package com.obric.aiagent.skill.manager.impl;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: SkillShopRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class al {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f19492d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f19493e;
    private final long f;
    private final List<com.obric.aiagent.skill.manager.api.e> g;
    private final List<String> h;
    private final boolean i;

    public al() {
        this(null, null, null, null, 0, 0, null, null, false, 511, null);
    }

    public static /* synthetic */ al a(al r12, String r13, String r14, String r15, String r16, int r17, long r18, List r20, List r21, boolean r22, int r23, Object r24) {
        List<com.obric.aiagent.skill.manager.api.e> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.aiagent.plugin");
        List<String> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.aiagent.plugin");
        if ((r23 & 1) == 0) goto L5;
        String r4 = r12.f19489a;
    L7:
        if ((r23 & 2) == 0) goto L9;
        String r5 = r12.f19490b;
    L11:
        if ((r23 & 4) == 0) goto L13;
        String r6 = r12.f19491c;
    L15:
        if ((r23 & 8) == 0) goto L17;
        String r7 = r12.f19492d;
    L19:
        if ((r23 & 16) == 0) goto L21;
        int r8 = r12.f19493e;
    L23:
        if ((r23 & 32) == 0) goto L25;
        long r9 = r12.f;
    L27:
        if ((r23 & 64) == 0) goto L30;
        r2 = r12.g;
    L30:
        if ((r23 & 128) == 0) goto L33;
        r3 = r12.h;
    L33:
        if ((r23 & 256) == 0) goto L35;
        boolean r1 = r12.i;
    L37:
        return r12.a(r4, r5, r6, r7, r8, r9, r2, r3, r1);
    L35:
        r1 = r22;
        goto L37
    L25:
        r9 = r18;
        goto L27
    L21:
        r8 = r17;
        goto L23
    L17:
        r7 = r16;
        goto L19
    L13:
        r6 = r15;
        goto L15
    L9:
        r5 = r14;
        goto L11
    L5:
        r4 = r13;
        goto L7
    }

    public final al a(String r14, String r15, String r16, String r17, int r18, long r19, List<com.obric.aiagent.skill.manager.api.e> r21, List<String> r22, boolean r23) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.aiagent.plugin");
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r14, DbHelper.COL_ID);
        d.h.b.o.e(r15, "name");
        d.h.b.o.e(r16, "slug");
        d.h.b.o.e(r17, "description");
        d.h.b.o.e(r10, "skills");
        d.h.b.o.e(r11, "usageExamples");
        return new al(r14, r15, r16, r17, r18, r19, r10, r11, r23);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, al.class) == true) goto L8;
        return false;
    L8:
        al r10 = (al) ZeusTransformUtils.preCheckCast(r9, al.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19489a, r10.f19489a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19490b, r10.f19490b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f19491c, r10.f19491c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f19492d, r10.f19492d) == true) goto L21;
        return false;
    L21:
        if (this.f19493e == r10.f19493e) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (d.h.b.o.a(this.h, r10.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r10.i) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        return (((((((((((((((this.f19489a.hashCode() * 31) + this.f19490b.hashCode()) * 31) + this.f19491c.hashCode()) * 31) + this.f19492d.hashCode()) * 31) + Integer.hashCode(this.f19493e)) * 31) + Long.hashCode(this.f)) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + Boolean.hashCode(this.i);
    }

    public String toString() {
        return "ShopCollection(id=" + this.f19489a + ", name=" + this.f19490b + ", slug=" + this.f19491c + ", description=" + this.f19492d + ", skillsCount=" + this.f19493e + ", starCount=" + this.f + ", skills=" + this.g + ", usageExamples=" + this.h + ", isStarred=" + this.i + ')';
    }

    public al(String r3, String r4, String r5, String r6, int r7, long r8, List<com.obric.aiagent.skill.manager.api.e> r10, List<String> r11, boolean r12) {
        List<com.obric.aiagent.skill.manager.api.e> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        List<String> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, DbHelper.COL_ID);
        d.h.b.o.e(r4, "name");
        d.h.b.o.e(r5, "slug");
        d.h.b.o.e(r6, "description");
        d.h.b.o.e(r13, "skills");
        d.h.b.o.e(r14, "usageExamples");
        this.f19489a = r3;
        this.f19490b = r4;
        this.f19491c = r5;
        this.f19492d = r6;
        this.f19493e = r7;
        this.f = r8;
        this.g = r13;
        this.h = r14;
        this.i = r12;
    }

    public final String a() {
        return this.f19490b;
    }

    public final String b() {
        return this.f19492d;
    }

    public /* synthetic */ al(String r13, String r14, String r15, String r16, int r17, long r18, List r20, List r21, boolean r22, int r23, d.h.b.h r24) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.aiagent.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.aiagent.plugin");
        String r4 = "";
        if ((r23 & 1) == 0) goto L5;
        String r3 = "";
    L7:
        if ((r23 & 2) == 0) goto L9;
        String r5 = "";
    L11:
        if ((r23 & 4) == 0) goto L13;
        String r6 = "";
    L15:
        if ((r23 & 8) != 0) goto L18;
        r4 = r16;
    L18:
        boolean r8 = false;
        if ((r23 & 16) == 0) goto L21;
        int r7 = 0;
    L23:
        if ((r23 & 32) == 0) goto L25;
        long r9 = 0;
    L27:
        if ((r23 & 64) == 0) goto L30;
        r1 = d.a.p.b();
    L30:
        if ((r23 & 128) == 0) goto L33;
        r2 = d.a.p.b();
    L33:
        if ((r23 & 256) != 0) goto L36;
        r8 = r22;
    L36:
        this(r3, r5, r6, r4, r7, r9, r1, r2, r8);
        return;
    L25:
        r9 = r18;
        goto L27
    L21:
        r7 = r17;
        goto L23
    L13:
        r6 = r15;
        goto L15
    L9:
        r5 = r14;
        goto L11
    L5:
        r3 = r13;
        goto L7
    }

    public final List<com.obric.aiagent.skill.manager.api.e> c() {
        return this.g;
    }

    public final List<String> d() {
        return this.h;
    }
}
