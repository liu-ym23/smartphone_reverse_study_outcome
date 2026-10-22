package com.bytedance.android.livesdk.player;

import android.graphics.RectF;
import android.text.TextUtils;
import com.bytedance.android.livesdk.player.monitor.LivePlayerExceptionLogger;
import com.bytedance.android.livesdkapi.host.HostDataKey;
import com.bytedance.android.livesdkapi.host.ILivePlayerHostService;
import com.bytedance.android.livesdkapi.log.ILivePlayerAppLogger;
import com.bytedance.android.livesdkapi.model.PlayerConfig;
import com.bytedance.android.livesdkapi.model.PlayerMonitorConfig;
import com.bytedance.android.livesdkapi.model.PlayerOptimizeConfig;
import com.bytedance.android.livesdkapi.model.PlayerPerformanceConfig;
import com.bytedance.android.livesdkapi.player.ILivePlayerEventController;
import com.bytedance.android.livesdkapi.player.LivePlayerEventListenerAdapter;
import com.bytedance.android.livesdkapi.player.PlayerTaskManager;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerSpmLogger;
import com.bytedance.android.livesdkapi.roomplayer.IPlayerLogger;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.MutexImpl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class LivePlayerAppLogger extends LivePlayerEventListenerAdapter implements ILivePlayerAppLogger {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f154874m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f154875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f154876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f154877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f154878d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LivePlayerAppLogger$stopObserver$1 f154879e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LivePlayerAppLogger$releaseObserver$1 f154880f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LivePlayerAppLogger$startPullObserver$1 f154881g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LivePlayerAppLogger$firstFrameObserver$1 f154882h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CoroutineScope f154883i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MutexImpl f154884j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Job f154885k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LivePlayerClient f154886l;

    public static final class a {
    }

    public static final class b implements Callable<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f154887a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, String> f154888b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function1<Map<String, String>, Unit> f154889c;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            ILivePlayerHostService r100 = LivePlayerService.INSTANCE.hostService();
            if (r100 == null) goto L5;
            r100.teaLog(this.f154887a, this.f154888b);
        L5:
            Function1<Map<String, String>, Unit> r101 = this.f154889c;
            if (r101 == null) goto L9;
            Unit r102 = r101.invoke(this.f154888b);
        L9:
            return Boolean.TRUE;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Boolean call() {
            return call();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(String r100, Map<String, String> r101, Function1<? super Map<String, String>, Unit> r102) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            Intrinsics.checkNotNullParameter(r101, "params");
            this.f154887a = r100;
            this.f154888b = r101;
            this.f154889c = r102;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdkapi.log.ILivePlayerAppLogger
    public final void launch() {
        if (((PlayerMonitorConfig) LivePlayerService.INSTANCE.getConfig(PlayerMonitorConfig.class)).getMonitorListenersOpt() == false) goto L5;
        ILivePlayerEventController.DefaultImpls.addEventListener$default(this.f154886l.getEventController(), this, false, 2, null);
        return;
    L5:
        IRoomEventHub r100 = this.f154886l.getEventHub();
        r100.getStartPullStream().observeForever(this.f154881g);
        r100.getStopped().observeForever(this.f154879e);
        r100.getReleased().observeForever(this.f154880f);
    }

    @Override // com.bytedance.android.livesdkapi.player.LivePlayerEventListenerAdapter, com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onFirstFrame() {
        LivePlayerAppLogger$firstFrameObserver$1 r100 = this.f154882h;
        Boolean r101 = Boolean.TRUE;
        r100.getClass();
        if (r101 == null) goto L6;
        Intrinsics.areEqual(r101, Boolean.FALSE);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.player.LivePlayerEventListenerAdapter, com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onRelease() {
        LivePlayerAppLogger$releaseObserver$1 r100 = this.f154880f;
        Boolean r101 = Boolean.TRUE;
        r100.getClass();
        if (r101 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r101, Boolean.FALSE) == true) goto L10;
        a(r100.f154890a);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.player.LivePlayerEventListenerAdapter, com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onStartPul() {
        this.f154881g.a(Boolean.TRUE);
    }

    @Override // com.bytedance.android.livesdkapi.player.LivePlayerEventListenerAdapter, com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onStop() {
        LivePlayerAppLogger$stopObserver$1 r100 = this.f154879e;
        Boolean r101 = Boolean.TRUE;
        r100.getClass();
        if (r101 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r101, Boolean.FALSE) == true) goto L10;
        a(r100.f154892a);
        return;
    }

    /* JADX WARN: Type inference failed for: r2v8, types: [com.bytedance.android.livesdk.player.LivePlayerAppLogger$firstFrameObserver$1] */
    public LivePlayerAppLogger(LivePlayerClient r100) {
        Intrinsics.checkNotNullParameter(r100, "client");
        this.f154886l = r100;
        this.f154876b = new ConcurrentHashMap();
        this.f154877c = new ConcurrentHashMap();
        this.f154878d = LazyKt.lazy(LivePlayerAppLogger$performanceConfig$2.INSTANCE);
        this.f154879e = new LivePlayerAppLogger$stopObserver$1(this);
        this.f154880f = new LivePlayerAppLogger$releaseObserver$1(this);
        this.f154881g = new LivePlayerAppLogger$startPullObserver$1(this);
        this.f154882h = new LivePlayerAppLogger$firstFrameObserver$1();
        this.f154883i = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        this.f154884j = kotlinx.coroutines.sync.b.a();
    }

    public static final void a(final LivePlayerAppLogger r110) {
        if (r110.f154875a != 0) goto L6;
        return;
    L6:
        if (new Random().nextInt(100) >= ((PlayerPerformanceConfig) r110.f154878d.getValue()).getSampleValue()) goto L8;
        boolean r100 = true;
    L9:
        if (r100 == false) goto L34;
        com.bytedance.android.livesdk.player.monitor.e r101 = r110.f154886l.getCostTracer();
        if (r101 == null) goto L34;
        HashMap r102 = new HashMap();
        Iterator<T> r103 = r101.f155840a.values().iterator();
    L15:
        if (r103.hasNext() == false) goto L18;
        com.bytedance.android.livesdk.player.monitor.j r104 = (com.bytedance.android.livesdk.player.monitor.j) r103.next();
        r102.put(r104.f155898a, String.valueOf(r104.f155902e));
        goto L15
    L18:
        if ((!r101.f155841b.isEmpty()) == false) goto L26;
        int r105 = r101.f155841b.size();
        Iterator<T> r106 = r101.f155841b.values().iterator();
        String r107 = "undefined";
        long r108 = 0;
        long r109 = 0;
    L21:
        if (r106.hasNext() == false) goto L25;
        com.bytedance.android.livesdk.player.monitor.j r111 = (com.bytedance.android.livesdk.player.monitor.j) r106.next();
        long r112 = r111.f155902e;
        r108 = r108 + r112;
        if (r112 <= r109) goto L21;
        r107 = r111.f155898a;
        r109 = r112;
        goto L21
    L25:
        r102.put("sei_handle_count", String.valueOf(r105));
        r102.put("sei_avg_handle_cost", String.valueOf((r108 * 1.0f) / r105));
        r102.put("sei_max_handle_cost", r107);
    L26:
        com.bytedance.android.livesdk.player.monitor.f r113 = r110.f154886l.getLivePlayerLogger$live_player_impl_saasRelease();
        if (r113 == null) goto L31;
        com.bytedance.android.livesdk.player.monitor.g r114 = r113.f155847f;
        if (r114 == null) goto L31;
        r102.putAll(r114.b());
    L31:
        ILivePlayerHostService r115 = LivePlayerService.INSTANCE.hostService();
        if (r115 == null) goto L34;
        r115.teaLog("live_player_performance", r102);
    L34:
        LinkedHashMap r116 = new LinkedHashMap();
        r116.put("vr_fov", String.valueOf(r110.f154886l.getVRFov()));
        if (((PlayerConfig) LivePlayerService.INSTANCE.getConfig(PlayerConfig.class)).getEndLogParamsEnable() == false) goto L38;
        LivePlayerClient r117 = r110.f154886l;
        HashMap<String, String> r118 = new HashMap();
        Unit r119 = Unit.INSTANCE;
        r117.injectAppLoggerParams("live_player_play_end", r118);
    L38:
        if ((!r110.f154876b.isEmpty()) == false) goto L40;
        r116.putAll(r110.f154876b);
    L40:
        r110.f154886l.assembleVolumeParams("ttliveplayer_player_end", r116);
        r110.teaLog("live_player_play_end", r116, new LivePlayerAppLogger$logPlayEnd$2(r110));
        r110.f154886l.logEnd();
        r110.f154875a = 0;
        return;
    L8:
        r100 = false;
        goto L9
    }

    @Override // com.bytedance.android.livesdkapi.log.ILivePlayerAppLogger
    public final String getEndParam(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        String r101 = this.f154876b.get(r100);
        if (r101 != null) goto L6;
        return "";
    L6:
        return r101;
    }

    @Override // com.bytedance.android.livesdkapi.log.ILivePlayerAppLogger
    public final String getStartParam(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        String r101 = this.f154877c.get(r100);
        if (r101 != null) goto L6;
        return "";
    L6:
        return r101;
    }

    @Override // com.bytedance.android.livesdkapi.log.ILivePlayerAppLogger
    public final void injectPlayEndParams(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f154876b.putAll(r100);
    }

    @Override // com.bytedance.android.livesdkapi.log.ILivePlayerAppLogger
    public final void injectPlayStartParams(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        LinkedHashMap r101 = new LinkedHashMap();
        if ((!r100.isEmpty()) == false) goto L19;
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L12;
        Map.Entry<String, String> r103 = r102.next();
        String r104 = r103.getKey();
        String r105 = r103.getValue();
        if (r104 == null) goto L6;
        if (r105 != null) goto L11;
        r105 = "";
    L11:
        r101.put(r104, r105);
        goto L6
    L12:
        this.f154877c.putAll(r101);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.log.ILivePlayerAppLogger
    public final void injectPlayEndParam(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f154876b.put(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.log.ILivePlayerAppLogger
    public final void teaLog(String r110, Map<String, String> r111, Function1<? super Map<String, String>, Unit> r112) {
        Intrinsics.checkNotNullParameter(r110, "eventName");
        LinkedHashMap r100 = new LinkedHashMap();
        LivePlayerService r101 = LivePlayerService.INSTANCE;
        PlayerOptimizeConfig r102 = (PlayerOptimizeConfig) r101.getConfig(PlayerOptimizeConfig.class);
        com.bytedance.android.livesdk.player.monitor.f r103 = this.f154886l.getLivePlayerLogger$live_player_impl_saasRelease();
        if (r103 == null) goto L106;
        com.bytedance.android.livesdk.player.monitor.g r104 = r103.f155847f;
        if (r104 == null) goto L106;
        LivePlayerSpmLogger.Companion.getClass();
        boolean r105 = false;
        HashMap<String, String> r106 = null;
        Integer r107 = null;
        if (LivePlayerSpmLogger.access$getPlayerLoggerSimplifyV2$cp() == false) goto L67;
        r100.putAll(r104.assembleTeaParams());
        if (Intrinsics.areEqual(r110, "live_player_play_end") == false) goto L11;
    L12:
        HashMap r108 = com.bytedance.android.livesdk.player.monitor.g.f();
        ILivePlayerHostService r109 = r101.hostService();
        String r113 = "";
        if (r109 == null) goto L18;
        Object r114 = r109.getHostData(HostDataKey.NETWORK_QUALITY);
        if (r114 == null) goto L18;
        String r115 = r114.toString();
        if (r115 == null) goto L18;
    L19:
        r108.put("network_quality", r115);
        LiveRequest r116 = r104.f155858j.getPlayerContext().f154925a;
        if (r116 == null) goto L23;
        String r117 = r116.getEnterLiveSource();
        if (r117 == null) goto L23;
    L24:
        r108.put("enter_live_source", r117);
        r108.put("dynamic_texture_render", String.valueOf(r104.f155858j.isDynamicOpenTextureRender()));
        Boolean r118 = r104.f155858j.getHasRoiSr();
        if (r118 == null) goto L34;
        r118.booleanValue();
        r108.put("roi_sr_used", "1");
        com.bytedance.android.livesdk.player.model.j r119 = r104.f155858j.getRoiSrParams();
        if (r119 == null) goto L32;
        RectF r120 = r119.f155651b;
        if (r120 == null) goto L32;
        String r121 = r120.toString();
        if (r121 == null) goto L32;
    L33:
        String r122 = (String) r108.put("roi_sr_region", r121);
    L32:
        r121 = "";
    L34:
        Boolean r123 = r104.f155858j.getSurfaceIntercepted();
        if (r123 == null) goto L37;
        r123.booleanValue();
        String r124 = (String) r108.put("surface_intercepted", "1");
    L37:
        Integer r125 = Integer.valueOf(com.bytedance.android.livesdk.player.monitor.d.b());
        r125.intValue();
        if (com.bytedance.android.livesdk.player.monitor.d.b() < 0) goto L40;
        boolean r126 = true;
    L41:
        if (r126 == true) goto L45;
        r125 = null;
    L45:
        if (r125 == null) goto L47;
        String r127 = (String) r108.put("v_codec2", String.valueOf(r125.intValue()));
    L47:
        Boolean r128 = r104.f155858j.context().is0vv();
        if (r128 == null) goto L53;
        String r129 = String.valueOf(r128.booleanValue());
        if (r129 == null) goto L53;
        r113 = r129;
    L53:
        r108.put("is_0vv", r113);
        Integer r130 = Integer.valueOf(com.bytedance.android.livesdk.player.monitor.d.b());
        r130.intValue();
        if (com.bytedance.android.livesdk.player.monitor.d.b() < 0) goto L56;
        r105 = true;
    L56:
        if (r105 == false) goto L58;
        r107 = r130;
    L58:
        if (r107 == null) goto L60;
        r108.put("v_codec2", String.valueOf(r107.intValue()));
    L60:
        ro2.b r131 = r104.f155858j.getFeatureManager();
        if (r131 == null) goto L63;
        r108.putAll(r131.b());
    L63:
        r108.putAll(r104.c());
        Map<String, String> r132 = r104.e();
        if (r132 == null) goto L66;
        r108.putAll(r132);
    L66:
        r100.putAll(r108);
        r100.putAll(r104.assembleLivePlayerParams());
        r100.putAll(r104.assembleTimeCostParams(this.f154875a));
        r100.putAll(this.f154876b);
        goto L106
    L40:
        r126 = false;
    L23:
        r117 = "";
    L18:
        r115 = "";
        goto L19
    L11:
        if (Intrinsics.areEqual(r110, "live_player_exception") == false) goto L106;
    L67:
        r100.putAll(r104.assembleFullParams());
        r100.putAll(r104.assembleLivePlayerParams());
        if (Intrinsics.areEqual(r110, "live_player_play_end") == false) goto L70;
    L71:
        r100.putAll(r104.assembleTimeCostParams(this.f154875a));
        r100.putAll(this.f154876b);
        int r133 = com.bytedance.android.livesdk.player.utils.c.f156213a;
        if ((!Intrinsics.areEqual(r110, "live_player_play_end")) == true) goto L84;
        String r134 = (String) r100.get("pull_duration");
        if (r134 != null) goto L77;
    L78:
        r105 = true;
    L79:
        if (r105 == true) goto L84;
        r100.put("preview_duration", String.valueOf(Math.max(0, CastLongProtector.parseLong(r134) - 0)));
        goto L84
    L77:
        if (r134.length() != 0) goto L79;
    L84:
        LivePlayerExceptionLogger r135 = this.f154886l.getLivePlayerLogger$live_player_impl_saasRelease().f155845d;
        if (r135 == null) goto L94;
        HashMap<String, String> r136 = r135.f155699g;
        if (r136 == null) goto L94;
        if ((!r136.isEmpty()) == false) goto L91;
        r106 = r136;
    L91:
        if (r106 == null) goto L94;
        r100.putAll(r106);
    L94:
        if (Intrinsics.areEqual(r110, "live_player_play_start") == false) goto L97;
        r100.putAll(this.f154877c);
    L97:
        if (r102.getAssembleNQEParams() == false) goto L106;
        JSONObject r137 = po2.f.a();
        Iterator<String> r138 = r137.keys();
    L100:
        if (r138.hasNext() == false) goto L106;
        String r139 = r138.next();
        if (TextUtils.isEmpty(r139) == true) goto L100;
        if (TextUtils.isEmpty(r137.optString(r139)) == true) goto L100;
        r100.put(r139.toString(), r137.optString(r139));
        goto L100
    L70:
        if (Intrinsics.areEqual(r110, "live_player_exception") == false) goto L94;
    L106:
        if (r111 == null) goto L109;
        r100.putAll(r111);
    L109:
        if (r102.getAsyncSendAppLog() == false) goto L111;
        PlayerTaskManager.inst().commit(new b(r110, r100, r112));
        return;
    L111:
        ILivePlayerHostService r140 = LivePlayerService.INSTANCE.hostService();
        if (r140 == null) goto L114;
        r140.teaLog(r110, r100);
    L114:
        if (r112 == null) goto L127;
        Unit r141 = r112.invoke(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.log.ILivePlayerAppLogger
    public final void logResolutionChange(String r100, String r101, String r110, Map<String, String> r111) {
        Intrinsics.checkNotNullParameter(r100, "oldResolution");
        Intrinsics.checkNotNullParameter(r101, "newResolution");
        Intrinsics.checkNotNullParameter(r110, "reason");
        HashMap r102 = new HashMap();
        PlayerResolution.Item r103 = PlayerResolution.Item;
        r102.put("old_resolution_level", String.valueOf(r103.getItemBySdkKey(r100).getLevel()));
        r102.put("old_resolution_name", r103.getItemBySdkKey(r100).getName());
        r102.put("old_resolution_sdkkey", r100);
        r102.put("new_resolution_level", String.valueOf(r103.getItemBySdkKey(r101).getLevel()));
        r102.put("new_resolution_name", r103.getItemBySdkKey(r101).getName());
        r102.put("new_resolution_sdkkey", r101);
        r102.put("change_strategy", r110);
        if (r111 == null) goto L12;
        Iterator<Map.Entry<String, String>> r104 = r111.entrySet().iterator();
    L6:
        if (r104.hasNext() == false) goto L12;
        Map.Entry<String, String> r105 = r104.next();
        String r112 = r105.getKey();
        String r106 = r105.getValue();
        if (r112 == null) goto L6;
        if (r106 != null) goto L11;
        r106 = "";
    L11:
        r102.put(r112, r106);
    L12:
        HashMap r107 = new HashMap();
        r107.put("state_change_type", "resolution_change");
        r107.putAll(r102);
        LivePlayerSpmLogger.Companion.getClass();
        if (LivePlayerSpmLogger.access$getPlayerLoggerSimplifyV2$cp() == true) goto L15;
        ILivePlayerAppLogger.DefaultImpls.teaLog$default(this, "ttliveplayer_state_change", r107, null, 4, null);
    L15:
        IPlayerLogger r108 = this.f154886l.logger();
        if (r108 == null) goto L24;
        HashMap r109 = new HashMap();
        r109.put("state_change_info", r107.toString());
        Unit r113 = Unit.INSTANCE;
        ILivePlayerSpmLogger.DefaultImpls.logLifeCycle$default(r108, "report ttliveplayer_state_change", r109, false, 4, null);
        return;
    }
}
