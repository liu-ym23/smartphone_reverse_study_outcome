package com.obric.aiagent.skill.manager.impl;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: SkillShopApiClient.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class fk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(DbHelper.COL_ID)
    private final String f19891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("name")
    private final String f19892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("slug")
    private final String f19893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("description")
    private final String f19894d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("skills_count")
    private final int f19895e;

    @SerializedName("star_count")
    private final long f;

    @SerializedName("skills")
    private final List<fs> g;

    @SerializedName("usage_examples")
    private final List<String> h;

    @SerializedName("is_starred")
    private final boolean i;

    public fk() {
        this(null, null, null, null, 0, 0, null, null, false, 511, null);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, fk.class) == true) goto L8;
        return false;
    L8:
        fk r10 = (fk) ZeusTransformUtils.preCheckCast(r9, fk.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19891a, r10.f19891a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19892b, r10.f19892b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f19893c, r10.f19893c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f19894d, r10.f19894d) == true) goto L21;
        return false;
    L21:
        if (this.f19895e == r10.f19895e) goto L24;
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
        String r0 = this.f19891a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.f19892b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.f19893c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.f19894d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (((((r9 + r11) * 31) + Integer.hashCode(this.f19895e)) * 31) + Long.hashCode(this.f)) * 31;
        List<fs> r13 = this.g;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        List<String> r16 = this.h;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return ((r15 + r1) * 31) + Boolean.hashCode(this.i);
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
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
        return "SkillShopCollectionDetail(id=" + this.f19891a + ", name=" + this.f19892b + ", slug=" + this.f19893c + ", description=" + this.f19894d + ", skillsCount=" + this.f19895e + ", starCount=" + this.f + ", skills=" + this.g + ", usageExamples=" + this.h + ", isStarred=" + this.i + ')';
    }

    public fk(String r3, String r4, String r5, String r6, int r7, long r8, List<fs> r10, List<String> r11, boolean r12) {
        List<fs> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        List<String> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        this.f19891a = r3;
        this.f19892b = r4;
        this.f19893c = r5;
        this.f19894d = r6;
        this.f19895e = r7;
        this.f = r8;
        this.g = r13;
        this.h = r14;
        this.i = r12;
    }

    public /* synthetic */ fk(String r14, String r15, String r16, String r17, int r18, long r19, List r21, List r22, boolean r23, int r24, d.h.b.h r25) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.aiagent.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin");
        List r4 = null;
        if ((r24 & 1) == 0) goto L5;
        String r3 = null;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r5 = null;
    L11:
        if ((r24 & 4) == 0) goto L13;
        String r6 = null;
    L15:
        if ((r24 & 8) == 0) goto L17;
        String r7 = null;
    L18:
        boolean r9 = false;
        if ((r24 & 16) == 0) goto L21;
        int r8 = 0;
    L23:
        if ((r24 & 32) == 0) goto L25;
        long r10 = 0;
    L27:
        if ((r24 & 64) == 0) goto L30;
        r1 = null;
    L30:
        if ((r24 & 128) != 0) goto L34;
        r4 = r2;
    L34:
        if ((r24 & 256) != 0) goto L37;
        r9 = r23;
    L37:
        this(r3, r5, r6, r7, r8, r10, r1, r4, r9);
        return;
    L25:
        r10 = r19;
        goto L27
    L21:
        r8 = r18;
        goto L23
    L17:
        r7 = r17;
        goto L18
    L13:
        r6 = r16;
        goto L15
    L9:
        r5 = r15;
        goto L11
    L5:
        r3 = r14;
        goto L7
    }

    public final String a() {
        return this.f19891a;
    }

    public final String b() {
        return this.f19892b;
    }

    public final String c() {
        return this.f19893c;
    }

    public final String d() {
        return this.f19894d;
    }

    public final long e() {
        return this.f;
    }

    public final List<fs> f() {
        return this.g;
    }

    public final List<String> g() {
        return this.h;
    }

    public final boolean h() {
        return this.i;
    }
}
