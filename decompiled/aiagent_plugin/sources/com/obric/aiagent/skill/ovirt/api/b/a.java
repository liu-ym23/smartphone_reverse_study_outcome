package com.obric.aiagent.skill.ovirt.api.b;

import com.obric.aiagent.skill.virt.api.x;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.h;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: OVirtShellRequest.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f20970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final x f20971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, String> f20972c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f20973d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Long f20974e;
    private final Long f;
    private final long g;
    private final String h;

    public static /* synthetic */ a a(a r11, String r12, x r13, Map r14, long r15, Long r17, Long r18, long r19, String r21, int r22, Object r23) {
        x r2 = (x) ZeusTransformUtils.wrapperContextForParams(r13, x.class, "com.obric.aiagent.plugin");
        Map<String, String> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.aiagent.plugin");
        if ((r22 & 1) == 0) goto L5;
        String r4 = r11.f20970a;
    L7:
        if ((r22 & 2) == 0) goto L10;
        r2 = r11.f20971b;
    L10:
        if ((r22 & 4) == 0) goto L13;
        r3 = r11.f20972c;
    L13:
        if ((r22 & 8) == 0) goto L15;
        long r5 = r11.f20973d;
    L17:
        if ((r22 & 16) == 0) goto L19;
        Long r7 = r11.f20974e;
    L21:
        if ((r22 & 32) == 0) goto L23;
        Long r8 = r11.f;
    L25:
        if ((r22 & 64) == 0) goto L27;
        long r9 = r11.g;
    L29:
        if ((r22 & 128) == 0) goto L31;
        String r1 = r11.h;
    L33:
        return r11.a(r4, r2, r3, r5, r7, r8, r9, r1);
    L31:
        r1 = r21;
        goto L33
    L27:
        r9 = r19;
        goto L29
    L23:
        r8 = r18;
        goto L25
    L19:
        r7 = r17;
        goto L21
    L15:
        r5 = r15;
        goto L17
    L5:
        r4 = r12;
        goto L7
    }

    public final a a(String r14, x r15, Map<String, String> r16, long r17, Long r19, Long r20, long r21, String r23) {
        x r4 = (x) ZeusTransformUtils.wrapperContextForParams(r15, x.class, "com.obric.aiagent.plugin");
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r16, Map.class, "com.obric.aiagent.plugin");
        o.e(r14, "command");
        o.e(r5, "env");
        return new a(r14, r4, r5, r17, r19, r20, r21, r23);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
        return false;
    L8:
        a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin");
        if (o.a(this.f20970a, r10.f20970a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f20971b, r10.f20971b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f20972c, r10.f20972c) == true) goto L18;
        return false;
    L18:
        if (this.f20973d == r10.f20973d) goto L21;
        return false;
    L21:
        if (o.a(this.f20974e, r10.f20974e) == true) goto L24;
        return false;
    L24:
        if (o.a(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L30;
        return false;
    L30:
        if (o.a(this.h, r10.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r0 = this.f20970a.hashCode() * 31;
        x r1 = this.f20971b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((r0 + r3) * 31) + this.f20972c.hashCode()) * 31) + Long.hashCode(this.f20973d)) * 31;
        Long r5 = this.f20974e;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Long r8 = this.f;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (((r7 + r9) * 31) + Long.hashCode(this.g)) * 31;
        String r11 = this.h;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return r10 + r2;
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
        return "OVirtShellRequest(command=" + this.f20970a + ", workDir=" + this.f20971b + ", env=" + this.f20972c + ", hardTimeoutMs=" + this.f20973d + ", inactivityReturnTimeoutMs=" + this.f20974e + ", firstReturnDeadlineElapsedRealtimeMs=" + this.f + ", exclusiveWaitTimeoutMs=" + this.g + ", outboundSensitiveDataJson=" + this.h + ')';
    }

    public a(String r3, x r4, Map<String, String> r5, long r6, Long r8, Long r9, long r10, String r12) {
        x r7 = (x) ZeusTransformUtils.wrapperContextForParams(r4, x.class, "com.obric.aiagent.plugin");
        Map<String, String> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        o.e(r3, "command");
        o.e(r11, "env");
        this.f20970a = r3;
        this.f20971b = r7;
        this.f20972c = r11;
        this.f20973d = r6;
        this.f20974e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r12;
    }

    public final String a() {
        return this.f20970a;
    }

    public final x b() {
        return this.f20971b;
    }

    public /* synthetic */ a(String r17, x r18, Map r19, long r20, Long r22, Long r23, long r24, String r26, int r27, h r28) {
        x r1 = (x) ZeusTransformUtils.wrapperContextForParams(r18, x.class, "com.obric.aiagent.plugin");
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r19, Map.class, "com.obric.aiagent.plugin");
        if ((r27 & 2) == 0) goto L5;
        x r7 = null;
    L7:
        if ((r27 & 4) == 0) goto L9;
        r2 = ao.b();
    L9:
        Map r8 = r2;
        if ((r27 & 16) == 0) goto L12;
        Long r11 = null;
    L14:
        if ((r27 & 32) == 0) goto L16;
        Long r12 = null;
    L18:
        if ((r27 & 64) == 0) goto L20;
        long r13 = 0;
    L22:
        if ((r27 & 128) == 0) goto L24;
        String r15 = null;
    L25:
        this(r17, r7, r8, r20, r11, r12, r13, r15);
        return;
    L24:
        r15 = r26;
        goto L25
    L20:
        r13 = r24;
        goto L22
    L16:
        r12 = r23;
        goto L18
    L12:
        r11 = r22;
        goto L14
    L5:
        r7 = r1;
        goto L7
    }

    public final Map<String, String> c() {
        return this.f20972c;
    }

    public final long d() {
        return this.f20973d;
    }

    public final Long e() {
        return this.f20974e;
    }

    public final Long f() {
        return this.f;
    }

    public final long g() {
        return this.g;
    }

    public final String h() {
        return this.h;
    }
}
