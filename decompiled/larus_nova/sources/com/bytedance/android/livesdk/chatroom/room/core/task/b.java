package com.bytedance.android.livesdk.chatroom.room.core.task;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.utils.m2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.chatroom.room.engine.RoomEngine$lifecycleObserver$1;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.v6;
import com.bytedance.android.livesdkapi.depend.live.LiveRoomState;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.room.RoomBaseSession;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.backend.BackendTaskConfigSwitch;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import io.reactivex.Observable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b extends is2.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f111006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RoomBaseSession f111007c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final is2.g f111008d;

    @Override // is2.h, tw2.b
    public final String getSpm() {
        return "ActualEnterRoomTask";
    }

    @Override // is2.h, tw2.b
    public final Map<String, Object> getPropertyParams() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("room_id", Long.valueOf(this.f111007c.getRoomId()));
        Object r101 = this.f111007c.getExtra().get("enter_from_merge");
        Object r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.put("enter_from_merge", r101);
        Object r103 = this.f111007c.getExtra().get("enter_method");
        if (r103 == null) goto L9;
        r102 = r103;
    L9:
        r100.put("enter_method", r102);
        if (this.f111006b.length() <= 0) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == false) goto L15;
        r100.put("error_return_status", this.f111006b);
    L15:
        return r100;
    L12:
        r104 = false;
        goto L13
    }

    @Override // is2.h
    public final void a(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "extra");
        this.f111007c.getExtra();
        MutableLiveData<Boolean> r101 = this.f111007c.getEventHub().getPreloadInitRoom();
        Boolean r102 = Boolean.TRUE;
        r101.setValue(r102);
        DataCenter r103 = this.f111007c.getDataCenter();
        if (r103 == null) goto L6;
        r103.put("log_action_type", this.f111007c.getEnterInfo().f111125a);
    L6:
        if (Intrinsics.areEqual(this.f111007c.getEventHub().getInitRoom().getValue(), r102) == false) goto L10;
        is2.i r104 = this.f495588a;
        if (r104 == null) goto L14;
        r104.a(a0.class, MapsKt.mapOf(TuplesKt.to("is_room_visible", r102)));
    L14:
        if (m2.a(this.f111007c.getCurState(), new Object[]{LiveRoomState.PREPARING, LiveRoomState.PREPARING_WITH_PRE_SHOW}) == true) goto L16;
        return;
    L16:
        if (this.f111007c.getRoomId() == 0) goto L28;
        is2.i r105 = this.f495588a;
        if (r105 == null) goto L20;
        is2.i.a.a(r105, EnterRoomTaskV1.class);
    L20:
        BackendTaskConfigSwitch r106 = LiveInfraSettingKeys.LIVE_BACKEND_TASK_CONFIG.getValue();
        if (r106.canUseBackendTask() == true) goto L23;
    L32:
        is2.i r107 = this.f495588a;
        if (r107 == null) goto L35;
        r107.a(com.bytedance.android.live.platformplayer.room.a.class, MapsKt.mapOf(TuplesKt.to("trigger_type", "init_room")));
    L35:
        ILivePlayerClient r108 = com.bytedance.android.live.platformplayer.utils.c.b(this.f111007c);
        if (r108 == null) goto L38;
        r108.unmute();
    L38:
        com.bytedance.android.livesdk.log.b0 r109 = com.bytedance.android.livesdk.log.b0.o();
        String r110 = "prepareNextStep cause show interaction; id " + this.f111007c.getRoomId();
        r109.getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_room_exit", r110);
        return;
    L23:
        if (r106.getDelayBackendWhenDraw() <= 0) goto L25;
        ((ObservableSubscribeProxy) Observable.just(r102).delay(r106.getDelayBackendWhenDraw(), TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).as(AutoDispose.bind(this.f111007c.getLifecycleOwner()))).subscribe(new a(this));
        return;
    L25:
        is2.i r111 = this.f495588a;
        if (r111 == null) goto L32;
        is2.i.a.a(r111, c.class);
        goto L32
    L28:
        is2.i r112 = this.f495588a;
        if (r112 == null) goto L31;
        is2.i.a.a(r112, k.class);
    L31:
        j0.l().sendLog("livesdk_init_room_task_zero", MapsKt.mapOf(new Pair[]{TuplesKt.to("user_id", v6.a()), TuplesKt.to("anchor_id", this.f111007c.getUserId())}), new Object[]{new am2.x(), Room.class});
        goto L32
    L10:
        is2.i r113 = this.f495588a;
        if (r113 == null) goto L14;
        r113.a(t.class, MapsKt.mapOf(TuplesKt.to("is_room_visible", r102)));
        goto L14
    }

    public b(RoomBaseSession r100, RoomEngine$lifecycleObserver$1 r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "lifecycleObserver");
        this.f111007c = r100;
        this.f111008d = r101;
        this.f111006b = "";
    }
}
