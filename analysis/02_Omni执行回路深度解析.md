# Omni（手机任务）执行回路深度解析

> 依据：aiagent 插件反编译（autogui/agents/vlm、operator、platforms/tools）+ 实测。2026-10-15。

## 一、网络层

| 端点 | 用途 |
|---|---|
| `https://ofa.obriccloud.com/auto_action/api/task/inference` | **SSE 推理主通道**（POST text/event-stream + JSON body；连接 15s/读 50s 超时+看门狗） |
| `auto_action/api/task/state` | 任务创建/状态查询（响应含 hard_blacklist/soft_blacklist/model_name/queue_num） |
| `auto_action/api/app/info/upload` | app 信息上报 |
| `auto_action/api/task/share` | 任务分享 |
| 模拟器 OS 时切 `ofa.bytedance.net` | |
| 聊天侧：`ws-samantha.doubao.com`（WS）、`api-normal.doubao.com/assistant/*`（HTTP） | 对话模型通道（Samantha） |
| `wss://audio.doubao.com` / `frontier-audio-ws.doubao.com` | SAMI 语音流 |

## 二、GUI_Action 指令格式（服务端→端侧）
```json
GUIActionParams {
  uniqueId: string,
  step:  { "action_type": "<类型>", "action_args": [ ... ] },
  ext:   { "query", "tool_id", "tool_name", "o_omni_instruction_type",
           "caller_source", "allow_user_interaction", "start_in_place",
           "o_omni_task_id", "prev_step_status", "is_gui_idle",
           "o_omni_gui_keep_bitmap" }
}
```
执行前置校验（parseAndValidate）：uniqueId 必填；tool_id 必填（否则丢弃）；task_id/instruction_id 回退链。

## 三、步骤类型（服务器下发的类型化 Step）
| Step 类 | 语义 |
|---|---|
| StandardModelActionedStep | 执行动作（含服务端耗时 y()：inference/server 时间） |
| StandardModelScriptStep | 执行本地脚本（scripted 流程） |
| BDUITarsModel / PreExecScreenEvidenceCache | UI-Tars 模型适配 / 步前截图证据缓存（辅助组件，非 Step） |
| **StandardModelCallUserStep** | **执行中问用户**：content（问题）+action_for_user，经 CallUserFunctionParams 阻塞等待用户回答；`h()=!isChatPageInVD()` 时为阻塞步 |
| StandardModelAdjustCallUserStep | 调整后的问用户 |
| StandardModelClarifyStep | 澄清（如黑名单 CLARIFY） |
| StandardModelEndStep | 结束（finish_reason 等） |
| StandardModelSetTimerTaskStep | 设置定时任务 |
| StandardModelUnknowStep | 未知步骤（容错） |
| StandardModelUnsolicitedAppListCheckingStep / ...BlackListHandlingStep | 主动 app 列表校验/黑名单处理 |

## 四、每步执行器（e/b/e：StepExecutor）
组装：scriptSource + operationPlanner + operationExecutor + **securityPolicy**（逐步黑名单/敏感检查）+ **loopGuard**（同能力重复 5 告警/10 阻断）+ performanceReporter + failureRecorder。
动作算子（AOStep.kt）：doOpen/openByName（开 app）、performScroll/executeFrameworkScroll（滚动）、performScreenshotOperation、maybeKillApp、isInWhiteScreen、**checkPixelsChanged/checkChangedBetweenSteps（步效像素级校验）**、adjustedSwipeRange。

## 五、感知实现
1. **截图**（ReflectedScreenCapture.kt，反射隐藏 API）：
   - `IWindowManager.captureDisplay(displayId, CaptureArgs, listener)`（按 display 抓，即 GPU 合成缓冲直读）；
   - CaptureArgs：setSourceCrop、setFrameScale、**HEIF 硬件编码输出**（width/height/qp/downscalePreference）、**setExcludeLayers**（可把悬浮球等图层从截图剔除）、early buffer listener；
   - 结果 ScreenCaptureListener→HardwareBuffer→asBitmap→ARGB_8888；
   - `containsSecureLayers()` → ContainsSecure（FLAG_SECURE 页面检测，拒绝继续）；
   - 备选 `windowManager().takeSurfaceControlScreenshot`。
2. **ViewTree**：CC 会话 `dumpViewHierarchy` → AssistStructure → 解析为 ViewHierarchyDump 列表（含 react_view_tree 注册，输入事件与视图树关联）。
3. 上行：截图+ViewTree+ReactViewTree → `uploadOmniScreenshot` / `uploadOmniDataFeedback`（/assistant/func_call/*）。

## 六、动作注入实现
- StandardMotionEventInjector：MotionEvent.obtain（含 pressure/pointer/downTime 仿真）→ 解析目标 displayId（activeSpace）→ 反射 `InputManager.injectInputEvent(event, 0)`（async 模式）；
- injectSeq 全链路追踪 + InjectEventContext 注册；
- ScreenTap/ScreenSwipe(V3)：注入序列 down→move(贝塞尔/stabilize)→up，v3 带尾部校验；
- KeyCodeSender：按键；
- 本机走 INJECT_EVENTS 特权权限；ComputerControl API 是跨设备适配层。

## 七、状态机（session/state）
IDLE→QUEUEING（**checkPrompt 本地敏感检查**）→PREPARING→OPERATING（逐步 planner→security→inject→verify）→(PAUSED / USER_INTERRUPTED)→TERMINATED（task_end 审计：check_user_input_audit_info + check_llm_output_audit_info）。

## 八、实测对照
- displayId 91/92/93 均为 auto_action 虚拟屏实例（每任务新建或复用）；
- 邮件草稿任务：收件人/主题逐字段填写（action_args 细粒度操作）；
- 微博热搜：冷启动→导航→读取，全程无人工；
- 锁屏（无安全锁）：直接执行（isDeviceLocked=false 短路认证）。
