package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: ViewOffsetHelper.java */
/* JADX INFO: loaded from: classes2.dex */
class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f13190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f13192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f13193d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f13194e;
    private boolean f;
    private boolean g;

    public d(View r2) {
        this.f = true;
        this.g = true;
        this.f13190a = r2;
    }

    void a() {
        this.f13191b = this.f13190a.getTop();
        this.f13192c = this.f13190a.getLeft();
    }

    void b() {
        View r0 = this.f13190a;
        ViewCompat.f(r0, this.f13193d - (r0.getTop() - this.f13191b));
        View r1 = this.f13190a;
        ViewCompat.g(r1, this.f13194e - (r1.getLeft() - this.f13192c));
    }

    public boolean a(int r2) {
        if (this.f == true) goto L5;
        return false;
    L5:
        if (this.f13193d == r2) goto L10;
        this.f13193d = r2;
        b();
        return true;
    L10:
        return false;
    }

    public boolean b(int r2) {
        if (this.g == true) goto L5;
        return false;
    L5:
        if (this.f13194e == r2) goto L10;
        this.f13194e = r2;
        b();
        return true;
    L10:
        return false;
    }

    public int c() {
        return this.f13193d;
    }

    public int d() {
        return this.f13191b;
    }
}
