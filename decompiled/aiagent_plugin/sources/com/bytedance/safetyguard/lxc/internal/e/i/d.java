package com.bytedance.safetyguard.lxc.internal.e.i;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Set;

/* JADX INFO: compiled from: CredentialStore.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f10909d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f10910e;
    private final long f;
    private final long g;
    private final Set<String> h;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, d.class) == true) goto L8;
        return false;
    L8:
        d r10 = (d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.aiagent.plugin");
        if (o.a(this.f10906a, r10.f10906a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f10907b, r10.f10907b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f10908c, r10.f10908c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f10909d, r10.f10909d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f10910e, r10.f10910e) == true) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L30;
        return false;
    L30:
        if (o.a(this.h, r10.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.f10906a.hashCode() * 31) + this.f10907b.hashCode()) * 31;
        String r1 = this.f10908c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((((((((r0 + r2) * 31) + this.f10909d.hashCode()) * 31) + this.f10910e.hashCode()) * 31) + Long.hashCode(this.f)) * 31) + Long.hashCode(this.g)) * 31) + this.h.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public d(String r3, String r4, String r5, String r6, String r7, long r8, long r10, Set<String> r12) {
        Set<String> r13 = (Set) ZeusTransformUtils.wrapperContextForParams(r12, Set.class, "com.obric.aiagent.plugin");
        o.e(r3, "appId");
        o.e(r4, "openId");
        o.e(r6, "accessToken");
        o.e(r7, "refreshToken");
        o.e(r13, "scopes");
        this.f10906a = r3;
        this.f10907b = r4;
        this.f10908c = r5;
        this.f10909d = r6;
        this.f10910e = r7;
        this.f = r8;
        this.g = r10;
        this.h = r13;
    }

    public final String a() {
        return this.f10906a;
    }

    public final String b() {
        return this.f10907b;
    }

    public final String c() {
        return this.f10908c;
    }

    public final String d() {
        return this.f10909d;
    }

    public final String e() {
        return this.f10910e;
    }

    public final long f() {
        return this.f;
    }

    public final long g() {
        return this.g;
    }

    public final Set<String> h() {
        return this.h;
    }

    public String toString() {
        return "StoredUserToken(appId=" + this.f10906a + ", openId=" + this.f10907b + ", name=" + this.f10908c + ", accessToken=<redacted>, refreshToken=<redacted>, accessTokenExpiresAtMillis=" + this.f + ", refreshTokenExpiresAtMillis=" + this.g + ", scopes=" + this.h + ')';
    }
}
