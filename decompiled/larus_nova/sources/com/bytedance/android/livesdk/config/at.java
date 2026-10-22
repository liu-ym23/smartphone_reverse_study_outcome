package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class at extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final at f119817a = null;

    static {
        f119817a = new at();
    }

    public at() {
        Boolean r100 = Boolean.FALSE;
        super("live_enable_server_merge_stream_for_multilink_game", "多人场景小玩法是否启用全链路服务端合流", r100, r100, false);
    }
}
