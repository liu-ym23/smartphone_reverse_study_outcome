# STEPX手机逆向分析

## 1 整体机制

*以一条消息的处理为核心，串起来整个流程。*

- 用户在前端UI界面发送提示词；
- **异步审核**：针对用户本轮提示词的内容审核函数异步运行，其中审核者是云端HTTP服务，并且结果仅在后续使用云端服务时才有用；
- **SLA竞速**：先判断一系列条件（见 `HUMAN_APPENDIX.md A.1` ），随即启动1000ms竞速计时器开始端侧竞速。竞速计时器超时直接进入任务上云端，正常流程：
    - 用户提示词进入端侧小模型；
        ```
        SlaRouter通过StepOS的DeepBinder框架（StepOS自研的binder注入框架，服务端是com.stepos.aiengine/.deepbinder.AIEngineDeepBinderProvider）调到AIEngine进程。
        跑在AIEngine里的是端侧小模型（llama/MNN/QNN后端之一）。
        ```
    - 端侧小模型按照行式文法输出 `<func>\n(<key>:<value>\n)*` ；
    - 模型输出中选择的函数过几轮输出判定（见 `HUMAN_APPENDIX.md A.2` ）决定是否放到云端；
    - 如果不上云端，则模型输出中选择的函数过台账判定（见 `HUMAN_APPENDIX.md A.3` ），如果没通过则询问用户；
    - 执行端侧模型的决定。
- **云端
