package com.amap.api.services.routepoisearch;

import com.amap.api.col.jmsl.C1631z1;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import java.util.List;

/* loaded from: classes.dex */
public class RoutePOISearchQuery implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private LatLonPoint f18000a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f18001b;

    /* renamed from: c, reason: collision with root package name */
    private int f18002c;

    /* renamed from: d, reason: collision with root package name */
    private RoutePOISearch.RoutePOISearchType f18003d;

    /* renamed from: e, reason: collision with root package name */
    private int f18004e;

    /* renamed from: f, reason: collision with root package name */
    private List<LatLonPoint> f18005f;

    /* renamed from: g, reason: collision with root package name */
    private String f18006g;

    public RoutePOISearchQuery(LatLonPoint latLonPoint, LatLonPoint latLonPoint2, int i10, RoutePOISearch.RoutePOISearchType routePOISearchType, int i11) {
        this.f18000a = latLonPoint;
        this.f18001b = latLonPoint2;
        this.f18002c = i10;
        this.f18003d = routePOISearchType;
        this.f18004e = i11;
    }

    public String getChannel() {
        return this.f18006g;
    }

    public LatLonPoint getFrom() {
        return this.f18000a;
    }

    public int getMode() {
        return this.f18002c;
    }

    public List<LatLonPoint> getPolylines() {
        return this.f18005f;
    }

    public int getRange() {
        return this.f18004e;
    }

    public RoutePOISearch.RoutePOISearchType getSearchType() {
        return this.f18003d;
    }

    public LatLonPoint getTo() {
        return this.f18001b;
    }

    public void setChannel(String str) {
        this.f18006g = str;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public RoutePOISearchQuery m41clone() throws CloneNotSupportedException {
        try {
            super.clone();
        } catch (CloneNotSupportedException e10) {
            C1631z1.o(e10, "RoutePOISearchQuery", "RoutePOISearchQueryclone");
        }
        List<LatLonPoint> list = this.f18005f;
        if (list == null || list.size() <= 0) {
            RoutePOISearchQuery routePOISearchQuery = new RoutePOISearchQuery(this.f18000a, this.f18001b, this.f18002c, this.f18003d, this.f18004e);
            routePOISearchQuery.setChannel(this.f18006g);
            return routePOISearchQuery;
        }
        RoutePOISearchQuery routePOISearchQuery2 = new RoutePOISearchQuery(this.f18005f, this.f18003d, this.f18004e);
        routePOISearchQuery2.setChannel(this.f18006g);
        return routePOISearchQuery2;
    }

    public RoutePOISearchQuery(List<LatLonPoint> list, RoutePOISearch.RoutePOISearchType routePOISearchType, int i10) {
        this.f18005f = list;
        this.f18003d = routePOISearchType;
        this.f18004e = i10;
    }
}
