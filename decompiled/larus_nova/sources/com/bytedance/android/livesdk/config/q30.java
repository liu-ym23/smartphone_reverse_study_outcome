package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class q30 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q30 f121028a = null;

    static {
        f121028a = new q30();
    }

    public q30() {
        super(LiveInitSettingKeys.LIVE_IO_PRE_START, "Live IO预启动", Boolean.FALSE, Boolean.TRUE);
    }
}
