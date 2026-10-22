package com.baidu.platform.comapi.bmsdk.animation;

import com.baidu.platform.comapi.bmsdk.b;

/* loaded from: classes.dex */
public class BmTranslateAnimation extends BmAnimation {

    /* renamed from: a, reason: collision with root package name */
    private double f8675a;

    /* renamed from: b, reason: collision with root package name */
    private double f8676b;

    /* renamed from: c, reason: collision with root package name */
    private double f8677c;

    /* renamed from: d, reason: collision with root package name */
    private double f8678d;

    public BmTranslateAnimation(b bVar, b bVar2) {
        super(82, nativeCreate());
        double d4 = bVar.f8679a;
        this.f8675a = d4;
        double d5 = bVar2.f8679a;
        this.f8676b = d5;
        double d6 = bVar.f8680b;
        this.f8677c = d6;
        double d7 = bVar2.f8680b;
        this.f8678d = d7;
        nativeBuildAnimation(this.nativeInstance, d4, d5, d6, d7);
    }

    private static native boolean nativeBuildAnimation(long j4, double d4, double d5, double d6, double d7);

    private static native long nativeCreate();
}
