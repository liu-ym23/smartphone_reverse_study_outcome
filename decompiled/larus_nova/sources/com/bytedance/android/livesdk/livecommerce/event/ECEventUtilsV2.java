package com.bytedance.android.livesdk.livecommerce.event;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.livesdk.livecommerce.promotionlist.LivePromotionListFragment;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.ExtraController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.utils.EnumEntranceInfoScene;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class ECEventUtilsV2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f147717a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ECEventUtilsV2 f147718b = null;

    public ECEventUtilsV2() {
    }

    static {
        f147718b = new ECEventUtilsV2();
        f147717a = LazyKt.lazy(ECEventUtilsV2$AD_ENTER_FROM_MERGE_PATTERN$2.INSTANCE);
    }

    @Deprecated(message = "减少使用单例获取直播间参数, 改为LiveRoomParams.getEntranceInfo()")
    public static String a(String r100) {
        return b(r100, l0.g(), l0.o(), null, null, null);
    }

    public static JSONObject d(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "reportParams");
        JSONObject r101 = new JSONObject();
        String r102 = (String) r100.get("enter_from_merge");
        String r103 = (String) r100.get("is_other_channel");
        r101.put("room_id", r100.get("room_id"));     // Catch: Exception -> L25
        r101.put("author_id", r100.get("anchor_id"));     // Catch: Exception -> L25
        r101.put(com.bytedance.android.ec.core.event.a.KEY_CHANNEL_ID, r102);     // Catch: Exception -> L25
        r101.put("request_id", r100.get("request_id"));     // Catch: Exception -> L25
        String r104 = (String) r100.get("creative_id");     // Catch: Exception -> L25
        if (r104 != null) goto L6;
        r104 = "";
    L6:
        r101.put("cid", r104);     // Catch: Exception -> L25
        f147718b.getClass();     // Catch: Exception -> L25
        boolean r105 = false;
        boolean r106 = ((Pattern) f147717a.getValue()).matcher(r102).matches();     // Catch: Exception -> L10
    L11:
        if (r102 == null) goto L16;
        if (r106 == false) goto L14;
    L19:
        r105 = true;
    L20:
        if (r105 == false) goto L22;
        String r107 = "1";
    L23:
        r101.put("is_from_ad", r107);     // Catch: Exception -> L25
    L27:
        return r101;
    L22:
        r107 = "0";
        goto L23
    L14:
        if (Intrinsics.areEqual(r102, "topview") == true) goto L19;
    L16:
        if (Intrinsics.areEqual(com.bytedance.android.ec.core.event.a.VALUE_EFFECTIVE_AD, r103) == true) goto L19;
        if (Intrinsics.areEqual(IPerformanceManager.SCENE_CLICK_DOU_PLUS, r103) == false) goto L20;
    L10:
        r106 = false;
    L25:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L27
    }

    @Deprecated(message = "减少使用单例获取直播间参数, 改为LiveRoomParams.getEntranceInfo()")
    public static String e(String r100) {
        PromotionListController.T.getClass();
        PromotionListController r101 = PromotionListController.a.a();
        if (r101.x() == false) goto L5;
        LivePromotionListFragment r102 = r101.f151548c;
    L6:
        if (r102 == null) goto L10;
        ECEventUtilsV2 r103 = f147718b;
        String r104 = r102.ca0();
        r103.getClass();
        String r105 = c(r103, r100, r104, l0.f147741a);
        if (r105 == null) goto L10;
        return r105;
    L10:
        return a(r100);
    L5:
        r102 = null;
        goto L6
    }

    @Deprecated(message = "减少使用单例获取直播间参数, 改为LiveRoomParams.getEntranceInfo()")
    public static JSONObject f(String r100, String r101, String r110) {
        Intrinsics.checkNotNullParameter(r100, "carrierType");
        HashMap<String, String> r102 = l0.g();
        HashMap<String, String> r103 = l0.o();
        int r104 = RoomContextController.f151593h;
        RoomContextController r105 = RoomContextController.a.a();
        JSONObject r106 = new JSONObject();
        Iterator<T> r107 = r102.entrySet().iterator();
    L4:
        if (r107.hasNext() == false) goto L53;
        Map.Entry r108 = (Map.Entry) r107.next();
        r106.put((String) r108.getKey(), r108.getValue());
        goto L4
    L53:
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L19
        if (r110 == null) goto L16;
        JSONObject r111 = com.bytedance.android.ec.core.utils.z1.g(r110);     // Catch: Throwable -> L19
        if (r111 == null) goto L16;
        Iterator<String> r112 = r111.keys();     // Catch: Throwable -> L19
    L13:
        if (r112.hasNext() == false) goto L15;
        String r113 = r112.next();     // Catch: Throwable -> L19
        r106.put(r113, r111.opt(r113));     // Catch: Throwable -> L19
        goto L13
    L15:
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L19
    L17:
        Result.m9449constructorimpl(r114);     // Catch: Throwable -> L19
    L21:
        r106.put("enter_from", "live");
        StringBuilder r115 = new StringBuilder();
        String r116 = r102.get("enter_from_merge");
        String r117 = "";
        if (r116 != null) goto L24;
        r116 = "";
    L24:
        r115.append(r116);
        r115.append("_temai_");
        String r118 = r102.get("enter_method");
        if (r118 == null) goto L28;
        r117 = r118;
    L28:
        r115.append(r117);
        r106.put("category_name", r115.toString());
        Iterator<T> r119 = r103.entrySet().iterator();
    L30:
        if (r119.hasNext() == false) goto L33;
        Map.Entry r120 = (Map.Entry) r119.next();
        r106.put((String) r120.getKey(), r120.getValue());
        goto L30
    L33:
        if (TextUtils.isEmpty(r100) == true) goto L35;
        r106.put("carrier_type", r100);
    L35:
        if (r101 == null) goto L37;
        r106.put(com.bytedance.android.ec.core.event.a.KEY_LIVE_LIST_CHANNEL, r101);
    L37:
        l0.q(r106);
        r106.put("display_room_id", r105.B());
        r106.put("display_anchor_id", r105.y());
        r106.put("display_sec_anchor_id", r105.z());
        r106.put("display_follow_status", r105.K().get("follow_status"));
        int r121 = com.bytedance.android.livesdk.livecommerce.room.controller.w.f151719h;
        r106.put("ecom_scene_id", com.bytedance.android.livesdk.livecommerce.room.controller.w.a.b());
        com.bytedance.android.ec.model.response.n1 r122 = r105.f151597f;
        if (r122 == null) goto L42;
        List<Long> r123 = r122.a();
        if (r123 == null) goto L42;
        int r124 = com.bytedance.android.livesdk.livecommerce.utils.m0.f153098a;
        r106.put("ecom_linkmic_room_ids", GsonProtectorUtils.toJson(com.bytedance.android.livesdk.livecommerce.utils.m0.a.f153099a, r123));
    L42:
        Lazy r125 = ExtraController.f151511l;
        ExtraController r126 = ControllerCenter.c(null, null).f151430u;
        Objects.toString(r126);
        JSONObject r127 = r126.H();
        if (r127 == null) goto L52;
        Iterator<String> r128 = r127.keys();
    L46:
        if (r128.hasNext() == false) goto L52;
        String r129 = r128.next();
        r106.put(r129, r127.optString(r129));     // Catch: JSONException -> L50
    L50:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L52:
        return r106;
    L16:
        r114 = null;
    L19:
        th = move-exception;
        Result.Companion r130 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    }

    public static String c(ECEventUtilsV2 r100, String r101, String r102, String r103) {
        r100.getClass();
        return b(r101, l0.g(), l0.o(), r102, r103, null);
    }

    public static String b(final String r310, final Map r311, final Map r312, final String r313, final String r314, final String r315) {
        Intrinsics.checkNotNullParameter(r312, "params");
        int r100 = com.bytedance.android.livesdk.livecommerce.utils.q.f153109a;     // Catch: Exception -> L130
        gl.a r110 = com.bytedance.android.livesdk.livecommerce.utils.q.a(EnumEntranceInfoScene.ECOM_LIVE_REQUEST, null);     // Catch: Exception -> L130
        if (r311 == null) goto L13;
        String r101 = (String) r311.get("enter_from_merge");     // Catch: Exception -> L130
        if (r101 != null) goto L9;
        r101 = "";
    L9:
        String r102 = (String) r311.get("enter_method");     // Catch: Exception -> L130
        if (r102 != null) goto L12;
        r102 = "";
    L12:
        String r111 = r101;
        String r103 = r102;
    L15:
        if (r110 == null) goto L43;
        Pair[] r104 = new Pair[8];     // Catch: Exception -> L130
        r104[0] = TuplesKt.to("enter_from_merge", r111);     // Catch: Exception -> L130
        r104[1] = TuplesKt.to("enter_method", r103);     // Catch: Exception -> L130
        if (r311 == null) goto L19;
        String r105 = (String) r311.get("action_type");     // Catch: Exception -> L130
    L20:
        r104[2] = TuplesKt.to("action_type", r105);     // Catch: Exception -> L130
        if (r311 == null) goto L23;
        String r106 = (String) r311.get("creative_id");     // Catch: Exception -> L130
    L24:
        r104[3] = TuplesKt.to("creative_id", r106);     // Catch: Exception -> L130
        if (r311 == null) goto L27;
        String r107 = (String) r311.get("is_other_channel");     // Catch: Exception -> L130
    L28:
        r104[4] = TuplesKt.to("is_other_channel", r107);     // Catch: Exception -> L130
        if (r311 == null) goto L31;
        String r108 = (String) r311.get("enter_from");     // Catch: Exception -> L130
    L32:
        r104[5] = TuplesKt.to("enter_from", r108);     // Catch: Exception -> L130
        if (r311 == null) goto L35;
        String r109 = (String) r311.get("coupon_category");     // Catch: Exception -> L130
    L36:
        r104[6] = TuplesKt.to("coupon_category", r109);     // Catch: Exception -> L130
        if (r311 == null) goto L39;
        String r112 = (String) r311.get(com.bytedance.android.ec.core.event.a.KEY_SUBSIDIZED_ACTIVITY);     // Catch: Exception -> L130
    L40:
        r104[7] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SUBSIDIZED_ACTIVITY, r112);     // Catch: Exception -> L130
        String r210 = "";
        String r211 = com.bytedance.android.ec.core.event.a.KEY_SUBSIDIZED_ACTIVITY;
        String r212 = "coupon_category";
        String r213 = "is_other_channel";
        int r113 = 1;
        com.bytedance.android.livesdk.livecommerce.utils.s.b(r110, r104, new ECEventUtilsV2$getEntranceInfo$$inlined$run$lambda$1(r311, r314, r310, r312, r313, r315));     // Catch: Exception -> L52
    L44:
        if (r110 == null) goto L144;
        Pair[] r114 = new Pair[r113];     // Catch: Exception -> L52
        if (r311 == null) goto L49;
        String r115 = (String) r311.get("request_id");     // Catch: Exception -> L52
    L50:
        r114[0] = TuplesKt.to("request_id", r115);     // Catch: Exception -> L52
        com.bytedance.android.livesdk.livecommerce.utils.s.b(r110, r114, new ECEventUtilsV2$getEntranceInfo$$inlined$run$lambda$2(r311, r314, r310, r312, r313, r315));     // Catch: Exception -> L52
        goto L144
    L49:
        r115 = null;
    L144:
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L107
        if (r314 == null) goto L57;
        final JSONObject r117 = com.bytedance.android.ec.core.utils.z1.g(r314);     // Catch: Throwable -> L107
    L58:
        if (r110 == null) goto L102;
        Pair[] r118 = new Pair[8];     // Catch: Throwable -> L107
        if (r117 == null) goto L62;
        String r119 = r117.optString("enter_from_merge");     // Catch: Throwable -> L107
    L63:
        r118[0] = TuplesKt.to("enter_from_merge", r119);     // Catch: Throwable -> L107
        if (r117 == null) goto L66;
        String r120 = r117.optString("enter_method");     // Catch: Throwable -> L107
    L67:
        r118[r113] = TuplesKt.to("enter_method", r120);     // Catch: Throwable -> L107
        if (r117 == null) goto L70;
        String r121 = r117.optString("action_type");     // Catch: Throwable -> L107
    L71:
        r118[2] = TuplesKt.to(r4, r121);     // Catch: Throwable -> L107
        if (r117 == null) goto L74;
        String r122 = r117.optString("creative_id");     // Catch: Throwable -> L107
    L75:
        r118[3] = TuplesKt.to("creative_id", r122);     // Catch: Throwable -> L107
        if (r117 == null) goto L81;
        String r123 = r213;
        String r124 = r117.optString(r123);     // Catch: Throwable -> L79
    L82:
        r118[4] = TuplesKt.to(r123, r124);     // Catch: Throwable -> L79
        if (r117 == null) goto L88;
        String r125 = "enter_from";
        String r126 = r117.optString(r125);     // Catch: Throwable -> L86
    L89:
        r118[5] = TuplesKt.to(r125, r126);     // Catch: Throwable -> L86
        if (r117 == null) goto L95;
        String r127 = r212;
        String r128 = r117.optString(r127);     // Catch: Throwable -> L93
    L96:
        r118[6] = TuplesKt.to(r127, r128);     // Catch: Throwable -> L93
        if (r117 == null) goto L100;
        String r129 = r211;
        String r130 = r117.optString(r129);     // Catch: Throwable -> L105
    L101:
        r118[7] = TuplesKt.to(r129, r130);     // Catch: Throwable -> L105
        com.bytedance.android.livesdk.livecommerce.utils.s.b(r110, r118, new ECEventUtilsV2$getEntranceInfo$entranceInfoStr$1$4$1(r117));     // Catch: Throwable -> L105
        Unit r131 = Unit.INSTANCE;     // Catch: Throwable -> L105
    L103:
        Result.m9449constructorimpl(r131);     // Catch: Throwable -> L105
    L110:
        if (r110 == null) goto L113;
        Pair<String, ? extends Object>[] r132 = new Pair[3];     // Catch: Exception -> L52
        r132[0] = TuplesKt.to(r125, "live");     // Catch: Exception -> L52
        r132[r113] = TuplesKt.to("category_name", r111 + "_temai_" + r103);     // Catch: Exception -> L52
        r132[2] = TuplesKt.to("carrier_type", r310);     // Catch: Exception -> L52
        r110.g(r132);     // Catch: Exception -> L52
    L113:
        if (r110 == null) goto L115;
        Pair[] r133 = new Pair[8];     // Catch: Exception -> L52
        Object r134 = r127;
        r133[0] = TuplesKt.to("enter_from_merge", r312.get("enter_from_merge"));     // Catch: Exception -> L52
        r133[r113] = TuplesKt.to("enter_method", r312.get("enter_method"));     // Catch: Exception -> L52
        r133[2] = TuplesKt.to(r4, r312.get(r4));     // Catch: Exception -> L52
        r133[3] = TuplesKt.to("creative_id", r312.get("creative_id"));     // Catch: Exception -> L52
        r133[4] = TuplesKt.to(r123, r312.get(r123));     // Catch: Exception -> L52
        r133[5] = TuplesKt.to(r125, r312.get(r125));     // Catch: Exception -> L52
        r133[6] = TuplesKt.to(r134, r312.get(r134));     // Catch: Exception -> L52
        r133[7] = TuplesKt.to(r129, r312.get(r129));     // Catch: Exception -> L52
        com.bytedance.android.livesdk.livecommerce.utils.s.b(r110, r133, new ECEventUtilsV2$getEntranceInfo$$inlined$run$lambda$3(r311, r314, r310, r312, r313, r315));     // Catch: Exception -> L52
    L115:
        if (r110 == null) goto L117;
        Pair[] r135 = new Pair[r113];     // Catch: Exception -> L52
        r135[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_LIVE_LIST_CHANNEL, r313);     // Catch: Exception -> L52
        com.bytedance.android.livesdk.livecommerce.utils.s.b(r110, r135, ECEventUtilsV2$getEntranceInfo$entranceInfoStr$1$6.INSTANCE);     // Catch: Exception -> L52
    L117:
        if (r110 == null) goto L122;
        Pair<String, ? extends Object>[] r136 = new Pair[r113];     // Catch: Exception -> L52
        String r137 = com.bytedance.android.ec.core.utils.a2.d(r315);     // Catch: Exception -> L52
        if (r137 != null) goto L121;
        int r138 = com.bytedance.android.livesdk.livecommerce.room.controller.w.f151719h;     // Catch: Exception -> L52
        r137 = com.bytedance.android.livesdk.livecommerce.room.controller.w.a.b();     // Catch: Exception -> L52
    L121:
        r136[0] = TuplesKt.to("ecom_scene_id", r137);     // Catch: Exception -> L52
        r110.g(r136);     // Catch: Exception -> L52
    L122:
        if (r110 == null) goto L124;
        String r139 = r110.h();     // Catch: Exception -> L52
    L125:
        if (r139 == null) goto L127;
        com.bytedance.android.livesdk.livecommerce.utils.s.c(r139, EnumEntranceInfoScene.ECOM_LIVE_REQUEST);     // Catch: Exception -> L52
        String r140 = r139;
    L128:
        return Uri.encode(r140);
    L127:
        r140 = null;
        goto L128
    L124:
        r139 = null;
    L105:
        th = th;
    L109:
        Result.Companion r141 = Result.Companion;     // Catch: Exception -> L52
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L52
        goto L110
    L100:
        r129 = r211;
        r130 = null;
    L93:
        th = th;
        r129 = r211;
        goto L109
    L95:
        r127 = r212;
        r128 = null;
    L86:
        th = th;
        r129 = r211;
        r127 = r212;
        goto L109
    L88:
        r125 = r6;
        r126 = null;
    L79:
        th = th;
    L80:
        r129 = r211;
        r127 = r212;
        r125 = r6;
        goto L109
    L81:
        r123 = r213;
        r124 = null;
        goto L82
    L74:
        r122 = null;
        goto L75
    L70:
        r121 = null;
        goto L71
    L66:
        r120 = null;
        goto L67
    L62:
        r119 = null;
        goto L63
    L102:
        r123 = r213;
        r129 = r211;
        r127 = r212;
        r125 = r6;
        r131 = null;
        goto L103
    L57:
        r117 = null;
    L107:
        th = th;
        r123 = r213;
    L52:
        e = e;
    L132:
        ECExceptionMonitor.e(e);
        return r210;
    L39:
        r112 = null;
        goto L40
    L35:
        r109 = null;
        goto L36
    L31:
        r108 = null;
        goto L32
    L27:
        r107 = null;
        goto L28
    L23:
        r106 = null;
        goto L24
    L19:
        r105 = null;
        goto L20
    L43:
        r213 = "is_other_channel";
        r212 = "coupon_category";
        r211 = com.bytedance.android.ec.core.event.a.KEY_SUBSIDIZED_ACTIVITY;
        r210 = "";
        r113 = 1;
        goto L44
    L13:
        r103 = "";
        r111 = r103;
    L130:
        e = e;
        r210 = "";
        goto L132
    }
}
