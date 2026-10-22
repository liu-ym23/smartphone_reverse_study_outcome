package com.bytedance.safetyguard.lxc.internal.d;

import com.bytedance.safetyguard.lxc.api.ProxySessionCloseReason;
import com.bytedance.safetyguard.lxc.api.ProxySessionErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppGatewayProxySession.kt */
/* JADX INFO: loaded from: classes.dex */
final class aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ProxySessionCloseReason f10172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ProxySessionErrorCode f10173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10174c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, aj.class) == true) goto L8;
        return false;
    L8:
        aj r6 = (aj) ZeusTransformUtils.preCheckCast(r5, aj.class, "com.obric.aiagent.plugin");
        if (this.f10172a == r6.f10172a) goto L12;
        return false;
    L12:
        if (this.f10173b == r6.f10173b) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f10174c, r6.f10174c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.f10172a.hashCode() * 31;
        ProxySessionErrorCode r1 = this.f10173b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.f10174c;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "TerminalState(closeReason=" + this.f10172a + ", errorCode=" + this.f10173b + ", message=" + this.f10174c + ')';
    }

    public aj(ProxySessionCloseReason r2, ProxySessionErrorCode r3, String r4) {
        d.h.b.o.e(r2, "closeReason");
        this.f10172a = r2;
        this.f10173b = r3;
        this.f10174c = r4;
    }

    public final ProxySessionCloseReason a() {
        return this.f10172a;
    }

    public final ProxySessionErrorCode b() {
        return this.f10173b;
    }

    public final String c() {
        return this.f10174c;
    }
}
