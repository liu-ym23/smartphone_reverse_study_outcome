package com.bytedance.android.livesdk.performance.degrade.ability;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/performance/degrade/ability/LivePerformanceScheduleStrategy;", "", "FORBIDDEN", "ORIGIN", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
final enum LivePerformanceScheduleStrategy extends Enum<LivePerformanceScheduleStrategy> {
    public static final LivePerformanceScheduleStrategy FORBIDDEN = null;
    public static final LivePerformanceScheduleStrategy ORIGIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LivePerformanceScheduleStrategy[] f154532a = null;

    static {
        LivePerformanceScheduleStrategy r100 = new LivePerformanceScheduleStrategy("FORBIDDEN", 0);
        FORBIDDEN = r100;
        LivePerformanceScheduleStrategy r101 = new LivePerformanceScheduleStrategy("ORIGIN", 1);
        ORIGIN = r101;
        f154532a = new LivePerformanceScheduleStrategy[]{r100, r101};
    }

    public static LivePerformanceScheduleStrategy valueOf(String r100) {
        return (LivePerformanceScheduleStrategy) r27.a.a(LivePerformanceScheduleStrategy.class, r100);
    }

    public static LivePerformanceScheduleStrategy[] values() {
        return (LivePerformanceScheduleStrategy[]) f154532a.clone();
    }

    public LivePerformanceScheduleStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
