package com.baidu.mapapi.search.route;

import com.baidu.mapapi.model.LatLng;

/* loaded from: classes.dex */
public class IndoorPlanNode {

    /* renamed from: a, reason: collision with root package name */
    private LatLng f7481a;

    /* renamed from: b, reason: collision with root package name */
    private String f7482b;

    public IndoorPlanNode(LatLng latLng, String str) {
        this.f7481a = latLng;
        this.f7482b = str;
    }

    public String getFloor() {
        return this.f7482b;
    }

    public LatLng getLocation() {
        return this.f7481a;
    }
}
