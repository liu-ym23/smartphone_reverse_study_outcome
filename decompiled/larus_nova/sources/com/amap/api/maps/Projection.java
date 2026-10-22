package com.amap.api.maps;

import android.graphics.Point;
import android.graphics.PointF;
import com.amap.api.maps.model.AMapCameraInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.TileProjection;
import com.amap.api.maps.model.VisibleRegion;
import com.autonavi.amap.mapcore.interfaces.IProjection;

/* JADX INFO: loaded from: classes28.dex */
public class Projection {
    private final IProjection projectionDelegate;

    public AMapCameraInfo getCameraInfo() {
        return this.projectionDelegate.getCameraInfo();
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public VisibleRegion getVisibleRegion() {
        return this.projectionDelegate.getVisibleRegion();
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public Projection(IProjection r100) {
        this.projectionDelegate = r100;
    }

    public LatLng fromScreenLocation(Point r100) {
        return this.projectionDelegate.fromScreenLocation(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public PointF toMapLocation(LatLng r100) {
        return this.projectionDelegate.toMapLocation(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public PointF toOpenGLLocation(LatLng r100) {
        return this.projectionDelegate.toMapLocation(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public float toOpenGLWidth(int r100) {
        return this.projectionDelegate.toMapLenWithWin(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return 0.0f;
    }

    public Point toScreenLocation(LatLng r100) {
        return this.projectionDelegate.toScreenLocation(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public float calZoomByTargetPos(LatLng r100, int r101) {
        return this.projectionDelegate.calculateMapZoomer(r100, r101);
    L4:
        th = move-exception;
        th.printStackTrace();
        return 3.0f;
    }

    public LatLngBounds getMapBounds(LatLng r100, float r101) {
        return this.projectionDelegate.getMapBounds(r100, r101);
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public TileProjection fromBoundsToTile(LatLngBounds r100, int r101, int r102) {
        return this.projectionDelegate.fromBoundsToTile(r100, r101, r102);
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }
}
