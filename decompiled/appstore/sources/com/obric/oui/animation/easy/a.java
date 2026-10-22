package com.obric.oui.animation.easy;

import com.obric.oui.animation.engine.DynamicAnimation;
import com.obric.oui.animation.engine.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final C0190a f12281r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final float f12282s = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f12283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f12285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f12286d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f12287e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f12288f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f12289g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f12290h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f12291i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f12292j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f12293k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f12294l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f12295m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public DynamicAnimation.OnAnimationUpdateListener f12296n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public DynamicAnimation.OnAnimationEndListener f12297o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f12298p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f12299q;

    /* JADX INFO: renamed from: com.obric.oui.animation.easy.a$a, reason: collision with other inner class name */
    public static final class C0190a {
        public /* synthetic */ C0190a(DefaultConstructorMarker r10) {
            this();
        }

        public C0190a() {
        }
    }

    static {
        f12281r = new C0190a(null);
        f12282s = Float.MAX_VALUE;
    }

    public a(float r10) {
        this.f12283a = r10;
        float r11 = f12282s;
        this.f12285c = r11;
        this.f12287e = r11;
        this.f12288f = Float.MAX_VALUE;
        this.f12289g = -Float.MAX_VALUE;
        this.f12291i = 0.5f;
        this.f12292j = 0.5f;
        this.f12294l = 1500.0f;
        this.f12295m = 1500.0f;
    }

    public final void a(com.obric.oui.animation.engine.b r10) {
        q.g(r10, "animation");
        if (this.f12298p == false) goto L6;
        r10.w();
    L8:
        r10.k(this.f12289g);
        r10.j(this.f12288f);
        if (this.f12284b == false) goto L12;
        r10.m(this.f12285c);
    L12:
        if (this.f12286d == false) goto L15;
        r10.n(this.f12287e);
    L15:
        if (r10.s() != null) goto L17;
        r10.v(new c());
    L17:
        r10.s().c(b());
        r10.s().e(c());
        r10.s().d(this.f12283a);
        if (r10.g() == true) goto L23;
        DynamicAnimation.OnAnimationUpdateListener r11 = this.f12296n;
        if (r11 == null) goto L23;
        r10.b(r11);
    L23:
        if (r10.g() == true) goto L28;
        DynamicAnimation.OnAnimationEndListener r12 = this.f12297o;
        if (r12 == null) goto L29;
        r10.a(r12);
        return;
    L29:
        return;
    L28:
        return;
    L6:
        if (this.f12299q == false) goto L8;
        r10.c();
        goto L8
    }

    public final float b() {
        if (this.f12290h == false) goto L6;
        return this.f12292j;
    L6:
        return this.f12291i;
    }

    public final float c() {
        if (this.f12293k == false) goto L6;
        return this.f12295m;
    L6:
        return this.f12294l;
    }

    public final void d(float r10) {
        this.f12290h = true;
        this.f12292j = r10;
    }

    public final void e(float r10) {
        this.f12291i = r10;
    }

    public final void f(float r10) {
        this.f12294l = r10;
    }

    public final void g(float r10) {
        this.f12284b = true;
        this.f12285c = r10;
    }

    public final void h(float r10) {
        this.f12293k = true;
        this.f12295m = r10;
    }
}
