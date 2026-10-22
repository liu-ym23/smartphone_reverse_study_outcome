package com.baidu.platform.comapi.bmsdk;

import com.baidu.mapapi.map.Polygon;
import com.baidu.platform.comapi.bmsdk.style.BmSurfaceStyle;

/* loaded from: classes.dex */
public class BmPolygon extends BmDrawItem {

    /* renamed from: i, reason: collision with root package name */
    private Polygon f8652i;

    public BmPolygon() {
        super(10, nativeCreate());
    }

    private static native boolean nativeAddGeoElement(long j4, long j5);

    private static native boolean nativeAddHoleGeoElement(long j4, long j5);

    private static native boolean nativeClearGeoElements(long j4);

    private static native long nativeCreate();

    private static native boolean nativeSetBloomAlpha(long j4, float f4);

    private static native boolean nativeSetBloomBlurTimes(long j4, int i4);

    private static native boolean nativeSetBloomGradientASpeed(long j4, float f4);

    private static native boolean nativeSetBloomWidth(long j4, float f4);

    private static native boolean nativeSetDrawFullscreenMaskFlag(long j4, boolean z4);

    private static native boolean nativeSetJointType(long j4, int i4);

    private static native boolean nativeSetLineBloomDirection(long j4, int i4);

    private static native boolean nativeSetLineBloomMode(long j4, int i4);

    private static native boolean nativeSetSurfaceStyle(long j4, long j5);

    private static native boolean nativeSetThin(long j4, int i4);

    private static native boolean nativeSetThinFactor(long j4, float f4);

    public void a(Polygon polygon) {
        this.f8652i = polygon;
    }

    public boolean b(BmGeoElement bmGeoElement) {
        return nativeAddHoleGeoElement(this.nativeInstance, bmGeoElement.getNativeInstance());
    }

    public boolean c() {
        return nativeClearGeoElements(this.nativeInstance);
    }

    public Polygon d() {
        return this.f8652i;
    }

    public boolean e(float f4) {
        return nativeSetThinFactor(this.nativeInstance, f4);
    }

    public boolean f(int i4) {
        return nativeSetJointType(this.nativeInstance, i4);
    }

    public boolean g(int i4) {
        return nativeSetLineBloomDirection(this.nativeInstance, i4);
    }

    public boolean h(int i4) {
        return nativeSetLineBloomMode(this.nativeInstance, i4);
    }

    public boolean i(int i4) {
        return nativeSetThin(this.nativeInstance, i4);
    }

    public boolean a(BmGeoElement bmGeoElement) {
        return nativeAddGeoElement(this.nativeInstance, bmGeoElement.getNativeInstance());
    }

    public boolean b(float f4) {
        return nativeSetBloomAlpha(this.nativeInstance, f4);
    }

    public boolean c(float f4) {
        return nativeSetBloomGradientASpeed(this.nativeInstance, f4);
    }

    public boolean d(float f4) {
        return nativeSetBloomWidth(this.nativeInstance, f4);
    }

    public boolean e(int i4) {
        return nativeSetBloomBlurTimes(this.nativeInstance, i4);
    }

    public void a(BmSurfaceStyle bmSurfaceStyle) {
        if (bmSurfaceStyle != null) {
            nativeSetSurfaceStyle(this.nativeInstance, bmSurfaceStyle.nativeInstance);
        } else {
            nativeSetSurfaceStyle(this.nativeInstance, 0L);
        }
    }
}
