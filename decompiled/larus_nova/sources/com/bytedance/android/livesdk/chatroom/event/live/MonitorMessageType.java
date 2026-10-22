package com.bytedance.android.livesdk.chatroom.event.live;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/event/live/MonitorMessageType;", "", "UNKNOWN", "SHOW_VERIFY", "CLOSE_LIVE", "PASS_VERIFY", "liveroom-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum MonitorMessageType extends Enum<MonitorMessageType> {
    public static final MonitorMessageType CLOSE_LIVE = null;
    public static final MonitorMessageType PASS_VERIFY = null;
    public static final MonitorMessageType SHOW_VERIFY = null;
    public static final MonitorMessageType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MonitorMessageType[] f106207a = null;

    static {
        MonitorMessageType r100 = new MonitorMessageType("UNKNOWN", 0);
        UNKNOWN = r100;
        MonitorMessageType r101 = new MonitorMessageType("SHOW_VERIFY", 1);
        SHOW_VERIFY = r101;
        MonitorMessageType r102 = new MonitorMessageType("CLOSE_LIVE", 2);
        CLOSE_LIVE = r102;
        MonitorMessageType r103 = new MonitorMessageType("PASS_VERIFY", 3);
        PASS_VERIFY = r103;
        f106207a = new MonitorMessageType[]{r100, r101, r102, r103};
    }

    public static MonitorMessageType valueOf(String r100) {
        return (MonitorMessageType) a.a(MonitorMessageType.class, r100);
    }

    public static MonitorMessageType[] values() {
        return (MonitorMessageType[]) f106207a.clone();
    }

    public MonitorMessageType(String r100, int r101) {
        super(r100, r101);
    }
}
