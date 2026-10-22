package com.obric.aiagent.skill.credentials.api;

import com.bytedance.crypto.platform.PlatformConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CredentialModels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f18940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f18941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f18942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final i f18943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f18944e;
    private final boolean f;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f18940a, r6.f18940a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f18941b, r6.f18941b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f18942c, r6.f18942c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f18943d, r6.f18943d) == true) goto L21;
        return false;
    L21:
        if (this.f18944e == r6.f18944e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.f18940a.hashCode() * 31) + this.f18941b.hashCode()) * 31) + this.f18942c.hashCode()) * 31;
        i r1 = this.f18943d;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + Boolean.hashCode(this.f18944e)) * 31) + Boolean.hashCode(this.f);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "CredentialAppRecord(providerId=" + this.f18940a + ", appId=" + this.f18941b + ", brand=" + this.f18942c + ", currentUser=" + this.f18943d + ", hasUserToken=" + this.f18944e + ", hasBotToken=" + this.f + ')';
    }

    public b(String r2, String r3, String r4, i r5, boolean r6, boolean r7) {
        d.h.b.o.e(r2, "providerId");
        d.h.b.o.e(r3, "appId");
        d.h.b.o.e(r4, PlatformConst.BUNDLE_KEY_BRAND);
        this.f18940a = r2;
        this.f18941b = r3;
        this.f18942c = r4;
        this.f18943d = r5;
        this.f18944e = r6;
        this.f = r7;
    }

    public final String a() {
        return this.f18941b;
    }

    public final i b() {
        return this.f18943d;
    }
}
