package com.amap.api.services.nearby;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class NearbySearchResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<NearbyInfo> f28984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f28985b;

    public NearbySearchResult() {
        this.f28984a = new ArrayList();
        this.f28985b = 0;
    }

    public List<NearbyInfo> getNearbyInfoList() {
        return this.f28984a;
    }

    public int getTotalNum() {
        return this.f28985b;
    }

    public void setNearbyInfoList(List<NearbyInfo> r100) {
        this.f28984a = r100;
        this.f28985b = r100.size();
    }
}
