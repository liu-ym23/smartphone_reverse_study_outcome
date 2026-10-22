package com.obric.oui.orecyclerview.base;

import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class OverScrollerAdapter {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f15331i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f15332j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f15333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Interpolator f15334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f15335c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f15336d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f15337e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f15338f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f15339g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f15340h;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f15331i = new a(null);
        f15332j = true;
    }

    public OverScrollerAdapter(Context r10, Interpolator r11) {
        q.g(r10, "context");
        q.g(r11, "interpolator");
        this.f15333a = r10;
        this.f15334b = r11;
        this.f15335c = kotlin.b.b(new OverScrollerAdapter$systemOverScroller$2(this));
        this.f15336d = kotlin.b.b(OverScrollerAdapter$fluidScrollerX$2.INSTANCE);
        this.f15337e = kotlin.b.b(OverScrollerAdapter$fluidScrollerY$2.INSTANCE);
        this.f15338f = f15332j;
        this.f15339g = -1;
        this.f15340h = -1;
    }

    public static final /* synthetic */ Context b(OverScrollerAdapter r10) {
        return r10.f15333a;
    }

    public static final /* synthetic */ Interpolator c(OverScrollerAdapter r10) {
        return r10.f15334b;
    }

    public final void a() {
        if (this.f15338f == false) goto L5;
        m().abortAnimation();
        return;
    L5:
        this.f15339g = -1;
    }

    public final boolean d() {
        if (this.f15338f == false) goto L7;
        return m().computeScrollOffset();
    L7:
        if (this.f15339g != (-1)) goto L10;
        return false;
    L10:
        this.f15340h = AnimationUtils.currentAnimationTimeMillis() - this.f15339g;
        return !n();
    }

    public final void e(int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19) {
        if (f15332j == false) goto L6;
        m().fling(r12, r13, r14, r15, r16, r17, r18, r19);
        return;
    L6:
        this.f15338f = false;
        float r10 = 1000;
        k().b(r12, r14 / r10);
        l().b(r13, r15 / r10);
        this.f15339g = AnimationUtils.currentAnimationTimeMillis();
    }

    public final float f() {
        if (this.f15338f == false) goto L7;
        return m().getCurrVelocity();
    L7:
        return ((float) Math.hypot(k().d(this.f15340h).b(), l().d(this.f15340h).b())) * 1000;
    }

    public final int g() {
        if (this.f15338f == false) goto L7;
        return m().getCurrX();
    L7:
        return (int) k().d(this.f15340h).a();
    }

    public final int h() {
        if (this.f15338f == false) goto L7;
        return m().getCurrY();
    L7:
        return (int) l().d(this.f15340h).a();
    }

    public final int i() {
        if (this.f15338f == false) goto L7;
        return m().getFinalX();
    L7:
        return (int) k().a();
    }

    public final int j() {
        if (this.f15338f == false) goto L7;
        return m().getFinalY();
    L7:
        return (int) l().a();
    }

    public final c k() {
        return (c) this.f15336d.getValue();
    }

    public final c l() {
        return (c) this.f15337e.getValue();
    }

    public final OverScroller m() {
        return (OverScroller) this.f15335c.getValue();
    }

    public final boolean n() {
        if (this.f15338f == true) goto L5;
        c.b r10 = k().d(this.f15340h);
        c.b r11 = l().d(this.f15340h);
        if (r10.c() == true) goto L9;
    L11:
        return false;
    L9:
        if (r11.c() == false) goto L11;
        return true;
    L5:
        return m().isFinished();
    }

    public final void o(int r10, int r11, int r12, int r13, int r14) {
        this.f15338f = true;
        m().startScroll(r10, r11, r12, r13, r14);
    }
}
