package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;

/* JADX INFO: loaded from: classes8.dex */
public final class c0 extends DynamicFactor<Integer> {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "lucky_bag_strategy_user";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        IStrategyService r100 = (IStrategyService) jc1.k.f(IStrategyService.class);
        ?? r101 = 0;
        r101 = 0;
        r101 = 0;
        if (r100 == null) goto L10;
        LiveData r102 = IStrategyService.a.a(r100, "lucky_bag_strategy_user", Boolean.FALSE, false, 12);
        if (r102 == null) goto L10;
        Boolean r103 = (Boolean) r102.getValue();
        if (r103 == null) goto L10;
        r101 = r103.booleanValue();
    L10:
        return Integer.valueOf(r101);
    }

    public c0() {
    }
}
