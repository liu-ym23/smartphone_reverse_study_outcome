package com.volcengine.tos.model.object;

import java.io.InputStream;

@Deprecated
/* loaded from: classes3.dex */
public class UploadPartInput {
    private InputStream content;
    private String key;
    private int partNumber;
    private long partSize;
    private String uploadID;

    public UploadPartInput() {
    }

    public InputStream getContent() {
        return this.content;
    }

    public String getKey() {
        return this.key;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public long getPartSize() {
        return this.partSize;
    }

    public String getUploadID() {
        return this.uploadID;
    }

    public UploadPartInput setContent(InputStream inputStream) {
        this.content = inputStream;
        return this;
    }

    public UploadPartInput setKey(String str) {
        this.key = str;
        return this;
    }

    public UploadPartInput setPartNumber(int i) {
        this.partNumber = i;
        return this;
    }

    public UploadPartInput setPartSize(long j5) {
        this.partSize = j5;
        return this;
    }

    public UploadPartInput setUploadID(String str) {
        this.uploadID = str;
        return this;
    }

    public String toString() {
        return "UploadPartInput{key='" + this.key + "', uploadID='" + this.uploadID + "', partSize=" + this.partSize + ", partNumber=" + this.partNumber + ", content=" + this.content + '}';
    }

    public UploadPartInput(String str, String str2, long j5, int i, InputStream inputStream) {
        this.key = str;
        this.uploadID = str2;
        this.partSize = j5;
        this.partNumber = i;
        this.content = inputStream;
    }
}
