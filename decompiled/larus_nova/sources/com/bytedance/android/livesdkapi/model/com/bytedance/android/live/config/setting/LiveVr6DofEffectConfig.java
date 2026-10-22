package com.bytedance.android.livesdkapi.model.com.bytedance.android.live.config.setting;

import com.bytedance.android.livesdk.g8;
import kotlin.Metadata;
import rf2.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/live/config/setting/LiveVr6DofEffectConfig;", "", "()V", "disable", "", "getDisable", "()Z", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveVr6DofEffectConfig {
    public static final LiveVr6DofEffectConfig INSTANCE = null;

    private LiveVr6DofEffectConfig() {
    }

    static {
        INSTANCE = new LiveVr6DofEffectConfig();
    }

    public final boolean getDisable() {
        if (a.a() == false) goto L7;
        return true;
    L7:
        return g8.f125385a.getValue().booleanValue();
    }
}
