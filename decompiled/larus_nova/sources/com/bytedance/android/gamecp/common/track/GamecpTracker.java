package com.bytedance.android.gamecp.common.track;

import android.app.Activity;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.gamecp.business.gamedetail.AudienceGamePromoteDialogV2;
import com.bytedance.android.gamecp.common.track.filter.GPViewFilter;
import com.bytedance.android.gamecp.common.track.model.GPTrackAction;
import com.bytedance.android.gamecp.common.track.model.GPTrackDataType;
import com.bytedance.android.gamecp.common.track.model.GPViewTrackData;
import com.bytedance.android.gamecp.common.track.monitor.j;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.gamecp.common.utils.e0;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.texturerender.TextureRenderKeys;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import xr.s;

/* JADX INFO: loaded from: classes44.dex */
public final class GamecpTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, String> f56755a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<GPCommonFilterName, List<String>> f56756b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, String> f56757c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final av.f f56758d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final com.bytedance.android.gamecp.common.track.monitor.i f56759e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final j f56760f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final PageCommonParamManager f56761g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final HashMap<String, String> f56762h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final GamecpTracker f56763i = null;

    public static final class a extends TrackRegisterStrategy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f56764a;

        @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
        public final int getAutoReportStrategy() {
            if (this.f56764a == false) goto L5;
            return 3;
        L5:
            return 0;
        }

        public a(boolean r100) {
            this.f56764a = r100;
        }
    }

    public static final class b implements av.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TrackRegisterStrategy f56765a;

        @Override // av.c
        public final void a(View r100) {
            Intrinsics.checkNotNullParameter(r100, "rootView");
            if ((this.f56765a.getAutoReportStrategy() & 1) <= 0) goto L6;
            LinkedHashMap r101 = new LinkedHashMap();
            Map<String, Object> r102 = this.f56765a.getShowExtraAttrs();
            GamecpTracker r103 = GamecpTracker.f56763i;
            GamecpTracker.G(r100, r102);
            r101.putAll(r102);
            r103.F(r100, r101);
            return;
        }

        public b(TrackRegisterStrategy r100, xu.a r101) {
            this.f56765a = r100;
        }

        @Override // av.c
        public final void b(View r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "rootView");
            if ((this.f56765a.getAutoReportStrategy() & 2) <= 0) goto L6;
            LinkedHashMap r102 = new LinkedHashMap();
            r102.putAll(this.f56765a.getDurationTempExtraAttrs());
            GamecpTracker.f56763i.E(r100, r101, r102);
            return;
        }
    }

    public GamecpTracker() {
    }

    static {
        f56763i = new GamecpTracker();
        HashMap<String, String> r100 = new HashMap();
        f56755a = r100;
        HashMap<GPCommonFilterName, List<String>> r101 = new HashMap();
        f56756b = r101;
        f56757c = new LinkedHashMap();
        f56758d = new av.f();
        f56759e = new com.bytedance.android.gamecp.common.track.monitor.i();
        av.f r102 = f56758d;
        f56760f = new j(r102);
        f56761g = new PageCommonParamManager(r102);
        f56762h = new HashMap();
        GPTrackDataType r103 = GPTrackDataType.PAGE;
        GPTrackAction r104 = GPTrackAction.SHOW;
        r100.put(g(r103, r104), "dygame_page_show");
        GPTrackAction r105 = GPTrackAction.CLICK;
        r100.put(g(r103, r105), "dygame_page_click");
        GPTrackAction r106 = GPTrackAction.DURATION;
        r100.put(g(r103, r106), "dygame_page_duration");
        GPTrackDataType r107 = GPTrackDataType.MODULE;
        r100.put(g(r107, r104), "dygame_module_show");
        r100.put(g(r107, r105), "dygame_module_click");
        r100.put(g(r107, r106), "dygame_module_duration");
        GPTrackDataType r108 = GPTrackDataType.Result;
        r100.put(g(r108, r105), "dygame_result_show");
        r100.put(g(r108, r104), "dygame_result_show");
        r101.put(GPCommonFilterName.GAME_INFO, CollectionsKt.listOf(new String[]{"game_info", "game_id"}));
        r101.put(GPCommonFilterName.BIZ_INFO, CollectionsKt.listOf(new String[]{"biz_type", AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID, AudienceGamePromoteDetailActionHandler.PARA_BIZ_MODE, AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_SCENE, "promote_scene_sub", "ad_params", AudienceGamePromoteDetailActionHandler.PROMOTE_INSTANCE_ID}));
        r101.put(GPCommonFilterName.CONTENT_INFO, CollectionsKt.listOf(new String[]{com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID, "creator_id", AudienceGamePromoteDetailActionHandler.PARA_RESERVE_ID}));
        r101.put(GPCommonFilterName.TRAFFIC_INFO, CollectionsKt.listOf(new String[]{"log_pb", "action_type", "enter_method", "enter_sub_method", "traffic_source", "traffic_extra"}));
        r101.put(GPCommonFilterName.USER_INFO, CollectionsKt.listOf(new String[]{"user_type", "user_info"}));
    }

    public static void a() {
        if ((!Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper()))) == false) goto L6;
        int r100 = i.f56806a;
        yr.c.g("GamecpTracker", "don't run in UI thread");
        return;
    }

    public static void J(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "temp");
        if (r100.isEmpty() == true) goto L7;
        Map<String, String> r101 = f56757c;
        ((LinkedHashMap) r101).clear();
        r101.putAll(r100);
        return;
    }

    public static void b(View r100) {
        if (r100 == null) goto L14;
        View r101 = r100.getRootView();
        if (r101 == null) goto L15;
        Object r102 = r101.getTag(R.id.gamecp_view_tag_delay_task);
        if (r102 != null) goto L8;
        return;
    L8:
        if (TypeIntrinsics.isMutableSet(r102) == true) goto L10;
        r102 = null;
    L10:
        Set r103 = (Set) r102;
        if (r103 == null) goto L17;
        final Set r104 = CollectionsKt.toMutableSet(r103);
        r103.clear();
        UtilityKotlinExtentionsKt.g(0, false, true, new GamecpTracker$executeDelayTask$1$1$1(r104), 3);
        return;
    L17:
        return;
    L15:
        return;
    }

    public static void d(HashMap r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        Intrinsics.checkNotNullParameter(r100, "map");
        PageCommonParamManager r101 = f56761g;
        TrackViewUtils.f56773c.getClass();
        r101.e(TrackViewUtils.b(null), r100, null);
    }

    @Deprecated(message = "")
    public static com.bytedance.android.gamecp.common.track.filter.d h(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "filterClazz");
        return i(r100, null);
    }

    public static GPCommonFilterName j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        GPCommonFilterName[] r101 = GPCommonFilterName.values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L10;
        GPCommonFilterName r104 = r101[r103];
        List<String> r105 = f56756b.get(r104);
        if (r105 == null) goto L9;
        if (r105.contains(r100) != true) goto L9;
        return r104;
    L9:
        r103 = r103 + 1;
        goto L3
    L10:
        return null;
    }

    public static GPViewTrackData l(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        com.bytedance.android.gamecp.common.track.filter.d r101 = h(GPViewTrackData.class);
        if (r101 == null) goto L7;
        GPViewFilter r102 = (GPViewFilter) r101;
        return GPViewFilter.d(r100);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.gamecp.common.track.filter.GPViewFilter");
    }

    public static void o(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "page");
        a();
        f56758d.a(r100);
    }

    public static void p(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "page");
        a();
        f56758d.d(r100);
    }

    public static void q(AudienceGamePromoteDialogV2 r100) {
        Intrinsics.checkNotNullParameter(r100, "page");
        com.bytedance.android.gamecp.common.track.monitor.i r101 = f56759e;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "page");
        Iterator<Map.Entry<String, WeakReference<com.bytedance.android.gamecp.common.track.monitor.a>>> r102 = r101.f56850a.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L24;
        com.bytedance.android.gamecp.common.track.monitor.a r103 = r102.next().getValue().get();
        if (r103 == null) goto L4;
        WeakReference<View> r104 = r103.f56812b;
        if (r104 == null) goto L10;
        View r105 = r104.get();
    L11:
        if (r105 == null) goto L4;
        if (r103.f56815e == false) goto L4;
        WeakReference<View> r106 = r103.f56812b;
        if (r106 == null) goto L4;
        View r107 = r106.get();
        if (r107 == null) goto L4;
        if (r107.isAttachedToWindow() != true) goto L4;
        r103.c();
        goto L4
    L10:
        r105 = null;
        goto L11
    }

    @Deprecated(message = "")
    public static void B(String r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "extra");
        z(null, r100, r101);
    }

    public static void G(View r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "trackView");
        Intrinsics.checkNotNullParameter(r101, "attrs");
        GPViewTrackData r102 = l(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        if ((!r101.isEmpty()) == false) goto L9;
        LinkedHashMap r103 = new LinkedHashMap();
        r103.putAll(r102.getAttrs());
        r103.putAll(r101);
        r102.setAttrs(r103);
        return;
    }

    public static void H(View r100, GPViewTrackData r101) {
        com.bytedance.android.gamecp.common.track.filter.d r102 = h(GPViewTrackData.class);
        if (r102 == null) goto L7;
        ((GPViewFilter) r102).f(r100, r101);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.gamecp.common.track.filter.GPViewFilter");
    }

    public static void K(View r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "pageRootView");
        Intrinsics.checkNotNullParameter(r101, "paramsMap");
        PageCommonParamManager r102 = f56761g;
        GPCommonFilterName.Companion.getClass();
        HashMap r103 = GPCommonFilterName.a.c(r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "paramFiltersMap");
        if (r100 == null) goto L8;
        TrackViewUtils.f56773c.getClass();
        int r104 = r102.f(TrackViewUtils.a(r100));
        g r105 = (g) CollectionsKt.getOrNull(r102.f56769d, r104);
        if (r105 == null) goto L9;
        f r106 = r105.f56803b;
        r106.f56794a.putAll(r103);
        f r107 = new f(r106.f56794a, r106.f56795b, r106.f56796c);
        g r108 = new g(r105.f56802a, r107, r105.f56804c);
        PageCommonParamManager.h(r105.f56804c.get(), r107);
        ListProtector.remove(r102.f56769d, r104);
        ListProtector.add(r102.f56769d, r104, r108);
        return;
    L9:
        return;
    }

    public static void L(View r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "anchorView");
        Intrinsics.checkNotNullParameter(r101, "attrs");
        com.bytedance.android.gamecp.common.track.filter.d r102 = i(GPViewTrackData.class, null);
        if (r102 == null) goto L16;
        Intrinsics.checkNotNullParameter(r100, "anchorView");
        Intrinsics.checkNotNullParameter(r101, "attrs");
        List<GPViewTrackData> r103 = ((GPViewFilter) r102).e(r100);
        int r104 = ((ArrayList) r103).size();
    L5:
        r104 = r104 - 1;
        if (r104 < 0) goto L14;
        GPViewTrackData r105 = (GPViewTrackData) ListProtector.get(r103, r104);
        LinkedHashMap r106 = new LinkedHashMap();
        r106.putAll(r105.getAttrs());
        LinkedHashMap r107 = new LinkedHashMap();
        Iterator r108 = r101.entrySet().iterator();
    L9:
        if (r108.hasNext() == false) goto L13;
        Map.Entry r109 = (Map.Entry) r108.next();
        if (r106.containsKey(r109.getKey()) == false) goto L9;
        r107.put(r109.getKey(), r109.getValue());
        goto L9
    L13:
        r106.putAll(r107);
        r105.setAttrs(r106);
        goto L5
    L14:
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.gamecp.common.track.filter.GPViewFilter");
    }

    public static void c(JsonObject r100, HashMap r101) {
        if ((!r100.isJsonNull()) == true) goto L6;
        r100 = null;
    L6:
        if (r100 == null) goto L23;
        Iterator<String> r102 = r100.keySet().iterator();
    L9:
        if (r102.hasNext() == false) goto L31;
        String r103 = r102.next();
        JsonElement r104 = r100.get(r103);
        if (r104 == null) goto L9;
        if (r104.isJsonPrimitive() == false) goto L16;
        String r105 = r104.getAsString();
    L17:
        GPCommonFilterName r106 = j(r103);
        if (r106 == null) goto L9;
        HashMap r107 = (HashMap) r101.get(r106);
        if (r107 != null) goto L22;
        r107 = new HashMap();
        r101.put(r106, r107);
    L22:
        r107.put(r103, r105);
        goto L9
    L16:
        r105 = r104.toString();
        goto L17
    L31:
        return;
    }

    public static void f(View r100, HashMap r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "routeMap");
        com.bytedance.android.gamecp.common.track.filter.d r102 = h(GPViewTrackData.class);
        if (r102 == null) goto L26;
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "map");
        HashMap r103 = new HashMap();
        ArrayList r104 = new ArrayList();
        ArrayList r105 = new ArrayList();
        Iterator r106 = ((ArrayList) ((GPViewFilter) r102).e(r100)).iterator();
    L6:
        if (r106.hasNext() == false) goto L23;
        GPViewTrackData r107 = (GPViewTrackData) r106.next();
        if (r107.isRootView() == true) goto L10;
        r104.add(r107.getName());
        r105.add(r107.getAttrs());
        goto L6
    L10:
        if (r107.isPageData() == true) goto L11;
        if (r107.isModuleData() == false) goto L6;
        Object r108 = r107.getLocationData().get("current_page");
        Object r109 = "";
        if (r108 != null) goto L17;
        r108 = "";
    L17:
        r103.put("previous_page", r108);
        Object r110 = r107.getLocationData().get("current_page_attr");
        if (r110 == null) goto L21;
        r109 = r110;
    L21:
        r103.put("previous_page_attr", r109);
        r104.add(r107.getName());
        r105.add(r107.getAttrs());
        goto L6
    L11:
        r103.put("previous_page", r107.getName());
        r103.put("previous_page_attr", r107.getAttrs());
        goto L6
    L23:
        r103.put("previous_module", r104);
        r103.put("previous_module_attr", r105);
        r103.putAll(r101);
        r101.putAll(r103);
        return;
    L26:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.gamecp.common.track.filter.GPViewFilter");
    }

    public static String g(GPTrackDataType r100, GPTrackAction r101) {
        return r100.getValue() + "_" + r101.getValue();
    }

    public static com.bytedance.android.gamecp.common.track.filter.d i(Class r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "filterClazz");
        PageCommonParamManager r102 = f56761g;
        TrackViewUtils.f56773c.getClass();
        View r103 = TrackViewUtils.b(r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "clazz");
        GPCommonFilterName.Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, "clazz");
        com.bytedance.android.gamecp.common.track.filter.d<?> r104 = null;
        if (Intrinsics.areEqual(r100, zu.d.class) == false) goto L6;
        GPCommonFilterName r105 = GPCommonFilterName.GAME_INFO;
    L21:
        if (r105 != null) goto L24;
        return null;
    L24:
        if (r105 != GPCommonFilterName.VIEW_TRACK_INFO) goto L30;
        com.bytedance.android.gamecp.common.track.filter.d<?> r106 = r102.f56767b.get(r105);
        if ((r106 instanceof com.bytedance.android.gamecp.common.track.filter.d) == false) goto L35;
        r104 = r106;
    L35:
        return r104;
    L30:
        com.bytedance.android.gamecp.common.track.filter.a r107 = GPCommonFilterName.a.a(r105, r102.g(r105, r103));
        if ((r107 instanceof com.bytedance.android.gamecp.common.track.filter.d) == true) goto L34;
        return null;
    L34:
        return r107;
    L6:
        if (Intrinsics.areEqual(r100, zu.a.class) == false) goto L9;
        r105 = GPCommonFilterName.BIZ_INFO;
        goto L21
    L9:
        if (Intrinsics.areEqual(r100, zu.b.class) == false) goto L12;
        r105 = GPCommonFilterName.CONTENT_INFO;
        goto L21
    L12:
        if (Intrinsics.areEqual(r100, zu.e.class) == false) goto L15;
        r105 = GPCommonFilterName.TRAFFIC_INFO;
        goto L21
    L15:
        if (Intrinsics.areEqual(r100, zu.f.class) == false) goto L18;
        r105 = GPCommonFilterName.USER_INFO;
        goto L21
    L18:
        if (Intrinsics.areEqual(r100, GPViewTrackData.class) == false) goto L20;
        r105 = GPCommonFilterName.VIEW_TRACK_INFO;
        goto L21
    L20:
        r105 = null;
        goto L21
    }

    public static Map k(View r100, String r101) {
        HashMap<String, String> r102 = new HashMap();
        PageCommonParamManager r103 = f56761g;
        TrackViewUtils.f56773c.getClass();
        r103.e(TrackViewUtils.b(r100), r102, r101);
        return r102;
    }

    public final void F(View r100, Map<String, ? extends Object> r101) {
        GPViewTrackData r102 = l(r100);
        C(this, e(GPTrackAction.SHOW, r102, false), r100, r101);
    }

    public static void D(View r100, Map r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "extraAttrs");
        Intrinsics.checkNotNullParameter(r102, "productType");
        GPViewTrackData r103 = l(r100);
        String r104 = e(GPTrackAction.SHOW, r103, true);
        if (TextUtils.isEmpty(r102) == false) goto L8;
        if (r103 == null) goto L7;
        r102 = r103.getName();
        if (r102 != null) goto L8;
    L7:
        r102 = "";
    L8:
        A(r104, r100, r101, true, r102);
    }

    public static String e(GPTrackAction r100, GPViewTrackData r101, boolean r102) {
        if (r101 == null) goto L11;
        if (r102 == true) goto L8;
        String r103 = f56755a.get(g(r101.getDataType(), r100));
        if (r103 != null) goto L14;
    L12:
        r103 = "";
    L14:
        if (TextUtils.isEmpty(r103) == false) goto L16;
        int r104 = i.f56806a;
        yr.c.g("GamecpTracker", "eventName is empty");
    L16:
        return r103;
    L8:
        r103 = f56755a.get(g(GPTrackDataType.Result, r100));
        if (r103 != null) goto L14;
    L11:
        int r105 = i.f56806a;
        yr.c.g("GamecpTracker", "view viewTrackData is empty, need use registerModule() to set ");
        goto L12
    }

    public static void y(Object r100, View r101, f r102) {
        Intrinsics.checkNotNullParameter(r101, "pageRootView");
        a();
        if (r102 == null) goto L6;
        f56761g.c(r100, r101, r102);
        return;
    }

    public static void z(View r110, String r111, Map r112) {
        Intrinsics.checkNotNullParameter(r111, "eventName");
        Intrinsics.checkNotNullParameter(r112, "extra");
        HashMap<String, String> r100 = new HashMap();
        HashMap r101 = new HashMap();
        r101.putAll(r112);
        PageCommonParamManager r102 = f56761g;
        TrackViewUtils.f56773c.getClass();
        Boolean r103 = null;
        r102.e(TrackViewUtils.b(r110), r100, null);
        String r113 = (String) r101.get("module_name");
        boolean r104 = false;
        if (r113 != null) goto L5;
    L8:
        boolean r114 = true;
    L9:
        if (r114 == false) goto L11;
    L73:
        r100.putAll(r101);
        xr.f r115 = (xr.f) s.a(xr.f.class);
        if (r115 == null) goto L77;
        r115.P0(r111, r100);
    L77:
        if (TypeIntrinsics.isMutableMap(r112) == false) goto L79;
        String r116 = (String) r112.remove("btm_params");
    L79:
        int r117 = fv.b.f478947a;
        com.bytedance.android.gamecp.host_api.a.b().getLogService().logV3(r111, r100);
        return;
    L11:
        if (StringsKt.contains$default(r113, "game_ad", false, 2, null) == false) goto L73;
        if (TextUtils.equals(r111, "dygame_module_show") == false) goto L15;
        HashMap<String, String> r118 = f56762h;
        r118.clear();
        r118.putAll(r100);
    L81:
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L71
        CharSequence r120 = (CharSequence) r101.get(SlcElement.KEY_ATTR);     // Catch: Throwable -> L71
        if (r120 != null) goto L25;
    L28:
        boolean r121 = true;
    L29:
        if (r121 == true) goto L69;
        Object r122 = r101.get(SlcElement.KEY_ATTR);     // Catch: Throwable -> L71
        Intrinsics.checkNotNull(r122);     // Catch: Throwable -> L71
        JSONObject r123 = new JSONObject((String) r122);     // Catch: Throwable -> L71
        if (TextUtils.equals(r111, "dygame_module_duration") == false) goto L54;
        Map<String, String> r124 = f56757c;     // Catch: Throwable -> L71
        Map r125 = MapsKt.toMap(r124);     // Catch: Throwable -> L71
        ((LinkedHashMap) r124).clear();     // Catch: Throwable -> L71
        if (r125.isEmpty() == false) goto L52;
        String r126 = r123.optString("duration_type");     // Catch: Throwable -> L71
        if (r126 != null) goto L37;
    L40:
        boolean r127 = true;
    L41:
        if (r127 == false) goto L43;
        r123.put("duration_type", "active");     // Catch: Throwable -> L71
    L43:
        String r105 = r123.optString("active_type");     // Catch: Throwable -> L71
        if (r105 != null) goto L46;
    L49:
        boolean r106 = true;
    L50:
        if (r106 == false) goto L54;
        r123.put("active_type", "other");     // Catch: Throwable -> L71
        goto L54
    L46:
        if (r105.length() == 0) goto L49;
        r106 = false;
        goto L50
    L37:
        if (r126.length() == 0) goto L40;
        r127 = false;
        goto L41
    L52:
        e0.a(r123, r125);     // Catch: Throwable -> L71
    L54:
        if (r123.optString("unique_key", "").length() <= 0) goto L56;
        r104 = true;
    L56:
        if (r104 == false) goto L59;
        r123.remove("unique_key");     // Catch: Throwable -> L71
    L59:
        if (TextUtils.equals(r111, "dygame_module_show") == false) goto L68;
        xr.j r128 = (xr.j) s.a(xr.j.class);     // Catch: Throwable -> L71
        if (r128 == null) goto L64;
        r103 = r128.isIntroducingCardManually("", "", "DEFAULT");     // Catch: Throwable -> L71
    L64:
        if (Intrinsics.areEqual(r103, Boolean.TRUE) == false) goto L66;
        String r129 = "1";
    L67:
        r123.put("is_introducing", r129);     // Catch: Throwable -> L71
        goto L68
    L66:
        r129 = "0";
    L68:
        r101.put(SlcElement.KEY_ATTR, r123.toString());     // Catch: Throwable -> L71
    L69:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L71
        goto L73
    L25:
        if (r120.length() == 0) goto L28;
        r121 = false;
    L71:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L73
    L15:
        HashMap<String, String> r130 = f56762h;
        if ((!r130.isEmpty()) == false) goto L81;
        if (r100.isEmpty() == false) goto L20;
    L21:
        r100.putAll(r130);
        goto L81
    L20:
        if (r100.size() >= r130.size()) goto L81;
    L5:
        if (r113.length() == 0) goto L8;
        r114 = false;
        goto L9
    }

    public final void E(View r100, float r101, Map<String, ? extends Object> r102) {
        GPViewTrackData r103 = l(r100);
        String r104 = e(GPTrackAction.DURATION, r103, false);
        HashMap r105 = new HashMap();
        r105.putAll(r102);
        r105.put("duration", String.valueOf(r101));
        C(this, r104, r100, r105);
    }

    public static /* synthetic */ void C(GamecpTracker r100, String r101, View r102, Map r103) {
        r100.getClass();
        A(r101, r102, r103, false, "");
    }

    public static void A(String r100, View r101, Map r102, boolean r110, String r111) {
        com.bytedance.android.gamecp.common.track.filter.d r103 = h(GPViewTrackData.class);
        if ((r103 instanceof GPViewFilter) == true) goto L5;
        r103 = null;
    L5:
        GPViewFilter r104 = (GPViewFilter) r103;
        HashMap<String, String> r105 = new HashMap();
        if (r104 == null) goto L8;
        r104.b(r101, r105, r102, r110, r111);
    L8:
        z(r101, r100, r105);
    }

    public static void I(final View r100, String r101, GPTrackDataType r102, Map r103, Map r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "trackView");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "dataType");
        Intrinsics.checkNotNullParameter(r103, "attrs");
        Intrinsics.checkNotNullParameter(r110, "routeData");
        if (r102 != GPTrackDataType.PAGE) goto L15;
        GPViewTrackData r104 = l(r100);
        if (r104 == null) goto L8;
        Map<String, Object> r105 = r104.getRouterData();
        if (r105 == null) goto L8;
    L10:
        if ((!r110.isEmpty()) == true) goto L13;
        r110 = r105;
    L13:
        H(r100, zu.c.b(r101, r103, r110, r111, null));
        UtilityKotlinExtentionsKt.g(0, false, false, new GamecpTracker$setViewTrackData$1(r100), 7);
        return;
    L8:
        r105 = MapsKt.emptyMap();
        goto L10
    L15:
        if (r102 != GPTrackDataType.MODULE) goto L19;
        H(r100, zu.c.a(r101, r103, r111, null));
        f56760f.c(r100);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static /* synthetic */ void n(View r100, GPTrackAction r101, Map r102, Map r110, float r111, int r112) {
        GamecpTracker r103 = f56763i;
        if ((r112 & 8) == 0) goto L5;
        r110 = new HashMap();
    L5:
        Map r104 = r110;
        if ((r112 & 32) == 0) goto L8;
        float r105 = 0.0f;
    L9:
        r103.m(r100, r101, r102, r104, false, r105);
        return;
    L8:
        r105 = r111;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void r(final View r100, String r110, Map r111, final TrackRegisterStrategy r112, boolean r113, int r114) {
        View r101 = null;
        Object[] r102 = 0;
        Object[] r103 = 0;
        if ((r114 & 8) == 0) goto L5;
        r112 = null;
    L5:
        boolean r104 = false;
        if ((r114 & 16) == 0) goto L8;
        r113 = false;
    L8:
        Intrinsics.checkNotNullParameter(r100, "moduleView");
        Intrinsics.checkNotNullParameter(r110, TextureRenderKeys.KEY_MODULE_NAME);
        Intrinsics.checkNotNullParameter(r111, "attrs");
        GPViewTrackData r115 = zu.c.a(r110, r111, r113, r112);
        a();
        H(r100, r115);
        f56760f.c(r100);
        if (r112 != null) goto L11;
        com.bytedance.android.gamecp.common.track.monitor.i r116 = f56759e;
        r116.c(r100);
        r116.d(r100);
        return;
    L11:
        int r117 = fv.b.f478947a;
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.MODULE);
        if ((r112.getAutoReportStrategy() & 3) <= 0) goto L14;
        com.bytedance.android.gamecp.common.track.monitor.i r105 = f56759e;
        float r106 = r112.getViewAppearRectLimit();
        boolean r107 = r112.enableViewEffectiveDetachCheck();
        final Object[] r108 = r103 == true ? 1 : 0;
        r105.b(r100, r106, r107, false, null, new GamecpTracker$registerModule$1(r112, r100, r108));
    L16:
        if ((r112.getAutoReportStrategy() & 4) <= 0) goto L35;
        com.bytedance.android.gamecp.common.track.monitor.i r118 = f56759e;
        final Object[] r109 = r102 == true ? 1 : 0;
        Function1<View, Unit> r119 = new GamecpTracker$registerModule$2(r112, r109, r100);
        r118.getClass();
        Intrinsics.checkNotNullParameter(r100, "moduleView");
        Intrinsics.checkNotNullParameter(r119, "observer");
        r118.a();
        String r120 = String.valueOf(r100.hashCode());
        WeakReference<com.bytedance.android.gamecp.common.track.monitor.h> r121 = r118.f56851b.get(r120);
        if (r121 == null) goto L20;
        com.bytedance.android.gamecp.common.track.monitor.h r122 = r121.get();
    L21:
        if (r122 == null) goto L32;
        WeakReference<View> r123 = r122.f56844d;
        if (r123 == null) goto L25;
        r101 = r123.get();
    L25:
        if (r101 != null) goto L27;
    L29:
        if (r104 == false) goto L32;
        Intrinsics.checkNotNullParameter(r119, "observer");
        r122.f56843c = r119;
        return;
    L27:
        if (r122.f56845e == false) goto L29;
        r104 = true;
    L32:
        if (r122 == null) goto L34;
        r122.b();
    L34:
        com.bytedance.android.gamecp.common.track.monitor.h r124 = new com.bytedance.android.gamecp.common.track.monitor.h();
        r124.c(r100, r119);
        r118.f56851b.put(r120, new WeakReference(r124));
        return;
    L20:
        r122 = null;
        goto L21
    L35:
        f56759e.d(r100);
        return;
    L14:
        f56759e.c(r100);
        goto L16
    }

    public static /* synthetic */ void w(Object r100, View r101, String r110, Map r111, Map r112, TrackRegisterStrategy r113) {
        t(r100, r101, r110, r111, r112, r113, true, null);
    }

    public final void m(View r100, GPTrackAction r101, Map<String, ? extends Object> r102, Map<String, ? extends Object> r103, boolean r104, float r105) {
        Intrinsics.checkNotNullParameter(r100, "trackView");
        Intrinsics.checkNotNullParameter(r101, "trackAction");
        Intrinsics.checkNotNullParameter(r102, "attrs");
        Intrinsics.checkNotNullParameter(r103, "tempAttrs");
        GPViewTrackData r106 = l(r100);
        if (r106 == null) goto L18;
        G(r100, r102);
        if (r104 == false) goto L7;
        D(r100, r103, r106.getName());
        return;
    L7:
        int r107 = d.f56792a[r101.ordinal()];
        if (r107 != 1) goto L10;
        F(r100, r103);
        return;
    L10:
        if (r107 != 2) goto L12;
        E(r100, r105, r103);
        return;
    L12:
        if (r107 == 3) goto L14;
        yr.c.g("GamecpTracker", "unknown trackAction");
        return;
    L14:
        GPViewTrackData r108 = l(r100);
        C(this, e(GPTrackAction.CLICK, r108, false), r100, r103);
        return;
    }

    public static void t(Object r110, View r111, String r112, Map r113, Map r114, TrackRegisterStrategy r115, boolean r116, xu.a r117) {
        Intrinsics.checkNotNullParameter(r110, "page");
        Intrinsics.checkNotNullParameter(r111, "pageRootView");
        Intrinsics.checkNotNullParameter(r112, "pageName");
        Intrinsics.checkNotNullParameter(r113, "attrs");
        Intrinsics.checkNotNullParameter(r114, "routeData");
        s(r110, r111, r112, r113, r114, r115, r116, null, r117);
    }

    public static void u(Object r100, View r110, String r111, Map r112, Map r113, boolean r114, boolean r115, xu.a r116) {
        Intrinsics.checkNotNullParameter(r100, "page");
        Intrinsics.checkNotNullParameter(r110, "pageRootView");
        Intrinsics.checkNotNullParameter(r111, "pageName");
        Intrinsics.checkNotNullParameter(r112, "attrs");
        Intrinsics.checkNotNullParameter(r113, "routeData");
        t(r100, r110, r111, r112, r113, new a(r114), r115, r116);
    }

    public static void v(Object r110, View r111, String r112, Map r113, Map r114, f r115, boolean r116, int r117) {
        if ((r117 & 128) == 0) goto L5;
        boolean r100 = false;
    L6:
        Intrinsics.checkNotNullParameter(r110, "page");
        Intrinsics.checkNotNullParameter(r111, "pageRootView");
        Intrinsics.checkNotNullParameter(r112, "pageName");
        Intrinsics.checkNotNullParameter(r113, "attrs");
        Intrinsics.checkNotNullParameter(r114, "routeData");
        s(r110, r111, r112, r113, r114, new e(), r100, r115, null);
        return;
    L5:
        r100 = r116;
        goto L6
    }

    public static /* synthetic */ void x(Object r100, View r101, String r110, Map r111, Map r112, boolean r113, boolean r114, int r115) {
        if ((r115 & 64) == 0) goto L5;
        boolean r102 = false;
    L6:
        u(r100, r101, r110, r111, r112, r113, r102, null);
        return;
    L5:
        r102 = r114;
        goto L6
    }

    public static void s(Object r110, final View r111, String r112, Map r113, Map r114, TrackRegisterStrategy r210, boolean r211, f r212, xu.a r213) {
        Intrinsics.checkNotNullParameter(r110, "page");
        Intrinsics.checkNotNullParameter(r111, "pageRootView");
        Intrinsics.checkNotNullParameter(r112, "pageName");
        Intrinsics.checkNotNullParameter(r113, "attrs");
        Intrinsics.checkNotNullParameter(r114, "routeData");
        a();
        int r100 = i.f56806a;
        H(r111, zu.c.b(r112, r113, r114, r211, r210));
        if (r212 == null) goto L5;
        f56761g.c(r110, r111, r212);
    L5:
        TrackViewUtils.f56773c.getClass();
        UtilityKotlinExtentionsKt.g(0, false, false, new TrackViewUtils$addPageShowSet$1(r111), 7);
        if (r210 != null) goto L8;
    L12:
        if (r210 != null) goto L14;
    L15:
        j r101 = f56760f;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r110, "page");
        r101.f56854c.remove(r110);
    L16:
        if (r210 != null) goto L18;
    L41:
        if (r210 != null) goto L43;
    L44:
        av.f r102 = f56758d;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r110, "page");
        r102.f16351b.remove(String.valueOf(r110.hashCode()));
        return;
    L43:
        if ((r210.getAutoReportStrategy() & 3) <= 0) goto L44;
        return;
    L18:
        if ((r210.getAutoReportStrategy() & 3) <= 0) goto L41;
        av.f r103 = f56758d;
        b r104 = new b(r210, r213);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r110, "page");
        Intrinsics.checkNotNullParameter(r111, "pageRootView");
        Intrinsics.checkNotNullParameter(r104, "exposureListener");
        if (r103.f16351b.size() < 200) goto L27;
        Iterator<Map.Entry<String, av.d>> r105 = r103.f16351b.entrySet().iterator();
    L23:
        if (r105.hasNext() == false) goto L27;
        if (r105.next().getValue().f16343a.get() != null) goto L23;
        r105.remove();
    L27:
        r103.f(r110);
        if ((r110 instanceof Activity) == false) goto L35;
        boolean r106 = ((Activity) r110).hasWindowFocus();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L38;
        FLogger.f375446a.i("DecorViewLancet", "hasWindowFocus");
        Thread r107 = ThreadMethodProxy.currentThread();
        if (r107 == com.larus.home.impl.utils.c.f346341a) goto L38;
        com.larus.home.impl.utils.c.a(r107, "hasWindowFocus");
    L38:
        String r108 = String.valueOf(r110.hashCode());
        r103.f16351b.put(r108, new av.d(new WeakReference(r111), r104));
        if (r106 == false) goto L51;
        r103.d(r110);
        return;
    L51:
        return;
    L35:
        if ((r110 instanceof Fragment) == false) goto L37;
        r106 = ((Fragment) r110).isResumed();
        goto L38
    L37:
        r106 = false;
        goto L38
    L14:
        if (r210.enablePageAutoRouteData() == true) goto L16;
    L8:
        if (r210.enablePageAutoRouteData() == false) goto L12;
        j r109 = f56760f;
        r109.getClass();
        Intrinsics.checkNotNullParameter(r110, "page");
        Intrinsics.checkNotNullParameter(r111, "rootView");
        r109.f56854c.put(r110, new WeakReference(r111));
        av.f r115 = r109.f56856e;
        r115.getClass();
        Intrinsics.checkNotNullParameter(r110, "page");
        Intrinsics.checkNotNullParameter(r109, "listener");
        r115.f(r110);
        if (r115.f16350a.contains(r109) == true) goto L16;
        r115.f16350a.add(r109);
        goto L16
    }
}
