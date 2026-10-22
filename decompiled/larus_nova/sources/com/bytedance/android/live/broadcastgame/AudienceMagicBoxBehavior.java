package com.bytedance.android.live.broadcastgame;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.broadcastgame.api.openplatform.OpenPlatformMonitorUtils;
import com.bytedance.android.live.broadcastgame.opengame.network.AudienceGameNetApi;
import com.bytedance.android.live.broadcastgame.opengame.network.OpenGameApi;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ToolbarComponentCheckManager;
import com.bytedance.android.livesdk.config.bi1;
import com.bytedance.android.livesdk.config.oz0;
import com.bytedance.android.livesdk.config.ve;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdk.message.model.mh;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomStampInfo;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.open.SocialConstants;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
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
public final class AudienceMagicBoxBehavior implements k0, vlc.l {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f59238k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Room f59239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public vlc.d f59240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.live.broadcastgame.opengame.message.f0 f59241c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f59242d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.live.broadcastgame.xplay.screendetect.a f59243e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Disposable f59244f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function1<? super com.bytedance.android.live.broadcastgame.opengame.message.f0, Unit> f59245g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f59246h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Context f59247i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final DataCenter f59248j;

    public static final class a implements ToolbarComponentCheckInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudienceMagicBoxBehavior f59249a;

        public a(AudienceMagicBoxBehavior r100) {
            this.f59249a = r100;
        }

