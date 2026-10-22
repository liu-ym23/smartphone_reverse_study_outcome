package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class i1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i1 f65321a = null;

    static {
        f65321a = new i1();
    }

    public i1() {
        Boolean r100 = Boolean.TRUE;
        super("live_external_fragment_state_fix", "fix接入层fragment状态异常问题", r100, r100, true);
    }
}
