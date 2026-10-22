package com.bytedance.safetyguard.lxc.internal.e.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: LarkAuthModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f10399b;

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, t.class) == true) goto L8;
        return false;
    L8:
        t r8 = (t) ZeusTransformUtils.preCheckCast(r7, t.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f10398a, r8.f10398a) == true) goto L12;
        return false;
    L12:
        if (this.f10399b == r8.f10399b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f10398a.hashCode() * 31) + Long.hashCode(this.f10399b);
    }

    public t(String r2, long r3) {
        d.h.b.o.e(r2, "accessToken");
        this.f10398a = r2;
        this.f10399b = r3;
    }

    public final String a() {
        return this.f10398a;
    }

    public final long b() {
        return this.f10399b;
    }

    public String toString() {
        return "LarkTenantTokenSet(accessToken=<redacted>, expiresAtMillis=" + this.f10399b + ')';
    }
}
