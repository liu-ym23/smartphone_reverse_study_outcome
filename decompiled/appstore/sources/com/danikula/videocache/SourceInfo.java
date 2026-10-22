package com.danikula.videocache;

/* JADX INFO: loaded from: classes2.dex */
public class SourceInfo {
    public final long length;
    public final String mime;
    public final String url;

    public SourceInfo(String r10, long r11, String r12) {
        this.url = r10;
        this.length = r11;
        this.mime = r12;
    }

    public String toString() {
        return "SourceInfo{url='" + this.url + "', length=" + this.length + ", mime='" + this.mime + "'}";
    }
}
