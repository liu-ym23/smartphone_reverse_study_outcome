package com.bytedance.ai.applet.page;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ai.applet.app.AppletAppActivity;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.app.foundation.AppletModelContextProvider;
import com.bytedance.ai.applet.app.foundation.performance.AppletPerformanceErrorCode;
import com.bytedance.ai.applet.app.foundation.performance.AppletPerformanceOutcome;
import com.bytedance.ai.applet.app.foundation.performance.r;
import com.bytedance.ai.applet.app.foundation.v;
import com.bytedance.ai.applet.app.t;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.model.objects.Page;
import com.bytedance.ai.model.objects.PageChatConfig;
import com.bytedance.ai.monitor.AppletErrorCode;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.pia.core.metrics.ErrorType;
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.utils.statistics.PerfLog;
import d3.w;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import m5.i1;
import m5.y0;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000¥\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u001a\u0018\u0000 H2\u00020\u0001:\u0001HB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001fH\u0002J\u0012\u0010!\u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u001fH\u0016J&\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010+\u001a\u00020\u001fH\u0016J\u0010\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\nH\u0016J\b\u0010.\u001a\u00020\u001fH\u0016J\b\u0010/\u001a\u00020\u001fH\u0016J\b\u00100\u001a\u00020\u001fH\u0016J\u0015\u00101\u001a\u00020\u001f2\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0002\b2J \u00103\u001a\u00020\r2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0002J \u0010:\u001a\u00020;2\u0006\u0010)\u001a\u00020*2\u0006\u00106\u001a\u0002072\u0006\u0010<\u001a\u00020=H\u0002J\u001a\u0010>\u001a\u00020\u001f2\u0006\u0010?\u001a\u00020\u00072\b\b\u0002\u0010@\u001a\u00020AH\u0002J\u0010\u0010B\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020DH\u0002J\b\u0010E\u001a\u00020\u001fH\u0002J\u0012\u0010F\u001a\u00020\u001f2\b\b\u0002\u0010G\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/bytedance/ai/applet/page/AppletPageFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "logger", "Lcom/bytedance/ai/applet/base/log/InstanceLogger;", "appId", "", "url", "isPageForeground", "", "chatInputEnabled", "lynxView", "Lcom/bytedance/ai/lynx/AppletLynxView;", "lynxViewShowed", "pageContentReady", "keyboardHeightChangeObserver", "Lcom/bytedance/ai/bridge/method/event/KeyboardHeightChangeObserver;", "pageTimelineTracker", "Lcom/bytedance/ai/applet/page/AppletPageTimelineTracker;", "conversationId", "bridge", "Lcom/bytedance/ai/bridge/AIBridge;", "performanceTracker", "Lcom/bytedance/ai/applet/app/foundation/performance/PagePerformanceTracker;", "lifeCycleListener", "com/bytedance/ai/applet/page/AppletPageFragment$lifeCycleListener$1", "Lcom/bytedance/ai/applet/page/AppletPageFragment$lifeCycleListener$1;", "backStackListener", "Landroidx/fragment/app/FragmentManager$OnBackStackChangedListener;", "checkVisibility", "", "applyChatInputVisibility", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", LiveCommonConstants.REASON_ON_DEDTROY, "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onResume", "onHiddenChanged", "hidden", "onPause", "onStop", "onDestroyView", "updatePage", "updatePage$ai_sdk_release", "createLynxView", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "app", "Lcom/bytedance/ai/applet/app/OnlineAppletApplication;", ErrorType.MANIFEST, "Lcom/bytedance/ai/model/objects/Applet;", "loadLynxView", "Lkotlinx/coroutines/Job;", "page", "Lcom/bytedance/ai/model/objects/Page;", "reportPerformanceError", "errorMessage", "errorCode", "", "updateHostContentState", "state", "Lcom/bytedance/ai/applet/app/AppletPageContentState;", "attachKeyboardHeightChangeObserver", "detachKeyboardHeightChangeObserver", "release", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletPageFragment extends Fragment {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final a f34873s = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.ai.applet.base.log.d f34874d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f34875e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f34876f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f34877g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f34878h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bytedance.ai.lynx.g f34879i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f34880j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f34881k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public w3.b f34882l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public AppletPageTimelineTracker f34883m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f34884n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final w f34885o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public r f34886p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final b f34887q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final h f34888r;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements com.bytedance.ai.lynx.r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppletPageFragment f34889a;

        @Override // com.bytedance.ai.lynx.r
        public final void onDetachedFromWindow(com.bytedance.ai.lynx.g r100) {
        }

        @Override // com.bytedance.ai.lynx.r
        public final void onFirstScreen(com.bytedance.ai.lynx.g r100) {
        }

        @Override // com.bytedance.ai.lynx.r
        public final void onPageUpdate(com.bytedance.ai.lynx.g r100) {
        }

        @Override // com.bytedance.ai.lynx.r
        public final void onRuntimeReady(com.bytedance.ai.lynx.g r100) {
        }

        @Override // com.bytedance.ai.lynx.r
        public final void onTimingUpdate(com.bytedance.ai.lynx.g r100, Map<String, Object> r101, Map<String, Long> r102, String r103) {
        }

        public b(AppletPageFragment r100) {
            this.f34889a = r100;
        }

        @Override // com.bytedance.ai.lynx.r
        public final void onLoadUriSuccess(Uri r100, com.bytedance.ai.lynx.g r101) {
            this.f34889a.f34874d.c("onLoadUriSuccess: uri = " + r100 + ", annieXLynxView = " + r101);
            AppletPageTimelineTracker r102 = this.f34889a.f34883m;
            if (r102 != null) goto L5;
        L8:
            AppletPageFragment r103 = this.f34889a;
            r103.f34881k = true;
            r103.V90(t.a.f34426a);
            return;
        L5:
            if (r102.f34891b == true) goto L8;
            i1 r104 = y0.f512051a;
            y0.f(r102.f34890a, "applet_page_timeline_full");
            r102.f34891b = true;
            goto L8
        }

        @Override // com.bytedance.ai.lynx.r
        public final void onPageStart(com.bytedance.ai.lynx.g r100, String r101) {
            this.f34889a.f34874d.c("onPageStart: url = " + r101 + ", annieXLynxView = " + r100);
            AppletPageFragment r102 = this.f34889a;
            r102.f34880j = true;
            r102.S90();
        }

        @Override // com.bytedance.ai.lynx.r
        public final void onReceivedError(com.bytedance.ai.lynx.g r100, LynxError r101) {
            AtomicInteger r102 = com.bytedance.ai.applet.base.log.d.f34519d;
            this.f34889a.f34874d.a("onReceivedError: annieXLynxView = " + r100 + ", error = " + r101, null);
            AppletPageFragment r103 = this.f34889a;
            if (r101 == null) goto L6;
            String r104 = r101.toString();
            if (r104 == null) goto L6;
        L7:
            if (r101 == null) goto L9;
            int r105 = r101.getErrorCode();
        L10:
            r103.U90(r104, r105);
            return;
        L9:
            r105 = AppletErrorCode.WEB_VIEW_LOAD_ERROR.getType();
        L6:
            r104 = "unknown Lynx error";
            goto L7
        }

        @Override // com.bytedance.ai.lynx.r
        public final void onTimingSetup(com.bytedance.ai.lynx.g r100, Map<String, Object> r101) {
            this.f34889a.f34874d.c("onTimingSetup: timingInfo = " + r101);
            AppletPageTimelineTracker r102 = this.f34889a.f34883m;
            if (r102 == null) goto L5;
            i1 r103 = y0.f512051a;
            y0.n(r102.f34890a, r101, "applet_page_timeline_full");
        L5:
            if (r101 == null) goto L9;
            r r104 = this.f34889a.f34886p;
            if (r104 == null) goto L9;
            r104.o(r101);
        L9:
            AppletPageFragment r105 = this.f34889a;
            r105.f34886p = null;
            if (r105.f34881k == true) goto L13;
            r105.f34881k = true;
            r105.V90(t.a.f34426a);
            return;
        }
    }

    static {
        f34873s = new a();
    }

    public final void S90() {
        if (this.f34877g == true) goto L5;
        return;
    L5:
        AppletAppManagerService r100 = AppletAppManagerService.INSTANCE;
        String r101 = this.f34875e;
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        r100.getClass();
        AppletApplication r102 = AppletAppManagerService.a(r101);
        if (r102 == null) goto L25;
        v r103 = r102.h();
        if (r103 == null) goto L26;
        com.bytedance.ai.applet.app.foundation.a r104 = r103.b();
        if (r104 != null) goto L15;
        return;
    L15:
        if (this.f34878h == true) goto L17;
        AppletAppActivity r105 = r104.f34200a.f34085d;
        if (r105 == null) goto L31;
        r105.O1();
        return;
    L31:
        return;
    L17:
        if (this.f34880j == false) goto L28;
        AppletAppActivity r106 = r104.f34200a.f34085d;
        if (r106 == null) goto L29;
        r106.Z1();
        return;
    L29:
        return;
    L28:
        return;
    L26:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        this.f34874d.c("onDestroyView");
        AppletPageTimelineTracker r100 = this.f34883m;
        if (r100 != null) goto L5;
    L8:
        r r101 = this.f34886p;
        if (r101 == null) goto L11;
        com.bytedance.ai.applet.app.foundation.performance.k.d(r101, AppletPerformanceOutcome.CANCELLED, 0, AppletPerformanceErrorCode.CANCELLED, "closed_before_complete", 2);
    L11:
        this.f34886p = null;
        w3.b r102 = this.f34882l;
        if (r102 == null) goto L14;
        r102.a();
    L14:
        this.f34882l = null;
        com.bytedance.ai.lynx.g r103 = this.f34879i;
        if (r103 == null) goto L17;
        r103.destroy();
    L17:
        this.f34879i = null;
        this.f34880j = false;
        this.f34881k = false;
        super.onDestroyView();
        return;
    L5:
        if (r100.f34892c == true) goto L8;
        i1 r104 = y0.f512051a;
        y0.p(r100.f34890a, "applet_page_timeline_full", false);
        y0.o(r100.f34890a, "applet_page_timeline_full");
        r100.f34892c = true;
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        this.f34874d.c("onPause");
        super.onPause();
        T90();
    }

    /* JADX WARN: Type inference failed for: r2v9, types: [com.bytedance.ai.applet.page.g] */
    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        this.f34874d.c("onResume");
        super.onResume();
        View r100 = this.f34879i;
        if (r100 == null) goto L20;
        w3.b r101 = this.f34882l;
        if (r101 != null) goto L8;
        r101 = new w3.b(new g(this));
        this.f34882l = r101;
    L8:
        Intrinsics.checkNotNullParameter(r100, "anchorView");
        WeakReference<View> r102 = r101.f558092b;
        if (r102 == null) goto L11;
        View r103 = r102.get();
    L12:
        if (r103 != r100) goto L14;
        r101.b();
        goto L20
    L14:
        r101.a();
        r101.f558092b = new WeakReference(r100);
        r100.addOnAttachStateChangeListener(r101);
        if (r100.isAttachedToWindow() == false) goto L20;
        ViewTreeObserver r104 = r100.getViewTreeObserver();
        if (r104.isAlive() == false) goto L19;
        r104.addOnGlobalLayoutListener(r101);
    L19:
        r101.b();
        goto L20
    L11:
        r103 = null;
    L20:
        T90();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        this.f34874d.c("onStop");
        w3.b r100 = this.f34882l;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        T90();
        super.onStop();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.ai.applet.page.h] */
    public AppletPageFragment() {
        this.f34874d = new com.bytedance.ai.applet.base.log.d("AppletPageFragment", null);
        w r100 = new w();
        this.f34885o = r100;
        r100.d(new q4.a());
        this.f34887q = new b(this);
        this.f34888r = new h(this);
    }

    public final void T90() {
        if (isResumed() == true) goto L5;
    L7:
        boolean r100 = false;
    L8:
        List<Fragment> r101 = getParentFragmentManager().getFragments();
        ListIterator<Fragment> r102 = r101.listIterator(r101.size());
    L10:
        if (r102.hasPrevious() == false) goto L17;
        Fragment r103 = r102.previous();
        if (r103.getId() != R.id.app_page_container) goto L14;
        boolean r104 = true;
    L15:
        if (r104 == false) goto L10;
    L18:
        if (r103 != this) goto L20;
        boolean r105 = true;
    L21:
        if (r100 == false) goto L24;
        if (r105 == false) goto L24;
        boolean r106 = true;
    L25:
        if (r106 == true) goto L27;
    L32:
        if (r106 == false) goto L34;
        return;
    L34:
        if (this.f34877g == false) goto L46;
        this.f34877g = false;
        this.f34874d.c("notifyPageHide");
        this.f34885o.a("onHide", null);
        com.bytedance.ai.lynx.g r107 = this.f34879i;
        if (r107 == null) goto L47;
        r107.onEnterBackground();
        return;
    L47:
        return;
    L46:
        return;
    L27:
        if (this.f34877g == true) goto L32;
        this.f34877g = true;
        S90();
        this.f34874d.c("notifyPageShow");
        com.bytedance.ai.lynx.g r108 = this.f34879i;
        if (r108 == null) goto L31;
        r108.onEnterForeground();
    L31:
        this.f34885o.a(SendEventContainerMethodParamModel.EventKinds.onShow, null);
        return;
    L24:
        r106 = false;
        goto L25
    L20:
        r105 = false;
        goto L21
    L14:
        r104 = false;
        goto L15
    L17:
        r103 = null;
        goto L18
    L5:
        if (isHidden() == true) goto L7;
        r100 = true;
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        getParentFragmentManager().removeOnBackStackChangedListener(this.f34888r);
        Long r100 = t2.b.b(this);
        if (r100 == null) goto L11;
        long r101 = r100.longValue();
        AppletAppManagerService r102 = AppletAppManagerService.INSTANCE;
        String r103 = this.f34875e;
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        r102.getClass();
        AppletApplication r104 = AppletAppManagerService.a(r103);
        if (r104 == null) goto L11;
        AppletModelContextProvider r105 = (AppletModelContextProvider) r104.h().f34410n.getValue();
        r105.f34189b.remove(Long.valueOf(r101));
        com.bytedance.ai.utils.g.f37637a.i("AppletModelContextProvider", "removePageContext, traceId=" + r101 + ", totalPages=" + r105.f34189b.size());
        r104.h().d().k(r101);
    L11:
        super.onDestroy();
    }

    public final void V90(t r100) {
        FragmentActivity r101 = getActivity();
        if ((r101 instanceof AppletAppActivity) == false) goto L5;
        AppletAppActivity r102 = (AppletAppActivity) r101;
    L6:
        if (r102 == null) goto L11;
        Intrinsics.checkNotNullParameter(this, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r100, "state");
        if (r102.f34076i != this) goto L12;
        r102.S1(r100);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        this.f34874d.c(WidgetCostModule.TYPE_ON_CREATE);
        super.onCreate(r100);
        Bundle r101 = getArguments();
        if (r101 == null) goto L24;
        String r102 = r101.getString("app_id");
        if (r102 != null) goto L7;
        return;
    L7:
        this.f34875e = r102;
        String r103 = r101.getString("url");
        if (r103 != null) goto L10;
        return;
    L10:
        this.f34876f = r103;
        this.f34883m = (AppletPageTimelineTracker) r101.getParcelable("page_timeline_tracker");
        this.f34884n = r101.getString("conversation_id");
        Long r104 = t2.b.b(this);
        if (r104 == null) goto L24;
        long r105 = r104.longValue();
        AppletAppManagerService r106 = AppletAppManagerService.INSTANCE;
        String r107 = this.f34875e;
        if (r107 != null) goto L15;
        r107 = "";
    L15:
        r106.getClass();
        AppletApplication r108 = AppletAppManagerService.a(r107);
        if (r108 == null) goto L22;
        v r109 = r108.h();
        if (r109 == null) goto L22;
        com.bytedance.ai.applet.app.foundation.performance.c r110 = r109.c();
        if (r110 == null) goto L22;
        r r111 = r110.f(r105);
    L23:
        this.f34886p = r111;
    L22:
        r111 = null;
    L24:
        getParentFragmentManager().addOnBackStackChangedListener(this.f34888r);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onHiddenChanged(boolean r100) {
        super.onHiddenChanged(r100);
        this.f34874d.c("onHiddenChanged: " + r100);
        T90();
    }

    public final void U90(String r100, int r101) {
        if (this.f34881k == true) goto L5;
        V90(new t.b(r100));
    L5:
        AppletPageTimelineTracker r102 = this.f34883m;
        if (r102 == null) goto L8;
        r102.a(r100, r101);
    L8:
        r r103 = this.f34886p;
        boolean r104 = false;
        if (r103 != null) goto L11;
    L13:
        if (r104 == false) goto L16;
        this.f34886p = null;
        return;
    L16:
        return;
    L11:
        if (r103.c(AppletPerformanceErrorCode.PAGE_RENDER_ERROR, r100 + ", sourceErrorCode=" + r101) != true) goto L13;
        r104 = true;
        goto L13
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        this.f34874d.c("onCreateView");
        String r113 = this.f34875e;
        String r114 = this.f34876f;
        boolean r115 = false;
        if (r114 != null) goto L5;
    L8:
        boolean r116 = true;
    L10:
        if (r116 == true) goto L37;
        if (r113 != null) goto L13;
    L16:
        boolean r117 = true;
    L17:
        if (r117 == true) goto L37;
        AppletAppManagerService.INSTANCE.getClass();
        AppletApplication r118 = AppletAppManagerService.a(r113);
        if ((r118 instanceof OnlineAppletApplication) == false) goto L22;
        OnlineAppletApplication r100 = (OnlineAppletApplication) r118;
    L23:
        if (r100 != null) goto L26;
        this.f34874d.a("onCreateView: app is null, appId = ".concat(r113), null);
        U90("app is null, appId = ".concat(r113), AppletErrorCode.LYNX_VIEW_CREATE_ERROR.getType());
        return null;
    L26:
        Page r101 = r100.j().q(this.f34876f);
        if (r101 != null) goto L30;
        this.f34874d.a("onCreateView: page is null, url = " + this.f34876f, null);
        U90("page is null, url = " + this.f34876f, AppletErrorCode.PAGE_NOT_FOUND.getType());
        return null;
    L30:
        PageChatConfig r119 = r101.getChatConfig();
        if (r119 != null) goto L33;
    L35:
        this.f34878h = r115;
        FrameLayout r120 = new FrameLayout(requireContext());
        r120.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AppletPageFragment$loadLynxView$1(this, r101, r100, r120, null), 3, null);
        return r120;
    L33:
        if (r119.getEnabled() != true) goto L35;
        r115 = true;
        goto L35
    L22:
        r100 = null;
        goto L23
    L13:
        if (r113.length() == 0) goto L16;
        r117 = false;
    L37:
        this.f34874d.a("onCreateView: url or appId is null", null);
        U90("url or appId is null", AppletErrorCode.LYNX_VIEW_CREATE_ERROR.getType());
        return null;
    L5:
        if (r114.length() == 0) goto L8;
        r116 = false;
        goto L10
    }
}
