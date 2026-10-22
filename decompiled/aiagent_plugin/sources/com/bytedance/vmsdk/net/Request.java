package com.bytedance.vmsdk.net;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Request {
    static final String defaultMethod = "GET";
    InputStream body;
    Map<String, String> headers;
    String method;
    String url;

    public Request(String r4, JSONObject r5, byte[] r6) {
        this.url = r4;     // Catch: JSONException -> L25
        if (r5.has("method") == false) goto L6;
        String r7 = r5.getString("method");     // Catch: JSONException -> L25
    L7:
        this.method = r7;     // Catch: JSONException -> L25
        if (r6 == null) goto L14;
        if (r6.length == 0) goto L14;
        this.body = new ByteArrayInputStream(r6);     // Catch: JSONException -> L25
    L18:
        JSONObject r8 = (JSONObject) ZeusTransformUtils.preCheckCast(r5.opt("headers"), JSONObject.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L25
        this.headers = new HashMap();     // Catch: JSONException -> L25
        if (r8 == null) goto L31;
        Iterator<String> r9 = r8.keys();     // Catch: JSONException -> L25
    L21:
        if (r9.hasNext() == false) goto L32;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L25
        this.headers.put(r10, r8.getString(r10));     // Catch: JSONException -> L25
        goto L21
    L32:
        return;
    L31:
        return;
    L14:
        if (r5.has("body") == false) goto L16;
        ByteArrayInputStream r11 = new ByteArrayInputStream(r5.getString("body").getBytes());     // Catch: JSONException -> L25
    L17:
        this.body = r11;     // Catch: JSONException -> L25
        goto L18
    L16:
        r11 = null;
        goto L17
    L6:
        r7 = defaultMethod;
    L25:
        e = move-exception;
        e.printStackTrace();
    }

    public String getUrl() {
        return this.url;
    }

    public String getMethod() {
        return this.method;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public InputStream getBody() {
        return this.body;
    }

    public String getBodyString() {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        byte[] r2 = new byte[4096];
    L12:
        int r3 = this.body.read(r2, 0, 4096);     // Catch: IOException -> L9
        if (r3 <= 0) goto L6;
        r0.write(r2, 0, r3);     // Catch: IOException -> L9
    L6:
        if (r3 > 0) goto L12;
        return r0.toString();
    L9:
        e = move-exception;
        e.printStackTrace();
        return "";
    }
}
