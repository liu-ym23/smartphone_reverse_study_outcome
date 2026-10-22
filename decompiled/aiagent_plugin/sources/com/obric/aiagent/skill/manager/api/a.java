package com.obric.aiagent.skill.manager.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19153b;

    public static /* synthetic */ a a(a r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.f19152a;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.f19153b;
    L9:
        return r0.a(r1, r2);
    }

    public final a a(String r1, String r2) {
        d.h.b.o.e(r1, "packageName");
        d.h.b.o.e(r2, "contentFingerprint");
        return new a(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19152a, r6.f19152a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19153b, r6.f19153b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f19152a.hashCode() * 31) + this.f19153b.hashCode();
    }

    public String toString() {
        return "AppFunctionInfo(packageName=" + this.f19152a + ", contentFingerprint=" + this.f19153b + ')';
    }

    public a(String r2, String r3) {
        d.h.b.o.e(r2, "packageName");
        d.h.b.o.e(r3, "contentFingerprint");
        this.f19152a = r2;
        this.f19153b = r3;
    }

    public final String a() {
        return this.f19152a;
    }

    public final String b() {
        return this.f19153b;
    }
}
