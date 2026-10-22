package com.bytedance.android.shopping.store.status;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.store.status.c;
import com.bytedance.android.ec.store.status.d;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class ECShopAggregatePageLoadingStatusView extends d {
    public final Map<? extends com.bytedance.android.ec.store.status.b, c<? extends View>> a() {
        return MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.store.status.b.c.f48653a, new c(new ECShopAggregatePageLoadingStatusView$provideImpl$1(this), null, 6)));
    }

    public ECShopAggregatePageLoadingStatusView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }
}
