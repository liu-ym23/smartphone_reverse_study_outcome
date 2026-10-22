package com.baidu.platform.comapi.bmsdk.animation;

/* JADX INFO: loaded from: classes39.dex */
public class BmAlphaAnimation extends BmAnimation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f32805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f32806b;

    private static native boolean nativeBuildAnimation(long r100, float r101, float r102);

    private static native long nativeCreate();

    public BmAlphaAnimation(float r100, float r101) {
        super(83, nativeCreate());
        this.f32805a = r100;
        this.f32806b = r101;
        nativeBuildAnimation(this.nativeInstance, r100, r101);
    }
}
