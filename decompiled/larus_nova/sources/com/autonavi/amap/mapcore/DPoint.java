package com.autonavi.amap.mapcore;

import androidx.camera.video.AudioStats;
import com.autonavi.base.ae.gmap.maploader.Pools;

/* JADX INFO: loaded from: classes39.dex */
public class DPoint {
    private static final Pools.SynchronizedPool<DPoint> M_POOL = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public double f30021x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public double f30022y;

    static {
        M_POOL = new Pools.SynchronizedPool(32);
    }

    public static DPoint obtain() {
        DPoint r100 = M_POOL.acquire();
        if (r100 == null) goto L7;
        r100.set(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);
        return r100;
    L7:
        return new DPoint();
    }

    public void recycle() {
        M_POOL.release(this);
    }

    public DPoint() {
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DPoint) == true) goto L8;
        return false;
    L8:
        DPoint r101 = (DPoint) r100;
        if (Double.doubleToLongBits(this.f30021x) == Double.doubleToLongBits(r101.f30021x)) goto L11;
    L13:
        return false;
    L11:
        if (Double.doubleToLongBits(this.f30022y) != Double.doubleToLongBits(r101.f30022y)) goto L13;
        return true;
    }

    public DPoint(double r100, double r101) {
        this.f30021x = r100;
        this.f30022y = r101;
    }

    public static DPoint obtain(double r100, double r101) {
        DPoint r102 = M_POOL.acquire();
        if (r102 == null) goto L7;
        r102.set(r100, r101);
        return r102;
    L7:
        return new DPoint(r100, r101);
    }

    private void set(double r100, double r101) {
        this.f30021x = r100;
        this.f30022y = r101;
    }
}
