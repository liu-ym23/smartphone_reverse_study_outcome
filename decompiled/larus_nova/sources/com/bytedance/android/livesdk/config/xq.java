package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class xq extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final xq f121624a = null;

    static {
        f121624a = new xq();
    }

    public xq() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_audience_game_manager", "是否开启观众端开放平台玩法", r100, r100);
    }
}
