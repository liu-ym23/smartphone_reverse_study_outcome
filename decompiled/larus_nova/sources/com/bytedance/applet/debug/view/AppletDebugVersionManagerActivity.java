package com.bytedance.applet.debug.view;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewAppInfo;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewAppInfoList;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewVersion;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewVersionPage;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.applet.databinding.LarusAppletDebugVersionManagerActivityBinding;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 32\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0016H\u0014J\b\u0010\u001a\u001a\u00020\u000eH\u0016J\b\u0010\u001b\u001a\u00020\u000eH\u0016J\b\u0010\u001c\u001a\u00020\u0016H\u0002J\b\u0010\u001d\u001a\u00020\u0016H\u0002J\b\u0010\u001e\u001a\u00020\u0016H\u0002J\u0018\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\fH\u0002J\b\u0010\"\u001a\u00020\u0016H\u0002J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010'\u001a\u00020\u0016H\u0002J\b\u0010(\u001a\u00020\u0016H\u0002J\b\u0010)\u001a\u00020\u0012H\u0002J\b\u0010*\u001a\u00020\u0016H\u0002J\b\u0010+\u001a\u00020\u0016H\u0002J\u001a\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f0-*\u00020%H\u0002J\u0012\u0010.\u001a\b\u0012\u0004\u0012\u0002000/*\u00020%H\u0002J\u000e\u00101\u001a\u0004\u0018\u00010\f*\u000200H\u0002J\b\u00102\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/bytedance/applet/debug/view/AppletDebugVersionManagerActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "binding", "Lcom/bytedance/applet/databinding/LarusAppletDebugVersionManagerActivityBinding;", "adapter", "Lcom/bytedance/applet/debug/view/AppletDebugVersionAdapter;", "loadAppListJob", "Lkotlinx/coroutines/Job;", "submitJob", "nextAppCursor", "", "hasMoreApps", "", "loadingMoreApps", "userScrollingAppList", "appListScrollDistance", "", "originDebugMode", "Lcom/bytedance/ai/debug/IAISDKDebugService$DebugMode;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", LiveCommonConstants.REASON_ON_DEDTROY, "needAdaptStatusBarPadding", "needAdaptNavigationBarPadding", "initViews", "loadFirstPage", "loadMoreApps", "loadMoreVersions", com.heytap.mcssdk.constant.b.f276376z, EffectConfiguration.KEY_CURSOR, "submitChangedConfigs", "bindFirstPage", "result", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewAppInfoList;", "appendAppPage", "updateConfirmButtonState", "updateEmptyView", "loadMoreScrollDistance", "showLoadingState", "hideLoadingState", "toSelectedVersionMap", "", "toDisplayApps", "", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewAppInfo;", "defaultVersionTag", "getXToken", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletDebugVersionManagerActivity extends FlowCommonAppCompatActivity {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f191605q = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LarusAppletDebugVersionManagerActivityBinding f191606g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AppletDebugVersionAdapter f191607h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Job f191608i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Job f191609j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f191610k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f191611l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f191612m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f191613n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f191614o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public IAISDKDebugService.DebugMode f191615p;

    public static final class a {
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity
    public final boolean H1() {
        return true;
    }

    static {
        f191605q = IAISDKDebugService.DebugMode.SCAN_PREVIEW.getValue();
    }

    public final void Q1() {
        com.bytedance.ai.utils.g.f37637a.i("AppletDebugVersionManager", "loadFirstPage");
        this.f191608i = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AppletDebugVersionManagerActivity$loadFirstPage$1(this, null), 3, null);
    }

    public final void S1() {
        AppletDebugVersionAdapter r100 = this.f191607h;
        LarusAppletDebugVersionManagerActivityBinding r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r100 = null;
    L5:
        boolean r102 = !r100.z2().isEmpty();
        LarusAppletDebugVersionManagerActivityBinding r103 = this.f191606g;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r103 = null;
    L8:
        r103.f191509e.setEnabled(r102);
        LarusAppletDebugVersionManagerActivityBinding r104 = this.f191606g;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L12:
        TextView r105 = r101.f191509e;
        if (r102 == false) goto L15;
        float r106 = 1.0f;
    L16:
        r105.setAlpha(r106);
        return;
    L15:
        r106 = 0.6f;
        goto L16
    L11:
        r101 = r104;
        goto L12
    }

    public final void T1() {
        LarusAppletDebugVersionManagerActivityBinding r100 = this.f191606g;
        AppletDebugVersionAdapter r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r100 = null;
    L5:
        TextView r102 = r100.f191510f;
        AppletDebugVersionAdapter r103 = this.f191607h;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L10:
        if (r101.getItemCount() != 0) goto L12;
        int r104 = 0;
    L13:
        r102.setVisibility(r104);
        return;
    L12:
        r104 = 8;
        goto L13
    L8:
        r101 = r103;
        goto L10
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(AppletDebugVersionManagerActivity.class.getName()));
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
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(AppletDebugVersionManagerActivity.class.getName()));
    L5:
        IAISDKDebugService.DebugMode r100 = this.f191615p;
        if (r100 == null) goto L8;
        IAISDKDebugService.f36186a.C(r100);
    L8:
        Job r101 = this.f191608i;
        if (r101 == null) goto L11;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L11:
        Job r102 = this.f191609j;
        if (r102 == null) goto L14;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L14:
        super.onDestroy();
    }

    public AppletDebugVersionManagerActivity() {
        this.f191610k = "";
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

    public static final String N1(AppletDebugVersionManagerActivity r100) {
        r100.getClass();
        Function0<String> r101 = com.larus.platform.service.q.f365787a.f().f547422a;
        if (r101 == null) goto L5;
        String r102 = r101.invoke();
    L6:
        if (r102 != null) goto L9;
        return "";
    L9:
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    public static final void O1(AppletDebugVersionManagerActivity r100) {
        LarusAppletDebugVersionManagerActivityBinding r101 = r100.f191606g;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r101 = null;
    L5:
        r101.f191512h.setVisibility(8);
        r100.S1();
    }

    public static final void P1(AppletDebugVersionManagerActivity r100) {
        LarusAppletDebugVersionManagerActivityBinding r101 = r100.f191606g;
        LarusAppletDebugVersionManagerActivityBinding r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r101 = null;
    L5:
        r101.f191512h.setVisibility(0);
        LarusAppletDebugVersionManagerActivityBinding r103 = r100.f191606g;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L9:
        r102.f191509e.setEnabled(false);
        return;
    L8:
        r102 = r103;
        goto L9
    }

    public static Map R1(OpenPlatformPreviewAppInfoList r100) {
        List<OpenPlatformPreviewAppInfo> r101 = r100.getScanSelectedApps();
        if (r101 != null) goto L5;
        r101 = CollectionsKt.emptyList();
    L5:
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L42;
        OpenPlatformPreviewAppInfo r104 = (OpenPlatformPreviewAppInfo) r103.next();
        String r105 = r104.getAppKey();
        if (r105 != null) goto L11;
        r105 = "";
    L11:
        Object r106 = null;
        if (StringsKt.isBlank(r105) == true) goto L39;
        OpenPlatformPreviewVersion[] r107 = new OpenPlatformPreviewVersion[2];
        List<OpenPlatformPreviewVersion> r108 = r104.getTestVersions();
        if (r108 == null) goto L17;
        OpenPlatformPreviewVersion r109 = (OpenPlatformPreviewVersion) CollectionsKt.firstOrNull(r108);
    L18:
        r107[0] = r109;
        List<OpenPlatformPreviewVersion> r110 = r104.getAuditVersions();
        if (r110 == null) goto L21;
        OpenPlatformPreviewVersion r111 = (OpenPlatformPreviewVersion) CollectionsKt.firstOrNull(r110);
    L22:
        r107[1] = r111;
        List r112 = CollectionsKt.listOfNotNull(r107);
        OpenPlatformPreviewVersionPage r113 = r104.getFormalVersions();
        if (r113 == null) goto L25;
        List<OpenPlatformPreviewVersion> r114 = r113.getItems();
    L26:
        if (r114 != null) goto L28;
        r114 = CollectionsKt.emptyList();
    L28:
        Iterator r115 = CollectionsKt.plus(r112, r114).iterator();
    L30:
        if (r115.hasNext() == false) goto L34;
        Object r116 = r115.next();
        if (Intrinsics.areEqual(((OpenPlatformPreviewVersion) r116).isDefault(), Boolean.TRUE) == false) goto L30;
    L35:
        OpenPlatformPreviewVersion r117 = (OpenPlatformPreviewVersion) r116;
        if (r117 == null) goto L38;
        r106 = r117.getVersionTag();
    L38:
        r106 = TuplesKt.to(r105, r106);
        goto L39
    L34:
        r116 = null;
        goto L35
    L25:
        r114 = null;
        goto L26
    L21:
        r111 = null;
        goto L22
    L17:
        r109 = null;
    L39:
        if (r106 == null) goto L7;
        r102.add(r106);
        goto L7
    L42:
        return MapsKt.toMap(r102);
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r110) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L7;
        v19.f.a(getTheme());     // Catch: Throwable -> L10
    L7:
        if (v19.f.f(this) == false) goto L11;
        v19.f.c(getTheme());     // Catch: Throwable -> L10
    L11:
        super.onCreate(r110);
        IAISDKDebugService.Companion r100 = IAISDKDebugService.f36186a;
        this.f191615p = r100.getDebugMode();
        r100.C(IAISDKDebugService.DebugMode.SCAN_PREVIEW);
        LarusAppletDebugVersionManagerActivityBinding r101 = null;
        View r102 = getLayoutInflater().inflate(com.larus.nova.R.layout.larus_applet_debug_version_manager_activity, null, false);
        int r103 = com.larus.nova.R.id.app_recycler_view;
        RecyclerView r104 = (RecyclerView) ViewBindings.findChildViewById(r102, com.larus.nova.R.id.app_recycler_view);
        if (r104 == null) goto L60;
        r103 = com.larus.nova.R.id.back_button;
        ImageButton r105 = (ImageButton) ViewBindings.findChildViewById(r102, com.larus.nova.R.id.back_button);
        if (r105 == null) goto L60;
        r103 = com.larus.nova.R.id.bottom_bar;
        FrameLayout r106 = (FrameLayout) ViewBindings.findChildViewById(r102, com.larus.nova.R.id.bottom_bar);
        if (r106 == null) goto L60;
        r103 = com.larus.nova.R.id.confirm_button;
        TextView r111 = (TextView) ViewBindings.findChildViewById(r102, com.larus.nova.R.id.confirm_button);
        if (r111 == null) goto L60;
        r103 = com.larus.nova.R.id.empty_view;
        TextView r112 = (TextView) ViewBindings.findChildViewById(r102, com.larus.nova.R.id.empty_view);
        if (r112 == null) goto L60;
        r103 = com.larus.nova.R.id.list_load_more_progress;
        ProgressBar r113 = (ProgressBar) ViewBindings.findChildViewById(r102, com.larus.nova.R.id.list_load_more_progress);
        if (r113 == null) goto L60;
        r103 = com.larus.nova.R.id.loading_overlay;
        FrameLayout r114 = (FrameLayout) ViewBindings.findChildViewById(r102, com.larus.nova.R.id.loading_overlay);
        if (r114 == null) goto L60;
        r103 = com.larus.nova.R.id.nav_bar;
        FrameLayout r115 = (FrameLayout) ViewBindings.findChildViewById(r102, com.larus.nova.R.id.nav_bar);
        if (r115 == null) goto L60;
        r103 = com.larus.nova.R.id.refresh_button;
        ImageButton r116 = (ImageButton) ViewBindings.findChildViewById(r102, com.larus.nova.R.id.refresh_button);
        if (r116 == null) goto L60;
        ConstraintLayout r107 = (ConstraintLayout) r102;
        if (((TextView) ViewBindings.findChildViewById(r102, com.larus.nova.R.id.title_text)) == null) goto L58;
        this.f191606g = new LarusAppletDebugVersionManagerActivityBinding(r107, r104, r105, r106, r111, r112, r113, r114, r115, r116, r107);
        setContentView(r107);
        B1(getResources().getColor(com.larus.nova.R.color.applet_app_debug_version_manager_background));
        LarusAppletDebugVersionManagerActivityBinding r108 = this.f191606g;
        if (r108 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r108 = null;
    L34:
        r108.f191515k.setBackgroundColor(ContextCompat.getColor(this, com.larus.nova.R.color.applet_app_debug_version_manager_background));
        this.f191607h = new AppletDebugVersionAdapter(new AppletDebugVersionManagerActivity$initViews$1(this), new AppletDebugVersionManagerActivity$initViews$2(this));
        LarusAppletDebugVersionManagerActivityBinding r109 = this.f191606g;
        if (r109 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r109 = null;
    L37:
        r109.f191506b.setLayoutManager(new LinearLayoutManager(this));
        LarusAppletDebugVersionManagerActivityBinding r117 = this.f191606g;
        if (r117 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r117 = null;
    L40:
        RecyclerView r118 = r117.f191506b;
        AppletDebugVersionAdapter r119 = this.f191607h;
        if (r119 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r119 = null;
    L43:
        r118.setAdapter(r119);
        LarusAppletDebugVersionManagerActivityBinding r120 = this.f191606g;
        if (r120 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r120 = null;
    L46:
        r120.f191506b.addOnScrollListener(new AppletDebugVersionManagerActivity$initViews$3(this));
        LarusAppletDebugVersionManagerActivityBinding r121 = this.f191606g;
        if (r121 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r121 = null;
    L49:
        e1.d(r121.f191507c, new o(this));
        LarusAppletDebugVersionManagerActivityBinding r122 = this.f191606g;
        if (r122 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r122 = null;
    L52:
        e1.d(r122.f191514j, new p(this));
        LarusAppletDebugVersionManagerActivityBinding r123 = this.f191606g;
        if (r123 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L56:
        e1.d(r101.f191509e, new q(this));
        S1();
        Q1();
        return;
    L55:
        r101 = r123;
        goto L56
    L58:
        r103 = com.larus.nova.R.id.title_text;
    L60:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
