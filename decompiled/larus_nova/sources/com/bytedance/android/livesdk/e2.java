package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class e2 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e2 f123285a = null;

    static {
        f123285a = new e2();
    }

    public e2() {
        Boolean r100 = Boolean.FALSE;
        super("live_player_sei_json_cache_remove_optimize", "播放器Sei解析JSON缓存池清空方式优化", r100, r100);
    }
}
