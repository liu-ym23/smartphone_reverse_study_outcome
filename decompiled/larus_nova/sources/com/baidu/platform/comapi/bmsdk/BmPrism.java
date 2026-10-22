package com.baidu.platform.comapi.bmsdk;

import com.baidu.mapapi.map.Prism;
import com.baidu.platform.comapi.bmsdk.style.BmSurfaceStyle;

/* JADX INFO: loaded from: classes39.dex */
public class BmPrism extends BmDrawItem {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Prism f32791i;

    private static native boolean nativeAddGeoElement(long r100, long r101);

    private static native boolean nativeClearGeoElements(long r100);

    private static native long nativeCreate();

    private static native boolean nativeSetAnimateType(long r100, int r101);

    private static native boolean nativeSetBuildingID(long r100, String r101);

    private static native boolean nativeSetFloorAnimateType(long r100, int r101);

    private static native boolean nativeSetFloorHeight(long r100, float r101);

    private static native boolean nativeSetHasFloor(long r100, boolean r101);

    private static native boolean nativeSetHeight(long r100, float r101);

    private static native boolean nativeSetIsAnimation(long r100, boolean r101);

    private static native boolean nativeSetIsBuilding(long r100, boolean r101);

    private static native boolean nativeSetIsRoundedCorner(long r100, boolean r101);

    private static native boolean nativeSetLastFloorHeight(long r100, float r101);

    private static native boolean nativeSetRoundedCornerRadius(long r100, float r101);

    private static native boolean nativeSetSurfaceFloorSideStyle(long r100, long r101);

    private static native boolean nativeSetSurfaceFloorTopStyle(long r100, long r101);

    private static native boolean nativeSetSurfaceSideStyle(long r100, long r101);

    private static native boolean nativeSetSurfaceTopStyle(long r100, long r101);

    public boolean c() {
        return nativeClearGeoElements(this.nativeInstance);
    }

    public BmPrism() {
        super(23, nativeCreate());
    }

    public Prism d() {
        return this.f32791i;
    }

    public void a(BmSurfaceStyle r100) {
        if (r100 == null) goto L4;
        nativeSetSurfaceFloorSideStyle(this.nativeInstance, r100.nativeInstance);
        return;
    L4:
        nativeSetSurfaceFloorSideStyle(this.nativeInstance, 0);
    }

    public void b(BmSurfaceStyle r100) {
        if (r100 == null) goto L4;
        nativeSetSurfaceFloorTopStyle(this.nativeInstance, r100.nativeInstance);
        return;
    L4:
        nativeSetSurfaceFloorTopStyle(this.nativeInstance, 0);
    }

    public void c(BmSurfaceStyle r100) {
        if (r100 == null) goto L4;
        nativeSetSurfaceSideStyle(this.nativeInstance, r100.nativeInstance);
        return;
    L4:
        nativeSetSurfaceSideStyle(this.nativeInstance, 0);
    }

    public void d(BmSurfaceStyle r100) {
        if (r100 == null) goto L4;
        nativeSetSurfaceTopStyle(this.nativeInstance, r100.nativeInstance);
        return;
    L4:
        nativeSetSurfaceTopStyle(this.nativeInstance, 0);
    }

    public boolean e(float r100) {
        return nativeSetRoundedCornerRadius(this.nativeInstance, r100);
    }

    public boolean f(int r100) {
        return nativeSetFloorAnimateType(this.nativeInstance, r100);
    }

    public boolean a(BmGeoElement r100) {
        return nativeAddGeoElement(this.nativeInstance, r100.getNativeInstance());
    }

    public boolean b(float r100) {
        return nativeSetFloorHeight(this.nativeInstance, r100);
    }

    public boolean c(float r100) {
        return nativeSetHeight(this.nativeInstance, r100);
    }

    public boolean d(float r100) {
        return nativeSetLastFloorHeight(this.nativeInstance, r100);
    }

    public boolean e(int r100) {
        return nativeSetAnimateType(this.nativeInstance, r100);
    }

    public boolean f(boolean r100) {
        return nativeSetIsRoundedCorner(this.nativeInstance, r100);
    }

    public boolean a(String r100) {
        return nativeSetBuildingID(this.nativeInstance, r100);
    }

    public boolean c(boolean r100) {
        return nativeSetIsAnimation(this.nativeInstance, r100);
    }

    public boolean d(boolean r100) {
        return nativeSetIsBuilding(this.nativeInstance, r100);
    }

    public boolean e(boolean r100) {
        return nativeSetHasFloor(this.nativeInstance, r100);
    }

    public void a(Prism r100) {
        this.f32791i = r100;
    }
}
