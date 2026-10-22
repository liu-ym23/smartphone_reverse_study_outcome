package com.baidu.platform.comapi.bmsdk;

import androidx.camera.video.AudioStats;
import com.baidu.mapapi.map.MultiPoint;
import com.baidu.platform.comapi.bmsdk.style.BmDrawableResource;

/* JADX INFO: loaded from: classes39.dex */
public class BmMultiPoint extends BmDrawItem {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private MultiPoint f32785i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private BmDrawableResource f32786j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f32787k;

    private static native boolean nativeAddGeoElement(long r100, long r101);

    private static native boolean nativeClearGeoElements(long r100);

    private static native long nativeCreate();

    private static native boolean nativeSetAnchorX(long r100, float r101);

    private static native boolean nativeSetAnchorY(long r100, float r101);

    private static native boolean nativeSetDrawableResource(long r100, long r101);

    private static native boolean nativeSetHeight(long r100, double r101);

    private static native boolean nativeSetPosition(long r100, double r101, double r102, double r103);

    private static native boolean nativeSetWidth(long r100, double r101);

    public boolean c() {
        return nativeClearGeoElements(this.nativeInstance);
    }

    public BmMultiPoint() {
        super(24, nativeCreate());
        this.f32787k = -1;
    }

    public int d() {
        return this.f32787k;
    }

    public MultiPoint e() {
        return this.f32785i;
    }

    public boolean a(BmDrawableResource r100) {
        this.f32786j = r100;
        if (r100 == null) goto L7;
        return nativeSetDrawableResource(this.nativeInstance, r100.getNativeInstance());
    L7:
        return nativeSetDrawableResource(this.nativeInstance, 0);
    }

    public boolean b(double r100) {
        return nativeSetWidth(this.nativeInstance, r100);
    }

    public boolean c(float r100) {
        return nativeSetAnchorY(this.nativeInstance, r100);
    }

    public void e(int r100) {
        this.f32787k = r100;
    }

    public boolean a(b r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return nativeSetPosition(this.nativeInstance, r100.f32817a, r100.f32818b, AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    public boolean b(float r100) {
        return nativeSetAnchorX(this.nativeInstance, r100);
    }

    public boolean a(BmGeoElement r100) {
        return nativeAddGeoElement(this.nativeInstance, r100.getNativeInstance());
    }

    public boolean a(double r100) {
        return nativeSetHeight(this.nativeInstance, r100);
    }

    public void a(MultiPoint r100) {
        this.f32785i = r100;
    }
}
