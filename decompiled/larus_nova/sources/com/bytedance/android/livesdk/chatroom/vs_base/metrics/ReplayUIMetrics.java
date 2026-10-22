package com.bytedance.android.livesdk.chatroom.vs_base.metrics;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/metrics/ReplayUIMetrics;", "", "", "description", "Ljava/lang/String;", "TOOLBAR", "EXPAND_AREA", "BACK_GROUND", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ReplayUIMetrics extends Enum<ReplayUIMetrics> {
    public static final ReplayUIMetrics BACK_GROUND = null;
    public static final ReplayUIMetrics EXPAND_AREA = null;
    public static final ReplayUIMetrics TOOLBAR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReplayUIMetrics[] f118031a = null;
    private final String description;

    static {
        ReplayUIMetrics r100 = new ReplayUIMetrics("TOOLBAR", 0, "vs底部Tooolbar");
        TOOLBAR = r100;
        ReplayUIMetrics r101 = new ReplayUIMetrics("EXPAND_AREA", 1, "vs延展区");
        EXPAND_AREA = r101;
        ReplayUIMetrics r102 = new ReplayUIMetrics("BACK_GROUND", 2, "录播背景");
        BACK_GROUND = r102;
        f118031a = new ReplayUIMetrics[]{r100, r101, r102};
    }

    public static ReplayUIMetrics valueOf(String r100) {
        return (ReplayUIMetrics) a.a(ReplayUIMetrics.class, r100);
    }

    public static ReplayUIMetrics[] values() {
        return (ReplayUIMetrics[]) f118031a.clone();
    }

    public ReplayUIMetrics(String r100, int r101, String r102) {
        super(r100, r101);
        this.description = r102;
    }
}
