package com.obric.aiagent.skill.manager.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillManagerContracts.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class an {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final am f19207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19208c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, an.class) == true) goto L8;
        return false;
    L8:
        an r6 = (an) ZeusTransformUtils.preCheckCast(r5, an.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19206a, r6.f19206a) == true) goto L12;
        return false;
    L12:
        if (this.f19207b == r6.f19207b) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f19208c, r6.f19208c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.f19206a.hashCode() * 31) + this.f19207b.hashCode()) * 31;
        String r2 = this.f19208c;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "SkillSignatureRefreshResult(slug=" + this.f19206a + ", action=" + this.f19207b + ", error=" + this.f19208c + ')';
    }

    public an(String r2, am r3, String r4) {
        d.h.b.o.e(r2, "slug");
        d.h.b.o.e(r3, "action");
        this.f19206a = r2;
        this.f19207b = r3;
        this.f19208c = r4;
    }

    public /* synthetic */ an(String r1, am r2, String r3, int r4, d.h.b.h r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }

    public final String a() {
        return this.f19206a;
    }

    public final am b() {
        return this.f19207b;
    }

    public final String c() {
        return this.f19208c;
    }
}
