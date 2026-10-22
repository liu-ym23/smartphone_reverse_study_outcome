package com.obric.autogui.database.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: Task.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f29041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f29042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Integer f29043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f29044d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f29045e;
    private long f;
    private String g;
    private String h;
    private int i;
    private long j;
    private String k;
    private String l;
    private String m;
    private int n;
    private int o;
    private String p;
    private final boolean q;
    private String r;
    private String s;
    private String t;
    private String u;
    private int v;
    private Map<String, String> w;
    private String x;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
        return false;
    L8:
        a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin");
        if (this.f29041a == r10.f29041a) goto L12;
        return false;
    L12:
        if (o.a(this.f29042b, r10.f29042b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f29043c, r10.f29043c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f29044d, r10.f29044d) == true) goto L21;
        return false;
    L21:
        if (this.f29045e == r10.f29045e) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (o.a(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (o.a(this.h, r10.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r10.i) goto L36;
        return false;
    L36:
        if (this.j == r10.j) goto L39;
        return false;
    L39:
        if (o.a(this.k, r10.k) == true) goto L42;
        return false;
    L42:
        if (o.a(this.l, r10.l) == true) goto L45;
        return false;
    L45:
        if (o.a(this.m, r10.m) == true) goto L48;
        return false;
    L48:
        if (this.n == r10.n) goto L51;
        return false;
    L51:
        if (this.o == r10.o) goto L54;
        return false;
    L54:
        if (o.a(this.p, r10.p) == true) goto L57;
        return false;
    L57:
        if (this.q == r10.q) goto L59;
        return false;
    L59:
        return true;
    }

    public int hashCode() {
        int r0 = Long.hashCode(this.f29041a) * 31;
        Integer r1 = this.f29042b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Integer r5 = this.f29043c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.f29044d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (((((((((((((((r7 + r9) * 31) + Long.hashCode(this.f29045e)) * 31) + Long.hashCode(this.f)) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + Integer.hashCode(this.i)) * 31) + Long.hashCode(this.j)) * 31) + this.k.hashCode()) * 31;
        String r11 = this.l;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (((((((r10 + r12) * 31) + this.m.hashCode()) * 31) + Integer.hashCode(this.n)) * 31) + Integer.hashCode(this.o)) * 31;
        String r14 = this.p;
        if (r14 == null) goto L23;
        r2 = r14.hashCode();
    L23:
        return ((r13 + r2) * 31) + Boolean.hashCode(this.q);
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
        r0.append("Task(id=").append(this.f29041a).append(", timerTaskTriggerId=").append(this.f29042b).append(", timerTaskId=").append(this.f29043c).append(", eventTaskId=").append(this.f29044d).append(", gmtCreated=").append(this.f29045e).append(", gmtModified=").append(this.f).append(", description=").append(this.g).append(", key=").append(this.h).append(", type=").append(this.i).append(", intervalMillis=").append(this.j).append(", shareDetails=").append(this.k).append(", summary=");
        r0.append(this.l).append(", platformKey=").append(this.m).append(", endType=").append(this.n).append(", termType=").append(this.o).append(", journalPath=").append(this.p).append(", migrated=").append(this.q).append(')');
        return r0.toString();
    }

    public a(long r8, Integer r10, Integer r11, String r12, long r13, long r15, String r17, String r18, int r19, long r20, String r22, String r23, String r24, int r25, int r26, String r27, boolean r28) {
        o.e(r17, "description");
        o.e(r18, "key");
        o.e(r22, "shareDetails");
        o.e(r24, "platformKey");
        this.f29041a = r8;
        this.f29042b = r10;
        this.f29043c = r11;
        this.f29044d = r12;
        this.f29045e = r13;
        this.f = r15;
        this.g = r17;
        this.h = r18;
        this.i = r19;
        this.j = r20;
        this.k = r22;
        this.l = r23;
        this.m = r24;
        this.n = r25;
        this.o = r26;
        this.p = r27;
        this.q = r28;
    }

    public final long a() {
        return this.f29041a;
    }

    public final Integer b() {
        return this.f29043c;
    }

    public final String c() {
        return this.f29044d;
    }

    public /* synthetic */ a(long r27, Integer r29, Integer r30, String r31, long r32, long r34, String r36, String r37, int r38, long r39, String r41, String r42, String r43, int r44, int r45, String r46, boolean r47, int r48, h r49) {
        if ((r48 & 1) == 0) goto L5;
        long r5 = 0;
    L7:
        if ((r48 & 2) == 0) goto L9;
        Integer r7 = null;
    L11:
        if ((r48 & 4) == 0) goto L13;
        Integer r8 = null;
    L15:
        if ((r48 & 8) == 0) goto L17;
        String r9 = null;
    L19:
        if ((r48 & 16) == 0) goto L21;
        long r10 = System.currentTimeMillis();
    L23:
        if ((r48 & 32) == 0) goto L25;
        long r12 = System.currentTimeMillis();
    L27:
        if ((r48 & 256) == 0) goto L29;
        int r16 = 0;
    L31:
        if ((r48 & 512) == 0) goto L33;
        long r17 = 0;
    L35:
        if ((r48 & 1024) == 0) goto L37;
        String r19 = "";
    L39:
        if ((r48 & 2048) == 0) goto L41;
        String r20 = null;
    L43:
        if ((r48 & 4096) == 0) goto L45;
        String r21 = "";
    L47:
        if ((r48 & 8192) == 0) goto L49;
        int r22 = 0;
    L51:
        if ((r48 & 16384) == 0) goto L53;
        int r23 = 0;
    L55:
        if ((32768 & r48) == 0) goto L57;
        String r24 = null;
    L59:
        if ((r48 & 65536) == 0) goto L61;
        boolean r25 = false;
    L62:
        this(r5, r7, r8, r9, r10, r12, r36, r37, r16, r17, r19, r20, r21, r22, r23, r24, r25);
        return;
    L61:
        r25 = r47;
        goto L62
    L57:
        r24 = r46;
        goto L59
    L53:
        r23 = r45;
        goto L55
    L49:
        r22 = r44;
        goto L51
    L45:
        r21 = r43;
        goto L47
    L41:
        r20 = r42;
        goto L43
    L37:
        r19 = r41;
        goto L39
    L33:
        r17 = r39;
        goto L35
    L29:
        r16 = r38;
        goto L31
    L25:
        r12 = r34;
        goto L27
    L21:
        r10 = r32;
        goto L23
    L17:
        r9 = r31;
        goto L19
    L13:
        r8 = r30;
        goto L15
    L9:
        r7 = r29;
        goto L11
    L5:
        r5 = r27;
        goto L7
    }

    public final long d() {
        return this.f29045e;
    }

    public final void a(long r1) {
        this.f = r1;
    }

    public final String e() {
        return this.g;
    }

    public final String f() {
        return this.h;
    }

    public final void a(int r1) {
        this.i = r1;
    }

    public final int getType() {
        return this.i;
    }

    public final void b(long r1) {
        this.j = r1;
    }

    public final long g() {
        return this.j;
    }

    public final void a(String r2) {
        o.e(r2, "<set-?>");
        this.k = r2;
    }

    public final void b(String r1) {
        this.l = r1;
    }

    public final String h() {
        return this.l;
    }

    public final String i() {
        return this.m;
    }

    public final void b(int r1) {
        this.n = r1;
    }

    public final int j() {
        return this.n;
    }

    public final int k() {
        return this.o;
    }

    public final String l() {
        return this.p;
    }

    public final void c(String r1) {
        this.r = r1;
    }

    public final String m() {
        return this.r;
    }

    public final void d(String r1) {
        this.s = r1;
    }

    public final String n() {
        return this.s;
    }

    public final void e(String r1) {
        this.t = r1;
    }

    public final String o() {
        return this.t;
    }

    public final void f(String r1) {
        this.u = r1;
    }

    public final String p() {
        return this.u;
    }

    public final void c(int r1) {
        this.v = r1;
    }

    public final int q() {
        return this.v;
    }

    public final void a(Map<String, String> r3) {
        this.w = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
    }

    public final Map<String, String> r() {
        return this.w;
    }

    public final void g(String r1) {
        this.x = r1;
    }

    public final String s() {
        return this.x;
    }
}
