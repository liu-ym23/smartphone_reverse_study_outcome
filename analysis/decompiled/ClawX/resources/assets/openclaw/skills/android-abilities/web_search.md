# web_search — 网络搜索与网页

> ⚠️ 全部工具为云侧工具（OpenClaw）

---

## 云侧工具参考

```
ability.call method="web_search" params='{"query":"<搜索关键词>"}'
```

关键词网页搜索。

```
ability.call method="web_fetch" params='{"url":"<目标网页URL>"}'
```

抓取指定 URL 的网页内容。

```
ability.call method="bing_search" params='{"query":"<搜索关键词>"}'
```

Bing 搜索引擎关键词搜索。

```
ability.call method="stepsearch-public" params='{"query":"<搜索问题>"}'
```

步骤式深度搜索（多步推理搜索）。

```
ability.call method="fetch_trending_news" params='{}'
```

获取百度、头条热榜资讯。可选参数：`topk`（每个数据源返回的结果数，默认10）。

```
ability.call method="diandian_share_fetch" params='{"url":"<点点的分享链接>"}'
```

获取点点分享链接对应的内容数据。点点是安装在手机内的社交分享 App，该工具用于解析点点分享链接并返回其内容。
