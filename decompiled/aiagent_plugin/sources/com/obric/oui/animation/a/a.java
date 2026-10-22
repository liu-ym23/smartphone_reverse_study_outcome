package com.obric.oui.animation.a;

import com.obric.oui.animation.engine.d;
import com.obric.oui.animation.engine.e;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: SpringAnimationConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0920a f33937a = null;
    private static final float s = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f33938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f33939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f33940d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f33941e;
    private float f;
    private float g;
    private float h;
    private boolean i;
    private float j;
    private float k;
    private boolean l;
    private float m;
    private float n;
    private com.obric.oui.animation.engine.b.c o;
    private com.obric.oui.animation.engine.b.InterfaceC0923b p;
    private boolean q;
    private boolean r;

    /* JADX INFO: renamed from: com.obric.oui.animation.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SpringAnimationConfig.kt */
    public static final class C0920a {
        public /* synthetic */ C0920a(h r1) {
            this();
        }

        private C0920a() {
        }
    }

    public a(float r1) {
        this.f33938b = r1;
        float r2 = s;
        this.f33940d = r2;
        this.f = r2;
        this.g = Float.MAX_VALUE;
        this.h = -Float.MAX_VALUE;
        this.j = 0.5f;
        this.k = 0.5f;
        this.m = 1500.0f;
        this.n = 1500.0f;
    }

    static {
        f33937a = new C0920a(null);
        s = Float.MAX_VALUE;
    }

    public final void a(float r2) {
        this.f33939c = true;
        this.f33940d = r2;
    }

    public final void b(float r1) {
        this.j = r1;
    }

    public final float a() {
        if (this.i == false) goto L6;
        return this.k;
    L6:
        return this.j;
    }

    public final void c(float r2) {
        this.i = true;
        this.k = r2;
    }

    public final void d(float r1) {
        this.m = r1;
    }

    public final float b() {
        if (this.l == false) goto L6;
        return this.n;
    L6:
        return this.m;
    }

    public final void e(float r2) {
        this.l = true;
        this.n = r2;
    }

    public final void a(d r3) {
        o.e(r3, "animation");
        if (this.q == false) goto L6;
        r3.f();
    L8:
        r3.d(this.h);
        r3.c(this.g);
        if (this.f33939c == false) goto L12;
        r3.a(this.f33940d);
    L12:
        if (this.f33941e == false) goto L15;
        r3.b(this.f);
    L15:
        if (r3.e() != null) goto L17;
        r3.a(new e());
    L17:
        r3.e().b(a());
        r3.e().a(b());
        r3.e().c(this.f33938b);
        if (r3.c() == true) goto L23;
        com.obric.oui.animation.engine.b.c r0 = this.o;
        if (r0 == null) goto L23;
        r3.a(r0);
    L23:
        if (r3.c() == true) goto L28;
        com.obric.oui.animation.engine.b.InterfaceC0923b r2 = this.p;
        if (r2 == null) goto L29;
        r3.a(r2);
        return;
    L29:
        return;
    L28:
        return;
    L6:
        if (this.r == false) goto L8;
        r3.b();
        goto L8
    }
}
