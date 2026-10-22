package com.autonavi.base.amap.mapcore.message;

import android.graphics.Point;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.maploader.Pools;

/* JADX INFO: loaded from: classes39.dex */
public class RotateGestureMapMessage extends AbstractGestureMapMessage {
    private static final Pools.SynchronizedPool<RotateGestureMapMessage> M_POOL = null;
    public float angleDelta;
    public int pivotX;
    public int pivotY;

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage, com.autonavi.base.ae.gmap.AbstractMapMessage
    public int getType() {
        return 2;
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

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage
    public void runCameraUpdate(GLMapState r110) {
        float r100 = r110.getMapAngle() + this.angleDelta;
        if (this.isGestureScaleByMapCenter == false) goto L6;
        r110.setMapAngle(r100);
        r110.recalculate();
        return;
    L6:
        int r101 = this.pivotX;
        int r102 = this.pivotY;
        if (this.isUseAnchor == false) goto L9;
        r101 = this.anchorX;
        r102 = this.anchorY;
    L9:
        if (r101 > 0) goto L13;
        if (r102 > 0) goto L13;
        IPoint r103 = null;
        IPoint r104 = null;
    L14:
        r110.setMapAngle(r100);
        r110.recalculate();
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
        win2geo(r110, r101, r102, r104);
        if (r103 == null) goto L20;
        r110.setMapGeoCenter((((Point) r103).x * 2) - ((Point) r104).x, (((Point) r103).y * 2) - ((Point) r104).y);
    L20:
        r110.recalculate();
    L13:
        r103 = IPoint.obtain();
        r104 = IPoint.obtain();
        win2geo(r110, r101, r102, r103);
        r110.setMapGeoCenter(((Point) r103).x, ((Point) r103).y);
        goto L14
    }

    public RotateGestureMapMessage(int r100, float r101, int r102, int r103) {
        super(r100);
        this.pivotX = 0;
        this.pivotY = 0;
        this.angleDelta = 0.0f;
        setParams(r100, r101, r102, r103);
        this.angleDelta = r101;
        this.pivotX = r102;
        this.pivotY = r103;
    }

    public static RotateGestureMapMessage obtain(int r100, float r101, int r102, int r103) {
        RotateGestureMapMessage r104 = M_POOL.acquire();
        if (r104 == null) goto L7;
        r104.reset();
        r104.setParams(r100, r101, r102, r103);
        return r104;
    L7:
        return new RotateGestureMapMessage(r100, r101, r102, r103);
    }

    private void setParams(int r100, float r101, int r102, int r103) {
        setState(r100);
        this.angleDelta = r101;
        this.pivotX = r102;
        this.pivotY = r103;
    }
}
