package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.depend.model.live.SdkParamsOptimizeConfig;

/* JADX INFO: loaded from: classes7.dex */
public final class s2 extends SettingKey<SdkParamsOptimizeConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s2 f157856a = null;

    static {
        f157856a = new s2();
    }

    public s2() {
        super("live_sdk_params_optimize_config", "直播streamdata解析复用优化配置", new SdkParamsOptimizeConfig(), new SdkParamsOptimizeConfig());
    }
}
