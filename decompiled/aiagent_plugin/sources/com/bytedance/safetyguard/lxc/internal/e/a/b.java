package com.bytedance.safetyguard.lxc.internal.e.a;

import com.bytedance.safetyguard.lxc.api.sidecar.SidecarBrand;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: LarkAppRegistrationPollStrategy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SidecarBrand f10338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f10339d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bytedance.safetyguard.lxc.internal.e.c.g f10340e;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f10336a, r6.f10336a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f10337b, r6.f10337b) == true) goto L15;
        return false;
    L15:
        if (this.f10338c == r6.f10338c) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f10339d, r6.f10339d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f10340e, r6.f10340e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.f10336a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.f10337b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        SidecarBrand r7 = this.f10338c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        a r10 = this.f10339d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        com.bytedance.safetyguard.lxc.internal.e.c.g r13 = this.f10340e;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
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
        return "AppRegistrationPollResponse(error=" + this.f10336a + ", errorDescription=" + this.f10337b + ", tenantBrand=" + this.f10338c + ", credentials=" + this.f10339d + ", failure=" + this.f10340e + ')';
    }

    public b(String r1, String r2, SidecarBrand r3, a r4, com.bytedance.safetyguard.lxc.internal.e.c.g r5) {
        this.f10336a = r1;
        this.f10337b = r2;
        this.f10338c = r3;
        this.f10339d = r4;
        this.f10340e = r5;
    }

    public final String a() {
        return this.f10336a;
    }

    public final String b() {
        return this.f10337b;
    }

    public final SidecarBrand c() {
        return this.f10338c;
    }

    public final a d() {
        return this.f10339d;
    }

    public final com.bytedance.safetyguard.lxc.internal.e.c.g e() {
        return this.f10340e;
    }
}
