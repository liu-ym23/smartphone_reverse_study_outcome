package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class z80 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z80 f121743a = null;

    static {
        f121743a = new z80();
    }

    public z80() {
        Boolean r100 = Boolean.TRUE;
        super("live_mg_fix_ad_schema", "修复：进房未请求entrance_info接口时，打开小游戏没带广告参数", r100, r100);
    }
}
