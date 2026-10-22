package com.baidu.mapapi.utils.poi;

import com.baidu.mapapi.model.LatLng;

/* JADX INFO: loaded from: classes39.dex */
public class PoiParaOption {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f31740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f31741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    LatLng f31742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f31743d;

    public PoiParaOption() {
    }

    public LatLng getCenter() {
        return this.f31742c;
    }

    public String getKey() {
        return this.f31741b;
    }

    public int getRadius() {
        return this.f31743d;
    }

    public String getUid() {
        return this.f31740a;
    }

    public PoiParaOption center(LatLng r100) {
        this.f31742c = r100;
        return this;
    }

    public PoiParaOption key(String r100) {
        this.f31741b = r100;
        return this;
    }

    public PoiParaOption radius(int r100) {
        this.f31743d = r100;
        return this;
    }

    public PoiParaOption uid(String r100) {
        this.f31740a = r100;
        return this;
    }
}
