package com.bytedance.android.livesdk.config;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class cc1 extends SSettingKey<List<? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final cc1 f119937a = null;

    static {
        f119937a = new cc1();
    }

    public cc1() {
        super("net_monitor_black_list", "网络错误监控黑名单", new ArrayList(), new ArrayList());
    }
}
