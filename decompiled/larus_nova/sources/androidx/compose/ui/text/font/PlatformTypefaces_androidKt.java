package androidx.compose.ui.text.font;

import android.content.Context;
import android.os.Build;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\u001a \u0010\u0002\u001a\u0004\u0018\u00010\u0003*\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0001¨\u0006\r"}, d2 = {"PlatformTypefaces", "Landroidx/compose/ui/text/font/PlatformTypefaces;", "setFontVariationSettings", "Landroid/graphics/Typeface;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getWeightSuffixForFallbackFamilyName", "", "name", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PlatformTypefaces_androidKt {
    public static final PlatformTypefaces PlatformTypefaces() {
        if (Build.VERSION.SDK_INT < 28) goto L6;
        return new PlatformTypefacesApi28();
    L6:
        return new PlatformTypefacesApi();
    }

    public static final String getWeightSuffixForFallbackFamilyName(String r100, FontWeight r101) {
        int r102 = r101.getWeight() / 100;
        boolean r103 = true;
        if (r102 < 0) goto L6;
        if (r102 >= 2) goto L6;
        boolean r104 = true;
    L7:
        if (r104 == false) goto L10;
        return r100 + "-thin";
    L10:
        if (2 > r102) goto L13;
        if (r102 >= 4) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == true) goto L37;
        if (r102 != 4) goto L19;
        return r100;
    L19:
        if (r102 != 5) goto L22;
        return r100 + "-medium";
    L22:
        if (6 > r102) goto L25;
        if (r102 >= 8) goto L25;
        boolean r106 = true;
    L26:
        if (r106 == true) goto L41;
        if (8 <= r102) goto L30;
    L32:
        r103 = false;
    L33:
        if (r103 == true) goto L35;
        return r100;
    L35:
        return r100 + "-black";
    L30:
        if (r102 >= 11) goto L32;
    L41:
        return r100;
    L25:
        r106 = false;
        goto L26
    L37:
        return r100 + "-light";
    L13:
        r105 = false;
    L6:
        r104 = false;
        goto L7
    }

    public static final android.graphics.Typeface setFontVariationSettings(android.graphics.Typeface r100, FontVariation.Settings r101, Context r102) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return r100;
    L5:
        return TypefaceCompatApi26.INSTANCE.setFontVariationSettings(r100, r101, r102);
    }
}
