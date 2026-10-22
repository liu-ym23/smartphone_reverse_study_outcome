package com.bytedance.android.live.cloudgrouplive.utils;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/cloudgrouplive/utils/CloudGroupLiveTraceEvent;", "", "", "eventName", "Ljava/lang/String;", "getEventName", "()Ljava/lang/String;", "RTC_MANAGER", "LIVE_MANAGER", "API_MANAGER", "JSB_MANAGER", "WINDOW_MANAGER", "PING_MANAGER", "multilink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum CloudGroupLiveTraceEvent extends Enum<CloudGroupLiveTraceEvent> {
    public static final CloudGroupLiveTraceEvent API_MANAGER = null;
    public static final CloudGroupLiveTraceEvent JSB_MANAGER = null;
    public static final CloudGroupLiveTraceEvent LIVE_MANAGER = null;
    public static final CloudGroupLiveTraceEvent PING_MANAGER = null;
    public static final CloudGroupLiveTraceEvent RTC_MANAGER = null;
    public static final CloudGroupLiveTraceEvent WINDOW_MANAGER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CloudGroupLiveTraceEvent[] f64485a = null;
    private final String eventName;

    static {
        CloudGroupLiveTraceEvent r100 = new CloudGroupLiveTraceEvent("RTC_MANAGER", 0, "rtc_manager");
        RTC_MANAGER = r100;
        CloudGroupLiveTraceEvent r101 = new CloudGroupLiveTraceEvent("LIVE_MANAGER", 1, "live_manager");
        LIVE_MANAGER = r101;
        CloudGroupLiveTraceEvent r102 = new CloudGroupLiveTraceEvent("API_MANAGER", 2, "api_manager");
        API_MANAGER = r102;
        CloudGroupLiveTraceEvent r103 = new CloudGroupLiveTraceEvent("JSB_MANAGER", 3, "jsb_manager");
        JSB_MANAGER = r103;
        CloudGroupLiveTraceEvent r104 = new CloudGroupLiveTraceEvent("WINDOW_MANAGER", 4, "window_manager");
        WINDOW_MANAGER = r104;
        CloudGroupLiveTraceEvent r105 = new CloudGroupLiveTraceEvent("PING_MANAGER", 5, "ping_manager");
        PING_MANAGER = r105;
        f64485a = new CloudGroupLiveTraceEvent[]{r100, r101, r102, r103, r104, r105};
    }

    public static CloudGroupLiveTraceEvent valueOf(String r100) {
        return (CloudGroupLiveTraceEvent) a.a(CloudGroupLiveTraceEvent.class, r100);
    }

    public static CloudGroupLiveTraceEvent[] values() {
        return (CloudGroupLiveTraceEvent[]) f64485a.clone();
    }

    public final String getEventName() {
        return this.eventName;
    }

    public CloudGroupLiveTraceEvent(String r100, int r101, String r102) {
        super(r100, r101);
        this.eventName = r102;
    }
}
