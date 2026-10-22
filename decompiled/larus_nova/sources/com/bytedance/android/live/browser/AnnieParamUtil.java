package com.bytedance.android.live.browser;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceResponse;
import com.android.ttcjpaysdk.base.utils.CJPayGestureUtils;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.x1;
import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.config.f3;
import com.bytedance.android.livesdk.config.td;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ext.EpisodeExtKt;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class AnnieParamUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f62513a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Boolean f62514b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Pair<Object, Boolean>> f62515c = null;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/live/browser/AnnieParamUtil$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<List<? extends Object>> {
        public a() {
        }
    }

    static {
        f62513a = new String[]{"568863", "615883", "1349"};
        f62514b = f3.f120172a.getValue();
        f62515c = new ConcurrentHashMap();
    }

    @JvmStatic
    public static final Map<String, String> i() {
        HashMap r100 = new HashMap();
        j0 r101 = j0.l();
        com.bytedance.android.livesdk.log.filter.o r102 = r101.c(com.bytedance.android.livesdk.log.filter.t.class);
        if (r102 == null) goto L5;
        r102.a(r100);
    L5:
        com.bytedance.android.livesdk.log.filter.o r103 = r101.c(IRoom.class);
        if (r103 == null) goto L8;
        r103.a(r100);
    L8:
        LinkedHashMap r104 = new LinkedHashMap();
        Iterator r105 = r100.entrySet().iterator();
    L10:
        if (r105.hasNext() == false) goto L15;
        Map.Entry r106 = (Map.Entry) r105.next();
        if (StringsKt.contains$default((String) r106.getKey(), "vs", false, 2, null) == false) goto L10;
        r104.put(r106.getKey(), r106.getValue());
        goto L10
    L15:
        return MapsKt.toMutableMap(r104);
    }

    @JvmStatic
    public static final void a(final com.bytedance.android.annie.param.k r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        int r101 = com.bytedance.android.annie.param.b.f39698a;
        com.bytedance.android.annie.param.b.a(new AnnieParamUtil$appendAllFinalParams$1(r100));
        com.bytedance.android.annie.param.b.a(new AnnieParamUtil$appendAllFinalParams$2(r100));
        com.bytedance.android.annie.param.b.a(new AnnieParamUtil$appendAllFinalParams$3(r100));
        Boolean r102 = td.f121288a.getValue();
        if (r102 == null) goto L5;
        boolean r103 = r102.booleanValue();
    L6:
        r100.s1(r103);
        Object r104 = String.valueOf(((IMiddleWareHostContext) jc1.k.n(IMiddleWareHostContext.class)).hostAppId());
        if (r104 != null) goto L10;
        r104 = 0;
    L10:
        if (ArraysKt.contains(f62513a, r104) == false) goto L12;
        r100.E1();
    L12:
        IMiddlewareNetworkService r105 = (IMiddlewareNetworkService) jc1.k.f(IMiddlewareNetworkService.class);
        if (r105 == null) goto L24;
        final Map<String, String> r106 = r105.getCommonParams();
        if (r106 == null) goto L25;
        String r107 = r106.get(TTVideoEngineInterface.PLAY_API_KEY_AC);
        if (r107 == null) goto L19;
        r100.R0(r107);
    L19:
        String r108 = r106.get("current_network_quality_info");
        if (r108 == null) goto L22;
        r100.k1(r108);
    L22:
        com.bytedance.android.annie.param.b.a(new AnnieParamUtil$appendAllFinalParams$$inlined$let$lambda$1(r106, r100));
        return;
    L25:
        return;
    L24:
        return;
    L5:
        r103 = false;
        goto L6
    }

    @JvmStatic
    public static final void b(com.bytedance.android.annie.param.k r100) {
        IMiddleWareHostContext r101 = (IMiddleWareHostContext) jc1.k.f(IMiddleWareHostContext.class);
        if (r101 == null) goto L15;
        r100.q2(String.valueOf(r101.getUpdateVersionCode()));
        r100.o2(r101.isNeedProtectUnderage() ? 1 : 0);
        ALogger.i("HybridParamUtil", "AnnieParamUtil is_teen_mode = " + r100.P0());
        if (fm3.d.b() == true) goto L12;
        Boolean r102 = r101.isDarkMode();
        if (Intrinsics.areEqual(r102, Boolean.TRUE) == false) goto L11;
    L13:
        String r103 = "dark";
    L14:
        r100.b1(r103);
        goto L15
    L11:
        if (Intrinsics.areEqual(r102, Boolean.FALSE) == false) goto L13;
    L12:
        r103 = "light";
    L15:
        com.bytedance.android.livesdk.user.e r104 = ((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user();
        if (r104 == null) goto L19;
        r100.H1(r104.isLogin() ? 1 : 0);
        return;
    }

    public static JsonElement e(Object r100) {
        Gson r101 = GsonHelper.get();
        if ((r100 instanceof JSONObject) == false) goto L6;
        return GsonProtectorUtils.toJsonTree(r101, GsonProtectorUtils.fromJson(r101, r100.toString(), Object.class));
    L6:
        if ((r100 instanceof JSONArray) == false) goto L9;
        return GsonProtectorUtils.toJsonTree(r101, GsonProtectorUtils.fromJson(r101, r100.toString(), new a().getType()));
    L9:
        return GsonProtectorUtils.toJsonTree(r101, r100);
    }

    @JvmStatic
    public static final Map<String, Object> g(String r100) {
        if (r100 == null) goto L4;
        WebResourceResponse r101 = com.bytedance.android.livesdk.gecko.n.f125818b.c(r100);
        if (r101 == null) goto L8;
        BufferedReader r102 = new BufferedReader(new InputStreamReader(r101.getData()));
        StringBuilder r103 = new StringBuilder();
    L10:
        String r104 = r102.readLine();
        if (r104 == null) goto L13;
        r103.append(Intrinsics.stringPlus(r104, "\n"));
        goto L10
    L13:
        ALogger.i("HybridParamUtil", "inject_json = " + r103);
        return UtilsKt.g(new JSONObject(r103.toString()));
    L16:
        ALogger.e("HybridParamUtil", "inject_json parse error");
        return new HashMap();
    L8:
        return new HashMap();
    L4:
        return new HashMap();
    }

    @JvmStatic
    public static final Object h(String r100) {
        Boolean r101 = f62514b;
        if (r101.booleanValue() == false) goto L8;
        Pair<Object, Boolean> r102 = f62515c.get(r100);
        if (r102 == null) goto L8;
        return r102.getFirst();
    L8:
        Object r103 = SettingUtil.getRawValue("key_ttlive_sdk_setting", r100);
        if (r101.booleanValue() == false) goto L16;
        if (r100 == null) goto L16;
        ConcurrentHashMap<String, Pair<Object, Boolean>> r104 = f62515c;
        if (r103 != null) goto L14;
        boolean r105 = true;
    L15:
        r104.put(r100, TuplesKt.to(r103, Boolean.valueOf(r105)));
        goto L16
    L14:
        r105 = false;
    L16:
        return r103;
    }

    public static boolean j(String r100) {
        if (r100 != null) goto L14;
        return false;
    L14:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        Object r102 = Result.m9449constructorimpl(Boolean.valueOf(UriProtector.parse(r100).getBooleanQueryParameter("inject_cache_async", false)));     // Catch: Throwable -> L7
    L9:
        Boolean r103 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r102) == false) goto L13;
        r102 = r103;
    L13:
        return ((Boolean) r102).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    @JvmStatic
    public static final void d(com.bytedance.android.annie.param.k r100, Context r101) {
        if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == true) goto L5;
    L7:
        Iterator<String> r102 = AnnieConfigSettingKeys.TRY_FIX_NATIVIGATION_BAR_HEIGHT_DEVICE.a().iterator();
    L9:
        if (r102.hasNext() == false) goto L13;
        if (Intrinsics.areEqual(r102.next(), Build.MODEL) == false) goto L9;
        boolean r103 = true;
    L14:
        if (r103 == false) goto L35;
        if (r101 == null) goto L34;
        Resources r104 = r101.getResources();
        int r105 = r104.getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");
        if (r105 <= 0) goto L20;
        int r106 = r104.getDimensionPixelSize(r105);
    L21:
        Rect r107 = new Rect();
        if ((r101 instanceof Activity) == false) goto L33;
        View r108 = ((Activity) r101).getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L28;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r109 = ThreadMethodProxy.currentThread();
        if (r109 == com.larus.home.impl.utils.c.f346341a) goto L28;
        com.larus.home.impl.utils.c.a(r109, "getDecorView");
    L28:
        r108.getWindowVisibleDisplayFrame(r107);
        int r110 = r107.height();
        if (r110 != (x1.e(r101) - r106)) goto L31;
        r110 = r110 - s1.A();
    L31:
        r106 = Math.min(Math.max((x1.e(r101) - s1.A()) - r110, 0), r106);
    L36:
        int r111 = s1.q(r101).heightPixels - r106;
        r100.d2(s1.G(r111));
        r100.e2(r111);
        Resources r112 = s1.getResources();
        if (r112 == null) goto L46;
        Configuration r113 = r112.getConfiguration();
        if (r113 == null) goto L46;
        int r114 = r113.orientation;
        if (r114 != 1) goto L44;
        r100.P1(0);
        goto L46
    L44:
        if (r114 != 2) goto L46;
        r100.P1(1);
    L46:
        r100.g2(s1.G(s1.y()));
        r100.Y1(s1.G(s1.q(r101).heightPixels));
        r100.h2(s1.y());
        return;
    L33:
        if (x1.c(r101) == true) goto L36;
    L20:
        r106 = 0;
    L34:
        r106 = 0;
        goto L36
    L35:
        r106 = x1.j(r101);
        goto L36
    L13:
        r103 = false;
        goto L14
    L5:
        if (AnnieConfigSettingKeys.AVOID_WORKER_THREAD_INVOKE_DECORVIEW.a().booleanValue() == false) goto L7;
        goto L7
    }

    public static void c(com.bytedance.android.annie.param.k r110, String r111, String r112) {
        com.bytedance.live.datacontext.m<IRoom> r100 = o3.f().getRoom();
        if (r100 == null) goto L5;
        IRoom r101 = r100.getValue();
    L6:
        IMiddlewareUserService r102 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        if (r102 == null) goto L17;
        com.bytedance.android.livesdk.user.e r103 = r102.user();
        if (r103 == null) goto L17;
        String r104 = r103.n();
        if (r104 == null) goto L13;
        r110.r2(r104);
        ALogger.i("HybridParamUtil", "userID = ".concat(r104));
    L13:
        String r105 = com.bytedance.android.live.base.model.user.o.a(r103.b());
        if (r105 == null) goto L17;
        r110.j2(r105);
    L17:
        if (r101 == null) goto L29;
        String r106 = r101.getIdStr();
        if (r106 == null) goto L21;
        r110.a2(r106);
    L21:
        String r107 = r101.getOwnerUserIdString();
        if (r107 == null) goto L24;
        r110.W0(r107);
    L24:
        IBaseUser r108 = r101.getOwner();
        if (r108 == null) goto L29;
        Intrinsics.checkNotNullParameter(r108, "$this$secUidExt");
        String r109 = r108.getCastSecUid();
        if (r109 == null) goto L29;
        r110.i2(r109);
    L29:
        boolean r113 = pm1.h.f529819a;
        if (pm1.h.f529819a == false) goto L43;
        lm1.b r114 = pm1.f.d(null);
        if (r114 == null) goto L36;
        com.bytedance.live.datacontext.n<Episode> r115 = r114.getEpisode();
        if (r115 == null) goto L36;
        Episode r116 = r115.getValue();
    L37:
        if (r116 == null) goto L43;
        r110.a2(String.valueOf(r116.getIdExt()));
        r110.W0(EpisodeExtKt.getOwnerIdString(r116));
        IBaseUser r117 = r116.getOwner();
        if (r117 == null) goto L43;
        Intrinsics.checkNotNullParameter(r117, "$this$secUidExt");
        String r118 = r117.getCastSecUid();
        if (r118 == null) goto L43;
        r110.i2(r118);
    L36:
        r116 = null;
    L43:
        JsonObject r119 = new JsonObject();
        int r120 = 0;
        boolean r121 = true;
        if (TextUtils.isEmpty(r111) == true) goto L67;
        Uri r122 = UriProtector.parse(r111);
        if (r122 == null) goto L49;
        String r123 = UriProtector.getQueryParameter(r122, AppConstants.BUNDLE_SETTING_KEYS);
    L50:
        if (r123 == null) goto L52;
        List r124 = StringsKt.split$default(r123, new String[]{","}, false, 0, 6, null);
    L53:
        List r125 = r124;
        if (r125 != null) goto L56;
    L59:
        boolean r126 = true;
    L60:
        if (r126 == true) goto L67;
        Iterator r127 = r124.iterator();
    L63:
        if (r127.hasNext() == false) goto L67;
        String r128 = (String) r127.next();
        Object r129 = h(r128);
        if (r129 == null) goto L63;
        r119.add(r128, GsonProtectorUtils.toJsonTree(new Gson(), r129));
        goto L63
    L56:
        if (r125.isEmpty() == true) goto L59;
        r126 = false;
        goto L60
    L52:
        r124 = null;
        goto L53
    L49:
        r123 = null;
    L67:
        r110.k2(r119);
        JsonObject r130 = new JsonObject();
    L94:
        e = move-exception;
        ALogger.e("HybridParamUtil", e);
    L96:
        r110.T0(r130);
        JsonObject r131 = new JsonObject();
    L120:
        e = move-exception;
        ALogger.e("HybridParamUtil", e);
    L122:
        r110.u1(r131);
        Map<String, ? extends Object> r132 = new HashMap();
        if (TextUtils.isEmpty(r111) == true) goto L146;
        Uri r133 = UriProtector.parse(r111);
        if (r133 == null) goto L128;
        String r134 = UriProtector.getQueryParameter(r133, AppConstants.BUNDLE_ACTIVITY_AB_PARAMS_KEYS);
    L129:
        if (r134 != null) goto L131;
    L134:
        if (r121 == true) goto L146;
        ArrayList r135 = new ArrayList();
        JSONArray r136 = new JSONArray(r134);
        int r137 = r136.length();
    L137:
        if (r120 >= r137) goto L139;
        r135.add(r136.get(r120).toString());
        r120 = r120 + 1;
        goto L137
    L139:
        Map<String, Object> r138 = ((IMiddleWareHostContext) jc1.k.n(IMiddleWareHostContext.class)).getSettings(r135);
        if (r138 != null) goto L142;
    L145:
        r132 = null;
        goto L146
    L142:
        if (r138.isEmpty() == true) goto L145;
        r132 = UtilsKt.g(new JSONObject(r138.toString()));
        goto L146
    L131:
        if (r134.length() == 0) goto L134;
        r121 = false;
        goto L134
    L128:
        r134 = null;
    L146:
        if (r132 == null) goto L148;
        r110.Q0(r132);
    L148:
        if (r111 == null) goto L150;
        Uri r139 = UriProtector.parse(r111);
    L151:
        ArrayList r140 = new ArrayList();
        r140.add(new ja1.a.c(r112));
        r140.add(new ja1.a.b(r139));
        r140.add(new ja1.a.C6406a(null));
        Object r141 = "";
        if (r140.isEmpty() == true) goto L160;
        Iterator r142 = r140.iterator();
    L156:
        if (r142.hasNext() == false) goto L160;
        ja1.b r143 = (ja1.b) r142.next();
        if (r143.a("inject_json_url") == false) goto L156;
        r141 = r143.b("inject_json_url", "");
    L160:
        r110.D1(g((String) r141));
        return;
    L150:
        r139 = null;
        goto L151
    L98:
        if (TextUtils.isEmpty(r111) == true) goto L122;
        Uri r144 = UriProtector.parse(r111);     // Catch: Exception -> L120
        if (r144 == null) goto L103;
        String r145 = UriProtector.getQueryParameter(r144, AppConstants.BUNDLE_ACTIVITY_DYNAMIC_SETTINGS_KEYS);     // Catch: Exception -> L120
    L104:
        if (r145 == null) goto L122;
        JSONArray r146 = new JSONArray(r145);     // Catch: Exception -> L120
        int r147 = r146.length();     // Catch: Exception -> L120
        int r148 = 0;
    L106:
        if (r148 >= r147) goto L122;
        Object r149 = r146.get(r148);     // Catch: Exception -> L120
        if (r149 == null) goto L119;
        if (r149.toString().length() <= 0) goto L112;
        boolean r150 = true;
    L113:
        if (r150 == false) goto L119;
        Object r151 = ((IMiddleWareHostContext) jc1.k.n(IMiddleWareHostContext.class)).getUgSettingsByKey(1, "data." + r149);     // Catch: Exception -> L120
        if (r151 == null) goto L119;
        JsonElement r152 = e(r151);     // Catch: Exception -> L120
        if (r152 == null) goto L119;
        r131.add(r146.get(r148).toString(), r152);     // Catch: Exception -> L120
        goto L119
    L112:
        r150 = false;
    L119:
        r148 = r148 + 1;
        goto L106
    L103:
        r145 = null;
        goto L104
    L69:
        if (TextUtils.isEmpty(r111) == true) goto L96;
        Uri r153 = UriProtector.parse(r111);     // Catch: Exception -> L94
        if (r153 == null) goto L74;
        String r154 = UriProtector.getQueryParameter(r153, AppConstants.BUNDLE_ACTIVITY_SETTING_KEYS);     // Catch: Exception -> L94
    L75:
        if (r154 == null) goto L96;
        JSONArray r155 = new JSONArray(r154);     // Catch: Exception -> L94
        int r156 = r155.length();     // Catch: Exception -> L94
        int r157 = 0;
    L77:
        if (r157 >= r156) goto L96;
        Object r158 = r155.get(r157);     // Catch: Exception -> L94
        if (r158 == null) goto L93;
        if (r158.toString().length() <= 0) goto L83;
        boolean r159 = true;
    L84:
        if (r159 == true) goto L87;
        r158 = null;
    L87:
        if (r158 == null) goto L93;
        Object r160 = ((IMiddleWareHostContext) jc1.k.n(IMiddleWareHostContext.class)).getUgSettingsByKey(0, "data.common_info.extra." + r158.toString());     // Catch: Exception -> L94
        if (r160 == null) goto L93;
        JsonElement r161 = e(r160);     // Catch: Exception -> L94
        if (r161 == null) goto L93;
        r130.add(r155.get(r157).toString(), r161);     // Catch: Exception -> L94
        goto L93
    L83:
        r159 = false;
    L93:
        r157 = r157 + 1;
        goto L77
    L74:
        r154 = null;
        goto L75
    L5:
        r101 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void f(final com.bytedance.android.annie.param.k r110, Context r111, String r112, String r113, final w r210) {
        Intrinsics.checkNotNullParameter(r110, "param");
        Intrinsics.checkNotNullParameter(r113, "url");
        int r100 = o.f64152a;
        AnnieParamUtil$getCacheParam$1 r101 = AnnieParamUtil$getCacheParam$1.INSTANCE;
        final Function1<Map<String, ? extends Object>, Unit> r102 = new AnnieParamUtil$getCacheParam$2(r110);
        AnnieParamUtil$getCacheParam$3 r103 = AnnieParamUtil$getCacheParam$3.INSTANCE;
        final Function1<Map<String, ? extends Object>, Unit> r104 = new AnnieParamUtil$getCacheParam$4(r110);
        Function2<String, JSONObject, Unit> r105 = new AnnieParamUtil$getCacheParam$5(r210);
        Intrinsics.checkNotNullParameter(r101, "prefetchProvider");
        Intrinsics.checkNotNullParameter(r103, "storageProvider");
        Intrinsics.checkNotNullParameter(r102, "prefetchResolve");
        Intrinsics.checkNotNullParameter(r104, "storageResolve");
        Intrinsics.checkNotNullParameter(r105, "monitorResolve");
        if (r112 == null) goto L123;
        if (r113 != null) goto L111;
        return;
    L111:
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L56
        String r107 = UriProtector.getQueryParameter(UriProtector.parse(r112), "inject_config_channel");     // Catch: Throwable -> L56
        if (r107 == null) goto L51;
        JSONObject r108 = e0.c(r113, r107, "inject_data.json");     // Catch: Throwable -> L56
        if (r108 != null) goto L13;
        String r114 = "inject_json_miss";
    L14:
        Uri r115 = UriProtector.parse(r113);     // Catch: Throwable -> L56
        String r116 = r115.getPath();     // Catch: Throwable -> L56
        if (r116 == null) goto L52;
        if (r108 == null) goto L52;
        r114 = "parse_detail_failed";
        String r117 = UriProtector.getQueryParameter(r115, "inject_scene");     // Catch: Throwable -> L56
        if (r117 != null) goto L20;
        r117 = "default";
    L20:
        JSONObject r109 = r108.optJSONObject(r116);     // Catch: Throwable -> L56
        if (r109 == null) goto L52;
        JSONObject r118 = r109.optJSONObject(r117);     // Catch: Throwable -> L56
        if (r118 == null) goto L52;
        if (r118.optInt("disable_prefetch_inject") != 1) goto L27;
        boolean r119 = true;
    L29:
        if (r118.optInt("disable_storage_inject") != 1) goto L31;
        boolean r120 = true;
    L32:
        ArrayList r121 = new ArrayList();     // Catch: Throwable -> L56
        JSONArray r122 = r118.optJSONArray("api_storage_key");     // Catch: Throwable -> L56
        if (r122 == null) goto L37;
        int r123 = r122.length();     // Catch: Throwable -> L56
        int r124 = 0;
    L35:
        if (r124 >= r123) goto L37;
        r121.add(JSONArrayProtectorUtils.getString(r122, r124));     // Catch: Throwable -> L56
        r124 = r124 + 1;     // Catch: Throwable -> L56
    L37:
        ArrayList r125 = new ArrayList();     // Catch: Throwable -> L56
        JSONArray r126 = r118.optJSONArray("local_storage_key");     // Catch: Throwable -> L56
        if (r126 == null) goto L42;
        int r127 = r126.length();     // Catch: Throwable -> L56
        int r128 = 0;
    L40:
        if (r128 >= r127) goto L42;
        r125.add(JSONArrayProtectorUtils.getString(r126, r128));     // Catch: Throwable -> L56
        r128 = r128 + 1;     // Catch: Throwable -> L56
    L42:
        JSONArray r129 = r118.optJSONArray("dynamic_storage_keys");     // Catch: Throwable -> L56
        if (r129 == null) goto L50;
        int r130 = r129.length();     // Catch: Throwable -> L56
        int r131 = 0;
    L45:
        if (r131 >= r130) goto L50;
        String r132 = o.a(JSONArrayProtectorUtils.getString(r129, r131), UriProtector.parse(r112));     // Catch: Throwable -> L56
        if (r132 == null) goto L49;
        r125.add(r132);     // Catch: Throwable -> L56
    L49:
        r131 = r131 + 1;     // Catch: Throwable -> L56
    L50:
        m r133 = new m(r119, r120, r121, r125);     // Catch: Throwable -> L56
    L59:
        if (r133 == null) goto L125;
        final Ref.BooleanRef r134 = new Ref.BooleanRef();
        r134.element = false;
        Function1<Map<String, ? extends Object>, Unit> r135 = new CacheParamUtil$injectCacheParam$1(r134, r102);
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L80
        if (r133.f64148a == true) goto L78;
        JsonElement r137 = r101.invoke(UriProtector.parse(r113).buildUpon().clearQuery().build().toString());     // Catch: Throwable -> L80
        if (r137 == null) goto L78;
        if ((r137 instanceof JsonObject) == true) goto L70;
    L72:
        boolean r138 = false;
    L73:
        if (r138 == true) goto L76;
        r137 = null;
    L76:
        if (r137 == null) goto L78;
        r135.invoke(GsonHelper.getDefault().fromJson((JsonObject) r137, new n().getType()));     // Catch: Throwable -> L80
        goto L78
    L70:
        if (((JsonObject) r137).size() <= 0) goto L72;
        r138 = true;
    L78:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L80
    L82:
        final Ref.BooleanRef r139 = new Ref.BooleanRef();
        r139.element = false;
        boolean r140 = r134.element;
        Function2<Map<String, ? extends Object>, Boolean, Unit> r141 = new CacheParamUtil$injectCacheParam$2(r139, r104);
        if (r111 != null) goto L114;
    L105:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L107
    L109:
        o.c(r134.element, r139.element, r113, null, r105);
        return;
    L107:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L109
    L114:
        if (r133.f64149b == true) goto L105;
        LinkedHashMap r143 = new LinkedHashMap();     // Catch: Throwable -> L107
        if (r140 == true) goto L94;
        Iterator<T> r144 = r133.f64150c.iterator();     // Catch: Throwable -> L107
    L91:
        if (r144.hasNext() == false) goto L93;
        o.b((String) r144.next(), r143, r111, r103);     // Catch: Throwable -> L107
        goto L91
    L93:
        boolean r145 = !r143.isEmpty();     // Catch: Throwable -> L107
    L95:
        Iterator<T> r146 = r133.f64151d.iterator();     // Catch: Throwable -> L107
    L97:
        if (r146.hasNext() == false) goto L100;
        o.b((String) r146.next(), r143, r111, r103);     // Catch: Throwable -> L107
        goto L97
    L100:
        if ((!r143.isEmpty()) == true) goto L103;
        r143 = null;
    L103:
        if (r143 == null) goto L105;
        r141.invoke(r143, Boolean.valueOf(r145));     // Catch: Throwable -> L107
        goto L105
    L94:
        r145 = false;
    L80:
        th = move-exception;
        Result.Companion r147 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L82
    L125:
        return;
    L31:
        r120 = false;
        goto L32
    L27:
        r119 = false;
    L52:
        if (r114 == null) goto L54;
        o.c(false, false, r113, r114, r105);     // Catch: Throwable -> L56
    L54:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L56
    L58:
        r133 = null;
        goto L59
    L13:
        r114 = null;
        goto L14
    L51:
        r114 = null;
    L56:
        th = move-exception;
        Result.Companion r148 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L58
    }
}
