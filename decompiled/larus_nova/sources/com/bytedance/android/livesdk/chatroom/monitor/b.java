package com.bytedance.android.livesdk.chatroom.monitor;

import com.bytedance.android.livesdk.chatroom.r;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.live.datacontext.i;
import com.bytedance.locallife.cube.PrefetchTiming;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class b extends ActivityBaseTimeMonitor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f106996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f106997d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f106998e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f106999f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f107000g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f107001h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f107002i;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.monitor.ActivityBaseTimeMonitor
    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        ActivityBaseTimeMonitor.f(r100, "containerType", this.f106999f);
        return r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.monitor.ActivityBaseTimeMonitor
    public final String b() {
        String r100 = this.f107002i;
        int r101 = x40.b.f562422a;
        if (Intrinsics.areEqual(r100, "top_right_banner") == false) goto L6;
        return "ttlive_banner_top_full_link_duration";
    L6:
        if (Intrinsics.areEqual(r100, "bottom_banner") == false) goto L8;
        return "ttlive_banner_bottom_full_link_duration";
    L8:
        return "ttlive_banner_type_unknown_duration";
    }

    @Override // com.bytedance.android.livesdk.chatroom.monitor.ActivityBaseTimeMonitor
    public final JSONObject c() {
        JSONObject r100 = new JSONObject();
        ActivityBaseTimeMonitor.f(r100, "roomId", Long.valueOf(this.f107001h));
        ActivityBaseTimeMonitor.f(r100, "startStep", this.f106997d);
        return r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.monitor.ActivityBaseTimeMonitor
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        if (this.f107000g == false) goto L6;
        super.d(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.monitor.ActivityBaseTimeMonitor
    public final JSONObject e(Map<String, Long> r110) {
        Intrinsics.checkNotNullParameter(r110, "timeEventMap");
        JSONObject r100 = this.f106996c;
        r r101 = z51.a.c(null, 0);
        if (r101 == null) goto L7;
        i<Long> r102 = r101.getEnterRoomTime();
        if (r102 == null) goto L7;
        Long r103 = r102.getValue();
    L8:
        Long r104 = r110.get("BANNER_WIDGET_ONLOAD");
        if (r103 == null) goto L26;
        if (r104 == null) goto L26;
        long r105 = r104.longValue();
        long r106 = r103.longValue();
        if (r106 <= 0) goto L26;
        if (r105 <= 0) goto L26;
        if (r105 < r106) goto L26;
        ActivityBaseTimeMonitor.f(r100, "onLoad_cost_time", Long.valueOf(r105 - r106));
        if (this.f106997d != null) goto L26;
        this.f106997d = "startRoom";
        r r107 = z51.a.c(null, 0);
        if (r107 == null) goto L24;
        i<Long> r108 = r107.getEnterRoomTime();
        if (r108 == null) goto L24;
        Long r109 = r108.getValue();
    L25:
        this.f106998e = r109;
    L24:
        r109 = null;
    L26:
        Long r111 = r110.get("BANNER_WIDGET_ONLOAD");
        Long r112 = r110.get("FETCH_BANNER_DATA_START");
        if (r111 == null) goto L39;
        if (r112 == null) goto L39;
        long r113 = r112.longValue();
        long r114 = r111.longValue();
        if (r114 <= 0) goto L39;
        if (r113 <= 0) goto L39;
        if (r113 < r114) goto L39;
        long r115 = r113 - r114;
        ActivityBaseTimeMonitor.f(r100, "start_request_cost_time", Long.valueOf(r115));
        if (this.f106997d != null) goto L38;
        this.f106997d = WidgetCostModule.TYPE_ON_LOAD;
        this.f106998e = r110.get("BANNER_WIDGET_ONLOAD");
    L38:
        Long r116 = Long.valueOf(r115);
    L40:
        if (r116 == null) goto L157;
        r116.longValue();
        Long r117 = r110.get("FETCH_BANNER_DATA_START");
        Long r118 = r110.get("FETCH_BANNER_DATA_END");
        if (r117 == null) goto L51;
        if (r118 == null) goto L51;
        long r119 = r118.longValue();
        long r120 = r117.longValue();
        if (r120 <= 0) goto L51;
        if (r119 <= 0) goto L51;
        if (r119 < r120) goto L51;
        long r121 = r119 - r120;
        ActivityBaseTimeMonitor.f(r100, "request_cost_time", Long.valueOf(r121));
        Long r122 = Long.valueOf(r121);
    L52:
        if (r122 == null) goto L157;
        r122.longValue();
        Long r123 = r110.get("FETCH_BANNER_DATA_END");
        Long r124 = r110.get("PROCESS_BANNER_DATA_START");
        if (r123 == null) goto L63;
        if (r124 == null) goto L63;
        long r125 = r124.longValue();
        long r126 = r123.longValue();
        if (r126 <= 0) goto L63;
        if (r125 <= 0) goto L63;
        if (r125 < r126) goto L63;
        long r127 = r125 - r126;
        ActivityBaseTimeMonitor.f(r100, "start_process_cost_time", Long.valueOf(r127));
        Long r128 = Long.valueOf(r127);
    L64:
        if (r128 == null) goto L157;
        r128.longValue();
        Long r129 = r110.get("PROCESS_BANNER_DATA_START");
        Long r130 = r110.get("PROCESS_BANNER_DATA_END");
        if (r129 == null) goto L75;
        if (r130 == null) goto L75;
        long r131 = r130.longValue();
        long r132 = r129.longValue();
        if (r132 <= 0) goto L75;
        if (r131 <= 0) goto L75;
        if (r131 < r132) goto L75;
        long r133 = r131 - r132;
        ActivityBaseTimeMonitor.f(r100, "activity_banner_process_cost_time", Long.valueOf(r133));
        Long r134 = Long.valueOf(r133);
    L76:
        if (r134 == null) goto L157;
        r134.longValue();
        Long r135 = r110.get("CREATE_HYBRID_VIEW_START");
        Long r136 = r110.get("CREATE_HYBRID_VIEW_END");
        if (r135 == null) goto L87;
        if (r136 == null) goto L87;
        long r137 = r136.longValue();
        long r138 = r135.longValue();
        if (r138 <= 0) goto L87;
        if (r137 <= 0) goto L87;
        if (r137 < r138) goto L87;
        long r139 = r137 - r138;
        ActivityBaseTimeMonitor.f(r100, "hybrid_create_cost_time", Long.valueOf(r139));
        Long r140 = Long.valueOf(r139);
    L88:
        if (r140 == null) goto L157;
        r140.longValue();
        Long r141 = r110.get("CREATE_HYBRID_VIEW_END");
        Long r142 = r110.get("LOAD_URL_START");
        if (r141 == null) goto L99;
        if (r142 == null) goto L99;
        long r143 = r142.longValue();
        long r144 = r141.longValue();
        if (r144 <= 0) goto L99;
        if (r143 <= 0) goto L99;
        if (r143 < r144) goto L99;
        long r145 = r143 - r144;
        ActivityBaseTimeMonitor.f(r100, "start_load_url_cost_time", Long.valueOf(r145));
        Long r146 = Long.valueOf(r145);
    L100:
        if (r146 == null) goto L157;
        r146.longValue();
        Long r147 = r110.get("LOAD_URL_START");
        Long r148 = r110.get("LOAD_URL_END");
        if (r147 == null) goto L111;
        if (r148 == null) goto L111;
        long r149 = r148.longValue();
        long r150 = r147.longValue();
        if (r150 <= 0) goto L111;
        if (r149 <= 0) goto L111;
        if (r149 < r150) goto L111;
        long r151 = r149 - r150;
        ActivityBaseTimeMonitor.f(r100, "load_url_cost_time", Long.valueOf(r151));
        Long r152 = Long.valueOf(r151);
    L112:
        if (r152 == null) goto L157;
        r152.longValue();
        Long r153 = r110.get("LOAD_URL_END");
        Long r154 = r110.get("ON_PAGE_FINISHED");
        if (r153 == null) goto L123;
        if (r154 == null) goto L123;
        long r155 = r154.longValue();
        long r156 = r153.longValue();
        if (r156 <= 0) goto L123;
        if (r155 <= 0) goto L123;
        if (r155 < r156) goto L123;
        long r157 = r155 - r156;
        ActivityBaseTimeMonitor.f(r100, "onPageFinish_cost_time", Long.valueOf(r157));
        Long r158 = Long.valueOf(r157);
    L124:
        if (r158 == null) goto L157;
        r158.longValue();
        r r159 = z51.a.c(null, 0);
        if (r159 == null) goto L130;
        i<Long> r160 = r159.getEnterRoomTime();
        if (r160 == null) goto L130;
        Long r161 = r160.getValue();
    L131:
        Long r162 = r110.get("ON_PAGE_FINISHED");
        if (r161 == null) goto L141;
        if (r162 == null) goto L141;
        long r163 = r162.longValue();
        long r164 = r161.longValue();
        if (r164 <= 0) goto L141;
        if (r163 <= 0) goto L141;
        if (r163 < r164) goto L141;
        long r165 = r163 - r164;
        ActivityBaseTimeMonitor.f(r100, "total_cost_time_from_start_live", Long.valueOf(r165));
        Long r166 = Long.valueOf(r165);
    L142:
        if (r166 == null) goto L157;
        r166.longValue();
        Long r167 = this.f106998e;
        Long r168 = r110.get("ON_PAGE_FINISHED");
        if (r167 == null) goto L153;
        if (r168 == null) goto L153;
        long r169 = r168.longValue();
        long r170 = r167.longValue();
        if (r170 <= 0) goto L153;
        if (r169 <= 0) goto L153;
        if (r169 < r170) goto L153;
        long r171 = r169 - r170;
        ActivityBaseTimeMonitor.f(r100, "total_cost_time", Long.valueOf(r171));
        Long r172 = Long.valueOf(r171);
    L154:
        if (r172 == null) goto L157;
        r172.longValue();
        return r100;
    L153:
        r172 = null;
    L141:
        r166 = null;
    L130:
        r161 = null;
    L123:
        r158 = null;
    L111:
        r152 = null;
    L99:
        r146 = null;
    L87:
        r140 = null;
    L75:
        r134 = null;
    L63:
        r128 = null;
    L51:
        r122 = null;
    L157:
        return null;
    L39:
        r116 = null;
    L7:
        r103 = null;
        goto L8
    }

    public b(long r100, boolean r110) {
        Intrinsics.checkNotNullParameter("top_right_banner", "activityType");
        this.f107001h = r100;
        this.f107002i = "top_right_banner";
        JSONObject r101 = new JSONObject();
        this.f106996c = r101;
        this.f107000g = r110;
        Map<String, x40.i> r111 = x40.f.f562424a;
        Map r102 = x40.f.c("top_right_banner", Long.valueOf(r100));
        if (r102 == null) goto L41;
        Long r112 = (Long) r102.get("OPEN_LIVE_JSB_START");
        Long r103 = (Long) r102.get("OPEN_LIVE_JSB_END");
        if (r112 == null) goto L14;
        if (r103 == null) goto L14;
        long r104 = r103.longValue();
        long r105 = r112.longValue();
        if (r105 <= 0) goto L14;
        if (r104 <= 0) goto L14;
        if (r104 < r105) goto L14;
        ActivityBaseTimeMonitor.f(r101, "activity_jsb_process_cost_time", Long.valueOf(r104 - r105));
        this.f106997d = PrefetchTiming.JSB;
        this.f106998e = (Long) r102.get("OPEN_LIVE_JSB_START");
    L14:
        Long r113 = (Long) r102.get("OPEN_LIVE_SCHEMA_START");
        Long r106 = (Long) r102.get("OPEN_LIVE_SCHEMA_END");
        if (r113 == null) goto L26;
        if (r106 == null) goto L26;
        long r107 = r106.longValue();
        long r108 = r113.longValue();
        if (r108 <= 0) goto L26;
        if (r107 <= 0) goto L26;
        if (r107 < r108) goto L26;
        ActivityBaseTimeMonitor.f(r101, "activity_schema_process_cost_time", Long.valueOf(r107 - r108));
        if (this.f106997d != null) goto L26;
        this.f106997d = "schema";
        this.f106998e = (Long) r102.get("OPEN_LIVE_SCHEMA_START");
    L26:
        Long r109 = (Long) r102.get("OPEN_LIVE_SCHEMA_END");
        Long r114 = null;
        r r115 = z51.a.c(null, 0);
        if (r115 == null) goto L31;
        i<Long> r116 = r115.getEnterRoomTime();
        if (r116 == null) goto L31;
        r114 = r116.getValue();
    L31:
        if (r109 == null) goto L42;
        if (r114 == null) goto L43;
        long r117 = r114.longValue();
        long r118 = r109.longValue();
        if (r118 > 0) goto L36;
        return;
    L36:
        if (r117 > 0) goto L38;
        return;
    L38:
        if (r117 < r118) goto L46;
        ActivityBaseTimeMonitor.f(r101, "activity_enter_room_cost_time", Long.valueOf(r117 - r118));
        return;
    L46:
        return;
    L43:
        return;
    L42:
        return;
    }
}
