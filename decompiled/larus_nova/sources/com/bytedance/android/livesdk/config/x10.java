package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class x10 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x10 f121571a = null;

    static {
        f121571a = new x10();
    }

    public x10() {
        Boolean r100 = Boolean.FALSE;
        super("live_inner_feed_single_use_clear_opt", "直播间detroy中部分单例clear问题", r100, r100, true);
    }
}
