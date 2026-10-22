package com.google.android.material.color.utilities;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicScheme {
    public final double contrastLevel;
    public final TonalPalette errorPalette;
    public final boolean isDark;
    public final TonalPalette neutralPalette;
    public final TonalPalette neutralVariantPalette;
    public final TonalPalette primaryPalette;
    public final TonalPalette secondaryPalette;
    public final int sourceColorArgb;
    public final Hct sourceColorHct;
    public final TonalPalette tertiaryPalette;
    public final Variant variant;

    public DynamicScheme(Hct r2, Variant r3, boolean r4, double r5, TonalPalette r7, TonalPalette r8, TonalPalette r9, TonalPalette r10, TonalPalette r11) {
        this.sourceColorArgb = r2.toInt();
        this.sourceColorHct = r2;
        this.variant = r3;
        this.isDark = r4;
        this.contrastLevel = r5;
        this.primaryPalette = r7;
        this.secondaryPalette = r8;
        this.tertiaryPalette = r9;
        this.neutralPalette = r10;
        this.neutralVariantPalette = r11;
        this.errorPalette = TonalPalette.fromHueAndChroma(25.0d, 84.0d);
    }

    public static double getRotatedHue(Hct r8, double[] r9, double[] r10) {
        double r0 = r8.getHue();
        int r3 = 0;
        if (r10.length == 1) goto L5;
        int r11 = r9.length;
    L8:
        if (r3 > (r11 - 2)) goto L16;
        double r4 = r9[r3];
        int r2 = r3 + 1;
        double r6 = r9[r2];
        if (r4 >= r0) goto L15;
        if (r0 >= r6) goto L15;
        return MathUtils.sanitizeDegreesDouble(r0 + r10[r3]);
    L15:
        r3 = r2;
        goto L8
    L16:
        return r0;
    L5:
        return MathUtils.sanitizeDegreesDouble(r0 + r10[0]);
    }
}
