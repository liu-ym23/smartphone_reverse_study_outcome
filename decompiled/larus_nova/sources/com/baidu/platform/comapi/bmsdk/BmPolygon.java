package com.baidu.platform.comapi.bmsdk;

import com.baidu.mapapi.map.Polygon;
import com.baidu.platform.comapi.bmsdk.style.BmSurfaceStyle;

/* JADX INFO: loaded from: classes39.dex */
public class BmPolygon extends BmDrawItem {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Polygon f32790i;

    private static native boolean nativeAddGeoElement(long r100, long r101);

    private static native boolean nativeAddHoleGeoElement(long r100, long r101);

    private static native boolean nativeClearGeoElements(long r100);

    private static native long nativeCreate();

    private static native boolean nativeSetBloomAlpha(long r100, float r101);

    private static native boolean nativeSetBloomBlurTimes(long r100, int r101);

    private static native boolean nativeSetBloomGradientASpeed(long r100, float r101);

    private static native boolean nativeSetBloomWidth(long r100, float r101);

    private static native boolean nativeSetDrawFullscreenMaskFlag(long r100, boolean r101);

    private static native boolean nativeSetJointType(long r100, int r101);

    private static native boolean nativeSetLineBloomDirection(long r100, int r101);

    private static native boolean nativeSetLineBloomMode(long r100, int r101);

    private static native boolean nativeSetSurfaceStyle(long r100, long r101);

    private static native boolean nativeSetThin(long r100, int r101);

    private static native boolean nativeSetThinFactor(long r100, float r101);

    public BmPolygon() {
        super(10, nativeCreate());
    }

    public boolean c() {
        return nativeClearGeoElements(getNativeInstance());
    }

    public Polygon d() {
        return this.f32790i;
    }

    public void a(BmSurfaceStyle r100) {
        if (r100 == null) goto L4;
        nativeSetSurfaceStyle(getNativeInstance(), r100.getNativeInstance());
        return;
    L4:
        nativeSetSurfaceStyle(getNativeInstance(), 0);
    }

    public boolean b(BmGeoElement r100) {
        return nativeAddHoleGeoElement(getNativeInstance(), r100.getNativeInstance());
    }

    public boolean c(float r100) {
        return nativeSetBloomGradientASpeed(getNativeInstance(), r100);
    }

    public boolean d(float r100) {
        return nativeSetBloomWidth(getNativeInstance(), r100);
    }

    public boolean e(float r100) {
        return nativeSetThinFactor(getNativeInstance(), r100);
    }

    public boolean f(int r100) {
        return nativeSetJointType(getNativeInstance(), r100);
    }

    public boolean g(int r100) {
        return nativeSetLineBloomDirection(getNativeInstance(), r100);
    }

    public boolean h(int r100) {
        return nativeSetLineBloomMode(getNativeInstance(), r100);
    }

    public boolean i(int r100) {
        return nativeSetThin(getNativeInstance(), r100);
    }

    public boolean a(BmGeoElement r100) {
        return nativeAddGeoElement(getNativeInstance(), r100.getNativeInstance());
    }

    public boolean b(float r100) {
        return nativeSetBloomAlpha(getNativeInstance(), r100);
    }

    public boolean e(int r100) {
        return nativeSetBloomBlurTimes(getNativeInstance(), r100);
    }

    public void a(Polygon r100) {
        this.f32790i = r100;
    }
}
