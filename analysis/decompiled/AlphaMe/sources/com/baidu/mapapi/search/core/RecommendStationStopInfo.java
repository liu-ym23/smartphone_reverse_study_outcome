package com.baidu.mapapi.search.core;

import java.util.List;

/* loaded from: classes.dex */
public class RecommendStationStopInfo {

    /* renamed from: a, reason: collision with root package name */
    private String f7308a;

    /* renamed from: b, reason: collision with root package name */
    private List<RecommendStopInfo> f7309b;

    public List<RecommendStopInfo> getRecommendStopInfoList() {
        return this.f7309b;
    }

    public String getStationName() {
        return this.f7308a;
    }

    public void setRecommendStopInfoList(List<RecommendStopInfo> list) {
        this.f7309b = list;
    }

    public void setStationName(String str) {
        this.f7308a = str;
    }
}
