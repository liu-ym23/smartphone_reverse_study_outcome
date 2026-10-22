package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class f2 extends SettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f2 f123400a = null;

    static {
        f123400a = new f2();
    }

    public f2() {
        super("live_player_sei_json_cache_size", "播放器Sei解析JSON缓存池大小", 20, 20);
    }
}
