package com.android.ttcjpaysdk.thirdparty.voiceprint.common;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0001¨\u0006\u0005"}, d2 = {"dp2px", "", "Landroid/content/Context;", "dp", "Landroid/view/View;", "bdpay-voiceprint_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CommonKt {
    public static DisplayMetrics INVOKEVIRTUAL_com_android_ttcjpaysdk_thirdparty_voiceprint_common_CommonKt_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static final float dp2px(Context r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return TypedValue.applyDimension(1, r101, INVOKEVIRTUAL_com_android_ttcjpaysdk_thirdparty_voiceprint_common_CommonKt_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()));
    }

    public static final float dp2px(View r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return dp2px(r100.getContext(), r101);
    }
}
