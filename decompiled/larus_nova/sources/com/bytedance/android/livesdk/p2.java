package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.LiveRoomFeatureConfig;

/* JADX INFO: loaded from: classes7.dex */
public final class p2 extends SettingKey<LiveRoomFeatureConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p2 f154190a = null;

    static {
        f154190a = new p2();
    }

    public p2() {
        super("live_room_feature_config", "策略平台-实时特征", new LiveRoomFeatureConfig(), new LiveRoomFeatureConfig());
    }
}
