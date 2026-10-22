package com.obric.aiagent.skill.manager.impl;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillShopApiClient.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ff {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(DbHelper.COL_ID)
    private final String f19876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("name")
    private final String f19877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("slug")
    private final String f19878c;

    public ff() {
        this(null, null, null, 7, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ff.class) == true) goto L8;
        return false;
    L8:
        ff r6 = (ff) ZeusTransformUtils.preCheckCast(r5, ff.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19876a, r6.f19876a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19877b, r6.f19877b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f19878c, r6.f19878c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.f19876a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.f19877b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.f19878c;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SkillShopBannerCollection(id=" + this.f19876a + ", name=" + this.f19877b + ", slug=" + this.f19878c + ')';
    }

    public ff(String r1, String r2, String r3) {
        this.f19876a = r1;
        this.f19877b = r2;
        this.f19878c = r3;
    }

    public /* synthetic */ ff(String r2, String r3, String r4, int r5, d.h.b.h r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }

    public final String a() {
        return this.f19876a;
    }

    public final String b() {
        return this.f19877b;
    }

    public final String c() {
        return this.f19878c;
    }
}
