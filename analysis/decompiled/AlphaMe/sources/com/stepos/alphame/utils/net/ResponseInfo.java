package com.stepos.alphame.utils.net;

import androidx.annotation.Nullable;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class ResponseInfo {
    private Map<String, List<String>> headers;
    private HttpRequest httpRequest;
    private boolean isCache;
    private int statusCode;

    public ResponseInfo(HttpRequest httpRequest) {
        this.httpRequest = httpRequest;
    }

    public Map<String, List<String>> getHeaders() {
        return this.headers;
    }

    @Nullable
    public HttpRequest getHttpRequest() {
        return this.httpRequest;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public boolean isCache() {
        return this.isCache;
    }

    public void setCache(boolean z4) {
        this.isCache = z4;
    }

    public void setHeaders(Map<String, List<String>> map) {
        this.headers = map;
    }

    public void setStatusCode(int i4) {
        this.statusCode = i4;
    }
}
