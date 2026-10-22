package com.bytedance.applet.view;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u0004\u0018\u00010\fJ\b\u0010\u0016\u001a\u00020\u0012H\u0002J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0014J\b\u0010\u001a\u001a\u00020\u0012H\u0014J\b\u0010\u001b\u001a\u00020\u0012H\u0014J\u0018\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\"\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\u0010\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u0007H\u0016J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u0007H\u0016R\"\u0010\u0005\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/bytedance/applet/view/AppletActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "Lcom/larus/ivykit/xbridge/choosemedia/IActivityResult;", "<init>", "()V", "mActivityResultListeners", "Ljava/util/ArrayList;", "Lcom/larus/ivykit/xbridge/choosemedia/ActivityResultListener;", "Lkotlin/collections/ArrayList;", AppConstants.APP_FG, "Lcom/bytedance/applet/view/AppletFragment;", "url", "", "transStatusBar", "", "transNavigationBar", "fullScreen", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "getAppId", "parseArguments", "needAdaptStatusBarPadding", "needAdaptNavigationBarPadding", "onResume", "onPause", LiveCommonConstants.REASON_ON_DEDTROY, "onSaveInstanceState", "outState", "outPersistentState", "Landroid/os/PersistableBundle;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "setActivityResultListener", "listener", "unsetActivityResultListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletActivity extends FlowCommonAppCompatActivity implements ug9.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList<ug9.a> f192322g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AppletFragment f192323h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f192324i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f192325j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f192326k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f192327l;

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity
    public final boolean H1() {
        return !this.f192326k;
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity
    public final boolean K1() {
        if (this.f192325j == true) goto L5;
    L8:
        return true;
    L5:
        if (this.f192327l == false) goto L8;
        return false;
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(AppletActivity.class.getName()));
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

    public final String getAppId() {
        AppletFragment r100 = this.f192323h;
        if (r100 == null) goto L7;
        com.bytedance.ai.model.widgets.c r101 = r100.f192336k;
        if (r101 == null) goto L7;
        return r101.getAppletId();
    L7:
        return null;
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(AppletActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    public AppletActivity() {
        this.f192322g = new ArrayList();
        this.f192327l = true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        N1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
    }

    public static View N1(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // ug9.b
    public final void I0(ug9.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f192322g.add(r100);
    }

    @Override // ug9.b
    public final void S(com.larus.bmhome.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f192322g.remove(r100);
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r100);
        setContentView(com.larus.nova.R.layout.larus_activity_fragment_container);
        Window r101 = getWindow();
        if (r101 == null) goto L13;
        View r102 = N1(r101);
    L14:
        setRootView(r102);
        L1();
        Bundle r103 = getIntent().getExtras();
        if (r103 == null) goto L18;
        String r104 = r103.getString("url");
        if (r104 == null) goto L18;
    L24:
        this.f192324i = r104;
        Bundle r105 = getIntent().getExtras();
        boolean r106 = true;
        if (r105 == null) goto L27;
        boolean r107 = r105.getBoolean("fullScreen", true);
    L28:
        this.f192327l = r107;
        String r108 = this.f192324i;
        if (r108 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("url");
        r108 = null;
    L31:
        Uri r109 = UriProtector.parse(r108);
        boolean r110 = false;
        this.f192325j = r109.getBooleanQueryParameter("transStatusBar", false);
        this.f192326k = r109.getBooleanQueryParameter("transNavigationBar", false);
        Bundle r111 = getIntent().getExtras();
        if (r111 == null) goto L40;
        String r112 = r111.getString("pageId");
        if (r112 == null) goto L40;
        AppletRuntimeManager.INSTANCE.getClass();
        if (AppletRuntimeManager.e(r112) != null) goto L39;
        r106 = false;
    L39:
        r110 = r106;
    L40:
        if (r110 == true) goto L42;
        finish();
        return;
    L42:
        AppletFragment r113 = new AppletFragment();
        this.f192323h = r113;
        r113.setArguments(getIntent().getExtras());
        FragmentTransaction r114 = getSupportFragmentManager().beginTransaction();
        AppletFragment r115 = this.f192323h;
        Intrinsics.checkNotNull(r115);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r114, r115, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, com.larus.nova.R.id.fragment_container) == true) goto L46;
        r114 = r114.replace(com.larus.nova.R.id.fragment_container, r115);
    L46:
        r114.commitAllowingStateLoss();
        return;
    L27:
        r107 = true;
    L18:
        Bundle r116 = getIntent().getExtras();
        if (r116 == null) goto L21;
        r104 = r116.getString("link_url");
    L22:
        if (r104 != null) goto L24;
        r104 = "";
        goto L24
    L21:
        r104 = null;
        goto L22
    L13:
        r102 = null;
        goto L14
    }

    @Override // android.app.Activity
    public final void onSaveInstanceState(Bundle r100, PersistableBundle r101) {
        Intrinsics.checkNotNullParameter(r100, "outState");
        Intrinsics.checkNotNullParameter(r101, "outPersistentState");
        super.onSaveInstanceState(r100, r101);
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        Iterator<ug9.a> r103 = this.f192322g.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        ug9.a r104 = r103.next();
        if (r104 == null) goto L4;
        r104.onActivityResult(r100, r101, r102);
        goto L4
    }
}
