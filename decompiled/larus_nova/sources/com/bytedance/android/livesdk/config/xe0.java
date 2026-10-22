package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class xe0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final xe0 f121597a = null;

    static {
        f121597a = new xe0();
    }

    public xe0() {
        Boolean r100 = Boolean.FALSE;
        super(LiveInitSettingKeys.LIVE_PAD_BACKUP_DISABLE_OPT, "兜底关掉直播pad优化的开关，默认关着的，打开了就回滚", r100, r100);
    }
}