        @Override // com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface
        public final boolean checkThenLoad(ToolbarMatchInterface r100, final Function0<Unit> r110, final Function1<? super String, Unit> r111) {
            Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
            Intrinsics.checkNotNullParameter(r110, "loadButton");
            Intrinsics.checkNotNullParameter(r111, "stopLoadCallback");
            final AudienceMagicBoxBehavior r101 = this.f59249a;
            r101.getClass();
            String r102 = r100.getComponentExtra();
            r101.f59246h = SystemClock.elapsedRealtime();
            int r103 = r100.getSource();
            Object r104 = null;
            if (r103 == 0) goto L27;
            if (r103 != 1) goto L56;
            OpenPlatformMonitorUtils.f59390c.j(r101.c(r101.f59241c), r101.d(), false, false);
            Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L17
            mh r106 = (mh) GsonHelper.get().fromJson(r102, mh.class);     // Catch: Throwable -> L17
            if (r106 == null) goto L14;
            List<com.bytedance.android.livesdk.message.model.e0> r107 = r106.entrances;     // Catch: Throwable -> L17
            if (r107 == null) goto L14;
            com.bytedance.android.livesdk.message.model.e0 r108 = (com.bytedance.android.livesdk.message.model.e0) CollectionsKt.firstOrNull(r107);     // Catch: Throwable -> L17
            if (r108 == null) goto L14;
            com.bytedance.android.live.broadcastgame.opengame.message.f0 r109 = com.bytedance.android.live.broadcastgame.opengame.message.l.a(r108, 0);     // Catch: Throwable -> L17
        L15:
            Object r112 = Result.m9449constructorimpl(r109);     // Catch: Throwable -> L17
        L20:
            if (Result.m9455isFailureimpl(r112) == true) goto L23;
            r104 = r112;
        L23:
            com.bytedance.android.live.broadcastgame.opengame.message.f0 r113 = (com.bytedance.android.live.broadcastgame.opengame.message.f0) r104;
            if (r113 == null) goto L26;
            r101.e(r113, r110, r111);
            goto L56
        L26:
            int r114 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
            com.bytedance.android.live.broadcastgame.opengame.q.k("MagicBoxBehavior", new Object[]{"entrance message to open entrance message error"});
        L14:
            r109 = null;
        L17:
            th = move-exception;
            Result.Companion r115 = Result.Companion;
            r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        L56:
            return true;
        L27:
            OpenPlatformMonitorUtils.f59390c.j(r101.c(r101.f59241c), r101.d(), true, false);
            Type r116 = new n().getType();
            Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L30
            Object r118 = Result.m9449constructorimpl((List) GsonHelper.get().fromJson(r102, r116));     // Catch: Throwable -> L30
        L33:
            if (Result.m9455isFailureimpl(r118) == true) goto L36;
            r104 = r118;
        L36:
            List r119 = (List) r104;
            if (r119 != null) goto L39;
            r119 = CollectionsKt.emptyList();
        L39:
            RoomStampInfo r120 = (RoomStampInfo) CollectionsKt.firstOrNull(r119);
            if (r120 != null) goto L42;
        L48:
            boolean r121 = false;
        L49:
            if (r121 == false) goto L56;
            Room r122 = r101.f59239a;
            if (r122 == null) goto L54;
            long r123 = r122.getRoomId();
        L55:
            Function1<com.bytedance.android.live.broadcastgame.opengame.message.f0, Unit> r124 = new AudienceMagicBoxBehavior$check$1(r101, r110, r111);
            AudienceMagicBoxBehavior$check$2 r125 = AudienceMagicBoxBehavior$check$2.INSTANCE;
            int r126 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("MagicBoxBehavior", new Object[]{"start request entrance_info..."});
            long r127 = SystemClock.elapsedRealtime();
            RxUtilKt.c(((OpenGameApi) com.bytedance.android.live.network.c.b().e(OpenGameApi.class)).getEntranceInfo(r123).compose(RxUtil.rxSchedulerHelper()).map(new r(r101, r127)).subscribe(new s(r101, r124, r125), new t(r101, r127, r125)), r101.f59242d);
            goto L56
        L54:
            r123 = 0;
            goto L55
        L42:
            if (r120.getStatus() == 0) goto L46;
            if (r120.getStatus() != 1) goto L48;
        L46:
            if (r120.getType() == 4) goto L48;
            r121 = true;
        L30:
            th = move-exception;
            Result.Companion r128 = Result.Companion;
            r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L33
        }
    }

    public static final class b {
    }

    public static final class c extends b7.a {
        public c() {
        }

        @Override // b7.a, b7.b
        public final boolean onFallback(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "errorMessage");
            int r102 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
            com.bytedance.android.live.broadcastgame.opengame.q.e("MagicBoxBehavior", new Object[]{"show magic box lynx dialog failed, errorCode: " + r100 + ", errorMesage: " + r101});
            return super.onFallback(r100, r101);
        }
    }

    static {
    }

    public final com.bytedance.android.live.broadcastgame.api.openplatform.e d() {
        return new com.bytedance.android.live.broadcastgame.api.openplatform.e(this.f59239a, SourceType.DEFAULT, 12);
    }

    public final void f() {
        int r100 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("MagicBoxBehavior", new Object[]{"show magic box lynx dialog"});
        com.bytedance.android.live.broadcastgame.opengame.message.f0 r101 = this.f59241c;
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
        com.bytedance.android.live.broadcastgame.opengame.q.e("MagicBoxBehavior", new Object[]{"show magic box lynx dialog failed, entranceMessage: " + this.f59241c + ", url: " + r103});
        return;
    L22:
        if (this.f59241c == null) goto L50;
        u6 r106 = new u6(r103);
        u6 r107 = r106.d("url");
        com.bytedance.android.live.broadcastgame.opengame.message.f0 r108 = this.f59241c;
        String r109 = "";
        if (r108 == null) goto L28;
        String r110 = r108.f60248a;
        if (r110 == null) goto L28;
    L29:
        r107.b("mini_app_id", r110);
        com.bytedance.android.live.broadcastgame.opengame.message.f0 r111 = this.f59241c;
        if (r111 != null) goto L32;
    L41:
        Uri r112 = r106.c();
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L44
        Object r114 = Result.m9449constructorimpl(((IBrowserService) jc1.k.n(IBrowserService.class)).showHybridDialog(this.f59247i, r112, new c()));     // Catch: Throwable -> L44
    L46:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);
        if (r115 == null) goto L54;
        int r116 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
        com.bytedance.android.live.broadcastgame.opengame.q.e("MagicBoxBehavior", new Object[]{"Magic box lynx start failed, cause: " + r115.getCause() + ", message: " + r115.getMessage()});
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
        Disposable r100 = this.f59244f;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        CompositeDisposable r101 = this.f59242d;
        if (r101 == null) goto L8;
        r101.dispose();
    L8:
        this.f59239a = null;
        this.f59241c = null;
        com.bytedance.android.live.broadcastgame.xplay.screendetect.a r102 = this.f59243e;
        if (r102 == null) goto L11;
        r102.f();
    L11:
        this.f59243e = null;
        Lazy r103 = ToolbarComponentCheckManager.f115947a;
        ToolbarComponentCheckManager.g(this.f59248j, NewToolbarButtonConstants.MiniGame.INSTANCE);
        vlc.d r104 = this.f59240b;
        if (r104 == null) goto L14;
        r104.removeMessageListener(this);
    L14:
        this.f59240b = null;
    }

    public final Context getContext() {
        return this.f59247i;
    }

    public static final void b(AudienceMagicBoxBehavior r100) {
        r100.getClass();
        r100.f59244f = xs2.b.a().b(com.bytedance.android.live.broadcastgame.api.openplatform.f.class).subscribe(new u(new AudienceMagicBoxBehavior$registerShowPanelEvent$1(r100)), new q(r100));
    }

    @Override // com.bytedance.android.live.broadcastgame.k0
    public final void a(Function1<? super com.bytedance.android.live.broadcastgame.opengame.message.f0, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_RECEIVER);
        this.f59245g = r100;
    }

    public final com.bytedance.android.live.broadcastgame.api.openplatform.d c(com.bytedance.android.live.broadcastgame.opengame.message.f0 r100) {
        if (r100 != null) goto L15;
        com.bytedance.android.live.broadcastgame.opengame.message.f0 r101 = this.f59241c;
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

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if ((r100 instanceof mh) == false) goto L20;
        List<com.bytedance.android.livesdk.message.model.e0> r101 = ((mh) r100).entrances;
        if (r101 == null) goto L21;
        com.bytedance.android.livesdk.message.model.e0 r102 = (com.bytedance.android.livesdk.message.model.e0) CollectionsKt.firstOrNull(r101);
        if (r102 == null) goto L22;
        boolean r103 = false;
        com.bytedance.android.live.broadcastgame.opengame.message.f0 r104 = com.bytedance.android.live.broadcastgame.opengame.message.l.a(r102, 0);
        if (r104 != null) goto L11;
        return;
    L11:
        if (r104.f60212r != 2) goto L14;
        r103 = true;
    L14:
        if (r103 == true) goto L17;
        r104 = null;
    L17:
        if (r104 == null) goto L24;
        e(r104, null, null);
        return;
    L24:
        return;
    L22:
        return;
    L21:
        return;
    }

    public AudienceMagicBoxBehavior(Context r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f59247i = r100;
        this.f59248j = r101;
        RoomContext.a r102 = RoomContext.Companion;
        RoomContext r103 = RoomContext.a.c(r102, r101, 0, 2);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.o r104 = null;
        if (r103 == null) goto L7;
        com.bytedance.live.datacontext.m<Room> r105 = r103.getRoom();
        if (r105 == null) goto L7;
        Room r106 = r105.getValue();
    L8:
        this.f59239a = r106;
        vlc.d r107 = (vlc.d) r101.get("data_message_manager");
        this.f59240b = r107;
        if (r107 == null) goto L11;
        r107.addMessageListener(MessageType.OPEN_PLATFORM_AUDIENCE_ENTRANCE_MESSAGE.getIntType(), this);
    L11:
        this.f59242d = new CompositeDisposable();
        if (oz0.f120943a.getValue().booleanValue() == true) goto L25;
        RoomContext r108 = RoomContext.a.c(r102, r101, 0, 2);
        if (r108 == null) goto L18;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.o> r109 = r108.getTbCompConfigRegister();
        if (r109 == null) goto L18;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.o r110 = r109.getValue();
    L20:
        if ((r110 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.o) == false) goto L23;
        r104 = r110;
    L23:
        if (r104 == null) goto L25;
        r104.register(new com.bytedance.android.live.broadcastgame.opengame.behavior.g(r101, r100));
    L18:
        r110 = null;
    L25:
        Lazy r111 = ToolbarComponentCheckManager.f115947a;
        ToolbarComponentCheckManager.e(r101, NewToolbarButtonConstants.MiniGame.INSTANCE, new a(this));
        return;
    L7:
        r106 = null;
        goto L8
    }

    public final void e(final com.bytedance.android.live.broadcastgame.opengame.message.f0 r210, final Function0<Unit> r211, final Function1<? super String, Unit> r212) {
        int r100 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("MagicBoxBehavior", new Object[]{"receive entrance msg from anchor, name: ", r210.f60203i, ", appId: ", r210.f60248a, ", status: ", Integer.valueOf(r210.f60212r)});
        if (r210.f60212r != 1) goto L5;
        boolean r101 = true;
    L6:
        Object r102 = bi1.a(Boolean.valueOf(r101), "start");
        if (r102 != null) goto L9;
        r102 = "stop";
    L9:
        String r110 = (String) r102;
        if (r210.f60215u != 1) goto L12;
        boolean r111 = true;
    L13:
        OpenPlatformMonitorUtils r103 = OpenPlatformMonitorUtils.f59390c;
        r103.n(c(r210), d(), r111, r110, r210.f60214t);
        InteractGameContext r104 = InteractGameContext.Companion.getContext();
        if (r104 == null) goto L27;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.model.i> r105 = r104.getGameOpenInfo();
        if (r105 == null) goto L27;
        String r106 = r210.f60248a;
        if (r106 != null) goto L20;
        String r112 = "";
    L21:
        long r113 = Long.valueOf(r210.f60200f).longValue();
        String r107 = r210.f60203i;
        if (r107 != null) goto L24;
        String r114 = "";
    L25:
        r105.setValue(new com.bytedance.android.live.broadcastgame.api.model.i(r112, r113, r114, Boolean.valueOf(r210.C).booleanValue(), Boolean.valueOf(r210.D).booleanValue()));
        goto L27
    L24:
        r114 = r107;
        goto L25
    L20:
        r112 = r106;
    L27:
        if (r210.f60212r == 1) goto L29;
        this.f59248j.put("revenue_interact", Boolean.FALSE);
        Function1<? super com.bytedance.android.live.broadcastgame.opengame.message.f0, Unit> r108 = this.f59245g;
        if (r108 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("sonicPluginMessageReceiver");
    L50:
        r108.invoke(r210);
        ((IInteractGameService) jc1.k.n(IInteractGameService.class)).clearCache();
        r103.h(c(r210), d());
        AudienceGameContext.Companion.getClass();
        AudienceGameContext r109 = AudienceGameContext.a.a();
        if (r109 == null) goto L55;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.model.h> r115 = r109.getAnchorCurrentGameIconInfo();
        if (r115 == null) goto L55;
        r115.setValue(null);
    L55:
        com.bytedance.android.live.broadcastgame.xplay.screendetect.a r116 = this.f59243e;
        if (r116 == null) goto L63;
        r116.f();
        return;
    L63:
        return;
    L29:
        if (tb1.c.f545229a == true) goto L34;
        com.bytedance.android.live.broadcastgame.opengame.q.f("MagicBoxBehavior", new Object[]{"not support game type"});
        if (r212 == null) goto L59;
        Unit r117 = r212.invoke("not support game type");
        return;
    L59:
        return;
    L34:
        Function0<Unit> r118 = new AudienceMagicBoxBehavior$receiveOpenEntranceMessage$showIcon$1(this, r210, r211);
        this.f59241c = r210;
        com.bytedance.android.live.broadcastgame.opengame.q.f("MagicBoxBehavior", new Object[]{"receive anchor message, need check visible: " + r210.f60214t});
        if (r210.f60214t == false) goto L41;
        Function0<Unit> r119 = new AudienceMagicBoxBehavior$receiveOpenEntranceMessage$1(this, r212, r210);
        com.bytedance.android.live.broadcastgame.opengame.q.f("MagicBoxBehavior", new Object[]{"start check entrance visible"});
        long r120 = SystemClock.elapsedRealtime();
        AudienceGameNetApi r121 = (AudienceGameNetApi) com.bytedance.android.live.network.c.b().e(AudienceGameNetApi.class);
        Room r122 = this.f59239a;
        if (r122 == null) goto L39;
        long r123 = r122.getRoomId();
    L40:
        RxUtilKt.c(r121.getEntranceVisiable(r123, 1, r210.f60200f).compose(RxUtil.rxSchedulerHelper()).subscribe(new l(this, r120, r210, r118, r119), new m(this, r120, r210, r119)), this.f59242d);
    L42:
        AudienceGameContext.Companion.getClass();
        AudienceGameContext r124 = AudienceGameContext.a.a();
        if (r124 == null) goto L60;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.model.h> r125 = r124.getAnchorCurrentGameIconInfo();
        if (r125 == null) goto L61;
        r125.setValue(new com.bytedance.android.live.broadcastgame.api.model.h(r210.f60248a, r210.f60203i, r210.f60204j));
        return;
    L61:
        return;
    L60:
        return;
    L39:
        r123 = 0;
        goto L40
    L41:
        r118.invoke();
        goto L42
    L12:
        r111 = false;
        goto L13
    L5:
        r101 = false;
        goto L6
    }
}
