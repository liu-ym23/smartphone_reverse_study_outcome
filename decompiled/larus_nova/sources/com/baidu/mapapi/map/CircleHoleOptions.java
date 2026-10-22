package com.baidu.mapapi.map;

import com.baidu.mapapi.model.LatLng;
import com.lynx.serval.svg.SVGRenderEngine;

/* JADX INFO: loaded from: classes39.dex */
public class CircleHoleOptions extends HoleOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LatLng f30832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f30833b;

    public CircleHoleOptions() {
        this.mHoleType = SVGRenderEngine.CIRCLE;
    }

    public LatLng getHoleCenter() {
        return this.f30832a;
    }

    public int getHoleRadius() {
        return this.f30833b;
    }

    public CircleHoleOptions center(LatLng r100) {
        if (r100 != null) goto L4;
        return this;
    L4:
        this.f30832a = r100;
        return this;
    }

    public CircleHoleOptions radius(int r100) {
        if (r100 > 0) goto L4;
        return this;
    L4:
        this.f30833b = r100;
        return this;
    }
}
