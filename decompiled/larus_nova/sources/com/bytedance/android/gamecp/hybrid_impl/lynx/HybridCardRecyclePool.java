package com.bytedance.android.gamecp.hybrid_impl.lynx;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.view.View;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.gamecp.common.setting.config.GamePromoteIconLocation;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.gamecp.host_api.GameCpTargetUtils;
import com.bytedance.android.gamecp.live_api.ProviderSource;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.bullet.pool.util.PoolUtilKt;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.behavior.LynxContext;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import wu.m2;
import wu.n4;
import wu.p3;

/* JADX INFO: loaded from: classes44.dex */
public final class HybridCardRecyclePool {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f57566l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f57567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f57568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f57569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f57570d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Triple<Boolean, String, ? extends Object> f57571e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f57572f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f57573g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<String, ? extends Object> f57574h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<Function3<View, Boolean, Triple<Boolean, String, ? extends Object>, Unit>> f57575i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f57576j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final HybridCardRecyclePool$lifecycleObserver$1 f57577k;

    public static final class a {
    }

    public static final class b extends jw.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HybridCardRecyclePool f57578a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f57579b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f57580c;

        @Override // jw.a, com.bytedance.android.anniex.ui.e
        public final void b(AnnieXLynxView r100, String r101) {
            HybridCardRecyclePool r102 = this.f57578a;
            String r103 = this.f57580c;
            r102.getClass();
            HybridCardRecyclePool.j(r103, "dygame_card_load_failed", "anniex", r101);
        }

        @Override // jw.a, com.bytedance.android.anniex.ui.e
        public final void d(Uri r100, AnnieXLynxView r101) {
            this.f57578a.f57570d = true;
            Map<String, ? extends Object> r102 = this.f57579b;
            if (r102 == null) goto L5;
            this.f57578a.i(r102);
        L5:
            this.f57578a.getClass();
            HybridCardRecyclePool r103 = this.f57578a;
            String r104 = this.f57580c;
            r103.getClass();
            HybridCardRecyclePool.j(r104, "dygame__card_load_success", "anniex", null);
        }

        @Override // jw.a, com.bytedance.android.anniex.ui.e
        public final void onLoadFail(Uri r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            Intrinsics.checkNotNullParameter(r101, "e");
            super.onLoadFail(r100, r101);
            HybridCardRecyclePool r102 = this.f57578a;
            String r103 = this.f57580c;
            String r104 = r101.getMessage();
            if (r104 != null) goto L5;
            r104 = "unknown";
        L5:
            r102.getClass();
            HybridCardRecyclePool.j(r103, "dygame_card_load_fail", "anniex", r104);
        }

