package com.alipay.android.phone.mrpc.core;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public class HttpUrlHeader implements Serializable {
    public static final long serialVersionUID = -6098125857367743614L;
    public Map<String, String> headers;

    public HttpUrlHeader() {
        this.headers = new HashMap();
    }

    public String getHead(String r100) {
        return this.headers.get(r100);
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public void setHead(String r100, String r101) {
        this.headers.put(r100, r101);
    }

    public void setHeaders(Map<String, String> r100) {
        this.headers = r100;
    }
}
