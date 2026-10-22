package com.bytedance.applet.debugger;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ai.api.DebuggerOpenArgs;
import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
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
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0014J\"\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\u0011\u001a\u00020\u0006H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0018H\u0002J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016¨\u0006\u001f"}, d2 = {"Lcom/bytedance/applet/debugger/AppletDebuggerActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "Lcom/bytedance/ai/api/IAppletDebuggerActivity;", "<init>", "()V", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onActivityResult", "requestCode", "", "resultCode", "data", LiveCommonConstants.REASON_ON_DEDTROY, "createHostContainer", "Landroidx/fragment/app/FragmentContainerView;", "registerBackHandler", "handleOpenIntent", "", "attachHost", "Lcom/bytedance/applet/debugger/AppletDebuggerHostFragment;", "openArgs", "Lcom/bytedance/ai/api/DebuggerOpenArgs;", "findHost", "getChatFragment", "Landroidx/fragment/app/Fragment;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletDebuggerActivity extends FlowCommonAppCompatActivity implements com.bytedance.ai.api.n {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f191690g = 0;

    public static final class a {
    }

    static {
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(AppletDebuggerActivity.class.getName()));
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

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(AppletDebuggerActivity.class.getName()));
    L5:
        IAISDKDebugService.f36186a.c(null);
        super.onDestroy();
    }

    public final AppletDebuggerHostFragment O1() {
        Fragment r100 = getSupportFragmentManager().findFragmentByTag("applet_debugger_host");
        if ((r100 instanceof AppletDebuggerHostFragment) == true) goto L7;
        return null;
    L7:
        return (AppletDebuggerHostFragment) r100;
    }

    @Override // com.bytedance.ai.api.n
    public final Fragment getChatFragment() {
        AppletDebuggerHostFragment r100 = O1();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getChatFragment();
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

    public AppletDebuggerActivity() {
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

    public final boolean P1(Intent r110) {
        final DebuggerOpenArgs r100 = null;
        if (r110 == null) goto L5;
        Serializable r111 = r110.getSerializableExtra("applet_debugger_open_args");
    L7:
        if ((r111 instanceof DebuggerOpenArgs) == false) goto L9;
        r100 = (DebuggerOpenArgs) r111;
    L9:
        if (r100 != null) goto L12;
        FLogger.f375446a.e("AppletDebuggerActivity", "Debugger open args are missing");
        return false;
    L12:
        final AppletDebuggerHostFragment r112 = O1();
        if (r112 == null) goto L15;
        Intrinsics.checkNotNullParameter(r100, "args");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r112.getViewLifecycleOwner()), null, null, new AppletDebuggerHostFragment$switchMode$1(r112, r100.getMode(), new k(r112, r100), new l(r112, r100), null), 3, null);
        return true;
    L15:
        int r113 = AppletDebuggerHostFragment.f191702m;
        Intrinsics.checkNotNullParameter(r100, "args");
        AppletDebuggerHostFragment r114 = new AppletDebuggerHostFragment();
        Bundle r101 = new Bundle();
        r101.putSerializable("applet_debugger_open_args", r100);
        r114.setArguments(r101);
        FragmentTransaction r102 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r102, r114, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "applet_debugger_host", com.larus.nova.R.id.applet_debugger_host_container) == true) goto L19;
        r102 = r102.replace(com.larus.nova.R.id.applet_debugger_host_container, r114, "applet_debugger_host");
    L19:
        r102.commitNow();
        return true;
    L5:
        r111 = null;
        goto L7
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
        FragmentContainerView r101 = new FragmentContainerView(this);
        r101.setId(com.larus.nova.R.id.applet_debugger_host_container);
        r101.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setContentView(r101);
        Window r102 = getWindow();
        if (r102 == null) goto L13;
        View r103 = N1(r102);
    L14:
        setRootView(r103);
        L1();
        getOnBackPressedDispatcher().addCallback(this, new AppletDebuggerActivity$registerBackHandler$1(this));
        if (r100 != null) goto L20;
        if (P1(getIntent()) == true) goto L25;
        finish();
        return;
    L25:
        return;
    L20:
        if (O1() != null) goto L27;
        FLogger.f375446a.e("AppletDebuggerActivity", "restored Debugger host is missing");
        finish();
        return;
    L27:
        return;
    L13:
        r103 = null;
        goto L14
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent r100) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        super.onNewIntent(r100);
        setIntent(r100);
        if (P1(r100) == true) goto L6;
        finish();
        return;
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        if (r102 == null) goto L15;
        Bundle r103 = r102.getExtras();
        if (r103 == null) goto L16;
        AppletDebuggerHostFragment r104 = O1();
        if (r104 == null) goto L17;
        Intrinsics.checkNotNullParameter(r103, "bundle");
        ActivityResultCaller r105 = r104.getChatFragment();
        if ((r105 instanceof xe8.a) == false) goto L11;
        xe8.a r106 = (xe8.a) r105;
    L12:
        if (r106 == null) goto L18;
        r106.Lc(r103, 100, -1);
        return;
    L18:
        return;
    L11:
        r106 = null;
        goto L12
    L17:
        return;
    L16:
        return;
    }
}
