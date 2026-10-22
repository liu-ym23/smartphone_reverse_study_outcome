package com.autonavi.amap.mapcore.interfaces;

import android.graphics.Point;
import android.graphics.PointF;
import android.os.RemoteException;
import com.amap.api.maps.model.AMapCameraInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.TileProjection;
import com.amap.api.maps.model.VisibleRegion;

/* JADX INFO: loaded from: classes39.dex */
public interface IProjection {
    float calculateMapZoomer(LatLng r100, int r101);

    TileProjection fromBoundsToTile(LatLngBounds r100, int r101, int r102) throws RemoteException;

    LatLng fromScreenLocation(Point r100) throws RemoteException;

    AMapCameraInfo getCameraInfo();

    LatLngBounds getMapBounds(LatLng r100, float r101) throws RemoteException;

    VisibleRegion getVisibleRegion() throws RemoteException;

    float toMapLenWithWin(int r100) throws RemoteException;

    PointF toMapLocation(LatLng r100) throws RemoteException;

    Point toScreenLocation(LatLng r100) throws RemoteException;
}
