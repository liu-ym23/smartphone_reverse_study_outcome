package com.obric.common.oea.foundation.animation.e;

import com.obric.common.oea.foundation.animation.engine.e;
import com.obric.common.oea.foundation.animation.engine.f;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: SpringAnimationConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0881a f32347a = null;
    private static final float s = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f32348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f32349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f32350d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f32351e;
    private float f;
    private float g;
    private boolean h;
    private float i;
    private float j;
    private boolean k;
    private float l;
    private float m;
    private com.obric.common.oea.foundation.animation.engine.b.c n;
    private com.obric.common.oea.foundation.animation.engine.b.InterfaceC0883b o;
    private boolean p;
    private boolean q;
    private float r;

    /* JADX INFO: renamed from: com.obric.common.oea.foundation.animation.e.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SpringAnimationConfig.kt */
    public static final class C0881a {
        private C0881a() {
        }

        public /* synthetic */ C0881a(h r1) {
            this();
        }
    }

    static {
        f32347a = new C0881a(null);
        s = Float.MAX_VALUE;
    }

    public final float a() {
        if (this.h == false) goto L6;
        return this.j;
    L6:
        return this.i;
    }

    public final float b() {
        if (this.k == false) goto L6;
        return this.m;
    L6:
        return this.l;
    }

    public final void a(e r4) {
        o.e(r4, "animation");
        if (this.p == false) goto L6;
        r4.f();
    L8:
        r4.d(this.g);
        r4.c(this.f);
        if (this.f32348b == false) goto L12;
        r4.a(this.f32349c);
    L12:
        if (this.f32350d == false) goto L15;
        r4.b(this.f32351e);
    L15:
        if (r4.e() != null) goto L17;
        r4.a(new f());
    L17:
        f r0 = r4.e();
        o.c(r0, "animation.spring");
        r0.b(a());
        f r1 = r4.e();
        o.c(r1, "animation.spring");
        r1.a(b());
        f r2 = r4.e();
        o.c(r2, "animation.spring");
        r2.c(this.r);
        if (r4.c() == true) goto L23;
        com.obric.common.oea.foundation.animation.engine.b.c r3 = this.n;
        if (r3 == null) goto L23;
        r4.a(r3);
    L23:
        if (r4.c() == true) goto L28;
        com.obric.common.oea.foundation.animation.engine.b.InterfaceC0883b r5 = this.o;
        if (r5 == null) goto L29;
        r4.a(r5);
        return;
    L29:
        return;
    L28:
        return;
    L6:
        if (this.q == false) goto L8;
        r4.b();
        goto L8
    }
}
