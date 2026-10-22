package com.bytedance.android.livesdk.interactivity.enteranim;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.utils.MainPostOptUtils;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.k1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.o0;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.android.livesdk.common.i;
import com.bytedance.android.livesdk.config.PerformanceTestSettings;
import com.bytedance.android.livesdk.config.ou;
import com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext;
import com.bytedance.android.livesdk.interactivity.api.comment.data.KeyboardViewModel;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.HighlevelNoMessageMonitorEnum;
import com.bytedance.android.livesdk.interactivity.common.utils.j;
import com.bytedance.android.livesdk.interactivity.enteranim.utils.g;
import com.bytedance.android.livesdk.interactivity.enteranim.utils.h;
import com.bytedance.android.livesdk.interactivity.enteranim.view.EnterAnimationView;
import com.bytedance.android.livesdk.interactivity.service.monitor.EventName;
import com.bytedance.android.livesdk.interactivity.service.monitor.MonitorEvent;
import com.bytedance.android.livesdk.interactivity.service.monitor.UploadMode;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.room.EnterRoomRedirect;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.ttm.player.MediaPlayer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import r52.b4;
import r52.h1;
import r52.i1;
import r52.r0;
import r72.f;
import r72.l;

/* JADX INFO: loaded from: classes9.dex */
public class EnterAnimWidget extends MiddlewareRoomRecyclableWidget implements l, Observer<KVData>, vlc.l, i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f136573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public EnterAnimationView f136574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public s72.d f136575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f136576d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public o f136577e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public InteractivityPlatformContext f136578f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public InteractionWidgetsPosContext f136579g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final h f136580h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final s72.b f136581i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f136582j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.common.utils.i f136583k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f136584l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f136585m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b f136586n;

    public class a implements com.bytedance.android.livesdk.interactivity.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EnterAnimWidget f136587a;

        public a(EnterAnimWidget r100) {
            this.f136587a = r100;
        }
    }

    public class b implements vlc.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EnterAnimWidget f136588a;

        public b(EnterAnimWidget r100) {
            this.f136588a = r100;
        }

        @Override // vlc.l
        public final void onMessage(tlc.d r100) {
            if ((r100 instanceof va) == false) goto L14;
            va r101 = (va) r100;
            if (r101.j0() != EnterRoomRedirect.REDIRECT_FROM_COLLABORATE_ENTER_ROOM.getValue()) goto L8;
            return;
        L8:
            if (this.f136588a.isScreenPortrait() == true) goto L10;
            return;
        L10:
            if (this.f136588a.yq(r101) == true) goto L16;
            r101.setFromRtcRoom(true);
            this.f136588a.f136581i.a(r101);
            return;
        L16:
            return;
        }
    }

    public class c implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EnterAnimWidget f136589a;

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            ALogger.i("EnterAnimWidget", "rtcMessageManager Null Callback");
            if (b4.f536156a.getValue().d() == false) goto L18;
            EnterAnimationView r100 = this.f136589a.f136574b;
            if (r100 == null) goto L18;
            if (r100.getEntryController() == null) goto L18;
            Iterator<Map.Entry<Long, Deque<k32.a>>> r101 = ((v72.c) this.f136589a.f136574b.getEntryController()).f553422e.f553459c.f136795a.entrySet().iterator();
        L10:
            if (r101.hasNext() == false) goto L18;
            Iterator<k32.a> r102 = r101.next().getValue().iterator();
        L13:
            if (r102.hasNext() == false) goto L10;
            if (r102.next().f501701r == false) goto L13;
            r102.remove();
        L18:
            return Unit.INSTANCE;
        }

        public c(EnterAnimWidget r100) {
            this.f136589a = r100;
        }
    }

    public class d implements t72.a.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k32.a f136590a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ EnterAnimWidget f136591b;

        public d(EnterAnimWidget r100, k32.a r101) {
            this.f136591b = r100;
            this.f136590a = r101;
        }
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_widget_enter_anim;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, tw2.b
    public final String getSpm() {
        return "a100.a100.a249";
    }

    @Override // com.bytedance.android.livesdk.common.i
    public final String nc() {
        return "EnterAnimWidget";
    }

    @Override // com.bytedance.android.livesdk.common.i
    public final /* synthetic */ boolean nq() {
        return com.bytedance.android.livesdk.common.h.a();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget
    public final int supportClearScene() {
        return MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_MEDIACODEC_PIPELINE_CTL;
    }

    @Override // com.bytedance.android.livesdk.common.i
    public final String Lg() {
        ViewGroup r100 = this.containerView;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (com.bytedance.android.livesdk.common.h.a() == true) goto L7;
        return null;
    L7:
        if (r100.getVisibility() != 8) goto L9;
        return null;
    L9:
        if (r100.getVisibility() == 4) goto L16;
        this.f136580h.a(r100, 6, true);
        this.f136573a = Boolean.TRUE;
        ALogger.i("CleanScreenManager", "EnterAnimWidget GONE");
        return "EnterAnimWidget";
    L16:
        return null;
    }

    @Override // com.bytedance.android.livesdk.common.i
    public final String cg() {
        ViewGroup r100 = this.containerView;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (com.bytedance.android.livesdk.common.h.a() == true) goto L7;
        return null;
    L7:
        if (this.f136573a.booleanValue() == false) goto L13;
        this.f136580h.a(r100, 6, false);
        this.f136573a = Boolean.FALSE;
        ALogger.i("CleanScreenManager", "EnterAnimWidget SHOW");
        return "EnterAnimWidget";
    L13:
        return null;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        ALogger.i("EnterAnimWidget", "onUnload");
        if (g.f136788a.booleanValue() == true) goto L5;
    L38:
        this.dataCenter.removeObserver(this);
        EnterAnimationView r100 = this.f136574b;
        if (r100 == null) goto L44;
        if (r100.getEntryController() == null) goto L44;
        ((v72.c) this.f136574b.getEntryController()).f553438u = null;
    L44:
        if (this.f136583k == null) goto L52;
        vlc.d r101 = (vlc.d) this.dataCenter.get("data_message_manager");
        com.bytedance.android.livesdk.interactivity.common.utils.i r102 = this.f136583k;
        int r103 = j.f136572a;
        if (r101 != null) goto L49;
    L51:
        this.f136583k = null;
        goto L52
    L49:
        if ((r101 instanceof dmc.a) == false) goto L51;
        ((dmc.a) r101).o(r102);
        ALogger.i("LiveMessageTracer", "removeReplayMessageListener");
    L52:
        this.f136573a = Boolean.FALSE;
        this.f136576d.clear();
        ViewGroup r104 = this.containerView;
        if (r104 == null) goto L55;
        r104.setVisibility(0);
        this.containerView.setAlpha(1.0f);
    L55:
        UIUtils.setViewVisibility(findViewById(R.id.enter), 0);
        h r105 = this.f136580h;
        InteractivityPlatformContext r106 = this.f136578f;
        r105.getClass();
        if (r106 == null) goto L68;
        com.bytedance.live.datacontext.i<Map<Integer, Boolean>> r107 = r106.getEnterAnimVisibleStateStore();
        if (r107 == null) goto L68;
        Map r108 = r107.getValue();
        if (r108 == null) goto L68;
        r108.clear();
        Iterator<Map.Entry<Integer, Boolean>> r109 = r105.f136794b.entrySet().iterator();
    L64:
        if (r109.hasNext() == false) goto L68;
        Map.Entry<Integer, Boolean> r110 = r109.next();
        if (r110.getKey().intValue() != 5) goto L64;
        r108.put(r110.getKey(), r110.getValue());
    L68:
        Iterator<Map.Entry<Integer, Boolean>> r111 = this.f136580h.f136794b.entrySet().iterator();
    L70:
        if (r111.hasNext() == false) goto L72;
        r111.next().setValue(Boolean.TRUE);
        goto L70
    L72:
        return;
    L5:
        if (g.f136790c <= 0) goto L7;
    L9:
        HashMap r112 = new HashMap();
        r112.put("on_change_cnt", String.valueOf(g.f136790c));
        int r113 = g.f136790c;
        String r114 = "0";
        if (r113 <= 0) goto L12;
        String r115 = String.valueOf(g.f136789b / r113);
    L13:
        r112.put("on_change_cost", r115);
        r112.put("play_anim_cnt", String.valueOf(g.f136792e));
        int r116 = g.f136792e;
        if (r116 <= 0) goto L16;
        String r117 = String.valueOf(g.f136791d / r116);
    L17:
        r112.put("play_anim_cost", r117);
        IMiddlewareUserService r118 = (IMiddlewareUserService) k.f(IMiddlewareUserService.class);
        if (r118 == null) goto L23;
        e r119 = r118.user();
        if (r119 == null) goto L23;
        String r120 = r119.n();
        if (r120 == null) goto L23;
    L24:
        r112.put("user_id", r120);
        IRoomContextService r121 = (IRoomContextService) k.f(IRoomContextService.class);
        if (r121 == null) goto L36;
        o r122 = IRoomContextService.a.a(r121, null, 0, 3);
        if (r122 == null) goto L36;
        m<IRoom> r123 = r122.getRoom();
        if (r123 == null) goto L36;
        IRoom r124 = r123.getValue();
        if (r124 == null) goto L36;
        String r125 = String.valueOf(r124.getRoomId());
        if (r125 == null) goto L36;
        r114 = r125;
    L36:
        r112.put("room_id", r114);
        j0.l().sendLog("ttlive_high_level_message_performance", r112, new Object[0]);
    L37:
        g.f136789b = 0;
        g.f136790c = 0;
        g.f136791d = 0;
        g.f136792e = 0;
    L23:
        r120 = "0";
        goto L24
    L16:
        r117 = "0";
        goto L17
    L12:
        r115 = "0";
        goto L13
    L7:
        if (g.f136792e > 0) goto L9;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [r72.j] */
    /* JADX WARN: Type inference failed for: r3v0, types: [r72.k] */
    public EnterAnimWidget() {
        this.f136573a = Boolean.FALSE;
        this.f136576d = new CompositeDisposable();
        this.f136580h = new h();
        this.f136581i = new s72.b(i0.c(), new r72.j(this), new r72.k(this));
        this.f136582j = false;
        this.f136584l = false;
        this.f136585m = new a(this);
        this.f136586n = new b(this);
    }

    @Override // com.bytedance.android.livesdk.common.i
    public final View getContentView() {
        return this.containerView;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onPause() {
        super.onPause();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onResume() {
        super.onResume();
    }

    @Override // com.bytedance.android.livesdk.common.i
    public final Boolean uk() {
        return this.f136573a;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        final KVData r101 = (KVData) r100;
        if (r101 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101.getKey()) == true) goto L10;
        g.a(new r72.b(this, r101));
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget
    public final void onEnterClear(int r100) {
        if (r100 != 1) goto L5;
    L14:
        View r101 = findViewById(R.id.enter);
        if (r101 == null) goto L19;
        this.f136580h.a(r101, 3, true);
        return;
    L19:
        return;
    L5:
        if (r100 == 4) goto L14;
        if (r100 == 16) goto L14;
        if (r100 == 32) goto L14;
        if (r100 == 256) goto L14;
        if (r100 == 1024) goto L14;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget
    public final void onExitClear(int r100) {
        if (r100 != 1) goto L5;
    L12:
        View r101 = findViewById(R.id.enter);
        if (r101 == null) goto L17;
        this.f136580h.a(r101, 3, false);
        return;
    L17:
        return;
    L5:
        if (r100 == 4) goto L12;
        if (r100 == 16) goto L12;
        if (r100 == 32) goto L12;
        if (r100 == 256) goto L12;
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.Object, r72.i] */
    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object... r100) {
        this.f136575c = new s72.d();
        EnterAnimationView r101 = (EnterAnimationView) this.contentView.findViewById(R.id.enter);
        this.f136574b = r101;
        r101.setUserEventListener(this);
        ?? r102 = new r72.i(this);
        if (ou.f120932a.getValue().booleanValue() == false) goto L17;
        DataCenter r103 = this.dataCenter;
        Lazy r104 = MainPostOptUtils.f66069a;
        Intrinsics.checkNotNullParameter("checkAndPreloadDrawableRunnable", "methodName");
        Intrinsics.checkNotNullParameter(this, NewBroadcastMonitor.STAGE.LIFECYCLE);
        Intrinsics.checkNotNullParameter(r102, "runnable");
        if (r103 == null) goto L19;
        Observable r105 = RxUtilKt.b(r103, "cmd_widget_loaded", true);
        if (r105 == null) goto L20;
        Observable r106 = r105.take(1);
        if (r106 == null) goto L21;
        Observable r107 = r106.delay(200, TimeUnit.MILLISECONDS);
        if (r107 == null) goto L22;
        Observable r108 = r107.observeOn(AndroidSchedulers.mainThread());
        if (r108 == null) goto L23;
        ObservableSubscribeProxy r109 = (ObservableSubscribeProxy) r108.as(AutoDispose.bind(this));
        if (r109 == null) goto L24;
        r109.subscribe(new k1(r102));
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L17:
        r102.run();
    }

    /* JADX WARN: Type inference failed for: r6v33, types: [java.lang.Object, r72.d] */
    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object... r110) {
        if (PerformanceTestSettings.TEST_DISABLE_ENTER_ANIM.getValue().booleanValue() == false) goto L5;
        return;
    L5:
        DataCenter r111 = this.dataCenter;
        if (r111 == null) goto L8;
        this.f136580h.f136793a = r111;
    L8:
        ALogger.i("EnterAnimWidget", WidgetCostModule.TYPE_ON_LOAD);
        if (LiveInfraSettingKeys.LIVE_ENTER_DIRTY_REGION_OPT.getValue().booleanValue() == false) goto L15;
        ViewGroup r100 = (ViewGroup) this.f136574b.getParent();
        if (r100 == null) goto L15;
        if (r100.getClipChildren() == true) goto L15;
        r100.setClipChildren(true);
        ALogger.i("DirtyRegion", "enter parent=" + r100 + " clipChildren=true");
    L15:
        long r101 = 0;
        boolean r102 = false;
        if (g.f136788a.booleanValue() == false) goto L18;
        g.f136789b = 0;
        g.f136790c = 0;
        g.f136791d = 0;
        g.f136792e = 0;
    L18:
        this.f136577e = ((IRoomContextService) k.f(IRoomContextService.class)).getRoomDataContext(this.dataCenter, 0);
        this.f136579g = InteractionWidgetsPosContext.getShared(this.dataCenter, 0);
        if (isScreenPortrait() == false) goto L29;
        o r103 = this.f136577e;
        if (r103 == null) goto L29;
        n<z70.b> r104 = r103.getTemplateContext();
        if (r104 == null) goto L29;
        z70.b r105 = r104.getValue();
        if (r105 == null) goto L29;
        if (r105.c("public_screen") == false) goto L29;
        boolean r106 = r105.a();
    L30:
        ALogger.i("EnterAnimWidget", "canLoadPublicScreen is " + r106);
        if (r106 == false) goto L39;
        InteractionWidgetsPosContext r107 = this.f136579g;
        if (r107 == null) goto L40;
        h r108 = this.f136580h;
        ViewGroup r109 = this.containerView;
        if (r107.getPublicScreenVisibility().getValue().intValue() != 0) goto L37;
        boolean r112 = true;
    L38:
        r108.a(r109, 0, r112);
        this.f136576d.add(this.f136579g.getPublicScreenVisibility().a().subscribe(new r72.a(this)));
        goto L40
    L37:
        r112 = false;
    L40:
        o r113 = this.f136577e;
        if (r113 != null) goto L43;
    L51:
        this.f136578f = com.bytedance.android.livesdk.interactivity.j.a(this.dataCenter);
        vlc.d r114 = (vlc.d) this.dataCenter.get("data_message_manager");
        if (h1.f536189a.getValue().booleanValue() == false) goto L54;
    L57:
        boolean r115 = true;
    L59:
        if (r115 == true) goto L61;
    L68:
        this.dataCenter.observe("data_member_message", this);
    L69:
        this.dataCenter.observe("data_game_download_message", this);
        this.dataCenter.observe("data_live_ecom_message", this);
        this.dataCenter.observe("mock_open_asset_message", this);
        this.dataCenter.observeForever("cmd_pk_state_change", this);
        this.dataCenter.observe("cmd_enter_widget_layout_change", this, true);
        this.dataCenter.observeForever("cmd_enter_widget_visible_change", this);
        this.dataCenter.observeForever("data_keyboard_status", this);
        this.dataCenter.observeForever("data_keyboard_status_douyin", this);
        this.dataCenter.observe("cmd_hide_enter_anim_until_next_anim", this);
        this.f136582j = ((Boolean) this.dataCenter.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        m<Object> r116 = getRoomContextService().getRoomInteractivityService(this.dataContext).c();
        if (r116 == null) goto L72;
        this.f136576d.add(r116.a().subscribe(new r72.e(this)));
    L73:
        this.dataCenter.observe("data_member_count", this);
        if (this.f136574b != null) goto L76;
    L80:
        EnterAnimationView r117 = this.f136574b;
        if (r117 == null) goto L85;
        r117.setDataCenter(this.dataCenter);
        this.f136574b.setInteractivityContext(this.f136578f);
        if (this.f136574b.getEntryController() == null) goto L85;
        ((v72.c) this.f136574b.getEntryController()).f553438u = this.f136585m;
    L85:
        this.dataCenter.observe("cmd_data_interact_public_screen_height_change", this, true);
        o r118 = this.f136577e;
        if (r118 != null) goto L88;
    L92:
        boolean r119 = ((Boolean) this.dataCenter.get("data_is_anchor")).booleanValue();
        h r120 = this.f136580h;
        InteractivityPlatformContext r121 = this.f136578f;
        r120.getClass();
        if (r121 == null) goto L106;
        com.bytedance.live.datacontext.i<Map<Integer, Boolean>> r122 = r121.getEnterAnimVisibleStateStore();
        if (r122 == null) goto L106;
        Map<Integer, Boolean> r123 = r122.getValue();
        if (r123 == null) goto L106;
        Iterator<Map.Entry<Integer, Boolean>> r124 = r123.entrySet().iterator();
    L101:
        if (r124.hasNext() == false) goto L105;
        Map.Entry<Integer, Boolean> r125 = r124.next();
        if (r125.getKey().intValue() != 5) goto L101;
        r120.f136794b.put(r125.getKey(), r125.getValue());
        goto L101
    L105:
        r123.clear();
    L106:
        h r126 = this.f136580h;
        ViewGroup r127 = this.containerView;
        if (r119 == false) goto L109;
    L111:
        r126.a(r127, 4, r102);
        com.bytedance.android.live.profit.player.d r128 = yt0.c.h();
        if (r128 == null) goto L114;
        this.f136576d.add(r128.x1().subscribe(new f(this)));
    L114:
        Widget.WidgetCallback r129 = this.widgetCallback;
        if (r129 == null) goto L118;
        ((KeyboardViewModel) r129.getViewModel(KeyboardViewModel.class)).getKeyboardData().observe(this, new r72.g(this));
    L118:
        if (r0.f536248a.getValue().c() == false) goto L133;
        z32.b r130 = z32.b.f569866c;
        EventName r131 = EventName.HighLevelNoMessageShowEvent;
        r130.getClass();
        Intrinsics.checkNotNullParameter(r131, "eventName");
        Intrinsics.checkNotNullParameter(r131, "eventName");
        r130.f569864a = r131;
        IRoomContextService r132 = (IRoomContextService) k.f(IRoomContextService.class);
        if (r132 == null) goto L128;
        o r133 = IRoomContextService.a.a(r132, null, 0, 3);
        if (r133 == null) goto L128;
        m<IRoom> r134 = r133.getRoom();
        if (r134 == null) goto L128;
        IRoom r135 = r134.getValue();
        if (r135 == null) goto L128;
        r101 = r135.getUserCount();
    L128:
        ALogger.i("HighlevelNoMessageMonitorHelper", "room enter acu: " + r101);
        com.bytedance.android.livesdk.interactivity.api.settings.config.l r136 = z32.b.f569865b;
        if (r101 <= r136.a()) goto L133;
        MonitorEvent.b r137 = new MonitorEvent.b(r131, UploadMode.TIMER, r136.b());
        r137.e(HighlevelNoMessageMonitorEnum.MemberReceiveCount.getValueNodeName(), true);
        r137.e(HighlevelNoMessageMonitorEnum.MemberDropCount.getValueNodeName(), true);
        r137.e(HighlevelNoMessageMonitorEnum.MemberFilterCount.getValueNodeName(), true);
        r137.e(HighlevelNoMessageMonitorEnum.MemberShowCount.getValueNodeName(), true);
        r137.e(HighlevelNoMessageMonitorEnum.NotifyReceiveCount.getValueNodeName(), true);
        r137.e(HighlevelNoMessageMonitorEnum.NotifyDropCount.getValueNodeName(), true);
        r137.e(HighlevelNoMessageMonitorEnum.NotifyFilterCount.getValueNodeName(), true);
        r137.e(HighlevelNoMessageMonitorEnum.NotifyShowCount.getValueNodeName(), true);
        r137.a(new a42.a(r136.d()));
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.g(r137.f());
    L133:
        if (b4.f536156a.getValue().c() == true) goto L135;
        return;
    L135:
        if (getMiddlewareRoomContext() == null) goto L144;
        this.f136576d.add(o0.b(getMiddlewareRoomContext(), "WebcastMemberMessage", this.f136586n, new c(this)));
        return;
    L144:
        return;
    L109:
        if (isScreenPortrait() == true) goto L111;
        r102 = true;
        goto L111
    L88:
        if (r118.getMessageManager() == null) goto L92;
        if (this.f136577e.getMessageManager().getValue() == null) goto L92;
        this.f136577e.getMessageManager().getValue().addMessageListener("WebcastNotifyEffectMessage", this);
        goto L92
    L76:
        if (isScreenPortrait() == false) goto L78;
        int r138 = s1.j(R.dimen.ttlive_portrait_enter_animate_container_bottom_margin);
    L79:
        this.f136574b.setChildMarginBottom(r138);
        goto L80
    L78:
        r138 = 0;
        goto L79
    L72:
        ALogger.e("EnterAnimWidget", "mockOpenAssetMessage#" + getRoomContextService().getRoomInteractivityService(this.dataContext) + "dataContext:" + this.dataContext);
        goto L73
    L61:
        if ((r114 instanceof dmc.a) == false) goto L68;
        ?? r139 = new r72.d(this);
        int r140 = j.f136572a;
        Intrinsics.checkNotNullParameter("WebcastMemberMessage", "messageMethod");
        Intrinsics.checkNotNullParameter(r139, "listener");
        com.bytedance.android.livesdk.interactivity.common.utils.i r141 = new com.bytedance.android.livesdk.interactivity.common.utils.i(r139, SetsKt.emptySet(), SetsKt.linkedSetOf(new String[]{"WebcastMemberMessage"}));
        this.f136583k = r141;
        if (r114 == null) goto L69;
        if ((r114 instanceof dmc.a) == false) goto L69;
        ((dmc.a) r114).C(r141);
        ALogger.i("LiveMessageTracer", "addReplayMessageListener");
        goto L69
    L54:
        if (i1.f536195a.getValue().booleanValue() == true) goto L57;
        r115 = false;
        goto L59
    L43:
        if (r113.getCleanMode() == null) goto L51;
        if (this.f136579g == null) goto L51;
        h r142 = this.f136580h;
        ViewGroup r143 = this.containerView;
        if (this.f136577e.getCleanMode().getValue().intValue() == 0) goto L49;
        boolean r144 = true;
    L50:
        r142.a(r143, 3, r144);
        this.f136576d.add(this.f136577e.getCleanMode().a().subscribe(new r72.c(this)));
        goto L51
    L49:
        r144 = false;
        goto L50
    L39:
        this.f136580h.a(this.containerView, 0, false);
    L29:
        r106 = true;
        goto L30
    }

    @Override // vlc.l
    public final void onMessage(final tlc.d r100) {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        if (this.f136574b == null) goto L10;
        g.a(new r72.h(this, r100));
        return;
    }

    @Override // com.bytedance.android.livesdk.common.i
    public final void qo(Boolean r100) {
        this.f136573a = r100;
    }

    public final void wq(int r100) {
        View r101 = this.containerView.findViewById(R.id.enter);
        if ((r101 instanceof EnterAnimationView) == true) goto L5;
        return;
    L5:
        ((EnterAnimationView) r101).setChildMarginBottom(r100);
    }

    public final void xq(k32.a r100) {
        int r101 = com.bytedance.android.livesdk.interactivity.enteranim.utils.f.f136787a;
        va.a r102 = r100.f501694k;
        if (r102 == null) goto L5;
        py.k r103 = r102.getTextIcon();
    L6:
        if (r103 != null) goto L8;
        return;
    L8:
        int r104 = t72.a.f544877a;
        d r105 = new d(this, r100);
        Intrinsics.checkNotNullParameter(r103, "imageModel");
        Intrinsics.checkNotNullParameter(r105, "callback");
        new t72.a.b(r103, r105).a();
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final boolean yq(va r100) {
        IBaseUser r101 = r100.getUser();
        if (r101 != null) goto L6;
        return true;
    L6:
        if (TextUtils.isEmpty(r101.getIdString()) == false) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == true) goto L13;
    L15:
        return false;
    L13:
        if (((Boolean) this.dataCenter.get("data_is_need_to_filter_self_enter_msg", Boolean.FALSE)).booleanValue() == false) goto L15;
        return true;
    L8:
        if (TextUtils.equals(r101.getIdString(), ((IMiddlewareUserService) k.f(IMiddlewareUserService.class)).user().n()) == false) goto L10;
        r102 = true;
        goto L11
    }

    public final void zq(va r100) {
        z32.b.a(HighlevelNoMessageMonitorEnum.MemberReceiveCount);
        if (isScreenPortrait() == true) goto L6;
        z32.b.a(HighlevelNoMessageMonitorEnum.MemberDropCount);
        return;
    L6:
        if (r100 != null) goto L8;
    L31:
        z32.b.a(HighlevelNoMessageMonitorEnum.MemberDropCount);
        return;
    L8:
        if (isViewValid() == false) goto L31;
        if (this.f136574b == null) goto L31;
        if (r100.getAction() == 1) goto L17;
        z32.b.a(HighlevelNoMessageMonitorEnum.MemberDropCount);
        return;
    L17:
        if (yq(r100) == false) goto L20;
        z32.b.a(HighlevelNoMessageMonitorEnum.MemberDropCount);
        return;
    L20:
        s72.d r101 = this.f136575c;
        boolean r102 = ((Boolean) this.dataCenter.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        r101.getClass();
        k32.a r103 = s72.d.a(r100, r102);
        if (r100.r() != null) goto L27;
        if (r100.e() != 0) goto L27;
        z32.b.a(HighlevelNoMessageMonitorEnum.MemberFilterCount);
        return;
    L27:
        if (com.bytedance.android.livesdk.interactivity.enteranim.utils.f.a(r103) == false) goto L29;
        xq(r103);
        return;
    L29:
        this.f136574b.b(r103);
    }
}
