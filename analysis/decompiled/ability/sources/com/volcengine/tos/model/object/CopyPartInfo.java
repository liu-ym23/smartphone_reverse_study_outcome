package com.volcengine.tos.model.object;

import androidx.appfunctions.metadata.a;

/* loaded from: classes3.dex */
public class CopyPartInfo {
    private long copySourceRangeEnd;
    private long copySourceRangeStart;
    private String etag;
    private boolean isCompleted;
    private int partNumber;

    public long getCopySourceRangeEnd() {
        return this.copySourceRangeEnd;
    }

    public long getCopySourceRangeStart() {
        return this.copySourceRangeStart;
    }

    public String getEtag() {
        return this.etag;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public boolean isCompleted() {
        return this.isCompleted;
    }

    public CopyPartInfo setCompleted(boolean z10) {
        this.isCompleted = z10;
        return this;
    }

    public CopyPartInfo setCopySourceRangeEnd(long j5) {
        this.copySourceRangeEnd = j5;
        return this;
    }

    public CopyPartInfo setCopySourceRangeStart(long j5) {
        this.copySourceRangeStart = j5;
        return this;
    }

    public CopyPartInfo setEtag(String str) {
        this.etag = str;
        return this;
    }

    public CopyPartInfo setPartNumber(int i) {
        this.partNumber = i;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CopyPartInfo{partNumber=");
        sb.append(this.partNumber);
        sb.append(", copySourceRangeStart=");
        sb.append(this.copySourceRangeStart);
        sb.append(", copySourceRangeEnd=");
        sb.append(this.copySourceRangeEnd);
        sb.append(", etag='");
        sb.append(this.etag);
        sb.append("', isCompleted=");
        return a.r(sb, this.isCompleted, '}');
    }
}
