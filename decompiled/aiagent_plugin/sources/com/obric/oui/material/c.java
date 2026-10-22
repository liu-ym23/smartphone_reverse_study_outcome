package com.obric.oui.material;

import android.content.res.ColorStateList;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: MaterialConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ColorStateList f35480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.oui.c.a f35481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.obric.oui.color.a[] f35482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.obric.oui.c.c f35483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.obric.oui.color.e f35484e;
    private com.obric.oui.c.a f;
    private com.obric.oui.blur.a g;
    private Float h;
    private com.obric.oui.shadow.a[] i;
    private com.obric.oui.fluid.a j;

    public c() {
        this(null, null, null, null, null, null, null, null, null, null, DownloadErrorCode.ERROR_IO, null);
    }

    public String toString() {
        return "MaterialConfig(fallbackBgColor=" + this.f35480a + ", blendConfigStateList=" + this.f35481b + ", blendConfig=" + Arrays.toString(this.f35482c) + ", strokeStateList=" + this.f35483d + ", stroke=" + this.f35484e + ", overlayBlendConfigStateList=" + this.f + ", blurConfig=" + this.g + ", blurRadius=" + this.h + ", shadow=" + Arrays.toString(this.i) + ", fluid=" + this.j + ')';
    }

    public c(ColorStateList r1, com.obric.oui.c.a r2, com.obric.oui.color.a[] r3, com.obric.oui.c.c r4, com.obric.oui.color.e r5, com.obric.oui.c.a r6, com.obric.oui.blur.a r7, Float r8, com.obric.oui.shadow.a[] r9, com.obric.oui.fluid.a r10) {
        this.f35480a = r1;
        this.f35481b = r2;
        this.f35482c = r3;
        this.f35483d = r4;
        this.f35484e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
    }

    public /* synthetic */ c(ColorStateList r2, com.obric.oui.c.a r3, com.obric.oui.color.a[] r4, com.obric.oui.c.c r5, com.obric.oui.color.e r6, com.obric.oui.c.a r7, com.obric.oui.blur.a r8, Float r9, com.obric.oui.shadow.a[] r10, com.obric.oui.fluid.a r11, int r12, d.h.b.h r13) {
        if ((r12 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r12 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r12 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r12 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r12 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r12 & 128) == 0) goto L27;
        r9 = null;
    L27:
        if ((r12 & 256) == 0) goto L30;
        r10 = null;
    L30:
        if ((r12 & 512) == 0) goto L32;
        r11 = null;
    L32:
        this(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public final ColorStateList a() {
        return this.f35480a;
    }

    public final void a(ColorStateList r1) {
        this.f35480a = r1;
    }

    public final void a(com.obric.oui.c.a r1) {
        this.f35481b = r1;
    }

    public final com.obric.oui.c.a b() {
        return this.f35481b;
    }

    public final void a(com.obric.oui.color.a[] r1) {
        this.f35482c = r1;
    }

    public final com.obric.oui.color.a[] c() {
        return this.f35482c;
    }

    public final void a(com.obric.oui.c.c r1) {
        this.f35483d = r1;
    }

    public final com.obric.oui.c.c d() {
        return this.f35483d;
    }

    public final void a(com.obric.oui.color.e r1) {
        this.f35484e = r1;
    }

    public final com.obric.oui.color.e e() {
        return this.f35484e;
    }

    public final void b(com.obric.oui.c.a r1) {
        this.f = r1;
    }

    public final com.obric.oui.c.a f() {
        return this.f;
    }

    public final com.obric.oui.blur.a g() {
        return this.g;
    }

    public final Float h() {
        return this.h;
    }

    public final com.obric.oui.shadow.a[] i() {
        return this.i;
    }

    public final void a(com.obric.oui.fluid.a r1) {
        this.j = r1;
    }

    public final com.obric.oui.fluid.a j() {
        return this.j;
    }

    public final e k() {
        ColorStateList r1 = this.f35480a;
        com.obric.oui.c.a r0 = this.f35481b;
        if (r0 != null) goto L5;
        com.obric.oui.c.b r3 = null;
    L6:
        com.obric.oui.color.a[] r2 = this.f35482c;
        if (r2 != null) goto L9;
        com.obric.oui.color.b[] r4 = null;
    L10:
        com.obric.oui.c.c r5 = this.f35483d;
        if (r5 != null) goto L13;
        com.obric.oui.c.d r6 = null;
    L14:
        com.obric.oui.color.e r7 = this.f35484e;
        if (r7 != null) goto L17;
        com.obric.oui.color.f r8 = null;
    L18:
        com.obric.oui.c.a r9 = this.f;
        if (r9 != null) goto L21;
        com.obric.oui.c.b r10 = null;
    L22:
        com.obric.oui.blur.a r11 = this.g;
        if (r11 != null) goto L25;
        com.obric.oui.blur.b r12 = null;
    L26:
        Float r13 = this.h;
        com.obric.oui.shadow.a[] r14 = this.i;
        if (r14 != null) goto L29;
        com.obric.oui.shadow.b[] r15 = null;
    L30:
        com.obric.oui.fluid.a r16 = this.j;
        if (r16 != null) goto L33;
        com.obric.oui.fluid.b r17 = null;
    L35:
        return new e(r1, r3, r4, r6, r8, r10, r12, r13, r15, r17);
    L33:
        r17 = r16.b();
        goto L35
    L29:
        r15 = f.a(r14);
        goto L30
    L25:
        r12 = r11.f();
        goto L26
    L21:
        r10 = r9.b();
        goto L22
    L17:
        r8 = r7.d();
        goto L18
    L13:
        r6 = r5.b();
        goto L14
    L9:
        r4 = com.obric.oui.color.c.a(r2);
        goto L10
    L5:
        r3 = r0.b();
        goto L6
    }

    public final c l() {
        e r0 = k().k();
        d.h.b.o.c(r0, "toCore().deepCopy()");
        c r1 = f.a(r0);
        ColorStateList r2 = a();
        if (r2 != null) goto L5;
        ColorStateList r3 = null;
    L6:
        r1.a(r3);
        return r1;
    L5:
        r3 = f.a(r2);
        goto L6
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L5;
        return true;
    L5:
        Class<?> r2 = getClass();
        if (r7 != null) goto L8;
        Class<?> r3 = null;
    L10:
        if (d.h.b.o.a(r2, r3) == true) goto L12;
        return false;
    L12:
        Objects.requireNonNull(r7, "null cannot be cast to non-null type com.obric.oui.material.MaterialConfig");
        c r4 = (c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.h, ((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin")).h) == true) goto L16;
        return false;
    L16:
        if (d.h.b.o.a(this.f35480a, ((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin")).f35480a) == true) goto L19;
        return false;
    L19:
        if (d.h.b.o.a(this.f35481b, ((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin")).f35481b) == true) goto L22;
        return false;
    L22:
        if (Arrays.equals(this.f35482c, ((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin")).f35482c) == true) goto L25;
        return false;
    L25:
        if (d.h.b.o.a(this.f35483d, ((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin")).f35483d) == true) goto L28;
        return false;
    L28:
        if (d.h.b.o.a(this.f35484e, ((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin")).f35484e) == true) goto L31;
        return false;
    L31:
        if (d.h.b.o.a(this.f, ((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin")).f) == true) goto L34;
        return false;
    L34:
        if (d.h.b.o.a(this.g, ((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin")).g) == true) goto L37;
        return false;
    L37:
        if (Arrays.equals(this.i, ((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin")).i) == true) goto L40;
        return false;
    L40:
        if (d.h.b.o.a(this.j, ((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin")).j) == true) goto L42;
        return false;
    L42:
        return true;
    L8:
        r3 = r7.getClass();
        goto L10
    }

    public int hashCode() {
        Float r0 = this.h;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        ColorStateList r4 = this.f35480a;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        com.obric.oui.c.a r7 = this.f35481b;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        com.obric.oui.color.a[] r10 = this.f35482c;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        com.obric.oui.c.c r13 = this.f35483d;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        com.obric.oui.color.e r16 = this.f35484e;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        com.obric.oui.c.a r19 = this.f;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        com.obric.oui.blur.a r22 = this.g;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        com.obric.oui.shadow.a[] r25 = this.i;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        com.obric.oui.fluid.a r28 = this.j;
        if (r28 == null) goto L43;
        r1 = r28.hashCode();
    L43:
        return r27 + r1;
    L37:
        r26 = Arrays.hashCode(r25);
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = Arrays.hashCode(r10);
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }
}
