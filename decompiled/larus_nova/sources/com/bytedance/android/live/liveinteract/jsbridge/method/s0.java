package com.bytedance.android.live.liveinteract.jsbridge.method;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.browser.jsbridge.base.OneButtonOpenSceneAndPlayModeResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApis;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.live.user.api.IUserServiceV2;
import com.bytedance.android.live.user.api.UserSetting;
import com.bytedance.android.livesdk.schema.OpenPlayModePanelActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import w20.ac;
import w20.c4;

/* JADX INFO: loaded from: classes46.dex */
public final class s0 extends c4<ac, OneButtonOpenSceneAndPlayModeResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f74247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f74248b;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s0 f74249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f74250b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ IRoom f74251c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f74252d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Function1 f74253e;

        public a(s0 r100, int r101, IRoom r102, long r103, Function1 r104) {
            this.f74249a = r100;
            this.f74250b = r101;
            this.f74251c = r102;
            this.f74252d = r103;
            this.f74253e = r104;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            com.bytedance.android.live.network.response.e r100 = (com.bytedance.android.live.network.response.e) r110;
            Intrinsics.checkNotNull(r100);
            com.bytedance.android.live.liveinteract.plantform.utils.i.d((com.bytedance.android.livesdk.chatroom.model.interact.j0) r100.data, r100.logId);
            this.f74249a.f74248b = false;
            tc0.c r101 = tc0.c.h();
            ALogger.w("ttlive_link_video", "initV2Success reqScene=" + this.f74250b + " initResult=" + ((com.bytedance.android.livesdk.chatroom.model.interact.j0) r100.data));
            tc0.c.h().E = ((com.bytedance.android.livesdk.chatroom.model.interact.j0) r100.data).isSupportVideo();
            com.bytedance.android.livesdk.chatroom.u r102 = com.bytedance.android.live.liveinteract.api.utils.m.d();
            if (r102 == null) goto L22;
            com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.e> r103 = r102.getVideoTalkRoomSubScene();
            if (r103 == null) goto L7;
            com.bytedance.android.livesdk.chatroom.viewmodel.e r104 = r103.getValue();
        L8:
            if (r104 == null) goto L22;
            if (((com.bytedance.android.livesdk.chatroom.model.interact.j0) r100.data).getScene() == 0) goto L17;
            com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.e> r105 = r102.getVideoTalkRoomSubScene();
            if (r105 == null) goto L16;
            com.bytedance.android.livesdk.chatroom.viewmodel.e r106 = r105.getValue();
            if (r106 == null) goto L16;
            r106.e(new com.bytedance.android.livesdk.chatroom.viewmodel.j(((com.bytedance.android.livesdk.chatroom.model.interact.j0) r100.data).getScene(), ((com.bytedance.android.livesdk.chatroom.model.interact.j0) r100.data).getPlayModes(), ((com.bytedance.android.livesdk.chatroom.model.interact.j0) r100.data).getUiLayout(), false, null, false, 56));
        L16:
            com.bytedance.android.livesdk.sharedpref.d.q(((com.bytedance.android.livesdk.chatroom.model.interact.j0) r100.data).getScene());
            goto L22
        L17:
            com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.e> r107 = r102.getVideoTalkRoomSubScene();
            if (r107 == null) goto L22;
            com.bytedance.android.livesdk.chatroom.viewmodel.e r108 = r107.getValue();
            if (r108 == null) goto L22;
            r108.e(new com.bytedance.android.livesdk.chatroom.viewmodel.j(this.f74250b, ((com.bytedance.android.livesdk.chatroom.model.interact.j0) r100.data).getPlayModes(), ((com.bytedance.android.livesdk.chatroom.model.interact.j0) r100.data).getUiLayout(), false, null, false, 56));
            goto L22
        L7:
            r104 = null;
        L22:
            this.f74251c.setLinkInitResult((com.bytedance.android.livesdk.chatroom.model.interact.j0) r100.data);
            r101.f545354k = ((com.bytedance.android.livesdk.chatroom.model.interact.j0) r100.data).getRtcExtInfo();
            r101.f545356m = ((com.bytedance.android.livesdk.chatroom.model.interact.j0) r100.data).getLiveCoreExtInfo();
            r101.f545361r = ((com.bytedance.android.livesdk.chatroom.model.interact.j0) r100.data).getMultiLiveCoreInfo();
            r101.f545357n = ((com.bytedance.android.livesdk.chatroom.model.interact.j0) r100.data).getMultiRtcInfo();
            long r111 = System.currentTimeMillis() - this.f74252d;
            com.bytedance.android.live.liveinteract.plantform.utils.x.z0(r111);
            InteractLinkFullLinkMonitor.l("8,12", 0, ((com.bytedance.android.livesdk.chatroom.model.interact.j0) r100.data).getScene(), (com.bytedance.android.livesdk.chatroom.model.interact.j0) r100.data, r111, r100.logId, "OneKeyOpenSceneAndPlayModeMethod");
            com.bytedance.android.livesdk.chatroom.model.interact.j0 r109 = (com.bytedance.android.livesdk.chatroom.model.interact.j0) r100.data;
            if (TextUtils.isEmpty(r109.getLinkMicIdStr()) == false) goto L25;
            r101.f545349f = String.valueOf(r109.getLinkMicId());
            r101.f545348e = String.valueOf(r109.getLinkMicId());
        L26:
            r101.f545353j = r109.getVendor();
            r101.f545354k = r109.getRtcExtInfo();
            if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L29;
            com.bytedance.android.live.liveinteract.plantform.base.f.a().id(32, MultiLinkOpenSource.INNER_TOOLS);
        L29:
            hd0.c.f().k(2);
            if (UserSetting.b() == false) goto L36;
            IUserServiceV2 r112 = (IUserServiceV2) jc1.k.f(IUserServiceV2.class);
            if (r112 == null) goto L37;
            Single<? extends IBaseUser> r113 = r112.updateCurrentUser(null, "OneKeyOpenSceneAndPlayModeMethod");
            if (r113 == null) goto L37;
            r113.subscribe(new com.bytedance.android.livesdk.user.h());
        L37:
            Function1 r114 = this.f74253e;
            if (r114 == null) goto L41;
            Unit r115 = (Unit) r114.invoke(Boolean.TRUE);
            return;
        L41:
            return;
        L36:
            ((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().j().subscribe(new com.bytedance.android.livesdk.user.h());
            goto L37
        L25:
            r101.f545348e = r109.getLinkMicIdStr();
            r101.f545349f = r109.getLinkMicIdStr();
            goto L26
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s0 f74254a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f74255b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f74256c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f74257d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Function1 f74258e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ long f74259f;

        public b(s0 r100, int r101, int r102, boolean r103, Function1 r104, long r105) {
            this.f74254a = r100;
            this.f74255b = r101;
            this.f74256c = r102;
            this.f74257d = r103;
            this.f74258e = r104;
            this.f74259f = r105;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            if (this.f74256c != 8) goto L5;
            int r102 = 1;
        L6:
            new qh0.h(r102, new OneKeyOpenSceneAndPlayModeMethod$openTalkRoom$disp$2$1(this), OneKeyOpenSceneAndPlayModeMethod$openTalkRoom$disp$2$2.INSTANCE).c(r101);
            this.f74254a.f74248b = false;
            InteractLinkFullLinkMonitor.j("8,12", 0, System.currentTimeMillis() - this.f74259f, r101, "tool_fast_open");
            return;
        L5:
            r102 = 2;
            goto L6
        }
    }

    public final int j() {
        return ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
    }

    public s0() {
        this.f74247a = new CompositeDisposable();
    }

    public static void k(s0 r100) {
        r100.getClass();
        OneButtonOpenSceneAndPlayModeResultModel r101 = new OneButtonOpenSceneAndPlayModeResultModel();
        r101.a(OneButtonOpenSceneAndPlayModeResultModel.Code.Success);
        r101.b("");
        r100.finishWithResult(r101);
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r110) {
        ac r101 = (ac) r100;
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((!Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE)) == false) goto L5;
        OneButtonOpenSceneAndPlayModeResultModel r102 = new OneButtonOpenSceneAndPlayModeResultModel();
        r102.a(OneButtonOpenSceneAndPlayModeResultModel.Code.Failed);
        r102.b("你不是主播不能更改场景和玩法");
        finishWithResult(r102);
        return;
    L5:
        String r103 = r101.getType();
        if (r103 == null) goto L63;
        j();
        int r111 = r103.hashCode();
        if (r111 == 408060947) goto L44;
        switch(r111) {
            case 49: goto L38;
            case 50: goto L32;
            case 51: goto L26;
            case 52: goto L20;
            case 53: goto L14;
            default: goto L64;
        };
    L64:
        return;
    L14:
        if (r103.equals("5") == false) goto L48;
        ALogger.d("OneKeyOpenSceneAndPlayModeMethod", "openFloat3x3Window.invoked");
        if (j() != 0) goto L18;
        m(this, 12, 7, new OneKeyOpenSceneAndPlayModeMethod$openFloat3x3Window$1(this), 1);
        return;
    L18:
        n(this, j(), 12, 7);
        this.f74247a.add(Observable.timer(3000, TimeUnit.MILLISECONDS).subscribe(new r0(this)));
        return;
    L48:
        return;
    L20:
        if (r103.equals("4") == false) goto L51;
        ALogger.d("OneKeyOpenSceneAndPlayModeMethod", "open3x3Window.invoked");
        if (j() != 0) goto L24;
        m(this, 12, 5, new OneKeyOpenSceneAndPlayModeMethod$open3x3Window$1(this), 1);
        return;
    L24:
        n(this, j(), 12, 5);
        this.f74247a.add(Observable.timer(3000, TimeUnit.MILLISECONDS).subscribe(new o0(this)));
        return;
    L51:
        return;
    L26:
        if (r103.equals("3") == false) goto L54;
        ALogger.d("OneKeyOpenSceneAndPlayModeMethod", "openFloat1V6Window.invoked");
        if (j() != 0) goto L30;
        m(this, 8, 7, new OneKeyOpenSceneAndPlayModeMethod$openFloat1V6Window$1(this), 1);
        return;
    L30:
        n(this, j(), 8, 7);
        this.f74247a.add(Observable.timer(3000, TimeUnit.MILLISECONDS).subscribe(new q0(this)));
        return;
    L54:
        return;
    L32:
        if (r103.equals("2") == false) goto L57;
        ALogger.d("OneKeyOpenSceneAndPlayModeMethod", "open1v6Window.invoked");
        if (j() != 0) goto L36;
        m(this, 8, 0, new OneKeyOpenSceneAndPlayModeMethod$open1v6Window$1(this), 5);
        return;
    L36:
        n(this, j(), 8, 0);
        this.f74247a.add(Observable.timer(3000, TimeUnit.MILLISECONDS).subscribe(new n0(this)));
        return;
    L57:
        return;
    L38:
        if (r103.equals("1") == false) goto L60;
        ALogger.d("OneKeyOpenSceneAndPlayModeMethod", "openDoubleChat.invoked");
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L42;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().K7("right_away");
    L42:
        this.f74247a.add(Observable.timer(3000, TimeUnit.MILLISECONDS).subscribe(new p0(this)));
        return;
    L60:
        return;
    L44:
        if (r103.equals(OpenPlayModePanelActionHandler.LINK_ROOM_FIGHT_PANEL) == false) goto L62;
        ((IInteractService) jc1.k.n(IInteractService.class)).clickLinkRoomFightIcon(MapsKt.mapOf(TuplesKt.to("request_page", "activity")));
        k(this);
        return;
    L62:
        return;
    }

    public static void n(s0 r100, int r101, int r102, int r103) {
        r100.getClass();
        Intrinsics.checkNotNullParameter("", "reason");
        ((IInteractService) jc1.k.n(IInteractService.class)).switchScene(r101, r102, "", Integer.valueOf(r103));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l(boolean r310, int r311, int r312, Function1<? super Boolean, Unit> r313) {
        TalkRoomBusinessFullLinkMonitor.f71456a.getClass();
        TalkRoomBusinessFullLinkMonitor.c0("tool_fast_open", r311, r312);
        long r210 = System.currentTimeMillis();
        com.bytedance.live.datacontext.m<IRoom> r100 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r100 == null) goto L23;
        IRoom r101 = r100.getValue();
        if (r101 != null) goto L8;
        return;
    L8:
        if (((IMultiLinkServiceExternal) jc1.k.n(IMultiLinkServiceExternal.class)).getMultiDataHolderExternal().getChannelId() == 0) goto L12;
        TalkRoomBusinessFullLinkMonitor.g0("during_pk");
        return;
    L12:
        if (this.f74248b == false) goto L14;
        return;
    L14:
        this.f74248b = true;
        LiveMode r102 = null;
        int r103 = ((Number) com.bytedance.android.livesdk.sharedpref.d.f158334d0.getValue(null, com.bytedance.android.livesdk.sharedpref.d.f158327a[54])).intValue();
        InteractLinkFullLinkMonitor.i("8,12", r103, "tool_fast_open");
        if (r310 == false) goto L17;
        Single<com.bytedance.android.live.network.response.e<com.bytedance.android.livesdk.chatroom.model.interact.j0>> r104 = ((LinkApis) com.bytedance.android.live.network.c.b().e(LinkApis.class)).initV2(r101.getId(), 4, 16, false, r103, "8,12", 0, r312, 1);
    L18:
        int r105 = com.bytedance.android.live.liveinteract.plantform.utils.f.f77476a;
        com.bytedance.live.datacontext.i<LiveMode> r106 = com.bytedance.android.live.liveinteract.api.utils.m.i().getLiveMode();
        if (r106 == null) goto L21;
        r102 = r106.getValue();
    L21:
        com.bytedance.android.live.liveinteract.plantform.utils.f.a(r102);
        ((IInteractService) jc1.k.n(IInteractService.class)).setDynamicFromAudience(false);
        r104.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this, r103, r101, r210, r313), new b(this, r312, r311, r310, r313, r210));
        return;
    L17:
        r104 = ((LinkApis) com.bytedance.android.live.network.c.b().e(LinkApis.class)).initV2(r101.getId(), 4, false, r103, "8,12");
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void m(s0 r100, int r101, int r102, Function1 r103, int r104) {
        if ((r104 & 1) == 0) goto L5;
        boolean r105 = true;
    L7:
        if ((r104 & 2) == 0) goto L10;
        r101 = 8;
    L10:
        if ((r104 & 4) == 0) goto L13;
        r102 = 0;
    L13:
        if ((r104 & 8) == 0) goto L15;
        r103 = null;
    L15:
        r100.l(r105, r101, r102, r103);
        return;
    L5:
        r105 = false;
        goto L7
    }
}
