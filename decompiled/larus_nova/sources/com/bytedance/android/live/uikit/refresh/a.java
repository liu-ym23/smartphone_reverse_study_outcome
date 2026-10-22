package com.bytedance.android.live.uikit.refresh;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MaterialProgressDrawable.c f102402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MaterialProgressDrawable f102403b;

    public a(MaterialProgressDrawable r100, MaterialProgressDrawable.c r101) {
        this.f102403b = r100;
        this.f102402a = r101;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float r100, Transformation r101) {
        if (this.f102403b.f102377j == false) goto L5;
        MaterialProgressDrawable.c r102 = this.f102402a;
        float r103 = (float) (Math.floor(r102.f102392n / 0.8f) + 1.0d);
        float r104 = r102.f102390l;
        r102.f102383e = r104 + ((r102.f102391m - r104) * r100);
        r102.a();
        float r105 = r102.f102392n;
        r102.f102385g = r105 + ((r103 - r105) * r100);
        r102.a();
        return;
    L5:
        MaterialProgressDrawable.c r106 = this.f102402a;
        float r107 = (float) Math.toRadians(((double) r106.f102386h) / (r106.f102396r * 6.283185307179586d));
        MaterialProgressDrawable.c r108 = this.f102402a;
        float r109 = r108.f102391m;
        float r110 = r108.f102390l;
        float r111 = r108.f102392n;
        float r112 = r109 + ((0.8f - r107) * MaterialProgressDrawable.f102367m.getInterpolation(r100));
        MaterialProgressDrawable.c r113 = this.f102402a;
        r113.f102384f = r112;
        r113.a();
        float r114 = r110 + (MaterialProgressDrawable.f102366l.getInterpolation(r100) * 0.8f);
        MaterialProgressDrawable.c r115 = this.f102402a;
        r115.f102383e = r114;
        r115.a();
        MaterialProgressDrawable.c r116 = this.f102402a;
        r116.f102385g = r111 + (0.25f * r100);
        r116.a();
        MaterialProgressDrawable r117 = this.f102403b;
        r117.f102370c = (r100 * 144.0f) + ((r117.f102374g / 5.0f) * 720.0f);
        r117.invalidateSelf();
    }
}
