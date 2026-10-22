package com.obric.oui.titlebar.behavior;

import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f17531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f17532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f17533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f17534d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f17535e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f17536f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f17537g;

    public a(View r10) {
        this.f17536f = true;
        this.f17537g = true;
        this.f17531a = r10;
    }

    public void a() {
        View r10 = this.f17531a;
        ViewCompat.a0(r10, this.f17534d - (r10.getTop() - this.f17532b));
        View r11 = this.f17531a;
        ViewCompat.Z(r11, this.f17535e - (r11.getLeft() - this.f17533c));
    }

    public int b() {
        return this.f17534d;
    }

    public void c() {
        this.f17532b = this.f17531a.getTop();
        this.f17533c = this.f17531a.getLeft();
    }

    public boolean d(int r10) {
        if (this.f17537g == true) goto L5;
        return false;
    L5:
        if (this.f17535e == r10) goto L10;
        this.f17535e = r10;
        a();
        return true;
    L10:
        return false;
    }

    public boolean e(int r10) {
        if (this.f17536f == true) goto L5;
        return false;
    L5:
        if (this.f17534d == r10) goto L10;
        this.f17534d = r10;
        a();
        return true;
    L10:
        return false;
    }
}
