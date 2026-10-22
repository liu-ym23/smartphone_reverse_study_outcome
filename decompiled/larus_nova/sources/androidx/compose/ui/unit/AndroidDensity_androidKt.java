package androidx.compose.ui.unit;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import androidx.compose.ui.unit.fontscaling.FontScaleConverter;
import androidx.compose.ui.unit.fontscaling.FontScaleConverterFactory;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"Density", "Landroidx/compose/ui/unit/Density;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "ui-unit"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidDensity_androidKt {
    public static final Density Density(Context r100) {
        float r101 = r100.getResources().getConfiguration().fontScale;
        float r102 = INVOKEVIRTUAL_androidx_compose_ui_unit_AndroidDensity_androidKt_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density;
        FontScaleConverter r103 = FontScaleConverterFactory.INSTANCE.forScale(r101);
        if (r103 != null) goto L6;
        r103 = new LinearFontScaleConverter(r101);
    L6:
        return new DensityWithConverter(r102, r101, r103);
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_compose_ui_unit_AndroidDensity_androidKt_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }
}
