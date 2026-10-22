package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedPerformanceAlarmReason;", "", "", "value", "I", "BANDWIDTH_FALLBACKED", "BANDWIDTH_RESUMED", "PERFORMANCE_FALLBACKED", "PERFORMANCE_RESUMED", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedPerformanceAlarmReason extends Enum<LiveWrappedPerformanceAlarmReason> {
    public static final LiveWrappedPerformanceAlarmReason BANDWIDTH_FALLBACKED = null;
    public static final LiveWrappedPerformanceAlarmReason BANDWIDTH_RESUMED = null;
    public static final LiveWrappedPerformanceAlarmReason PERFORMANCE_FALLBACKED = null;
    public static final LiveWrappedPerformanceAlarmReason PERFORMANCE_RESUMED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedPerformanceAlarmReason[] f147433a = null;
    private int value;

    static {
        LiveWrappedPerformanceAlarmReason r100 = new LiveWrappedPerformanceAlarmReason("BANDWIDTH_FALLBACKED", 0, 0);
        BANDWIDTH_FALLBACKED = r100;
        LiveWrappedPerformanceAlarmReason r101 = new LiveWrappedPerformanceAlarmReason("BANDWIDTH_RESUMED", 1, 1);
        BANDWIDTH_RESUMED = r101;
        LiveWrappedPerformanceAlarmReason r102 = new LiveWrappedPerformanceAlarmReason("PERFORMANCE_FALLBACKED", 2, 2);
        PERFORMANCE_FALLBACKED = r102;
        LiveWrappedPerformanceAlarmReason r103 = new LiveWrappedPerformanceAlarmReason("PERFORMANCE_RESUMED", 3, 3);
        PERFORMANCE_RESUMED = r103;
        f147433a = new LiveWrappedPerformanceAlarmReason[]{r100, r101, r102, r103};
    }

    public static LiveWrappedPerformanceAlarmReason valueOf(String r100) {
        return (LiveWrappedPerformanceAlarmReason) a.a(LiveWrappedPerformanceAlarmReason.class, r100);
    }

    public static LiveWrappedPerformanceAlarmReason[] values() {
        return (LiveWrappedPerformanceAlarmReason[]) f147433a.clone();
    }

    public LiveWrappedPerformanceAlarmReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
