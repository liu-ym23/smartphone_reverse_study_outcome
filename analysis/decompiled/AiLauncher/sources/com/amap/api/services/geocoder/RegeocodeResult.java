package com.amap.api.services.geocoder;

/* loaded from: classes.dex */
public class RegeocodeResult {

    /* renamed from: a, reason: collision with root package name */
    private RegeocodeQuery f17468a;

    /* renamed from: b, reason: collision with root package name */
    private RegeocodeAddress f17469b;

    public RegeocodeResult(RegeocodeQuery regeocodeQuery, RegeocodeAddress regeocodeAddress) {
        this.f17468a = regeocodeQuery;
        this.f17469b = regeocodeAddress;
    }

    public RegeocodeAddress getRegeocodeAddress() {
        return this.f17469b;
    }

    public RegeocodeQuery getRegeocodeQuery() {
        return this.f17468a;
    }

    public void setRegeocodeAddress(RegeocodeAddress regeocodeAddress) {
        this.f17469b = regeocodeAddress;
    }

    public void setRegeocodeQuery(RegeocodeQuery regeocodeQuery) {
        this.f17468a = regeocodeQuery;
    }
}
