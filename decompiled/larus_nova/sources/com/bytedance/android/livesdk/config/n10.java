package com.bytedance.android.livesdk.config;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class n10 extends SSettingKey<List<? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n10 f120799a = null;

    static {
        f120799a = new n10();
    }

    public n10() {
        super("live_inner_feed_enable_pull_refresh", "直播间支持下拉刷新入口配置", new ArrayList(), new ArrayList());
    }
}
