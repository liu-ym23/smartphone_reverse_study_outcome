package com.bytedance.android.livesdk.chatroom.replay.player.tips;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerTipsContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.s;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.vs_base.util.k;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mq1.t;
import mq1.u;
import mq1.v;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/player/tips/ReplayPlayTipsWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayPlayTipsWidget extends LiveRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f109835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f109836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f109837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f109838d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public u f109839e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Animator f109840f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PlayerTipsContext f109841g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CompositeDisposable f109842h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f109843i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f109844j;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f109845a;

        public b(TextView r100) {
            this.f109845a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            TextView r101 = this.f109845a;
            Object r102 = r100.getAnimatedValue();
            if (r102 == null) goto L7;
            r101.setAlpha(((Float) r102).floatValue());
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class c implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f109846a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ReplayPlayTipsWidget f109847b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            UtilityKotlinExtentionsKt.i(this.f109846a);
            this.f109847b.f109840f = null;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            UtilityKotlinExtentionsKt.i(this.f109846a);
            this.f109847b.f109840f = null;
        }

        public c(TextView r100, ReplayPlayTipsWidget r101) {
            this.f109846a = r100;
            this.f109847b = r101;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayPlayTipsWidget f109848a;

        public d(ReplayPlayTipsWidget r100) {
            this.f109848a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            com.bytedance.android.livesdk.chatroom.progress.context.a r111 = (com.bytedance.android.livesdk.chatroom.progress.context.a) r110;
            ReplayPlayTipsWidget r100 = this.f109848a;
            Boolean r101 = null;
            if (r100.f109844j == false) goto L6;
        L29:
            ALogger.w(this.f109848a.f109835a, "receive show event for " + r111.f107688a);
            int r102 = r111.getType();
            if (r102 == 0) goto L61;
            if (r102 != 1) goto L101;
            View r103 = r111.f107691d;
            if (r103 == null) goto L96;
            ALogger.d(this.f109848a.f109835a, "show custom view visibility is " + r103.getVisibility());
            ReplayPlayTipsWidget r104 = this.f109848a;
            String r112 = r111.f107688a;
            TextView r105 = r104.f109837c;
            if (r105 == null) goto L38;
            UtilityKotlinExtentionsKt.h(r105);
        L38:
            FrameLayout r106 = r104.f109838d;
            if (r106 == null) goto L97;
            PlayerTipsContext r107 = r104.f109841g;     // Catch: IllegalStateException -> L59
            if (r107 == null) goto L45;
            Map<String, Boolean> r108 = r107.getShowMap();     // Catch: IllegalStateException -> L59
            if (r108 == null) goto L45;
            r101 = r108.get(r104.f109843i);     // Catch: IllegalStateException -> L59
        L45:
            Boolean r109 = Boolean.TRUE;     // Catch: IllegalStateException -> L59
            if (Intrinsics.areEqual(r101, r109) == false) goto L52;
            PlayerTipsContext r113 = r104.f109841g;     // Catch: IllegalStateException -> L59
            if (r113 == null) goto L52;
            Map<String, Boolean> r114 = r113.getShowMap();     // Catch: IllegalStateException -> L59
            if (r114 == null) goto L52;
            r114.put(r104.f109843i, Boolean.FALSE);     // Catch: IllegalStateException -> L59
        L52:
            r106.removeAllViews();     // Catch: IllegalStateException -> L59
            r106.removeView(r103);     // Catch: IllegalStateException -> L59
            k.a(r103, 8388627);     // Catch: IllegalStateException -> L59
            r106.addView(r103);     // Catch: IllegalStateException -> L59
            UtilityKotlinExtentionsKt.j(r106);     // Catch: IllegalStateException -> L59
            PlayerTipsContext r115 = r104.f109841g;     // Catch: IllegalStateException -> L59
            if (r115 == null) goto L57;
            Map<String, Boolean> r116 = r115.getShowMap();     // Catch: IllegalStateException -> L59
            if (r116 == null) goto L57;
            r116.put(r112, r109);     // Catch: IllegalStateException -> L59
        L57:
            r104.f109843i = r112;     // Catch: IllegalStateException -> L59
            return;
        L59:
            e = move-exception;
            ALogger.e(r104.f109835a, "showCustomView", e);
            return;
        L97:
            return;
        L96:
            return;
        L101:
            return;
        L61:
            CharSequence r117 = r111.f107690c;
            if (r117 == null) goto L99;
            ReplayPlayTipsWidget r118 = this.f109848a;
            String r119 = r111.f107688a;
            boolean r120 = r111.f107692e;
            Animator r121 = r118.f109840f;
            if (r121 == null) goto L66;
            r121.cancel();
        L66:
            r118.f109840f = null;
            TextView r122 = r118.f109837c;
            if (r122 == null) goto L90;
            PlayerTipsContext r123 = r118.f109841g;
            if (r123 == null) goto L73;
            Map<String, Boolean> r124 = r123.getShowMap();
            if (r124 == null) goto L73;
            r101 = r124.get(r118.f109843i);
        L73:
            Boolean r125 = Boolean.TRUE;
            if (Intrinsics.areEqual(r101, r125) == false) goto L80;
            PlayerTipsContext r126 = r118.f109841g;
            if (r126 == null) goto L80;
            Map<String, Boolean> r127 = r126.getShowMap();
            if (r127 == null) goto L80;
            r127.put(r118.f109843i, Boolean.FALSE);
        L80:
            UtilityKotlinExtentionsKt.j(r122);
            r122.setText(r117);
            if (r120 == false) goto L83;
            ValueAnimator r128 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(100);
            r128.addUpdateListener(new zl1.a(r122));
            Unit r129 = Unit.INSTANCE;
            r118.f109840f = r128;
            r128.start();
        L84:
            PlayerTipsContext r130 = r118.f109841g;
            if (r130 == null) goto L89;
            Map<String, Boolean> r131 = r130.getShowMap();
            if (r131 == null) goto L89;
            r131.put(r119, r125);
        L89:
            r118.f109843i = r119;
            goto L90
        L83:
            r122.setAlpha(1.0f);
        L90:
            FrameLayout r132 = r118.f109838d;
            if (r132 == null) goto L100;
            UtilityKotlinExtentionsKt.h(r132);
            return;
        L100:
            return;
        L99:
            return;
        L6:
            if (r100.containerView == null) goto L29;
            t r133 = s.e();
            if (r133 == null) goto L14;
            v r134 = r133.provideVSPlayerViewControlService(r100.dataCenter);
            if (r134 == null) goto L14;
            if (r134.getVisibilityStatus() != true) goto L14;
        L28:
            r100.f109844j = true;
        L14:
            int[] r135 = new int[2];
            Object r136 = r100.containerView.getParent();
            if ((r136 instanceof View) == true) goto L17;
            r136 = null;
        L17:
            View r137 = (View) r136;
            if (r137 == null) goto L20;
            r137.getLocationOnScreen(r135);
        L20:
            int r138 = r135[1];
            Object r139 = r100.containerView.getParent();
            if ((r139 instanceof View) == true) goto L23;
            r139 = null;
        L23:
            View r140 = (View) r139;
            if (r140 == null) goto L26;
            int r141 = r140.getHeight();
        L27:
            int r142 = r138 + r141;
            int[] r143 = new int[2];
            r100.containerView.getLocationOnScreen(r143);
            int r144 = r143[1] + r100.containerView.getHeight();
            float r145 = r100.containerView.getTranslationY() + r142;
            int r146 = lr1.a.f510387b;
            ValueAnimator r147 = ValueAnimator.ofFloat(new float[]{r100.containerView.getTranslationY(), (r145 - s1.f(lr1.a.C6730a.a(r100.dataCenter).b())) - r144});
            r147.addUpdateListener(new zl1.b(r100));
            r147.start();
            r147.setDuration(100);
            goto L28
        L26:
            r141 = 0;
            goto L27
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayPlayTipsWidget f109849a;

        public e(ReplayPlayTipsWidget r100) {
            this.f109849a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            String r101 = (String) r100;
            ALogger.w(this.f109849a.f109835a, "receive hide event for " + r101);
            ReplayPlayTipsWidget r102 = this.f109849a;
            PlayerTipsContext r103 = r102.f109841g;
            if (r103 == null) goto L7;
            Map<String, Boolean> r104 = r103.getShowMap();
            if (r104 == null) goto L7;
            Boolean r105 = r104.get(r101);
        L8:
            if (r105 != null) goto L10;
        L26:
            ALogger.w(r102.f109835a, "[" + r101 + "] has already hide,skip");
            return;
        L10:
            if (r105.booleanValue() == false) goto L26;
            r102.wq();
            PlayerTipsContext r106 = r102.f109841g;
            if (r106 == null) goto L17;
            Map<String, Boolean> r107 = r106.getShowMap();
            if (r107 == null) goto L17;
            r107.put(r101, Boolean.FALSE);
        L17:
            PlayerTipsContext r108 = r102.f109841g;
            if (r108 == null) goto L28;
            m<Boolean> r109 = r108.isTipsShowing();
            if (r109 == null) goto L29;
            PlayerTipsContext r110 = r102.f109841g;
            if (r110 == null) goto L24;
            boolean r111 = r110.getPlayerTipShowing();
        L25:
            r109.setValue(Boolean.valueOf(r111));
            return;
        L24:
            r111 = false;
            goto L25
        L29:
            return;
        L28:
            return;
        L7:
            r105 = null;
            goto L8
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_replay_widget_video_player_tip;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        Animator r100 = this.f109840f;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        t r101 = s.e();
        if (r101 == null) goto L10;
        v r102 = r101.provideVSPlayerViewControlService(this.dataCenter);
        if (r102 == null) goto L10;
        r102.c(PlayerViewControl.KEY.PlayTip);
    L10:
        boolean r103 = false;
        this.f109844j = false;
        wq();
        PlayerTipsContext r104 = this.f109841g;
        if (r104 == null) goto L15;
        Map<String, Boolean> r105 = r104.getShowMap();
        if (r105 == null) goto L15;
        r105.clear();
    L15:
        PlayerTipsContext r106 = this.f109841g;
        if (r106 == null) goto L24;
        m<Boolean> r107 = r106.isTipsShowing();
        if (r107 == null) goto L25;
        PlayerTipsContext r108 = this.f109841g;
        if (r108 == null) goto L22;
        r103 = r108.getPlayerTipShowing();
    L22:
        r107.setValue(Boolean.valueOf(r103));
        return;
    L25:
        return;
    }

    public final void wq() {
        TextView r100 = this.f109837c;
        if (r100 != null) goto L5;
    L10:
        FrameLayout r101 = this.f109838d;
        if (r101 != null) goto L13;
        return;
    L13:
        if (r101.getVisibility() == 8) goto L17;
        r101.removeAllViews();
        UtilityKotlinExtentionsKt.i(r101);
        return;
    L17:
        return;
    L5:
        if (r100.getVisibility() == 8) goto L10;
        if (this.f109840f == null) goto L9;
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f}).setDuration(100);
        r102.addUpdateListener(new b(r100));
        r102.addListener(new c(r100, this));
        Unit r103 = Unit.INSTANCE;
        this.f109840f = r102;
        r102.start();
        goto L10
    L9:
        UtilityKotlinExtentionsKt.i(r100);
        goto L10
    }

    public ReplayPlayTipsWidget() {
        this.f109835a = "VideoPlayTipsWidget[" + hashCode() + ']';
        this.f109842h = new CompositeDisposable();
        this.f109843i = "";
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r110) {
        ALogger.i(this.f109835a, "tipWidget start to load, dataCenter:" + this.dataCenter.hashCode());
        ReplayDataContext.a r111 = ReplayDataContext.Companion;
        DataCenter r100 = this.dataCenter;
        r111.getClass();
        ReplayDataContext.a.b(r100);
        u r112 = s.e().provideVSPlayerTipService(this.dataCenter);
        this.f109839e = r112;
        if (r112 == null) goto L5;
        PlayerTipsContext r113 = r112.provideVSPlayTipsContext();
    L6:
        this.f109841g = r113;
        this.f109837c = (TextView) findViewById(R.id.tv_tip_default);
        this.f109838d = (FrameLayout) findViewById(R.id.custom_tip_holder);
        t r114 = s.e();
        if (r114 == null) goto L11;
        v r101 = r114.provideVSPlayerViewControlService(this.dataCenter);
        if (r101 == null) goto L11;
        PlayerViewControl.KEY r102 = PlayerViewControl.KEY.PlayTip;
        PlayerViewControl.Type r103 = PlayerViewControl.Type.BOTTOM;
        PlayerViewControl.Style r104 = PlayerViewControl.Style.ATTACH;
        ViewGroup r105 = this.containerView;
        int r115 = lr1.a.f510387b;
        v.a.a(r101, r102, r103, r104, r105, lr1.a.C6730a.a(this.dataCenter).b(), false, null, 480);
    L11:
        int r116 = this.dataCenter.hashCode();
        Integer r106 = this.f109836b;
        if (r106 != null) goto L14;
    L15:
        ALogger.w(this.f109835a, "dataCenter has change from [" + this.f109836b + "] to [" + r116 + "],tipWidget dispose");
        this.f109843i = "";
        wq();
        this.f109836b = Integer.valueOf(r116);
        this.f109842h.dispose();
        this.f109842h = new CompositeDisposable();
        PlayerTipsContext r117 = this.f109841g;
        if (r117 == null) goto L33;
        com.bytedance.live.datacontext.k<com.bytedance.android.livesdk.chatroom.progress.context.a> r118 = r117.getMShowPlayerTipEvent();
        if (r118 == null) goto L24;
        PublishSubject r119 = r118.onEvent();
        if (r119 == null) goto L24;
        Disposable r120 = r119.subscribe(new d(this));
        if (r120 == null) goto L24;
        RxUtilKt.c(r120, this.f109842h);
    L24:
        PlayerTipsContext r121 = this.f109841g;
        if (r121 == null) goto L33;
        com.bytedance.live.datacontext.k<String> r122 = r121.getMHidePlayerTipEvent();
        if (r122 == null) goto L33;
        PublishSubject r123 = r122.onEvent();
        if (r123 == null) goto L33;
        Disposable r124 = r123.subscribe(new e(this));
        if (r124 == null) goto L33;
        RxUtilKt.c(r124, this.f109842h);
    L33:
        ReplayDataContext r125 = ReplayDataContext.a.b(this.dataCenter);
        if (r125 == null) goto L39;
        m<Boolean> r126 = r125.getPlayerTipsReady();
        if (r126 == null) goto L40;
        r126.setValue(Boolean.TRUE);
        return;
    L40:
        return;
    L39:
        return;
    L14:
        if (r106.intValue() == r116) goto L33;
    L5:
        r113 = null;
        goto L6
    }
}
