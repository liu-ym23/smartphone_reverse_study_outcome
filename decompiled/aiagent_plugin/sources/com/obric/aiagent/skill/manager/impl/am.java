package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillShopRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class am {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.aiagent.skill.manager.api.e f19494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19495b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, am.class) == true) goto L8;
        return false;
    L8:
        am r6 = (am) ZeusTransformUtils.preCheckCast(r5, am.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19494a, r6.f19494a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19495b, r6.f19495b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f19494a.hashCode() * 31) + this.f19495b.hashCode();
    }

    public String toString() {
        return "ShopDiscoverySkill(skill=" + this.f19494a + ", listDescription=" + this.f19495b + ')';
    }

    public am(com.obric.aiagent.skill.manager.api.e r2, String r3) {
        d.h.b.o.e(r2, "skill");
        d.h.b.o.e(r3, "listDescription");
        this.f19494a = r2;
        this.f19495b = r3;
    }

    public final com.obric.aiagent.skill.manager.api.e a() {
        return this.f19494a;
    }

    public final String b() {
        return this.f19495b;
    }
}
