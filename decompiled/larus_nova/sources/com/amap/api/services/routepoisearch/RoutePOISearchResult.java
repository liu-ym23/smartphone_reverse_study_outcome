package com.amap.api.services.routepoisearch;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class RoutePOISearchResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<RoutePOIItem> f29271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RoutePOISearchQuery f29272b;

    public RoutePOISearchQuery getQuery() {
        return this.f29272b;
    }

    public List<RoutePOIItem> getRoutePois() {
        return this.f29271a;
    }

    public RoutePOISearchResult(ArrayList<RoutePOIItem> r100, RoutePOISearchQuery r101) {
        new ArrayList();
        this.f29271a = r100;
        this.f29272b = r101;
    }
}
