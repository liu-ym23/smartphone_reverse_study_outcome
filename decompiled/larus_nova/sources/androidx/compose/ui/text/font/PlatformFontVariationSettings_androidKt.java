package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.fonts.FontVariationAxis;
import android.os.Build;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.util.ListUtilsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u001a'\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¢\u0006\u0002\u0010\n\u001a\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u000fH\u0002¨\u0006\u0010"}, d2 = {"toAndroidString", "", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "density", "Landroidx/compose/ui/unit/Density;", "weightAdjustment", "", "toAndroidArray", "", "Landroid/graphics/fonts/FontVariationAxis;", "(Landroidx/compose/ui/text/font/FontVariation$Settings;Landroidx/compose/ui/unit/Density;I)[Landroid/graphics/fonts/FontVariationAxis;", "getFontWeightAdjustment", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "coerceInWeight", "", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PlatformFontVariationSettings_androidKt {
    public static /* synthetic */ CharSequence a(Density r100, FontVariation.Setting r101) {
        return toAndroidString$lambda$0(r100, r101);
    }

    private static final float coerceInWeight(float r100) {
        return RangesKt.coerceIn(r100, 1.0f, 1000.0f);
    }

    public static final int getFontWeightAdjustment(Context r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        if (Build.VERSION.SDK_INT >= 31) goto L7;
        return 0;
    L7:
        if (r100.getResources().getConfiguration().fontWeightAdjustment != Integer.MAX_VALUE) goto L10;
        return 0;
    L10:
        return r100.getResources().getConfiguration().fontWeightAdjustment;
    }

    public static final String toAndroidString(FontVariation.Settings r100, Context r101) {
        return toAndroidString(r100, AndroidDensity_androidKt.Density(r101), getFontWeightAdjustment(r101));
    }

    private static final CharSequence toAndroidString$lambda$0(Density r100, FontVariation.Setting r101) {
        return "'" + r101.getAxisName() + "' " + r101.toVariationValue(r100);
    }

    public static final FontVariationAxis[] toAndroidArray(FontVariation.Settings r100, Density r101, int r102) {
        int r103 = 0;
        if (r102 != 0) goto L8;
        int r104 = r100.getSettings().size();
        FontVariationAxis[] r105 = new FontVariationAxis[r104];
    L5:
        if (r103 >= r104) goto L7;
        r105[r103] = new FontVariationAxis(((FontVariation.Setting) ListProtector.get(r100.getSettings(), r103)).getAxisName(), ((FontVariation.Setting) ListProtector.get(r100.getSettings(), r103)).toVariationValue(r101));
        r103 = r103 + 1;
        goto L5
    L7:
        return r105;
    L8:
        int r106 = r100.getSettings().size();
        int r107 = 0;
    L10:
        if (r107 >= r106) goto L15;
        if (Intrinsics.areEqual(((FontVariation.Setting) ListProtector.get(r100.getSettings(), r107)).getAxisName(), "wght") == true) goto L13;
        r107 = r107 + 1;
        goto L10
    L13:
        boolean r108 = true;
    L16:
        if (r108 == false) goto L18;
        int r109 = r100.getSettings().size();
    L19:
        FontVariationAxis[] r110 = new FontVariationAxis[r109];
    L20:
        if (r103 >= r109) goto L29;
        if (r103 != r100.getSettings().size()) goto L25;
        FontVariationAxis r111 = new FontVariationAxis("wght", coerceInWeight(r102 + 400.0f));
    L28:
        r110[r103] = r111;
        r103 = r103 + 1;
        goto L20
    L25:
        if (Intrinsics.areEqual(((FontVariation.Setting) ListProtector.get(r100.getSettings(), r103)).getAxisName(), "wght") == false) goto L27;
        r111 = new FontVariationAxis("wght", coerceInWeight(((FontVariation.Setting) ListProtector.get(r100.getSettings(), r103)).toVariationValue(r101) + r102));
        goto L28
    L27:
        r111 = new FontVariationAxis(((FontVariation.Setting) ListProtector.get(r100.getSettings(), r103)).getAxisName(), ((FontVariation.Setting) ListProtector.get(r100.getSettings(), r103)).toVariationValue(r101));
        goto L28
    L29:
        return r110;
    L18:
        r109 = r100.getSettings().size() + 1;
        goto L19
    L15:
        r108 = false;
        goto L16
    }

    public static final String toAndroidString(FontVariation.Settings r110, final Density r111, int r112) {
        if (r112 == 0) goto L4;
        List<FontVariation.Setting> r100 = r110.getSettings();
        int r101 = r100.size();
        int r102 = 0;
        String r103 = "";
        boolean r104 = false;
    L6:
        boolean r105 = true;
        if (r102 >= r101) goto L15;
        FontVariation.Setting r106 = (FontVariation.Setting) ListProtector.get(r100, r102);
        if (Intrinsics.areEqual(r106.getAxisName(), "wght") == false) goto L11;
        float r107 = coerceInWeight(r106.toVariationValue(r111) + r112);
    L12:
        if (r102 == 0) goto L14;
        r103 = r103 + ',';
    L14:
        r103 = r103 + '\'' + r106.getAxisName() + "' " + r107;
        r102 = r102 + 1;
        r104 = r105;
        goto L6
    L11:
        r105 = r104;
        r107 = r106.toVariationValue(r111);
        goto L12
    L15:
        if (r104 == true) goto L24;
        float r113 = coerceInWeight(r112 + 400.0f);
        if ((!r110.getSettings().isEmpty()) == false) goto L20;
        r103 = r103 + ',';
    L20:
        return r103 + "'wght' " + r113;
    L24:
        return r103;
    L4:
        return ListUtilsKt.fastJoinToString$default(r110.getSettings(), null, null, null, 0, null, new g(r111), 31, null);
    }
}
