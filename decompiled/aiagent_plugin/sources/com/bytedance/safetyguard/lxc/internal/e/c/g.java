package com.bytedance.safetyguard.lxc.internal.e.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: SidecarHttpDiagnostics.kt */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Integer f10742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f10743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f10745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f10746e;
    private final String f;

    public static /* synthetic */ g a(g r4, Integer r5, Integer r6, String r7, String r8, String r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.f10742a;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.f10743b;
    L8:
        Integer r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.f10744c;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.f10745d;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.f10746e;
    L17:
        String r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.f;
    L20:
        Integer r14 = r5;
        return r4.a(r14, r13, r0, r1, r2, r10);
    }

    public final g a(Integer r8, Integer r9, String r10, String r11, String r12, String r13) {
        return new g(r8, r9, r10, r11, r12, r13);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
        return false;
    L8:
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
        if (o.a(this.f10742a, r6.f10742a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f10743b, r6.f10743b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f10744c, r6.f10744c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f10745d, r6.f10745d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f10746e, r6.f10746e) == true) goto L24;
        return false;
    L24:
        if (o.a(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.f10742a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.f10743b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.f10744c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.f10745d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.f10746e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
    L21:
        r14 = r13.hashCode();
        goto L22
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
        return "UpstreamFailure(httpStatus=" + this.f10742a + ", subcode=" + this.f10743b + ", subtype=" + this.f10744c + ", safeMessage=" + this.f10745d + ", logId=" + this.f10746e + ", requestId=" + this.f + ')';
    }

    public g(Integer r1, Integer r2, String r3, String r4, String r5, String r6) {
        this.f10742a = r1;
        this.f10743b = r2;
        this.f10744c = r3;
        this.f10745d = r4;
        this.f10746e = r5;
        this.f = r6;
    }

    public final Integer a() {
        return this.f10742a;
    }

    public final Integer b() {
        return this.f10743b;
    }

    public final String c() {
        return this.f10744c;
    }

    public final String d() {
        return this.f10745d;
    }

    public final String e() {
        return this.f10746e;
    }

    public final String f() {
        return this.f;
    }
}
