package com.bytedance.safetyguard.lxc.internal.d;

import com.bytedance.safetyguard.lxc.api.ProxySessionCloseReason;
import com.bytedance.safetyguard.lxc.api.ProxySessionErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppGatewayProxySession.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ProxySessionCloseReason f10227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ProxySessionErrorCode f10228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10229c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final u f10230d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
        if (this.f10227a == r6.f10227a) goto L12;
        return false;
    L12:
        if (this.f10228b == r6.f10228b) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f10229c, r6.f10229c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f10230d, r6.f10230d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = this.f10227a.hashCode() * 31;
        ProxySessionErrorCode r1 = this.f10228b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.f10229c;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((r4 + r2) * 31) + this.f10230d.hashCode();
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "AppGatewaySessionOutcome(closeReason=" + this.f10227a + ", errorCode=" + this.f10228b + ", message=" + this.f10229c + ", stats=" + this.f10230d + ')';
    }

    public f(ProxySessionCloseReason r2, ProxySessionErrorCode r3, String r4, u r5) {
        d.h.b.o.e(r2, "closeReason");
        d.h.b.o.e(r5, "stats");
        this.f10227a = r2;
        this.f10228b = r3;
        this.f10229c = r4;
        this.f10230d = r5;
    }

    public final ProxySessionCloseReason a() {
        return this.f10227a;
    }

    public final ProxySessionErrorCode b() {
        return this.f10228b;
    }

    public final String c() {
        return this.f10229c;
    }

    public final u d() {
        return this.f10230d;
    }
}
