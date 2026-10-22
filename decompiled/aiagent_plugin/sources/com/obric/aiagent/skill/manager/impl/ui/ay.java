package com.obric.aiagent.skill.manager.impl.ui;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillFormSheetController.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ax f20587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f20588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final bb f20589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ao f20590d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final aw f20591e;
    private final am f;
    private final bd g;
    private final as h;
    private final ap i;
    private final boolean j;
    private final d.h.a.a<d.x> k;
    private final d.h.a.a<d.x> l;
    private final d.h.a.q<bb, String, bc, d.x> m;

    /* JADX INFO: renamed from: lambda$J5zOBYmC_rH0-f38y9rFWfhN8Jc, reason: not valid java name */
    public static /* synthetic */ d.x m328lambda$J5zOBYmC_rH0f38y9rFWfhN8Jc() {
        return n();
    }

    public static /* synthetic */ d.x lambda$olFVl8qI69yEBP1Hx9_8cjYY5QY() {
        return o();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ay.class) == true) goto L8;
        return false;
    L8:
        ay r6 = (ay) ZeusTransformUtils.preCheckCast(r5, ay.class, "com.obric.aiagent.plugin");
        if (this.f20587a == r6.f20587a) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f20588b, r6.f20588b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f20589c, r6.f20589c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f20590d, r6.f20590d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f20591e, r6.f20591e) == true) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (d.h.b.o.a(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (d.h.b.o.a(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (d.h.b.o.a(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (d.h.b.o.a(this.m, r6.m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((((((((((((((((this.f20587a.hashCode() * 31) + this.f20588b.hashCode()) * 31) + this.f20589c.hashCode()) * 31) + this.f20590d.hashCode()) * 31) + this.f20591e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + Boolean.hashCode(this.j)) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31;
        d.h.a.q<bb, String, bc, d.x> r2 = this.m;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("SkillFormSheetConfig(mode=").append(this.f20587a).append(", title=").append(this.f20588b).append(", initialValues=").append(this.f20589c).append(", limits=").append(this.f20590d).append(", importPreview=").append(this.f20591e).append(", cover=").append(this.f).append(", text=").append(this.g).append(", fileSection=").append(this.h).append(", initialFieldMode=").append(this.i).append(", validateTextFieldsOnSubmit=").append(this.j).append(", onClose=").append(this.k).append(", onDismiss=");
        r0.append(this.l).append(", onSubmit=").append(this.m).append(')');
        return r0.toString();
    }

    public ay(ax r3, String r4, bb r5, ao r6, aw r7, am r8, bd r9, as r10, ap r11, boolean r12, d.h.a.a<d.x> r13, d.h.a.a<d.x> r14, d.h.a.q<? super bb, ? super String, ? super bc, d.x> r15) {
        as r16 = (as) ZeusTransformUtils.wrapperContextForParams(r10, as.class, "com.obric.aiagent.plugin");
        d.h.a.a<d.x> r17 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a<d.x> r18 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.q<bb, String, bc, d.x> r19 = (d.h.a.q) ZeusTransformUtils.wrapperContextForParams(r15, d.h.a.q.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "mode");
        d.h.b.o.e(r4, DBDefinition.TITLE);
        d.h.b.o.e(r5, "initialValues");
        d.h.b.o.e(r6, "limits");
        d.h.b.o.e(r7, "importPreview");
        d.h.b.o.e(r8, "cover");
        d.h.b.o.e(r9, "text");
        d.h.b.o.e(r16, "fileSection");
        d.h.b.o.e(r11, "initialFieldMode");
        d.h.b.o.e(r17, "onClose");
        d.h.b.o.e(r18, "onDismiss");
        this.f20587a = r3;
        this.f20588b = r4;
        this.f20589c = r5;
        this.f20590d = r6;
        this.f20591e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r16;
        this.i = r11;
        this.j = r12;
        this.k = r17;
        this.l = r18;
        this.m = r19;
    }

    public final ax a() {
        return this.f20587a;
    }

    public final String b() {
        return this.f20588b;
    }

    public final bb c() {
        return this.f20589c;
    }

    public final ao d() {
        return this.f20590d;
    }

    public /* synthetic */ ay(ax r24, String r25, bb r26, ao r27, aw r28, am r29, bd r30, as r31, ap r32, boolean r33, d.h.a.a r34, d.h.a.a r35, d.h.a.q r36, int r37, d.h.b.h r38) {
        as r1 = (as) ZeusTransformUtils.wrapperContextForParams(r31, as.class, "com.obric.aiagent.plugin");
        d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r34, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r35, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.q r5 = (d.h.a.q) ZeusTransformUtils.wrapperContextForParams(r36, d.h.a.q.class, "com.obric.aiagent.plugin");
        if ((r37 & 16) == 0) goto L5;
        aw r14 = new aw(null, null, 3, null);
    L7:
        if ((r37 & 128) == 0) goto L9;
        r1 = (as) ZeusTransformUtils.preCheckCast(as.a.f20562a, as.class, "com.obric.aiagent.plugin");
    L9:
        as r17 = r1;
        if ((r37 & 256) == 0) goto L12;
        ap r18 = ap.f20549a;
    L14:
        if ((r37 & 512) == 0) goto L16;
        boolean r19 = true;
    L18:
        if ((r37 & 1024) == 0) goto L20;
        r3 = $$Lambda$ay$J5zOBYmC_rH0f38y9rFWfhN8Jc.INSTANCE;
    L20:
        d.h.a.a r20 = r3;
        if ((r37 & 2048) == 0) goto L23;
        r4 = $$Lambda$ay$olFVl8qI69yEBP1Hx9_8cjYY5QY.INSTANCE;
    L23:
        d.h.a.a r21 = r4;
        if ((r37 & 4096) == 0) goto L26;
        d.h.a.q r22 = null;
    L27:
        this(r24, r25, r26, r27, r14, r29, r30, r17, r18, r19, r20, r21, r22);
        return;
    L26:
        r22 = r5;
        goto L27
    L16:
        r19 = r33;
        goto L18
    L12:
        r18 = r32;
        goto L14
    L5:
        r14 = r28;
        goto L7
    }

    public final aw e() {
        return this.f20591e;
    }

    public final am f() {
        return this.f;
    }

    public final bd g() {
        return this.g;
    }

    public final as h() {
        return this.h;
    }

    public final ap i() {
        return this.i;
    }

    public final boolean j() {
        return this.j;
    }

    private static final d.x n() {
        return d.x.f38692a;
    }

    public final d.h.a.a<d.x> k() {
        return this.k;
    }

    private static final d.x o() {
        return d.x.f38692a;
    }

    public final d.h.a.a<d.x> l() {
        return this.l;
    }

    public final d.h.a.q<bb, String, bc, d.x> m() {
        return this.m;
    }
}
