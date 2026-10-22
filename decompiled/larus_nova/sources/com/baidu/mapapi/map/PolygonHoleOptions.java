package com.baidu.mapapi.map;

import com.baidu.mapapi.model.LatLng;
import com.lynx.serval.svg.SVGRenderEngine;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class PolygonHoleOptions extends HoleOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<LatLng> f31234a;

    public PolygonHoleOptions() {
        this.mHoleType = SVGRenderEngine.POLYGON;
    }

    public List<LatLng> getHolePoints() {
        return this.f31234a;
    }

    public PolygonHoleOptions addPoints(List<LatLng> r100) {
        if (r100 != null) goto L4;
    L7:
        return this;
    L4:
        if (r100.size() < 3) goto L7;
        this.f31234a = r100;
        goto L7
    }
}
