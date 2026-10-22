package com.bytedance.android.shopping.commentfeed.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.shopping.anchorv3.utils.b0;
import com.bytedance.android.shopping.commentfeed.model.CommentDetailParams;
import com.bytedance.android.shopping.commentfeed.utils.CommentListViewModel;
import com.bytedance.android.shopping.extensions.m;
import com.bytedance.android.shopping.track.TrackerProvider;
import com.bytedance.ies.uikit.base.AbsActivity;
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
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import v19.f;
import yb3.d;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/commentfeed/view/CommentDetailActivity;", "Lcom/bytedance/ies/uikit/base/AbsActivity;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentDetailActivity extends AbsActivity {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f172336k = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ImmersionBar f172337j;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.uikit.base.AbsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.ec_commerce_activity_out);
        if ((this instanceof ChatWindowActivity) == true) goto L56;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(CommentDetailActivity.class.getName()));
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

    @Override // com.bytedance.ies.uikit.base.AbsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(CommentDetailActivity.class.getName()));
    L5:
        super.onDestroy();
        ImmersionBar r100 = this.f172337j;
        if (r100 == null) goto L8;
        r100.destroy();
    L8:
        ac3.c.f2669a.clear();
    }

    public CommentDetailActivity() {
        CommentDetailActivity$viewModel$2 r100 = CommentDetailActivity$viewModel$2.INSTANCE;
        Reflection.getOrCreateKotlinClass(CommentListViewModel.class);
        new CommentDetailActivity$$special$$inlined$viewModels$1(this);
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
        this.f172337j = r101;
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

    @Override // com.bytedance.ies.uikit.base.AbsActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r100);
        setTheme(R.style.ECommerceAppTheme);
        setContentView(R.layout.ec_comment_detail_list_activity_layout);
        Window r101 = getWindow();
        if (r101 == null) goto L13;
        m.a(r101, false);
    L13:
        Serializable r102 = getIntent().getSerializableExtra(com.bytedance.android.ec.core.event.a.KEY_COMMENT_DETAIL);
        if ((r102 instanceof CommentDetailParams) == true) goto L16;
        r102 = null;
    L16:
        CommentDetailParams r103 = (CommentDetailParams) r102;
        if (r103 == null) goto L32;
        int r104 = CommentDetailFragment.f172338t;
        Intrinsics.checkNotNullParameter(r103, "params");
        CommentDetailFragment r105 = new CommentDetailFragment();
        Bundle r106 = new Bundle();
        r106.putSerializable(com.bytedance.android.ec.core.event.a.KEY_COMMENT_DETAIL, r103);
        Unit r107 = Unit.INSTANCE;
        r105.setArguments(r106);
        FragmentManager r108 = getSupportFragmentManager();
        if (r108 == null) goto L28;
        FragmentTransaction r109 = r108.beginTransaction();
        if (r109 == null) goto L28;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r109, r105, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, R.id.ec_comment_fragment_container) == true) goto L26;
        r109 = r109.replace(R.id.ec_comment_fragment_container, r105);
    L26:
        if (r109 == null) goto L28;
        r109.commitAllowingStateLoss();
    L28:
        TrackerProvider.a r110 = TrackerProvider.Companion;
        int r111 = d.f567088b;
        Intrinsics.checkNotNullParameter(r103, "param");
        d r112 = new d();
        d.a(r112, com.bytedance.android.ec.core.event.a.KEY_COMMENT_ENTRANCE, r103.getCommentEntrance());
        d.a(r112, "comment_id", r103.getCommentId());
        d.a(r112, "page_name", com.bytedance.android.ec.core.event.a.VALUE_COMMENT_DETAIL_PAGE);
        r110.getClass();
        TrackerProvider.a.a(this, r112);
        return;
    }
}
