package com.bytedance.android.live.browser.utils;

import com.bytedance.android.annie.service.appruntime.DegradeStatus;
import com.bytedance.android.livesdkapi.performance.BasePerformanceStrategyTask;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyMonitor;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a extends BasePerformanceStrategyTask {
    @Override // com.bytedance.android.livesdkapi.performance.BasePerformanceStrategyTask
    public final boolean onTriggerEnhance(int r100, Map<String, String> r101, IPerformanceStrategyMonitor r102) {
        Intrinsics.checkNotNullParameter(r101, "basePerformanceInfo");
        Intrinsics.checkNotNullParameter(r102, "monitor");
        return false;
    }

    public a() {
    }

    @Override // com.bytedance.android.livesdkapi.performance.BasePerformanceStrategyTask
    public final void onTriggerOrigin(Map<String, String> r100, IPerformanceStrategyMonitor r101) {
        Intrinsics.checkNotNullParameter(r100, "basePerformanceInfo");
        Intrinsics.checkNotNullParameter(r101, "monitor");
        int r102 = y8.d.f566654a;
        y8.d.b(DegradeStatus.liveDegrade);
    }

    @Override // com.bytedance.android.livesdkapi.performance.BasePerformanceStrategyTask
    public final boolean onTriggerDegrade(int r100, Map<String, String> r101, IPerformanceStrategyMonitor r102) {
        Intrinsics.checkNotNullParameter(r101, "basePerformanceInfo");
        Intrinsics.checkNotNullParameter(r102, "monitor");
        int r103 = y8.d.f566654a;
        y8.d.a(DegradeStatus.liveDegrade, r100, 4);
        return false;
    }
}
