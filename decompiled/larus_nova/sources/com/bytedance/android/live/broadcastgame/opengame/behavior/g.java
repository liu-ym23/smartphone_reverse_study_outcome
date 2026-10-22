package com.bytedance.android.live.broadcastgame.opengame.behavior;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.broadcastgame.api.openplatform.OpenPlatformMonitorUtils;
import com.bytedance.android.live.broadcastgame.opengame.message.f0;
import com.bytedance.android.live.broadcastgame.opengame.network.AudienceGameNetApi;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ToolbarComponentCheckManager;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w;
import com.bytedance.android.livesdk.config.bi1;
import com.bytedance.android.livesdk.config.oz0;
import com.bytedance.android.livesdk.config.ve;
import com.bytedance.android.livesdk.config.x20;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdk.message.model.e0;
import com.bytedance.android.livesdk.message.model.hn;
import com.bytedance.android.livesdk.message.model.mh;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomStampInfo;
import com.bytedance.android.livesdkapi.model.WtnPlayEvent;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.livesdkapi.toolbar.ToolbarBehaviorData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.google.gson.Gson;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.thread.ThreadPoolHelper;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class g extends a0 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f59746m = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Room f59747f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f0 f59748g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CompositeDisposable f59749h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bytedance.android.live.broadcastgame.xplay.screendetect.a f59750i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Disposable f59751j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final DataCenter f59752k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Context f59753l;

    public static final class a implements ToolbarComponentCheckInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f59754a;

        /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.behavior.g$a$a, reason: collision with other inner class name */
        public static final class C0983a<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f59755a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function1 f59756b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Function0 f59757c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ long f59758d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ ToolbarMatchInterface f59759e;

            public C0983a(a r100, Function1 r101, Function0 r102, long r103, ToolbarMatchInterface r104) {
                this.f59755a = r100;
                this.f59756b = r101;
                this.f59757c = r102;
                this.f59758d = r103;
                this.f59759e = r104;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r110) {
                f0 r111 = (f0) r110;
                if (r111 == null) goto L37;
                g.q(this.f59755a.f59754a, r111);
                this.f59755a.f59754a.getClass();
                if (tb1.c.f545229a == true) goto L7;
                int r112 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
                com.bytedance.android.live.broadcastgame.opengame.q.f("MiniGameComponentConfig", new Object[]{"not support game type"});
                this.f59756b.invoke("not support game type");
                return;
            L7:
                int r100 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
                com.bytedance.android.live.broadcastgame.opengame.q.f("MiniGameComponentConfig", new Object[]{"start show toolbar icon, business type: " + r111.f60211q + ", hideUserEntrance: " + r111.f60218x});
                this.f59755a.f59754a.f59748g = r111;
                if (Intrinsics.areEqual(r111.f60219y, Boolean.TRUE) == false) goto L12;
                Disposable r101 = this.f59755a.f59754a.f59751j;
                if (r101 == null) goto L14;
                r101.dispose();
            L14:
                if (r111.f60218x == true) goto L32;
                this.f59755a.f59754a.f59752k.put("revenue_interact", Boolean.valueOf(r111.A));
                this.f59757c.invoke();
                long r102 = SystemClock.elapsedRealtime() - this.f59758d;
                OpenPlatformMonitorUtils r103 = OpenPlatformMonitorUtils.f59390c;
                g r104 = this.f59755a.f59754a;
                r103.k(r104.u(r104.f59748g), this.f59755a.f59754a.v(), r102, this.f59759e.isPreloadScene());
                String r105 = com.bytedance.android.live.broadcastgame.opengame.service.e.f60998a;
                com.bytedance.android.live.broadcastgame.opengame.service.e.e(Long.valueOf(r111.f60200f), r111.f60203i, r111.f60208n, null);
                g r106 = this.f59755a.f59754a;
                r106.getClass();
                if (x20.f121572a.getValue().booleanValue() == true) goto L39;
            L20:
                ((IInteractGameService) jc1.k.n(IInteractGameService.class)).cacheEntranceVisibility(r111.f60248a, 1);
                ((IInteractGameService) jc1.k.n(IInteractGameService.class)).consumeCacheOpenPlatformMessage(r111.f60248a, this.f59755a.f59754a.f59752k);
                g r107 = this.f59755a.f59754a;
                int r108 = com.bytedance.android.live.broadcastgame.xplay.screendetect.a.f62357c;
                Room r109 = r107.f59747f;
                if (r109 == null) goto L23;
                long r113 = r109.getRoomId();
            L24:
                Room r114 = this.f59755a.f59754a.f59747f;
                if (r114 == null) goto L28;
                String r115 = r114.getOwnerUserIdString();
                if (r115 == null) goto L28;
            L29:
                r107.f59750i = com.bytedance.android.live.broadcastgame.xplay.screendetect.a.C1031a.a(new com.bytedance.android.live.broadcastgame.xplay.screendetect.c(false, r113, r115, r111.f60200f, r111.f60248a, r111.f60203i));
                com.bytedance.android.live.broadcastgame.xplay.screendetect.a r116 = this.f59755a.f59754a.f59750i;
                if (r116 == null) goto L32;
                r116.g();
            L28:
                r115 = "";
                goto L29
            L23:
                r113 = 0;
                goto L24
            L39:
                ThreadPoolHelper.d().execute(new q(r106, r102));     // Catch: Exception -> L19
            L32:
                AudienceGameContext.Companion.getClass();
                AudienceGameContext r117 = AudienceGameContext.a.a();
                if (r117 == null) goto L42;
                com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.model.h> r118 = r117.getAnchorCurrentGameIconInfo();
                if (r118 == null) goto L43;
                r118.setValue(new com.bytedance.android.live.broadcastgame.api.model.h(r111.f60248a, r111.f60203i, r111.f60204j));
                return;
            L43:
                return;
            L42:
                return;
            L12:
                g.r(this.f59755a.f59754a);
                goto L14
            L37:
                this.f59756b.invoke("ENTRANCE_INVISIBLE");
            }
        }

        public static final class b<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f59760a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function1 f59761b;

            public b(a r100, Function1 r101) {
                this.f59760a = r100;
                this.f59761b = r101;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                int r101 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
                com.bytedance.android.live.broadcastgame.opengame.q.k("MiniGameComponentConfig", new Object[]{"load small rocker fail, " + ((Throwable) r100)});
                this.f59761b.invoke("ENTRANCE_INVISIBLE");
                IInteractGameService r102 = (IInteractGameService) jc1.k.n(IInteractGameService.class);
                f0 r103 = this.f59760a.f59754a.f59748g;
                String r104 = "";
                if (r103 == null) goto L6;
                String r105 = r103.f60248a;
                if (r105 == null) goto L6;
            L7:
                r102.cacheEntranceVisibility(r105, 0);
                IInteractGameService r106 = (IInteractGameService) jc1.k.n(IInteractGameService.class);
                g r107 = this.f59760a.f59754a;
                f0 r108 = r107.f59748g;
                if (r108 == null) goto L13;
                String r109 = r108.f60248a;
                if (r109 == null) goto L13;
                r104 = r109;
            L13:
                r106.consumeCacheOpenPlatformMessage(r104, r107.f59752k);
                return;
            L6:
                r105 = "";
                goto L7
            }
        }

        public a(g r100) {
            this.f59754a = r100;
        }

        @Override // com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface
        public final boolean checkThenLoad(ToolbarMatchInterface r110, Function0<Unit> r111, Function1<? super String, Unit> r112) {
            Intrinsics.checkNotNullParameter(r110, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
            Intrinsics.checkNotNullParameter(r111, "loadButton");
            Intrinsics.checkNotNullParameter(r112, "stopLoadCallback");
            int r100 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("MiniGameComponentConfig", new Object[]{"prepare load small rocker on toolbar, this=" + this.f59754a + ", pre=" + r110.isPreloadScene()});
            if (r110.isPreloadScene() == false) goto L6;
            g r101 = this.f59754a;
            r101.getClass();
            RxUtilKt.c(r101.t(r110, r110.isPreloadScene()).subscribe(new m(r101, r111, r112), new n(r112)), r101.f59749h);
            return true;
        L6:
            RxUtilKt.c(this.f59754a.t(r110, r110.isPreloadScene()).subscribe(new C0983a(this, r112, r111, SystemClock.elapsedRealtime(), r110), new b(this, r112)), this.f59754a.f59749h);
            return true;
        }
    }

    public static final class b implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f59762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Observer f59763b;

        public b(g r100, f r101) {
            this.f59762a = r100;
            this.f59763b = r101;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            Lazy r100 = ToolbarComponentCheckManager.f115947a;
            ToolbarComponentCheckManager.g(this.f59762a.f59752k, NewToolbarButtonConstants.MiniGame.INSTANCE);
            this.f59762a.f59752k.removeObserver("cmd_specific_behavior_un_loaded", this.f59763b);
            this.f59762a.f59752k.removeObserver("data_link_state", this.f59763b);
        }
    }

    public static final class c {
    }

    public static final class d<T> implements ObservableOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f59764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ToolbarMatchInterface f59765b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f59766c;

        public d(g r100, ToolbarMatchInterface r101, boolean r102) {
            this.f59764a = r100;
            this.f59765b = r101;
            this.f59766c = r102;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<e0> r100) {
            Intrinsics.checkNotNullParameter(r100, "emitter");
            String r101 = this.f59765b.getComponentExtra();
            int r102 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("MiniGameComponentConfig", new Object[]{"receive toolbar message, " + r101});
            Object r103 = null;
            if (this.f59766c == false) goto L54;
            this.f59764a.getClass();
            Type r104 = new j().getType();
            Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L7
            Object r106 = Result.m9449constructorimpl((List) GsonHelper.get().fromJson(r101, r104));     // Catch: Throwable -> L7
        L10:
            if (Result.m9455isFailureimpl(r106) == false) goto L12;
            r106 = null;
        L12:
            List r107 = (List) r106;
            if (r107 != null) goto L15;
            r107 = CollectionsKt.emptyList();
        L15:
            RoomStampInfo r108 = (RoomStampInfo) CollectionsKt.firstOrNull(r107);
            if (r108 == null) goto L48;
            e0 r109 = new e0();
            r109.appId = r108.getId();
            Gson r110 = GsonHelper.get();     // Catch: Throwable -> L26
            String r111 = r108.getEntrances();     // Catch: Throwable -> L26
            if (r111 != null) goto L21;
            r111 = "";
        L21:
            e0 r112 = (e0) r110.fromJson(r111, e0.class);     // Catch: Throwable -> L26
            e0 r113 = r112;
            if (r112 != null) goto L24;
            r113 = r109;
        L24:
            Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L26
        L28:
            Object r115 = r109;
            if (Result.m9455isFailureimpl(r114) == true) goto L32;
            r115 = r114;
        L32:
            r103 = (e0) r115;
        L26:
            th = move-exception;
            Result.Companion r116 = Result.Companion;
            r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        L48:
            if (r103 == null) goto L50;
            r100.onNext(r103);
            return;
        L50:
            r100.onError(new Exception("invalid extras, " + r101));
            return;
        L7:
            th = move-exception;
            Result.Companion r117 = Result.Companion;
            r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L10
        L54:
            Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L41
            mh r119 = (mh) GsonHelper.get().fromJson(r101, mh.class);     // Catch: Throwable -> L41
            if (r119 == null) goto L38;
            List<e0> r120 = r119.entrances;     // Catch: Throwable -> L41
            if (r120 == null) goto L38;
            e0 r121 = (e0) CollectionsKt.firstOrNull(r120);     // Catch: Throwable -> L41
        L39:
            Object r122 = Result.m9449constructorimpl(r121);     // Catch: Throwable -> L41
        L44:
            if (Result.m9455isFailureimpl(r122) == true) goto L47;
            r103 = r122;
        L47:
            r103 = (e0) r103;
        L38:
            r121 = null;
        L41:
            th = move-exception;
            Result.Companion r123 = Result.Companion;
            r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L44
        }
    }

    public static final class e<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f59767a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f59768b;

        public e(g r100, boolean r101) {
            this.f59767a = r100;
            this.f59768b = r101;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            e0 r101 = (e0) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            int r102 = r101.visibleType;
            int r103 = hn.f153654a;
            if (r102 != 1) goto L8;
            f0 r104 = com.bytedance.android.live.broadcastgame.opengame.message.l.a(r101, this.f59768b ? 1 : 0);
            if (r104 == null) goto L10;
            com.bytedance.revenue.platform.api.core.rx.l r105 = com.bytedance.revenue.platform.api.core.rx.l.f267516a;
            return Observable.just(r104);
        L10:
            int r106 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("MiniGameComponentConfig", new Object[]{"request entrance visible v2, entranceExtra: " + r101.entranceExtra + ", extra: " + r101.extra});
            long r107 = SystemClock.elapsedRealtime();
            AudienceGameNetApi r108 = (AudienceGameNetApi) com.bytedance.android.live.network.c.b().e(AudienceGameNetApi.class);
            Room r109 = this.f59767a.f59747f;
            if (r109 == null) goto L13;
            long r110 = r109.getRoomId();
        L14:
            String r111 = r101.appId;
            if (r111 != null) goto L18;
            r111 = "";
        L18:
            return r108.getEntranceVisibleV2(r110, r111).compose(RxUtil.rxSchedulerHelper()).map(new h(this, r107)).doOnError(new i(this, r107));
        L13:
            r110 = 0;
            goto L14
        L8:
            if (r102 != 3) goto L10;
            com.bytedance.revenue.platform.api.core.rx.l r112 = com.bytedance.revenue.platform.api.core.rx.l.f267516a;
            return Observable.error(new Exception("name: " + r101.name + ", visible type: " + r101.visibleType));
        }
    }

    public static final class f<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f59769a;

        public f(g r100) {
            this.f59769a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            KVData r101 = (KVData) r100;
            if (Intrinsics.areEqual(r101.getKey(), "cmd_specific_behavior_un_loaded") == false) goto L22;
            ToolbarBehaviorData r102 = (ToolbarBehaviorData) r101.getData();
            if (r102 != null) goto L7;
            return;
        L7:
            if (r102.getId() == 6) goto L9;
            return;
        L9:
            if (r102.isFold() == true) goto L32;
            int r103 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("MiniGameComponentConfig", new Object[]{"receive unload icon event"});
            f0 r104 = this.f59769a.f59748g;
            if (r104 == null) goto L20;
            r104.f60212r = 2;
            g.s();
            com.bytedance.android.live.broadcastgame.opengame.q.f("MiniGameComponentConfig", new Object[]{"clear resource"});
            g.q(this.f59769a, r104);
            this.f59769a.f59752k.put("revenue_interact", Boolean.FALSE);
            ((IInteractGameService) jc1.k.n(IInteractGameService.class)).clearCache();
            OpenPlatformMonitorUtils.f59390c.h(this.f59769a.u(r104), this.f59769a.v());
            AudienceGameContext.Companion.getClass();
            AudienceGameContext r105 = AudienceGameContext.a.a();
            if (r105 == null) goto L17;
            com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.model.h> r106 = r105.getAnchorCurrentGameIconInfo();
            if (r106 == null) goto L17;
            r106.setValue(null);
        L17:
            com.bytedance.android.live.broadcastgame.xplay.screendetect.a r107 = this.f59769a.f59750i;
            if (r107 == null) goto L20;
            r107.f();
        L20:
            this.f59769a.f59748g = null;
            return;
        L32:
            return;
        L22:
            if (Intrinsics.areEqual(r101.getKey(), "data_link_state") == false) goto L34;
            Integer r108 = (Integer) r101.getData();
            if (r108 != null) goto L27;
            r108 = 0;
        L27:
            if (r108.intValue() != 32) goto L35;
            this.f59769a.getClass();
            g.s();
            return;
        L35:
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.behavior.g$g, reason: collision with other inner class name */
    public static final class C0984g extends b7.a {
        public C0984g() {
        }

        @Override // b7.a, b7.b
        public final boolean onFallback(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "errorMessage");
            int r102 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
            com.bytedance.android.live.broadcastgame.opengame.q.e("MiniGameComponentConfig", new Object[]{"show magic box lynx dialog failed, errorCode: " + r100 + ", errorMesage: " + r101});
            return super.onFallback(r100, r101);
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final w j() {
        return new w(ToolbarButton.OPEN_PLATFORM_MINI_GAME, null, null, null);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final boolean m() {
        if (oz0.f120943a.getValue().booleanValue() == false) goto L6;
        return false;
    L6:
        return super.m();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final void p() {
        if (oz0.f120943a.getValue().booleanValue() == false) goto L15;
        s();
        Disposable r100 = this.f59751j;
        if (r100 == null) goto L7;
        r100.dispose();
    L7:
        CompositeDisposable r101 = this.f59749h;
        if (r101 == null) goto L10;
        r101.dispose();
    L10:
        this.f59747f = null;
        this.f59748g = null;
        com.bytedance.android.live.broadcastgame.xplay.screendetect.a r102 = this.f59750i;
        if (r102 == null) goto L13;
        r102.f();
    L13:
        this.f59750i = null;
        return;
    }

    public final com.bytedance.android.live.broadcastgame.api.openplatform.e v() {
        return new com.bytedance.android.live.broadcastgame.api.openplatform.e(this.f59747f, SourceType.DEFAULT, 12);
    }

    public final void w() {
        int r100 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("MiniGameComponentConfig", new Object[]{"show magic box lynx dialog"});
        f0 r101 = this.f59748g;
        Long r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.B;
    L6:
        if (r103 != null) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == false) goto L14;
        r103 = ve.f121442a.getValue();
    L14:
        if (r103 != null) goto L16;
    L19:
        boolean r105 = true;
    L20:
        if (r105 == false) goto L22;
    L50:
        com.bytedance.android.live.broadcastgame.opengame.q.e("MiniGameComponentConfig", new Object[]{"show magic box lynx dialog failed, entranceMessage: " + this.f59748g + ", url: " + r103});
        return;
    L22:
        if (this.f59748g == null) goto L50;
        u6 r106 = new u6(r103);
        u6 r107 = r106.d("url");
        f0 r108 = this.f59748g;
        String r109 = "";
        if (r108 == null) goto L28;
        String r110 = r108.f60248a;
        if (r110 == null) goto L28;
    L29:
        r107.b("mini_app_id", r110);
        f0 r111 = this.f59748g;
        if (r111 != null) goto L32;
    L41:
        Uri r112 = r106.c();
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L44
        Object r114 = Result.m9449constructorimpl(((IBrowserService) jc1.k.n(IBrowserService.class)).showHybridDialog(this.f59753l, r112, new C0984g()));     // Catch: Throwable -> L44
    L46:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);
        if (r115 == null) goto L54;
        int r116 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
        com.bytedance.android.live.broadcastgame.opengame.q.e("MiniGameComponentConfig", new Object[]{"Magic box lynx start failed, cause: " + r115.getCause() + ", message: " + r115.getMessage()});
        return;
    L54:
        return;
    L44:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L46
    L32:
        if (r111.A != true) goto L41;
        boolean r118 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        p11.j r119 = ((ILinkService) com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class)).getRevenueLinkDataHolder();
        if (r119 == null) goto L36;
        r102 = Long.valueOf(r119.getChannelId());
    L36:
        String r120 = String.valueOf(r102.longValue());
        if (r120 == null) goto L40;
        r109 = r120;
    L40:
        r107.b("channel_id", r109);
    L28:
        r110 = "";
        goto L29
    L16:
        if (r103.length() == 0) goto L19;
        r105 = false;
        goto L20
    L8:
        if (r103.length() == 0) goto L11;
        r104 = false;
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    public static void s() {
        ILivePlayerClient r100 = LivePlatformPlayerManager.f();
        if (r100 == null) goto L7;
        IRoomEventHub r101 = r100.getEventHub();
        if (r101 == null) goto L7;
        MutableLiveData<WtnPlayEvent> r102 = r101.getWtnPlayEvent();
    L8:
        if (r102 == null) goto L17;
        WtnPlayEvent r103 = r102.getValue();
        if (r103 != null) goto L12;
        return;
    L12:
        if (r103.getState() != WtnPlayEvent.Companion.getSTATE_PLAYING()) goto L19;
        ILivePlayerClient r104 = LivePlatformPlayerManager.f();
        if (r104 == null) goto L20;
        r104.closeWtnPlay();
        return;
    L20:
        return;
    L19:
        return;
    L17:
        return;
    L7:
        r102 = null;
        goto L8
    }

    public final Context getContext() {
        return this.f59753l;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final NewToolbarButtonConstants k() {
        return NewToolbarButtonConstants.MiniGame.INSTANCE;
    }

    public static final void r(g r100) {
        r100.getClass();
        r100.f59751j = xs2.b.a().b(com.bytedance.android.live.broadcastgame.api.openplatform.f.class).subscribe(new p(new MiniGameComponentConfig$registerShowPanelEvent$1(r100)), new o(r100));
    }

    public final com.bytedance.android.live.broadcastgame.api.openplatform.d u(f0 r100) {
        if (r100 != null) goto L15;
        f0 r101 = this.f59748g;
        String r102 = null;
        if (r101 == null) goto L7;
        String r103 = r101.f60248a;
    L8:
        if (r101 == null) goto L10;
        String r104 = r101.f60203i;
    L11:
        if (r101 == null) goto L14;
        r102 = r101.f60202h;
    L14:
        return new com.bytedance.android.live.broadcastgame.api.openplatform.d(r103, r104, r102);
    L10:
        r104 = null;
        goto L11
    L7:
        r103 = null;
        goto L8
    L15:
        return new com.bytedance.android.live.broadcastgame.api.openplatform.d(r100.f60248a, r100.f60203i, r100.f60202h);
    }

    public g(DataCenter r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Room r102 = null;
        super(null, null, 7);
        this.f59752k = r100;
        this.f59753l = r101;
        if (oz0.f120943a.getValue().booleanValue() == false) goto L11;
        RoomContext r103 = RoomContext.a.c(RoomContext.Companion, r100, 0, 2);
        if (r103 == null) goto L9;
        com.bytedance.live.datacontext.m<Room> r104 = r103.getRoom();
        if (r104 == null) goto L9;
        r102 = r104.getValue();
    L9:
        this.f59747f = r102;
        CompositeDisposable r105 = new CompositeDisposable();
        this.f59749h = r105;
        Lazy r106 = ToolbarComponentCheckManager.f115947a;
        ToolbarComponentCheckManager.e(r100, NewToolbarButtonConstants.MiniGame.INSTANCE, new a(this));
        f r107 = new f(this);
        r100.observe("cmd_specific_behavior_un_loaded", r107);
        r100.observe("data_link_state", r107);
        RxUtilKt.c(Disposables.fromAction(new b(this, r107)), r105);
        return;
    }

    public static final void q(g r110, f0 r111) {
        r110.getClass();
        int r100 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("MagicBoxBehavior", new Object[]{"receive entrance msg from anchor, name: ", r111.f60203i, ", appId: ", r111.f60248a, ", status: ", Integer.valueOf(r111.f60212r)});
        if (r111.f60212r != 1) goto L5;
        boolean r101 = true;
    L6:
        Object r102 = bi1.a(Boolean.valueOf(r101), "start");
        if (r102 != null) goto L9;
        r102 = "stop";
    L9:
        String r103 = (String) r102;
        if (r111.f60215u != 1) goto L12;
        boolean r104 = true;
    L13:
        OpenPlatformMonitorUtils.f59390c.n(r110.u(r111), r110.v(), r104, r103, r111.f60214t);
        InteractGameContext r112 = InteractGameContext.Companion.getContext();
        if (r112 == null) goto L19;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.model.i> r113 = r112.getGameOpenInfo();
        if (r113 == null) goto L20;
        r113.setValue(new com.bytedance.android.live.broadcastgame.api.model.i(r111.f60248a, r111.f60200f, r111.f60203i, r111.C, r111.D));
        return;
    L20:
        return;
    L19:
        return;
    L12:
        r104 = false;
        goto L13
    L5:
        r101 = false;
        goto L6
    }

    public final Observable<f0> t(ToolbarMatchInterface r100, boolean r101) {
        if (r100.getSource() != 0) goto L5;
        boolean r102 = true;
    L6:
        OpenPlatformMonitorUtils.f59390c.j(u(this.f59748g), v(), r102, r101);
        com.bytedance.revenue.platform.api.core.rx.l r103 = com.bytedance.revenue.platform.api.core.rx.l.f267516a;
        return Observable.create(new d(this, r100, r102)).flatMap(new e(this, r102));
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final c0.b g(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "button");
        return new MiniGameToolbarBehavior();
    }
}
