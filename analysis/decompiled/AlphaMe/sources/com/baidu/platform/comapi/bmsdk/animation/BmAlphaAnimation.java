package com.baidu.platform.comapi.bmsdk.animation;

/* loaded from: classes.dex */
public class BmAlphaAnimation extends BmAnimation {

    /* renamed from: a, reason: collision with root package name */
    private float f8667a;

    /* renamed from: b, reason: collision with root package name */
    private float f8668b;

    public BmAlphaAnimation(float f4, float f5) {
        super(83, nativeCreate());
        this.f8667a = f4;
        this.f8668b = f5;
        nativeBuildAnimation(this.nativeInstance, f4, f5);
    }

    private static native boolean nativeBuildAnimation(long j4, float f4, float f5);

    private static native long nativeCreate();
}
