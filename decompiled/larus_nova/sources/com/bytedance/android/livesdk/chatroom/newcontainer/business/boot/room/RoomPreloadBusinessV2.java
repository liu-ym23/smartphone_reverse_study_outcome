package com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room;

import am2.x;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.room.api.playopt.topspeed.TopSpeedModeManager;
import com.bytedance.android.live.room.api.playopt.topspeed.base.LivePrefStatus;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.adapter.LiveDetailPagerAdapter;
import com.bytedance.android.livesdk.chatroom.helper.o;
import com.bytedance.android.livesdk.chatroom.room.RoomPreloadTaskManager;
import com.bytedance.android.livesdk.chatroom.room.RoomSession;
import com.bytedance.android.livesdk.chatroom.room.p0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.room.c;
import com.bytedance.android.livesdk.room.state.ContainerLifecycle;
import com.bytedance.android.livesdk.room.state.WidgetLevel;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.widget.LiveVerticalViewPager;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import com.bytedance.android.livesdkapi.eventbus.NewLiveActivityStartEvent;
import com.bytedance.android.livesdkapi.eventbus.NewLiveExternalOperatorCreate;
import com.bytedance.android.livesdkapi.eventbus.NewLiveRoomCreateEvent;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.PreloadOpt;
import com.bytedance.android.livesdkapi.service.com.bytedance.android.livesdkapi.depend.model.live.PRELOAD_DISABLE_REASON;
import com.bytedance.android.livesdkapi.service.com.bytedance.android.livesdkapi.depend.model.live.PRELOAD_STAGE;
import com.bytedance.android.livesdkapi.service.com.bytedance.android.livesdkapi.depend.model.live.RoomPreloadStage;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import ts2.f;
import ts2.g;
import ts2.r;
import vh1.x1;
import vh1.y1;
import vm2.h;

