package com.amap.api.services.geocoder;

/* JADX INFO: loaded from: classes28.dex */
public class RegeocodeResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RegeocodeQuery f28944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RegeocodeAddress f28945b;

    public RegeocodeAddress getRegeocodeAddress() {
        return this.f28945b;
    }

    public RegeocodeQuery getRegeocodeQuery() {
        return this.f28944a;
    }

    public void setRegeocodeAddress(RegeocodeAddress r100) {
        this.f28945b = r100;
    }

    public void setRegeocodeQuery(RegeocodeQuery r100) {
        this.f28944a = r100;
    }

    public RegeocodeResult(RegeocodeQuery r100, RegeocodeAddress r101) {
        this.f28944a = r100;
        this.f28945b = r101;
    }
}
