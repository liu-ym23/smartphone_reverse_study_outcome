package com.volcengine.tos.model.object;

import androidx.appfunctions.metadata.a;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class UploadFilePartInfo implements Serializable {
    private boolean isCompleted;
    private long offset;
    private UploadPartOutput part;
    private int partNum;
    private long partSize;

    public long getOffset() {
        return this.offset;
    }

    public UploadPartOutput getPart() {
        return this.part;
    }

    public int getPartNum() {
        return this.partNum;
    }

    public long getPartSize() {
        return this.partSize;
    }

    public boolean isCompleted() {
        return this.isCompleted;
    }

    public UploadFilePartInfo setCompleted(boolean z10) {
        this.isCompleted = z10;
        return this;
    }

    public UploadFilePartInfo setOffset(long j5) {
        this.offset = j5;
        return this;
    }

    public UploadFilePartInfo setPart(UploadPartOutput uploadPartOutput) {
        this.part = uploadPartOutput;
        return this;
    }

    public UploadFilePartInfo setPartNum(int i) {
        this.partNum = i;
        return this;
    }

    public UploadFilePartInfo setPartSize(long j5) {
        this.partSize = j5;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UploadFilePartInfo{part=");
        sb.append(this.part);
        sb.append(", offset=");
        sb.append(this.offset);
        sb.append(", partNum=");
        sb.append(this.partNum);
        sb.append(", partSize=");
        sb.append(this.partSize);
        sb.append(", isCompleted=");
        return a.r(sb, this.isCompleted, '}');
    }
}
