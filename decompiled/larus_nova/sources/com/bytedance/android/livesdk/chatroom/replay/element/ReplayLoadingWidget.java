package com.bytedance.android.livesdk.chatroom.replay.element;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.livesdk.chatroom.replay.view.ReplayErrorView;
import com.bytedance.android.livesdk.chatroom.ui.VideoViewParams;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.ReplayConfigSettingKeys;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.ReplayRoomFragmentScopeUtil;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.vs_base.view.ReplayLoadingView;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSPlayerViewControlContext;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.vs.LiveBlurAnimView;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.videoshop.context.VideoContext;
import com.ss.ttvideoengine.utils.Error;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/element/ReplayLoadingWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayLoadingWidget extends LiveRecyclableWidget {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f108384k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ReplayLoadingView f108385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ReplayErrorView f108386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f108387c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.vs_base.base.util.g f108388d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g f108389e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f108390f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f108391g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Disposable f108392h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f108393i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.vs_base.session.video.h f108394j;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayLoadingWidget f108395a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VideoContext f108396b;

        public b(ReplayLoadingWidget r100, VideoContext r101) {
            this.f108395a = r100;
            this.f108396b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Logger.d("VSLoading", "session.eventHub.showLoading");
            if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == true) goto L5;
            return;
        L5:
            if (this.f108396b.isPlaying() == true) goto L21;
            ReplayLoadingWidget r101 = this.f108395a;
            int r102 = ReplayLoadingWidget.f108384k;
            if (r101.Cq() == true) goto L9;
            return;
        L9:
            if (this.f108395a.f108394j.f118137k == true) goto L23;
            com.bytedance.live.datacontext.m<Boolean> r103 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.b().castScreenMode(this.f108395a.dataCenter);
            boolean r104 = true;
            if (r103 != null) goto L13;
        L14:
            StringBuilder r105 = new StringBuilder("session.eventHub.showLoading visibility = ");
            if (ReplayLoadingWidget.yq(this.f108395a).getVisibility() == 0) goto L18;
            r104 = false;
        L18:
            r105.append(r104);
            Logger.d("VSLoading", r105.toString());
            this.f108395a.Gq();
            ReplayLoadingWidget.yq(this.f108395a).post(new com.bytedance.android.livesdk.chatroom.replay.element.f(this));
            return;
        L13:
            if (r103.getValue().booleanValue() != true) goto L14;
            return;
        L23:
            return;
        }
    }

    public static final class c<T> implements androidx.lifecycle.Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayLoadingWidget f108397a;

        public c(ReplayLoadingWidget r100) {
            this.f108397a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            KVData r101 = (KVData) r100;
            ReplayLoadingWidget r102 = this.f108397a;
            int r103 = ReplayLoadingWidget.f108384k;
            r102.Fq();
        }
    }

    public static final class d<T> implements androidx.lifecycle.Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayLoadingWidget f108398a;

        public d(ReplayLoadingWidget r100) {
            this.f108398a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            KVData r101 = (KVData) r100;
            ALogger.d("ReplayLoading", "observer updateLoadingPosition");
            ReplayLoadingWidget r102 = this.f108398a;
            int r103 = ReplayLoadingWidget.f108384k;
            r102.Gq();
        }
    }

    public static final class e<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayLoadingWidget f108399a;

        public e(ReplayLoadingWidget r100) {
            this.f108399a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            ReplayLoadingWidget r102 = this.f108399a;
            int r103 = ReplayLoadingWidget.f108384k;
            r102.Bq();
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayLoadingWidget f108400a;

        public f(ReplayLoadingWidget r100) {
            this.f108400a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
            ReplayLoadingWidget r102 = this.f108400a;
            int r103 = ReplayLoadingWidget.f108384k;
            r102.Bq();
        }
    }

    public static final class g extends nic.l.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayLoadingWidget f108401a;

        public g(ReplayLoadingWidget r100) {
            this.f108401a = r100;
        }

        @Override // nic.l.a, nic.h
        public final void I(oic.f r100, tic.a r101) {
            ReplayLoadingWidget.xq(this.f108401a);
        }

        @Override // nic.l.a, nic.h
        public final void W(oic.f r100, tic.a r101) {
            ReplayLoadingWidget.xq(this.f108401a);
        }

        @Override // nic.l.a, nic.h
        public final void Y(oic.f r100, tic.a r101) {
            ReplayLoadingWidget.zq(this.f108401a);
            this.f108401a.f108390f.postDelayed(new com.bytedance.android.livesdk.chatroom.replay.element.g(this), 5000);
        }

        @Override // nic.l.a, nic.h
        public final void b(oic.f r100, tic.a r101) {
            UtilityKotlinExtentionsKt.i(ReplayLoadingWidget.yq(this.f108401a));
        }

        @Override // nic.l.a, nic.h
        public final void v(oic.f r100, tic.a r101, Error r102) {
            ReplayLoadingWidget.wq(this.f108401a);
        }

        @Override // nic.l.a, nic.h
        public final void w(oic.f r100, tic.a r101, long r102) {
            if (ReplayLoadingWidget.yq(this.f108401a).getVisibility() == 0) goto L5;
            ReplayLoadingWidget r103 = this.f108401a;
            r103.f108391g = System.currentTimeMillis();
        L5:
            ReplayLoadingWidget.zq(this.f108401a);
        }

        @Override // nic.l.a, nic.h
        public final void x(oic.f r100, tic.a r101, boolean r102) {
            Disposable r103 = this.f108401a.f108392h;
            if (r103 != null) goto L5;
        L10:
            long r104 = System.currentTimeMillis();
            ReplayLoadingWidget r105 = this.f108401a;
            long r106 = 500 - (r104 - r105.f108391g);
            if (r106 <= 0) goto L13;
            r105.f108392h = Observable.just(this).delay(r106, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.chatroom.replay.element.h(this), new com.bytedance.android.livesdk.chatroom.replay.element.i(this));
            return;
        L13:
            ReplayLoadingView r107 = r105.f108385a;
            if (r107 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
        L16:
            UtilityKotlinExtentionsKt.i(r107);
            return;
        L5:
            if (r103.isDisposed() == true) goto L8;
            r103 = null;
        L8:
            if (r103 == null) goto L10;
            r103.dispose();
            goto L10
        }

        @Override // nic.l.a, nic.b
        public final void O(nic.p r100, tic.a r101, boolean r102, int r110, boolean r111, boolean r112) {
            ReplayLoadingWidget r103 = this.f108401a;
            int r104 = ReplayLoadingWidget.f108384k;
            r103.getClass();
            if (r102 == false) goto L6;
            boolean r105 = MatchRoomLandScapeAnimUtil.f82832a;
            MatchRoomLandScapeAnimUtil.c("player_loading", r103.contentView, false, false, false, 28);
            return;
        }
    }

    public static final class h<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayLoadingWidget f108402a;

        public h(ReplayLoadingWidget r100) {
            this.f108402a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L9;
            VideoContext r101 = VideoContext.n0(this.f108402a.context);
            g r102 = this.f108402a.f108389e;
            if (r102 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("playerListener");
        L7:
            r101.K0(r102);
            return;
        }
    }

    public static final class i<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayLoadingWidget f108403a;

        public i(ReplayLoadingWidget r100) {
            this.f108403a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L22;
            ReplayLoadingWidget r101 = this.f108403a;
            if (r101.f108393i == false) goto L23;
            com.bytedance.android.livesdk.chatroom.vs_base.base.util.g r102 = r101.f108388d;
            wr1.b r103 = r102.f117935c;
            if (r103 == null) goto L17;
            LiveBlurAnimView r104 = r103.getView();
            if (r104 == null) goto L17;
            ViewPropertyAnimator r105 = r104.animate();
            if (r105 == null) goto L17;
            ViewPropertyAnimator r106 = r105.alpha(0.0f);
            if (r106 == null) goto L17;
            ViewPropertyAnimator r107 = r106.setDuration(1000);
            if (r107 == null) goto L17;
            ViewPropertyAnimator r108 = r107.withLayer();
        L18:
            if (r108 == null) goto L20;
            r108.start();
        L20:
            i0.c().postDelayed(new com.bytedance.android.livesdk.chatroom.vs_base.base.util.k(r102), 1000);
            this.f108403a.f108393i = false;
            return;
        L17:
            r108 = null;
            goto L18
        L23:
            return;
        }
    }

    public static final class j<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayLoadingWidget f108404a;

        public j(ReplayLoadingWidget r100) {
            this.f108404a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L6;
            ReplayLoadingWidget.xq(this.f108404a);
            return;
        }
    }

    public static final class k<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayLoadingWidget f108405a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VideoContext f108406b;

        public k(ReplayLoadingWidget r100, VideoContext r101) {
            this.f108405a = r100;
            this.f108406b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L14;
            ReplayLoadingWidget r101 = this.f108405a;
            int r102 = ReplayLoadingWidget.f108384k;
            if (r101.Cq() == false) goto L14;
            com.bytedance.live.datacontext.m<Boolean> r103 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.b().castScreenMode(this.f108405a.dataCenter);
            if (r103 != null) goto L9;
        L10:
            this.f108405a.Gq();
            VideoContext r104 = this.f108406b;
            g r105 = this.f108405a.f108389e;
            if (r105 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("playerListener");
        L13:
            r104.D0(r105);
            return;
        L9:
            if (r103.getValue().booleanValue() != true) goto L10;
        L14:
            UtilityKotlinExtentionsKt.i(ReplayLoadingWidget.yq(this.f108405a));
            VideoContext r106 = this.f108406b;
            g r107 = this.f108405a.f108389e;
            if (r107 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("playerListener");
        L17:
            r106.K0(r107);
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_replay_loading_widget_layout;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    public final boolean Cq() {
        if (this.f108394j.f118133g == false) goto L13;
        ReplayDataContext.a r100 = ReplayDataContext.Companion;
        DataCenter r101 = this.dataCenter;
        r100.getClass();
        ReplayDataContext r102 = ReplayDataContext.a.b(r101);
        if (r102 == null) goto L11;
        com.bytedance.live.datacontext.m<Boolean> r103 = r102.getHasSwitched();
        if (r103 == null) goto L11;
        if (r103.getValue().booleanValue() != true) goto L11;
        return true;
    L11:
        return false;
    L13:
        return true;
    }

    public final void Fq() {
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L13;
        Episode r101 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.a(r100);
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.isMatchEpisode() != true) goto L15;
        ReplayLoadingView r102 = this.f108385a;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
    L11:
        r102.setLandBackgroundUrl(ReplayConfigSettingKeys.REPLAY_LOADING_BG.getValue());
        return;
    L15:
        return;
    }

    public final void Gq() {
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r100 = ReplayRoomFragmentScopeUtil.f117917a;
        com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.p r101 = (com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.p) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.p.class);
        int r102 = 0;
        if (r101.b() == false) goto L5;
    L7:
        boolean r103 = false;
    L8:
        Context r104 = null;
        if (r103 == false) goto L34;
        DataCenter r105 = this.dataCenter;
        if (r105 == null) goto L15;
        Integer r106 = (Integer) r105.get("interaction_layer_margin_top", 0);
        if (r106 == null) goto L15;
        int r107 = r106.intValue();
    L17:
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == true) goto L19;
    L35:
        int r108 = com.bytedance.android.livesdk.chatroom.vs_base.util.t.h();
        VideoViewParams r109 = new VideoViewParams(-1, (int) ((r108 / 16.0f) * 9.0f), UtilityKotlinExtentionsKt.c(lr1.b.a()), 0.0f);
        DataCenter r110 = this.dataCenter;
        VideoViewParams r111 = r109;
        if (r110 == null) goto L42;
        Object r112 = r110.get("live_render_view_params");
        Object r113 = r109;
        if (r112 == null) goto L41;
        r113 = r112;
    L41:
        r111 = (VideoViewParams) r113;
    L42:
        int r114 = com.bytedance.android.livesdk.chatroom.vs_base.util.m.f118199a;
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.m.a(this.context) == false) goto L46;
        r108 = -1;
    L51:
        FrameLayout.LayoutParams r115 = new FrameLayout.LayoutParams(r108, r111.f112570b);
        r115.topMargin = r111.f112571c + r107;
        Context r116 = this.context;
        if (r116 == null) goto L61;
        boolean r117 = r116 instanceof Activity;
        if (r117 == false) goto L61;
        if (r117 == false) goto L59;
        r104 = r116;
    L59:
        if (e5.j((Activity) r104) == false) goto L61;
        r102 = 17;
    L61:
        r115.gravity = r102;
        ReplayLoadingView r118 = this.f108385a;
        if (r118 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
    L64:
        r118.setLayoutParams(r115);
        ReplayErrorView r119 = this.f108386b;
        if (r119 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("errorView");
    L67:
        r119.setLayoutParams(r115);
        FrameLayout r120 = (FrameLayout) this.f108387c.getValue();
        if (r120 == null) goto L71;
        r120.setLayoutParams(r115);
        return;
    L71:
        return;
    L46:
        if (PadConfigUtils.c() == true) goto L48;
    L50:
        r108 = r111.f112569a;
        goto L51
    L48:
        if (r111.f112569a <= r108) goto L50;
    L19:
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L35;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L34;
        Context r121 = this.context;
        if (r121 == null) goto L34;
        boolean r122 = r121 instanceof Activity;
        if (r122 == false) goto L33;
        if (r122 == true) goto L29;
        r121 = null;
    L29:
        if (e5.j((Activity) r121) == false) goto L33;
        r107 = StatusBarUtil.portraitStatusBarHeight;
        if (r107 > 0) goto L35;
    L33:
        r107 = StatusBarUtil.getStatusBarHeight(this.context);
        StatusBarUtil.portraitStatusBarHeight = r107;
    L15:
        r107 = 0;
    L34:
        r107 = 0;
        goto L35
    L5:
        if (r101.l() == true) goto L7;
        r103 = true;
        goto L8
    }

    public final boolean isPortrait() {
        Context r100 = this.context;
        if ((r100 instanceof Activity) == true) goto L5;
        r100 = null;
    L5:
        Activity r101 = (Activity) r100;
        if (r101 != null) goto L8;
    L10:
        return false;
    L8:
        if (r101.getRequestedOrientation() != 1) goto L10;
        return true;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        Disposable r100 = null;
        this.f108390f.removeCallbacksAndMessages(null);
        VideoContext r101 = VideoContext.n0(this.context);
        g r102 = this.f108389e;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("playerListener");
    L5:
        r101.K0(r102);
        Disposable r103 = this.f108392h;
        if (r103 != null) goto L8;
        return;
    L8:
        if (r103.isDisposed() == false) goto L10;
        r100 = r103;
    L10:
        if (r100 == null) goto L14;
        r100.dispose();
        return;
    }

    public final void Bq() {
        mq1.t r100 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.e();
        if (r100 == null) goto L7;
        mq1.v r101 = r100.provideVSPlayerViewControlService(this.dataCenter);
        if (r101 == null) goto L7;
        VSPlayerViewControlContext r102 = r101.provideContext();
    L8:
        boolean r103 = false;
        if (r102 == null) goto L15;
        com.bytedance.live.datacontext.m<Boolean> r104 = r102.getPlayerViewVisible();
        if (r104 == null) goto L15;
        if (r104.getValue().booleanValue() != true) goto L15;
        boolean r105 = true;
    L16:
        Boolean r106 = com.bytedance.android.livesdk.f.d().f123392a.getValue();
        Boolean r107 = Boolean.TRUE;
        boolean r108 = Intrinsics.areEqual(r106, r107);
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r109 = ReplayRoomFragmentScopeUtil.f117917a;
        com.bytedance.android.livesdk.chatroom.replay.ui.j r110 = (com.bytedance.android.livesdk.chatroom.replay.ui.j) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.replay.ui.j.class);
        if (r105 == true) goto L19;
        if (r108 == true) goto L19;
    L20:
        Function1<Boolean, Unit> r111 = new ReplayLoadingWidget$controlBackButton$1(this);
        r110.getClass();
        Intrinsics.checkNotNullParameter(r111, "action");
        if (r110.i() == false) goto L23;
        r111.invoke(r107);
        return;
    L23:
        r111.invoke(Boolean.valueOf(r103));
        return;
    L19:
        r103 = true;
    L15:
        r105 = false;
    L7:
        r102 = null;
        goto L8
    }

    public ReplayLoadingWidget(com.bytedance.android.livesdk.chatroom.vs_base.session.video.h r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        this.f108394j = r100;
        this.f108387c = LazyKt.lazy(new ReplayLoadingWidget$mCoverContainer$2(this));
        this.f108388d = new com.bytedance.android.livesdk.chatroom.vs_base.base.util.g();
        this.f108390f = new Handler(Looper.getMainLooper());
    }

    public static final void Aq(ReplayLoadingWidget r100) {
        if (r100.f108393i == true) goto L36;
        VideoContext r101 = VideoContext.n0(r100.context);
        if (r101 == null) goto L37;
        com.bytedance.android.livesdk.chatroom.vs_base.session.video.h r102 = r100.f108394j;
        if (r101.isPlaying() == false) goto L11;
        return;
    L11:
        if (r100.Cq() == true) goto L13;
        return;
    L13:
        if (r102.f118137k == true) goto L34;
        com.bytedance.live.datacontext.m<Boolean> r103 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.b().castScreenMode(r100.dataCenter);
        if (r103 != null) goto L17;
    L18:
        ReplayLoadingView r104 = r100.f108385a;
        if (r104 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
    L21:
        r104.setOnClickListener(com.bytedance.android.livesdk.chatroom.replay.element.j.f108554a);
        ReplayLoadingView r105 = r100.f108385a;
        if (r105 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
    L24:
        UtilityKotlinExtentionsKt.j(r105);
        ReplayLoadingView r106 = r100.f108385a;
        if (r106 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
    L27:
        r106.setText(s1.B(R.string.ttlive_vs_about_to_begin));
        r100.Eq(false);
        ReplayLoadingView r107 = r100.f108385a;
        if (r107 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
    L30:
        r107.f118228d.b();
        return;
    L17:
        if (r103.getValue().booleanValue() != true) goto L18;
        return;
    L34:
        return;
    L37:
        return;
    }

    public static final void wq(ReplayLoadingWidget r100) {
        if (r100.isViewValid == false) goto L23;
        Context r101 = r100.context;
        int r102 = ita.i.f495747a;
        if (NetworkUtils.isNetworkAvailable(r101) == true) goto L22;
        ReplayErrorView r103 = r100.f108386b;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("errorView");
    L11:
        if (r100.isPortrait() == false) goto L13;
        UtilityKotlinExtentionsKt.i(r103.f110285c);
    L14:
        ReplayErrorView r104 = r100.f108386b;
        if (r104 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("errorView");
    L17:
        UtilityKotlinExtentionsKt.j(r104);
        ReplayLoadingView r105 = r100.f108385a;
        if (r105 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
    L20:
        UtilityKotlinExtentionsKt.i(r105);
        com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(r100.dataCenter).d("loading_network_error_show", null, new Object[0]);
        return;
    L13:
        UtilityKotlinExtentionsKt.j(r103.f110285c);
        goto L14
    L22:
        return;
    }

    public static final void xq(ReplayLoadingWidget r100) {
        ReplayErrorView r101 = r100.f108386b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("errorView");
    L5:
        UtilityKotlinExtentionsKt.i(r101);
        ReplayLoadingView r102 = r100.f108385a;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
    L8:
        UtilityKotlinExtentionsKt.i(r102);
        ReplayLoadingView r103 = r100.f108385a;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
    L11:
        r103.setClickable(false);
        r100.f108390f.removeCallbacksAndMessages(null);
        ReplayLoadingView r104 = r100.f108385a;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
    L14:
        r104.f118228d.c();
        ReplayLoadingView r105 = r100.f108385a;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
    L17:
        UtilityKotlinExtentionsKt.h(r105);
        ReplayErrorView r106 = r100.f108386b;
        if (r106 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("errorView");
    L20:
        UtilityKotlinExtentionsKt.h(r106);
    }

    public static final /* synthetic */ ReplayLoadingView yq(ReplayLoadingWidget r100) {
        ReplayLoadingView r101 = r100.f108385a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
    L5:
        return r101;
    }

    public static final void zq(ReplayLoadingWidget r100) {
        r100.getClass();
        com.bytedance.live.datacontext.m<Boolean> r101 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.b().castScreenMode(r100.dataCenter);
        if (r101 != null) goto L5;
    L7:
        ReplayLoadingView r102 = r100.f108385a;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
    L10:
        r102.setClickable(false);
        r100.Gq();
        r102.setBackgroundResource(R.color.ttlive_std_mask_4);
        r102.setText(s1.B(R.string.ttlive_vs_loading));
        r102.a();
        ReplayLoadingView r103 = r100.f108385a;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
    L13:
        UtilityKotlinExtentionsKt.j(r103);
        return;
    L5:
        if (r101.getValue().booleanValue() != true) goto L7;
    }

    public final void Eq(boolean r100) {
        if ((!this.f108394j.f118135i.isEmpty()) == true) goto L19;
        ReplayLoadingView r101 = this.f108385a;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
    L8:
        if (PadConfigUtils.c() == false) goto L11;
        r101.a();
        return;
    L11:
        if (isPortrait() == false) goto L13;
        r101.setBackgroundResource(R.color.ttlive_std_bg_inverse);
        r101.a();
        return;
    L13:
        r101.setBackgroundResource(R.color.transparent);
        String r102 = r101.f118230f;
        if (r102 == null) goto L16;
        a1.r(r101.f118226b, r102, R.color.ttlive_std_bg_inverse);
    L16:
        UtilityKotlinExtentionsKt.j(r101.f118226b);
        if (r101.f118229e == true) goto L31;
        UtilityKotlinExtentionsKt.j(r101.f118227c);
        return;
    L31:
        return;
    L19:
        if (r100 == true) goto L21;
        return;
    L21:
        if (isPortrait() == true) goto L23;
        return;
    L23:
        if (this.f108393i == true) goto L35;
        FrameLayout r103 = (FrameLayout) this.f108387c.getValue();
        if (r103 == null) goto L27;
        UtilityKotlinExtentionsKt.j(r103);
    L27:
        py.k r104 = (py.k) vh7.f.c(py.k.class);
        r104.setUrls(this.f108394j.f118135i);
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.g r105 = this.f108388d;
        FrameLayout r106 = (FrameLayout) this.f108387c.getValue();
        int r107 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.g.f117932e;
        r105.a(r104, r106, 0, ImageView.ScaleType.CENTER_CROP);
        this.f108393i = true;
        return;
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        Eq(false);
        ReplayErrorView r101 = this.f108386b;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("errorView");
    L6:
        if (isPortrait() == false) goto L8;
        UtilityKotlinExtentionsKt.i(r101.f110285c);
        return;
    L8:
        UtilityKotlinExtentionsKt.j(r101.f110285c);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        ReplayLoadingView r101 = (ReplayLoadingView) this.contentView.findViewById(R.id.vs_loading_view);
        if (r101 != null) goto L5;
        return;
    L5:
        this.f108385a = r101;
        ReplayErrorView r102 = (ReplayErrorView) this.contentView.findViewById(R.id.vs_error_view);
        if (r102 != null) goto L8;
        return;
    L8:
        this.f108386b = r102;
        Fq();
        DataCenter r103 = this.dataCenter;
        if (r103 == null) goto L11;
        r103.observe("data_vs_episode_data", new c(this));
    L11:
        ReplayErrorView r104 = this.f108386b;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("errorView");
    L14:
        UtilityKotlinExtentionsKt.i(r104);
        ReplayErrorView r105 = this.f108386b;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("errorView");
    L17:
        r105.setRetryListener(new ReplayLoadingWidget$initErrorView$1(this));
        DataCenter r106 = this.dataCenter;
        if (r106 == null) goto L20;
        r106.observe("live_render_view_params", new d(this));
    L20:
        Gq();
        Eq(true);
        if (e5.n() == false) goto L23;
        boolean r107 = MatchRoomLandScapeAnimUtil.f82832a;
        MatchRoomLandScapeAnimUtil.c("player_loading", this.contentView, false, false, false, 28);
    L23:
        ReplayLoadingView r108 = this.f108385a;
        if (r108 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
    L26:
        r108.setTextColor(R.color.ttlive_std_text_white_1);
        Bq();
        com.bytedance.android.livesdk.f.d().f123392a.observe(this, new e(this));
        mq1.t r109 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.e();
        if (r109 == null) goto L31;
        mq1.v r110 = r109.provideVSPlayerViewControlService(this.dataCenter);
        if (r110 == null) goto L31;
        VSPlayerViewControlContext r111 = r110.provideContext();
    L32:
        if (r111 == null) goto L38;
        com.bytedance.live.datacontext.m<Boolean> r112 = r111.getPlayerViewVisible();
        if (r112 == null) goto L38;
        Observable<Boolean> r113 = r112.a();
        if (r113 == null) goto L38;
        r113.subscribe(new f(this));
    L38:
        VideoContext r114 = VideoContext.n0(this.context);
        ReplayLoadingView r115 = this.f108385a;
        if (r115 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
    L41:
        UtilityKotlinExtentionsKt.i(r115);
        this.f108389e = new g(this);
        this.f108394j.f118130d.f118070x.observe(this, new h(this));
        this.f108394j.f118130d.f118048b.observe(this, new i(this));
        this.f108394j.f118130d.f118052f.observe(this, new j(this));
        this.f108394j.f118130d.f118055i.observe(this, new k(this, r114));
        this.f108394j.f118130d.f118056j.observe(this, new b(this, r114), false);
        ReplayLoadingView r116 = this.f108385a;
        if (r116 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
    L44:
        r116.f118228d.c();
        return;
    L31:
        r111 = null;
        goto L32
    }
}
