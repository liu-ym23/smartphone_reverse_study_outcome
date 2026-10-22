package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: SkillShopRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.aiagent.skill.manager.api.e f19500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<String> f19502c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ao.class) == true) goto L8;
        return false;
    L8:
        ao r6 = (ao) ZeusTransformUtils.preCheckCast(r5, ao.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19500a, r6.f19500a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19501b, r6.f19501b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f19502c, r6.f19502c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f19500a.hashCode() * 31) + this.f19501b.hashCode()) * 31) + this.f19502c.hashCode();
    }

    public String toString() {
        return "ShopSkillDetail(skill=" + this.f19500a + ", detailDescription=" + this.f19501b + ", usageExamples=" + this.f19502c + ')';
    }

    public ao(com.obric.aiagent.skill.manager.api.e r3, String r4, List<String> r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "skill");
        d.h.b.o.e(r4, "detailDescription");
        d.h.b.o.e(r6, "usageExamples");
        this.f19500a = r3;
        this.f19501b = r4;
        this.f19502c = r6;
    }

    public final com.obric.aiagent.skill.manager.api.e a() {
        return this.f19500a;
    }

    public final String b() {
        return this.f19501b;
    }

    public final List<String> c() {
        return this.f19502c;
    }
}
