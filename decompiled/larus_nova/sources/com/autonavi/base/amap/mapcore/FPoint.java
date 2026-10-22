package com.autonavi.base.amap.mapcore;

import android.graphics.PointF;
import com.autonavi.base.ae.gmap.maploader.Pools;

/* JADX INFO: loaded from: classes39.dex */
public class FPoint extends PointF {
    private static final Pools.SynchronizedPool<FPoint> M_POOL = null;

    static {
        M_POOL = new Pools.SynchronizedPool(32);
    }

    public static FPoint obtain() {
        FPoint r100 = M_POOL.acquire();
        if (r100 == null) goto L7;
        r100.set(0.0f, 0.0f);
        return r100;
    L7:
        return new FPoint();
    }

    @Override // android.graphics.PointF
    public int hashCode() {
        Float.floatToIntBits(((PointF) this).x);
        return Float.floatToIntBits(((PointF) this).y) * 37;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    public FPoint() {
    }

    @Override // android.graphics.PointF
    public boolean equals(Object r100) {
        FPoint r101 = (FPoint) r100;
        if (r101 != null) goto L6;
        return false;
    L6:
        if (((PointF) this).x == ((PointF) r101).x) goto L8;
        return false;
    L8:
        if (((PointF) this).y != ((PointF) r101).y) goto L12;
        return true;
    L12:
        return false;
    }

    public FPoint(float r100, float r101) {
        ((PointF) this).x = r100;
        ((PointF) this).y = r101;
    }

    public static FPoint obtain(float r100, float r101) {
        FPoint r102 = M_POOL.acquire();
        if (r102 == null) goto L7;
        r102.set(r100, r101);
        return r102;
    L7:
        return new FPoint(r100, r101);
    }
}
