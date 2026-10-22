package com.bytedance.android.livesdk.chatroom.replay.element;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.IReplayInnerProgressService;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.ReplayConfigSettingKeys;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.ReplayRoomFragmentScopeUtil;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeHighLight;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.videoshop.context.VideoContext;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mq1.h0;
import mq1.i0;
import mq1.j0;
import zg1.i1;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/element/ReplayBaseGestureWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lmq1/j0;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ReplayBaseGestureWidget extends LiveRecyclableWidget implements j0 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f108322k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f108323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f108324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LottieAnimationView f108325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Animator f108326d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f108327e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AnimatorSet f108328f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CompositeDisposable f108329g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final j f108330h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final i f108331i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f108332j;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayBaseGestureWidget f108333a;

        public b(ReplayBaseGestureWidget r100) {
            this.f108333a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = r100.getAnimatedValue();
            if (r101 == null) goto L9;
            float r102 = ((Float) r101).floatValue();
            View r103 = this.f108333a.f108324b;
            if (r103 == null) goto L10;
            r103.setAlpha(r102);
            return;
        L10:
            return;
        L9:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayBaseGestureWidget f108334a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f108335b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            if (this.f108335b == true) goto L8;
            View r101 = this.f108334a.f108324b;
            if (r101 == null) goto L9;
            UtilityKotlinExtentionsKt.u(r101);
            return;
        L9:
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            if (this.f108335b == true) goto L8;
            View r101 = this.f108334a.f108324b;
            if (r101 == null) goto L9;
            UtilityKotlinExtentionsKt.u(r101);
            return;
        L9:
            return;
        }

        public c(ReplayBaseGestureWidget r100, boolean r101) {
            this.f108334a = r100;
            this.f108335b = r101;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayBaseGestureWidget f108336a;

        public d(ReplayBaseGestureWidget r100) {
            this.f108336a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            zt2.a r101 = (zt2.a) r100;
            ALogger.e("ReplayBaseGestureWidget", "on LandScapeFullScreenEvent" + r101.f573568a);
            if (r101.f573568a == true) goto L6;
            ReplayBaseGestureWidget r102 = this.f108336a;
            int r103 = ReplayBaseGestureWidget.f108322k;
            r102.yq();
            return;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayBaseGestureWidget f108337a;

        public e(ReplayBaseGestureWidget r100) {
            this.f108337a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            if (((i1) r100).f571850b == false) goto L6;
            ReplayBaseGestureWidget r101 = this.f108337a;
            int r102 = ReplayBaseGestureWidget.f108322k;
            r101.yq();
            return;
        }
    }

    public static final class f implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayBaseGestureWidget f108338a;

        public f(ReplayBaseGestureWidget r100) {
            this.f108338a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = r100.getAnimatedValue();
            if (r101 == null) goto L9;
            float r102 = ((Float) r101).floatValue();
            View r103 = this.f108338a.f108323a;
            if (r103 == null) goto L10;
            r103.setAlpha(r102);
            return;
        L10:
            return;
        L9:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class g implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayBaseGestureWidget f108339a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f108340b;

        public g(ReplayBaseGestureWidget r100, float r101) {
            this.f108339a = r100;
            this.f108340b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = r100.getAnimatedValue();
            if (r101 == null) goto L12;
            float r102 = ((Float) r101).floatValue();
            View r103 = this.f108339a.f108323a;
            if (r103 == null) goto L7;
            float r104 = this.f108340b;
            r103.setScaleX(r104 - ((r104 - 1.0f) * r102));
        L7:
            View r105 = this.f108339a.f108323a;
            if (r105 == null) goto L13;
            float r106 = this.f108340b;
            r105.setScaleY(r106 - ((r106 - 1.0f) * r102));
            return;
        L13:
            return;
        L12:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class h extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayBaseGestureWidget f108341a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f108342b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0 f108343c;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ h f108344a;

            public a(h r100) {
                this.f108344a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Function0 r100 = this.f108344a.f108343c;     // Catch: Throwable -> L6
                if (r100 == null) goto L9;
                Unit r101 = (Unit) r100.invoke();     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationCancel(r100);
            View r101 = this.f108341a.f108323a;
            if (r101 != null) goto L5;
        L9:
            View r102 = this.f108341a.f108323a;
            if (r102 == null) goto L12;
            r102.setScaleX(1.0f);
        L12:
            View r103 = this.f108341a.f108323a;
            if (r103 == null) goto L16;
            r103.setScaleY(1.0f);
            return;
        L16:
            return;
        L5:
            if (this.f108342b == false) goto L7;
            int r104 = 0;
        L8:
            r101.setVisibility(r104);
            goto L9
        L7:
            r104 = 4;
            goto L8
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationEnd(r100);
            View r101 = this.f108341a.f108323a;
            if (r101 != null) goto L5;
        L9:
            View r102 = this.f108341a.f108323a;
            if (r102 == null) goto L12;
            r102.setScaleX(1.0f);
        L12:
            View r103 = this.f108341a.f108323a;
            if (r103 == null) goto L15;
            r103.setScaleY(1.0f);
        L15:
            View r104 = this.f108341a.f108323a;
            if (r104 == null) goto L19;
            r104.post(new a(this));
            return;
        L19:
            return;
        L5:
            if (this.f108342b == false) goto L7;
            int r105 = 0;
        L8:
            r101.setVisibility(r105);
            goto L9
        L7:
            r105 = 4;
            goto L8
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationStart(r100);
            View r101 = this.f108341a.f108323a;
            if (r101 == null) goto L6;
            r101.setVisibility(0);
            return;
        }

        public h(ReplayBaseGestureWidget r100, boolean r101, Function0 r102) {
            this.f108341a = r100;
            this.f108342b = r101;
            this.f108343c = r102;
        }
    }

    public static final class i implements jm1.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayBaseGestureWidget f108345a;

        @Override // jm1.c
        public final void C5() {
        }

        @Override // jm1.c
        public final void P1() {
        }

        @Override // jm1.c
        public final void Pc(float r100, boolean r101, long r102) {
        }

        @Override // jm1.c
        public final void g5() {
        }

        @Override // jm1.c
        public final void k2() {
        }

        @Override // jm1.c
        public final void l3() {
        }

        @Override // jm1.c
        public final void onRenderStart() {
        }

        @Override // jm1.c
        public final void z() {
        }

        public i(ReplayBaseGestureWidget r100) {
            this.f108345a = r100;
        }

        @Override // jm1.c
        public final void Xa(boolean r100) {
            if (r100 == true) goto L5;
            ReplayBaseGestureWidget r101 = this.f108345a;
            int r102 = ReplayBaseGestureWidget.f108322k;
            r101.yq();
            return;
        }

        @Override // jm1.c
        public final void v2(EpisodeHighLight r100) {
            Intrinsics.checkNotNullParameter(r100, "episodeHighLight");
            Intrinsics.checkNotNullParameter(r100, "episodeHighLight");
        }
    }

    public static final class j extends nic.l.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayBaseGestureWidget f108346a;

        public j(ReplayBaseGestureWidget r100) {
            this.f108346a = r100;
        }

        @Override // nic.l.a, nic.h
        public final void W(oic.f r100, tic.a r101) {
            ReplayBaseGestureWidget r102 = this.f108346a;
            if (r102.f108332j == true) goto L8;
            View r103 = r102.f108323a;
            if (r103 != null) goto L7;
        L9:
            this.f108346a.f108332j = false;
            return;
        L7:
            if (r103.getVisibility() != 0) goto L9;
        L8:
            ReplayBaseGestureWidget.wq(this.f108346a, false);
            goto L9
        }

        @Override // nic.l.a, nic.h
        public final void o(oic.f r100, tic.a r101) {
            ReplayBaseGestureWidget r102 = this.f108346a;
            int r103 = ReplayBaseGestureWidget.f108322k;
            r102.yq();
        }

        @Override // nic.l.a, nic.h
        public final void s(oic.f r100, tic.a r101) {
            ReplayBaseGestureWidget r102 = this.f108346a;
            if (r102.f108332j == true) goto L8;
            View r103 = r102.f108323a;
            if (r103 != null) goto L7;
        L9:
            ReplayBaseGestureWidget r104 = this.f108346a;
            r104.f108332j = false;
            r104.xq(false);
            LottieAnimationView r105 = this.f108346a.f108325c;
            if (r105 == null) goto L13;
            r105.cancelAnimation();
            return;
        L13:
            return;
        L7:
            if (r103.getVisibility() != 0) goto L9;
        L8:
            ReplayBaseGestureWidget.wq(this.f108346a, true);
            goto L9
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_replay_gesture_widget_layout;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public void onInit(Object[] r100) {
    }

    public final void yq() {
        Disposable r100 = this.f108327e;
        if (r100 != null) goto L5;
    L10:
        AnimatorSet r101 = this.f108328f;
        if (r101 != null) goto L13;
    L18:
        Animator r102 = this.f108326d;
        if (r102 != null) goto L21;
    L26:
        View r103 = this.f108323a;
        if (r103 == null) goto L29;
        r103.setScaleX(1.0f);
    L29:
        View r104 = this.f108323a;
        if (r104 == null) goto L32;
        r104.setScaleY(1.0f);
    L32:
        View r105 = this.f108323a;
        if (r105 == null) goto L36;
        r105.setVisibility(4);
        return;
    L36:
        return;
    L21:
        if (r102.isRunning() != true) goto L26;
        Animator r106 = this.f108326d;
        if (r106 == null) goto L25;
        r106.cancel();
    L25:
        this.f108326d = null;
        goto L26
    L13:
        if (r101.isRunning() != true) goto L18;
        AnimatorSet r107 = this.f108328f;
        if (r107 == null) goto L17;
        r107.cancel();
    L17:
        this.f108328f = null;
        goto L18
    L5:
        if (r100.isDisposed() == true) goto L10;
        Disposable r108 = this.f108327e;
        if (r108 == null) goto L9;
        r108.dispose();
    L9:
        this.f108327e = null;
        goto L10
    }

    public ReplayBaseGestureWidget() {
        this.f108329g = new CompositeDisposable();
        this.f108330h = new j(this);
        this.f108331i = new i(this);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onPause() {
        super.onPause();
        VideoContext.n0(this.context).K0(this.f108330h);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onResume() {
        super.onResume();
        VideoContext.n0(this.context).D0(this.f108330h);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public void onUnload() {
        IReplayInnerProgressService r100 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.e().provideVSProgressService(this.dataCenter);
        if (r100 == null) goto L5;
        r100.removeProgressChangeListener(this.f108331i);
    L5:
        h0 r101 = i0.a(this.dataCenter, this);
        if (r101 == null) goto L8;
        r101.g(this);
    L8:
        Disposable r102 = this.f108327e;
        if (r102 == null) goto L17;
        if (r102.isDisposed() == true) goto L17;
        Disposable r103 = this.f108327e;
        if (r103 == null) goto L15;
        r103.dispose();
    L15:
        this.f108327e = null;
    L17:
        if (this.f108329g.isDisposed() == true) goto L20;
        this.f108329g.dispose();
        return;
    }

    public static int zq(boolean r100) {
        if (Build.VERSION.SDK_INT >= 24) goto L8;
        if (r100 == false) goto L6;
        return R.drawable.ttlive_vs_replay_gesture_pause_downgrade;
    L6:
        return R.drawable.ttlive_vs_replay_gesture_play_downgrade;
    L8:
        if (r100 == false) goto L10;
        return R.drawable.ttlive_vs_replay_gesture_pause;
    L10:
        return R.drawable.ttlive_vs_replay_gesture_play;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public void onLoad(Object[] r100) {
        View r101 = findViewById(R.id.pause_icon);
        this.f108323a = r101;
        if (r101 == null) goto L5;
        r101.setVisibility(4);
    L5:
        View r102 = this.f108323a;
        if (r102 == null) goto L8;
        r102.setBackgroundResource(zq(false));
    L8:
        this.f108324b = findViewById(R.id.fast_forward_container);
        LottieAnimationView r103 = (LottieAnimationView) findViewById(R.id.fast_forward_icon);
        this.f108325c = r103;
        if (r103 == null) goto L11;
        r103.setRepeatCount(-1);
    L11:
        LottieAnimationView r104 = this.f108325c;
        if (r104 == null) goto L14;
        r104.setAnimation("fast_forward/play_rate.json");
    L14:
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r105 = ReplayRoomFragmentScopeUtil.f117917a;
        com.bytedance.android.livesdk.chatroom.replay.ui.v r106 = (com.bytedance.android.livesdk.chatroom.replay.ui.v) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.replay.ui.v.class);
        View r107 = this.f108323a;
        View r108 = this.f108324b;
        r106.getClass();
        ViewGroup.LayoutParams r109 = null;
        if (r107 == null) goto L17;
        ViewGroup.LayoutParams r110 = r107.getLayoutParams();
    L19:
        if ((r110 instanceof ConstraintLayout.LayoutParams) == true) goto L21;
        r110 = null;
    L21:
        ConstraintLayout.LayoutParams r111 = (ConstraintLayout.LayoutParams) r110;
        if (r111 != null) goto L24;
    L32:
        if (r108 == null) goto L34;
        ViewGroup.LayoutParams r112 = r108.getLayoutParams();
    L36:
        if ((r112 instanceof ConstraintLayout.LayoutParams) == false) goto L39;
        r109 = r112;
    L39:
        ConstraintLayout.LayoutParams r113 = (ConstraintLayout.LayoutParams) r109;
        if (r113 != null) goto L42;
    L49:
        TextView r114 = (TextView) findViewById(R.id.fast_forward_tip);
        if (r114 == null) goto L52;
        r114.setText(s1.C(R.string.ttlive_fast_forward_tip, new Object[]{ReplayConfigSettingKeys.REPLAY_FAST_FORWARD_SPEED.getValue()}));
    L52:
        h0 r115 = i0.a(this.dataCenter, this);
        if (r115 == null) goto L55;
        r115.f(this);
    L55:
        IReplayInnerProgressService r116 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.e().provideVSProgressService(this.dataCenter);
        if (r116 == null) goto L58;
        r116.addProgressChangeListener(this.f108331i);
    L58:
        L7(zt2.a.class, new d(this));
        L7(i1.class, new e(this));
        return;
    L42:
        if (r106.l() == false) goto L45;
        float r117 = 114.0f;
    L48:
        ((ViewGroup.MarginLayoutParams) r113).topMargin = (int) UtilityKotlinExtentionsKt.h(r117);
        goto L49
    L45:
        if (r106.d() == false) goto L47;
        r117 = 54.0f;
        goto L48
    L47:
        r117 = 14.0f;
        goto L48
    L34:
        r112 = null;
        goto L36
    L24:
        if (r106.d() == false) goto L26;
        float r118 = UtilityKotlinExtentionsKt.h(72.0f);
    L27:
        ((ViewGroup.MarginLayoutParams) r111).width = (int) r118;
        if (r106.d() == false) goto L30;
        float r119 = UtilityKotlinExtentionsKt.h(72.0f);
    L31:
        ((ViewGroup.MarginLayoutParams) r111).height = (int) r119;
        goto L32
    L30:
        r119 = UtilityKotlinExtentionsKt.h(58.0f);
        goto L31
    L26:
        r118 = UtilityKotlinExtentionsKt.h(58.0f);
        goto L27
    L17:
        r110 = null;
        goto L19
    }

    public final void xq(boolean r100) {
        if (r100 == true) goto L8;
        View r101 = this.f108324b;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.getVisibility() == 0) goto L8;
        return;
    L8:
        if (r100 == false) goto L14;
        View r102 = this.f108324b;
        if (r102 == null) goto L14;
        if (r102.getVisibility() != 0) goto L14;
        return;
    L14:
        View r103 = this.f108324b;
        if (r103 == null) goto L17;
        UtilityKotlinExtentionsKt.w(r103);
    L17:
        Animator r104 = this.f108326d;
        if (r104 != null) goto L20;
    L25:
        float[] r105 = {1.0f, 0.0f};
        if (r100 == false) goto L29;
        r105 = {x006c: FILL_ARRAY_DATA  (LINE:16777324), data: [0, 1065353216} // fill-array;
    L29:
        ValueAnimator r106 = ValueAnimator.ofFloat(r105);
        r106.addUpdateListener(new b(this));
        r106.addListener(new c(this, r100));
        r106.setInterpolator(new AccelerateInterpolator());
        r106.setDuration(300);
        Unit r107 = Unit.INSTANCE;
        this.f108326d = r106;
        r106.start();
        return;
    L20:
        if (r104.isRunning() != true) goto L25;
        Animator r108 = this.f108326d;
        if (r108 == null) goto L24;
        r108.cancel();
    L24:
        this.f108326d = null;
        goto L25
    }

    private final <T> void L7(Class<T> r100, Consumer<T> r101) {
        this.f108329g.add(((ObservableSubscribeProxy) xs2.b.a().b(r100).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r101));
    }

    public static final void wq(final ReplayBaseGestureWidget r100, final boolean r101) {
        Disposable r102 = r100.f108327e;
        if (r102 != null) goto L5;
    L10:
        View r103 = r100.f108323a;
        if (r103 != null) goto L13;
    L18:
        r100.Aq(Boolean.valueOf(r101), true, null);
        long r104 = 2300;
    L19:
        r100.f108327e = Observable.timer(r104, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.chatroom.replay.element.d(r100));
        return;
    L13:
        if (r103.getVisibility() != 0) goto L18;
        View r105 = r100.f108323a;
        if (r105 == null) goto L17;
        r105.setBackgroundResource(zq(!r101));
    L17:
        r100.Aq(Boolean.valueOf(!r101), false, new ReplayBaseGestureWidget$pauseIconChange$1(r100, r101));
        r104 = 2600;
        goto L19
    L5:
        if (r102.isDisposed() == true) goto L10;
        Disposable r106 = r100.f108327e;
        if (r106 == null) goto L9;
        r106.dispose();
    L9:
        r100.f108327e = null;
        goto L10
    }

    @Override // mq1.j0
    public final void p7(int r100, int r101) {
        if (r100 != r101) goto L5;
        return;
    L5:
        if (r100 != 5) goto L9;
        xq(false);
        LottieAnimationView r102 = this.f108325c;
        if (r102 == null) goto L9;
        r102.cancelAnimation();
    L9:
        if (r101 != 0) goto L11;
        return;
    L11:
        if (r101 != 5) goto L13;
        xq(true);
        LottieAnimationView r103 = this.f108325c;
        if (r103 == null) goto L25;
        r103.playAnimation();
        return;
    L25:
        return;
    L13:
        if (r101 != 6) goto L15;
    L17:
        this.f108332j = true;
        return;
    L15:
        if (r101 == 7) goto L17;
        yq();
    }

    public final void Aq(Boolean r110, boolean r111, Function0<Unit> r112) {
        StringBuilder r100 = new StringBuilder("pauseIconShow pause:");
        r100.append(r110);
        r100.append(" show:");
        r100.append(r111);
        r100.append(" has onAnimationEnd:");
        if (r112 == null) goto L5;
        boolean r101 = true;
    L6:
        r100.append(r101);
        ALogger.i("ReplayBaseGestureWidget", r100.toString());
        if (r110 == null) goto L11;
        boolean r113 = r110.booleanValue();
        View r102 = this.f108323a;
        if (r102 == null) goto L11;
        r102.setBackgroundResource(zq(r113));
    L11:
        AnimatorSet r114 = this.f108328f;
        if (r114 != null) goto L14;
    L19:
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r115 = ReplayRoomFragmentScopeUtil.f117917a;
        if (((com.bytedance.android.livesdk.chatroom.replay.ui.v) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.replay.ui.v.class)).i() == false) goto L22;
        float r116 = 1.2f;
    L23:
        float[] r103 = {1.0f, 0.0f};
        if (r111 == false) goto L27;
        r103 = {x00d2: FILL_ARRAY_DATA  (LINE:50331858), data: [0, 1065353216} // fill-array;
    L27:
        ValueAnimator r104 = ValueAnimator.ofFloat(r103);
        r104.addUpdateListener(new f(this));
        float[] r105 = {1.0f, 0.0f};
        if (r111 == false) goto L31;
        r105 = {x00e2: FILL_ARRAY_DATA  (LINE:50331874), data: [0, 1065353216} // fill-array;
    L31:
        ValueAnimator r106 = ValueAnimator.ofFloat(r105);
        r106.setInterpolator(PathInterpolatorCompat.create(0.58f, 0.0f, 0.16f, 1.0f));
        r106.addUpdateListener(new g(this, r116));
        AnimatorSet r117 = new AnimatorSet();
        this.f108328f = r117;
        r117.addListener(new h(this, r111, r112));
        AnimatorSet r118 = this.f108328f;
        if (r118 == null) goto L34;
        r118.setDuration(300);
    L34:
        AnimatorSet r119 = this.f108328f;
        if (r119 == null) goto L37;
        r119.playTogether(new Animator[]{r104, r106});
    L37:
        AnimatorSet r120 = this.f108328f;
        if (r120 == null) goto L41;
        r120.start();
        return;
    L41:
        return;
    L22:
        r116 = 1.4f;
        goto L23
    L14:
        if (r114.isRunning() != true) goto L19;
        AnimatorSet r121 = this.f108328f;
        if (r121 == null) goto L18;
        r121.cancel();
    L18:
        this.f108328f = null;
        goto L19
    L5:
        r101 = false;
        goto L6
    }
}
