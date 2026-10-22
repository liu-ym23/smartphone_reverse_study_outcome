package com.volcengine.tos.model.object;

import com.volcengine.tos.TosException;
import com.volcengine.tos.comm.event.CopyEventType;

/* loaded from: classes3.dex */
public class CopyEvent {
    private String bucket;
    private String checkpointFile;
    private CopyPartInfo copyPartInfo;
    private TosException exception;
    private String key;
    private String srcBucket;
    private String srcKey;
    private String srcVersionID;
    private CopyEventType type;
    private String uploadID;

    public String getBucket() {
        return this.bucket;
    }

    public String getCheckpointFile() {
        return this.checkpointFile;
    }

    public CopyPartInfo getCopyPartInfo() {
        return this.copyPartInfo;
    }

    public TosException getException() {
        return this.exception;
    }

    public String getKey() {
        return this.key;
    }

    public String getSrcBucket() {
        return this.srcBucket;
    }

    public String getSrcKey() {
        return this.srcKey;
    }

    public String getSrcVersionID() {
        return this.srcVersionID;
    }

    public CopyEventType getType() {
        return this.type;
    }

    public String getUploadID() {
        return this.uploadID;
    }

    public CopyEvent setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public CopyEvent setCheckpointFile(String str) {
        this.checkpointFile = str;
        return this;
    }

    public CopyEvent setCopyPartInfo(CopyPartInfo copyPartInfo) {
        this.copyPartInfo = copyPartInfo;
        return this;
    }

    public CopyEvent setException(TosException tosException) {
        this.exception = tosException;
        return this;
    }

    public CopyEvent setKey(String str) {
        this.key = str;
        return this;
    }

    public CopyEvent setSrcBucket(String str) {
        this.srcBucket = str;
        return this;
    }

    public CopyEvent setSrcKey(String str) {
        this.srcKey = str;
        return this;
    }

    public CopyEvent setSrcVersionID(String str) {
        this.srcVersionID = str;
        return this;
    }

    public CopyEvent setType(CopyEventType copyEventType) {
        this.type = copyEventType;
        return this;
    }

    public CopyEvent setUploadID(String str) {
        this.uploadID = str;
        return this;
    }

    public String toString() {
        return "CopyEvent{type=" + this.type + ", exception=" + this.exception + ", bucket='" + this.bucket + "', key='" + this.key + "', uploadID='" + this.uploadID + "', srcBucket='" + this.srcBucket + "', srcKey='" + this.srcKey + "', srcVersionID='" + this.srcVersionID + "', checkpointFile='" + this.checkpointFile + "', copyPartInfo=" + this.copyPartInfo + '}';
    }
}
