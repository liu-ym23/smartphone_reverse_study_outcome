package com.bytedance.android.livesdk.chatroom.monitor;

import com.bytedance.android.livesdk.chatroom.r;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.live.datacontext.i;
import com.bytedance.locallife.cube.PrefetchTiming;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class f extends ActivityBaseTimeMonitor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f107011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f107012d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f107013e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f107014f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f107015g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f107016h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f107017i;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.monitor.ActivityBaseTimeMonitor
    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        ActivityBaseTimeMonitor.f(r100, "containerType", this.f107015g);
        return r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.monitor.ActivityBaseTimeMonitor
    public final String b() {
        int r100 = this.f107017i;
        if (r100 != 1) goto L5;
        return "ttlive_short_touch_full_link_stage1_duration";
    L5:
        if (r100 == 2) goto L7;
        return "ttlive_short_touch_unknown_stage_duration";
    L7:
        return "ttlive_short_touch_full_link_stage2_duration";
    }

    @Override // com.bytedance.android.livesdk.chatroom.monitor.ActivityBaseTimeMonitor
    public final JSONObject c() {
        JSONObject r100 = new JSONObject();
        ActivityBaseTimeMonitor.f(r100, "roomId", Long.valueOf(this.f107016h));
        ActivityBaseTimeMonitor.f(r100, "startStep", this.f107012d);
        return r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.monitor.ActivityBaseTimeMonitor
    public final JSONObject e(Map<String, Long> r110) {
        Intrinsics.checkNotNullParameter(r110, "timeEventMap");
        if (this.f107014f == false) goto L5;
        return null;
    L5:
        this.f107014f = true;
        int r100 = this.f107017i;
        if (r100 != 1) goto L8;
        JSONObject r101 = this.f107011c;
        r r102 = z51.a.c(null, 0);
        if (r102 == null) goto L101;
        i<Long> r103 = r102.getEnterRoomTime();
        if (r103 == null) goto L101;
        Long r104 = r103.getValue();
    L102:
        Long r105 = r110.get("ST_WIDGET_ONCREATE");
        if (r104 == null) goto L121;
        if (r105 == null) goto L121;
        long r106 = r105.longValue();
        long r107 = r104.longValue();
        if (r107 <= 0) goto L121;
        if (r106 <= 0) goto L121;
        if (r106 < r107) goto L121;
        long r108 = r106 - r107;
        ActivityBaseTimeMonitor.f(r101, "widget_oncreate_cost_time", Long.valueOf(r108));
        if (this.f107012d != null) goto L120;
        this.f107012d = "startRoom";
        r r109 = z51.a.c(null, 0);
        if (r109 == null) goto L118;
        i<Long> r111 = r109.getEnterRoomTime();
        if (r111 == null) goto L118;
        Long r112 = r111.getValue();
    L119:
        this.f107013e = r112;
    L118:
        r112 = null;
    L120:
        Long r113 = Long.valueOf(r108);
    L122:
        if (r113 == null) goto L201;
        r113.longValue();
        Long r114 = r110.get("ST_WIDGET_ONCREATE");
        Long r115 = r110.get("FETCH_ST_DATA_START");
        if (r114 == null) goto L136;
        if (r115 == null) goto L136;
        long r116 = r115.longValue();
        long r117 = r114.longValue();
        if (r117 <= 0) goto L136;
        if (r116 <= 0) goto L136;
        if (r116 < r117) goto L136;
        long r118 = r116 - r117;
        ActivityBaseTimeMonitor.f(r101, "start_request_cost_time", Long.valueOf(r118));
        if (this.f107012d != null) goto L135;
        this.f107012d = WidgetCostModule.TYPE_ON_CREATE;
        this.f107013e = r110.get("ST_WIDGET_ONCREATE");
    L135:
        Long r119 = Long.valueOf(r118);
    L137:
        if (r119 == null) goto L202;
        r119.longValue();
        Long r120 = r110.get("FETCH_ST_DATA_START");
        Long r121 = r110.get("FETCH_ST_DATA_END");
        if (r120 == null) goto L148;
        if (r121 == null) goto L148;
        long r122 = r121.longValue();
        long r123 = r120.longValue();
        if (r123 <= 0) goto L148;
        if (r122 <= 0) goto L148;
        if (r122 < r123) goto L148;
        long r124 = r122 - r123;
        ActivityBaseTimeMonitor.f(r101, "request_cost_time", Long.valueOf(r124));
        Long r125 = Long.valueOf(r124);
    L149:
        if (r125 == null) goto L203;
        r125.longValue();
        Long r126 = r110.get("FETCH_ST_DATA_END");
        Long r127 = r110.get("STI_FRAMEWORK_LOAD");
        if (r126 == null) goto L160;
        if (r127 == null) goto L160;
        long r128 = r127.longValue();
        long r129 = r126.longValue();
        if (r129 <= 0) goto L160;
        if (r128 <= 0) goto L160;
        if (r128 < r129) goto L160;
        long r130 = r128 - r129;
        ActivityBaseTimeMonitor.f(r101, "sti_load_cost_time", Long.valueOf(r130));
        Long r131 = Long.valueOf(r130);
    L161:
        if (r131 == null) goto L204;
        r131.longValue();
        r r132 = z51.a.c(null, 0);
        if (r132 == null) goto L167;
        i<Long> r133 = r132.getEnterRoomTime();
        if (r133 == null) goto L167;
        Long r134 = r133.getValue();
    L168:
        Long r135 = r110.get("STI_FRAMEWORK_LOAD");
        if (r134 == null) goto L178;
        if (r135 == null) goto L178;
        long r136 = r135.longValue();
        long r137 = r134.longValue();
        if (r137 <= 0) goto L178;
        if (r136 <= 0) goto L178;
        if (r136 < r137) goto L178;
        long r138 = r136 - r137;
        ActivityBaseTimeMonitor.f(r101, "stage1_cost_time_from_start_live", Long.valueOf(r138));
        Long r139 = Long.valueOf(r138);
    L179:
        if (r139 == null) goto L205;
        r139.longValue();
        Long r140 = this.f107013e;
        Long r141 = r110.get("STI_FRAMEWORK_LOAD");
        if (r140 == null) goto L190;
        if (r141 == null) goto L190;
        long r142 = r141.longValue();
        long r143 = r140.longValue();
        if (r143 <= 0) goto L190;
        if (r142 <= 0) goto L190;
        if (r142 < r143) goto L190;
        long r144 = r142 - r143;
        ActivityBaseTimeMonitor.f(r101, "stage1_cost_time", Long.valueOf(r144));
        Long r145 = Long.valueOf(r144);
    L191:
        if (r145 == null) goto L206;
        r145.longValue();
        return r101;
    L206:
        return null;
    L190:
        r145 = null;
        goto L191
    L205:
        return null;
    L178:
        r139 = null;
    L167:
        r134 = null;
        goto L168
    L204:
        return null;
    L160:
        r131 = null;
        goto L161
    L203:
        return null;
    L148:
        r125 = null;
        goto L149
    L202:
        return null;
    L136:
        r119 = null;
        goto L137
    L201:
        return null;
    L121:
        r113 = null;
    L101:
        r104 = null;
        goto L102
    L8:
        if (r100 == 2) goto L10;
        return null;
    L10:
        JSONObject r146 = new JSONObject();
        Long r147 = r110.get("ST_ICONMODEL_ONCREATE");
        Long r148 = r110.get("GET_ICON_VIEW");
        if (r147 == null) goto L20;
        if (r148 == null) goto L20;
        long r149 = r148.longValue();
        long r150 = r147.longValue();
        if (r150 <= 0) goto L20;
        if (r149 <= 0) goto L20;
        if (r149 < r150) goto L20;
        long r151 = r149 - r150;
        ActivityBaseTimeMonitor.f(r146, "get_iconview_cost_time", Long.valueOf(r151));
        Long r152 = Long.valueOf(r151);
    L21:
        if (r152 == null) goto L194;
        r152.longValue();
        Long r153 = r110.get("GET_ICON_VIEW");
        Long r154 = r110.get("CREATE_HYBRID_VIEW_START");
        if (r153 == null) goto L32;
        if (r154 == null) goto L32;
        long r155 = r154.longValue();
        long r156 = r153.longValue();
        if (r156 <= 0) goto L32;
        if (r155 <= 0) goto L32;
        if (r155 < r156) goto L32;
        long r157 = r155 - r156;
        ActivityBaseTimeMonitor.f(r146, "start_create_hybrid_view_cost_time", Long.valueOf(r157));
        Long r158 = Long.valueOf(r157);
    L33:
        if (r158 == null) goto L195;
        r158.longValue();
        Long r159 = r110.get("CREATE_HYBRID_VIEW_START");
        Long r160 = r110.get("CREATE_HYBRID_VIEW_END");
        if (r159 == null) goto L44;
        if (r160 == null) goto L44;
        long r161 = r160.longValue();
        long r162 = r159.longValue();
        if (r162 <= 0) goto L44;
        if (r161 <= 0) goto L44;
        if (r161 < r162) goto L44;
        long r163 = r161 - r162;
        ActivityBaseTimeMonitor.f(r146, "create_hybrid_view_cost_time", Long.valueOf(r163));
        Long r164 = Long.valueOf(r163);
    L45:
        if (r164 == null) goto L196;
        r164.longValue();
        Long r165 = r110.get("CREATE_HYBRID_VIEW_END");
        Long r166 = r110.get("LOAD_URL_START");
        if (r165 == null) goto L56;
        if (r166 == null) goto L56;
        long r167 = r166.longValue();
        long r168 = r165.longValue();
        if (r168 <= 0) goto L56;
        if (r167 <= 0) goto L56;
        if (r167 < r168) goto L56;
        long r169 = r167 - r168;
        ActivityBaseTimeMonitor.f(r146, "start_load_url_cost_time", Long.valueOf(r169));
        Long r170 = Long.valueOf(r169);
    L57:
        if (r170 == null) goto L197;
        r170.longValue();
        Long r171 = r110.get("LOAD_URL_START");
        Long r172 = r110.get("LOAD_URL_END");
        if (r171 == null) goto L68;
        if (r172 == null) goto L68;
        long r173 = r172.longValue();
        long r174 = r171.longValue();
        if (r174 <= 0) goto L68;
        if (r173 <= 0) goto L68;
        if (r173 < r174) goto L68;
        long r175 = r173 - r174;
        ActivityBaseTimeMonitor.f(r146, "load_url_cost_time", Long.valueOf(r175));
        Long r176 = Long.valueOf(r175);
    L69:
        if (r176 == null) goto L198;
        r176.longValue();
        Long r177 = r110.get("LOAD_URL_END");
        Long r178 = r110.get("ON_PAGE_FINISHED");
        if (r177 == null) goto L80;
        if (r178 == null) goto L80;
        long r179 = r178.longValue();
        long r180 = r177.longValue();
        if (r180 <= 0) goto L80;
        if (r179 <= 0) goto L80;
        if (r179 < r180) goto L80;
        long r181 = r179 - r180;
        ActivityBaseTimeMonitor.f(r146, "onPageFinish_cost_time", Long.valueOf(r181));
        Long r182 = Long.valueOf(r181);
    L81:
        if (r182 == null) goto L199;
        r182.longValue();
        Long r183 = r110.get("ST_ICONMODEL_ONCREATE");
        Long r184 = r110.get("ON_PAGE_FINISHED");
        if (r183 == null) goto L92;
        if (r184 == null) goto L92;
        long r185 = r184.longValue();
        long r186 = r183.longValue();
        if (r186 <= 0) goto L92;
        if (r185 <= 0) goto L92;
        if (r185 < r186) goto L92;
        long r187 = r185 - r186;
        ActivityBaseTimeMonitor.f(r146, "stage2_cost_time", Long.valueOf(r187));
        Long r188 = Long.valueOf(r187);
    L93:
        if (r188 == null) goto L200;
        r188.longValue();
        return r146;
    L200:
        return null;
    L92:
        r188 = null;
        goto L93
    L199:
        return null;
    L80:
        r182 = null;
        goto L81
    L198:
        return null;
    L68:
        r176 = null;
        goto L69
    L197:
        return null;
    L56:
        r170 = null;
        goto L57
    L196:
        return null;
    L44:
        r164 = null;
        goto L45
    L195:
        return null;
    L32:
        r158 = null;
        goto L33
    L194:
        return null;
    L20:
        r152 = null;
        goto L21
    }

    public f(long r100, int r110) {
        this.f107016h = r100;
        this.f107017i = r110;
        JSONObject r101 = new JSONObject();
        this.f107011c = r101;
        if (r110 != 1) goto L43;
        Map<String, x40.i> r111 = x40.f.f562424a;
        int r112 = x40.b.f562422a;
        Map r102 = x40.f.c("short_touch", Long.valueOf(r100));
        if (r102 == null) goto L44;
        Long r113 = (Long) r102.get("OPEN_LIVE_JSB_START");
        Long r103 = (Long) r102.get("OPEN_LIVE_JSB_END");
        if (r113 == null) goto L16;
        if (r103 == null) goto L16;
        long r104 = r103.longValue();
        long r105 = r113.longValue();
        if (r105 <= 0) goto L16;
        if (r104 <= 0) goto L16;
        if (r104 < r105) goto L16;
        ActivityBaseTimeMonitor.f(r101, "activity_jsb_process_cost_time", Long.valueOf(r104 - r105));
        this.f107012d = PrefetchTiming.JSB;
        this.f107013e = (Long) r102.get("OPEN_LIVE_JSB_START");
    L16:
        Long r114 = (Long) r102.get("OPEN_LIVE_SCHEMA_START");
        Long r106 = (Long) r102.get("OPEN_LIVE_SCHEMA_END");
        if (r114 == null) goto L28;
        if (r106 == null) goto L28;
        long r107 = r106.longValue();
        long r108 = r114.longValue();
        if (r108 <= 0) goto L28;
        if (r107 <= 0) goto L28;
        if (r107 < r108) goto L28;
        ActivityBaseTimeMonitor.f(r101, "activity_schema_process_cost_time", Long.valueOf(r107 - r108));
        if (this.f107012d != null) goto L28;
        this.f107012d = "schema";
        this.f107013e = (Long) r102.get("OPEN_LIVE_SCHEMA_START");
    L28:
        Long r109 = (Long) r102.get("OPEN_LIVE_SCHEMA_END");
        Long r115 = null;
        r r116 = z51.a.c(null, 0);
        if (r116 == null) goto L33;
        i<Long> r117 = r116.getEnterRoomTime();
        if (r117 == null) goto L33;
        r115 = r117.getValue();
    L33:
        if (r109 == null) goto L45;
        if (r115 == null) goto L46;
        long r118 = r115.longValue();
        long r119 = r109.longValue();
        if (r119 > 0) goto L38;
        return;
    L38:
        if (r118 > 0) goto L40;
        return;
    L40:
        if (r118 < r119) goto L49;
        ActivityBaseTimeMonitor.f(r101, "activity_enter_room_cost_time", Long.valueOf(r118 - r119));
        return;
    L49:
        return;
    L46:
        return;
    L45:
        return;
    L44:
        return;
    }
}
