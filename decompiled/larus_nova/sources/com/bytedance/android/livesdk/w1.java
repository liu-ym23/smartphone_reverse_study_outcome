package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.model.LiveMemStatsReportConfig;

/* JADX INFO: loaded from: classes7.dex */
public final class w1 extends SSettingKey<LiveMemStatsReportConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w1 f160650a = null;

    static {
        f160650a = new w1();
    }

    public w1() {
        super("live_perf_mem_stats_report", "直播内存增量信息统计上报配置", new LiveMemStatsReportConfig(), new LiveMemStatsReportConfig());
    }
}
