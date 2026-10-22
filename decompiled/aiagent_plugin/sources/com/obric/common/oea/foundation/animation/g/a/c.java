package com.obric.common.oea.foundation.animation.g.a;

import d.h.b.p;

/* JADX INFO: compiled from: FloatSpringSpec.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: compiled from: FloatSpringSpec.kt */
    static final class a extends p implements d.h.a.a<Double> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ double f32394a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ double f32395b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ double f32396c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ double f32397d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ double f32398e;

        a(double r1, double r3, double r5, double r7, double r9) {
            this.f32394a = r1;
            this.f32395b = r3;
            this.f32396c = r5;
            this.f32397d = r7;
            this.f32398e = r9;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ Double invoke() {
            return Double.valueOf(a());
        }

        public final double a() {
            return (this.f32394a * Math.exp(this.f32395b * this.f32396c)) + (this.f32397d * Math.exp(this.f32398e * this.f32396c));
        }
    }

    public static final long a(float r10, float r11, float r12, float r13, float r14) {
        if (r11 != 0.0f) goto L7;
        return 9223372036854L;
    L7:
        return a(r10, r11, r12, r13, r14);
    }

    public static final long a(double r12, double r14, double r16, double r18, double r20) {
        double r0 = (2.0d * r14) * Math.sqrt(r12);
        double r2 = (r0 * r0) - (4.0d * r12);
        double r1 = -r0;
        com.obric.common.oea.foundation.animation.g.a.a r4 = a(r2);
        com.obric.common.oea.foundation.animation.g.a.a.a(r4, com.obric.common.oea.foundation.animation.g.a.a.a(r4) + r1);
        com.obric.common.oea.foundation.animation.g.a.a.a(r4, com.obric.common.oea.foundation.animation.g.a.a.a(r4) * 0.5d);
        com.obric.common.oea.foundation.animation.g.a.a.b(r4, com.obric.common.oea.foundation.animation.g.a.a.b(r4) * 0.5d);
        com.obric.common.oea.foundation.animation.g.a.a r3 = a(r2);
        double r9 = -1;
        com.obric.common.oea.foundation.animation.g.a.a.a(r3, com.obric.common.oea.foundation.animation.g.a.a.a(r3) * r9);
        com.obric.common.oea.foundation.animation.g.a.a.b(r3, com.obric.common.oea.foundation.animation.g.a.a.b(r3) * r9);
        com.obric.common.oea.foundation.animation.g.a.a.a(r3, com.obric.common.oea.foundation.animation.g.a.a.a(r3) + r1);
        com.obric.common.oea.foundation.animation.g.a.a.a(r3, com.obric.common.oea.foundation.animation.g.a.a.a(r3) * 0.5d);
        com.obric.common.oea.foundation.animation.g.a.a.b(r3, com.obric.common.oea.foundation.animation.g.a.a.b(r3) * 0.5d);
        return a(r4, r3, r14, r16, r18, r20);
    }

    public static final com.obric.common.oea.foundation.animation.g.a.a a(double r3) {
        if (r3 >= 0.0d) goto L6;
        return new com.obric.common.oea.foundation.animation.g.a.a(0.0d, Math.sqrt(Math.abs(r3)));
    L6:
        return new com.obric.common.oea.foundation.animation.g.a.a(Math.sqrt(r3), 0.0d);
    }

    private static final long a(com.obric.common.oea.foundation.animation.g.a.a r10, com.obric.common.oea.foundation.animation.g.a.a r11, double r12, double r14, double r16, double r18) {
        double r0 = r14;
        if (r16 != 0.0d) goto L9;
        if (r0 != 0.0d) goto L9;
        return 0;
    L9:
        if (r16 >= 0) goto L11;
        r0 = -r0;
    L11:
        double r4 = Math.abs(r16);
        if (r12 <= 1.0d) goto L15;
        double r1 = a(r10, r11, r4, r0, r18);
    L19:
        return (long) (r1 * 1000.0d);
    L15:
        if (r12 >= 1.0d) goto L17;
        r1 = a(r10, r4, r0, r18);
        goto L19
    L17:
        r1 = b(r10, r4, r0, r18);
        goto L19
    }

    private static final double a(com.obric.common.oea.foundation.animation.g.a.a r31, com.obric.common.oea.foundation.animation.g.a.a r32, double r33, double r35, double r37) {
        double r0 = r37;
        double r13 = r31.a();
        double r15 = r32.a();
        double r17 = r13 - r15;
        double r11 = ((r13 * r33) - r35) / r17;
        double r19 = r33 - r11;
        double r2 = Math.log(Math.abs(r0 / r19)) / r13;
        double r4 = Math.log(Math.abs(r0 / r11)) / r15;
        if (Double.isInfinite(r2) == false) goto L5;
    L7:
        boolean r6 = false;
    L9:
        if ((!r6) == false) goto L12;
        double r22 = r4;
    L22:
        double r24 = r19 * r13;
        double r26 = Math.log(r24 / ((-r11) * r15)) / (r15 - r13);
        a r28 = new a(r19, r13, r26, r11, r15);
        if (Double.isNaN(r26) == false) goto L25;
    L37:
        r0 = -r0;
    L38:
        double r12 = r11 * r15;
        if (Math.abs((Math.exp(r13 * r22) * r24) + (Math.exp(r15 * r22) * r12)) >= 1.0E-4d) goto L41;
        return r22;
    L41:
        double r3 = Double.MAX_VALUE;
        int r5 = 0;
    L43:
        if (r3 <= 0.001d) goto L47;
        if (r5 >= 100) goto L47;
        r5 = r5 + 1;
        double r7 = r13 * r22;
        double r8 = r15 * r22;
        double r9 = r22 - ((((Math.exp(r7) * r19) + (Math.exp(r8) * r11)) + r0) / ((Math.exp(r7) * r24) + (Math.exp(r8) * r12)));
        double r10 = Math.abs(r22 - r9);
        r22 = r9;
        r3 = r10;
    L47:
        return r22;
    L25:
        if (r26 <= 0.0d) goto L37;
        if (r26 > 0.0d) goto L30;
    L36:
        r22 = Math.log((-((r11 * r15) * r15)) / (r24 * r13)) / r17;
        goto L38
    L30:
        if ((-r28.a()) >= r0) goto L36;
        if (r11 <= 0.0d) goto L37;
        if (r19 >= 0.0d) goto L37;
        r22 = 0.0d;
        goto L37
    L12:
        if (Double.isInfinite(r4) == false) goto L14;
    L16:
        boolean r14 = false;
    L18:
        if ((!r14) == true) goto L21;
        r2 = Math.max(r2, r4);
    L21:
        r22 = r2;
        goto L22
    L14:
        if (Double.isNaN(r4) == true) goto L16;
        r14 = true;
        goto L18
    L5:
        if (Double.isNaN(r2) == true) goto L7;
        r6 = true;
        goto L9
    }

    private static final double a(com.obric.common.oea.foundation.animation.g.a.a r4, double r5, double r7, double r9) {
        double r0 = r4.a();
        double r8 = (r7 - (r0 * r5)) / r4.b();
        return Math.log(r9 / Math.sqrt((r5 * r5) + (r8 * r8))) / r0;
    }

    private static final double b(com.obric.common.oea.foundation.animation.g.a.a r20, double r21, double r23, double r25) {
        double r0 = r25;
        double r2 = r20.a();
        double r4 = r2 * r21;
        double r6 = r23 - r4;
        double r8 = Math.log(Math.abs(r0 / r21)) / r2;
        double r10 = Math.log(Math.abs(r0 / r6));
        double r14 = r10;
        int r13 = 0;
    L4:
        if (r13 > 5) goto L6;
        r14 = r10 - Math.log(Math.abs(r14 / r2));
        r13 = r13 + 1;
        goto L4
    L6:
        double r15 = r14 / r2;
        if (Double.isInfinite(r8) == false) goto L9;
    L11:
        boolean r11 = false;
    L13:
        if ((!r11) == false) goto L16;
        r8 = r15;
    L25:
        double r12 = (-(r4 + r6)) / (r2 * r6);
        double r16 = r2 * r12;
        double r17 = (Math.exp(r16) * r21) + ((r6 * r12) * Math.exp(r16));
        if (Double.isNaN(r12) == false) goto L28;
    L40:
        int r18 = 0;
    L41:
        r0 = -r0;
    L42:
        double r19 = Double.MAX_VALUE;
    L44:
        if (r19 <= 0.001d) goto L48;
        if (r18 >= 100) goto L48;
        r18 = r18 + 1;
        double r110 = r2 * r8;
        double r24 = r0;
        double r1 = r8 - ((((r21 + (r6 * r8)) * Math.exp(r110)) + r0) / ((((((double) 1) + r110) * r6) + r4) * Math.exp(r110)));
        r19 = Math.abs(r8 - r1);
        r8 = r1;
        r0 = r24;
    L48:
        return r8;
    L28:
        if (r12 <= 0.0d) goto L40;
        if (r12 > 0.0d) goto L33;
    L39:
        r18 = 0;
        r8 = (-(2.0d / r2)) - (r21 / r6);
        goto L42
    L33:
        if ((-r17) >= r0) goto L39;
        r18 = 0;
        double r111 = 0;
        if (r6 >= r111) goto L41;
        if (r21 <= r111) goto L41;
        r8 = 0.0d;
        goto L41
    L16:
        if (Double.isInfinite(r15) == false) goto L18;
    L20:
        boolean r112 = false;
    L22:
        if ((!r112) == true) goto L25;
        r8 = Math.max(r8, r15);
        goto L25
    L18:
        if (Double.isNaN(r15) == true) goto L20;
        r112 = true;
        goto L22
    L9:
        if (Double.isNaN(r8) == true) goto L11;
        r11 = true;
        goto L13
    }
}
