package com.obric.oui.titlebar.behavior;

import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: ViewOffsetHelper.java */
/* JADX INFO: loaded from: classes4.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f36692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f36693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f36694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f36695d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f36696e;
    private boolean f;
    private boolean g;

    public b(View r2) {
        this.f = true;
        this.g = true;
        this.f36692a = r2;
    }

    void a() {
        this.f36693b = this.f36692a.getTop();
        this.f36694c = this.f36692a.getLeft();
    }

    void b() {
        View r0 = this.f36692a;
        ViewCompat.f(r0, this.f36695d - (r0.getTop() - this.f36693b));
        View r1 = this.f36692a;
        ViewCompat.g(r1, this.f36696e - (r1.getLeft() - this.f36694c));
    }

    public boolean a(int r2) {
        if (this.f == true) goto L5;
        return false;
    L5:
        if (this.f36695d == r2) goto L10;
        this.f36695d = r2;
        b();
        return true;
    L10:
        return false;
    }

    public boolean b(int r2) {
        if (this.g == true) goto L5;
        return false;
    L5:
        if (this.f36696e == r2) goto L10;
        this.f36696e = r2;
        b();
        return true;
    L10:
        return false;
    }

    public int c() {
        return this.f36695d;
    }
}
