package com.bytedance.android.livesdk.livecommerce.router;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.UrlBuilderV2;
import com.bytedance.android.ec.core.utils.x0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.l;
import com.bytedance.android.livesdk.livecommerce.event.l0;
import com.bytedance.android.livesdk.livecommerce.event.t1;
import com.bytedance.android.livesdk.livecommerce.room.f;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.k;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class ECLiveSchemaBuilder implements hf.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Map<String, String> f152814l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Uri f152815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f152816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, String> f152817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, String> f152818d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final dm.a.b f152819e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f152820f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f152821g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f152822h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f152823i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f152824j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f152825k;

    public static final class a {
    }

    @Override // hf.a
    public final String build() {
        String r100 = j(false);
        h(false);
        return r100;
    }

    static {
        f152814l = new LinkedHashMap();
    }

    public ECLiveSchemaBuilder() {
        this.f152819e = dm.a.a("ECLiveSchemaBuilder");
        this.f152820f = LazyKt.lazy(ECLiveSchemaBuilder$ecomLiveParamsInfo$2.INSTANCE);
        this.f152821g = LazyKt.lazy(ECLiveSchemaBuilder$passThroughLogDataDenyList$2.INSTANCE);
        this.f152822h = LazyKt.lazy(ECLiveSchemaBuilder$ecomLiveParamError$2.INSTANCE);
        this.f152823i = LazyKt.lazy(ECLiveSchemaBuilder$passThroughLogDataError$2.INSTANCE);
        this.f152824j = LazyKt.lazy(ECLiveSchemaBuilder$passThroughLogDataSuperError$2.INSTANCE);
        this.f152825k = LazyKt.lazy(ECLiveSchemaBuilder$passThroughLogDataFixError$2.INSTANCE);
    }

    @Override // hf.a
    public final ECLiveSchemaBuilder a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "baseSchema");
        this.f152816b = r100;
        return this;
    }

    public final ECLiveSchemaBuilder c(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "ecomLiveParams");
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = r102.next();
        r101.put(r103, r100.optString(r103));
        goto L4
    L6:
        Intrinsics.checkNotNullParameter(r101, "ecomLiveParams");
        if ((!r101.isEmpty()) == false) goto L9;
        this.f152818d = r101;
    L9:
        return this;
    }

    public final ECLiveSchemaBuilder d(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "query");
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = r102.next();
        r101.put(r103, r100.optString(r103));
        goto L4
    L6:
        Intrinsics.checkNotNullParameter(r101, "query");
        if ((!r101.isEmpty()) == false) goto L9;
        this.f152817c = r101;
    L9:
        return this;
    }

    public final boolean f(String r100) {
        JSONObject r101 = (JSONObject) this.f152820f.getValue();
        if (r101 == null) goto L25;
        String r102 = r101.optString(r100);
        if (r102 == null) goto L23;
        int r103 = r102.hashCode();
        if (r103 == (-1034364087)) goto L21;
        if (r103 == (-891985903)) goto L18;
        if (r103 != 107868) goto L23;
        if (r102.equals("map") == false) goto L23;
        return true;
    L18:
        if (r102.equals("string") == false) goto L23;
        return true;
    L21:
        if (r102.equals("number") == false) goto L23;
        return true;
    L23:
        ((List) this.f152822h.getValue()).add(r100);
        return false;
    L25:
        return true;
    }

    public final void h(boolean r100) {
        Uri r101 = this.f152815a;
        if (r101 == null) goto L10;
        t1 r102 = new t1();
        if (r100 == false) goto L7;
        r102.f("is_ec_open", "1");
    L8:
        r102.f("room_id", UriProtector.getQueryParameter(r101, "room_id"));
        r102.f("anchor_id", UriProtector.getQueryParameter(r101, "anchor_id"));
        r102.f("enter_from_merge", UriProtector.getQueryParameter(r101, "enter_from_merge"));
        r102.f("enter_method", UriProtector.getQueryParameter(r101, "enter_method"));
        r102.f(ILiveRoomPlayFragmentConstant.ENTER_ECOM_LIVE_PARAMS, UriProtector.getQueryParameter(r101, ILiveRoomPlayFragmentConstant.ENTER_ECOM_LIVE_PARAMS));
        r102.f("host", r101.getHost());
        r102.k();
        return;
    L7:
        r102.f("is_ec_open", "0");
        goto L8
    }

    public final String i(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = j(true);
        if ((!StringsKt.isBlank(r101)) == true) goto L6;
        r101 = null;
    L6:
        if (r101 == null) goto L9;
        h(true);
        Handler r102 = k.f153092a;
        f.b(r100, r101);
        return r101;
    L9:
        return "";
    }

    public final String j(boolean r110) {
        String r100 = this.f152816b;
        if (r100 != null) goto L81;
    L9:
        Uri r101 = this.f152815a;
        if (r101 != null) goto L83;
    L15:
        UtilityKotlinExtentionsKt.f(this.f152815a, this.f152817c, new ECLiveSchemaBuilder$realAddQuery$1(this));
        Uri r102 = this.f152815a;
        if (r102 == null) goto L71;
        UrlBuilderV2 r103 = new UrlBuilderV2(r102);
        if (EComABUtils.liveFixExtraBusinessParamsSourceList().contains(r103.getQuery("enter_from_merge") + "_temai_" + r103.getQuery("enter_method")) == true) goto L71;
        JSONObject r104 = z1.g(r103.getQuery(ILiveRoomPlayFragmentConstant.ENTER_ECOM_LIVE_PARAMS));
        if (r104 == null) goto L71;
        JSONObject r105 = z1.g(r104.optString("pass_through_log_data"));
        if (r105 == null) goto L71;
        String r106 = r105.optString("creative_id");
        String r111 = r105.optString("log_extra");
        String r112 = r105.optString("search_params");
        String r113 = r105.optString("request_id");
        String r107 = r105.optString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_RECOMMEND_INFO);
        JSONObject r108 = new JSONObject();
        r105.remove("creative_id");
        if (com.bytedance.android.shopping.extensions.k.c(r106) == true) goto L29;
    L36:
        r105.remove("log_extra");
        if (com.bytedance.android.shopping.extensions.k.c(r111) == true) goto L39;
    L46:
        r105.remove("search_params");
        if (com.bytedance.android.shopping.extensions.k.c(r112) == true) goto L49;
    L52:
        r105.remove("request_id");
        if (com.bytedance.android.shopping.extensions.k.c(r113) == true) goto L55;
    L58:
        r105.remove(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_RECOMMEND_INFO);
        if (com.bytedance.android.shopping.extensions.k.c(r107) == true) goto L61;
    L77:
        r104.put("pass_through_log_data", r105.toString());     // Catch: JSONException -> L68
        if (r108.length() <= 0) goto L70;
        r104.put("tmp_log_extra_for_inner", r108.toString());     // Catch: JSONException -> L68
    L70:
        r103.addOrReplaceParam(ILiveRoomPlayFragmentConstant.ENTER_ECOM_LIVE_PARAMS, r104.toString());
        Uri r109 = r103.buildUri();
        this.f152819e.a("ec enter room checkAndFixPassThroughLogDataParams origin:" + r102 + " result:" + r109);
        Unit r114 = Unit.INSTANCE;
        this.f152815a = r109;
    L68:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L70
    L61:
        if (com.bytedance.android.shopping.extensions.k.c(r103.getQuery(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_RECOMMEND_INFO)) == false) goto L63;
        ((List) this.f152824j.getValue()).add(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_RECOMMEND_INFO);
        goto L77
    L63:
        r103.addOrReplaceParam(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_RECOMMEND_INFO, r107);
        ((List) this.f152825k.getValue()).add(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_RECOMMEND_INFO);
        goto L77
    L55:
        if (com.bytedance.android.shopping.extensions.k.c(r103.getQuery("request_id")) == false) goto L57;
        ((List) this.f152824j.getValue()).add("request_id");
        goto L58
    L57:
        r103.addOrReplaceParam("request_id", r113);
        ((List) this.f152825k.getValue()).add("request_id");
        goto L58
    L49:
        if (com.bytedance.android.shopping.extensions.k.c(r103.getQuery(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_RECOMMEND_INFO)) == false) goto L51;
        ((List) this.f152824j.getValue()).add("search_params");
        goto L52
    L51:
        r103.addOrReplaceParam("search_params", r112);
        ((List) this.f152825k.getValue()).add("search_params");
        goto L52
    L39:
        if (com.bytedance.android.shopping.extensions.k.c(r103.getQuery("log_extra")) == false) goto L79;
        ((List) this.f152824j.getValue()).add("log_extra");
        goto L46
    L79:
        r108.put("log_extra", r111);     // Catch: JSONException -> L43
    L45:
        ((List) this.f152825k.getValue()).add("log_extra");
    L43:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L45
    L29:
        if (com.bytedance.android.shopping.extensions.k.c(r103.getQuery("creative_id")) == false) goto L85;
        ((List) this.f152824j.getValue()).add("creative_id");
        goto L36
    L85:
        r108.put("creative_id", r106);     // Catch: JSONException -> L33
    L35:
        ((List) this.f152825k.getValue()).add("creative_id");
    L33:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L71:
        Uri r115 = this.f152815a;
        if (r115 == null) goto L75;
        String r116 = r115.toString();
        if (r116 == null) goto L75;
        return r116;
    L75:
        return "";
    L83:
        this.f152815a = l0.t(this.f152815a, ILiveRoomPlayFragmentConstant.ENTER_ECOM_LIVE_PARAMS, k(z1.f(UriProtector.getQueryParameter(r101, ILiveRoomPlayFragmentConstant.ENTER_ECOM_LIVE_PARAMS)), this.f152818d, r110).toString());     // Catch: Exception -> L13
    L13:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L15
    L81:
        Uri r117 = UriProtector.parse(r100);     // Catch: Exception -> L6
    L8:
        this.f152815a = r117;
    L6:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r117 = null;
        goto L8
    }

    public final void b(JSONObject r100, boolean r110) {
        if (r110 == false) goto L5;
        r100.put("is_ec_open", "1");
        long r101 = System.currentTimeMillis();
        r100.put("ec_room_enter_start_time", r101);
        f152814l.put(String.valueOf(r101), r100.toString());
    L6:
        r100.put("ec_room_enter", "1");
        if (ECAppInfoService.f48114e.i() == false) goto L49;
        StringBuilder r111 = new StringBuilder();
        boolean r102 = true;
        if ((!((List) this.f152822h.getValue()).isEmpty()) == false) goto L23;
        r111.append("ecom_live_params中有错误的参数：");
        Iterator r103 = ((List) this.f152822h.getValue()).iterator();
        int r104 = 0;
    L12:
        if (r103.hasNext() == false) goto L21;
        Object r105 = r103.next();
        int r106 = r104 + 1;
        if (r104 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        r111.append((String) r105);
        if (r104 == (((List) this.f152822h.getValue()).size() - 1)) goto L19;
        r111.append("、");
    L20:
        r104 = r106;
        goto L12
    L19:
        r111.append("\n");
        goto L20
    L21:
        ((List) this.f152822h.getValue()).clear();
    L23:
        if ((!((List) this.f152823i.getValue()).isEmpty()) == false) goto L37;
        r111.append("pass_through_log_data中有错误的参数：");
        Iterator r107 = ((List) this.f152823i.getValue()).iterator();
        int r108 = 0;
    L26:
        if (r107.hasNext() == false) goto L35;
        Object r109 = r107.next();
        int r112 = r108 + 1;
        if (r108 >= 0) goto L30;
        CollectionsKt.throwIndexOverflow();
    L30:
        r111.append((String) r109);
        if (r108 == (((List) this.f152823i.getValue()).size() - 1)) goto L33;
        r111.append("、");
    L34:
        r108 = r112;
        goto L26
    L33:
        r111.append("\n");
        goto L34
    L35:
        ((List) this.f152823i.getValue()).clear();
    L37:
        if (r111.length() > 0) goto L40;
        r102 = false;
    L40:
        if (r102 == false) goto L50;
        r111.append("这些参数不应该存在，问题咨询 seven.zeng");
        r100.put("error_msg", r111.toString());
        return;
    L50:
        return;
    L49:
        return;
    L5:
        r100.put("is_ec_open", "0");
        goto L6
    }

    public final JSONObject e(JSONObject r100, Bundle r101) {
        if (EComABUtils.liveRemoveSesitiveParamsDisableSourcePageList().contains(r101.getString("enter_from_merge") + "_temai_" + r101.getString("enter_method")) == false) goto L5;
        return r100;
    L5:
        String r102 = r100.optString("pass_through_log_data");
        this.f152819e.a("ec hook enter room remove pass_through_log_data origin: " + r102);
        JSONObject r103 = z1.g(r102);
        if (r103 == null) goto L19;
        Iterator<T> r104 = EComABUtils.liveRemoveSesitiveParamsList().iterator();
        boolean r105 = false;
    L9:
        if (r104.hasNext() == false) goto L13;
        if (r103.remove((String) r104.next()) == null) goto L9;
        r105 = true;
        goto L9
    L13:
        if (r105 == false) goto L19;
        r100 = x0.a(r100);
        String r106 = r103.toString();     // Catch: JSONException -> L17
        this.f152819e.a("ec hook enter room remove pass_through_log_data ec params result: " + r106);     // Catch: JSONException -> L17
        Unit r107 = Unit.INSTANCE;     // Catch: JSONException -> L17
        r100.put("pass_through_log_data", r106);     // Catch: JSONException -> L17
    L17:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L19:
        return r100;
    }

    public final void g(final String r100, final Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "ecomLiveParams");
        Intrinsics.checkNotNullParameter(r101, "bundle");
        l.a(new ECLiveSchemaBuilder$hookECOMLiveParams$1(r100, r101));
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (EComABUtils.getEnterRoomParamsHook() == false) goto L18;
        JSONObject r102 = new JSONObject(r100);     // Catch: Exception -> L14
        if (Intrinsics.areEqual(r102.optString("is_ec_open"), "1") == false) goto L10;
        b(r102, true);     // Catch: Exception -> L14
    L11:
        r100 = e(r102, r101).toString();     // Catch: Exception -> L14
        goto L12
    L10:
        r102 = k(r102, null, true);     // Catch: Exception -> L14
    L12:
        r101.putString(ILiveRoomPlayFragmentConstant.ENTER_ECOM_LIVE_PARAMS, r100);
        t1 r103 = new t1();
        r103.f("is_ec_open", "1");
        r103.f("enter_from_merge", r101.getString("enter_from_merge"));
        r103.f("enter_method", r101.getString("enter_method"));
        r103.f(ILiveRoomPlayFragmentConstant.ENTER_ECOM_LIVE_PARAMS, r100);
        r103.k();
        return;
    }

    public final JSONObject k(JSONObject r110, Map<String, String> r111, boolean r112) {
        JSONObject r100 = new JSONObject();
        if (r111 == null) goto L28;
        Iterator<Map.Entry<String, String>> r113 = r111.entrySet().iterator();
    L6:
        if (r113.hasNext() == false) goto L28;
        Map.Entry<String, String> r101 = r113.next();
        String r102 = r101.getValue();
        String r103 = r101.getKey();
        String r104 = r101.getValue();
        if (f(r103) == false) goto L6;
        String r105 = r110.optString(r101.getKey());
        if (Intrinsics.areEqual("multi_room_data", r101.getKey()) == false) goto L13;
    L14:
        JSONObject r106 = z1.g(r102);
        if (r106 == null) goto L27;
        JSONObject r107 = z1.g(r105);
        if (r107 == null) goto L27;
        JSONObject r108 = new JSONObject();
        Iterator<String> r109 = r106.keys();
    L20:
        if (r109.hasNext() == false) goto L22;
        String r114 = r109.next();
        r108.put(r114, r106.optString(r114));
        r107.remove(r114);
        goto L20
    L22:
        Iterator<String> r115 = r107.keys();
    L24:
        if (r115.hasNext() == false) goto L26;
        String r116 = r115.next();
        r108.put(r116, r107.optString(r116));
        goto L24
    L26:
        r102 = r108.toString();
    L27:
        r100.put(r101.getKey(), r102);
        r110.remove(r101.getKey());
        goto L6
    L13:
        if (Intrinsics.areEqual("pass_through_log_data", r101.getKey()) == false) goto L27;
    L28:
        Iterator<String> r117 = r110.keys();
    L30:
        if (r117.hasNext() == false) goto L36;
        String r118 = r117.next();
        Object r119 = r110.optString(r118);
        if (f(r118) == false) goto L30;
        r100.put(r118, r119);
        goto L30
    L36:
        if (EComABUtils.getEnterRoomParamsHook() == false) goto L49;
        JSONObject r120 = z1.g(r100.optString("multi_room_data"));
        if (r120 == null) goto L49;
        JSONObject r121 = new JSONObject();
        Iterator<String> r122 = r120.keys();
    L42:
        if (r122.hasNext() == false) goto L47;
        String r123 = r122.next();
        String r124 = r120.optString(r123);
        if (f(r123) == false) goto L42;
        r121.put(r123, r124);
        goto L42
    L47:
        r100.put("multi_room_data", r121);
    L49:
        if (ECAppInfoService.f48114e.i() == true) goto L51;
    L66:
        b(r100, r112);
        return r100;
    L51:
        if (((List) this.f152821g.getValue()).isEmpty() == true) goto L66;
        if (EComABUtils.getEnterRoomParamsHook() == false) goto L66;
        JSONObject r125 = z1.g(r100.optString("pass_through_log_data"));
        if (r125 == null) goto L66;
        JSONObject r126 = new JSONObject();
        Iterator<String> r127 = r125.keys();
    L60:
        if (r127.hasNext() == false) goto L65;
        String r128 = r127.next();
        if (((List) this.f152821g.getValue()).contains(r128) == false) goto L64;
        ((List) this.f152823i.getValue()).add(r128);
    L64:
        r126.put(r128, r125.opt(r128));
        goto L60
    L65:
        r100.put("pass_through_log_data", r126);
        goto L66
    }
}
