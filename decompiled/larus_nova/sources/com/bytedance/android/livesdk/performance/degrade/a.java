package com.bytedance.android.livesdk.performance.degrade;

import com.bytedance.android.livesdk.performance.config.LiveBatteryStrategyConfig;
import com.bytedance.android.livesdkapi.strategy.StrategyConvertHelper;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements ObservableOnSubscribe<LiveBatteryStrategyConfig> {
    public a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<LiveBatteryStrategyConfig> r100) throws Exception {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        r100.onNext(StrategyConvertHelper.getObjectStrategyValue("live_battery_performance_config", new LiveBatteryStrategyConfig(), true, true));
    }
}
