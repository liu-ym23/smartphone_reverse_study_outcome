package com.bytedance.android.livesdk.dynamicstrategy.api.utils;

import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes8.dex */
public final class DynamicStrategyMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f123031a = 0;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/api/utils/DynamicStrategyMonitor$Event;", "", "", "eventName", "Ljava/lang/String;", "getEventName", "()Ljava/lang/String;", "Lcom/bytedance/android/live/core/monitor/LiveTracingMonitor$EventModule;", "eventModule", "Lcom/bytedance/android/live/core/monitor/LiveTracingMonitor$EventModule;", "getEventModule", "()Lcom/bytedance/android/live/core/monitor/LiveTracingMonitor$EventModule;", "", "extraALog", "Z", "getExtraALog", "()Z", "reportInLocalTest", "getReportInLocalTest", "StrategyFetchAll", "StrategyFetchError", "StrategyCheckError", "StrategyExecuteError", "StrategyContextInitContext", "StrategyExecuteCost", "CloudFactorFetchAll", "CloudFactorFetchError", "dynamicstrategy-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Event extends Enum<Event> {
        public static final Event CloudFactorFetchAll = null;
        public static final Event CloudFactorFetchError = null;
        public static final Event StrategyCheckError = null;
        public static final Event StrategyContextInitContext = null;
        public static final Event StrategyExecuteCost = null;
        public static final Event StrategyExecuteError = null;
        public static final Event StrategyFetchAll = null;
        public static final Event StrategyFetchError = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Event[] f123032a = null;
        private final LiveTracingMonitor.EventModule eventModule;
        private final String eventName;
        private final boolean extraALog;
        private final boolean reportInLocalTest;

        public Event() {
            throw null;
        }

        public static Event valueOf(String r100) {
            return (Event) a.a(Event.class, r100);
        }

        public static Event[] values() {
            return (Event[]) f123032a.clone();
        }

        static {
            LiveTracingMonitor.EventModule r210 = LiveTracingMonitor.EventModule.DYNAMIC_STRATEGY;
            Event r110 = new Event("StrategyFetchAll", 0, "ttlive_dynamic_strategy_fetch_all", r210, false, false, 8, null);
            StrategyFetchAll = r110;
            Event r100 = new Event("StrategyFetchError", 1, "ttlive_dynamic_strategy_fetch_error", r210, true, false, 8, null);
            StrategyFetchError = r100;
            Event r101 = new Event("StrategyCheckError", 2, "ttlive_dynamic_strategy_check_error", r210, true, false, 8, null);
            StrategyCheckError = r101;
            Event r102 = new Event("StrategyExecuteError", 3, "ttlive_dynamic_strategy_execute_error", r210, true, false, 8, null);
            StrategyExecuteError = r102;
            Event r103 = new Event("StrategyContextInitContext", 4, "ttlive_dynamic_strategy_context_init_cost", r210, true, false, 8, null);
            StrategyContextInitContext = r103;
            Event r104 = new Event("StrategyExecuteCost", 5, "ttlive_dynamic_strategy_execute_cost", r210, true, false, 8, null);
            StrategyExecuteCost = r104;
            Event r105 = new Event("CloudFactorFetchAll", 6, "ttlive_dynamic_strategy_cloud_factor_fetch_all", r210, false, false, 8, null);
            CloudFactorFetchAll = r105;
            Event r106 = new Event("CloudFactorFetchError", 7, "ttlive_dynamic_strategy_cloud_factor_fetch_error", r210, true, false, 8, null);
            CloudFactorFetchError = r106;
            f123032a = new Event[]{r110, r100, r101, r102, r103, r104, r105, r106};
        }

        public final LiveTracingMonitor.EventModule getEventModule() {
            return this.eventModule;
        }

        public final String getEventName() {
            return this.eventName;
        }

        public final boolean getExtraALog() {
            return this.extraALog;
        }

        public final boolean getReportInLocalTest() {
            return this.reportInLocalTest;
        }

        public Event(String r100, int r101, String r102, LiveTracingMonitor.EventModule r103, boolean r104, boolean r105, int r106, DefaultConstructorMarker r107) {
            if ((r106 & 4) == 0) goto L6;
            r104 = true;
        L6:
            if ((r106 & 8) == 0) goto L8;
            r105 = true;
        L8:
            super(r100, r101);
            this.eventName = r102;
            this.eventModule = r103;
            this.extraALog = r104;
            this.reportInLocalTest = r105;
        }
    }

    static {
    }

    public static LiveMonitor.a a(Event r100) {
        LiveMonitor.a r101 = new LiveMonitor.a(r100.getEventName(), r100.getEventModule());
        r101.f64903f = r100.getExtraALog();
        r101.f64905h = r100.getReportInLocalTest();
        return r101;
    }

    public static void c(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "version");
        JSONObject r102 = new JSONObject();
        r102.put("requestScene", r100);
        r102.put("is_success", true);
        LiveMonitor.a r103 = a(Event.CloudFactorFetchAll);
        r103.b(r102);
        r103.i("requestScene", Integer.valueOf(r100));
        r103.i("version", r101);
        r103.a().report();
    }

    public static void b(int r100, String r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "version");
        Intrinsics.checkNotNullParameter(r103, "errorInfo");
        LiveMonitor.a r104 = a(Event.CloudFactorFetchError);
        r104.i("requestScene", Integer.valueOf(r100));
        r104.i("version", r101);
        r104.i("errorCode", Integer.valueOf(r102));
        r104.i("errorInfo", r103);
        r104.a().report();
        JSONObject r105 = new JSONObject();
        r105.put("requestScene", r100);
        r105.put("is_success", false);
        r105.put("errorCode", r102);
        LiveMonitor.a r106 = a(Event.CloudFactorFetchAll);
        r106.b(r105);
        r106.i("requestScene", Integer.valueOf(r100));
        r106.i("version", r101);
        r106.a().report();
    }

    public static void d(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "strategyName");
        Intrinsics.checkNotNullParameter(r101, ControlRule.KEY_STRATEGY_TYPE);
        Intrinsics.checkNotNullParameter(r102, "executeInfo");
        Intrinsics.checkNotNullParameter(r103, "errorInfo");
        JSONObject r104 = new JSONObject();
        r104.put("name", r100);
        r104.put("type", r101);
        LiveMonitor.a r105 = a(Event.StrategyExecuteError);
        r105.b(r104);
        r105.i("name", r100);
        r105.i("type", r101);
        r105.i(MapMonitorConst.ERROR_INFO, r103);
        r105.a().report();
    }

    public static void e(int r100, String r101, int r102, String r110) {
        Intrinsics.checkNotNullParameter(r101, "version");
        Intrinsics.checkNotNullParameter(r110, "errorInfo");
        LiveMonitor.a r103 = a(Event.StrategyFetchError);
        r103.i("requestScene", Integer.valueOf(r100));
        r103.i("version", r101);
        r103.i("errorCode", Integer.valueOf(r102));
        r103.i("errorInfo", r110);
        r103.a().report();
        JSONObject r104 = new JSONObject();
        r104.put("requestScene", r100);
        r104.put("is_success", false);
        r104.put("errorCode", r102);
        LiveMonitor.a r105 = a(Event.StrategyFetchAll);
        r105.b(r104);
        r105.i("requestScene", Integer.valueOf(r100));
        r105.i("version", r101);
        r105.i("errorCode", Integer.valueOf(r102));
        r105.i("errorInfo", r110);
        r105.a().report();
    }
}
