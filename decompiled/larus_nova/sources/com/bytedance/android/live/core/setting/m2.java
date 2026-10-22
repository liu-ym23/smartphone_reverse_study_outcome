package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class m2 extends SSettingKey<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m2 f65357a = null;

    static {
        f65357a = new m2();
    }

    public m2() {
        super("live_match_room_progress_max_duration", "赛事直播进度条最大拖动范围ms", 10800000L, 10800000L);
    }
}
