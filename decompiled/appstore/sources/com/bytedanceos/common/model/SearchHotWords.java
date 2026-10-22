package com.bytedanceos.common.model;

import com.bytedanceos.common.BaseApplication;

/* JADX INFO: loaded from: classes2.dex */
public class SearchHotWords {
    private String endTime;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f9837id;
    private boolean isSearchHit;
    private String keyword;
    private String mJsonData;
    private String mSSTJ;
    private String packageName;
    private String searchNum;
    private String sign;
    private String sort;
    private String startTime;
    private String status;
    private String updateTime;

    public SearchHotWords() {
    }

    public AppInfo convertToAppInfo() {
        AppInfo r10 = new AppInfo();
        r10.appName = this.keyword;
        r10.appPackageName = this.packageName;
        r10.mSSTJ = this.mSSTJ;
        r10.mApiUrl = BaseApplication.c().l();
        r10.mJsonData = this.mJsonData;
        return r10;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public String getId() {
        return this.f9837id;
    }

    public String getJsonData() {
        return this.mJsonData;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getSSTJ() {
        return this.mSSTJ;
    }

    public String getSearchNum() {
        return this.searchNum;
    }

    public String getSign() {
        return this.sign;
    }

    public String getSort() {
        return this.sort;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public String getStatus() {
        return this.status;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public boolean isSearchHit() {
        return this.isSearchHit;
    }

    public void setEndTime(String r10) {
        this.endTime = r10;
    }

    public void setId(String r10) {
        this.f9837id = r10;
    }

    public void setJsonData(String r10) {
        this.mJsonData = r10;
    }

    public void setKeyword(String r10) {
        this.keyword = r10;
    }

    public void setPackageName(String r10) {
        this.packageName = r10;
    }

    public void setSSTJ(String r10) {
        this.mSSTJ = r10;
    }

    public void setSearchHit(boolean r10) {
        this.isSearchHit = r10;
    }

    public void setSearchNum(String r10) {
        this.searchNum = r10;
    }

    public void setSign(String r10) {
        this.sign = r10;
    }

    public void setSort(String r10) {
        this.sort = r10;
    }

    public void setStartTime(String r10) {
        this.startTime = r10;
    }

    public void setStatus(String r10) {
        this.status = r10;
    }

    public void setUpdateTime(String r10) {
        this.updateTime = r10;
    }

    public String toString() {
        return "SearchHotWords:id:" + this.f9837id + ";keyword:" + this.keyword + ";searchNum:" + this.searchNum + ";updateTime:" + this.updateTime + ";sort:" + this.sort + ";package:" + this.packageName + ";status:" + this.status + ";/startTime:" + this.startTime + ";endTime:" + this.endTime;
    }
}
