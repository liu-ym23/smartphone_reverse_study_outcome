package com.obric.agent.trace.toolmetrics;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OmniClientToolTraceModels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f15905b;

    /* JADX WARN: Multi-variable type inference failed */
    public m() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, m.class) == true) goto L8;
        return false;
    L8:
        m r6 = (m) ZeusTransformUtils.preCheckCast(r5, m.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f15904a, r6.f15904a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f15905b, r6.f15905b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.f15904a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.f15905b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "OmniClientToolRawError(code=" + this.f15904a + ", message=" + this.f15905b + ')';
    }

    public m(String r1, String r2) {
        this.f15904a = r1;
        this.f15905b = r2;
    }

    public /* synthetic */ m(String r2, String r3, int r4, d.h.b.h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final String a() {
        return this.f15904a;
    }

    public final String b() {
        return this.f15905b;
    }

    public final boolean c() {
        if (this.f15904a == null) goto L5;
    L8:
        return true;
    L5:
        if (this.f15905b != null) goto L8;
        return false;
    }
}
