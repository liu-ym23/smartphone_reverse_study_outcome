package com.obric.aiagent.skill.manager.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillOperationResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final t f19305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19306b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, s.class) == true) goto L8;
        return false;
    L8:
        s r6 = (s) ZeusTransformUtils.preCheckCast(r5, s.class, "com.obric.aiagent.plugin");
        if (this.f19305a == r6.f19305a) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19306b, r6.f19306b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f19305a.hashCode() * 31) + this.f19306b.hashCode();
    }

    public String toString() {
        return "SkillOperationFailureDetail(reason=" + this.f19305a + ", message=" + this.f19306b + ')';
    }

    public s(t r2, String r3) {
        d.h.b.o.e(r2, "reason");
        d.h.b.o.e(r3, "message");
        this.f19305a = r2;
        this.f19306b = r3;
    }

    public final t a() {
        return this.f19305a;
    }

    public final String b() {
        return this.f19306b;
    }
}
