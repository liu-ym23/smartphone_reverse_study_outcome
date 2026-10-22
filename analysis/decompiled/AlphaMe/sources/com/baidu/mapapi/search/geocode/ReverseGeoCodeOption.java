package com.baidu.mapapi.search.geocode;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.base.LanguageType;

/* loaded from: classes.dex */
public class ReverseGeoCodeOption {

    /* renamed from: a, reason: collision with root package name */
    private int f7369a = 10;

    /* renamed from: b, reason: collision with root package name */
    private int f7370b = 0;

    /* renamed from: c, reason: collision with root package name */
    private LatLng f7371c = null;

    /* renamed from: d, reason: collision with root package name */
    private int f7372d = 1;

    /* renamed from: e, reason: collision with root package name */
    private int f7373e = 1000;

    /* renamed from: f, reason: collision with root package name */
    private String f7374f = null;

    /* renamed from: g, reason: collision with root package name */
    private boolean f7375g = false;

    /* renamed from: h, reason: collision with root package name */
    private LanguageType f7376h = LanguageType.LanguageTypeChinese;

    public ReverseGeoCodeOption extensionsRoad(boolean z4) {
        this.f7375g = z4;
        return this;
    }

    public boolean getExtensionsRoad() {
        return this.f7375g;
    }

    public LanguageType getLanguage() {
        return this.f7376h;
    }

    public int getLatestAdmin() {
        return this.f7372d;
    }

    public LatLng getLocation() {
        return this.f7371c;
    }

    public int getPageNum() {
        return this.f7370b;
    }

    public int getPageSize() {
        return this.f7369a;
    }

    public String getPoiType() {
        return this.f7374f;
    }

    public int getRadius() {
        return this.f7373e;
    }

    public ReverseGeoCodeOption language(LanguageType languageType) {
        this.f7376h = languageType;
        return this;
    }

    public ReverseGeoCodeOption location(LatLng latLng) {
        this.f7371c = latLng;
        return this;
    }

    public ReverseGeoCodeOption newVersion(int i4) {
        this.f7372d = i4;
        return this;
    }

    public ReverseGeoCodeOption pageNum(int i4) {
        if (i4 < 0) {
            i4 = 0;
        }
        this.f7370b = i4;
        return this;
    }

    public ReverseGeoCodeOption pageSize(int i4) {
        if (i4 <= 0) {
            this.f7369a = 10;
        } else if (i4 > 100) {
            this.f7369a = 100;
        } else {
            this.f7369a = i4;
        }
        return this;
    }

    public ReverseGeoCodeOption poiType(String str) {
        this.f7374f = str;
        return this;
    }

    public ReverseGeoCodeOption radius(int i4) {
        if (i4 < 0) {
            this.f7373e = 0;
        } else if (i4 > 1000) {
            this.f7373e = 1000;
        } else {
            this.f7373e = i4;
        }
        return this;
    }
}
