package com.baidu.platform.comapi.bmsdk.animation;

/* JADX INFO: loaded from: classes39.dex */
public class BmScaleAnimation extends BmAnimation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f32809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f32810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f32811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f32812d;

    private static native boolean nativeBuildAnimation(long r100, float r101, float r102, float r103, float r104);

    private static native long nativeCreate();

    public BmScaleAnimation(float r110, float r111) {
        super(81, nativeCreate());
        this.f32809a = r110;
        this.f32810b = r111;
        this.f32811c = r110;
        this.f32812d = r111;
        nativeBuildAnimation(this.nativeInstance, r110, r111, r110, r111);
    }

    public BmScaleAnimation(float r110, float r111, float r112, float r113) {
        super(81, nativeCreate());
        this.f32809a = r110;
        this.f32810b = r111;
        this.f32811c = r112;
        this.f32812d = r113;
        nativeBuildAnimation(this.nativeInstance, r110, r111, r112, r113);
    }
}
