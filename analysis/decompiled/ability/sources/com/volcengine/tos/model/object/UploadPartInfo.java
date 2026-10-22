package com.volcengine.tos.model.object;

import androidx.appfunctions.metadata.a;

/* loaded from: classes3.dex */
public class UploadPartInfo {
    private String etag;
    private long hashCrc64ecma;
    private boolean isCompleted;
    private long offset;
    private int partNumber;
    private long partSize;

    public String getEtag() {
        return this.etag;
    }

    public long getHashCrc64ecma() {
        return this.hashCrc64ecma;
    }

    public long getOffset() {
        return this.offset;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public long getPartSize() {
        return this.partSize;
    }

    public boolean isCompleted() {
        return this.isCompleted;
    }

    public UploadPartInfo setCompleted(boolean z10) {
        this.isCompleted = z10;
        return this;
    }

    public UploadPartInfo setEtag(String str) {
        this.etag = str;
        return this;
    }

    public UploadPartInfo setHashCrc64ecma(long j5) {
        this.hashCrc64ecma = j5;
        return this;
    }

    public UploadPartInfo setOffset(long j5) {
        this.offset = j5;
        return this;
    }

    public UploadPartInfo setPartNumber(int i) {
        this.partNumber = i;
        return this;
    }

    public UploadPartInfo setPartSize(long j5) {
        this.partSize = j5;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UploadPartInfo{partNumber=");
        sb.append(this.partNumber);
        sb.append(", partSize=");
        sb.append(this.partSize);
        sb.append(", offset=");
        sb.append(this.offset);
        sb.append(", etag='");
        sb.append(this.etag);
        sb.append("', hashCrc64ecma='");
        sb.append(this.hashCrc64ecma);
        sb.append("', isCompleted=");
        return a.r(sb, this.isCompleted, '}');
    }
}
