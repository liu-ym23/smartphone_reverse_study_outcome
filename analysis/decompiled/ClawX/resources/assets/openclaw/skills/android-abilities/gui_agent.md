# gui_agent

GUI Agent UI 自动化。在手机 APP 中执行多步屏幕交互操作。来源: com.stepos.common.ability.proxy

> 只要用户要求在第三方 App（淘宝、美团、小红书、抖音、微信等）中操作——无论是搜索、浏览、点赞、收藏还是下单——都使用此工具。task 中写清楚：搜什么、选哪个、做什么、不要做什么。

## Available Tools

### `gui_agent`
- **描述**: 在第三方 App 中执行任何需要屏幕交互的操作（搜索、浏览、点击、滑动、加购、收藏、下单、关注、评论等）。只要操作目标是第三方 App 就使用此工具，不限于"多步复杂操作"。
- **参数**:
  - `app_name` (string, Required): 目标 APP 名称，例如：美团、微信、淘宝、抖音、高德地图、小红书等
  - `task` (string, Required): 要执行的任务描述，使用自然语言详细说明 UI 操作目标与关键约束（如搜索关键词、筛选条件、收货地址、是否下单等）。如果上下文中包含地址、联系人等关键信息，必须写入 task 中

## ⚠️ 调用前必做：获取节点 ID

**禁止使用 `node="auto"`**，否则报 `"node required"` 错误。
调用前必须先通过 `nodes action="status"` 获取可用节点的完整 ID。

## 调用说明

gui_agent 属于耗时操作（多步 UI 可能需要 60–600 秒），**必须传 `invokeTimeoutMs=600000`**，不可使用默认 30s 超时。

## 调用示例

**完整调用模板：**
```
nodes action="invoke" node="<节点ID>" invokeCommand="ability.call" invokeTimeoutMs=600000 invokeParamsJson='{"method":"gui_agent","params":{"app_name":"<App中文名>","task":"<详细任务描述，含约束条件>"}}'
```

**小红书搜索穿搭：**
```
nodes action="invoke" node="<节点ID>" invokeCommand="ability.call" invokeTimeoutMs=600000 invokeParamsJson='{"method":"gui_agent","params":{"app_name":"小红书","task":"搜索穿搭，浏览前几条帖子，给高赞帖子点赞"}}'
```

**淘宝加购：**
```
nodes action="invoke" node="<节点ID>" invokeCommand="ability.call" invokeTimeoutMs=600000 invokeParamsJson='{"method":"gui_agent","params":{"app_name":"淘宝","task":"搜索手机壳，加购前三个结果到购物车，不要下单"}}'
```

**美团点外卖：**
```
nodes action="invoke" node="<节点ID>" invokeCommand="ability.call" invokeTimeoutMs=600000 invokeParamsJson='{"method":"gui_agent","params":{"app_name":"美团","task":"搜索附近奶茶店，选评分最高的，点一杯招牌奶茶加到购物车，不要下单"}}'
```

## 常见错误

| 错误 | 原因 | 解决 |
|------|------|------|
| `node required` | 用了 `node="auto"` 或没传 node | 先调 `nodes action="status"` 获取具体节点 ID |
| `gateway timeout after 30000ms` | 没传 invokeTimeoutMs | 必须设 `invokeTimeoutMs=600000` |
| `ABILITY_NOT_FOUND` | 方法名不存在 | 用 `ability.list` 检查可用方法 |
