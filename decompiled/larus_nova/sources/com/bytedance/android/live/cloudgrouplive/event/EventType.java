package com.bytedance.android.live.cloudgrouplive.event;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/cloudgrouplive/event/EventType;", "", "RTC_LINK_SUCCESS", "RTC_LINK_END", "RTS_MSG_RECEIVED", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum EventType extends Enum<EventType> {
    public static final EventType RTC_LINK_END = null;
    public static final EventType RTC_LINK_SUCCESS = null;
    public static final EventType RTS_MSG_RECEIVED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EventType[] f64458a = null;

    static {
        EventType r100 = new EventType("RTC_LINK_SUCCESS", 0);
        RTC_LINK_SUCCESS = r100;
        EventType r101 = new EventType("RTC_LINK_END", 1);
        RTC_LINK_END = r101;
        EventType r102 = new EventType("RTS_MSG_RECEIVED", 2);
        RTS_MSG_RECEIVED = r102;
        f64458a = new EventType[]{r100, r101, r102};
    }

    public static EventType valueOf(String r100) {
        return (EventType) a.a(EventType.class, r100);
    }

    public static EventType[] values() {
        return (EventType[]) f64458a.clone();
    }

    public EventType(String r100, int r101) {
        super(r100, r101);
    }
}
