package com.amap.api.services.routepoisearch;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RoutePOISearchResult {

    /* renamed from: a, reason: collision with root package name */
    private List<RoutePOIItem> f18007a;

    /* renamed from: b, reason: collision with root package name */
    private RoutePOISearchQuery f18008b;

    public RoutePOISearchResult(ArrayList<RoutePOIItem> arrayList, RoutePOISearchQuery routePOISearchQuery) {
        new ArrayList();
        this.f18007a = arrayList;
        this.f18008b = routePOISearchQuery;
    }

    public RoutePOISearchQuery getQuery() {
        return this.f18008b;
    }

    public List<RoutePOIItem> getRoutePois() {
        return this.f18007a;
    }
}
