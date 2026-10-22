package com.baidu.mapapi.favorite;

import com.baidu.mapapi.model.LatLng;

/* loaded from: classes.dex */
public class FavoritePoiInfo {

    /* renamed from: a, reason: collision with root package name */
    String f6005a;

    /* renamed from: b, reason: collision with root package name */
    String f6006b;

    /* renamed from: c, reason: collision with root package name */
    LatLng f6007c;

    /* renamed from: d, reason: collision with root package name */
    String f6008d;

    /* renamed from: e, reason: collision with root package name */
    String f6009e;

    /* renamed from: f, reason: collision with root package name */
    String f6010f;

    /* renamed from: g, reason: collision with root package name */
    long f6011g;

    public FavoritePoiInfo addr(String str) {
        this.f6008d = str;
        return this;
    }

    public FavoritePoiInfo cityName(String str) {
        this.f6009e = str;
        return this;
    }

    public String getAddr() {
        return this.f6008d;
    }

    public String getCityName() {
        return this.f6009e;
    }

    public String getID() {
        return this.f6005a;
    }

    public String getPoiName() {
        return this.f6006b;
    }

    public LatLng getPt() {
        return this.f6007c;
    }

    public long getTimeStamp() {
        return this.f6011g;
    }

    public String getUid() {
        return this.f6010f;
    }

    public FavoritePoiInfo poiName(String str) {
        this.f6006b = str;
        return this;
    }

    public FavoritePoiInfo pt(LatLng latLng) {
        this.f6007c = latLng;
        return this;
    }

    public FavoritePoiInfo uid(String str) {
        this.f6010f = str;
        return this;
    }
}
