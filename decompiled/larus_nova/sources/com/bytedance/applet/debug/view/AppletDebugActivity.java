package com.bytedance.applet.debug.view;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ai.api.DebuggerMode;
import com.bytedance.ai.api.IAppletDebuggerService;
import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.applet.databinding.LarusAppletDebugActivityBinding;
import com.bytedance.applet.debug.AppletDebugManager;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0001DB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0011H\u0014J\u0012\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\"\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0018H\u0014J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\tH\u0016J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\tH\u0016J\b\u0010!\u001a\u00020\u000eH\u0016J\b\u0010\"\u001a\u00020\u000eH\u0016J\b\u0010#\u001a\u00020\u0011H\u0002J\b\u0010$\u001a\u00020\u0011H\u0002J\u0010\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020\u0011H\u0002J\u0010\u0010)\u001a\u00020\u00112\u0006\u0010*\u001a\u00020'H\u0002J\u0012\u0010+\u001a\u00020\u00112\b\b\u0001\u0010,\u001a\u00020\u001bH\u0002J\u0010\u0010+\u001a\u00020\u00112\u0006\u0010-\u001a\u00020'H\u0002J\u0010\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u00020'H\u0002J\"\u00100\u001a\u00020\u00112\u0006\u00101\u001a\u00020'2\u0006\u00102\u001a\u00020'2\b\b\u0002\u00103\u001a\u00020\u000eH\u0002J\u0012\u00104\u001a\u00020\u00112\b\b\u0002\u00105\u001a\u00020\u000eH\u0002J\u0012\u00106\u001a\u00020\u00112\b\b\u0002\u00107\u001a\u00020\u000eH\u0002J\u0010\u00108\u001a\u00020\u00112\u0006\u00109\u001a\u00020:H\u0002J\b\u0010;\u001a\u00020\u0011H\u0002J\u0010\u0010<\u001a\u00020\u00112\u0006\u0010=\u001a\u00020>H\u0002J\b\u0010?\u001a\u00020\u0011H\u0002J \u0010@\u001a\u00020\u00112\u0006\u0010A\u001a\u00020'2\b\u0010B\u001a\u0004\u0018\u00010'H\u0082@¢\u0006\u0002\u0010CR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\t0\bj\n\u0012\u0006\u0012\u0004\u0018\u00010\t`\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/bytedance/applet/debug/view/AppletDebugActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "Lcom/larus/ivykit/xbridge/choosemedia/IActivityResult;", "<init>", "()V", "binding", "Lcom/bytedance/applet/databinding/LarusAppletDebugActivityBinding;", "mActivityResultListeners", "Ljava/util/ArrayList;", "Lcom/larus/ivykit/xbridge/choosemedia/ActivityResultListener;", "Lkotlin/collections/ArrayList;", "installDebugPackageJob", "Lkotlinx/coroutines/Job;", "callerIsMainBotChatPage", "", "getDebugSchemaJob", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "initViews", LiveCommonConstants.REASON_ON_DEDTROY, "onNewIntent", "intent", "Landroid/content/Intent;", "onActivityResult", "requestCode", "", "resultCode", "data", "setActivityResultListener", "listener", "unsetActivityResultListener", "needAdaptStatusBarPadding", "needAdaptNavigationBarPadding", "handleIntent", "navigateToDebugTarget", "openUgcBotChatPage", "botId", "", "openMainBotPage", "finishWithErrorMessage", "errorMessage", "finishWithToast", "textResId", "text", "startGetDebugSchemaAsync", "shortToken", "startDebugModeAsync", "debugInfo", "debugToken", "isLegacy", "showLoadingState", "hideDebugView", "hideLoadingState", "showDebugView", "displayDebugConfig", "debugConfigObj", "Lorg/json/JSONObject;", "showDebugConfig", "showJustExitDialog", "activity", "Landroid/app/Activity;", "restartApp", "navigateToDebuggerActivity", "packageName", "versionTag", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletDebugActivity extends FlowCommonAppCompatActivity implements ug9.b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f191570l = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LarusAppletDebugActivityBinding f191571g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList<ug9.a> f191572h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Job f191573i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f191574j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Job f191575k;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity
    public final boolean H1() {
        return true;
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(AppletDebugActivity.class.getName()));
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
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(AppletDebugActivity.class.getName()));
    L5:
        Job r100 = this.f191575k;
        boolean r101 = false;
        if (r100 != null) goto L8;
    L15:
        Job r102 = this.f191573i;
        if (r102 != null) goto L18;
    L25:
        com.bytedance.ai.utils.g.f37637a.e("AppletDebugActivity", LiveCommonConstants.REASON_ON_DEDTROY);
        super.onDestroy();
        return;
    L18:
        if (r102.isCompleted() != true) goto L20;
        r101 = true;
    L20:
        if (r101 == true) goto L25;
        com.bytedance.ai.utils.g.f37637a.w("AppletDebugActivity", "AppletDebugActivity finish when installDebugPackageJob is NOT Completed");
        Job r103 = this.f191573i;
        if (r103 == null) goto L24;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
    L24:
        AppletDebugManager.c(null, "");
        IAISDKDebugService.Companion r104 = IAISDKDebugService.f36186a;
        r104.l(null, null);
        r104.c(null);
        goto L25
    L8:
        if (r100.isCompleted() != true) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == true) goto L15;
        com.bytedance.ai.utils.g.f37637a.w("AppletDebugActivity", "AppletDebugActivity finish when getDebugSchemaJob is NOT Completed");
        Job r106 = this.f191575k;
        if (r106 == null) goto L15;
        Job.DefaultImpls.cancel$default(r106, null, 1, null);
        goto L15
    L10:
        r105 = false;
        goto L11
    }

    public AppletDebugActivity() {
        this.f191572h = new ArrayList();
    }

    public final void handleIntent() {
        this.f191574j = getIntent().getBooleanExtra("callerIsMainBotChatPage", false);
        String r100 = getIntent().getStringExtra("actionName");
        if (r100 != null) goto L5;
        P1("invalid action");
        return;
    L5:
        if (Intrinsics.areEqual(r100, "showDebugInfo") == false) goto L14;
        S1(false);
        boolean r101 = AppletDebugManager.f191566a;
        String r102 = IAISDKDebugService.f36186a.o();
        if (r102 != null) goto L29;
        P1("DebugInfo is empty");
        return;
    L29:
        O1(new JSONObject(r102));     // Catch: JSONException -> L10
        return;
    L10:
        e = move-exception;
        com.bytedance.ai.utils.g.f37637a.e("AppletDebugActivity", "Failed to parse debugInfo: " + e.getMessage() + ", debugInfo: " + r102);
        Q1(com.larus.nova.R.string.applet_app_invalid_debug_info_cn);
        return;
    L14:
        if (Intrinsics.areEqual(r100, "startDebug") == false) goto L26;
        LarusAppletDebugActivityBinding r103 = this.f191571g;
        if (r103 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r103 = null;
    L18:
        r103.f191497a.post(new g());
        String r104 = getIntent().getStringExtra("shortToken");
        String r105 = getIntent().getStringExtra("debugInfo");
        String r106 = getIntent().getStringExtra("debugToken");
        if (r104 == null) goto L21;
        this.f191575k = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AppletDebugActivity$startGetDebugSchemaAsync$1(this, r104, null), 3, null);
        return;
    L21:
        if (r105 == null) goto L25;
        if (r106 == null) goto L24;
        this.f191573i = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AppletDebugActivity$startDebugModeAsync$1(this, r105, true, r106, null), 3, null);
        return;
    L24:
        P1("debugToken is empty");
        return;
    L25:
        P1("debugInfo is empty");
        return;
    L26:
        P1("invalid action");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
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

    @Override // ug9.b
    public final void I0(ug9.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f191572h.add(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void O1(JSONObject r100) {
        R1(true);
        ArrayList r101 = new ArrayList();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = r102.next();
        r101.add(new Pair(r103, r100.optString(r103)));
        goto L4
    L6:
        DebugInfoAdapter r104 = new DebugInfoAdapter(r101);
        LarusAppletDebugActivityBinding r105 = this.f191571g;
        LarusAppletDebugActivityBinding r106 = null;
        if (r105 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r105 = null;
    L9:
        r105.f191500d.setAdapter(r104);
        LarusAppletDebugActivityBinding r107 = this.f191571g;
        if (r107 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L13:
        r106.f191499c.setVisibility(0);
        AppletDebugManager.f191566a = true;
        Context r108 = v.f191653a;
        Intrinsics.checkNotNullParameter(this, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (v.f191655c.compareAndSet(false, true) == true) goto L16;
        com.bytedance.ai.utils.g.f37637a.i("AppletDebugWindowHelper", "AppletDebugWindowHelper is already initialized. skip it");
    L21:
        v.b(true);
        return;
    L16:
        com.bytedance.ai.utils.g.f37637a.i("AppletDebugWindowHelper", "AppletDebugWindowHelper init");
        if ((this instanceof Application) == false) goto L19;
        Application r109 = (Application) this;
    L20:
        v.f191653a = r109;
        AppHost.Companion r110 = AppHost.f326268a;
        r110.getApplication().registerActivityLifecycleCallbacks(new t());
        v.a(!r110.a().isAppBackground(), r110.a().getCurrentActivity());
        goto L21
    L19:
        Context r111 = getApplicationContext();
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type android.app.Application");
        r109 = (Application) r111;
        goto L20
    L12:
        r106 = r107;
        goto L13
    }

    public final void P1(String r100) {
        com.bytedance.ai.utils.g.f37637a.e("AppletDebugActivity", r100);
        finish();
    }

    public final void Q1(int r100) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AppletDebugActivity$finishWithToast$1(this, r100, null), 3, null);
    }

    public final void R1(boolean r100) {
        LarusAppletDebugActivityBinding r101 = this.f191571g;
        LarusAppletDebugActivityBinding r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r101 = null;
    L5:
        r101.f191502f.setVisibility(8);
        LarusAppletDebugActivityBinding r103 = this.f191571g;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r103 = null;
    L8:
        r103.f191503g.setEnabled(true);
        LarusAppletDebugActivityBinding r104 = this.f191571g;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r104 = null;
    L11:
        r104.f191503g.setAlpha(1.0f);
        LarusAppletDebugActivityBinding r105 = this.f191571g;
        if (r105 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r105 = null;
    L14:
        r105.f191504h.setEnabled(true);
        LarusAppletDebugActivityBinding r106 = this.f191571g;
        if (r106 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r106 = null;
    L17:
        r106.f191504h.setAlpha(1.0f);
        LarusAppletDebugActivityBinding r107 = this.f191571g;
        if (r107 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r107 = null;
    L20:
        r107.f191498b.setEnabled(true);
        LarusAppletDebugActivityBinding r108 = this.f191571g;
        if (r108 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r108 = null;
    L23:
        r108.f191498b.setAlpha(1.0f);
        if (r100 == false) goto L40;
        LarusAppletDebugActivityBinding r109 = this.f191571g;
        if (r109 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r109 = null;
    L28:
        r109.f191499c.setVisibility(0);
        LarusAppletDebugActivityBinding r110 = this.f191571g;
        if (r110 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r110 = null;
    L31:
        r110.f191504h.setVisibility(0);
        LarusAppletDebugActivityBinding r111 = this.f191571g;
        if (r111 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r111 = null;
    L34:
        r111.f191498b.setVisibility(0);
        LarusAppletDebugActivityBinding r112 = this.f191571g;
        if (r112 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L38:
        r102.f191503g.setVisibility(0);
        return;
    L37:
        r102 = r112;
        goto L38
    }

    @Override // ug9.b
    public final void S(com.larus.bmhome.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f191572h.remove(r100);
    }

    public final void S1(boolean r100) {
        LarusAppletDebugActivityBinding r101 = this.f191571g;
        LarusAppletDebugActivityBinding r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r101 = null;
    L5:
        r101.f191502f.setVisibility(0);
        LarusAppletDebugActivityBinding r103 = this.f191571g;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r103 = null;
    L8:
        r103.f191503g.setEnabled(false);
        LarusAppletDebugActivityBinding r104 = this.f191571g;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r104 = null;
    L11:
        r104.f191503g.setAlpha(0.6f);
        LarusAppletDebugActivityBinding r105 = this.f191571g;
        if (r105 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r105 = null;
    L14:
        r105.f191504h.setEnabled(false);
        LarusAppletDebugActivityBinding r106 = this.f191571g;
        if (r106 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r106 = null;
    L17:
        r106.f191504h.setAlpha(0.6f);
        LarusAppletDebugActivityBinding r107 = this.f191571g;
        if (r107 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r107 = null;
    L20:
        r107.f191498b.setEnabled(false);
        LarusAppletDebugActivityBinding r108 = this.f191571g;
        if (r108 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r108 = null;
    L23:
        r108.f191498b.setAlpha(0.6f);
        if (r100 == false) goto L40;
        LarusAppletDebugActivityBinding r109 = this.f191571g;
        if (r109 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r109 = null;
    L28:
        r109.f191499c.setVisibility(8);
        LarusAppletDebugActivityBinding r110 = this.f191571g;
        if (r110 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r110 = null;
    L31:
        r110.f191504h.setVisibility(8);
        LarusAppletDebugActivityBinding r111 = this.f191571g;
        if (r111 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r111 = null;
    L34:
        r111.f191498b.setVisibility(8);
        LarusAppletDebugActivityBinding r112 = this.f191571g;
        if (r112 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L38:
        r102.f191503g.setVisibility(8);
        return;
    L37:
        r102 = r112;
        goto L38
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r110) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r110);
        LarusAppletDebugActivityBinding r100 = null;
        View r111 = getLayoutInflater().inflate(com.larus.nova.R.layout.larus_applet_debug_activity, null, false);
        int r101 = com.larus.nova.R.id.close_debug_button;
        Button r102 = (Button) ViewBindings.findChildViewById(r111, com.larus.nova.R.id.close_debug_button);
        if (r102 == null) goto L54;
        r101 = com.larus.nova.R.id.debug_info_container;
        ScrollView r103 = (ScrollView) ViewBindings.findChildViewById(r111, com.larus.nova.R.id.debug_info_container);
        if (r103 == null) goto L54;
        r101 = com.larus.nova.R.id.debug_info_recycler_view;
        RecyclerView r104 = (RecyclerView) ViewBindings.findChildViewById(r111, com.larus.nova.R.id.debug_info_recycler_view);
        if (r104 == null) goto L54;
        r101 = com.larus.nova.R.id.debug_tag_switch;
        SwitchCompat r105 = (SwitchCompat) ViewBindings.findChildViewById(r111, com.larus.nova.R.id.debug_tag_switch);
        if (r105 == null) goto L54;
        r101 = com.larus.nova.R.id.loading_overlay;
        FrameLayout r106 = (FrameLayout) ViewBindings.findChildViewById(r111, com.larus.nova.R.id.loading_overlay);
        if (r106 == null) goto L54;
        r101 = com.larus.nova.R.id.loading_view;
        if (((ProgressBar) ViewBindings.findChildViewById(r111, com.larus.nova.R.id.loading_view)) == null) goto L54;
        ConstraintLayout r107 = (ConstraintLayout) r111;
        Button r112 = (Button) ViewBindings.findChildViewById(r111, com.larus.nova.R.id.navigate_debug_button);
        if (r112 == null) goto L52;
        Button r113 = (Button) ViewBindings.findChildViewById(r111, com.larus.nova.R.id.version_manager_button);
        if (r113 == null) goto L51;
        this.f191571g = new LarusAppletDebugActivityBinding(r107, r102, r103, r104, r105, r106, r112, r113);
        setContentView(r107);
        getOnBackPressedDispatcher().addCallback(this, new AppletDebugActivity$initViews$callback$1(this));
        LarusAppletDebugActivityBinding r114 = this.f191571g;
        if (r114 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r114 = null;
    L29:
        r114.f191500d.setLayoutManager(new LinearLayoutManager(this));
        LarusAppletDebugActivityBinding r115 = this.f191571g;
        if (r115 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r115 = null;
    L32:
        e1.d(r115.f191498b, new c(this));
        LarusAppletDebugActivityBinding r116 = this.f191571g;
        if (r116 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r116 = null;
    L35:
        e1.d(r116.f191503g, new d(this));
        LarusAppletDebugActivityBinding r117 = this.f191571g;
        if (r117 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r117 = null;
    L38:
        e1.d(r117.f191504h, new e(this));
        LarusAppletDebugActivityBinding r118 = this.f191571g;
        if (r118 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r118 = null;
    L41:
        SwitchCompat r119 = r118.f191501e;
        IAISDKDebugService.f36186a.getClass();
        IAISDKDebugService r108 = IAISDKDebugService.Companion.f36188c;
        if (r108 == null) goto L44;
        boolean r109 = r108.n();
    L45:
        r119.setChecked(r109);
        LarusAppletDebugActivityBinding r120 = this.f191571g;
        if (r120 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L49:
        r100.f191501e.setOnCheckedChangeListener(new f());
        handleIntent();
        return;
    L48:
        r100 = r120;
        goto L49
    L44:
        r109 = true;
        goto L45
    L51:
        r101 = com.larus.nova.R.id.version_manager_button;
        goto L54
    L52:
        r101 = com.larus.nova.R.id.navigate_debug_button;
    L54:
        throw new NullPointerException("Missing required view with ID: ".concat(r111.getResources().getResourceName(r101)));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent r100) {
        super.onNewIntent(r100);
        if (r100 == null) goto L5;
        setIntent(r100);
    L5:
        handleIntent();
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        Iterator<ug9.a> r103 = this.f191572h.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        ug9.a r104 = r103.next();
        if (r104 == null) goto L4;
        r104.onActivityResult(r100, r101, r102);
        goto L4
    }

    public static final Object N1(final AppletDebugActivity r100, String r101, String r110, Continuation r111) {
        r100.getClass();
        if ((r111 instanceof AppletDebugActivity$navigateToDebuggerActivity$1) == false) goto L7;
        AppletDebugActivity$navigateToDebuggerActivity$1 r102 = (AppletDebugActivity$navigateToDebuggerActivity$1) r111;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        AppletDebugActivity$navigateToDebuggerActivity$1 r104 = r102;
        Object r112 = r104.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r104.label;
        boolean r107 = true;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r101 = (String) r104.L$0;
        ResultKt.throwOnFailure(r112);
    L20:
        if (((Boolean) r112).booleanValue() == true) goto L23;
    L22:
        r107 = false;
    L23:
        if (r107 == true) goto L25;
        IAISDKDebugService.Companion r113 = IAISDKDebugService.f36186a;
        r113.l(r101, null);
        r100.Q1(com.larus.nova.R.string.applet_debugger_create_failed);
        r113.c(new b(r100));
    L27:
        return Unit.INSTANCE;
    L25:
        r100.finish();
        goto L27
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        IAISDKDebugService.f36186a.l(r101, r110);
        IAppletDebuggerService r108 = (IAppletDebuggerService) ServiceManager.get().getService(IAppletDebuggerService.class);
        if (r108 == null) goto L22;
        DebuggerMode r109 = DebuggerMode.ONLINE_PREVIEW;
        r104.L$0 = r101;
        r104.label = 1;
        r112 = IAppletDebuggerService.a.a(r108, r100, "scan", r109, r104, 8);
        if (r112 != r105) goto L20;
        return r105;
    L7:
        r102 = new AppletDebugActivity$navigateToDebuggerActivity$1(r100, r111);
        goto L8
    }
}
