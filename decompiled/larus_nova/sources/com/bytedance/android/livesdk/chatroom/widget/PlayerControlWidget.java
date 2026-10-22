package com.bytedance.android.livesdk.chatroom.widget;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.progressbar.IProgressCastService;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.view.PlayPauseView;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeHighLight;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.livesdkapi.roomplayer.VrBgLogData;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/PlayerControlWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class PlayerControlWidget extends LiveRecyclableWidget {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f118598o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PlayPauseView f118599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LottieAnimationView f118600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IPlayerProgressService f118601c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PlayerProgressServiceContext f118602d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f118603e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f118604f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f118605g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f118606h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CompositeDisposable f118607i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public j0 f118608j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.progressbar.b f118609k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public IProgressCastService f118610l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.o f118611m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final d f118612n;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerControlWidget f118613a;

        public b(PlayerControlWidget r100) {
            this.f118613a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            MiddlewareRoomContext r101 = o3.b();
            if (r101 == null) goto L10;
            com.bytedance.live.datacontext.m<Boolean> r102 = r101.getVsInChorusConcert();
            if (r102 == null) goto L10;
            if (r102.getValue().booleanValue() != true) goto L10;
            com.bytedance.android.live.core.utils.f2.c("您已在合唱中，请保持最新进度", 0);
            return;
        L10:
            PlayerControlWidget r103 = this.f118613a;
            j0 r104 = r103.f118608j;
            if (r104 != null) goto L13;
        L15:
            PlayerControlWidget.Aq(this.f118613a);
            PlayerControlWidget r105 = this.f118613a;
            j0 r106 = r105.f118608j;
            if (r106 == null) goto L18;
            r106.j(r105.dataCenter);
        L18:
            PlayerControlWidget r107 = this.f118613a;
            IProgressCastService r108 = r107.f118610l;
            if (r108 == null) goto L37;
            com.bytedance.live.datacontext.m<Boolean> r109 = r108.castScreenMode(r107.dataCenter);
            if (r109 == null) goto L37;
            if (r109.getValue().booleanValue() != true) goto L37;
            if (PlayerControlWidget.yq(this.f118613a) == false) goto L34;
            IProgressCastService r110 = this.f118613a.f118610l;
            if (r110 == null) goto L29;
            r110.pause();
        L29:
            com.bytedance.android.livesdk.chatroom.progressbar.b r111 = this.f118613a.f118609k;
            if (r111 == null) goto L40;
            com.bytedance.live.datacontext.m<mf1.b> r112 = r111.c();
            if (r112 == null) goto L40;
            r112.setValue(new mf1.b(false, false));
        L40:
            com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_pause_play_icon_click", MapsKt.mapOf(TuplesKt.to("vs_pause_icon_status", "pause")), new Object[]{new am2.x(), IRoom.class});
            if (r3.l(this.f118613a.context) == false) goto L44;
            r3.q(this.f118613a.context, "已暂停");
            return;
        L44:
            return;
        L34:
            IProgressCastService r113 = this.f118613a.f118610l;
            if (r113 == null) goto L40;
            r113.pause();
        L37:
            ILivePlayerClient r114 = PlayerControlWidget.xq(this.f118613a);
            if (r114 == null) goto L40;
            r114.pause();
            goto L40
        L13:
            if (r104.e(r103.dataCenter) != true) goto L15;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerControlWidget f118614a;

        public c(PlayerControlWidget r100) {
            this.f118614a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            MiddlewareRoomContext r101 = o3.b();
            if (r101 == null) goto L10;
            com.bytedance.live.datacontext.m<Boolean> r102 = r101.getVsInChorusConcert();
            if (r102 == null) goto L10;
            if (r102.getValue().booleanValue() != true) goto L10;
            com.bytedance.android.live.core.utils.f2.c("您已在合唱中，请保持最新进度", 0);
            return;
        L10:
            PlayerControlWidget r103 = this.f118614a;
            j0 r104 = r103.f118608j;
            if (r104 != null) goto L13;
        L15:
            PlayerControlWidget.Bq(this.f118614a);
            PlayerControlWidget r105 = this.f118614a;
            j0 r106 = r105.f118608j;
            if (r106 == null) goto L18;
            r106.j(r105.dataCenter);
        L18:
            PlayerControlWidget r107 = this.f118614a;
            IProgressCastService r108 = r107.f118610l;
            if (r108 == null) goto L27;
            com.bytedance.live.datacontext.m<Boolean> r109 = r108.castScreenMode(r107.dataCenter);
            if (r109 == null) goto L27;
            if (r109.getValue().booleanValue() != true) goto L27;
            IProgressCastService r110 = this.f118614a.f118610l;
            if (r110 == null) goto L28;
            r110.resume();
        L28:
            com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_pause_play_icon_click", MapsKt.mapOf(TuplesKt.to("vs_pause_icon_status", "play")), new Object[]{new am2.x(), IRoom.class});
            if (r3.l(this.f118614a.context) == false) goto L32;
            r3.q(this.f118614a.context, "已继续播放");
            return;
        L32:
            return;
        L27:
            PlayerControlWidget.zq(this.f118614a);
            goto L28
        L13:
            if (r104.e(r103.dataCenter) != true) goto L15;
        }
    }

    public static final class d implements com.bytedance.android.livesdk.chatroom.vsplayer.api.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerControlWidget f118615a;

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void C5() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void D5() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void E5() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void G5(boolean r100) {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void H5() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void g5() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void onRenderStart() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void z() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void P1() {
            if (PlayerControlWidget.yq(this.f118615a) == false) goto L5;
            return;
        L5:
            PlayerProgressServiceContext r100 = this.f118615a.f118602d;
            if (r100 == null) goto L8;
            Boolean r101 = r100.isPlaying();
        L10:
            if (Intrinsics.areEqual(r101, Boolean.FALSE) == false) goto L13;
            PlayerControlWidget.Bq(this.f118615a);
            return;
        L13:
            return;
        L8:
            r101 = null;
            goto L10
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void k2() {
            PlayerProgressServiceContext r100 = this.f118615a.f118602d;
            if (r100 == null) goto L6;
            r100.setPlaying(Boolean.TRUE);
        L6:
            if (PlayerControlWidget.yq(this.f118615a) == false) goto L8;
            return;
        L8:
            PlayerControlWidget.wq(this.f118615a, true);
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void l3() {
            PlayerProgressServiceContext r100 = this.f118615a.f118602d;
            if (r100 == null) goto L6;
            r100.setPlaying(Boolean.FALSE);
        L6:
            if (PlayerControlWidget.yq(this.f118615a) == false) goto L8;
            return;
        L8:
            PlayerControlWidget.wq(this.f118615a, false);
        }

        public d(PlayerControlWidget r100) {
            this.f118615a = r100;
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void v2(EpisodeHighLight r100) {
            Intrinsics.checkNotNullParameter(r100, "episodeHighLight");
            Intrinsics.checkNotNullParameter(r100, "episodeHighLight");
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void F5(EpisodeHighLight r100, Pair<Integer, Boolean> r101) {
            Intrinsics.checkNotNullParameter(r100, "episodeHighLight");
            Intrinsics.checkNotNullParameter(r101, "pair");
            com.bytedance.android.livesdk.chatroom.vsplayer.api.d.a.a(r100, r101);
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void I5(EpisodeHighLight r100, Pair<Integer, Boolean> r101) {
            Intrinsics.checkNotNullParameter(r100, "episodeHighLight");
            Intrinsics.checkNotNullParameter(r101, "pair");
            com.bytedance.android.livesdk.chatroom.vsplayer.api.d.a.b(r100, r101);
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerControlWidget f118616a;

        public e(PlayerControlWidget r100) {
            this.f118616a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            PlayerControlWidget r101 = this.f118616a;
            boolean r102 = ((Boolean) r100).booleanValue();
            int r103 = PlayerControlWidget.f118598o;
            r101.Jq(r102, false);
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerControlWidget f118617a;

        public f(PlayerControlWidget r100) {
            this.f118617a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
            if (PlayerControlWidget.yq(this.f118617a) == false) goto L15;
            PlayerControlWidget r102 = this.f118617a;
            IProgressCastService r103 = r102.f118610l;
            if (r103 == null) goto L16;
            com.bytedance.live.datacontext.m<Boolean> r104 = r103.castScreenMode(r102.dataCenter);
            if (r104 != null) goto L9;
            return;
        L9:
            if (r104.getValue().booleanValue() == true) goto L11;
            return;
        L11:
            if (r101.booleanValue() == false) goto L13;
            this.f118617a.contentView.setVisibility(0);
            return;
        L13:
            this.f118617a.contentView.setVisibility(8);
            return;
        L16:
            return;
        }
    }

    static {
    }

    public abstract j0 Fq();

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_widget_play_control_layout;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    private final ILivePlayerClient Eq() {
        j0 r100 = this.f118608j;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getLivePlayerClient();
    }

    private final boolean Gq() {
        IProgressCastService r100 = this.f118610l;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isByteMatchCasting(this.dataCenter) != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public void onUnload() {
        int r100 = this.f118605g;
        com.bytedance.android.livesdk.chatroom.o r101 = this.f118611m;
        if (r101 == null) goto L10;
        com.bytedance.live.datacontext.m<Integer> r102 = r101.U1();
        if (r102 == null) goto L10;
        if (r100 != r102.getValue().intValue()) goto L10;
        boolean r103 = false;
    L11:
        this.f118606h = r103;
        IPlayerProgressService r104 = this.f118601c;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("progressService");
    L14:
        r104.removeProgressChangeListener(this.f118612n);
        this.f118607i.dispose();
        return;
    L10:
        r103 = true;
        goto L11
    }

    public PlayerControlWidget() {
        this.f118603e = 1;
        this.f118605g = 1;
        this.f118607i = new CompositeDisposable();
        this.f118612n = new d(this);
    }

    public final void Iq() {
        ILivePlayerClient r100 = Eq();
        if (r100 == null) goto L20;
        IRoomEventHub r101 = r100.getEventHub();
        if (r101 == null) goto L22;
        ILivePlayerClient r102 = Eq();
        if (r102 == null) goto L21;
        LifecycleOwner r103 = r102.getLifecycleOwner();
        if (r103 != null) goto L13;
        return;
    L13:
        if (Intrinsics.areEqual(r101.getPlaying().getValue(), Boolean.TRUE) == false) goto L18;
        IPlayerProgressService r104 = this.f118601c;
        if (r104 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("progressService");
    L17:
        r104.handleProgressListener(PlayerControlWidget$registerPlayerEvent$1.INSTANCE);
    L18:
        r101.getPlaying().observe(r103, new n1(this));
        r101.getStopped().observe(r103, new o1(this));
        r101.getPlayResume().observe(r103, new p1(this));
        return;
    L21:
        return;
    L22:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public void onResume() {
        super.onResume();
        if (this.f118604f == true) goto L10;
        com.bytedance.android.livesdk.chatroom.o r100 = this.f118611m;
        if (r100 == null) goto L11;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.l> r101 = r100.a2();
        if (r101 == null) goto L12;
        r101.c(new PlayerControlWidget$logShow$1(this));
        return;
    L12:
        return;
    L11:
        return;
    }

    public static final void Aq(PlayerControlWidget r100) {
        PlayPauseView r101 = r100.f118599a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L5:
        r101.d();
    }

    public static final void Bq(PlayerControlWidget r100) {
        PlayPauseView r101 = r100.f118599a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L5:
        r101.e();
    }

    private final void Cq(boolean r100) {
        this.f118603e--;
        if (r100 == false) goto L32;
        PlayPauseView r101 = this.f118599a;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L7:
        r3.c(r101, "暂停", true);
        PlayPauseView r102 = this.f118599a;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L10:
        r102.setOnClickListener(new b(this));
        if (Gq() == false) goto L21;
        PlayPauseView r103 = this.f118599a;
        if (r103 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L16:
        if (r103.getPlayStatus() == true) goto L61;
        PlayPauseView r104 = this.f118599a;
        if (r104 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L20:
        r104.e();
        return;
    L61:
        return;
    L21:
        PlayPauseView r105 = this.f118599a;
        if (r105 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L25:
        if (r105.getPlayStatus() == false) goto L27;
        return;
    L27:
        if (this.f118603e >= 0) goto L64;
        PlayPauseView r106 = this.f118599a;
        if (r106 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L31:
        r106.e();
        return;
    L64:
        return;
    L32:
        PlayPauseView r107 = this.f118599a;
        if (r107 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L35:
        r3.c(r107, "播放", true);
        PlayPauseView r108 = this.f118599a;
        if (r108 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L38:
        r108.setOnClickListener(new c(this));
        if (Gq() == false) goto L49;
        PlayPauseView r109 = this.f118599a;
        if (r109 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L44:
        if (r109.getPlayStatus() != true) goto L66;
        PlayPauseView r110 = this.f118599a;
        if (r110 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L48:
        r110.d();
        return;
    L66:
        return;
    L49:
        PlayPauseView r111 = this.f118599a;
        if (r111 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L53:
        if (r111.getPlayStatus() == true) goto L55;
        return;
    L55:
        if (this.f118603e >= 0) goto L69;
        PlayPauseView r112 = this.f118599a;
        if (r112 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L59:
        r112.d();
        return;
    }

    public static final /* synthetic */ ILivePlayerClient xq(PlayerControlWidget r100) {
        return r100.Eq();
    }

    public static final /* synthetic */ boolean yq(PlayerControlWidget r100) {
        return r100.Gq();
    }

    public static final void zq(PlayerControlWidget r110) {
        PlayerProgressServiceContext r100 = r110.f118602d;
        if (r100 == null) goto L5;
        long r101 = (r100.getTotalTime().getValue().longValue() - r100.getCurrentTime().getValue().longValue()) / ((long) 1000);
    L6:
        j0 r102 = r110.f118608j;
        if (r102 != null) goto L9;
    L38:
        ILivePlayerClient r103 = r110.Eq();
        if (r103 != null) goto L41;
    L45:
        ILivePlayerClient r111 = r110.Eq();
        if (r111 == null) goto L55;
        r111.resume();
        return;
    L55:
        return;
    L41:
        if (r103.getBufferFull() != true) goto L45;
        ILivePlayerClient r112 = r110.Eq();
        if (r112 == null) goto L53;
        r112.seekBy((int) r101);
        return;
    L53:
        return;
    L9:
        if (r102.d(r110.dataCenter) != true) goto L38;
        j0 r104 = r110.f118608j;
        if (r104 == null) goto L31;
        String r105 = r104.c(r110.dataCenter);
        if (r105 == null) goto L31;
        j0 r106 = r110.f118608j;
        Long r107 = null;
        if (r106 == null) goto L17;
        NextLiveData<Boolean> r108 = r106.i(r110.dataCenter);
    L18:
        j0 r109 = r110.f118608j;
        if (r109 == null) goto L31;
        ILivePlayerClient r113 = r110.Eq();
        Pair[] r114 = new Pair[4];
        String r115 = "0";
        r114[0] = TuplesKt.to(VrBgLogData.KEY_IS_PREVIEW, "0");
        r114[1] = TuplesKt.to("reason", "click_play_button");
        j0 r116 = r110.f118608j;
        if (r116 != null) goto L23;
    L25:
        r114[2] = TuplesKt.to("view_right", r115);
        com.bytedance.android.livesdk.chatroom.o r117 = r110.f118611m;
        if (r117 == null) goto L30;
        com.bytedance.live.datacontext.m<Long> r118 = r117.getCameraId();
        if (r118 == null) goto L30;
        r107 = r118.getValue();
    L30:
        r114[3] = TuplesKt.to("current_camera_id", String.valueOf(r107));
        r109.a(r113, r105, r108, MapsKt.mutableMapOf(r114), null);
        goto L31
    L23:
        if (r116.g(r110.dataCenter) != true) goto L25;
        r115 = "1";
        goto L25
    L17:
        r108 = null;
    L31:
        ILivePlayerClient r119 = r110.Eq();
        if (r119 != null) goto L34;
        return;
    L34:
        if (r119.getBufferFull() != true) goto L50;
        ILivePlayerClient r120 = r110.Eq();
        if (r120 == null) goto L51;
        r120.seekBy((int) r101);
        return;
    L51:
        return;
    L50:
        return;
    L5:
        r101 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public void onLoad(Object[] r100) {
        this.f118607i = new CompositeDisposable();
        j0 r101 = Fq();
        this.f118608j = r101;
        Boolean r102 = null;
        if (r101 == null) goto L5;
        IProgressCastService r103 = r101.h();
    L6:
        this.f118610l = r103;
        if (r103 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.progressbar.b r104 = r103.getProgressCastStreamShiftService();
    L10:
        this.f118609k = r104;
        IRoomContextService r105 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        if (r105 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.o r106 = IRoomContextService.a.a(r105, null, 0, 3);
    L14:
        this.f118611m = r106;
        if (r106 == null) goto L21;
        com.bytedance.live.datacontext.m<Integer> r107 = r106.U1();
        if (r107 == null) goto L21;
        Integer r108 = r107.getValue();
        if (r108 == null) goto L21;
        int r109 = r108.intValue();
    L22:
        this.f118605g = r109;
        this.f118603e = 1;
        boolean r110 = false;
        this.f118604f = false;
        this.f118599a = (PlayPauseView) this.contentView.findViewById(R.id.live_iv_play);
        this.f118600b = (LottieAnimationView) this.contentView.findViewById(R.id.iv_landscape_block);
        if (isScreenPortrait() == false) goto L31;
        PlayPauseView r111 = this.f118599a;
        if (r111 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L27:
        com.bytedance.android.live.core.utils.a1.p(r111, UtilityKotlinExtentionsKt.i(36));
        PlayPauseView r112 = this.f118599a;
        if (r112 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L30:
        com.bytedance.android.live.core.utils.a1.k(r112, UtilityKotlinExtentionsKt.i(36));
    L38:
        PlayPauseView r113 = this.f118599a;
        if (r113 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L41:
        r113.a();
        rk1.a r114 = (rk1.a) jc1.k.f(rk1.a.class);
        if (r114 == null) goto L87;
        IPlayerProgressService r115 = r114.M4(this.dataCenter);
        if (r115 == null) goto L87;
        this.f118601c = r115;
        PlayerProgressServiceContext r116 = r115.provideContext(this.dataCenter);
        this.f118602d = r116;
        if (r116 == null) goto L55;
        ILivePlayerClient r117 = Eq();
        if (r117 != null) goto L51;
    L53:
        boolean r118 = false;
    L54:
        r116.setPlaying(Boolean.valueOf(r118));
        goto L55
    L51:
        if (r117.isPlaying() != true) goto L53;
        r118 = true;
    L55:
        PlayerProgressServiceContext r119 = this.f118602d;
        if (r119 == null) goto L59;
        r102 = r119.isPlaying();
    L59:
        if (Intrinsics.areEqual(r102, Boolean.FALSE) == false) goto L64;
        PlayPauseView r120 = this.f118599a;
        if (r120 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L63:
        r120.b();
        Cq(false);
    L65:
        IPlayerProgressService r121 = this.f118601c;
        if (r121 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("progressService");
    L68:
        r121.addProgressChangeListener(this.f118612n);
        j0 r122 = this.f118608j;
        if (r122 == null) goto L73;
        NextLiveData<Boolean> r123 = r122.f(this.dataCenter);
        if (r123 == null) goto L73;
        r123.observe(this, new k1(this), true);
    L73:
        j0 r124 = this.f118608j;
        if (r124 == null) goto L78;
        NextLiveData<Boolean> r125 = r124.i(this.dataCenter);
        if (r125 == null) goto L78;
        r125.observe(this, new l1(this), true);
    L78:
        PlayerProgressServiceContext r126 = this.f118602d;
        if (r126 == null) goto L87;
        com.bytedance.live.datacontext.k<Boolean> r127 = r126.getPlayOrPauseEvent();
        if (r127 == null) goto L87;
        PublishSubject r128 = r127.onEvent();
        if (r128 == null) goto L87;
        Disposable r129 = r128.subscribe(new m1(this));
        if (r129 == null) goto L87;
        RxUtilKt.c(r129, this.f118607i);
        goto L87
    L64:
        Cq(true);
    L87:
        IProgressCastService r130 = this.f118610l;
        if (r130 == null) goto L117;
        com.bytedance.live.datacontext.m<Boolean> r131 = r130.castScreenMode(this.dataCenter);
        if (r131 == null) goto L117;
        if (r131.getValue().booleanValue() != true) goto L117;
        if (Gq() == false) goto L116;
        com.bytedance.android.livesdk.chatroom.progressbar.b r132 = this.f118609k;
        if (r132 == null) goto L116;
        com.bytedance.live.datacontext.m<Boolean> r133 = r132.d();
        if (r133 == null) goto L116;
        if (r133.getValue().booleanValue() != true) goto L116;
        com.bytedance.android.livesdk.chatroom.progressbar.b r134 = this.f118609k;
        if (r134 == null) goto L111;
        com.bytedance.live.datacontext.m<Boolean> r135 = r134.b();
        if (r135 == null) goto L111;
        if (r135.getValue().booleanValue() != true) goto L111;
        PlayPauseView r136 = this.f118599a;
        if (r136 != null) goto L110;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L110:
        r136.a();
    L115:
        this.contentView.setVisibility(0);
    L118:
        IProgressCastService r137 = this.f118610l;
        if (r137 == null) goto L125;
        com.bytedance.live.datacontext.m<Boolean> r138 = r137.castScreenMode(this.dataCenter);
        if (r138 == null) goto L125;
        Boolean r139 = r138.getValue();
        if (r139 == null) goto L125;
        r110 = r139.booleanValue();
    L125:
        Jq(r110, true);
        IProgressCastService r140 = this.f118610l;
        if (r140 == null) goto L134;
        com.bytedance.live.datacontext.m<Boolean> r141 = r140.castScreenMode(this.dataCenter);
        if (r141 == null) goto L134;
        Observable<Boolean> r142 = r141.a();
        if (r142 == null) goto L134;
        Disposable r143 = r142.subscribe(new e(this));
        if (r143 == null) goto L134;
        RxUtilKt.c(r143, this.f118607i);
    L134:
        com.bytedance.android.livesdk.chatroom.progressbar.b r144 = this.f118609k;
        if (r144 == null) goto L143;
        com.bytedance.live.datacontext.m<Boolean> r145 = r144.d();
        if (r145 == null) goto L143;
        Observable<Boolean> r146 = r145.a();
        if (r146 == null) goto L143;
        Disposable r147 = r146.subscribe(new f(this));
        if (r147 == null) goto L143;
        RxUtilKt.c(r147, this.f118607i);
    L143:
        com.bytedance.android.livesdk.chatroom.progressbar.b r148 = this.f118609k;
        if (r148 == null) goto L151;
        com.bytedance.live.datacontext.m<Boolean> r149 = r148.b();
        if (r149 == null) goto L152;
        Disposable r150 = i80.a.a(r149, new AnonymousClass3(this));
        if (r150 == null) goto L153;
        RxUtilKt.c(r150, this.f118607i);
        return;
    L153:
        return;
    L152:
        return;
    L151:
        return;
    L111:
        PlayPauseView r151 = this.f118599a;
        if (r151 != null) goto L114;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L114:
        r151.b();
    L116:
        this.contentView.setVisibility(8);
    L117:
        this.contentView.setVisibility(0);
        goto L118
    L31:
        PlayPauseView r152 = this.f118599a;
        if (r152 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L34:
        com.bytedance.android.live.core.utils.a1.p(r152, UtilityKotlinExtentionsKt.i(40));
        PlayPauseView r153 = this.f118599a;
        if (r153 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L37:
        com.bytedance.android.live.core.utils.a1.k(r153, UtilityKotlinExtentionsKt.i(40));
    L21:
        r109 = 1;
        goto L22
    L13:
        r106 = null;
        goto L14
    L9:
        r104 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    public static final /* synthetic */ void wq(PlayerControlWidget r100, boolean r101) {
        r100.Cq(r101);
    }

    public final void Jq(boolean r100, boolean r101) {
        if (r100 == true) goto L5;
        this.contentView.setVisibility(0);
        if (r101 == true) goto L23;
        PlayPauseView r102 = this.f118599a;
        if (r102 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L19:
        r102.a();
        Cq(true);
        return;
    L23:
        return;
    L5:
        if (Gq() == false) goto L13;
        com.bytedance.android.livesdk.chatroom.progressbar.b r103 = this.f118609k;
        if (r103 == null) goto L13;
        com.bytedance.live.datacontext.m<Boolean> r104 = r103.d();
        if (r104 == null) goto L13;
        if (r104.getValue().booleanValue() != true) goto L13;
        this.contentView.setVisibility(0);
        return;
    L13:
        this.contentView.setVisibility(8);
    }
}
