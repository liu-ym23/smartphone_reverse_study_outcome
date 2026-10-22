package com.bytedance.android.livesdkapi.roomplayer;

import com.bytedance.android.livesdkapi.model.PlayerNameValuePair;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class PlayerHttpResponse {
    private byte[] body;
    private List<PlayerNameValuePair> headers;
    private String mimeType;
    private String reason;
    private int statusCode;
    private InputStream stream;
    private String url;

    public PlayerHttpResponse() {
    }

    public byte[] getBody() {
        return this.body;
    }

    public List<PlayerNameValuePair> getHeaders() {
        return this.headers;
    }

    public PlayerHttpResponse setBody(byte[] r100) {
        this.body = r100;
        return this;
    }

    public PlayerHttpResponse setHeaders(List<PlayerNameValuePair> r100) {
        this.headers = r100;
        return this;
    }

    public PlayerHttpResponse setMimeType(String r100) {
        this.mimeType = r100;
        return this;
    }

    public PlayerHttpResponse setReason(String r100) {
        this.reason = r100;
        return this;
    }

    public PlayerHttpResponse setStatusCode(int r100) {
        this.statusCode = r100;
        return this;
    }

    public PlayerHttpResponse setStream(InputStream r100) {
        this.stream = r100;
        return this;
    }

    public PlayerHttpResponse setUrl(String r100) {
        this.url = r100;
        return this;
    }
}
