package com.bytedance.android.livesdk.revenue.log;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/log/LogCommonInstance;", "", "LIVE_AD_LOG", "live-kmp-platform-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LogCommonInstance extends Enum<LogCommonInstance> {
    public static final LogCommonInstance LIVE_AD_LOG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LogCommonInstance[] f157171a = null;

    static {
        LogCommonInstance r100 = new LogCommonInstance();
        LIVE_AD_LOG = r100;
        f157171a = new LogCommonInstance[]{r100};
    }

    public static LogCommonInstance valueOf(String r100) {
        return (LogCommonInstance) r27.a.a(LogCommonInstance.class, r100);
    }

    public static LogCommonInstance[] values() {
        return (LogCommonInstance[]) f157171a.clone();
    }

    public LogCommonInstance() {
        super("LIVE_AD_LOG", 0);
    }
}
