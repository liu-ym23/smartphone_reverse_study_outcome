package com.baidu.platform.comapi.bmsdk.animation;

import com.baidu.platform.comapi.bmsdk.b;

/* JADX INFO: loaded from: classes39.dex */
public class BmTranslateAnimation extends BmAnimation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f32813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f32814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private double f32815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private double f32816d;

    private static native boolean nativeBuildAnimation(long r100, double r101, double r102, double r103, double r104);

    private static native long nativeCreate();

    public BmTranslateAnimation(b r110, b r111) {
        super(82, nativeCreate());
        double r100 = r110.f32817a;
        this.f32813a = r100;
        double r101 = r111.f32817a;
        this.f32814b = r101;
        double r102 = r110.f32818b;
        this.f32815c = r102;
        double r112 = r111.f32818b;
        this.f32816d = r112;
        nativeBuildAnimation(this.nativeInstance, r100, r101, r102, r112);
    }
}
