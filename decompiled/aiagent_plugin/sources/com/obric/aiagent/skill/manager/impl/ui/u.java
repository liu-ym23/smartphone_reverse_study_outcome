package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillCoverBinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f20820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f20821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f20822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f20823d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, u.class) == true) goto L8;
        return false;
    L8:
        u r6 = (u) ZeusTransformUtils.preCheckCast(r5, u.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f20820a, r6.f20820a) == true) goto L12;
        return false;
    L12:
        if (Float.compare(this.f20821b, r6.f20821b) == 0) goto L15;
        return false;
    L15:
        if (this.f20822c == r6.f20822c) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f20823d, r6.f20823d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f20820a.hashCode() * 31) + Float.hashCode(this.f20821b)) * 31) + Boolean.hashCode(this.f20822c)) * 31) + this.f20823d.hashCode();
    }

    public String toString() {
        return "SkillCoverBindingToken(canonicalUrl=" + this.f20820a + ", radiusPx=" + this.f20821b + ", fallbackToDefault=" + this.f20822c + ", requestUrl=" + this.f20823d + ')';
    }

    public u(String r2, float r3, boolean r4, String r5) {
        d.h.b.o.e(r2, "canonicalUrl");
        d.h.b.o.e(r5, "requestUrl");
        this.f20820a = r2;
        this.f20821b = r3;
        this.f20822c = r4;
        this.f20823d = r5;
    }

    public final String a() {
        return this.f20820a;
    }

    public final float b() {
        return this.f20821b;
    }

    public final boolean c() {
        return this.f20822c;
    }

    public final void a(String r2) {
        d.h.b.o.e(r2, "<set-?>");
        this.f20823d = r2;
    }

    public final String d() {
        return this.f20823d;
    }
}
