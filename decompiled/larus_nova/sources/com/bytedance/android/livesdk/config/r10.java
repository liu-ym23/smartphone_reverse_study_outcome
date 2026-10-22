package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class r10 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r10 f121098a = null;

    static {
        f121098a = new r10();
    }

    public r10() {
        Boolean r100 = Boolean.FALSE;
        super("live_inner_feed_pull_refresh_collect_unread_switch", "直播内流下拉刷新消重上报", r100, r100, true);
    }
}
