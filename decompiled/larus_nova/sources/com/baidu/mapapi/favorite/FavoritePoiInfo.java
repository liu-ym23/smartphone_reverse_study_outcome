package com.baidu.mapapi.favorite;

import com.baidu.mapapi.model.LatLng;

/* JADX INFO: loaded from: classes39.dex */
public class FavoritePoiInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f30548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f30549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    LatLng f30550c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f30551d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f30552e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f30553f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    long f30554g;

    public FavoritePoiInfo() {
    }

    public String getAddr() {
        return this.f30551d;
    }

    public String getCityName() {
        return this.f30552e;
    }

    public String getID() {
        return this.f30548a;
    }

    public String getPoiName() {
        return this.f30549b;
    }

    public LatLng getPt() {
        return this.f30550c;
    }

    public long getTimeStamp() {
        return this.f30554g;
    }

    public String getUid() {
        return this.f30553f;
    }

    public FavoritePoiInfo addr(String r100) {
        this.f30551d = r100;
        return this;
    }

    public FavoritePoiInfo cityName(String r100) {
        this.f30552e = r100;
        return this;
    }

    public FavoritePoiInfo poiName(String r100) {
        this.f30549b = r100;
        return this;
    }

    public FavoritePoiInfo pt(LatLng r100) {
        this.f30550c = r100;
        return this;
    }

    public FavoritePoiInfo uid(String r100) {
        this.f30553f = r100;
        return this;
    }
}
