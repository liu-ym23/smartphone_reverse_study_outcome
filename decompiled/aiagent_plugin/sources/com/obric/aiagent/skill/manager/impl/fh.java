package com.obric.aiagent.skill.manager.impl;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillShopApiClient.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class fh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(DbHelper.COL_ID)
    private final String f19880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName(DBDefinition.TITLE)
    private final String f19881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("subtitle")
    private final String f19882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("collection_id")
    private final String f19883d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("image_url")
    private final String f19884e;

    @SerializedName("collection")
    private final ff f;

    public fh() {
        this(null, null, null, null, null, null, 63, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, fh.class) == true) goto L8;
        return false;
    L8:
        fh r6 = (fh) ZeusTransformUtils.preCheckCast(r5, fh.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19880a, r6.f19880a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19881b, r6.f19881b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f19882c, r6.f19882c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f19883d, r6.f19883d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f19884e, r6.f19884e) == true) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r0 = this.f19880a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.f19881b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.f19882c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.f19883d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.f19884e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        ff r16 = this.f;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
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
        return "SkillShopBannerItem(id=" + this.f19880a + ", title=" + this.f19881b + ", subtitle=" + this.f19882c + ", collectionId=" + this.f19883d + ", imageUrl=" + this.f19884e + ", collection=" + this.f + ')';
    }

    public fh(String r1, String r2, String r3, String r4, String r5, ff r6) {
        this.f19880a = r1;
        this.f19881b = r2;
        this.f19882c = r3;
        this.f19883d = r4;
        this.f19884e = r5;
        this.f = r6;
    }

    public /* synthetic */ fh(String r2, String r3, String r4, String r5, String r6, ff r7, int r8, d.h.b.h r9) {
        if ((r8 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r8 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r8 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r8 & 32) == 0) goto L20;
        r7 = null;
    L20:
        this(r2, r3, r4, r5, r6, r7);
    }

    public final String a() {
        return this.f19880a;
    }

    public final String b() {
        return this.f19881b;
    }

    public final String c() {
        return this.f19882c;
    }

    public final String d() {
        return this.f19883d;
    }

    public final String e() {
        return this.f19884e;
    }

    public final ff f() {
        return this.f;
    }
}
