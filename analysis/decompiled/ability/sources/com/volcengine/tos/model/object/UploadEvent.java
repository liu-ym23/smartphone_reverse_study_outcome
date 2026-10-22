package com.volcengine.tos.model.object;

import com.volcengine.tos.TosException;
import com.volcengine.tos.comm.event.UploadEventType;

/* loaded from: classes3.dex */
public class UploadEvent {
    private String bucket;
    private String checkpointFile;
    private String filePath;
    private String key;
    private TosException tosException;
    private UploadEventType uploadEventType;
    private String uploadID;
    private UploadPartInfo uploadPartInfo;

    public String getBucket() {
        return this.bucket;
    }

    public String getCheckpointFile() {
        return this.checkpointFile;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getKey() {
        return this.key;
    }

    public TosException getTosException() {
        return this.tosException;
    }

    public UploadEventType getUploadEventType() {
        return this.uploadEventType;
    }

    public String getUploadID() {
        return this.uploadID;
    }

    public UploadPartInfo getUploadPartInfo() {
        return this.uploadPartInfo;
    }

    public UploadEvent setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public UploadEvent setCheckpointFile(String str) {
        this.checkpointFile = str;
        return this;
    }

    public UploadEvent setFilePath(String str) {
        this.filePath = str;
        return this;
    }

    public UploadEvent setKey(String str) {
        this.key = str;
        return this;
    }

    public UploadEvent setTosException(TosException tosException) {
        this.tosException = tosException;
        return this;
    }

    public UploadEvent setUploadEventType(UploadEventType uploadEventType) {
        this.uploadEventType = uploadEventType;
        return this;
    }

    public UploadEvent setUploadID(String str) {
        this.uploadID = str;
        return this;
    }

    public UploadEvent setUploadPartInfo(UploadPartInfo uploadPartInfo) {
        this.uploadPartInfo = uploadPartInfo;
        return this;
    }

    public String toString() {
        return "UploadEvent{uploadEventType=" + this.uploadEventType + ", tosException=" + this.tosException + ", buckets='" + this.bucket + "', key='" + this.key + "', uploadID='" + this.uploadID + "', filePath='" + this.filePath + "', checkpointFile='" + this.checkpointFile + "', uploadPartInfo=" + this.uploadPartInfo + '}';
    }
}
