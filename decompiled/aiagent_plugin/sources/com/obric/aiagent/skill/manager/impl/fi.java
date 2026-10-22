package com.obric.aiagent.skill.manager.impl;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: SkillShopApiClient.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class fi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(DbHelper.COL_ID)
    private final String f19885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("name")
    private final String f19886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("slug")
    private final String f19887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("sort_order")
    private final int f19888d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("children")
    private final List<fi> f19889e;

    public fi() {
        this(null, null, null, 0, null, 31, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, fi.class) == true) goto L8;
        return false;
    L8:
        fi r6 = (fi) ZeusTransformUtils.preCheckCast(r5, fi.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19885a, r6.f19885a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19886b, r6.f19886b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f19887c, r6.f19887c) == true) goto L18;
        return false;
    L18:
        if (this.f19888d == r6.f19888d) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f19889e, r6.f19889e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.f19885a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.f19886b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.f19887c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (((r6 + r8) * 31) + Integer.hashCode(this.f19888d)) * 31;
        List<fi> r10 = this.f19889e;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SkillShopCategory(id=" + this.f19885a + ", name=" + this.f19886b + ", slug=" + this.f19887c + ", sortOrder=" + this.f19888d + ", children=" + this.f19889e + ')';
    }

    public fi(String r3, String r4, String r5, int r6, List<fi> r7) {
        List<fi> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        this.f19885a = r3;
        this.f19886b = r4;
        this.f19887c = r5;
        this.f19888d = r6;
        this.f19889e = r8;
    }

    public /* synthetic */ fi(String r8, String r9, String r10, int r11, List r12, int r13, d.h.b.h r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        if ((r13 & 1) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r13 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r13 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r13 & 8) == 0) goto L17;
        r11 = 0;
    L17:
        int r5 = r11;
        if ((r13 & 16) == 0) goto L20;
        List r6 = null;
    L21:
        this(r2, r3, r4, r5, r6);
        return;
    L20:
        r6 = r15;
        goto L21
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

    public final String a() {
        return this.f19885a;
    }

    public final String b() {
        return this.f19886b;
    }

    public final String c() {
        return this.f19887c;
    }

    public final int d() {
        return this.f19888d;
    }

    public final List<fi> e() {
        return this.f19889e;
    }
}
