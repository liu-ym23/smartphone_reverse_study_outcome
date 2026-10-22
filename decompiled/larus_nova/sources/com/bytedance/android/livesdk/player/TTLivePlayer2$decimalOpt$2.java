package com.bytedance.android.livesdk.player;

import com.bytedance.android.livesdkapi.model.PlayerExtraRenderConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference0Impl;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class TTLivePlayer2$decimalOpt$2 extends PropertyReference0Impl {
    public TTLivePlayer2$decimalOpt$2(PlayerExtraRenderConfig r100) {
        super(r100, PlayerExtraRenderConfig.class, "decimalOpt", "getDecimalOpt()Z", 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return Boolean.valueOf(((PlayerExtraRenderConfig) this.receiver).getDecimalOpt());
    }
}
