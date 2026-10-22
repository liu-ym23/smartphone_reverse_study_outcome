package com.bytedance.android.livesdk.chatroom.monitor;

import am2.x;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.j0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class e extends ActivityBaseTimeMonitor {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f107006g = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f107007c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f107008d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f107009e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f107010f;

    public static final class a {
        public static void a(int r100, String r110, String r111, String r112, String r113) {
            Intrinsics.checkNotNullParameter(r113, "msg");
            JSONObject r101 = new JSONObject();
            r101.put("uri", r112);
            r101.put("msg", r113);
            JSONObject r102 = new JSONObject();
            r102.put("schema", r111);
            r102.put("scene", r110);
            o r114 = j0.l().c(x.class);
            if (r114 == null) goto L8;
            Map<String, String> r115 = r114.getMap();
            if (r115 == null) goto L8;
            String r116 = r115.get("enter_from_merge");
            if (r116 == null) goto L8;
        L10:
            if (x40.e.a(r116) == false) goto L12;
            r102.put("enter_from_merge", r116);
        L12:
            wm0.a r103 = om0.c.h();
            if (r103 == null) goto L16;
            r103.b(LiveTracingMonitor.EventModule.ACTIVITY.name(), LiveTracingMonitor.EventType.BUSSINESS_API_CALL.name(), r100, r113, r102, new JSONObject(), r101);
            return;
        L16:
            return;
        L8:
            r116 = "";
            goto L10
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.monitor.ActivityBaseTimeMonitor
    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        if (this.f107007c == false) goto L7;
        String r101 = this.f107010f;
        if (r101 == null) goto L10;
        ActivityBaseTimeMonitor.f(r100, "core_schema_name", r101);
    L10:
        return r100;
    L7:
        String r102 = this.f107009e;
        if (r102 == null) goto L10;
        ActivityBaseTimeMonitor.f(r100, "schema_host", r102);
        goto L10
    }

    @Override // com.bytedance.android.livesdk.chatroom.monitor.ActivityBaseTimeMonitor
    public final String b() {
        if (this.f107007c == false) goto L5;
        return "ttlive_core_schema_handle_duration";
    L5:
        return "ttlive_schema_process_duration";
    }

    @Override // com.bytedance.android.livesdk.chatroom.monitor.ActivityBaseTimeMonitor
    public final JSONObject c() {
        JSONObject r100 = new JSONObject();
        String r101 = this.f107008d;
        if (r101 == null) goto L5;
        ActivityBaseTimeMonitor.f(r100, "schema_uri", r101);
    L5:
        return r100;
    }

    public final void h() {
        d("CORE_SCHEMA_END");
    }

    public e() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.monitor.ActivityBaseTimeMonitor
    public final JSONObject e(Map<String, Long> r110) {
        Intrinsics.checkNotNullParameter(r110, "timeEventMap");
        JSONObject r100 = new JSONObject();
        if (this.f107007c == false) goto L14;
        Long r101 = r110.get("CORE_SCHEMA_START");
        Long r111 = r110.get("CORE_SCHEMA_END");
        if (r101 == null) goto L64;
        if (r111 == null) goto L64;
        long r102 = r111.longValue();
        long r103 = r101.longValue();
        if (r103 <= 0) goto L64;
        if (r102 <= 0) goto L64;
        if (r102 < r103) goto L64;
        ActivityBaseTimeMonitor.f(r100, "core_schema_cost_time", Long.valueOf(r102 - r103));
    L64:
        return r100;
    L14:
        Long r104 = r110.get("HANDLE_SCHEMA_START");
        Long r105 = r110.get("GET_HANDLER_START");
        if (r104 == null) goto L24;
        if (r105 == null) goto L24;
        long r106 = r105.longValue();
        long r107 = r104.longValue();
        if (r107 <= 0) goto L24;
        if (r106 <= 0) goto L24;
        if (r106 < r107) goto L24;
        ActivityBaseTimeMonitor.f(r100, "get_handler_start_cost_time", Long.valueOf(r106 - r107));
    L24:
        Long r108 = r110.get("GET_HANDLER_START");
        Long r109 = r110.get("GET_HANDLER_END");
        if (r108 == null) goto L34;
        if (r109 == null) goto L34;
        long r112 = r109.longValue();
        long r113 = r108.longValue();
        if (r113 <= 0) goto L34;
        if (r112 <= 0) goto L34;
        if (r112 < r113) goto L34;
        ActivityBaseTimeMonitor.f(r100, "get_handler_cost_time", Long.valueOf(r112 - r113));
    L34:
        Long r114 = r110.get("GET_HANDLER_END");
        Long r115 = r110.get("START_HANDLE");
        if (r114 == null) goto L44;
        if (r115 == null) goto L44;
        long r116 = r115.longValue();
        long r117 = r114.longValue();
        if (r117 <= 0) goto L44;
        if (r116 <= 0) goto L44;
        if (r116 < r117) goto L44;
        ActivityBaseTimeMonitor.f(r100, "start_handle_cost_time", Long.valueOf(r116 - r117));
    L44:
        Long r118 = r110.get("START_HANDLE");
        Long r119 = r110.get("END_HANDLE_METHOD");
        if (r118 == null) goto L54;
        if (r119 == null) goto L54;
        long r120 = r119.longValue();
        long r121 = r118.longValue();
        if (r121 <= 0) goto L54;
        if (r120 <= 0) goto L54;
        if (r120 < r121) goto L54;
        ActivityBaseTimeMonitor.f(r100, "handle_method_cost_time", Long.valueOf(r120 - r121));
    L54:
        Long r122 = r110.get("HANDLE_SCHEMA_START");
        Long r123 = r110.get("END_HANDLE_METHOD");
        if (r122 == null) goto L64;
        if (r123 == null) goto L64;
        long r124 = r123.longValue();
        long r125 = r122.longValue();
        if (r125 <= 0) goto L64;
        if (r124 <= 0) goto L64;
        if (r124 < r125) goto L64;
        ActivityBaseTimeMonitor.f(r100, "total_cost_time", Long.valueOf(r124 - r125));
        goto L64
    }

    public final void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schemaName");
        if (LiveInfraSettingKeys.LIVE_ACTIVIY_TIME_MONITOR_SWITCH.getValue().booleanValue() == true) goto L5;
        return;
    L5:
        this.f107010f = r100;
        this.f107007c = true;
        this.f107009e = null;
        d("CORE_SCHEMA_START");
    }
}
