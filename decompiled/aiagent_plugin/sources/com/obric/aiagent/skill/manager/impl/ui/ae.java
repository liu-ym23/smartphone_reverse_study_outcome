package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: SkillDetailLoadCoordinator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.aiagent.skill.manager.api.e f20496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f20497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<String> f20498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f20499d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ae.class) == true) goto L8;
        return false;
    L8:
        ae r6 = (ae) ZeusTransformUtils.preCheckCast(r5, ae.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f20496a, r6.f20496a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f20497b, r6.f20497b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f20498c, r6.f20498c) == true) goto L18;
        return false;
    L18:
        if (this.f20499d == r6.f20499d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f20496a.hashCode() * 31) + this.f20497b.hashCode()) * 31) + this.f20498c.hashCode()) * 31) + Boolean.hashCode(this.f20499d);
    }

    public String toString() {
        return "SkillDetailState(skill=" + this.f20496a + ", detailDescription=" + this.f20497b + ", usageExamples=" + this.f20498c + ", isInstalled=" + this.f20499d + ')';
    }

    public ae(com.obric.aiagent.skill.manager.api.e r3, String r4, List<String> r5, boolean r6) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "skill");
        d.h.b.o.e(r4, "detailDescription");
        d.h.b.o.e(r7, "usageExamples");
        this.f20496a = r3;
        this.f20497b = r4;
        this.f20498c = r7;
        this.f20499d = r6;
    }

    public final com.obric.aiagent.skill.manager.api.e a() {
        return this.f20496a;
    }

    public final String b() {
        return this.f20497b;
    }

    public /* synthetic */ ae(com.obric.aiagent.skill.manager.api.e r2, String r3, List r4, boolean r5, int r6, d.h.b.h r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if ((r6 & 4) == 0) goto L5;
        r8 = d.a.p.b();
    L5:
        this(r2, r3, r8, r5);
    }

    public final List<String> c() {
        return this.f20498c;
    }

    public final boolean d() {
        return this.f20499d;
    }
}
