package com.obric.aiagent.applog;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: AppLogConfigInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f16120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f16121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f16122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f16123d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f16124e;
    private final String f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private final boolean m;
    private final int n;
    private final long o;
    private final long p;
    private final boolean q;
    private final boolean r;
    private final boolean s;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
        return false;
    L8:
        a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin");
        if (this.f16120a == r10.f16120a) goto L12;
        return false;
    L12:
        if (o.a(this.f16121b, r10.f16121b) == true) goto L15;
        return false;
    L15:
        if (this.f16122c == r10.f16122c) goto L18;
        return false;
    L18:
        if (o.a(this.f16123d, r10.f16123d) == true) goto L21;
        return false;
    L21:
        if (this.f16124e == r10.f16124e) goto L24;
        return false;
    L24:
        if (o.a(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L30;
        return false;
    L30:
        if (this.h == r10.h) goto L33;
        return false;
    L33:
        if (this.i == r10.i) goto L36;
        return false;
    L36:
        if (this.j == r10.j) goto L39;
        return false;
    L39:
        if (this.k == r10.k) goto L42;
        return false;
    L42:
        if (this.l == r10.l) goto L45;
        return false;
    L45:
        if (this.m == r10.m) goto L48;
        return false;
    L48:
        if (this.n == r10.n) goto L51;
        return false;
    L51:
        if (this.o == r10.o) goto L54;
        return false;
    L54:
        if (this.p == r10.p) goto L57;
        return false;
    L57:
        if (this.q == r10.q) goto L60;
        return false;
    L60:
        if (this.r == r10.r) goto L63;
        return false;
    L63:
        if (this.s == r10.s) goto L65;
        return false;
    L65:
        return true;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((Integer.hashCode(this.f16120a) * 31) + this.f16121b.hashCode()) * 31) + Integer.hashCode(this.f16122c)) * 31) + this.f16123d.hashCode()) * 31) + Integer.hashCode(this.f16124e)) * 31) + this.f.hashCode()) * 31) + Boolean.hashCode(this.g)) * 31) + Boolean.hashCode(this.h)) * 31) + Boolean.hashCode(this.i)) * 31) + Boolean.hashCode(this.j)) * 31) + Boolean.hashCode(this.k)) * 31) + Boolean.hashCode(this.l)) * 31) + Boolean.hashCode(this.m)) * 31) + Integer.hashCode(this.n)) * 31) + Long.hashCode(this.o)) * 31) + Long.hashCode(this.p)) * 31) + Boolean.hashCode(this.q)) * 31) + Boolean.hashCode(this.r)) * 31) + Boolean.hashCode(this.s);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("AppLogConfigInfo(appId=").append(this.f16120a).append(", appName=").append(this.f16121b).append(", versionCode=").append(this.f16122c).append(", versionName=").append(this.f16123d).append(", updateVersionCode=").append(this.f16124e).append(", channel=").append(this.f).append(", isBoe=").append(this.g).append(", isDebug=").append(this.h).append(", filterEnable=").append(this.i).append(", samplingEnable=").append(this.j).append(", newMonitorEnabled=").append(this.k).append(", newMonitorInDebugMode=");
        r0.append(this.l).append(", defaultSentryEnabled=").append(this.m).append(", defaultSentryColdStartSamplingRate=").append(this.n).append(", defaultColdStartReportDelay=").append(this.o).append(", defaultReportInterval=").append(this.p).append(", packByLengthEnabled=").append(this.q).append(", realtimeEventOptEnabled=").append(this.r).append(", packMultiQueryEnabled=").append(this.s).append(')');
        return r0.toString();
    }

    public a(int r6, String r7, int r8, String r9, int r10, String r11, boolean r12, boolean r13, boolean r14, boolean r15, boolean r16, boolean r17, boolean r18, int r19, long r20, long r22, boolean r24, boolean r25, boolean r26) {
        o.e(r7, "appName");
        o.e(r9, "versionName");
        o.e(r11, "channel");
        this.f16120a = r6;
        this.f16121b = r7;
        this.f16122c = r8;
        this.f16123d = r9;
        this.f16124e = r10;
        this.f = r11;
        this.g = r12;
        this.h = r13;
        this.i = r14;
        this.j = r15;
        this.k = r16;
        this.l = r17;
        this.m = r18;
        this.n = r19;
        this.o = r20;
        this.p = r22;
        this.q = r24;
        this.r = r25;
        this.s = r26;
    }

    public /* synthetic */ a(int r26, String r27, int r28, String r29, int r30, String r31, boolean r32, boolean r33, boolean r34, boolean r35, boolean r36, boolean r37, boolean r38, int r39, long r40, long r42, boolean r44, boolean r45, boolean r46, int r47, h r48) {
        if ((r47 & 128) == 0) goto L5;
        boolean r11 = false;
    L7:
        if ((r47 & 256) == 0) goto L9;
        boolean r12 = false;
    L11:
        if ((r47 & 512) == 0) goto L13;
        boolean r13 = true;
    L15:
        if ((r47 & 1024) == 0) goto L17;
        boolean r14 = false;
    L19:
        if ((r47 & 2048) == 0) goto L21;
        boolean r15 = false;
    L23:
        if ((r47 & 4096) == 0) goto L25;
        boolean r16 = false;
    L27:
        if ((r47 & 8192) == 0) goto L29;
        int r17 = 100;
    L31:
        if ((r47 & 16384) == 0) goto L33;
        long r18 = 5000;
    L35:
        if ((32768 & r47) == 0) goto L37;
        long r20 = 60000;
    L39:
        if ((65536 & r47) == 0) goto L41;
        boolean r22 = false;
    L43:
        if ((131072 & r47) == 0) goto L45;
        boolean r23 = false;
    L47:
        if ((r47 & 262144) == 0) goto L49;
        boolean r24 = false;
    L50:
        this(r26, r27, r28, r29, r30, r31, r32, r11, r12, r13, r14, r15, r16, r17, r18, r20, r22, r23, r24);
        return;
    L49:
        r24 = r46;
        goto L50
    L45:
        r23 = r45;
        goto L47
    L41:
        r22 = r44;
        goto L43
    L37:
        r20 = r42;
        goto L39
    L33:
        r18 = r40;
        goto L35
    L29:
        r17 = r39;
        goto L31
    L25:
        r16 = r38;
        goto L27
    L21:
        r15 = r37;
        goto L23
    L17:
        r14 = r36;
        goto L19
    L13:
        r13 = r35;
        goto L15
    L9:
        r12 = r34;
        goto L11
    L5:
        r11 = r33;
        goto L7
    }

    public final int a() {
        return this.f16120a;
    }

    public final String b() {
        return this.f16121b;
    }

    public final int c() {
        return this.f16122c;
    }

    public final String d() {
        return this.f16123d;
    }

    public final int e() {
        return this.f16124e;
    }

    public final String f() {
        return this.f;
    }

    public final boolean g() {
        return this.g;
    }

    public final boolean h() {
        return this.h;
    }

    public final boolean i() {
        return this.i;
    }

    public final boolean j() {
        return this.j;
    }

    public final boolean k() {
        return this.k;
    }

    public final boolean l() {
        return this.l;
    }

    public final boolean m() {
        return this.m;
    }

    public final int n() {
        return this.n;
    }

    public final long o() {
        return this.o;
    }

    public final long p() {
        return this.p;
    }

    public final boolean q() {
        return this.q;
    }

    public final boolean r() {
        return this.r;
    }

    public final boolean s() {
        return this.s;
    }
}
