package com.baidu.platform.comapi.bmsdk.animation;

/* loaded from: classes.dex */
public class BmScaleAnimation extends BmAnimation {

    /* renamed from: a, reason: collision with root package name */
    private float f8671a;

    /* renamed from: b, reason: collision with root package name */
    private float f8672b;

    /* renamed from: c, reason: collision with root package name */
    private float f8673c;

    /* renamed from: d, reason: collision with root package name */
    private float f8674d;

    public BmScaleAnimation(float f4, float f5, float f6, float f7) {
        super(81, nativeCreate());
        this.f8671a = f4;
        this.f8672b = f5;
        this.f8673c = f6;
        this.f8674d = f7;
        nativeBuildAnimation(this.nativeInstance, f4, f5, f6, f7);
    }

    private static native boolean nativeBuildAnimation(long j4, float f4, float f5, float f6, float f7);

    private static native long nativeCreate();

    public BmScaleAnimation(float f4, float f5) {
        super(81, nativeCreate());
        this.f8671a = f4;
        this.f8672b = f5;
        this.f8673c = f4;
        this.f8674d = f5;
        nativeBuildAnimation(this.nativeInstance, f4, f5, f4, f5);
    }
}
