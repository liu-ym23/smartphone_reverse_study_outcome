package com.baidu.platform.comapi.bmsdk;

import com.baidu.mapapi.map.Arc;
import com.baidu.platform.comapi.bmsdk.style.BmLineStyle;

/* loaded from: classes.dex */
public class BmArc extends BmDrawItem {

    /* renamed from: i, reason: collision with root package name */
    private Arc f8606i;

    public BmArc() {
        super(12, nativeCreate());
    }

    private static native long nativeCreate();

    private static native boolean nativeSetCenter(long j4, double d4, double d5, double d6);

    private static native boolean nativeSetClockwise(long j4, boolean z4);

    private static native boolean nativeSetEndRadian(long j4, double d4);

    private static native boolean nativeSetLineStyle(long j4, long j5);

    private static native boolean nativeSetPixelRadius(long j4, int i4);

    private static native boolean nativeSetRadius(long j4, double d4);

    private static native boolean nativeSetStartRadian(long j4, double d4);

    private static native boolean nativeSetTrackBy(long j4, int i4);

    public boolean a(b bVar) {
        if (bVar == null) {
            return false;
        }
        return nativeSetCenter(this.nativeInstance, bVar.f8679a, bVar.f8680b, 0.0d);
    }

    public boolean b(double d4) {
        return nativeSetRadius(this.nativeInstance, d4);
    }

    public Arc c() {
        return this.f8606i;
    }

    public void a(Arc arc) {
        this.f8606i = arc;
    }

    public boolean c(double d4) {
        return nativeSetStartRadian(this.nativeInstance, d4);
    }

    public boolean a(double d4) {
        return nativeSetEndRadian(this.nativeInstance, d4);
    }

    public boolean c(boolean z4) {
        return nativeSetClockwise(this.nativeInstance, z4);
    }

    public void a(BmLineStyle bmLineStyle) {
        if (bmLineStyle != null) {
            nativeSetLineStyle(this.nativeInstance, bmLineStyle.nativeInstance);
        } else {
            nativeSetLineStyle(this.nativeInstance, 0L);
        }
    }
}
