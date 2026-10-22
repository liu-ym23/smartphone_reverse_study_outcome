package com.bytedance.android.live.broadcastgame.opengame.sonicgame;

import android.content.Context;
import android.os.Bundle;
import androidx.collection.LruCache;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.opengame.openapi.g0;
import com.bytedance.android.live.broadcastgame.opengame.openapi.y;
import com.bytedance.android.live.broadcastgame.opengame.panel.FullScreenOpenPanel;
import com.bytedance.android.live.broadcastgame.opengame.panel.PanelType;
import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.android.live.broadcastgame.opengame.runtime.BootInfoService;
import com.bytedance.android.live.broadcastgame.opengame.runtime.LaunchMode;
import com.bytedance.android.live.broadcastgame.opengame.runtime.LiveBasePluginWithPanel;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.runtime.n;
import com.bytedance.android.live.broadcastgame.opengame.service.OpenPlatformMonitorService;
import com.bytedance.android.live.broadcastgame.opengame.sonicgame.checker.GameFpsMonitor;
import com.bytedance.android.live.broadcastgame.opengame.sonicgame.checker.PerformanceChecker;
import com.bytedance.android.live.broadcastgame.opengame.t;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.at0;
import com.bytedance.android.livesdk.config.fe0;
import com.bytedance.android.livesdk.config.ke0;
import com.bytedance.android.livesdk.config.me0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdp.bdpbase.core.BdpStartUpParam;
import com.bytedance.bdp.bdpbase.core.IBdpAppInstance;
import com.bytedance.bdp.bdpbase.core.container.BdpAppContainer;
import com.bytedance.bdp.live.livecontainer.base.schema.LiveSchemaInfo;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class SonicGamePlugin extends LiveBasePluginWithPanel implements f {
    public static final /* synthetic */ int L = 0;
    public volatile boolean A;
    public volatile String B;
    public long C;
    public long D;
    public k E;
    public final boolean F;
    public final Lazy G;
    public boolean H;
    public final SonicGamePlugin$liveLifeCycle$1 I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public com.bytedance.android.live.broadcastgame.opengame.panel.h f61011J;
    public final PluginContext K;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f61012q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public na4.b f61013r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f61014s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public SonicState f61015t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final com.bytedance.android.live.broadcastgame.openplatform.miniapp.b f61016u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f61017v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f61018w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f61019x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final List<Class<Object>> f61020y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public volatile com.bytedance.android.live.broadcastgame.opengame.sonicgame.a f61021z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/sonicgame/SonicGamePlugin$SonicState;", "", "RESUME", "PAUSE", "DESTROY", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum SonicState extends Enum<SonicState> {
        public static final SonicState DESTROY = null;
        public static final SonicState PAUSE = null;
        public static final SonicState RESUME = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SonicState[] f61022a = null;

        static {
            SonicState r100 = new SonicState("RESUME", 0);
            RESUME = r100;
            SonicState r101 = new SonicState("PAUSE", 1);
            PAUSE = r101;
            SonicState r102 = new SonicState("DESTROY", 2);
            DESTROY = r102;
            f61022a = new SonicState[]{r100, r101, r102};
        }

        public static SonicState valueOf(String r100) {
            return (SonicState) r27.a.a(SonicState.class, r100);
        }

        public static SonicState[] values() {
            return (SonicState[]) f61022a.clone();
        }

        public SonicState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b implements com.bytedance.bdp.live.livecontainer.sonicgame.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SonicGamePlugin f61023a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ n f61024b;

        @Override // na4.d
        public final void a(String r100, com.bytedance.bdp.live.livecontainer.sonicgame.h r101) {
            Intrinsics.checkNotNullParameter(r101, "instance");
        }

        @Override // na4.d
        public final void b() {
        }

        @Override // na4.d
        public final void onFirstFrame() {
        }

        public b(SonicGamePlugin r100, n r101) {
            this.f61023a = r100;
            this.f61024b = r101;
        }

        @Override // na4.d
        public final void onFail(String r100, String r110) {
            int r101 = q.f60744a;
            q.f("SonicGamePlugin", new Object[]{"onDownloadFail, appId: ", r100, ", errorMsg: ", r110});
            ((OpenPlatformMonitorService) this.f61023a.K.o(OpenPlatformMonitorService.class)).a("ttlive_open_platform_resource_download", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, 1, 1, r110).c();
            n r102 = this.f61024b;
            if (r102 == null) goto L6;
            r102.n(r100, r110, "Download");
            return;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SonicGamePlugin f61025a;

        public c(SonicGamePlugin r100) {
            this.f61025a = r100;
        }
    }

    public static final class d implements com.bytedance.android.live.broadcastgame.opengame.panel.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SonicGamePlugin f61026a;

        @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
        public final void a() {
        }

        @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
        public final void b() {
        }

        @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
        public final void c() {
            this.f61026a.u(SonicState.RESUME, true);
        }

        @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
        public final void onBackPressed() {
            this.f61026a.K.f60809m.getClass();
            this.f61026a.K.f60807k.a();
        }

        @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
        public final void onPanelCancel() {
            this.f61026a.K.f60809m.getClass();
            this.f61026a.K.f60807k.a();
        }

        public d(SonicGamePlugin r100) {
            this.f61026a = r100;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.LiveBasePluginWithPanel, com.bytedance.android.live.broadcastgame.opengame.runtime.k
    public final void onStop() {
        b(false);
        if (((IInteractService) jc1.k.n(IInteractService.class)).isLinkCasting() == false) goto L5;
        ((IInteractService) jc1.k.n(IInteractService.class)).onProgramStop();
    L5:
        MainThreadPostUtils.d(((GameFpsMonitor) ((PerformanceChecker) this.G.getValue()).f61048a.getValue()).f61044d);
        this.K.f60803g = null;
        jc1.a.b().unregisterActivityLifecycleCallbacks(this.I);
        this.f61011J = null;
        super.onStop();
        k r100 = this.E;
        if (r100 == null) goto L8;
        r100.f61069b.clear();
        MainThreadPostUtils.d(r100.f61070c);
    L8:
        this.E = null;
        int r101 = q.f60744a;
        q.f("SonicGamePlugin", new Object[]{"transfer sonic state to destroy"});
        u(SonicState.DESTROY, false);
        t10.a r102 = this.f61016u.f61740a;
        na4.b r103 = r102.f544135a;
        if (r103 == null) goto L11;
        r103.d();
    L11:
        r102.f544136b.e();
        r102.f544135a = null;
        if (at0.f119818a.getValue().booleanValue() == false) goto L28;
        na4.c<com.bytedance.bdp.live.livecontainer.sonicgame.k, com.bytedance.bdp.live.livecontainer.sonicgame.b> r104 = x();
        if ((r104 instanceof com.bytedance.bdp.live.livecontainer.sonicgame.j) == true) goto L17;
        r104 = null;
    L17:
        com.bytedance.bdp.live.livecontainer.sonicgame.j r105 = (com.bytedance.bdp.live.livecontainer.sonicgame.j) r104;
        if (r105 == null) goto L26;
        IBdpAppInstance r106 = r105.f201529a;
        if (r106 == null) goto L27;
        r106.finish();
        BdpAppContainer r107 = r106.getAppContainer();
        if (r107 == null) goto L24;
        r107.a();
    L24:
        r105.f201529a = null;
        return;
    L27:
        return;
    L26:
        return;
    }

    public final na4.c<com.bytedance.bdp.live.livecontainer.sonicgame.k, com.bytedance.bdp.live.livecontainer.sonicgame.b> x() {
        return (na4.c) this.f61012q.getValue();
    }

    public final void A() {
        int r100 = q.f60744a;
        q.f("SonicGamePlugin", new Object[]{"init sonic context"});
        JSONObject r101 = (JSONObject) this.K.g("game_config");
        if (r101 != null) goto L15;
    L8:
        final String r102 = "";
    L9:
        t(null, new SonicGamePlugin$initSonicContext$1(r102));     // Catch: JSONException -> L11
    L13:
        t(null, new SonicGamePlugin$initSonicContext$2(this));
        return;
    L11:
        e = move-exception;
        int r103 = q.f60744a;
        q.f("SonicGamePlugin", new Object[]{"parse button color fail, error: ", e});
        goto L13
    L15:
        JSONObject r104 = JSONObjectProtectorUtils.getJSONObject(r101, "liveOpenConfig");     // Catch: JSONException -> L11
        if (r104 == null) goto L8;
        r102 = JSONObjectProtectorUtils.getString(r104, "panelMoreBtnColor");     // Catch: JSONException -> L11
        if (r102 != null) goto L9;
        goto L8
    }

    public final boolean B() {
        PluginContext r100 = this.K;
        if (r100.h(r100.r()) == GameCastStrategy.VIDEO_CHATROOM) goto L5;
    L7:
        return false;
    L5:
        if (((IInteractService) jc1.k.n(IInteractService.class)).isLinkCasting() == false) goto L7;
        return true;
    }

    public final boolean E() {
        if (me0.f120749a.getValue().booleanValue() == true) goto L32;
        com.bytedance.android.live.broadcastgame.opengame.runtime.g r100 = ((BootInfoService) this.K.o(BootInfoService.class)).c();
        if (r100 == null) goto L24;
        com.bytedance.android.live.broadcastgame.opengame.runtime.j r101 = r100.f60835b;
        if (r101 == null) goto L24;
        List<com.bytedance.android.live.broadcastgame.opengame.network.a.C0989a> r102 = r101.f60839a;
        if (r102 == null) goto L24;
        List<com.bytedance.android.live.broadcastgame.opengame.network.a.C0989a> r103 = r102;
        if ((r103 instanceof Collection) == true) goto L13;
    L15:
        Iterator<T> r104 = r103.iterator();
    L17:
        if (r104.hasNext() == false) goto L21;
        if (Intrinsics.areEqual("openCloudGame", ((com.bytedance.android.live.broadcastgame.opengame.network.a.C0989a) r104.next()).c()) == false) goto L17;
        boolean r105 = true;
    L22:
        if (r105 != true) goto L24;
        boolean r106 = true;
    L25:
        if (r106 == false) goto L33;
        return false;
    L33:
        return true;
    L21:
        r105 = false;
        goto L22
    L13:
        if (r103.isEmpty() == false) goto L15;
    L24:
        r106 = false;
        goto L25
    L32:
        return true;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.LiveBasePluginWithPanel
    public final com.bytedance.android.live.broadcastgame.opengame.runtime.l m() {
        int r100 = q.f60744a;
        q.f("SonicGamePlugin", new Object[]{"create panel factory, can switch screen: ", Boolean.valueOf(((BootInfoService) this.K.o(BootInfoService.class)).a())});
        int r101 = fe0.f120196a.getValue().b();
        if (r101 == 1) goto L11;
        if (r101 == 2) goto L7;
        return new SonicGamePlugin$provideFactory$2(this);
    L7:
        if (((BootInfoService) this.K.o(BootInfoService.class)).a() == false) goto L14;
        return new i(this);
    L14:
        return new SonicGamePlugin$provideFactory$2(this);
    L11:
        return new i(this);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.LiveBasePluginWithPanel, com.bytedance.android.live.broadcastgame.opengame.runtime.v, com.bytedance.android.live.broadcastgame.opengame.runtime.k
    public final void onHide() {
        this.C += System.currentTimeMillis() - this.D;
        if (ke0.f120596a.getValue().a() == false) goto L6;
        t(null, new SonicGamePlugin$checkBlackScreen$1(this));
    L6:
        super.onHide();
        if (E() == false) goto L10;
        int r100 = q.f60744a;
        q.f("SonicGamePlugin", new Object[]{"transfer sonic state to pause"});
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.LiveBasePluginWithPanel
    public final boolean q() {
        if (fe0.f120196a.getValue().b() == 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.service.SimplePanelStateDispatchService.b
    public final void s0() {
        int r100 = q.f60744a;
        q.f("SonicGamePlugin", new Object[]{"on panel real show"});
        u(SonicState.RESUME, false);
        if (B() == false) goto L6;
        ((IInteractService) jc1.k.n(IInteractService.class)).onProgramShow();
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.service.SimplePanelStateDispatchService.b
    public final void t0() {
        int r100 = q.f60744a;
        q.f("SonicGamePlugin", new Object[]{"on panel real hide"});
        if (E() == false) goto L6;
        q.f("SonicGamePlugin", new Object[]{"transfer sonic state to pause"});
        u(SonicState.PAUSE, false);
    L6:
        if (B() == false) goto L9;
        ((IInteractService) jc1.k.n(IInteractService.class)).onProgramHide();
        return;
    }

    public final f w() {
        if (this.f61021z == null) goto L7;
        return this.f61021z;
    L7:
        if (x() == null) goto L9;
        com.bytedance.android.live.broadcastgame.opengame.sonicgame.a r100 = new com.bytedance.android.live.broadcastgame.opengame.sonicgame.a(this.K, x(), new c(this));
    L10:
        this.f61021z = r100;
        return this.f61021z;
    L9:
        r100 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.LiveBasePluginWithPanel, com.bytedance.android.live.broadcastgame.opengame.runtime.k
    public final void onStart() {
        super.onStart();
        int r100 = q.f60744a;
        q.f("SonicGamePlugin", new Object[]{"on lifecycle: onStart"});
        q.f("SonicGamePlugin", new Object[]{"inject open api"});
        y r101 = this.f60848b;
        if (r101 == null) goto L6;
        com.bytedance.android.live.broadcastgame.openplatform.miniapp.b r102 = this.f61016u;
        PluginContext r103 = this.K;
        t r104 = r103.f60809m;
        String r105 = r104.f61083i;
        long r106 = r104.f61075a;
        Context r107 = r103.getContext();
        LaunchMode r108 = this.f60847a;
        t r109 = this.K.f60809m;
        r101.a(r102, new g0(r105, r106, r107, r108, r109.f61082h, r109.b(this.f60849c)));
    L6:
        if (this.F == false) goto L11;
        k r110 = this.E;
        if (r110 == null) goto L10;
        r110.f61069b.clear();
        MainThreadPostUtils.d(r110.f61070c);
    L10:
        k r111 = new k(this.K);
        boolean r112 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        com.bytedance.android.live.profit.scoreboard.h r113 = (com.bytedance.android.live.profit.scoreboard.h) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.scoreboard.h.class);
        t r114 = r111.f61071d.f60809m;
        r113.S3(r114.f61083i, r114.f61075a, new l(r111));
        Unit r115 = Unit.INSTANCE;
        this.E = r111;
    L11:
        jc1.a.b().registerActivityLifecycleCallbacks(this.I);
        A();
    }

    public SonicGamePlugin(PluginContext r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginContext");
        super(r100);
        this.K = r100;
        this.f61012q = LazyKt.lazy(new SonicGamePlugin$pluginLauncher$2(this));
        this.f61016u = new com.bytedance.android.live.broadcastgame.openplatform.miniapp.b(r100.getContext());
        this.f61017v = "com.bytedance.android.ttlivesdk.live.LiveBgBroadcastActivity";
        this.f61018w = "com.ss.android.ugc.aweme.live.LiveBgBroadcastActivity";
        this.f61019x = "com.bytedance.android.livesdkproxy.activity.LiveBgBroadcastActivity";
        this.f61020y = ((IHostApp) jc1.k.n(IHostApp.class)).getAllLiveActivity();
        this.B = "sonic_game_load_unknown";
        if (r100.f60809m.d(this.f60849c) != 5) goto L5;
        boolean r101 = true;
    L6:
        this.F = r101;
        this.G = LazyKt.lazy(new SonicGamePlugin$performanceChecker$2(this));
        this.I = new SonicGamePlugin$liveLifeCycle$1(this);
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void D(boolean r100) {
        na4.b r101 = this.f61013r;
        if (r101 == null) goto L10;
        Bundle r102 = new Bundle();
        r102.putString("event", "onAnchorShareScreen");
        JSONObject r103 = new JSONObject();
        if (r100 == false) goto L7;
        int r104 = 1;
    L8:
        r103.put("action", r104);
        r103.put("scene", 2);
        Unit r105 = Unit.INSTANCE;
        r102.putString("data", r103.toString());
        r101.a("command_send_event_to_js_core", r102);
        return;
    L7:
        r104 = 2;
        goto L8
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.sonicgame.f
    public final void b(boolean r100) {
        f r101 = w();
        if (r101 == null) goto L5;
        ((com.bytedance.android.live.broadcastgame.opengame.sonicgame.a) r101).b(r100);
    L5:
        this.f61021z = null;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.sonicgame.f
    public final void g(boolean r100) {
        f r101 = w();
        if (r101 == null) goto L6;
        r101.g(r100);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.LiveBasePluginWithPanel, com.bytedance.android.live.broadcastgame.opengame.runtime.k
    public final void onShow(final Map<String, String> r100) {
        this.D = System.currentTimeMillis();
        super.onShow(r100);
        t(new AnonymousClass1(this, r100), AnonymousClass2.INSTANCE);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.LiveBasePluginWithPanel
    public final void s(com.bytedance.android.live.broadcastgame.opengame.panel.h r110) {
        Intrinsics.checkNotNullParameter(r110, "panel");
        int r100 = q.f60744a;
        q.f("SonicGamePlugin", new Object[]{"on panel create"});
        this.K.f60803g = r110;
        this.f61011J = r110;
        String r101 = ((IUserService) jc1.k.n(IUserService.class)).user().b().getIdString();
        RoomContext r102 = RoomContext.a.c(RoomContext.Companion, this.K.f60805i, 0, 2);
        com.bytedance.android.live.broadcastgame.opengame.panel.h r103 = null;
        if (r102 == null) goto L9;
        m<Room> r104 = r102.getRoom();
        if (r104 == null) goto L9;
        Room r105 = r104.getValue();
        if (r105 == null) goto L9;
        String r106 = r105.getOwnerUserIdString();
    L10:
        com.bytedance.android.live.broadcastgame.opengame.panel.h r107 = this.f61011J;
        if ((r107 instanceof FullScreenOpenPanel) == false) goto L14;
        r103 = r107;
    L14:
        FullScreenOpenPanel r108 = (FullScreenOpenPanel) r103;
        if (r108 == null) goto L21;
        t r109 = this.K.f60809m;
        long r111 = r109.f61082h;
        String r112 = r109.b(this.f60849c);
        String r113 = ((BootInfoService) this.K.o(BootInfoService.class)).e();
        PluginContext r114 = this.K;
        Intrinsics.checkNotNullParameter(r101, "userId");
        Intrinsics.checkNotNullParameter(r112, "gameName");
        Intrinsics.checkNotNullParameter(r113, "gameCategory");
        if (r106 != null) goto L20;
        r106 = "";
    L20:
        r108.f60618r = r106;
        r108.f60619s = r101;
        r108.f60620t = String.valueOf(r111);
        r108.f60621u = r112;
        r108.f60622v = r113;
        r108.f60623w = r114;
    L21:
        r110.registerListener(new d(this));
        return;
    L9:
        r106 = null;
        goto L10
    }

    public final void y(final Function1<? super PanelType, Unit> r100) {
        t(null, new SonicGamePlugin$getScreenType$1(r100));
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.k
    public final <T> void sendEvent(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "data");
        com.bytedance.android.live.broadcastgame.openplatform.miniapp.b r102 = this.f61016u;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "data");
        t10.a r103 = r102.f61740a;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "data");
        if (r103.f544136b.f249346f == true) goto L6;
        JSONObject r104 = new JSONObject();
        r104.put("eventName", r100);
        r104.put("data", r101);
        r103.f544136b.f(r100, r104);
        return;
    }

    public final void u(SonicState r100, boolean r101) {
        int r102 = q.f60744a;
        q.f("SonicGamePlugin", new Object[]{"sonic state change, cur state: ", this.f61015t, ", to state: ", r100, ", force: ", Boolean.valueOf(r101), ", sonic instance: ", this.f61013r});
        if (r101 == false) goto L5;
    L11:
        int r103 = g.f61063a[r100.ordinal()];
        if (r103 == 1) goto L28;
        if (r103 == 2) goto L24;
        if (r103 == 3) goto L17;
    L31:
        this.f61015t = r100;
        return;
    L17:
        if (this.F == false) goto L19;
        boolean r104 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        ((com.bytedance.android.live.profit.scoreboard.h) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.scoreboard.h.class)).i(this.K.f60809m.f61083i);
    L19:
        na4.b r105 = this.f61013r;
        if (r105 == null) goto L22;
        r105.destroy();
    L22:
        this.f61013r = null;
        goto L31
    L24:
        if (this.F == true) goto L31;
        na4.b r106 = this.f61013r;
        if (r106 == null) goto L31;
        r106.pause();
        goto L31
    L28:
        na4.b r107 = this.f61013r;
        if (r107 == null) goto L31;
        r107.resume();
        goto L31
    L5:
        if (this.f61013r == null) goto L10;
        SonicState r108 = this.f61015t;
        if (r108 != r100) goto L9;
        return;
    L9:
        if (r108 != SonicState.DESTROY) goto L11;
        return;
    }

    public final void G(PanelType r100, Function1<? super PanelType, Unit> r110, Function1<? super Throwable, Unit> r111) {
        Intrinsics.checkNotNullParameter(r100, "toType");
        com.bytedance.android.live.broadcastgame.opengame.panel.h r101 = this.f61011J;
        if ((r101 instanceof com.bytedance.android.live.broadcastgame.opengame.panel.g) == true) goto L6;
        Unit r102 = r111.invoke(new Throwable("panel not support switch"));
        return;
    L6:
        if (r101 == null) goto L38;
        PanelType r112 = r101.getPanelType();
        if (r112 == null) goto L39;
        if (r112 != r100) goto L13;
        Unit r103 = r110.invoke(r100);
        return;
    L13:
        PanelType.Companion.getClass();
        if (PanelType.a.a(r112) == false) goto L22;
        if (r100 != PanelType.PANEL_TYPE_PORTRAIT) goto L19;
        String r113 = "玩法将切换为竖全屏";
    L26:
        if (r100 != PanelType.PANEL_TYPE_LANDSCAPE) goto L28;
        long r104 = 100;
    L30:
        if ((!StringsKt.isBlank(r113)) == false) goto L36;
        InteractGameContext r105 = InteractGameContext.Companion.getContext();
        if (r105 == null) goto L36;
        if (r105.getGameFullPanelIsShowing() != true) goto L36;
        f2.c(r113, 0);
        r104 = 0;
    L36:
        UtilityKotlinExtentionsKt.s(r104, false, false, new SonicGamePlugin$switchScreen$1(this, r100, r110), 6);
        return;
    L28:
        r104 = 500;
        goto L30
    L19:
        if (r100 != PanelType.PANEL_TYPE_LANDSCAPE) goto L24;
        r113 = "玩法将切换为横全屏";
    L24:
        r113 = "";
        goto L26
    L22:
        if (PanelType.a.a(r100) == false) goto L24;
        r113 = "当前玩法将进入全屏模式";
        goto L26
    L39:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.k
    public final void e(Context r210, String r211, Map<String, ? extends Object> r212, n r213) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r211, "schema");
        this.f61014s = r211;
        LruCache<String, LiveSchemaInfo> r100 = LiveSchemaInfo.f201489r;
        LiveSchemaInfo r101 = LiveSchemaInfo.c.a(r211);
        int r102 = q.f60744a;
        q.f("SonicGamePlugin", new Object[]{"start download resource, appId: " + this.K.f60809m.f61083i});
        Object r103 = null;
        if (r101 != null) goto L7;
        q.f("SonicGamePlugin", new Object[]{"download resource failed, schemaInfo is null"});
        if (r213 == null) goto L20;
        r213.n(null, "schema error", "Download");
        return;
    L20:
        return;
    L7:
        Object[] r104 = new Object[6];
        r104[0] = "is anchor: ";
        r104[1] = Boolean.valueOf(this.K.f60811o);
        int r105 = 2;
        r104[2] = ", from collect: ";
        if (r212 == null) goto L10;
        r103 = r212.get("from_collect");
    L10:
        r104[3] = r103;
        r104[4] = ", live start mode: ";
        r104[5] = Integer.valueOf(n());
        q.f("SonicGamePlugin", r104);
        com.bytedance.bdp.live.livecontainer.sonicgame.k r106 = new com.bytedance.bdp.live.livecontainer.sonicgame.k(null, null, null, false, 0, 0, false, 0, 0, UnixStat.PERM_MASK);
        r106.f518463b.put(BdpStartUpParam.KEY_START_MODE, "host");
        Map<String, String> r107 = r106.f518463b;
        JSONObject r108 = new JSONObject();
        r108.put("anchor", this.K.f60811o);
        if (r212 != null) goto L13;
    L15:
        r105 = n();
    L16:
        r108.put("live_start_mode", r105);
        Unit r109 = Unit.INSTANCE;
        r107.put(BdpStartUpParam.KEY_EXT_CONFIG_JSON, r108.toString());
        na4.c<com.bytedance.bdp.live.livecontainer.sonicgame.k, com.bytedance.bdp.live.livecontainer.sonicgame.b> r110 = x();
        if (r110 == null) goto L22;
        r110.a(r101, r106, new b(this, r213));
        return;
    L22:
        return;
    L13:
        if (Intrinsics.areEqual(r212.get("from_collect"), Boolean.TRUE) == false) goto L15;
        goto L15
    }
}
