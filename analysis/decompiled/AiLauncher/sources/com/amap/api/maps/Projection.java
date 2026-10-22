package com.amap.api.maps;

import android.graphics.Point;
import com.amap.api.col.jmsl.InterfaceC1627y1;
import com.amap.api.maps.model.LatLng;

/* loaded from: classes.dex */
public class Projection {
    private final InterfaceC1627y1 projectionDelegate;

    public Projection(InterfaceC1627y1 interfaceC1627y1) {
        this.projectionDelegate = interfaceC1627y1;
    }

    public void fromScreenLocation(Point point, AMapCallback<LatLng> aMapCallback) {
        try {
            this.projectionDelegate.b(point, aMapCallback);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void toScreenLocation(LatLng latLng, AMapCallback<Point> aMapCallback) {
        try {
            this.projectionDelegate.a(latLng, aMapCallback);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
