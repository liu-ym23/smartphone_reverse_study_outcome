package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;

/* JADX INFO: loaded from: classes8.dex */
public final class m extends DynamicFactor<Integer> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f123169b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "live_component_strategy_experiment";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
    }

    public m() {
        this.f123169b = r52.y.f536286a.getValue();
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        return this.f123169b;
    }
}
