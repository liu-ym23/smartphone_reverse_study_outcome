package com.obric.oui.material;

import android.content.res.ColorStateList;
import com.obric.oui.color.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ColorStateList f15226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ld.b f15227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.obric.oui.color.b[] f15228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ld.d f15229d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public k0 f15230e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ld.b f15231f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public pc.b f15232g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Float f15233h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.obric.oui.shadow.b[] f15234i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.obric.oui.fluid.b f15235j;

    public d(ColorStateList r10, ld.b r11, com.obric.oui.color.b[] r12, ld.d r13, k0 r14, ld.b r15, pc.b r16, Float r17, com.obric.oui.shadow.b[] r18, com.obric.oui.fluid.b r19) {
        this.f15226a = r10;
        this.f15227b = r11;
        this.f15228c = r12;
        this.f15229d = r13;
        this.f15230e = r14;
        this.f15231f = r15;
        this.f15232g = r16;
        this.f15233h = r17;
        this.f15234i = r18;
        this.f15235j = r19;
    }

    public d a() {
        ColorStateList r10 = this.f15226a;
        if (r10 == null) goto L5;
        ColorStateList r11 = r10;
    L6:
        ld.b r12 = this.f15227b;
        if (r12 == null) goto L9;
        ld.b r13 = r12.c();
    L10:
        com.obric.oui.color.b[] r14 = com.obric.oui.color.b.f(this.f15228c);
        ld.d r15 = this.f15229d;
        if (r15 == null) goto L13;
        ld.d r16 = r15.a();
    L14:
        k0 r17 = this.f15230e;
        if (r17 == null) goto L17;
        k0 r18 = r17.a();
    L18:
        ld.b r19 = this.f15231f;
        if (r19 == null) goto L21;
        ld.b r20 = r19.c();
    L22:
        pc.b r21 = this.f15232g;
        if (r21 == null) goto L25;
        pc.b r22 = r21.a();
    L26:
        Float r23 = this.f15233h;
        com.obric.oui.shadow.b[] r110 = com.obric.oui.shadow.b.b(this.f15234i);
        com.obric.oui.fluid.b r111 = this.f15235j;
        if (r111 == null) goto L29;
        com.obric.oui.fluid.b r112 = r111.a();
    L31:
        return new d(r11, r13, r14, r16, r18, r20, r22, r23, r110, r112);
    L29:
        r112 = null;
        goto L31
    L25:
        r22 = null;
        goto L26
    L21:
        r20 = null;
        goto L22
    L17:
        r18 = null;
        goto L18
    L13:
        r16 = null;
        goto L14
    L9:
        r13 = null;
        goto L10
    L5:
        r11 = null;
        goto L6
    }

    public com.obric.oui.color.b[] b() {
        return this.f15228c;
    }

    public ld.b c() {
        return this.f15227b;
    }

    public pc.b d() {
        return this.f15232g;
    }

    public Float e() {
        return this.f15233h;
    }

    public ColorStateList f() {
        return this.f15226a;
    }

    public com.obric.oui.fluid.b g() {
        return this.f15235j;
    }

    public ld.b h() {
        return this.f15231f;
    }

    public com.obric.oui.shadow.b[] i() {
        return this.f15234i;
    }

    public k0 j() {
        return this.f15230e;
    }

    public ld.d k() {
        return this.f15229d;
    }
}
