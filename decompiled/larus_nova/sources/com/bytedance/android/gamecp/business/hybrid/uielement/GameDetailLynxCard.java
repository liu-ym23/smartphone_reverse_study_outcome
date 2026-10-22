package com.bytedance.android.gamecp.business.hybrid.uielement;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.gamecp.business.hybrid.GameDetailHybridCardPool;
import com.bytedance.android.gamecp.business.hybrid.GameDetailLynxConfigProvider;
import com.bytedance.android.gamecp.common.setting.config.GamePromoteIconLocation;
import com.bytedance.android.gamecp.common.setting.config.i1;
import com.bytedance.android.gamecp.common.setting.config.r0;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.common.utils.e0;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import wu.s0;
import wu.x2;
import xr.s;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0012B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/gamecp/business/hybrid/uielement/GameDetailLynxCard;", "Landroid/widget/FrameLayout;", "Lxr/c;", "Lcom/bytedance/android/gamecp/business/hybrid/uielement/a;", "cardLifeCycle", "", "setCardLifeCycle", "", "enabled", "setPreLoadEnabled", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameDetailLynxCard extends FrameLayout implements xr.c {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f55980m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f55981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f55982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, Integer> f55983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.gamecp.business.hybrid.uielement.a f55984d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, ? extends Object> f55985e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f55986f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f55987g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f55988h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f55989i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f55990j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function1<? super Triple<Boolean, ? extends GamePromoteIconLocation, String>, Unit> f55991k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.gamecp.common.track.monitor.a f55992l;

    public static final class a {
        public static String a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "schema");
            Uri r101 = UriProtector.parse(r100);
            String r102 = UriProtector.getQueryParameter(r101, "url");
            if (r102 != null) goto L6;
            r102 = "";
        L6:
            if (TextUtils.isEmpty(r102) == false) goto L9;
            return "";
        L9:
            return r101.buildUpon().clearQuery().toString() + "-" + UriProtector.parse(r102).buildUpon().clearQuery().toString();
        }
    }

    public static final class b implements ViewTreeObserver.OnScrollChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GameDetailLynxCard f55993a;

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            long r100 = System.currentTimeMillis();
            GameDetailLynxCard r101 = this.f55993a;
            if ((r100 - r101.f55982b) >= 300) goto L5;
            return;
        L5:
            r101.f55982b = r100;
        }

        public b(GameDetailLynxCard r100) {
            this.f55993a = r100;
        }
    }

    static {
    }

    public GameDetailLynxCard(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GameDetailLynxCard(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // xr.c
    public final void attachViewAppearObserver(View r100, Function2<? super Boolean, ? super Float, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "appearObserver");
        this.f55992l.attachViewAppearObserver(r100, r101);
    }

    @Override // xr.c
    public final void detachViewAppearObserver() {
        this.f55992l.detachViewAppearObserver();
    }

    @Override // xr.c
    public final boolean viewIsWillDetached() {
        return this.f55992l.viewIsWillDetached();
    }

    public final void d() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L35
        detachViewAppearObserver();     // Catch: Throwable -> L35
        this.f55982b = 0;     // Catch: Throwable -> L35
        View r101 = this.f55981a;     // Catch: Throwable -> L35
        if (r101 == null) goto L7;
        ViewTreeObserver r102 = r101.getViewTreeObserver();     // Catch: Throwable -> L35
        if (r102 == null) goto L7;
        r102.removeOnScrollChangedListener(this.f55988h);     // Catch: Throwable -> L35
    L7:
        View r103 = this.f55981a;     // Catch: Throwable -> L35
        if (r103 == null) goto L33;
        removeView(r103);     // Catch: Throwable -> L35
        if (this.f55987g == true) goto L12;
    L14:
        boolean r104 = false;
    L15:
        if (r104 == false) goto L19;
        String r105 = this.f55986f;     // Catch: Throwable -> L35
        if (r105 == null) goto L33;
        String r106 = UriProtector.getQueryParameter(UriProtector.parse(r105), "game_id");     // Catch: Throwable -> L35
        boolean r107 = GameDetailHybridCardPool.f55950a;     // Catch: Throwable -> L35
        GameDetailHybridCardPool.h(getContext(), r106, r105, this.f55981a);     // Catch: Throwable -> L35
        goto L33
    L19:
        View r108 = this.f55981a;     // Catch: Throwable -> L35
        if ((r108 instanceof HybridCard) == false) goto L28;
        if ((r108 instanceof HybridCard) == true) goto L24;
        r108 = null;
    L24:
        HybridCard r109 = (HybridCard) r108;     // Catch: Throwable -> L35
        if (r109 == null) goto L33;
        r109.release();     // Catch: Throwable -> L35
        goto L33
    L28:
        if ((r108 instanceof AnnieXLynxView) == true) goto L30;
        r108 = null;
    L30:
        AnnieXLynxView r110 = (AnnieXLynxView) r108;     // Catch: Throwable -> L35
        if (r110 == null) goto L33;
        r110.destroy();     // Catch: Throwable -> L35
        goto L33
    L12:
        if (((Boolean) GameDetailLynxConfigProvider.f55968b.getValue()).booleanValue() == false) goto L14;
        r104 = true;
    L33:
        this.f55981a = null;     // Catch: Throwable -> L35
        this.f55985e = null;     // Catch: Throwable -> L35
        this.f55983c.clear();     // Catch: Throwable -> L35
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L35
        return;
    L35:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static final void a(final GameDetailLynxCard r100) {
        r100.attachViewAppearObserver(r100.f55981a, new GameDetailLynxCard$registerScrollOrDrawListenerForLynxCard$1(r100));
        View r101 = r100.f55981a;
        if (r101 == null) goto L8;
        ViewTreeObserver r102 = r101.getViewTreeObserver();
        if (r102 == null) goto L9;
        r102.addOnScrollChangedListener(r100.f55988h);
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (x2.f561416a.getValue().booleanValue() == false) goto L14;
        if (r100 != null) goto L7;
    L9:
        if (r100 == null) goto L14;
        if (r100.getAction() != 1) goto L14;
        e("gamecpDetailTouchesEvents", MapsKt.mapOf(TuplesKt.to("eventType", "touchesEnded")));
        goto L14
    L7:
        if (r100.getAction() != 0) goto L9;
        e("gamecpDetailTouchesEvents", MapsKt.mapOf(TuplesKt.to("eventType", "touchesBegan")));
    L14:
        return super.dispatchTouchEvent(r100);
    }

    public final void f(Map<String, ? extends Object> r100) {
        Integer r101 = this.f55983c.get(this.f55990j);
        if (r101 != null) goto L6;
    L8:
        if (r101 != null) goto L11;
        return;
    L11:
        if (r101.intValue() != 2000) goto L23;
        View r102 = this.f55981a;
        if (r102 != null) goto L15;
        return;
    L15:
        if ((r102 instanceof HybridCard) == false) goto L17;
        ((HybridCard) r102).updateData(r100);
    L20:
        this.f55985e = null;
        return;
    L17:
        jw.c r103 = (jw.c) s.a(jw.c.class);
        if (r103 == null) goto L20;
        r103.updateData(r102, r100);
        goto L20
    L23:
        return;
    L6:
        if (r101.intValue() != 1000) goto L8;
        this.f55985e = r100;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
    }

    public final void setCardLifeCycle(com.bytedance.android.gamecp.business.hybrid.uielement.a r100) {
        Intrinsics.checkNotNullParameter(r100, "cardLifeCycle");
        this.f55984d = r100;
    }

    public final void setPreLoadEnabled(boolean r100) {
        this.f55987g = r100;
    }

    public final void c(Map<String, ? extends Object> r100, String r101) {
        if (r101 == null) goto L11;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        e(r101, e0.h(r100));     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Result.m9448boximpl(r103);
        return;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final <T> void e(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "data");
        View r102 = this.f55981a;
        if ((r102 instanceof HybridCard) == false) goto L11;
        if ((r102 instanceof HybridCard) == true) goto L7;
        r102 = null;
    L7:
        HybridCard r103 = (HybridCard) r102;
        if (r103 == null) goto L25;
        r103.sendJsEvent(r100, r101);
        return;
    L25:
        return;
    L11:
        if ((r101 instanceof Map) == false) goto L19;
        if ((r102 instanceof AnnieXLynxView) == true) goto L15;
        r102 = null;
    L15:
        AnnieXLynxView r104 = (AnnieXLynxView) r102;
        if (r104 == null) goto L27;
        JSONObject r105 = new JSONObject((Map) r101);
        int r106 = AnnieXLynxView.B;
        r104.O(r100, r105, true);
        return;
    L27:
        return;
    L19:
        if ((r102 instanceof AnnieXLynxView) == true) goto L21;
        r102 = null;
    L21:
        AnnieXLynxView r107 = (AnnieXLynxView) r102;
        if (r107 == null) goto L29;
        int r108 = AnnieXLynxView.B;
        r107.O(r100, r101, true);
        return;
    }

    public GameDetailLynxCard(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        this.f55992l = new com.bytedance.android.gamecp.common.track.monitor.a(0, false, 0.0f, false, null, 63);
        this.f55983c = new ConcurrentHashMap();
        this.f55988h = new b(this);
        this.f55990j = "";
    }

    public static void b(final GameDetailLynxCard r110, String r210, Map r211) {
        String r100 = r210;
        r110.getClass();
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r211, "renderData");
        if (TextUtils.isEmpty(r210) == false) goto L5;
        yr.c.b("GameDetailLynxCard", "schema: " + r100 + "  is empty");
        return;
    L5:
        boolean r101 = true;
        String r102 = "";
        if (((Boolean) GameDetailLynxConfigProvider.f55969c.getValue()).booleanValue() == true) goto L8;
        final String r111 = r100;
    L71:
        r110.f55986f = r111;
        if (r110.f55987g == true) goto L74;
    L76:
        boolean r103 = false;
    L78:
        if (r103 == false) goto L102;
        String r104 = a.a(r111);
        r110.f55990j = r104;
        if (TextUtils.isEmpty(r104) == true) goto L175;
        Context r105 = r110.getContext();
        if ((r105 instanceof Activity) == false) goto L85;
    L87:
        String r106 = UriProtector.getQueryParameter(UriProtector.parse(r111), "url");
        if (r106 == null) goto L91;
        r102 = r106;
    L91:
        String r107 = UriProtector.getQueryParameter(UriProtector.parse(r102), "game_id");
        String r108 = com.bytedance.android.gamecp.business.gamedetail.util.c.f55628a;
        final GamePromoteIconLocation r109 = com.bytedance.android.gamecp.business.gamedetail.util.c.b(r110.f55989i, r111);
        if (r110.f55981a != null) goto L101;
        r110.f55983c.put(r110.f55990j, 1000);
        boolean r112 = GameDetailHybridCardPool.f55950a;
        View r113 = GameDetailHybridCardPool.c(r105, r107, r111, r211, r109, new GameDetailLynxCard$loadNew$1(r110, r109), new GameDetailLynxCard$loadNew$2(r110, r111));
        r110.f55981a = r113;
        if (r113 != null) goto L96;
        return;
    L96:
        if ((r113 instanceof HybridCard) == false) goto L100;
        Triple r114 = com.bytedance.android.gamecp.business.gamedetail.util.c.c(r107, r111, r113);
        Function1<? super Triple<Boolean, ? extends GamePromoteIconLocation, String>, Unit> r115 = r110.f55991k;
        if (r115 == null) goto L100;
        Unit r116 = r115.invoke(r114);
    L100:
        r110.addView(r110.f55981a);
        return;
    L101:
        r110.f(r211);
        return;
    L85:
        if ((r105 instanceof ContextWrapper) == false) goto L87;
        r105 = ((ContextWrapper) r105).getBaseContext();
        goto L87
    L175:
        return;
    L102:
        String r117 = a.a(r111);
        if (TextUtils.isEmpty(r117) == true) goto L176;
        Integer r118 = r110.f55983c.get(r117);
        if (r118 != null) goto L109;
    L110:
        Integer r119 = r110.f55983c.get(r117);
        if (r119 != null) goto L114;
    L117:
        if (r101 == false) goto L144;
        r110.d();
        Context r120 = r110.getContext();
        if ((r120 instanceof Activity) == false) goto L121;
    L123:
        r110.f55983c.put(r117, 1000);
        if (d.a(r211, "GameDetailLynxCard") == false) goto L135;
        String r121 = com.bytedance.android.gamecp.business.gamedetail.util.c.f55628a;
        final GamePromoteIconLocation r122 = com.bytedance.android.gamecp.business.gamedetail.util.c.b(r110.f55989i, r111);
        jw.c r123 = (jw.c) s.a(jw.c.class);
        if (r123 == null) goto L131;
        if (r122 == null) goto L129;
        String r124 = r122.getLocation();
    L130:
        View r125 = jw.c.a.a(r123, r120, r111, r211, r124, new GameDetailLynxCard$loadOld$1(r110, r122), new com.bytedance.android.gamecp.business.hybrid.uielement.b(r110, r111, r117));
    L132:
        r110.f55981a = r125;
        if (r125 == null) goto L168;
        r110.addView(r125);
        return;
    L168:
        return;
    L129:
        r124 = null;
        goto L130
    L131:
        r125 = null;
        goto L132
    L135:
        HybridCard r126 = com.bytedance.android.gamecp.host_api.a.b().getBrowserService().getHybridCard(r120, UriProtector.parse(r111), new c(r110, r111, r117));
        r110.f55981a = r126;
        if ((r126 instanceof HybridCard) == true) goto L138;
        r126 = null;
    L138:
        if (r126 == null) goto L170;
        String r127 = com.bytedance.android.gamecp.business.gamedetail.util.c.f55628a;
        Triple r128 = com.bytedance.android.gamecp.business.gamedetail.util.c.c(r110.f55989i, r111, r126);
        Function1<? super Triple<Boolean, ? extends GamePromoteIconLocation, String>, Unit> r129 = r110.f55991k;
        if (r129 == null) goto L142;
        Unit r130 = r129.invoke(r128);
    L142:
        r126.load(null, r211);
        r110.addView(r126);
        return;
    L170:
        return;
    L121:
        if ((r120 instanceof ContextWrapper) == false) goto L123;
        r120 = ((ContextWrapper) r120).getBaseContext();
        goto L123
    L144:
        if (r211.isEmpty() == false) goto L146;
        yr.c.g("GameDetailLynxCard", "renderData is empty");
        return;
    L146:
        Integer r131 = r110.f55983c.get(r117);
        if (r131 != null) goto L150;
    L152:
        if (r131 != null) goto L155;
        return;
    L155:
        if (r131.intValue() != 2000) goto L174;
        r110.c(r211, "gamecpCardUpdateData");
        return;
    L174:
        return;
    L150:
        if (r131.intValue() != 1000) goto L152;
        r110.f55985e = r211;
        return;
    L114:
        if (r119.intValue() != 2000) goto L117;
    L116:
        r101 = false;
        goto L117
    L109:
        if (r118.intValue() == 1000) goto L116;
    L176:
        return;
    L74:
        if (((Boolean) GameDetailLynxConfigProvider.f55968b.getValue()).booleanValue() == false) goto L76;
        r103 = true;
        goto L78
    L8:
        String r132 = UriProtector.getQueryParameter(UriProtector.parse(r210), "url");
        Iterator<Map.Entry<String, r0>> r133 = s0.f561384a.getValue().entrySet().iterator();
    L10:
        if (r133.hasNext() == false) goto L19;
        Map.Entry<String, r0> r134 = r133.next();
        String r135 = r134.getKey();
        r0 r136 = r134.getValue();
        if (r132 == null) goto L10;
        if (StringsKt.contains$default(r132, r135, false, 2, null) != true) goto L10;
        String r137 = r136.a();
        String r138 = r136.b();
        if (r138 == null) goto L18;
        Long r139 = Long.valueOf(CastLongProtector.parseLong(r138));
    L20:
        yr.c.e("GameDetailLynxCard", "从setting获取的channel为 " + r137 + " gecko_version为  " + r139);
        if (r132 != null) goto L23;
        String r140 = "";
    L24:
        Uri r141 = UriProtector.parse(r140);
        String r142 = UriProtector.getQueryParameter(r141, "gcp_channel");
        String r143 = UriProtector.getQueryParameter(r141, "gcp_min_gecko_version");
        if (r143 == null) goto L27;
        Long r144 = Long.valueOf(CastLongProtector.parseLong(r143));
    L28:
        yr.c.e("GameDetailLynxCard", "从服务端获取的channel为 " + r142 + " gecko_version为  " + r144);
        if (r139 == null) goto L32;
        if (r144 == null) goto L32;
        r139 = Long.valueOf(Math.max(r139.longValue(), r144.longValue()));
    L37:
        if (r137 != null) goto L39;
        r137 = r142;
    L39:
        Lazy r145 = GameDetailLynxConfigProvider.f55967a;
        if (r137 != null) goto L42;
    L45:
        boolean r146 = true;
    L46:
        if (r146 == true) goto L65;
        if (r139 == null) goto L65;
        Long r147 = com.bytedance.android.gamecp.host_api.a.b().getBrowserService().getGeckoLatestChannelVersion(r137);
        if (r147 == null) goto L52;
        long r148 = r147.longValue();
    L53:
        yr.c.e("GameDetailLynxConfigProvider", "本地资源的版本为" + r148);
        i1 r149 = wu.c.f561287a.getValue();
        if (r149 == null) goto L63;
        if (r149.e() != true) goto L63;
        if (r148 == 0) goto L65;
        if (r148 >= r139.longValue()) goto L65;
    L64:
        boolean r150 = true;
    L67:
        if (r150 == false) goto L69;
        r100 = w36.a.b(UriProtector.parse(r210), "url").buildUpon().appendQueryParameter("url", UriProtector.parse(r132).buildUpon().appendQueryParameter("only_online", "1").build().toString()).build().toString();
        HashMap<String, String> r151 = GamecpTracker.f56755a;
        GamecpTracker.B("dygame_tech_detail_lynx_data_from", MapsKt.mapOf(new Pair[]{TuplesKt.to("data_source", "1"), TuplesKt.to("url", UriProtector.parse(r132).getPath() + "require_min_version=" + r139)}));
        yr.c.e("GameDetailLynxCard", "cdn跳转");
    L70:
        r111 = r100;
        goto L71
    L69:
        HashMap<String, String> r152 = GamecpTracker.f56755a;
        GamecpTracker.B("dygame_tech_detail_lynx_data_from", MapsKt.mapOf(new Pair[]{TuplesKt.to("data_source", "0"), TuplesKt.to("url", UriProtector.parse(r132).getPath() + "require_min_version=" + r139)}));
        yr.c.e("GameDetailLynxCard", "缓存跳转");
    L63:
        if (r148 >= r139.longValue()) goto L65;
    L52:
        r148 = 0;
    L65:
        r150 = false;
        goto L67
    L42:
        if (r137.length() == 0) goto L45;
        r146 = false;
    L32:
        if (r139 != null) goto L37;
        if (r144 == null) goto L36;
        r139 = r144;
        goto L37
    L36:
        r139 = null;
        goto L37
    L27:
        r144 = null;
        goto L28
    L23:
        r140 = r132;
        goto L24
    L18:
        r139 = null;
        goto L20
    L19:
        r137 = null;
        r139 = null;
        goto L20
    }

    public /* synthetic */ GameDetailLynxCard(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
