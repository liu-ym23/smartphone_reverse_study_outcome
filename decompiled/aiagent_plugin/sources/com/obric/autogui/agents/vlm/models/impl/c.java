package com.obric.autogui.agents.vlm.models.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: StandardModelBaseStep.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f27605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f27606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f27607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f27608d;

    public c() {
        this(false, false, 0, false, 15, null);
    }

    public static /* synthetic */ c a(c r3, boolean r4, boolean r5, long r6, boolean r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.f27605a;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.f27606b;
    L8:
        boolean r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.f27607c;
    L11:
        long r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r8 = r3.f27608d;
    L14:
        boolean r7 = r4;
        return r3.a(r7, r11, r0, r8);
    }

    public final c a(boolean r7, boolean r8, long r9, boolean r11) {
        return new c(r7, r8, r9, r11);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, c.class) == true) goto L8;
        return false;
    L8:
        c r10 = (c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.aiagent.plugin");
        if (this.f27605a == r10.f27605a) goto L12;
        return false;
    L12:
        if (this.f27606b == r10.f27606b) goto L15;
        return false;
    L15:
        if (this.f27607c == r10.f27607c) goto L18;
        return false;
    L18:
        if (this.f27608d == r10.f27608d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.f27605a) * 31) + Boolean.hashCode(this.f27606b)) * 31) + Long.hashCode(this.f27607c)) * 31) + Boolean.hashCode(this.f27608d);
    }

    public String toString() {
        return "RuleStabilityTrackingSnapshot(registered=" + this.f27605a + ", pageSwitchCallbackReceived=" + this.f27606b + ", waitDurationMillis=" + this.f27607c + ", waitedForPageSwitch=" + this.f27608d + ')';
    }

    public c(boolean r1, boolean r2, long r3, boolean r5) {
        this.f27605a = r1;
        this.f27606b = r2;
        this.f27607c = r3;
        this.f27608d = r5;
    }

    public /* synthetic */ c(boolean r2, boolean r3, long r4, boolean r6, int r7, d.h.b.h r8) {
        if ((r7 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = 0;
    L12:
        if ((r7 & 8) == 0) goto L14;
        r6 = false;
    L14:
        this(r2, r3, r4, r6);
    }

    public final boolean a() {
        return this.f27605a;
    }

    public final boolean b() {
        return this.f27606b;
    }

    public final long c() {
        return this.f27607c;
    }

    public final boolean d() {
        return this.f27608d;
    }
}
