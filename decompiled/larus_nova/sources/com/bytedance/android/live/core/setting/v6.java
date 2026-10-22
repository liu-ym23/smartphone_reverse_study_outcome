package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class v6 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v6 f65441a = null;

    static {
        f65441a = new v6();
    }

    public v6() {
        Boolean r100 = Boolean.TRUE;
        super("player_consume_first_layout_sei", "播放器使用layoutSEI", r100, r100);
    }
}
