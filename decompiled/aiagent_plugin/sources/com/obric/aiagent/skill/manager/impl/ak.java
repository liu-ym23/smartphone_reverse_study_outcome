package com.obric.aiagent.skill.manager.impl;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: SkillShopRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ak {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f19487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<ak> f19488e;

    public ak() {
        this(null, null, null, 0, null, 31, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ak.class) == true) goto L8;
        return false;
    L8:
        ak r6 = (ak) ZeusTransformUtils.preCheckCast(r5, ak.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19484a, r6.f19484a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19485b, r6.f19485b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f19486c, r6.f19486c) == true) goto L18;
        return false;
    L18:
        if (this.f19487d == r6.f19487d) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f19488e, r6.f19488e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.f19484a.hashCode() * 31) + this.f19485b.hashCode()) * 31) + this.f19486c.hashCode()) * 31) + Integer.hashCode(this.f19487d)) * 31) + this.f19488e.hashCode();
    }

    public String toString() {
        return "ShopCategory(id=" + this.f19484a + ", name=" + this.f19485b + ", slug=" + this.f19486c + ", sortOrder=" + this.f19487d + ", children=" + this.f19488e + ')';
    }

    public ak(String r3, String r4, String r5, int r6, List<ak> r7) {
        List<ak> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, DbHelper.COL_ID);
        d.h.b.o.e(r4, "name");
        d.h.b.o.e(r5, "slug");
        d.h.b.o.e(r8, "children");
        this.f19484a = r3;
        this.f19485b = r4;
        this.f19486c = r5;
        this.f19487d = r6;
        this.f19488e = r8;
    }

    public final String a() {
        return this.f19484a;
    }

    public final String b() {
        return this.f19485b;
    }

    public final String c() {
        return this.f19486c;
    }

    public final int d() {
        return this.f19487d;
    }

    public /* synthetic */ ak(String r8, String r9, String r10, int r11, List r12, int r13, d.h.b.h r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        if ((r13 & 1) == 0) goto L5;
        String r2 = "";
    L7:
        if ((r13 & 2) == 0) goto L9;
        String r3 = "";
    L11:
        if ((r13 & 4) == 0) goto L13;
        String r4 = "";
    L15:
        if ((r13 & 8) == 0) goto L17;
        r11 = 0;
    L17:
        int r5 = r11;
        if ((r13 & 16) == 0) goto L20;
        r15 = d.a.p.b();
    L20:
        this(r2, r3, r4, r5, r15);
        return;
    L13:
        r4 = r10;
        goto L15
    L9:
        r3 = r9;
        goto L11
    L5:
        r2 = r8;
        goto L7
    }
}
