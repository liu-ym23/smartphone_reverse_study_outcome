package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;

/* JADX INFO: loaded from: classes8.dex */
public final class z extends DynamicFactor<Integer> {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "live_factor_consume";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        IStrategyService r100 = (IStrategyService) jc1.k.f(IStrategyService.class);
        int r101 = -1;
        if (r100 == null) goto L10;
        LiveData r102 = r100.getFactor("factor_consume", -1, false, true);
        if (r102 == null) goto L10;
        Integer r103 = (Integer) r102.getValue();
        if (r103 == null) goto L10;
        r101 = r103.intValue();
    L10:
        return Integer.valueOf(r101);
    }

    public z() {
    }
}
