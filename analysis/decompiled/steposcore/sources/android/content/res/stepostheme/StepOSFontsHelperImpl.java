package android.content.res.stepostheme;

import android.graphics.Typeface;

/* loaded from: classes.dex */
public class StepOSFontsHelperImpl implements IStepOSFontsHelperExt {
    public Typeface getDefaultFromStyle(int style) {
        if (StepOSFontsHelper.hasStepOSTypeface()) {
            return StepOSFontsHelper.getStepOSTypeface();
        }
        return null;
    }

    public Typeface replaceTypeface(Typeface typeface) {
        if (StepOSFontsHelper.hasStepOSTypeface() && StepOSFontsHelper.isDefaultTypeface(typeface)) {
            return StepOSFontsHelper.getStepOSTypeface();
        }
        if (StepOSFontsHelper.isDefaultTypeface(typeface)) {
            return StepOSFontsHelper.getVariationTypeface(typeface);
        }
        return typeface;
    }

    public boolean isDefaultTypeface(Typeface curTypeface) {
        return StepOSFontsHelper.isDefaultTypeface(curTypeface);
    }

    public Typeface getStepOSTypeface() {
        return StepOSFontsHelper.getStepOSTypeface();
    }

    public void cleanStepOSTypeface() {
        StepOSFontsHelper.cleanStepOSTypeface();
    }

    public boolean hasStepOSTypeface() {
        return StepOSFontsHelper.hasStepOSTypeface();
    }

    public String getCurStepOSTypefacePath() {
        return StepOSFontsHelper.getCurStepOSTypefacePath();
    }

    public boolean isVariationFontType(Typeface typeface) {
        return StepOSFontsHelper.isVariationFontType(typeface);
    }

    public Typeface getVariationTypeface(Typeface typeface) {
        return StepOSFontsHelper.getVariationTypeface(typeface);
    }
}
