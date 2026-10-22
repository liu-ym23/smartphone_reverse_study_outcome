package com.bytedance.android.livesdk.chatroom.appointment;

import am2.x;
import android.widget.TextView;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.y;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.StringCompanionObject;
import vlc.d;
import vlc.l;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/appointment/AppointmentAnchorWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Lvlc/l;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AppointmentAnchorWidget extends LiveWidget implements l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f105100c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f105101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f105102b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_appointment_anchor_widget_layout;
    }

    public AppointmentAnchorWidget() {
        this.f105101a = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        this.f105102b = (TextView) findViewById(R.id.tv_count);
        AppointmentApi r100 = (AppointmentApi) com.bytedance.android.live.network.c.b().e(AppointmentApi.class);
        RoomContext.a r101 = RoomContext.Companion;
        RoomContext r102 = RoomContext.a.c(r101, null, 0, 3);
        if (r102 == null) goto L10;
        m<Room> r103 = r102.getRoom();
        if (r103 == null) goto L10;
        Room r104 = r103.getValue();
        if (r104 == null) goto L10;
        String r105 = r104.getOwnerUserIdString();
        if (r105 == null) goto L10;
    L11:
        RoomContext r106 = RoomContext.a.c(r101, null, 0, 3);
        if (r106 == null) goto L18;
        m<Room> r107 = r106.getRoom();
        if (r107 == null) goto L18;
        Room r108 = r107.getValue();
        if (r108 == null) goto L18;
        long r109 = r108.getCreateTime();
    L19:
        RxUtilKt.c(r100.querySubscribeCount(r105, r109).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.chatroom.appointment.a(this), new b(this)), this.f105101a);
        RoomContext r110 = RoomContext.a.c(r101, null, 0, 3);
        if (r110 == null) goto L24;
        j<d> r111 = r110.getMessageManager();
        if (r111 == null) goto L24;
        r111.c(new AnonymousClass1(this));
    L24:
        int r112 = c.f105105a;
        RoomContext r113 = RoomContext.a.c(r101, null, 0, 3);
        if (r113 == null) goto L39;
        m<Room> r114 = r113.getRoom();
        if (r114 == null) goto L40;
        Room r115 = r114.getValue();
        if (r115 == null) goto L41;
        String r116 = r115.getOwnerUserIdString();
        String r117 = String.valueOf(r115.getRoomId());
        String r118 = r115.getOwnerUserIdString() + '_' + r115.getCreateTime();
        o r119 = u.l().c(x.class);
        HashMap r120 = new HashMap();
        r120.put("anchor_id", r116);
        r120.put("room_id", r117);
        r120.put("enter_method", "live_room_head");
        r120.put("appointment_id", r118);
        r120.put("is_able_click", "0");
        r120.put(IPerformanceManager.Params.is_anchor, "1");
        if (r119.getMap().containsKey("enter_from_merge") == false) goto L37;
        String r121 = r119.getMap().get("enter_from_merge");
        if (r121 != null) goto L36;
        r121 = "";
    L36:
        r120.put("enter_from_merge", r121);
    L37:
        u.l().sendLog("livesdk_live_announce_card_show", r120, new Object[0]);
        return;
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L18:
        r109 = 0;
    L10:
        r105 = "0";
        goto L11
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        RoomContext r100 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r100 == null) goto L7;
        j<d> r101 = r100.getMessageManager();
        if (r101 == null) goto L7;
        r101.c(new C100021(this));
    L7:
        this.f105101a.clear();
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if ((r100 instanceof y) == false) goto L10;
        y.a r101 = ((y) r100).data;
        if (r101 == null) goto L7;
        Long r102 = Long.valueOf(r101.a());
    L8:
        wq(r102);
        return;
    L7:
        r102 = null;
        goto L8
    }

    public final void wq(Long r110) {
        if (r110 == null) goto L14;
        long r100 = r110.longValue();
        TextView r111 = this.f105102b;
        if (r111 == null) goto L15;
        long r101 = 10000;
        if (r100 > r101) goto L8;
        String r102 = String.valueOf(r100);
    L12:
        r111.setText(r102);
        return;
    L8:
        if ((r100 % r101) != 0) goto L10;
        r102 = String.valueOf(r100 / r101) + "万";
        goto L12
    L10:
        StringBuilder r103 = new StringBuilder();
        StringCompanionObject r104 = StringCompanionObject.INSTANCE;
        r103.append(String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(r100 / 10000)}, 1)));
        r103.append("万");
        r102 = r103.toString();
        goto L12
    L15:
        return;
    }
}
