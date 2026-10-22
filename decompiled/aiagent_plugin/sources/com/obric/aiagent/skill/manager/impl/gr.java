package com.obric.aiagent.skill.manager.impl;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillShopApiClient.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class gr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("upload_url")
    private final String f20025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("credentials")
    private final gq f20026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("object_key")
    private final String f20027c;

    public gr() {
        this(null, null, null, 7, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, gr.class) == true) goto L8;
        return false;
    L8:
        gr r6 = (gr) ZeusTransformUtils.preCheckCast(r5, gr.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f20025a, r6.f20025a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f20026b, r6.f20026b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f20027c, r6.f20027c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.f20025a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        gq r4 = this.f20026b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((r3 + r1) * 31) + this.f20027c.hashCode();
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SkillSigningUploadTokenData(uploadUrl=" + this.f20025a + ", credentials=" + this.f20026b + ", objectKey=" + this.f20027c + ')';
    }

    public gr(String r2, gq r3, String r4) {
        d.h.b.o.e(r4, "objectKey");
        this.f20025a = r2;
        this.f20026b = r3;
        this.f20027c = r4;
    }

    public /* synthetic */ gr(String r2, gq r3, String r4, int r5, d.h.b.h r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = "";
    L11:
        this(r2, r3, r4);
    }

    public final String a() {
        return this.f20025a;
    }

    public final gq b() {
        return this.f20026b;
    }

    public final String c() {
        return this.f20027c;
    }
}
