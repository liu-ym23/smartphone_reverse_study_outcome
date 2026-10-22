package com.bytedance.android.livesdk.interactivity.service.monitor;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/service/monitor/EventName;", "", "", "str", "Ljava/lang/String;", "getStr", "()Ljava/lang/String;", "Default", "InputPanelMonitorEvent", "PublicScreenRealtimeMonitorEvent", "PublicScreenRoomStatMonitorEvent", "PublicScreenNoMessageShowEvent", "HighLevelNoMessageShowEvent", "ChatApiTrigger", "CommentPanelShowDelay", "ChatSendToShowDelay", "community-service_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EventName extends Enum<EventName> {
    public static final EventName ChatApiTrigger = null;
    public static final EventName ChatSendToShowDelay = null;
    public static final EventName CommentPanelShowDelay = null;
    public static final EventName Default = null;
    public static final EventName HighLevelNoMessageShowEvent = null;
    public static final EventName InputPanelMonitorEvent = null;
    public static final EventName PublicScreenNoMessageShowEvent = null;
    public static final EventName PublicScreenRealtimeMonitorEvent = null;
    public static final EventName PublicScreenRoomStatMonitorEvent = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EventName[] f140913a = null;
    private final String str;

    public static EventName valueOf(String r100) {
        return (EventName) r27.a.a(EventName.class, r100);
    }

    public static EventName[] values() {
        return (EventName[]) f140913a.clone();
    }

    static {
        EventName r100 = new EventName("Default", 0, "default");
        Default = r100;
        EventName r101 = new EventName("InputPanelMonitorEvent", 1, "livesdk_message_link_input_monitor");
        InputPanelMonitorEvent = r101;
        EventName r102 = new EventName("PublicScreenRealtimeMonitorEvent", 2, "livesdk_public_screen_realtime_monitor");
        PublicScreenRealtimeMonitorEvent = r102;
        EventName r103 = new EventName("PublicScreenRoomStatMonitorEvent", 3, "livesdk_public_screen_room_stat_monitor");
        PublicScreenRoomStatMonitorEvent = r103;
        EventName r104 = new EventName("PublicScreenNoMessageShowEvent", 4, "livesdk_public_screen_no_message_show_event");
        PublicScreenNoMessageShowEvent = r104;
        EventName r105 = new EventName("HighLevelNoMessageShowEvent", 5, "ttlive_high_level_no_message_show_event");
        HighLevelNoMessageShowEvent = r105;
        EventName r106 = new EventName("ChatApiTrigger", 6, "livesdk_chat_api_trigger");
        ChatApiTrigger = r106;
        EventName r107 = new EventName("CommentPanelShowDelay", 7, "livesdk_comment_panel_show_delay");
        CommentPanelShowDelay = r107;
        EventName r108 = new EventName("ChatSendToShowDelay", 8, "livesdk_chat_send_to_show_delay");
        ChatSendToShowDelay = r108;
        f140913a = new EventName[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
    }

    public final String getStr() {
        return this.str;
    }

    public EventName(String r100, int r101, String r102) {
        super(r100, r101);
        this.str = r102;
    }
}
