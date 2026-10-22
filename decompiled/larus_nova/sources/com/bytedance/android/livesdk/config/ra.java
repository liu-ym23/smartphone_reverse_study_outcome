package com.bytedance.android.livesdk.config;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class ra extends SSettingKey<List<? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ra f121115a = null;

    static {
        f121115a = new ra();
    }

    public ra() {
        super("live_anchor_alog_intercept_list", "开播日志拦截列表", new ArrayList(), new ArrayList());
    }
}
