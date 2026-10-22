package com.stepos.common.widget;

import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;

/* loaded from: classes.dex */
class l {

    /* renamed from: a, reason: collision with root package name */
    private GradientDrawable f14433a;

    /* renamed from: b, reason: collision with root package name */
    private float f14434b;

    /* renamed from: c, reason: collision with root package name */
    private int f14435c;

    /* renamed from: d, reason: collision with root package name */
    private int f14436d;

    /* renamed from: e, reason: collision with root package name */
    private int f14437e;

    /* renamed from: f, reason: collision with root package name */
    private int f14438f;

    /* renamed from: g, reason: collision with root package name */
    private int f14439g;

    /* renamed from: h, reason: collision with root package name */
    private int f14440h;

    public l(GradientDrawable gradientDrawable) {
        this.f14433a = gradientDrawable;
    }

    public GradientDrawable a() {
        return this.f14433a;
    }

    public int b() {
        return this.f14436d;
    }

    public int c() {
        return this.f14438f;
    }

    public int d() {
        return this.f14439g;
    }

    public int e() {
        return this.f14437e;
    }

    public void f(int i5) {
        if (this.f14440h == i5) {
            return;
        }
        this.f14440h = i5;
        this.f14433a.setAlpha(i5);
    }

    public void g(int i5) {
        this.f14435c = i5;
        this.f14433a.setColor(i5);
        this.f14433a.setColorFilter(i5, PorterDuff.Mode.SRC_IN);
    }

    public void h(float f5) {
        this.f14434b = f5;
        this.f14433a.setCornerRadius(f5);
    }

    public void i(int i5) {
        this.f14436d = i5;
        this.f14433a.setSize(this.f14437e, i5);
    }

    public void j(int i5) {
        this.f14438f = i5;
    }

    public void k(int i5) {
        this.f14439g = i5;
    }

    public void l(int i5) {
        this.f14437e = i5;
        this.f14433a.setSize(i5, this.f14436d);
    }
}
