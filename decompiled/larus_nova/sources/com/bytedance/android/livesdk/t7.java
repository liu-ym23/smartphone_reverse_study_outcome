package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class t7 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t7 f158510a = null;

    static {
        f158510a = new t7();
    }

    public t7() {
        super("live_strategy_setting", "开启 一种支持直播策略平台因子的SettingKey", Boolean.FALSE, Boolean.TRUE);
    }
}
