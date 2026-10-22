package com.byted.cast.common.api;

import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public class Response {
    public String body;
    public int code;
    public Map<String, String> headers;
    public String msg;

    public String toString() {
        return "Response{headers=" + this.headers + ", body='" + this.body + "', code=" + this.code + ", msg='" + this.msg + "'}";
    }

    public Response(String r100, int r101, String r102) {
        this.body = r100;
        this.code = r101;
        this.msg = r102;
    }

    public Response(Map<String, String> r100, String r101, int r102, String r103) {
        this.headers = r100;
        this.body = r101;
        this.code = r102;
        this.msg = r103;
    }
}
