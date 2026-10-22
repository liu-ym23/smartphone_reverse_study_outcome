package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.H;

/* loaded from: classes.dex */
class f {

    /* renamed from: a, reason: collision with root package name */
    private final View f12184a;

    /* renamed from: b, reason: collision with root package name */
    private int f12185b;

    /* renamed from: c, reason: collision with root package name */
    private int f12186c;

    /* renamed from: d, reason: collision with root package name */
    private int f12187d;

    /* renamed from: e, reason: collision with root package name */
    private int f12188e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f12189f = true;

    /* renamed from: g, reason: collision with root package name */
    private boolean f12190g = true;

    public f(View view) {
        this.f12184a = view;
    }

    void a() {
        View view = this.f12184a;
        H.V(view, this.f12187d - (view.getTop() - this.f12185b));
        View view2 = this.f12184a;
        H.U(view2, this.f12188e - (view2.getLeft() - this.f12186c));
    }

    public int b() {
        return this.f12188e;
    }

    public int c() {
        return this.f12187d;
    }

    public boolean d() {
        return this.f12190g;
    }

    public boolean e() {
        return this.f12189f;
    }

    void f() {
        this.f12185b = this.f12184a.getTop();
        this.f12186c = this.f12184a.getLeft();
    }

    public void g(boolean z5) {
        this.f12190g = z5;
    }

    public boolean h(int i5) {
        if (!this.f12190g || this.f12188e == i5) {
            return false;
        }
        this.f12188e = i5;
        a();
        return true;
    }

    public boolean i(int i5) {
        if (!this.f12189f || this.f12187d == i5) {
            return false;
        }
        this.f12187d = i5;
        a();
        return true;
    }

    public void j(boolean z5) {
        this.f12189f = z5;
    }
}
