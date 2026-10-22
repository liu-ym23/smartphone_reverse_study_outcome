package com.bytedance.android.live.broadcastgame.opengame.panel;

import android.R;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.android.live.broadcastgame.opengame.runtime.LiveBasePluginWithPanel$initPanelAndHide$3;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.runtime.s;
import com.bytedance.android.live.broadcastgame.opengame.runtime.t;
import com.bytedance.android.live.broadcastgame.opengame.service.TrackMiniGameService;
import com.bytedance.android.live.broadcastgame.opengame.view.PanelTopRightButtonView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.statusbar.IESStatusBarUtil;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.t8;
import com.bytedance.android.livesdk.widget.roundcorner.RoundCornerConstraintLayout;
import com.bytedance.android.livesdkapi.model.InnerContextEntity;
import com.bytedance.android.livesdkapi.service.ILiveVideoFloatWindowService;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttm.player.MediaPlayer;
import io.reactivex.subjects.PublishSubject;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import zg1.h1;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\"\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/panel/FullScreenOpenPanel;", "Landroidx/fragment/app/FragmentActivity;", "Lcom/bytedance/android/live/broadcastgame/opengame/panel/g;", "Lcom/bytedance/android/live/broadcastgame/opengame/runtime/s;", "Lcom/bytedance/android/live/broadcastgame/opengame/panel/i;", "Landroid/content/Intent;", "intent", "", "requestCode", "Landroid/os/Bundle;", "options", "", "startActivityForResult", "Landroid/view/View;", "view", "addTopRightBtnView", "addTopMessageView", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FullScreenOpenPanel extends FragmentActivity implements g, s<i> {
    public static final AtomicInteger E = null;
    public static final HashMap<Integer, WeakReference<FullScreenOpenPanel>> F = null;
    public static final HashSet<Integer> G = null;
    public static final PublishSubject H = null;
    public boolean A;
    public View.OnClickListener B;
    public PanelType C;
    public final /* synthetic */ t<i> D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f60601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f60602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f60603c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f60604d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RoundCornerConstraintLayout f60605e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewGroup f60606f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup f60607g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LiveDoubleColorBallAnimationView f60608h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewGroup f60609i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f60610j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ViewGroup f60611k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PanelTopRightButtonView f60612l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ViewGroup f60613m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f60614n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f60615o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f60616p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f60617q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f60618r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f60619s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f60620t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f60621u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f60622v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public PluginContext f60623w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f60624x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f60625y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f60626z;

    public static final class a {
    }

    public static final class b implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f60627a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
        }

        public b(Function0 r100) {
            this.f60627a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            this.f60627a.invoke();
        }
    }

    public static final class c implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f60628a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
        }

        public c(Function0 r100) {
            this.f60628a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            this.f60628a.invoke();
        }
    }

    public final long B1() {
        return ((Number) this.f60603c.getValue()).longValue();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void F() {
    }

    public final boolean F1() {
        return ((Boolean) this.f60604d.getValue()).booleanValue();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final Context J() {
        return this;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void hide() {
        D1(true);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        this.f60614n = true;
        i r100 = A1();
        if (r100 == null) goto L6;
        r100.onBackPressed();
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void u0(Bitmap r100) {
        Intrinsics.checkNotNullParameter(r100, "background");
    }

    static {
        E = new AtomicInteger(0);
        F = new HashMap();
        G = new HashSet();
        H = PublishSubject.create();
    }

    public final i A1() {
        return this.D.f60846b;
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(FullScreenOpenPanel.class.getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L45
        if (r103 != null) goto L10;
    L13:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L45
        monitor-exit(r102);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
    L19:
        if (isFinishing() == true) goto L22;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r104 == null) goto L48;
        r104.addFlags(268435456);     // Catch: Throwable -> L42
        r104.addFlags(2097152);     // Catch: Throwable -> L42
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r104);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.s
    public final List<i> getListeners() {
        return this.D.f60845a;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final PanelType getPanelType() {
        PanelType r100 = this.C;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return PanelType.PANEL_TYPE_X_SCREEN;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void h() {
        UtilityKotlinExtentionsKt.s(0, false, false, new FullScreenOpenPanel$showDoubleBallLoading$1(this), 7);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final ViewGroup h0() {
        ViewGroup r100 = this.f60611k;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topRightBtnContainer");
    L5:
        return r100;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void i() {
        UtilityKotlinExtentionsKt.s(0, false, false, new FullScreenOpenPanel$hideDoubleBallLoading$1(this), 7);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void init() {
        int r100 = q.f60744a;
        q.f("FullScreenOpenPanel", new Object[]{"init, do nothing"});
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        int r100 = q.f60744a;
        q.f("FullScreenOpenPanel", new Object[]{"onDestroy, remove record"});
        int r101 = ((Number) this.f60602b.getValue()).intValue();
        G.add(Integer.valueOf(r101));
        F.remove(Integer.valueOf(r101));
        i r102 = A1();
        if (r102 == null) goto L5;
        r102.b();
    L5:
        RoundCornerConstraintLayout r103 = this.f60605e;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L8:
        r103.clearAnimation();
        C1(false);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        int r100 = q.f60744a;
        q.f("FullScreenOpenPanel", new Object[]{"onStop, isShowing: " + this.f60614n});
        boolean r101 = this.f60614n;
        Function0<Unit> r102 = new C98741(this);
        if (r101 != true) goto L5;
        r102.invoke();
    L5:
        this.f60614n = false;
        this.A = false;
        if (isFinishing() == true) goto L10;
        InteractGameContext r103 = InteractGameContext.Companion.getContext();
        if (r103 == null) goto L10;
        r103.setGameFullPanelIsShowing(false);
    L10:
        super.onStop();
        if (isFinishing() == false) goto L16;
        InteractGameContext r104 = InteractGameContext.Companion.getContext();
        if (r104 == null) goto L16;
        r104.setGameFullPanelIsShowing(false);
    L16:
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L22;
        y1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L19
        return;
    L23:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void show() {
        boolean r100 = this.f60614n;
        Function0<Unit> r101 = new C98751(this);
        if (r100 == true) goto L5;
        r101.invoke();
        Boolean r102 = Boolean.FALSE;
    L6:
        if (r102 == null) goto L17;
        r102.booleanValue();
        if (isDestroyed() == false) goto L10;
        return;
    L10:
        if (getLifecycle().getCurrentState() == Lifecycle.State.RESUMED) goto L19;
        InteractGameContext r103 = InteractGameContext.Companion.getContext();
        if (r103 == null) goto L15;
        r103.setGameFullPanelIsShowing(true);
    L15:
        int r104 = q.f60744a;
        q.f("FullScreenOpenPanel", new Object[]{"move activity to front"});
        Application r105 = jc1.a.b();
        Function1<Intent, Unit> r106 = new AnonymousClass2(this);
        Intent r107 = new Intent(r105, FullScreenOpenPanel.class);
        r107.addFlags(268435456);
        r106.invoke(r107);
        Unit r108 = Unit.INSTANCE;
        r105.startActivity(r107);
        ((ShowTipsHelper) this.f60626z.getValue()).b();
        return;
    L19:
        return;
    L17:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public FullScreenOpenPanel() {
        this.D = new t();
        this.f60601a = new LinkedHashMap();
        this.f60602b = LazyKt.lazy(new FullScreenOpenPanel$token$2(this));
        this.f60603c = LazyKt.lazy(new FullScreenOpenPanel$roomId$2(this));
        this.f60604d = LazyKt.lazy(new FullScreenOpenPanel$isAnchor$2(this));
        this.f60618r = "";
        this.f60619s = "";
        this.f60620t = "";
        this.f60621u = "";
        this.f60622v = "";
        this.f60624x = LazyKt.lazy(new FullScreenOpenPanel$enterAnimation$2(this));
        this.f60625y = LazyKt.lazy(new FullScreenOpenPanel$outAnimation$2(this));
        this.f60626z = LazyKt.lazy(new FullScreenOpenPanel$showTipsHelper$2(this));
    }

    public final void G1() {
        if (F1() == false) goto L5;
        return;
    L5:
        if (this.f60615o == true) goto L10;
        this.f60615o = true;
        ILiveVideoFloatWindowService r100 = (ILiveVideoFloatWindowService) jc1.k.n(ILiveVideoFloatWindowService.class);
        InnerContextEntity.InnerFloatExtra r101 = new InnerContextEntity.InnerFloatExtra();
        r101.setRequestPage("open_game_page");
        r101.setEnterRoomId(Long.valueOf(B1()));
        r101.setFinishOnClick(false);
        r101.setOnClickListener(new FullScreenOpenPanel$showFloatWindow$$inlined$apply$lambda$1(this));
        Unit r102 = Unit.INSTANCE;
        r100.startShowFloat(this, r101);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void L0() {
        i();
        ViewGroup r100 = this.f60607g;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("retryLayout");
    L5:
        UtilityKotlinExtentionsKt.w(r100);
        TextView r101 = this.f60610j;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("retryBtn");
    L8:
        UtilityKotlinExtentionsKt.w(r101);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final ViewGroup getContentView() {
        return (ViewGroup) _$_findCachedViewById(com.larus.nova.R.id.hybrid_content);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        int r100 = q.f60744a;
        q.f("FullScreenOpenPanel", new Object[]{"onPause"});
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        int r100 = q.f60744a;
        q.f("FullScreenOpenPanel", new Object[]{"onResume"});
        RoundCornerConstraintLayout r101 = this.f60605e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        UtilityKotlinExtentionsKt.z(r101, true);
        PanelType r102 = this.C;
        PanelType r103 = PanelType.PANEL_TYPE_LANDSCAPE;
        if (r102 != r103) goto L11;
        if (getRequestedOrientation() == 0) goto L11;
        H1(r103, true);
    L17:
        z1(this.C);
        this.f60616p = false;
        final Ref.BooleanRef r104 = new Ref.BooleanRef();
        r104.element = true;
        boolean r105 = this.f60614n;
        Function0<Unit> r106 = new AnonymousClass1(this, r104);
        if (r105 == true) goto L20;
        r106.invoke();
    L20:
        Function0<Unit> r107 = new FullScreenOpenPanel$onResume$checkFloatWindowShow$1(this);
        if (r104.element == true) goto L23;
        return;
    L23:
        this.f60614n = true;
        q.g("onResume", "FullScreenOpenPanel");
        if (((Animation) this.f60624x.getValue()).hasStarted() == true) goto L26;
    L28:
        ((Animation) this.f60624x.getValue()).reset();
        Animation r108 = (Animation) this.f60624x.getValue();
        if (r108 == null) goto L31;
        r108.setAnimationListener(new c(r107));
    L31:
        RoundCornerConstraintLayout r109 = this.f60605e;
        if (r109 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L34:
        r109.startAnimation((Animation) this.f60624x.getValue());
        return;
    L26:
        if (((Animation) this.f60624x.getValue()).hasEnded() == true) goto L28;
        return;
    L11:
        if (this.C == r103) goto L17;
        if (getRequestedOrientation() == 1) goto L17;
        PanelType r110 = this.C;
        if (r110 == null) goto L17;
        H1(r110, true);
        goto L17
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        int r100 = q.f60744a;
        q.f("FullScreenOpenPanel", new Object[]{WidgetCostModule.TYPE_ON_START});
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final Window v0() {
        return getWindow();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final OpenPanelType c() {
        return OpenPanelType.FULL_SCREEN_OPEN_PANEL;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void dismiss() {
        finish();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final boolean isShowing() {
        return this.f60614n;
    }

    public static View y1(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, com.bytedance.android.live.broadcastgame.opengame.panel.i, java.lang.Object] */
    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.s
    public final void C(i r100) {
        i r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "delegate");
        this.D.f60846b = r101;
    }

    public final void C1(boolean r100) {
        if (F1() == false) goto L5;
        return;
    L5:
        if (this.f60615o == false) goto L17;
        ((ILiveVideoFloatWindowService) jc1.k.n(ILiveVideoFloatWindowService.class)).stopShowFloat();
        if (r100 == false) goto L14;
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, null, B1(), 1);
        if (r101 == null) goto L14;
        if (r101.isCleared() == true) goto L14;
        xs2.b.a().post(new h1(42));
    L14:
        this.f60615o = false;
        return;
    }

    public final void D1(boolean r100) {
        boolean r101 = this.f60614n;
        Function0<Unit> r102 = new FullScreenOpenPanel$hidePanel$1(this);
        boolean r103 = true;
        if (r101 != true) goto L5;
        r102.invoke();
        Boolean r104 = Boolean.FALSE;
    L6:
        if (r104 == null) goto L33;
        r104.booleanValue();
        if (this.C != PanelType.PANEL_TYPE_LANDSCAPE) goto L10;
        setRequestedOrientation(1);
    L10:
        K1(false);
        if (isFinishing() == false) goto L13;
    L15:
        r103 = false;
    L16:
        C1(r103);
        Function0<Unit> r105 = new FullScreenOpenPanel$hidePanel$moveToBack$1(this);
        if (r100 == true) goto L21;
        r105.invoke();
        return;
    L21:
        if (((Animation) this.f60625y.getValue()).hasStarted() == true) goto L23;
    L25:
        ((Animation) this.f60625y.getValue()).reset();
        ((Animation) this.f60625y.getValue()).setAnimationListener(new b(r105));
        RoundCornerConstraintLayout r106 = this.f60605e;
        if (r106 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L28:
        r106.clearAnimation();
        RoundCornerConstraintLayout r107 = this.f60605e;
        if (r107 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L31:
        r107.startAnimation((Animation) this.f60625y.getValue());
        ((ShowTipsHelper) this.f60626z.getValue()).a();
        return;
    L23:
        if (((Animation) this.f60625y.getValue()).hasEnded() == true) goto L25;
        return;
    L13:
        if (isDestroyed() == true) goto L15;
    L33:
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void K(boolean r100) {
        PanelTopRightButtonView r101 = this.f60612l;
        if (r101 == null) goto L6;
        r101.setTopRightTheme(r100);
        return;
    }

    public final void K1(boolean r110) {
        if (r110 == true) goto L7;
        PanelType r111 = this.C;
        if (r111 == PanelType.PANEL_TYPE_LANDSCAPE) goto L7;
        if (r111 == PanelType.PANEL_TYPE_PORTRAIT) goto L7;
        return;
    L7:
        TrackMiniGameService.a r112 = TrackMiniGameService.f60990g;
        String r100 = String.valueOf(B1());
        boolean r101 = F1();
        String r102 = this.f60618r;
        String r103 = this.f60619s;
        String r104 = this.f60620t;
        String r105 = this.f60621u;
        String r106 = this.f60622v;
        String r107 = String.valueOf((System.currentTimeMillis() - this.f60617q) / ((long) 1000));
        r112.getClass();
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r102, "anchorId");
        Intrinsics.checkNotNullParameter(r103, "userId");
        Intrinsics.checkNotNullParameter(r104, "gameId");
        Intrinsics.checkNotNullParameter(r105, "gameName");
        Intrinsics.checkNotNullParameter(r106, "gameCategory");
        Intrinsics.checkNotNullParameter(r107, "duration");
        com.bytedance.android.livesdk.log.g r113 = u.l();
        Map<String, String> r108 = TrackMiniGameService.a.b(r102, r103, r104, r105, r106, r100, Boolean.valueOf(r101), MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_FRAME_COUNT);
        r108.put("duration", r107);
        Unit r114 = Unit.INSTANCE;
        r113.sendLog("livesdk_game_full_screen_duration", r108, new Object[0]);
    }

    public final void L1(PanelType r110) {
        int r111 = com.bytedance.android.live.broadcastgame.opengame.panel.c.f60678c[r110.ordinal()];
        if (r111 != 1) goto L5;
    L18:
        this.f60617q = System.currentTimeMillis();
        TrackMiniGameService.a r112 = TrackMiniGameService.f60990g;
        String r100 = String.valueOf(B1());
        boolean r101 = F1();
        String r102 = this.f60618r;
        String r103 = this.f60619s;
        String r104 = this.f60620t;
        String r105 = this.f60621u;
        String r106 = this.f60622v;
        r112.getClass();
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r102, "anchorId");
        Intrinsics.checkNotNullParameter(r103, "userId");
        Intrinsics.checkNotNullParameter(r104, "gameId");
        Intrinsics.checkNotNullParameter(r105, "gameName");
        Intrinsics.checkNotNullParameter(r106, "gameCategory");
        u.l().sendLog("livesdk_game_full_screen_show", TrackMiniGameService.a.b(r102, r103, r104, r105, r106, r100, Boolean.valueOf(r101), MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_FRAME_COUNT), new Object[0]);
        return;
    L5:
        if (r111 == 2) goto L18;
        if (r111 != 3) goto L9;
    L11:
        TrackMiniGameService.a r113 = TrackMiniGameService.f60990g;
        String r107 = String.valueOf(B1());
        boolean r108 = F1();
        String r109 = this.f60618r;
        String r114 = this.f60619s;
        String r115 = this.f60620t;
        String r116 = this.f60621u;
        String r117 = this.f60622v;
        PluginContext r118 = this.f60623w;
        if (r118 == null) goto L16;
        com.bytedance.android.live.broadcastgame.opengame.t r119 = r118.f60809m;
        if (r119 == null) goto L16;
        String r120 = r119.f61083i;
    L17:
        r113.getClass();
        TrackMiniGameService.a.c(r107, r108, r109, r114, r115, r116, r117, r120);
        return;
    L16:
        r120 = null;
        goto L17
    L9:
        if (r111 == 4) goto L11;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void M(int r100) {
        if (r100 != 0) goto L8;
        ViewGroup r101 = this.f60613m;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("topMessageContainer");
    L7:
        UIUtils.setViewVisibility(r101, 0);
        return;
    L8:
        ViewGroup r102 = this.f60613m;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("topMessageContainer");
    L11:
        UIUtils.setViewVisibility(r102, 8);
    }

    public final void M1(PanelType r100) {
        int r101 = UtilityKotlinExtentionsKt.i(12);
        ViewGroup r102 = this.f60611k;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topRightBtnContainer");
    L5:
        int r103 = com.bytedance.android.live.broadcastgame.opengame.panel.c.f60677b[r100.ordinal()];
        if (r103 != 1) goto L8;
        RoundCornerConstraintLayout r104 = this.f60605e;
        if (r104 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L26:
        r104.J(0, 0, 0, 0);
        r101 = r101 + s1.A();
    L27:
        a1.o(r102, r101);
        return;
    L8:
        if (r103 != 2) goto L10;
    L19:
        RoundCornerConstraintLayout r105 = this.f60605e;
        if (r105 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L22:
        r105.J(UtilityKotlinExtentionsKt.i(12), 0, UtilityKotlinExtentionsKt.i(12), 0);
        goto L27
    L10:
        if (r103 == 3) goto L19;
        if (r103 != 4) goto L18;
        RoundCornerConstraintLayout r106 = this.f60605e;
        if (r106 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L16:
        r106.J(0, 0, 0, 0);
        goto L27
    L18:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void V(boolean r100) {
        if (r100 == false) goto L8;
        RoundCornerConstraintLayout r101 = this.f60605e;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L7:
        r101.setBackground(new ColorDrawable(ColorProtector.parseColor("#161616")));
        return;
    L8:
        RoundCornerConstraintLayout r102 = this.f60605e;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L11:
        r102.setBackground(new ColorDrawable(-16777216));
    }

    public final View _$_findCachedViewById(int r100) {
        if (this.f60601a != null) goto L5;
        this.f60601a = new LinkedHashMap();
    L5:
        View r101 = this.f60601a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f60601a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public void addTopMessageView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        ViewGroup r101 = this.f60613m;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topMessageContainer");
    L5:
        r101.addView(r100);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public void addTopRightBtnView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if ((r100 instanceof PanelTopRightButtonView) == true) goto L5;
        View r101 = null;
    L6:
        PanelTopRightButtonView r102 = (PanelTopRightButtonView) r101;
        if (r102 == null) goto L9;
        this.f60612l = r102;
    L9:
        ViewGroup r103 = this.f60611k;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("topRightBtnContainer");
    L12:
        r103.addView(r100);
        return;
    L5:
        r101 = r100;
        goto L6
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void i1(boolean r100) {
        int r101 = q.f60744a;
        q.g("FullScreenOpenPanel", "全屏的面板不需要处理圆角的变化 -- 因为圆角要一直展示");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L17
        if (dc9.d.a() == true) goto L19;
        int r101 = getRequestedOrientation();     // Catch: Throwable -> L17
        if (r100 == null) goto L8;
        Integer r102 = Integer.valueOf(r100.orientation);     // Catch: Throwable -> L17
    L9:
        if (r102 != null) goto L12;
    L14:
        if (r101 != 3) goto L19;
        setRequestedOrientation(1);     // Catch: Throwable -> L17
        FLogger.f375446a.i("PadLancet", "onConfigurationChanged, phone reset page:FullScreenOpenPanel portrait");     // Catch: Throwable -> L17
        goto L19
    L12:
        if (r102.intValue() == r101) goto L19;
    L8:
        r102 = null;
    L19:
        PanelType.a r103 = PanelType.Companion;
        PanelType r104 = this.C;
        r103.getClass();
        if (PanelType.a.a(r104) == true) goto L22;
        return;
    L22:
        if (r100.orientation != 2) goto L28;
        G1();
        return;
    L28:
        return;
    L17:
        th = move-exception;
        FLogger.f375446a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
        goto L19
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r100);
        int r101 = q.f60744a;
        q.f("FullScreenOpenPanel", new Object[]{"onCreate, init view and notify panel created"});
        com.bytedance.android.live.broadcastgame.opengame.runtime.u.a(this, i.class);
        overridePendingTransition(0, 0);
        setContentView(com.larus.nova.R.layout.ttlive_open_platform_full_panel_container);
        getWindow().setGravity(80);
        getWindow().setLayout(-1, -1);
        getWindow().setDimAmount(0.0f);
        if (Build.VERSION.SDK_INT < 28) goto L13;
        WindowManager.LayoutParams r102 = getWindow().getAttributes();
        r102.layoutInDisplayCutoutMode = 1;
        getWindow().setAttributes(r102);
    L13:
        y1(getWindow()).post(new f(this));
        IESStatusBarUtil.transparencyBar(this);
        this.f60605e = (RoundCornerConstraintLayout) _$_findCachedViewById(com.larus.nova.R.id.game_interact_panel_layout);
        this.f60606f = (ViewGroup) _$_findCachedViewById(com.larus.nova.R.id.hybrid_content);
        TextView r103 = (TextView) _$_findCachedViewById(com.larus.nova.R.id.statusBtn);
        this.f60607g = (ViewGroup) _$_findCachedViewById(com.larus.nova.R.id.loading_status_layout);
        this.f60608h = (LiveDoubleColorBallAnimationView) _$_findCachedViewById(com.larus.nova.R.id.double_ball_loading_view);
        ViewGroup r104 = (ViewGroup) _$_findCachedViewById(com.larus.nova.R.id.double_ball_loading_view_background);
        this.f60609i = r104;
        if (r104 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("doubleBallLoadingLayoutBg");
    L16:
        r104.setOnClickListener(d.f60679a);
        TextView r105 = (TextView) _$_findCachedViewById(com.larus.nova.R.id.retry_btn);
        this.f60610j = r105;
        if (r105 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("retryBtn");
    L19:
        r105.setOnClickListener(new e(this));
        ViewGroup r106 = (ViewGroup) _$_findCachedViewById(com.larus.nova.R.id.top_right_btn_view);
        this.f60611k = r106;
        if (r106 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("topRightBtnContainer");
    L22:
        a1.e(r106);
        ViewGroup r107 = this.f60611k;
        if (r107 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("topRightBtnContainer");
    L25:
        r107.setVisibility(8);
        ViewGroup r108 = (ViewGroup) _$_findCachedViewById(com.larus.nova.R.id.top_message_container);
        this.f60613m = r108;
        if (r108 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("topMessageContainer");
    L28:
        r108.setVisibility(8);
        ((LinearLayout) _$_findCachedViewById(com.larus.nova.R.id.fl_panel_container_root)).setOnClickListener(new FullScreenOpenPanel$initView$3(this));
        r(PanelType.PANEL_TYPE_X_SCREEN);
        int r109 = ((Number) this.f60602b.getValue()).intValue();
        F.put(Integer.valueOf(r109), new WeakReference(this));
        H.onNext(TuplesKt.to(Integer.valueOf(r109), this));
        h();
        i r110 = A1();
        if (r110 == null) goto L34;
        r110.a();
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent r100) {
        super.onNewIntent(r100);
        int r101 = q.f60744a;
        q.f("FullScreenOpenPanel", new Object[]{"onNewIntent"});
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean r100) {
        super.onWindowFocusChanged(r100);
        if (r100 == false) goto L6;
        z1(this.C);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void p(int r100) {
        if (r100 != 0) goto L8;
        ViewGroup r101 = this.f60611k;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("topRightBtnContainer");
    L7:
        UIUtils.setViewVisibility(r101, 0);
        return;
    L8:
        ViewGroup r102 = this.f60611k;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("topRightBtnContainer");
    L11:
        UIUtils.setViewVisibility(r102, 8);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void r(PanelType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        b0(r100, null);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.s
    public final void registerListener(i r100) {
        i r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.D.registerListener(r101);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void z(LiveBasePluginWithPanel$initPanelAndHide$3.a r100) {
        Intrinsics.checkNotNullParameter(r100, "clickListener");
        this.B = r100;
    }

    public final void z1(PanelType r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100 != PanelType.PANEL_TYPE_LANDSCAPE) goto L7;
    L10:
        t8.d(getWindow());
        return;
    L7:
        if (r100 == PanelType.PANEL_TYPE_PORTRAIT) goto L10;
        t8.e(this);
    }

    public final void H1(PanelType r100, boolean r101) {
        PanelType r102 = PanelType.PANEL_TYPE_LANDSCAPE;
        if (r100 != r102) goto L5;
        int r103 = 0;
    L6:
        setRequestedOrientation(r103);
        if (r100 != r102) goto L14;
        M1(r100);
        z1(r100);
        RoundCornerConstraintLayout r104 = this.f60605e;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L11:
        r104.setLayoutParams(new LinearLayout.LayoutParams(r102.getWidth(), r102.getHeight()));
        if (r101 == true) goto L18;
        L1(r100);
        return;
    L18:
        return;
    L14:
        if (r100 == r102) goto L16;
        K1(true);
    L16:
        z1(r100);
        M1(r100);
        return;
    L5:
        r103 = 1;
        goto L6
    }

    public final void I1(final PanelType r100, final PanelType r101) {
        Intrinsics.checkNotNullParameter(r101, "toPanelType");
        if (r100 != r101) goto L6;
        return;
    L6:
        if (r100 == PanelType.PANEL_TYPE_LANDSCAPE) goto L8;
        z1(r101);
        h();
        int r102 = com.bytedance.android.live.broadcastgame.opengame.utils.b.f61149a;
        RoundCornerConstraintLayout r103 = this.f60605e;
        if (r103 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L18:
        PanelType r104 = this.C;
        if (r104 == null) goto L21;
        int r105 = r104.getHeight();
    L22:
        int r106 = r101.getHeight();
        Intrinsics.checkNotNullParameter(r103, "targetView");
        ValueAnimator r107 = ValueAnimator.ofInt(new int[]{r105, r106}).setDuration(500);
        r107.addUpdateListener(new com.bytedance.android.live.broadcastgame.opengame.utils.a(r103));
        r107.start();
        com.bytedance.android.live.core.utils.h.a(r107, new FullScreenOpenPanel$switchPortraitScreen$1(this, r101, r100));
        return;
    L21:
        r105 = r101.getHeight();
        goto L22
    L8:
        if (r101 == PanelType.PANEL_TYPE_PORTRAIT) goto L10;
        C1(true);
    L10:
        L1(r101);
        z1(r101);
        H1(r101, false);
        RoundCornerConstraintLayout r108 = this.f60605e;
        if (r108 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L13:
        r108.setLayoutParams(new LinearLayout.LayoutParams(r101.getWidth(), r101.getHeight()));
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.g
    public final void b0(PanelType r100, Function1<? super PanelType, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "toType");
        PanelType r102 = this.C;
        if (r102 != r100) goto L7;
        if (r101 == null) goto L27;
        Unit r103 = r101.invoke(r100);
        return;
    L27:
        return;
    L7:
        xs2.b r104 = xs2.b.a();
        if (r102 != null) goto L10;
        PanelType r105 = getPanelType();
    L11:
        r104.post(new q10.a(r105, r100));
        int r106 = com.bytedance.android.live.broadcastgame.opengame.panel.c.f60676a[r100.ordinal()];
        if (r106 != 1) goto L14;
        I1(r102, r100);
    L23:
        this.C = r100;
        if (r101 == null) goto L28;
        Unit r107 = r101.invoke(r100);
        return;
    L28:
        return;
    L14:
        if (r106 != 2) goto L16;
    L21:
        I1(r102, r100);
        goto L23
    L16:
        if (r106 == 3) goto L21;
        if (r106 != 4) goto L23;
        H1(r100, false);
        goto L23
    L10:
        r105 = r102;
        goto L11
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r100, int r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        this.A = true;
        super.startActivityForResult(r100, r101, r102);
    }
}
