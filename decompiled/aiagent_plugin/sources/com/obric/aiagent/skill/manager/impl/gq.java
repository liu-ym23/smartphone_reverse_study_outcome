package com.obric.aiagent.skill.manager.impl;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillShopApiClient.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class gq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("access_key_id")
    private final String f20021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("secret_access_key")
    private final String f20022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("session_token")
    private final String f20023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("expired_time")
    private final Long f20024d;

    public gq() {
        this(null, null, null, null, 15, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, gq.class) == true) goto L8;
        return false;
    L8:
        gq r6 = (gq) ZeusTransformUtils.preCheckCast(r5, gq.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f20021a, r6.f20021a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f20022b, r6.f20022b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f20023c, r6.f20023c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f20024d, r6.f20024d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.f20021a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.f20022b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.f20023c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.f20024d;
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
        return "SkillSigningUploadCredentials(accessKeyId=" + this.f20021a + ", secretAccessKey=" + this.f20022b + ", sessionToken=" + this.f20023c + ", expiredTime=" + this.f20024d + ')';
    }

    public gq(String r1, String r2, String r3, Long r4) {
        this.f20021a = r1;
        this.f20022b = r2;
        this.f20023c = r3;
        this.f20024d = r4;
    }

    public /* synthetic */ gq(String r2, String r3, String r4, Long r5, int r6, d.h.b.h r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }

    public final Long a() {
        return this.f20024d;
    }
}
