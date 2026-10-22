package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class i0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i0 f65320a = null;

    static {
        f65320a = new i0();
    }

    public i0() {
        Boolean r100 = Boolean.TRUE;
        super("live_del_guest_battle_tech_report", "删除大作战客户端上的埋点上报", r100, r100);
    }
}
