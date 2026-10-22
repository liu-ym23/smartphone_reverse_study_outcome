package com.bytedanceos.common.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class Recommends implements Serializable {
    private static final long serialVersionUID = -54564579191641699L;
    private String mBannerFooter;
    private JSONObject mExtra;
    private List<AppInfo> mRecommendList;
    private List<Topic> mRecommendTopics;
    private List<Topic> mSecondNavigation;

    public Recommends() {
        this.mRecommendTopics = new ArrayList();
        this.mSecondNavigation = new ArrayList();
        this.mRecommendList = new ArrayList();
    }

    public String getBannerFooter() {
        return this.mBannerFooter;
    }

    public JSONObject getExtra() {
        return this.mExtra;
    }

    public List<AppInfo> getRecommendList() {
        return this.mRecommendList;
    }

    public List<Topic> getRecommendTopics() {
        return this.mRecommendTopics;
    }

    public List<Topic> getSecondNavigation() {
        return this.mSecondNavigation;
    }

    public void setBannerFooter(String r10) {
        this.mBannerFooter = r10;
    }

    public void setExtra(JSONObject r10) {
        this.mExtra = r10;
    }

    public void setRecommendList(List<AppInfo> r10) {
        this.mRecommendList = r10;
    }

    public void setRecommendTopics(List<Topic> r10) {
        this.mRecommendTopics = r10;
    }

    public void setSecondNavigation(List<Topic> r10) {
        this.mSecondNavigation = r10;
    }
}
