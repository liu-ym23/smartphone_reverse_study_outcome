package com.bytedance.android.live.broadcastgame;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.broadcastgame.api.openplatform.OpenPlatformMonitorUtils;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ToolbarComponentCheckManager;
import com.bytedance.android.livesdk.config.bi1;
import com.bytedance.android.livesdk.config.oz0;
import com.bytedance.android.livesdk.config.ve;
import com.bytedance.android.livesdk.config.x20;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.WtnPlayEvent;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.livesdkapi.toolbar.ToolbarBehaviorData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.thread.ThreadPoolHelper;
import com.tencent.open.SocialConstants;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements k0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f59262i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Room f59263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.live.broadcastgame.opengame.message.f0 f59264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f59265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.live.broadcastgame.xplay.screendetect.a f59266d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f59267e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super com.bytedance.android.live.broadcastgame.opengame.message.f0, Unit> f59268f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f59269g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DataCenter f59270h;

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.a$a, reason: collision with other inner class name */
    public static final class C0976a implements ToolbarComponentCheckInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f59271a;

        /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.a$a$a, reason: collision with other inner class name */
        public static final class C0977a<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C0976a f59272a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function1 f59273b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Function0 f59274c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ long f59275d;

            public C0977a(C0976a r100, Function1 r101, Function0 r102, long r103) {
                this.f59272a = r100;
                this.f59273b = r101;
                this.f59274c = r102;
                this.f59275d = r103;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r110) {
                com.bytedance.android.live.broadcastgame.opengame.message.f0 r111 = (com.bytedance.android.live.broadcastgame.opengame.message.f0) r110;
                if (r111 == null) goto L41;
                a.b(this.f59272a.f59271a, r111);
                this.f59272a.f59271a.getClass();
                if (tb1.c.f545229a == true) goto L7;
                int r112 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
                com.bytedance.android.live.broadcastgame.opengame.q.f("MagicBoxBehaviorV2", new Object[]{"not support game type"});
                this.f59273b.invoke("not support game type");
                return;
            L7:
                int r100 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
                com.bytedance.android.live.broadcastgame.opengame.q.f("MagicBoxBehaviorV2", new Object[]{"start show toolbar icon, business type: " + r111.f60211q + ", hideUserEntrance: " + r111.f60218x});
                this.f59272a.f59271a.f59264b = r111;
                if (Intrinsics.areEqual(r111.f60219y, Boolean.TRUE) == false) goto L16;
                Disposable r101 = this.f59272a.f59271a.f59267e;
                if (r101 == null) goto L12;
                r101.dispose();
            L12:
                Function1<? super com.bytedance.android.live.broadcastgame.opengame.message.f0, Unit> r102 = this.f59272a.f59271a.f59268f;
                if (r102 != null) goto L15;
                Intrinsics.throwUninitializedPropertyAccessException("sonicPluginMessageReceiver");
            L15:
                r102.invoke(r111);
            L18:
                if (r111.f60218x == true) goto L36;
                this.f59272a.f59271a.f59270h.put("revenue_interact", Boolean.valueOf(r111.A));
                this.f59274c.invoke();
                long r103 = SystemClock.elapsedRealtime() - this.f59275d;
                OpenPlatformMonitorUtils r104 = OpenPlatformMonitorUtils.f59390c;
                a r105 = this.f59272a.f59271a;
                OpenPlatformMonitorUtils.f59390c.k(r105.e(r105.f59264b), this.f59272a.f59271a.f(), r103, false);
                String r106 = com.bytedance.android.live.broadcastgame.opengame.service.e.f60998a;
                com.bytedance.android.live.broadcastgame.opengame.service.e.e(Long.valueOf(r111.f60200f), r111.f60203i, r111.f60248a, r111.f60208n);
                a r107 = this.f59272a.f59271a;
                r107.getClass();
                if (x20.f121572a.getValue().booleanValue() == true) goto L43;
            L24:
                ((IInteractGameService) jc1.k.n(IInteractGameService.class)).cacheEntranceVisibility(r111.f60248a, 1);
                ((IInteractGameService) jc1.k.n(IInteractGameService.class)).consumeCacheOpenPlatformMessage(r111.f60248a, this.f59272a.f59271a.f59270h);
                a r108 = this.f59272a.f59271a;
                int r109 = com.bytedance.android.live.broadcastgame.xplay.screendetect.a.f62357c;
                Room r113 = r108.f59263a;
                if (r113 == null) goto L27;
                long r114 = r113.getRoomId();
            L28:
                Room r115 = this.f59272a.f59271a.f59263a;
                if (r115 == null) goto L32;
                String r116 = r115.getOwnerUserIdString();
                if (r116 == null) goto L32;
            L33:
                r108.f59266d = com.bytedance.android.live.broadcastgame.xplay.screendetect.a.C1031a.a(new com.bytedance.android.live.broadcastgame.xplay.screendetect.c(false, r114, r116, r111.f60200f, r111.f60248a, r111.f60203i));
                com.bytedance.android.live.broadcastgame.xplay.screendetect.a r117 = this.f59272a.f59271a.f59266d;
                if (r117 == null) goto L36;
                r117.g();
            L32:
                r116 = "";
                goto L33
            L27:
                r114 = 0;
                goto L28
            L43:
                ThreadPoolHelper.d().execute(new k(r107, r103));     // Catch: Exception -> L23
            L36:
                AudienceGameContext.Companion.getClass();
                AudienceGameContext r118 = AudienceGameContext.a.a();
                if (r118 == null) goto L46;
                com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.model.h> r119 = r118.getAnchorCurrentGameIconInfo();
                if (r119 == null) goto L47;
                r119.setValue(new com.bytedance.android.live.broadcastgame.api.model.h(r111.f60248a, r111.f60203i, r111.f60204j));
                return;
            L47:
                return;
            L46:
                return;
            L16:
                a.c(this.f59272a.f59271a);
                goto L18
            L41:
                this.f59273b.invoke("ENTRANCE_INVISIBLE");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.a$a$b */
        public static final class b<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C0976a f59276a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function1 f59277b;

            public b(C0976a r100, Function1 r101) {
                this.f59276a = r100;
                this.f59277b = r101;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                int r101 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
                com.bytedance.android.live.broadcastgame.opengame.q.k("MagicBoxBehaviorV2", new Object[]{"load small rocker fail, " + ((Throwable) r100)});
                this.f59277b.invoke("ENTRANCE_INVISIBLE");
                IInteractGameService r102 = (IInteractGameService) jc1.k.n(IInteractGameService.class);
                com.bytedance.android.live.broadcastgame.opengame.message.f0 r103 = this.f59276a.f59271a.f59264b;
                String r104 = "";
                if (r103 == null) goto L6;
                String r105 = r103.f60248a;
                if (r105 == null) goto L6;
            L7:
                r102.cacheEntranceVisibility(r105, 0);
                IInteractGameService r106 = (IInteractGameService) jc1.k.n(IInteractGameService.class);
                a r107 = this.f59276a.f59271a;
                com.bytedance.android.live.broadcastgame.opengame.message.f0 r108 = r107.f59264b;
                if (r108 == null) goto L13;
                String r109 = r108.f60248a;
                if (r109 == null) goto L13;
                r104 = r109;
            L13:
                r106.consumeCacheOpenPlatformMessage(r104, r107.f59270h);
                return;
            L6:
                r105 = "";
                goto L7
            }
        }

        public C0976a(a r100) {
            this.f59271a = r100;
        }

        @Override // com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface
        public final boolean checkThenLoad(ToolbarMatchInterface r110, Function0<Unit> r111, Function1<? super String, Unit> r112) {
            Intrinsics.checkNotNullParameter(r110, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
            Intrinsics.checkNotNullParameter(r111, "loadButton");
            Intrinsics.checkNotNullParameter(r112, "stopLoadCallback");
            int r100 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("MagicBoxBehaviorV2", new Object[]{"prepare load small rocker on toolbar, this=" + this.f59271a + ", pre=" + r110.isPreloadScene()});
            long r101 = SystemClock.elapsedRealtime();
            a r102 = this.f59271a;
            r102.getClass();
            if (r110.getSource() != 0) goto L5;
            boolean r103 = true;
        L6:
            OpenPlatformMonitorUtils.f59390c.j(r102.e(r102.f59264b), r102.f(), r103, false);
            com.bytedance.revenue.platform.api.core.rx.l r104 = com.bytedance.revenue.platform.api.core.rx.l.f267516a;
            RxUtilKt.c(Observable.create(new com.bytedance.android.live.broadcastgame.b(r102, r110, r103)).flatMap(new com.bytedance.android.live.broadcastgame.e(r102, r103)).subscribe(new C0977a(this, r112, r111, r101), new b(this, r112)), this.f59271a.f59265c);
            return true;
        L5:
            r103 = false;
            goto L6
        }
    }

    public static final class b implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f59278a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Observer f59279b;

        public b(a r100, d r101) {
            this.f59278a = r100;
            this.f59279b = r101;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            Lazy r100 = ToolbarComponentCheckManager.f115947a;
            ToolbarComponentCheckManager.g(this.f59278a.f59270h, NewToolbarButtonConstants.MiniGame.INSTANCE);
            this.f59278a.f59270h.removeObserver("cmd_specific_behavior_un_loaded", this.f59279b);
        }
    }

    public static final class c {
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f59280a;

        public d(a r100) {
            this.f59280a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            KVData r101 = (KVData) r100;
            ToolbarBehaviorData r102 = (ToolbarBehaviorData) r101.getData();
            if (Intrinsics.areEqual(r101.getKey(), "cmd_specific_behavior_un_loaded") == false) goto L24;
            if (r102 != null) goto L6;
            return;
        L6:
            if (r102.getId() == 6) goto L8;
            return;
        L8:
            if (r102.isFold() == true) goto L27;
            int r103 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("MagicBoxBehaviorV2", new Object[]{"receive unload icon event"});
            com.bytedance.android.live.broadcastgame.opengame.message.f0 r104 = this.f59280a.f59264b;
            if (r104 == null) goto L22;
            r104.f60212r = 2;
            a.d();
            com.bytedance.android.live.broadcastgame.opengame.q.f("MagicBoxBehaviorV2", new Object[]{"clear resource"});
            a.b(this.f59280a, r104);
            this.f59280a.f59270h.put("revenue_interact", Boolean.FALSE);
            Function1<? super com.bytedance.android.live.broadcastgame.opengame.message.f0, Unit> r105 = this.f59280a.f59268f;
            if (r105 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("sonicPluginMessageReceiver");
        L14:
            r105.invoke(r104);
            ((IInteractGameService) jc1.k.n(IInteractGameService.class)).clearCache();
            OpenPlatformMonitorUtils.f59390c.h(this.f59280a.e(r104), this.f59280a.f());
            AudienceGameContext.Companion.getClass();
            AudienceGameContext r106 = AudienceGameContext.a.a();
            if (r106 == null) goto L19;
            com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.model.h> r107 = r106.getAnchorCurrentGameIconInfo();
            if (r107 == null) goto L19;
            r107.setValue(null);
        L19:
            com.bytedance.android.live.broadcastgame.xplay.screendetect.a r108 = this.f59280a.f59266d;
            if (r108 == null) goto L22;
            r108.f();
        L22:
            this.f59280a.f59264b = null;
            return;
        L27:
            return;
        }
    }

    public static final class e extends b7.a {
        public e() {
        }

        @Override // b7.a, b7.b
        public final boolean onFallback(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "errorMessage");
            int r102 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
            com.bytedance.android.live.broadcastgame.opengame.q.e("MagicBoxBehaviorV2", new Object[]{"show magic box lynx dialog failed, errorCode: " + r100 + ", errorMesage: " + r101});
            return super.onFallback(r100, r101);
        }
    }

    static {
    }

    public final com.bytedance.android.live.broadcastgame.api.openplatform.e f() {
        return new com.bytedance.android.live.broadcastgame.api.openplatform.e(this.f59263a, SourceType.DEFAULT, 12);
    }

    public final void g() {
        int r100 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("MagicBoxBehaviorV2", new Object[]{"show magic box lynx dialog"});
        com.bytedance.android.live.broadcastgame.opengame.message.f0 r101 = this.f59264b;
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
        com.bytedance.android.live.broadcastgame.opengame.q.e("MagicBoxBehaviorV2", new Object[]{"show magic box lynx dialog failed, entranceMessage: " + this.f59264b + ", url: " + r103});
        return;
    L22:
        if (this.f59264b == null) goto L50;
        u6 r106 = new u6(r103);
        u6 r107 = r106.d("url");
        com.bytedance.android.live.broadcastgame.opengame.message.f0 r108 = this.f59264b;
        String r109 = "";
        if (r108 == null) goto L28;
        String r110 = r108.f60248a;
        if (r110 == null) goto L28;
    L29:
        r107.b("mini_app_id", r110);
        com.bytedance.android.live.broadcastgame.opengame.message.f0 r111 = this.f59264b;
        if (r111 != null) goto L32;
    L41:
        Uri r112 = r106.c();
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L44
        Object r114 = Result.m9449constructorimpl(((IBrowserService) jc1.k.n(IBrowserService.class)).showHybridDialog(this.f59269g, r112, new e()));     // Catch: Throwable -> L44
    L46:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);
        if (r115 == null) goto L54;
        int r116 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
        com.bytedance.android.live.broadcastgame.opengame.q.e("MagicBoxBehaviorV2", new Object[]{"Magic box lynx start failed, cause: " + r115.getCause() + ", message: " + r115.getMessage()});
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

    @Override // com.bytedance.android.live.broadcastgame.k0
    public final void onDestroy() {
        if (oz0.f120943a.getValue().booleanValue() == true) goto L15;
        d();
        Disposable r100 = this.f59267e;
        if (r100 == null) goto L7;
        r100.dispose();
    L7:
        CompositeDisposable r101 = this.f59265c;
        if (r101 == null) goto L10;
        r101.dispose();
    L10:
        this.f59263a = null;
        this.f59264b = null;
        com.bytedance.android.live.broadcastgame.xplay.screendetect.a r102 = this.f59266d;
        if (r102 == null) goto L13;
        r102.f();
    L13:
        this.f59266d = null;
        return;
    }

    public static void d() {
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
        return this.f59269g;
    }

    public static final void c(a r100) {
        r100.getClass();
        r100.f59267e = xs2.b.a().b(com.bytedance.android.live.broadcastgame.api.openplatform.f.class).subscribe(new j(new AudienceInteractPlayBehavior$registerShowPanelEvent$1(r100)), new i(r100));
    }

    @Override // com.bytedance.android.live.broadcastgame.k0
    public final void a(Function1<? super com.bytedance.android.live.broadcastgame.opengame.message.f0, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_RECEIVER);
        this.f59268f = r100;
    }

    public final com.bytedance.android.live.broadcastgame.api.openplatform.d e(com.bytedance.android.live.broadcastgame.opengame.message.f0 r100) {
        if (r100 != null) goto L15;
        com.bytedance.android.live.broadcastgame.opengame.message.f0 r101 = this.f59264b;
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

    public a(Context r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f59269g = r100;
        this.f59270h = r101;
        if (oz0.f120943a.getValue().booleanValue() == true) goto L24;
        RoomContext.a r102 = RoomContext.Companion;
        RoomContext r103 = RoomContext.a.c(r102, r101, 0, 2);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.o r104 = null;
        if (r103 == null) goto L9;
        com.bytedance.live.datacontext.m<Room> r105 = r103.getRoom();
        if (r105 == null) goto L9;
        Room r106 = r105.getValue();
    L10:
        this.f59263a = r106;
        CompositeDisposable r107 = new CompositeDisposable();
        this.f59265c = r107;
        RoomContext r108 = RoomContext.a.c(r102, r101, 0, 2);
        if (r108 == null) goto L15;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.o> r109 = r108.getTbCompConfigRegister();
        if (r109 == null) goto L15;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.o r110 = r109.getValue();
    L17:
        if ((r110 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.o) == false) goto L20;
        r104 = r110;
    L20:
        if (r104 == null) goto L22;
        r104.register(new com.bytedance.android.live.broadcastgame.opengame.behavior.g(r101, r100));
    L22:
        Lazy r111 = ToolbarComponentCheckManager.f115947a;
        ToolbarComponentCheckManager.e(r101, NewToolbarButtonConstants.MiniGame.INSTANCE, new C0976a(this));
        d r112 = new d(this);
        r101.observe("cmd_specific_behavior_un_loaded", r112);
        RxUtilKt.c(Disposables.fromAction(new b(this, r112)), r107);
        return;
    L15:
        r110 = null;
    L9:
        r106 = null;
        goto L10
    }

    public static final void b(a r110, com.bytedance.android.live.broadcastgame.opengame.message.f0 r111) {
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
        OpenPlatformMonitorUtils.f59390c.n(r110.e(r111), r110.f(), r104, r103, r111.f60214t);
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
}
