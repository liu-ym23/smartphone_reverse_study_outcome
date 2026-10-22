package com.bytedance.android.shopping.anchorv3.dualstream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.imagex.t;
import com.bytedance.android.ec.core.jedi.ReflectViewModelFactory;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.model.response.f1;
import com.bytedance.android.shopping.anchorv3.AnchorV3GridLayoutManager;
import com.bytedance.android.shopping.anchorv3.detail.StaggeredGridDoubleColumnDecoration;
import com.bytedance.android.shopping.anchorv3.dualstream.adapter.DualStreamAdapter;
import com.bytedance.android.shopping.anchorv3.dualstream.model.DualStreamParams;
import com.bytedance.android.shopping.anchorv3.dualstream.model.LoadSource;
import com.bytedance.android.shopping.anchorv3.utils.b0;
import com.bytedance.android.shopping.anchorv3.widget.AnchorV3SwipeRefreshLayout;
import com.bytedance.android.shopping.anchorv3.widget.FixedHeadView;
import com.bytedance.android.shopping.anchorv3.widget.FixedRecyclerView;
import com.bytedance.android.shopping.track.TrackerProvider;
import com.bytedance.android.ui.ec.widget.loading.ECSloganLoadingAnimationView;
import com.bytedance.ies.uikit.base.AbsActivity;
import com.bytedance.jedi.arch.Async;
import com.bytedance.jedi.arch.IReceiver;
import com.bytedance.jedi.arch.ISubscriber;
import com.bytedance.jedi.arch.IdentitySubscriber;
import com.bytedance.jedi.arch.JediView;
import com.bytedance.jedi.arch.JediViewModel;
import com.bytedance.jedi.arch.LifecycleOwnerHolder;
import com.bytedance.jedi.arch.Middleware;
import com.bytedance.jedi.arch.ReceiverHolder;
import com.bytedance.jedi.arch.State;
import com.bytedance.jedi.arch.SubscriptionConfig;
import com.bytedance.jedi.arch.Tuple1;
import com.bytedance.jedi.arch.Tuple2;
import com.bytedance.jedi.arch.Tuple3;
import com.bytedance.jedi.arch.Tuple4;
import com.bytedance.jedi.arch.Tuple5;
import com.bytedance.jedi.arch.ViewModelFactoryOwner;
import com.bytedance.jedi.arch.ext.list.DiffableAdapter;
import com.bytedance.jedi.arch.lifecycleAwareLazy;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.gyf.barlibrary.ImmersionBar;
import com.gyf.barlibrary.OSUtils;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.Disposable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty1;
import o53.c;
import org.json.JSONObject;
import ti.j;
import v19.f;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/dualstream/AnchorV3DualStreamActivity;", "Lcom/bytedance/ies/uikit/base/AbsActivity;", "Lcom/bytedance/jedi/arch/JediView;", "Lcom/bytedance/jedi/arch/ViewModelFactoryOwner;", "Lcom/bytedance/android/ec/core/jedi/ReflectViewModelFactory;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV3DualStreamActivity extends AbsActivity implements JediView, ViewModelFactoryOwner<ReflectViewModelFactory> {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f165016x = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ReflectViewModelFactory f165017j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final lifecycleAwareLazy f165018k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f165019l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f165020m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f165021n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f165022o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f165023p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f165024q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f165025r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ImmersionBar f165026s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public DualStreamAdapter f165027t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public f1 f165028u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f165029v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final b f165030w;

    public static final class a {
        public static void a(Context r100, DualStreamParams r101) {
            Intrinsics.checkNotNullParameter(r101, "param");
            if (r100 == null) goto L6;
            Intent r102 = new Intent(r100, AnchorV3DualStreamActivity.class);
            r102.putExtra("param_key", r101);
            Unit r103 = Unit.INSTANCE;
            r100.startActivity(r102);
            return;
        }
    }

    public static final class b implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorV3DualStreamActivity f165031a;

        public b(AnchorV3DualStreamActivity r100) {
            this.f165031a = r100;
        }

        @Override // ti.j
        public final void a(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            int r101 = r100.optInt("action", 0);
            if (r101 != 3) goto L5;
            AnchorV3DualStreamActivity r102 = this.f165031a;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r100, "params");
            f1 r103 = r102.f165028u;
            if (r103 == null) goto L11;
            r102.B1().submitSurvey(r100, r103, r102, r102.getString(R.string.ec_comment_nps_success));
            r102.z1();
        L11:
            c.b();
            return;
        L5:
            if (r101 != 4) goto L14;
            this.f165031a.z1();
            c.b();
            return;
        }
    }

    static {
    }

    public final FixedRecyclerView A1() {
        return (FixedRecyclerView) this.f165019l.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final DualStreamVM B1() {
        return (DualStreamVM) this.f165018k.getValue();
    }

    @Override // com.bytedance.ies.uikit.base.AbsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(AnchorV3DualStreamActivity.class.getName()));
    L5:
        super.onDestroy();
        ImmersionBar r100 = this.f165026s;
        if (r100 == null) goto L8;
        r100.destroy();
    L8:
        t.c(this);
        ECLiveHybridUtil.p("nps_data_sync", this.f165030w);
    }

    public final void z1() {
        DualStreamAdapter r100 = this.f165027t;
        if (r100 == null) goto L5;
        List r101 = DiffableAdapter.DefaultImpls.getCurrentList(r100);
    L6:
        ArrayList r102 = new ArrayList();
        int r103 = -1;
        if (r101 == null) goto L18;
        List r104 = r101;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator r106 = r104.iterator();
        int r107 = 0;
    L10:
        if (r106.hasNext() == false) goto L18;
        Object r108 = r106.next();
        int r109 = r107 + 1;
        if (r107 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        r102.add(r108);
        if ((r108 instanceof f1) == false) goto L17;
        r103 = r107;
    L17:
        r105.add(Unit.INSTANCE);
        r107 = r109;
    L18:
        ListProtector.remove(r102, r103);
        DualStreamAdapter r110 = this.f165027t;
        if (r110 == null) goto L21;
        Intrinsics.checkNotNullParameter(r102, "list");
        DiffableAdapter.DefaultImpls.submitList(r110, r102);
    L21:
        this.f165029v = c.a(1);
        return;
    L5:
        r101 = null;
        goto L6
    }

    public AnchorV3DualStreamActivity() {
        this.f165017j = new ReflectViewModelFactory();
        final KClass r100 = Reflection.getOrCreateKotlinClass(DualStreamVM.class);
        final AnchorV3DualStreamActivity$$special$$inlined$viewModel$1 r101 = AnchorV3DualStreamActivity$$special$$inlined$viewModel$1.INSTANCE;
        this.f165018k = new lifecycleAwareLazy(this, new AnchorV3DualStreamActivity$$special$$inlined$viewModel$2(this, r100, r101, r100));
        this.f165019l = LazyKt.lazy(new AnchorV3DualStreamActivity$recyclerView$2(this));
        this.f165020m = LazyKt.lazy(new AnchorV3DualStreamActivity$backView$2(this));
        this.f165021n = LazyKt.lazy(new AnchorV3DualStreamActivity$networkErrorView$2(this));
        this.f165022o = LazyKt.lazy(new AnchorV3DualStreamActivity$retryButton$2(this));
        this.f165023p = LazyKt.lazy(new AnchorV3DualStreamActivity$loadingView$2(this));
        this.f165024q = LazyKt.lazy(new AnchorV3DualStreamActivity$refreshLayout$2(this));
        this.f165029v = c.a(1);
        this.f165030w = new b(this);
    }

    @Override // com.bytedance.ies.uikit.base.AbsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L56;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(AnchorV3DualStreamActivity.class.getName()));
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
    L53:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
    L48:
        goto L53
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
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right);     // Catch: Throwable -> L39
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

    @Override // com.bytedance.jedi.arch.IdentitySubscriber, com.bytedance.jedi.arch.LifecycleOwnerHolder
    public final LifecycleOwner getLifecycleOwner() {
        return JediView.DefaultImpls.getLifecycleOwner(this);
    }

    @Override // com.bytedance.jedi.arch.IdentitySubscriber, com.bytedance.jedi.arch.ISubscriber
    public final LifecycleOwnerHolder getLifecycleOwnerHolder() {
        return JediView.DefaultImpls.getLifecycleOwnerHolder(this);
    }

    @Override // com.bytedance.jedi.arch.ReceiverHolder
    public final IReceiver getReceiver() {
        return JediView.DefaultImpls.getReceiver(this);
    }

    @Override // com.bytedance.jedi.arch.IdentitySubscriber, com.bytedance.jedi.arch.ISubscriber
    public final ReceiverHolder<IdentitySubscriber> getReceiverHolder() {
        return JediView.DefaultImpls.getReceiverHolder(this);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final boolean getUniqueOnlyGlobal() {
        return JediView.DefaultImpls.getUniqueOnlyGlobal(this);
    }

    @Override // com.bytedance.ies.uikit.base.AbsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r100 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r101 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r101 == com.larus.home.impl.utils.c.f346341a) goto L9;
        com.larus.home.impl.utils.c.a(r101, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r100.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    @Override // com.bytedance.ies.uikit.base.AbsActivity
    public final void y1() {
        super.y1();
        if (OSUtils.isEMUI3_0() == false) goto L5;
        return;
    L5:
        if (OSUtils.isEMUI3_1() == true) goto L16;
        int r100 = b0.f165303a;
        b0.a(getWindow());
        ImmersionBar r101 = ImmersionBar.with(this);
        this.f165026s = r101;
        if (r101 == null) goto L14;
        ImmersionBar r102 = r101.statusBarDarkFont(true);
        if (r102 == null) goto L15;
        r102.init();
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // com.bytedance.jedi.arch.ViewModelFactoryOwner
    public final ViewModelProvider.Factory getViewModelFactory() {
        return this.f165017j;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        finish();
    }

    @Override // com.bytedance.jedi.arch.IdentitySubscriber, com.bytedance.jedi.arch.ReceiverHolder
    public final IdentitySubscriber getReceiver() {
        return JediView.DefaultImpls.getReceiver(this);
    }

    @Override // com.bytedance.ies.uikit.base.AbsActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r110) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L7;
        f.a(getTheme());     // Catch: Throwable -> L10
    L7:
        if (f.f(this) == false) goto L11;
        f.c(getTheme());     // Catch: Throwable -> L10
    L11:
        super.onCreate(r110);
        overridePendingTransition(R.anim.ec_commerce_activity_in, R.anim.ec_commerce_pre_out);
        setContentView(R.layout.ec_commerce_anchor_v3_dual_stream);
        Serializable r100 = null;
        if (r110 == null) goto L14;
        Serializable r101 = r110.getSerializable("param_key");
    L16:
        if ((r101 instanceof DualStreamParams) == true) goto L18;
        r101 = null;
    L18:
        DualStreamParams r102 = (DualStreamParams) r101;
        if (r102 != null) goto L25;
        Serializable r103 = getIntent().getSerializableExtra("param_key");
        if ((r103 instanceof DualStreamParams) == false) goto L24;
        r100 = r103;
    L24:
        r102 = (DualStreamParams) r100;
    L25:
        if (r102 == null) goto L27;
        this.f165025r = r102.getProductId();
    L27:
        AnchorV3SwipeRefreshLayout r104 = (AnchorV3SwipeRefreshLayout) this.f165024q.getValue();
        int r105 = com.bytedance.android.shopping.extensions.b.b(210);
        int r106 = com.bytedance.android.shopping.extensions.b.b(20);
        FixedHeadView r107 = r104.f165579c;
        if (r107 == null) goto L30;
        r107.S5(r105, r106);
    L30:
        int r108 = com.bytedance.android.shopping.extensions.b.b(12);
        int r109 = com.bytedance.android.shopping.extensions.b.b(12);
        FixedHeadView r111 = r104.f165579c;
        if (r111 == null) goto L33;
        r111.R5(r108, r109);
    L33:
        r104.setOnRefreshListener(new AnchorV3DualStreamActivity$initDualStreamAdapter$$inlined$apply$lambda$1(this));
        ((View) this.f165020m.getValue()).setOnClickListener(new com.bytedance.android.shopping.anchorv3.dualstream.a(this));
        ((TextView) this.f165022o.getValue()).setOnClickListener(new com.bytedance.android.shopping.anchorv3.dualstream.b(this));
        DualStreamAdapter r112 = new DualStreamAdapter(this);
        r112.setShowFooter(true);
        int r113 = com.bytedance.android.shopping.extensions.b.b(12);
        int r114 = com.bytedance.android.shopping.extensions.b.b(12);
        r112.f176403j = 0;
        r112.f176405l = r113;
        r112.f176404k = 0;
        r112.f176402i = r114;
        int r115 = g1.f45599a;
        r112.f176397d = g1.a.a(A1().getContext(), R.color.TextReverse3);
        r112.f176396c = g1.a.a(A1().getContext(), R.color.TextReverse3);
        r112.resetLoadMoreState();
        r112.f176411r = new AnchorV3DualStreamActivity$initDualStreamAdapter$$inlined$apply$lambda$2(this);
        Unit r116 = Unit.INSTANCE;
        this.f165027t = r112;
        A1().setAdapter(this.f165027t);
        FixedRecyclerView r117 = A1();
        r117.setLayoutManager(new AnchorV3GridLayoutManager());
        r117.addItemDecoration(new StaggeredGridDoubleColumnDecoration(0.0f, 0.0f, 8.0f, 7.0f, 8.0f, new AnchorV3DualStreamActivity$initDualStreamAdapter$5$1(StaggeredGridDoubleColumnDecoration.f164806g)));
        String r118 = this.f165025r;
        if (r118 == null) goto L36;
        B1().initData(r118);
    L36:
        B1().loadDualStreamData(LoadSource.FIRST_LOAD);
        ((ECSloganLoadingAnimationView) this.f165023p.getValue()).setVisibility(0);
        ISubscriber.DefaultImpls.selectSubscribe$default(this, B1(), AnchorV3DualStreamActivity$initSubscribe$1.INSTANCE, AnchorV3DualStreamActivity$initSubscribe$2.INSTANCE, AnchorV3DualStreamActivity$initSubscribe$3.INSTANCE, null, new AnchorV3DualStreamActivity$initSubscribe$4(this), 8, null);
        ISubscriber.DefaultImpls.selectSubscribe$default(this, B1(), AnchorV3DualStreamActivity$initSubscribe$5.INSTANCE, AnchorV3DualStreamActivity$initSubscribe$6.INSTANCE, null, new AnchorV3DualStreamActivity$initSubscribe$7(this), 4, null);
        ISubscriber.DefaultImpls.selectSubscribe$default(this, B1(), AnchorV3DualStreamActivity$initSubscribe$8.INSTANCE, null, new AnchorV3DualStreamActivity$initSubscribe$9(this), 2, null);
        ECLiveHybridUtil.m("nps_data_sync", this.f165030w);
        TrackerProvider.a r119 = TrackerProvider.Companion;
        int r120 = g63.b.f480148b;
        g63.b r121 = g63.b.a.a();
        r119.getClass();
        TrackerProvider.a.a(this, r121);
        t.b(this, B1().getImageCallerContext());
        return;
    L14:
        r101 = null;
        goto L16
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <VM1 extends JediViewModel<S1>, S1 extends State, R> R withState(VM1 r100, Function1<? super S1, ? extends R> r101) {
        Intrinsics.checkNotNullParameter(r100, "viewModel1");
        Intrinsics.checkNotNullParameter(r101, "block");
        return (R) JediView.DefaultImpls.withState(this, r100, r101);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <M1 extends Middleware<S1, PROP1>, PROP1 extends State, S1 extends State, R> R withSubstate(Middleware<S1, PROP1> r100, Function1<? super PROP1, ? extends R> r101) {
        Intrinsics.checkNotNullParameter(r100, "middleware1");
        Intrinsics.checkNotNullParameter(r101, "block");
        return (R) JediView.DefaultImpls.withSubstate(this, r100, r101);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <S extends State> Disposable subscribe(JediViewModel<S> r100, SubscriptionConfig<S> r101, Function2<? super IdentitySubscriber, ? super S, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$subscribe");
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "subscriber");
        return JediView.DefaultImpls.subscribe(this, r100, r101, r102);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <VM1 extends JediViewModel<S1>, S1 extends State, VM2 extends JediViewModel<S2>, S2 extends State, R> R withState(VM1 r100, VM2 r101, Function2<? super S1, ? super S2, ? extends R> r102) {
        Intrinsics.checkNotNullParameter(r100, "viewModel1");
        Intrinsics.checkNotNullParameter(r101, "viewModel2");
        Intrinsics.checkNotNullParameter(r102, "block");
        return (R) JediView.DefaultImpls.withState(this, r100, r101, r102);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <M1 extends Middleware<S1, PROP1>, PROP1 extends State, S1 extends State, M2 extends Middleware<S2, PROP2>, PROP2 extends State, S2 extends State, R> R withSubstate(Middleware<S1, PROP1> r100, Middleware<S2, PROP2> r101, Function2<? super PROP1, ? super PROP2, ? extends R> r102) {
        Intrinsics.checkNotNullParameter(r100, "middleware1");
        Intrinsics.checkNotNullParameter(r101, "middleware2");
        Intrinsics.checkNotNullParameter(r102, "block");
        return (R) JediView.DefaultImpls.withSubstate(this, r100, r101, r102);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <S extends State, A> Disposable selectSubscribe(JediViewModel<S> r100, KProperty1<S, ? extends A> r101, SubscriptionConfig<Tuple1<A>> r102, Function2<? super IdentitySubscriber, ? super A, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$selectSubscribe");
        Intrinsics.checkNotNullParameter(r101, "prop1");
        Intrinsics.checkNotNullParameter(r102, "config");
        Intrinsics.checkNotNullParameter(r103, "subscriber");
        return JediView.DefaultImpls.selectSubscribe(this, r100, r101, r102, r103);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <VM1 extends JediViewModel<S1>, S1 extends State, VM2 extends JediViewModel<S2>, S2 extends State, VM3 extends JediViewModel<S3>, S3 extends State, R> R withState(VM1 r100, VM2 r101, VM3 r102, Function3<? super S1, ? super S2, ? super S3, ? extends R> r103) {
        Intrinsics.checkNotNullParameter(r100, "viewModel1");
        Intrinsics.checkNotNullParameter(r101, "viewModel2");
        Intrinsics.checkNotNullParameter(r102, "viewModel3");
        Intrinsics.checkNotNullParameter(r103, "block");
        return (R) JediView.DefaultImpls.withState(this, r100, r101, r102, r103);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <M1 extends Middleware<S1, PROP1>, PROP1 extends State, S1 extends State, M2 extends Middleware<S2, PROP2>, PROP2 extends State, S2 extends State, M3 extends Middleware<S3, PROP3>, PROP3 extends State, S3 extends State, R> R withSubstate(Middleware<S1, PROP1> r100, Middleware<S2, PROP2> r101, Middleware<S3, PROP3> r102, Function3<? super PROP1, ? super PROP2, ? super PROP3, ? extends R> r103) {
        Intrinsics.checkNotNullParameter(r100, "middleware1");
        Intrinsics.checkNotNullParameter(r101, "middleware2");
        Intrinsics.checkNotNullParameter(r102, "middleware3");
        Intrinsics.checkNotNullParameter(r103, "block");
        return (R) JediView.DefaultImpls.withSubstate(this, r100, r101, r102, r103);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <S extends State, A, B> Disposable selectSubscribe(JediViewModel<S> r100, KProperty1<S, ? extends A> r101, KProperty1<S, ? extends B> r102, SubscriptionConfig<Tuple2<A, B>> r103, Function3<? super IdentitySubscriber, ? super A, ? super B, Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, "$this$selectSubscribe");
        Intrinsics.checkNotNullParameter(r101, "prop1");
        Intrinsics.checkNotNullParameter(r102, "prop2");
        Intrinsics.checkNotNullParameter(r103, "config");
        Intrinsics.checkNotNullParameter(r104, "subscriber");
        return JediView.DefaultImpls.selectSubscribe(this, r100, r101, r102, r103, r104);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <VM1 extends JediViewModel<S1>, S1 extends State, VM2 extends JediViewModel<S2>, S2 extends State, VM3 extends JediViewModel<S3>, S3 extends State, VM4 extends JediViewModel<S4>, S4 extends State, R> R withState(VM1 r100, VM2 r101, VM3 r102, VM4 r103, Function4<? super S1, ? super S2, ? super S3, ? super S4, ? extends R> r104) {
        Intrinsics.checkNotNullParameter(r100, "viewModel1");
        Intrinsics.checkNotNullParameter(r101, "viewModel2");
        Intrinsics.checkNotNullParameter(r102, "viewModel3");
        Intrinsics.checkNotNullParameter(r103, "viewModel4");
        Intrinsics.checkNotNullParameter(r104, "block");
        return (R) JediView.DefaultImpls.withState(this, r100, r101, r102, r103, r104);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <M1 extends Middleware<S1, PROP1>, PROP1 extends State, S1 extends State, M2 extends Middleware<S2, PROP2>, PROP2 extends State, S2 extends State, M3 extends Middleware<S3, PROP3>, PROP3 extends State, S3 extends State, M4 extends Middleware<S4, PROP4>, PROP4 extends State, S4 extends State, R> R withSubstate(Middleware<S1, PROP1> r100, Middleware<S2, PROP2> r101, Middleware<S3, PROP3> r102, Middleware<S4, PROP4> r103, Function4<? super PROP1, ? super PROP2, ? super PROP3, ? super PROP4, ? extends R> r104) {
        Intrinsics.checkNotNullParameter(r100, "middleware1");
        Intrinsics.checkNotNullParameter(r101, "middleware2");
        Intrinsics.checkNotNullParameter(r102, "middleware3");
        Intrinsics.checkNotNullParameter(r103, "middleware4");
        Intrinsics.checkNotNullParameter(r104, "block");
        return (R) JediView.DefaultImpls.withSubstate(this, r100, r101, r102, r103, r104);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <S extends State, T> Disposable asyncSubscribe(JediViewModel<S> r100, KProperty1<S, ? extends Async<? extends T>> r101, SubscriptionConfig<Tuple1<Async<T>>> r102, Function2<? super IdentitySubscriber, ? super Throwable, Unit> r103, Function1<? super IdentitySubscriber, Unit> r104, Function2<? super IdentitySubscriber, ? super T, Unit> r105) {
        Intrinsics.checkNotNullParameter(r100, "$this$asyncSubscribe");
        Intrinsics.checkNotNullParameter(r101, "prop");
        Intrinsics.checkNotNullParameter(r102, "config");
        return JediView.DefaultImpls.asyncSubscribe(this, r100, r101, r102, r103, r104, r105);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <S extends State, A, B, C> Disposable selectSubscribe(JediViewModel<S> r100, KProperty1<S, ? extends A> r101, KProperty1<S, ? extends B> r102, KProperty1<S, ? extends C> r103, SubscriptionConfig<Tuple3<A, B, C>> r104, Function4<? super IdentitySubscriber, ? super A, ? super B, ? super C, Unit> r105) {
        Intrinsics.checkNotNullParameter(r100, "$this$selectSubscribe");
        Intrinsics.checkNotNullParameter(r101, "prop1");
        Intrinsics.checkNotNullParameter(r102, "prop2");
        Intrinsics.checkNotNullParameter(r103, "prop3");
        Intrinsics.checkNotNullParameter(r104, "config");
        Intrinsics.checkNotNullParameter(r105, "subscriber");
        return JediView.DefaultImpls.selectSubscribe(this, r100, r101, r102, r103, r104, r105);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <VM1 extends JediViewModel<S1>, S1 extends State, VM2 extends JediViewModel<S2>, S2 extends State, VM3 extends JediViewModel<S3>, S3 extends State, VM4 extends JediViewModel<S4>, S4 extends State, VM5 extends JediViewModel<S5>, S5 extends State, R> R withState(VM1 r100, VM2 r101, VM3 r102, VM4 r103, VM5 r104, Function5<? super S1, ? super S2, ? super S3, ? super S4, ? super S5, ? extends R> r105) {
        Intrinsics.checkNotNullParameter(r100, "viewModel1");
        Intrinsics.checkNotNullParameter(r101, "viewModel2");
        Intrinsics.checkNotNullParameter(r102, "viewModel3");
        Intrinsics.checkNotNullParameter(r103, "viewModel4");
        Intrinsics.checkNotNullParameter(r104, "viewModel5");
        Intrinsics.checkNotNullParameter(r105, "block");
        return (R) JediView.DefaultImpls.withState(this, r100, r101, r102, r103, r104, r105);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <M1 extends Middleware<S1, PROP1>, PROP1 extends State, S1 extends State, M2 extends Middleware<S2, PROP2>, PROP2 extends State, S2 extends State, M3 extends Middleware<S3, PROP3>, PROP3 extends State, S3 extends State, M4 extends Middleware<S4, PROP4>, PROP4 extends State, S4 extends State, M5 extends Middleware<S5, PROP5>, PROP5 extends State, S5 extends State, R> R withSubstate(Middleware<S1, PROP1> r100, Middleware<S2, PROP2> r101, Middleware<S3, PROP3> r102, Middleware<S4, PROP4> r103, Middleware<S5, PROP5> r104, Function5<? super PROP1, ? super PROP2, ? super PROP3, ? super PROP4, ? super PROP5, ? extends R> r105) {
        Intrinsics.checkNotNullParameter(r100, "middleware1");
        Intrinsics.checkNotNullParameter(r101, "middleware2");
        Intrinsics.checkNotNullParameter(r102, "middleware3");
        Intrinsics.checkNotNullParameter(r103, "middleware4");
        Intrinsics.checkNotNullParameter(r104, "middleware5");
        Intrinsics.checkNotNullParameter(r105, "block");
        return (R) JediView.DefaultImpls.withSubstate(this, r100, r101, r102, r103, r104, r105);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <S extends State, A, B, C, D> Disposable selectSubscribe(JediViewModel<S> r100, KProperty1<S, ? extends A> r101, KProperty1<S, ? extends B> r102, KProperty1<S, ? extends C> r103, KProperty1<S, ? extends D> r104, SubscriptionConfig<Tuple4<A, B, C, D>> r105, Function5<? super IdentitySubscriber, ? super A, ? super B, ? super C, ? super D, Unit> r106) {
        Intrinsics.checkNotNullParameter(r100, "$this$selectSubscribe");
        Intrinsics.checkNotNullParameter(r101, "prop1");
        Intrinsics.checkNotNullParameter(r102, "prop2");
        Intrinsics.checkNotNullParameter(r103, "prop3");
        Intrinsics.checkNotNullParameter(r104, "prop4");
        Intrinsics.checkNotNullParameter(r105, "config");
        Intrinsics.checkNotNullParameter(r106, "subscriber");
        return JediView.DefaultImpls.selectSubscribe(this, r100, r101, r102, r103, r104, r105, r106);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <S extends State, A, B, C, D, E> Disposable selectSubscribe(JediViewModel<S> r100, KProperty1<S, ? extends A> r101, KProperty1<S, ? extends B> r102, KProperty1<S, ? extends C> r103, KProperty1<S, ? extends D> r104, KProperty1<S, ? extends E> r105, SubscriptionConfig<Tuple5<A, B, C, D, E>> r106, Function6<? super IdentitySubscriber, ? super A, ? super B, ? super C, ? super D, ? super E, Unit> r107) {
        Intrinsics.checkNotNullParameter(r100, "$this$selectSubscribe");
        Intrinsics.checkNotNullParameter(r101, "prop1");
        Intrinsics.checkNotNullParameter(r102, "prop2");
        Intrinsics.checkNotNullParameter(r103, "prop3");
        Intrinsics.checkNotNullParameter(r104, "prop4");
        Intrinsics.checkNotNullParameter(r105, "prop5");
        Intrinsics.checkNotNullParameter(r106, "config");
        Intrinsics.checkNotNullParameter(r107, "subscriber");
        return JediView.DefaultImpls.selectSubscribe(this, r100, r101, r102, r103, r104, r105, r106, r107);
    }
}
