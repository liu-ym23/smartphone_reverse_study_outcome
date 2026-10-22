package com.bytedance.android.marketing.sdk.impl.data;

import android.widget.FrameLayout;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.marketing.sdk.impl.utils.ECMarketingErrorType;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import com.google.gson.Gson;
import com.ss.android.socialbase.appdownloader.ah.DevicePlans;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class h {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f162794l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, RitDataWrapper> f162795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<FrameLayout> f162796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super String, Unit> f162797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f162798d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, ? extends Object> f162799e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<String, ? extends Object> f162800f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f162801g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TrackData f162802h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, Map<String, Boolean>> f162803i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, RitDataWrapperV5> f162804j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f162805k;

    public static final class a {
    }

    static {
    }

    public h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pageId");
        this.f162805k = r100;
        this.f162795a = new LinkedHashMap();
        this.f162802h = new TrackData();
        this.f162803i = new LinkedHashMap();
        this.f162804j = new LinkedHashMap();
    }

    public final RitDataWrapper d(String r100) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_RIT);
        RitDataWrapper r101 = (RitDataWrapper) ((LinkedHashMap) this.f162795a).get(r100);
        if (r101 != null) goto L6;
        RitDataWrapper r102 = new RitDataWrapper(this.f162805k, r100, this);
        this.f162795a.put(r100, r102);
        return r102;
    L6:
        return r101;
    }

    public final RitDataWrapperV5 e(String r100) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_RIT);
        RitDataWrapperV5 r101 = (RitDataWrapperV5) ((LinkedHashMap) this.f162804j).get(r100);
        if (r101 != null) goto L6;
        RitDataWrapperV5 r102 = new RitDataWrapperV5(this.f162805k, r100, this);
        this.f162804j.put(r100, r102);
        return r102;
    L6:
        return r101;
    }

    public final void h(String r100) {
        JSONObject r101 = ex2.d.c(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        JSONObject r102 = r101.optJSONObject("resource_payload");
        if (r102 == null) goto L8;
        r101 = r102;
    L8:
        Iterator<String> r103 = r101.keys();
    L10:
        if (r103.hasNext() == false) goto L26;
        String r104 = r103.next();
        if (r104 == null) goto L10;
        if (b(this.f162805k, r104) == true) goto L16;
        RitDataWrapper r105 = (RitDataWrapper) ((LinkedHashMap) this.f162795a).get(r104);
        if (r105 == null) goto L10;
        Iterator r106 = ((LinkedHashMap) r105.f162731a).entrySet().iterator();
    L23:
        if (r106.hasNext() == false) goto L25;
        ((CompDataWrapper) ((Map.Entry) r106.next()).getValue()).c();
        goto L23
    L25:
        ((LinkedHashMap) r105.f162731a).clear();
        goto L10
    L16:
        RitDataWrapperV5 r107 = (RitDataWrapperV5) ((LinkedHashMap) this.f162804j).get(r104);
        if (r107 == null) goto L10;
        r107.b();
        goto L10
    }

    public final void l(String r100) {
        JSONObject r101 = ex2.d.c(r100);
        String r102 = null;
        boolean r103 = true;
        if (r101 != null) goto L9;
        String r104 = this.f162802h.getEntryRit();
        if ((true ^ StringsKt.isBlank(r104)) == false) goto L7;
        r102 = r104;
    L7:
        i(r102, "PageData解析异常");
        return;
    L9:
        JSONObject r105 = r101.optJSONObject("resource_payload");
        if (r105 == null) goto L12;
        r101 = r105;
    L13:
        Iterator<String> r106 = r101.keys();
    L15:
        if (r106.hasNext() == false) goto L28;
        String r107 = r106.next();
        if (r107 == null) goto L15;
        JSONObject r108 = r101.optJSONObject(r107);
        if (r108 == null) goto L21;
        if (r103 == true) goto L23;
        m(r107, r108, null);
        goto L15
    L23:
        Map<String, Map<String, Boolean>> r109 = this.f162803i;
        String r110 = this.f162805k;
        LinkedHashMap r111 = (LinkedHashMap) r109;
        Object r112 = r111.get(r110);
        if (r112 != null) goto L26;
        r112 = new LinkedHashMap();
        r111.put(r110, r112);
    L26:
        ((Map) r112).put(r107, Boolean.TRUE);
        n(r107, r108);
        goto L15
    L21:
        i(r107, "RitData解析异常");
        goto L15
    L28:
        return;
    L12:
        r103 = false;
        goto L13
    }

    public final boolean b(String r100, String r101) {
        Map<String, Map<String, Boolean>> r102 = this.f162803i;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        Map r103 = (Map) ((LinkedHashMap) r102).get(r100);
        if (r103 == null) goto L10;
        Boolean r104 = (Boolean) r103.get(r101);
        if (r104 == null) goto L10;
        return r104.booleanValue();
    L10:
        return false;
    }

    public final CompDataWrapper c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_RIT);
        Intrinsics.checkNotNullParameter(r101, "compName");
        RitDataWrapper r102 = (RitDataWrapper) ((LinkedHashMap) this.f162795a).get(r100);
        if (r102 == null) goto L7;
        Map<String, CompDataWrapper> r103 = r102.f162731a;
        if (r103 == null) goto L7;
        return (CompDataWrapper) ((LinkedHashMap) r103).get(r101);
    L7:
        return null;
    }

    public final void i(String r100, String r110) {
        int r101 = com.bytedance.android.marketing.sdk.impl.utils.e.f162816a;
        com.bytedance.android.marketing.sdk.impl.utils.e.e(r100, null, this.f162802h.getLogId(), ECMarketingErrorType.PROTOCOL_PARSE_ERROR.getCode(), r110, this.f162802h.getServicePageName(), this.f162802h.getLoadEntryType());
    }

    public final void n(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_RIT);
        RitDataWrapperV5 r102 = e(r100);
        String r103 = this.f162802h.getServicePageName();
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r102.f162757j = r103;
        String r104 = this.f162802h.getLoadEntryType();
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r102.f162758k = r104;
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_RIT);
        JSONObject r105 = r101.optJSONObject("resource_extra");
        String r106 = null;
        if (r105 == null) goto L5;
        JSONObject r107 = r105.optJSONObject("ui_info");
    L6:
        if (r107 == null) goto L11;
        String r108 = r107.optString("version");
        if (r108 != null) goto L10;
        r108 = r102.f162751d;
    L10:
        r102.f162751d = r108;
    L11:
        r102.f162752e = r101;
        if (r107 == null) goto L14;
        String r109 = r107.optString("template_url");
    L15:
        r102.f162749b = r109;
        if (r107 == null) goto L20;
        JSONObject r110 = r107.optJSONObject("layout_info");
        if (r110 == null) goto L20;
        String r111 = r110.toString();
    L21:
        r102.f162750c = r111;
        JSONArray r112 = r101.optJSONArray("resource_list");
        if (r112 != null) goto L24;
        return;
    L24:
        if (r112.length() <= 0) goto L67;
        boolean r113 = false;
        JSONObject r114 = r112.optJSONObject(0);
        if (r114 == null) goto L68;
        r102.f162760m = r114;
        JSONObject r115 = r114.optJSONObject("plan_info");
        if (r115 == null) goto L37;
        String r116 = r115.optString("plan_id");
        if (r116 == null) goto L37;
        if (r116.length() <= 0) goto L34;
        boolean r117 = true;
    L35:
        if (r117 == false) goto L37;
    L38:
        r102.f162755h = r116;
        String r118 = r114.optString(CronetDataStorageAccess.LOGID);
        if (r118 != null) goto L41;
    L50:
        String r119 = r114.optString("log_id");
        if (r119 != null) goto L53;
    L57:
        r102.f162756i = r106;
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L60
        Gson r121 = com.bytedance.android.marketing.sdk.impl.utils.f.f162817a;     // Catch: Throwable -> L60
        r102.f162759l = (i) com.bytedance.android.marketing.sdk.impl.utils.f.a(String.valueOf(r102.f162760m), i.class);     // Catch: Throwable -> L60
        Object r122 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L60
    L62:
        Result.m9448boximpl(r122);
        return;
    L60:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L62
    L53:
        if (r119.length() <= 0) goto L55;
        r113 = true;
    L55:
        if (r113 == false) goto L57;
        r106 = r119;
        goto L57
    L41:
        if (r118.length() <= 0) goto L43;
        boolean r124 = true;
    L44:
        if (r124 == true) goto L47;
        r118 = null;
    L47:
        if (r118 == null) goto L50;
        r106 = r118;
        goto L57
    L43:
        r124 = false;
        goto L44
    L34:
        r117 = false;
    L37:
        r116 = null;
        goto L38
    L68:
        return;
    L67:
        return;
    L20:
        r111 = null;
        goto L21
    L14:
        r109 = null;
        goto L15
    L5:
        r107 = null;
        goto L6
    }

    public final void a(String r100, String r101, boolean r102) {
        boolean r103 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L23;
        Iterator r105 = ((LinkedHashMap) this.f162795a).keySet().iterator();
    L12:
        if (r105.hasNext() == false) goto L67;
        String r106 = (String) r105.next();
        RitDataWrapper r107 = (RitDataWrapper) ((LinkedHashMap) this.f162795a).get(r106);
        if (r107 == null) goto L12;
        Map<String, CompDataWrapper> r108 = r107.f162731a;
        if (r108 == null) goto L12;
        LinkedHashMap r109 = (LinkedHashMap) r108;
        Iterator r110 = r109.keySet().iterator();
    L19:
        if (r110.hasNext() == false) goto L12;
        CompDataWrapper r111 = (CompDataWrapper) r109.get((String) r110.next());
        if (r111 == null) goto L19;
        r111.q(r102);
        goto L19
    L67:
        return;
    L23:
        if (r101 != null) goto L25;
    L26:
        r103 = true;
    L27:
        if (r103 == false) goto L38;
        RitDataWrapper r112 = (RitDataWrapper) ((LinkedHashMap) this.f162795a).get(r100);
        if (r112 == null) goto L62;
        Map<String, CompDataWrapper> r113 = r112.f162731a;
        if (r113 == null) goto L63;
        LinkedHashMap r114 = (LinkedHashMap) r113;
        Iterator r115 = r114.keySet().iterator();
    L34:
        if (r115.hasNext() == false) goto L68;
        CompDataWrapper r116 = (CompDataWrapper) r114.get((String) r115.next());
        if (r116 == null) goto L34;
        r116.q(r102);
        goto L34
    L68:
        return;
    L63:
        return;
    L62:
        return;
    L38:
        RitDataWrapper r117 = (RitDataWrapper) ((LinkedHashMap) this.f162795a).get(r100);
        if (r117 == null) goto L64;
        Map<String, CompDataWrapper> r118 = r117.f162731a;
        if (r118 == null) goto L65;
        CompDataWrapper r119 = (CompDataWrapper) ((LinkedHashMap) r118).get(r101);
        if (r119 == null) goto L66;
        r119.q(r102);
        return;
    L66:
        return;
    L65:
        return;
    L64:
        return;
    L25:
        if (r101.length() != 0) goto L27;
    L5:
        if (r100.length() == 0) goto L8;
        r104 = false;
        goto L9
    }

    public final void g(String r100, Map<String, ? extends Object> r101, String r102) {
        if (ex2.d.a(r100) == false) goto L54;
        JSONObject r103 = ex2.d.c(r100);
        if (r103 != null) goto L7;
        return;
    L7:
        JSONObject r104 = r103.optJSONObject("resource_payload");
        if (r104 == null) goto L10;
        r103 = r104;
    L10:
        Iterator<String> r105 = r103.keys();
    L12:
        if (r105.hasNext() == false) goto L87;
        String r106 = r105.next();
        if (r106 == null) goto L12;
        Object r107 = null;
        if (r101 == null) goto L19;
        Object r108 = r101.get(r106);
    L20:
        if (r108 == null) goto L22;
        if ((r108 instanceof Map) == true) goto L31;
        if ((r108 instanceof String) == false) goto L43;
        r107 = r108;
    L43:
        String r109 = (String) r107;
        if (r109 != null) goto L47;
        r109 = "";
    L47:
        if (b(this.f162805k, r106) == true) goto L48;
        RitDataWrapper r110 = (RitDataWrapper) ((LinkedHashMap) this.f162795a).get(r106);
        if (r110 == null) goto L12;
        r110.b(r109, r102);
        goto L12
    L48:
        RitDataWrapperV5 r111 = (RitDataWrapperV5) ((LinkedHashMap) this.f162804j).get(r106);
        if (r111 == null) goto L12;
        r111.h(r109, r102);
        goto L12
    L31:
        String r112 = new JSONObject((Map) r108).toString();
        if (b(this.f162805k, r106) == true) goto L33;
        RitDataWrapper r113 = (RitDataWrapper) ((LinkedHashMap) this.f162795a).get(r106);
        if (r113 == null) goto L12;
        r113.b(r112, r102);
        goto L12
    L33:
        RitDataWrapperV5 r114 = (RitDataWrapperV5) ((LinkedHashMap) this.f162804j).get(r106);
        if (r114 == null) goto L12;
        r114.h(r112, r102);
        goto L12
    L22:
        if (b(this.f162805k, r106) == true) goto L23;
        RitDataWrapper r115 = (RitDataWrapper) ((LinkedHashMap) this.f162795a).get(r106);
        if (r115 == null) goto L12;
        int r116 = RitDataWrapper.f162730q;
        r115.b(null, r102);
        goto L12
    L23:
        RitDataWrapperV5 r117 = (RitDataWrapperV5) ((LinkedHashMap) this.f162804j).get(r106);
        if (r117 == null) goto L12;
        int r118 = RitDataWrapperV5.f162747w;
        r117.h(null, r102);
        goto L12
    L19:
        r108 = null;
        goto L20
    L87:
        return;
    }

    public final void k(com.bytedance.android.marketing.sdk.api.c r110, String r111, String r112) {
        FrameLayout r100 = r110.f162671b;
        if (r100 == null) goto L5;
        this.f162796b = new WeakReference(r100);
    L5:
        Map<String, ? extends Object> r101 = r110.f162673d;
        if (r101 == null) goto L8;
        this.f162799e = r101;
    L8:
        Map<String, ? extends Object> r102 = r110.f162674e;
        if (r102 == null) goto L11;
        this.f162800f = r102;
    L11:
        String r103 = r110.f162670a;
        if (r103 == null) goto L14;
        JSONObject r104 = ex2.d.c(r103);
    L15:
        if (r104 != null) goto L17;
        i(r111, "PageData解析异常");
    L17:
        if (r104 == null) goto L19;
        JSONObject r105 = r104.optJSONObject("resource_payload");
    L21:
        if (r105 == null) goto L23;
        r104 = r105;
        boolean r106 = true;
    L24:
        if (r104 != null) goto L26;
    L30:
        if (r104 == null) goto L63;
        Iterator<String> r107 = r104.keys();
        if (r107 == null) goto L63;
    L34:
        if (r107.hasNext() == false) goto L63;
        String r108 = r107.next();
        if (r108 == null) goto L34;
        if (ex2.d.a(r111) == false) goto L44;
        if ((!Intrinsics.areEqual(r108, r111)) == true) goto L34;
    L44:
        if (r104.optJSONObject(r108) == null) goto L46;
        JSONObject r109 = r104.optJSONObject(r108);
    L55:
        if (r109 == null) goto L56;
        if (r106 == true) goto L58;
        RitDataWrapper r113 = d(r108);
        r113.f162737g = r110.a(r108);
        r113.f162736f = r110.b(r108);
        m(r108, r109, r112);
        goto L34
    L58:
        Map<String, Map<String, Boolean>> r114 = this.f162803i;
        String r115 = this.f162805k;
        LinkedHashMap r116 = (LinkedHashMap) r114;
        Object r117 = r116.get(r115);
        if (r117 != null) goto L61;
        r117 = new LinkedHashMap();
        r116.put(r115, r117);
    L61:
        ((Map) r117).put(r108, Boolean.TRUE);
        RitDataWrapperV5 r118 = e(r108);
        r118.f162754g = r110.a(r108);
        r118.f162753f = r110.b(r108);
        n(r108, r109);
        goto L34
    L56:
        i(r108, "RitData解析异常");
        goto L34
    L46:
        String r119 = r104.optString(r108);
        if (r119.length() <= 0) goto L49;
        boolean r120 = true;
    L50:
        if (r120 == true) goto L87;
    L54:
        r109 = null;
        goto L55
    L87:
        r109 = new JSONObject(r119);     // Catch: Exception -> L53
        goto L55
    L49:
        r120 = false;
    L63:
        Iterator r121 = ((LinkedHashMap) r110.f162677h).keySet().iterator();
    L65:
        if (r121.hasNext() == false) goto L75;
        String r122 = (String) r121.next();
        FrameLayout r123 = (FrameLayout) ((LinkedHashMap) r110.f162677h).get(r122);
        if (r123 == null) goto L65;
        if (r106 == true) goto L69;
        RitDataWrapper r124 = (RitDataWrapper) ((LinkedHashMap) this.f162795a).get(r122);
        if (r124 == null) goto L65;
        r124.f162734d = new WeakReference(r123);
        goto L65
    L69:
        RitDataWrapperV5 r125 = (RitDataWrapperV5) ((LinkedHashMap) this.f162804j).get(r122);
        if (r125 == null) goto L65;
        r125.f162748a = new WeakReference(r123);
        goto L65
    L75:
        Iterator r126 = ((LinkedHashMap) r110.f162678i).keySet().iterator();
    L77:
        if (r126.hasNext() == false) goto L86;
        String r127 = (String) r126.next();
        if (r106 == true) goto L81;
        RitDataWrapper r128 = (RitDataWrapper) ((LinkedHashMap) this.f162795a).get(r127);
        if (r128 == null) goto L77;
        r128.f162735e = (String) ((LinkedHashMap) r110.f162678i).get(r127);
        goto L77
    L81:
        if (((RitDataWrapperV5) ((LinkedHashMap) this.f162804j).get(r127)) == null) goto L77;
        String r129 = (String) ((LinkedHashMap) r110.f162678i).get(r127);
        goto L77
    L86:
        return;
    L26:
        if (ex2.d.a(r111) == false) goto L30;
        if (r104.has(r111) == true) goto L30;
        i(r111, "PageData中不存在RitData");
        goto L30
    L23:
        r106 = false;
        goto L24
    L19:
        r105 = null;
        goto L21
    L14:
        r104 = null;
        goto L15
    }

    public final void m(String r110, JSONObject r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, BdpAppEventConstant.PARAMS_RIT);
        if (r111 == null) goto L79;
        RitDataWrapper r100 = d(r110);
        String r101 = this.f162802h.getServicePageName();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r100.f162742l = r101;
        String r102 = this.f162802h.getLoadEntryType();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r100.f162743m = r102;
        Intrinsics.checkNotNullParameter(r110, BdpAppEventConstant.PARAMS_RIT);
        String r103 = r111.optString("plan_id");
        int r104 = 0;
        if (r103.length() <= 0) goto L7;
        boolean r105 = true;
    L8:
        String r106 = null;
        if (r105 == true) goto L12;
        r103 = null;
    L12:
        r100.f162740j = r103;
        JSONObject r107 = r111.optJSONObject("data");
        if (r107 == null) goto L22;
        String r108 = r107.optString(CronetDataStorageAccess.LOGID);
        if (r108 == null) goto L22;
        if (r108.length() <= 0) goto L19;
        boolean r109 = true;
    L20:
        if (r109 == false) goto L22;
    L23:
        r100.f162741k = r108;
        LinkedHashSet r113 = new LinkedHashSet();
        JSONObject r114 = r111.optJSONObject(RootDescription.ROOT_ELEMENT);
        if (r114 == null) goto L26;
        JSONArray r115 = r114.optJSONArray("views");
    L27:
        if (r115 == null) goto L29;
        int r116 = r115.length();
    L30:
        String r117 = "";
        if (r104 >= r116) goto L38;
        if (r115 == null) goto L37;
        String r118 = JSONArrayProtectorUtils.getString(r115, r104);
        if (r118 == null) goto L37;
        r117 = r118;
    L37:
        r113.add(r117);
        r104 = r104 + 1;
        goto L30
    L38:
        r100.f162733c = r113;
        JSONObject r119 = r111.optJSONObject(RootDescription.ROOT_ELEMENT);
        if (r119 == null) goto L41;
        r106 = r119.optString("default");
    L41:
        if (r106 == null) goto L44;
        r117 = r106;
    L44:
        r100.f162732b = r117;
        JSONObject r120 = r111.optJSONObject("extra_data");
        if (r120 == null) goto L50;
        Map<? extends String, ? extends Object> r121 = com.bytedance.android.marketing.sdk.impl.utils.f.b(r120);
        Map r122 = r100.f162736f;
        if (r122 != null) goto L49;
        r122 = new LinkedHashMap();
    L49:
        Map<String, ? extends Object> r123 = MapsKt.toMutableMap(r122);
        r123.putAll(r121);
        Unit r124 = Unit.INSTANCE;
        r100.f162736f = r123;
    L50:
        JSONObject r125 = r111.optJSONObject("common_log_params");
        if (r125 == null) goto L56;
        Map<? extends String, ? extends Object> r126 = com.bytedance.android.marketing.sdk.impl.utils.f.b(r125);
        Map r127 = r100.f162737g;
        if (r127 != null) goto L55;
        r127 = new LinkedHashMap();
    L55:
        Map<String, ? extends Object> r128 = MapsKt.toMutableMap(r127);
        r128.putAll(r126);
        Unit r129 = Unit.INSTANCE;
        r100.f162737g = r128;
    L56:
        String r130 = r111.optString("version");
        r100.f162738h = r130;
        if (Intrinsics.areEqual(r130, DevicePlans.DEVICE_PLAN_VIVO4) == false) goto L59;
        r100.f162739i = r111;
        JSONObject r131 = r111.optJSONObject("view_config");
    L60:
        if (r131 != null) goto L63;
        r100.c("RitData组件列表解析异常");
        return;
    L63:
        if (ex2.d.a(r112) == true) goto L65;
    L67:
        Iterator<String> r132 = r131.keys();
    L69:
        if (r132.hasNext() == false) goto L96;
        String r133 = r132.next();
        if (ex2.d.a(r112) == false) goto L75;
        if ((!Intrinsics.areEqual(r133, r112)) == true) goto L69;
    L75:
        JSONObject r134 = r131.optJSONObject(r133);
        if (r134 == null) goto L77;
        r100.d(r110, r133, r134);
        goto L69
    L77:
        r100.c("CompData解析异常: " + r133);
        goto L69
    L96:
        return;
    L65:
        if (r131.has(r112) == true) goto L67;
        r100.c("RitData中不存在组件: " + r112);
        return;
    L59:
        r131 = r111.optJSONObject("data");
        goto L60
    L29:
        r116 = 0;
        goto L30
    L26:
        r115 = null;
        goto L27
    L19:
        r109 = false;
    L22:
        r108 = null;
        goto L23
    L7:
        r105 = false;
        goto L8
    }

    public final void j(String r100, Object r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        boolean r104 = true;
        if (r102 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L23;
        Iterator r106 = ((LinkedHashMap) this.f162795a).keySet().iterator();
    L12:
        if (r106.hasNext() == false) goto L68;
        String r107 = (String) r106.next();
        RitDataWrapper r108 = (RitDataWrapper) ((LinkedHashMap) this.f162795a).get(r107);
        if (r108 == null) goto L12;
        Map<String, CompDataWrapper> r109 = r108.f162731a;
        if (r109 == null) goto L12;
        LinkedHashMap r110 = (LinkedHashMap) r109;
        Iterator r111 = r110.keySet().iterator();
    L19:
        if (r111.hasNext() == false) goto L12;
        CompDataWrapper r112 = (CompDataWrapper) r110.get((String) r111.next());
        if (r112 == null) goto L19;
        r112.p(r100, r101);
        goto L19
    L68:
        return;
    L23:
        if (r103 != null) goto L25;
    L28:
        if (r104 == false) goto L39;
        RitDataWrapper r113 = (RitDataWrapper) ((LinkedHashMap) this.f162795a).get(r102);
        if (r113 == null) goto L63;
        Map<String, CompDataWrapper> r114 = r113.f162731a;
        if (r114 == null) goto L64;
        LinkedHashMap r115 = (LinkedHashMap) r114;
        Iterator r116 = r115.keySet().iterator();
    L35:
        if (r116.hasNext() == false) goto L69;
        CompDataWrapper r117 = (CompDataWrapper) r115.get((String) r116.next());
        if (r117 == null) goto L35;
        r117.p(r100, r101);
        goto L35
    L69:
        return;
    L64:
        return;
    L63:
        return;
    L39:
        RitDataWrapper r118 = (RitDataWrapper) ((LinkedHashMap) this.f162795a).get(r102);
        if (r118 == null) goto L65;
        Map<String, CompDataWrapper> r119 = r118.f162731a;
        if (r119 == null) goto L66;
        CompDataWrapper r120 = (CompDataWrapper) ((LinkedHashMap) r119).get(r103);
        if (r120 == null) goto L67;
        r120.p(r100, r101);
        return;
    L67:
        return;
    L66:
        return;
    L65:
        return;
    L25:
        if (r103.length() == 0) goto L28;
        r104 = false;
        goto L28
    L5:
        if (r102.length() == 0) goto L8;
        r105 = false;
        goto L9
    }

    public final void f(com.bytedance.android.marketing.sdk.api.c r100, Map<String, ? extends Object> r101, String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        boolean r102 = false;
        if (r110 != null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if (r103 == false) goto L22;
        if (r111 != null) goto L13;
    L14:
        r102 = true;
    L15:
        if (r102 == false) goto L22;
        Intrinsics.checkNotNullParameter(r100, "builder");
        h(r100.f162670a);
        k(r100, null, null);
        g(r100.f162670a, r101, r112);
        int r104 = com.bytedance.android.marketing.sdk.impl.utils.d.f162815a;
        TrackData r105 = this.f162802h;
        String r106 = ex2.c.c(r100);
        Map<String, RitDataWrapper> r113 = this.f162795a;
        ArrayList r114 = new ArrayList(r113.size());
        Iterator r115 = ((LinkedHashMap) r113).entrySet().iterator();
    L18:
        if (r115.hasNext() == false) goto L20;
        r114.add((String) ((Map.Entry) r115.next()).getKey());
        goto L18
    L20:
        com.bytedance.android.marketing.sdk.impl.utils.d.b(r105, r106, r114, 1, "");
        return;
    L13:
        if (r111.length() != 0) goto L15;
    L22:
        h(r100.f162670a);
        k(r100, r110, r111);
        String r107 = r100.f162670a;
        if (ex2.d.a(r107) == false) goto L77;
        JSONObject r108 = ex2.d.c(r107);
        if (r108 == null) goto L77;
        JSONObject r109 = r108.optJSONObject("resource_payload");
        if (r109 == null) goto L30;
        r108 = r109;
    L30:
        Iterator<String> r116 = r108.keys();
    L32:
        if (r116.hasNext() == false) goto L77;
        String r117 = r116.next();
        if (r117 == null) goto L32;
        if (ex2.d.a(r110) == false) goto L41;
        if ((!Intrinsics.areEqual(r117, r110)) == true) goto L32;
    L41:
        if (r101 == null) goto L43;
        Object r118 = r101.get(r117);
    L44:
        if (r118 == null) goto L46;
        if ((r118 instanceof Map) == true) goto L55;
        if ((r118 instanceof String) == true) goto L66;
        r118 = null;
    L66:
        String r119 = (String) r118;
        if (r119 != null) goto L70;
        r119 = "";
    L70:
        if (b(this.f162805k, r117) == true) goto L71;
        RitDataWrapper r120 = (RitDataWrapper) ((LinkedHashMap) this.f162795a).get(r117);
        if (r120 == null) goto L32;
        r120.a(r111, r119, r112);
        goto L32
    L71:
        RitDataWrapperV5 r121 = (RitDataWrapperV5) ((LinkedHashMap) this.f162804j).get(r117);
        if (r121 == null) goto L32;
        r121.h(r119, r112);
        goto L32
    L55:
        String r122 = new JSONObject((Map) r118).toString();
        if (b(this.f162805k, r117) == true) goto L57;
        RitDataWrapper r123 = (RitDataWrapper) ((LinkedHashMap) this.f162795a).get(r117);
        if (r123 == null) goto L32;
        r123.a(r111, r122, r112);
        goto L32
    L57:
        RitDataWrapperV5 r124 = (RitDataWrapperV5) ((LinkedHashMap) this.f162804j).get(r117);
        if (r124 == null) goto L32;
        r124.h(r122, r112);
        goto L32
    L46:
        if (b(this.f162805k, r117) == true) goto L47;
        RitDataWrapper r125 = (RitDataWrapper) ((LinkedHashMap) this.f162795a).get(r117);
        if (r125 == null) goto L32;
        int r126 = RitDataWrapper.f162730q;
        r125.a(r111, null, r112);
        goto L32
    L47:
        RitDataWrapperV5 r127 = (RitDataWrapperV5) ((LinkedHashMap) this.f162804j).get(r117);
        if (r127 == null) goto L32;
        int r128 = RitDataWrapperV5.f162747w;
        r127.h(null, r112);
        goto L32
    L43:
        r118 = null;
    L77:
        int r129 = com.bytedance.android.marketing.sdk.impl.utils.d.f162815a;
        TrackData r130 = this.f162802h;
        String r131 = ex2.c.c(r100);
        Map<String, RitDataWrapper> r132 = this.f162795a;
        ArrayList r133 = new ArrayList(r132.size());
        Iterator r134 = ((LinkedHashMap) r132).entrySet().iterator();
    L79:
        if (r134.hasNext() == false) goto L81;
        r133.add((String) ((Map.Entry) r134.next()).getKey());
        goto L79
    L81:
        com.bytedance.android.marketing.sdk.impl.utils.d.b(r130, r131, r133, 1, "");
        return;
    L5:
        if (r110.length() == 0) goto L8;
        r103 = false;
        goto L10
    }
}
