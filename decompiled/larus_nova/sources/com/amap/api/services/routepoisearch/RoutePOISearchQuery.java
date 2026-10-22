package com.amap.api.services.routepoisearch;

import com.amap.api.col.s.i;
import com.amap.api.services.core.LatLonPoint;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class RoutePOISearchQuery implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LatLonPoint f29265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LatLonPoint f29266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f29267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private RoutePOISearch.RoutePOISearchType f29268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f29269e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<LatLonPoint> f29270f;

    public RoutePOISearchQuery clone() {
        super.clone();     // Catch: CloneNotSupportedException -> L4
    L6:
        List<LatLonPoint> r100 = this.f29270f;
        if (r100 == null) goto L13;
        if (r100.size() <= 0) goto L13;
        return new RoutePOISearchQuery(this.f29270f, this.f29268d, this.f29269e);
    L13:
        return new RoutePOISearchQuery(this.f29265a, this.f29266b, this.f29267c, this.f29268d, this.f29269e);
    L4:
        e = move-exception;
        i.a(e, "RoutePOISearchQuery", "RoutePOISearchQueryclone");
        goto L6
    }

    public LatLonPoint getFrom() {
        return this.f29265a;
    }

    public int getMode() {
        return this.f29267c;
    }

    public List<LatLonPoint> getPolylines() {
        return this.f29270f;
    }

    public int getRange() {
        return this.f29269e;
    }

    public RoutePOISearch.RoutePOISearchType getSearchType() {
        return this.f29268d;
    }

    public LatLonPoint getTo() {
        return this.f29266b;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8047clone() throws CloneNotSupportedException {
        return clone();
    }

    public RoutePOISearchQuery(List<LatLonPoint> r100, RoutePOISearch.RoutePOISearchType r101, int r102) {
        this.f29270f = r100;
        this.f29268d = r101;
        this.f29269e = r102;
    }

    public RoutePOISearchQuery(LatLonPoint r100, LatLonPoint r101, int r102, RoutePOISearch.RoutePOISearchType r103, int r104) {
        this.f29265a = r100;
        this.f29266b = r101;
        this.f29267c = r102;
        this.f29268d = r103;
        this.f29269e = r104;
    }
}