/* JADX INFO: loaded from: classes7.dex */
public final class RoomPreloadBusinessV2 extends c<ls2.c> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f107041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CompositeDisposable f107042c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f107043d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f107044e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f107045f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RoomPreloadBusinessV2$liveEndObserver$1 f107046g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.android.livesdk.room.b f107047h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ik1.c f107048i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, Boolean> f107049j;

    public static final class a implements vf1.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomPreloadBusinessV2 f107050a;

        public a(RoomPreloadBusinessV2 r100) {
            this.f107050a = r100;
        }

        @Override // vf1.a
        public final void a(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
            RoomPreloadBusinessV2 r102 = this.f107050a;
            com.bytedance.android.livesdk.room.b r103 = r102.f107047h;
            if (r103 == null) goto L23;
            String r104 = r102.f107041b;
            StringBuilder r105 = new StringBuilder("reset preload stage, position = ");
            r105.append(r101);
            r105.append(", hashcode = ");
            this.f107050a.getClass();
            ILiveRoomPlayFragment r106 = RoomPreloadBusinessV2.F(r103, r101);
            Bundle r107 = null;
            if (r106 == null) goto L9;
            Fragment r108 = r106.getFragment();
            if (r108 == null) goto L9;
            Integer r109 = Integer.valueOf(r108.hashCode());
        L10:
            r105.append(r109);
            ALogger.i(r104, r105.toString());
            this.f107050a.getClass();
            ILiveRoomPlayFragment r110 = RoomPreloadBusinessV2.F(r103, r101);
            if (r110 == null) goto L16;
            Fragment r111 = r110.getFragment();
            if (r111 == null) goto L16;
            r107 = r111.getArguments();
        L16:
            if (r107 == null) goto L18;
            r107.putBoolean(ILiveRoomPlayFragmentConstant.EXTRA_NEED_PRE_REQUEST_ROOM_PRELOAD, false);
        L18:
            if (r107 == null) goto L20;
            r107.putBoolean(ILiveRoomPlayFragmentConstant.EXTRA_NEED_PRE_REQUEST_ROOM_BACKEND, false);
        L20:
            if (r107 == null) goto L24;
            r107.putBoolean(ILiveRoomPlayFragmentConstant.EXTRA_NEED_PRE_ENTER_ROOM, false);
            return;
        L24:
            return;
        L9:
            r109 = null;
            goto L10
        }

        @Override // vf1.a
        public final void b(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
            int r102 = this.f107050a.E();
            if (r102 >= 0) goto L5;
            return;
        L5:
            if ((r102 + 1) != r101) goto L22;
            RoomPreloadBusinessV2 r103 = this.f107050a;
            com.bytedance.android.livesdk.room.b r104 = r103.f107047h;
            if (r104 == null) goto L23;
            String r105 = r103.f107041b;
            StringBuilder r106 = new StringBuilder("on fragment init, position = ");
            r106.append(r101);
            r106.append(", hashcode = ");
            this.f107050a.getClass();
            ILiveRoomPlayFragment r107 = RoomPreloadBusinessV2.F(r104, r101);
            Bundle r108 = null;
            if (r107 == null) goto L13;
            Fragment r109 = r107.getFragment();
            if (r109 == null) goto L13;
            Integer r110 = Integer.valueOf(r109.hashCode());
        L14:
            r106.append(r110);
            ALogger.i(r105, r106.toString());
            RoomPreloadBusinessV2 r111 = this.f107050a;
            r111.getClass();
            ILiveRoomPlayFragment r112 = RoomPreloadBusinessV2.F(r104, r101);
            if (r112 == null) goto L19;
            Fragment r113 = r112.getFragment();
            if (r113 == null) goto L19;
            r108 = r113.getArguments();
        L19:
            r111.K(r108);
            return;
        L13:
            r110 = null;
            goto L14
        L23:
            return;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomPreloadBusinessV2 f107051a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Class f107052b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.livesdk.room.b f107053c;

        public b(RoomPreloadBusinessV2 r100, Class r101, com.bytedance.android.livesdk.room.b r102) {
            this.f107051a = r100;
            this.f107052b = r101;
            this.f107053c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(T r100) {
            ALogger.i(this.f107051a.f107041b, "stopPreRoom because receive event: ".concat(this.f107052b.getSimpleName()));
            ((com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b) this.f107053c.a(com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b.class)).wv(MapMonitorConst.EVENT_DESTROY);
        }
    }

    @Override // os2.a
    public final ls2.c d() {
        return null;
    }

    public final int E() {
        com.bytedance.android.livesdk.room.b r100 = this.f107047h;
        if (r100 == null) goto L7;
        ILiveRoomPlayFragment r101 = ((com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b) r100.a(com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b.class)).getRealAction();
        if (r101 == null) goto L7;
        Fragment r102 = r101.getFragment();
    L8:
        if (r102 == null) goto L19;
        com.bytedance.android.livesdk.room.b r103 = this.f107047h;
        if (r103 == null) goto L21;
        com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.session.a r104 = D(r103);
        if (r104 == null) goto L22;
        LiveDetailPagerAdapter r105 = r104.getAdapter();
        if (r105 == null) goto L23;
        int r106 = r105.getItemPosition(r102);
        if (r106 < 0) goto L24;
        ALogger.i(this.f107041b, "getCurrentPosition, current position =  " + r106 + ", businessCode = " + hashCode());
        return r106;
    L24:
        return -1;
    L23:
        return -1;
    L22:
        return -1;
    L21:
        return -1;
    L19:
        return -1;
    L7:
        r102 = null;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.RoomPreloadBusinessV2$liveEndObserver$1] */
    public RoomPreloadBusinessV2() {
        this.f107041b = "RoomPreloadTrigger";
        this.f107042c = new CompositeDisposable();
        this.f107043d = -1;
        this.f107044e = new a(this);
        this.f107046g = new RoomPreloadBusinessV2$liveEndObserver$1(this);
        this.f107049j = new LinkedHashMap();
    }

    public static com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.session.a D(com.bytedance.android.livesdk.room.b r100) {
        return ((dk1.a) r100.a(dk1.a.class)).N8();
    }

    public final void H(boolean r110) {
        if (this.f107045f == true) goto L101;
        int r100 = o.f106488a;
        com.bytedance.android.livesdk.room.b r101 = this.f107047h;
        if (r101 == null) goto L7;
        DataCenter r102 = r101.f157610s;
    L8:
        LinkedHashMap r103 = new LinkedHashMap();
        if (r102 == null) goto L13;
        RoomPreloadStage r104 = z.p(r102);
        if (r104 == null) goto L13;
        int r105 = r104.preloadStage();
    L14:
        if (r102 == null) goto L18;
        RoomPreloadStage r106 = z.p(r102);
        if (r106 == null) goto L18;
        int r107 = r106.roomApiStage();
    L19:
        String r108 = String.valueOf(r105);
        String r109 = "0";
        if (r108 != null) goto L22;
        r108 = "0";
    L22:
        r103.put("room_preload_stage", r108);
        String r111 = String.valueOf(r107);
        if (r111 != null) goto L25;
        r111 = "0";
    L25:
        r103.put("room_preload_api_stage", r111);
        if (r102 == null) goto L31;
        RoomPreloadStage r112 = z.p(r102);
        if (r112 == null) goto L31;
        String r113 = String.valueOf(r112.backendApiStage());
        if (r113 == null) goto L31;
    L32:
        r103.put("room_backend_api_stage", r113);
        String r114 = "click";
        if (r102 == null) goto L38;
        String r115 = (String) r102.get("log_action_type", "click");
        if (r115 == null) goto L38;
        r114 = r115;
    L38:
        r103.put("action_type", r114);
        if (r105 >= 3) goto L41;
    L43:
        boolean r116 = false;
    L45:
        if (r105 < 4) goto L47;
        boolean r117 = true;
    L48:
        String r118 = "1";
        if (r110 == false) goto L51;
        Object r119 = "1";
    L52:
        r103.put("has_start_room", r119);
        if (r110 == false) goto L56;
        if (r117 == false) goto L56;
        Object r120 = "1";
    L57:
        r103.put("preload_used", r120);
        if (r116 == false) goto L60;
        Object r121 = "1";
    L61:
        r103.put("preload_successed", r121);
        if (r102 == null) goto L68;
        RoomPreloadStage r122 = z.p(r102);
        if (r122 == null) goto L68;
        if (r122.isUseRecommendPredict() != true) goto L68;
        Object r123 = "1";
    L69:
        r103.put("is_use_recommend_predict", r123);
        if (r102 == null) goto L76;
        RoomPreloadStage r124 = z.p(r102);
        if (r124 == null) goto L76;
        if (r124.getIsBlockPreload() != true) goto L76;
    L77:
        r103.put("is_preload_shield", r118);
        if (r102 == null) goto L83;
        RoomPreloadStage r125 = z.p(r102);
        if (r125 == null) goto L83;
        String r126 = String.valueOf(r125.getBlockPreloadReason());
        if (r126 == null) goto L83;
    L84:
        r103.put("preload_disable_reason", r126);
        if (r102 == null) goto L90;
        RoomPreloadStage r127 = z.p(r102);
        if (r127 == null) goto L90;
        String r128 = String.valueOf(r127.costTime());
        if (r128 == null) goto L90;
    L91:
        r103.put("use_from_preload_duration", r128);
        if (r102 == null) goto L99;
        RoomPreloadStage r129 = z.p(r102);
        if (r129 == null) goto L99;
        String r130 = String.valueOf(r129.lastEnterRoom2PreloadCost());
        if (r130 == null) goto L99;
        r109 = r130;
    L99:
        r103.put("last_enter_to_preload_start_time", r109);
        u.l().sendLog("livesdk_inner_room_preload_monitor", r103, new Object[]{x.class});
        this.f107045f = true;
        return;
    L90:
        r128 = "0";
    L83:
        r126 = "0";
    L76:
        r118 = "0";
    L68:
        r123 = "0";
        goto L69
    L60:
        r121 = "0";
    L56:
        r120 = "0";
        goto L57
    L51:
        r119 = "0";
        goto L52
    L47:
        r117 = false;
        goto L48
    L41:
        if (r107 < 2) goto L43;
        r116 = true;
    L31:
        r113 = "0";
    L18:
        r107 = 0;
    L13:
        r105 = 0;
        goto L14
    L7:
        r102 = null;
        goto L8
    }

    public final void K(Bundle r100) {
        Map<String, Boolean> r101 = this.f107049j;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        Boolean r103 = (Boolean) r102.get(PreloadType.PRE_REQUEST_ROOM_PRELOAD.getType());
        Boolean r104 = Boolean.TRUE;
        if (Intrinsics.areEqual(r103, r104) == false) goto L6;
        if (r100 == null) goto L6;
        r100.putBoolean(ILiveRoomPlayFragmentConstant.EXTRA_NEED_PRE_REQUEST_ROOM_PRELOAD, true);
    L6:
        Map<String, Boolean> r105 = this.f107049j;
        LinkedHashMap r106 = (LinkedHashMap) r105;
        if (Intrinsics.areEqual((Boolean) r106.get(PreloadType.PRE_REQUEST_ROOM_BACKEND.getType()), r104) == false) goto L10;
        if (r100 == null) goto L10;
        r100.putBoolean(ILiveRoomPlayFragmentConstant.EXTRA_NEED_PRE_REQUEST_ROOM_BACKEND, true);
    L10:
        Map<String, Boolean> r107 = this.f107049j;
        LinkedHashMap r108 = (LinkedHashMap) r107;
        if (Intrinsics.areEqual((Boolean) r108.get(PreloadType.PRE_ENTER_ROOM.getType()), r104) == false) goto L15;
        if (r100 == null) goto L16;
        r100.putBoolean(ILiveRoomPlayFragmentConstant.EXTRA_NEED_PRE_ENTER_ROOM, true);
        return;
    L16:
        return;
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void i(com.bytedance.android.livesdk.room.b r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ALogger.i(this.f107041b, "onExitRoom = " + hashCode() + '}');
        ((LinkedHashMap) this.f107049j).clear();
        DataCenter r101 = r100.f157610s;
        if (r101 == null) goto L5;
        r101.removeObserver(this.f107046g);
    L5:
        H(true);
        CompositeDisposable r102 = this.f107042c;
        if (r102 == null) goto L8;
        r102.dispose();
    L8:
        this.f107042c = null;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void m(com.bytedance.android.livesdk.room.b r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.session.a r101 = D(r100);
        if (r101 == null) goto L7;
        LiveDetailPagerAdapter r102 = r101.getAdapter();
        if (r102 == null) goto L7;
        r102.f105093d.remove(this.f107044e);
    L7:
        ALogger.i(this.f107041b, "onPreloadRoomExit = " + hashCode() + '}');
        ((LinkedHashMap) this.f107049j).clear();
        DataCenter r103 = r100.f157610s;
        if (r103 == null) goto L10;
        r103.removeObserver(this.f107046g);
    L10:
        CompositeDisposable r104 = this.f107042c;
        if (r104 == null) goto L13;
        r104.dispose();
    L13:
        this.f107042c = null;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void o(com.bytedance.android.livesdk.room.b r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ALogger.i(this.f107041b, "roomInit businessCode = " + hashCode() + '}');
        MultiRoomConfig r101 = MultiRoomConfig.INSTANCE;
        if (r101.fixJump() == false) goto L5;
        J(r100, NewLiveExternalOperatorCreate.class);
    L6:
        J(r100, NewLiveRoomCreateEvent.class);
        if (r101.enableRoomPreload() == false) goto L11;
        Disposable r102 = xs2.b.a().c(HorizontalPlayEvent.class).subscribe(new y1(this, HorizontalPlayEvent.class));
        if (r102 == null) goto L11;
        RxUtilKt.c(r102, this.f107042c);
    L11:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return;
    L5:
        J(r100, NewLiveActivityStartEvent.class);
        goto L6
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void q(com.bytedance.android.livesdk.room.b r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ALogger.i(this.f107041b, "onStartEntRoom = " + hashCode() + "}, datacenter is " + r100.f157610s);
        ((xh1.c) r100.a(xh1.c.class)).reset();
        this.f107045f = false;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    public static int A(com.bytedance.android.livesdk.room.b r100, int r101) {
        int r102 = fh1.c.f476958a;
        if (fh1.c.b(r100.f157610s, null, 2) == false) goto L5;
    L12:
        return r101;
    L5:
        if (r101 != TriggerPreloadStage.STAGE_START_LOAD_FS.getValue()) goto L9;
        return TriggerPreloadStage.STAGE_START_LOAD_P0.getValue();
    L9:
        if (r101 != TriggerPreloadStage.STAGE_LOAD_FS_FINISH.getValue()) goto L12;
        return TriggerPreloadStage.STAGE_LOAD_P0_FINISH.getValue();
    }

    public static int C(com.bytedance.android.livesdk.room.b r100, PreloadType r101) {
        int r102 = x1.f554946c[r101.ordinal()];
        if (r102 == 1) goto L13;
        if (r102 == 2) goto L15;
        if (r102 != 3) goto L10;
        return A(r100, MultiRoomConfig.INSTANCE.getPreEnterRoomStage());
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return A(r100, MultiRoomConfig.INSTANCE.getPreRequestRoomBackendStage());
    L13:
        return A(r100, MultiRoomConfig.INSTANCE.getPreRequestRoomPreloadStage());
    }

    public static ILiveRoomPlayFragment F(com.bytedance.android.livesdk.room.b r100, int r101) {
        com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.session.a r102 = D(r100);
        if (r102 == null) goto L5;
        LiveDetailPagerAdapter r103 = r102.getAdapter();
    L6:
        if (r103 == null) goto L8;
        int r104 = r103.getCount();
    L9:
        if (r101 < 0) goto L17;
        if (r101 >= r104) goto L18;
        com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.session.a r105 = D(r100);
        if (r105 == null) goto L19;
        LiveDetailPagerAdapter r106 = r105.getAdapter();
        if (r106 != null) goto L16;
        return null;
    L16:
        return r106.i(r101);
    L19:
        return null;
    L18:
        return null;
    L17:
        return null;
    L8:
        r104 = 0;
        goto L9
    L5:
        r103 = null;
        goto L6
    }

    public static TriggerPreloadStage G(boolean r100, WidgetLevel r101) {
        int r102 = x1.f554944a[r101.ordinal()];
        if (r102 != 1) goto L5;
        if (r100 == false) goto L28;
        return TriggerPreloadStage.STAGE_START_LOAD_FS;
    L28:
        return TriggerPreloadStage.STAGE_LOAD_FS_FINISH;
    L5:
        if (r102 != 2) goto L7;
        if (r100 == false) goto L37;
        return TriggerPreloadStage.STAGE_START_LOAD_P0;
    L37:
        return TriggerPreloadStage.STAGE_LOAD_P0_FINISH;
    L7:
        if (r102 != 3) goto L9;
        if (r100 == false) goto L35;
        return TriggerPreloadStage.STAGE_START_LOAD_P1;
    L35:
        return TriggerPreloadStage.STAGE_LOAD_P1_FINISH;
    L9:
        if (r102 != 4) goto L11;
        if (r100 == false) goto L33;
        return TriggerPreloadStage.STAGE_START_LOAD_P2;
    L33:
        return TriggerPreloadStage.STAGE_LOAD_P2_FINISH;
    L11:
        if (r102 != 5) goto L29;
        if (r100 == false) goto L31;
        return TriggerPreloadStage.STAGE_START_LOAD_ALL;
    L31:
        return TriggerPreloadStage.STAGE_LOAD_ALL_FINISH;
    L29:
        return TriggerPreloadStage.STAGE_LOAD_ALL_FINISH;
    }

    public final <T> void J(com.bytedance.android.livesdk.room.b r100, Class<T> r101) {
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == false) goto L8;
        Disposable r102 = xs2.b.a().c(r101).subscribe(new b(this, r101, r100));
        if (r102 == null) goto L9;
        RxUtilKt.c(r102, this.f107042c);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void t(com.bytedance.android.livesdk.room.b r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ALogger.i(this.f107041b, "roomContainerFinish = " + hashCode() + '}');
        this.f107047h = r100;
        this.f107048i = jk1.a.c(r100);
        if (MultiRoomConfig.INSTANCE.getPreloadOpt() == null) goto L32;
        com.bytedance.android.livesdk.room.b r102 = this.f107047h;
        ik1.c r103 = this.f107048i;
        if (r103 == null) goto L7;
        RoomSession r104 = r103.f490211d;
    L8:
        if (r102 == null) goto L12;
        Long r105 = r102.f510496c;
        if (r105 == null) goto L12;
        long r106 = r105.longValue();
    L13:
        com.bytedance.android.livesdk.room.b r107 = this.f107047h;
        if (r107 == null) goto L18;
        Fragment r108 = r107.f510501h;
        if (r108 == null) goto L18;
        int r109 = r108.hashCode();
    L19:
        RoomPreloadTaskManager r110 = new RoomPreloadTaskManager(r104, r106, r109);
        wh1.a r111 = jk1.a.e(this.f107047h);
        if (r111 == null) goto L22;
        r111.f559644e = r110;
    L22:
        ik1.c r112 = this.f107048i;
        if (r112 == null) goto L27;
        RoomSession r113 = r112.f490211d;
        if (r113 == null) goto L27;
        r113.setRoomPreloadTaskManager(r110);
    L27:
        com.bytedance.android.livesdk.room.b r114 = this.f107047h;
        if (r114 == null) goto L32;
        DataCenter r115 = r114.f157610s;
        if (r115 == null) goto L32;
        r115.put("data_preload_task_manager", r110);
    L18:
        r109 = 0;
    L12:
        r106 = 0;
        goto L13
    L7:
        r104 = null;
    L32:
        com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.session.a r116 = D(r100);
        if (r116 == null) goto L37;
        LiveDetailPagerAdapter r117 = r116.getAdapter();
        if (r117 == null) goto L37;
        r117.f105093d.add(this.f107044e);
    L37:
        DataCenter r118 = r100.f157610s;
        if (r118 == null) goto L40;
        r118.observe("cmd_end_live", this.f107046g);
    L40:
        DataCenter r119 = r100.f157610s;
        if (r119 == null) goto L43;
        r119.put("data_preload_stage", new RoomPreloadStage());
    L43:
        DataCenter r120 = r100.f157610s;
        if (r120 == null) goto L48;
        RoomPreloadStage r121 = z.p(r120);
        if (r121 == null) goto L48;
        r121.enable(true);
    L48:
        this.f107045f = false;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    public final void z(com.bytedance.android.livesdk.room.b r100, TriggerPreloadStage r101) {
        int r102 = r101.getValue();
        PreloadType r103 = PreloadType.PRE_REQUEST_ROOM_PRELOAD;
        if (r102 != C(r100, r103)) goto L5;
        B(r100, false, r103, "当前Fragment " + r101.name());
    L5:
        int r104 = r101.getValue();
        PreloadType r105 = PreloadType.PRE_REQUEST_ROOM_BACKEND;
        if (r104 != C(r100, r105)) goto L8;
        B(r100, false, r105, "当前Fragment " + r101.name());
    L8:
        int r106 = r101.getValue();
        PreloadType r107 = PreloadType.PRE_ENTER_ROOM;
        if (r106 != C(r100, r107)) goto L12;
        B(r100, false, r107, "当前Fragment " + r101.name());
        return;
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void f(com.bytedance.android.livesdk.room.b r100, ContainerLifecycle r101, ts2.a r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 != ContainerLifecycle.ON_RESUME) goto L33;
        ALogger.i(this.f107041b, "on fragment resume, businessC = " + hashCode());
        Bundle r102 = r100.f510497d;
        if (r102 == null) goto L7;
        boolean r103 = r102.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_NEED_PRE_REQUEST_ROOM_PRELOAD, false);
    L8:
        Bundle r104 = r100.f510497d;
        if (r104 == null) goto L11;
        r104.putBoolean(ILiveRoomPlayFragmentConstant.EXTRA_NEED_PRE_REQUEST_ROOM_PRELOAD, false);
    L11:
        Bundle r105 = r100.f510497d;
        if (r105 == null) goto L14;
        boolean r106 = r105.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_NEED_PRE_REQUEST_ROOM_BACKEND, false);
    L15:
        Bundle r107 = r100.f510497d;
        if (r107 == null) goto L18;
        r107.putBoolean(ILiveRoomPlayFragmentConstant.EXTRA_NEED_PRE_REQUEST_ROOM_BACKEND, false);
    L18:
        Bundle r108 = r100.f510497d;
        if (r108 == null) goto L21;
        boolean r109 = r108.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_NEED_PRE_ENTER_ROOM, false);
    L22:
        Bundle r111 = r100.f510497d;
        if (r111 == null) goto L26;
        r111.putBoolean(ILiveRoomPlayFragmentConstant.EXTRA_NEED_PRE_ENTER_ROOM, false);
    L26:
        if (r103 == false) goto L28;
        B(r100, true, PreloadType.PRE_REQUEST_ROOM_PRELOAD, "被预加载的Fragment onResume");
    L28:
        if (r106 == false) goto L30;
        B(r100, true, PreloadType.PRE_REQUEST_ROOM_BACKEND, "被预加载的Fragment onResume");
    L30:
        if (r109 == false) goto L33;
        B(r100, true, PreloadType.PRE_ENTER_ROOM, "被预加载的Fragment onResume");
        goto L33
    L21:
        r109 = false;
        goto L22
    L14:
        r106 = false;
        goto L15
    L7:
        r103 = false;
    L33:
        if (r101 != ContainerLifecycle.ON_CURRENT_PAGE_SELECTED) goto L53;
        if (r110 == null) goto L53;
        if ((r110 instanceof g) == false) goto L53;
        Boolean r112 = ((g) r110).f547346a;
        if (r112 == null) goto L40;
        boolean r113 = r112.booleanValue();
    L41:
        int r114 = E();
        com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.session.a r115 = D(r100);
        if (r115 == null) goto L46;
        LiveVerticalViewPager r116 = r115.getViewPager();
        if (r116 == null) goto L46;
        int r117 = r116.getCurrentItem();
    L47:
        if (r113 == true) goto L53;
        if (r114 >= r117) goto L53;
        if (MultiRoomConfig.INSTANCE.getPreloadOpt() == null) goto L53;
        ALogger.i(this.f107041b, "stopPreRoomForUnSelect, curRoomPosition = " + r114 + ", selectedPosition = " + r117);
        ((com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b) r100.a(com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b.class)).wv(GXViewKey.VIEW_TYPE_CONTAINER_SCROLL);
    L46:
        r117 = 0;
        goto L47
    L40:
        r113 = false;
    L53:
        if (r101 != ContainerLifecycle.ON_CONFIGURATION_CHANGED) goto L56;
        ((LinkedHashMap) this.f107049j).clear();
    L56:
        if (r101 != ContainerLifecycle.ON_BEFORE_INTERACTION_COMMIT) goto L59;
        z(r100, TriggerPreloadStage.STAGE_START_LOAD_INTERACTION);
    L59:
        if (r101 != ContainerLifecycle.ON_DESTROY_VIEW) goto L74;
        ik1.c r118 = this.f107048i;
        if (r118 == null) goto L69;
        RoomSession r119 = r118.f490211d;
        if (r119 == null) goto L69;
        p0 r120 = r119.getEventHub();
        if (r120 == null) goto L69;
        MutableLiveData<Boolean> r121 = r120.isRoomVisible();
        if (r121 == null) goto L69;
        Boolean r122 = r121.getValue();
    L71:
        if (Intrinsics.areEqual(r122, Boolean.FALSE) == false) goto L74;
        H(false);
    L69:
        r122 = null;
    L74:
        if (r101 != ContainerLifecycle.ON_DESTROY) goto L84;
        com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.session.a r123 = D(r100);
        if (r123 == null) goto L80;
        LiveDetailPagerAdapter r124 = r123.getAdapter();
        if (r124 == null) goto L80;
        r124.f105093d.remove(this.f107044e);
    L80:
        ((LinkedHashMap) this.f107049j).clear();
        CompositeDisposable r125 = this.f107042c;
        if (r125 == null) goto L83;
        r125.dispose();
    L83:
        this.f107042c = null;
    L84:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void w(com.bytedance.android.livesdk.room.b r100, WidgetLevel r101, r r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "widgetLevel");
        z(r100, G(true, r101));
        super.w(r100, r101, r102);
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void y(com.bytedance.android.livesdk.room.b r100, WidgetLevel r101, r r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "widgetLevel");
        z(r100, G(false, r101));
        super.y(r100, r101, r102);
    }

    public final void B(com.bytedance.android.livesdk.room.b r110, boolean r210, PreloadType r211, String r212) {
        int r100 = E();
        ILiveRoomPlayFragment r111 = null;
        Bundle r112 = null;
        ILiveRoomPlayFragment r113 = null;
        if (r210 == false) goto L5;
        ILiveRoomPlayFragment r101 = (ILiveRoomPlayFragment) r110.a(com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b.class);
    L10:
        ILiveRoomPlayFragment r114 = r101;
    L12:
        boolean r115 = true;
        if (r210 == true) goto L34;
        this.f107049j.put(r211.getType(), Boolean.TRUE);
        if (r114 == null) goto L17;
        Fragment r102 = r114.getFragment();
    L18:
        if (r102 != null) goto L21;
        I(r114, r210, r211, r212, r100);
        return;
    L21:
        Fragment r103 = r114.getFragment();
        if (r103 == null) goto L29;
        Lifecycle r104 = r103.getLifecycle();
        if (r104 == null) goto L29;
        Lifecycle.State r105 = r104.getCurrentState();
        if (r105 == null) goto L29;
        if (r105.isAtLeast(Lifecycle.State.RESUMED) == true) goto L34;
    L29:
        Fragment r106 = r114.getFragment();
        if (r106 == null) goto L32;
        r112 = r106.getArguments();
    L32:
        K(r112);
        I(r114, r210, r211, r212, r100);
        return;
    L17:
        r102 = null;
    L34:
        int r107 = x1.f554945b[r211.ordinal()];
        if (r107 != 1) goto L37;
        String r108 = this.f107041b;
        StringBuilder r109 = new StringBuilder("real invoke request room preload, isSuccess = ");
        if (r114 != null) goto L362;
        r115 = false;
    L362:
        r109.append(r115);
        ALogger.i(r108, r109.toString());
        I(r114, r210, r211, r212, r100);
        if (r114 == null) goto L376;
        r114.preRequestRoomPreload(false);
        return;
    L376:
        return;
    L37:
        if (r107 != 2) goto L39;
        String r116 = this.f107041b;
        StringBuilder r117 = new StringBuilder("real invoke request room backend, isSuccess = ");
        if (r114 != null) goto L355;
        r115 = false;
    L355:
        r117.append(r115);
        ALogger.i(r116, r117.toString());
        I(r114, r210, r211, r212, r100);
        if (r114 == null) goto L374;
        r114.preBackendRoom();
        return;
    L374:
        return;
    L39:
        if (r107 != 3) goto L377;
        if (r210 == false) goto L52;
        if (r100 < 0) goto L44;
        ILiveRoomPlayFragment r118 = F(r110, r100 - 1);
    L45:
        if (r118 == null) goto L47;
        ILiveRoomPlayFragment r119 = r118.getRealAction();
    L49:
        if ((r119 instanceof com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b) == true) goto L51;
        r119 = null;
    L51:
        com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b r120 = (com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b) r119;
    L53:
        IStrategyService r121 = (IStrategyService) k.f(IStrategyService.class);
        if (r121 == null) goto L59;
        LiveData r122 = IStrategyService.a.a(r121, "live_session_disable_preload", Boolean.FALSE, false, 8);
        if (r122 == null) goto L59;
        Boolean r123 = (Boolean) r122.getValue();
        if (r123 == null) goto L59;
    L61:
        if (r123.booleanValue() == false) goto L70;
        if (r120 == null) goto L199;
        RoomSession r124 = r120.Uq();
        if (r124 == null) goto L199;
        DataCenter r125 = r124.getDataCenter();
        if (r125 == null) goto L199;
        RoomPreloadStage r126 = z.p(r125);
        if (r126 == null) goto L199;
        r126.updatePreloadBlockReason(PRELOAD_DISABLE_REASON.DISABLE_REASON_SMART);
    L199:
        boolean r127 = true;
    L200:
        if (r127 == true) goto L339;
        if (r114 == null) goto L203;
        Fragment r128 = r114.getFragment();
    L204:
        PreloadOpt r129 = MultiRoomConfig.INSTANCE.getPreloadOpt();
        if (r129 != null) goto L207;
    L235:
        boolean r130 = true;
    L236:
        if (r130 == false) goto L339;
        String r131 = this.f107041b;
        StringBuilder r132 = new StringBuilder("real invoke preEnter, isSuccess = ");
        if (r114 == null) goto L240;
        boolean r133 = true;
    L241:
        r132.append(r133);
        ALogger.i(r131, r132.toString());
        I(r114, r210, r211, r212, r100);
        if (r114 == null) goto L248;
        Fragment r134 = r114.getFragment();
        if (r134 == null) goto L248;
        Bundle r135 = r134.getArguments();
        if (r135 == null) goto L248;
        r135.putString("live.intent.extra.ENTER_TYPE", "draw");
    L248:
        boolean r136 = r114 instanceof com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b;
        if (r136 == true) goto L251;
        ILiveRoomPlayFragment r137 = null;
    L252:
        com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b r138 = (com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b) r137;
        if (r138 == null) goto L261;
        RoomSession r139 = r138.Uq();
        if (r139 == null) goto L261;
        DataCenter r140 = r139.getDataCenter();
        if (r140 == null) goto L261;
        RoomPreloadStage r141 = z.p(r140);
        if (r141 == null) goto L261;
        r141.enable(true);
    L261:
        if (r136 == true) goto L263;
        ILiveRoomPlayFragment r142 = null;
    L264:
        com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b r143 = (com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b) r142;
        if (r143 == null) goto L273;
        RoomSession r144 = r143.Uq();
        if (r144 == null) goto L273;
        DataCenter r145 = r144.getDataCenter();
        if (r145 == null) goto L273;
        RoomPreloadStage r146 = z.p(r145);
        if (r146 == null) goto L273;
        r146.updatePreloadStage(PRELOAD_STAGE.HAS_INVOKE_PRELOAD);
    L273:
        long r147 = System.currentTimeMillis();
        if (r136 == true) goto L276;
        ILiveRoomPlayFragment r148 = null;
    L277:
        com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b r149 = (com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b) r148;
        if (r149 == null) goto L285;
        RoomSession r150 = r149.Uq();
        if (r150 == null) goto L285;
        DataCenter r151 = r150.getDataCenter();
        if (r151 == null) goto L285;
        r151.put("data_preload_start_time", Long.valueOf(r147));
    L285:
        if (MultiLinkLoadWidgetUtils.g() == true) goto L287;
    L289:
        r115 = false;
    L290:
        if (r115 == false) goto L336;
        if (r210 == false) goto L302;
        if (r100 < 0) goto L294;
        ILiveRoomPlayFragment r152 = F(r110, r100 - 1);
    L295:
        if (r152 == null) goto L297;
        ILiveRoomPlayFragment r153 = r152.getRealAction();
    L299:
        if ((r153 instanceof com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b) == true) goto L301;
        r153 = null;
    L301:
        com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b r154 = (com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b) r153;
    L304:
        if (r154 == null) goto L310;
        Fragment r155 = r154.getFragment();
        if (r155 == null) goto L310;
        Bundle r156 = r155.getArguments();
        if (r156 == null) goto L310;
        long r157 = r156.getLong(ILiveRoomPlayFragmentConstant.EXTRA_USER_ACTION_ENTER_ROOM_START_TIME);
    L311:
        ALogger.i(this.f107041b, "lastRoomEnterTime = " + r157 + ", lastEnterAction = " + r154 + ", action = " + r114);
        if (r157 <= 0) goto L336;
        if (r136 == true) goto L315;
        ILiveRoomPlayFragment r158 = null;
    L316:
        com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b r159 = (com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b) r158;
        if (r159 == null) goto L323;
        RoomSession r160 = r159.Uq();
        if (r160 == null) goto L323;
        DataCenter r161 = r160.getDataCenter();
        if (r161 == null) goto L323;
        r161.put("data_preload_last_enter_time", Long.valueOf(r157));
    L323:
        long r162 = r147 - r157;
        if (r136 == false) goto L327;
        r113 = r114;
    L327:
        com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b r163 = (com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b) r113;
        if (r163 == null) goto L336;
        RoomSession r164 = r163.Uq();
        if (r164 == null) goto L336;
        DataCenter r165 = r164.getDataCenter();
        if (r165 == null) goto L336;
        RoomPreloadStage r166 = z.p(r165);
        if (r166 == null) goto L336;
        r166.updateLastEnterRoom2PreloadCost(r162);
        goto L336
    L315:
        r158 = r114;
    L310:
        r157 = 0;
        goto L311
    L297:
        r153 = null;
        goto L299
    L294:
        r152 = null;
        goto L295
    L302:
        r154 = (com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b) r110.a(com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b.class);
    L336:
        if (r114 == null) goto L367;
        r114.preEnterRoom();
        return;
    L367:
        return;
    L287:
        if (h.W().logPreloadStart() == false) goto L289;
    L276:
        r148 = r114;
        goto L277
    L263:
        r142 = r114;
        goto L264
    L251:
        r137 = r114;
        goto L252
    L240:
        r133 = false;
        goto L241
    L207:
        if (r129.getEnable() != true) goto L235;
        if (r128 == null) goto L219;
        com.bytedance.android.livesdk.room.b r167 = this.f107047h;
        if (r167 == null) goto L219;
        com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.session.a r168 = D(r167);
        if (r168 == null) goto L219;
        LiveDetailPagerAdapter r169 = r168.getAdapter();
        if (r169 == null) goto L219;
        int r170 = r169.getItemPosition(r128);
        if (r170 < 0) goto L219;
    L220:
        com.bytedance.android.livesdk.room.b r171 = this.f107047h;
        if (r171 == null) goto L227;
        com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.session.a r172 = D(r171);
        if (r172 == null) goto L227;
        LiveVerticalViewPager r173 = r172.getViewPager();
        if (r173 == null) goto L227;
        int r174 = r173.getCurrentItem();
    L229:
        if (r170 < 0) goto L234;
        if (r174 < 0) goto L234;
        if (r170 >= r174) goto L234;
        ALogger.i(this.f107041b, "checkCanLoad false, position = " + r170 + ", selectedPosition = " + r174);
        r130 = false;
    L234:
        ALogger.i(this.f107041b, "checkCanLoad true, position = " + r170 + ", selectedPosition = " + r174);
    L227:
        r174 = -1;
    L219:
        r170 = -1;
        goto L220
    L203:
        r128 = null;
    L339:
        if ((r114 instanceof com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b) == false) goto L342;
        r111 = r114;
    L342:
        com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b r175 = (com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b) r111;
        if (r175 == null) goto L369;
        RoomSession r176 = r175.Uq();
        if (r176 == null) goto L370;
        DataCenter r177 = r176.getDataCenter();
        if (r177 == null) goto L371;
        RoomPreloadStage r178 = z.p(r177);
        if (r178 == null) goto L372;
        r178.updateShield(true);
        return;
    L372:
        return;
    L371:
        return;
    L370:
        return;
    L369:
        return;
    L70:
        if (r120 == null) goto L78;
        RoomSession r179 = r120.Uq();
        if (r179 == null) goto L78;
        DataCenter r180 = r179.getDataCenter();
        if (r180 == null) goto L78;
        Boolean r181 = (Boolean) r180.get("data_is_portrait", Boolean.FALSE);
        if (r181 == null) goto L78;
        boolean r182 = r181.booleanValue();
    L79:
        ik1.c r183 = this.f107048i;
        if (r183 == null) goto L84;
        RoomSession r184 = r183.f490211d;
        if (r184 == null) goto L84;
        boolean r185 = e5.f(r184.getScreenOrientation());
    L85:
        if (r182 == false) goto L88;
        if (r185 == true) goto L88;
    L90:
        boolean r186 = false;
    L91:
        MultiRoomConfig r187 = MultiRoomConfig.INSTANCE;
        if (r187.isBlockPreloadAtPrefPoor() == false) goto L130;
        float r188 = r187.blockPreloadOnJavaUsedPct();
        double r189 = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / Runtime.getRuntime().maxMemory();
        ALogger.i("DisablePreload", "disablePreloadOfCurPref preload javaUsedPct : " + r189);
        if (r189 <= r188) goto L104;
        if (r120 == null) goto L129;
        RoomSession r190 = r120.Uq();
        if (r190 == null) goto L129;
        DataCenter r191 = r190.getDataCenter();
        if (r191 == null) goto L129;
        RoomPreloadStage r192 = z.p(r191);
        if (r192 == null) goto L129;
        r192.updatePreloadBlockReason(PRELOAD_DISABLE_REASON.DISABLE_REASON_MEMORY);
    L129:
        boolean r193 = true;
    L131:
        if (r120 == null) goto L133;
        IRoom r194 = r120.getCurRoom();
    L134:
        if (r194 == null) goto L140;
        boolean r195 = bh0.b.a(r194);
        Lazy r196 = MultiLinkLoadWidgetUtils.f78649a;
        if (h.W().isDisableNotMultiLinkPreload() == false) goto L140;
        if (r195 == true) goto L140;
        boolean r197 = true;
    L141:
        if (r186 == false) goto L150;
        if (r120 == null) goto L150;
        RoomSession r198 = r120.Uq();
        if (r198 == null) goto L150;
        DataCenter r199 = r198.getDataCenter();
        if (r199 == null) goto L150;
        RoomPreloadStage r200 = z.p(r199);
        if (r200 == null) goto L150;
        r200.updatePreloadBlockReason(PRELOAD_DISABLE_REASON.DISABLE_REASON_LANDSCAPE);
    L150:
        ALogger.i("DisablePreload", "preload isBlockPreload : " + r193 + ", disableNotMultiLink: " + r197);
        if (r186 == true) goto L199;
        if (r193 == true) goto L199;
        Bundle r201 = r110.f510497d;
        if (r201 == null) goto L156;
        String r202 = r201.getString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_RECOMMEND_INFO);
    L158:
        if (r187.useRecommendDataForPreload() == true) goto L160;
    L195:
        boolean r203 = false;
    L196:
        if (r203 == true) goto L199;
        r127 = false;
        goto L200
    L160:
        if (r2.a(r202) == false) goto L195;
        Result.Companion r204 = Result.Companion;     // Catch: Throwable -> L193
        String r205 = new JSONObject(r202).optString("feed_draw_client_targets_rec_info");     // Catch: Throwable -> L193
        ALogger.i("DisablePreload", "recommend Prediction recInfoString : " + r205);     // Catch: Throwable -> L193
        if (r2.a(r205) == false) goto L191;
        JSONObject r206 = new JSONObject(r205);     // Catch: Throwable -> L193
        Float r207 = StringsKt.toFloatOrNull(r206.optString("staytime"));     // Catch: Throwable -> L193
        if (r207 == null) goto L166;
        float r208 = r207.floatValue();     // Catch: Throwable -> L193
    L168:
        if (r208 <= 0) goto L170;
        r208 = r208 * 1000;     // Catch: Throwable -> L193
    L170:
        int r209 = (int) r208;     // Catch: Throwable -> L193
        if (r206.has("is_fs_preload_draw") == false) goto L191;
        if (r120 == null) goto L180;
        RoomSession r213 = r120.Uq();     // Catch: Throwable -> L193
        if (r213 == null) goto L180;
        DataCenter r214 = r213.getDataCenter();     // Catch: Throwable -> L193
        if (r214 == null) goto L180;
        RoomPreloadStage r215 = z.p(r214);     // Catch: Throwable -> L193
        if (r215 == null) goto L180;
        r215.updateUseRecommendPredict(true);     // Catch: Throwable -> L193
    L180:
        boolean r216 = r206.optBoolean("is_fs_preload_draw");     // Catch: Throwable -> L193
        ALogger.i("DisablePreload", "recommend Prediction Preload next : " + r216 + "  stayTime :  " + r209);     // Catch: Throwable -> L193
        if (r216 == true) goto L190;
        if (r120 == null) goto L190;
        RoomSession r217 = r120.Uq();     // Catch: Throwable -> L193
        if (r217 == null) goto L190;
        DataCenter r218 = r217.getDataCenter();     // Catch: Throwable -> L193
        if (r218 == null) goto L190;
        RoomPreloadStage r219 = z.p(r218);     // Catch: Throwable -> L193
        if (r219 == null) goto L190;
        r219.updatePreloadBlockReason(PRELOAD_DISABLE_REASON.DISABLE_REASON_PREDICTION);     // Catch: Throwable -> L193
    L190:
        r203 = !r216;     // Catch: Throwable -> L193
        goto L196
    L166:
        r208 = this.f107043d;     // Catch: Throwable -> L193
    L191:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L193
    L193:
        th = move-exception;
        Result.Companion r220 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L195
    L156:
        r202 = null;
    L140:
        r197 = false;
        goto L141
    L133:
        r194 = null;
        goto L134
    L104:
        if (r187.blockPreloadOnPrefSerious() == false) goto L118;
        int r221 = TopSpeedModeManager.f99061l.f99066e.f64752a.intValue();
        ALogger.i("DisablePreload", "disablePreloadOfCurPref preload prefStatus : " + r221);
        if (r221 != LivePrefStatus.PREF_SERIOUS.getCode()) goto L108;
    L109:
        if (r120 == null) goto L129;
        RoomSession r222 = r120.Uq();
        if (r222 == null) goto L129;
        DataCenter r223 = r222.getDataCenter();
        if (r223 == null) goto L129;
        RoomPreloadStage r224 = z.p(r223);
        if (r224 == null) goto L129;
        r224.updatePreloadBlockReason(PRELOAD_DISABLE_REASON.DISABLE_REASON_DEGRADE);
        goto L129
    L108:
        if (r221 == LivePrefStatus.PREF_MEDIUM.getCode()) goto L109;
    L118:
        if (r187.blockPreloadOnAnr() == false) goto L130;
        Boolean r225 = ((com.bytedance.android.livesdk.service.f) TTLiveSDKContext.getHostService()).f157991a.hostPerformanceMonitor().isANRDowngrade();
        ALogger.i("DisablePreload", "disablePreloadOfCurPref anr preload shouldDowngrade : " + r225);
        if (r225.booleanValue() == false) goto L130;
        if (r120 == null) goto L129;
        RoomSession r226 = r120.Uq();
        if (r226 == null) goto L129;
        DataCenter r227 = r226.getDataCenter();
        if (r227 == null) goto L129;
        RoomPreloadStage r228 = z.p(r227);
        if (r228 == null) goto L129;
        r228.updatePreloadBlockReason(PRELOAD_DISABLE_REASON.DISABLE_REASON_ANR);
    L130:
        r193 = false;
    L88:
        if (MultiRoomConfig.INSTANCE.disableLandscape() == false) goto L90;
        r186 = true;
    L84:
        r185 = false;
    L78:
        r182 = false;
    L59:
        r123 = Boolean.FALSE;
        goto L61
    L47:
        r119 = null;
        goto L49
    L44:
        r118 = null;
        goto L45
    L52:
        r120 = (com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b) r110.a(com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b.class);
        goto L53
    L377:
        return;
    L5:
        if (r100 < 0) goto L7;
        ILiveRoomPlayFragment r229 = F(r110, r100 + 1);
    L8:
        if (r229 == null) goto L11;
        r101 = r229.getRealAction();
        goto L10
    L11:
        r114 = null;
        goto L12
    L7:
        r229 = null;
        goto L8
    }

    public final void I(ILiveRoomPlayFragment r100, boolean r101, PreloadType r102, String r103, int r110) {
        if (r100 == null) goto L6;
        IRoom r104 = r100.getCurRoom();
        if (r104 == null) goto L6;
        long r105 = r104.getRoomId();
    L7:
        int r106 = 0;
        if (r101 == false) goto L10;
        boolean r107 = true;
    L19:
        if (r100 == null) goto L23;
        Fragment r108 = r100.getFragment();
        if (r108 == null) goto L23;
        r106 = r108.hashCode();
    L23:
        if (r101 == true) goto L26;
        r110 = r110 + 1;
    L26:
        ALogger.i(this.f107041b, "触发预加载时机: " + r103 + ", 预加载类型:" + r102.getType() + ", isSuccess: " + r107 + ", businessCode: " + hashCode() + ", roomId: " + r105 + ", 被预加载LivePlayFragment的hashCode:" + r106 + ",preloadIndex:" + r110);
        return;
    L10:
        if (r100 == null) goto L18;
        Fragment r109 = r100.getFragment();
        if (r109 == null) goto L18;
        Lifecycle r111 = r109.getLifecycle();
        if (r111 == null) goto L18;
        Lifecycle.State r112 = r111.getCurrentState();
        if (r112 == null) goto L18;
        r107 = r112.isAtLeast(Lifecycle.State.RESUMED);
    L18:
        r107 = false;
    L6:
        r105 = 0;
        goto L7
    }
}
