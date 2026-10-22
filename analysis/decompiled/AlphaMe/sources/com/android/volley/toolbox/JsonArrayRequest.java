package com.android.volley.toolbox;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class JsonArrayRequest extends JsonRequest<JSONArray> {
    public JsonArrayRequest(int i4, String str, String str2, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
        super(i4, str, str2, listener, errorListener);
    }

    @Override // com.android.volley.toolbox.JsonRequest, com.android.volley.Request
    public Response<JSONArray> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            return Response.success(new JSONArray(new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers, "utf-8"))), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (UnsupportedEncodingException e4) {
            return Response.error(new ParseError(e4));
        } catch (JSONException e5) {
            return Response.error(new ParseError(e5));
        }
    }

    public JsonArrayRequest(String str, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
        super(0, str, null, listener, errorListener);
    }

    public JsonArrayRequest(int i4, String str, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
        super(i4, str, null, listener, errorListener);
    }

    public JsonArrayRequest(int i4, String str, JSONArray jSONArray, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
        super(i4, str, jSONArray == null ? null : jSONArray.toString(), listener, errorListener);
    }

    public JsonArrayRequest(int i4, String str, JSONObject jSONObject, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
        super(i4, str, jSONObject == null ? null : jSONObject.toString(), listener, errorListener);
    }

    public JsonArrayRequest(String str, JSONArray jSONArray, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
        this(jSONArray == null ? 0 : 1, str, jSONArray, listener, errorListener);
    }

    public JsonArrayRequest(String str, JSONObject jSONObject, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
        this(jSONObject == null ? 0 : 1, str, jSONObject, listener, errorListener);
    }
}
