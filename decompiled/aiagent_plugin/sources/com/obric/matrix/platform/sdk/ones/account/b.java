package com.obric.matrix.platform.sdk.ones.account;

import com.obric.capabilitykit.common.UiType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: AccountInfo.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f33609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f33610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f33611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f33612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f33613e;
    private String f;
    private String g;
    private String h;
    private int i;
    private String j;
    private String k;
    private String l;
    private String m;
    private boolean n;
    private int o;
    private boolean p;
    private String q;
    private long r;
    private String s;

    public b() {
        this(false, 0, null, null, 0, null, null, null, 0, null, null, null, null, false, 0, false, null, 0, null, 524287, null);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
        return false;
    L8:
        b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.aiagent.plugin");
        if (this.f33609a == r10.f33609a) goto L12;
        return false;
    L12:
        if (this.f33610b == r10.f33610b) goto L15;
        return false;
    L15:
        if (o.a(this.f33611c, r10.f33611c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f33612d, r10.f33612d) == true) goto L21;
        return false;
    L21:
        if (this.f33613e == r10.f33613e) goto L24;
        return false;
    L24:
        if (o.a(this.f, r10.f) == true) goto L27;
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
        if (o.a(this.j, r10.j) == true) goto L39;
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
        if (this.p == r10.p) goto L57;
        return false;
    L57:
        if (o.a(this.q, r10.q) == true) goto L60;
        return false;
    L60:
        if (this.r == r10.r) goto L63;
        return false;
    L63:
        if (o.a(this.s, r10.s) == true) goto L65;
        return false;
    L65:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v27, types: [int] */
    /* JADX WARN: Type inference failed for: r0v31, types: [int] */
    /* JADX WARN: Type inference failed for: r0v38 */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v25, types: [int] */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v30 */
    public int hashCode() {
        boolean r0 = this.f33609a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = ((((((((((((((((((((((((r2 * 31) + Integer.hashCode(this.f33610b)) * 31) + this.f33611c.hashCode()) * 31) + this.f33612d.hashCode()) * 31) + Integer.hashCode(this.f33613e)) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + Integer.hashCode(this.i)) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31;
        boolean r4 = this.n;
        ?? r5 = r4;
        if (r4 == false) goto L8;
        r5 = 1;
    L8:
        int r6 = (((r3 + r5) * 31) + Integer.hashCode(this.o)) * 31;
        boolean r7 = this.p;
        if (r7 == true) goto L13;
        r1 = r7;
    L13:
        return ((((((r6 + r1) * 31) + this.q.hashCode()) * 31) + Long.hashCode(this.r)) * 31) + this.s.hashCode();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("AccountInfo(loginState=").append(this.f33609a).append(", logoutScene=").append(this.f33610b).append(", secUserId=").append(this.f33611c).append(", userId=").append(this.f33612d).append(", odinUserType=").append(this.f33613e).append(", xTTToken=").append(this.f).append(", innerSSOToken=").append(this.g).append(", avatarUrl=").append(this.h).append(", countryCode=").append(this.i).append(", userName=").append(this.j).append(", screenName=").append(this.k).append(", userEmail=");
        r0.append(this.l).append(", userMobile=").append(this.m).append(", hasPassword=").append(this.n).append(", userGender=").append(this.o).append(", isNewUser=").append(this.p).append(", userSession=").append(this.q).append(", loginUtcTime=").append(this.r).append(", loginPhoneNumber=").append(this.s).append(')');
        return r0.toString();
    }

    public b(boolean r14, int r15, String r16, String r17, int r18, String r19, String r20, String r21, int r22, String r23, String r24, String r25, String r26, boolean r27, int r28, boolean r29, String r30, long r31, String r33) {
        o.e(r16, "secUserId");
        o.e(r17, "userId");
        o.e(r19, "xTTToken");
        o.e(r20, "innerSSOToken");
        o.e(r21, "avatarUrl");
        o.e(r23, "userName");
        o.e(r24, "screenName");
        o.e(r25, "userEmail");
        o.e(r26, "userMobile");
        o.e(r30, "userSession");
        o.e(r33, "loginPhoneNumber");
        this.f33609a = r14;
        this.f33610b = r15;
        this.f33611c = r16;
        this.f33612d = r17;
        this.f33613e = r18;
        this.f = r19;
        this.g = r20;
        this.h = r21;
        this.i = r22;
        this.j = r23;
        this.k = r24;
        this.l = r25;
        this.m = r26;
        this.n = r27;
        this.o = r28;
        this.p = r29;
        this.q = r30;
        this.r = r31;
        this.s = r33;
    }

    public /* synthetic */ b(boolean r22, int r23, String r24, String r25, int r26, String r27, String r28, String r29, int r30, String r31, String r32, String r33, String r34, boolean r35, int r36, boolean r37, String r38, long r39, String r41, int r42, h r43) {
        if ((r42 & 1) == 0) goto L5;
        boolean r1 = false;
    L7:
        if ((r42 & 2) == 0) goto L9;
        int r3 = 0;
    L11:
        if ((r42 & 4) == 0) goto L13;
        String r4 = "";
    L15:
        if ((r42 & 8) == 0) goto L17;
        String r6 = "";
    L19:
        if ((r42 & 16) == 0) goto L21;
        int r7 = 0;
    L23:
        if ((r42 & 32) == 0) goto L25;
        String r8 = "";
    L27:
        if ((r42 & 64) == 0) goto L29;
        String r9 = "";
    L31:
        if ((r42 & 128) == 0) goto L33;
        String r10 = "";
    L35:
        if ((r42 & 256) == 0) goto L37;
        int r11 = 86;
    L39:
        if ((r42 & 512) == 0) goto L41;
        String r12 = "";
    L43:
        if ((r42 & 1024) == 0) goto L45;
        String r13 = "";
    L47:
        if ((r42 & 2048) == 0) goto L49;
        String r14 = "";
    L51:
        if ((r42 & 4096) == 0) goto L53;
        String r15 = "";
    L55:
        if ((r42 & 8192) == 0) goto L57;
        boolean r2 = false;
    L59:
        if ((r42 & 16384) == 0) goto L61;
        int r5 = 0;
    L63:
        if ((r42 & 32768) == 0) goto L65;
        boolean r16 = false;
    L67:
        if ((r42 & 65536) == 0) goto L69;
        String r17 = "";
    L71:
        if ((r42 & UiType.FLAG_PHONE_CARD) == 0) goto L73;
        long r18 = 0;
    L75:
        if ((r42 & 262144) == 0) goto L77;
        String r0 = "";
    L78:
        this(r1, r3, r4, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r5, r16, r17, r18, r0);
        return;
    L77:
        r0 = r41;
        goto L78
    L73:
        r18 = r39;
        goto L75
    L69:
        r17 = r38;
        goto L71
    L65:
        r16 = r37;
        goto L67
    L61:
        r5 = r36;
        goto L63
    L57:
        r2 = r35;
        goto L59
    L53:
        r15 = r34;
        goto L55
    L49:
        r14 = r33;
        goto L51
    L45:
        r13 = r32;
        goto L47
    L41:
        r12 = r31;
        goto L43
    L37:
        r11 = r30;
        goto L39
    L33:
        r10 = r29;
        goto L35
    L29:
        r9 = r28;
        goto L31
    L25:
        r8 = r27;
        goto L27
    L21:
        r7 = r26;
        goto L23
    L17:
        r6 = r25;
        goto L19
    L13:
        r4 = r24;
        goto L15
    L9:
        r3 = r23;
        goto L11
    L5:
        r1 = r22;
        goto L7
    }

    public final void a(boolean r1) {
        this.f33609a = r1;
    }

    public final boolean a() {
        return this.f33609a;
    }

    public final void a(int r1) {
        this.f33610b = r1;
    }

    public final void a(String r2) {
        o.e(r2, "<set-?>");
        this.f33611c = r2;
    }

    public final String b() {
        return this.f33612d;
    }

    public final void b(String r2) {
        o.e(r2, "<set-?>");
        this.f33612d = r2;
    }

    public final void b(int r1) {
        this.f33613e = r1;
    }

    public final void c(String r2) {
        o.e(r2, "<set-?>");
        this.f = r2;
    }

    public final void d(String r2) {
        o.e(r2, "<set-?>");
        this.g = r2;
    }

    public final void e(String r2) {
        o.e(r2, "<set-?>");
        this.h = r2;
    }

    public final void c(int r1) {
        this.i = r1;
    }

    public final void f(String r2) {
        o.e(r2, "<set-?>");
        this.j = r2;
    }

    public final void g(String r2) {
        o.e(r2, "<set-?>");
        this.k = r2;
    }

    public final void h(String r2) {
        o.e(r2, "<set-?>");
        this.l = r2;
    }

    public final void i(String r2) {
        o.e(r2, "<set-?>");
        this.m = r2;
    }

    public final void b(boolean r1) {
        this.n = r1;
    }

    public final void d(int r1) {
        this.o = r1;
    }

    public final void c(boolean r1) {
        this.p = r1;
    }

    public final void j(String r2) {
        o.e(r2, "<set-?>");
        this.q = r2;
    }

    public final void a(long r1) {
        this.r = r1;
    }

    public final void k(String r2) {
        o.e(r2, "<set-?>");
        this.s = r2;
    }
}
