package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.app.Activity;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostVerify;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.event.live.MonitorMessageType;
import com.bytedance.android.livesdk.message.model.cn;
import com.bytedance.android.livesdk.message.model.dn;
import com.bytedance.android.livesdk.message.model.mk;
import com.bytedance.android.livesdk.verify.VerificationCodeApi;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.priority.PriorityModule;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/VerifyCodeWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lvlc/l;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VerifyCodeWidget extends LiveRecyclableWidget implements vlc.l {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f115089g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f115090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f115091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f115092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f115093d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f115094e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f115095f;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public b(VerifyCodeWidget r100) {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ((ch1.b) r100).getType();
            MonitorMessageType r101 = MonitorMessageType.UNKNOWN;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, tw2.b
    public final String getSpm() {
        return "a100.a100.a209";
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    public final void Aq() {
        Room r100 = (Room) this.dataCenter.get("data_room", null);
        if (r100 == null) goto L6;
        HashMap r101 = new HashMap();
        r101.put(com.bytedance.android.ec.core.event.a.KEY_PARAM_LIVE_PLATFROM, "live");
        r101.put("anchor_id", r100.getOwnerUserIdString());
        r101.put("live_type", zq(r100));
        r101.put("notice_type", this.f115095f);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_verification_code_notice", r101, new Object[0]);
        return;
    }

    public VerifyCodeWidget() {
        this.f115090a = new CompositeDisposable();
        this.f115094e = "VerifyCodeWidget.Channel";
        this.f115095f = "";
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        vlc.d r100 = (vlc.d) this.dataCenter.get("data_message_manager", null);
        if (r100 == null) goto L5;
        r100.removeMessageListener(this);
    L5:
        this.f115090a.clear();
        Disposable r101 = this.f115093d;
        if (r101 == null) goto L9;
        r101.dispose();
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        DataCenter r101 = this.dataCenter;
        if (r101 != null) goto L5;
        return;
    L5:
        this.f115091b = false;
        Disposable r102 = null;
        vlc.d r103 = (vlc.d) r101.get("data_message_manager", null);
        if (r103 == null) goto L8;
        r103.addMessageListener(MessageType.VERIFY_CODE_MESSAGE.getIntType(), this);
        r103.addMessageListener(MessageType.VERIFY_DECISION_CODE_MESSAGE.getIntType(), this);
    L8:
        DataContext r104 = com.bytedance.live.datacontext.d.d(RoomContext.class);
        if ((r104 instanceof RoomContext) == true) goto L11;
        r104 = null;
    L11:
        RoomContext r105 = (RoomContext) r104;
        if (r105 == null) goto L18;
        com.bytedance.live.datacontext.m<ch1.b> r106 = r105.getReconnectMonitorMessage();
        if (r106 == null) goto L18;
        Observable<ch1.b> r107 = r106.a();
        if (r107 == null) goto L18;
        r102 = r107.subscribe(new b(this));
    L18:
        this.f115093d = r102;
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r110) {
        long r100 = 0;
        DataContext r101 = null;
        String r102 = null;
        r102 = null;
        if (r110 != null) goto L5;
    L20:
        if (r110 != null) goto L22;
        return;
    L22:
        if (r110.getIntType() == MessageType.VERIFY_DECISION_CODE_MESSAGE.getIntType()) goto L24;
        return;
    L24:
        if ((r110 instanceof dn) == false) goto L53;
        dn r111 = (dn) r110;
        Logger.d("VerifyCodeWidget", "showVerifyCodeDialogV2, data=" + r111.E() + ' ' + r111.G() + ' ' + r111.H());
        IHostVerify r103 = TTLiveSDK.hostService().verify();
        Activity r104 = com.bytedance.android.live.core.utils.s2.a(this.context);
        String r105 = r111.G();
        String r106 = "";
        if (r105 != null) goto L28;
        r105 = "";
    L28:
        r103.showCaptchaV2(r104, r105, new t3(this, r111));
        if (r111.H() <= 0) goto L31;
        long r107 = r111.H();
    L32:
        Logger.i("VerifyCodeWidget", "showVerifyCodeDialogV2, timeout = " + r107);
        this.f115090a.add(Observable.timer(r107, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(u3.f117535a, v3.f117540a));
        String r112 = r111.E();
        Room r108 = (Room) this.dataCenter.get("data_room", null);
        DataContext r109 = com.bytedance.live.datacontext.d.d(RoomContext.class);
        if ((r109 instanceof RoomContext) == false) goto L36;
        r101 = r109;
    L36:
        RoomContext r113 = (RoomContext) r101;
        if (r108 == null) goto L54;
        HashMap r114 = new HashMap();
        r114.put("anchor_id", r108.getOwnerUserIdString());
        r114.put("room_id", r108.getIdStr());
        if (r113 == null) goto L48;
        com.bytedance.live.datacontext.n<mk> r115 = r113.getCurStatMessage();
        if (r115 == null) goto L48;
        mk r116 = r115.getValue();
        if (r116 == null) goto L48;
        String r117 = String.valueOf(r116.getTotal());
        if (r117 == null) goto L48;
        r106 = r117;
    L48:
        r114.put("watch_ucnt", r106);
        r114.put("check_reason", r112);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_man_machine_check_show", r114, new Object[0]);
        return;
    L54:
        return;
    L31:
        r107 = 60;
        goto L32
    L53:
        return;
    L5:
        if (r110.getIntType() != MessageType.VERIFY_CODE_MESSAGE.getIntType()) goto L20;
        if ((r110 instanceof cn) == false) goto L20;
        this.f115091b = false;
        cn r118 = (cn) r110;
        Logger.d("VerifyCodeWidget", "VerificationCodeMessage, id=" + r118.getId() + ", duration=" + r118.getDuration());
        Room r119 = (Room) this.dataCenter.get("data_room", null);
        if (r119 == null) goto L11;
        r100 = r119.f162599id;
    L11:
        if (r119 == null) goto L14;
        String r120 = r119.getOwnerUserIdString();
        if (r120 == null) goto L14;
    L15:
        if (r119 == null) goto L19;
        User r121 = r119.mo8271getOwner();
        if (r121 == null) goto L19;
        r102 = r121.getCastSecUid();
    L19:
        this.f115090a.add(((VerificationCodeApi) com.bytedance.android.live.network.c.b().e(VerificationCodeApi.class)).requestVerificationCode(r120, r102, r100).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new o3(this, r118, r119), p3.f115331a));
        return;
    L14:
        r120 = "0";
        goto L15
    }

    public final String zq(Room r100) {
        LiveMode r101 = r100.getStreamType();
        int r102 = l3.f115308a[r101.ordinal()];
        if (r102 != 1) goto L5;
        return "video_live";
    L5:
        if (r102 != 2) goto L7;
        return "voice_live";
    L7:
        if (r102 != 3) goto L9;
        return PriorityModule.SCENE_THIRD_PARTY;
    L9:
        if (r102 == 4) goto L11;
        return "undefined";
    L11:
        return "game";
    }

    public static final void wq(VerifyCodeWidget r100, int r101) {
        Room r102 = (Room) r100.dataCenter.get("data_room", null);
        if (r102 == null) goto L13;
        HashMap r103 = new HashMap();
        r103.put(com.bytedance.android.ec.core.event.a.KEY_PARAM_LIVE_PLATFROM, "live");
        r103.put("anchor_id", r102.getOwnerUserIdString());
        switch(r101) {
            case 0: goto L10;
            case 1: goto L9;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L6:
        r103.put("type", "shutdown");
    L11:
        r103.put("live_type", r100.zq(r102));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_verification_code_close", r103, new Object[0]);
        return;
    L7:
        r103.put("type", "timeout");
        goto L11
    L8:
        r103.put("type", "shutdown");
        goto L11
    L9:
        r103.put("type", "notpass");
        goto L11
    L10:
        r103.put("type", "pass");
        goto L11
    }

    public static final void xq(VerifyCodeWidget r100, String r101, boolean r102) {
        DataCenter r103 = r100.dataCenter;
        if (r103 == null) goto L27;
        DataContext r104 = null;
        Room r105 = (Room) r103.get("data_room", null);
        DataContext r106 = com.bytedance.live.datacontext.d.d(RoomContext.class);
        if ((r106 instanceof RoomContext) == false) goto L9;
        r104 = r106;
    L9:
        RoomContext r107 = (RoomContext) r104;
        if (r105 == null) goto L26;
        HashMap r108 = new HashMap();
        r108.put("anchor_id", r105.getOwnerUserIdString());
        r108.put("room_id", r105.getIdStr());
        if (r107 == null) goto L19;
        com.bytedance.live.datacontext.n<mk> r109 = r107.getCurStatMessage();
        if (r109 == null) goto L19;
        mk r110 = r109.getValue();
        if (r110 == null) goto L19;
        String r111 = String.valueOf(r110.getTotal());
        if (r111 == null) goto L19;
    L20:
        r108.put("watch_ucnt", r111);
        r108.put("check_reason", r101);
        if (r102 == false) goto L23;
        String r112 = "success";
    L24:
        r108.put(LocationMonitorConst.CHECK_RESULT, r112);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_man_machine_check_result", r108, new Object[0]);
        return;
    L23:
        r112 = "fail";
    L19:
        r111 = "";
        goto L20
    L26:
        return;
    }

    public static final void yq(VerifyCodeWidget r100, cn r101, int r102) {
        if (r100.f115091b == true) goto L7;
        Disposable r103 = ((VerificationCodeApi) com.bytedance.android.live.network.c.b().e(VerificationCodeApi.class)).reportVerificationResult(r101.getId(), r101.getMessageId(), r102).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(m3.f115313a, n3.f115318a);
        r100.f115090a.add(r103);
        return;
    }
}
