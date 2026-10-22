package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillFormFileState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class bb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f20625a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final bb f20626e = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f20627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f20628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f20629d;

    /* JADX INFO: compiled from: SkillFormFileState.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    public static /* synthetic */ bb a(bb r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.f20627b;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.f20628c;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.f20629d;
    L12:
        return r0.a(r1, r2, r3);
    }

    public final bb a(String r1, String r2, String r3) {
        d.h.b.o.e(r1, "name");
        d.h.b.o.e(r2, "description");
        d.h.b.o.e(r3, "body");
        return new bb(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, bb.class) == true) goto L8;
        return false;
    L8:
        bb r6 = (bb) ZeusTransformUtils.preCheckCast(r5, bb.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f20627b, r6.f20627b) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f20628c, r6.f20628c) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f20629d, r6.f20629d) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f20627b.hashCode() * 31) + this.f20628c.hashCode()) * 31) + this.f20629d.hashCode();
    }

    public String toString() {
        return "SkillFormSnapshot(name=" + this.f20627b + ", description=" + this.f20628c + ", body=" + this.f20629d + ')';
    }

    public bb(String r2, String r3, String r4) {
        d.h.b.o.e(r2, "name");
        d.h.b.o.e(r3, "description");
        d.h.b.o.e(r4, "body");
        this.f20627b = r2;
        this.f20628c = r3;
        this.f20629d = r4;
    }

    public final String a() {
        return this.f20627b;
    }

    public final String b() {
        return this.f20628c;
    }

    public final String c() {
        return this.f20629d;
    }

    public final bb d() {
        return a(this, d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(this.f20627b, CharSequence.class, "com.obric.aiagent.plugin")).toString(), null, null, 6, null);
    }

    public final boolean e() {
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(this.f20627b, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L5;
    L9:
        return false;
    L5:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(this.f20628c, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L9;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(this.f20629d, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L9;
        return true;
    }

    public final boolean a(ao r3) {
        d.h.b.o.e(r3, "limits");
        if (this.f20627b.length() <= r3.a()) goto L5;
    L8:
        return true;
    L5:
        if (this.f20628c.length() > r3.b()) goto L8;
        return false;
    }

    public final boolean b(ao r2) {
        d.h.b.o.e(r2, "limits");
        if (e() == true) goto L5;
    L7:
        return false;
    L5:
        if (a(r2) == true) goto L7;
        return true;
    }

    public final boolean a(bb r2) {
        d.h.b.o.e(r2, "baseline");
        return !d.h.b.o.a(this, r2);
    }

    public final bg<bb> a(com.obric.aiagent.skill.manager.impl.cb r3, ao r4) {
        d.h.b.o.e(r3, "draft");
        d.h.b.o.e(r4, "limits");
        bb r2 = new bb(r3.b(), r3.c(), r3.d());
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2.f20627b, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L6;
        bf r5 = bf.f20636a;
    L15:
        if (r5 != null) goto L18;
        return (bg) ZeusTransformUtils.preCheckCast(new bg.b(r2), bg.class, "com.obric.aiagent.plugin");
    L18:
        return (bg) ZeusTransformUtils.preCheckCast(new bg.a(r5), bg.class, "com.obric.aiagent.plugin");
    L6:
        if (r2.f20627b.length() <= r4.a()) goto L9;
        r5 = bf.f20637b;
        goto L15
    L9:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2.f20628c, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L12;
        r5 = bf.f20638c;
        goto L15
    L12:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2.f20629d, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L14;
        r5 = bf.f20640e;
        goto L15
    L14:
        r5 = null;
        goto L15
    }

    public final bg<bb> b(com.obric.aiagent.skill.manager.impl.cb r3, ao r4) {
        d.h.b.o.e(r3, "draft");
        d.h.b.o.e(r4, "limits");
        bg<bb> r2 = a(r3, r4);
        if (ZeusTransformUtils.instanceOf(r2, bg.a.class) == false) goto L6;
        return r2;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, bg.b.class) == false) goto L13;
        if (((bb) ZeusTransformUtils.preCheckCast(((bg.b) ZeusTransformUtils.preCheckCast(r2, bg.b.class, "com.obric.aiagent.plugin")).a(), bb.class, "com.obric.aiagent.plugin")).f20628c.length() > r4.b()) goto L11;
        return r2;
    L11:
        return (bg) ZeusTransformUtils.preCheckCast(new bg.a(bf.f20639d), bg.class, "com.obric.aiagent.plugin");
    L13:
        throw new d.k();
    }

    static {
        f20625a = new a(null);
        f20626e = new bb("", "", "");
    }
}
