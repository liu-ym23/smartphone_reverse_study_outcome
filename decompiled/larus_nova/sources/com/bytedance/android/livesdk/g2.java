package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class g2 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g2 f125379a = null;

    static {
        f125379a = new g2();
    }

    public g2() {
        Boolean r100 = Boolean.FALSE;
        super("live_player_sei_json_optimize", "播放器Sei解析JSON优化", r100, r100);
    }
}
