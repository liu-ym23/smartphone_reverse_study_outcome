package com.bytedance.android.ec.search.host.impl;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostRouterService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class l implements ITradeSearchHostRouterService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f48178a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f48179b = null;

    public l() {
    }

    static {
        f48178a = new l();
        f48179b = LazyKt.lazy(new k());
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostRouterService
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostRouterService
    public final void openSchema(Context r100, String r101) {
        jj.a r102 = (jj.a) f48179b.getValue();
        if (r102 == null) goto L6;
        r102.openSchema(r100, r101);
        return;
    }
}
