package com.obric.aiagent.skill.manager.impl;

import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillShopApiClient.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class fs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(DbHelper.COL_ID)
    private final String f19917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("display_name")
    private final String f19918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("slug")
    private final String f19919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("short_description")
    private final String f19920d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("description")
    private final String f19921e;

    @SerializedName("cover_url")
    private final String f;

    @SerializedName(DBHelper.BATTERY_COL_SOURCE)
    private final JsonElement g;

    @SerializedName("is_official")
    private final Boolean h;

    @SerializedName("current_version")
    private final fl i;

    public fs() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, fs.class) == true) goto L8;
        return false;
    L8:
        fs r6 = (fs) ZeusTransformUtils.preCheckCast(r5, fs.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19917a, r6.f19917a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19918b, r6.f19918b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f19919c, r6.f19919c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f19920d, r6.f19920d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f19921e, r6.f19921e) == true) goto L24;
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
        String r0 = this.f19917a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.f19918b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.f19919c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.f19920d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.f19921e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        JsonElement r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Boolean r22 = this.h;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        fl r25 = this.i;
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
        return "SkillShopListItem(id=" + this.f19917a + ", displayName=" + this.f19918b + ", slug=" + this.f19919c + ", shortDescription=" + this.f19920d + ", description=" + this.f19921e + ", coverUrl=" + this.f + ", source=" + this.g + ", isOfficial=" + this.h + ", currentVersion=" + this.i + ')';
    }

    public fs(String r1, String r2, String r3, String r4, String r5, String r6, JsonElement r7, Boolean r8, fl r9) {
        this.f19917a = r1;
        this.f19918b = r2;
        this.f19919c = r3;
        this.f19920d = r4;
        this.f19921e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }

    public /* synthetic */ fs(String r2, String r3, String r4, String r5, String r6, String r7, JsonElement r8, Boolean r9, fl r10, int r11, d.h.b.h r12) {
        if ((r11 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r11 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r11 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r11 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r11 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r11 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r11 & 128) == 0) goto L27;
        r9 = null;
    L27:
        if ((r11 & 256) == 0) goto L29;
        r10 = null;
    L29:
        this(r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public final String a() {
        return this.f19918b;
    }

    public final String b() {
        return this.f19919c;
    }

    public final String c() {
        return this.f19920d;
    }

    public final String d() {
        return this.f19921e;
    }

    public final String e() {
        return this.f;
    }

    public final JsonElement f() {
        return this.g;
    }

    public final fl g() {
        return this.i;
    }
}
