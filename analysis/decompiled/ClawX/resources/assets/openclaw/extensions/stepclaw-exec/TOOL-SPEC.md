# 端侧文件系统操作工具集（实现与文档对齐说明）

实现依据：`端侧文件系统操作工具集` Word 文档。调用方式：

```bash
openclaw nodes invoke --node "<nodeId>" --command "stepclaw.exec" --params '<JSON>'
```

JSON 顶层字段包含 `tool` 及各工具参数（亦可嵌套一层 `params`，插件会合并）。

## 通用约定

- **编码**：文本默认 UTF-8；`read` / `write` 可设 `encoding: "base64"` 传二进制。
- **read**：默认最多 2 MB 文本或 2000 行；超限返回 `E_TOO_LARGE` 并带 `size`。
- **write**：内联内容上限 8 MB；更大文件请用 **push**。
- **错误**：`toolFail` 返回 `error.code`、`error.message`，并带 `exitCode: 1`、`stderr`（与文档结构一致）。

## workspace URI（pull / push）

- `workspace:/相对路径` 或 `workspace:相对路径` 映射到 Gateway 进程内  
  **`/root/.openclaw/workspace/`**（与 Openclaw 工作区一致）。
- 设备侧路径：绝对路径或经 `path.resolve` 解析后的路径。

## 工具一览

### ls

| 参数 | 类型 | 必填 | 默认 | 说明 |
|------|------|------|------|------|
| paths | string[] | 是 | — | 位置参数 FILE... |
| all | boolean | 否 | false | `-a` |
| almost_all | boolean | 否 | false | `-A` |
| long | boolean | 否 | **true** | `-l`；为 false 时仅返回 path/name/type |
| human_readable | boolean | 否 | false | `-h`；为 true 时在条目中增加 `size_human` |
| recursive | boolean | 否 | false | `-R` |
| sort | string | 否 | name | `name` \| `mtime` \| `size` \| `none` |

### stat

| 参数 | 类型 | 必填 | 默认 |
|------|------|------|------|
| file | string | 是 | — |
| dereference | boolean | 否 | true |
| file_system | boolean | 否 | false |

`file_system: true` 时使用 `fs.statfsSync`（需 Node 支持）返回 `file_system` 对象（块大小、可用块等），不返回 inode 级字段。

### find

与文档一致：`paths`, `name`, `iname`, `path`, `type` (f|d|l), `maxdepth`, `mindepth`, `size`, `mtime`, `mmin`, `newer`；结果最多 1000 条，`truncated` 标明截断。

### mkdir / rm / mv / cp

参数名与文档表格一致（如 `paths`, `src`, `dst`, `recursive`, `force`, `no_clobber`, `preserve` 等）。

### read / write / edit

与文档一致：`file_path`, `content`, `encoding`, `offset`, `limit`, `old_string`, `new_string`, `replace_all`。

### pull（设备 → Openclaw 工作区）

在 Gateway 内执行 **设备路径 → 工作区目录** 的复制（等价于在用户空间把文件收到 `workspace:` 指向的区域）。

| 参数 | 类型 | 必填 |
|------|------|------|
| src | string[] | 是 |
| dst | string | 是（`workspace:...`） |
| recursive | boolean | 否，默认 false |
| preserve | boolean | 否，默认 false |
| no_clobber | boolean | 否，默认 false |
| expected_sha256 | string | 否 |

`src` 支持 basename 中含 `*`、`?` 的简通配（与文档「支持通配符」对齐）；`[abc]` 类通配为有限实现。

返回：`result.transferred[]` — `src`, `dst`, `size`, `sha256`, `duration_ms`；其中 `dst` 为 **`workspace:/...` 展示形式**。

### push（Openclaw 工作区 → 设备）

| 参数 | 类型 | 必填 |
|------|------|------|
| src | string[] | 是（`workspace:...`） |
| dst | string | 是（设备路径） |
| recursive | boolean | 否 |
| preserve | boolean | 否 |
| no_clobber | boolean | 否 |
| make_parents | boolean | 否，默认 true |
| expected_sha256 | string | 否 |

返回：`result.transferred[]` — `src`, `dst`, `size`, `sha256`, `duration_ms`。

---

**大文件说明**：单次 `read`/`write` 仍受 2MB/8MB 限制；大于此限制的整块传输应在**云侧**拆片后多次 `push`（或改用对象存储等链路透传，不在本文档工具范围内）。
