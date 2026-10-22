package com.android.volley.toolbox;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes.dex */
public class StringRequest extends Request<String> {
    private final Response.Listener<String> mListener;

    public StringRequest(int r10, String r11, Response.Listener<String> r12, Response.ErrorListener r13) {
        super(r10, r11, r13);
        this.mListener = r12;
    }

    @Override // com.android.volley.Request
    public /* bridge */ /* synthetic */ void deliverResponse(String r10) {
        deliverResponse2(r10);
    }

    @Override // com.android.volley.Request
    public Response<String> parseNetworkResponse(NetworkResponse r10) {
        String r11 = new String(r10.data, HttpHeaderParser.parseCharset(r10.headers));     // Catch: UnsupportedEncodingException -> L4
    L6:
        return Response.success(r11, HttpHeaderParser.parseCacheHeaders(r10));
    L4:
        r11 = new String(r10.data);
        goto L6
    }

    /* JADX INFO: renamed from: deliverResponse, reason: avoid collision after fix types in other method */
    public void deliverResponse2(String r10) {
        this.mListener.onResponse(r10);
    }

    public StringRequest(String r10, Response.Listener<String> r11, Response.ErrorListener r12) {
        this(0, r10, r11, r12);
    }
}
