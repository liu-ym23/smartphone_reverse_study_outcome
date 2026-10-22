package com.bytedance.android.livesdk.star;

import ag1.c;
import am2.x;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdk.chatroom.ui.framework.utils.f;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.kk;
import com.bytedance.android.livesdk.message.model.q1;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.batterymonitor.stragety.AbsBatteryStrategy;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vlc.d;
import vlc.l;
import xs2.b;
import zg1.g0;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/star/StayTimeTaskWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lvlc/l;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StayTimeTaskWidget extends LiveRecyclableWidget implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Room f158432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f158433b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        f.d(this);
        this.f158432a = null;
        d r100 = this.f158433b;
        if (r100 == null) goto L6;
        r100.removeMessageListener(this);
        return;
    }

    public StayTimeTaskWidget() {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        f.c(this);
        DataCenter r101 = this.dataCenter;
        if (r101 != null) goto L5;
        return;
    L5:
        this.f158432a = (Room) r101.get("data_room", null);
        d r102 = (d) this.dataCenter.get("data_message_manager", null);
        this.f158433b = r102;
        if (r102 == null) goto L9;
        r102.addMessageListener(MessageType.CNY_REWARD_MESSAGE.getIntType(), this);
        return;
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r110) {
        Intrinsics.checkNotNullParameter(r110, "message");
        boolean r100 = r110 instanceof q1;
        if (r100 == true) goto L5;
        return;
    L5:
        Room r101 = this.f158432a;
        if (r101 != null) goto L8;
        return;
    L8:
        long r102 = r101.f162599id;
        q1 r103 = (q1) r110;
        kk r104 = c.d(r102, null, "", 10, r103.E(), "#FF004F", AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF, "");
        d r105 = this.f158433b;
        if (r105 == null) goto L39;
        r105.j(r104, true);
    L39:
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L13
        b.a().post(new com.bytedance.android.livesdk.event.c(new JSONObject().put("banner_content", ((q1) r110).G())));     // Catch: Throwable -> L13
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        b.a().post(new g0(1, 1));
        b.a().post(new g0(2, 1));
        if (r100 == false) goto L41;
        HashMap r107 = new HashMap();
        r107.put("lucky_num", r103.G());
        o r108 = u.l().c(x.class);
        if (r108 == null) goto L25;
        Map<String, String> r109 = r108.getMap();
        if (r109 == null) goto L25;
        String r111 = r109.get("enter_from_merge");
        if (r111 == null) goto L25;
        r107.put("enter_from_merge", r111);
    L25:
        if (r108 == null) goto L31;
        Map<String, String> r112 = r108.getMap();
        if (r112 == null) goto L31;
        String r113 = r112.get("enter_method");
        if (r113 == null) goto L31;
        r107.put("enter_method", r113);
    L31:
        if (r108 == null) goto L37;
        Map<String, String> r114 = r108.getMap();
        if (r114 == null) goto L37;
        String r115 = r114.get("action_type");
        if (r115 == null) goto L37;
        r107.put("action_type", r115);
    L37:
        u.l().sendLog("livesdk_dur_task_finish_show", r107, new Object[]{Room.class});
        LiveSlardarMonitor.monitorStatus("ttlive_cny_stay_time_task_message", 1, new JSONObject());
        Observable.create(new jt2.a(r110)).observeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe();
        return;
    L41:
        return;
    L13:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }
}
