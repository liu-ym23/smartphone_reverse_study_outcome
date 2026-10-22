package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillDerivedProperties.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class bd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final bb f19555c;

    public bd() {
        this(null, null, null, 7, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, bd.class) == true) goto L8;
        return false;
    L8:
        bd r6 = (bd) ZeusTransformUtils.preCheckCast(r5, bd.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19553a, r6.f19553a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19554b, r6.f19554b) == true) goto L15;
        return false;
    L15:
        if (this.f19555c == r6.f19555c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.f19553a.hashCode() * 31) + this.f19554b.hashCode()) * 31;
        bb r2 = this.f19555c;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "SkillDetailMetadata(sourceName=" + this.f19553a + ", date=" + this.f19554b + ", dateAction=" + this.f19555c + ')';
    }

    public bd(String r2, String r3, bb r4) {
        d.h.b.o.e(r2, "sourceName");
        d.h.b.o.e(r3, "date");
        this.f19553a = r2;
        this.f19554b = r3;
        this.f19555c = r4;
    }

    public /* synthetic */ bd(String r2, String r3, bb r4, int r5, d.h.b.h r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }

    public final String a() {
        return this.f19553a;
    }

    public final String b() {
        return this.f19554b;
    }

    public final bb c() {
        return this.f19555c;
    }

    public final boolean d() {
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(this.f19553a, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L5;
        return true;
    L5:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(this.f19554b, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L10;
        return false;
    L10:
        return true;
    }
}
