package com.google.android.material.color.utilities;

import java.util.HashMap;
import java.util.function.BiFunction;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public final class DynamicColor {
    public final Function<DynamicScheme, DynamicColor> background;
    public final Function<DynamicScheme, Double> chroma;
    private final HashMap<DynamicScheme, Hct> hctCache;
    public final Function<DynamicScheme, Double> hue;
    public final Function<DynamicScheme, Double> opacity;
    public final Function<DynamicScheme, Double> tone;
    public final Function<DynamicScheme, ToneDeltaConstraint> toneDeltaConstraint;
    public final Function<DynamicScheme, Double> toneMaxContrast;
    public final Function<DynamicScheme, Double> toneMinContrast;

    /* JADX INFO: renamed from: com.google.android.material.color.utilities.DynamicColor$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$android$material$color$utilities$TonePolarity = null;

        static {
            int[] r0 = new int[TonePolarity.values().length];
            $SwitchMap$com$google$android$material$color$utilities$TonePolarity = r0;
            r0[TonePolarity.DARKER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$google$android$material$color$utilities$TonePolarity[TonePolarity.LIGHTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$android$material$color$utilities$TonePolarity[TonePolarity.NO_PREFERENCE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static /* synthetic */ TonalPalette lambda$fromArgb$0(TonalPalette r0, DynamicScheme r1) {
        return r0;
    }

    static /* synthetic */ DynamicColor lambda$getTone$11(DynamicColor r0, DynamicScheme r1) {
        return r0;
    }

    static /* synthetic */ Double lambda$toneMinContrastDefault$16(Double r0) {
        return r0;
    }

    public DynamicColor(Function<DynamicScheme, Double> r2, Function<DynamicScheme, Double> r3, Function<DynamicScheme, Double> r4, Function<DynamicScheme, Double> r5, Function<DynamicScheme, DynamicColor> r6, Function<DynamicScheme, Double> r7, Function<DynamicScheme, Double> r8, Function<DynamicScheme, ToneDeltaConstraint> r9) {
        this.hctCache = new HashMap();
        this.hue = r2;
        this.chroma = r3;
        this.tone = r4;
        this.opacity = r5;
        this.background = r6;
        this.toneMinContrast = r7;
        this.toneMaxContrast = r8;
        this.toneDeltaConstraint = r9;
    }

    public static DynamicColor fromArgb(int r2) {
        final Hct r0 = Hct.fromInt(r2);
        final TonalPalette r3 = TonalPalette.fromInt(r2);
        return fromPalette(new DynamicColor$$ExternalSyntheticLambda6(r3), new DynamicColor$$ExternalSyntheticLambda7(r0));
    }

    static /* synthetic */ Double lambda$fromArgb$1(Hct r0, DynamicScheme r1) {
        return Double.valueOf(r0.getTone());
    }

    public static DynamicColor fromArgb(final int r1, Function<DynamicScheme, Double> r2) {
        return fromPalette(new DynamicColor$$ExternalSyntheticLambda17(r1), r2);
    }

    static /* synthetic */ TonalPalette lambda$fromArgb$2(int r0, DynamicScheme r1) {
        return TonalPalette.fromInt(r0);
    }

    public static DynamicColor fromArgb(final int r1, Function<DynamicScheme, Double> r2, Function<DynamicScheme, DynamicColor> r3) {
        return fromPalette(new DynamicColor$$ExternalSyntheticLambda16(r1), r2, r3);
    }

    static /* synthetic */ TonalPalette lambda$fromArgb$3(int r0, DynamicScheme r1) {
        return TonalPalette.fromInt(r0);
    }

    public static DynamicColor fromArgb(final int r1, Function<DynamicScheme, Double> r2, Function<DynamicScheme, DynamicColor> r3, Function<DynamicScheme, ToneDeltaConstraint> r4) {
        return fromPalette(new DynamicColor$$ExternalSyntheticLambda5(r1), r2, r3, r4);
    }

    static /* synthetic */ TonalPalette lambda$fromArgb$4(int r0, DynamicScheme r1) {
        return TonalPalette.fromInt(r0);
    }

    public static DynamicColor fromPalette(Function<DynamicScheme, TonalPalette> r1, Function<DynamicScheme, Double> r2) {
        return fromPalette(r1, r2, null, null);
    }

    public static DynamicColor fromPalette(Function<DynamicScheme, TonalPalette> r1, Function<DynamicScheme, Double> r2, Function<DynamicScheme, DynamicColor> r3) {
        return fromPalette(r1, r2, r3, null);
    }

    public static DynamicColor fromPalette(final Function<DynamicScheme, TonalPalette> r10, final Function<DynamicScheme, Double> r11, final Function<DynamicScheme, DynamicColor> r12, final Function<DynamicScheme, ToneDeltaConstraint> r13) {
        return new DynamicColor(new DynamicColor$$ExternalSyntheticLambda0(r10), new DynamicColor$$ExternalSyntheticLambda10(r10), r11, null, r12, new DynamicColor$$ExternalSyntheticLambda11(r11, r12, r13), new DynamicColor$$ExternalSyntheticLambda12(r11, r12, r13), r13);
    }

    static /* synthetic */ Double lambda$fromPalette$5(Function r0, DynamicScheme r1) {
        return Double.valueOf(((TonalPalette) r0.apply(r1)).getHue());
    }

    static /* synthetic */ Double lambda$fromPalette$6(Function r0, DynamicScheme r1) {
        return Double.valueOf(((TonalPalette) r0.apply(r1)).getChroma());
    }

    static /* synthetic */ Double lambda$fromPalette$7(Function r0, Function r1, Function r2, DynamicScheme r3) {
        return Double.valueOf(toneMinContrastDefault(r0, r1, r3, r2));
    }

    static /* synthetic */ Double lambda$fromPalette$8(Function r0, Function r1, Function r2, DynamicScheme r3) {
        return Double.valueOf(toneMaxContrastDefault(r0, r1, r3, r2));
    }

    public int getArgb(DynamicScheme r4) {
        int r0 = getHct(r4).toInt();
        Function<DynamicScheme, Double> r3 = this.opacity;
        if (r3 != null) goto L5;
        return r0;
    L5:
        int r5 = MathUtils.clampInt(0, 255, (int) Math.round(r3.apply(r4).doubleValue() * 255.0d));
        int r6 = r5 << 24;
        return r6 | (16777215 & r0);
    }

    public Hct getHct(DynamicScheme r8) {
        Hct r0 = this.hctCache.get(r8);
        if (r0 == null) goto L5;
        return r0;
    L5:
        Hct r1 = Hct.from(this.hue.apply(r8).doubleValue(), this.chroma.apply(r8).doubleValue(), getTone(r8));
        if (this.hctCache.size() <= 4) goto L8;
        this.hctCache.clear();
    L8:
        this.hctCache.put(r8, r1);
        return r1;
    }

    public double getTone(final DynamicScheme r16) {
        final double r2 = this.tone.apply(r16).doubleValue();
        boolean r5 = true;
        if (r16.contrastLevel >= 0.0d) goto L5;
        boolean r4 = true;
    L7:
        if (r16.contrastLevel == 0.0d) goto L13;
        double r3 = this.tone.apply(r16).doubleValue();
        if (r4 == false) goto L11;
        Function<DynamicScheme, Double> r6 = this.toneMinContrast;
    L12:
        r2 = r3 + ((r6.apply(r16).doubleValue() - r3) * Math.abs(r16.contrastLevel));
        goto L13
    L11:
        r6 = this.toneMaxContrast;
    L13:
        Function<DynamicScheme, DynamicColor> r7 = this.background;
        if (r7 != null) goto L16;
        final DynamicColor r8 = null;
    L17:
        final double r11 = 1.0d;
        if (r8 == null) goto L36;
        Function<DynamicScheme, DynamicColor> r9 = r8.background;
        if (r9 != null) goto L22;
    L24:
        r5 = false;
    L25:
        double r10 = Contrast.ratioOfTones(this.tone.apply(r16).doubleValue(), r8.tone.apply(r16).doubleValue());
        if (r4 == false) goto L31;
        double r12 = Contrast.ratioOfTones(this.toneMinContrast.apply(r16).doubleValue(), r8.toneMinContrast.apply(r16).doubleValue());
        if (r5 == false) goto L30;
        r11 = r12;
    L30:
        final double r13 = r10;
    L38:
        return calculateDynamicTone(r16, this.tone, new DynamicColor$$ExternalSyntheticLambda18(r16), new DynamicColor$$ExternalSyntheticLambda1(r2), new DynamicColor$$ExternalSyntheticLambda2(r8), this.toneDeltaConstraint, new DynamicColor$$ExternalSyntheticLambda3(r11), new DynamicColor$$ExternalSyntheticLambda4(r13));
    L31:
        double r14 = Contrast.ratioOfTones(this.toneMaxContrast.apply(r16).doubleValue(), r8.toneMaxContrast.apply(r16).doubleValue());
        if (r5 == false) goto L34;
        r11 = Math.min(r14, r10);
    L34:
        if (r5 == false) goto L36;
        r13 = Math.max(r14, r10);
        goto L38
    L22:
        if (r9.apply(r16) == null) goto L24;
    L36:
        r13 = 21.0d;
        goto L38
    L16:
        r8 = r7.apply(r16);
        goto L17
    L5:
        r4 = false;
        goto L7
    }

    static /* synthetic */ Double lambda$getTone$9(DynamicScheme r0, DynamicColor r1) {
        return Double.valueOf(r1.getTone(r0));
    }

    static /* synthetic */ Double lambda$getTone$10(double r0, Double r2, Double r3) {
        return Double.valueOf(r0);
    }

    static /* synthetic */ Double lambda$getTone$12(double r0, Double r2) {
        return Double.valueOf(r0);
    }

    static /* synthetic */ Double lambda$getTone$13(double r0, Double r2) {
        return Double.valueOf(r0);
    }

    public static double toneMinContrastDefault(final Function<DynamicScheme, Double> r8, final Function<DynamicScheme, DynamicColor> r9, final DynamicScheme r10, Function<DynamicScheme, ToneDeltaConstraint> r11) {
        return calculateDynamicTone(r10, r8, new DynamicColor$$ExternalSyntheticLambda13(r10), new DynamicColor$$ExternalSyntheticLambda14(r8, r10, r9), r9, r11, null, new DynamicColor$$ExternalSyntheticLambda15());
    }

    static /* synthetic */ Double lambda$toneMinContrastDefault$14(DynamicScheme r0, DynamicColor r1) {
        return r1.toneMinContrast.apply(r0);
    }

    static /* synthetic */ Double lambda$toneMinContrastDefault$15(Function r6, DynamicScheme r7, Function r8, Double r9, Double r10) {
        double r0 = ((Double) r6.apply(r7)).doubleValue();
        if (r9.doubleValue() < 7.0d) goto L6;
        r0 = contrastingTone(r10.doubleValue(), 4.5d);
    L20:
        return Double.valueOf(r0);
    L6:
        if (r9.doubleValue() < 3.0d) goto L8;
        r0 = contrastingTone(r10.doubleValue(), 3.0d);
        goto L20
    L8:
        if (r8 != null) goto L10;
    L16:
        boolean r11 = false;
    L17:
        if (r11 == false) goto L20;
        r0 = contrastingTone(r10.doubleValue(), r9.doubleValue());
        goto L20
    L10:
        if (r8.apply(r7) == null) goto L16;
        if (((DynamicColor) r8.apply(r7)).background == null) goto L16;
        if (((DynamicColor) r8.apply(r7)).background.apply(r7) == null) goto L16;
        r11 = true;
        goto L17
    }

    public static double toneMaxContrastDefault(Function<DynamicScheme, Double> r8, final Function<DynamicScheme, DynamicColor> r9, final DynamicScheme r10, Function<DynamicScheme, ToneDeltaConstraint> r11) {
        return calculateDynamicTone(r10, r8, new DynamicColor$$ExternalSyntheticLambda8(r10), new DynamicColor$$ExternalSyntheticLambda9(r9, r10), r9, r11, null, null);
    }

    static /* synthetic */ Double lambda$toneMaxContrastDefault$17(DynamicScheme r0, DynamicColor r1) {
        return r1.toneMaxContrast.apply(r0);
    }

    static /* synthetic */ Double lambda$toneMaxContrastDefault$18(Function r2, DynamicScheme r3, Double r4, Double r5) {
        if (r2 != null) goto L4;
    L10:
        boolean r6 = false;
    L12:
        if (r6 == false) goto L16;
        return Double.valueOf(contrastingTone(r5.doubleValue(), 7.0d));
    L16:
        return Double.valueOf(contrastingTone(r5.doubleValue(), Math.max(7.0d, r4.doubleValue())));
    L4:
        if (r2.apply(r3) == null) goto L10;
        if (((DynamicColor) r2.apply(r3)).background == null) goto L10;
        if (((DynamicColor) r2.apply(r3)).background.apply(r3) == null) goto L10;
        r6 = true;
        goto L12
    }

    public static double calculateDynamicTone(DynamicScheme r22, Function<DynamicScheme, Double> r23, Function<DynamicColor, Double> r24, BiFunction<Double, Double, Double> r25, Function<DynamicScheme, DynamicColor> r26, Function<DynamicScheme, ToneDeltaConstraint> r27, Function<Double, Double> r28, Function<Double, Double> r29) {
        double r5 = r23.apply(r22).doubleValue();
        if (r26 != null) goto L5;
        DynamicColor r0 = null;
    L6:
        if (r0 != null) goto L8;
        return r5;
    L8:
        double r7 = Contrast.ratioOfTones(r5, r0.tone.apply(r22).doubleValue());
        double r10 = r24.apply(r0).doubleValue();
        double r12 = r25.apply(Double.valueOf(r7), Double.valueOf(r10)).doubleValue();
        double r20 = Contrast.ratioOfTones(r10, r12);
        double r14 = 1.0d;
        if (r28 != null) goto L12;
    L15:
        if (r29 != null) goto L18;
    L16:
        double r16 = 21.0d;
    L21:
        double r1 = MathUtils.clampDouble(r14, r16, r20);
        if (r1 == r20) goto L25;
        r12 = contrastingTone(r10, r1);
    L25:
        Function<DynamicScheme, DynamicColor> r2 = r0.background;
        if (r2 != null) goto L28;
    L31:
        double r3 = enableLightForeground(r12);
    L33:
        return ensureToneDelta(r3, r5, r22, r27, r24);
    L28:
        if (r2.apply(r22) == null) goto L31;
        r3 = r12;
        goto L33
    L18:
        if (r29.apply(Double.valueOf(r7)) == null) goto L16;
        r16 = r29.apply(Double.valueOf(r7)).doubleValue();
        goto L21
    L12:
        if (r28.apply(Double.valueOf(r7)) == null) goto L15;
        r14 = r28.apply(Double.valueOf(r7)).doubleValue();
        goto L15
    L5:
        r0 = r26.apply(r22);
        goto L6
    }

    static double ensureToneDelta(double r8, double r10, DynamicScheme r12, Function<DynamicScheme, ToneDeltaConstraint> r13, Function<DynamicColor, Double> r14) {
        if (r13 != null) goto L4;
        ToneDeltaConstraint r15 = null;
    L5:
        if (r15 != null) goto L7;
        return r8;
    L7:
        double r0 = r15.delta;
        double r2 = r14.apply(r15.keepAway).doubleValue();
        double r4 = Math.abs(r8 - r2);
        if (r4 < r0) goto L10;
        return r8;
    L10:
        int r16 = AnonymousClass1.$SwitchMap$com$google$android$material$color$utilities$TonePolarity[r15.keepAwayPolarity.ordinal()];
        boolean r6 = true;
        if (r16 == 1) goto L37;
        if (r16 == 2) goto L35;
        if (r16 == 3) goto L18;
        return r8;
    L18:
        if (r10 <= r15.keepAway.tone.apply(r12).doubleValue()) goto L20;
        boolean r11 = true;
    L21:
        double r17 = Math.abs(r4 - r0);
        if (r11 == false) goto L27;
        if ((r8 + r17) <= 100.0d) goto L30;
    L29:
        r6 = false;
    L30:
        if (r6 == false) goto L33;
        return r8 + r17;
    L33:
        return r8 - r17;
    L27:
        if (r8 >= r17) goto L29;
    L20:
        r11 = false;
        goto L21
    L35:
        return MathUtils.clampDouble(0.0d, 100.0d, r2 - r0);
    L37:
        return MathUtils.clampDouble(0.0d, 100.0d, r2 + r0);
    L4:
        r15 = r13.apply(r12);
        goto L5
    }

    public static double contrastingTone(double r10, double r12) {
        double r0 = Contrast.lighterUnsafe(r10, r12);
        double r2 = Contrast.darkerUnsafe(r10, r12);
        double r4 = Contrast.ratioOfTones(r0, r10);
        double r6 = Contrast.ratioOfTones(r2, r10);
        if (tonePrefersLightForeground(r10) == false) goto L21;
        if (Math.abs(r4 - r6) < 0.1d) goto L7;
    L11:
        boolean r11 = false;
    L13:
        if (r4 < r12) goto L15;
    L19:
        return r0;
    L15:
        if (r4 >= r6) goto L19;
        if (r11 == true) goto L19;
        return r2;
    L7:
        if (r4 >= r12) goto L11;
        if (r6 >= r12) goto L11;
        r11 = true;
        goto L13
    L21:
        if (r6 >= r12) goto L25;
        if (r6 >= r4) goto L25;
        return r0;
    L25:
        return r2;
    }

    public static double enableLightForeground(double r1) {
        if (tonePrefersLightForeground(r1) == true) goto L5;
        return r1;
    L5:
        if (toneAllowsLightForeground(r1) == true) goto L9;
        return 49.0d;
    L9:
        return r1;
    }

    public static boolean tonePrefersLightForeground(double r2) {
        if (Math.round(r2) > 60) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean toneAllowsLightForeground(double r2) {
        if (Math.round(r2) > 49) goto L5;
        return true;
    L5:
        return false;
    }
}
