package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.mapapi.model.LatLng;
import org.json.JSONException;

/* loaded from: classes.dex */
public final class UiSettings {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.mapsdkplatform.comapi.map.b f7077a;

    public UiSettings(com.baidu.mapsdkplatform.comapi.map.b bVar) {
        this.f7077a = bVar;
    }

    public boolean isCompassEnabled() {
        return this.f7077a.k();
    }

    public boolean isOverlookingGesturesEnabled() {
        return this.f7077a.N();
    }

    public boolean isRotateGesturesEnabled() {
        return this.f7077a.O();
    }

    public boolean isScrollGesturesEnabled() {
        return this.f7077a.Q();
    }

    public boolean isZoomGesturesEnabled() {
        return this.f7077a.S();
    }

    public void setAllGesturesEnabled(boolean z4) {
        setRotateGesturesEnabled(z4);
        setScrollGesturesEnabled(z4);
        setOverlookingGesturesEnabled(z4);
        setZoomGesturesEnabled(z4);
        setDoubleClickZoomEnabled(z4);
        setTwoTouchClickZoomEnabled(z4);
        setDoubleClickMoveZoomEnable(z4);
    }

    public void setCompassEnabled(boolean z4) throws JSONException {
        this.f7077a.f(z4);
    }

    public void setDoubleClickGesturesCenter(boolean z4) {
        this.f7077a.i(z4);
    }

    public void setDoubleClickMoveZoomEnable(boolean z4) {
        this.f7077a.j(z4);
    }

    public void setDoubleClickZoomEnabled(boolean z4) {
        this.f7077a.k(z4);
    }

    public void setEnlargeCenterWithDoubleClickEnable(boolean z4) {
        this.f7077a.l(z4);
    }

    public void setFlingEnable(boolean z4) {
        this.f7077a.m(z4);
    }

    public void setInertialAnimation(boolean z4) {
        this.f7077a.p(z4);
    }

    public void setLatLngGesturesCenter(LatLng latLng) {
        this.f7077a.a(latLng);
    }

    public void setOverlookingGesturesEnabled(boolean z4) {
        this.f7077a.u(z4);
    }

    public void setPointGesturesCenter(Point point) {
        this.f7077a.b(point);
    }

    public void setRotateGesturesEnabled(boolean z4) {
        this.f7077a.v(z4);
    }

    public void setScrollGesturesEnabled(boolean z4) {
        this.f7077a.y(z4);
    }

    public void setTwoTouchClickZoomEnabled(boolean z4) {
        this.f7077a.A(z4);
    }

    public void setZoomGesturesEnabled(boolean z4) {
        this.f7077a.B(z4);
    }
}
