package com.obric.oui.material;

import android.content.res.ColorStateList;

/* JADX INFO: compiled from: MaterialConfigCore.java */
/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ColorStateList f35486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.oui.c.b f35487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.obric.oui.color.b[] f35488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.obric.oui.c.d f35489d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.obric.oui.color.f f35490e;
    private com.obric.oui.c.b f;
    private com.obric.oui.blur.b g;
    private Float h;
    private com.obric.oui.shadow.b[] i;
    private com.obric.oui.fluid.b j;

    public e() {
        this(null, null, null, null, null, null, null, null, null, null);
    }

    public e(ColorStateList r1, com.obric.oui.c.b r2, com.obric.oui.color.b[] r3, com.obric.oui.c.d r4, com.obric.oui.color.f r5, com.obric.oui.c.b r6, com.obric.oui.blur.b r7, Float r8, com.obric.oui.shadow.b[] r9, com.obric.oui.fluid.b r10) {
        this.f35486a = r1;
        this.f35487b = r2;
        this.f35488c = r3;
        this.f35489d = r4;
        this.f35490e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
    }

    public ColorStateList a() {
        return this.f35486a;
    }

    public com.obric.oui.c.b b() {
        return this.f35487b;
    }

    public com.obric.oui.color.b[] c() {
        return this.f35488c;
    }

    public com.obric.oui.c.d d() {
        return this.f35489d;
    }

    public com.obric.oui.color.f e() {
        return this.f35490e;
    }

    public com.obric.oui.c.b f() {
        return this.f;
    }

    public com.obric.oui.blur.b g() {
        return this.g;
    }

    public Float h() {
        return this.h;
    }

    public com.obric.oui.shadow.b[] i() {
        return this.i;
    }

    public com.obric.oui.fluid.b j() {
        return this.j;
    }

    public e k() {
        ColorStateList r0 = this.f35486a;
        if (r0 == null) goto L5;
        ColorStateList r2 = r0;
    L6:
        com.obric.oui.c.b r1 = this.f35487b;
        if (r1 == null) goto L9;
        com.obric.oui.c.b r3 = r1.b();
    L10:
        com.obric.oui.color.b[] r4 = com.obric.oui.color.b.a(this.f35488c);
        com.obric.oui.c.d r5 = this.f35489d;
        if (r5 == null) goto L13;
        com.obric.oui.c.d r6 = r5.b();
    L14:
        com.obric.oui.color.f r7 = this.f35490e;
        if (r7 == null) goto L17;
        com.obric.oui.color.f r8 = r7.d();
    L18:
        com.obric.oui.c.b r9 = this.f;
        if (r9 == null) goto L21;
        com.obric.oui.c.b r10 = r9.b();
    L22:
        com.obric.oui.blur.b r11 = this.g;
        if (r11 == null) goto L25;
        com.obric.oui.blur.b r12 = r11.f();
    L26:
        Float r13 = this.h;
        com.obric.oui.shadow.b[] r14 = com.obric.oui.shadow.b.a(this.i);
        com.obric.oui.fluid.b r15 = this.j;
        if (r15 == null) goto L29;
        com.obric.oui.fluid.b r16 = r15.b();
    L31:
        return new e(r2, r3, r4, r6, r8, r10, r12, r13, r14, r16);
    L29:
        r16 = null;
        goto L31
    L25:
        r12 = null;
        goto L26
    L21:
        r10 = null;
        goto L22
    L17:
        r8 = null;
        goto L18
    L13:
        r6 = null;
        goto L14
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }
}
