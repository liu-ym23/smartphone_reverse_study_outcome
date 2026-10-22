package com.autonavi.amap.mapcore;

import android.graphics.Point;
import com.autonavi.base.ae.gmap.maploader.Pools;

/* JADX INFO: loaded from: classes39.dex */
public class IPoint extends Point implements Cloneable {
    private static final Pools.SynchronizedPool<IPoint> M_POOL = null;

    static {
        M_POOL = new Pools.SynchronizedPool(32);
    }

    public static IPoint obtain() {
        IPoint r100 = M_POOL.acquire();
        if (r100 == null) goto L7;
        r100.set(0, 0);
        return r100;
    L7:
        return new IPoint();
    }

    public void recycle() {
        M_POOL.release(this);
    }

    public Object clone() {
        return (IPoint) super.clone();
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public IPoint() {
    }

    public double distance(IPoint r100) {
        return Math.sqrt(Math.pow(((Point) r100).x - ((Point) this).x, 2.0d) + Math.pow(((Point) r100).y - ((Point) this).y, 2.0d));
    }

    public IPoint(int r100, int r101) {
        ((Point) this).x = r100;
        ((Point) this).y = r101;
    }

    public static IPoint obtain(int r100, int r101) {
        IPoint r102 = M_POOL.acquire();
        if (r102 == null) goto L7;
        r102.set(r100, r101);
        return r102;
    L7:
        return new IPoint(r100, r101);
    }
}
