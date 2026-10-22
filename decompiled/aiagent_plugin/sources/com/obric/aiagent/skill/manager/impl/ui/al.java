package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillFormFileState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class al {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bb f20535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final bb f20536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ap f20537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ak f20538d;

    public static /* synthetic */ al a(al r0, bb r1, bb r2, ap r3, ak r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.f20535a;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.f20536b;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.f20537c;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.f20538d;
    L15:
        return r0.a(r1, r2, r3, r4);
    }

    public final al a(bb r1, bb r2, ap r3, ak r4) {
        d.h.b.o.e(r1, "snapshot");
        d.h.b.o.e(r2, "baseline");
        d.h.b.o.e(r3, "fieldMode");
        return new al(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, al.class) == true) goto L8;
        return false;
    L8:
        al r6 = (al) ZeusTransformUtils.preCheckCast(r5, al.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f20535a, r6.f20535a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f20536b, r6.f20536b) == true) goto L15;
        return false;
    L15:
        if (this.f20537c == r6.f20537c) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f20538d, r6.f20538d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.f20535a.hashCode() * 31) + this.f20536b.hashCode()) * 31) + this.f20537c.hashCode()) * 31;
        ak r2 = this.f20538d;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "SkillFormContentState(snapshot=" + this.f20535a + ", baseline=" + this.f20536b + ", fieldMode=" + this.f20537c + ", attachmentRestorePoint=" + this.f20538d + ')';
    }

    public al(bb r2, bb r3, ap r4, ak r5) {
        d.h.b.o.e(r2, "snapshot");
        d.h.b.o.e(r3, "baseline");
        d.h.b.o.e(r4, "fieldMode");
        this.f20535a = r2;
        this.f20536b = r3;
        this.f20537c = r4;
        this.f20538d = r5;
    }

    public final bb a() {
        return this.f20535a;
    }

    public final bb b() {
        return this.f20536b;
    }

    public /* synthetic */ al(bb r1, bb r2, ap r3, ak r4, int r5, d.h.b.h r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = r1;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = ap.f20549a;
    L9:
        if ((r5 & 8) == 0) goto L11;
        r4 = null;
    L11:
        this(r1, r2, r3, r4);
    }

    public final ap c() {
        return this.f20537c;
    }

    public final al a(bb r9) {
        d.h.b.o.e(r9, "nextSnapshot");
        return a(this, r9, null, null, null, 14, null);
    }

    public final bg<al> a(com.obric.aiagent.skill.manager.impl.cb r10, ao r11) {
        d.h.b.o.e(r10, "draft");
        d.h.b.o.e(r11, "limits");
        bg r12 = this.f20535a.a(r10, r11);
        if (ZeusTransformUtils.instanceOf(r12, bg.a.class) == false) goto L6;
        return r12;
    L6:
        if (ZeusTransformUtils.instanceOf(r12, bg.b.class) == false) goto L10;
        return (bg) ZeusTransformUtils.preCheckCast(new bg.b(a(this, (bb) ZeusTransformUtils.preCheckCast(((bg.b) ZeusTransformUtils.preCheckCast(r12, bg.b.class, "com.obric.aiagent.plugin")).a(), bb.class, "com.obric.aiagent.plugin"), (bb) ZeusTransformUtils.preCheckCast(((bg.b) ZeusTransformUtils.preCheckCast(r12, bg.b.class, "com.obric.aiagent.plugin")).a(), bb.class, "com.obric.aiagent.plugin"), null, new ak(this.f20535a, this.f20536b), 4, null)), bg.class, "com.obric.aiagent.plugin");
    L10:
        throw new d.k();
    }

    public final al d() {
        ak r0 = this.f20538d;
        if (r0 != null) goto L6;
        return this;
    L6:
        return a(this, r0.a(), r0.b(), null, null, 4, null);
    }
}
