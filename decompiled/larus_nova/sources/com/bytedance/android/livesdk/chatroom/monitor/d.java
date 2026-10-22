package com.bytedance.android.livesdk.chatroom.monitor;

import android.net.Uri;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class d extends ActivityBaseTimeMonitor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Uri f107005c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.monitor.ActivityBaseTimeMonitor
    public final String b() {
        return "ttlive_activity_open_container_duration";
    }

    @Override // com.bytedance.android.livesdk.chatroom.monitor.ActivityBaseTimeMonitor
    public final JSONObject a() {
        Uri r100 = this.f107005c;
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getHost();
    L6:
        if (r102 == null) goto L19;
        int r103 = r102.hashCode();
        if (r103 == 469921128) goto L17;
        if (r103 != 1435311181) goto L19;
        if (r102.equals("webcast_webview") == false) goto L19;
        r101 = "H5";
        goto L19
    L17:
        if (r102.equals("webcast_lynxview") == false) goto L19;
        r101 = "LYNX";
    L19:
        JSONObject r104 = new JSONObject();
        ActivityBaseTimeMonitor.f(r104, "containerType", r101);
        return r104;
    L5:
        r102 = null;
        goto L6
    }

    public d() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.monitor.ActivityBaseTimeMonitor
    public final JSONObject e(Map<String, Long> r110) {
        Intrinsics.checkNotNullParameter(r110, "timeEventMap");
        JSONObject r100 = new JSONObject();
        Long r101 = r110.get("OPEN_CONTAINER_START");
        Long r102 = r110.get("PREPARE_DATA");
        if (r101 == null) goto L12;
        if (r102 == null) goto L12;
        long r103 = r102.longValue();
        long r104 = r101.longValue();
        if (r104 <= 0) goto L12;
        if (r103 <= 0) goto L12;
        if (r103 < r104) goto L12;
        ActivityBaseTimeMonitor.f(r100, "prepare_data_start_cost_time", Long.valueOf(r103 - r104));
    L12:
        Long r105 = r110.get("PREPARE_DATA");
        Long r106 = r110.get("PREPARE_COMPONENT");
        if (r105 == null) goto L22;
        if (r106 == null) goto L22;
        long r107 = r106.longValue();
        long r108 = r105.longValue();
        if (r108 <= 0) goto L22;
        if (r107 <= 0) goto L22;
        if (r107 < r108) goto L22;
        ActivityBaseTimeMonitor.f(r100, "prepare_data_cost_time", Long.valueOf(r107 - r108));
    L22:
        Long r109 = r110.get("PREPARE_COMPONENT");
        Long r111 = r110.get("LOAD_URL");
        if (r109 == null) goto L32;
        if (r111 == null) goto L32;
        long r112 = r111.longValue();
        long r113 = r109.longValue();
        if (r113 <= 0) goto L32;
        if (r112 <= 0) goto L32;
        if (r112 < r113) goto L32;
        ActivityBaseTimeMonitor.f(r100, "prepare_component_cost_time", Long.valueOf(r112 - r113));
    L32:
        Long r114 = r110.get("LOAD_URL");
        Long r115 = r110.get("ON_PAGE_FINISH");
        if (r114 == null) goto L42;
        if (r115 == null) goto L42;
        long r116 = r115.longValue();
        long r117 = r114.longValue();
        if (r117 <= 0) goto L42;
        if (r116 <= 0) goto L42;
        if (r116 < r117) goto L42;
        ActivityBaseTimeMonitor.f(r100, "load_url_finish_cost_time", Long.valueOf(r116 - r117));
    L42:
        Long r118 = r110.get("OPEN_CONTAINER_START");
        Long r119 = r110.get("ON_PAGE_FINISH");
        if (r118 == null) goto L52;
        if (r119 == null) goto L52;
        long r120 = r119.longValue();
        long r121 = r118.longValue();
        if (r121 <= 0) goto L52;
        if (r120 <= 0) goto L52;
        if (r120 < r121) goto L52;
        ActivityBaseTimeMonitor.f(r100, "open_container_cost_time", Long.valueOf(r120 - r121));
    L52:
        return r100;
    }
}
