package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.RoomCountMemberLimitConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class xa extends SSettingKey<RoomCountMemberLimitConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final xa f121587a = null;

    static {
        f121587a = new xa();
    }

    public xa() {
        super("LIVE_ANCHOR_AUDIENCE_CNT_LIMIT_CONFIG", "房间人数上限功能是否开启", new RoomCountMemberLimitConfig(null, null, null, 7, null), new RoomCountMemberLimitConfig(null, null, null, 7, null), true);
    }
}
