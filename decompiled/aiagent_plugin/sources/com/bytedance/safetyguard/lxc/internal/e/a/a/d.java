package com.bytedance.safetyguard.lxc.internal.e.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.l.n;

/* JADX INFO: compiled from: OAuthPollingModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f10310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f10311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f10312d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Integer f10313e;

    public static /* synthetic */ d a(d r3, int r4, int r5, a r6, int r7, Integer r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.f10309a;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.f10310b;
    L8:
        int r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.f10311c;
    L11:
        a r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.f10312d;
    L14:
        int r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.f10313e;
    L17:
        int r12 = r4;
        return r3.a(r12, r11, r0, r1, r8);
    }

    public final d a(int r7, int r8, a r9, int r10, Integer r11) {
        o.e(r9, "initialDelay");
        return new d(r7, r8, r9, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
        if (this.f10309a == r6.f10309a) goto L12;
        return false;
    L12:
        if (this.f10310b == r6.f10310b) goto L15;
        return false;
    L15:
        if (this.f10311c == r6.f10311c) goto L18;
        return false;
    L18:
        if (this.f10312d == r6.f10312d) goto L21;
        return false;
    L21:
        if (o.a(this.f10313e, r6.f10313e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((Integer.hashCode(this.f10309a) * 31) + Integer.hashCode(this.f10310b)) * 31) + this.f10311c.hashCode()) * 31) + Integer.hashCode(this.f10312d)) * 31;
        Integer r2 = this.f10313e;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "OAuthPollConfig(initialIntervalSec=" + this.f10309a + ", expiresInSec=" + this.f10310b + ", initialDelay=" + this.f10311c + ", maxIntervalSec=" + this.f10312d + ", maxAttempts=" + this.f10313e + ')';
    }

    public d(int r2, int r3, a r4, int r5, Integer r6) {
        o.e(r4, "initialDelay");
        this.f10309a = r2;
        this.f10310b = r3;
        this.f10311c = r4;
        this.f10312d = r5;
        this.f10313e = r6;
    }

    public /* synthetic */ d(int r7, int r8, a r9, int r10, Integer r11, int r12, d.h.b.h r13) {
        if ((r12 & 8) == 0) goto L5;
        r10 = 60;
    L5:
        int r4 = r10;
        if ((r12 & 16) == 0) goto L8;
        r11 = null;
    L8:
        this(r7, r8, r9, r4, r11);
    }

    public final int a() {
        return this.f10309a;
    }

    public final int b() {
        return this.f10310b;
    }

    public final a c() {
        return this.f10311c;
    }

    public final int d() {
        return this.f10312d;
    }

    public final Integer e() {
        return this.f10313e;
    }

    public final d f() {
        int r3 = n.c(this.f10309a, 1);
        return a(this, r3, n.c(this.f10310b, 1), null, n.c(this.f10312d, r3), null, 20, null);
    }
}
