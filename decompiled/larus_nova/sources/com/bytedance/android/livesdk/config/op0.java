package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class op0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final op0 f120923a = null;

    static {
        f120923a = new op0();
    }

    public op0() {
        Boolean r100 = Boolean.FALSE;
        super("live_saas_room_fight_public_stream_switch_to_single_view", "saas厅战公共流走单view", r100, r100);
    }
}
