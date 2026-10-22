package com.baidu.platform.comapi.bmsdk;

import com.baidu.mapapi.map.MultiPoint;
import com.baidu.platform.comapi.bmsdk.style.BmDrawableResource;

/* loaded from: classes.dex */
public class BmMultiPoint extends BmDrawItem {

    /* renamed from: i, reason: collision with root package name */
    private MultiPoint f8647i;

    /* renamed from: j, reason: collision with root package name */
    private BmDrawableResource f8648j;

    /* renamed from: k, reason: collision with root package name */
    private int f8649k;

    public BmMultiPoint() {
        super(24, nativeCreate());
        this.f8649k = -1;
    }

    private static native boolean nativeAddGeoElement(long j4, long j5);

    private static native boolean nativeClearGeoElements(long j4);

    private static native long nativeCreate();

    private static native boolean nativeSetAnchorX(long j4, float f4);

    private static native boolean nativeSetAnchorY(long j4, float f4);

    private static native boolean nativeSetDrawableResource(long j4, long j5);

    private static native boolean nativeSetHeight(long j4, double d4);

    private static native boolean nativeSetPosition(long j4, double d4, double d5, double d6);

    private static native boolean nativeSetWidth(long j4, double d4);

    public boolean a(BmGeoElement bmGeoElement) {
        return nativeAddGeoElement(this.nativeInstance, bmGeoElement.getNativeInstance());
    }

    public boolean b(double d4) {
        return nativeSetWidth(this.nativeInstance, d4);
    }

    public boolean c() {
        return nativeClearGeoElements(this.nativeInstance);
    }

    public int d() {
        return this.f8649k;
    }

    public void e(int i4) {
        this.f8649k = i4;
    }

    public boolean a(b bVar) {
        if (bVar == null) {
            return false;
        }
        return nativeSetPosition(this.nativeInstance, bVar.f8679a, bVar.f8680b, 0.0d);
    }

    public boolean b(float f4) {
        return nativeSetAnchorX(this.nativeInstance, f4);
    }

    public boolean c(float f4) {
        return nativeSetAnchorY(this.nativeInstance, f4);
    }

    public MultiPoint e() {
        return this.f8647i;
    }

    public void a(MultiPoint multiPoint) {
        this.f8647i = multiPoint;
    }

    public boolean a(double d4) {
        return nativeSetHeight(this.nativeInstance, d4);
    }

    public boolean a(BmDrawableResource bmDrawableResource) {
        this.f8648j = bmDrawableResource;
        if (bmDrawableResource != null) {
            return nativeSetDrawableResource(this.nativeInstance, bmDrawableResource.getNativeInstance());
        }
        return nativeSetDrawableResource(this.nativeInstance, 0L);
    }
}
