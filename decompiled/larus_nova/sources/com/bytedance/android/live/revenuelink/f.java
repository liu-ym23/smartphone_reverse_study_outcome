package com.bytedance.android.live.revenuelink;

import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public interface f {

    public static final class a {
        public static /* synthetic */ void a(f r100, String r101, LiveTracingMonitorKt.EventModule r102, Map r110, JSONObject r111) {
            r100.Z(r101, r102, r110, r111, 0);
        }

        public static /* synthetic */ void b(f r100, LiveTracingMonitorKt.EventModule r110, int r111, String r112, Map r113, JSONObject r114) {
            r100.Y("ttlive_pk_business_api_call", r110, r111, r112, r113, r114, null, null);
        }
    }

    boolean X(String r100);

    void Y(String r100, LiveTracingMonitorKt.EventModule r101, int r102, String r103, Map<String, Object> r104, JSONObject r105, JSONObject r106, JSONObject r107);

    void Z(String r100, LiveTracingMonitorKt.EventModule r101, Map<String, Object> r102, JSONObject r103, long r104);

    void a0(String r100, LiveTracingMonitorKt.EventModule r101, String r102, Map<String, Object> r103, JSONObject r104, long r105);

    void b0(String r100, LiveTracingMonitorKt.EventModule r101, JSONObject r102);

    void c0(String r100, LiveTracingMonitorKt.EventModule r101, int r102, String r103, Map<String, Object> r104, JSONObject r105);
}
