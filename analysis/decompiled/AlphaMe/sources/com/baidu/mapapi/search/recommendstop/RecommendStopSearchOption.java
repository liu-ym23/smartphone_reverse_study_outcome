package com.baidu.mapapi.search.recommendstop;

import com.baidu.mapapi.model.LatLng;

/* loaded from: classes.dex */
public class RecommendStopSearchOption {

    /* renamed from: a, reason: collision with root package name */
    private boolean f7441a = false;
    public LatLng mLocation;

    public LatLng getLocation() {
        return this.mLocation;
    }

    public boolean isNeedStationInfo() {
        return this.f7441a;
    }

    public RecommendStopSearchOption location(LatLng latLng) {
        this.mLocation = latLng;
        return this;
    }

    public RecommendStopSearchOption setNeedStationInfo(boolean z4) {
        this.f7441a = z4;
        return this;
    }
}
