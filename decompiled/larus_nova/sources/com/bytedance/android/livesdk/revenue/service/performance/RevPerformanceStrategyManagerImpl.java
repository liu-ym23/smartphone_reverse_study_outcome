package com.bytedance.android.livesdk.revenue.service.performance;

import com.bytedance.android.livesdk.config.e81;
import com.bytedance.android.livesdk.config.k91;
import com.bytedance.android.livesdk.config.zy0;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.bytedance.android.scope.o;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class RevPerformanceStrategyManagerImpl implements d, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f157421a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.revenue.service.performance.d
    public final boolean Jc() {
        return ((k91) com.bytedance.android.live.liveinteract.f.b(zy0.f121801a)).a();
    }

    @Override // com.bytedance.android.livesdk.revenue.service.performance.d
    public final int getCurrentPerformanceLevel() {
        return ((IPerformanceStrategyManager) this.f157421a.getValue()).getCurrentPerformanceLevel();
    }

    @Override // com.bytedance.android.livesdk.revenue.service.performance.d
    public final long lg() {
        return ((Number) com.bytedance.android.live.liveinteract.f.b(e81.f120100f)).intValue();
    }

    public RevPerformanceStrategyManagerImpl() {
        this.f157421a = LazyKt.lazy(RevPerformanceStrategyManagerImpl$service$2.INSTANCE);
    }

    @Override // com.bytedance.android.livesdk.revenue.service.performance.d
    public final boolean canLoad(int r100) {
        return ((IPerformanceStrategyManager) this.f157421a.getValue()).canLoad(532);
    }

    @Override // com.bytedance.android.livesdk.revenue.service.performance.d
    public final void unregisterPerformanceStrategyTask(int r100) {
        ((IPerformanceStrategyManager) this.f157421a.getValue()).unregisterPerformanceStrategyTask(r100);
    }

    @Override // com.bytedance.android.livesdk.revenue.service.performance.d
    public final void e6(int r100, lq2.b r101) {
        Intrinsics.checkNotNullParameter(r101, "performanceStrategyTask");
        ((IPerformanceStrategyManager) this.f157421a.getValue()).registerPerformanceStrategyTask(r100, new lq2.a(r101));
    }
}
