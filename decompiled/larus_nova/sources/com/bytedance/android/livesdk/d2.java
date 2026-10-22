package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class d2 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d2 f121930a = null;

    static {
        f121930a = new d2();
    }

    public d2() {
        Boolean r100 = Boolean.FALSE;
        super("live_player_sei_cache_optimize", "播放器Sei缓存池优化", r100, r100);
    }
}
