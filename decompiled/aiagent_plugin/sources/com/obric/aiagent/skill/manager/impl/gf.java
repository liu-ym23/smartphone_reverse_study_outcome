package com.obric.aiagent.skill.manager.impl;

import com.google.gson.JsonElement;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillSigningStateStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class gf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JsonElement f19982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19983b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, gf.class) == true) goto L8;
        return false;
    L8:
        gf r6 = (gf) ZeusTransformUtils.preCheckCast(r5, gf.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19982a, r6.f19982a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19983b, r6.f19983b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.f19982a.hashCode() * 31;
        String r1 = this.f19983b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "SkillSigningManifestSnapshot(signedManifest=" + this.f19982a + ", signingPayloadBase64=" + this.f19983b + ')';
    }

    public gf(JsonElement r2, String r3) {
        d.h.b.o.e(r2, "signedManifest");
        this.f19982a = r2;
        this.f19983b = r3;
    }

    public final JsonElement a() {
        return this.f19982a;
    }

    public final String b() {
        return this.f19983b;
    }
}
