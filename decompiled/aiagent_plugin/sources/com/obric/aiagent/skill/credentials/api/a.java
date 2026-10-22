package com.obric.aiagent.skill.credentials.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: CredentialModels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f18935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f18936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<String> f18937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Long f18938d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Long f18939e;

    public static /* synthetic */ a a(a r6, b r7, boolean r8, List r9, Long r10, Long r11, int r12, Object r13) {
        List<String> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.f18935a;
    L5:
        b r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r8 = r6.f18936b;
    L8:
        boolean r2 = r8;
        if ((r12 & 4) == 0) goto L11;
        r14 = r6.f18937c;
    L11:
        List<String> r3 = r14;
        if ((r12 & 8) == 0) goto L14;
        r10 = r6.f18938d;
    L14:
        Long r4 = r10;
        if ((r12 & 16) == 0) goto L18;
        r11 = r6.f18939e;
    L18:
        return r6.a(r1, r2, r3, r4, r11);
    }

    public final a a(b r7, boolean r8, List<String> r9, Long r10, Long r11) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "grantedScopes");
        return new a(r7, r8, r3, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f18935a, r6.f18935a) == true) goto L12;
        return false;
    L12:
        if (this.f18936b == r6.f18936b) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f18937c, r6.f18937c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f18938d, r6.f18938d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f18939e, r6.f18939e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        b r0 = this.f18935a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((((r2 * 31) + Boolean.hashCode(this.f18936b)) * 31) + this.f18937c.hashCode()) * 31;
        Long r4 = this.f18938d;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.f18939e;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "CredentialAccountStatus(app=" + this.f18935a + ", loggedIn=" + this.f18936b + ", grantedScopes=" + this.f18937c + ", accessTokenExpiresAtMillis=" + this.f18938d + ", refreshTokenExpiresAtMillis=" + this.f18939e + ')';
    }

    public a(b r3, boolean r4, List<String> r5, Long r6, Long r7) {
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "grantedScopes");
        this.f18935a = r3;
        this.f18936b = r4;
        this.f18937c = r8;
        this.f18938d = r6;
        this.f18939e = r7;
    }

    public final b a() {
        return this.f18935a;
    }

    public final boolean b() {
        return this.f18936b;
    }

    public final List<String> c() {
        return this.f18937c;
    }

    public final Long d() {
        return this.f18938d;
    }

    public final Long e() {
        return this.f18939e;
    }
}
