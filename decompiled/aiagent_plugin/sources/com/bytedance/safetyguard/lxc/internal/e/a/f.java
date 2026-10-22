package com.bytedance.safetyguard.lxc.internal.e.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: LarkAuthModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f10350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f10351d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f10348a, r6.f10348a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f10349b, r6.f10349b) == true) goto L15;
        return false;
    L15:
        if (this.f10350c == r6.f10350c) goto L18;
        return false;
    L18:
        if (this.f10351d == r6.f10351d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f10348a.hashCode() * 31) + this.f10349b.hashCode()) * 31) + Integer.hashCode(this.f10350c)) * 31) + Integer.hashCode(this.f10351d);
    }

    public String toString() {
        return "LarkAppRegistrationBeginResponse(deviceCode=" + this.f10348a + ", verificationUrl=" + this.f10349b + ", expiresInSec=" + this.f10350c + ", intervalSec=" + this.f10351d + ')';
    }

    public f(String r2, String r3, int r4, int r5) {
        d.h.b.o.e(r2, "deviceCode");
        d.h.b.o.e(r3, "verificationUrl");
        this.f10348a = r2;
        this.f10349b = r3;
        this.f10350c = r4;
        this.f10351d = r5;
    }

    public final String a() {
        return this.f10348a;
    }

    public final String b() {
        return this.f10349b;
    }

    public final int c() {
        return this.f10350c;
    }

    public final int d() {
        return this.f10351d;
    }
}
