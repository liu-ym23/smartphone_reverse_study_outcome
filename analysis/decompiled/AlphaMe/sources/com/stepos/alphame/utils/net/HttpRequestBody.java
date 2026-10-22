package com.stepos.alphame.utils.net;

import F1.n;
import android.util.ArrayMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class HttpRequestBody {
    public static final int TYPE_FORM = 2;
    public static final int TYPE_JSON = 1;
    String charset;
    Map<String, String> contents = new ArrayMap();
    int type;

    private HttpRequestBody(int i4, String str) {
        this.type = i4;
        this.charset = str;
    }

    public static HttpRequestBody form() {
        return new HttpRequestBody(2, null);
    }

    public static HttpRequestBody json(String str, String str2) {
        HttpRequestBody httpRequestBody = new HttpRequestBody(1, str2);
        httpRequestBody.add("com.stepos.alphame.json", str);
        return httpRequestBody;
    }

    public void add(String str, String str2) {
        this.contents.put(str, str2);
    }

    public String getCharset() {
        return this.charset;
    }

    public Map<String, String> getContents() {
        return this.contents;
    }

    public int getType() {
        return this.type;
    }

    public void setCharset(String str) {
        this.charset = str;
    }

    public void setContents(Map<String, String> map) {
        this.contents = map;
    }

    public void setType(int i4) {
        this.type = i4;
    }

    public static HttpRequestBody json(Object obj, String str) {
        HttpRequestBody httpRequestBody = new HttpRequestBody(1, str);
        if (obj != null) {
            httpRequestBody.add("com.stepos.alphame.json", new n().g(obj));
        }
        return httpRequestBody;
    }
}
