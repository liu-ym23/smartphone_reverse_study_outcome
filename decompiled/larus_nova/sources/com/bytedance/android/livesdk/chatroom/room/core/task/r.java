package com.bytedance.android.livesdk.chatroom.room.core.task;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.m2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.model.h0;
import com.bytedance.android.livesdk.chatroom.room.engine.PreEnterRoomManager;
import com.bytedance.android.livesdk.chatroom.room.engine.RoomEngine$lifecycleObserver$1;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.v6;
import com.bytedance.android.livesdkapi.depend.live.LiveRoomState;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.room.RoomBaseSession;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.backend.BackendTaskConfigSwitch;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerExtraRenderController;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class r extends is2.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bundle f111062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f111063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l f111064d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RoomBaseSession f111065e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final is2.g f111066f;

    @Override // is2.h, tw2.b
    public final String getSpm() {
        return "InitRoomTaskV1";
    }

    @Override // is2.h, tw2.b
    public final Map<String, Object> getPropertyParams() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("room_id", Long.valueOf(this.f111065e.getRoomId()));
        Object r101 = this.f111065e.getExtra().get("enter_from_merge");
        Object r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.put("enter_from_merge", r101);
        Object r103 = this.f111065e.getExtra().get("enter_method");
        if (r103 == null) goto L9;
        r102 = r103;
    L9:
        r100.put("enter_method", r102);
        if (this.f111063c.length() <= 0) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == false) goto L15;
        r100.put("error_return_status", this.f111063c);
    L15:
        return r100;
    L12:
        r104 = false;
        goto L13
    }

    @Override // is2.h
    public final void a(Map<String, ? extends Object> r110) {
        Intrinsics.checkNotNullParameter(r110, "extra");
        this.f111062b = this.f111065e.getExtra();
        com.bytedance.android.livesdk.log.b0 r111 = com.bytedance.android.livesdk.log.b0.o();
        String r100 = "initroom task id " + this.f111065e.getRoomId();
        r111.getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_room", r100);
        RoomBaseSession r112 = this.f111065e;
        Intrinsics.checkNotNullParameter(r112, "$this$createPlayer");
        LivePlatformPlayerManager.c(r112.getRoomIdWithMicRoom(), r112.isPseudo()).g(r112.getFirstShow());
        as0.a r113 = LivePlatformPlayerManager.c(this.f111065e.getRoomId(), this.f111065e.isPseudo());
        r113.t(this.f111065e.getContext());
        r113.h();
        ILivePlayerClient r114 = r113.player();
        if (r114 == null) goto L7;
        ILivePlayerExtraRenderController r115 = r114.extraRenderController();
        if (r115 == null) goto L7;
        r115.setRoomLoggerService(this.f111064d);
    L7:
        LiveRoomState r116 = this.f111065e.getCurState();
        LiveRoomState r101 = LiveRoomState.INITIALIZED;
        Object r102 = LiveRoomState.LIVE_FINISHED;
        Long r103 = null;
        Room r104 = null;
        if (m2.a(r116, new Object[]{r101, r102}) == true) goto L10;
        com.bytedance.android.livesdk.live.provider.a.f147597b.f147598a = null;
        this.f111063c = this.f111065e.getCurState().name();
        return;
    L10:
        MutableLiveData<Boolean> r117 = this.f111065e.getEventHub().getInitRoom();
        Boolean r105 = Boolean.TRUE;
        r117.setValue(r105);
        if (this.f111065e.getCurState() == r102) goto L13;
    L18:
        this.f111065e.setHasEndOnce(false);
        this.f111065e.getEventHub().getShowLiveEnd().setValue(Boolean.FALSE);
        com.bytedance.android.livesdk.chatroom.j r118 = ((IMiddlewareRoomService) jc1.k.n(IMiddlewareRoomService.class)).backToRoomDataUtil();
        DataCenter r106 = this.f111065e.getDataCenter();
        Bundle r107 = this.f111062b;
        if (r107 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("args");
    L21:
        ((com.bytedance.android.livesdk.chatroom.utils.g) r118).a(r106, r107);
        this.f111065e.setCurState(LiveRoomState.PREPARING);
        DataCenter r119 = this.f111065e.getDataCenter();
        if (r119 == null) goto L24;
        r119.put("log_action_type", this.f111065e.getEnterInfo().f111125a);
    L24:
        this.f111066f.onRoomPrepareV2(true);
        if (this.f111065e.getRoomId() != 0) goto L27;
        is2.i r120 = this.f495588a;
        if (r120 == null) goto L116;
        is2.i.a.a(r120, k.class);
    L116:
        j0.l().sendLog("livesdk_init_room_task_zero", MapsKt.mapOf(new Pair[]{TuplesKt.to("user_id", v6.a()), TuplesKt.to("anchor_id", this.f111065e.getUserId())}), new Object[]{new am2.x(), Room.class});
    L117:
        is2.i r121 = this.f495588a;
        if (r121 == null) goto L120;
        r121.a(com.bytedance.android.live.platformplayer.room.a.class, MapsKt.mapOf(TuplesKt.to("trigger_type", "init_room")));
    L120:
        ILivePlayerClient r122 = com.bytedance.android.live.platformplayer.utils.c.b(this.f111065e);
        if (r122 == null) goto L123;
        r122.unmute("InitRoomTaskV1.prepareNextStep");
    L123:
        com.bytedance.android.livesdk.log.b0 r123 = com.bytedance.android.livesdk.log.b0.o();
        String r108 = "prepareNextStep cause show interaction; id " + this.f111065e.getRoomId();
        r123.getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_room_exit", r108);
        return;
    L27:
        if (com.bytedance.android.live.core.tetris.widgets.d.b() == true) goto L29;
    L102:
        is2.i r124 = this.f495588a;
        if (r124 == null) goto L105;
        is2.i.a.a(r124, EnterRoomTaskV1.class);
    L105:
        BackendTaskConfigSwitch r125 = LiveInfraSettingKeys.LIVE_BACKEND_TASK_CONFIG.getValue();
        if (r125.canUseBackendTask() == false) goto L117;
        if (r125.getDelayBackendWhenDraw() <= 0) goto L110;
        ((ObservableSubscribeProxy) Observable.just(r105).delay(r125.getDelayBackendWhenDraw(), TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).as(AutoDispose.bind(this.f111065e.getLifecycleOwner()))).subscribe(new q(this));
        return;
    L110:
        is2.i r126 = this.f495588a;
        if (r126 == null) goto L117;
        is2.i.a.a(r126, c.class);
        goto L117
    L29:
        if (com.bytedance.android.live.core.tetris.widgets.d.a() == false) goto L46;
        com.bytedance.android.livesdk.chatroom.detail.p r127 = this.f111065e.getPreEnterRoomController();
        new HashMap();
        if (r127 == null) goto L46;
        if (r127.getRoomId() != this.f111065e.getRoomId()) goto L46;
        if (r127.d() == true) goto L46;
        if ((r127.getResult() instanceof h0) == false) goto L46;
        com.bytedance.android.live.core.tetris.widgets.d.g("update preload room using pre enter room");
        RoomBaseSession r109 = this.f111065e;
        Object r128 = r127.getResult();
        if ((r128 instanceof h0) == true) goto L41;
        r128 = null;
    L41:
        h0 r129 = (h0) r128;
        if (r129 == null) goto L44;
        Room r130 = r129.f106917a;
    L45:
        r109.setPreLoadRoom(r130);
        goto L46
    L44:
        r130 = null;
    L46:
        Room r131 = this.f111065e.getPreLoadRoom();
        if (r131 != null) goto L49;
        RoomBaseSession r132 = this.f111065e;
        if (r132 == null) goto L54;
        com.bytedance.android.livesdk.chatroom.detail.p r133 = r132.getPreEnterRoomController();
    L56:
        if (r133 == null) goto L74;
        Lazy r134 = PreEnterRoomManager.f111087h;
        MutableLiveData<Room> r135 = PreEnterRoomManager.a.a().g(this.f111065e.getRoomId());
        if (r135 == null) goto L60;
        r104 = r135.getValue();
    L60:
        if (r104 != null) goto L62;
        RoomBaseSession r136 = this.f111065e;
        if (r136 == null) goto L102;
        LifecycleOwner r137 = r136.getLifecycleOwner();
        if (r137 == null) goto L102;
        MutableLiveData<Room> r138 = PreEnterRoomManager.a.a().f111090c;
        if (r138 == null) goto L72;
        r138.observe(r137, new m(this));
    L72:
        i0.c().postDelayed(new n(r137), 3000);
        goto L102
    L62:
        if (ln1.c.i(r104, this.f111065e) == true) goto L102;
        List<String> r139 = ln1.c.f509981a;
        ln1.c.h(r104, this.f111065e);
        b(r104);
        goto L102
    L74:
        if (ln1.c.f509988h.f() == false) goto L102;
        if (this.f111065e.isInner() == false) goto L102;
        RoomBaseSession r140 = this.f111065e;
        if (r140 == null) goto L91;
        MutableLiveData<Room> r141 = r140.getSplitEnterData();
        if (r141 == null) goto L91;
        Room r142 = r141.getValue();
        if (r142 == null) goto L91;
        long r143 = r142.getRoomId();
        RoomBaseSession r144 = this.f111065e;
        if (r144 == null) goto L87;
        r103 = Long.valueOf(r144.getRoomId());
    L87:
        if (r143 != r103.longValue()) goto L91;
        Room r145 = this.f111065e.getSplitEnterData().getValue();
        if (ln1.c.i(r145, this.f111065e) == true) goto L91;
        ln1.c.h(r145, this.f111065e);
        b(r145);
    L91:
        RoomBaseSession r146 = this.f111065e;
        if (r146 == null) goto L102;
        LifecycleOwner r147 = r146.getLifecycleOwner();
        if (r147 == null) goto L102;
        RoomBaseSession r148 = this.f111065e;
        if (r148 == null) goto L101;
        MutableLiveData<Room> r149 = r148.getSplitEnterData();
        if (r149 == null) goto L101;
        r149.observe(r147, new o(this));
    L101:
        i0.c().postDelayed(new p(this, r147), 3000);
        goto L102
    L54:
        r133 = null;
        goto L56
    L49:
        if (ln1.c.k(this.f111065e, r131) == false) goto L102;
        com.bytedance.android.live.core.tetris.widgets.d.g("part show interaction due to prefetch room info");
        b(r131);
        goto L102
    L13:
        if (Intrinsics.areEqual(this.f111065e.getEventHub().getShowLiveEnd().getValue(), r105) == false) goto L17;
        RoomBaseSession r150 = this.f111065e;
        if (r150.liveEndAutoPageChange == true) goto L17;
        this.f111063c = r150.getCurState().name();
        return;
    L17:
        this.f111065e.setCurState(r101);
        goto L18
    }

    public final void b(Room r100) {
        com.bytedance.live.datacontext.j<ViewModel> r101 = ((IRoomContextService) jc1.k.n(IRoomContextService.class)).getBottomToolbarService(this.f111065e.getDataCenter(), this.f111065e.getRoomId()).a();
        if ((r101 instanceof ap1.a) == true) goto L5;
        r101 = null;
    L5:
        ap1.a r102 = (ap1.a) r101;
        if (r102 == null) goto L8;
        r102.recordTime("pre_enter_end");
    L8:
        if (r100 != null) goto L10;
        return;
    L10:
        List<String> r103 = ln1.c.f509981a;
        ln1.c.m(false);
        this.f111066f.onRoomPreloadV2(r100, true);
    }

    public r(RoomBaseSession r100, RoomEngine$lifecycleObserver$1 r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "lifecycleObserver");
        this.f111065e = r100;
        this.f111066f = r101;
        this.f111063c = "";
        this.f111064d = new l(this);
    }
}
