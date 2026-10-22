package com.obric.oui.material;

import android.content.res.ColorStateList;
import com.obric.oui.color.j0;
import com.obric.oui.color.k0;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ColorStateList f15215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ld.a f15216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.obric.oui.color.a[] f15217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ld.c f15218d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public j0 f15219e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ld.a f15220f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public pc.a f15221g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Float f15222h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.obric.oui.shadow.a[] f15223i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.obric.oui.fluid.a f15224j;

    public b(ColorStateList r10, ld.a r11, com.obric.oui.color.a[] r12, ld.c r13, j0 r14, ld.a r15, pc.a r16, Float r17, com.obric.oui.shadow.a[] r18, com.obric.oui.fluid.a r19) {
        this.f15215a = r10;
        this.f15216b = r11;
        this.f15217c = r12;
        this.f15218d = r13;
        this.f15219e = r14;
        this.f15220f = r15;
        this.f15221g = r16;
        this.f15222h = r17;
        this.f15223i = r18;
        this.f15224j = r19;
    }

    public final b a() {
        d r10 = u().a();
        kotlin.jvm.internal.q.f(r10, "toCore().deepCopy()");
        b r11 = e.b(r10);
        ColorStateList r12 = f();
        if (r12 != null) goto L5;
        ColorStateList r13 = null;
    L6:
        r11.o(r13);
        return r11;
    L5:
        r13 = e.a(r12);
        goto L6
    }

    public final com.obric.oui.color.a[] b() {
        return this.f15217c;
    }

    public final ld.a c() {
        return this.f15216b;
    }

    public final pc.a d() {
        return this.f15221g;
    }

    public final Float e() {
        return this.f15222h;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L5;
        return true;
    L5:
        if (r10 != null) goto L7;
        Class<?> r11 = null;
    L9:
        if (kotlin.jvm.internal.q.b(b.class, r11) == true) goto L11;
        return false;
    L11:
        if (r10 == null) goto L44;
        b r12 = (b) r10;
        if (kotlin.jvm.internal.q.a(this.f15222h, r12.f15222h) == true) goto L16;
        return false;
    L16:
        if (kotlin.jvm.internal.q.b(this.f15215a, r12.f15215a) == true) goto L19;
        return false;
    L19:
        if (kotlin.jvm.internal.q.b(this.f15216b, r12.f15216b) == true) goto L22;
        return false;
    L22:
        if (Arrays.equals(this.f15217c, r12.f15217c) == true) goto L25;
        return false;
    L25:
        if (kotlin.jvm.internal.q.b(this.f15218d, r12.f15218d) == true) goto L28;
        return false;
    L28:
        if (kotlin.jvm.internal.q.b(this.f15219e, r12.f15219e) == true) goto L31;
        return false;
    L31:
        if (kotlin.jvm.internal.q.b(this.f15220f, r12.f15220f) == true) goto L34;
        return false;
    L34:
        if (kotlin.jvm.internal.q.b(this.f15221g, r12.f15221g) == true) goto L37;
        return false;
    L37:
        if (Arrays.equals(this.f15223i, r12.f15223i) == true) goto L40;
        return false;
    L40:
        if (kotlin.jvm.internal.q.b(this.f15224j, r12.f15224j) == true) goto L42;
        return false;
    L42:
        return true;
    L44:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.material.MaterialConfig");
    L7:
        r11 = r10.getClass();
        goto L9
    }

    public final ColorStateList f() {
        return this.f15215a;
    }

    public final com.obric.oui.fluid.a g() {
        return this.f15224j;
    }

    public final ld.a h() {
        return this.f15220f;
    }

    public int hashCode() {
        Float r10 = this.f15222h;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        ColorStateList r14 = this.f15215a;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        ld.a r17 = this.f15216b;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        com.obric.oui.color.a[] r20 = this.f15217c;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (r19 + r21) * 31;
        ld.c r23 = this.f15218d;
        if (r23 != null) goto L21;
        int r24 = 0;
    L22:
        int r25 = (r22 + r24) * 31;
        j0 r26 = this.f15219e;
        if (r26 != null) goto L25;
        int r27 = 0;
    L26:
        int r28 = (r25 + r27) * 31;
        ld.a r29 = this.f15220f;
        if (r29 != null) goto L29;
        int r30 = 0;
    L30:
        int r31 = (r28 + r30) * 31;
        pc.a r32 = this.f15221g;
        if (r32 != null) goto L33;
        int r33 = 0;
    L34:
        int r34 = (r31 + r33) * 31;
        com.obric.oui.shadow.a[] r35 = this.f15223i;
        if (r35 != null) goto L37;
        int r36 = 0;
    L38:
        int r37 = (r34 + r36) * 31;
        com.obric.oui.fluid.a r38 = this.f15224j;
        if (r38 == null) goto L43;
        r11 = r38.hashCode();
    L43:
        return r37 + r11;
    L37:
        r36 = Arrays.hashCode(r35);
        goto L38
    L33:
        r33 = r32.hashCode();
        goto L34
    L29:
        r30 = r29.hashCode();
        goto L30
    L25:
        r27 = r26.hashCode();
        goto L26
    L21:
        r24 = r23.hashCode();
        goto L22
    L17:
        r21 = Arrays.hashCode(r20);
        goto L18
    L13:
        r18 = r17.hashCode();
        goto L14
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public final com.obric.oui.shadow.a[] i() {
        return this.f15223i;
    }

    public final j0 j() {
        return this.f15219e;
    }

    public final ld.c k() {
        return this.f15218d;
    }

    public final void l(com.obric.oui.color.a[] r10) {
        this.f15217c = r10;
    }

    public final void m(ld.a r10) {
        this.f15216b = r10;
    }

    public final void n(pc.a r10) {
        this.f15221g = r10;
    }

    public final void o(ColorStateList r10) {
        this.f15215a = r10;
    }

    public final void p(com.obric.oui.fluid.a r10) {
        this.f15224j = r10;
    }

    public final void q(ld.a r10) {
        this.f15220f = r10;
    }

    public final void r(com.obric.oui.shadow.a[] r10) {
        this.f15223i = r10;
    }

    public final void s(j0 r10) {
        this.f15219e = r10;
    }

    public final void t(ld.c r10) {
        this.f15218d = r10;
    }

    public String toString() {
        return "MaterialConfig(fallbackBgColor=" + this.f15215a + ", blendConfigStateList=" + this.f15216b + ", blendConfig=" + Arrays.toString(this.f15217c) + ", strokeStateList=" + this.f15218d + ", stroke=" + this.f15219e + ", overlayBlendConfigStateList=" + this.f15220f + ", blurConfig=" + this.f15221g + ", blurRadius=" + this.f15222h + ", shadow=" + Arrays.toString(this.f15223i) + ", fluid=" + this.f15224j + ')';
    }

    public final d u() {
        ColorStateList r10 = this.f15215a;
        ld.a r11 = this.f15216b;
        if (r11 != null) goto L5;
        ld.b r12 = null;
    L6:
        com.obric.oui.color.a[] r13 = this.f15217c;
        if (r13 != null) goto L9;
        com.obric.oui.color.b[] r14 = null;
    L10:
        ld.c r15 = this.f15218d;
        if (r15 != null) goto L13;
        ld.d r16 = null;
    L14:
        j0 r17 = this.f15219e;
        if (r17 != null) goto L17;
        k0 r18 = null;
    L18:
        ld.a r19 = this.f15220f;
        if (r19 != null) goto L21;
        ld.b r20 = null;
    L22:
        pc.a r21 = this.f15221g;
        if (r21 != null) goto L25;
        pc.b r22 = null;
    L26:
        Float r23 = this.f15222h;
        com.obric.oui.shadow.a[] r24 = this.f15223i;
        if (r24 != null) goto L29;
        com.obric.oui.shadow.b[] r110 = null;
    L30:
        com.obric.oui.fluid.a r111 = this.f15224j;
        if (r111 != null) goto L33;
        com.obric.oui.fluid.b r112 = null;
    L35:
        return new d(r10, r12, r14, r16, r18, r20, r22, r23, r110, r112);
    L33:
        r112 = r111.b();
        goto L35
    L29:
        r110 = e.g(r24);
        goto L30
    L25:
        r22 = r21.h();
        goto L26
    L21:
        r20 = r19.d();
        goto L22
    L17:
        r18 = r17.d();
        goto L18
    L13:
        r16 = r15.d();
        goto L14
    L9:
        r14 = com.obric.oui.color.c.c(r13);
        goto L10
    L5:
        r12 = r11.d();
        goto L6
    }

    public /* synthetic */ b(ColorStateList r10, ld.a r11, com.obric.oui.color.a[] r12, ld.c r13, j0 r14, ld.a r15, pc.a r16, Float r17, com.obric.oui.shadow.a[] r18, com.obric.oui.fluid.a r19, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r110 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r110 & 4) == 0) goto L12;
        r12 = null;
    L12:
        if ((r110 & 8) == 0) goto L15;
        r13 = null;
    L15:
        if ((r110 & 16) == 0) goto L18;
        r14 = null;
    L18:
        if ((r110 & 32) == 0) goto L21;
        r15 = null;
    L21:
        if ((r110 & 64) == 0) goto L24;
        r16 = null;
    L24:
        if ((r110 & 128) == 0) goto L27;
        r17 = null;
    L27:
        if ((r110 & 256) == 0) goto L30;
        r18 = null;
    L30:
        if ((r110 & 512) == 0) goto L32;
        r19 = null;
    L32:
        this(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }
}
