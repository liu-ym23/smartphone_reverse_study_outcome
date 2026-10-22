package com.bytedance.safetyguard.lxc.internal.e.a;

import com.bytedance.common.wschannel.WsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: UrlConnectionLarkOAuthClient.kt */
/* JADX INFO: loaded from: classes.dex */
final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f10412c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10413d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f10414e;
    private com.bytedance.safetyguard.lxc.internal.e.c.g f;

    public w() {
        this(0, 0, 0, 0, 0, null, 63, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, w.class) == true) goto L8;
        return false;
    L8:
        w r6 = (w) ZeusTransformUtils.preCheckCast(r5, w.class, "com.obric.aiagent.plugin");
        if (this.f10410a == r6.f10410a) goto L12;
        return false;
    L12:
        if (this.f10411b == r6.f10411b) goto L15;
        return false;
    L15:
        if (this.f10412c == r6.f10412c) goto L18;
        return false;
    L18:
        if (this.f10413d == r6.f10413d) goto L21;
        return false;
    L21:
        if (this.f10414e == r6.f10414e) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((Integer.hashCode(this.f10410a) * 31) + Integer.hashCode(this.f10411b)) * 31) + Integer.hashCode(this.f10412c)) * 31) + Integer.hashCode(this.f10413d)) * 31) + Integer.hashCode(this.f10414e)) * 31;
        com.bytedance.safetyguard.lxc.internal.e.c.g r2 = this.f;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "OAuthPollLogStats(attempts=" + this.f10410a + ", pendingCount=" + this.f10411b + ", slowDownCount=" + this.f10412c + ", networkRetryCount=" + this.f10413d + ", malformedRetryCount=" + this.f10414e + ", lastFailure=" + this.f + ')';
    }

    public w(int r1, int r2, int r3, int r4, int r5, com.bytedance.safetyguard.lxc.internal.e.c.g r6) {
        this.f10410a = r1;
        this.f10411b = r2;
        this.f10412c = r3;
        this.f10413d = r4;
        this.f10414e = r5;
        this.f = r6;
    }

    public /* synthetic */ w(int r2, int r3, int r4, int r5, int r6, com.bytedance.safetyguard.lxc.internal.e.c.g r7, int r8, d.h.b.h r9) {
        if ((r8 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r4 = 0;
    L12:
        if ((r8 & 8) == 0) goto L15;
        r5 = 0;
    L15:
        if ((r8 & 16) == 0) goto L18;
        r6 = 0;
    L18:
        if ((r8 & 32) == 0) goto L20;
        r7 = null;
    L20:
        this(r2, r3, r4, r5, r6, r7);
    }

    public final int a() {
        return this.f10410a;
    }

    public final void a(int r1) {
        this.f10410a = r1;
    }

    public final int b() {
        return this.f10411b;
    }

    public final int c() {
        return this.f10412c;
    }

    public final int d() {
        return this.f10413d;
    }

    public final int e() {
        return this.f10414e;
    }

    public final com.bytedance.safetyguard.lxc.internal.e.c.g f() {
        return this.f;
    }

    public final void a(r r2) {
        d.h.b.o.e(r2, "response");
        com.bytedance.safetyguard.lxc.internal.e.c.g r0 = r2.a().j();
        if (r0 == null) goto L5;
        this.f = r0;
    L5:
        com.bytedance.safetyguard.lxc.internal.e.c.g r3 = r2.a().j();
        if (r3 == null) goto L8;
        String r4 = r3.c();
    L10:
        if (d.h.b.o.a(r4, "authorization_pending") == false) goto L13;
        this.f10411b++;
        return;
    L13:
        if (d.h.b.o.a(r4, "slow_down") == false) goto L17;
        this.f10412c++;
        return;
    L17:
        return;
    L8:
        r4 = null;
        goto L10
    }

    public final void a(m r4) {
        d.h.b.o.e(r4, WsConstants.KEY_CONNECTION_ERROR);
        String r0 = r4.a();
        int r1 = r0.hashCode();
        if (r1 == (-1046606779)) goto L17;
        if (r1 == (-617237321)) goto L13;
        if (r1 == (-294502320)) goto L10;
    L20:
        com.bytedance.safetyguard.lxc.internal.e.c.g r5 = r4.c();
        if (r5 == null) goto L24;
        this.f = r5;
        return;
    L24:
        return;
    L10:
        if (r0.equals("network_timeout") == false) goto L20;
    L15:
        this.f10413d++;
        goto L20
    L13:
        if (r0.equals("network_error") == true) goto L15;
    L17:
        if (r0.equals("malformed_response") == false) goto L20;
        this.f10414e++;
        goto L20
    }
}