        public b(HybridCardRecyclePool r100, Map r101, String r102) {
            this.f57578a = r100;
            this.f57579b = r101;
            this.f57580c = r102;
        }
    }

    public static final class c extends b7.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HybridCardRecyclePool f57581a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f57582b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map f57583c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f57584d;

        @Override // b7.a, b7.b
        public final void onLoadSuccess(View r100) {
            this.f57581a.f57570d = true;
            Map<String, ? extends Object> r101 = this.f57583c;
            if (r101 == null) goto L5;
            this.f57581a.i(r101);
        L5:
            this.f57581a.getClass();
            HybridCardRecyclePool r102 = this.f57581a;
            String r103 = this.f57584d;
            r102.getClass();
            HybridCardRecyclePool.j(r103, "dygame__card_load_success", "webcast", null);
        }

        @Override // b7.a, b7.b
        public final void onAttachView(View r100, IHybridComponent.HybridType r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "hybridType");
            super.onAttachView(r100, r101, r102);
            if (GameCpTargetUtils.c() == false) goto L13;
            View r103 = this.f57581a.f57568b;
            if (r103 != null) goto L7;
            return;
        L7:
            if ((r103 instanceof HybridCard) == true) goto L10;
            r103 = null;
        L10:
            if (r103 == null) goto L15;
            com.bytedance.android.gamecp.host_api.a.b().getBrowserService().e0((HybridCard) r103);
            return;
        L15:
            return;
        }

        @Override // b7.a, b7.b
        public final void onLoadFail(View r100, String r101, String r102) {
            HybridCardRecyclePool r103 = this.f57581a;
            String r104 = this.f57584d;
            if (r102 != null) goto L5;
            r102 = "unknown";
        L5:
            r103.getClass();
            HybridCardRecyclePool.j(r104, "dygame_card_load_fail", "webcast", r102);
        }

        public c(HybridCardRecyclePool r100, Map r101, Map r102, String r103) {
            this.f57581a = r100;
            this.f57582b = r101;
            this.f57583c = r102;
            this.f57584d = r103;
        }
    }

    static {
    }

    public static String c() {
        String r100 = m2.f561350a.getValue().a();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final void h() {
        yr.b.b(4, this.f57567a, "recycleHybridCard");
        View r100 = this.f57568b;
        if (r100 == null) goto L5;
        PoolUtilKt.a(r100);
    L5:
        View r101 = this.f57568b;
        if ((r101 instanceof AnnieXLynxView) == false) goto L12;
        if (r101 == null) goto L10;
        ((AnnieXLynxView) r101).destroy();
    L17:
        Disposable r102 = this.f57573g;
        if (r102 == null) goto L20;
        r102.dispose();
    L20:
        this.f57573g = null;
        this.f57568b = null;
        this.f57570d = false;
        this.f57571e = null;
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.anniex.ui.AnnieXLynxView");
    L12:
        if ((r101 instanceof HybridCard) == true) goto L14;
        r101 = null;
    L14:
        HybridCard r103 = (HybridCard) r101;
        if (r103 == null) goto L17;
        r103.release();
        goto L17
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.bytedance.android.gamecp.hybrid_impl.lynx.HybridCardRecyclePool$lifecycleObserver$1] */
    public HybridCardRecyclePool() {
        this.f57567a = "HybridCardRecyclePool";
        this.f57572f = LazyKt.lazy(HybridCardRecyclePool$kevaGecoSp$2.INSTANCE);
        this.f57575i = new ArrayList();
        this.f57576j = LazyKt.lazy(HybridCardRecyclePool$cardLoadPostpone$2.INSTANCE);
        this.f57577k = new HybridCardRecyclePool$lifecycleObserver$1(this);
    }

    public final boolean g() {
        Long r100 = com.bytedance.android.gamecp.host_api.a.b().getBrowserService().getGeckoLatestChannelVersion("game_promote_tools_lynx_douyin");
        if (r100 == null) goto L5;
        long r101 = r100.longValue();
    L7:
        if (r101 == ((Keva) this.f57572f.getValue()).getLong("gecko_version_key", 0)) goto L9;
        return true;
    L9:
        return false;
    L5:
        r101 = 0;
        goto L7
    }

    public static Map d(Map r100) {
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.get("roomContext");
    L7:
        if ((r102 instanceof Map) == false) goto L10;
        r101 = r102;
    L10:
        Map r103 = (Map) r101;
        if (r103 == null) goto L29;
        Object r104 = r103.get("roomId");
        if (r104 == null) goto L28;
        String r105 = (String) r104;
        Object r106 = r103.get("uniqueKey");
        if (r106 == null) goto L26;
        String r107 = (String) r106;
        Object r108 = r103.get("isPreStream");
        if (r108 == null) goto L24;
        if (((Integer) r108).intValue() != 0) goto L21;
        ProviderSource r109 = ProviderSource.DEFAULT;
    L22:
        String r110 = r109.name();
    L30:
        LinkedHashMap r111 = new LinkedHashMap();
        r111.put("room_id", r105);
        r111.put("unique_key", r107);
        r111.put("source", r110);
        return r111;
    L21:
        r109 = ProviderSource.PREVIEW;
        goto L22
    L24:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L26:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L28:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L29:
        r105 = "";
        r110 = "";
        r107 = r110;
        goto L30
    L5:
        r102 = null;
        goto L7
    }

    public final Triple<Boolean, String, Object> f(Map<String, Object> r100) {
        Logger.i("game-promote", "hookImageInterceptor params =" + r100);
        return e(this.f57568b, GamePromoteIconLocation.GAME_PROMOTE_ICON.getLocation(), r100);
    }

    public final void i(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (this.f57570d == true) goto L6;
        this.f57574h = r100;
        return;
    L6:
        View r101 = this.f57568b;
        if ((r101 instanceof AnnieXLynxView) == false) goto L13;
        if (r101 == null) goto L11;
        JSONObject r102 = new JSONObject(r100);
        int r103 = AnnieXLynxView.B;
        ((AnnieXLynxView) r101).O("setCardInitialData", r102, true);
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.anniex.ui.AnnieXLynxView");
    L13:
        if ((r101 instanceof HybridCard) == true) goto L15;
        r101 = null;
    L15:
        HybridCard r104 = (HybridCard) r101;
        if (r104 == null) goto L20;
        r104.sendJsEvent("setCardInitialData", r100);
        return;
    }

    public static void k(String r100, String r101) {
        Map r102 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("game_id", r100), TuplesKt.to(BdpAppEventConstant.PARAMS_PKG_IS_REUSE, r101)});
        HashMap<String, String> r103 = GamecpTracker.f56755a;
        GamecpTracker.B("dygame_tech_explain_card_lynx_reuse", r102);
    }

    public static Triple e(View r100, String r101, Map r102) {
        Intrinsics.checkNotNullParameter(r101, "location");
        Intrinsics.checkNotNullParameter(r102, "params");
        if ((r100 instanceof HybridCard) == false) goto L14;
        View r103 = ((HybridCard) r100).getHybridView();
        if ((r103 instanceof LynxView) == true) goto L7;
        r103 = null;
    L7:
        LynxView r104 = (LynxView) r103;
        if (r104 == null) goto L24;
        LynxContext r105 = r104.getLynxContext();
        if (r105 == null) goto L24;
        return u1.b(r105, r101, r102);
    L24:
        return new Triple(Boolean.FALSE, null, null);
    L14:
        if ((r100 instanceof LynxView) == true) goto L16;
        r100 = null;
    L16:
        LynxView r106 = (LynxView) r100;
        if (r106 == null) goto L22;
        LynxContext r107 = r106.getLynxContext();
        if (r107 == null) goto L22;
        return u1.b(r107, r101, r102);
    L22:
        return new Triple(Boolean.FALSE, null, null);
    }

    public static /* synthetic */ void b(HybridCardRecyclePool r100, Context r101, String r102, Map r103) {
        r100.a(r101, r102, r103, null, null);
    }

    public static void j(String r110, String r111, String r112, String r113) {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L25
        String r101 = UriProtector.getQueryParameter(UriProtector.parse(r110), "url");     // Catch: Throwable -> L25
        if (r101 != null) goto L6;
        return;
    L6:
        Uri r102 = UriProtector.parse(r101);     // Catch: Throwable -> L25
        String r103 = r102.getPath();     // Catch: Throwable -> L25
        if (r103 == null) goto L9;
        int r104 = StringsKt.lastIndexOf$default(r103, HTTP.URL_DEFAULT, 0, false, 6, null);     // Catch: Throwable -> L25
    L10:
        String r105 = r102.getPath();     // Catch: Throwable -> L25
        String r106 = null;
        if (r105 == null) goto L13;
        String r107 = r105.substring(0, r104);     // Catch: Throwable -> L25
    L14:
        if (r107 == null) goto L16;
        int r108 = StringsKt.lastIndexOf$default(r107, HTTP.URL_DEFAULT, 0, false, 6, null);     // Catch: Throwable -> L25
    L18:
        if (r107 == null) goto L20;
        r106 = r107.substring(r108 + 1);     // Catch: Throwable -> L25
    L20:
        bw.j r109 = com.bytedance.android.gamecp.host_api.a.b().getLogService();     // Catch: Throwable -> L25
        Map<String, String> r114 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("event_type", r111), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, r112), TuplesKt.to("pid", r106)});     // Catch: Throwable -> L25
        if (r113 == null) goto L23;
        r114.put("errorMsg", r113);     // Catch: Throwable -> L25
    L23:
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L25
        r109.logV3("dygame_lynx_introduce_card_type_event", r114);     // Catch: Throwable -> L25
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L25
        return;
    L16:
        r108 = 0;
        goto L18
    L13:
        r107 = null;
        goto L14
    L9:
        r104 = 0;
    L25:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public final void a(Context r210, String r211, Map<String, ? extends Object> r212, String r213, Function3<? super View, ? super Boolean, ? super Triple<Boolean, String, ? extends Object>, Unit> r214) {
        final Map<String, ? extends Object> r100 = r212;
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.get("roomContext");
    L7:
        if ((r102 instanceof Map) == true) goto L9;
        r102 = null;
    L9:
        Map r103 = (Map) r102;
        if (r103 == null) goto L16;
        String r104 = this.f57567a;
        StringBuilder r105 = new StringBuilder();
        r105.append(r103.get("uniqueKey"));
        r105.append('-');
        r105.append(r103.get("isPreStream"));
        r105.append(": 容器是否已 ready = ");
        if (this.f57568b == null) goto L14;
        boolean r106 = true;
    L15:
        r105.append(r106);
        yr.b.b(4, r104, r105.toString());
        goto L16
    L14:
        r106 = false;
    L16:
        View r107 = this.f57568b;
        if (r107 == null) goto L55;
        Context r108 = r107.getContext();
        if ((r108 instanceof MutableContextWrapper) == true) goto L21;
        r108 = null;
    L21:
        MutableContextWrapper r109 = (MutableContextWrapper) r108;
        if (r109 == null) goto L24;
        r109.setBaseContext(r210);
    L24:
        View r110 = this.f57568b;
        if (r110 == null) goto L27;
        PoolUtilKt.a(r110);
    L27:
        Triple<Boolean, String, ? extends Object> r111 = this.f57571e;
        if (r111 != null) goto L30;
    L43:
        if (r214 == null) goto L45;
        Unit r112 = r214.invoke(this.f57568b, Boolean.TRUE, this.f57571e);
    L45:
        if (r100 == null) goto L47;
        i(r100);
    L47:
        k(r213, "1");
        if (GameCpTargetUtils.c() == false) goto L196;
        View r113 = this.f57568b;
        if (r113 != null) goto L52;
        return;
    L52:
        if ((r113 instanceof HybridCard) == false) goto L198;
        com.bytedance.android.gamecp.host_api.a.b().getBrowserService().e0((HybridCard) r113);
        return;
    L198:
        return;
    L196:
        return;
    L30:
        if ((r111.getThird() instanceof GameCpAnnieLynxViewClient) == false) goto L36;
        Object r114 = r111.getThird();
        if (r114 == null) goto L35;
        ((GameCpAnnieLynxViewClient) r114).updateParams(d(r212));
        goto L43
    L35:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.gamecp.hybrid_impl.lynx.GameCpAnnieLynxViewClient");
    L36:
        Object r115 = r111.getThird();
        if ((r115 instanceof r1) == false) goto L40;
        r101 = r115;
    L40:
        r1 r116 = (r1) r101;
        if (r116 == null) goto L43;
        Map<? extends String, ? extends Object> r117 = d(r212);
        Intrinsics.checkNotNullParameter(r117, "newParams");
        r116.f57646d.putAll(r117);
        LocalTestManager.a(new Class[]{uv.a.class});
        goto L43
    L55:
        k(r213, "0");
        if (r211.length() != 0) goto L58;
        boolean r118 = true;
    L59:
        if (r118 == false) goto L61;
        return;
    L61:
        if (r214 == null) goto L64;
        ((ArrayList) this.f57575i).add(r214);
    L64:
        if (this.f57569c == true) goto L199;
        new MutableContextWrapper(r210).getBaseContext();
        if (n4.f561358a.getValue().g() == false) goto L70;
        Activity r119 = com.bytedance.android.gamecp.host_api.a.b().getHostAppService().getMainActivity();
        if (r119 == null) goto L70;
        new MutableContextWrapper(r119).getBaseContext();
    L70:
        Map<String, Object> r120 = d(r212);
        this.f57569c = true;
        if (wu.m1.f561349a.getValue().booleanValue() == true) goto L73;
        String r121 = r211;
        long r122 = 0;
    L137:
        if (p3.f561369a.getValue().e() == true) goto L163;
        final HybridCard r123 = com.bytedance.android.gamecp.host_api.a.b().getBrowserService().getHybridCard(r210, UriProtector.parse(r121), new c(this, r120, r100, r121));
        this.f57568b = r123;
        if ((r123 instanceof HybridCard) == false) goto L162;
        if (r123 == null) goto L161;
        if (GameCpTargetUtils.c() == false) goto L147;
        if (this.f57568b == null) goto L147;
        com.bytedance.android.gamecp.host_api.a.b().getBrowserService().e0(r123);
        this.f57571e = f(r120);
    L147:
        if (((Boolean) this.f57576j.getValue()).booleanValue() == false) goto L149;
        UtilityKotlinExtentionsKt.g(0, false, true, new HybridCardRecyclePool$createHybridCard$8(r123, r100), 3);
    L153:
        if (GameCpTargetUtils.h() == true) goto L155;
        com.bytedance.android.gamecp.host_api.a.b().getBrowserService().e0(r123);
    L155:
        Iterator r124 = ((ArrayList) this.f57575i).iterator();
    L157:
        if (r124.hasNext() == false) goto L159;
        ((Function3) r124.next()).invoke(this.f57568b, Boolean.FALSE, this.f57571e);
        goto L157
    L159:
        ((ArrayList) this.f57575i).clear();
        goto L162
    L149:
        if (r100 != null) goto L151;
        r100 = MapsKt.emptyMap();
    L151:
        r123.load(null, r100);
        goto L153
    L161:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.annie.api.card.HybridCard");
    L162:
        j(r121, "dygame_card_create", "webcast", null);
    L186:
        Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L182
        Long r126 = com.bytedance.android.gamecp.host_api.a.b().getBrowserService().getGeckoLatestChannelVersion("game_promote_tools_lynx_douyin");     // Catch: Throwable -> L182
        if (r126 == null) goto L179;
        long r127 = r126.longValue();     // Catch: Throwable -> L182
    L180:
        ((Keva) this.f57572f.getValue()).storeLong("gecko_version_key", r127);     // Catch: Throwable -> L182
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L182
    L184:
        this.f57569c = false;
        return;
    L179:
        r127 = r122;
    L182:
        th = move-exception;
        Result.Companion r128 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L184
    L163:
        jw.c r129 = (jw.c) xr.s.a(jw.c.class);
        if (r129 == null) goto L170;
        if (r100 == null) goto L168;
        Map r130 = MapsKt.plus(r100, r120);
        if (r130 == null) goto L168;
    L169:
        AnnieXLynxView r131 = jw.c.a.a(r129, r210, r121, r130, GamePromoteIconLocation.GAME_PROMOTE_ICON.getLocation(), new HybridCardRecyclePool$createHybridCard$10(this), new b(this, r100, r121));
    L171:
        this.f57568b = r131;
        Iterator r132 = ((ArrayList) this.f57575i).iterator();
    L173:
        if (r132.hasNext() == false) goto L175;
        ((Function3) r132.next()).invoke(this.f57568b, Boolean.FALSE, this.f57571e);
        goto L173
    L175:
        ((ArrayList) this.f57575i).clear();
        j(r121, "dygame_card_create", "anniex", null);
    L168:
        r130 = MapsKt.emptyMap();
        goto L169
    L170:
        r131 = null;
        goto L171
    L73:
        String r133 = UriProtector.getQueryParameter(UriProtector.parse(r211), "url");
        Iterator<Map.Entry<String, com.bytedance.android.gamecp.common.setting.config.r0>> r134 = wu.s0.f561384a.getValue().entrySet().iterator();
    L75:
        if (r134.hasNext() == false) goto L84;
        Map.Entry<String, com.bytedance.android.gamecp.common.setting.config.r0> r135 = r134.next();
        String r136 = r135.getKey();
        com.bytedance.android.gamecp.common.setting.config.r0 r137 = r135.getValue();
        if (r133 == null) goto L75;
        if (StringsKt.contains$default(r133, r136, false, 2, null) != true) goto L75;
        String r138 = r137.a();
        String r139 = r137.b();
        if (r139 == null) goto L83;
        Long r140 = Long.valueOf(CastLongProtector.parseLong(r139));
    L85:
        yr.c.e(this.f57567a, "从setting获取的channel为 " + r138 + " gecko_version为  " + r140);
        if (r133 != null) goto L88;
        String r141 = "";
    L89:
        Uri r142 = UriProtector.parse(r141);
        String r143 = UriProtector.getQueryParameter(r142, "gcp_channel");
        String r144 = UriProtector.getQueryParameter(r142, "gcp_min_gecko_version");
        if (r144 == null) goto L92;
        Long r145 = Long.valueOf(CastLongProtector.parseLong(r144));
    L93:
        yr.c.e(this.f57567a, "从服务端获取的channel为 " + r143 + " gecko_version为  " + r145);
        if (r140 == null) goto L97;
        if (r145 == null) goto L97;
        r140 = Long.valueOf(Math.max(r140.longValue(), r145.longValue()));
    L102:
        if (r138 != null) goto L104;
        r138 = r143;
    L104:
        if (r138 != null) goto L106;
    L109:
        boolean r146 = true;
    L110:
        if (r146 == true) goto L129;
        if (r140 == null) goto L129;
        Long r147 = com.bytedance.android.gamecp.host_api.a.b().getBrowserService().getGeckoLatestChannelVersion(r138);
        if (r147 == null) goto L116;
        long r148 = r147.longValue();
    L117:
        yr.c.e(this.f57567a, "本地讲解卡资源的版本为" + r148);
        com.bytedance.android.gamecp.common.setting.config.i1 r149 = wu.c.f561287a.getValue();
        if (r149 != null) goto L120;
    L126:
        r122 = 0;
        if (r148 >= r140.longValue()) goto L130;
    L128:
        boolean r150 = true;
    L132:
        if (r150 == false) goto L134;
        String r151 = w36.a.b(UriProtector.parse(r211), "url").buildUpon().appendQueryParameter("url", UriProtector.parse(r133).buildUpon().appendQueryParameter("only_online", "1").build().toString()).build().toString();
        HashMap<String, String> r152 = GamecpTracker.f56755a;
        GamecpTracker.B("dygame_tech_detail_lynx_data_from", MapsKt.mapOf(new Pair[]{TuplesKt.to("data_source", "1"), TuplesKt.to("url", UriProtector.parse(r133).getPath() + "require_min_version=" + r140)}));
        yr.c.e(this.f57567a, "cdn跳转");
    L135:
        r121 = r151;
        goto L137
    L134:
        HashMap<String, String> r153 = GamecpTracker.f56755a;
        GamecpTracker.B("dygame_tech_detail_lynx_data_from", MapsKt.mapOf(new Pair[]{TuplesKt.to("data_source", "0"), TuplesKt.to("url", UriProtector.parse(r133).getPath() + "require_min_version=" + r140)}));
        yr.c.e(this.f57567a, "缓存跳转");
        r151 = r211;
    L130:
        r150 = false;
        goto L132
    L120:
        if (r149.e() != true) goto L126;
        r122 = 0;
        if (r148 == 0) goto L130;
        if (r148 >= r140.longValue()) goto L130;
    L116:
        r148 = 0;
    L129:
        r122 = 0;
        goto L130
    L106:
        if (r138.length() == 0) goto L109;
        r146 = false;
    L97:
        if (r140 != null) goto L102;
        if (r145 == null) goto L101;
        r140 = r145;
        goto L102
    L101:
        r140 = null;
        goto L102
    L92:
        r145 = null;
        goto L93
    L88:
        r141 = r133;
        goto L89
    L83:
        r140 = null;
        goto L85
    L84:
        r138 = null;
        r140 = null;
        goto L85
    L199:
        return;
    L58:
        r118 = false;
        goto L59
    L5:
        r102 = null;
        goto L7
    }
}
