package mb;

import com.obric.common.oea.foundation.animation.token.Easing;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Easing f22263a = null;

    static {
        f22263a = new a(0.4f, 0.0f, 0.2f, 1.0f);
    }

    public static final /* synthetic */ int a(float r10, float[] r11, int r12) {
        return j(r10, r11, r12);
    }

    public static final nb.a b(float r10, float r11, float r12, float r13, float[] r14, int r15) {
        q.g(r14, "roots");
        float r16 = (r11 - r10) * 3.0f;
        float r17 = (r12 - r11) * 3.0f;
        float r18 = (r13 - r12) * 3.0f;
        int r19 = g(r16, r17, r18, r14, r15);
        float r20 = (r17 - r16) * 2.0f;
        float r21 = (r18 - r17) * 2.0f;
        float r22 = (-r20) / (r21 - r20);
        int r23 = r19 + a(r22, r14, r15 + r19);
        float r110 = Math.min(r10, r13);
        float r24 = Math.max(r10, r13);
        int r25 = 0;
    L3:
        if (r25 >= r23) goto L6;
        float r26 = d(r10, r11, r12, r13, r14[r25]);
        r110 = Math.min(r110, r26);
        r24 = Math.max(r24, r26);
        r25 = r25 + 1;
        goto L3
    L6:
        return new nb.a(r110, r24);
    }

    public static final float c(float r10, float r11, float r12) {
        float r13 = (r10 - r11) + 0.33333334f;
        float r14 = r13 * r12;
        return ((((r14 + (r11 - (2.0f * r10))) * r12) + r10) * 3.0f) * r12;
    }

    public static final float d(float r10, float r11, float r12, float r13, float r14) {
        float r15 = (r13 + ((r11 - r12) * 3.0f)) - r10;
        float r16 = ((r12 - (2.0f * r11)) + r10) * 3.0f;
        float r17 = ((r15 * r14) + r16) * r14;
        return ((r17 + ((r11 - r10) * 3.0f)) * r14) + r10;
    }

    public static final float e(float r10) {
        float r11 = Float.intBitsToFloat(((int) ((((long) Float.floatToRawIntBits(r10)) & 8589934591L) / ((long) 3))) + 709952852);
        float r12 = r11 - ((r11 - (r10 / (r11 * r11))) * 0.33333334f);
        return r12 - ((r12 - (r10 / (r12 * r12))) * 0.33333334f);
    }

    public static final float f(float r22, float r23, float r24, float r25) {
        double r10 = r22;
        double r11 = ((r10 - (((double) r23) * 2.0d)) + ((double) r24)) * 3.0d;
        double r12 = ((double) (r23 - r22)) * 3.0d;
        double r13 = (((double) (-r22)) + (((double) (r23 - r24)) * 3.0d)) + ((double) r25);
        if (Math.abs(r13 - 0.0d) < 1.0E-7d) goto L5;
        double r14 = r11 / r13;
        double r15 = r12 / r13;
        double r16 = r10 / r13;
        double r17 = ((r15 * 3.0d) - (r14 * r14)) / 9.0d;
        double r18 = (((((2.0d * r14) * r14) * r14) - ((9.0d * r14) * r15)) + (r16 * 27.0d)) / 54.0d;
        double r19 = (r17 * r17) * r17;
        double r20 = (r18 * r18) + r19;
        double r21 = r14 / 3.0d;
        if (r20 >= 0.0d) goto L98;
        double r26 = Math.sqrt(-r19);
        double r27 = (-r18) / r26;
        if (r27 >= (-1.0d)) goto L55;
        r27 = -1.0d;
    L55:
        if (r27 <= 1.0d) goto L57;
        r27 = 1.0d;
    L57:
        double r28 = Math.acos(r27);
        double r29 = e((float) r26) * 2.0f;
        float r30 = (float) ((Math.cos(r28 / 3.0d) * r29) - r21);
        if (r30 >= 0.0f) goto L64;
        if (r30 < (-8.34465E-7f)) goto L62;
        r30 = 0.0f;
    L69:
        if (Float.isNaN(r30) == true) goto L71;
        return r30;
    L71:
        float r31 = (float) ((Math.cos((6.283185307179586d + r28) / 3.0d) * r29) - r21);
        if (r31 >= 0.0f) goto L78;
        if (r31 < (-8.34465E-7f)) goto L76;
        r31 = 0.0f;
    L83:
        if (Float.isNaN(r31) == true) goto L85;
        return r31;
    L85:
        float r32 = (float) ((r29 * Math.cos((r28 + 12.566370614359172d) / 3.0d)) - r21);
        if (r32 >= 0.0f) goto L92;
        if (r32 < (-8.34465E-7f)) goto L146;
        return 0.0f;
    L146:
        return Float.NaN;
    L92:
        if (r32 <= 1.0f) goto L97;
        if (r32 > 1.0000008f) goto L146;
        return 1.0f;
    L97:
        return r32;
    L76:
        r31 = Float.NaN;
        goto L83
    L78:
        if (r31 <= 1.0f) goto L83;
        if (r31 > 1.0000008f) goto L76;
        r31 = 1.0f;
    L62:
        r30 = Float.NaN;
        goto L69
    L64:
        if (r30 <= 1.0f) goto L69;
        if (r30 > 1.0000008f) goto L62;
        r30 = 1.0f;
        goto L69
    L98:
        if (r20 != 0.0d) goto L126;
        float r33 = -e((float) r18);
        float r34 = (float) r21;
        float r35 = (2.0f * r33) - r34;
        if (r35 >= 0.0f) goto L106;
        if (r35 < (-8.34465E-7f)) goto L104;
        r35 = 0.0f;
    L111:
        if (Float.isNaN(r35) == true) goto L113;
        return r35;
    L113:
        float r36 = (-r33) - r34;
        if (r36 >= 0.0f) goto L120;
        if (r36 < (-8.34465E-7f)) goto L149;
        return 0.0f;
    L149:
        return Float.NaN;
    L120:
        if (r36 <= 1.0f) goto L125;
        if (r36 > 1.0000008f) goto L149;
        return 1.0f;
    L125:
        return r36;
    L104:
        r35 = Float.NaN;
        goto L111
    L106:
        if (r35 <= 1.0f) goto L111;
        if (r35 > 1.0000008f) goto L104;
        r35 = 1.0f;
        goto L111
    L126:
        double r37 = Math.sqrt(r20);
        float r38 = (float) (((double) (e((float) ((-r18) + r37)) - e((float) (r18 + r37)))) - r21);
        if (r38 >= 0.0f) goto L133;
        if (r38 < (-8.34465E-7f)) goto L152;
        return 0.0f;
    L152:
        return Float.NaN;
    L133:
        if (r38 <= 1.0f) goto L138;
        if (r38 > 1.0000008f) goto L152;
        return 1.0f;
    L138:
        return r38;
    L5:
        if (Math.abs(r11 - 0.0d) < 1.0E-7d) goto L7;
        double r39 = Math.sqrt((r12 * r12) - ((4.0d * r11) * r10));
        double r40 = r11 * 2.0d;
        float r41 = (float) ((r39 - r12) / r40);
        if (r41 >= 0.0f) goto L29;
        if (r41 < (-8.34465E-7f)) goto L27;
        r41 = 0.0f;
    L34:
        if (Float.isNaN(r41) == true) goto L36;
        return r41;
    L36:
        float r42 = (float) (((-r12) - r39) / r40);
        if (r42 >= 0.0f) goto L43;
        if (r42 < (-8.34465E-7f)) goto L143;
        return 0.0f;
    L143:
        return Float.NaN;
    L43:
        if (r42 <= 1.0f) goto L48;
        if (r42 > 1.0000008f) goto L143;
        return 1.0f;
    L48:
        return r42;
    L27:
        r41 = Float.NaN;
        goto L34
    L29:
        if (r41 <= 1.0f) goto L34;
        if (r41 > 1.0000008f) goto L27;
        r41 = 1.0f;
        goto L34
    L7:
        if (Math.abs(r12 - 0.0d) >= 1.0E-7d) goto L9;
        return Float.NaN;
    L9:
        float r43 = (float) ((-r10) / r12);
        if (r43 >= 0.0f) goto L16;
        if (r43 < (-8.34465E-7f)) goto L140;
        return 0.0f;
    L140:
        return Float.NaN;
    L16:
        if (r43 <= 1.0f) goto L21;
        if (r43 > 1.0000008f) goto L140;
        return 1.0f;
    L21:
        return r43;
    }

    public static final int g(float r17, float r18, float r19, float[] r20, int r21) {
        double r10 = r17;
        double r11 = r18;
        double r12 = r19;
        double r13 = r11 * 2.0d;
        double r14 = (r10 - r13) + r12;
        if (r14 == 0.0d) goto L13;
        double r15 = -Math.sqrt((r11 * r11) - (r12 * r10));
        double r16 = (-r10) + r11;
        int r22 = j((float) ((-(r15 + r16)) / r14), r20, r21);
        int r23 = r22 + j((float) ((r15 - r16) / r14), r20, r21 + r22);
        if (r23 <= 1) goto L17;
        float r24 = r20[r21];
        int r25 = r21 + 1;
        float r26 = r20[r25];
        if (r24 <= r26) goto L10;
        r20[r21] = r26;
        r20[r25] = r24;
        return r23;
    L10:
        if (r24 == r26) goto L20;
        return r23;
    L20:
        return r23 - 1;
    L17:
        return r23;
    L13:
        if (r11 != r12) goto L21;
        return 0;
    L21:
        return j((float) ((r13 - r12) / (r13 - (r12 * 2.0d))), r20, r21);
    }

    public static final float h(float r10, float r11, float r12) {
        return (r10 * (1 - r12)) + (r11 * r12);
    }

    public static final void i(String r10) {
        q.g(r10, "message");
        throw new IllegalArgumentException(r10);
    }

    public static final int j(float r10, float[] r11, int r12) {
        float r13 = 0.0f;
        if (r10 < 0.0f) goto L5;
        r13 = 1.0f;
        if (r10 > 1.0f) goto L11;
    L13:
        r11[r12] = r10;
        return !Float.isNaN(r10) ? 1 : 0;
    L11:
        if (r10 <= 1.0000008f) goto L6;
    L7:
        r10 = Float.NaN;
    L6:
        r10 = r13;
        goto L13
    L5:
        if (r10 < (-8.34465E-7f)) goto L7;
        goto L6
    }
}
