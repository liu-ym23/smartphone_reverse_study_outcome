package com.bytedance.android.livesdk.config;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class wj extends SSettingKey<List<? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final wj f121530a = null;

    static {
        f121530a = new wj();
    }

    public wj() {
        super("live_change_room_reuse_player_white_list", "直播进房换房复用播放器场景名单", new ArrayList(), new ArrayList());
    }
}
