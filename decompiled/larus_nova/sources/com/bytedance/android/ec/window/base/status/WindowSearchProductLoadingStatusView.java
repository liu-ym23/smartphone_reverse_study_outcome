package com.bytedance.android.ec.window.base.status;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class WindowSearchProductLoadingStatusView extends e {
    public final Map<? extends c, d<? extends View>> a() {
        return MapsKt.mapOf(TuplesKt.to(c.d.f49705a, new d(new WindowSearchProductLoadingStatusView$provideImpl$1(this), null, null)));
    }

    public WindowSearchProductLoadingStatusView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }
}
