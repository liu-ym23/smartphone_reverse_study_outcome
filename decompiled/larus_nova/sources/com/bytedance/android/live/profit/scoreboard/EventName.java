package com.bytedance.android.live.profit.scoreboard;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/EventName;", "", "ON_ROUND_MESSAGE_START", "ON_ROUND_MESSAGE_FINISH", "ON_ROUND_MESSAGE_SCORE_CHANGE", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum EventName extends Enum<EventName> {
    public static final EventName ON_ROUND_MESSAGE_FINISH = null;
    public static final EventName ON_ROUND_MESSAGE_SCORE_CHANGE = null;
    public static final EventName ON_ROUND_MESSAGE_START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EventName[] f88794a = null;

    static {
        EventName r100 = new EventName("ON_ROUND_MESSAGE_START", 0);
        ON_ROUND_MESSAGE_START = r100;
        EventName r101 = new EventName("ON_ROUND_MESSAGE_FINISH", 1);
        ON_ROUND_MESSAGE_FINISH = r101;
        EventName r102 = new EventName("ON_ROUND_MESSAGE_SCORE_CHANGE", 2);
        ON_ROUND_MESSAGE_SCORE_CHANGE = r102;
        f88794a = new EventName[]{r100, r101, r102};
    }

    public static EventName valueOf(String r100) {
        return (EventName) r27.a.a(EventName.class, r100);
    }

    public static EventName[] values() {
        return (EventName[]) f88794a.clone();
    }

    public EventName(String r100, int r101) {
        super(r100, r101);
    }
}
