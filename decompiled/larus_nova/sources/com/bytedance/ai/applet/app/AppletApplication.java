package com.bytedance.ai.applet.app;

import android.content.Context;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.os.Build;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LifecycleRegistry;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ai.applet.app.base.RouteOptions;
import com.bytedance.ai.applet.app.foundation.v;
import com.bytedance.ai.applet.app.foundation.w;
import com.bytedance.ai.applet.services.AppLifecycleCallbacks;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.remote.model.AppMeta;
import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.bytedance.ai.bridge.service.ToastBuilder;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.pia.core.metrics.ErrorType;
import com.larus.nova.R;
import com.larus.office.container.impl.applet.OfficeAppletApplication;
import com.larus.platform.api.creation.TplType;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.ss.android.common.applog.EventVerify;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u0000 \u0082\u00012\u00020\u0001:\u0004\u0082\u0001\u0083\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u000205J\u000e\u0010?\u001a\u00020=2\u0006\u0010>\u001a\u000205J\u0006\u0010@\u001a\u00020+J\u0006\u0010A\u001a\u00020+J\b\u0010B\u001a\u00020=H\u0004J\u0015\u0010C\u001a\u00020=2\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0002\bDJ\r\u0010E\u001a\u00020=H\u0000¢\u0006\u0002\bFJ\u0010\u0010K\u001a\u0004\u0018\u00010)H\u0086@¢\u0006\u0002\u0010LJ\u0018\u0010M\u001a\u0004\u0018\u00010+2\u0006\u0010N\u001a\u00020OH\u0086@¢\u0006\u0002\u0010PJ\b\u0010Q\u001a\u00020=H\u0017J\u0010\u0010R\u001a\u00020=2\u0006\u0010N\u001a\u00020OH\u0017J&\u0010S\u001a\u0004\u0018\u00010T2\u0006\u0010N\u001a\u00020O2\u0006\u0010U\u001a\u00020\u00162\n\b\u0002\u0010V\u001a\u0004\u0018\u00010WH&J1\u0010X\u001a\b\u0012\u0004\u0012\u00020=0Y2\u0006\u0010Z\u001a\u00020T2\u0006\u0010U\u001a\u00020\u00162\n\b\u0002\u0010V\u001a\u0004\u0018\u00010WH\u0016¢\u0006\u0004\b[\u0010\\J\u0010\u0010]\u001a\u00020=2\u0006\u0010N\u001a\u00020OH\u0017J\u0010\u0010^\u001a\u00020=2\u0006\u0010N\u001a\u00020OH\u0017J\u0010\u0010_\u001a\u00020=2\u0006\u0010N\u001a\u00020OH\u0017J\u0010\u0010`\u001a\u00020=2\u0006\u0010N\u001a\u00020OH\u0017J\u0015\u0010a\u001a\u00020=2\u0006\u0010N\u001a\u00020OH\u0000¢\u0006\u0002\bbJ\u0010\u0010c\u001a\u00020=2\u0006\u0010N\u001a\u00020OH\u0017J\b\u0010d\u001a\u00020=H\u0017J\r\u0010e\u001a\u00020=H\u0000¢\u0006\u0002\bfJ\b\u0010g\u001a\u00020=H\u0016J\u0010\u0010h\u001a\u00020=2\u0006\u0010i\u001a\u00020\u001eH\u0016J\u0010\u0010j\u001a\u00020=2\u0006\u0010k\u001a\u00020lH\u0017J\u0010\u0010m\u001a\u00020=2\u0006\u0010n\u001a\u00020lH\u0017J\b\u0010o\u001a\u00020=H\u0002J\b\u0010p\u001a\u00020=H\u0002J\b\u0010q\u001a\u00020+H\u0014J\u0010\u0010r\u001a\u00020=2\u0006\u0010G\u001a\u00020HH\u0016J\b\u0010s\u001a\u00020+H\u0016J\u0010\u0010t\u001a\u00020+2\u0006\u0010u\u001a\u00020vH\u0016J\u0018\u0010w\u001a\u00020=2\u0006\u0010N\u001a\u00020O2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u001a\u0010x\u001a\u00020=2\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010y\u001a\u00020+H\u0002J\u0010\u0010z\u001a\u00020\u00162\u0006\u0010N\u001a\u00020OH\u0002J\b\u0010{\u001a\u00020=H\u0002J\b\u0010|\u001a\u00020=H\u0002J\u0010\u0010}\u001a\u00020=2\u0006\u0010N\u001a\u00020OH\u0002J\"\u0010~\u001a\u0004\u0018\u00010+2\u0006\u0010N\u001a\u00020O2\b\b\u0002\u0010y\u001a\u00020+H\u0082@¢\u0006\u0002\u0010\u007fJ\u001a\u0010\u0080\u0001\u001a\u00020=2\u0006\u0010N\u001a\u00020O2\u0007\u0010\u0081\u0001\u001a\u00020+H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u001e8F¢\u0006\u0006\u001a\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010$\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0018\u0010'\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010)\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010+\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0-X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0/¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u000e\u00102\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R2\u00103\u001a&\u0012\f\u0012\n 6*\u0004\u0018\u00010505 6*\u0012\u0012\f\u0012\n 6*\u0004\u0018\u00010505\u0018\u00010704X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010G\u001a\u00020HX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010J¨\u0006\u0084\u0001"}, d2 = {"Lcom/bytedance/ai/applet/app/AppletApplication;", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "()V", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "_manifest", "Lcom/bytedance/ai/model/objects/Applet;", ErrorType.MANIFEST, "getManifest", "()Lcom/bytedance/ai/model/objects/Applet;", "logger", "Lcom/bytedance/ai/applet/base/log/InstanceLogger;", "getLogger", "()Lcom/bytedance/ai/applet/base/log/InstanceLogger;", "setLogger", "(Lcom/bytedance/ai/applet/base/log/InstanceLogger;)V", "appId", "", "getAppId", "()Ljava/lang/String;", "launchThemeMode", "Lcom/bytedance/ai/applet/app/view/AppletThemeMode;", "getLaunchThemeMode$ai_sdk_release", "()Lcom/bytedance/ai/applet/app/view/AppletThemeMode;", "_appActivity", "Lcom/bytedance/ai/applet/app/AppletAppActivity;", "appActivity", "getAppActivity", "()Lcom/bytedance/ai/applet/app/AppletAppActivity;", "_foundation", "Lcom/bytedance/ai/applet/app/foundation/AppletFoundation;", "foundation", "getFoundation", "()Lcom/bytedance/ai/applet/app/foundation/AppletFoundation;", "metaInfoJob", "Lkotlinx/coroutines/Deferred;", "Lcom/bytedance/ai/bridge/remote/model/AppMeta;", "queryPinResultJob", "", "_pinStatus", "Lkotlinx/coroutines/flow/MutableStateFlow;", "pinStatus", "Lkotlinx/coroutines/flow/StateFlow;", "getPinStatus", "()Lkotlinx/coroutines/flow/StateFlow;", "terminating", "keepAliveRequesters", "", "Lcom/bytedance/ai/applet/app/KeepAliveRequester;", "kotlin.jvm.PlatformType", "", "destructionJob", "Lkotlinx/coroutines/Job;", "foregroundTime", "", "acquireKeepAlive", "", "requester", "releaseKeepAlive", "isKeptAlive", "isResumed", "rescheduleDestruction", LynxViewpagerItem.BIND_ON_ATTACH, "attach$ai_sdk_release", EventVerify.TYPE_TERMINATE, "terminate$ai_sdk_release", TplType.MENU, "Lcom/bytedance/ai/applet/app/view/Menu;", "getMenu$ai_sdk_release", "()Lcom/bytedance/ai/applet/app/view/Menu;", "getMetaInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshPinStatus", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onAttached", WidgetCostModule.TYPE_ON_CREATE, "onCreateView", "Landroidx/fragment/app/Fragment;", "url", "options", "Lcom/bytedance/ai/applet/app/base/RouteOptions;", "onUpdateView", "Lkotlin/Result;", WidgetService.PARAM_FRAGMENT, "onUpdateView-0E7RQCE", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Lcom/bytedance/ai/applet/app/base/RouteOptions;)Ljava/lang/Object;", "onTaskForeground", "onTaskBackground", "onResume", "onStop", "onActivityDestroy", "onActivityDestroy$ai_sdk_release", "onDestroyView", LiveCommonConstants.REASON_ON_DEDTROY, "destroyNow", "destroyNow$ai_sdk_release", "onActionBarMenuMoreClicked", "onMoveTaskToBack", "activity", "onSaveInstanceState", "outState", "Lcom/bytedance/ai/applet/app/AppletApplication$StateStore;", "onRestoreInstanceState", "savedState", "scheduleDestruction", "cancelScheduledDestruction", "canDestroy", "onCreateOptionsMenu", "onShowOptionsMenu", "onOptionsItemSelected", MapController.ITEM_LAYER_TAG, "Lcom/bytedance/ai/applet/app/view/MenuItem;", "initMetaInfoJob", "initQueryPinResultJob", "forceRefresh", "getCurrentLocale", "navigateToAboutActivity", "addShortcut", "showShortcutFailure", "refreshPinMenuStatus", "(Landroid/content/Context;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyPinMenuStatus", "isPin", "Companion", "StateStore", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AppletApplication implements LifecycleOwner {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f34081o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleRegistry f34082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Applet f34083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.ai.applet.base.log.d f34084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AppletAppActivity f34085d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public v f34086e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Deferred<AppMeta> f34087f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Deferred<Boolean> f34088g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final StateFlowImpl f34089h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b1 f34090i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f34091j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Set<KeepAliveRequester> f34092k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Job f34093l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f34094m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.ai.applet.app.view.l f34095n;

    /* JADX INFO: loaded from: classes43.dex */
    public static final class a {
    }

    /* JADX INFO: loaded from: classes43.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, Object> f34096a;

        public b() {
            this.f34096a = new LinkedHashMap();
        }
    }

    static {
    }

    public boolean A() {
        return !(this instanceof OfficeAppletApplication);
    }

    public void o() {
    }

    public void s(com.bytedance.ai.applet.app.view.l r100) {
        Intrinsics.checkNotNullParameter(r100, TplType.MENU);
    }

    public abstract Fragment t(Context r100, String r101, RouteOptions r102);

    public void v(AppletAppActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    public void x(b r100) {
        Intrinsics.checkNotNullParameter(r100, "savedState");
    }

    public void z(b r100) {
        Intrinsics.checkNotNullParameter(r100, "outState");
    }

    public final void H() {
        Job r100 = this.f34093l;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == false) goto L10;
        i().c("scheduleDestruction: destruction already scheduled");
        return;
    L10:
        i().c("scheduleDestruction: scheduling app destruction in 300000 ms");
        this.f34093l = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new AppletApplication$scheduleDestruction$1(this, null), 3, null);
        return;
    L5:
        if (r100.isActive() != true) goto L7;
        r101 = true;
        goto L7
    }

    public boolean e() {
        boolean r100 = false;
        if (this.f34085d == null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        com.bytedance.ai.applet.base.log.d r102 = i();
        StringBuilder r103 = new StringBuilder("canDestroy check: appActivity is null? ");
        if (this.f34085d != null) goto L11;
        r100 = true;
    L11:
        r103.append(r100);
        r103.append(", isKeptAlive? ");
        r103.append(!this.f34092k.isEmpty());
        r103.append(". Result: ");
        r103.append(r101);
        r102.c(r103.toString());
        return r101;
    L5:
        if ((!this.f34092k.isEmpty()) == true) goto L7;
        r101 = true;
        goto L8
    }

    public final void f() {
        Job r100 = this.f34093l;
        boolean r101 = false;
        if (r100 == null) goto L8;
        if (r100.isActive() != true) goto L8;
        r101 = true;
    L8:
        if (r101 == false) goto L12;
        i().c("cancelScheduledDestruction: canceling scheduled destruction");
        Job r102 = this.f34093l;
        if (r102 == null) goto L12;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L12:
        this.f34093l = null;
    }

    public final v h() {
        v r100 = this.f34086e;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("_foundation");
        return null;
    L6:
        return r100;
    }

    public final com.bytedance.ai.applet.base.log.d i() {
        com.bytedance.ai.applet.base.log.d r100 = this.f34084c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("logger");
        return null;
    }

    public final Applet j() {
        Applet r100 = this.f34083b;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("_manifest");
        return null;
    L6:
        return r100;
    }

    public AppletApplication() {
        this.f34082a = new LifecycleRegistry(this);
        StateFlowImpl r100 = j1.a(null);
        this.f34089h = r100;
        this.f34090i = kotlinx.coroutines.flow.e.b(r100);
        this.f34092k = Collections.synchronizedSet(new HashSet());
        this.f34095n = new com.bytedance.ai.applet.app.view.l();
    }

    public final void G() {
        i().c("rescheduleDestruction: resetting destruction timer.");
        if (e() == false) goto L5;
        f();
        H();
        return;
    L5:
        i().c("rescheduleDestruction: conditions to destroy are not met, no need to reschedule.");
    }

    public final void g() {
        if (getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L6;
        onDestroy();
        return;
    }

    public final String getAppId() {
        return j().K;
    }

    public final boolean m() {
        if (getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) goto L5;
        return true;
    L5:
        return false;
    }

    public void onDestroy() {
        i().c(LiveCommonConstants.REASON_ON_DEDTROY);
        Iterator r100 = CollectionsKt.asReversed(h().f()).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((w) r100.next()).onDestroy();
        goto L4
    L6:
        f();
        j().g();
        this.f34082a.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        AppletAppManagerService.INSTANCE.getClass();
        Intrinsics.checkNotNullParameter(this, "app");
        Iterator<AppLifecycleCallbacks> r101 = AppletAppManagerService.f35188b.iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        r101.next().onAppDestroyed(this);
        goto L8
    L10:
        AppletAppManagerService r102 = AppletAppManagerService.INSTANCE;
        String r103 = getAppId();
        r102.getClass();
        AppletAppManagerService.g(r103);
    }

    public void p() {
        i().c("onAttached");
        this.f34082a.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        Iterator<T> r100 = h().f().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((w) r100.next()).d();
        goto L4
    L6:
        AppletAppManagerService.INSTANCE.getClass();
        Intrinsics.checkNotNullParameter(this, "app");
        Iterator<AppLifecycleCallbacks> r101 = AppletAppManagerService.f35188b.iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        r101.next().onAppAttached(this);
        goto L8
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.f34082a;
    }

    public void B(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        i().c("onStop");
        this.f34082a.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        v r101 = h();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Iterator<T> r102 = r101.f().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((w) r102.next()).h(r100);
        goto L4
    L6:
        AppletAppManagerService.INSTANCE.getClass();
        Intrinsics.checkNotNullParameter(this, "app");
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Iterator<AppLifecycleCallbacks> r103 = AppletAppManagerService.f35188b.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        r103.next().onAppStopped(this, r100);
        goto L8
    }

    public void C(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        i().c("onTaskBackground");
        if (this.f34094m <= 0) goto L8;
        long r101 = System.currentTimeMillis() - this.f34094m;
        this.f34094m = 0;
        if (r101 <= 0) goto L7;
        com.bytedance.ai.applet.app.foundation.j r102 = h().e();
        r102.getClass();
        r102.i("exit_doubao_apps", MapsKt.mapOf(TuplesKt.to("duration", Long.valueOf(r101))));
    L9:
        AppletAppManagerService.INSTANCE.getClass();
        Intrinsics.checkNotNullParameter(this, "app");
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Iterator<AppLifecycleCallbacks> r103 = AppletAppManagerService.f35188b.iterator();
    L11:
        if (r103.hasNext() == false) goto L13;
        r103.next().onAppTaskBackground(this, r100);
        goto L11
    L13:
        return;
    L7:
        com.bytedance.ai.applet.base.log.d.d(i(), "onTaskBackground: durationMillis is negative, durationMillis = " + r101);
        goto L9
    L8:
        com.bytedance.ai.applet.base.log.d.d(i(), "onTaskBackground: foregroundTime is not set, skip exit tracking");
        goto L9
    }

    public final void F(KeepAliveRequester r100) {
        Intrinsics.checkNotNullParameter(r100, "requester");
        i().c("releaseKeepAlive by " + r100);
        this.f34092k.remove(r100);
        if (e() == false) goto L6;
        H();
        return;
    }

    public final void b(KeepAliveRequester r100) {
        Intrinsics.checkNotNullParameter(r100, "requester");
        i().c("acquireKeepAlive by " + r100);
        f();
        this.f34092k.add(r100);
    }

    public final Object k(Continuation<? super AppMeta> r100) {
        if ((r100 instanceof AppletApplication$getMetaInfo$1) == false) goto L7;
        AppletApplication$getMetaInfo$1 r101 = (AppletApplication$getMetaInfo$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        AppMeta r106 = null;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        ResultKt.throwOnFailure(r103);
    L31:
        r106 = (AppMeta) r103;
    L33:
        return r106;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r103);
    L21:
        AppMeta r107 = (AppMeta) r103;
    L23:
        if (r107 == null) goto L25;
        return r107;
    L25:
        if (this.f34085d == null) goto L33;
        l(j().K);
        Deferred<AppMeta> r108 = this.f34087f;
        if (r108 == null) goto L33;
        r101.label = 2;
        r103 = r108.await(r101);
        if (r103 != r104) goto L31;
        return r104;
    L16:
        ResultKt.throwOnFailure(r103);
        Deferred<AppMeta> r109 = this.f34087f;
        if (r109 == null) goto L22;
        r101.label = 1;
        r103 = r109.await(r101);
        if (r103 != r104) goto L21;
        return r104;
    L22:
        r107 = null;
    L7:
        r101 = new AppletApplication$getMetaInfo$1(this, r100);
        goto L8
    }

    public final void l(String r100) {
        Deferred<AppMeta> r101 = this.f34087f;
        if (r101 != null) goto L5;
    L7:
        this.f34087f = BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.f36600a), null, null, new AppletApplication$initMetaInfoJob$2(r100, this, null), 3, null);
        return;
    L5:
        if (r101.isCompleted() == true) goto L7;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
        goto L7
    }

    public void r(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        i().c(WidgetCostModule.TYPE_ON_CREATE);
        f();
        this.f34085d = (AppletAppActivity) r100;
        s(this.f34095n);
        if (A() == false) goto L9;
        l(j().K);
        AppletAppActivity r101 = this.f34085d;
        if (r101 == null) goto L9;
        LifecycleCoroutineScope r102 = LifecycleOwnerKt.getLifecycleScope(r101);
        if (r102 == null) goto L9;
        BuildersKt.launch$default(r102, null, null, new AppletApplication$onCreate$1(this, r100, null), 3, null);
    L9:
        v r103 = h();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Iterator<T> r104 = r103.f().iterator();
    L11:
        if (r104.hasNext() == false) goto L13;
        ((w) r104.next()).a(r100);
        goto L11
    L13:
        AppletAppManagerService.INSTANCE.getClass();
        Intrinsics.checkNotNullParameter(this, "app");
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Iterator<AppLifecycleCallbacks> r105 = AppletAppManagerService.f35188b.iterator();
    L15:
        if (r105.hasNext() == false) goto L17;
        r105.next().onAppCreated(this, r100);
        goto L15
    }

    public void u(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        i().c("onDestroyView");
        com.bytedance.ai.applet.app.foundation.performance.c r101 = h().c();
        Object r102 = r101.f34272c;
        monitor-enter(r102);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (r101.f34278i == true) goto L7;
        r101.f34276g = null;     // Catch: Throwable -> L18
        r101.f34277h = false;     // Catch: Throwable -> L18
    L7:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r102);
        v r104 = h();
        r104.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Iterator r105 = CollectionsKt.asReversed(r104.f()).iterator();
    L11:
        if (r105.hasNext() == false) goto L13;
        ((w) r105.next()).g(r100);
        goto L11
    L13:
        this.f34085d = null;
        AppletAppManagerService.INSTANCE.getClass();
        Intrinsics.checkNotNullParameter(this, "app");
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Iterator<AppLifecycleCallbacks> r106 = AppletAppManagerService.f35188b.iterator();
    L15:
        if (r106.hasNext() == false) goto L17;
        r106.next().onAppDestroyView(this, r100);
        goto L15
    }

    public boolean w(com.bytedance.ai.applet.app.view.m r110) {
        Intrinsics.checkNotNullParameter(r110, MapController.ITEM_LAYER_TAG);
        com.bytedance.ai.utils.g.f37637a.d("AppletApplication", "menu: " + r110.f34497a + " is selected");
        com.bytedance.ai.applet.app.foundation.j r100 = h().e();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, MapController.ITEM_LAYER_TAG);
        int r101 = r110.f34497a;
        if (r101 == 1) goto L15;
        if (r101 == 2) goto L15;
        if (r101 == 3) goto L15;
        if (r101 == 4) goto L15;
        if (r101 == 5) goto L15;
        if (r101 == 6) goto L15;
        int r102 = 0;
    L16:
        String r103 = r110.f34505i;
        if (r103 != null) goto L19;
    L22:
        boolean r104 = true;
    L24:
        if (r104 == true) goto L26;
        String r105 = r110.f34505i;
    L29:
        if (r105 == null) goto L33;
        r100.i("doubao_apps_info_panel_click", MapsKt.mapOf(new Pair[]{TuplesKt.to("is_default", Integer.valueOf(r102)), TuplesKt.to("click_from", r105)}));
    L33:
        switch(r110.f34497a) {
            case 1: goto L50;
            case 2: goto L47;
            case 3: goto L44;
            case 4: goto L41;
            case 5: goto L38;
            case 6: goto L35;
            default: goto L55;
        };
    L35:
        AppletAppActivity r106 = this.f34085d;
        if (r106 == null) goto L53;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r106), null, null, new AppletApplication$onOptionsItemSelected$3$1(this, r106, r110, null), 3, null);
    L53:
        return true;
    L38:
        AppletAppActivity r111 = this.f34085d;
        if (r111 == null) goto L53;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r111), null, null, new AppletApplication$navigateToAboutActivity$1$1(this, r111, null), 3, null);
        goto L53
    L41:
        AppletAppActivity r112 = this.f34085d;
        if (r112 == null) goto L53;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r112), null, null, new AppletApplication$addShortcut$1$1(this, r112, null), 3, null);
        goto L53
    L44:
        AppletAppActivity r113 = this.f34085d;
        if (r113 == null) goto L53;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r113), null, null, new AppletAppActivity$reLaunchApp$1(r113, null), 3, null);
        goto L53
    L47:
        AppletAppActivity r107 = this.f34085d;
        if (r107 == null) goto L53;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r107), null, null, new AppletApplication$onOptionsItemSelected$2$1(this, r107, r110, null), 3, null);
        goto L53
    L50:
        AppletAppActivity r108 = this.f34085d;
        if (r108 == null) goto L53;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r108), null, null, new AppletApplication$onOptionsItemSelected$1$1(this, r110, r108, null), 3, null);
        goto L53
    L55:
        return false;
    L26:
        if (r102 == 0) goto L28;
        r105 = com.bytedance.ai.applet.app.view.p.a(r110.f34497a);
        goto L29
    L28:
        r105 = null;
        goto L29
    L19:
        if (r103.length() == 0) goto L22;
        r104 = false;
    L15:
        r102 = 1;
        goto L16
    }

    public void y(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        i().c("onResume");
        this.f34082a.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        int r101 = com.bytedance.ai.utils.n.f37678a;
        String r102 = j().K;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, IFlowAppIntentIDL.PARAM_APPLET_ID);
        if (Build.VERSION.SDK_INT < 25) goto L14;
        ShortcutManager r103 = (ShortcutManager) r100.getSystemService(ShortcutManager.class);
        if (r103 == null) goto L14;
        Iterator<ShortcutInfo> r104 = r103.getPinnedShortcuts().iterator();
    L8:
        if (r104.hasNext() == false) goto L14;
        ShortcutInfo r105 = r104.next();
        if (Intrinsics.areEqual(r105.getId(), "doubao_app." + r102) == true) goto L13;
        if (Intrinsics.areEqual(r105.getId(), r102) == false) goto L8;
    L13:
        boolean r106 = true;
    L15:
        com.bytedance.ai.applet.app.view.l r107 = this.f34095n;
        boolean r108 = !r106;
        com.bytedance.ai.applet.app.view.m r109 = r107.f34496b.get(4);
        if (r109 == null) goto L18;
        com.bytedance.ai.applet.app.view.m r110 = com.bytedance.ai.applet.app.view.m.a(r109, null, null, r108, 991);
        com.bytedance.ai.applet.app.view.m r111 = r107.f34496b.put(Integer.valueOf(r110.f34497a), r110);
    L18:
        AppletAppManagerService.INSTANCE.getClass();
        Intrinsics.checkNotNullParameter(this, "app");
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Iterator<AppLifecycleCallbacks> r112 = AppletAppManagerService.f35188b.iterator();
    L20:
        if (r112.hasNext() == false) goto L22;
        r112.next().onAppResumed(this, r100);
        goto L20
    L22:
        return;
    L14:
        r106 = false;
        goto L15
    }

    public static final void a(AppletApplication r100, AppletAppActivity r110) {
        r100.getClass();
        ToastBuilder r101 = new ToastBuilder(r110, r110.getResources().getString(R.string.applet_add_to_desktop_failure), "error", null, null, null, 56, null);
        IHostStyleUIDepend r111 = r4.a.f535978e;
        if (r111 == null) goto L5;
        Boolean r112 = r111.showToast(r101);
    L7:
        if (Intrinsics.areEqual(r112, Boolean.TRUE) == true) goto L10;
        new i4.c().showToast(r101);
        return;
    L10:
        return;
    L5:
        r112 = null;
        goto L7
    }

    public Object D(Fragment r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "url");
        Result.Companion r102 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new UnsupportedOperationException("Updating an existing page is not supported")));
    }

    public final void c(Context r100, boolean r101) {
        if (r101 == false) goto L4;
        int r102 = com.bytedance.ai.applet.app.view.o.f34507a;
        String r103 = com.bytedance.ai.applet.app.view.o.c(r100, "larus_appEntry_3rdPartyApp_menuOption_unpin", R.string.applet_share_sheet_menu_unpin);
        this.f34095n.a(r103, R.drawable.ic_applet_share_sheet_unpin);
    L5:
        this.f34089h.setValue(Boolean.valueOf(r101));
        return;
    L4:
        int r104 = com.bytedance.ai.applet.app.view.o.f34507a;
        String r105 = com.bytedance.ai.applet.app.view.o.c(r100, "larus_appEntry_3rdPartyApp_menuOption_pin", R.string.applet_share_sheet_menu_pin);
        this.f34095n.a(r105, R.drawable.ic_applet_share_sheet_pin);
        goto L5
    }

    public final Object E(Context r110, boolean r111, Continuation<? super Boolean> r112) {
        if ((r112 instanceof AppletApplication$refreshPinMenuStatus$1) == false) goto L7;
        AppletApplication$refreshPinMenuStatus$1 r100 = (AppletApplication$refreshPinMenuStatus$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        r110 = (Context) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L28:
        Boolean r114 = (Boolean) r113;
    L30:
        if (r114 != null) goto L33;
        com.bytedance.ai.applet.base.log.d.d(i(), "refreshPinMenuStatus: query pin result is null");
        return null;
    L33:
        c(r110, r114.booleanValue());
        return r114;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        String r115 = j().K;
        Deferred<Boolean> r104 = this.f34088g;
        if (r111 == true) goto L20;
        if (r104 == null) goto L20;
        if (r104.isCancelled() == true) goto L20;
    L23:
        Deferred<Boolean> r116 = this.f34088g;
        if (r116 == null) goto L29;
        r100.L$0 = r110;
        r100.label = 1;
        r113 = r116.await(r100);
        if (r113 != r102) goto L28;
        return r102;
    L29:
        r114 = null;
    L20:
        if (r104 == null) goto L22;
        Job.DefaultImpls.cancel$default(r104, null, 1, null);
    L22:
        this.f34089h.setValue(null);
        this.f34088g = BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.f36600a), null, null, new AppletApplication$initQueryPinResultJob$1(r115, this, null), 3, null);
    L7:
        r100 = new AppletApplication$refreshPinMenuStatus$1(this, r112);
        goto L8
    }
}
