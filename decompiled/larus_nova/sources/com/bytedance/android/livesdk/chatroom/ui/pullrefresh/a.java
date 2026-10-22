package com.bytedance.android.livesdk.chatroom.ui.pullrefresh;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* JADX INFO: loaded from: classes8.dex */
public final class a extends Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MaterialProgressDrawable.b f113901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MaterialProgressDrawable f113902b;

    public a(MaterialProgressDrawable r100, MaterialProgressDrawable.b r101) {
        this.f113902b = r100;
        this.f113901a = r101;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float r100, Transformation r110) {
        if (this.f113902b.f113845j == false) goto L5;
        MaterialProgressDrawable.b r111 = this.f113901a;
        MaterialProgressDrawable.c(r100, r111);
        float r101 = (float) (Math.floor(r111.f113860n / 0.8f) + 1.0d);
        float r102 = (float) Math.toRadians(((double) r111.f113854h) / (r111.f113864r * 6.283185307179586d));
        float r103 = r111.f113858l;
        r111.f113851e = r103 + (((r111.f113859m - r102) - r103) * r100);
        r111.a();
        r111.f113852f = r111.f113859m;
        r111.a();
        float r104 = r111.f113860n;
        r111.f113853g = r104 + ((r101 - r104) * r100);
        r111.a();
        return;
    L5:
        MaterialProgressDrawable.b r112 = this.f113901a;
        float r113 = (float) Math.toRadians(((double) r112.f113854h) / (r112.f113864r * 6.283185307179586d));
        MaterialProgressDrawable.b r105 = this.f113901a;
        float r106 = r105.f113859m;
        float r107 = r105.f113858l;
        float r108 = r105.f113860n;
        this.f113902b.getClass();
        MaterialProgressDrawable.c(r100, r105);
        if (r100 > 0.5f) goto L9;
        float r109 = r107 + ((0.8f - r113) * MaterialProgressDrawable.f113834l.getInterpolation(r100 / 0.5f));
        MaterialProgressDrawable.b r114 = this.f113901a;
        r114.f113851e = r109;
        r114.a();
    L9:
        if (r100 <= 0.5f) goto L11;
        float r115 = r106 + ((0.8f - r113) * MaterialProgressDrawable.f113834l.getInterpolation((r100 - 0.5f) / 0.5f));
        MaterialProgressDrawable.b r116 = this.f113901a;
        r116.f113852f = r115;
        r116.a();
    L11:
        MaterialProgressDrawable.b r117 = this.f113901a;
        r117.f113853g = r108 + (0.25f * r100);
        r117.a();
        MaterialProgressDrawable r118 = this.f113902b;
        r118.f113838c = (r100 * 216.0f) + ((r118.f113842g / 5.0f) * 1080.0f);
        r118.invalidateSelf();
    }
}
