package com.bytedance.android.livesdk.chatroom.end.vs;

import com.bytedance.android.live.core.monitor.trace.c;
import com.bytedance.android.live.core.monitor.trace.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class VSEndTraceHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f106183a = 0;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/end/vs/VSEndTraceHelper$EventType;", "", "", "event", "Ljava/lang/String;", "getEvent", "()Ljava/lang/String;", "", "code", "I", "getCode", "()I", "FINISH_URL_EMPTY", "CREATE_CONTAINER_ERROR", "LOAD_URL_ERROR", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum EventType extends Enum<EventType> {
        public static final EventType CREATE_CONTAINER_ERROR = null;
        public static final EventType FINISH_URL_EMPTY = null;
        public static final EventType LOAD_URL_ERROR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EventType[] f106184a = null;
        private final int code;
        private final String event;

        static {
            EventType r100 = new EventType("FINISH_URL_EMPTY", 0, "finish_url_empty", 1);
            FINISH_URL_EMPTY = r100;
            EventType r101 = new EventType("CREATE_CONTAINER_ERROR", 1, "create_container_error", 2);
            CREATE_CONTAINER_ERROR = r101;
            EventType r102 = new EventType("LOAD_URL_ERROR", 2, "load_url_error", 3);
            LOAD_URL_ERROR = r102;
            f106184a = new EventType[]{r100, r101, r102};
        }

        public static EventType valueOf(String r100) {
            return (EventType) r27.a.a(EventType.class, r100);
        }

        public static EventType[] values() {
            return (EventType[]) f106184a.clone();
        }

        public final int getCode() {
            return this.code;
        }

        public final String getEvent() {
            return this.event;
        }

        public EventType(String r100, int r101, String r102, int r103) {
            super(r100, r101);
            this.event = r102;
            this.code = r103;
        }
    }

    static {
    }

    public static void a(EventType r100, String r101, long r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        Intrinsics.checkNotNullParameter(r101, "errMsg");
        Intrinsics.checkNotNullParameter(r103, "anchorId");
        Intrinsics.checkNotNullParameter(r104, "userId");
        r100.getEvent();
        int r105 = e.f64997m;
        e.a r106 = e.b.a(r100.getEvent(), "vs_end_page_trace");
        r106.f65012c = "webcast_client_show";
        r106.f65014e = String.valueOf(r102);
        r106.f65015f = r103;
        r106.f65016g = r104.toString();
        r106.f65017h = Integer.valueOf(r100.getCode());
        r106.f65018i = r101;
        r106.b("is_fe", "false");
        c.b(r106.a(), null);
    }
}
