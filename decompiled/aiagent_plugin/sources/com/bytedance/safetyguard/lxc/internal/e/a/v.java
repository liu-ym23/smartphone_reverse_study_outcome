package com.bytedance.safetyguard.lxc.internal.e.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;

/* JADX INFO: compiled from: LarkAuthModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10407c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f10408d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f10409e;
    private final long f;
    private final Set<String> g;

    public static /* synthetic */ v a(v r11, String r12, String r13, String r14, String r15, long r16, long r18, Set r20, int r21, Object r22) {
        Set<String> r1 = (Set) ZeusTransformUtils.wrapperContextForParams(r20, Set.class, "com.obric.aiagent.plugin");
        if ((r21 & 1) == 0) goto L5;
        String r2 = r11.f10405a;
    L7:
        if ((r21 & 2) == 0) goto L9;
        String r3 = r11.f10406b;
    L11:
        if ((r21 & 4) == 0) goto L13;
        String r4 = r11.f10407c;
    L15:
        if ((r21 & 8) == 0) goto L17;
        String r5 = r11.f10408d;
    L19:
        if ((r21 & 16) == 0) goto L21;
        long r6 = r11.f10409e;
    L23:
        if ((r21 & 32) == 0) goto L25;
        long r8 = r11.f;
    L27:
        if ((r21 & 64) == 0) goto L30;
        r1 = r11.g;
    L30:
        return r11.a(r2, r3, r4, r5, r6, r8, r1);
    L25:
        r8 = r18;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    public final v a(String r12, String r13, String r14, String r15, long r16, long r18, Set<String> r20) {
        Set r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r20, Set.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r12, "openId");
        d.h.b.o.e(r14, "accessToken");
        d.h.b.o.e(r15, "refreshToken");
        d.h.b.o.e(r10, "scopes");
        return new v(r12, r13, r14, r15, r16, r18, r10);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, v.class) == true) goto L8;
        return false;
    L8:
        v r10 = (v) ZeusTransformUtils.preCheckCast(r9, v.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f10405a, r10.f10405a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f10406b, r10.f10406b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f10407c, r10.f10407c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f10408d, r10.f10408d) == true) goto L21;
        return false;
    L21:
        if (this.f10409e == r10.f10409e) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.g, r10.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = this.f10405a.hashCode() * 31;
        String r1 = this.f10406b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((((((((r0 + r2) * 31) + this.f10407c.hashCode()) * 31) + this.f10408d.hashCode()) * 31) + Long.hashCode(this.f10409e)) * 31) + Long.hashCode(this.f)) * 31) + this.g.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public v(String r3, String r4, String r5, String r6, long r7, long r9, Set<String> r11) {
        Set<String> r12 = (Set) ZeusTransformUtils.wrapperContextForParams(r11, Set.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "openId");
        d.h.b.o.e(r5, "accessToken");
        d.h.b.o.e(r6, "refreshToken");
        d.h.b.o.e(r12, "scopes");
        this.f10405a = r3;
        this.f10406b = r4;
        this.f10407c = r5;
        this.f10408d = r6;
        this.f10409e = r7;
        this.f = r9;
        this.g = r12;
    }

    public final String a() {
        return this.f10405a;
    }

    public final String b() {
        return this.f10406b;
    }

    public final String c() {
        return this.f10407c;
    }

    public final String d() {
        return this.f10408d;
    }

    public final long e() {
        return this.f10409e;
    }

    public final long f() {
        return this.f;
    }

    public final Set<String> g() {
        return this.g;
    }

    public String toString() {
        return "LarkTokenSet(openId=" + this.f10405a + ", name=" + this.f10406b + ", accessToken=<redacted>, refreshToken=<redacted>, accessTokenExpiresAtMillis=" + this.f10409e + ", refreshTokenExpiresAtMillis=" + this.f + ", scopes=" + this.g + ')';
    }
}
