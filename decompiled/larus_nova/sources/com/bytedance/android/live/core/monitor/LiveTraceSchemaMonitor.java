package com.bytedance.android.live.core.monitor;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
public final class LiveTraceSchemaMonitor extends BaseMonitor {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/core/monitor/LiveTraceSchemaMonitor$HybridType;", "", "ANNIE", "LYNX", "WEB", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum HybridType extends Enum<HybridType> {
        public static final HybridType ANNIE = null;
        public static final HybridType LYNX = null;
        public static final HybridType WEB = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ HybridType[] f64907a = null;

        static {
            HybridType r100 = new HybridType("ANNIE", 0);
            ANNIE = r100;
            HybridType r101 = new HybridType("LYNX", 1);
            LYNX = r101;
            HybridType r102 = new HybridType("WEB", 2);
            WEB = r102;
            f64907a = new HybridType[]{r100, r101, r102};
        }

        public static HybridType valueOf(String r100) {
            return (HybridType) a.a(HybridType.class, r100);
        }

        public static HybridType[] values() {
            return (HybridType[]) f64907a.clone();
        }

        public HybridType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/core/monitor/LiveTraceSchemaMonitor$Status;", "", "", "value", "I", "getValue", "()I", "SUCCESS", "SDK_INIT_UNFINISHED", "URI_INVALID", "ERROR_UNKNOWN", "ENTER_ROOM_PARAMS_INVALID", "ENTER_ROOM_GET_USER_INFO_FAIL", "ENTER_ROOM_COIN_TASK_FAIL", "ENTER_ROOM_ACTIVITY_CREATE_FAIL", "ENTER_ROOM_FRAGMENT_CREATE_FAIL", "BROADCAST_MODULE_NOT_LAUNCH", "BROADCAST_PAGE_CREATE_FAIL", "HYBRID_URL_INVALID", "HYBRID_GET_CONTAINER_TYPE_FAIL", "HYBRID_ANNIE_LOAD_FAIL", "HYBRID_LYNX_LOAD_FAIL", "HYBRID_WEB_LOAD_FAIL", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Status extends Enum<Status> {
        public static final Status BROADCAST_MODULE_NOT_LAUNCH = null;
        public static final Status BROADCAST_PAGE_CREATE_FAIL = null;
        public static final Status ENTER_ROOM_ACTIVITY_CREATE_FAIL = null;
        public static final Status ENTER_ROOM_COIN_TASK_FAIL = null;
        public static final Status ENTER_ROOM_FRAGMENT_CREATE_FAIL = null;
        public static final Status ENTER_ROOM_GET_USER_INFO_FAIL = null;
        public static final Status ENTER_ROOM_PARAMS_INVALID = null;
        public static final Status ERROR_UNKNOWN = null;
        public static final Status HYBRID_ANNIE_LOAD_FAIL = null;
        public static final Status HYBRID_GET_CONTAINER_TYPE_FAIL = null;
        public static final Status HYBRID_LYNX_LOAD_FAIL = null;
        public static final Status HYBRID_URL_INVALID = null;
        public static final Status HYBRID_WEB_LOAD_FAIL = null;
        public static final Status SDK_INIT_UNFINISHED = null;
        public static final Status SUCCESS = null;
        public static final Status URI_INVALID = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Status[] f64908a = null;
        private final int value;

        public static Status valueOf(String r100) {
            return (Status) a.a(Status.class, r100);
        }

        public static Status[] values() {
            return (Status[]) f64908a.clone();
        }

        static {
            Status r100 = new Status("SUCCESS", 0, 0);
            SUCCESS = r100;
            Status r101 = new Status("SDK_INIT_UNFINISHED", 1, 1);
            SDK_INIT_UNFINISHED = r101;
            Status r102 = new Status("URI_INVALID", 2, 2);
            URI_INVALID = r102;
            Status r103 = new Status("ERROR_UNKNOWN", 3, 3);
            ERROR_UNKNOWN = r103;
            Status r104 = new Status("ENTER_ROOM_PARAMS_INVALID", 4, 11);
            ENTER_ROOM_PARAMS_INVALID = r104;
            Status r105 = new Status("ENTER_ROOM_GET_USER_INFO_FAIL", 5, 12);
            ENTER_ROOM_GET_USER_INFO_FAIL = r105;
            Status r106 = new Status("ENTER_ROOM_COIN_TASK_FAIL", 6, 13);
            ENTER_ROOM_COIN_TASK_FAIL = r106;
            Status r107 = new Status("ENTER_ROOM_ACTIVITY_CREATE_FAIL", 7, 14);
            ENTER_ROOM_ACTIVITY_CREATE_FAIL = r107;
            Status r108 = new Status("ENTER_ROOM_FRAGMENT_CREATE_FAIL", 8, 15);
            ENTER_ROOM_FRAGMENT_CREATE_FAIL = r108;
            Status r109 = new Status("BROADCAST_MODULE_NOT_LAUNCH", 9, 21);
            BROADCAST_MODULE_NOT_LAUNCH = r109;
            Status r110 = new Status("BROADCAST_PAGE_CREATE_FAIL", 10, 22);
            BROADCAST_PAGE_CREATE_FAIL = r110;
            Status r111 = new Status("HYBRID_URL_INVALID", 11, 31);
            HYBRID_URL_INVALID = r111;
            Status r112 = new Status("HYBRID_GET_CONTAINER_TYPE_FAIL", 12, 32);
            HYBRID_GET_CONTAINER_TYPE_FAIL = r112;
            Status r113 = new Status("HYBRID_ANNIE_LOAD_FAIL", 13, 33);
            HYBRID_ANNIE_LOAD_FAIL = r113;
            Status r114 = new Status("HYBRID_LYNX_LOAD_FAIL", 14, 34);
            HYBRID_LYNX_LOAD_FAIL = r114;
            Status r115 = new Status("HYBRID_WEB_LOAD_FAIL", 15, 35);
            HYBRID_WEB_LOAD_FAIL = r115;
            f64908a = new Status[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115};
        }

        public final int getValue() {
            return this.value;
        }

        public Status(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @JvmStatic
    public static final void l(BaseMonitor.MonitorEventModule r100, Status r101, String r102, String r103, String r104, JSONObject r105) {
        Intrinsics.checkNotNullParameter(r100, "eventModule");
        Intrinsics.checkNotNullParameter(r101, "status");
        Intrinsics.checkNotNullParameter(r102, com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG);
    }

    static {
        new LiveTraceSchemaMonitor();
    }

    public LiveTraceSchemaMonitor() {
    }

    public static /* synthetic */ void m(BaseMonitor.MonitorEventModule r100, Status r101, String r102, String r103, String r110) {
        l(r100, r101, r102, r103, r110, null);
    }
}
