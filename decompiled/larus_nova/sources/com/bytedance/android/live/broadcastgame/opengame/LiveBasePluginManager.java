package com.bytedance.android.live.broadcastgame.opengame;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.util.LruCache;
import android.view.Surface;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.broadcastgame.InteractGameService;
import com.bytedance.android.live.broadcastgame.api.interactgame.GameDataReportHelper;
import com.bytedance.android.live.broadcastgame.api.interactgame.InteractGameLocalStatusUtils;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.broadcastgame.api.openplatform.OpenPlatformMonitorUtils;
import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;
import com.bytedance.android.live.broadcastgame.opengame.control.report.ReportPicUploader;
import com.bytedance.android.live.broadcastgame.opengame.debug.GameReceiver;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.broadcastgame.opengame.runtime.BootInfoService;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.i2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdp.live.livecontainer.base.schema.LiveSchemaInfo;
import com.bytedance.crash.Npth;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.nova.R;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.io.File;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public abstract class LiveBasePluginManager implements com.bytedance.android.live.broadcastgame.api.openplatform.b, com.bytedance.android.live.broadcastgame.opengame.runtime.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.live.broadcastgame.opengame.runtime.q f59705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f59706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f59707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.live.broadcastgame.opengame.debug.d f59708d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f59709e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.android.live.broadcastgame.api.d f59710f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f59711g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DataCenter f59712h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f59713i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ViewGroup f59714j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ i20.a f59715k;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveBasePluginManager f59716a;

        public b(LiveBasePluginManager r100) {
            this.f59716a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            LiveBasePluginManager r101 = this.f59716a;
            r101.r((com.bytedance.android.live.broadcastgame.api.openplatform.f) r100);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveBasePluginManager f59717a;

        public c(LiveBasePluginManager r100) {
            this.f59717a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            int r101 = q.f60744a;
            q.i((Throwable) r100, "LiveBasePluginManager", "on registerShowPanelEvent Error");
            this.f59717a.q();
            LocalTestManager.a(new Class[]{wy.a.class});
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveBasePluginManager f59718a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.broadcastgame.api.openplatform.f f59719b;

        public d(LiveBasePluginManager r100, com.bytedance.android.live.broadcastgame.api.openplatform.f r101) {
            this.f59718a = r100;
            this.f59719b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            IBaseUser r101 = (IBaseUser) r100;
            LiveBasePluginManager r102 = this.f59718a;
            r102.g(r102.f59706b, MapsKt.mapOf(TuplesKt.to("location", this.f59719b.f59412b)), this.f59719b.f59411a);
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f59720a = null;

        static {
            f59720a = new e();
        }

        public e() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            int r101 = q.f60744a;
            q.i((Throwable) r100, "LiveBasePluginManager", "on registerShowPanelEvent login Error");
        }
    }

    static {
    }

    public final void a(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$autoDispose");
        this.f59715k.a(r100);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.n
    public final void f(String r100, File r101) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public void j(String r100) {
        Intrinsics.checkNotNullParameter("sei", "name");
        Intrinsics.checkNotNullParameter(r100, "params");
    }

    public abstract com.bytedance.android.live.broadcastgame.opengame.runtime.q l(Context r100, long r101, DataCenter r102, f r103, PluginType r104);

    public final Room m() {
        return (Room) this.f59709e.getValue();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.n
    public final void n(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "stage");
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.r
    public final void o() {
    }

    public void onStop() {
        this.f59706b = null;
        this.f59705a = null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final String getGameCategory() {
        com.bytedance.android.live.broadcastgame.opengame.runtime.q r100 = this.f59705a;
        if (r100 == null) goto L7;
        PluginContext r101 = r100.mo8168getContext();
        if (r101 == null) goto L7;
        return ((BootInfoService) r101.o(BootInfoService.class)).e();
    L7:
        return "";
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final String h() {
        Intrinsics.checkNotNullParameter("", "appId");
        com.bytedance.android.live.broadcastgame.opengame.runtime.q r100 = this.f59705a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.h();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void k() {
        Intrinsics.checkNotNullParameter("", "appId");
        com.bytedance.android.live.broadcastgame.opengame.runtime.q r100 = this.f59705a;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public void onDestroy() {
        ReportPicUploader.f59915c.clear();
        com.bytedance.android.live.broadcastgame.opengame.runtime.q r100 = this.f59705a;
        if (r100 == null) goto L5;
        r100.b("on destroy");
    L5:
        com.bytedance.android.live.broadcastgame.opengame.debug.d r101 = this.f59708d;
        OpenPlatformBaseDebugger r102 = r101.f59996b;
        if (r102 == null) goto L8;
        r102.releaseDebug();
    L8:
        r101.f59996b = null;
        r101.f59995a = false;
        this.f59705a = null;
        this.f59706b = null;
        f r103 = this.f59707c;
        r103.getClass();
        int r104 = q.f60744a;
        q.g("销毁游戏IM", "");
        vlc.d r105 = r103.f60118b;
        if (r105 == null) goto L11;
        r105.release();
    L11:
        com.bytedance.android.live.broadcastgame.api.interactgame.o.f59317a = 0;
        int r106 = InteractGameLocalStatusUtils.f59295a;
        InteractGameLocalStatusUtils.c("in_game_cast", String.valueOf(false));
        this.f59715k.b();
        GameReceiver r107 = com.bytedance.android.live.broadcastgame.opengame.debug.a.f59992a;
        if (v.a() == true) goto L14;
        return;
    L14:
        if (com.bytedance.android.live.broadcastgame.opengame.debug.a.f59992a == null) goto L26;
        Application r108 = jc1.a.b();
        GameReceiver r109 = com.bytedance.android.live.broadcastgame.opengame.debug.a.f59992a;
        ReceiverRegisterLancet.loge(r109, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L31;
        r108.unregisterReceiver(r109);
        goto L26
    L31:
    L21:
        e = move-exception;
        if (r109 == null) goto L24;
        Npth.addTag("unregisterReceiver", r109.toString());
    L24:
        e.printStackTrace();
        goto L26
    L18:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r109, r108) == false) goto L26;
        r108.unregisterReceiver(r109);     // Catch: Exception -> L21
    L26:
        GameReceiver r110 = com.bytedance.android.live.broadcastgame.opengame.debug.a.f59992a;
        if (r110 == null) goto L29;
        r110.f59961b = null;
    L29:
        com.bytedance.android.live.broadcastgame.opengame.debug.a.f59992a = null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void stopGameCastToAudience() {
        com.bytedance.android.live.broadcastgame.opengame.runtime.q r100 = this.f59705a;
        if (r100 == null) goto L6;
        r100.stopGameCastToAudience();
        return;
    }

    public final void q() {
        a(RxUtilKt.h(xs2.b.a().b(com.bytedance.android.live.broadcastgame.api.openplatform.f.class)).subscribe(new b(this), new c(this)));
    }

    public final Context getContext() {
        return this.f59711g;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        com.bytedance.android.live.broadcastgame.opengame.runtime.q r101 = this.f59705a;
        if (r101 == null) goto L5;
        r101.b(r100);
    L5:
        this.f59705a = null;
        this.f59706b = null;
        int r102 = com.bytedance.android.live.broadcastgame.api.interactgame.o.f59317a;
        com.bytedance.android.live.broadcastgame.api.interactgame.o.f59317a = 0;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void c(boolean r100) {
        com.bytedance.android.live.broadcastgame.opengame.runtime.q r101 = this.f59705a;
        if (r101 == null) goto L6;
        r101.c(r100);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void e(u r110) {
        Intrinsics.checkNotNullParameter(r110, "gameItem");
        int r100 = q.f60744a;
        Object[] r101 = new Object[1];
        StringBuilder r102 = new StringBuilder("start intro dialog, game name: ");
        r102.append(r110.name);
        r102.append(", appId: ");
        com.bytedance.android.live.broadcastgame.api.model.r r103 = r110.c();
        if (r103 == null) goto L6;
        String r104 = r103.b();
        if (r104 == null) goto L6;
    L7:
        r102.append(r104);
        r101[0] = r102.toString();
        q.f("LiveBasePluginManager", r101);
        LruCache<String, byte[]> r105 = ReportPicUploader.f59913a;
        com.bytedance.android.live.broadcastgame.api.model.r r106 = r110.c();
        if (r106 == null) goto L11;
        String r107 = r106.b();
        if (r107 == null) goto L11;
    L12:
        Intrinsics.checkNotNullParameter(r107, "appId");
        ReportPicUploader.a r108 = ReportPicUploader.f59915c.get(r107);
        Long r109 = null;
        if (r108 == null) goto L19;
        q.f("LiveBasePluginManager", new Object[]{"startPluginWithIntroduction: game is in black list, cancel start"});
        f2.b(R.string.ttlive_open_platform_violation_tip, 0);
        int r111 = GameDataReportHelper.f59290a;
        String r112 = r110.name;
        com.bytedance.android.live.broadcastgame.api.model.r r113 = r110.c();
        if (r113 == null) goto L17;
        r109 = Long.valueOf(r113.p());
    L17:
        GameDataReportHelper.f(r112, String.valueOf(r109), r108.f59919a, r108.f59920b, z.e(this.f59712h, false));
        return;
    L19:
        Context r114 = this.f59711g;
        DataCenter r115 = this.f59712h;
        Intrinsics.checkNotNullParameter(r114, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "gameItem");
        Intrinsics.checkNotNullParameter(r115, "dataCenter");
        LiveBasePluginManager$startPluginWithIntroduction$2 r116 = LiveBasePluginManager$startPluginWithIntroduction$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r116, "fallback");
        int r117 = com.bytedance.android.live.broadcastgame.opengame.view.i.f61293j;
        Intrinsics.checkNotNullParameter(r114, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r115, "dataCenter");
        Intrinsics.checkNotNullParameter(r110, "gameItem");
        Intrinsics.checkNotNullParameter(this, "gameManager");
        com.bytedance.android.live.broadcastgame.opengame.view.i r118 = new com.bytedance.android.live.broadcastgame.opengame.view.i(r114, r115, r110, this);
        Intrinsics.checkNotNullParameter(r116, "fallback");
        r118.e(r116, null);
        return;
    L11:
        r107 = "";
    L6:
        r104 = "null";
        goto L7
    }

    public final void r(com.bytedance.android.live.broadcastgame.api.openplatform.f r100) {
        Intrinsics.checkNotNullParameter(r100, "openEvent");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L56
        if (Intrinsics.areEqual(r100.f59412b, "from_toolbar") == false) goto L7;
    L10:
        String r102 = r100.f59412b;     // Catch: Throwable -> L56
        int r103 = r102.hashCode();     // Catch: Throwable -> L56
        if (r103 == (-1271529498)) goto L24;
        if (r103 == (-949931101)) goto L21;
        if (r103 == 214339523) goto L18;
    L26:
        String r104 = "";
    L27:
        OpenPlatformMonitorUtils r105 = OpenPlatformMonitorUtils.f59390c;     // Catch: Throwable -> L56
        com.bytedance.android.live.broadcastgame.opengame.runtime.q r106 = this.f59705a;     // Catch: Throwable -> L56
        String r107 = null;
        if (r106 == null) goto L32;
        t r108 = r106.getPluginInfo();     // Catch: Throwable -> L56
        if (r108 == null) goto L32;
        String r109 = r108.f61083i;     // Catch: Throwable -> L56
    L33:
        com.bytedance.android.live.broadcastgame.opengame.runtime.q r110 = this.f59705a;     // Catch: Throwable -> L56
        if (r110 == null) goto L40;
        t r111 = r110.getPluginInfo();     // Catch: Throwable -> L56
        if (r111 == null) goto L40;
        Map<String, ? extends Object> r112 = r111.f61085k;     // Catch: Throwable -> L56
        if (r112 == null) goto L40;
        Object r113 = r112.get("OPEN_APP_NAME");     // Catch: Throwable -> L56
    L42:
        if ((r113 instanceof String) == true) goto L44;
        r113 = null;
    L44:
        String r114 = (String) r113;     // Catch: Throwable -> L56
        com.bytedance.android.live.broadcastgame.opengame.runtime.q r115 = this.f59705a;     // Catch: Throwable -> L56
        if (r115 == null) goto L49;
        t r116 = r115.getPluginInfo();     // Catch: Throwable -> L56
        if (r116 == null) goto L49;
        r107 = r116.f61088n;     // Catch: Throwable -> L56
    L49:
        r105.g(new com.bytedance.android.live.broadcastgame.api.openplatform.d(r109, r114, r107), new com.bytedance.android.live.broadcastgame.api.openplatform.e(m(), SourceType.DEFAULT, 12), r104);     // Catch: Throwable -> L56
    L51:
        if (((IUserService) jc1.k.n(IUserService.class)).user().isLogin() == true) goto L53;
        com.bytedance.android.livesdk.user.f r117 = ((IUserService) jc1.k.n(IUserService.class)).user();     // Catch: Throwable -> L56
        Context r118 = this.f59711g;     // Catch: Throwable -> L56
        com.bytedance.android.livesdk.user.l.a r119 = new com.bytedance.android.livesdk.user.l.a();     // Catch: Throwable -> L56
        r119.f158685a = s1.B(R.string.ttlive_core_login_dialog_message);     // Catch: Throwable -> L56
        r119.f158688d = "open_platform";     // Catch: Throwable -> L56
        r119.f158687c = -1;     // Catch: Throwable -> L56
        a(r117.login(r118, new com.bytedance.android.livesdk.user.l(r119)).subscribe(new d(this, r100), e.f59720a));     // Catch: Throwable -> L56
    L54:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L56
        return;
    L53:
        g(this.f59706b, MapsKt.mapOf(TuplesKt.to("location", r100.f59412b)), r100.f59411a);     // Catch: Throwable -> L56
    L40:
        r113 = null;
    L32:
        r109 = null;
        goto L33
    L18:
        if (r102.equals("from_temp_area") == false) goto L26;
        r104 = "temp_area";
        goto L27
    L21:
        if (r102.equals("from_mini_card") == false) goto L26;
        r104 = BrowserDependency.UrlClickType.CARD;
        goto L27
    L24:
        if (r102.equals("from_toolbar") == false) goto L26;
        r104 = NewBroadcastMonitor.STAGE.TOOLBAR;
        goto L27
    L7:
        if (Intrinsics.areEqual(r100.f59412b, "from_mini_card") == true) goto L10;
        if (Intrinsics.areEqual(r100.f59412b, "from_temp_area") == false) goto L51;
    L56:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public void d(String r100, Map<String, String> r101) {
        com.bytedance.android.live.broadcastgame.opengame.runtime.q r102 = this.f59705a;
        if (r102 == null) goto L6;
        r102.g(r101);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void notifyStartLinkCastResult(boolean r100, Surface r101, int r102) {
        com.bytedance.android.live.broadcastgame.opengame.runtime.q r103 = this.f59705a;
        if (r103 == null) goto L6;
        r103.notifyStartLinkCastResult(r100, r101, r102);
        return;
    }

    public LiveBasePluginManager(Context r100, DataCenter r110, long r111, ViewGroup r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "dataCenter");
        Intrinsics.checkNotNullParameter(r112, "containerView");
        this.f59715k = new i20.a();
        this.f59711g = r100;
        this.f59712h = r110;
        this.f59713i = r111;
        this.f59714j = r112;
        this.f59707c = new f(r100, r111);
        this.f59708d = new com.bytedance.android.live.broadcastgame.opengame.debug.d();
        this.f59709e = LazyKt.lazy(LiveBasePluginManager$room$2.INSTANCE);
        InteractGameService.Companion.getClass();
        i10.f r101 = (i10.f) InteractGameService.access$getDiComponent$cp();
        r101.getClass();
        com.bytedance.android.live.broadcastgame.api.d r102 = r101.f487925a.f487929e.get();
        this.f59710f = r102;
        if (r102 == null) goto L6;
        r102.a();
    L6:
        if (v.a() == false) goto L10;
        a(RxUtilKt.h(xs2.b.a().b(d10.c.class)).subscribe(new n(this), o.f60301a));
    L10:
        if (v.a() == false) goto L13;
        a(RxUtilKt.h(xs2.b.a().b(d10.a.class)).subscribe(new l(this), m.f60161a));
    L13:
        q();
        GameReceiver r103 = com.bytedance.android.live.broadcastgame.opengame.debug.a.f59992a;
        Intrinsics.checkNotNullParameter(this, "manager");
        if (v.a() == false) goto L86;
        int r104 = q.f60744a;
        q.g("ADBDebugManager: init", "");
        IntentFilter r105 = new IntentFilter("com.bytedance.android.live.game");
        GameReceiver r113 = com.bytedance.android.live.broadcastgame.opengame.debug.a.f59992a;
        if (r113 != null) goto L18;
        r113 = new GameReceiver(this);
    L18:
        com.bytedance.android.live.broadcastgame.opengame.debug.a.f59992a = r113;
        if (Build.VERSION.SDK_INT < 34) goto L49;
        Application r114 = jc1.a.b();
        GameReceiver r115 = com.bytedance.android.live.broadcastgame.opengame.debug.a.f59992a;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L83;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L83:
    L44:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L48;
        ReceiverRegisterCrashOptimizer.registerReceiver(r115, r105, 2);
        return;
    L48:
        throw e;
    L24:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L35;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r105) == false) goto L35;
        int r106 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r115, r105, 2, null, null, 3, r114).result;     // Catch: Exception -> L44
        if (r106 == 1) goto L33;
        if (r106 == 2) goto L32;
        if (r106 == 3) goto L82;
        r114.registerReceiver(r115, r105, 2);     // Catch: Exception -> L44
    L82:
        return;
    L32:
        new Intent();     // Catch: Exception -> L44
        goto L82
    L33:
        r114.registerReceiver(r115, r105, 2);     // Catch: Exception -> L44
    L35:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L38;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L44
        r114.registerReceiver(r115, r105, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L44
        goto L82
    L38:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L40;
    L42:
        r114.registerReceiver(r115, r105, 2);     // Catch: Exception -> L44
        goto L82
    L40:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r105) == false) goto L42;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L44
        ContextCompat.registerReceiver(r114, r115, r105, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L44
        goto L82
    L49:
        Application r116 = jc1.a.b();
        GameReceiver r117 = com.bytedance.android.live.broadcastgame.opengame.debug.a.f59992a;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L80;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L80:
    L73:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L77;
        ReceiverRegisterCrashOptimizer.registerReceiver(r117, r105);
        return;
    L77:
        throw e;
    L53:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L64;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r105) == false) goto L64;
        int r107 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r117, r105, 0, null, null, 2, r116).result;     // Catch: Exception -> L73
        if (r107 == 1) goto L62;
        if (r107 == 2) goto L61;
        if (r107 == 3) goto L79;
        r116.registerReceiver(r117, r105);     // Catch: Exception -> L73
    L79:
        return;
    L61:
        new Intent();     // Catch: Exception -> L73
        goto L79
    L62:
        r116.registerReceiver(r117, r105);     // Catch: Exception -> L73
    L64:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L67;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L73
        r116.registerReceiver(r117, r105, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L73
        goto L79
    L67:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L69;
    L71:
        r116.registerReceiver(r117, r105);     // Catch: Exception -> L73
        goto L79
    L69:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r105) == false) goto L71;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L73
        ContextCompat.registerReceiver(r116, r117, r105, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L73
        goto L79
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public void i(long r110, String r111, String r210, Map<String, ? extends Object> r211, boolean r212, boolean r213) {
        String r100 = r210;
        Intrinsics.checkNotNullParameter(r111, "appId");
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r211, "params");
        LruCache<String, byte[]> r101 = ReportPicUploader.f59913a;
        Intrinsics.checkNotNullParameter(r111, "appId");
        ReportPicUploader.a r102 = ReportPicUploader.f59915c.get(r111);
        Long r103 = null;
        if (r102 == null) goto L18;
        int r104 = q.f60744a;
        q.f("LiveBasePluginManager", new Object[]{"startPlugin: game is in black list, cancel start"});
        f2.b(R.string.ttlive_open_platform_violation_tip, 0);
        Object r105 = r211.get("game");
        if ((r105 instanceof u) == true) goto L7;
        r105 = null;
    L7:
        u r106 = (u) r105;
        int r107 = GameDataReportHelper.f59290a;
        if (r106 == null) goto L10;
        String r108 = r106.name;
    L11:
        String r109 = String.valueOf(r108);
        if (r106 == null) goto L16;
        com.bytedance.android.live.broadcastgame.api.model.r r112 = r106.c();
        if (r112 == null) goto L16;
        r103 = Long.valueOf(r112.p());
    L16:
        GameDataReportHelper.f(r109, String.valueOf(r103), r102.f59919a, r102.f59920b, z.e(this.f59712h, false));
        return;
    L10:
        r108 = null;
        goto L11
    L18:
        int r113 = q.f60744a;
        q.f("LiveBasePluginManager", new Object[]{"start plugin, appId: ", r111, ", schema: ", r100});
        if (com.bytedance.android.live.broadcastgame.api.openplatform.k.a(r210) == false) goto L22;
        r100 = r100.concat("&version_type=debug&tech_type=13");
    L21:
        String r114 = r100;
        com.bytedance.android.live.broadcastgame.opengame.runtime.q r115 = this.f59705a;
        if (r115 == null) goto L38;
        r115.b("start another plugin");
    L38:
        PluginType.Companion.getClass();
        PluginType r116 = PluginType.a.a(r114);
        if (r116 != null) goto L43;
        q.f("LiveBasePluginManager", new Object[]{"pluginType is null"});
        f2.b(R.string.ttlive_open_game_debug_invalid_qrcode_error, 0);
        return;
    L43:
        if (this.f59713i == 0) goto L45;
        q.f("LiveBasePluginManager", new Object[]{"update js sdk"});
        this.f59706b = r111;
        q.f("LiveBasePluginManager", new Object[]{"create runtime"});
        this.f59705a = l(this.f59711g, this.f59713i, this.f59712h, this.f59707c, r116);
        q.f("LiveBasePluginManager", new Object[]{"do start plugin"});
        com.bytedance.android.live.broadcastgame.opengame.runtime.q r117 = this.f59705a;
        if (r117 == null) goto L53;
        r117.e(r114, r116, r211, r213, this);
        return;
    L53:
        return;
    L45:
        if (v.a() == false) goto L47;
        f2.c("roomid is null", 0);
    L47:
        q.e("LiveBasePluginManager", new Object[]{"roomid is null"});
        return;
    L22:
        Intrinsics.checkNotNullParameter(r100, "$this$isNeedPerformance");
        androidx.collection.LruCache<String, LiveSchemaInfo> r118 = LiveSchemaInfo.f201489r;
        LiveSchemaInfo r119 = LiveSchemaInfo.c.a(r210);
        if (r119 == null) goto L25;
        String r120 = r119.b("needPerformance");
    L27:
        if (Intrinsics.areEqual(r120, "1") == false) goto L29;
        Intrinsics.checkNotNullParameter(r100, "$this$getWithoutPerfParam");
        String r121 = i2.e(i2.e(i2.e(UriProtector.parse(r210), "needPerformance"), "report_id"), "live_app_version").toString();
    L31:
        if (p.a(r121, r111) == false) goto L34;
        q.e("LiveBasePluginManager", new Object[]{"schema is invalid, appId: ", r111, ", schema: ", r121});
        f2.b(R.string.ttlive_open_game_debug_invalid_qrcode_error, 0);
        OpenPlatformMonitorUtils r122 = OpenPlatformMonitorUtils.f59390c;
        OpenPlatformMonitorUtils.o(r211, new com.bytedance.android.live.broadcastgame.api.openplatform.e(m(), null, 6), 1);
        return;
    L34:
        OpenPlatformMonitorUtils r123 = OpenPlatformMonitorUtils.f59390c;
        OpenPlatformMonitorUtils.o(r211, new com.bytedance.android.live.broadcastgame.api.openplatform.e(m(), null, 6), 0);
        goto L21
    L29:
        r121 = r100;
        goto L31
    L25:
        r120 = null;
        goto L27
    }
}
