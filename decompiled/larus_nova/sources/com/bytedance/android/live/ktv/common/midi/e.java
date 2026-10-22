package com.bytedance.android.live.ktv.common.midi;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class e {
    public static final d a(View r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$createFrescoPlayOnceControllerListener");
        Intrinsics.checkNotNullParameter(r101, WidgetCostModule.TYPE_ON_START);
        return new d(r100, r101);
    }

    public static final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ALogger.d("midiEnhance_".concat(r100), r101);
    }
}
