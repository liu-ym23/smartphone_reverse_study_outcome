package com.obric.agent.trace.toolmetrics;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OmniClientToolTraceModels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f15898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f15899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f15900d;

    public k() {
        this(null, null, null, null, 15, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, k.class) == true) goto L8;
        return false;
    L8:
        k r6 = (k) ZeusTransformUtils.preCheckCast(r5, k.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f15897a, r6.f15897a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f15898b, r6.f15898b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f15899c, r6.f15899c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f15900d, r6.f15900d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.f15897a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.f15898b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.f15899c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.f15900d;
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
        return "OmniClientToolCorrelation(omniTaskId=" + this.f15897a + ", questionId=" + this.f15898b + ", messageId=" + this.f15899c + ", omniExecuteId=" + this.f15900d + ')';
    }

    public k(String r1, String r2, String r3, String r4) {
        this.f15897a = r1;
        this.f15898b = r2;
        this.f15899c = r3;
        this.f15900d = r4;
    }

    public /* synthetic */ k(String r2, String r3, String r4, String r5, int r6, d.h.b.h r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }

    public final String a() {
        return this.f15897a;
    }

    public final String b() {
        return this.f15898b;
    }

    public final String c() {
        return this.f15899c;
    }

    public final String d() {
        return this.f15900d;
    }
}
