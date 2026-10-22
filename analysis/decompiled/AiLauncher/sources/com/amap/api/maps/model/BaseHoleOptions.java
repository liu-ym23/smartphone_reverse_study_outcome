package com.amap.api.maps.model;

import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseHoleOptions extends BaseOptions {
    protected boolean isPolygonHoleOptions = true;

    public abstract List<LatLng> getPoints();
}
