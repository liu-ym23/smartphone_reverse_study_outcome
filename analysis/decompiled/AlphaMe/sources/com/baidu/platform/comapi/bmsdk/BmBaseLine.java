package com.baidu.platform.comapi.bmsdk;

import com.baidu.mapapi.map.Polyline;

/* loaded from: classes.dex */
public class BmBaseLine extends BmDrawItem {

    /* renamed from: i, reason: collision with root package name */
    private Polyline f8607i;

    private BmBaseLine() {
        super(7, 0L);
    }

    private static native boolean nativeAddGeoElement(long j4, long j5);

    private static native boolean nativeClearGeoElements(long j4);

    private static native boolean nativeSetBloomAlpha(long j4, float f4);

    private static native boolean nativeSetBloomBlurTimes(long j4, int i4);

    private static native boolean nativeSetBloomGradientASpeed(long j4, float f4);

    private static native boolean nativeSetBloomWidth(long j4, float f4);

    private static native boolean nativeSetCollisionBehavior(long j4, int i4);

    private static native boolean nativeSetCollisionTagId(long j4, int i4);

    private static native boolean nativeSetEndCapType(long j4, int i4);

    private static native boolean nativeSetGeoElement(long j4, long j5);

    private static native boolean nativeSetHighPrecision(long j4, boolean z4);

    private static native boolean nativeSetJointType(long j4, int i4);

    private static native boolean nativeSetLineBloomDirection(long j4, int i4);

    private static native boolean nativeSetLineBloomMode(long j4, int i4);

    private static native boolean nativeSetLineDirectionCrossType(long j4, int i4);

    private static native boolean nativeSetSmooth(long j4, int i4);

    private static native boolean nativeSetSmoothFactor(long j4, float f4);

    private static native boolean nativeSetStartCapType(long j4, int i4);

    private static native boolean nativeSetThin(long j4, int i4);

    private static native boolean nativeSetThinFactor(long j4, float f4);

    public void a(Polyline polyline) {
        this.f8607i = polyline;
    }

    public boolean b(float f4) {
        return nativeSetBloomAlpha(this.nativeInstance, f4);
    }

    public Polyline c() {
        return this.f8607i;
    }

    public boolean d(float f4) {
        return nativeSetBloomWidth(this.nativeInstance, f4);
    }

    public boolean e(float f4) {
        return nativeSetSmoothFactor(this.nativeInstance, f4);
    }

    public boolean f(float f4) {
        return nativeSetThinFactor(this.nativeInstance, f4);
    }

    public boolean g(int i4) {
        return nativeSetJointType(this.nativeInstance, i4);
    }

    public boolean h(int i4) {
        return nativeSetLineBloomDirection(this.nativeInstance, i4);
    }

    public boolean i(int i4) {
        return nativeSetLineBloomMode(this.nativeInstance, i4);
    }

    public boolean j(int i4) {
        return nativeSetLineDirectionCrossType(this.nativeInstance, i4);
    }

    public boolean k(int i4) {
        return nativeSetSmooth(this.nativeInstance, i4);
    }

    public boolean l(int i4) {
        return nativeSetStartCapType(this.nativeInstance, i4);
    }

    public boolean m(int i4) {
        return nativeSetThin(this.nativeInstance, i4);
    }

    public BmBaseLine(int i4, long j4) {
        super(i4, j4);
    }

    public boolean a(BmGeoElement bmGeoElement) {
        return nativeAddGeoElement(this.nativeInstance, bmGeoElement.getNativeInstance());
    }

    public boolean c(float f4) {
        return nativeSetBloomGradientASpeed(this.nativeInstance, f4);
    }

    public boolean e(int i4) {
        return nativeSetBloomBlurTimes(this.nativeInstance, i4);
    }

    public boolean f(int i4) {
        return nativeSetEndCapType(this.nativeInstance, i4);
    }

    public boolean c(boolean z4) {
        return nativeSetHighPrecision(this.nativeInstance, z4);
    }
}
