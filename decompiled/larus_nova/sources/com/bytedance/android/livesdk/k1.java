package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.LiveMgInstantPlayConfig;

/* JADX INFO: loaded from: classes7.dex */
public final class k1 extends SSettingKey<LiveMgInstantPlayConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k1 f142262a = null;

    static {
        f142262a = new k1();
    }

    public k1() {
        super("live_mg_instant_play_config", "小游戏新增用户即看即玩主播在玩场景能力", new LiveMgInstantPlayConfig(), new LiveMgInstantPlayConfig());
    }
}
