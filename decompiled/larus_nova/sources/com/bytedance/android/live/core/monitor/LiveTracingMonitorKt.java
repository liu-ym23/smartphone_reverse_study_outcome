package com.bytedance.android.live.core.monitor;

import com.bytedance.android.live.network.annotation.PbRequest;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
public final class LiveTracingMonitorKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LiveTracingMonitorKt f64913a = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/core/monitor/LiveTracingMonitorKt$EventModule;", "", "", "typeName", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "PK", "MULTI_LINKER", "MEDIA_MULTI_LINKER", "SCREEN_LINKER", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum EventModule extends Enum<EventModule> {
        public static final EventModule MEDIA_MULTI_LINKER = null;
        public static final EventModule MULTI_LINKER = null;
        public static final EventModule PK = null;
        public static final EventModule SCREEN_LINKER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EventModule[] f64914a = null;
        private final String typeName;

        static {
            EventModule r100 = new EventModule("PK", 0, PbRequest.SwitchType.PK);
            PK = r100;
            EventModule r101 = new EventModule("MULTI_LINKER", 1, "muti_linker");
            MULTI_LINKER = r101;
            EventModule r102 = new EventModule("MEDIA_MULTI_LINKER", 2, "media_muti_linker");
            MEDIA_MULTI_LINKER = r102;
            EventModule r103 = new EventModule("SCREEN_LINKER", 3, "screen_linker");
            SCREEN_LINKER = r103;
            f64914a = new EventModule[]{r100, r101, r102, r103};
        }

        public static EventModule valueOf(String r100) {
            return (EventModule) a.a(EventModule.class, r100);
        }

        public static EventModule[] values() {
            return (EventModule[]) f64914a.clone();
        }

        public final String getTypeName() {
            return this.typeName;
        }

        public EventModule(String r100, int r101, String r102) {
            super(r100, r101);
            this.typeName = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/core/monitor/LiveTracingMonitorKt$EventType;", "", "", "typeName", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "BUSSINESS_API_CALL", "SERVER_API_CALL", "MESSAGE_RECEIVED", "SDK_INTERFACE_CALL", "SDK_CALLBACK", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum EventType extends Enum<EventType> {
        public static final EventType BUSSINESS_API_CALL = null;
        public static final EventType MESSAGE_RECEIVED = null;
        public static final EventType SDK_CALLBACK = null;
        public static final EventType SDK_INTERFACE_CALL = null;
        public static final EventType SERVER_API_CALL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EventType[] f64915a = null;
        private final String typeName;

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
            f64915a = new EventType[]{r100, r101, r102, r103, r104};
        }

        public static EventType valueOf(String r100) {
            return (EventType) a.a(EventType.class, r100);
        }

        public static EventType[] values() {
            return (EventType[]) f64915a.clone();
        }

        public final String getTypeName() {
            return this.typeName;
        }

        public EventType(String r100, int r101, String r102) {
            super(r100, r101);
            this.typeName = r102;
        }
    }

    public LiveTracingMonitorKt() {
    }

    static {
        f64913a = new LiveTracingMonitorKt();
    }

    public static EventModule a(int r100) {
        if (r100 != 1) goto L7;
        return EventModule.PK;
    L7:
        if (r100 != 17) goto L11;
        return EventModule.MEDIA_MULTI_LINKER;
    L11:
        if (r100 != 14) goto L15;
        return EventModule.SCREEN_LINKER;
    L15:
        return EventModule.MULTI_LINKER;
    }
}
