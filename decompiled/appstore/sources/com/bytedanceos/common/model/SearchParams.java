package com.bytedanceos.common.model;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SearchParams {
    public boolean mInstallFilter;
    public String mPackage;
    public int mPageNo;
    public JSONObject mParams;
    public String mSearchFrom;
    public String mSearchKey;
    public String mSource;
    public String mTraceId;

    public SearchParams() {
        this.mInstallFilter = false;
    }
}
