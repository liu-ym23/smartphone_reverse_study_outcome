package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SkillShopViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class cf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<bu> f20713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final bs f20714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, cd> f20715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<String, com.obric.aiagent.skill.manager.api.e> f20716d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set<String> f20717e;
    private final Set<String> f;

    public cf() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ cf a(cf r7, List r8, bs r9, Map r10, Map r11, Set r12, Set r13, int r14, Object r15) {
        List<bu> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        Map<String, cd> r17 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        Map<String, com.obric.aiagent.skill.manager.api.e> r18 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        Set<String> r19 = (Set) ZeusTransformUtils.wrapperContextForParams(r12, Set.class, "com.obric.aiagent.plugin");
        Set<String> r110 = (Set) ZeusTransformUtils.wrapperContextForParams(r13, Set.class, "com.obric.aiagent.plugin");
        if ((r14 & 1) == 0) goto L5;
        r16 = r7.f20713a;
    L5:
        List<bu> r1 = r16;
        if ((r14 & 2) == 0) goto L8;
        r9 = r7.f20714b;
    L8:
        bs r2 = r9;
        if ((r14 & 4) == 0) goto L11;
        r17 = r7.f20715c;
    L11:
        Map<String, cd> r3 = r17;
        if ((r14 & 8) == 0) goto L14;
        r18 = r7.f20716d;
    L14:
        Map<String, com.obric.aiagent.skill.manager.api.e> r4 = r18;
        if ((r14 & 16) == 0) goto L17;
        r19 = r7.f20717e;
    L17:
        Set<String> r5 = r19;
        if ((r14 & 32) == 0) goto L21;
        r110 = r7.f;
    L21:
        return r7.a(r1, r2, r3, r4, r5, r110);
    }

    public final cf a(List<? extends bu> r9, bs r10, Map<String, cd> r11, Map<String, com.obric.aiagent.skill.manager.api.e> r12, Set<String> r13, Set<String> r14) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r13, Set.class, "com.obric.aiagent.plugin");
        Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r14, Set.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "channels");
        d.h.b.o.e(r10, "bannerState");
        d.h.b.o.e(r4, "pages");
        d.h.b.o.e(r5, "installedSkills");
        d.h.b.o.e(r6, "processingSkillIds");
        d.h.b.o.e(r7, "completedSkillIds");
        return new cf(r2, r10, r4, r5, r6, r7);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, cf.class) == true) goto L8;
        return false;
    L8:
        cf r6 = (cf) ZeusTransformUtils.preCheckCast(r5, cf.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f20713a, r6.f20713a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f20714b, r6.f20714b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f20715c, r6.f20715c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f20716d, r6.f20716d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f20717e, r6.f20717e) == true) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((this.f20713a.hashCode() * 31) + this.f20714b.hashCode()) * 31) + this.f20715c.hashCode()) * 31) + this.f20716d.hashCode()) * 31) + this.f20717e.hashCode()) * 31) + this.f.hashCode();
    }

    public String toString() {
        return "SkillShopUiState(channels=" + this.f20713a + ", bannerState=" + this.f20714b + ", pages=" + this.f20715c + ", installedSkills=" + this.f20716d + ", processingSkillIds=" + this.f20717e + ", completedSkillIds=" + this.f + ')';
    }

    public cf(List<? extends bu> r3, bs r4, Map<String, cd> r5, Map<String, com.obric.aiagent.skill.manager.api.e> r6, Set<String> r7, Set<String> r8) {
        List<bu> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        Map<String, cd> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        Map<String, com.obric.aiagent.skill.manager.api.e> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        Set<String> r12 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.aiagent.plugin");
        Set<String> r13 = (Set) ZeusTransformUtils.wrapperContextForParams(r8, Set.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "channels");
        d.h.b.o.e(r4, "bannerState");
        d.h.b.o.e(r10, "pages");
        d.h.b.o.e(r11, "installedSkills");
        d.h.b.o.e(r12, "processingSkillIds");
        d.h.b.o.e(r13, "completedSkillIds");
        this.f20713a = r9;
        this.f20714b = r4;
        this.f20715c = r10;
        this.f20716d = r11;
        this.f20717e = r12;
        this.f = r13;
    }

    public /* synthetic */ cf(List r9, bs r10, Map r11, Map r12, Set r13, Set r14, int r15, d.h.b.h r16) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r13, Set.class, "com.obric.aiagent.plugin");
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r14, Set.class, "com.obric.aiagent.plugin");
        if ((r15 & 1) == 0) goto L6;
        r0 = d.a.p.b();
    L6:
        if ((r15 & 2) == 0) goto L8;
        bs r1 = (bs) ZeusTransformUtils.preCheckCast(bs.b.f20667a, bs.class, "com.obric.aiagent.plugin");
    L10:
        if ((r15 & 4) == 0) goto L13;
        r2 = d.a.ao.b();
    L13:
        if ((r15 & 8) == 0) goto L16;
        r3 = d.a.ao.b();
    L16:
        if ((r15 & 16) == 0) goto L19;
        r4 = d.a.ax.b();
    L19:
        if ((r15 & 32) == 0) goto L21;
        r5 = d.a.ax.b();
    L21:
        this(r0, r1, r2, r3, r4, r5);
        return;
    L8:
        r1 = r10;
        goto L10
    }

    public final List<bu> a() {
        return this.f20713a;
    }

    public final bs b() {
        return this.f20714b;
    }

    public final Map<String, cd> c() {
        return this.f20715c;
    }

    public final Map<String, com.obric.aiagent.skill.manager.api.e> d() {
        return this.f20716d;
    }

    public final Set<String> e() {
        return this.f20717e;
    }

    public final Set<String> f() {
        return this.f;
    }

    public final cd a(bu r8) {
        d.h.b.o.e(r8, "channel");
        cd r7 = (cd) ZeusTransformUtils.preCheckCast(this.f20715c.get(r8.a()), cd.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L5;
        return r7;
    L5:
        return new cd(null, false, false, false, 15, null);
    }
}
