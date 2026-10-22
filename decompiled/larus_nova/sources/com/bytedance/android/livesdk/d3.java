package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.depend.model.live.StreamDataOptimizeConfig;

/* JADX INFO: loaded from: classes7.dex */
public final class d3 extends SettingKey<StreamDataOptimizeConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d3 f121931a = null;

    static {
        f121931a = new d3();
    }

    public d3() {
        super("live_stream_data_optimize_config", "直播streamdata解析复用优化配置", new StreamDataOptimizeConfig(), new StreamDataOptimizeConfig());
    }
}
