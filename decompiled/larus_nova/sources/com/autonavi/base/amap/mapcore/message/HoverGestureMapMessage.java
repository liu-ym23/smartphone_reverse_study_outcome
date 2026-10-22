package com.autonavi.base.amap.mapcore.message;

import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.maploader.Pools;

/* JADX INFO: loaded from: classes39.dex */
public class HoverGestureMapMessage extends AbstractGestureMapMessage {
    private static final Pools.SynchronizedPool<HoverGestureMapMessage> M_POOL = null;
    public float angleDelta;

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage, com.autonavi.base.ae.gmap.AbstractMapMessage
    public int getType() {
        return 3;
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
    public void runCameraUpdate(GLMapState r100) {
        float r101 = r100.getCameraDegree() + this.angleDelta;
        if (r101 >= 0.0f) goto L6;
        r101 = 0.0f;
    L15:
        r100.setCameraDegree(r101);
        r100.recalculate();
        return;
    L6:
        if (r101 <= 80.0f) goto L9;
        r101 = 80.0f;
        goto L15
    L9:
        if (r100.getCameraDegree() <= 40.0f) goto L15;
        if (r101 <= 40.0f) goto L15;
        if (r100.getCameraDegree() <= r101) goto L15;
        r101 = 40.0f;
        goto L15
    }

    public HoverGestureMapMessage(int r100, float r101) {
        super(r100);
        this.angleDelta = r101;
    }

    public static HoverGestureMapMessage obtain(int r100, float r101) {
        HoverGestureMapMessage r102 = M_POOL.acquire();
        if (r102 != null) goto L5;
        r102 = new HoverGestureMapMessage(r100, r101);
    L6:
        r102.setParams(r100, r101);
        return r102;
    L5:
        r102.reset();
        goto L6
    }

    private void setParams(int r100, float r101) {
        setState(r100);
        this.angleDelta = r101;
    }
}
