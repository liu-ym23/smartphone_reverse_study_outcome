package com.obric.common.oea.foundation.animation.token;

import com.obric.common.oea.foundation.animation.util.FloatFloatPair;
import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OEasing.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u001a\u0011\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0082\b\u001a8\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u001a\u0011\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0017H\u0086\b\u001a\u001e\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007\u001a0\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0002\u001a\u000e\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007\u001a&\u0010 \u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007\u001a+\u0010!\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0082\b\u001a2\u0010\"\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0002\u001a\u0011\u0010#\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0014H\u0086\b\u001a \u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0007H\u0000\u001a\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0000\u001a \u0010,\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a\u0015\u0010-\u001a\u00020.*\u00020\u00012\u0006\u0010/\u001a\u00020\u0001H\u0080\b\u001a\u0015\u00100\u001a\u00020\u0001*\u00020\u00012\u0006\u00101\u001a\u00020\u0001H\u0086\b\u001a\u0015\u00100\u001a\u00020\u0007*\u00020\u00072\u0006\u00101\u001a\u00020\u0007H\u0086\b\u001a\u0015\u00102\u001a\u00020\u0001*\u00020\u00012\u0006\u00103\u001a\u00020\u0001H\u0086\b\u001a\u0015\u00102\u001a\u00020\u0007*\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0086\b\u001a\u001d\u00104\u001a\u00020\u0001*\u00020\u00012\u0006\u00101\u001a\u00020\u00012\u0006\u00103\u001a\u00020\u0001H\u0086\b\u001a\u001d\u00104\u001a\u00020\u0007*\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0086\b\u001a\r\u00105\u001a\u00020\u0014*\u00020\u0001H\u0086\b\u001a\r\u00105\u001a\u00020\u0014*\u00020\u0007H\u0086\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Epsilon", "", "FastOutSlowInEasing", "Lcom/obric/common/oea/foundation/animation/token/Easing;", "getFastOutSlowInEasing", "()Lcom/obric/common/oea/foundation/animation/token/Easing;", "FloatEpsilon", "", "Tau", "clampValidRootInUnitRange", "r", "computeCubicVerticalBounds", "Lcom/obric/common/oea/foundation/animation/util/FloatFloatPair;", "p0y", "p1y", "p2y", "p3y", "roots", "", "index", "", "doubleFromBits", "bits", "", "evaluateCubic", "p1", "p2", "t", "p0", "p3", "fastCbrt", MaterialConfigFormatNames.X, "findFirstCubicRoot", "findLineRoot", "findQuadraticRoots", "floatFromBits", "lerp", "start", "stop", "fraction", "throwIllegalArgumentException", "", "message", "", "writeValidRootInUnitRange", "closeTo", "", "b", "fastCoerceAtLeast", "minimumValue", "fastCoerceAtMost", "maximumValue", "fastCoerceIn", "fastRoundToInt", "foundation_standardRelease"}, k = 2, mv = {1, 4, 3})
public final class OEasingKt {
    private static final double Epsilon = 1.0E-7d;
    private static final Easing FastOutSlowInEasing = null;
    private static final float FloatEpsilon = 8.34465E-7f;
    private static final double Tau = 6.283185307179586d;

    public static final /* synthetic */ int access$writeValidRootInUnitRange(float r0, float[] r1, int r2) {
        return writeValidRootInUnitRange(r0, r1, r2);
    }

    private static final float clampValidRootInUnitRange(float r3) {
        float r0 = 0.0f;
        if (r3 < 0.0f) goto L5;
        r0 = 1.0f;
        if (r3 > 1.0f) goto L11;
        return r3;
    L11:
        if (r3 > 1.0000008f) goto L14;
    L13:
        return r0;
    L14:
        return Float.NaN;
    L5:
        if (r3 < (-8.34465E-7f)) goto L14;
        goto L13
    }

    public static final float evaluateCubic(float r2, float r3, float r4) {
        float r1 = (r2 - r3) + 0.33333334f;
        float r5 = r1 * r4;
        return ((((r5 + (r3 - (2.0f * r2))) * r4) + r2) * 3.0f) * r4;
    }

    private static final float evaluateCubic(float r2, float r3, float r4, float r5, float r6) {
        float r7 = (r5 + ((r3 - r4) * 3.0f)) - r2;
        float r8 = ((r4 - (2.0f * r3)) + r2) * 3.0f;
        float r9 = ((r7 * r6) + r8) * r6;
        return ((r9 + ((r3 - r2) * 3.0f)) * r6) + r2;
    }

