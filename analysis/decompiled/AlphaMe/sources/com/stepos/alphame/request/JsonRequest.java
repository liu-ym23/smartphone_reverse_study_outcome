package com.stepos.alphame.request;

import android.text.TextUtils;
import ch.qos.logback.classic.spi.CallerData;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.stepos.activeview.utils.Constants;
import com.stepos.alphame.utils.AlphaMeLogger;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;

/* loaded from: classes.dex */
public class JsonRequest<T> extends Request<T> {
    public static final String TAG_DEBUG = "JsonRequest";
    private final Map<String, String> mHeaders;
    private ResponseListener<T> mListener;
    private final Map<String, String> mParamer;
    private final int mRequestCode;
    private final TypeReference<T> mTypeRef;

    public static class Builder<T> {
        private ResponseListener<T> mListener;
        private Object mTag;
        private TypeReference<T> mTypeRef;
        private String mUrl;
        private int mRequestCode = 0;
        private int mMethod = 0;
        private Map<String, String> mHeader = new HashMap();
        private Map<String, String> mParamer = new HashMap();
        private boolean mShouldCache = true;

        public Builder() {
            initHeader();
        }

        private void initHeader() {
            this.mHeader.put("Charset", Constants.UTF_8_CODE);
        }

        private String mapToHttpParamers(Map<String, String> map) {
            StringBuilder sb = new StringBuilder("");
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                        sb.append(URLEncoder.encode(entry.getKey(), Constants.UTF_8_CODE));
                        sb.append('=');
                        sb.append(URLEncoder.encode(entry.getValue(), Constants.UTF_8_CODE));
                        sb.append(Typography.amp);
                    }
                }
                return sb.toString().substring(0, sb.length() - 1);
            } catch (UnsupportedEncodingException e4) {
                e4.printStackTrace();
                return sb.toString();
            }
        }

        public Builder<T> addHeader(String str, String str2) {
            this.mHeader.put(str, str2);
            return this;
        }

        public Builder<T> addParamer(String str, String str2) {
            AlphaMeLogger.debugLog("addParamer-->>> key=" + str + ", value=" + str2);
            this.mParamer.put(str, str2);
            return this;
        }

        public Builder<T> addParamerIfNotNull(String str, String str2) {
            if (str2 != null) {
                AlphaMeLogger.debugLog("addParamer-->>> key=" + str + ", value=" + str2);
                this.mParamer.put(str, str2);
            }
            return this;
        }

        public JsonRequest<T> build() {
            if (this.mUrl == null) {
                AlphaMeLogger.eLog("You must use setUrl() to set a valid Url in this Builder!");
            }
            if (this.mMethod == 0 && !this.mParamer.isEmpty()) {
                this.mUrl += CallerData.NA + mapToHttpParamers(this.mParamer);
                AlphaMeLogger.debugLog("JsonRequest----mUrl=" + this.mUrl);
            }
            JsonRequest<T> jsonRequest = new JsonRequest<>(this.mMethod, this.mRequestCode, this.mUrl, this.mHeader, this.mParamer, this.mTypeRef, this.mListener);
            jsonRequest.setRetryPolicy(new DefaultRetryPolicy(5000, 0, 1.0f));
            jsonRequest.setShouldCache(this.mShouldCache);
            jsonRequest.setTag(this.mTag);
            return jsonRequest;
        }

        public Builder<T> setBeanType(TypeReference<T> typeReference) {
            this.mTypeRef = typeReference;
            return this;
        }

        public Builder<T> setListener(ResponseListener<T> responseListener) {
            this.mListener = responseListener;
            return this;
        }

        public Builder<T> setMethod(int i4) {
            this.mMethod = i4;
            return this;
        }

        public Builder<T> setRequestCode(int i4) {
            this.mRequestCode = i4;
            return this;
        }

        public Builder<T> setShouldCache(boolean z4) {
            this.mShouldCache = z4;
            return this;
        }

        public Builder<T> setTag(Object obj) {
            this.mTag = obj;
            return this;
        }

        public Builder<T> setUrl(String str) {
            this.mUrl = str;
            return this;
        }

        public JsonRequest<T> start(com.android.volley.RequestQueue requestQueue) {
            JsonRequest<T> jsonRequestBuild = build();
            requestQueue.add(jsonRequestBuild);
            return jsonRequestBuild;
        }
    }

    public JsonRequest(int i4, int i5, String str, Map<String, String> map, Map<String, String> map2, TypeReference<T> typeReference, ResponseListener<T> responseListener) {
        super(i4, str, null);
        this.mRequestCode = i5;
        this.mHeaders = map;
        this.mParamer = map2;
        this.mTypeRef = typeReference;
        this.mListener = responseListener;
    }

    @Override // com.android.volley.Request
    public void deliverError(VolleyError volleyError) {
        StringBuilder sb = new StringBuilder("deliverError--error:");
        sb.append(volleyError == null ? "null" : volleyError.getMessage());
        sb.append("\ndata=");
        NetworkResponse networkResponse = volleyError.networkResponse;
        sb.append(networkResponse == null ? "null" : networkResponse.data);
        sb.append("\nstatusCode=");
        NetworkResponse networkResponse2 = volleyError.networkResponse;
        sb.append(networkResponse2 != null ? Integer.valueOf(networkResponse2.statusCode) : "null");
        AlphaMeLogger.debugLog(sb.toString());
        ResponseListener<T> responseListener = this.mListener;
        if (responseListener != null) {
            responseListener.onFailed(this.mRequestCode, volleyError);
        }
    }

    @Override // com.android.volley.Request
    public void deliverResponse(T t4) {
        AlphaMeLogger.debugLog("deliverResponse--mListener:\n" + this.mListener + "--response:\n" + t4);
        ResponseListener<T> responseListener = this.mListener;
        if (responseListener != null) {
            responseListener.onSuccess(this.mRequestCode, t4);
        }
    }

    @Override // com.android.volley.Request
    public String getCacheKey() {
        return super.getCacheKey();
    }

    @Override // com.android.volley.Request
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> map = this.mHeaders;
        return map != null ? map : super.getHeaders();
    }

    @Override // com.android.volley.Request
    public Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> map = this.mParamer;
        return map != null ? map : super.getParams();
    }

    @Override // com.android.volley.Request
    public Response<T> parseNetworkResponse(NetworkResponse networkResponse) {
        Object object;
        try {
            String str = new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers, "utf-8"));
            AlphaMeLogger.debugLog("parseNetworkResponse----jsonStr:\n".concat(str));
            SteposResponseBean steposResponseBean = (SteposResponseBean) JSON.parseObject(str, SteposResponseBean.class);
            AlphaMeLogger.debugLog("MzResponseBean : " + steposResponseBean);
            if (steposResponseBean == null) {
                return Response.error(new VolleyError("ResponseBean is null"));
            }
            if (steposResponseBean.getCode() != 200) {
                return Response.error(new VolleyError(steposResponseBean.getCode() + "###" + steposResponseBean.getMsg()));
            }
            if (this.mTypeRef != null) {
                object = JSON.parseObject(steposResponseBean.getValue(), this.mTypeRef, new Feature[0]);
                AlphaMeLogger.debugLog("result : " + object);
                if (object == null) {
                    return Response.error(new VolleyError("ResponseBean is null"));
                }
            } else {
                object = null;
            }
            return Response.success(object, HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (UnsupportedEncodingException e4) {
            e4.printStackTrace();
            return Response.error(new ParseError(e4));
        }
    }

    public JsonRequest<T> setListener(ResponseListener<T> responseListener) {
        this.mListener = responseListener;
        return this;
    }

    public void start(com.android.volley.RequestQueue requestQueue) {
        requestQueue.add(this);
    }

    @Override // com.android.volley.Request
    public JsonRequest<T> setTag(Object obj) {
        super.setTag(obj);
        return this;
    }
}
