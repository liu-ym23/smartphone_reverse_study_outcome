package com.obric.aiagent.skill.manager.impl;

import com.google.gson.JsonElement;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillSignatureVerifier.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class fy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f19957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f19958d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f19959e;
    private final JsonElement f;
    private final String g;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, fy.class) == true) goto L8;
        return false;
    L8:
        fy r6 = (fy) ZeusTransformUtils.preCheckCast(r5, fy.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19955a, r6.f19955a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19956b, r6.f19956b) == true) goto L15;
        return false;
    L15:
        if (this.f19957c == r6.f19957c) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f19958d, r6.f19958d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f19959e, r6.f19959e) == true) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((this.f19955a.hashCode() * 31) + this.f19956b.hashCode()) * 31) + Integer.hashCode(this.f19957c)) * 31) + this.f19958d.hashCode()) * 31) + this.f19959e.hashCode()) * 31;
        JsonElement r1 = this.f;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.g;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "SkillSignatureVerificationInput(expectedManifestId=" + this.f19955a + ", expectedSlug=" + this.f19956b + ", expectedVersion=" + this.f19957c + ", currentPackageSha256=" + this.f19958d + ", currentMetadataSha256=" + this.f19959e + ", signedManifest=" + this.f + ", signingPayloadBase64=" + this.g + ')';
    }

    public fy(String r2, String r3, int r4, String r5, String r6, JsonElement r7, String r8) {
        d.h.b.o.e(r2, "expectedManifestId");
        d.h.b.o.e(r3, "expectedSlug");
        d.h.b.o.e(r5, "currentPackageSha256");
        d.h.b.o.e(r6, "currentMetadataSha256");
        this.f19955a = r2;
        this.f19956b = r3;
        this.f19957c = r4;
        this.f19958d = r5;
        this.f19959e = r6;
        this.f = r7;
        this.g = r8;
    }

    public final String a() {
        return this.f19955a;
    }

    public final String b() {
        return this.f19956b;
    }

    public final int c() {
        return this.f19957c;
    }

    public final String d() {
        return this.f19958d;
    }

    public final String e() {
        return this.f19959e;
    }

    public final JsonElement f() {
        return this.f;
    }

    public final String g() {
        return this.g;
    }
}
