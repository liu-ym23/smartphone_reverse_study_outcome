package com.bytedance.android.ec.store.status;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class DefaultStoreTadLoadingStatusView extends d {
    public final Map<? extends b, c<? extends View>> a() {
        return MapsKt.mapOf(TuplesKt.to(b.c.f48653a, new c(new DefaultStoreTadLoadingStatusView$provideImpl$1(this), null, 6)));
    }

    public DefaultStoreTadLoadingStatusView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }
}
