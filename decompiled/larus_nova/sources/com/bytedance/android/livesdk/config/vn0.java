package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class vn0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vn0 f121465a = null;

    static {
        f121465a = new vn0();
    }

    public vn0() {
        Boolean r100 = Boolean.TRUE;
        super("live_room_battle_voice_wave_mix_fix", "厅战合流说话状态修复", r100, r100);
    }
}