    public static final double fastCoerceAtLeast(double r1, double r3) {
        if (r1 < r3) goto L5;
        return r1;
    L5:
        return r3;
    }

    public static final float fastCoerceAtLeast(float r1, float r2) {
        if (r1 < r2) goto L5;
        return r1;
    L5:
        return r2;
    }

    public static final double fastCoerceAtMost(double r1, double r3) {
        if (r1 > r3) goto L5;
        return r1;
    L5:
        return r3;
    }

    public static final float fastCoerceAtMost(float r1, float r2) {
        if (r1 > r2) goto L5;
        return r1;
    L5:
        return r2;
    }

    public static final double fastCoerceIn(double r1, double r3, double r5) {
        if (r1 >= r3) goto L6;
        r1 = r3;
    L6:
        if (r1 <= r5) goto L9;
        return r5;
    L9:
        return r1;
    }

    public static final float fastCoerceIn(float r1, float r2, float r3) {
        if (r1 >= r2) goto L6;
        r1 = r2;
    L6:
        if (r1 <= r3) goto L9;
        return r3;
    L9:
        return r1;
    }

    public static final float lerp(float r1, float r2, float r3) {
        return (r1 * (1 - r3)) + (r2 * r3);
    }

    static {
        FastOutSlowInEasing = new CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f);
    }

    public static final Easing getFastOutSlowInEasing() {
        return FastOutSlowInEasing;
    }

    public static final void throwIllegalArgumentException(String r1) {
        Intrinsics.checkNotNullParameter(r1, "message");
        throw new IllegalArgumentException(r1);
    }

    public static final boolean closeTo(double r0, double r2) {
        if (Math.abs(r0 - r2) >= Epsilon) goto L5;
        return true;
    L5:
        return false;
    }

    public static final float fastCbrt(float r4) {
        float r0 = Float.intBitsToFloat(((int) ((((long) Float.floatToRawIntBits(r4)) & 8589934591L) / ((long) 3))) + 709952852);
        float r1 = r0 - ((r0 - (r4 / (r0 * r0))) * 0.33333334f);
        return r1 - ((r1 - (r4 / (r1 * r1))) * 0.33333334f);
    }

    public static final float floatFromBits(int r0) {
        return Float.intBitsToFloat(r0);
    }

    public static final double doubleFromBits(long r0) {
        return Double.longBitsToDouble(r0);
    }

    public static final int fastRoundToInt(float r0) {
        return Math.round(r0);
    }

    public static final int fastRoundToInt(double r0) {
        return (int) Math.round(r0);
    }

    public static /* synthetic */ FloatFloatPair computeCubicVerticalBounds$default(float r6, float r7, float r8, float r9, float[] r10, int r11, int r12, Object r13) {
        if ((r12 & 32) == 0) goto L6;
        r11 = 0;
    L6:
        return computeCubicVerticalBounds(r6, r7, r8, r9, r10, r11);
    }

    public static final FloatFloatPair computeCubicVerticalBounds(float r5, float r6, float r7, float r8, float[] r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "roots");
        float r0 = (r6 - r5) * 3.0f;
        float r2 = (r7 - r6) * 3.0f;
        float r3 = (r8 - r7) * 3.0f;
        int r1 = findQuadraticRoots(r0, r2, r3, r9, r10);
        float r4 = (r2 - r0) * 2.0f;
        float r11 = (r3 - r2) * 2.0f;
        float r12 = (-r4) / (r11 - r4);
        int r13 = r1 + access$writeValidRootInUnitRange(r12, r9, r10 + r1);
        float r14 = Math.min(r5, r8);
        float r15 = Math.max(r5, r8);
        int r16 = 0;
    L3:
        if (r16 >= r13) goto L6;
        float r17 = evaluateCubic(r5, r6, r7, r8, r9[r16]);
        r14 = Math.min(r14, r17);
        r15 = Math.max(r15, r17);
        r16 = r16 + 1;
        goto L3
    L6:
        return new FloatFloatPair(r14, r15);
    }

    static /* synthetic */ int findQuadraticRoots$default(float r0, float r1, float r2, float[] r3, int r4, int r5, Object r6) {
        if ((r5 & 16) == 0) goto L6;
        r4 = 0;
    L6:
        return findQuadraticRoots(r0, r1, r2, r3, r4);
    }

    private static final int findQuadraticRoots(float r17, float r18, float r19, float[] r20, int r21) {
        double r3 = r17;
        double r5 = r18;
        double r7 = r19;
        double r11 = r5 * 2.0d;
        double r13 = (r3 - r11) + r7;
        if (r13 == 0.0d) goto L13;
        double r8 = -Math.sqrt((r5 * r5) - (r7 * r3));
        double r4 = (-r3) + r5;
        int r1 = writeValidRootInUnitRange((float) ((-(r8 + r4)) / r13), r20, r21) + 0;
        int r15 = r1 + writeValidRootInUnitRange((float) ((r8 - r4) / r13), r20, r21 + r1);
        if (r15 <= 1) goto L16;
        float r2 = r20[r21];
        int r6 = r21 + 1;
        float r9 = r20[r6];
        if (r2 <= r9) goto L10;
        r20[r21] = r9;
        r20[r6] = r2;
        return r15;
    L10:
        if (r2 == r9) goto L19;
        return r15;
    L19:
        return r15 - 1;
    L16:
        return r15;
    L13:
        if (r5 != r7) goto L15;
        return 0;
    L15:
        return 0 + writeValidRootInUnitRange((float) ((r11 - r7) / (r11 - (r7 * 2.0d))), r20, r21);
    }

    private static final int findLineRoot(float r1, float r2, float[] r3, int r4) {
        return access$writeValidRootInUnitRange((-r1) / (r2 - r1), r3, r4);
    }

    static /* synthetic */ int findLineRoot$default(float r0, float r1, float[] r2, int r3, int r4, Object r5) {
        if ((r4 & 8) == 0) goto L6;
        r3 = 0;
    L6:
        return access$writeValidRootInUnitRange((-r0) / (r1 - r0), r2, r3);
    }

    private static final int writeValidRootInUnitRange(float r3, float[] r4, int r5) {
        float r0 = 0.0f;
        if (r3 < 0.0f) goto L5;
        r0 = 1.0f;
        if (r3 > 1.0f) goto L11;
    L13:
        r4[r5] = r3;
        return !Float.isNaN(r3) ? 1 : 0;
    L11:
        if (r3 <= 1.0000008f) goto L6;
    L7:
        r3 = Float.NaN;
    L6:
        r3 = r0;
        goto L13
    L5:
        if (r3 < (-8.34465E-7f)) goto L7;
        goto L6
    }

    public static final float findFirstCubicRoot(float r24, float r25, float r26, float r27) {
        double r3 = r24;
        double r5 = ((r3 - (((double) r25) * 2.0d)) + ((double) r26)) * 3.0d;
        double r11 = ((double) (r25 - r24)) * 3.0d;
        double r13 = (((double) (-r24)) + (((double) (r25 - r26)) * 3.0d)) + ((double) r27);
        boolean r15 = true;
        if (Math.abs(r13 - 0.0d) >= Epsilon) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == true) goto L9;
        double r6 = r5 / r13;
        double r12 = r11 / r13;
        double r4 = r3 / r13;
        double r14 = ((r12 * 3.0d) - (r6 * r6)) / 9.0d;
        double r7 = (((((2.0d * r6) * r6) * r6) - ((9.0d * r6) * r12)) + (r4 * 27.0d)) / 54.0d;
        double r16 = (r14 * r14) * r14;
        double r8 = (r7 * r7) + r16;
        double r9 = r6 / 3.0d;
        if (r8 >= 0.0d) goto L108;
        double r10 = Math.sqrt(-r16);
        double r17 = (-r7) / r10;
        if (r17 >= (-1.0d)) goto L65;
        r17 = -1.0d;
    L65:
        if (r17 <= 1.0d) goto L67;
        r17 = 1.0d;
    L67:
        double r18 = Math.acos(r17);
        double r0 = fastCbrt((float) r10) * 2.0f;
        float r19 = (float) ((Math.cos(r18 / 3.0d) * r0) - r9);
        if (r19 >= 0.0f) goto L74;
        if (r19 < (-8.34465E-7f)) goto L72;
        r19 = 0.0f;
    L79:
        if (Float.isNaN(r19) == true) goto L81;
        return r19;
    L81:
        float r20 = (float) ((Math.cos((Tau + r18) / 3.0d) * r0) - r9);
        if (r20 >= 0.0f) goto L88;
        if (r20 < (-8.34465E-7f)) goto L86;
        r20 = 0.0f;
    L93:
        if (Float.isNaN(r20) == true) goto L95;
        return r20;
    L95:
        float r1 = (float) ((r0 * Math.cos((r18 + 12.566370614359172d) / 3.0d)) - r9);
        if (r1 >= 0.0f) goto L102;
        if (r1 < (-8.34465E-7f)) goto L156;
        return 0.0f;
    L156:
        return Float.NaN;
    L102:
        if (r1 <= 1.0f) goto L107;
        if (r1 > 1.0000008f) goto L156;
        return 1.0f;
    L107:
        return r1;
    L86:
        r20 = Float.NaN;
        goto L93
    L88:
        if (r20 <= 1.0f) goto L93;
        if (r20 > 1.0000008f) goto L86;
        r20 = 1.0f;
    L72:
        r19 = Float.NaN;
        goto L79
    L74:
        if (r19 <= 1.0f) goto L79;
        if (r19 > 1.0000008f) goto L72;
        r19 = 1.0f;
        goto L79
    L108:
        if (r8 != 0.0d) goto L136;
        float r21 = -fastCbrt((float) r7);
        float r22 = (float) r9;
        float r23 = (2.0f * r21) - r22;
        if (r23 >= 0.0f) goto L116;
        if (r23 < (-8.34465E-7f)) goto L114;
        r23 = 0.0f;
    L121:
        if (Float.isNaN(r23) == true) goto L123;
        return r23;
    L123:
        float r28 = (-r21) - r22;
        if (r28 >= 0.0f) goto L130;
        if (r28 < (-8.34465E-7f)) goto L159;
        return 0.0f;
    L159:
        return Float.NaN;
    L130:
        if (r28 <= 1.0f) goto L135;
        if (r28 > 1.0000008f) goto L159;
        return 1.0f;
    L135:
        return r28;
    L114:
        r23 = Float.NaN;
        goto L121
    L116:
        if (r23 <= 1.0f) goto L121;
        if (r23 > 1.0000008f) goto L114;
        r23 = 1.0f;
        goto L121
    L136:
        double r29 = Math.sqrt(r8);
        float r30 = (float) (((double) (fastCbrt((float) ((-r7) + r29)) - fastCbrt((float) (r7 + r29)))) - r9);
        if (r30 >= 0.0f) goto L143;
        if (r30 < (-8.34465E-7f)) goto L162;
        return 0.0f;
    L162:
        return Float.NaN;
    L143:
        if (r30 <= 1.0f) goto L148;
        if (r30 > 1.0000008f) goto L162;
        return 1.0f;
    L148:
        return r30;
    L9:
        if (Math.abs(r5 - 0.0d) >= Epsilon) goto L11;
        boolean r31 = true;
    L12:
        if (r31 == true) goto L14;
        double r32 = Math.sqrt((r11 * r11) - ((4.0d * r5) * r3));
        double r33 = r5 * 2.0d;
        float r34 = (float) ((r32 - r11) / r33);
        if (r34 >= 0.0f) goto L39;
        if (r34 < (-8.34465E-7f)) goto L37;
        r34 = 0.0f;
    L44:
        if (Float.isNaN(r34) == true) goto L46;
        return r34;
    L46:
        float r35 = (float) (((-r11) - r32) / r33);
        if (r35 >= 0.0f) goto L53;
        if (r35 < (-8.34465E-7f)) goto L153;
        return 0.0f;
    L153:
        return Float.NaN;
    L53:
        if (r35 <= 1.0f) goto L58;
        if (r35 > 1.0000008f) goto L153;
        return 1.0f;
    L58:
        return r35;
    L37:
        r34 = Float.NaN;
        goto L44
    L39:
        if (r34 <= 1.0f) goto L44;
        if (r34 > 1.0000008f) goto L37;
        r34 = 1.0f;
        goto L44
    L14:
        if (Math.abs(r11 - 0.0d) < Epsilon) goto L17;
        r15 = false;
    L17:
        if (r15 == false) goto L19;
        return Float.NaN;
    L19:
        float r36 = (float) ((-r3) / r11);
        if (r36 >= 0.0f) goto L26;
        if (r36 < (-8.34465E-7f)) goto L150;
        return 0.0f;
    L150:
        return Float.NaN;
    L26:
        if (r36 <= 1.0f) goto L31;
        if (r36 > 1.0000008f) goto L150;
        return 1.0f;
    L31:
        return r36;
    L11:
        r31 = false;
        goto L12
    L5:
        r2 = false;
        goto L7
    }
}
