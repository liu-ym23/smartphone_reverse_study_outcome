package com.obric.aiagent.skill.manager.impl;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillShopApiClient.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("manifest_id")
    private final String f19978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("signed_manifest")
    private final JsonElement f19979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("signing_payload_base64")
    private final String f19980c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final transient String f19981d;

    public ge() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ge a(ge r0, String r1, JsonElement r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.f19978a;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.f19979b;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.f19980c;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.f19981d;
    L15:
        return r0.a(r1, r2, r3, r4);
    }

    public final ge a(String r1, JsonElement r2, String r3, String r4) {
        d.h.b.o.e(r1, "manifestId");
        d.h.b.o.e(r4, "rawJson");
        return new ge(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ge.class) == true) goto L8;
        return false;
    L8:
        ge r6 = (ge) ZeusTransformUtils.preCheckCast(r5, ge.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19978a, r6.f19978a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19979b, r6.f19979b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f19980c, r6.f19980c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f19981d, r6.f19981d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = this.f19978a.hashCode() * 31;
        JsonElement r1 = this.f19979b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.f19980c;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((r4 + r2) * 31) + this.f19981d.hashCode();
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "SkillSigningManifestData(manifestId=" + this.f19978a + ", signedManifest=" + this.f19979b + ", signingPayloadBase64=" + this.f19980c + ", rawJson=" + this.f19981d + ')';
    }

    public ge(String r2, JsonElement r3, String r4, String r5) {
        d.h.b.o.e(r2, "manifestId");
        d.h.b.o.e(r5, "rawJson");
        this.f19978a = r2;
        this.f19979b = r3;
        this.f19980c = r4;
        this.f19981d = r5;
    }

    public /* synthetic */ ge(String r3, JsonElement r4, String r5, String r6, int r7, d.h.b.h r8) {
        if ((r7 & 1) == 0) goto L6;
        r3 = "";
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r7 & 8) == 0) goto L14;
        r6 = "";
    L14:
        this(r3, r4, r5, r6);
    }

    public final String a() {
        return this.f19978a;
    }

    public final JsonElement b() {
        return this.f19979b;
    }

    public final String c() {
        return this.f19980c;
    }

    public final String d() {
        return this.f19981d;
    }
}
