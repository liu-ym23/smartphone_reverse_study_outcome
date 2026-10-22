package com.obric.aiagent.skill.credentials.api;

import com.bytedance.crypto.platform.PlatformConst;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: CredentialModels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f18954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, String> f18955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f18956c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f18957d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f18958e;

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, g.class) == true) goto L8;
        return false;
    L8:
        g r8 = (g) ZeusTransformUtils.preCheckCast(r7, g.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f18954a, r8.f18954a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f18955b, r8.f18955b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f18956c, r8.f18956c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f18957d, r8.f18957d) == true) goto L21;
        return false;
    L21:
        if (this.f18958e == r8.f18958e) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.f18954a.hashCode() * 31) + this.f18955b.hashCode()) * 31) + this.f18956c.hashCode()) * 31) + this.f18957d.hashCode()) * 31) + Long.hashCode(this.f18958e);
    }

    public String toString() {
        return "CredentialSessionEnv(sessionId=" + this.f18954a + ", env=" + this.f18955b + ", appId=" + this.f18956c + ", brand=" + this.f18957d + ", expiresAtMillis=" + this.f18958e + ')';
    }

    public g(String r3, Map<String, String> r4, String r5, String r6, long r7) {
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, ObricMemoryConstants.KEY_SESSION_ID);
        d.h.b.o.e(r8, "env");
        d.h.b.o.e(r5, "appId");
        d.h.b.o.e(r6, PlatformConst.BUNDLE_KEY_BRAND);
        this.f18954a = r3;
        this.f18955b = r8;
        this.f18956c = r5;
        this.f18957d = r6;
        this.f18958e = r7;
    }

    public final String a() {
        return this.f18954a;
    }

    public final Map<String, String> b() {
        return this.f18955b;
    }

    public final String c() {
        return this.f18956c;
    }

    public final String d() {
        return this.f18957d;
    }

    public final long e() {
        return this.f18958e;
    }
}
