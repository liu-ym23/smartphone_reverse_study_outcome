package android.content.res.stepostheme;

import android.graphics.Typeface;
import android.os.StepOSCtsUtils;
import android.os.SystemProperties;
import android.util.Log;
import android.util.Slog;
import java.io.File;

/* loaded from: classes.dex */
public class StepOSFontsHelper {
    private static Typeface mWeightTypeface = null;
    private static final String sANDROID_R_FONT_PATH = "data/customizecenter/font";
    private static final String sANDROID_R_OTF_FONT_PATH = "data/customizecenter/font/steposFont.otf";
    private static final String sANDROID_R_TTF_FONT_PATH = "data/customizecenter/font/steposFont.ttf";
    private static final String TAG = "StepOSFontsHelper";
    static final boolean DEBUG = Log.isLoggable(TAG, 3);
    private static String curTypefacePath = null;
    private static Typeface sStepOSDefaultTypeface = null;
    private static boolean mCreated = false;

    private static void generateNewTypeface() {
        try {
            File customFontFile = new File(sANDROID_R_TTF_FONT_PATH);
            if (customFontFile.exists()) {
                curTypefacePath = sANDROID_R_TTF_FONT_PATH;
                sStepOSDefaultTypeface = Typeface.createFromFile(customFontFile);
            } else {
                File customFontFile2 = new File(sANDROID_R_OTF_FONT_PATH);
                if (customFontFile2.exists()) {
                    curTypefacePath = sANDROID_R_OTF_FONT_PATH;
                    sStepOSDefaultTypeface = Typeface.createFromFile(customFontFile2);
                } else {
                    curTypefacePath = null;
                    sStepOSDefaultTypeface = null;
                }
            }
            mCreated = true;
        } catch (Exception e) {
            Slog.e(TAG, e.getMessage());
        }
    }

    public static boolean isDefaultTypeface(Typeface curTypeface) {
        return curTypeface == null || !(curTypeface.getSystemFontFamilyName() == null || Typeface.DEFAULT == null || !curTypeface.getSystemFontFamilyName().equals(Typeface.DEFAULT.getSystemFontFamilyName())) || (!(curTypeface.getSystemFontFamilyName() == null || Typeface.DEFAULT_BOLD == null || !curTypeface.getSystemFontFamilyName().equals(Typeface.DEFAULT_BOLD.getSystemFontFamilyName())) || "sans-serif-medium".equals(curTypeface.getSystemFontFamilyName()) || "sans-serif".equals(curTypeface.getSystemFontFamilyName()) || "serif".equals(curTypeface.getSystemFontFamilyName()) || "monospace".equals(curTypeface.getSystemFontFamilyName()) || Typeface.isSystemTypeface(curTypeface));
    }

    public static Typeface getStepOSTypeface() {
        if (!mCreated && sStepOSDefaultTypeface == null && !StepOSCtsUtils.isCtsRunning()) {
            generateNewTypeface();
        }
        return sStepOSDefaultTypeface;
    }

    public static void cleanStepOSTypeface() {
        curTypefacePath = null;
        sStepOSDefaultTypeface = null;
        mCreated = false;
    }

    public static boolean hasStepOSTypeface() {
        return getStepOSTypeface() != null;
    }

    public static String getCurStepOSTypefacePath() {
        return curTypefacePath;
    }

    public static boolean isVariationFontType(Typeface typeface) {
        if (!StepOSCtsUtils.isCtsRunning()) {
            boolean isVariation = SystemProperties.getBoolean("persist.sys.variation_font_state", false);
            if (!isVariation) {
                return false;
            }
            if (typeface == mWeightTypeface && typeface != null) {
                return false;
            }
            if (typeface == null || typeface == Typeface.DEFAULT || typeface == Typeface.DEFAULT_BOLD || typeface == Typeface.SANS_SERIF || typeface == Typeface.SERIF) {
                return true;
            }
        }
        return false;
    }

    public static Typeface getVariationTypeface(Typeface typeface) {
        int fontWeightAdjustment = SystemProperties.getInt("persist.sys.variation_font_weight", 0);
        if (fontWeightAdjustment == 0 || ((typeface != null && typeface.isWeightAdjustmentTypeface()) || StepOSCtsUtils.isCtsRunning())) {
            return typeface;
        }
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        int newWeight = Math.min(Math.max(typeface.getWeight() + fontWeightAdjustment, 1), 1000);
        boolean italic = (typeface.getStyle() & 2) != 0;
        Typeface tf = Typeface.create(typeface, newWeight, italic);
        tf.setWeightAdjustment(true);
        return tf;
    }
}
