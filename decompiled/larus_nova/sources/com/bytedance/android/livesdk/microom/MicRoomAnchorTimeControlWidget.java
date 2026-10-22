package com.bytedance.android.livesdk.microom;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.rxutils.j;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.room.IMicRoomService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.setting.r;
import com.bytedance.android.livesdk.message.model.ik;
import com.bytedance.android.livesdk.message.model.tg;
import com.bytedance.android.livesdk.message.model.vg;
import com.bytedance.android.livesdk.microom.enhance.MicRoomStatusViewModel;
import com.bytedance.android.livesdk.utils.ntp.e;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.OfficialChannelInfo;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import qm2.p;
import qm2.q;
import vlc.l;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/microom/MicRoomAnchorTimeControlWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lvlc/l;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MicRoomAnchorTimeControlWidget extends LiveRecyclableWidget implements l {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f153735g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f153736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public vlc.d f153737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f153738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Room f153739d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f153740e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Disposable f153741f;

    public static final class a {
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f153742a;

        public b(long r100) {
            this.f153742a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Long r101 = (Long) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return Long.valueOf(this.f153742a - r101.longValue());
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MicRoomAnchorTimeControlWidget f153743a;

        public c(MicRoomAnchorTimeControlWidget r100) {
            this.f153743a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Long r111 = (Long) r110;
            Logger.d(Reflection.getOrCreateKotlinClass(MicRoomAnchorTimeControlWidget.class).getSimpleName(), "mic room anchor time: " + r111);
            MicRoomAnchorTimeControlWidget r100 = this.f153743a;
            long r101 = r111.longValue();
            Room r102 = r100.f153739d;
            if (r102 == null) goto L7;
            OfficialChannelInfo r103 = r102.officialChannelInfo;
            if (r103 == null) goto L7;
            long r104 = r103.getForbiddenBeforeEnd();
        L9:
            if (r101 < r104) goto L11;
        L16:
            MicRoomAnchorTimeControlWidget r105 = this.f153743a;
            long r106 = r111.longValue();
            r105.getClass();
            if (r106 != 60) goto L22;
            ik r107 = ag1.c.b(s1.B(R.string.ttlive_mic_room_official_one_min));
            vlc.d r108 = r105.f153737b;
            if (r108 == null) goto L22;
            r108.j(r107, true);
        L22:
            this.f153743a.wq(r111.longValue());
            if (r.a().booleanValue() == true) goto L25;
            return;
        L25:
            if (r111.longValue() != 60) goto L29;
            r.b("trick setAnchorCountDown");
            MicRoomStatusViewModel.a r112 = MicRoomStatusViewModel.Companion;
            DataCenter r109 = this.f153743a.dataCenter;
            r112.getClass();
            MicRoomStatusViewModel.a.a(r109).setAnchorCountDown(true);
            return;
        L29:
            return;
        L11:
            if (r100.f153738c == true) goto L16;
            r100.f153738c = true;
            String r113 = s1.C(R.string.ttlive_mic_room_end_status, new Object[]{Long.valueOf(r104 / 60)});
            y3.f(r100.dataCenter).a(ToolbarButton.VOTE, r113);
            y3.f(r100.dataCenter).a(ToolbarButton.LOTTERY, r113);
            y3.m(r100.dataCenter).a(ToolbarButton.PK, r113);
            y3.m(r100.dataCenter).a(ToolbarButton.INTERACTION, r113);
            y3.m(r100.dataCenter).a(ToolbarButton.INTERACTION_AUDIENCE, r113);
            y3.m(r100.dataCenter).a(ToolbarButton.INTERACTION_ROOM, r113);
            IMicRoomService r114 = (IMicRoomService) k.f(IMicRoomService.class);
            if (r114 == null) goto L16;
            r114.setAnchorDisable(true);
        L7:
            r104 = 300;
            goto L9
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f153744a = null;

        static {
            f153744a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    static {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        this.f153736a.clear();
        IMicRoomService r100 = (IMicRoomService) k.f(IMicRoomService.class);
        if (r100 == null) goto L5;
        r100.setAnchorDisable(false);
    L5:
        IMicRoomService r101 = (IMicRoomService) k.f(IMicRoomService.class);
        if (r101 == null) goto L8;
        r101.setAnchorMicRoomStatus(0);
    L8:
        vlc.d r102 = this.f153737b;
        if (r102 == null) goto L12;
        r102.removeMessageListener(this);
        return;
    }

    public MicRoomAnchorTimeControlWidget() {
        this.f153736a = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        IMicRoomService r101 = (IMicRoomService) k.f(IMicRoomService.class);
        if (r101 == null) goto L5;
        r101.setAnchorDisable(false);
    L5:
        this.f153737b = (vlc.d) this.dataCenter.get("data_message_manager", null);
        this.f153739d = (Room) this.dataCenter.get("data_room", null);
        vlc.d r102 = this.f153737b;
        if (r102 == null) goto L8;
        r102.addMessageListener(MessageType.OFFICIAL_CHANNEL_FOR_ANCHOR_MESSAGE.getIntType(), this);
    L8:
        vlc.d r103 = this.f153737b;
        if (r103 == null) goto L11;
        r103.addMessageListener(MessageType.OFFICIAL_CHANNEL_MODIFY_MESSAGE.getIntType(), this);
    L11:
        this.f153738c = false;
        Room r104 = this.f153739d;
        if (r104 == null) goto L17;
        OfficialChannelInfo r105 = r104.officialChannelInfo;
        if (r105 == null) goto L18;
        yq(r105.getEndTimeStamp());
        return;
    L18:
        return;
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r110) {
        tlc.d r100 = null;
        String r101 = null;
        if (r110 == null) goto L5;
        Integer r102 = Integer.valueOf(r110.getIntType());
    L6:
        int r103 = MessageType.OFFICIAL_CHANNEL_FOR_ANCHOR_MESSAGE.getIntType();
        if (r102 != null) goto L10;
    L43:
        int r104 = MessageType.OFFICIAL_CHANNEL_MODIFY_MESSAGE.getIntType();
        if (r102 != null) goto L47;
        return;
    L47:
        if (r102.intValue() == r104) goto L49;
        return;
    L49:
        if ((r110 instanceof tg) == false) goto L53;
        r100 = r110;
    L53:
        if (((tg) r100) == null) goto L66;
        StringBuilder r105 = new StringBuilder("mic room: on modify message. start time = ");
        tg r111 = (tg) r110;
        r105.append(r111.G());
        r105.append(", end time = ");
        r105.append(Long.valueOf(r111.getEndTimeStamp()).longValue());
        ALogger.d("MicRoomAnchorTimeControlWidget", r105.toString());
        Disposable r106 = this.f153741f;
        if (r106 == null) goto L57;
        r106.dispose();
    L57:
        this.dataCenter.put("cmd_mic_room_channel_user_id", r111.E());
        if ((e.a() / ((long) 1000)) < r111.getEndTimeStamp()) goto L60;
        wq(0);
    L61:
        r.b("OChannelModifyMessage -start time = " + r111.G() + ", end time = " + r111.getEndTimeStamp());
        return;
    L60:
        yq(r111.getEndTimeStamp());
        goto L61
    L66:
        return;
    L10:
        if (r102.intValue() != r103) goto L43;
        if ((r110 instanceof vg) == true) goto L14;
        tlc.d r107 = null;
    L16:
        if (((vg) r107) == null) goto L63;
        StringBuilder r108 = new StringBuilder("mic room: on anchor message. start time = ");
        vg r112 = (vg) r110;
        r108.append(r112.E());
        r108.append(", officialid = ");
        IBaseUser r109 = r112.getChannelUser();
        if (r109 == null) goto L20;
        r101 = r109.getIdString();
    L20:
        r108.append(r101);
        ALogger.d("MicRoomAnchorTimeControlWidget", r108.toString());
        this.f153736a.clear();
        ILinkServiceExternal r113 = (ILinkServiceExternal) k.f(ILinkServiceExternal.class);
        if (r113 == null) goto L23;
        r113.updateMicRoomAnchorStatus(1);
    L23:
        this.dataCenter.put("cmd_mic_room_anchor_status", 1);
        DataCenter r114 = this.dataCenter;
        IBaseUser r115 = r112.getChannelUser();
        if (r115 == null) goto L27;
        String r116 = r115.getIdString();
        if (r116 == null) goto L27;
    L28:
        r114.put("cmd_mic_room_channel_user_id", r116);
        DataCenter r117 = this.dataCenter;
        IBaseUser r118 = r112.getChannelUser();
        if (r118 == null) goto L31;
        long r119 = r118.getLiveRoomId();
    L32:
        r117.put("cmd_mic_room_channel_room_id", Long.valueOf(r119));
        IMicRoomService r120 = (IMicRoomService) k.f(IMicRoomService.class);
        if (r120 == null) goto L35;
        r120.setAnchorMicRoomStatus(1);
    L35:
        String r121 = s1.B(R.string.ttlive_mic_room_prepare_status);
        y3.m(this.dataCenter).a(ToolbarButton.PK, r121);
        y3.m(this.dataCenter).a(ToolbarButton.INTERACTION, r121);
        y3.m(this.dataCenter).a(ToolbarButton.INTERACTION_AUDIENCE, r121);
        y3.m(this.dataCenter).a(ToolbarButton.INTERACTION_ROOM, r121);
        y3.f(this.dataCenter).a(ToolbarButton.KTV, r121);
        y3.f(this.dataCenter).a(ToolbarButton.VOTE, r121);
        ik r122 = ag1.c.b(s1.B(R.string.ttlive_mic_room_official_room_prepare));
        vlc.d r123 = this.f153737b;
        if (r123 == null) goto L38;
        r123.j(r122, true);
    L38:
        long r124 = r112.E() - (e.a() / ((long) 1000));
        if (r124 > 0) goto L41;
        xq(r112);
    L42:
        r.b("OfficialChannelForAnchorMessage -start time = " + r112.E() + ", end time = " + r112.getEndTimeStamp());
        return;
    L41:
        Disposable r125 = Observable.timer(r124, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new p(this, r112), q.f533861a);
        this.f153736a.add(r125);
        this.f153740e = r125;
        goto L42
    L31:
        r119 = 0;
    L27:
        r116 = "0";
        goto L28
    L63:
        return;
    L14:
        r107 = r110;
        goto L16
    L5:
        r102 = null;
        goto L6
    }

    public final void wq(long r100) {
        if (r100 <= 1) goto L5;
        return;
    L5:
        this.f153738c = false;
        y3.f(this.dataCenter).o(ToolbarButton.VOTE);
        y3.f(this.dataCenter).o(ToolbarButton.LOTTERY);
        y3.m(this.dataCenter).o(ToolbarButton.PK);
        y3.m(this.dataCenter).o(ToolbarButton.INTERACTION);
        y3.m(this.dataCenter).o(ToolbarButton.INTERACTION_AUDIENCE);
        y3.m(this.dataCenter).o(ToolbarButton.INTERACTION_ROOM);
        IMicRoomService r101 = (IMicRoomService) k.f(IMicRoomService.class);
        if (r101 == null) goto L8;
        r101.setAnchorDisable(false);
    L8:
        ILinkServiceExternal r102 = (ILinkServiceExternal) k.f(ILinkServiceExternal.class);
        if (r102 == null) goto L11;
        r102.updateMicRoomAnchorStatus(3);
    L11:
        this.dataCenter.put("cmd_mic_room_anchor_status", 3);
        IMicRoomService r103 = (IMicRoomService) k.f(IMicRoomService.class);
        if (r103 == null) goto L15;
        r103.setAnchorMicRoomStatus(3);
        return;
    }

    public final void xq(vg r100) {
        ILinkServiceExternal r101 = (ILinkServiceExternal) k.f(ILinkServiceExternal.class);
        if (r101 == null) goto L5;
        r101.updateMicRoomAnchorStatus(2);
    L5:
        this.dataCenter.put("cmd_mic_room_anchor_status", 2);
        IMicRoomService r102 = (IMicRoomService) k.f(IMicRoomService.class);
        if (r102 == null) goto L8;
        r102.setAnchorMicRoomStatus(2);
    L8:
        yq(r100.getEndTimeStamp());
        y3.m(this.dataCenter).o(ToolbarButton.PK);
        y3.m(this.dataCenter).o(ToolbarButton.INTERACTION);
        y3.m(this.dataCenter).o(ToolbarButton.INTERACTION_AUDIENCE);
        y3.m(this.dataCenter).o(ToolbarButton.INTERACTION_ROOM);
        y3.f(this.dataCenter).o(ToolbarButton.KTV);
        y3.f(this.dataCenter).o(ToolbarButton.VOTE);
    }

    public final void yq(long r100) {
        long r101 = r100 - (e.a() / ((long) 1000));
        if (r101 > 0) goto L5;
        return;
    L5:
        this.dataCenter.put("mic_room_widget_show", Boolean.FALSE);
        this.dataCenter.put("mic_room_widget_entry_show", Boolean.TRUE);
        j.a r102 = j.f66356a;
        Disposable r103 = ((ObservableSubscribeProxy) j.c(1, TimeUnit.SECONDS).take(1 + r101).map(new b(r101)).observeOn(AndroidSchedulers.mainThread()).as(autoDispose())).subscribe(new c(this), d.f153744a);
        this.f153736a.add(r103);
        this.f153741f = r103;
    }
}
