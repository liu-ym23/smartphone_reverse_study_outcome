package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.mapapi.model.LatLng;

/* JADX INFO: loaded from: classes39.dex */
public final class UiSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.baidu.mapsdkplatform.comapi.map.b f31519a;

    public boolean isCompassEnabled() {
        return this.f31519a.k();
    }

    public boolean isOverlookingGesturesEnabled() {
        return this.f31519a.O();
    }

    public boolean isRotateGesturesEnabled() {
        return this.f31519a.P();
    }

    public boolean isScrollGesturesEnabled() {
        return this.f31519a.R();
    }

    public boolean isZoomGesturesEnabled() {
        return this.f31519a.T();
    }

    public UiSettings(com.baidu.mapsdkplatform.comapi.map.b r100) {
        this.f31519a = r100;
    }

    public void setAllGesturesEnabled(boolean r100) {
        setRotateGesturesEnabled(r100);
        setScrollGesturesEnabled(r100);
        setOverlookingGesturesEnabled(r100);
        setZoomGesturesEnabled(r100);
        setDoubleClickZoomEnabled(r100);
        setTwoTouchClickZoomEnabled(r100);
        setDoubleClickMoveZoomEnable(r100);
    }

    public void setCompassEnabled(boolean r100) {
        this.f31519a.f(r100);
    }

    public void setDoubleClickGesturesCenter(boolean r100) {
        this.f31519a.j(r100);
    }

    public void setDoubleClickMoveZoomEnable(boolean r100) {
        this.f31519a.k(r100);
    }

    public void setDoubleClickZoomEnabled(boolean r100) {
        this.f31519a.l(r100);
    }

    public void setEnlargeCenterWithDoubleClickEnable(boolean r100) {
        this.f31519a.m(r100);
    }

    public void setFlingEnable(boolean r100) {
        this.f31519a.n(r100);
    }

    public void setInertialAnimation(boolean r100) {
        this.f31519a.q(r100);
    }

    public void setLatLngGesturesCenter(LatLng r100) {
        this.f31519a.a(r100);
    }

    public void setOverlookingGesturesEnabled(boolean r100) {
        this.f31519a.v(r100);
    }

    public void setPointGesturesCenter(Point r100) {
        this.f31519a.b(r100);
    }

    public void setRotateGesturesEnabled(boolean r100) {
        this.f31519a.w(r100);
    }

    public void setScrollGesturesEnabled(boolean r100) {
        this.f31519a.z(r100);
    }

    public void setTwoTouchClickZoomEnabled(boolean r100) {
        this.f31519a.B(r100);
    }

    public void setZoomGesturesEnabled(boolean r100) {
        this.f31519a.C(r100);
    }
}
