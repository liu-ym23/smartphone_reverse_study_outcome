package com.baidu.mapapi.map;

import com.baidu.mapapi.model.LatLng;

/* loaded from: classes.dex */
public final class MultiPointItem {

    /* renamed from: a, reason: collision with root package name */
    private LatLng f6686a;

    /* renamed from: b, reason: collision with root package name */
    private String f6687b;

    public MultiPointItem(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: MultiPointItem point can not be null");
        }
        this.f6686a = latLng;
    }

    public LatLng getPoint() {
        return this.f6686a;
    }

    public String getTitle() {
        return this.f6687b;
    }

    public void setTitle(String str) {
        this.f6687b = str;
    }
}
