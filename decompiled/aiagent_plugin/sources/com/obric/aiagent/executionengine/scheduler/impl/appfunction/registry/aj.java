package com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppFunctionSpellSkillBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f18224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f18225b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, aj.class) == true) goto L8;
        return false;
    L8:
        aj r6 = (aj) ZeusTransformUtils.preCheckCast(r5, aj.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f18224a, r6.f18224a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f18225b, r6.f18225b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f18224a.hashCode() * 31) + this.f18225b.hashCode();
    }

    public String toString() {
        return "BuiltSpellAppFunctionSkill(packageName=" + this.f18224a + ", skillMarkdown=" + this.f18225b + ')';
    }

    public aj(String r2, String r3) {
        d.h.b.o.e(r2, "packageName");
        d.h.b.o.e(r3, "skillMarkdown");
        this.f18224a = r2;
        this.f18225b = r3;
    }

    public final String a() {
        return this.f18224a;
    }

    public final String b() {
        return this.f18225b;
    }
}
