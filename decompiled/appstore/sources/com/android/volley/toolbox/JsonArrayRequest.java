package com.android.volley.toolbox;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class JsonArrayRequest extends JsonRequest<JSONArray> {
    public JsonArrayRequest(String r10, Response.Listener<JSONArray> r11, Response.ErrorListener r12) {
        super(0, r10, null, r11, r12);
    }

    @Override // com.android.volley.toolbox.JsonRequest, com.android.volley.Request
    public Response<JSONArray> parseNetworkResponse(NetworkResponse r10) {
        return Response.success(new JSONArray(new String(r10.data, HttpHeaderParser.parseCharset(r10.headers, "utf-8"))), HttpHeaderParser.parseCacheHeaders(r10));
    L6:
        e = move-exception;
        return Response.error(new ParseError(e));
    L4:
        e = move-exception;
        return Response.error(new ParseError(e));
    }

    public JsonArrayRequest(int r10, String r11, JSONArray r12, Response.Listener<JSONArray> r13, Response.ErrorListener r14) {
        if (r12 != null) goto L5;
        String r15 = null;
    L6:
        super(r10, r11, r15, r13, r14);
        return;
    L5:
        r15 = r12.toString();
        goto L6
    }
}
