package com.android.volley.toolbox;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyLog;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes.dex */
public abstract class JsonRequest<T> extends Request<T> {
    protected static final String PROTOCOL_CHARSET = "utf-8";
    private static final String PROTOCOL_CONTENT_TYPE = null;
    private final Response.Listener<T> mListener;
    private final String mRequestBody;

    static {
        PROTOCOL_CONTENT_TYPE = String.format("application/json; charset=%s", new Object[]{PROTOCOL_CHARSET});
    }

    public JsonRequest(String r10, String r11, Response.Listener<T> r12, Response.ErrorListener r13) {
        this(-1, r10, r11, r12, r13);
    }

    @Override // com.android.volley.Request
    public void deliverResponse(T r10) {
        this.mListener.onResponse(r10);
    }

    @Override // com.android.volley.Request
    public byte[] getBody() {
        String r10 = this.mRequestBody;     // Catch: UnsupportedEncodingException -> L8
        if (r10 == null) goto L12;
        return r10.getBytes(PROTOCOL_CHARSET);
    L12:
        return null;
    L8:
        VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", new Object[]{this.mRequestBody, PROTOCOL_CHARSET});
        return null;
    }

    @Override // com.android.volley.Request
    public String getBodyContentType() {
        return PROTOCOL_CONTENT_TYPE;
    }

    @Override // com.android.volley.Request
    public byte[] getPostBody() {
        return getBody();
    }

    @Override // com.android.volley.Request
    public String getPostBodyContentType() {
        return getBodyContentType();
    }

    @Override // com.android.volley.Request
    public abstract Response<T> parseNetworkResponse(NetworkResponse r10);

    public JsonRequest(int r10, String r11, String r12, Response.Listener<T> r13, Response.ErrorListener r14) {
        super(r10, r11, r14);
        this.mListener = r13;
        this.mRequestBody = r12;
    }
}
