package com.obric.aiagent.skill.manager.impl;

import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: SkillShopApiClient.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class fm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(DbHelper.COL_ID)
    private final String f19899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("display_name")
    private final String f19900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("slug")
    private final String f19901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("description")
    private final String f19902d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("cover_url")
    private final String f19903e;

    @SerializedName(DBHelper.BATTERY_COL_SOURCE)
    private final JsonElement f;

    @SerializedName("is_official")
    private final Boolean g;

    @SerializedName("current_version")
    private final fl h;

    @SerializedName("usage_examples")
    private final List<String> i;

    public fm() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, fm.class) == true) goto L8;
        return false;
    L8:
        fm r6 = (fm) ZeusTransformUtils.preCheckCast(r5, fm.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19899a, r6.f19899a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19900b, r6.f19900b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f19901c, r6.f19901c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f19902d, r6.f19902d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f19903e, r6.f19903e) == true) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (d.h.b.o.a(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (d.h.b.o.a(this.i, r6.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        String r0 = this.f19899a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.f19900b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.f19901c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.f19902d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.f19903e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        JsonElement r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Boolean r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        fl r22 = this.h;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        List<String> r25 = this.i;
        if (r25 == null) goto L39;
        r1 = r25.hashCode();
    L39:
        return r24 + r1;
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
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
        return "SkillShopDetail(id=" + this.f19899a + ", displayName=" + this.f19900b + ", slug=" + this.f19901c + ", description=" + this.f19902d + ", coverUrl=" + this.f19903e + ", source=" + this.f + ", isOfficial=" + this.g + ", currentVersion=" + this.h + ", usageExamples=" + this.i + ')';
    }

    public fm(String r3, String r4, String r5, String r6, String r7, JsonElement r8, Boolean r9, fl r10, List<String> r11) {
        List<String> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        this.f19899a = r3;
        this.f19900b = r4;
        this.f19901c = r5;
        this.f19902d = r6;
        this.f19903e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r12;
    }

    public /* synthetic */ fm(String r12, String r13, String r14, String r15, String r16, JsonElement r17, Boolean r18, fl r19, List r20, int r21, d.h.b.h r22) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.aiagent.plugin");
        if ((r21 & 1) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r21 & 2) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r21 & 4) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r21 & 8) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r21 & 16) == 0) goto L21;
        String r7 = null;
    L23:
        if ((r21 & 32) == 0) goto L25;
        JsonElement r8 = null;
    L27:
        if ((r21 & 64) == 0) goto L29;
        Boolean r9 = null;
    L31:
        if ((r21 & 128) == 0) goto L33;
        fl r10 = null;
    L35:
        if ((r21 & 256) == 0) goto L37;
        r1 = null;
    L37:
        this(r2, r4, r5, r6, r7, r8, r9, r10, r1);
        return;
    L33:
        r10 = r19;
        goto L35
    L29:
        r9 = r18;
        goto L31
    L25:
        r8 = r17;
        goto L27
    L21:
        r7 = r16;
        goto L23
    L17:
        r6 = r15;
        goto L19
    L13:
        r5 = r14;
        goto L15
    L9:
        r4 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    public final String a() {
        return this.f19900b;
    }

    public final String b() {
        return this.f19901c;
    }

    public final String c() {
        return this.f19902d;
    }

    public final String d() {
        return this.f19903e;
    }

    public final JsonElement e() {
        return this.f;
    }

    public final fl f() {
        return this.h;
    }

    public final List<String> g() {
        return this.i;
    }
}
