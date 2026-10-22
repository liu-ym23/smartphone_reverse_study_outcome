package com.stepos.pps.logpull;

import android.content.Context;
import com.stepos.pps.logpull.LogPullTaskList;
import com.stepos.pps.logpull.LogPullUploader;

/* loaded from: classes.dex */
public class LogPullTaskStore {
    public static final String PHASE_COLLECTING = "collecting";
    public static final String PHASE_IDLE = "idle";
    public static final String PHASE_UPLOAD = "upload";
    private final LogPullTaskList list;

    public static class PendingTask {
        public long configId;
        public String deadlineTime;
        public String fileName;
        public boolean fulldump;
        public String oaid;
        public String phase;
        public long sizeBytes;
        public String zipPath;
    }

    public LogPullTaskStore(Context context) {
        this.list = new LogPullTaskList(context);
    }

    public void save(PendingTask pendingTask) {
        if (pendingTask == null || pendingTask.configId <= 0) {
            return;
        }
        LogPullTaskList.Entry entry = this.list.get(pendingTask.configId);
        if (entry == null) {
            entry = new LogPullTaskList.Entry();
            entry.configId = pendingTask.configId;
        }
        entry.oaid = pendingTask.oaid;
        entry.phase = pendingTask.phase;
        entry.zipPath = pendingTask.zipPath != null ? pendingTask.zipPath : "";
        entry.sizeBytes = pendingTask.sizeBytes;
        entry.deadlineTime = pendingTask.deadlineTime;
        entry.fileName = pendingTask.fileName;
        entry.fulldump = pendingTask.fulldump;
        this.list.put(entry);
    }

    public void updatePhase(String str) {
        LogPullTaskList.Entry entryActiveTask = this.list.activeTask();
        if (entryActiveTask == null) {
            return;
        }
        entryActiveTask.phase = str;
        this.list.put(entryActiveTask);
    }

    public PendingTask load() {
        LogPullTaskList.Entry entryActiveTask = this.list.activeTask();
        if (entryActiveTask == null || entryActiveTask.configId <= 0 || entryActiveTask.phase == null) {
            return null;
        }
        if (!"collecting".equals(entryActiveTask.phase) && (entryActiveTask.zipPath == null || entryActiveTask.zipPath.isEmpty())) {
            return null;
        }
        PendingTask pendingTask = new PendingTask();
        pendingTask.configId = entryActiveTask.configId;
        pendingTask.oaid = entryActiveTask.oaid;
        pendingTask.zipPath = entryActiveTask.zipPath;
        pendingTask.sizeBytes = entryActiveTask.sizeBytes;
        pendingTask.deadlineTime = entryActiveTask.deadlineTime;
        pendingTask.fileName = entryActiveTask.fileName;
        pendingTask.phase = entryActiveTask.phase;
        pendingTask.fulldump = entryActiveTask.fulldump;
        return pendingTask;
    }

    public void clear() {
        LogPullTaskList.Entry entryActiveTask = this.list.activeTask();
        if (entryActiveTask != null) {
            this.list.remove(entryActiveTask.configId);
        }
    }

    public void saveUpload(LogPullUploader.UploadState uploadState) {
        if (uploadState == null || uploadState.configId <= 0) {
            return;
        }
        LogPullTaskList.Entry entry = this.list.get(uploadState.configId);
        if (entry == null) {
            entry = new LogPullTaskList.Entry();
            entry.configId = uploadState.configId;
            entry.phase = "upload";
        }
        entry.oaid = uploadState.oaid;
        entry.uploadUrl = uploadState.uploadUrl;
        entry.objectKey = uploadState.objectKey;
        entry.expireAt = uploadState.expireAt;
        entry.totalSize = uploadState.totalSize;
        entry.uploadedBytes = uploadState.uploadedBytes;
        entry.filePath = uploadState.filePath;
        entry.lastActiveTime = uploadState.lastActiveTime;
        entry.uploadType = uploadState.uploadType;
        entry.uploadId = uploadState.uploadId;
        entry.partSize = uploadState.partSize;
        entry.completedParts.clear();
        entry.completedParts.putAll(uploadState.completedParts);
        this.list.put(entry);
    }

    public LogPullUploader.UploadState loadUpload() {
        LogPullTaskList.Entry entryActiveTask = this.list.activeTask();
        if (entryActiveTask == null || !entryActiveTask.hasUploadState()) {
            return null;
        }
        LogPullUploader.UploadState uploadState = new LogPullUploader.UploadState();
        uploadState.configId = entryActiveTask.configId;
        uploadState.oaid = entryActiveTask.oaid;
        uploadState.uploadUrl = entryActiveTask.uploadUrl;
        uploadState.objectKey = entryActiveTask.objectKey;
        uploadState.expireAt = entryActiveTask.expireAt;
        uploadState.totalSize = entryActiveTask.totalSize;
        uploadState.uploadedBytes = entryActiveTask.uploadedBytes;
        uploadState.filePath = entryActiveTask.filePath;
        uploadState.lastActiveTime = entryActiveTask.lastActiveTime;
        uploadState.uploadType = entryActiveTask.uploadType != null ? entryActiveTask.uploadType : LogPullStatusReporter.UPLOAD_TYPE_NORMAL;
        uploadState.uploadId = entryActiveTask.uploadId;
        uploadState.partSize = entryActiveTask.partSize;
        uploadState.completedParts.putAll(entryActiveTask.completedParts);
        return uploadState;
    }

    public void clearUpload() {
        LogPullTaskList.Entry entryActiveTask = this.list.activeTask();
        if (entryActiveTask == null) {
            return;
        }
        entryActiveTask.uploadUrl = null;
        entryActiveTask.objectKey = null;
        entryActiveTask.expireAt = 0L;
        entryActiveTask.totalSize = 0L;
        entryActiveTask.uploadedBytes = 0L;
        entryActiveTask.filePath = null;
        entryActiveTask.lastActiveTime = 0L;
        entryActiveTask.uploadType = LogPullStatusReporter.UPLOAD_TYPE_NORMAL;
        entryActiveTask.uploadId = null;
        entryActiveTask.partSize = 0L;
        entryActiveTask.completedParts.clear();
        this.list.put(entryActiveTask);
    }

    public static PendingTask newCollecting(LogPullConfig logPullConfig, String str) {
        PendingTask pendingTask = new PendingTask();
        pendingTask.configId = logPullConfig.configId;
        pendingTask.oaid = str;
        pendingTask.zipPath = "";
        pendingTask.sizeBytes = 0L;
        pendingTask.deadlineTime = logPullConfig.deadlineTime;
        pendingTask.fileName = null;
        pendingTask.phase = "collecting";
        if (logPullConfig.logTypes != null) {
            for (String str2 : logPullConfig.logTypes) {
                if ("fulldump".equals(str2)) {
                    pendingTask.fulldump = true;
                    return pendingTask;
                }
            }
        }
        return pendingTask;
    }
}
