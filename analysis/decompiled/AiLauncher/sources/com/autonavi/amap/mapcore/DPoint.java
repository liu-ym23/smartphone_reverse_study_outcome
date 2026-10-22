package com.autonavi.amap.mapcore;

import com.autonavi.amap.mapcore.Pools;
import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes.dex */
public class DPoint {
    private static final Pools.SynchronizedPool<DPoint> M_POOL = new Pools.SynchronizedPool<>(32);

    /* renamed from: x, reason: collision with root package name */
    public double f18178x;

    /* renamed from: y, reason: collision with root package name */
    public double f18179y;

    public DPoint() {
    }

    public static DPoint obtain() {
        DPoint dPointAcquire = M_POOL.acquire();
        if (dPointAcquire == null) {
            return new DPoint();
        }
        dPointAcquire.set(0.0d, 0.0d);
        return dPointAcquire;
    }

    private void set(double d10, double d11) {
        this.f18178x = d10;
        this.f18179y = d11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DPoint)) {
            return false;
        }
        DPoint dPoint = (DPoint) obj;
        return Double.doubleToLongBits(this.f18178x) == Double.doubleToLongBits(dPoint.f18178x) && Double.doubleToLongBits(this.f18179y) == Double.doubleToLongBits(dPoint.f18179y);
    }

    public void recycle() {
        M_POOL.release(this);
    }

    public String toString() {
        return "[" + this.f18179y + Const.STR_MART_COMMA + this.f18178x + "]";
    }

    public DPoint(double d10, double d11) {
        this.f18178x = d10;
        this.f18179y = d11;
    }

    public static DPoint obtain(double d10, double d11) {
        DPoint dPointAcquire = M_POOL.acquire();
        if (dPointAcquire == null) {
            return new DPoint(d10, d11);
        }
        dPointAcquire.set(d10, d11);
        return dPointAcquire;
    }
}
