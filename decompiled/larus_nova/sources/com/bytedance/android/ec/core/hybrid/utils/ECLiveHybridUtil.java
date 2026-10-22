package com.bytedance.android.ec.core.hybrid.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.ECLiveEntranceMonitor;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.host.api.hybrid.IECForestHostService;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.hybrid.data.gecko.HybridForestLoader;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.RequestParams;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.ies.xbridge.event.Js2NativeEvent;
import com.bytedance.ies.xbridge.event.JsEventSubscriber;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class ECLiveHybridUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f44277a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<ti.j, JsEventSubscriber> f44278b = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/utils/ECLiveHybridUtil$HybridType;", "", "(Ljava/lang/String;I)V", "LYNX", "WEB", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum HybridType extends Enum<HybridType> {
        private static final /* synthetic */ HybridType[] $VALUES = null;
        public static final HybridType LYNX = null;
        public static final HybridType WEB = null;

        static {
            HybridType r100 = new HybridType("LYNX", 0);
            LYNX = r100;
            HybridType r101 = new HybridType("WEB", 1);
            WEB = r101;
            $VALUES = new HybridType[]{r100, r101};
        }

        public static HybridType valueOf(String r100) {
            return (HybridType) r27.a.a(HybridType.class, r100);
        }

        public static HybridType[] values() {
            return (HybridType[]) $VALUES.clone();
        }

        private HybridType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a implements ti.k {
        public a() {
        }

        @Override // ti.k
        public final void b() {
            Intrinsics.checkNotNullParameter("", "errorMessage");
            Intrinsics.checkNotNullParameter("", "errorMessage");
        }

        @Override // ti.k
        public final void onFirstScreen(View r100) {
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            Intrinsics.checkNotNullParameter(r100, "lynxView");
        }

        @Override // ti.k
        public final void onLoadSuccess(View r100) {
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            Intrinsics.checkNotNullParameter(r100, "lynxView");
        }

        @Override // ti.k
        public final void onRuntimeReady(View r100) {
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            Intrinsics.checkNotNullParameter(r100, "lynxView");
        }

        @Override // ti.k
        public final void g(View r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r100, "view");
        }

        @Override // ti.k
        public final void onLoadFailed(View r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            Intrinsics.checkNotNullParameter(r100, "lynxView");
        }

        @Override // ti.k
        public final void onPageStart(View r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            Intrinsics.checkNotNullParameter(r100, "lynxView");
        }

        @Override // ti.k
        public final void s(View r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r100, "view");
        }
    }

    public static final class b implements ti.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ti.k f44279a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ti.k f44280b;

        @Override // ti.k
        public final void b() {
            Intrinsics.checkNotNullParameter("", "errorMessage");
            this.f44279a.b();
        }

        @Override // ti.k
        public final void g(View r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f44279a.g(r100, r101);
        }

        @Override // ti.k
        public final void onFirstScreen(View r100) {
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            this.f44279a.onFirstScreen(r100);
        }

        @Override // ti.k
        public final void onLoadSuccess(View r100) {
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            this.f44279a.onLoadSuccess(r100);
        }

        @Override // ti.k
        public final void onPageStart(View r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            this.f44279a.onPageStart(r100, r101);
        }

        @Override // ti.k
        public final void onRuntimeReady(View r100) {
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            this.f44279a.onRuntimeReady(r100);
        }

        @Override // ti.k
        public final void s(View r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f44279a.s(r100, r101, r102);
        }

        public b(ti.k r100) {
            this.f44280b = r100;
            this.f44279a = r100;
        }

        @Override // ti.k
        public final void onLoadFailed(View r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            this.f44280b.onLoadFailed(r100, r101);
            Object r102 = r100.getParent();
            if ((r102 instanceof HybridCard) == false) goto L11;
            ViewParent r103 = ((HybridCard) r102).getParent();
            if ((r103 instanceof ViewGroup) == true) goto L7;
            r103 = null;
        L7:
            ViewGroup r104 = (ViewGroup) r103;
            if (r104 == null) goto L12;
            r104.removeView((View) r102);
            return;
        L12:
            return;
        }
    }

    public static final class c implements JsEventSubscriber {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ti.j f44281a;

        public c(ti.j r100) {
            this.f44281a = r100;
        }

        @Override // com.bytedance.ies.xbridge.event.JsEventSubscriber
        public final void onReceiveJsEvent(Js2NativeEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "jsEvent");
            ti.j r101 = this.f44281a;
            int r102 = k.f44314a;
            XReadableMap r103 = r100.getParams();
            if (r103 == null) goto L5;
            Map<String, Object> r104 = r103.toMap();
        L6:
            r101.a(k.b(r104));
            return;
        L5:
            r104 = null;
            goto L6
        }
    }

    public static final class d implements JsEventSubscriber {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ti.j f44286a;

        public d(ti.j r100) {
            this.f44286a = r100;
        }

        @Override // com.bytedance.ies.xbridge.event.JsEventSubscriber
        public final void onReceiveJsEvent(Js2NativeEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "jsEvent");
            ti.j r101 = this.f44286a;
            int r102 = k.f44314a;
            XReadableMap r103 = r100.getParams();
            if (r103 == null) goto L5;
            Map<String, Object> r104 = r103.toMap();
        L6:
            r101.a(k.b(r104));
            return;
        L5:
            r104 = null;
            goto L6
        }
    }

    static {
        kg.a.a("ECLiveHybridUtil");
        f44277a = new a();
        f44278b = new ConcurrentHashMap();
    }

    public static void h() {
        boolean r100 = ECServiceManager.f42805a;
        pd.e r101 = ((IAdapterService) ECServiceManager.c(IAdapterService.class)).getIExternaHybridService();
        if (r101 == null) goto L9;
        final pd.f r102 = r101.getExternalJsBridgeMethodInjectorAdapter();
        if (r102 == null) goto L10;
        r102.b(new ECLiveHybridUtil$injectECLiveBridges$1(r102));
        r102.c(new ECLiveHybridUtil$injectECLiveBridges$2(r102));
        ((s83.g) ECServiceManager.c(s83.g.class)).s();
        return;
    L10:
        return;
    }

    public static boolean i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (StringsKt.startsWith$default(r100, "sslocal://webcast_lynxview", false, 2, null) == false) goto L5;
        return true;
    L5:
        if (StringsKt.startsWith$default(r100, "sslocal://webcast_webview", false, 2, null) == true) goto L10;
        return false;
    L10:
        return true;
    }

    public static ti.k d(ti.k r100, boolean r101) {
        if (r101 == true) goto L4;
        return r100;
    L4:
        if (r100 != null) goto L7;
        r100 = f44277a;
    L7:
        return new b(r100);
    }

    @JvmStatic
    public static final void f(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        int r102 = ECSdk.f48106a;
        IAdapterService r103 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r103 == null) goto L8;
        pd.e r104 = r103.getIExternaHybridService();
        if (r104 == null) goto L9;
        r104.enqueueEvent(r100, r101);
        return;
    L9:
        return;
    }

    public static void g(String r100, final Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "callback");
        int r102 = ECSdk.f48106a;
        IECHostService r103 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r103 == null) goto L5;
        IECForestHostService r104 = r103.getECForestHostService();
    L6:
        if (r104 == null) goto L9;
        r104.fetchLiveResourceAsync(r100, r101);
        return;
    L9:
        Map<String, Long> r105 = HybridForestLoader.f46691a;
        Forest r106 = HybridForestLoader.e();
        if (r106 == null) goto L13;
        r106.fetchResourceAsync(r100, new RequestParams(0), new ECLiveHybridUtil$fetchLiveResourceAsync$1(r101));
        return;
    L13:
        return;
    L5:
        r104 = null;
        goto L6
    }

    public static void l(String r100, boolean r101) {
        if (com.bytedance.android.shopping.anchorv3.a.b(r100) == false) goto L10;
        int r102 = ECSdk.f48106a;
        IAdapterService r103 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r103 == null) goto L11;
        pd.e r104 = r103.getIExternaHybridService();
        if (r104 == null) goto L12;
        r104.preloadResourceForLynx(r100, r101);
        return;
    L12:
        return;
    L11:
        return;
    }

    @JvmStatic
    public static final void m(String r100, ti.j r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "subscriber");
        c r102 = new c(r101);
        f44278b.put(r101, r102);
        EventCenter.registerJsEventSubscriber(r100, r102);
    }

    @JvmStatic
    public static final void n(String r100, ti.j r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "subscriber");
        ConcurrentHashMap<ti.j, JsEventSubscriber> r102 = f44278b;
        if (r102.containsKey(r101) == false) goto L5;
        return;
    L5:
        d r103 = new d(r101);
        r102.put(r101, r103);
        EventCenter.registerJsEventSubscriber(r100, r103);
    }

    @JvmStatic
    public static final <T> void o(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r102 = ECSdk.f48106a;
        IAdapterService r103 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r103 == null) goto L8;
        pd.e r104 = r103.getIExternaHybridService();
        if (r104 == null) goto L9;
        r104.sendEventToAllJsBridges(r100, r101);
        return;
    L9:
        return;
    }

    @JvmStatic
    public static final void p(String r100, ti.j r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "subscriber");
        JsEventSubscriber r102 = f44278b.remove(r101);
        if (r102 == null) goto L6;
        EventCenter.unregisterJsEventSubscriber(r100, r102);
        return;
    }

    public static pd.b a(Context r100, String r101, pd.c r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, NewBroadcastMonitor.STAGE.LIFECYCLE);
        int r103 = ECSdk.f48106a;
        IAdapterService r104 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r104 == null) goto L5;
        pd.e r105 = r104.getIExternaHybridService();
    L6:
        if (r105 != null) goto L8;
        return null;
    L8:
        return r105.createAnnieComponent(r100, r101, r102);
    L5:
        r105 = null;
        goto L6
    }

    public static /* synthetic */ void k(Context r100, String r101, boolean r110, boolean r111, boolean r112, String r113, int r114) {
        if ((r114 & 8) == 0) goto L5;
        boolean r102 = false;
    L7:
        if ((r114 & 16) == 0) goto L9;
        boolean r103 = false;
    L11:
        if ((r114 & 32) == 0) goto L13;
        boolean r104 = false;
    L15:
        if ((r114 & 128) == 0) goto L17;
        r113 = null;
    L17:
        j(r100, r101, null, r102, r103, r104, null, r113);
        return;
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r102 = r110;
        goto L7
    }

    @JvmStatic
    public static final void j(Context r110, String r111, Bundle r112, boolean r210, boolean r211, boolean r212, String r213, String r214) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "url");
        String r100 = j.c(r111, r210, 4);
        int r101 = com.bytedance.android.ec.core.hybrid.utils.a.f44296a;
        Intrinsics.checkNotNullParameter(r100, "url");
        Uri r102 = UriProtector.parse(r100);
        String r103 = UriProtector.getQueryParameter(r102, "fallback_url");
        if (TextUtils.isEmpty(r103) == false) goto L5;
    L4:
        String r104 = r100;
        JSONObject r105 = p.f44324a;
        Intrinsics.checkNotNullParameter(r104, "url");
        if (StringsKt.contains$default(r104, "ecommerce_buynow", false, 2, null) == true) goto L336;
    L44:
        String r106 = r104;
        if (ECAppInfoService.f48114e.isLocalTest() == false) goto L296;
    L297:
        int r107 = ECSdk.f48106a;
        com.bytedance.android.ec.core.monitor.o r108 = (com.bytedance.android.ec.core.monitor.o) ECSdk.a(com.bytedance.android.ec.core.monitor.o.class);
        if (r108 != null) goto L300;
    L319:
        if (r212 == true) goto L321;
    L325:
        int r109 = ECSdk.f48106a;
        IAdapterService r113 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r113 == null) goto L379;
        IAdapterService.a.a(r113, r110, UriProtector.parse(r106), r211, 8);
        return;
    L379:
        return;
    L321:
        if (l0.b(r110) == null) goto L325;
        nj.d r114 = com.bytedance.android.ec.sdk.helper.d.f48119b.getPadSplitService();
        if (r114 == null) goto L325;
        r114.i();
        goto L325
    L300:
        if (r112 == null) goto L303;
        String r115 = r112.getString("vmsdk_scene");
        if (r115 == null) goto L303;
    L304:
        String r116 = r115;
        if (r112 == null) goto L307;
        String r117 = r112.getString("vmsdk_contextProvider");
    L309:
        if (r112 == null) goto L311;
        String r118 = r112.getString("vmsdk_scriptPath");
    L312:
        r108.a(r110, r116, r106, r117, r118);
        if (r112 == null) goto L315;
        r112.remove("vmsdk_scene");
    L315:
        if (r112 == null) goto L317;
        r112.remove("vmsdk_contextProvider");
    L317:
        if (r112 == null) goto L319;
        r112.remove("vmsdk_scriptPath");
        goto L319
    L311:
        r118 = null;
        goto L312
    L307:
        r117 = null;
    L303:
        r115 = "hybrid";
        goto L304
    L296:
        if (ECSettingKeys.l() == false) goto L319;
    L336:
        Uri r119 = UriProtector.parse(r104);     // Catch: Exception -> L292
        p.f44326c = r119;
        if ((!Intrinsics.areEqual(UriProtector.getQueryParameter(r119, "ec_order_prefetch"), "1")) == false) goto L45;
        ECLiveEntranceMonitor.trace$default("ec_order_prefetch is not enable", "BuyNowPrefetch", false, 4, null);
        goto L44
    L45:
        int r120 = zg.a.f571786a;
        int r121 = com.bytedance.android.ec.core.opt.ab.m.f45240a;
        boolean r122 = ECServiceManager.f42805a;
        s83.g r123 = (s83.g) ECServiceManager.c(s83.g.class);
        String r124 = "";
        if (r123 == null) goto L51;
        s83.a r125 = r123.q();
        if (r125 == null) goto L51;
        Object r126 = r125.e("ec_order_prefetch_config");
        if (r126 == null) goto L51;
    L346:
        String r127 = Uri.decode((String) r126);     // Catch: Exception -> L222
    L348:
        Set<String> r128 = UriProtector.getQueryParameterNames(p.f44326c);     // Catch: JSONException -> L235
        JSONObject r129 = new JSONObject(r127);     // Catch: JSONException -> L235
        JSONArray r130 = r129.optJSONArray("no_prefetch_buynow");     // Catch: JSONException -> L235
        if (r130 == null) goto L233;
        int r131 = r130.length();     // Catch: JSONException -> L235
        int r132 = 0;
    L228:
        if (r132 >= r131) goto L233;
        String r133 = r130.optString(r132, "");     // Catch: JSONException -> L235
        if (r128.contains(r133) == true) goto L231;
        r132 = r132 + 1;     // Catch: JSONException -> L235
        goto L228
    L231:
        ECLiveEntranceMonitor.trace$default("no need for prefetch: " + r133, "BuyNowPrefetch", false, 4, null);     // Catch: JSONException -> L235
    L237:
        boolean r134 = false;
    L238:
        if (r134 == false) goto L286;
        String r135 = UriProtector.getQueryParameter(p.f44326c, "mega_object_id");
        if (r135 == null) goto L246;
        HashMap<String, JSONObject> r136 = j.f44312a;
        JSONObject r137 = j.d(r135);
        if (r137 == null) goto L246;
        p.f44324a = new JSONObject(r137.optString(com.bytedance.android.ec.core.event.a.KEY_CJ_INFO));     // Catch: Exception -> L329
    L344:
        p.f44325b = new JSONObject(r137.optString(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO));     // Catch: Exception -> L330
    L246:
        Iterator r138 = ((LinkedHashMap) p.f44327d).entrySet().iterator();
    L248:
        if (r138.hasNext() == false) goto L250;
        Map.Entry r139 = (Map.Entry) r138.next();
        p.f44328e.put((String) r139.getKey(), p.c((l) r139.getValue()));
        goto L248
    L250:
        Iterator r140 = ((LinkedHashMap) p.f44329f).entrySet().iterator();
    L252:
        if (r140.hasNext() == false) goto L254;
        Map.Entry r141 = (Map.Entry) r140.next();
        p.f44330g.put((String) r141.getKey(), p.c((l) r141.getValue()));
        goto L252
    L254:
        Iterator r142 = ((LinkedHashMap) p.f44331h).entrySet().iterator();
    L256:
        if (r142.hasNext() == false) goto L258;
        Map.Entry r143 = (Map.Entry) r142.next();
        p.f44332i.put((String) r143.getKey(), p.c((l) r143.getValue()));
        goto L256
    L258:
        String r144 = UUID.randomUUID().toString();
        p.f44333j.put(r144, null);
        Map<String, Object> r145 = p.f44330g;     // Catch: Exception -> L283
        if ((r145 instanceof Map) == true) goto L262;
        r145 = null;
    L262:
        if (r145 != null) goto L264;
        r145 = MapsKt.emptyMap();     // Catch: Exception -> L283
    L264:
        JSONObject r146 = new JSONObject(r145);     // Catch: Exception -> L283
        Map<String, Object> r147 = p.f44332i;     // Catch: Exception -> L283
        if ((r147 instanceof Map) == true) goto L267;
        r147 = null;
    L267:
        if (r147 != null) goto L269;
        r147 = MapsKt.emptyMap();     // Catch: Exception -> L283
    L269:
        JSONObject r148 = new JSONObject(r147);     // Catch: Exception -> L283
        JSONArray r149 = new JSONArray();     // Catch: Exception -> L283
        r149.put(0, r148);     // Catch: Exception -> L283
        JSONArray r150 = new JSONArray();     // Catch: Exception -> L283
        r150.put(0, r146);     // Catch: Exception -> L283
        r146.put("product_requests", r149);     // Catch: Exception -> L283
        String r151 = p.f44325b.toString();     // Catch: Exception -> L283
        JSONObject r152 = new JSONObject();     // Catch: Exception -> L283
        String r153 = p.f44324a.optString(com.bytedance.android.ec.core.event.a.KEY_INSTALLMENT_INFO, null);     // Catch: Exception -> L283
        if (r153 == null) goto L340;
        r152.put("top_pay_type", 8);     // Catch: Exception -> L283
        r152.put("default_pay_type", 8);     // Catch: Exception -> L283
        r152.put(com.bytedance.android.ec.core.event.a.KEY_INSTALLMENT_INFO, r153);     // Catch: Exception -> L283
    L340:
        r152.put("checkout_id", 1);     // Catch: Exception -> L331
        String r154 = p.f44324a.optString(com.bytedance.android.ec.core.event.a.KEY_BIO_TYPE, null);     // Catch: Exception -> L331
        if (r154 == null) goto L277;
        r152.put(com.bytedance.android.ec.core.event.a.KEY_BIO_TYPE, r154);     // Catch: Exception -> L331
    L277:
        String r155 = r152.toString();     // Catch: Exception -> L331
        JSONObject r156 = new JSONObject();     // Catch: Exception -> L331
        Iterator r157 = ((LinkedHashMap) p.f44328e).entrySet().iterator();     // Catch: Exception -> L331
    L279:
        if (r157.hasNext() == false) goto L281;
        Map.Entry r158 = (Map.Entry) r157.next();     // Catch: Exception -> L331
        r156.put((String) r158.getKey(), r158.getValue());     // Catch: Exception -> L331
        goto L279
    L281:
        r156.put("customize_pay_type", r155);     // Catch: Exception -> L331
        r156.put("shop_requests", r150);     // Catch: Exception -> L331
        r156.put("entrance_params", r151);     // Catch: Exception -> L331
        bg4.b.b(((OrderDetailApi) com.bytedance.android.ec.sdk.helper.n.f48128a.create("https://ken.snssdk.com/", OrderDetailApi.class)).prefetchOrderDetailData2(2, r156)).subscribe(new m(SystemClock.elapsedRealtime(), r144), new n(r144));     // Catch: Exception -> L331
        r124 = r144;
    L284:
        p.e(new q("", 3), r144);
        p.a();
    L286:
        if (r124.length() <= 0) goto L288;
        boolean r159 = true;
    L289:
        if (r159 == false) goto L291;
        r104 = p.f44326c.buildUpon().appendQueryParameter("ec_request_id", r124).build().toString();
        goto L44
    L291:
        ECLiveEntranceMonitor.trace$default("prefetch failed as request_id is empty", "BuyNowPrefetch", false, 4, null);
        goto L44
    L288:
        r159 = false;
    L233:
        p.d("ec_order_outside", r129);     // Catch: JSONException -> L235
        p.d("ec_order_shop_request", r129);     // Catch: JSONException -> L235
        p.d("ec_order_product_request", r129);     // Catch: JSONException -> L235
        r134 = true;
    L235:
        e = move-exception;
        ECLiveEntranceMonitor.trace$default("parseSetting failed: " + e.getMessage(), "BuyNowPrefetch", false, 4, null);
    L222:
        e = move-exception;
        ECLiveEntranceMonitor.trace$default("decode ec_order_prefetch_config failed: " + e.getMessage(), "BuyNowPrefetch", false, 4, null);
        r127 = "";
    L51:
        int r160 = com.bytedance.android.ec.core.opt.ab.n.f45241a;
        int r161 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r162 = Result.Companion;     // Catch: Throwable -> L212
        Object r163 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_order_prefetch_config");     // Catch: Throwable -> L105
        if (r163 != null) goto L57;
    L102:
        Object r164 = null;
    L103:
        Object r165 = Result.m9449constructorimpl(r164);     // Catch: Throwable -> L105
    L107:
        Throwable r166 = Result.m9452exceptionOrNullimpl(r165);     // Catch: Throwable -> L212
        if (r166 == null) goto L111;
        EnsureManager.ensureNotReachHere(r166);     // Catch: Throwable -> L212
    L111:
        if (Result.m9455isFailureimpl(r165) == false) goto L114;
        r165 = null;
    L114:
        if ((r165 instanceof String) == true) goto L116;
        r165 = null;
    L116:
        r126 = (String) r165;     // Catch: Throwable -> L212
        if (r126 != null) goto L123;
        Object r167 = com.bytedance.android.ec.base.settings.d.f42816a.get("ec_order_prefetch_config");     // Catch: Throwable -> L212
        if ((r167 instanceof String) == true) goto L122;
        r167 = null;
    L122:
        r126 = (String) r167;     // Catch: Throwable -> L212
    L123:
        if (r126 != null) goto L346;
        int r168 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L212
        Object r169 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_order_prefetch_config");     // Catch: Throwable -> L178
        if (r169 != null) goto L130;
    L175:
        Object r170 = null;
    L176:
        Object r171 = Result.m9449constructorimpl(r170);     // Catch: Throwable -> L178
    L180:
        Throwable r172 = Result.m9452exceptionOrNullimpl(r171);     // Catch: Throwable -> L203
        if (r172 == null) goto L184;
        EnsureManager.ensureNotReachHere(r172);     // Catch: Throwable -> L203
    L184:
        if (Result.m9455isFailureimpl(r171) == false) goto L187;
        r171 = null;
    L187:
        if ((r171 instanceof String) == true) goto L189;
        r171 = null;
    L189:
        r126 = (String) r171;     // Catch: Throwable -> L203
        if (r126 != null) goto L210;
        IHybridHostService r173 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L203
        if (r173 == null) goto L195;
        Object r174 = r173.getHostABValue("ec_order_prefetch_config", "");     // Catch: Throwable -> L203
    L196:
        if (r174 != null) goto L198;
    L209:
        r126 = "";
        goto L210
    L198:
        if ((r174 instanceof String) == true) goto L200;
        r174 = null;
    L200:
        r126 = (String) r174;     // Catch: Throwable -> L203
        if (r126 != null) goto L210;
    L203:
        th = move-exception;
        Result.Companion r175 = Result.Companion;     // Catch: Throwable -> L212
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L212
        Throwable r176 = Result.m9452exceptionOrNullimpl(r126);     // Catch: Throwable -> L212
        if (r176 == null) goto L208;
        EnsureManager.ensureNotReachHere(r176);     // Catch: Throwable -> L212
    L208:
        if (Result.m9455isFailureimpl(r126) == false) goto L210;
    L195:
        r174 = null;
    L210:
        com.bytedance.android.ec.base.settings.d.d("ec_order_prefetch_config", r126);     // Catch: Throwable -> L212
        goto L346
    L130:
        if ((r169 instanceof String) == true) goto L132;
        Object r177 = null;
    L133:
        r170 = (String) r177;     // Catch: Throwable -> L178
        if (r170 != null) goto L176;
        if ((r169 instanceof Number) == false) goto L163;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L145;
        Float r178 = Float.valueOf(((Number) r169).floatValue());     // Catch: Throwable -> L178
        if ((r178 instanceof String) == true) goto L143;
        r178 = null;
    L143:
        r170 = (String) r178;     // Catch: Throwable -> L178
        goto L176
    L145:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L151;
        Double r179 = Double.valueOf(((Number) r169).doubleValue());     // Catch: Throwable -> L178
        if ((r179 instanceof String) == true) goto L149;
        r179 = null;
    L149:
        r170 = (String) r179;     // Catch: Throwable -> L178
        goto L176
    L151:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L157;
        Integer r180 = Integer.valueOf(((Number) r169).intValue());     // Catch: Throwable -> L178
        if ((r180 instanceof String) == true) goto L155;
        r180 = null;
    L155:
        r170 = (String) r180;     // Catch: Throwable -> L178
        goto L176
    L157:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L163;
        Long r181 = Long.valueOf(((Number) r169).longValue());     // Catch: Throwable -> L178
        if ((r181 instanceof String) == true) goto L161;
        r181 = null;
    L161:
        r170 = (String) r181;     // Catch: Throwable -> L178
    L163:
        if ((r169 instanceof JSONObject) == false) goto L165;
    L338:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L171
        Object r182 = SDKSettingsCacheManager.a().fromJson(r169.toString(), String.class);     // Catch: Throwable -> L171
        if ((r182 instanceof String) == true) goto L169;
        r182 = null;
    L169:
        Object r183 = Result.m9449constructorimpl((String) r182);     // Catch: Throwable -> L171
    L173:
        r170 = r183;
        if (Result.m9455isFailureimpl(r170) == false) goto L176;
    L171:
        th = move-exception;
        Result.Companion r184 = Result.Companion;     // Catch: Throwable -> L178
        r183 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L178
        goto L173
    L165:
        if ((r169 instanceof JSONArray) == false) goto L175;
    L132:
        r177 = r169;
    L178:
        th = move-exception;
        Result.Companion r185 = Result.Companion;     // Catch: Throwable -> L203
        r171 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L203
        goto L180
    L57:
        if ((r163 instanceof String) == true) goto L59;
        Object r186 = null;
    L60:
        r164 = (String) r186;     // Catch: Throwable -> L105
        if (r164 != null) goto L103;
        if ((r163 instanceof Number) == false) goto L90;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L72;
        Float r187 = Float.valueOf(((Number) r163).floatValue());     // Catch: Throwable -> L105
        if ((r187 instanceof String) == true) goto L70;
        r187 = null;
    L70:
        r164 = (String) r187;     // Catch: Throwable -> L105
        goto L103
    L72:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L78;
        Double r188 = Double.valueOf(((Number) r163).doubleValue());     // Catch: Throwable -> L105
        if ((r188 instanceof String) == true) goto L76;
        r188 = null;
    L76:
        r164 = (String) r188;     // Catch: Throwable -> L105
        goto L103
    L78:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L84;
        Integer r189 = Integer.valueOf(((Number) r163).intValue());     // Catch: Throwable -> L105
        if ((r189 instanceof String) == true) goto L82;
        r189 = null;
    L82:
        r164 = (String) r189;     // Catch: Throwable -> L105
        goto L103
    L84:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L90;
        Long r190 = Long.valueOf(((Number) r163).longValue());     // Catch: Throwable -> L105
        if ((r190 instanceof String) == true) goto L88;
        r190 = null;
    L88:
        r164 = (String) r190;     // Catch: Throwable -> L105
    L90:
        if ((r163 instanceof JSONObject) == false) goto L92;
    L332:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L98
        Object r191 = SDKSettingsCacheManager.a().fromJson(r163.toString(), String.class);     // Catch: Throwable -> L98
        if ((r191 instanceof String) == true) goto L96;
        r191 = null;
    L96:
        Object r192 = Result.m9449constructorimpl((String) r191);     // Catch: Throwable -> L98
    L100:
        r164 = r192;
        if (Result.m9455isFailureimpl(r164) == false) goto L103;
    L98:
        th = move-exception;
        Result.Companion r193 = Result.Companion;     // Catch: Throwable -> L105
        r192 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L105
        goto L100
    L92:
        if ((r163 instanceof JSONArray) == false) goto L102;
    L59:
        r186 = r163;
    L105:
        th = move-exception;
        Result.Companion r194 = Result.Companion;     // Catch: Throwable -> L212
        r165 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L212
    L212:
        th = move-exception;
        Result.Companion r195 = Result.Companion;
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r196 = Result.m9452exceptionOrNullimpl(r126);
        if (r196 == null) goto L217;
        EnsureManager.ensureNotReachHere(r196);
    L217:
        if (Result.m9455isFailureimpl(r126) == false) goto L346;
        r126 = "";
        goto L346
    L5:
        Uri r197 = UriProtector.parse(r103);
        Uri.Builder r198 = r197.buildUpon();
        Iterator<T> r199 = UriProtector.getQueryParameterNames(r102).iterator();
    L7:
        if (r199.hasNext() == false) goto L19;
        String r1100 = (String) r199.next();
        if (Intrinsics.areEqual(r1100, "fallback_url") == true) goto L7;
        if (Intrinsics.areEqual(r1100, "mega_object") == true) goto L7;
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r197, r1100)) == false) goto L7;
    L18:
        r198.appendQueryParameter(r1100, UriProtector.getQueryParameter(r102, r1100));
    L16:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L18
    L19:
        String r200 = r198.build().toString();
        if (r102 != null) goto L23;
    L36:
        r100 = String.valueOf(r102);
        goto L4
    L23:
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r102, "fallback_url")) == true) goto L36;
        Uri.Builder r201 = r102.buildUpon();
        r201.clearQuery();
        Iterator<String> r202 = UriProtector.getQueryParameterNames(r102).iterator();
    L27:
        if (r202.hasNext() == false) goto L35;
        String r1101 = r202.next();
        if ((!Intrinsics.areEqual(r1101, "fallback_url")) == true) goto L30;
        r201.appendQueryParameter(r1101, r200);
        goto L27
    L30:
        Iterator<String> r1102 = UriProtector.getQueryParameters(r102, r1101).iterator();
    L32:
        if (r1102.hasNext() == false) goto L27;
        r201.appendQueryParameter(r1101, r1102.next());
        goto L32
    L35:
        r102 = r201.build();
        goto L36
    }

    public static f c(Activity r100, String r101, Map r102, ViewGroup r103, ti.k r104, boolean r105, boolean r106, LifecycleOwner r110, Function1 r111) {
        int r107 = ECSdk.f48106a;     // Catch: Exception -> L9
        IAdapterService r108 = (IAdapterService) ECSdk.a(IAdapterService.class);     // Catch: Exception -> L9
        if (r108 == null) goto L11;
        pd.e r109 = r108.getIExternaHybridService();     // Catch: Exception -> L9
        if (r109 == null) goto L11;
        pd.j r112 = r109.createLynxComponent(r100, r101, new g(r104), r105);     // Catch: Exception -> L9
    L12:
        if (r112 != null) goto L14;
        return null;
    L14:
        r112.getHybridView().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (r103 == null) goto L17;
        r103.addView(r112.getHybridView());
    L17:
        if (r106 == false) goto L24;
        if (r110 == null) goto L20;
    L23:
        r112.c(r110);
        goto L24
    L20:
        if ((r100 instanceof LifecycleOwner) == true) goto L22;
        r100 = null;
    L22:
        r110 = (LifecycleOwner) r100;
    L24:
        f r113 = new f(r112);
        if (r111 == null) goto L27;
        Unit r114 = (Unit) r111.invoke(r113);
    L27:
        r112.renderTemplate(r101, r102);
        return r113;
    L11:
        r112 = null;
    L9:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L11
    }

    public static h e(Activity r100, String r101, Map r102, ViewGroup r103, ti.k r104, boolean r105, boolean r106, LifecycleOwner r107, Function1 r110) {
        int r108 = ECSdk.f48106a;     // Catch: Exception -> L9
        IAdapterService r109 = (IAdapterService) ECSdk.a(IAdapterService.class);     // Catch: Exception -> L9
        if (r109 == null) goto L11;
        pd.e r111 = r109.getIExternaHybridService();     // Catch: Exception -> L9
        if (r111 == null) goto L11;
        pd.g r112 = r111.createWebViewRecord(r100, r101, new i(r104), r105);     // Catch: Exception -> L9
    L12:
        if (r112 != null) goto L14;
        return null;
    L14:
        r112.getHybridView().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (r103 == null) goto L18;
        r103.addView(r112.getHybridView());
    L18:
        if (StringsKt.startsWith$default(r101, "http", false, 2, null) == false) goto L38;
    L23:
        if (r106 == false) goto L30;
        if (r107 != null) goto L29;
        boolean r113 = r100 instanceof LifecycleOwner;
        Object r114 = r100;
        if (r113 == true) goto L28;
        r114 = null;
    L28:
        LifecycleOwner r115 = (LifecycleOwner) r114;
    L29:
        r112.c();
    L30:
        h r116 = new h(r112);
        if (r110 == null) goto L33;
        Unit r117 = (Unit) r110.invoke(r116);
    L33:
        if (r101 == null) goto L35;
        r112.loadUrl(r101);
    L35:
        return r116;
    L38:
        r101 = UriProtector.getQueryParameter(UriProtector.parse(r101), "url");     // Catch: Exception -> L22
    L22:
        r101 = "";
    L11:
        r112 = null;
    L9:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L11
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [T, com.bytedance.android.ec.core.hybrid.utils.h] */
    /* JADX WARN: Type inference failed for: r0v17, types: [T, com.bytedance.android.ec.core.hybrid.utils.h] */
    /* JADX WARN: Type inference failed for: r0v22, types: [T, com.bytedance.android.ec.core.hybrid.utils.f] */
    /* JADX WARN: Type inference failed for: r0v23, types: [T, com.bytedance.android.ec.core.hybrid.utils.f] */
    public static ti.l b(Context r110, String r111, Map r112, ViewGroup r210, ti.k r211, HybridType r212, Lifecycle r213, boolean r214, LifecycleOwner r215, Function1 r216, boolean r217, int r218) {
        if ((r218 & 4) == 0) goto L5;
        Map r100 = null;
    L7:
        if ((r218 & 8) == 0) goto L9;
        ViewGroup r101 = null;
    L11:
        if ((r218 & 16) == 0) goto L13;
        ti.k r102 = null;
    L15:
        if ((r218 & 32) == 0) goto L17;
        HybridType r103 = HybridType.LYNX;
    L19:
        if ((r218 & 64) != 0) goto L21;
        Lifecycle r104 = r213;
    L30:
        if ((r218 & 256) == 0) goto L32;
        boolean r105 = false;
    L34:
        if ((r218 & 512) == 0) goto L36;
        LifecycleOwner r113 = null;
    L38:
        if ((r218 & 1024) == 0) goto L40;
        Function1 r114 = null;
    L42:
        if ((r218 & 2048) == 0) goto L44;
        boolean r115 = false;
    L45:
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "url");
        Lazy r106 = ECSettingKeys.f43616a;
        int r107 = com.bytedance.android.ec.core.opt.ab.p.f45243a;
        Lazy r116 = ECAppInfoService.f48110a;
        Object r117 = Boolean.valueOf(ECAppInfoService.m());
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L50
        jj4.b r119 = jj4.b.f499326b;     // Catch: Throwable -> L50
        Object r108 = jj4.a.a("ec_use_annie_component", Boolean.class, r117, false);     // Catch: Throwable -> L50
        if (r108 != null) goto L57;
        Intrinsics.throwNpe();     // Catch: Throwable -> L50
    L57:
        if (((Boolean) r108).booleanValue() == true) goto L62;
        Lazy r109 = ECAppInfoService.f48110a;
        if (ECAppInfoService.j() == true) goto L62;
        boolean r120 = false;
    L64:
        if ((r110 instanceof MutableContextWrapper) == false) goto L71;
        Context r121 = r110;
    L67:
        if ((r121 instanceof Activity) == true) goto L73;
        if ((r121 instanceof ContextWrapper) == false) goto L73;
        r121 = ((ContextWrapper) r121).getBaseContext();
    L73:
        if ((r121 instanceof Activity) == true) goto L75;
        r121 = null;
    L75:
        Activity r122 = (Activity) r121;
        if (r122 != null) goto L78;
        r122 = com.bytedance.android.ec.sdk.plugin.e.getActivity(r110);
    L78:
        if (r122 == null) goto L118;
        final Ref.ObjectRef r123 = new Ref.ObjectRef();
        r123.element = null;
        final Lifecycle r124 = r104;
        if (r103 != HybridType.LYNX) goto L95;
        if (StringsKt.startsWith$default(r111, "http", false, 2, null) == false) goto L85;
        r123.element = c(r122, r111, r100, r101, d(r102, r115), r120, r105, r113, r114);
    L109:
        if (((ti.l) r123.element) == null) goto L113;
        if (r124 == null) goto L113;
        r124.addObserver(new ECLiveHybridUtil$createLiveHybridComponent$$inlined$let$lambda$1(r124, r123));
    L113:
        return (ti.l) r123.element;
    L85:
        String r125 = UriProtector.parse(r111).getHost();
        if (r125 == null) goto L109;
        if (r125.hashCode() != 469921128) goto L109;
        if (r125.equals("webcast_lynxview") == false) goto L109;
        r123.element = c(r122, r111, r100, r101, d(r102, r115), r120, r105, r113, r114);
        goto L109
    L95:
        if (r103 != HybridType.WEB) goto L109;
        if (StringsKt.startsWith$default(r111, "http", false, 2, null) == false) goto L99;
        r123.element = e(r122, r111, r100, r101, d(r102, r115), r120, r105, r113, r114);
        goto L109
    L99:
        String r126 = UriProtector.parse(r111).getHost();
        if (r126 == null) goto L109;
        if (r126.hashCode() != 1435311181) goto L109;
        if (r126.equals("webcast_webview") == false) goto L109;
        r123.element = e(r122, r111, r100, r101, d(r102, r115), r120, r105, r113, r114);
        goto L109
    L118:
        return null;
    L71:
        r121 = r110;
    L62:
        r120 = true;
    L50:
        th = move-exception;
        Result.Companion r127 = Result.Companion;
        Object r128 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r128) == true) goto L55;
        r117 = r128;
    L55:
        r108 = r117;
        goto L57
    L44:
        r115 = r217;
        goto L45
    L40:
        r114 = r216;
        goto L42
    L36:
        r113 = r215;
        goto L38
    L32:
        r105 = r214;
        goto L34
    L21:
        if ((r110 instanceof FragmentActivity) == true) goto L23;
        Context r129 = null;
    L24:
        FragmentActivity r130 = (FragmentActivity) r129;
        if (r130 == null) goto L27;
        r104 = r130.getLifecycle();
        goto L30
    L27:
        r104 = null;
        goto L30
    L23:
        r129 = r110;
        goto L24
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
