package com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppFunctionSkillManager.kt */
/* JADX INFO: loaded from: classes2.dex */
final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f18331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f18332b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, z.class) == true) goto L8;
        return false;
    L8:
        z r6 = (z) ZeusTransformUtils.preCheckCast(r5, z.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f18331a, r6.f18331a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f18332b, r6.f18332b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f18331a.hashCode() * 31) + this.f18332b.hashCode();
    }

    public String toString() {
        return "AppFunctionSkillIdentity(slug=" + this.f18331a + ", packageName=" + this.f18332b + ')';
    }

    public z(String r2, String r3) {
        d.h.b.o.e(r2, "slug");
        d.h.b.o.e(r3, "packageName");
        this.f18331a = r2;
        this.f18332b = r3;
    }
}
