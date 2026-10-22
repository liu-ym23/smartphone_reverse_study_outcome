package com.autonavi.base.amap.mapcore.message;

import android.graphics.Point;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.maploader.Pools;

/* JADX INFO: loaded from: classes39.dex */
public class ScaleGestureMapMessage extends AbstractGestureMapMessage {
    private static final Pools.SynchronizedPool<ScaleGestureMapMessage> M_POOL = null;
    public int pivotX;
    public int pivotY;
    public float scaleDelta;

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage, com.autonavi.base.ae.gmap.AbstractMapMessage
    public int getType() {
        return 1;
    }

    static {
        M_POOL = new Pools.SynchronizedPool(256);
    }

    public static void destory() {
        M_POOL.destory();
    }

    public void recycle() {
        M_POOL.release(this);
    }

    private void setMapZoomer(GLMapState r100) {
        float r101 = this.scaleDelta;
        r100.setMapZoomer(r100.getMapZoomer() + r101);
        r100.recalculate();
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage
    public void runCameraUpdate(GLMapState r100) {
        if (this.isUseAnchor == false) goto L6;
        setMapZoomer(r100);
        return;
    L6:
        int r101 = this.pivotX;
        int r102 = this.pivotY;
        if (this.isGestureScaleByMapCenter == false) goto L9;
        r101 = this.width >> 1;
        r102 = this.height >> 1;
    L9:
        if (r101 > 0) goto L13;
        if (r102 > 0) goto L13;
        IPoint r103 = null;
        IPoint r104 = null;
    L14:
        setMapZoomer(r100);
        if (r101 > 0) goto L17;
        if (r102 > 0) goto L17;
    L21:
        if (r103 == null) goto L23;
        r103.recycle();
    L23:
        if (r104 == null) goto L26;
        r104.recycle();
        return;
    L26:
        return;
    L17:
        win2geo(r100, r101, r102, r104);
        if (r103 == null) goto L20;
        r100.setMapGeoCenter((((Point) r103).x * 2) - ((Point) r104).x, (((Point) r103).y * 2) - ((Point) r104).y);
    L20:
        r100.recalculate();
    L13:
        r103 = IPoint.obtain();
        r104 = IPoint.obtain();
        win2geo(r100, r101, r102, r103);
        r100.setMapGeoCenter(((Point) r103).x, ((Point) r103).y);
        goto L14
    }

    public ScaleGestureMapMessage(int r100, float r101, int r102, int r103) {
        super(r100);
        this.scaleDelta = 0.0f;
        this.pivotX = 0;
        this.pivotY = 0;
        setParams(r100, r101, r102, r103);
    }

    public static ScaleGestureMapMessage obtain(int r100, float r101, int r102, int r103) {
        ScaleGestureMapMessage r104 = M_POOL.acquire();
        if (r104 == null) goto L7;
        r104.reset();
        r104.setParams(r100, r101, r102, r103);
        return r104;
    L7:
        return new ScaleGestureMapMessage(r100, r101, r102, r103);
    }

    private void setParams(int r100, float r101, int r102, int r103) {
        setState(r100);
        this.scaleDelta = r101;
        this.pivotX = r102;
        this.pivotY = r103;
    }
}
