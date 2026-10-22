package com.bytedance.android.livesdk.chatroom.playback4live.tetris;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.core.element.widget.WidgetElement;
import com.bytedance.android.live.core.tetris.layer.core.tetris.LiveTetris;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.platformplayer.playback.LiveProgressBarWidget;
import com.bytedance.android.live.room.api.IVisibilityControlBrickService;
import com.bytedance.android.live.room.api.IVisibilityControlService;
import com.bytedance.android.live.room.api.visibilitycontrol.LiveVisibilityControlContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.playback4live.widget.LivePlayerControlWidget;
import com.bytedance.android.livesdk.chatroom.utils.h1;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/playback4live/tetris/LivePlaybackTetris;", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/LiveTetris;", "Ld90/a;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePlaybackTetris extends LiveTetris<d90.a> {
    public static final /* synthetic */ int C = 0;
    public WidgetElement A;
    public WidgetElement B;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public FrameLayout f107580o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public FrameLayout f107581p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public LinearLayout f107582q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public IVisibilityControlService f107583r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final CompositeDisposable f107584s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Disposable f107585t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f107586u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f107587v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final float f107588w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final float f107589x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final float f107590y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f107591z;

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f107592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f107593b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            ALogger.d(LiveVisibilityControlContext.timerTag, "PlayerProgressBarTetris.kt # alphaAnimate #  anim end listener");
            if (this.f107593b == true) goto L6;
            this.f107592a.setVisibility(8);
            return;
        }

        public b(View r100, boolean r101) {
            this.f107592a = r100;
            this.f107593b = r101;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LivePlaybackTetris f107594a;

        public c(LivePlaybackTetris r100) {
            this.f107594a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            if (((Boolean) r100).booleanValue() == false) goto L5;
            LivePlaybackTetris r101 = this.f107594a;
            int r102 = LivePlaybackTetris.C;
            r101.Z();
            return;
        L5:
            LivePlaybackTetris r103 = this.f107594a;
            int r104 = LivePlaybackTetris.C;
            r103.getClass();
            ALogger.d("LivePlaybackTetris", "detachWidget");
            WidgetElement r105 = r103.A;
            if (r105 == null) goto L8;
            r103.S(r105);
        L8:
            WidgetElement r106 = r103.B;
            if (r106 == null) goto L11;
            r103.S(r106);
        L11:
            FrameLayout r107 = r103.f107581p;
            if (r107 == null) goto L14;
            r107.setVisibility(8);
        L14:
            FrameLayout r108 = r103.f107580o;
            if (r108 == null) goto L19;
            r108.setVisibility(8);
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LivePlaybackTetris f107595a;

        public d(LivePlaybackTetris r100) {
            this.f107595a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            if (((Boolean) r100).booleanValue() == false) goto L24;
            LivePlaybackTetris r101 = this.f107595a;
            if (r101.f107591z == true) goto L25;
            r101.f107591z = true;
            if (LivePlaybackTetris.V(r101) == false) goto L9;
            return;
        L9:
            if (d90.c.i((d90.a) this.f107595a.K()) == false) goto L27;
            LinearLayout r102 = this.f107595a.f107582q;
            ViewGroup.LayoutParams r103 = null;
            if (r102 == null) goto L13;
            ViewGroup.LayoutParams r104 = r102.getLayoutParams();
        L15:
            if ((r104 instanceof ConstraintLayout.LayoutParams) == false) goto L18;
            r103 = r104;
        L18:
            ConstraintLayout.LayoutParams r105 = (ConstraintLayout.LayoutParams) r103;
            if (r105 == null) goto L28;
            ((ViewGroup.MarginLayoutParams) r105).rightMargin = s1.f(this.f107595a.f107590y);
            ((ViewGroup.MarginLayoutParams) r105).bottomMargin = s1.f(this.f107595a.f107588w);
            LinearLayout r106 = this.f107595a.f107582q;
            if (r106 == null) goto L29;
            r106.setLayoutParams(r105);
            return;
        L29:
            return;
        L28:
            return;
        L13:
            r104 = null;
            goto L15
        L27:
            return;
        L25:
            return;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void O() {
        h1.a r100 = h1.f114487b;
        DataCenter r101 = ((d90.a) K()).f467480h;
        r100.getClass();
        LiveVisibilityControlContext r102 = h1.a.f(r101);
        if (r102 != null) goto L5;
    L7:
        LiveVisibilityControlContext.Companion.getClass();
        if (LiveVisibilityControlContext.a.a() == false) goto L45;
        LiveVisibilityControlContext r103 = h1.a.f(((d90.a) K()).f467480h);
        if (r103 == null) goto L19;
        m<Boolean> r104 = r103.getEnablePlaybackMutable();
        if (r104 == null) goto L19;
        Observable<Boolean> r105 = r104.a();
        if (r105 == null) goto L19;
        Disposable r106 = r105.subscribe(new c(this));
        if (r106 == null) goto L19;
        RxUtilKt.c(r106, this.f107584s);
    L19:
        if (d90.c.i((d90.a) K()) == false) goto L38;
        IVisibilityControlService r107 = a0();
        if (r107 == null) goto L29;
        LiveVisibilityControlContext r108 = r107.provideContext();
        if (r108 == null) goto L29;
        m<Boolean> r109 = r108.getPlaybackVisibleMutable();
        if (r109 == null) goto L29;
        Disposable r110 = i80.a.a(r109, new LivePlaybackTetris$onViewCreated$2(this));
        if (r110 == null) goto L29;
        RxUtilKt.c(r110, this.f107584s);
    L29:
        RoomContext r111 = RoomContext.a.c(RoomContext.Companion, ((d90.a) K()).f467480h, 0, 2);
        if (r111 == null) goto L46;
        m<Boolean> r112 = r111.isCleanMode();
        if (r112 == null) goto L47;
        Observable<Boolean> r113 = r112.a();
        if (r113 == null) goto L48;
        Disposable r114 = r113.subscribe(new d(this));
        if (r114 == null) goto L49;
        RxUtilKt.c(r114, this.f107584s);
        return;
    L49:
        return;
    L48:
        return;
    L47:
        return;
    L46:
        return;
    L38:
        FrameLayout r115 = this.f107581p;
        if (r115 == null) goto L41;
        r115.setVisibility(0);
    L41:
        FrameLayout r116 = this.f107580o;
        if (r116 == null) goto L51;
        r116.setVisibility(0);
        return;
    L51:
        return;
    L45:
        return;
    L5:
        if (r102.enablePlayBackAbility() != true) goto L7;
        Z();
        goto L7
    }

    public final void Z() {
        ALogger.d("LivePlaybackTetris", "attachWidget");
        FrameLayout r100 = this.f107581p;
        if (r100 == null) goto L9;
        com.bytedance.android.live.platformplayer.service.a r101 = (com.bytedance.android.live.platformplayer.service.a) k.f(com.bytedance.android.live.platformplayer.service.a.class);
        if (r101 == null) goto L9;
        LiveProgressBarWidget r102 = r101.u1();
        if (r102 == null) goto L9;
        this.A = LiveTetris.R(this, r102, r100);
    L9:
        FrameLayout r103 = this.f107580o;
        if (r103 == null) goto L13;
        this.B = LiveTetris.Q(this, LivePlayerControlWidget.class, r103, false, null, 24);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final IVisibilityControlService a0() {
        if (this.f107583r != null) goto L10;
        IVisibilityControlBrickService r100 = (IVisibilityControlBrickService) k.f(IVisibilityControlBrickService.class);
        if (r100 == null) goto L7;
        IVisibilityControlService r101 = r100.provideVisibilityControlService(((d90.a) K()).f467480h);
    L8:
        this.f107583r = r101;
        goto L10
    L7:
        r101 = null;
    L10:
        return this.f107583r;
    }

    public LivePlaybackTetris() {
        this.f107584s = new CompositeDisposable();
        this.f107587v = 200;
        this.f107588w = 60.0f;
        this.f107589x = 10.0f;
        this.f107590y = 12.0f;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void onDestroy() {
        super.onDestroy();
        this.f107584s.clear();
        Disposable r100 = this.f107585t;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDisposed() == true) goto L11;
        Disposable r101 = this.f107585t;
        if (r101 == null) goto L12;
        r101.dispose();
        return;
    L12:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean V(LivePlaybackTetris r100) {
        r100.getClass();
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, ((d90.a) r100.K()).f467480h, 0, 2);
        if (r101 == null) goto L11;
        n<Function0<Boolean>> r102 = r101.isStreamHorizontal();
        if (r102 == null) goto L11;
        Function0<Boolean> r103 = r102.getValue();
        if (r103 == null) goto L11;
        if (r103.invoke().booleanValue() != true) goto L11;
        return true;
    L11:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final View G(t70.k r100) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r101 = r100.b(R.layout.ttlive_live_tetris_progress_bar_layout);
        this.f107580o = (FrameLayout) r101.findViewById(R.id.live_play_control_container);
        this.f107581p = (FrameLayout) r101.findViewById(R.id.live_progress_container);
        this.f107582q = (LinearLayout) r101.findViewById(R.id.bottom_container);
        this.f107591z = false;
        this.f107586u = false;
        DataCenter r102 = ((d90.a) K()).f467480h;
        ViewGroup.LayoutParams r103 = null;
        if (r102 != null) goto L5;
    L19:
        LinearLayout r104 = this.f107582q;
        if (r104 == null) goto L22;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
    L24:
        if ((r105 instanceof ConstraintLayout.LayoutParams) == false) goto L27;
        r103 = r105;
    L27:
        ConstraintLayout.LayoutParams r106 = (ConstraintLayout.LayoutParams) r103;
        if (r106 == null) goto L32;
        ((ViewGroup.MarginLayoutParams) r106).leftMargin = s1.f(0.0f);
        ((ViewGroup.MarginLayoutParams) r106).rightMargin = s1.f(0.0f);
        LinearLayout r107 = this.f107582q;
        if (r107 == null) goto L32;
        r107.setLayoutParams(r106);
    L32:
        return r101;
    L22:
        r105 = null;
        goto L24
    L5:
        if (z.m(r102, true) == true) goto L19;
        LinearLayout r108 = this.f107582q;
        if (r108 == null) goto L9;
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
    L11:
        if ((r109 instanceof ConstraintLayout.LayoutParams) == false) goto L14;
        r103 = r109;
    L14:
        ConstraintLayout.LayoutParams r110 = (ConstraintLayout.LayoutParams) r103;
        if (r110 == null) goto L32;
        ((ViewGroup.MarginLayoutParams) r110).leftMargin = s1.f(this.f107589x);
        ((ViewGroup.MarginLayoutParams) r110).rightMargin = s1.f(this.f107589x);
        LinearLayout r111 = this.f107582q;
        if (r111 == null) goto L32;
        r111.setLayoutParams(r110);
        goto L32
    L9:
        r109 = null;
        goto L11
    }

    public final void W(View r100, boolean r101) {
        if (r101 == true) goto L4;
    L6:
        if (r101 == false) goto L8;
    L10:
        if (r101 == false) goto L12;
        r100.setVisibility(0);
    L12:
        ViewPropertyAnimator r102 = r100.animate();
        if (r102 == null) goto L24;
        if (r101 == false) goto L16;
        float r103 = 1.0f;
    L17:
        ViewPropertyAnimator r104 = r102.alpha(r103);
        if (r104 == null) goto L24;
        ViewPropertyAnimator r105 = r104.setDuration(this.f107587v);
        if (r105 == null) goto L24;
        ViewPropertyAnimator r106 = r105.setListener(new b(r100, r101));
        if (r106 == null) goto L24;
        r106.start();
        goto L24
    L16:
        r103 = 0.0f;
    L24:
        ALogger.d(LiveVisibilityControlContext.timerTag, "PlayerProgressBarTetris.kt # alphaAnimate # start anim");
        return;
    L8:
        if (r100.getVisibility() != 8) goto L10;
        return;
    L4:
        if (r100.getVisibility() != 0) goto L6;
    }
}
