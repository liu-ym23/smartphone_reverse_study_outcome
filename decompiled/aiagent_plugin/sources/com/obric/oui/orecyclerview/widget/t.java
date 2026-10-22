package com.obric.oui.orecyclerview.widget;

import android.graphics.Rect;
import android.view.View;

/* JADX INFO: compiled from: OrientationHelper.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final RecyclerView.h f35833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Rect f35834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f35835c;

    public abstract int a(View r1);

    public abstract void a(int r1);

    public abstract int b(View r1);

    public abstract int c();

    public abstract int c(View r1);

    public abstract int d();

    public abstract int d(View r1);

    public abstract int e();

    public abstract int e(View r1);

    public abstract int f();

    public abstract int f(View r1);

    public abstract int g();

    public abstract int h();

    public abstract int i();

    /* synthetic */ t(RecyclerView.h r1, AnonymousClass1 r2) {
        this(r1);
    }

    private t(RecyclerView.h r2) {
        this.f35835c = Integer.MIN_VALUE;
        this.f35834b = new Rect();
        this.f35833a = r2;
    }

    public void a() {
        this.f35835c = f();
    }

    public int b() {
        if (Integer.MIN_VALUE != this.f35835c) goto L6;
        return 0;
    L6:
        return f() - this.f35835c;
    }

    public static t a(RecyclerView.h r1, int r2) {
        if (r2 == 0) goto L10;
        if (r2 != 1) goto L8;
        return b(r1);
    L8:
        throw new IllegalArgumentException("invalid orientation");
    L10:
        return a(r1);
    }

    public static t a(final RecyclerView.h r1) {
        return new AnonymousClass1(r1);
    }

    public static t b(final RecyclerView.h r1) {
        return new AnonymousClass2(r1);
    }
}
