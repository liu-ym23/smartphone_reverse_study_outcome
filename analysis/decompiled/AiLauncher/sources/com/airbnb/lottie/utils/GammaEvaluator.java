package com.airbnb.lottie.utils;

/* loaded from: classes.dex */
public class GammaEvaluator {
    private static float EOCF_sRGB(float f10) {
        return f10 <= 0.04045f ? f10 / 12.92f : (float) Math.pow((f10 + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    private static float OECF_sRGB(float f10) {
        return f10 <= 0.0031308f ? f10 * 12.92f : (float) ((Math.pow(f10, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static int evaluate(float f10, int i10, int i11) {
        if (i10 == i11 || f10 <= 0.0f) {
            return i10;
        }
        if (f10 >= 1.0f) {
            return i11;
        }
        float f11 = ((i10 >> 24) & 255) / 255.0f;
        float fEOCF_sRGB = EOCF_sRGB(((i10 >> 16) & 255) / 255.0f);
        float fEOCF_sRGB2 = EOCF_sRGB(((i10 >> 8) & 255) / 255.0f);
        float fEOCF_sRGB3 = EOCF_sRGB((i10 & 255) / 255.0f);
        float fEOCF_sRGB4 = EOCF_sRGB(((i11 >> 16) & 255) / 255.0f);
        float f12 = f11 + (((((i11 >> 24) & 255) / 255.0f) - f11) * f10);
        float fEOCF_sRGB5 = fEOCF_sRGB2 + ((EOCF_sRGB(((i11 >> 8) & 255) / 255.0f) - fEOCF_sRGB2) * f10);
        float fEOCF_sRGB6 = fEOCF_sRGB3 + (f10 * (EOCF_sRGB((i11 & 255) / 255.0f) - fEOCF_sRGB3));
        return (Math.round(OECF_sRGB(fEOCF_sRGB + ((fEOCF_sRGB4 - fEOCF_sRGB) * f10)) * 255.0f) << 16) | (Math.round(f12 * 255.0f) << 24) | (Math.round(OECF_sRGB(fEOCF_sRGB5) * 255.0f) << 8) | Math.round(OECF_sRGB(fEOCF_sRGB6) * 255.0f);
    }
}
