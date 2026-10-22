package com.obric.aiagent.skill.manager.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillManagerContracts.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19160b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ad.class) == true) goto L8;
        return false;
    L8:
        ad r6 = (ad) ZeusTransformUtils.preCheckCast(r5, ad.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19159a, r6.f19159a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19160b, r6.f19160b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f19159a.hashCode() * 31) + this.f19160b.hashCode();
    }

    public String toString() {
        return "SkillProjectionPreparationFailure(slug=" + this.f19159a + ", reason=" + this.f19160b + ')';
    }

    public ad(String r2, String r3) {
        d.h.b.o.e(r2, "slug");
        d.h.b.o.e(r3, "reason");
        this.f19159a = r2;
        this.f19160b = r3;
    }

    public final String a() {
        return this.f19159a;
    }

    public final String b() {
        return this.f19160b;
    }
}
