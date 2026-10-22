package com.obric.aiagent.ipc.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: IPCAnomalyDetector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f18640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f18641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f18642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f18643d;

    public a() {
        this(false, 0, 0, 0, 15, null);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
        return false;
    L8:
        a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin");
        if (this.f18640a == r10.f18640a) goto L12;
        return false;
    L12:
        if (this.f18641b == r10.f18641b) goto L15;
        return false;
    L15:
        if (this.f18642c == r10.f18642c) goto L18;
        return false;
    L18:
        if (this.f18643d == r10.f18643d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.f18640a) * 31) + Long.hashCode(this.f18641b)) * 31) + Integer.hashCode(this.f18642c)) * 31) + Integer.hashCode(this.f18643d);
    }

    public String toString() {
        return "IPCAnomalyConfig(enabled=" + this.f18640a + ", slowCallThresholdMs=" + this.f18641b + ", frequentCallThresholdPerMinute=" + this.f18642c + ", reportLimitPerMinute=" + this.f18643d + ')';
    }

    public a(boolean r1, long r2, int r4, int r5) {
        this.f18640a = r1;
        this.f18641b = r2;
        this.f18642c = r4;
        this.f18643d = r5;
    }

    public /* synthetic */ a(boolean r4, long r5, int r7, int r8, int r9, d.h.b.h r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = true;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = 200;
    L8:
        long r0 = r5;
        if ((r9 & 4) == 0) goto L11;
        r7 = 3000;
    L11:
        int r11 = r7;
        if ((r9 & 8) == 0) goto L14;
        r8 = 60;
    L14:
        boolean r6 = r4;
        this(r6, r0, r11, r8);
    }

    public final boolean a() {
        return this.f18640a;
    }

    public final long b() {
        return this.f18641b;
    }

    public final int c() {
        return this.f18642c;
    }

    public final int d() {
        return this.f18643d;
    }
}
