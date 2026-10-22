package com.obric.agent.complextask;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: HeartbeatResult.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f14355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f14357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f14358d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
        if (this.f14355a == r6.f14355a) goto L12;
        return false;
    L12:
        if (o.a(this.f14356b, r6.f14356b) == true) goto L15;
        return false;
    L15:
        if (this.f14357c == r6.f14357c) goto L18;
        return false;
    L18:
        if (o.a(this.f14358d, r6.f14358d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = Integer.hashCode(this.f14355a) * 31;
        String r1 = this.f14356b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + Boolean.hashCode(this.f14357c)) * 31;
        String r5 = this.f14358d;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "HeartbeatResult(code=" + this.f14355a + ", state=" + this.f14356b + ", success=" + this.f14357c + ", errorMessage=" + this.f14358d + ')';
    }

    public d(int r1, String r2, boolean r3, String r4) {
        this.f14355a = r1;
        this.f14356b = r2;
        this.f14357c = r3;
        this.f14358d = r4;
    }

    public final int a() {
        return this.f14355a;
    }

    public final String b() {
        return this.f14356b;
    }

    public final boolean c() {
        if (this.f14355a != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
