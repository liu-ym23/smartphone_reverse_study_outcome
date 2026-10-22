# map_navigation — 地图与导航

> 来源 App：`com.stepos.notepaper`（笔记，端侧测试工具）
> ⚠️ 主要地图能力（`maps_*`）均为云侧工具

---

## 端侧工具

> ⚠️ **调用规则**：方法名必须来自本文档，通过 `ability.call` 调用。
> 禁止直接使用 `nodes action=location_get`（这是底层实现名，绕过 ability 层会导致结果格式不一致）。

### 1. 实时定位

```
ability.call method="get_current_location" params='{}'
```

- **能力描述**：获取设备当前的实时地理位置（城市 / 区域级）。
- **使用时机**：
  - 用户未明确提供位置（如：天气、导航、距离等场景）
  - 需要基于“当前位置”进行后续计算（如路线、打车、附近搜索），例如从我这里到某地需要多久、多远、怎么走、附近有什么等（涉及路线、距离、导航时优先获取当前位置再处理）。
- **注意事项**：
  - 所有“从我这里出发 / 我在哪 / 附近 / 到某地怎么走、要多久”等请求，必须优先调用该能力获取位置

---

## 云侧工具参考

以下工具由云侧（高德 API）提供，需通过 OpenClaw 网关调用：

```
ability.call method="maps_text_search" params='{"keywords":"<搜索关键词>"}'
```

关键词搜索 API，根据用户输入的关键词进行 POI 搜索，并返回相关信息。可选参数：`city`（查询城市）；`citylimit`（是否限制城市范围搜索）。

```
ability.call method="maps_around_search" params='{"keywords":"<搜索关键词>","location":"<坐标>"}'
```

周边搜索，根据关键词和坐标，搜索出指定半径范围内的 POI。可选参数：`radius`（搜索半径）；`strategy`（排序策略）。

```
ability.call method="maps_search_detail" params='{"id":"<POI ID>"}'
```

查询关键词搜索或周边搜索获取到的 POI ID 的详细信息。

```
ability.call method="maps_direction_driving" params='{"origin":"<起点坐标>","destination":"<终点坐标>"}'
```

驾车路径规划，根据起终点经纬度坐标规划驾车方案。

```
ability.call method="maps_direction_walking" params='{"origin":"<起点坐标>","destination":"<终点坐标>"}'
```

步行路径规划，规划 100km 以内的步行路线方案。

```
ability.call method="maps_direction_bicycling" params='{"origin":"<起点坐标>","destination":"<终点坐标>"}'
```

骑行路径规划，会考虑天桥、单行线、小路等情况，最大支持 500km。

```
ability.call method="maps_direction_transit_integrated" params='{"origin":"<起点坐标>","destination":"<终点坐标>"}'
```

综合公共交通路线规划，包含火车、公交、地铁等方式。跨城市场景必须传起点城市和终点城市。

```
ability.call method="maps_schema_navi" params='{"lon":"<终点经度>","lat":"<终点纬度>"}'
```

Schema 唤起客户端导航页面，根据终点经纬度返回拼装好的客户端唤起 URI。

```
ability.call method="maps_schema_take_taxi" params='{"dlat":"<终点纬度>","dlon":"<终点经度>","dname":"<终点名称>"}'
```

唤起高德地图进行打车，直接显示链接，不需要总结。可选参数：`slat`（起点纬度）；`slon`（起点经度）；`sname`（起点名称）。

```
ability.call method="maps_schema_personal_map" params='{"lineList":"<行程位置点列表>"}'
```

将行程规划结果在高德地图显示，返回高德地图打开的 URI 链接，该结果不需总结，直接返回。

```
ability.call method="maps_geo" params='{"address":"<详细地址>"}'
```

将详细的结构化地址或地标名称转换为高德经纬度坐标。

```
ability.call method="maps_regeocode" params='{"location":"<高德经纬度坐标>"}'
```

将高德经纬度坐标转换为行政区域和地址信息。

```
ability.call method="maps_ip_location" params='{"ip":"<IP地址>"}'
```

IP 定位，根据用户输入的 IP 地址定位 IP 所在位置。

```
ability.call method="maps_distance" params='{"origins":"<起点坐标>","destination":"<终点坐标>"}'
```

测量两个经纬度坐标之间的距离，支持驾车、步行以及球面距离测量。

```
ability.call method="maps_weather" params='{"city":"<城市名称或adcode>"}'
```

根据城市名称或高德 adcode 查询指定城市的天气。


```
ability.call method="weatherInfo" params='{"city":"<需要查询天气的城市名称>"}'
```

查询天气（高德API，通过城市名称查询）。

```
ability.call method="kesong_shoot_search" params='{"query":"<摄位搜索查询，如摄影行-\"海岸来信\"服务区>"}'
```

可拍摄位搜索。可选参数：`lat`（纬度）；`lng`（经度）；`city`（城市名称）；`poiName`（POI名称）。
