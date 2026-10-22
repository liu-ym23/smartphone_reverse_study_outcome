package com.bytedance.android.livesdk.livecommerce.event;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.ec.common.api.IECCommonService;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.livesdk.livecommerce.promotionlist.LivePromotionListFragment;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.ExtraController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Pair;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
@Deprecated(message = "直播间减少单例获取信息, 改为LiveRoomParams")
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f147741a;

    public static String d() {
        return i("enter_from_merge");
    }

    public static String e() {
        return i("enter_method");
    }

    public static String f() {
        return i("follow_status");
    }

    public static HashMap<String, String> g() {
        int r100 = RoomContextController.f151593h;
        if (RoomContextController.a.a().x() == false) goto L5;
        HashMap<String, String> r101 = new HashMap(RoomContextController.a.a().K());
    L9:
        r101.put("room_unique_key", RoomContextController.a.a().D());
        int r102 = ECSdk.f48106a;
        IECCommonService r103 = (IECCommonService) ECSdk.a(IECCommonService.class);
        if (r103 == null) goto L16;
        Map<String, String> r104 = r103.getExplainReplayCommonParams();
        if (r104 == null) goto L16;
        if (r104.size() <= 0) goto L16;
        r101.putAll(r104);
    L16:
        return r101;
    L5:
        fh2.a r105 = PromotionListController.H();
        if (r105 == null) goto L8;
        r101 = new HashMap(((LivePromotionListFragment) r105).ga0());
        goto L9
    L8:
        r101 = new HashMap();
        goto L9
    }

    public static String c() {
        HashMap<String, String> r100 = g();
        JSONObject r110 = new JSONObject();
        r110.putOpt(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, r100.get("enter_from_merge"));     // Catch: Exception -> L22
        r110.putOpt(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, r100.get("enter_method"));     // Catch: Exception -> L22
        r110.putOpt(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, "live");     // Catch: Exception -> L22
        r110.putOpt("carrier_type", "live_add_to_cart");     // Catch: Exception -> L22
        r110.putOpt("room_id", r100.get("room_id"));     // Catch: Exception -> L22
        r110.putOpt("anchor_id", r100.get("anchor_id"));     // Catch: Exception -> L22
        r110.putOpt("follow_status", r100.get("follow_status"));     // Catch: Exception -> L22
        r110.putOpt("request_id", r100.get("request_id"));     // Catch: Exception -> L22
        r110.putOpt("group_id", r100.get("group_id"));     // Catch: Exception -> L22
        r110.putOpt("enter_from_merge", r100.get("enter_from_merge"));     // Catch: Exception -> L22
        r110.putOpt("enter_method", r100.get("enter_method"));     // Catch: Exception -> L22
        r110.putOpt("action_type", r100.get("action_type"));     // Catch: Exception -> L22
        r110.putOpt("creative_id", r100.get("creative_id"));     // Catch: Exception -> L22
        r110.putOpt("is_other_channel", r100.get("is_other_channel"));     // Catch: Exception -> L22
        r110.putOpt("live_tracker_params", r100.get("live_tracker_params"));     // Catch: Exception -> L22
        r110.putOpt("add_cart_source", "live");     // Catch: Exception -> L22
        String r101 = r100.get("search_params");     // Catch: Exception -> L22
        if (r101 == null) goto L6;
        r110.putOpt("search_params", r101);     // Catch: Exception -> L22
    L13:
        r110.putOpt("log_extra", r100.get("log_extra"));     // Catch: Exception -> L22
        Lazy r102 = ExtraController.f151511l;     // Catch: Exception -> L22
        ExtraController r103 = ControllerCenter.c(null, null).f151430u;     // Catch: Exception -> L22
        Objects.toString(r103);     // Catch: Exception -> L22
        JSONObject r104 = r103.H();     // Catch: Exception -> L22
        if (r104 == null) goto L25;
        Iterator<String> r105 = r104.keys();     // Catch: Exception -> L22
    L16:
        if (r105.hasNext() == false) goto L25;
        String r106 = r105.next();     // Catch: Exception -> L22
        Object r107 = r104.opt(r106);     // Catch: Exception -> L22
        if (r107 == null) goto L16;
        r110.putOpt(r106, r107.toString());     // Catch: Exception -> L22
    L25:
        return r110.toString();
    L6:
        String r108 = r100.get("live_tracker_params");     // Catch: Exception -> L22
        String r109 = "";
        if (TextUtils.isEmpty(r108) == false) goto L26;
    L12:
        r110.putOpt("search_params", r109);     // Catch: Exception -> L22
        goto L13
    L26:
        r109 = new JSONObject(r108).optString("search_params", "");     // Catch: JSONException -> L10 Exception -> L22
    L10:
        e = move-exception;
        ECExceptionMonitor.e(e);     // Catch: Exception -> L22
    L22:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L25
    }

    public static String l() {
        return g().get("request_id");
    }

    public static String n() {
        HashMap<String, String> r100 = g();
        return "" + r100.get("enter_from_merge") + "_temai_" + r100.get("enter_method");
    }

    public static HashMap<String, String> o() {
        if (RoomContextController.H().x() == false) goto L5;
        ECContext r100 = RoomContextController.H().r();
    L6:
        if (r100 == null) goto L14;
        if (r100.getEnterRoomParams().getValue().containsKey("jump_schema") == false) goto L12;
        HashMap<String, String> r101 = new HashMap(r100.getEnterRoomParams().getValue());
        r101.remove("jump_schema");
        return r101;
    L12:
        return (HashMap) r100.getEnterRoomParams().getValue();
    L14:
        return new HashMap();
    L5:
        r100 = null;
        goto L6
    }

    public static JSONObject b(Map<String, String> r100) {
        String r101 = r100.get("tracker_params");
        if (r101 == null) goto L12;
        return new JSONObject(r101);
    L6:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return null;
    L12:
        return null;
    }

    public static HashMap<String, String> h(RoomContextController r100) {
        if (r100.x() == false) goto L5;
        HashMap<String, String> r101 = new HashMap(r100.K());
    L9:
        int r102 = ECSdk.f48106a;
        IECCommonService r103 = (IECCommonService) ECSdk.a(IECCommonService.class);
        if (r103 == null) goto L16;
        Map<String, String> r104 = r103.getExplainReplayCommonParams();
        if (r104 == null) goto L16;
        if (r104.size() <= 0) goto L16;
        r101.putAll(r104);
    L16:
        return r101;
    L5:
        String r105 = r100.B();
        String r106 = r100.D();
        PromotionListController.T.getClass();
        fh2.a r107 = PromotionListController.a.b(r105, r106);
        if (r107 == null) goto L8;
        r101 = new HashMap(((LivePromotionListFragment) r107).ga0());
        goto L9
    L8:
        r101 = new HashMap();
        goto L9
    }

    public static String i(String r100) {
        String r101 = g().get(r100);
        if (TextUtils.isEmpty(r101) == true) goto L5;
        return r101;
    L5:
        return "";
    }

    public static JSONObject p(Map<String, String> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        String r101 = r100.get("pass_through_log_data");
        if (TextUtils.isEmpty(r101) == false) goto L13;
        return null;
    L13:
        return new JSONObject(r101);
    L10:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return null;
    }

    public static void q(JSONObject r100) {
        r100.remove("pass_through_log_data");
        r100.remove("multi_room_data");
        r100.remove("single_room_data");
    }

    public static Uri u(Uri r100) {
        Uri.Builder r101 = r100.buildUpon();
        r101.clearQuery();
        Iterator<String> r102 = UriProtector.getQueryParameterNames(r100).iterator();
    L4:
        if (r102.hasNext() == false) goto L13;
        String r103 = r102.next();
        if (r103.equals("as_panel") == false) goto L7;
        r101.appendQueryParameter(r103, "0");
        goto L4
    L7:
        Iterator<String> r104 = UriProtector.getQueryParameters(r100, r103).iterator();
    L9:
        if (r104.hasNext() == false) goto L4;
        r101.appendQueryParameter(r103, r104.next());
        goto L9
    L13:
        return r101.build();
    }

    public static String j(String r100, RoomContextController r101) {
        if (r101 == null) goto L4;
        String r102 = h(r101).get(r100);
        if (TextUtils.isEmpty(r102) == true) goto L8;
        return r102;
    L8:
        return "";
    L4:
        return i(r100);
    }

    public static String m(String r100, String r101) {
        int r102 = RoomContextController.f151593h;
        RoomContextController r103 = RoomContextController.a.b(r100, r101);
        if (r103.x() == true) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
        return "0";
    L11:
        return "1";
    L5:
        if (r103.A().f151429t.f151473m == true) goto L8;
        r104 = false;
        goto L9
    }

    public static String a(String r100, String r101, String r102) {
        Uri r103 = UriProtector.parse(r100);     // Catch: Exception -> L9
        String r104 = UriProtector.getQueryParameter(r103, "url");     // Catch: Exception -> L9
        if (r104 == null) goto L8;
        return t(r103, "url", t(UriProtector.parse(r104), r101, r102).toString()).toString();
    L8:
        return t(r103, r101, r102).toString();
    L9:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return r100;
    }

    public static String k(String r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L30
        Iterator<Map.Entry<String, String>> r104 = g().entrySet().iterator();     // Catch: Exception -> L30
    L4:
        if (r104.hasNext() == false) goto L7;
        Map.Entry<String, String> r105 = r104.next();     // Catch: Exception -> L30
        r103.put(r105.getKey(), r105.getValue());     // Catch: Exception -> L30
        goto L4
    L7:
        if (r102 != null) goto L33;
    L17:
        r103.put("enter_from", "live");     // Catch: Exception -> L30
        r103.put("category_name", d() + "_temai_" + i("enter_method"));     // Catch: Exception -> L30
        r103.put("carrier_type", r101);     // Catch: Exception -> L30
        HashMap<String, String> r106 = o();     // Catch: Exception -> L30
        if (r106.isEmpty() == true) goto L23;
        Iterator<Map.Entry<String, String>> r107 = r106.entrySet().iterator();     // Catch: Exception -> L30
    L21:
        if (r107.hasNext() == false) goto L23;
        Map.Entry<String, String> r108 = r107.next();     // Catch: Exception -> L30
        r103.put(r108.getKey(), r108.getValue());     // Catch: Exception -> L30
    L23:
        r103.put(com.bytedance.android.ec.core.event.a.KEY_LIVE_LIST_CHANNEL, r100);     // Catch: Exception -> L30
        q(r103);     // Catch: Exception -> L30
        int r109 = com.bytedance.android.livesdk.livecommerce.room.controller.w.f151719h;     // Catch: Exception -> L30
        r103.put("ecom_scene_id", com.bytedance.android.livesdk.livecommerce.room.controller.w.a.b());     // Catch: Exception -> L30
        RoomContextController r110 = RoomContextController.a.a();     // Catch: Exception -> L30
        r103.put("display_room_id", r110.B());     // Catch: Exception -> L30
        r103.put("display_anchor_id", r110.y());     // Catch: Exception -> L30
        r103.put("display_sec_anchor_id", r110.z());     // Catch: Exception -> L30
        r103.put("display_follow_status", r110.K().get("follow_status"));     // Catch: Exception -> L30
        com.bytedance.android.ec.model.response.n1 r111 = r110.f151597f;     // Catch: Exception -> L30
        if (r111 != null) goto L26;
    L28:
        return Uri.encode(r103.toString());
    L26:
        if (r111.a() == null) goto L28;
        int r112 = com.bytedance.android.livesdk.livecommerce.utils.m0.f153098a;     // Catch: Exception -> L30
        r103.put("ecom_linkmic_room_ids", com.bytedance.android.livesdk.livecommerce.utils.m0.a.f153099a.toJson(r111.a()));     // Catch: Exception -> L30
        goto L28
    L33:
        JSONObject r113 = new JSONObject(r102);     // Catch: Exception -> L15
        Iterator<String> r114 = r113.keys();     // Catch: Exception -> L15
    L10:
        if (r114.hasNext() == false) goto L17;
        String r115 = r114.next();     // Catch: Exception -> L15
        Object r116 = r113.opt(r115);     // Catch: Exception -> L15
        if (r116 == null) goto L10;
        r103.putOpt(r115, r116.toString());     // Catch: Exception -> L15
    L15:
        e = move-exception;
        ECExceptionMonitor.e(e);     // Catch: Exception -> L30
    L30:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return "";
    }

    public static String s(String r100, String r101, Pair<String, String>... r102) {
        Uri r103 = UriProtector.parse(r100);
        String r104 = UriProtector.getQueryParameter(r103, r101);
        if (r104 != null) goto L5;
        return r100;
    L5:
        if (r104.isEmpty() == false) goto L8;
        return r100;
    L8:
        return t(r103, r101, (String) r(r104, new String[]{com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO}, 0, r102)).toString();
    }

    public static Uri t(Uri r100, String r101, String r102) {
        if (r102 == null) goto L25;
        Uri.Builder r103 = r100.buildUpon();
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r100, r101)) == false) goto L7;
        r103.appendQueryParameter(r101, r102);
    L18:
        return r103.build();
    L7:
        r103.clearQuery();
        Iterator<String> r104 = UriProtector.getQueryParameterNames(r100).iterator();
    L9:
        if (r104.hasNext() == false) goto L18;
        String r105 = r104.next();
        if (r105.equals(r101) == false) goto L12;
        r103.appendQueryParameter(r105, r102);
        goto L9
    L12:
        Iterator<String> r106 = UriProtector.getQueryParameters(r100, r105).iterator();
    L14:
        if (r106.hasNext() == false) goto L9;
        r103.appendQueryParameter(r105, r106.next());
        goto L14
    L25:
        return r100;
    }

    public static Object r(Object r100, String[] r101, int r102, Pair<String, String>... r103) {
        int r104 = 0;
        if ((r100 instanceof JSONObject) == false) goto L6;
        JSONObject r105 = (JSONObject) r100;     // Catch: Exception -> L28
        boolean r106 = true;
    L12:
        if (r102 < r101.length) goto L21;
        int r107 = r103.length;     // Catch: Exception -> L28
    L14:
        if (r104 >= r107) goto L24;
        Pair<String, String> r108 = r103[r104];     // Catch: Exception -> L28
        if (r108.getFirst() == null) goto L20;
        if (r108.getSecond() == null) goto L20;
        r105.put(r108.getFirst(), r108.getSecond());     // Catch: Exception -> L28
    L20:
        r104 = r104 + 1;     // Catch: Exception -> L28
    L24:
        if (r106 == false) goto L26;
        return r105;
    L26:
        return r105.toString();
    L21:
        Object r109 = r105.opt(r101[r102]);     // Catch: Exception -> L28
        if (r109 == null) goto L24;
        Object r110 = r(r109, r101, r102 + 1, r103);     // Catch: Exception -> L28
        r105.put(r101[r102], r110);     // Catch: Exception -> L28
        goto L24
    L6:
        if ((r100 instanceof String) == false) goto L37;
        String r111 = (String) r100;     // Catch: Exception -> L28
        if (TextUtils.isEmpty(r111) == false) goto L10;
        r111 = SliceInitService.DEFAULT_SWITCH;
    L10:
        r105 = new JSONObject(r111);     // Catch: Exception -> L28
        r106 = false;
        goto L12
    L37:
        return r100;
    L28:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return r100;
    }
}
