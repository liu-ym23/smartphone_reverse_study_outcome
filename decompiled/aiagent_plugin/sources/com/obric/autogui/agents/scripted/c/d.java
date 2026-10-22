package com.obric.autogui.agents.scripted.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ScriptResourceUpdateConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f26921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f26922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f26923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f26924d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f26925e;
    private final int f;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, d.class) == true) goto L8;
        return false;
    L8:
        d r10 = (d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.aiagent.plugin");
        if (this.f26921a == r10.f26921a) goto L12;
        return false;
    L12:
        if (this.f26922b == r10.f26922b) goto L15;
        return false;
    L15:
        if (this.f26923c == r10.f26923c) goto L18;
        return false;
    L18:
        if (this.f26924d == r10.f26924d) goto L21;
        return false;
    L21:
        if (this.f26925e == r10.f26925e) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((Long.hashCode(this.f26921a) * 31) + Long.hashCode(this.f26922b)) * 31) + Long.hashCode(this.f26923c)) * 31) + Long.hashCode(this.f26924d)) * 31) + Long.hashCode(this.f26925e)) * 31) + Integer.hashCode(this.f);
    }

    public String toString() {
        return "ScriptResourceUpdateConfig(successCooldownMs=" + this.f26921a + ", attemptFloorMs=" + this.f26922b + ", wifiSettleDelayMs=" + this.f26923c + ", periodicIntervalMs=" + this.f26924d + ", roundTimeoutMs=" + this.f26925e + ", downloadRetryCount=" + this.f + ')';
    }

    public d(long r1, long r3, long r5, long r7, long r9, int r11) {
        this.f26921a = r1;
        this.f26922b = r3;
        this.f26923c = r5;
        this.f26924d = r7;
        this.f26925e = r9;
        this.f = r11;
    }

    public final long a() {
        return this.f26921a;
    }

    public final long b() {
        return this.f26922b;
    }

    public final long c() {
        return this.f26923c;
    }

    public final long d() {
        return this.f26924d;
    }

    public final long e() {
        return this.f26925e;
    }

    public final int f() {
        return this.f;
    }
}
