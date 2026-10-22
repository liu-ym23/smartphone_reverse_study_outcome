package com.amap.api.services.nearby;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class NearbySearchResult {

    /* renamed from: a, reason: collision with root package name */
    private List<NearbyInfo> f17507a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private int f17508b = 0;

    public List<NearbyInfo> getNearbyInfoList() {
        return this.f17507a;
    }

    public int getTotalNum() {
        return this.f17508b;
    }

    public void setNearbyInfoList(List<NearbyInfo> list) {
        this.f17507a = list;
        this.f17508b = list.size();
    }
}
