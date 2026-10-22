package com.amap.api.services.geocoder;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class GeocodeResult {

    /* renamed from: a, reason: collision with root package name */
    private GeocodeQuery f17441a;

    /* renamed from: b, reason: collision with root package name */
    private List<GeocodeAddress> f17442b;

    public GeocodeResult(GeocodeQuery geocodeQuery, List<GeocodeAddress> list) {
        new ArrayList();
        this.f17441a = geocodeQuery;
        this.f17442b = list;
    }

    public List<GeocodeAddress> getGeocodeAddressList() {
        return this.f17442b;
    }

    public GeocodeQuery getGeocodeQuery() {
        return this.f17441a;
    }

    public void setGeocodeAddressList(List<GeocodeAddress> list) {
        this.f17442b = list;
    }

    public void setGeocodeQuery(GeocodeQuery geocodeQuery) {
        this.f17441a = geocodeQuery;
    }
}
