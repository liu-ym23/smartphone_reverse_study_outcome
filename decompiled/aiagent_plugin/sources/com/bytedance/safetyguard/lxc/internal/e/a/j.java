package com.bytedance.safetyguard.lxc.internal.e.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;

/* JADX INFO: compiled from: LarkAuthModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f10373c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f10374d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set<String> f10375e;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, j.class) == true) goto L8;
        return false;
    L8:
        j r6 = (j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f10371a, r6.f10371a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f10372b, r6.f10372b) == true) goto L15;
        return false;
    L15:
        if (this.f10373c == r6.f10373c) goto L18;
        return false;
    L18:
        if (this.f10374d == r6.f10374d) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f10375e, r6.f10375e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.f10371a.hashCode() * 31) + this.f10372b.hashCode()) * 31) + Integer.hashCode(this.f10373c)) * 31) + Integer.hashCode(this.f10374d)) * 31) + this.f10375e.hashCode();
    }

    public String toString() {
        return "LarkDeviceAuthorizationResponse(deviceCode=" + this.f10371a + ", verificationUrl=" + this.f10372b + ", expiresInSec=" + this.f10373c + ", intervalSec=" + this.f10374d + ", requestedScopes=" + this.f10375e + ')';
    }

    public j(String r3, String r4, int r5, int r6, Set<String> r7) {
        Set<String> r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "deviceCode");
        d.h.b.o.e(r4, "verificationUrl");
        d.h.b.o.e(r8, "requestedScopes");
        this.f10371a = r3;
        this.f10372b = r4;
        this.f10373c = r5;
        this.f10374d = r6;
        this.f10375e = r8;
    }

    public final String a() {
        return this.f10371a;
    }

    public final String b() {
        return this.f10372b;
    }

    public final int c() {
        return this.f10373c;
    }

    public final int d() {
        return this.f10374d;
    }

    public final Set<String> e() {
        return this.f10375e;
    }
}
