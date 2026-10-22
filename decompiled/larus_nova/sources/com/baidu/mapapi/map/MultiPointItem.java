package com.baidu.mapapi.map;

import com.baidu.mapapi.model.LatLng;

/* JADX INFO: loaded from: classes39.dex */
public final class MultiPointItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LatLng f31164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f31165b;

    public LatLng getPoint() {
        return this.f31164a;
    }

    public String getTitle() {
        return this.f31165b;
    }

    public MultiPointItem(LatLng r100) {
        if (r100 == null) goto L7;
        this.f31164a = r100;
        return;
    L7:
        throw new IllegalArgumentException("BDMapSDKException: MultiPointItem point can not be null");
    }

    public void setTitle(String r100) {
        this.f31165b = r100;
    }
}
