package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class z2 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z2 f65469a = null;

    static {
        f65469a = new z2();
    }

    public z2() {
        Boolean r100 = Boolean.TRUE;
        super("live_multi_link_preview_interact_song_data_handler_lateinit_opt", "FeedViewInteractSongDataHandler里proxy未初始化修复", r100, r100);
    }
}
