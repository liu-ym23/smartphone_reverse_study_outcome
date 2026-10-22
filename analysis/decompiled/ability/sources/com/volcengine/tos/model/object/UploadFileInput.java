package com.volcengine.tos.model.object;

import B7.a;

@Deprecated
/* loaded from: classes3.dex */
public class UploadFileInput {
    private String checkpointFile;
    private boolean enableCheckpoint;
    private String objectKey;
    private long partSize;
    private int taskNum;
    private String uploadFilePath;

    public String getCheckpointFile() {
        return this.checkpointFile;
    }

    public String getObjectKey() {
        return this.objectKey;
    }

    public long getPartSize() {
        return this.partSize;
    }

    public int getTaskNum() {
        return this.taskNum;
    }

    public String getUploadFilePath() {
        return this.uploadFilePath;
    }

    public boolean isEnableCheckpoint() {
        return this.enableCheckpoint;
    }

    public UploadFileInput setCheckpointFile(String str) {
        this.checkpointFile = str;
        return this;
    }

    public UploadFileInput setEnableCheckpoint(boolean z10) {
        this.enableCheckpoint = z10;
        return this;
    }

    public UploadFileInput setObjectKey(String str) {
        this.objectKey = str;
        return this;
    }

    public UploadFileInput setPartSize(long j5) {
        this.partSize = j5;
        return this;
    }

    public UploadFileInput setTaskNum(int i) {
        this.taskNum = i;
        return this;
    }

    public UploadFileInput setUploadFilePath(String str) {
        this.uploadFilePath = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UploadFileInput{objectKey='");
        sb.append(this.objectKey);
        sb.append("', uploadFilePath='");
        sb.append(this.uploadFilePath);
        sb.append("', partSize=");
        sb.append(this.partSize);
        sb.append(", taskNum=");
        sb.append(this.taskNum);
        sb.append(", enableCheckpoint=");
        sb.append(this.enableCheckpoint);
        sb.append(", checkpointFile='");
        return a.q(sb, this.checkpointFile, "'}");
    }
}
