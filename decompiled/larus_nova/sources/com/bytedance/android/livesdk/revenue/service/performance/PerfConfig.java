package com.bytedance.android.livesdk.revenue.service.performance;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/service/performance/PerfConfig;", "", "DataChatRoomLiveCoreExtra", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PerfConfig extends Enum<PerfConfig> {
    public static final PerfConfig DataChatRoomLiveCoreExtra = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PerfConfig[] f157420a = null;

    static {
        PerfConfig r100 = new PerfConfig();
        DataChatRoomLiveCoreExtra = r100;
        f157420a = new PerfConfig[]{r100};
    }

    public static PerfConfig valueOf(String r100) {
        return (PerfConfig) r27.a.a(PerfConfig.class, r100);
    }

    public static PerfConfig[] values() {
        return (PerfConfig[]) f157420a.clone();
    }

    public PerfConfig() {
        super("DataChatRoomLiveCoreExtra", 0);
    }
}
