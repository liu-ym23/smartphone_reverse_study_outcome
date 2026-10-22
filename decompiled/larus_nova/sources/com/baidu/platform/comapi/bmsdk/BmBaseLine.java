package com.baidu.platform.comapi.bmsdk;

import com.baidu.mapapi.map.Polyline;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class BmBaseLine extends BmDrawItem {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Polyline f32744i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<BmGeoElement> f32745j;

    private BmBaseLine() {
        super(7, 0);
        this.f32745j = new ArrayList();
    }

    private static native boolean nativeAddGeoElement(long r100, long r101);

    private static native boolean nativeClearGeoElements(long r100);

    private static native boolean nativeDeleteGeoElement(long r100, long r101);

    private static native boolean nativeSetBloomAlpha(long r100, float r101);

    private static native boolean nativeSetBloomBlurTimes(long r100, int r101);

    private static native boolean nativeSetBloomGradientASpeed(long r100, float r101);

    private static native boolean nativeSetBloomWidth(long r100, float r101);

    private static native boolean nativeSetCollisionBehavior(long r100, int r101);

    private static native boolean nativeSetCollisionTagId(long r100, int r101);

    private static native boolean nativeSetEndCapType(long r100, int r101);

    private static native boolean nativeSetGeoElement(long r100, long r101);

    private static native boolean nativeSetHighPrecision(long r100, boolean r101);

    private static native boolean nativeSetJointType(long r100, int r101);

    private static native boolean nativeSetLineBloomDirection(long r100, int r101);

    private static native boolean nativeSetLineBloomMode(long r100, int r101);

    private static native boolean nativeSetLineDirectionCrossType(long r100, int r101);

    private static native boolean nativeSetSmooth(long r100, int r101);

    private static native boolean nativeSetSmoothFactor(long r100, float r101);

    private static native boolean nativeSetStartCapType(long r100, int r101);

    private static native boolean nativeSetThin(long r100, int r101);

    private static native boolean nativeSetThinFactor(long r100, float r101);

    public boolean c() {
        List<BmGeoElement> r100 = this.f32745j;
        if (r100 == null) goto L13;
        Iterator<BmGeoElement> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L11;
        r101.next().close();     // Catch: Exception -> L10
        goto L6
    L11:
        this.f32745j.clear();
    L13:
        return nativeClearGeoElements(getNativeInstance());
    }

    @Override // com.baidu.platform.comapi.bmsdk.BmDrawItem, com.baidu.platform.comapi.bmsdk.BmObject, java.lang.AutoCloseable
    public void close() throws Exception {
        super.close();
        List<BmGeoElement> r100 = this.f32745j;
        if (r100 == null) goto L19;
        Iterator<BmGeoElement> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L11;
        r101.next().close();     // Catch: Exception -> L10
        goto L6
    L11:
        this.f32745j.clear();
        this.f32745j = null;
        return;
    }

    public Polyline d() {
        return this.f32744i;
    }

    public boolean a(BmGeoElement r100) {
        List<BmGeoElement> r101 = this.f32745j;
        if (r101 == null) goto L6;
        r101.add(r100);
    L6:
        return nativeAddGeoElement(getNativeInstance(), r100.getNativeInstance());
    }

    public boolean b(BmGeoElement r100) {
        boolean r101 = nativeDeleteGeoElement(getNativeInstance(), r100.getNativeInstance());
        r100.close();     // Catch: Exception -> L5
    L4:
        return r101;
    }

    public boolean c(float r100) {
        return nativeSetBloomGradientASpeed(getNativeInstance(), r100);
    }

    public boolean d(float r100) {
        return nativeSetBloomWidth(getNativeInstance(), r100);
    }

    public boolean e(float r100) {
        return nativeSetSmoothFactor(getNativeInstance(), r100);
    }

    public boolean f(float r100) {
        return nativeSetThinFactor(getNativeInstance(), r100);
    }

    public boolean g(int r100) {
        return nativeSetCollisionTagId(getNativeInstance(), r100);
    }

    public boolean h(int r100) {
        return nativeSetEndCapType(getNativeInstance(), r100);
    }

    public boolean i(int r100) {
        return nativeSetJointType(getNativeInstance(), r100);
    }

    public boolean j(int r100) {
        return nativeSetLineBloomDirection(getNativeInstance(), r100);
    }

    public boolean k(int r100) {
        return nativeSetLineBloomMode(getNativeInstance(), r100);
    }

    public boolean l(int r100) {
        return nativeSetLineDirectionCrossType(getNativeInstance(), r100);
    }

    public boolean m(int r100) {
        return nativeSetSmooth(getNativeInstance(), r100);
    }

    public boolean n(int r100) {
        return nativeSetStartCapType(getNativeInstance(), r100);
    }

    public boolean o(int r100) {
        return nativeSetThin(getNativeInstance(), r100);
    }

    public void a(Polyline r100) {
        this.f32744i = r100;
    }

    public boolean b(float r100) {
        return nativeSetBloomAlpha(getNativeInstance(), r100);
    }

    public boolean c(boolean r100) {
        return nativeSetHighPrecision(getNativeInstance(), r100);
    }

    public boolean e(int r100) {
        return nativeSetBloomBlurTimes(getNativeInstance(), r100);
    }

    public boolean f(int r100) {
        return nativeSetCollisionBehavior(getNativeInstance(), r100);
    }

    public BmBaseLine(int r100, long r101) {
        super(r100, r101);
        this.f32745j = new ArrayList();
    }
}
