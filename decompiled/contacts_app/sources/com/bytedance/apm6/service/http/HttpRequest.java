package com.bytedance.apm6.service.http;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class HttpRequest {
    public byte[] data;
    public Map<String, String> headerMap;
    public String url;

    public HttpRequest(String r1, Map<String, String> r2) {
        this.url = r1;
        this.headerMap = r2;
    }

    public HttpRequest(String r1, Map<String, String> r2, byte[] r3) {
        this.url = r1;
        this.headerMap = r2;
        this.data = r3;
    }
}
