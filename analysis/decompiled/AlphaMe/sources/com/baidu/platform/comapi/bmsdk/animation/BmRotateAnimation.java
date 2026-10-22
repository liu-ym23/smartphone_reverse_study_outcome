package com.baidu.platform.comapi.bmsdk.animation;

/* loaded from: classes.dex */
public class BmRotateAnimation extends BmAnimation {

    /* renamed from: a, reason: collision with root package name */
    private float f8669a;

    /* renamed from: b, reason: collision with root package name */
    private float f8670b;

    public BmRotateAnimation(float f4, float f5) {
        super(84, nativeCreate());
        this.f8669a = f4;
        this.f8670b = f5;
        nativeBuildAnimation(this.nativeInstance, f4, f5);
    }

    private static native boolean nativeBuildAnimation(long j4, float f4, float f5);

    private static native long nativeCreate();
}
