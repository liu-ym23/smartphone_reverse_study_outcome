package com.bytedance.ai.applet.app;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.view.View;
import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ai.applet.app.base.ApplicationRouter;
import com.bytedance.ai.applet.app.base.BaseActivity;
import com.bytedance.ai.applet.app.base.RouteOptions;
import com.bytedance.ai.applet.app.foundation.RouteAction;
import com.bytedance.ai.applet.app.foundation.performance.AppletPerformanceErrorCode;
import com.bytedance.ai.applet.app.foundation.performance.AppletPerformanceOutcome;
import com.bytedance.ai.applet.app.foundation.v;
import com.bytedance.ai.applet.components.input.AppletChatInputController;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.Page;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.common.applog.EventVerify;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000Ë\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u001b\b&\u0018\u0000 \u0087\u00012\u00020\u0001:\u0004\u0087\u0001\u0088\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010%\u001a\u00020&H$J\b\u0010'\u001a\u00020&H$J\b\u0010(\u001a\u00020&H\u0014J\b\u0010)\u001a\u00020&H\u0014J\u0015\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020,H\u0010¢\u0006\u0002\b-J\u0012\u0010.\u001a\u00020&2\b\u0010/\u001a\u0004\u0018\u000100H\u0014J\u0010\u00101\u001a\u00020&2\u0006\u00102\u001a\u00020\u0017H\u0002J\u0012\u00103\u001a\u00020&2\b\u00104\u001a\u0004\u0018\u000105H\u0014J\u0010\u00106\u001a\u00020&2\u0006\u00107\u001a\u000208H\u0016J\u0010\u00109\u001a\u00020&2\u0006\u0010:\u001a\u00020\u0013H\u0014J\b\u0010;\u001a\u00020&H\u0002J\u0012\u0010<\u001a\u00020&2\b\u00104\u001a\u0004\u0018\u000105H\u0002J'\u0010=\u001a\b\u0012\u0004\u0012\u00020&0>2\u0006\u0010?\u001a\u00020@2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B¢\u0006\u0004\bC\u0010DJ\b\u0010E\u001a\u00020&H\u0014J\b\u0010F\u001a\u00020&H\u0014J\b\u0010G\u001a\u00020&H\u0014J\u0010\u0010H\u001a\u00020&2\u0006\u0010I\u001a\u000200H\u0014J\b\u0010J\u001a\u00020&H\u0014J\b\u0010K\u001a\u00020&H\u0016J\r\u0010L\u001a\u00020&H\u0010¢\u0006\u0002\bMJ\b\u0010N\u001a\u00020&H\u0016J\b\u0010O\u001a\u00020&H\u0016J\u0011\u0010P\u001a\u0004\u0018\u00010QH\u0000¢\u0006\u0004\bR\u0010SJ\u000f\u0010T\u001a\u0004\u0018\u00010\u0017H\u0000¢\u0006\u0002\bUJ\u0012\u0010V\u001a\u00020&2\b\u0010W\u001a\u0004\u0018\u00010\u0017H\u0002J\u0019\u0010X\u001a\u00020\u00152\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010ZJ!\u0010[\u001a\b\u0012\u0004\u0012\u00020&0>2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010]H\u0002¢\u0006\u0004\b^\u0010_J)\u0010`\u001a\b\u0012\u0004\u0012\u00020&0>2\u0006\u0010W\u001a\u00020\u00172\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010]H\u0002¢\u0006\u0004\ba\u0010bJ)\u0010c\u001a\b\u0012\u0004\u0012\u00020&0>2\u0006\u0010W\u001a\u00020\u00172\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010]H\u0002¢\u0006\u0004\bd\u0010bJ)\u0010e\u001a\b\u0012\u0004\u0012\u00020&0>2\u0006\u0010W\u001a\u00020\u00172\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010]H\u0002¢\u0006\u0004\bf\u0010bJ1\u0010g\u001a\b\u0012\u0004\u0012\u00020&0>2\u0006\u0010W\u001a\u00020\u00172\u0006\u0010:\u001a\u00020h2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010]H\u0002¢\u0006\u0004\bi\u0010jJ\u001a\u0010k\u001a\u0004\u0018\u00010l2\u0006\u0010W\u001a\u00020\u00172\u0006\u0010m\u001a\u00020\u0015H\u0002J/\u0010n\u001a\b\u0012\u0004\u0012\u00020&0>2\u0006\u0010o\u001a\u00020l2\u0006\u0010W\u001a\u00020\u00172\b\u0010\\\u001a\u0004\u0018\u00010]H\u0002¢\u0006\u0004\bp\u0010qJ\b\u0010r\u001a\u00020&H\u0002J\u001d\u0010s\u001a\u00020&2\u0006\u0010t\u001a\u00020\u00192\u0006\u0010+\u001a\u00020,H\u0000¢\u0006\u0002\buJ\u0018\u0010v\u001a\u00020&2\u0006\u0010t\u001a\u00020\u00192\u0006\u0010w\u001a\u00020\u0015H\u0002J\u0010\u0010x\u001a\u00020&2\u0006\u00102\u001a\u00020\u0017H\u0002J\u001b\u0010y\u001a\b\u0012\u0004\u0012\u00020&0>2\u0006\u0010z\u001a\u00020\u0013¢\u0006\u0004\b{\u0010|J\u001a\u0010}\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170~0>¢\u0006\u0005\b\u007f\u0010\u0080\u0001J\b\u0010\u0081\u0001\u001a\u00030\u0082\u0001J\f\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u0001H\u0016J\n\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0084.¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0012\u0010!\u001a\u00020\"X \u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006\u0089\u0001"}, d2 = {"Lcom/bytedance/ai/applet/app/AppletAppActivity;", "Lcom/bytedance/ai/applet/app/base/BaseActivity;", "<init>", "()V", "logger", "Lcom/bytedance/ai/applet/base/log/InstanceLogger;", "getLogger", "()Lcom/bytedance/ai/applet/base/log/InstanceLogger;", "value", "Lcom/bytedance/ai/api/model/ability/IAIAbilities;", "abilities", "getAbilities", "()Lcom/bytedance/ai/api/model/ability/IAIAbilities;", "_application", "Lcom/bytedance/ai/applet/app/AppletApplication;", "application", "getApplication", "()Lcom/bytedance/ai/applet/app/AppletApplication;", "appliedNightMode", "", "hasRootPage", "", "currentPagePathSnapshot", "", "initialPageStateSource", "Landroidx/fragment/app/Fragment;", "rootBackPressedCallback", "com/bytedance/ai/applet/app/AppletAppActivity$rootBackPressedCallback$1", "Lcom/bytedance/ai/applet/app/AppletAppActivity$rootBackPressedCallback$1;", "chatInputController", "Lcom/bytedance/ai/applet/components/input/AppletChatInputController;", "getChatInputController$ai_sdk_release", "()Lcom/bytedance/ai/applet/components/input/AppletChatInputController;", "showMode", "Lcom/bytedance/ai/applet/app/AppletShowMode;", "getShowMode$ai_sdk_release", "()Lcom/bytedance/ai/applet/app/AppletShowMode;", "handleRootBackPressed", "", "setupHostContent", "onHostThemeChanged", "destroyHostAuxiliaryContentNow", "onCurrentPageContentStateChanged", "state", "Lcom/bytedance/ai/applet/app/AppletPageContentState;", "onCurrentPageContentStateChanged$ai_sdk_release", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "failHostCreation", "message", "onNewIntent", "intent", "Landroid/content/Intent;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onNightModeChanged", "mode", "checkThemChanged", "handleIntent", "performRouteAction", "Lkotlin/Result;", "action", "Lcom/bytedance/ai/applet/app/foundation/RouteAction;", SocialConstants.PARAM_RECEIVER, "Landroid/os/ResultReceiver;", "performRouteAction-gIAlu-s", "(Lcom/bytedance/ai/applet/app/foundation/RouteAction;Landroid/os/ResultReceiver;)Ljava/lang/Object;", WidgetCostModule.TYPE_ON_START, "onResume", "onStop", "onSaveInstanceState", "outState", LiveCommonConstants.REASON_ON_DEDTROY, VideoEventOneOutSync.END_TYPE_FINISH, "closeAppView", "closeAppView$ai_sdk_release", "showChatInput", "hideChatInput", "currentPageTraceId", "", "currentPageTraceId$ai_sdk_release", "()Ljava/lang/Long;", "currentPagePath", "currentPagePath$ai_sdk_release", "updateCurrentPagePath", "url", "hostTaskMoveToFront", "preferredTaskId", "(Ljava/lang/Integer;)Z", EventVerify.TYPE_LAUNCH, "options", "Lcom/bytedance/ai/applet/app/base/RouteOptions;", "launch-IoAF18A", "(Lcom/bytedance/ai/applet/app/base/RouteOptions;)Ljava/lang/Object;", "navigateTo", "navigateTo-gIAlu-s", "(Ljava/lang/String;Lcom/bytedance/ai/applet/app/base/RouteOptions;)Ljava/lang/Object;", "redirectTo", "redirectTo-gIAlu-s", "reLaunch", "reLaunch-gIAlu-s", SendEventContainerMethodParamModel.EventKinds.openPage, "Lcom/bytedance/ai/applet/app/base/ApplicationRouter$OpenPageMode;", "openPage-0E7RQCE", "(Ljava/lang/String;Lcom/bytedance/ai/applet/app/base/ApplicationRouter$OpenPageMode;Lcom/bytedance/ai/applet/app/base/RouteOptions;)Ljava/lang/Object;", "findReusablePage", "Lcom/bytedance/ai/applet/app/AppletAppActivity$ReusablePage;", "topOnly", "reusePage", "reusablePage", "reusePage-0E7RQCE", "(Lcom/bytedance/ai/applet/app/AppletAppActivity$ReusablePage;Ljava/lang/String;Lcom/bytedance/ai/applet/app/base/RouteOptions;)Ljava/lang/Object;", "destroyAllPageFragmentsNow", "updatePageContentState", WidgetService.PARAM_FRAGMENT, "updatePageContentState$ai_sdk_release", "markInitialPageLoadingIfNeeded", "isInitialPage", "showInitialPageCreationErrorIfNeeded", "navigateBack", "delta", "navigateBack-IoAF18A", "(I)Ljava/lang/Object;", "getCurrentPageRoutes", "", "getCurrentPageRoutes-d1pmJ48", "()Ljava/lang/Object;", "reLaunchApp", "Lkotlinx/coroutines/Job;", "getMenuButton", "Landroid/view/View;", "getMenuButtonBoundingClientRect", "Landroid/graphics/Rect;", "Companion", "ReusablePage", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AppletAppActivity extends BaseActivity {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f34069j = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.ai.applet.base.log.d f34070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g2.b f34071d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AppletApplication f34072e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f34073f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f34074g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile String f34075h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Fragment f34076i;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Fragment f34077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f34078b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f34077a, r101.f34077a) == true) goto L12;
            return false;
        L12:
            if (this.f34078b == r101.f34078b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f34077a.hashCode() * 31) + this.f34078b;
        }

        public final String toString() {
            return "ReusablePage(fragment=" + this.f34077a + ", pagesAbove=" + this.f34078b + ')';
        }

        public b(Fragment r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
            this.f34077a = r100;
            this.f34078b = r101;
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34079a = null;

        static {
            int[] r100 = new int[ApplicationRouter.OpenPageMode.values().length];
            r100[ApplicationRouter.OpenPageMode.PUSH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[ApplicationRouter.OpenPageMode.REPLACE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[ApplicationRouter.OpenPageMode.NAVIGATE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[ApplicationRouter.OpenPageMode.POP_TO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f34079a = r100;
        }
    }

    static {
    }

    public void D1() {
    }

    public AppletChatInputController H1() {
        return null;
    }

    public View I1() {
        return null;
    }

    public abstract AppletShowMode L1();

    public abstract void N1();

    public void S1(t r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    public void T1() {
    }

    public abstract void Y1();

    public void B1() {
        this.f34070c.c("closeAppView:");
        finish();
    }

    public Rect K1() {
        return new Rect();
    }

    public void O1() {
        com.bytedance.ai.applet.base.log.d.d(this.f34070c, "hideChatInput: unsupported by ".concat(getClass().getSimpleName()));
    }

    public void Z1() {
        com.bytedance.ai.applet.base.log.d.d(this.f34070c, "showChatInput: unsupported by ".concat(getClass().getSimpleName()));
    }

    @Override // com.bytedance.ai.applet.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void finish() {
        this.f34070c.c("finish:");
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L56;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(getClass().getName()));
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

    @Override // com.bytedance.ai.applet.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        this.f34070c.c("onDestroy:");
        this.f34076i = null;
        this.f34075h = null;
        AppletApplication r100 = this.f34072e;
        if (r100 == null) goto L13;
        Intrinsics.checkNotNullParameter(this, PerfLog.PARAM_KEY_CONTEXT_ID);
        r100.i().c("onActivityDestroy");
        r100.u(this);
        if (r100.f34091j == false) goto L11;
        r100.i().c("onActivityDestroy, terminating, need uninstall");
        r100.g();
        goto L13
    L11:
        if (r100.e() == false) goto L13;
        r100.i().c("onActivityDestroy, canDestroy is true, schedule destruction");
        r100.H();
    L13:
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        this.f34070c.c("onResume:");
        super.onResume();
        A1();
        AppletApplication r100 = this.f34072e;
        if (r100 == null) goto L6;
        r100.y(this);
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        this.f34070c.c("onStop:");
        super.onStop();
        AppletApplication r100 = this.f34072e;
        if (r100 == null) goto L6;
        r100.B(this);
        return;
    }

    public AppletAppActivity() {
        this.f34070c = new com.bytedance.ai.applet.base.log.d("AppletAppActivity", null);
        OnBackPressedCallback r100 = new AppletAppActivity$rootBackPressedCallback$1(this);
        getOnBackPressedDispatcher().addCallback(r100);
    }

    public final void A1() {
        int r100 = getResources().getConfiguration().uiMode & 48;
        if (r100 != this.f34073f) goto L5;
        return;
    L5:
        this.f34070c.c("checkThemChanged: mode = " + r100);
        this.f34073f = r100;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r101 = AppletRuntimeManager.f36749d;
        if (r101 != null) goto L8;
    L12:
        T1();
        return;
    L8:
        if (r100 != 32) goto L10;
        boolean r102 = true;
    L11:
        r101.b(r102);
        goto L12
    L10:
        r102 = false;
        goto L11
    }

    public final Long C1() {
        List<Fragment> r100 = getSupportFragmentManager().getFragments();
        ListIterator<Fragment> r101 = r100.listIterator(r100.size());
    L4:
        if (r101.hasPrevious() == false) goto L13;
        Fragment r102 = r101.previous();
        Fragment r103 = r102;
        if (r103.getId() == com.larus.nova.R.id.app_page_container) goto L8;
    L10:
        boolean r104 = false;
    L11:
        if (r104 == false) goto L4;
    L14:
        Fragment r105 = r102;
        if (r105 != null) goto L17;
        return null;
    L17:
        return t2.b.b(r105);
    L8:
        if (r103.isAdded() == false) goto L10;
        r104 = true;
        goto L11
    L13:
        r102 = null;
        goto L14
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        A1();
    }

    public final void F1(String r100) {
        AtomicInteger r101 = com.bytedance.ai.applet.base.log.d.f34519d;
        this.f34070c.a("onCreate: " + r100, null);
        Intent r102 = getIntent();
        Intrinsics.checkNotNullParameter(r102, "<this>");
        ResultReceiver r103 = (ResultReceiver) r102.getParcelableExtra("route_result_receiver");
        if (r103 == null) goto L5;
        com.bytedance.ai.applet.app.foundation.i.a(r103, r100);
    L5:
        B1();
    }

    public final void M1(Intent r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        RouteAction r101 = (RouteAction) r100.getParcelableExtra("route_action");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ResultReceiver r102 = (ResultReceiver) r100.getParcelableExtra("route_result_receiver");
        if (r101 == null) goto L7;
        Result.m9448boximpl(U1(r101, r102));
        return;
    L7:
        this.f34070c.c("handleIntent: action is null");
    }

    public boolean P1(Integer r100) {
        com.bytedance.ai.applet.base.log.d.d(this.f34070c, "hostTaskMoveToFront: unsupported by ".concat(getClass().getSimpleName()));
        return false;
    }

    public final Object Q1(int r100) {
        String r101 = null;
        if (r100 > 0) goto L6;
        AtomicInteger r102 = com.bytedance.ai.applet.base.log.d.f34519d;
        this.f34070c.a("navigateBack: delta must be a positive number, but was " + r100, null);
        Result.Companion r103 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new IllegalArgumentException("delta must be a positive number.")));
    L6:
        int r104 = getSupportFragmentManager().getBackStackEntryCount();
        if (r104 != 0) goto L10;
        this.f34070c.c("navigateBack: back stack is empty, handle root back press");
        N1();
        Result.Companion r105 = Result.Companion;
        return Result.m9449constructorimpl(Unit.INSTANCE);
    L10:
        int r106 = getSupportFragmentManager().getBackStackEntryAt(r104 - Math.min(r100, r104)).getId();
        if (getSupportFragmentManager().popBackStackImmediate(r106, 1) == false) goto L28;
        List<Fragment> r107 = getSupportFragmentManager().getFragments();
        ListIterator<Fragment> r108 = r107.listIterator(r107.size());
    L14:
        if (r108.hasPrevious() == false) goto L23;
        Fragment r109 = r108.previous();
        Fragment r110 = r109;
        if (r110.getId() == com.larus.nova.R.id.app_page_container) goto L18;
    L20:
        boolean r111 = false;
    L21:
        if (r111 == false) goto L14;
    L24:
        Fragment r112 = r109;
        if (r112 == null) goto L27;
        r101 = t2.b.c(r112);
    L27:
        b2(r101);
        Result.Companion r113 = Result.Companion;
        return Result.m9449constructorimpl(Unit.INSTANCE);
    L18:
        if (r110.isAdded() == false) goto L20;
        r111 = true;
        goto L21
    L23:
        r109 = null;
        goto L24
    L28:
        AtomicInteger r114 = com.bytedance.ai.applet.base.log.d.f34519d;
        this.f34070c.a("navigateBack: popBackStackImmediate failed for entryId " + r106, null);
        Result.Companion r115 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException("Failed to navigate back.")));
    }

    public final void a2(String r100) {
        if (this.f34074g == false) goto L5;
        return;
    L5:
        if (this.f34076i != null) goto L9;
        S1(new t.b(r100));
        return;
    }

    public final void b2(String r100) {
        String r101 = null;
        if (r100 == null) goto L12;
        String r102 = t2.c.a(r100);
        if (r102 == null) goto L12;
        if (r102.length() <= 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
        r101 = r102;
        goto L12
    L9:
        r103 = false;
    L12:
        this.f34075h = r101;
    }

    @Override // com.bytedance.ai.applet.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L14
        if (dc9.d.a() == true) goto L16;
        int r101 = getRequestedOrientation();     // Catch: Throwable -> L14
        Integer r102 = Integer.valueOf(r100.orientation);     // Catch: Throwable -> L14
        if (r102 != null) goto L9;
    L11:
        if (r101 != 3) goto L16;
        setRequestedOrientation(1);     // Catch: Throwable -> L14
        FLogger.f375446a.i("PadLancet", "onConfigurationChanged, phone reset page:" + getClass().getSimpleName() + " portrait");     // Catch: Throwable -> L14
        goto L16
    L9:
        if (r102.intValue() != r101) goto L11;
    L16:
        this.f34070c.c("onConfigurationChanged: uiMode = " + r100.uiMode);
        A1();
        return;
    L14:
        th = move-exception;
        FLogger.f375446a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
        goto L16
    }

    @Override // com.bytedance.ai.applet.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        this.f34070c.c("onCreate:");
        super.onCreate(null);
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r101 = AppletRuntimeManager.f36749d;
        if (r101 != null) goto L13;
        F1("aiAbility is null");
        return;
    L13:
        this.f34071d = r101;
        Uri r102 = getIntent().getData();
        if (r102 == null) goto L16;
        String r103 = r102.toString();
    L17:
        if (r103 != null) goto L19;
    L22:
        boolean r104 = true;
    L23:
        if (r104 == false) goto L25;
        F1("appId is empty");
        return;
    L25:
        this.f34070c.c("onCreate: appId = " + r103);
        AppletAppManagerService.INSTANCE.getClass();
        AppletApplication r105 = AppletAppManagerService.a(r103);
        if (r105 != null) goto L28;
        F1("appId not found: ".concat(r103));
        return;
    L28:
        this.f34072e = r105;
        r105.r(this);
        Y1();
        if (r100 == null) goto L31;
        String r106 = r100.getString("restored_launch_url");
    L32:
        if (r106 == null) goto L34;
        this.f34070c.c("onCreate: restoring launch url = ".concat(r106));
        Result.m9448boximpl(R1(r106, null));
        return;
    L34:
        M1(getIntent());
        return;
    L31:
        r106 = null;
        goto L32
    L19:
        if (r103.length() == 0) goto L22;
        r104 = false;
        goto L23
    L16:
        r103 = null;
        goto L17
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent r100) {
        super.onNewIntent(r100);
        if (r100 == null) goto L7;
        Uri r101 = r100.getData();
        if (r101 == null) goto L7;
        String r102 = r101.toString();
    L8:
        AppletApplication r103 = this.f34072e;
        if (r103 == null) goto L11;
        String r104 = r103.getAppId();
    L12:
        if (r102 != null) goto L14;
    L19:
        M1(r100);
        return;
    L14:
        if (Intrinsics.areEqual(r102, r104) == true) goto L19;
        String r105 = "onNewIntent: appId mismatch, currentAppId=" + r104 + ", incomingAppId=" + r102 + ", taskId=" + getTaskId();
        com.bytedance.ai.applet.base.log.d r106 = this.f34070c;
        AtomicInteger r107 = com.bytedance.ai.applet.base.log.d.f34519d;
        r106.a(r105, null);
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ResultReceiver r108 = (ResultReceiver) r100.getParcelableExtra("route_result_receiver");
        if (r108 == null) goto L21;
        com.bytedance.ai.applet.app.foundation.i.a(r108, r105);
        return;
    L21:
        return;
    L11:
        r104 = null;
    L7:
        r102 = null;
        goto L8
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public void onNightModeChanged(int r100) {
        super.onNightModeChanged(r100);
        this.f34070c.c("onNightModeChanged: mode = " + r100);
        A1();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onSaveInstanceState(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "outState");
        Iterator<T> r101 = getSupportFragmentManager().getFragments().iterator();
    L3:
        String r102 = null;
        if (r101.hasNext() == false) goto L13;
        Object r103 = r101.next();
        Fragment r104 = (Fragment) r103;
        if (r104.getId() == com.larus.nova.R.id.app_page_container) goto L8;
    L10:
        boolean r105 = false;
    L11:
        if (r105 == false) goto L3;
    L14:
        Fragment r106 = (Fragment) r103;
        if (r106 == null) goto L17;
        r102 = t2.b.c(r106);
    L17:
        if (r102 == null) goto L19;
        this.f34070c.c("onSaveInstanceState: launchUrl=".concat(r102));
        r100.putString("restored_launch_url", r102);
    L19:
        super.onSaveInstanceState(r100);
        return;
    L8:
        if (r104.isAdded() == false) goto L10;
        r105 = true;
        goto L11
    L13:
        r103 = null;
        goto L14
    }

    public final b G1(String r110, boolean r111) {
        final AppletApplication r100 = this.f34072e;
        if (r100 != null) goto L5;
        return null;
    L5:
        final Page r112 = r100.j().q(r110);
        if (r112 != null) goto L8;
        return null;
    L8:
        List<Fragment> r101 = getSupportFragmentManager().getFragments();
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L9:
        boolean r104 = false;
        if (r103.hasNext() == false) goto L18;
        Object r105 = r103.next();
        Fragment r106 = (Fragment) r105;
        if (r106.getId() == com.larus.nova.R.id.app_page_container) goto L14;
    L16:
        if (r104 == false) goto L9;
        r102.add(r105);
        goto L9
    L14:
        if (r106.isAdded() == false) goto L16;
        r104 = true;
        goto L16
    L18:
        Function1 r107 = new e(r100, r112);
        if (r111 == false) goto L27;
        Integer r113 = Integer.valueOf(CollectionsKt.getLastIndex(r102));
        int r114 = r113.intValue();
        if (r114 >= 0) goto L23;
    L25:
        if (r104 == true) goto L40;
    L39:
        r113 = null;
    L40:
        if (r113 == null) goto L43;
        int r115 = r113.intValue();
        return new b((Fragment) ListProtector.get(r102, r115), CollectionsKt.getLastIndex(r102) - r115);
    L43:
        return null;
    L23:
        if (((Boolean) r107.invoke(ListProtector.get(r102, r114))).booleanValue() == false) goto L25;
        r104 = true;
        goto L25
    L27:
        ListIterator r116 = r102.listIterator(r102.size());
    L29:
        if (r116.hasPrevious() == false) goto L33;
        if (((Boolean) r107.invoke(r116.previous())).booleanValue() == false) goto L29;
        int r117 = r116.nextIndex();
    L34:
        r113 = Integer.valueOf(r117);
        if (r113.intValue() < 0) goto L37;
        r104 = true;
    L37:
        if (r104 == false) goto L39;
    L33:
        r117 = -1;
        goto L34
    }

    public final Object R1(String r100, RouteOptions r110) {
        AppletApplication r101 = this.f34072e;
        if (r101 == null) goto L5;
        Fragment r111 = r101.t(this, r100, r110);
    L6:
        if (r111 != null) goto L9;
        String r112 = "Failed to create page for url: " + r100;
        AtomicInteger r102 = com.bytedance.ai.applet.base.log.d.f34519d;
        this.f34070c.a("navigateTo: fragment is null, openPath = " + r100, null);
        a2(r112);
        Result.Companion r103 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException(r112)));
    L9:
        t2.b.d(r111, r100);
        boolean r104 = !this.f34074g;
        if (r104 == true) goto L12;
    L15:
        FragmentTransaction r105 = getSupportFragmentManager().beginTransaction();
        if (r104 == true) goto L19;
        r105.setCustomAnimations(com.larus.nova.R.anim.applet_router_slide_in_right, com.larus.nova.R.anim.applet_router_slide_out_left, com.larus.nova.R.anim.applet_router_slide_in_left, com.larus.nova.R.anim.applet_router_slide_out_right);
    L19:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r105, r111, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, com.larus.nova.R.id.app_page_container) == true) goto L22;
        r105.add(com.larus.nova.R.id.app_page_container, r111);
    L22:
        if (r104 == true) goto L24;
        r105.addToBackStack(null);
    L24:
        r105.commitAllowingStateLoss();
        this.f34074g = true;
        b2(r100);
        Result.Companion r106 = Result.Companion;
        return Result.m9449constructorimpl(Unit.INSTANCE);
    L12:
        if (this.f34076i != null) goto L15;
        this.f34076i = r111;
        S1(t.c.f34428a);
        goto L15
    L5:
        r111 = null;
        goto L6
    }

    public final Object U1(RouteAction r110, ResultReceiver r111) {
        Intrinsics.checkNotNullParameter(r110, "action");
        this.f34070c.c("performRouteAction: performing action: " + r110);
        RouteOptions r100 = r110.a();
        if (r100 == null) goto L13;
        Long r101 = r100.f34165b;
        if (r101 == null) goto L13;
        long r102 = r101.longValue();
        AppletApplication r103 = this.f34072e;
        if (r103 == null) goto L13;
        v r104 = r103.h();
        if (r104 == null) goto L13;
        com.bytedance.ai.applet.app.foundation.performance.c r105 = r104.c();
        if (r105 == null) goto L13;
        com.bytedance.ai.applet.app.foundation.performance.r r106 = r105.f(r102);
    L14:
        if (r106 == null) goto L16;
        r106.t();
    L16:
        boolean r107 = true;
        if ((r110 instanceof RouteAction.Launch) == false) goto L41;
        RouteOptions r108 = ((RouteAction.Launch) r110).f34190a;
        if (this.f34074g == false) goto L33;
        if (r108 == null) goto L32;
        Long r109 = r108.f34165b;
        if (r109 == null) goto L32;
        long r112 = r109.longValue();
        AppletApplication r113 = this.f34072e;
        if (r113 == null) goto L32;
        v r114 = r113.h();
        if (r114 == null) goto L32;
        com.bytedance.ai.applet.app.foundation.performance.c r115 = r114.c();
        if (r115 == null) goto L32;
        com.bytedance.ai.applet.app.foundation.performance.r r116 = r115.f(r112);
        if (r116 == null) goto L32;
        AtomicLong r117 = com.bytedance.ai.applet.app.foundation.performance.k.f34338g;
        com.bytedance.ai.applet.app.foundation.performance.k.d(r116, AppletPerformanceOutcome.CANCELLED, 0, AppletPerformanceErrorCode.CANCELLED, "cancelled", 2);
    L32:
        Result.Companion r118 = Result.Companion;
        Object r119 = Result.m9449constructorimpl(Unit.INSTANCE);
    L91:
        if (Result.m9456isSuccessimpl(r119) == false) goto L115;
        Unit r120 = (Unit) r119;
        this.f34070c.c("performRouteAction: action " + r110 + " performed successfully");
        RouteOptions r121 = r110.a();
        if (r121 == null) goto L95;
        String r122 = r121.f34164a;
    L96:
        if (r122 != null) goto L98;
    L101:
        if (r107 == true) goto L113;
        this.f34070c.c("performRouteAction: conversationId = " + r122);
        AppletApplication r123 = this.f34072e;
        if (r123 == null) goto L113;
        v r124 = r123.h();
        if (r124 == null) goto L113;
        com.bytedance.ai.applet.app.foundation.a r125 = r124.b();
        if (r125 == null) goto L113;
        Intrinsics.checkNotNullParameter(r122, "conversationId");
        r125.f34201b = r122;
        AppletAppActivity r126 = r125.f34200a.f34085d;
        if (r126 == null) goto L113;
        AppletChatInputController r127 = r126.H1();
        if (r127 == null) goto L113;
        r127.q7(r122);
    L113:
        if (r111 == null) goto L115;
        Intrinsics.checkNotNullParameter(r111, "<this>");
        r111.send(0, null);
        goto L115
    L98:
        if (r122.length() == 0) goto L101;
        r107 = false;
        goto L101
    L95:
        r122 = null;
    L115:
        Throwable r128 = Result.m9452exceptionOrNullimpl(r119);
        if (r128 == null) goto L125;
        this.f34070c.a("performRouteAction: action " + r110 + " performed with error: " + r128.getMessage(), null);
        if (r106 == null) goto L123;
        AppletPerformanceErrorCode r129 = AppletPerformanceErrorCode.ROUTE_ERROR;
        String r130 = r128.getMessage();
        if (r130 != null) goto L122;
        r130 = r128.getClass().getSimpleName();
    L122:
        r106.c(r129, r130);
    L123:
        if (r111 == null) goto L125;
        com.bytedance.ai.applet.app.foundation.i.a(r111, r128.getMessage());
    L125:
        return r119;
    L33:
        AppletApplication r131 = this.f34072e;
        if (r131 != null) goto L36;
        com.bytedance.ai.applet.base.log.d r132 = this.f34070c;
        AtomicInteger r133 = com.bytedance.ai.applet.base.log.d.f34519d;
        r132.a("launch: application is null", null);
        Result.Companion r134 = Result.Companion;
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException("application is null")));
        goto L91
    L36:
        String r135 = r131.j().O;
        if (StringsKt.isBlank(r135) == false) goto L39;
        r135 = "index";
    L39:
        r119 = R1(r135, r108);
        goto L91
    L41:
        if ((r110 instanceof RouteAction.NavigateTo) == false) goto L44;
        RouteAction.NavigateTo r136 = (RouteAction.NavigateTo) r110;
        r119 = R1(r136.f34191a, r136.f34192b);
        goto L91
    L44:
        if ((r110 instanceof RouteAction.RedirectTo) == false) goto L47;
        RouteAction.RedirectTo r137 = (RouteAction.RedirectTo) r110;
        r119 = W1(r137.f34198a, r137.f34199b);
        goto L91
    L47:
        if ((r110 instanceof RouteAction.ReLaunch) == false) goto L66;
        RouteAction.ReLaunch r138 = (RouteAction.ReLaunch) r110;
        String r139 = r138.f34196a;
        RouteOptions r140 = r138.f34197b;
        AppletApplication r141 = this.f34072e;
        if (r141 == null) goto L51;
        Fragment r142 = r141.t(this, r139, r140);
    L52:
        if (r142 != null) goto L54;
        String r143 = "Failed to create page for url: " + r139;
        this.f34070c.a("reLaunch: fragment is null, openPath = " + r139, null);
        a2(r143);
        Result.Companion r144 = Result.Companion;
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException(r143)));
        goto L91
    L54:
        t2.b.d(r142, r139);
        if ((!this.f34074g) == true) goto L57;
    L60:
        getSupportFragmentManager().popBackStackImmediate(null, 1);
        FragmentTransaction r145 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r145, r142, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, com.larus.nova.R.id.app_page_container) == true) goto L64;
        r145 = r145.replace(com.larus.nova.R.id.app_page_container, r142);
    L64:
        r145.commitAllowingStateLoss();
        this.f34074g = true;
        b2(r139);
        Result.Companion r146 = Result.Companion;
        r119 = Result.m9449constructorimpl(Unit.INSTANCE);
        goto L91
    L57:
        if (this.f34076i != null) goto L60;
        this.f34076i = r142;
        S1(t.c.f34428a);
        goto L60
    L51:
        r142 = null;
        goto L52
    L66:
        if ((r110 instanceof RouteAction.OpenPage) == false) goto L127;
        RouteAction.OpenPage r147 = (RouteAction.OpenPage) r110;
        String r148 = r147.f34193a;
        ApplicationRouter.OpenPageMode r149 = r147.f34194b;
        RouteOptions r150 = r147.f34195c;
        int r151 = c.f34079a[r149.ordinal()];
        if (r151 != 1) goto L70;
        r119 = R1(r148, r150);
        goto L91
    L70:
        if (r151 != 2) goto L72;
        b r152 = G1(r148, true);
        if (r152 == null) goto L88;
        r119 = X1(r152, r148, r150);
        goto L91
    L88:
        r119 = W1(r148, r150);
        goto L91
    L72:
        if (r151 != 3) goto L74;
    L78:
        b r153 = G1(r148, false);
        if (r153 == null) goto L82;
        r119 = X1(r153, r148, r150);
        goto L91
    L82:
        if (r149 != ApplicationRouter.OpenPageMode.NAVIGATE) goto L84;
        r119 = R1(r148, r150);
        goto L91
    L84:
        r119 = W1(r148, r150);
        goto L91
    L74:
        if (r151 == 4) goto L78;
        throw new NoWhenBranchMatchedException();
    L127:
        throw new NoWhenBranchMatchedException();
    L13:
        r106 = null;
        goto L14
    }

    public final Object W1(String r100, RouteOptions r101) {
        AppletApplication r102 = this.f34072e;
        if (r102 == null) goto L5;
        Fragment r103 = r102.t(this, r100, r101);
    L6:
        if (r103 != null) goto L9;
        String r104 = "Failed to create page for url: " + r100;
        AtomicInteger r105 = com.bytedance.ai.applet.base.log.d.f34519d;
        this.f34070c.a("redirectTo: fragment is null, openPath = " + r100, null);
        a2(r104);
        Result.Companion r106 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException(r104)));
    L9:
        t2.b.d(r103, r100);
        if ((!this.f34074g) == false) goto L16;
        if (this.f34076i != null) goto L16;
        this.f34076i = r103;
        S1(t.c.f34428a);
    L16:
        if (getSupportFragmentManager().getBackStackEntryCount() <= 0) goto L18;
        boolean r107 = true;
    L19:
        if (r107 == false) goto L21;
        getSupportFragmentManager().popBackStackImmediate();
    L21:
        FragmentTransaction r108 = getSupportFragmentManager().beginTransaction();
        r108.setCustomAnimations(0, 0, 0, com.larus.nova.R.anim.applet_router_slide_out_right);
        if (r107 == false) goto L29;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r108, r103, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, com.larus.nova.R.id.app_page_container) == true) goto L27;
        r108.add(com.larus.nova.R.id.app_page_container, r103);
    L27:
        r108.addToBackStack(null);
    L32:
        r108.commitAllowingStateLoss();
        this.f34074g = true;
        b2(r100);
        Result.Companion r109 = Result.Companion;
        return Result.m9449constructorimpl(Unit.INSTANCE);
    L29:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r108, r103, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, com.larus.nova.R.id.app_page_container) == true) goto L32;
        r108.replace(com.larus.nova.R.id.app_page_container, r103);
        goto L32
    L18:
        r107 = false;
        goto L19
    L5:
        r103 = null;
        goto L6
    }

    public final Object X1(b r100, String r110, RouteOptions r111) {
        AppletApplication r101 = this.f34072e;
        if (r101 != null) goto L6;
        Result.Companion r102 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException("AppletApplication is null")));
    L6:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r101.D(r100.f34077a, r110));
        if (r103 != null) goto L9;
        t2.b.d(r100.f34077a, r110);
        int r104 = r100.f34078b;
        if (r104 <= 0) goto L13;
        Object r105 = Q1(r104);
    L15:
        if (Result.m9456isSuccessimpl(r105) == false) goto L23;
        Unit r106 = (Unit) r105;
        b2(r110);
        if (r111 == null) goto L23;
        Long r112 = r111.f34165b;
        if (r112 == null) goto L23;
        long r113 = r112.longValue();
        com.bytedance.ai.applet.app.foundation.performance.r r107 = r101.h().c().f(r113);
        if (r107 == null) goto L23;
        AtomicLong r114 = com.bytedance.ai.applet.app.foundation.performance.k.f34338g;
        com.bytedance.ai.applet.app.foundation.performance.k.d(r107, AppletPerformanceOutcome.CANCELLED, 0, AppletPerformanceErrorCode.CANCELLED, "cancelled", 2);
    L23:
        return r105;
    L13:
        r105 = Result.m9449constructorimpl(Unit.INSTANCE);
        goto L15
    L9:
        return Result.m9449constructorimpl(ResultKt.createFailure(r103));
    }
}
