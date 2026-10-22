package com.obric.common.oea.foundation.animation.spec.spring;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class FloatSpringSpecKt {
    public static final a a(double r10) {
        if (r10 >= 0.0d) goto L6;
        return new a(0.0d, Math.sqrt(Math.abs(r10)));
    L6:
        return new a(Math.sqrt(r10), 0.0d);
    }

    public static final long b(double r12, double r14, double r16, double r18, double r20) {
        double r10 = (2.0d * r14) * Math.sqrt(r12);
        double r11 = (r10 * r10) - (4.0d * r12);
        double r13 = -r10;
        a r15 = a(r11);
        a.d(r15, a.b(r15) + r13);
        a.d(r15, a.b(r15) * 0.5d);
        a.c(r15, a.a(r15) * 0.5d);
        a r17 = a(r11);
        double r19 = -1;
        a.d(r17, a.b(r17) * r19);
        a.c(r17, a.a(r17) * r19);
        a.d(r17, a.b(r17) + r13);
        a.d(r17, a.b(r17) * 0.5d);
        a.c(r17, a.a(r17) * 0.5d);
        return e(r15, r17, r14, r16, r18, r20);
    }

    public static final long c(float r10, float r11, float r12, float r13, float r14) {
        if (r11 != 0.0f) goto L7;
        return 9223372036854L;
    L7:
        return b(r10, r11, r12, r13, r14);
    }

    public static final double d(a r20, double r21, double r23, double r25) {
        double r10 = r25;
        double r11 = r20.f();
        double r12 = r11 * r21;
        double r13 = r23 - r12;
        double r14 = Math.log(Math.abs(r10 / r21)) / r11;
        double r15 = Math.log(Math.abs(r10 / r13));
        double r16 = r15;
        int r17 = 0;
    L4:
        if (r17 > 5) goto L6;
        r16 = r15 - Math.log(Math.abs(r16 / r11));
        r17 = r17 + 1;
        goto L4
    L6:
        double r18 = r16 / r11;
        if (Double.isInfinite(r14) == false) goto L9;
    L11:
        boolean r19 = false;
    L12:
        if (r19 == true) goto L15;
        r14 = r18;
    L23:
        double r110 = (-(r12 + r13)) / (r11 * r13);
        double r111 = r11 * r110;
        double r112 = (Math.exp(r111) * r21) + ((r13 * r110) * Math.exp(r111));
        if (Double.isNaN(r110) == false) goto L26;
    L27:
        int r113 = 0;
    L37:
        r10 = -r10;
    L39:
        double r114 = Double.MAX_VALUE;
    L41:
        if (r114 <= 0.001d) goto L45;
        if (r113 >= 100) goto L45;
        r113 = r113 + 1;
        double r115 = r11 * r14;
        double r24 = r10;
        double r22 = r14 - ((((r21 + (r13 * r14)) * Math.exp(r115)) + r10) / ((((((double) 1) + r115) * r13) + r12) * Math.exp(r115)));
        r114 = Math.abs(r14 - r22);
        r14 = r22;
        r10 = r24;
    L45:
        return r14;
    L26:
        if (r110 <= 0.0d) goto L27;
        if (r110 > 0.0d) goto L31;
    L38:
        r113 = 0;
        r14 = (-(2.0d / r11)) - (r21 / r13);
        goto L39
    L31:
        if ((-r112) >= r10) goto L38;
        r113 = 0;
        double r116 = 0;
        if (r13 >= r116) goto L37;
        if (r21 <= r116) goto L37;
        r14 = 0.0d;
        goto L37
    L15:
        if (Double.isInfinite(r18) == false) goto L17;
    L19:
        boolean r117 = false;
    L20:
        if (r117 == false) goto L23;
        r14 = Math.max(r14, r18);
        goto L23
    L17:
        if (Double.isNaN(r18) == true) goto L19;
        r117 = true;
        goto L20
    L9:
        if (Double.isNaN(r14) == true) goto L11;
        r19 = true;
        goto L12
    }

    public static final long e(a r10, a r11, double r12, double r14, double r16, double r18) {
        double r13 = r14;
        if (r16 != 0.0d) goto L9;
        if (r13 != 0.0d) goto L9;
        return 0;
    L9:
        if (r16 >= 0) goto L11;
        r13 = -r13;
    L11:
        double r15 = Math.abs(r16);
        if (r12 <= 1.0d) goto L15;
        double r17 = f(r10, r11, r15, r13, r18);
    L19:
        return (long) (r17 * 1000.0d);
    L15:
        if (r12 >= 1.0d) goto L17;
        r17 = g(r10, r15, r13, r18);
        goto L19
    L17:
        r17 = d(r10, r15, r13, r18);
        goto L19
    }

    public static final double f(a r31, a r32, double r33, double r35, double r37) {
        double r10 = r37;
        final double r13 = r31.f();
        final double r15 = r32.f();
        double r17 = r13 - r15;
        final double r11 = ((r13 * r33) - r35) / r17;
        final double r19 = r33 - r11;
        double r12 = Math.log(Math.abs(r10 / r19)) / r13;
        double r14 = Math.log(Math.abs(r10 / r11)) / r15;
        boolean r16 = true;
        if (Double.isInfinite(r12) == false) goto L5;
    L7:
        boolean r18 = false;
    L8:
        if (r18 == true) goto L11;
        double r22 = r14;
    L19:
        double r24 = r19 * r13;
        final double r26 = Math.log(r24 / ((-r11) * r15)) / (r15 - r13);
        Function0<Double> r28 = new FloatSpringSpecKt$estimateOverDamped$1(r19, r13, r26, r11, r15);
        if (Double.isNaN(r26) == false) goto L22;
    L33:
        r10 = -r10;
    L35:
        double r110 = r11 * r15;
        if (Math.abs((Math.exp(r13 * r22) * r24) + (Math.exp(r15 * r22) * r110)) >= 1.0E-4d) goto L38;
        return r22;
    L38:
        double r20 = Double.MAX_VALUE;
        int r21 = 0;
    L40:
        if (r20 <= 0.001d) goto L44;
        if (r21 >= 100) goto L44;
        r21 = r21 + 1;
        double r23 = r13 * r22;
        double r25 = r15 * r22;
        double r27 = r22 - ((((Math.exp(r23) * r19) + (Math.exp(r25) * r11)) + r10) / ((Math.exp(r23) * r24) + (Math.exp(r25) * r110)));
        double r29 = Math.abs(r22 - r27);
        r22 = r27;
        r20 = r29;
    L44:
        return r22;
    L22:
        if (r26 <= 0.0d) goto L33;
        if (r26 > 0.0d) goto L27;
    L34:
        r22 = Math.log((-((r11 * r15) * r15)) / (r24 * r13)) / r17;
        goto L35
    L27:
        if ((-r28.invoke2()) >= r10) goto L34;
        if (r11 <= 0.0d) goto L33;
        if (r19 >= 0.0d) goto L33;
        r22 = 0.0d;
        goto L33
    L11:
        if (Double.isInfinite(r14) == false) goto L13;
    L15:
        r16 = false;
    L16:
        if (r16 == true) goto L18;
    L17:
        r22 = r12;
        goto L19
    L18:
        r12 = Math.max(r12, r14);
        goto L17
    L13:
        if (Double.isNaN(r14) == true) goto L15;
    L5:
        if (Double.isNaN(r12) == true) goto L7;
        r18 = true;
        goto L8
    }

    public static final double g(a r10, double r11, double r12, double r13) {
        double r14 = r10.f();
        double r15 = (r12 - (r14 * r11)) / r10.e();
        return Math.log(r13 / Math.sqrt((r11 * r11) + (r15 * r15))) / r14;
    }
}
