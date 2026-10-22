---
name: android-filesystem
description: "Direct /sdcard filesystem access on the Android chroot container. Use for listing, reading, and searching files (ls, find, read_file). Do NOT use this skill to delete or restore /sdcard files via shell; deletion and restore must go through android-abilities dynamic ability.list + ability.call using file_safe_delete / file_restore."
---

# Android Filesystem Skill (FALLBACK)

## Runtime Environment

You are running inside a **chroot Ubuntu container on an Android device**. The Android device's external storage (`/sdcard`) is bind-mounted into the chroot environment, giving you **direct filesystem access** to the user's files.

This means you can use your standard file tools (`read_file`, `write_file`, `edit_file`) and bash commands (`ls`, `find`, `cat`, etc.) to access Android files for **browsing, reading, and searching** — no special API or handler is needed for basic file I/O.

For **deleting or restoring** files under `/sdcard`, this skill is **not** the final execution path. Deletion and restore must go through the `android-abilities` skill: call `nodes` / `ability.list` first, then call the returned `file_safe_delete` or `file_restore` method via `nodes` / `ability.call`.

## Path Mapping

Do not assume every phone uses the same subdirectory layout. Always verify with `ls` before naming a path to the user or trying to open a file.

| Candidate Android Path | chroot Path | Typical Content |
|---|---|---|
| `/sdcard/DCIM/` | `/sdcard/DCIM/` | Camera and media-related directories, often including `Camera/` |
| `/sdcard/Pictures/` | `/sdcard/Pictures/` | Saved images from apps, screenshots on some ROMs |
| `/sdcard/Download/` | `/sdcard/Download/` | Downloaded files, app exports on some devices |
| `/sdcard/Documents/` | `/sdcard/Documents/` | Documents |
| `/sdcard/Movies/` | `/sdcard/Movies/` | Videos and screen recordings on some ROMs |
| `/sdcard/Music/` | `/sdcard/Music/` | Audio files |
| `/sdcard/Android/data/` | `/sdcard/Android/data/` | Third-party app data (limited access) |

> **Note:** `/sdcard` is also accessible as `/storage/emulated/0`. Both paths are equivalent.
>
> **Examples of variation:** screenshots may be under `/sdcard/Pictures/Screenshots/` instead of `/sdcard/DCIM/Screenshots/`; screen recordings may be directly under `/sdcard/Movies/` or inside `/sdcard/Movies/Screenrecords/`.

## File Operations Guide

### Listing files

```bash
# Start from the parent directory and inspect actual subfolders
ls -la /sdcard/DCIM/

# Then inspect the likely camera folder if it exists
ls -la /sdcard/DCIM/Camera/

# List recent downloads
ls -lt /sdcard/Download/ | head -20

# Find all images recursively
find /sdcard/DCIM/ -type f \( -name "*.jpg" -o -name "*.png" -o -name "*.jpeg" \) | head -50
```

### Reading files

Use the `read_file` tool with the full `/sdcard/...` path, or `cat` for text files:

```bash
cat /sdcard/Documents/notes.txt
```

### Searching for files

```bash
# Search by name pattern
find /sdcard/ -name "*.pdf" -type f 2>/dev/null | head -20

# Search by date (modified in last 7 days)
find /sdcard/DCIM/ -type f -mtime -7 2>/dev/null

# Search by size (files larger than 10MB)
find /sdcard/ -type f -size +10M 2>/dev/null | head -20
```

### Deleting files

Do **not** delete `/sdcard` files with shell commands such as:

```bash
rm /sdcard/Download/a.pdf
find /sdcard/Download/ -type f -name "*.pdf" -delete
find /sdcard/Download/ -type f -name "*.pdf" -exec rm {} \;
```

Required flow for `/sdcard` deletion:

1. Use `ls` / `find` only to enumerate candidate files.
2. Review or summarize the matches if needed.
3. Call `nodes` with `invokeCommand="ability.list"` and query `"安全删除文件到回收站"`.
4. Copy the returned `method=file_safe_delete` exactly, then call `nodes` with `invokeCommand="ability.call"` and `invokeParamsJson='{"method":"file_safe_delete","params":{"path":"<original path>"}}'`.

This keeps Android file deletion on the recoverable CommonAbility trash path instead of doing irreversible shell deletion.

### Restoring files

Do **not** invent method names such as `trash_restore_run`, `trash_restore_search`, `trash_restore`, or `fs.restore`.

Required flow for `/sdcard` restore:

1. Use the original path from before deletion.
2. Call `nodes` with `invokeCommand="ability.list"` and query `"从回收站按原始路径恢复文件"`.
3. Copy the returned `method=file_restore` exactly, then call `nodes` with `invokeCommand="ability.call"` and `invokeParamsJson='{"method":"file_restore","params":{"path":"<original path>"}}'`.

### Getting directory overview

```bash
# Quick summary of a directory
du -sh /sdcard/DCIM/
ls /sdcard/DCIM/ | wc -l
```

## Image Handling

When the user asks you to look at, analyze, or describe an image:

1. First inspect the parent directory to confirm where the files really are
2. Use the `read_file` tool with the image's full path — the model's vision capability will process it
3. Describe what you see in the image

Example: after verifying the real location, use `read_file` with the full path such as `/sdcard/DCIM/Camera/IMG_20260312_143022.jpg`.

## Important Notes

- Always verify paths exist before assuming — use `ls` to check first
- The `/sdcard` mount is shared storage; treat user files with care
- `find` is allowed for search only; do not add `-delete` and do not pair it with `-exec rm`
- For `/sdcard` deletions/restores, stop using shell and switch to `nodes` / `ability.list` then `nodes` / `ability.call` with `file_safe_delete` or `file_restore`
- For large directories, use `head` or `| head -N` to limit output
- File permissions follow Android's external storage model — most files under `/sdcard` are readable
- When the user says "相册" (album), start with `/sdcard/DCIM/` and `/sdcard/Pictures/`, then inspect the real child directories
- When the user says "截图" (screenshots), check both `/sdcard/Pictures/` and `/sdcard/DCIM/` before concluding
- When the user says "录屏" (screen recordings), check `/sdcard/Movies/` and its child directories before concluding
- When the user says "下载" (downloads), check `/sdcard/Download/`, but remember some apps export into app-specific folders
