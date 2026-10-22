package com.bytedance.android.gamecp.common.ui.pullrefresh;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MaterialProgressDrawable.b f57122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MaterialProgressDrawable f57123b;

    public a(MaterialProgressDrawable r100, MaterialProgressDrawable.b r101) {
        this.f57123b = r100;
        this.f57122a = r101;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float r100, Transformation r110) {
        if (this.f57123b.f57066i == false) goto L5;
        MaterialProgressDrawable.b r111 = this.f57122a;
        MaterialProgressDrawable.a(r100, r111);
        float r101 = (float) (Math.floor(r111.f57081n / 0.8f) + 1.0d);
        float r102 = (float) Math.toRadians(((double) r111.f57075h) / (r111.f57085r * 6.283185307179586d));
        float r103 = r111.f57079l;
        r111.f57072e = r103 + (((r111.f57080m - r102) - r103) * r100);
        r111.a();
        r111.f57073f = r111.f57080m;
        r111.a();
        float r104 = r111.f57081n;
        r111.f57074g = r104 + ((r101 - r104) * r100);
        r111.a();
        return;
    L5:
        MaterialProgressDrawable.b r112 = this.f57122a;
        float r113 = (float) Math.toRadians(((double) r112.f57075h) / (r112.f57085r * 6.283185307179586d));
        MaterialProgressDrawable.b r105 = this.f57122a;
        float r106 = r105.f57080m;
        float r107 = r105.f57079l;
        float r108 = r105.f57081n;
        this.f57123b.getClass();
        MaterialProgressDrawable.a(r100, r105);
        if (r100 > 0.5f) goto L9;
        float r109 = r107 + ((0.8f - r113) * MaterialProgressDrawable.f57056k.getInterpolation(r100 / 0.5f));
        MaterialProgressDrawable.b r114 = this.f57122a;
        r114.f57072e = r109;
        r114.a();
    L9:
        if (r100 <= 0.5f) goto L11;
        float r115 = r106 + ((0.8f - r113) * MaterialProgressDrawable.f57056k.getInterpolation((r100 - 0.5f) / 0.5f));
        MaterialProgressDrawable.b r116 = this.f57122a;
        r116.f57073f = r115;
        r116.a();
    L11:
        MaterialProgressDrawable.b r117 = this.f57122a;
        r117.f57074g = r108 + (0.25f * r100);
        r117.a();
        MaterialProgressDrawable r118 = this.f57123b;
        r118.f57060c = (r100 * 216.0f) + ((r118.f57063f / 5.0f) * 1080.0f);
        r118.invalidateSelf();
    }
}
