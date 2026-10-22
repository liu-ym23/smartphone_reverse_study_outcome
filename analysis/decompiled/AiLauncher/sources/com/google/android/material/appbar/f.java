package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.N;

/* loaded from: classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public final View f20281a;

    /* renamed from: b, reason: collision with root package name */
    public int f20282b;

    /* renamed from: c, reason: collision with root package name */
    public int f20283c;

    /* renamed from: d, reason: collision with root package name */
    public int f20284d;

    /* renamed from: e, reason: collision with root package name */
    public int f20285e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f20286f = true;

    /* renamed from: g, reason: collision with root package name */
    public boolean f20287g = true;

    public f(View view) {
        this.f20281a = view;
    }

    public void a() {
        View view = this.f20281a;
        N.T(view, this.f20284d - (view.getTop() - this.f20282b));
        View view2 = this.f20281a;
        N.S(view2, this.f20285e - (view2.getLeft() - this.f20283c));
    }

    public int b() {
        return this.f20285e;
    }

    public int c() {
        return this.f20284d;
    }

    public boolean d() {
        return this.f20287g;
    }

    public boolean e() {
        return this.f20286f;
    }

    public void f() {
        this.f20282b = this.f20281a.getTop();
        this.f20283c = this.f20281a.getLeft();
    }

    public void g(boolean z10) {
        this.f20287g = z10;
    }

    public boolean h(int i10) {
        if (!this.f20287g || this.f20285e == i10) {
            return false;
        }
        this.f20285e = i10;
        a();
        return true;
    }

    public boolean i(int i10) {
        if (!this.f20286f || this.f20284d == i10) {
            return false;
        }
        this.f20284d = i10;
        a();
        return true;
    }

    public void j(boolean z10) {
        this.f20286f = z10;
    }
}
