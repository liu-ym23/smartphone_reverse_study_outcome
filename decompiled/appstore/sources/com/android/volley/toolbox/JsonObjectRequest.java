package com.android.volley.toolbox;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class JsonObjectRequest extends JsonRequest<JSONObject> {
    public JsonObjectRequest(int r10, String r11, JSONObject r12, Response.Listener<JSONObject> r13, Response.ErrorListener r14) {
        if (r12 != null) goto L5;
        String r15 = null;
    L6:
        super(r10, r11, r15, r13, r14);
        return;
    L5:
        r15 = r12.toString();
        goto L6
    }

    @Override // com.android.volley.toolbox.JsonRequest, com.android.volley.Request
    public Response<JSONObject> parseNetworkResponse(NetworkResponse r10) {
        return Response.success(new JSONObject(new String(r10.data, HttpHeaderParser.parseCharset(r10.headers, "utf-8"))), HttpHeaderParser.parseCacheHeaders(r10));
    L6:
        e = move-exception;
        return Response.error(new ParseError(e));
    L4:
        e = move-exception;
        return Response.error(new ParseError(e));
    }

    public JsonObjectRequest(String r10, JSONObject r11, Response.Listener<JSONObject> r12, Response.ErrorListener r13) {
        if (r11 != null) goto L5;
        int r14 = 0;
    L6:
        this(r14, r10, r11, r12, r13);
        return;
    L5:
        r14 = 1;
        goto L6
    }
}
