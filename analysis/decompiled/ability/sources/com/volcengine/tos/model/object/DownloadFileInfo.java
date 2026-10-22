package com.volcengine.tos.model.object;

import B7.a;

/* loaded from: classes3.dex */
public class DownloadFileInfo {
    private String filePath;
    private String tempFilePath;

    public String getFilePath() {
        return this.filePath;
    }

    public String getTempFilePath() {
        return this.tempFilePath;
    }

    public DownloadFileInfo setFilePath(String str) {
        this.filePath = str;
        return this;
    }

    public DownloadFileInfo setTempFilePath(String str) {
        this.tempFilePath = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DownloadFileInfo{filePath='");
        sb.append(this.filePath);
        sb.append("', tempFilePath='");
        return a.q(sb, this.tempFilePath, "'}");
    }
}
