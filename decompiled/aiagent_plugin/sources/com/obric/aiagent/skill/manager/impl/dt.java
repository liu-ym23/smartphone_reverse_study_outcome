package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillTrackingSchema.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class dt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final dr f19770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ds f19772c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, dt.class) == true) goto L8;
        return false;
    L8:
        dt r6 = (dt) ZeusTransformUtils.preCheckCast(r5, dt.class, "com.obric.aiagent.plugin");
        if (this.f19770a == r6.f19770a) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19771b, r6.f19771b) == true) goto L15;
        return false;
    L15:
        if (this.f19772c == r6.f19772c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f19770a.hashCode() * 31) + this.f19771b.hashCode()) * 31) + this.f19772c.hashCode();
    }

    public String toString() {
        return "SkillPageTrackingContext(currentPage=" + this.f19770a + ", previousPage=" + this.f19771b + ", enterMethod=" + this.f19772c + ')';
    }

    public dt(dr r2, String r3, ds r4) {
        d.h.b.o.e(r2, "currentPage");
        d.h.b.o.e(r3, "previousPage");
        d.h.b.o.e(r4, "enterMethod");
        this.f19770a = r2;
        this.f19771b = r3;
        this.f19772c = r4;
    }

    public final dr a() {
        return this.f19770a;
    }

    public final String b() {
        return this.f19771b;
    }

    public final ds c() {
        return this.f19772c;
    }
}
