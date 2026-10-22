package com.bytedance.android.live.profit.player;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/profit/player/LynxAlphaPlayerWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LynxAlphaPlayerWidget extends LiveRecyclableWidget {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f88278i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HybridCard f88279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.live.profit.player.a f88280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<com.bytedance.android.live.profit.player.a> f88281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f88282d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f88283e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public q f88284f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ca0.q f88285g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f88286h;

    public static final class a {
    }

    public static final class b implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerService f88287a;

        public b(PlayerService r100) {
            this.f88287a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.f88287a.f88308f.onNext(sh6.a.f541970a);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxAlphaPlayerWidget f88288a;

        public c(LynxAlphaPlayerWidget r100) {
            this.f88288a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Object r111 = sh6.c.b((sh6.b) r110);
            if (r111 == null) goto L25;
            com.bytedance.android.live.profit.player.a r112 = (com.bytedance.android.live.profit.player.a) r111;
            LynxAlphaPlayerWidget r100 = this.f88288a;
            if (r100.f88279a != null) goto L23;
            long r101 = System.currentTimeMillis();
            String r102 = (String) r.f88360b.getValue(null, r.f88359a[0]);
            ALogger.w("LynxAlphaPlayerWidget", "load card");
            if (r100.context != null) goto L10;
            ALogger.w("LynxAlphaPlayerWidget", "context is null");
            return;
        L10:
            if (r102.length() != 0) goto L12;
            boolean r103 = true;
        L13:
            if (r103 == false) goto L15;
            r100.yq("schema is empty");
            return;
        L15:
            com.bytedance.android.annie.ng.c r104 = Annie.with(r100.context, UriProtector.parse(r102), "webcast");
            h r105 = new h(r100);
            r104.getClass();
            Intrinsics.checkNotNullParameter(r105, "commonLifecycle");
            r104.f39655d = r105;
            HybridCard r106 = r104.a();
            if (r106 != null) goto L18;
            r100.yq("createCard returned null");
            return;
        L18:
            r106.registerMethod("dressPlayFinish", new f(r100));
            r106.registerMethod("dressPlayClick", new g(r100));
            r100.f88280b = r112;
            a7.a.a(r106, null, MapsKt.mapOf(TuplesKt.to("initPlayData", r100.Aq(r112))), 1);
            r100.f88279a = r106;
            q r113 = new q(0);
            long r107 = System.currentTimeMillis();
            r113.f88355a = r101;
            r113.f88356b = r107;
            Unit r108 = Unit.INSTANCE;
            r100.f88284f = r113;
            IGiftService r114 = (IGiftService) jc1.k.f(IGiftService.class);
            if (r114 == null) goto L29;
            ca0.o r115 = r114.getLiveRevenueEventCenter();
            if (r115 == null) goto L30;
            r115.h();
            return;
        L30:
            return;
        L29:
            return;
        L12:
            r103 = false;
            goto L13
        L23:
            ((ArrayList) r100.f88281c).add(r112);
            r100.wq();
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxAlphaPlayerWidget f88289a;

        public d(LynxAlphaPlayerWidget r100) {
            this.f88289a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            LynxAlphaPlayerWidget r102 = this.f88289a;
            int r103 = LynxAlphaPlayerWidget.f88278i;
            r102.xq(false, "cleanup timer");
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_lynx_alphaplayer;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        this.f88283e.clear();
        xq(false, "widget unload");
    }

    public final boolean wq() {
        HybridCard r100 = this.f88279a;
        if (r100 != null) goto L5;
    L13:
        return false;
    L5:
        if (this.f88280b != null) goto L13;
        if (((ArrayList) this.f88281c).size() <= 0) goto L13;
        com.bytedance.android.live.profit.player.a r101 = (com.bytedance.android.live.profit.player.a) ListProtector.remove(this.f88281c, 0);
        ALogger.w("LynxAlphaPlayerWidget", "playing dress " + r101);
        this.f88282d.clear();
        this.f88280b = r101;
        q r102 = this.f88284f;
        if (r102 == null) goto L11;
        r102.f88358d++;
    L11:
        r100.sendJsEvent("DressPlay", Aq(r101));
        return true;
    }

    public LynxAlphaPlayerWidget() {
        this.f88281c = new ArrayList();
        this.f88282d = new CompositeDisposable();
        this.f88283e = new CompositeDisposable();
    }

    public final JSONObject Aq(com.bytedance.android.live.profit.player.a r100) {
        Pair[] r101 = new Pair[5];
        r101[0] = TuplesKt.to("_playId", r100.f88313a);
        r101[1] = TuplesKt.to("centerY", Float.valueOf(s1.G(this.contentView.getHeight()) - r100.f88317e));
        r101[2] = TuplesKt.to("dressId", r100.f88314b);
        Handler r102 = UtilityKotlinExtentionsKt.f66103a;
        JSONObject r103 = new JSONObject();
        Map<String, c5> r104 = r100.f88315c;
        if (r104 == null) goto L8;
        Iterator<Map.Entry<String, c5>> r105 = r104.entrySet().iterator();
    L6:
        if (r105.hasNext() == false) goto L8;
        Map.Entry<String, c5> r106 = r105.next();
        String r107 = r106.getKey();
        c5 r108 = r106.getValue();
        r103.put(r107, tv5.a.a(GsonHelper.get(), r108));
    L8:
        Unit r109 = Unit.INSTANCE;
        r101[3] = TuplesKt.to("pieceValues", r103);
        r101[4] = TuplesKt.to("avatarThumb", r100.f88316d);
        return UtilityKotlinExtentionsKt.o(r101);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        ALogger.d("LynxAlphaPlayerWidget", "onInit");
        this.f88286h = System.currentTimeMillis();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        com.bytedance.android.live.profit.player.d r101 = yt0.c.h();
        if ((r101 instanceof PlayerService) == true) goto L5;
        r101 = null;
    L5:
        PlayerService r102 = (PlayerService) r101;
        if (r102 != null) goto L8;
        return;
    L8:
        RxUtilKt.c(r102.f88308f.observeOn(AndroidSchedulers.mainThread()).doOnDispose(new b(r102)).subscribe(new c(this)), this.f88283e);
    }

    public final void yq(String r100) {
        xq(true, "lynx container load failed: " + r100);
    }

    public final void xq(boolean r100, String r101) {
        HybridCard r102 = this.f88279a;
        if (r102 == null) goto L5;
        r102.release();
    L5:
        this.f88279a = null;
        View r103 = this.contentView;
        if (r103 == null) goto L23;
        ((ViewGroup) r103).removeAllViews();
        this.f88280b = null;
        this.f88284f = null;
        ca0.q r104 = this.f88285g;
        if (r104 == null) goto L10;
        r104.clearData();
    L10:
        this.f88285g = null;
        if (r100 == false) goto L16;
        ALogger.e("LynxAlphaPlayerWidget", "cleanup with failure: " + r101);
        Iterator<T> r105 = this.f88281c.iterator();
    L14:
        if (r105.hasNext() == false) goto L20;
        ((com.bytedance.android.live.profit.player.a) r105.next()).f88320h.invoke(new Throwable(r101));
    L20:
        this.f88282d.clear();
        ((ArrayList) this.f88281c).clear();
        return;
    L16:
        ALogger.w("LynxAlphaPlayerWidget", "cleanup: reason=" + r101);
        Iterator<T> r106 = this.f88281c.iterator();
    L18:
        if (r106.hasNext() == false) goto L20;
        ((com.bytedance.android.live.profit.player.a) r106.next()).f88319g.invoke();
        goto L18
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final void zq(boolean r100, String r101) {
        if (r100 == false) goto L9;
        ALogger.w("LynxAlphaPlayerWidget", "play finish successfully, playingData=" + this.f88280b);
        com.bytedance.android.live.profit.player.a r102 = this.f88280b;
        if (r102 == null) goto L14;
        Function0<Unit> r103 = r102.f88319g;
        if (r103 == null) goto L14;
        Unit r104 = r103.invoke();
    L14:
        ca0.q r105 = this.f88285g;
        if (r105 == null) goto L17;
        r105.stop();
    L17:
        LinkedHashMap r106 = new LinkedHashMap();
        r106.put("stay_room_duration", String.valueOf((System.currentTimeMillis() - this.f88286h) / ((long) 1000)));
        if (r100 == false) goto L20;
        String r107 = "0";
    L21:
        r106.put("lynx_load_failed", r107);
        if (r101 != null) goto L24;
        r101 = "";
    L24:
        r106.put("error_msg", r101);
        com.bytedance.android.live.profit.player.a r108 = this.f88280b;
        if (r108 == null) goto L27;
        r106.put("dress_id", r108.f88314b);
    L27:
        q r109 = this.f88284f;
        if (r109 == null) goto L30;
        r106.put("lynx_init_time", String.valueOf(r109.f88356b - r109.f88355a));
        r106.put("lynx_loaded_time", String.valueOf(r109.f88357c - r109.f88355a));
        r106.put("play_times", String.valueOf(r109.f88358d));
        r106.put("total_play_time", String.valueOf(System.currentTimeMillis() - r109.f88355a));
    L30:
        com.bytedance.android.livesdk.revenue.service.performance.c r110 = (com.bytedance.android.livesdk.revenue.service.performance.c) vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.c.class);
        r106.put("cpu_rate", String.valueOf(r110.getCpuRate()));
        r106.put("gpu_used", String.valueOf(r110.getGpuUsed()));
        r106.put("mem_pss_total", String.valueOf(r110.getPssTotal() / ((long) 1024)));
        r106.put(IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE, String.valueOf(r110.getTemperature()));
        r106.put("ui_fps", String.valueOf(r110.getFps()));
        r106.put(IPerformanceStrategyManager.KEY_DOUBLE_UI_STALL_RATE, String.valueOf(r110.F3()));
        r106.put(IPerformanceManager.Battery.battery_current, String.valueOf(r110.ql()));
        ca0.q r111 = this.f88285g;
        if (r111 == null) goto L37;
        Map<String, String> r112 = r111.c();
        if (r112 == null) goto L37;
        r106.putAll(r112);
        ca0.q r113 = this.f88285g;
        if (r113 == null) goto L37;
        r113.clearData();
    L37:
        mz0.n r114 = new mz0.n();
        Map<String, String> r115 = r114.f516447a;
        Intrinsics.checkNotNullParameter(r115, "map");
        Intrinsics.checkNotNullParameter(r106, "map");
        r115.putAll(r106);
        mz0.m r116 = new mz0.m();
        r116.b(LogCommon.ROOM);
        ((ArrayList) r114.f516448b).addAll(r116.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r117 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r118 = com.bytedance.android.scope.m.b(r117).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r118);
        ((mz0.i) ((f80.a) r118)).w3("livesdk_rd_lynx_alpha_player_metrics", r114.f516447a, r114.f516448b);
        IGiftService r119 = (IGiftService) jc1.k.f(IGiftService.class);
        if (r119 == null) goto L42;
        ca0.o r120 = r119.getLiveRevenueEventCenter();
        if (r120 == null) goto L42;
        r120.a();
    L42:
        this.f88280b = null;
        if (wq() == false) goto L45;
        return;
    L45:
        if (r.a() <= 0) goto L48;
        RxUtilKt.c(Observable.timer(r.a(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this)), this.f88282d);
        return;
    L48:
        if (r.a() != 0) goto L53;
        xq(false, "cleanup timer");
        return;
    L53:
        return;
    L20:
        r107 = "1";
        goto L21
    L9:
        ALogger.e("LynxAlphaPlayerWidget", "play failed, playingData=" + this.f88280b + ", msg=" + r101);
        com.bytedance.android.live.profit.player.a r121 = this.f88280b;
        if (r121 == null) goto L14;
        Function1<Throwable, Unit> r122 = r121.f88320h;
        if (r122 == null) goto L14;
        Unit r123 = r122.invoke(new Throwable(r101));
        goto L14
    }
}
