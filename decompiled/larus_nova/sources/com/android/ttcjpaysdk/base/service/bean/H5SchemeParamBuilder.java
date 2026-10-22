package com.android.ttcjpaysdk.base.service.bean;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class H5SchemeParamBuilder {
    private int callbackId;
    private Context context;
    private Map<String, String> extendParams;
    private JSONObject hostInfo;
    private boolean isFromBanner;
    private String url;

    public H5SchemeParamBuilder() {
        this.callbackId = -1;
        this.extendParams = new HashMap();
    }

    public int getCallbackId() {
        return this.callbackId;
    }

    public Context getContext() {
        return this.context;
    }

    public Map<String, String> getExtendParams() {
        return this.extendParams;
    }

    public JSONObject getHostInfo() {
        return this.hostInfo;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isFromBanner() {
        return this.isFromBanner;
    }

    public H5SchemeParamBuilder setCallbackId(int r100) {
        this.callbackId = r100;
        return this;
    }

    public H5SchemeParamBuilder setContext(Context r100) {
        this.context = r100;
        return this;
    }

    public H5SchemeParamBuilder setExtendParams(Map<String, String> r100) {
        this.extendParams = r100;
        return this;
    }

    public H5SchemeParamBuilder setFromBanner(boolean r100) {
        this.isFromBanner = r100;
        return this;
    }

    public H5SchemeParamBuilder setHostInfo(JSONObject r100) {
        this.hostInfo = r100;
        return this;
    }

    public H5SchemeParamBuilder setUrl(String r100) {
        this.url = r100;
        return this;
    }
}
