package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.LiveInnerCheckLiveConfig;

/* JADX INFO: loaded from: classes7.dex */
public final class x0 extends SettingKey<LiveInnerCheckLiveConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x0 f162533a = null;

    static {
        f162533a = new x0();
    }

    public x0() {
        super("live_inner_check_live_config", "直播内流探活配置", new LiveInnerCheckLiveConfig(), new LiveInnerCheckLiveConfig());
    }
}
