package com.obric.aiagent.executionengine.capabilitymanager.api.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: UnifiedCapability.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f16404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f16405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f16406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f16407d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f16408e;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (this.f16404a == r6.f16404a) goto L12;
        return false;
    L12:
        if (o.a(this.f16405b, r6.f16405b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f16406c, r6.f16406c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f16407d, r6.f16407d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f16408e, r6.f16408e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((this.f16404a.hashCode() * 31) + this.f16405b.hashCode()) * 31) + this.f16406c.hashCode()) * 31) + this.f16407d.hashCode()) * 31;
        String r2 = this.f16408e;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "UnifiedCapability(type=" + this.f16404a + ", capabilityName=" + this.f16405b + ", packageName=" + this.f16406c + ", implRef=" + this.f16407d + ", service=" + this.f16408e + ')';
    }

    public b(a r2, String r3, String r4, String r5, String r6) {
        o.e(r2, "type");
        o.e(r3, "capabilityName");
        o.e(r4, "packageName");
        o.e(r5, "implRef");
        this.f16404a = r2;
        this.f16405b = r3;
        this.f16406c = r4;
        this.f16407d = r5;
        this.f16408e = r6;
    }

    public /* synthetic */ b(a r7, String r8, String r9, String r10, String r11, int r12, h r13) {
        if ((r12 & 16) == 0) goto L5;
        r11 = null;
    L5:
        this(r7, r8, r9, r10, r11);
    }

    public final a getType() {
        return this.f16404a;
    }

    public final String a() {
        return this.f16405b;
    }

    public final String b() {
        return this.f16406c;
    }

    public final String c() {
        return this.f16407d;
    }
}
