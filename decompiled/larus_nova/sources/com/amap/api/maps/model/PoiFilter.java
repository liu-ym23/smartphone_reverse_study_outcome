package com.amap.api.maps.model;

import android.graphics.Point;
import com.amap.api.maps.AMap;
import com.amap.api.maps.Projection;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class PoiFilter {
    public static final int FilterTypeAll = -1;
    public static final int FilterTypeLabel3rd = 8;
    public static final int FilterTypePoi = 1;
    public static final int FilterTypeRoadName = 2;
    public static final int FilterTypeRoadShield = 4;
    public int mFilterType;
    public String mKeyName;
    public List<LatLng> mPosition;

    public PoiFilter() {
        this.mPosition = new ArrayList();
    }

    public static PoiFilter createPoiFilterByCenter(AMap r100, LatLng r101, int r102, String r103, int r104, int r105) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Projection r106 = r100.getProjection();
        if (r106 != null) goto L8;
        return null;
    L8:
        PoiFilter r107 = new PoiFilter();
        r107.mFilterType = r102;
        r107.mKeyName = r103;
        Point r108 = r100.getProjection().toScreenLocation(r101);
        Point r109 = new Point();
        int r110 = r104 / 2;
        r109.x = r108.x - r110;
        int r111 = r105 / 2;
        r109.y = r108.y - r111;
        Point r112 = new Point();
        r112.x = r108.x + r110;
        r112.y = r108.y - r111;
        Point r113 = new Point();
        r113.x = r108.x - r110;
        r113.y = r108.y + r111;
        Point r114 = new Point();
        r114.x = r108.x + r110;
        r114.y = r108.y + r111;
        r107.mPosition.add(r106.fromScreenLocation(r109));
        r107.mPosition.add(r106.fromScreenLocation(r112));
        r107.mPosition.add(r106.fromScreenLocation(r114));
        r107.mPosition.add(r106.fromScreenLocation(r113));
        return r107;
    }
}
