package com.obric.oui.popover;

import android.view.MotionEvent;
import android.view.View;
import d.h.b.o;

/* JADX INFO: compiled from: LongClickUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f35996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View.OnTouchListener f35997b;

    /* JADX INFO: renamed from: lambda$-LBCs6igexxsSUVuMklvUkA9rZE, reason: not valid java name */
    public static /* synthetic */ boolean m1129lambda$LBCs6igexxsSUVuMklvUkA9rZE(d r0, View r1, MotionEvent r2) {
        return a(r0, r1, r2);
    }

    public abstract boolean a(View r1, int[] r2);

    public d() {
        this.f35996a = new int[2];
        this.f35997b = new $$Lambda$d$LBCs6igexxsSUVuMklvUkA9rZE(this);
    }

    public final int[] a() {
        return this.f35996a;
    }

    public final View.OnTouchListener b() {
        return this.f35997b;
    }

    private static final boolean a(d r2, View r3, MotionEvent r4) {
        o.e(r2, "this$0");
        if (r4 == null) goto L5;
        r2.f35996a[0] = (int) r4.getRawX();
        r2.f35996a[1] = (int) r4.getRawY();
    L5:
        return false;
    }
}
