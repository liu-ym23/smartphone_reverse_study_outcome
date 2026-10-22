package com.bytedance.android.livesdk.floatview.inner;

import android.content.Context;
import android.content.res.Configuration;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.n0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.platformplayer.effect.VrEffectDownloader;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.message.model.ControlMessage;
import com.bytedance.android.livesdk.message.model.MemberMessage;
import com.bytedance.android.livesdk.utils.a6;
import com.bytedance.android.livesdk.utils.l3;
import com.bytedance.android.livesdk.utils.r5;
import com.bytedance.android.livesdk.utils.w5;
import com.bytedance.android.livesdk.utils.z4;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.message.PaidLiveTypeModifyData;
import com.bytedance.android.livesdkapi.depend.message.WebcastPaidLiveTypeModifyMessage;
import com.bytedance.android.livesdkapi.depend.message.wrds.IPreviewSyncDataType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PrivilegeInfo;
import com.bytedance.android.livesdkapi.floatview.InnerFloatViewTAG;
import com.bytedance.android.livesdkapi.message.OnWRDSDataUpdateListener;
import com.bytedance.android.livesdkapi.model.InnerContextEntity;
import com.bytedance.android.livesdkapi.model.LiveFloatWindowStatus;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.config.setting.LiveVr6DofEffectConfig;
import com.bytedance.android.livesdkapi.player.LivePlayerStreamTypeUtils;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.android.livesdkapi.resolution.IResolutionService;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerConfig;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import com.bytedance.android.livesdkapi.roomplayer.VideoEffectInitConfigBuilder;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class k extends FrameLayout implements MessageHub, com.bytedance.android.livesdk.floatview.f, vlc.l, a6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f125193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f125194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RelativeLayout f125195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f125196d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FrameLayout f125197e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LivePlayerView f125198f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ILivePlayerClient f125199g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f125200h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HSImageView f125201i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f125202j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RelativeLayout f125203k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f125204l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f125205m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public RelativeLayout f125206n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public FrameLayout f125207o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f125208p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Room f125209q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f125210r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f125211s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public a6 f125212t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public com.ss.ugc.live.sdk.msg.d f125213u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public com.bytedance.android.livesdk.floatview.e f125214v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final com.bytedance.android.livesdk.floatview.mob.b f125215w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Disposable f125216x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final n f125217y;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebcastPaidLiveTypeModifyMessage f125218a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k f125219b;

        public b(WebcastPaidLiveTypeModifyMessage r100, k r101) {
            this.f125218a = r100;
            this.f125219b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.livesdk.floatview.e r100 = this.f125219b.f125214v;     // Catch: Throwable -> L13
            if (r100 == null) goto L5;
            r100.b();     // Catch: Throwable -> L13
        L5:
            PaidLiveTypeModifyData r101 = this.f125218a.paidLiveModifyData;     // Catch: Throwable -> L13
            if (r101 == null) goto L16;
            PrivilegeInfo r102 = r101.data;     // Catch: Throwable -> L13
            if (r102 != null) goto L10;
            return;
        L10:
            if (r102.paidLiveType != 101) goto L21;
            f2.b(R.string.ttlive_toast_room_change_to_subscribe_room, 0);     // Catch: Throwable -> L13
            return;
        L21:
            return;
        L16:
            return;
        L13:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L22;
            throw th;
        }
    }

    static {
    }

    public k() {
        throw null;
    }

    @Override // com.bytedance.android.livesdkapi.service.MessageHub
    public final void addWRDSListener(IPreviewSyncDataType r100, OnWRDSDataUpdateListener r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "listener");
    }

    @Override // com.bytedance.android.livesdk.floatview.f
    public final void e() {
        this.f125211s = true;
        LivePlayerView r100 = this.f125198f;
        if (r100 == null) goto L6;
        r100.stop();
        return;
    }

    @Override // com.bytedance.android.livesdk.floatview.f
    public final void g() {
        this.f125211s = false;
        Room r100 = this.f125209q;
        if (r100 == null) goto L8;
        LivePlayerView r101 = this.f125198f;
        if (r101 == null) goto L9;
        r101.start(l(r100));
        return;
    L9:
        return;
    }

    public /* bridge */ /* synthetic */ InnerContextEntity getContainContext() {
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.service.MessageHub
    public final <T extends tlc.d> T getLatestWRDSMessage(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "messageMethod");
        return null;
    }

    public /* bridge */ /* synthetic */ FrameLayout getVideoContainer() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.utils.a6.b
    public final void onScreenOff() {
    }

    @Override // com.bytedance.android.livesdk.utils.a6.b
    public final void onScreenOn() {
    }

    @Override // com.bytedance.android.livesdkapi.service.MessageHub
    public final void removeWRDSListener(IPreviewSyncDataType r100, OnWRDSDataUpdateListener r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "listener");
    }

    public void setContainContext(InnerContextEntity r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.android.livesdk.floatview.f
    public final void onPause() {
        com.bytedance.android.livesdk.floatview.mob.b r100 = this.f125215w;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f125242a == (-1)) goto L10;
        r100.f125244c = SystemClock.elapsedRealtime();
        return;
    }

    @Override // com.bytedance.android.livesdk.floatview.f
    public final void onResume() {
        com.bytedance.android.livesdk.floatview.mob.b r100 = this.f125215w;
        if (r100 == null) goto L6;
        r100.n();
        return;
    }

    @Override // com.bytedance.android.livesdk.floatview.f
    public final void onStart() {
        com.bytedance.android.livesdk.floatview.mob.b r100 = this.f125215w;
        if (r100 == null) goto L6;
        r100.f125242a = SystemClock.elapsedRealtime();
        return;
    }

    public final void p() {
        LivePlayerView r100 = this.f125198f;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.release();
        ILivePlayerScene r101 = null;
        setMLivePlayerView(null);
        this.f125199g = null;
        ALogger.i("VideoWatchingInnerFloatWindowView", "release player");
        Room r102 = this.f125209q;
        if (r102 == null) goto L18;
        RoomContext r103 = RoomContext.a.c(RoomContext.Companion, null, r102.getRoomId(), 1);
        if (r103 == null) goto L19;
        com.bytedance.live.datacontext.m<LiveFloatWindowStatus> r104 = r103.getFloatWindowStatus();
        if (r104 == null) goto L20;
        LiveFloatWindowStatus r105 = new LiveFloatWindowStatus();
        r105.setShow(false);
        LivePlayerView r106 = this.f125198f;
        if (r106 == null) goto L16;
        LivePlayerConfig r107 = r106.getConfig();
        if (r107 == null) goto L16;
        r101 = r107.getScene();
    L16:
        r105.setScene(r101);
        Unit r108 = Unit.INSTANCE;
        r104.setValue(r105);
        return;
    L20:
        return;
    L19:
        return;
    }

    public final void q() {
        com.bytedance.android.livesdk.floatview.mob.b r100 = this.f125215w;
        if (r100 == null) goto L5;
        Room r101 = this.f125209q;
        int r102 = com.bytedance.android.livesdk.floatview.mob.b.f125241o;
        r100.g(r101, null);
    L5:
        HSImageView r103 = this.f125201i;
        if (r103 == null) goto L8;
        r103.setVisibility(0);
    L8:
        View r104 = this.f125202j;
        if (r104 == null) goto L11;
        r104.setVisibility(0);
    L11:
        RelativeLayout r105 = this.f125203k;
        if (r105 == null) goto L14;
        r105.setVisibility(0);
    L14:
        LivePlayerView r106 = this.f125198f;
        if (r106 == null) goto L17;
        r106.release();
    L17:
        this.f125216x = du2.a.b(0, 1, TimeUnit.SECONDS).take(6).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new l(this));
    }

    @Override // com.bytedance.android.livesdk.floatview.f
    public final void stop() {
        ALogger.i("VideoWatchingInnerFloatWindowView", "ready to stop");
        com.bytedance.android.livesdk.floatview.mob.b r100 = this.f125215w;
        if (r100 == null) goto L5;
        Room r101 = this.f125209q;
        int r102 = com.bytedance.android.livesdk.floatview.mob.b.f125241o;
        r100.f(r101, null);
    L5:
        reset();
        a6 r103 = this.f125212t;
        if (r103 == null) goto L8;
        r103.a();
    L8:
        this.f125212t = null;
    }

    private final View getRootLayout() {
        return LayoutInflater.from(getContext()).inflate(R.layout.ttlive_common_inner_float_window_view, this);
    }

    @Override // com.bytedance.android.livesdk.utils.a6.b
    public final void onUserPresent() {
        if (getVisibility() != 0) goto L12;
        LivePlayerView r100 = this.f125198f;
        if (r100 == null) goto L13;
        ILivePlayerClient r101 = r100.getClient();
        if (r101 != null) goto L9;
        return;
    L9:
        if (r101.isPlaying() == true) goto L15;
        g();
        return;
    L15:
        return;
    L13:
        return;
    }

    @Override // com.bytedance.android.livesdk.floatview.f
    public final void reset() {
        p();
        this.f125209q = null;
        this.f125211s = false;
        com.bytedance.android.livesdk.floatview.mob.b r100 = this.f125215w;
        if (r100 == null) goto L5;
        r100.f125242a = -1;
        r100.f125243b = -1;
        r100.f125244c = -1;
        r100.f125245d = 0;
        r100.f125254m = null;
    L5:
        Disposable r101 = this.f125216x;
        if (r101 == null) goto L8;
        r101.dispose();
    L8:
        this.f125216x = null;
        com.ss.ugc.live.sdk.msg.d r102 = this.f125213u;
        if (r102 == null) goto L11;
        r102.removeMessageListener(this);
    L11:
        com.ss.ugc.live.sdk.msg.d r103 = this.f125213u;
        if (r103 == null) goto L14;
        r103.release();
    L14:
        this.f125213u = null;
        ALogger.i("VideoWatchingInnerFloatWindowView", "remove message listener");
    }

    public com.bytedance.android.livesdk.floatview.mob.b getFloatWindowLogger() {
        return this.f125215w;
    }

    public final LivePlayerView getMLivePlayerView() {
        return this.f125198f;
    }

    @Override // com.bytedance.android.livesdk.floatview.f
    public final boolean isPaused() {
        return this.f125211s;
    }

    public static final void i(k r100) {
        r100.getClass();
        Room r101 = ((IRoomService) jc1.k.n(IRoomService.class)).getCurrentRoomFromRoomContext();
        Long r102 = null;
        if (r101 == null) goto L5;
        Long r103 = Long.valueOf(r101.f162599id);
    L6:
        Room r104 = r100.f125209q;
        if (r104 == null) goto L10;
        r102 = Long.valueOf(r104.f162599id);
    L10:
        if (Intrinsics.areEqual(r103, r102) == false) goto L12;
        return;
    L12:
        if ((System.currentTimeMillis() - r100.f125200h) < 5000) goto L17;
        r100.f125200h = System.currentTimeMillis();
        w5.a();
        return;
    L17:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final LiveRequest l(Room r100) {
        IResolutionService r101 = (IResolutionService) jc1.k.f(IResolutionService.class);
        if (r101 == null) goto L8;
        PlayerResolution.PickResult r102 = r101.getWindowDefaultResolutionSdkKey(r100, "inner_float_window_resolution");
        if (r102 == null) goto L8;
        String r103 = r102.getResultSdkKey();
        if (r103 == null) goto L8;
    L9:
        LiveRequest r104 = new LiveRequest.Builder().streamData(r100.getMultiStreamData()).resolution(r103).streamType(LivePlayerStreamTypeUtils.INSTANCE.mapLiveModeToStreamType(r100.getStreamType())).preview(true).mute(true).build();
        ILivePlayerClient r105 = this.f125199g;
        Intrinsics.checkNotNullParameter(r104, "liveRequest");
        if (LiveVr6DofEffectConfig.INSTANCE.getDisable() == true) goto L20;
        if (r105 == null) goto L20;
        com.bytedance.android.live.platformplayer.service.a r106 = (com.bytedance.android.live.platformplayer.service.a) jc1.k.f(com.bytedance.android.live.platformplayer.service.a.class);
        if (r106 == null) goto L18;
        VrEffectDownloader r107 = r106.T0();
        if (r107 == null) goto L18;
        VideoEffectInitConfigBuilder r108 = r107.f(r105);
    L19:
        r104.setVrEffectConfigBuilder(r108);
    L18:
        r108 = null;
    L20:
        return r104;
    L8:
        r103 = r100.getMultiStreamDefaultQualitySdkKey();
        goto L9
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        com.bytedance.android.livesdk.floatview.e r101 = this.f125214v;
        if (r101 == null) goto L6;
        r101.onConfigurationChanged(r100);
        return;
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        boolean r101 = r100 instanceof ControlMessage;
        if (r101 == false) goto L11;
        if (r101 == true) goto L6;
        r100 = null;
    L6:
        ControlMessage r102 = (ControlMessage) r100;
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.getAction() != 3) goto L36;
        ALogger.i("VideoWatchingInnerFloatWindowView", "receive live end message");
        q();
        return;
    L36:
        return;
    L11:
        boolean r103 = r100 instanceof WebcastPaidLiveTypeModifyMessage;
        if (r103 == false) goto L25;
        if (r103 == true) goto L15;
        r100 = null;
    L15:
        WebcastPaidLiveTypeModifyMessage r104 = (WebcastPaidLiveTypeModifyMessage) r100;
        if (r104 == null) goto L38;
        PaidLiveTypeModifyData r105 = r104.paidLiveModifyData;
        if (r105 != null) goto L20;
    L21:
        if (r105 != null) goto L23;
        return;
    L23:
        if (r105.operatorType != 1) goto L40;
    L24:
        q();
        MainThreadPostUtils.b(new b(r104, this));
        return;
    L40:
        return;
    L20:
        if (r105.operatorType == 2) goto L24;
    L38:
        return;
    L25:
        boolean r106 = r100 instanceof MemberMessage;
        if (r106 == false) goto L42;
        if (r106 == true) goto L29;
        r100 = null;
    L29:
        MemberMessage r107 = (MemberMessage) r100;
        if (r107 != null) goto L32;
        return;
    L32:
        if (r107.getAction() != 11) goto L44;
        ALogger.i("VideoWatchingInnerFloatWindowView", "receive kick out message");
        q();
        return;
    L44:
        return;
    }

    public void setFloatViewListener(com.bytedance.android.livesdk.floatview.e r100) {
        this.f125214v = r100;
    }

    public final void setMLivePlayerView(LivePlayerView r100) {
        this.f125198f = r100;
    }

    @Override // com.bytedance.android.livesdkapi.service.MessageHub
    public final void addMessageListener(String r100, vlc.l r101) {
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r101, "listener");
        com.ss.ugc.live.sdk.msg.d r102 = this.f125213u;
        if (r102 == null) goto L6;
        r102.addMessageListener(r100, r101);
        return;
    }

    @Override // com.bytedance.android.livesdk.floatview.f
    public final void h(final Room r110, boolean r111) {
        if (IRoom.Companion.isValid(r110) == true) goto L6;
        ALogger.i("VideoWatchingInnerFloatWindowView", "room is not valid, return");
        return;
    L6:
        if (r110 != null) goto L8;
        return;
    L8:
        Room r100 = this.f125209q;
        if (r100 != null) goto L11;
    L13:
        ALogger.i("VideoWatchingInnerFloatWindowView", "ready to start");
        this.f125211s = false;
        Context r101 = s1.getContext();
        long r102 = r110.f162599id;
        boolean r112 = r110.isMediaRoom();
        boolean r113 = r110.isMergeVSRoom();
        String r103 = r110.getOwnerUserIdString();
        n0.d();
        com.ss.ugc.live.sdk.msg.d r104 = z4.a(r101, new r5(r102, r103, false, r112, r113, "", null, false));
        this.f125213u = r104;
        r104.addMessageListener(MessageType.CONTROL.getIntType(), this);
        com.ss.ugc.live.sdk.msg.d r105 = this.f125213u;
        if (r105 == null) goto L16;
        r105.addMessageListener(MessageType.PAID_LIVE_TYPE_MODIFY_MESSAGE.getIntType(), this);
    L16:
        com.ss.ugc.live.sdk.msg.d r106 = this.f125213u;
        if (r106 == null) goto L19;
        r106.addMessageListener(MessageType.MEMBER.getIntType(), this);
    L19:
        com.ss.ugc.live.sdk.msg.d r107 = this.f125213u;
        if (r107 == null) goto L22;
        r107.startMessage();
    L22:
        ALogger.i("VideoWatchingInnerFloatWindowView", "add message listener");
        if (this.f125212t != null) goto L25;
        a6 r108 = new a6(getContext());
        this.f125212t = r108;
        r108.b(this);
    L25:
        this.f125209q = r110;
        this.f125210r = r111;
        p();
        FrameLayout r109 = this.f125196d;
        ILivePlayerScene r114 = null;
        if (r109 == null) goto L71;
        Context r115 = getContext();
        LivePlayerView r116 = this.f125198f;
        if (r116 == null) goto L35;
        r116.setVisibility(8);
        ViewParent r117 = r116.getParent();
        if ((r117 instanceof ViewGroup) == true) goto L32;
        r117 = null;
    L32:
        ViewGroup r118 = (ViewGroup) r117;
        if (r118 == null) goto L35;
        r118.removeView(r116);
    L35:
        LivePlayerConfig.Companion r119 = LivePlayerConfig.Companion;
        com.bytedance.android.livesdk.floatview.f.N0.getClass();
        setMLivePlayerView(new LivePlayerView(r115, r119.buildWith(com.bytedance.android.livesdk.floatview.f.a.f125140c, r110.getIdStr())));
        ALogger.i("VideoWatchingInnerFloatWindowView", "create new LivePlayerView");
        LivePlayerView r120 = this.f125198f;
        if (r120 == null) goto L38;
        ILivePlayerClient r121 = r120.getClient();
    L39:
        this.f125199g = r121;
        FrameLayout.LayoutParams r122 = new FrameLayout.LayoutParams(-1, -1);
        r122.gravity = 17;
        LivePlayerView r123 = this.f125198f;
        if (r123 == null) goto L42;
        r123.setLayoutParams(r122);
    L42:
        LivePlayerView r124 = this.f125198f;
        if (r124 == null) goto L47;
        IRenderView r125 = r124.getRenderView();
        if (r125 == null) goto L47;
        r125.setLayoutParams(r122);
    L47:
        LivePlayerView r126 = this.f125198f;
        if (r126 == null) goto L50;
        r126.setVisibility(0);
    L50:
        LivePlayerView r127 = this.f125198f;
        if (r127 == null) goto L54;
        r127.setScaleType(2);
    L54:
        if (r109.indexOfChild(this.f125198f) >= 0) goto L67;
        LivePlayerView r128 = this.f125198f;
        if (r128 == null) goto L63;
        r128.setVisibility(8);
        ViewParent r129 = r128.getParent();
        if ((r129 instanceof ViewGroup) == true) goto L60;
        r129 = null;
    L60:
        ViewGroup r130 = (ViewGroup) r129;
        if (r130 == null) goto L63;
        r130.removeView(r128);
    L63:
        LivePlayerView r131 = this.f125198f;
        if (r131 == null) goto L66;
        r131.setVisibility(0);
    L66:
        r109.addView(this.f125198f);
    L67:
        LiveRequest r132 = l(r110);
        ILivePlayerClient r133 = this.f125199g;
        if (r133 == null) goto L70;
        r133.stream(r132, new VideoWatchingInnerFloatWindowView$startPlayer$$inlined$let$lambda$1(this, r110));
    L70:
        ALogger.i("VideoWatchingInnerFloatWindowView", "start player");
        goto L71
    L38:
        r121 = null;
    L71:
        float r134 = UIUtils.getScreenWidth(getContext()) / UIUtils.getScreenHeight(getContext());
        User r135 = r110.mo8271getOwner();
        if (r135 == null) goto L76;
        ImageModel r136 = r135.getAvatarThumb();
        if (r136 == null) goto L76;
        List<String> r137 = r136.getUrls();
    L78:
        if (Lists.notEmpty(r137) == false) goto L80;
        ImageLoader.bindImage(this.f125201i, new ImageModel(null, r137), new l3(2, r134, null));
    L81:
        Room r138 = this.f125209q;
        if (r138 == null) goto L94;
        RoomContext r139 = RoomContext.a.c(RoomContext.Companion, null, r138.getRoomId(), 1);
        if (r139 == null) goto L95;
        com.bytedance.live.datacontext.m<LiveFloatWindowStatus> r140 = r139.getFloatWindowStatus();
        if (r140 == null) goto L96;
        LiveFloatWindowStatus r141 = new LiveFloatWindowStatus();
        r141.setShow(true);
        LivePlayerView r142 = this.f125198f;
        if (r142 == null) goto L92;
        LivePlayerConfig r143 = r142.getConfig();
        if (r143 == null) goto L92;
        r114 = r143.getScene();
    L92:
        r141.setScene(r114);
        Unit r144 = Unit.INSTANCE;
        r140.setValue(r141);
        return;
    L96:
        return;
    L95:
        return;
    L94:
        return;
    L80:
        ImageLoader.bindImage(this.f125201i, "res://" + getContext().getPackageName() + "/2131251156", new l3(5, r134, null));
    L76:
        r137 = null;
        goto L78
    L11:
        if (r100.f162599id != r110.f162599id) goto L13;
    }

    @Override // com.bytedance.android.livesdkapi.service.MessageHub
    public final void removeMessageListener(String r100, vlc.l r101) {
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r101, "listener");
        com.ss.ugc.live.sdk.msg.d r102 = this.f125213u;
        if (r102 == null) goto L6;
        r102.removeMessageListener(r100, r101);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.service.MessageHub
    public final void addMessageListener(int r100, vlc.l r101) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        com.ss.ugc.live.sdk.msg.d r102 = this.f125213u;
        if (r102 == null) goto L6;
        r102.addMessageListener(r100, r101);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.service.MessageHub
    public final void removeMessageListener(int r100, vlc.l r101) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        com.ss.ugc.live.sdk.msg.d r102 = this.f125213u;
        if (r102 == null) goto L6;
        r102.removeMessageListener(r100, r101);
        return;
    }

    public k(Context r100, String r101, HashMap r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r102, "mobParams");
        Intrinsics.checkNotNullParameter("content", "initialPage");
        super(r100);
        new LinkedHashMap();
        this.f125208p = InnerFloatViewTAG.TAG_VIDEO_PREVIEW.getTag();
        this.f125217y = new n(this);
        this.f125208p = r101;
        View r103 = getRootLayout();
        this.f125193a = r103;
        if (r103 == null) goto L9;
        this.f125197e = (FrameLayout) r103.findViewById(R.id.float_edge);
        this.f125201i = (HSImageView) r103.findViewById(R.id.float_cover_container);
        this.f125202j = r103.findViewById(R.id.float_cover_mask);
        this.f125203k = (RelativeLayout) r103.findViewById(R.id.float_end_view_container);
        this.f125204l = (TextView) r103.findViewById(R.id.float_end_count_down);
        this.f125194b = (FrameLayout) r103.findViewById(R.id.float_container);
        this.f125196d = (FrameLayout) r103.findViewById(R.id.float_stream_container);
        this.f125195c = (RelativeLayout) r103.findViewById(R.id.float_close_container);
        this.f125205m = (TextView) r103.findViewById(R.id.lottery_wait_tip);
        this.f125206n = (RelativeLayout) r103.findViewById(R.id.lottery_draw_tip);
        this.f125207o = (FrameLayout) r103.findViewById(R.id.float_feed_view_container);
        RelativeLayout r104 = this.f125195c;
        if (r104 == null) goto L9;
        r104.setOnClickListener(new m(this));
    L9:
        if (Intrinsics.areEqual(r101, InnerFloatViewTAG.TAG_LOTTERY_PREVIEW.getTag()) == false) goto L11;
        String r105 = "lottery";
    L12:
        this.f125215w = new com.bytedance.android.livesdk.floatview.mob.b(1, "content", r105, r102);
        return;
    L11:
        r105 = "";
        goto L12
    }
}
