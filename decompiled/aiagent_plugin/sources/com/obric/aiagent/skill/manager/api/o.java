package com.obric.aiagent.skill.manager.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillManagerContracts.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p f19288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19289b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, o.class) == true) goto L8;
        return false;
    L8:
        o r6 = (o) ZeusTransformUtils.preCheckCast(r5, o.class, "com.obric.aiagent.plugin");
        if (this.f19288a == r6.f19288a) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19289b, r6.f19289b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.f19288a.hashCode() * 31;
        String r1 = this.f19289b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "SkillInstallEntryContext(method=" + this.f19288a + ", skillSourceUrl=" + this.f19289b + ')';
    }

    public o(p r2, String r3) {
        d.h.b.o.e(r2, "method");
        this.f19288a = r2;
        this.f19289b = r3;
    }

    public /* synthetic */ o(p r1, String r2, int r3, d.h.b.h r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public final p a() {
        return this.f19288a;
    }

    public final String b() {
        return this.f19289b;
    }
}
