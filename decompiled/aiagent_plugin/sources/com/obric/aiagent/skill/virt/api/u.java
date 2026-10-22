package com.obric.aiagent.skill.virt.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: ShellApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f21611a = null;
    private static final d.o.k m = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f21612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final x f21613c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f21614d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<String, String> f21615e;
    private final long f;
    private final Long g;
    private final Long h;
    private final long i;
    private final String j;
    private final q k;
    private final String l;

    /* JADX INFO: compiled from: ShellApi.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, u.class) == true) goto L8;
        return false;
    L8:
        u r10 = (u) ZeusTransformUtils.preCheckCast(r9, u.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f21612b, r10.f21612b) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f21613c, r10.f21613c) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f21614d, r10.f21614d) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f21615e, r10.f21615e) == true) goto L21;
        return false;
    L21:
        if (this.f == r10.f) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.g, r10.g) == true) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.h, r10.h) == true) goto L30;
        return false;
    L30:
        if (this.i == r10.i) goto L33;
        return false;
    L33:
        if (d.h.b.o.a(this.j, r10.j) == true) goto L36;
        return false;
    L36:
        if (d.h.b.o.a(this.k, r10.k) == true) goto L39;
        return false;
    L39:
        if (d.h.b.o.a(this.l, r10.l) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((this.f21612b.hashCode() * 31) + this.f21613c.hashCode()) * 31) + this.f21614d.hashCode()) * 31) + this.f21615e.hashCode()) * 31) + Long.hashCode(this.f)) * 31;
        Long r1 = this.g;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Long r5 = this.h;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + Long.hashCode(this.i)) * 31;
        String r8 = this.j;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        q r11 = this.k;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.l;
        if (r14 == null) goto L23;
        r2 = r14.hashCode();
    L23:
        return r13 + r2;
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("VirtAsyncShellSpec(command=").append(this.f21612b).append(", workDir=").append(this.f21613c).append(", executionId=").append(this.f21614d).append(", env=").append(this.f21615e).append(", hardTimeoutMs=").append(this.f).append(", inactivityReturnTimeoutMs=").append(this.g).append(", firstReturnDeadlineElapsedRealtimeMs=").append(this.h).append(", exclusiveWaitTimeoutMs=").append(this.i).append(", groupId=").append(this.j).append(", observation=").append(this.k).append(", outboundSensitiveDataJson=").append(this.l).append(')');
        return r0.toString();
    }

    public u(String r3, x r4, String r5, Map<String, String> r6, long r7, Long r9, Long r10, long r11, String r13, q r14, String r15) {
        x r8 = (x) ZeusTransformUtils.wrapperContextForParams(r4, x.class, "com.obric.aiagent.plugin");
        Map<String, String> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "command");
        d.h.b.o.e(r8, "workDir");
        d.h.b.o.e(r5, "executionId");
        d.h.b.o.e(r12, "env");
        this.f21612b = r3;
        this.f21613c = r8;
        this.f21614d = r5;
        this.f21615e = r12;
        this.f = r7;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r13;
        this.k = r14;
        this.l = r15;
        boolean r16 = true;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L32;
        if (r5.length() > 64) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L30;
        if (m.a((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L28;
        if (r11 < 0) goto L14;
        boolean r17 = true;
    L15:
        if (r17 == false) goto L26;
        if (r10 != null) goto L18;
    L21:
        if (r16 == false) goto L24;
        return;
    L24:
        throw new IllegalArgumentException("VirtAsyncShellSpec.firstReturnDeadlineElapsedRealtimeMs must be > 0 when provided".toString());
    L18:
        if (r10.longValue() > 0) goto L21;
        r16 = false;
        goto L21
    L26:
        throw new IllegalArgumentException("VirtAsyncShellSpec.exclusiveWaitTimeoutMs must be >= 0".toString());
    L14:
        r17 = false;
        goto L15
    L28:
        throw new IllegalArgumentException("VirtAsyncShellSpec.executionId must match [A-Za-z0-9_.-]".toString());
    L30:
        throw new IllegalArgumentException("VirtAsyncShellSpec.executionId must be <= 64 chars".toString());
    L7:
        r2 = false;
        goto L8
    L32:
        throw new IllegalArgumentException("VirtAsyncShellSpec.executionId must not be blank".toString());
    }

    public final String a() {
        return this.f21612b;
    }

    public final x b() {
        return this.f21613c;
    }

    public final String c() {
        return this.f21614d;
    }

    public final Map<String, String> d() {
        return this.f21615e;
    }

    public final long e() {
        return this.f;
    }

    public final Long f() {
        return this.g;
    }

    public final Long g() {
        return this.h;
    }

    public final long h() {
        return this.i;
    }

    public final String i() {
        return this.j;
    }

    public final q j() {
        return this.k;
    }

    public final String k() {
        return this.l;
    }

    static {
        f21611a = new a(null);
        m = new d.o.k("[A-Za-z0-9_.-]+");
    }
}
