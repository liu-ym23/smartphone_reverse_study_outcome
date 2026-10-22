package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class w6 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w6 f65449a = null;

    static {
        f65449a = new w6();
    }

    public w6() {
        Boolean r100 = Boolean.FALSE;
        super("player_consume_first_sei_fix", "播放器首帧SEI消费fix", r100, r100);
    }
}
