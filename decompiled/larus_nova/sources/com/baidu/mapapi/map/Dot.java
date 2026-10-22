package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;

/* JADX INFO: loaded from: classes39.dex */
public final class Dot extends Overlay {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    LatLng f30859g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f30860h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f30861i;

    public Dot() {
        this.type = com.baidu.mapsdkplatform.comapi.map.d.f32147g;
    }

    public LatLng getCenter() {
        return this.f30859g;
    }

    public int getColor() {
        return this.f30860h;
    }

    public int getRadius() {
        return this.f30861i;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle r100) {
        super.a(r100);
        GeoPoint r101 = CoordUtil.ll2mc(this.f30859g);
        r100.putDouble("location_x", r101.getLongitudeE6());
        r100.putDouble("location_y", r101.getLatitudeE6());
        r100.putInt("radius", this.f30861i);
        Overlay.d(this.f30860h, r100);
        return r100;
    }

    public void setCenter(LatLng r100) {
        if (r100 == null) goto L6;
        this.f30859g = r100;
        this.listener.c(this);
        return;
    L6:
        throw new IllegalArgumentException("BDMapSDKException: dot center can not be null");
    }

    public void setColor(int r100) {
        this.f30860h = r100;
        this.listener.c(this);
    }

    public void setRadius(int r100) {
        if (r100 <= 0) goto L5;
        this.f30861i = r100;
        this.listener.c(this);
        return;
    }
}
