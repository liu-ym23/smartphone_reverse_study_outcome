package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveSwitchAccountConfig;

/* JADX INFO: loaded from: classes7.dex */
public final class e3 extends SSettingKey<LiveSwitchAccountConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e3 f123286a = null;

    static {
        f123286a = new e3();
    }

    public e3() {
        super("live_switch_account_config", "是否开启直播间切换账号能力", new LiveSwitchAccountConfig(), new LiveSwitchAccountConfig());
    }
}
