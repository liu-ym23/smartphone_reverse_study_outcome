package com.bytedance.android.live.core.activity;

import am2.x;
import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.livesdk.chatroom.event.VSUserProfileEvent;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.j0;
import com.larus.dora.api.model.FlowDoraWifiScene;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import r27.a;
import x40.e;

/* JADX INFO: loaded from: classes45.dex */
public final class BannerFullMonitor {

    public static final enum BannerType extends Enum<BannerType> {
        public static final BannerType BOTTOM_RIGHT = null;
        public static final BannerType OTHER = null;
        public static final BannerType TOP_RIGHT = null;
        public static final BannerType TOP_RIGHT_TASK = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BannerType[] f64746a = null;
        private String type;

        static {
            BannerType r100 = new BannerType("TOP_RIGHT", 0, "top_right");
            TOP_RIGHT = r100;
            BannerType r101 = new BannerType("BOTTOM_RIGHT", 1, VSUserProfileEvent.CLICK_POS_RIGHT);
            BOTTOM_RIGHT = r101;
            BannerType r102 = new BannerType("TOP_RIGHT_TASK", 2, "top_right_task");
            TOP_RIGHT_TASK = r102;
            BannerType r103 = new BannerType(FlowDoraWifiScene.OTHER, 3, "other");
            OTHER = r103;
            f64746a = new BannerType[]{r100, r101, r102, r103};
        }

        public static BannerType[] values() {
            return (BannerType[]) f64746a.clone();
        }

        public static /* synthetic */ String access$000(BannerType r100) {
            return r100.type;
        }

        public static BannerType valueOf(String r100) {
            return (BannerType) a.a(BannerType.class, r100);
        }

        public BannerType(String r100, int r101, String r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    public static void b(int r100, String r101, String r102, BannerType r110, String r111) {
        a("ttlive_in_room_banner_fetch_result", r100, r102, null, r101, r110, r111);
    }

    public static void a(String r100, int r110, @Nullable String r111, @Nullable String r112, @Nullable String r113, BannerType r114, String r115) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return;
    L6:
        if (ActivityMonitor.a() == true) goto L40;
        return;
    L40:
        JSONObject r101 = new JSONObject();     // Catch: JSONException -> L35
        if (r111 == null) goto L11;
        r101.put("room_id", r111);     // Catch: JSONException -> L35
    L11:
        if (r112 == null) goto L13;
        r101.put("url", r112);     // Catch: JSONException -> L35
    L13:
        if (r113 == null) goto L15;
        r101.put("status_msg", r113);     // Catch: JSONException -> L35
    L15:
        LiveTracingMonitor.EventModule r116 = LiveTracingMonitor.EventModule.ACTIVITY;     // Catch: JSONException -> L35
        JSONObject r117 = new JSONObject();     // Catch: JSONException -> L35
        r117.put("status_code", r110);     // Catch: JSONException -> L38
    L44:
        r117.put("category_1", BannerType.access$000(r114));     // Catch: JSONException -> L39
    L20:
        LiveMonitor r118 = new LiveMonitor();     // Catch: JSONException -> L35
        r118.mCategory = r117;     // Catch: JSONException -> L35
        r118.mEventModule = r116;     // Catch: JSONException -> L35
        r118.mServiceName = r100;     // Catch: JSONException -> L35
        r118.mExtraLog = r101;     // Catch: JSONException -> L35
        r118.mMetrics = null;     // Catch: JSONException -> L35
        LiveMonitor.access$002(r118, false);     // Catch: JSONException -> L35
        LiveMonitor.access$102(r118, false);     // Catch: JSONException -> L35
        LiveMonitor.access$202(r118, true);     // Catch: JSONException -> L35
        LiveMonitor.access$302(r118, false);     // Catch: JSONException -> L35
        LiveMonitor.access$402(r118, true);     // Catch: JSONException -> L35
        r118.report();     // Catch: JSONException -> L35
        o r119 = j0.l().c(x.class);     // Catch: JSONException -> L35
        if (r119 != null) goto L24;
    L28:
        String r120 = "";
    L30:
        if (e.a(r120) == false) goto L32;
        String r102 = r120;
    L33:
        ActivityMonitor.b(r100, r110, r101, BannerType.access$000(r114), r102, null, r115);     // Catch: JSONException -> L35
        return;
    L32:
        r102 = "";
        goto L33
    L24:
        if (r119.getMap() == null) goto L28;
        if (r119.getMap().containsKey("enter_from_merge") == false) goto L28;
        r120 = r119.getMap().get("enter_from_merge");     // Catch: JSONException -> L35
    L35:
        e = move-exception;
        ALogger.e("BannerFullMonitor", e);
    }
}
