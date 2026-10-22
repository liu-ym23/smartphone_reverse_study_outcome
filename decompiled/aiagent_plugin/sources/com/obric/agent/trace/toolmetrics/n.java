package com.obric.agent.trace.toolmetrics;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OmniClientToolTraceModels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l f15906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k f15907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final m f15908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final m f15909d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final u f15910e;

    public n() {
        this(null, null, null, null, null, 31, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, n.class) == true) goto L8;
        return false;
    L8:
        n r6 = (n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f15906a, r6.f15906a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f15907b, r6.f15907b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f15908c, r6.f15908c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f15909d, r6.f15909d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f15910e, r6.f15910e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        l r0 = this.f15906a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        k r4 = this.f15907b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        m r7 = this.f15908c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        m r10 = this.f15909d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        u r13 = this.f15910e;
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
        return "OmniClientToolTraceAppendix(meta=" + this.f15906a + ", correlation=" + this.f15907b + ", executeError=" + this.f15908c + ", deliveryError=" + this.f15909d + ", fragment=" + this.f15910e + ')';
    }

    public n(l r1, k r2, m r3, m r4, u r5) {
        this.f15906a = r1;
        this.f15907b = r2;
        this.f15908c = r3;
        this.f15909d = r4;
        this.f15910e = r5;
    }

    public /* synthetic */ n(l r2, k r3, m r4, m r5, u r6, int r7, d.h.b.h r8) {
        if ((r7 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r7 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r7 & 16) == 0) goto L17;
        r6 = null;
    L17:
        this(r2, r3, r4, r5, r6);
    }

    public final l a() {
        return this.f15906a;
    }

    public final k b() {
        return this.f15907b;
    }

    public final m c() {
        return this.f15908c;
    }

    public final m d() {
        return this.f15909d;
    }

    public final u e() {
        return this.f15910e;
    }
}
