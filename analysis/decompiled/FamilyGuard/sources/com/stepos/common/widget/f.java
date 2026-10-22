package com.stepos.common.widget;

import android.content.res.ColorStateList;

/* loaded from: classes.dex */
class f {

    /* renamed from: a, reason: collision with root package name */
    public l f14399a;

    /* renamed from: b, reason: collision with root package name */
    public float f14400b;

    /* renamed from: c, reason: collision with root package name */
    public int f14401c;

    /* renamed from: d, reason: collision with root package name */
    public int f14402d;

    /* renamed from: e, reason: collision with root package name */
    public ColorStateList f14403e;

    /* renamed from: f, reason: collision with root package name */
    public ColorStateList f14404f;

    /* renamed from: g, reason: collision with root package name */
    public float f14405g;

    /* renamed from: h, reason: collision with root package name */
    public float f14406h;

    private f(l lVar) {
        this.f14399a = lVar;
    }

    public static f d(l lVar) {
        return new f(lVar);
    }

    public f a(float f5, float f6) {
        this.f14405g = f5;
        this.f14406h = f6;
        return this;
    }

    public f b(ColorStateList colorStateList, ColorStateList colorStateList2) {
        this.f14403e = colorStateList;
        this.f14404f = colorStateList2;
        return this;
    }

    public f c(int i5) {
        this.f14400b = i5;
        return this;
    }

    public f e(int i5) {
        this.f14401c = i5;
        return this;
    }

    public f f(int i5) {
        this.f14402d = i5;
        return this;
    }
}
