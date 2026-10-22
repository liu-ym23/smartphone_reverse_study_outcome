package com.bytedance.android.livehostapi.business.depend.openplatform.dux;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.exifinterface.media.ExifInterface;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0003\"\"\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0002H\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"dp", "", ExifInterface.GPS_DIRECTION_TRUE, "", "getDp", "(Ljava/lang/Number;)I", "hostapp-api_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class DuxPopupNoticeConfigKt {
    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_android_livehostapi_business_depend_openplatform_dux_DuxPopupNoticeConfigKt_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static final /* synthetic */ <T extends Number> int getDp(T r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$dp");
        return MathKt.roundToInt(TypedValue.applyDimension(1, r100.floatValue(), INVOKEVIRTUAL_com_bytedance_android_livehostapi_business_depend_openplatform_dux_DuxPopupNoticeConfigKt_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())));
    }
}
