package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class w1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w1 f65444a = null;

    static {
        f65444a = new w1();
    }

    public w1() {
        Boolean r100 = Boolean.TRUE;
        super("live_guest_battle_tech_report_lynx", "大作战技术埋点上报迁移到Lynx", r100, r100);
    }
}
