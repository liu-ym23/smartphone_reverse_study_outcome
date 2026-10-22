package com.baidu.platform.comapi.bmsdk;

import com.baidu.mapapi.map.GroundOverlay;
import com.baidu.platform.comapi.bmsdk.style.BmDrawableResource;

/* loaded from: classes.dex */
public class BmGround extends BmDrawItem {

    /* renamed from: i, reason: collision with root package name */
    private BmDrawableResource f8638i;

    /* renamed from: j, reason: collision with root package name */
    private GroundOverlay f8639j;

    public BmGround() {
        super(22, nativeCreate());
    }

    private static native long nativeCreate();

    private static native boolean nativeSetAnchorX(long j4, float f4);

    private static native boolean nativeSetAnchorY(long j4, float f4);

    private static native boolean nativeSetDrawableResource(long j4, long j5);

    private static native boolean nativeSetHeight(long j4, double d4);

    private static native boolean nativeSetPosition(long j4, double d4, double d5, double d6);

    private static native boolean nativeSetWidth(long j4, double d4);

    public boolean a(b bVar) {
        if (bVar == null) {
            return false;
        }
        return nativeSetPosition(this.nativeInstance, bVar.f8679a, bVar.f8680b, 0.0d);
    }

    public boolean b(double d4) {
        return nativeSetWidth(this.nativeInstance, d4);
    }

    public GroundOverlay c() {
        return this.f8639j;
    }

    public void a(GroundOverlay groundOverlay) {
        this.f8639j = groundOverlay;
    }

    public boolean b(float f4) {
        return nativeSetAnchorX(this.nativeInstance, f4);
    }

    public boolean c(float f4) {
        return nativeSetAnchorY(this.nativeInstance, f4);
    }

    public boolean a(double d4) {
        return nativeSetHeight(this.nativeInstance, d4);
    }

    public boolean a(BmDrawableResource bmDrawableResource) {
        this.f8638i = bmDrawableResource;
        if (bmDrawableResource != null) {
            return nativeSetDrawableResource(this.nativeInstance, bmDrawableResource.getNativeInstance());
        }
        return nativeSetDrawableResource(this.nativeInstance, 0L);
    }
}
