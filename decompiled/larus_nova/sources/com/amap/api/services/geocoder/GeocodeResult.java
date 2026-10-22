package com.amap.api.services.geocoder;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class GeocodeResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private GeocodeQuery f28917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<GeocodeAddress> f28918b;

    public List<GeocodeAddress> getGeocodeAddressList() {
        return this.f28918b;
    }

    public GeocodeQuery getGeocodeQuery() {
        return this.f28917a;
    }

    public void setGeocodeAddressList(List<GeocodeAddress> r100) {
        this.f28918b = r100;
    }

    public void setGeocodeQuery(GeocodeQuery r100) {
        this.f28917a = r100;
    }

    public GeocodeResult(GeocodeQuery r100, List<GeocodeAddress> r101) {
        new ArrayList();
        this.f28917a = r100;
        this.f28918b = r101;
    }
}
