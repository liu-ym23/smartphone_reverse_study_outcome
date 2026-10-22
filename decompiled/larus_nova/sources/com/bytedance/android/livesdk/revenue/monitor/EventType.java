package com.bytedance.android.livesdk.revenue.monitor;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/monitor/EventType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "BUSSINESS_API_CALL", "SERVER_API_CALL", "MESSAGE_RECEIVED", "SDK_INTERFACE_CALL", "SDK_CALLBACK", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum EventType extends Enum<EventType> {
    public static final EventType BUSSINESS_API_CALL = null;
    public static final EventType MESSAGE_RECEIVED = null;
    public static final EventType SDK_CALLBACK = null;
    public static final EventType SDK_INTERFACE_CALL = null;
    public static final EventType SERVER_API_CALL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EventType[] f157201a = null;
    private final String value;

    static {
        EventType r100 = new EventType("BUSSINESS_API_CALL", 0, "bussiness_api_call");
        BUSSINESS_API_CALL = r100;
        EventType r101 = new EventType("SERVER_API_CALL", 1, "server_api_call");
        SERVER_API_CALL = r101;
        EventType r102 = new EventType("MESSAGE_RECEIVED", 2, "message_received");
        MESSAGE_RECEIVED = r102;
        EventType r103 = new EventType("SDK_INTERFACE_CALL", 3, "sdk_interface_call");
        SDK_INTERFACE_CALL = r103;
        EventType r104 = new EventType("SDK_CALLBACK", 4, "sdk_callback");
        SDK_CALLBACK = r104;
        f157201a = new EventType[]{r100, r101, r102, r103, r104};
    }

    public static EventType valueOf(String r100) {
        return (EventType) a.a(EventType.class, r100);
    }

    public static EventType[] values() {
        return (EventType[]) f157201a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public EventType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
