package com.volcengine.tos.model.object;

import B7.a;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class UploadFileInfo implements Serializable {
    private String filePath;
    private long fileSize;
    private long lastModified;

    public String getFilePath() {
        return this.filePath;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public UploadFileInfo setFilePath(String str) {
        this.filePath = str;
        return this;
    }

    public UploadFileInfo setFileSize(long j5) {
        this.fileSize = j5;
        return this;
    }

    public UploadFileInfo setLastModified(long j5) {
        this.lastModified = j5;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UploadFileInfo{filePath='");
        sb.append(this.filePath);
        sb.append("', lastModified=");
        sb.append(this.lastModified);
        sb.append(", fileSize=");
        return a.p(sb, this.fileSize, '}');
    }
}
