package com.baidu.mapapi.navi;

import com.baidu.mapapi.model.LatLng;

/* JADX INFO: loaded from: classes39.dex */
public class WayPointInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f31699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LatLng f31700b;

    public WayPointInfo() {
    }

    public LatLng getLatLng() {
        return this.f31700b;
    }

    public String getWayPointName() {
        return this.f31699a;
    }

    public WayPointInfo setLatLng(LatLng r100) {
        if (r100 == null) goto L6;
        this.f31700b = r100;
        return this;
    L6:
        throw new IllegalStateException("BDMapSDKException: The latitude and longitude of the waypoint cannot be null");
    }

    public WayPointInfo setWayPointName(String r100) {
        this.f31699a = r100;
        return this;
    }
}
