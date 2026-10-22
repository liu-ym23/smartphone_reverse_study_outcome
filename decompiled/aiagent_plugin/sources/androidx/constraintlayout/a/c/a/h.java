package androidx.constraintlayout.a.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: Direct.java */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b.a f719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f721c;

    static {
        f719a = new b.a();
        f720b = 0;
        f721c = 0;
    }

    public static void a(androidx.constraintlayout.a.c.f r14, b.InterfaceC0012b r15) {
        b.InterfaceC0012b r16 = (b.InterfaceC0012b) ZeusTransformUtils.wrapperContextForParams(r15, b.InterfaceC0012b.class, "com.obric.aiagent.plugin");
        androidx.constraintlayout.a.c.e.a r0 = r14.aa();
        androidx.constraintlayout.a.c.e.a r2 = r14.ab();
        f720b = 0;
        f721c = 0;
        r14.n();
        ArrayList<androidx.constraintlayout.a.c.e> r4 = r14.ak();
        int r5 = r4.size();
        int r6 = 0;
    L3:
        if (r6 >= r5) goto L5;
        ((androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r4.get(r6), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin")).n();
        r6 = r6 + 1;
        goto L3
    L5:
        boolean r7 = r14.ag();
        if (r0 != androidx.constraintlayout.a.c.e.a.f775a) goto L8;
        r14.a(0, r14.F());
    L9:
        int r1 = 0;
        boolean r8 = false;
        boolean r9 = false;
    L11:
        if (r1 >= r5) goto L34;
        androidx.constraintlayout.a.c.e r12 = (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r4.get(r1), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, androidx.constraintlayout.a.c.h.class) == false) goto L29;
        androidx.constraintlayout.a.c.h r13 = (androidx.constraintlayout.a.c.h) ZeusTransformUtils.preCheckCast(r12, androidx.constraintlayout.a.c.h.class, "com.obric.aiagent.plugin");
        if (r13.c() != 1) goto L33;
        if (r13.g() == (-1)) goto L20;
        r13.B(r13.g());
    L27:
        r8 = true;
        goto L33
    L20:
        if (r13.h() == (-1)) goto L25;
        if (r14.d() == false) goto L25;
        r13.B(r14.F() - r13.h());
    L25:
        if (r14.d() == false) goto L27;
        r13.B((int) ((r13.f() * r14.F()) + 0.5f));
    L33:
        r1 = r1 + 1;
        goto L11
    L29:
        if (ZeusTransformUtils.instanceOf(r12, androidx.constraintlayout.a.c.a.class) == false) goto L33;
        if (((androidx.constraintlayout.a.c.a) ZeusTransformUtils.preCheckCast(r12, androidx.constraintlayout.a.c.a.class, "com.obric.aiagent.plugin")).h() != 0) goto L33;
        r9 = true;
        goto L33
    L34:
        if (r8 == false) goto L43;
        int r3 = 0;
    L36:
        if (r3 >= r5) goto L43;
        androidx.constraintlayout.a.c.e r10 = (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r4.get(r3), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, androidx.constraintlayout.a.c.h.class) == false) goto L42;
        androidx.constraintlayout.a.c.h r11 = (androidx.constraintlayout.a.c.h) ZeusTransformUtils.preCheckCast(r10, androidx.constraintlayout.a.c.h.class, "com.obric.aiagent.plugin");
        if (r11.c() != 1) goto L42;
        a(0, r11, r16, r7);
    L42:
        r3 = r3 + 1;
    L43:
        a(0, r14, r16, r7);
        if (r9 == false) goto L54;
        int r17 = 0;
    L46:
        if (r17 >= r5) goto L54;
        androidx.constraintlayout.a.c.e r18 = (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r4.get(r17), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r18, androidx.constraintlayout.a.c.a.class) == false) goto L52;
        androidx.constraintlayout.a.c.a r19 = (androidx.constraintlayout.a.c.a) ZeusTransformUtils.preCheckCast(r18, androidx.constraintlayout.a.c.a.class, "com.obric.aiagent.plugin");
        if (r19.h() != 0) goto L52;
        a(0, r19, r16, 0, r7);
    L52:
        r17 = r17 + 1;
    L54:
        if (r2 != androidx.constraintlayout.a.c.e.a.f775a) goto L56;
        r14.b(0, r14.G());
    L57:
        int r20 = 0;
        boolean r21 = false;
        boolean r22 = false;
    L58:
        if (r20 >= r5) goto L81;
        androidx.constraintlayout.a.c.e r23 = (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r4.get(r20), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r23, androidx.constraintlayout.a.c.h.class) == false) goto L76;
        androidx.constraintlayout.a.c.h r24 = (androidx.constraintlayout.a.c.h) ZeusTransformUtils.preCheckCast(r23, androidx.constraintlayout.a.c.h.class, "com.obric.aiagent.plugin");
        if (r24.c() != 0) goto L80;
        if (r24.g() == (-1)) goto L67;
        r24.B(r24.g());
    L74:
        r21 = true;
        goto L80
    L67:
        if (r24.h() == (-1)) goto L72;
        if (r14.e() == false) goto L72;
        r24.B(r14.G() - r24.h());
    L72:
        if (r14.e() == false) goto L74;
        r24.B((int) ((r24.f() * r14.G()) + 0.5f));
    L80:
        r20 = r20 + 1;
        goto L58
    L76:
        if (ZeusTransformUtils.instanceOf(r23, androidx.constraintlayout.a.c.a.class) == false) goto L80;
        if (((androidx.constraintlayout.a.c.a) ZeusTransformUtils.preCheckCast(r23, androidx.constraintlayout.a.c.a.class, "com.obric.aiagent.plugin")).h() != 1) goto L80;
        r22 = true;
        goto L80
    L81:
        if (r21 == false) goto L90;
        int r25 = 0;
    L83:
        if (r25 >= r5) goto L90;
        androidx.constraintlayout.a.c.e r26 = (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r4.get(r25), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r26, androidx.constraintlayout.a.c.h.class) == false) goto L89;
        androidx.constraintlayout.a.c.h r27 = (androidx.constraintlayout.a.c.h) ZeusTransformUtils.preCheckCast(r26, androidx.constraintlayout.a.c.h.class, "com.obric.aiagent.plugin");
        if (r27.c() != 0) goto L89;
        a(1, r27, r16);
    L89:
        r25 = r25 + 1;
    L90:
        a(0, r14, r16);
        if (r22 == false) goto L100;
        int r110 = 0;
    L93:
        if (r110 >= r5) goto L100;
        androidx.constraintlayout.a.c.e r28 = (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r4.get(r110), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r28, androidx.constraintlayout.a.c.a.class) == false) goto L99;
        androidx.constraintlayout.a.c.a r29 = (androidx.constraintlayout.a.c.a) ZeusTransformUtils.preCheckCast(r28, androidx.constraintlayout.a.c.a.class, "com.obric.aiagent.plugin");
        if (r29.h() != 1) goto L99;
        a(0, r29, r16, 1, r7);
    L99:
        r110 = r110 + 1;
    L100:
        int r111 = 0;
    L101:
        if (r111 >= r5) goto L114;
        androidx.constraintlayout.a.c.e r30 = (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r4.get(r111), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (r30.t() == false) goto L113;
        if (a(0, r30) == false) goto L113;
        androidx.constraintlayout.a.c.f.a(0, r30, r16, f719a, b.a.f697a);
        if (ZeusTransformUtils.instanceOf(r30, androidx.constraintlayout.a.c.h.class) == true) goto L109;
        a(0, r30, r16, r7);
        a(0, r30, r16);
        goto L113
    L109:
        if (((androidx.constraintlayout.a.c.h) ZeusTransformUtils.preCheckCast(r30, androidx.constraintlayout.a.c.h.class, "com.obric.aiagent.plugin")).c() != 0) goto L111;
        a(0, r30, r16);
        goto L113
    L111:
        a(0, r30, r16, r7);
    L113:
        r111 = r111 + 1;
        goto L101
    L114:
        return;
    L56:
        r14.e(0);
        goto L57
    L8:
        r14.d(0);
        goto L9
    }

    private static void a(int r2, androidx.constraintlayout.a.c.a r3, b.InterfaceC0012b r4, int r5, boolean r6) {
        b.InterfaceC0012b r7 = (b.InterfaceC0012b) ZeusTransformUtils.wrapperContextForParams(r4, b.InterfaceC0012b.class, "com.obric.aiagent.plugin");
        if (r3.i() == false) goto L8;
        if (r5 != 0) goto L6;
        a(r2 + 1, r3, r7, r6);
        return;
    L6:
        a(r2 + 1, r3, r7);
        return;
    }

    private static void a(int r17, androidx.constraintlayout.a.c.e r18, b.InterfaceC0012b r19, boolean r20) {
        b.InterfaceC0012b r2 = (b.InterfaceC0012b) ZeusTransformUtils.wrapperContextForParams(r19, b.InterfaceC0012b.class, "com.obric.aiagent.plugin");
        if (r18.j() == false) goto L5;
        return;
    L5:
        f720b++;
        if (ZeusTransformUtils.instanceOf(r18, androidx.constraintlayout.a.c.f.class) == false) goto L8;
    L12:
        androidx.constraintlayout.a.c.d r4 = r18.a(androidx.constraintlayout.a.c.d.a.f763b);
        androidx.constraintlayout.a.c.d r6 = r18.a(androidx.constraintlayout.a.c.d.a.f765d);
        int r7 = r4.d();
        int r8 = r6.d();
        if (r4.a() == null) goto L79;
        if (r4.f() == false) goto L79;
        Iterator<androidx.constraintlayout.a.c.d> r5 = r4.a().iterator();
    L18:
        if (r5.hasNext() == false) goto L79;
        androidx.constraintlayout.a.c.d r9 = (androidx.constraintlayout.a.c.d) ZeusTransformUtils.preCheckCast(r5.next(), androidx.constraintlayout.a.c.d.class, "com.obric.aiagent.plugin");
        androidx.constraintlayout.a.c.e r13 = r9.f756a;
        int r14 = r17 + 1;
        boolean r15 = a(r14, r13);
        if (r13.t() == false) goto L24;
        if (r15 == false) goto L24;
        androidx.constraintlayout.a.c.f.a(r14, r13, r2, new b.a(), b.a.f697a);
    L24:
        if (r9 != r13.A) goto L30;
        if (r13.C.f758c == null) goto L30;
        if (r13.C.f758c.f() == false) goto L30;
    L35:
        boolean r10 = true;
    L38:
        if (r13.aa() != androidx.constraintlayout.a.c.e.a.f777c) goto L62;
        if (r15 == true) goto L62;
        if (r13.aa() != androidx.constraintlayout.a.c.e.a.f777c) goto L18;
        if (r13.r < 0) goto L18;
        if (r13.q < 0) goto L18;
        if (r13.B() == 8) goto L54;
        if (r13.n != 0) goto L18;
        if (r13.U() != 0.0f) goto L18;
    L54:
        if (r13.ac() == true) goto L18;
        if (r13.p() == true) goto L18;
        if (r10 == false) goto L18;
        if (r13.ac() == true) goto L18;
        a(r14, r18, r2, r13, r20);
    L62:
        if (r13.t() == true) goto L18;
        if (r9 != r13.A) goto L70;
        if (r13.C.f758c != null) goto L70;
        int r11 = r13.A.i() + r7;
        r13.a(r11, r13.F() + r11);
        a(r14, r13, r2, r20);
    L70:
        if (r9 == r13.C) goto L72;
    L74:
        if (r10 == false) goto L18;
        if (r13.ac() == true) goto L18;
        a(r14, r2, r13, r20);
        goto L18
    L72:
        if (r13.A.f758c != null) goto L74;
        int r12 = r7 - r13.C.i();
        r13.a(r12 - r13.F(), r12);
        a(r14, r13, r2, r20);
    L30:
        if (r9 == r13.C) goto L32;
    L36:
        r10 = false;
        goto L38
    L32:
        if (r13.A.f758c == null) goto L36;
        if (r13.A.f758c.f() == false) goto L36;
    L79:
        if (ZeusTransformUtils.instanceOf(r18, androidx.constraintlayout.a.c.h.class) == false) goto L82;
        return;
    L82:
        if (r6.a() != null) goto L84;
    L150:
        r18.l();
        return;
    L84:
        if (r6.f() == false) goto L150;
        Iterator<androidx.constraintlayout.a.c.d> r16 = r6.a().iterator();
    L87:
        if (r16.hasNext() == false) goto L150;
        androidx.constraintlayout.a.c.d r21 = (androidx.constraintlayout.a.c.d) ZeusTransformUtils.preCheckCast(r16.next(), androidx.constraintlayout.a.c.d.class, "com.obric.aiagent.plugin");
        androidx.constraintlayout.a.c.e r22 = r21.f756a;
        int r23 = r17 + 1;
        boolean r110 = a(r23, r22);
        if (r22.t() == false) goto L93;
        if (r110 == false) goto L93;
        androidx.constraintlayout.a.c.f.a(r23, r22, r2, new b.a(), b.a.f697a);
    L93:
        if (r21 != r22.A) goto L99;
        if (r22.C.f758c == null) goto L99;
        if (r22.C.f758c.f() == false) goto L99;
    L104:
        boolean r111 = true;
    L107:
        if (r22.aa() != androidx.constraintlayout.a.c.e.a.f777c) goto L134;
        if (r110 == true) goto L134;
        if (r22.aa() != androidx.constraintlayout.a.c.e.a.f777c) goto L87;
        if (r22.r < 0) goto L87;
        if (r22.q < 0) goto L87;
        if (r22.B() == 8) goto L125;
        if (r22.n != 0) goto L87;
        if (r22.U() != 0.0f) goto L87;
    L125:
        if (r22.ac() == true) goto L87;
        if (r22.p() == true) goto L87;
        if (r111 == false) goto L87;
        if (r22.ac() == true) goto L87;
        a(r23, r18, r2, r22, r20);
    L134:
        if (r22.t() == true) goto L87;
        if (r21 != r22.A) goto L142;
        if (r22.C.f758c != null) goto L142;
        int r24 = r22.A.i() + r8;
        r22.a(r24, r22.F() + r24);
        a(r23, r22, r2, r20);
    L142:
        if (r21 != r22.C) goto L146;
        if (r22.A.f758c != null) goto L146;
        int r25 = r8 - r22.C.i();
        r22.a(r25 - r22.F(), r25);
        a(r23, r22, r2, r20);
    L146:
        if (r111 == false) goto L87;
        if (r22.ac() == true) goto L87;
        a(r23, r2, r22, r20);
    L99:
        if (r21 == r22.C) goto L101;
    L105:
        r111 = false;
        goto L107
    L101:
        if (r22.A.f758c == null) goto L105;
        if (r22.A.f758c.f() == false) goto L105;
    L8:
        if (r18.t() == false) goto L12;
        int r26 = r17 + 1;
        if (a(r26, r18) == false) goto L12;
        androidx.constraintlayout.a.c.f.a(r26, r18, r2, new b.a(), b.a.f697a);
        goto L12
    }

    private static void a(int r16, androidx.constraintlayout.a.c.e r17, b.InterfaceC0012b r18) {
        b.InterfaceC0012b r1 = (b.InterfaceC0012b) ZeusTransformUtils.wrapperContextForParams(r18, b.InterfaceC0012b.class, "com.obric.aiagent.plugin");
        if (r17.k() == false) goto L5;
        return;
    L5:
        boolean r4 = true;
        f721c++;
        if (ZeusTransformUtils.instanceOf(r17, androidx.constraintlayout.a.c.f.class) == false) goto L8;
    L12:
        androidx.constraintlayout.a.c.d r3 = r17.a(androidx.constraintlayout.a.c.d.a.f764c);
        androidx.constraintlayout.a.c.d r5 = r17.a(androidx.constraintlayout.a.c.d.a.f766e);
        int r6 = r3.d();
        int r7 = r5.d();
        if (r3.a() == null) goto L79;
        if (r3.f() == false) goto L79;
        Iterator<androidx.constraintlayout.a.c.d> r8 = r3.a().iterator();
    L18:
        if (r8.hasNext() == false) goto L79;
        androidx.constraintlayout.a.c.d r9 = (androidx.constraintlayout.a.c.d) ZeusTransformUtils.preCheckCast(r8.next(), androidx.constraintlayout.a.c.d.class, "com.obric.aiagent.plugin");
        androidx.constraintlayout.a.c.e r12 = r9.f756a;
        int r13 = r16 + 1;
        boolean r14 = a(r13, r12);
        if (r12.t() == false) goto L24;
        if (r14 == false) goto L24;
        androidx.constraintlayout.a.c.f.a(r13, r12, r1, new b.a(), b.a.f697a);
    L24:
        if (r9 != r12.B) goto L30;
        if (r12.D.f758c == null) goto L30;
        if (r12.D.f758c.f() == false) goto L30;
    L35:
        boolean r11 = r4;
    L38:
        if (r12.ab() != androidx.constraintlayout.a.c.e.a.f777c) goto L62;
        if (r14 == true) goto L62;
        if (r12.ab() != androidx.constraintlayout.a.c.e.a.f777c) goto L63;
        if (r12.u < 0) goto L63;
        if (r12.t < 0) goto L63;
        if (r12.B() == 8) goto L54;
        if (r12.o != 0) goto L63;
        if (r12.U() != 0.0f) goto L63;
    L54:
        if (r12.ad() == true) goto L63;
        if (r12.p() == true) goto L63;
        if (r11 == false) goto L63;
        if (r12.ad() == true) goto L63;
        a(r13, r17, r1, r12);
    L63:
        r4 = true;
    L62:
        if (r12.t() == true) goto L63;
        if (r9 != r12.B) goto L70;
        if (r12.D.f758c != null) goto L70;
        int r10 = r12.B.i() + r6;
        r12.b(r10, r12.G() + r10);
        a(r13, r12, r1);
    L70:
        if (r9 == r12.D) goto L72;
    L74:
        if (r11 == false) goto L63;
        if (r12.ad() == true) goto L63;
        a(r13, r1, r12);
        goto L63
    L72:
        if (r12.B.f758c != null) goto L74;
        int r15 = r6 - r12.D.i();
        r12.b(r15 - r12.G(), r15);
        a(r13, r12, r1);
    L30:
        if (r9 == r12.D) goto L32;
    L36:
        r11 = false;
        goto L38
    L32:
        if (r12.B.f758c == null) goto L36;
        if (r12.B.f758c.f() == false) goto L36;
    L79:
        if (ZeusTransformUtils.instanceOf(r17, androidx.constraintlayout.a.c.h.class) == false) goto L82;
        return;
    L82:
        if (r5.a() != null) goto L84;
    L147:
        androidx.constraintlayout.a.c.d r19 = r17.a(androidx.constraintlayout.a.c.d.a.f);
        if (r19.a() != null) goto L150;
    L167:
        r17.m();
        return;
    L150:
        if (r19.f() == false) goto L167;
        int r20 = r19.d();
        Iterator<androidx.constraintlayout.a.c.d> r21 = r19.a().iterator();
    L153:
        if (r21.hasNext() == false) goto L167;
        androidx.constraintlayout.a.c.d r22 = (androidx.constraintlayout.a.c.d) ZeusTransformUtils.preCheckCast(r21.next(), androidx.constraintlayout.a.c.d.class, "com.obric.aiagent.plugin");
        androidx.constraintlayout.a.c.e r23 = r22.f756a;
        int r24 = r16 + 1;
        boolean r25 = a(r24, r23);
        if (r23.t() == false) goto L159;
        if (r25 == false) goto L159;
        androidx.constraintlayout.a.c.f.a(r24, r23, r1, new b.a(), b.a.f697a);
    L159:
        if (r23.ab() != androidx.constraintlayout.a.c.e.a.f777c) goto L162;
        if (r25 == false) goto L153;
    L162:
        if (r23.t() == true) goto L153;
        if (r22 != r23.E) goto L153;
        r23.f(r22.i() + r20);
        a(r24, r23, r1);
        goto L153
    L84:
        if (r5.f() == false) goto L147;
        Iterator<androidx.constraintlayout.a.c.d> r26 = r5.a().iterator();
    L87:
        if (r26.hasNext() == false) goto L147;
        androidx.constraintlayout.a.c.d r27 = (androidx.constraintlayout.a.c.d) ZeusTransformUtils.preCheckCast(r26.next(), androidx.constraintlayout.a.c.d.class, "com.obric.aiagent.plugin");
        androidx.constraintlayout.a.c.e r28 = r27.f756a;
        int r29 = r16 + 1;
        boolean r30 = a(r29, r28);
        if (r28.t() == false) goto L93;
        if (r30 == false) goto L93;
        androidx.constraintlayout.a.c.f.a(r29, r28, r1, new b.a(), b.a.f697a);
    L93:
        if (r27 != r28.B) goto L99;
        if (r28.D.f758c == null) goto L99;
        if (r28.D.f758c.f() == false) goto L99;
    L104:
        boolean r110 = true;
    L107:
        if (r28.ab() != androidx.constraintlayout.a.c.e.a.f777c) goto L131;
        if (r30 == true) goto L131;
        if (r28.ab() != androidx.constraintlayout.a.c.e.a.f777c) goto L87;
        if (r28.u < 0) goto L87;
        if (r28.t < 0) goto L87;
        if (r28.B() == 8) goto L123;
        if (r28.o != 0) goto L87;
        if (r28.U() != 0.0f) goto L87;
    L123:
        if (r28.ad() == true) goto L87;
        if (r28.p() == true) goto L87;
        if (r110 == false) goto L87;
        if (r28.ad() == true) goto L87;
        a(r29, r17, r1, r28);
    L131:
        if (r28.t() == true) goto L87;
        if (r27 != r28.B) goto L139;
        if (r28.D.f758c != null) goto L139;
        int r31 = r28.B.i() + r7;
        r28.b(r31, r28.G() + r31);
        a(r29, r28, r1);
    L139:
        if (r27 != r28.D) goto L143;
        if (r28.B.f758c != null) goto L143;
        int r32 = r7 - r28.D.i();
        r28.b(r32 - r28.G(), r32);
        a(r29, r28, r1);
    L143:
        if (r110 == false) goto L87;
        if (r28.ad() == true) goto L87;
        a(r29, r1, r28);
    L99:
        if (r27 == r28.D) goto L101;
    L105:
        r110 = false;
        goto L107
    L101:
        if (r28.B.f758c == null) goto L105;
        if (r28.B.f758c.f() == false) goto L105;
    L8:
        if (r17.t() == false) goto L12;
        int r33 = r16 + 1;
        if (a(r33, r17) == false) goto L12;
        androidx.constraintlayout.a.c.f.a(r33, r17, r1, new b.a(), b.a.f697a);
        goto L12
    }

    private static void a(int r6, b.InterfaceC0012b r7, androidx.constraintlayout.a.c.e r8, boolean r9) {
        b.InterfaceC0012b r10 = (b.InterfaceC0012b) ZeusTransformUtils.wrapperContextForParams(r7, b.InterfaceC0012b.class, "com.obric.aiagent.plugin");
        float r0 = r8.P();
        int r1 = r8.A.f758c.d();
        int r2 = r8.C.f758c.d();
        int r3 = r8.A.i() + r1;
        int r4 = r2 - r8.C.i();
        if (r1 != r2) goto L5;
        r0 = 0.5f;
    L6:
        int r5 = r8.F();
        int r11 = (r2 - r1) - r5;
        if (r1 <= r2) goto L9;
        r11 = (r1 - r2) - r5;
    L9:
        if (r11 <= 0) goto L11;
        float r12 = (r0 * r11) + 0.5f;
    L12:
        int r13 = ((int) r12) + r1;
        int r14 = r13 + r5;
        if (r1 <= r2) goto L15;
        r14 = r13 - r5;
    L15:
        r8.a(r13, r14);
        a(r6 + 1, r8, r10, r9);
        return;
    L11:
        r12 = r0 * r11;
        goto L12
    L5:
        r1 = r3;
        r2 = r4;
        goto L6
    }

    private static void a(int r6, b.InterfaceC0012b r7, androidx.constraintlayout.a.c.e r8) {
        b.InterfaceC0012b r9 = (b.InterfaceC0012b) ZeusTransformUtils.wrapperContextForParams(r7, b.InterfaceC0012b.class, "com.obric.aiagent.plugin");
        float r0 = r8.Q();
        int r1 = r8.B.f758c.d();
        int r2 = r8.D.f758c.d();
        int r3 = r8.B.i() + r1;
        int r4 = r2 - r8.D.i();
        if (r1 != r2) goto L5;
        r0 = 0.5f;
    L6:
        int r5 = r8.G();
        int r10 = (r2 - r1) - r5;
        if (r1 <= r2) goto L9;
        r10 = (r1 - r2) - r5;
    L9:
        if (r10 <= 0) goto L11;
        float r11 = (r0 * r10) + 0.5f;
    L12:
        int r12 = (int) r11;
        int r13 = r1 + r12;
        int r14 = r13 + r5;
        if (r1 <= r2) goto L15;
        r13 = r1 - r12;
        r14 = r13 - r5;
    L15:
        r8.b(r13, r14);
        a(r6 + 1, r8, r9);
        return;
    L11:
        r11 = r0 * r10;
        goto L12
    L5:
        r1 = r3;
        r2 = r4;
        goto L6
    }

    private static void a(int r7, androidx.constraintlayout.a.c.e r8, b.InterfaceC0012b r9, androidx.constraintlayout.a.c.e r10, boolean r11) {
        b.InterfaceC0012b r12 = (b.InterfaceC0012b) ZeusTransformUtils.wrapperContextForParams(r9, b.InterfaceC0012b.class, "com.obric.aiagent.plugin");
        float r0 = r10.P();
        int r1 = r10.A.f758c.d() + r10.A.i();
        int r2 = r10.C.f758c.d() - r10.C.i();
        if (r2 < r1) goto L21;
        int r3 = r10.F();
        if (r10.B() != 8) goto L7;
    L19:
        int r4 = r1 + ((int) ((r0 * ((r2 - r1) - r3)) + 0.5f));
        r10.a(r4, r3 + r4);
        a(r7 + 1, r10, r12, r11);
        return;
    L7:
        if (r10.n != 2) goto L14;
        if (ZeusTransformUtils.instanceOf(r8, androidx.constraintlayout.a.c.f.class) == false) goto L11;
        int r13 = r8.F();
    L12:
        r3 = (int) ((r10.P() * 0.5f) * r13);
    L16:
        r3 = Math.max(r10.q, r3);
        if (r10.r <= 0) goto L19;
        r3 = Math.min(r10.r, r3);
        goto L19
    L11:
        r13 = r8.A().F();
        goto L12
    L14:
        if (r10.n != 0) goto L16;
        r3 = r2 - r1;
        goto L16
    }

    private static void a(int r7, androidx.constraintlayout.a.c.e r8, b.InterfaceC0012b r9, androidx.constraintlayout.a.c.e r10) {
        b.InterfaceC0012b r11 = (b.InterfaceC0012b) ZeusTransformUtils.wrapperContextForParams(r9, b.InterfaceC0012b.class, "com.obric.aiagent.plugin");
        float r0 = r10.Q();
        int r1 = r10.B.f758c.d() + r10.B.i();
        int r2 = r10.D.f758c.d() - r10.D.i();
        if (r2 < r1) goto L21;
        int r3 = r10.G();
        if (r10.B() != 8) goto L7;
    L19:
        int r4 = r1 + ((int) ((r0 * ((r2 - r1) - r3)) + 0.5f));
        r10.b(r4, r3 + r4);
        a(r7 + 1, r10, r11);
        return;
    L7:
        if (r10.o != 2) goto L14;
        if (ZeusTransformUtils.instanceOf(r8, androidx.constraintlayout.a.c.f.class) == false) goto L11;
        int r12 = r8.G();
    L12:
        r3 = (int) ((r0 * 0.5f) * r12);
    L16:
        r3 = Math.max(r10.t, r3);
        if (r10.u <= 0) goto L19;
        r3 = Math.min(r10.u, r3);
        goto L19
    L11:
        r12 = r8.A().G();
        goto L12
    L14:
        if (r10.o != 0) goto L16;
        r3 = r2 - r1;
        goto L16
    }

    private static boolean a(int r5, androidx.constraintlayout.a.c.e r6) {
        androidx.constraintlayout.a.c.e.a r7 = r6.aa();
        androidx.constraintlayout.a.c.e.a r0 = r6.ab();
        if (r6.A() == null) goto L5;
        androidx.constraintlayout.a.c.f r1 = (androidx.constraintlayout.a.c.f) ZeusTransformUtils.preCheckCast(r6.A(), androidx.constraintlayout.a.c.f.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 == null) goto L8;
        r1.aa();
        androidx.constraintlayout.a.c.e.a r3 = androidx.constraintlayout.a.c.e.a.f775a;
    L8:
        if (r1 == null) goto L11;
        r1.ab();
        androidx.constraintlayout.a.c.e.a r2 = androidx.constraintlayout.a.c.e.a.f775a;
    L11:
        if (r7 != androidx.constraintlayout.a.c.e.a.f775a) goto L13;
    L32:
        boolean r8 = true;
    L34:
        if (r0 != androidx.constraintlayout.a.c.e.a.f775a) goto L36;
    L55:
        boolean r4 = true;
    L57:
        if (r6.O <= 0.0f) goto L61;
        if (r8 == true) goto L60;
        if (r4 == false) goto L61;
    L60:
        return true;
    L61:
        if (r8 == false) goto L65;
        if (r4 == true) goto L64;
        return false;
    L64:
        return true;
    L65:
        return false;
    L36:
        if (r6.e() == true) goto L55;
        if (r0 == androidx.constraintlayout.a.c.e.a.f776b) goto L55;
        if (r0 != androidx.constraintlayout.a.c.e.a.f777c) goto L48;
        if (r6.o != 0) goto L48;
        if (r6.O != 0.0f) goto L48;
        if (r6.g(1) == true) goto L55;
    L48:
        if (r0 == androidx.constraintlayout.a.c.e.a.f777c) goto L50;
    L54:
        r4 = false;
        goto L57
    L50:
        if (r6.o != 1) goto L54;
        if (r6.c(1, r6.G()) == false) goto L54;
    L13:
        if (r6.d() == true) goto L32;
        if (r7 == androidx.constraintlayout.a.c.e.a.f776b) goto L32;
        if (r7 != androidx.constraintlayout.a.c.e.a.f777c) goto L25;
        if (r6.n != 0) goto L25;
        if (r6.O != 0.0f) goto L25;
        if (r6.g(0) == true) goto L32;
    L25:
        if (r7 == androidx.constraintlayout.a.c.e.a.f777c) goto L27;
    L31:
        r8 = false;
        goto L34
    L27:
        if (r6.n != 1) goto L31;
        if (r6.c(0, r6.F()) == false) goto L31;
    L5:
        r1 = null;
        goto L6
    }
}
