package com.amap.api.col.jmsl;

import android.graphics.Point;
import android.os.RemoteException;
import com.amap.api.maps.AMapCallback;
import com.amap.api.maps.model.LatLng;

/* renamed from: com.amap.api.col.jmsl.y1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC1627y1 {
    void a(LatLng latLng, AMapCallback<Point> aMapCallback) throws RemoteException;

    void b(Point point, AMapCallback<LatLng> aMapCallback) throws RemoteException;
}
