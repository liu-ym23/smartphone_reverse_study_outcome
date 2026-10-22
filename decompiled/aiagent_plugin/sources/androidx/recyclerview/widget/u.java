package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;

/* JADX INFO: compiled from: OrientationHelper.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final RecyclerView.h f2583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Rect f2584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2585c;

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

    /* synthetic */ u(RecyclerView.h r1, AnonymousClass1 r2) {
        this(r1);
    }

    private u(RecyclerView.h r2) {
        this.f2585c = Integer.MIN_VALUE;
        this.f2584b = new Rect();
        this.f2583a = r2;
    }

    public void a() {
        this.f2585c = f();
    }

    public int b() {
        if (Integer.MIN_VALUE != this.f2585c) goto L6;
        return 0;
    L6:
        return f() - this.f2585c;
    }

    public static u a(RecyclerView.h r1, int r2) {
        if (r2 == 0) goto L10;
        if (r2 != 1) goto L8;
        return b(r1);
    L8:
        throw new IllegalArgumentException("invalid orientation");
    L10:
        return a(r1);
    }

    public static u a(final RecyclerView.h r1) {
        return new AnonymousClass1(r1);
    }

    public static u b(final RecyclerView.h r1) {
        return new AnonymousClass2(r1);
    }
}
