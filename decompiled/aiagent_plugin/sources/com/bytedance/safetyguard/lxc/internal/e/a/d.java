package com.bytedance.safetyguard.lxc.internal.e.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: LarkDeviceTokenPollStrategy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final v f10345c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bytedance.safetyguard.lxc.internal.e.c.g f10346d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f10343a, r6.f10343a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f10344b, r6.f10344b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f10345c, r6.f10345c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f10346d, r6.f10346d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.f10343a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.f10344b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        v r7 = this.f10345c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        com.bytedance.safetyguard.lxc.internal.e.c.g r10 = this.f10346d;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "DeviceTokenPollResponse(error=" + this.f10343a + ", errorDescription=" + this.f10344b + ", token=" + this.f10345c + ", failure=" + this.f10346d + ')';
    }

    public d(String r1, String r2, v r3, com.bytedance.safetyguard.lxc.internal.e.c.g r4) {
        this.f10343a = r1;
        this.f10344b = r2;
        this.f10345c = r3;
        this.f10346d = r4;
    }

    public final String a() {
        return this.f10343a;
    }

    public final String b() {
        return this.f10344b;
    }

    public final v c() {
        return this.f10345c;
    }

    public final com.bytedance.safetyguard.lxc.internal.e.c.g d() {
        return this.f10346d;
    }
}
