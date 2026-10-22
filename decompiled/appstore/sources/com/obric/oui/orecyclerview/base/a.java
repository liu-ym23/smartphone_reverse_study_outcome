package com.obric.oui.orecyclerview.base;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.animation.AnimationUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final C0197a f15341l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f15342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f15343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f15344c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f15345d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f15346e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f15347f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f15348g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f15349h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f15350i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f15351j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final DisplayMetrics f15352k;

    /* JADX INFO: renamed from: com.obric.oui.orecyclerview.base.a$a, reason: collision with other inner class name */
    public static final class C0197a {
        public /* synthetic */ C0197a(DefaultConstructorMarker r10) {
            this();
        }

        public C0197a() {
        }
    }

    static {
        f15341l = new C0197a(null);
    }

    public a(Context r10) {
        q.g(r10, "context");
        this.f15342a = r10;
        this.f15344c = -1;
        this.f15345d = -1;
        this.f15346e = new d();
        this.f15351j = true;
        this.f15352k = r10.getResources().getDisplayMetrics();
    }

    public final boolean a() {
        if (this.f15344c != (-1)) goto L6;
        return false;
    L6:
        if (this.f15350i != 1) goto L8;
        return true;
    L8:
        long r10 = AnimationUtils.currentAnimationTimeMillis() - this.f15344c;
        this.f15345d = r10;
        d.a r11 = this.f15346e.b(r10);
        this.f15347f = h(r11.a());
        boolean r12 = r11.b();
        this.f15351j = r12;
        if (r12 == false) goto L12;
        this.f15350i = 0;
    L12:
        return !r12;
    }

    public final float b(float r10) {
        return r10 / this.f15352k.density;
    }

    public final float c() {
        return this.f15347f;
    }

    public final boolean d() {
        return this.f15351j;
    }

    public final void e(int r10) {
        float r11 = b(r10 / 1000.0f);
        this.f15344c = AnimationUtils.currentAnimationTimeMillis();
        this.f15346e.a(r11, 0.0f);
        this.f15350i = 2;
        this.f15351j = false;
    }

    public final float f(float r10, boolean r11, boolean r12) {
        if (Math.signum(r10) != Math.signum(this.f15347f)) goto L5;
        boolean r13 = true;
    L7:
        if (r13 != r11) goto L41;
        if (r12 == true) goto L41;
        float r14 = b(r10);
        if (this.f15350i == 1) goto L18;
        float r15 = b.f15353a.a(Math.abs(b(this.f15347f)), this.f15343b) * (-Math.signum(this.f15347f));
        this.f15348g = r15;
        if (r15 != 0.0f) goto L15;
        float r16 = Math.signum(r14);
    L16:
        this.f15349h = r16;
    L20:
        float r17 = this.f15348g;
        float r18 = r14 + r17;
        this.f15348g = r18;
        float r19 = Math.signum(r18);
        float r20 = this.f15349h;
        if (r19 == r20) goto L26;
        if (r20 == 0.0f) goto L26;
        if (r11 == false) goto L30;
        this.f15348g = 0.0f;
        this.f15349h = 0.0f;
        r18 = 0.0f;
    L31:
        this.f15347f = h((-b.f15353a.b(Math.abs(r18), this.f15343b)) * Math.signum(r18));
        this.f15350i = 1;
        this.f15351j = false;
        if (r13 == false) goto L40;
        if (r18 == 0.0f) goto L36;
        return r10;
    L36:
        if (r17 != 0.0f) goto L43;
        return r10;
    L43:
        return -h(r17);
    L40:
        return 0.0f;
    L30:
        this.f15349h = Math.signum(r18);
    L26:
        if (this.f15348g != 0.0f) goto L31;
        this.f15349h = 0.0f;
        goto L31
    L15:
        r16 = Math.signum(r15);
        goto L16
    L18:
        if (this.f15349h != 0.0f) goto L20;
        this.f15349h = Math.signum(r14);
    L41:
        return 0.0f;
    L5:
        r13 = false;
        goto L7
    }

    public final void g() {
        float r10 = b(this.f15347f);
        this.f15344c = AnimationUtils.currentAnimationTimeMillis();
        this.f15346e.a((-r10) / 100.0f, r10);
        this.f15350i = 2;
        this.f15351j = false;
    }

    public final float h(float r10) {
        return TypedValue.applyDimension(1, r10, this.f15352k);
    }

    public final void i(int r10) {
        this.f15343b = b(r10);
    }
}
