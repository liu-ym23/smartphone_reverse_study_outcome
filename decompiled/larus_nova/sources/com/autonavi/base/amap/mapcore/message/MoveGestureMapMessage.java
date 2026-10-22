package com.autonavi.base.amap.mapcore.message;

import android.graphics.Point;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.maploader.Pools;

/* JADX INFO: loaded from: classes39.dex */
public class MoveGestureMapMessage extends AbstractGestureMapMessage {
    private static final Pools.SynchronizedPool<MoveGestureMapMessage> M_POOL = null;
    static int newCount;
    public float touchDeltaX;
    public float touchDeltaY;
    public int touchX;
    public int touchY;

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage, com.autonavi.base.ae.gmap.AbstractMapMessage
    public int getType() {
        return 0;
    }

    static {
        M_POOL = new Pools.SynchronizedPool(1024);
    }

    public static void destory() {
        M_POOL.destory();
    }

    public void recycle() {
        M_POOL.release(this);
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage
    public void runCameraUpdate(GLMapState r100) {
        int r101 = (int) this.touchDeltaX;
        int r102 = (int) this.touchDeltaY;
        int r103 = this.touchX - r101;
        int r104 = this.touchY - r102;
        IPoint r105 = IPoint.obtain();
        win2geo(r100, this.touchX, this.touchY, r105);
        IPoint r106 = IPoint.obtain();
        win2geo(r100, r103, r104, r106);
        IPoint r107 = IPoint.obtain();
        r100.getMapGeoCenter(r107);
        r100.setMapGeoCenter(((Point) r107).x + (((Point) r106).x - ((Point) r105).x), ((Point) r107).y + (((Point) r106).y - ((Point) r105).y));
        r100.recalculate();
        r107.recycle();
        r105.recycle();
        r106.recycle();
    }

    public MoveGestureMapMessage(int r100, float r101, float r102) {
        super(r100);
        this.touchX = 0;
        this.touchY = 0;
        this.touchDeltaX = r101;
        this.touchDeltaY = r102;
        newCount++;
    }

    private void setParams(int r100, float r101, float r102) {
        setState(r100);
        this.touchDeltaX = r101;
        this.touchDeltaY = r102;
    }

    public static synchronized MoveGestureMapMessage obtain(int r100, float r101, float r102, float r103, float r104) {
        monitor-enter(MoveGestureMapMessage.class);
        MoveGestureMapMessage r105 = M_POOL.acquire();     // Catch: Throwable -> L11
        if (r105 != null) goto L7;
        r105 = new MoveGestureMapMessage(r100, r101, r102);     // Catch: Throwable -> L11
    L8:
        r105.touchX = (int) r103;     // Catch: Throwable -> L11
        r105.touchY = (int) r104;     // Catch: Throwable -> L11
        monitor-exit(MoveGestureMapMessage.class);
        return r105;
    L7:
        r105.reset();     // Catch: Throwable -> L11
        r105.setParams(r100, r101, r102);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
