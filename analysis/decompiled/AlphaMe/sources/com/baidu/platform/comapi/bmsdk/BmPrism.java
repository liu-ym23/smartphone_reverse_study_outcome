package com.baidu.platform.comapi.bmsdk;

import com.baidu.mapapi.map.Prism;
import com.baidu.platform.comapi.bmsdk.style.BmSurfaceStyle;

/* loaded from: classes.dex */
public class BmPrism extends BmDrawItem {

    /* renamed from: i, reason: collision with root package name */
    private Prism f8653i;

    public BmPrism() {
        super(23, nativeCreate());
    }

    private static native boolean nativeAddGeoElement(long j4, long j5);

    private static native boolean nativeClearGeoElements(long j4);

    private static native long nativeCreate();

    private static native boolean nativeSetAnimateType(long j4, int i4);

    private static native boolean nativeSetBuildingID(long j4, String str);

    private static native boolean nativeSetFloorAnimateType(long j4, int i4);

    private static native boolean nativeSetFloorHeight(long j4, float f4);

    private static native boolean nativeSetHasFloor(long j4, boolean z4);

    private static native boolean nativeSetHeight(long j4, float f4);

    private static native boolean nativeSetIsAnimation(long j4, boolean z4);

    private static native boolean nativeSetIsBuilding(long j4, boolean z4);

    private static native boolean nativeSetIsRoundedCorner(long j4, boolean z4);

    private static native boolean nativeSetLastFloorHeight(long j4, float f4);

    private static native boolean nativeSetRoundedCornerRadius(long j4, float f4);

    private static native boolean nativeSetSurfaceFloorSideStyle(long j4, long j5);

    private static native boolean nativeSetSurfaceFloorTopStyle(long j4, long j5);

    private static native boolean nativeSetSurfaceSideStyle(long j4, long j5);

    private static native boolean nativeSetSurfaceTopStyle(long j4, long j5);

    public void a(Prism prism) {
        this.f8653i = prism;
    }

    public void b(BmSurfaceStyle bmSurfaceStyle) {
        if (bmSurfaceStyle != null) {
            nativeSetSurfaceFloorTopStyle(this.nativeInstance, bmSurfaceStyle.nativeInstance);
        } else {
            nativeSetSurfaceFloorTopStyle(this.nativeInstance, 0L);
        }
    }

    public boolean c() {
        return nativeClearGeoElements(this.nativeInstance);
    }

    public void d(BmSurfaceStyle bmSurfaceStyle) {
        if (bmSurfaceStyle != null) {
            nativeSetSurfaceTopStyle(this.nativeInstance, bmSurfaceStyle.nativeInstance);
        } else {
            nativeSetSurfaceTopStyle(this.nativeInstance, 0L);
        }
    }

    public boolean e(boolean z4) {
        return nativeSetHasFloor(this.nativeInstance, z4);
    }

    public boolean f(int i4) {
        return nativeSetFloorAnimateType(this.nativeInstance, i4);
    }

    public boolean a(BmGeoElement bmGeoElement) {
        return nativeAddGeoElement(this.nativeInstance, bmGeoElement.getNativeInstance());
    }

    public void c(BmSurfaceStyle bmSurfaceStyle) {
        if (bmSurfaceStyle != null) {
            nativeSetSurfaceSideStyle(this.nativeInstance, bmSurfaceStyle.nativeInstance);
        } else {
            nativeSetSurfaceSideStyle(this.nativeInstance, 0L);
        }
    }

    public boolean e(int i4) {
        return nativeSetAnimateType(this.nativeInstance, i4);
    }

    public boolean f(boolean z4) {
        return nativeSetIsRoundedCorner(this.nativeInstance, z4);
    }

    public void a(BmSurfaceStyle bmSurfaceStyle) {
        if (bmSurfaceStyle != null) {
            nativeSetSurfaceFloorSideStyle(this.nativeInstance, bmSurfaceStyle.nativeInstance);
        } else {
            nativeSetSurfaceFloorSideStyle(this.nativeInstance, 0L);
        }
    }

    public boolean b(float f4) {
        return nativeSetFloorHeight(this.nativeInstance, f4);
    }

    public boolean d(float f4) {
        return nativeSetLastFloorHeight(this.nativeInstance, f4);
    }

    public boolean e(float f4) {
        return nativeSetRoundedCornerRadius(this.nativeInstance, f4);
    }

    public boolean c(float f4) {
        return nativeSetHeight(this.nativeInstance, f4);
    }

    public boolean d(boolean z4) {
        return nativeSetIsBuilding(this.nativeInstance, z4);
    }

    public boolean a(String str) {
        return nativeSetBuildingID(this.nativeInstance, str);
    }

    public boolean c(boolean z4) {
        return nativeSetIsAnimation(this.nativeInstance, z4);
    }
}
