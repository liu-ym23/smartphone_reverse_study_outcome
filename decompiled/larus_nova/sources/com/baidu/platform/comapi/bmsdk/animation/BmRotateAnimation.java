package com.baidu.platform.comapi.bmsdk.animation;

/* JADX INFO: loaded from: classes39.dex */
public class BmRotateAnimation extends BmAnimation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f32807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f32808b;

    private static native boolean nativeBuildAnimation(long r100, float r101, float r102);

    private static native long nativeCreate();

    public BmRotateAnimation(float r100, float r101) {
        super(84, nativeCreate());
        this.f32807a = r100;
        this.f32808b = r101;
        nativeBuildAnimation(this.nativeInstance, r100, r101);
    }
}
