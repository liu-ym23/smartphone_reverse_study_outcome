package com.bytedance.android.livesdk.chatroom.progressbar;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerTipsContext;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import vr1.u;
import zg1.i1;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/progressbar/VSRoomPlayTipsWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/a;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSRoomPlayTipsWidget extends LiveRecyclableWidget implements com.bytedance.android.livesdk.chatroom.vsplayer.model.a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f107709o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f107710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f107711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f107712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f107713d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.vsplayer.api.b f107714e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Animator f107715f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PlayerTipsContext f107716g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CompositeDisposable f107717h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f107718i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Disposable f107719j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CompositeDisposable f107720k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f107721l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PlayerProgressServiceContext f107722m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f107723n;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f107724a;

        public b(TextView r100) {
            this.f107724a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            TextView r101 = this.f107724a;
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
        public final /* synthetic */ TextView f107725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VSRoomPlayTipsWidget f107726b;

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
            UtilityKotlinExtentionsKt.u(this.f107725a);
            this.f107726b.f107715f = null;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            UtilityKotlinExtentionsKt.u(this.f107725a);
            this.f107726b.f107715f = null;
        }

        public c(TextView r100, VSRoomPlayTipsWidget r101) {
            this.f107725a = r100;
            this.f107726b = r101;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VSRoomPlayTipsWidget f107727a;

        public d(VSRoomPlayTipsWidget r100) {
            this.f107727a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            com.bytedance.android.livesdk.chatroom.progress.context.a r111 = (com.bytedance.android.livesdk.chatroom.progress.context.a) r110;
            VSRoomPlayTipsWidget r100 = this.f107727a;
            Boolean r101 = null;
            if (r100.f107721l == false) goto L6;
        L22:
            ALogger.w(this.f107727a.f107710a, "receive show event for " + r111.f107688a);
            int r102 = r111.getType();
            boolean r103 = false;
            if (r102 != 0) goto L25;
            CharSequence r104 = r111.f107690c;
            if (r104 == null) goto L105;
            VSRoomPlayTipsWidget r105 = this.f107727a;
            String r106 = r111.f107688a;
            boolean r112 = r111.f107692e;
            r105.f107715f = null;
            TextView r107 = r105.f107712c;
            if (r107 == null) goto L96;
            PlayerTipsContext r108 = r105.f107716g;
            if (r108 == null) goto L72;
            Map<String, Boolean> r109 = r108.getShowMap();
            if (r109 == null) goto L72;
            r101 = r109.get(r105.f107718i);
        L72:
            Boolean r113 = Boolean.TRUE;
            if (Intrinsics.areEqual(r101, r113) == false) goto L79;
            PlayerTipsContext r114 = r105.f107716g;
            if (r114 == null) goto L79;
            Map<String, Boolean> r115 = r114.getShowMap();
            if (r115 == null) goto L79;
            r115.put(r105.f107718i, Boolean.FALSE);
        L79:
            UtilityKotlinExtentionsKt.w(r107);
            r107.setText(r104);
            if (r112 == false) goto L82;
            ValueAnimator r116 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(100);
            r116.addUpdateListener(new g(r107));
            Unit r117 = Unit.INSTANCE;
            r105.f107715f = r116;
            r116.start();
        L83:
            PlayerTipsContext r118 = r105.f107716g;
            if (r118 == null) goto L88;
            Map<String, Boolean> r119 = r118.getShowMap();
            if (r119 == null) goto L88;
            r119.put(r106, r113);
        L88:
            r105.f107718i = r106;
            PlayerTipsContext r120 = r105.f107716g;
            if (r120 == null) goto L96;
            m<Boolean> r121 = r120.isTipsShowing();
            if (r121 == null) goto L96;
            PlayerTipsContext r122 = r105.f107716g;
            if (r122 == null) goto L95;
            r103 = r122.getPlayerTipShowing();
        L95:
            r121.setValue(Boolean.valueOf(r103));
            goto L96
        L82:
            r107.setAlpha(1.0f);
        L96:
            FrameLayout r123 = r105.f107713d;
            if (r123 == null) goto L99;
            UtilityKotlinExtentionsKt.t(r123);
        L99:
            VSRoomPlayTipsWidget.wq(this.f107727a);
            return;
        L105:
            return;
        L25:
            if (r102 != 1) goto L106;
            View r124 = r111.f107691d;
            if (r124 == null) goto L103;
            ALogger.d(this.f107727a.f107710a, "show custom view visibility is " + r124.getVisibility());
            VSRoomPlayTipsWidget r125 = this.f107727a;
            String r126 = r111.f107688a;
            TextView r127 = r125.f107712c;
            if (r127 == null) goto L32;
            UtilityKotlinExtentionsKt.t(r127);
        L32:
            FrameLayout r128 = r125.f107713d;
            if (r128 != null) goto L101;
        L62:
            VSRoomPlayTipsWidget.wq(this.f107727a);
            return;
        L101:
            PlayerTipsContext r129 = r125.f107716g;     // Catch: IllegalStateException -> L60
            if (r129 == null) goto L39;
            Map<String, Boolean> r130 = r129.getShowMap();     // Catch: IllegalStateException -> L60
            if (r130 == null) goto L39;
            r101 = r130.get(r125.f107718i);     // Catch: IllegalStateException -> L60
        L39:
            Boolean r131 = Boolean.TRUE;     // Catch: IllegalStateException -> L60
            if (Intrinsics.areEqual(r101, r131) == false) goto L46;
            PlayerTipsContext r132 = r125.f107716g;     // Catch: IllegalStateException -> L60
            if (r132 == null) goto L46;
            Map<String, Boolean> r133 = r132.getShowMap();     // Catch: IllegalStateException -> L60
            if (r133 == null) goto L46;
            r133.put(r125.f107718i, Boolean.FALSE);     // Catch: IllegalStateException -> L60
        L46:
            r128.removeAllViews();     // Catch: IllegalStateException -> L60
            r128.removeView(r124);     // Catch: IllegalStateException -> L60
            a1.j(r124, 8388627);     // Catch: IllegalStateException -> L60
            r128.addView(r124);     // Catch: IllegalStateException -> L60
            UtilityKotlinExtentionsKt.w(r128);     // Catch: IllegalStateException -> L60
            PlayerTipsContext r134 = r125.f107716g;     // Catch: IllegalStateException -> L60
            if (r134 == null) goto L51;
            Map<String, Boolean> r135 = r134.getShowMap();     // Catch: IllegalStateException -> L60
            if (r135 == null) goto L51;
            r135.put(r126, r131);     // Catch: IllegalStateException -> L60
        L51:
            r125.f107718i = r126;     // Catch: IllegalStateException -> L60
            PlayerTipsContext r136 = r125.f107716g;     // Catch: IllegalStateException -> L60
            if (r136 == null) goto L62;
            m<Boolean> r137 = r136.isTipsShowing();     // Catch: IllegalStateException -> L60
            if (r137 == null) goto L62;
            PlayerTipsContext r138 = r125.f107716g;     // Catch: IllegalStateException -> L60
            if (r138 == null) goto L58;
            r103 = r138.getPlayerTipShowing();     // Catch: IllegalStateException -> L60
        L58:
            r137.setValue(Boolean.valueOf(r103));     // Catch: IllegalStateException -> L60
        L60:
            e = move-exception;
            ALogger.e(r125.f107710a, "showCustomView", e);
            goto L62
        L103:
            return;
        L106:
            return;
        L6:
            if (r100.containerView == null) goto L22;
            if (PadConfigUtils.c() == false) goto L19;
            u r139 = r.u(r100.dataCenter, null, 2);
            if (r139 == null) goto L15;
            n<PadOrientation> r140 = r139.w();
            if (r140 == null) goto L15;
            PadOrientation r141 = r140.getValue();
        L17:
            if (r141 != PadOrientation.LANDSCAPE) goto L19;
        L15:
            r141 = null;
        L19:
            ALogger.d(r100.f107710a, "initTipsPositionIfNeed start");
            ViewGroup r142 = r100.containerView;
            if (r142 == null) goto L22;
            r142.post(new i(r100));
            goto L22
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VSRoomPlayTipsWidget f107728a;

        public e(VSRoomPlayTipsWidget r100) {
            this.f107728a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            String r101 = (String) r100;
            ALogger.w(this.f107728a.f107710a, "receive hide event for " + r101);
            VSRoomPlayTipsWidget r102 = this.f107728a;
            PlayerTipsContext r103 = r102.f107716g;
            if (r103 == null) goto L7;
            Map<String, Boolean> r104 = r103.getShowMap();
            if (r104 == null) goto L7;
            Boolean r105 = r104.get(r101);
        L8:
            if (r105 != null) goto L10;
        L26:
            ALogger.w(r102.f107710a, "[" + r101 + "] has already hide,skip");
            return;
        L10:
            if (r105.booleanValue() == false) goto L26;
            r102.xq();
            PlayerTipsContext r106 = r102.f107716g;
            if (r106 == null) goto L17;
            Map<String, Boolean> r107 = r106.getShowMap();
            if (r107 == null) goto L17;
            r107.put(r101, Boolean.FALSE);
        L17:
            PlayerTipsContext r108 = r102.f107716g;
            if (r108 == null) goto L28;
            m<Boolean> r109 = r108.isTipsShowing();
            if (r109 == null) goto L29;
            PlayerTipsContext r110 = r102.f107716g;
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

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.progressbar.VSRoomPlayTipsWidget$onLoad$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lzg1/i1;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lzg1/i1;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<i1, Unit> {
        public AnonymousClass4(VSRoomPlayTipsWidget r100) {
            super(1, r100, VSRoomPlayTipsWidget.class, "onLiveInputEvent", "onLiveInputEvent(Lcom/bytedance/android/livesdk/chatroom/event/LiveInputEvent;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(i1 r100) {
            Intrinsics.checkNotNullParameter(r100, "p1");
            VSRoomPlayTipsWidget r101 = (VSRoomPlayTipsWidget) this.receiver;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r100, "event");
            UtilityKotlinExtentionsKt.z(r101.containerView, !r100.f571850b);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(i1 r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_match_widget_player_tip;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        int r100 = this.f107723n;
        u r101 = r.u(this.dataCenter, null, 2);
        if (r101 == null) goto L11;
        m<Integer> r102 = r101.f();
        if (r102 == null) goto L11;
        if (r100 != r102.getValue().intValue()) goto L11;
        Disposable r103 = this.f107719j;
        if (r103 == null) goto L11;
        r103.dispose();
    L11:
        this.f107720k.clear();
        IVSPlayerService r104 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
        if (r104 == null) goto L16;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r105 = r104.provideVSPlayerViewControlService(this.dataCenter);
        if (r105 == null) goto L16;
        r105.c(PlayerViewControl.KEY.PlayTip);
    L16:
        this.f107721l = false;
    }

    public final void xq() {
        TextView r100 = this.f107712c;
        if (r100 != null) goto L5;
    L10:
        FrameLayout r101 = this.f107713d;
        if (r101 != null) goto L13;
        return;
    L13:
        if (r101.getVisibility() == 8) goto L17;
        r101.removeAllViews();
        UtilityKotlinExtentionsKt.u(r101);
        return;
    L17:
        return;
    L5:
        if (r100.getVisibility() == 8) goto L10;
        if (this.f107715f == null) goto L9;
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f}).setDuration(100);
        r102.addUpdateListener(new b(r100));
        r102.addListener(new c(r100, this));
        Unit r103 = Unit.INSTANCE;
        this.f107715f = r102;
        r102.start();
        goto L10
    L9:
        UtilityKotlinExtentionsKt.u(r100);
        goto L10
    }

    public VSRoomPlayTipsWidget() {
        this.f107710a = "VideoPlayTipsWidget[" + hashCode() + ']';
        this.f107717h = new CompositeDisposable();
        this.f107718i = "";
        this.f107720k = new CompositeDisposable();
        this.f107723n = 1;
    }

    public static final void wq(VSRoomPlayTipsWidget r100) {
        r100.getClass();
        if (PadConfigUtils.c() == false) goto L16;
        PadOrientation r101 = null;
        u r102 = r.u(r100.dataCenter, null, 2);
        if (r102 == null) goto L10;
        n<PadOrientation> r103 = r102.w();
        if (r103 == null) goto L10;
        r101 = r103.getValue();
    L10:
        if (r101 != PadOrientation.LANDSCAPE) goto L17;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r104 = ((IVSPlayerService) jc1.k.n(IVSPlayerService.class)).provideVSPlayerViewControlService(r100.dataCenter);
        if (r104 == null) goto L14;
        r104.setVisibilityStatus(true);
    L14:
        ALogger.d(r100.f107710a, "PadOrientation.LANDSCAPE,do show player control");
        return;
    L17:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.model.a
    public final boolean canControlByPlayer(PlayerViewControl.KEY r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (r100 != PlayerViewControl.KEY.PlayTip) goto L41;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r101 = ((IVSPlayerService) jc1.k.n(IVSPlayerService.class)).provideVSPlayerViewControlService(this.dataCenter);
        if (r101 == null) goto L7;
        Boolean r102 = Boolean.valueOf(r101.getVisibilityStatus());
    L8:
        IPlayerProgressService r103 = ((IVSPlayerService) jc1.k.n(IVSPlayerService.class)).provideVSProgressService(this.dataCenter);
        if (r103 == null) goto L17;
        PlayerProgressServiceContext r104 = r103.provideContext(this.dataCenter);
        if (r104 == null) goto L17;
        m<Boolean> r105 = r104.getVsRoomEnableSeek();
        if (r105 == null) goto L17;
        if (r105.getValue().booleanValue() != true) goto L17;
        boolean r106 = true;
    L19:
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.dataCenter).isPaidLive() == false) goto L21;
    L24:
        boolean r107 = true;
    L26:
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(this.dataCenter, true) == false) goto L32;
        if (r106 == true) goto L32;
        if (r107 == false) goto L32;
        if (Intrinsics.areEqual(r102, Boolean.TRUE) == false) goto L32;
        return false;
    L32:
        if (r106 == false) goto L41;
        PlayerProgressServiceContext r108 = this.f107722m;
        if (r108 == null) goto L41;
        m<Boolean> r109 = r108.isSeekbarOnTracking();
        if (r109 == null) goto L41;
        Boolean r110 = r109.getValue();
        if (r110 == null) goto L41;
        return !r110.booleanValue();
    L21:
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.dataCenter).Y0(PaidSceneEnum.ALL) == true) goto L24;
        r107 = false;
    L17:
        r106 = false;
        goto L19
    L7:
        r102 = null;
    L41:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r110) {
        ALogger.i(this.f107710a, "tipWidget start to load, dataCenter:" + this.dataCenter.hashCode());
        this.f107720k = new CompositeDisposable();
        String r100 = null;
        u r111 = r.u(this.dataCenter, null, 2);
        if (r111 == null) goto L9;
        m<Integer> r112 = r111.f();
        if (r112 == null) goto L9;
        Integer r113 = r112.getValue();
        if (r113 == null) goto L9;
        int r114 = r113.intValue();
    L10:
        this.f107723n = r114;
        this.f107714e = ((IVSPlayerService) jc1.k.n(IVSPlayerService.class)).provideVSPlayerTipService(this.dataCenter);
        IPlayerProgressService r115 = ((IVSPlayerService) jc1.k.n(IVSPlayerService.class)).provideVSProgressService(this.dataCenter);
        if (r115 == null) goto L13;
        PlayerProgressServiceContext r116 = r115.provideContext(this.dataCenter);
    L14:
        this.f107722m = r116;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.b r117 = this.f107714e;
        if (r117 == null) goto L17;
        PlayerTipsContext r118 = r117.provideVSPlayTipsContext();
    L18:
        this.f107716g = r118;
        this.f107712c = (TextView) findViewById(R.id.tv_tip_default);
        this.f107713d = (FrameLayout) findViewById(R.id.custom_tip_holder);
        IVSPlayerService r119 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
        if (r119 == null) goto L23;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r101 = r119.provideVSPlayerViewControlService(this.dataCenter);
        if (r101 == null) goto L23;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c.a.a(r101, PlayerViewControl.KEY.PlayTip, PlayerViewControl.Type.BOTTOM, PlayerViewControl.Style.ATTACH, this.containerView, 15.0f, true, false, this, 320);
    L23:
        int r120 = this.dataCenter.hashCode();
        Integer r102 = this.f107711b;
        String r103 = "";
        if (r102 != null) goto L26;
    L27:
        ALogger.w(this.f107710a, "dataCenter has change from [" + this.f107711b + "] to [" + r120 + "],tipWidget dispose");
        this.f107718i = "";
        xq();
        this.f107711b = Integer.valueOf(r120);
        this.f107717h.dispose();
        this.f107717h = new CompositeDisposable();
        PlayerTipsContext r121 = this.f107716g;
        if (r121 == null) goto L45;
        com.bytedance.live.datacontext.k<com.bytedance.android.livesdk.chatroom.progress.context.a> r122 = r121.getMShowPlayerTipEvent();
        if (r122 == null) goto L36;
        PublishSubject r123 = r122.onEvent();
        if (r123 == null) goto L36;
        Disposable r124 = r123.subscribe(new d(this));
        if (r124 == null) goto L36;
        RxUtilKt.c(r124, this.f107717h);
    L36:
        PlayerTipsContext r125 = this.f107716g;
        if (r125 == null) goto L45;
        com.bytedance.live.datacontext.k<String> r126 = r125.getMHidePlayerTipEvent();
        if (r126 == null) goto L45;
        PublishSubject r127 = r126.onEvent();
        if (r127 == null) goto L45;
        Disposable r128 = r127.subscribe(new e(this));
        if (r128 == null) goto L45;
        RxUtilKt.c(r128, this.f107717h);
    L45:
        DataCenter r129 = this.dataCenter;
        if (r129 == null) goto L48;
        Integer r130 = (Integer) r129.get("data_first_show_play_from", -1);
    L49:
        DataCenter r104 = this.dataCenter;
        if (r104 == null) goto L52;
        r104.put("data_first_show_play_from", -1);
    L52:
        if (r130 != null) goto L54;
    L97:
        RxUtilKt.c(xs2.b.a().b(i1.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(new AnonymousClass4(this))), this.f107720k);
        return;
    L54:
        if (r130.intValue() == (-1)) goto L97;
        if (r130.intValue() != 1) goto L97;
        u r105 = r.u(this.dataCenter, null, 2);
        if (r105 == null) goto L66;
        m<Boolean> r106 = r105.A();
        if (r106 == null) goto L66;
        if (r106.getValue().booleanValue() == true) goto L97;
    L66:
        DataCenter r107 = this.dataCenter;
        if (r107 == null) goto L69;
        com.bytedance.android.livesdk.chatroom.progressbar.highlight.b r108 = (com.bytedance.android.livesdk.chatroom.progressbar.highlight.b) r107.get("data_vs_highlight_tips_params", null);
    L70:
        Ref.ObjectRef r109 = new Ref.ObjectRef();
        r109.element = "";
        if (r130.intValue() != 2) goto L74;
        r109.element = "from_history";
        r103 = s1.B(R.string.ttlive_first_show_play_from_history);
    L84:
        com.bytedance.android.livesdk.chatroom.vsplayer.api.b r131 = ((IVSPlayerService) jc1.k.n(IVSPlayerService.class)).provideVSPlayerTipService(this.dataCenter);
        if (r131 == null) goto L88;
        r131.hidePlayerTip((String) r109.element);
        r131.showPlayerTip((String) r109.element, r103, false);
    L88:
        if (r108 == null) goto L90;
        long r132 = r108.f107760b;
    L92:
        if (r132 <= 0) goto L95;
        if (r108 == null) goto L95;
        long r133 = r108.f107760b;
    L96:
        this.f107719j = Observable.timer(r133, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new k(this, r109));
    L95:
        r133 = KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL;
        goto L96
    L90:
        r132 = 0;
        goto L92
    L74:
        if (r130.intValue() != 1) goto L84;
        r109.element = "from_highlight";
        if (r108 == null) goto L79;
        r100 = r108.f107759a;
    L79:
        if (TextUtils.isEmpty(r100) == true) goto L83;
        if (r108 == null) goto L83;
        r103 = r108.f107759a;
        if (r103 != null) goto L84;
    L83:
        r103 = "正在播放精彩看点片段";
        goto L84
    L69:
        r108 = null;
        goto L70
    L48:
        r130 = null;
        goto L49
    L26:
        if (r102.intValue() == r120) goto L45;
    L17:
        r118 = null;
        goto L18
    L13:
        r116 = null;
    L9:
        r114 = 1;
        goto L10
    }
}
