package com.volcengine.tos.model.object;

import com.volcengine.tos.TosException;
import com.volcengine.tos.comm.event.DownloadEventType;

/* loaded from: classes3.dex */
public class DownloadEvent {
    private String bucket;
    private String checkpointFile;
    private DownloadEventType downloadEventType;
    private DownloadPartInfo downloadPartInfo;
    private String filePath;
    private String key;
    private String tempFilePath;
    private TosException tosException;
    private String versionID;

    public String getBucket() {
        return this.bucket;
    }

    public String getCheckpointFile() {
        return this.checkpointFile;
    }

    public DownloadEventType getDownloadEventType() {
        return this.downloadEventType;
    }

    public DownloadPartInfo getDownloadPartInfo() {
        return this.downloadPartInfo;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getKey() {
        return this.key;
    }

    public String getTempFilePath() {
        return this.tempFilePath;
    }

    public TosException getTosException() {
        return this.tosException;
    }

    public String getVersionID() {
        return this.versionID;
    }

    public DownloadEvent setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public DownloadEvent setCheckpointFile(String str) {
        this.checkpointFile = str;
        return this;
    }

    public DownloadEvent setDownloadEventType(DownloadEventType downloadEventType) {
        this.downloadEventType = downloadEventType;
        return this;
    }

    public DownloadEvent setDownloadPartInfo(DownloadPartInfo downloadPartInfo) {
        this.downloadPartInfo = downloadPartInfo;
        return this;
    }

    public DownloadEvent setFilePath(String str) {
        this.filePath = str;
        return this;
    }

    public DownloadEvent setKey(String str) {
        this.key = str;
        return this;
    }

    public DownloadEvent setTempFilePath(String str) {
        this.tempFilePath = str;
        return this;
    }

    public DownloadEvent setTosException(TosException tosException) {
        this.tosException = tosException;
        return this;
    }

    public DownloadEvent setVersionID(String str) {
        this.versionID = str;
        return this;
    }

    public String toString() {
        return "DownloadEvent{type=" + this.downloadEventType + ", tosException=" + this.tosException + ", buckets='" + this.bucket + "', key='" + this.key + "', versionID='" + this.versionID + "', filePath='" + this.filePath + "', checkpointFile='" + this.checkpointFile + "', tempFilePath='" + this.tempFilePath + "', downloadPartInfo=" + this.downloadPartInfo + '}';
    }
}
