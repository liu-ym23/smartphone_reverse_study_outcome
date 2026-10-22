package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.model.LiveMemStatusCheckConfig;

/* JADX INFO: loaded from: classes7.dex */
public final class x1 extends SSettingKey<LiveMemStatusCheckConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x1 f162534a = null;

    static {
        f162534a = new x1();
    }

    public x1() {
        super("live_perf_mem_status_check_config", "直播内存状态判断配置", new LiveMemStatusCheckConfig(), new LiveMemStatusCheckConfig());
    }
}
