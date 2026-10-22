package com.volcengine.tos.model.object;

import androidx.constraintlayout.core.dsl.a;

/* loaded from: classes3.dex */
public class DownloadPartInfo {
    private long hashCrc64ecma;
    private boolean isCompleted;
    private int partNumber;
    private long rangeEnd;
    private long rangeStart;

    public long getHashCrc64ecma() {
        return this.hashCrc64ecma;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public long getRangeEnd() {
        return this.rangeEnd;
    }

    public long getRangeStart() {
        return this.rangeStart;
    }

    public boolean isCompleted() {
        return this.isCompleted;
    }

    public DownloadPartInfo setCompleted(boolean z10) {
        this.isCompleted = z10;
        return this;
    }

    public DownloadPartInfo setHashCrc64ecma(long j5) {
        this.hashCrc64ecma = j5;
        return this;
    }

    public DownloadPartInfo setPartNumber(int i) {
        this.partNumber = i;
        return this;
    }

    public DownloadPartInfo setRangeEnd(long j5) {
        this.rangeEnd = j5;
        return this;
    }

    public DownloadPartInfo setRangeStart(long j5) {
        this.rangeStart = j5;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DownloadPartInfo{partNumber=");
        sb.append(this.partNumber);
        sb.append(", rangeStart=");
        sb.append(this.rangeStart);
        sb.append(", rangeEnd=");
        sb.append(this.rangeEnd);
        sb.append(", isCompleted=");
        sb.append(this.isCompleted);
        sb.append(", hashCrc64ecma='");
        return a.e(this.hashCrc64ecma, "'}", sb);
    }
}
