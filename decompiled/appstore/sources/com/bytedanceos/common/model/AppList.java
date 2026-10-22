package com.bytedanceos.common.model;

import java.io.Serializable;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AppList implements Serializable {
    private static final long serialVersionUID = 2;
    private int mBannerType;
    private List<String> mBannerUrls;
    private List<AppInfo> mDataList;
    private JSONObject mExtra;
    private boolean mHasMore;
    private String mIntroduce;
    private int mLastId;
    private String mTraceId;

    public AppList() {
        this.mHasMore = false;
        this.mBannerType = 105;
    }

    public int getBannerType() {
        return this.mBannerType;
    }

    public List<String> getBannerUrl() {
        return this.mBannerUrls;
    }

    public List<AppInfo> getDataList() {
        return this.mDataList;
    }

    public JSONObject getExtra() {
        return this.mExtra;
    }

    public String getIntroduce() {
        return this.mIntroduce;
    }

    public int getLastId() {
        return this.mLastId;
    }

    public String getTraceId() {
        return this.mTraceId;
    }

    public boolean hasMore() {
        return this.mHasMore;
    }

    public boolean isEmpty() {
        List<AppInfo> r10 = this.mDataList;
        if (r10 != null) goto L5;
    L8:
        return true;
    L5:
        if (r10.isEmpty() == true) goto L8;
        return false;
    }

    public void setBannerType(int r10) {
        this.mBannerType = r10;
    }

    public void setBannerUrls(List<String> r10) {
        this.mBannerUrls = r10;
    }

    public void setDataList(List<AppInfo> r10) {
        this.mDataList = r10;
    }

    public void setExtra(JSONObject r10) {
        this.mExtra = r10;
    }

    public void setIntroduce(String r10) {
        this.mIntroduce = r10;
    }

    public void setLastId(int r10) {
        this.mLastId = r10;
    }

    public void setMore(boolean r10) {
        this.mHasMore = r10;
    }

    public void setTraceId(String r10) {
        this.mTraceId = r10;
    }
}
