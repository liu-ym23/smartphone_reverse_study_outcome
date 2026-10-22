package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class u6 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u6 f158616a = null;

    static {
        f158616a = new u6();
    }

    public u6() {
        Boolean r100 = Boolean.TRUE;
        super("live_player_read_phone_state_limit", "livesdk_live_player合规权限限制开关", r100, r100);
    }
}
