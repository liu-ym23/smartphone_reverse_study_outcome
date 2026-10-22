package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.stepos.alphame.sleep.SleepModeData;

/* loaded from: classes.dex */
public final class Dot extends Overlay {

    /* renamed from: g, reason: collision with root package name */
    LatLng f6340g;

    /* renamed from: h, reason: collision with root package name */
    int f6341h;

    /* renamed from: i, reason: collision with root package name */
    int f6342i;

    public Dot() {
        this.type = com.baidu.mapsdkplatform.comapi.map.d.dot;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.f6340g);
        bundle.putDouble(SleepModeData.LOCATION_X, geoPointLl2mc.getLongitudeE6());
        bundle.putDouble(SleepModeData.LOCATION_Y, geoPointLl2mc.getLatitudeE6());
        bundle.putInt("radius", this.f6342i);
        Overlay.d(this.f6341h, bundle);
        return bundle;
    }

    public LatLng getCenter() {
        return this.f6340g;
    }

    public int getColor() {
        return this.f6341h;
    }

    public int getRadius() {
        return this.f6342i;
    }

    public void setCenter(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: dot center can not be null");
        }
        this.f6340g = latLng;
        this.listener.c(this);
    }

    public void setColor(int i4) {
        this.f6341h = i4;
        this.listener.c(this);
    }

    public void setRadius(int i4) {
        if (i4 > 0) {
            this.f6342i = i4;
            this.listener.c(this);
        }
    }
}
