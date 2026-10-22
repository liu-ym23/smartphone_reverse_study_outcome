package com.bytedance.ai.model.widgets;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.core.os.HandlerCompat;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.Page;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.PageStatus;
import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMapKeySetIterator;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes43.dex */
public abstract class c implements k2.j {
    public static final a Companion = null;
    private static final String TAG = "AIContainerViewBase";
    private final String _renderType;
    private final AppletRuntime appletRuntime;
    private HashMap<String, Object> eventCommonParams;
    private boolean isPageLoadFinish;
    private final Lazy mMainHandler$delegate;
    private final String pageId;
    private PageInfo pageInfo;
    private PageStatus pageStatus;
    private boolean pendingOnShow;
    private KClass<?> renderClass;
    private String selectionContent;
    private String uiContext;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f37016a;

        public b(c r100) {
            this.f37016a = r100;
        }

        public final void a() {
            if (this.f37016a.getPageStatus() == PageStatus.RE_CREATE) goto L5;
            AppletRuntimeManager r100 = AppletRuntimeManager.INSTANCE;
            String r101 = this.f37016a.getPageID();
            r100.getClass();
            AppletRuntimeManager.m(r101);
        L5:
            AppletRuntime r102 = this.f37016a.getAppletRuntime();
            r102.f36719h.g();
            r102.f();
            this.f37016a.setPageStatus(PageStatus.DESTROY);
            d3.b0 r103 = this.f37016a.getAIBridge();
            if (r103 == null) goto L9;
            JsonObject r104 = new JsonObject();
            r104.addProperty("eventName", this.f37016a.getPageInfo().toViewContext());
            Unit r105 = Unit.INSTANCE;
            r103.a(LiveCommonConstants.REASON_ON_DEDTROY, r104);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.model.widgets.c$c, reason: collision with other inner class name */
    public static final class C0708c implements k5.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f37017a;

        public C0708c(c r100) {
            this.f37017a = r100;
        }

        @Override // k5.j
        public final void a(AppletMonitorableEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            r100.f37145f = this.f37017a.getAppletRuntime().f36719h.f36895b;
            r100.f37146g = this.f37017a.getAppletRuntime().f36719h.o();
            r100.f("renderType", this.f37017a.getRenderType());
            r100.h(this.f37017a.getPageInfo().buildMonitorEvent());
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ Handler f() {
        return mMainHandler_delegate$lambda$1();
    }

    public static /* synthetic */ void g(c r100) {
        onViewFinish$lambda$8(r100);
    }

    @Override // k2.k
    public k2.m getContainerViewService() {
        return null;
    }

    @Override // k2.j
    public k2.t getFloatingSpeakerController() {
        return null;
    }

    @Override // k2.j
    public void handleContentSizeChange(double r100, double r101) {
    }

    @Override // k2.o
    public void handleWebViewDrawEnd(long r100, long r101) {
    }

    public void onFocusChange(boolean r100) {
    }

    public void sendUIAction(String r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
    }

    @Override // k2.j
    public void setFloatingSpeakerController(k2.t r100) {
    }

    private final Handler getMMainHandler() {
        return (Handler) this.mMainHandler$delegate.getValue();
    }

    private static final Handler mMainHandler_delegate$lambda$1() {
        return new Handler(Looper.getMainLooper());
    }

    @Override // k2.j
    public void doRefresh() {
        if (f2.k.f475104b == false) goto L6;
        AppletRuntime r100 = this.appletRuntime;
        AtomicInteger r101 = AppletRuntime.f36716x;
        r100.B(null, null);
        return;
    }

    @Override // k2.i
    public String getAppletId() {
        return this.appletRuntime.f36719h.K;
    }

    @Override // k2.i
    public void onDestroy() {
        com.bytedance.ai.utils.g.f37637a.i(TAG, LiveCommonConstants.REASON_ON_DEDTROY);
        this.isPageLoadFinish = false;
        getMMainHandler().removeCallbacksAndMessages(this);
        HandlerCompat.postDelayed(getMMainHandler(), new b(this), this, 100);
    }

    @Override // k2.i
    public void onHostDestroy() {
        com.bytedance.ai.utils.g.f37637a.i(TAG, "onHostDestroy");
    }

    @Override // k2.i
    public void onHostHide() {
        com.bytedance.ai.utils.g.f37637a.i(TAG, "onHostHide");
    }

    @Override // k2.i
    public void onHostShow() {
        com.bytedance.ai.utils.g.f37637a.i(TAG, "onHostShow");
    }

    @Override // k2.i
    public String getBotId() {
        return getPageInfo().getBotId();
    }

    @Override // k2.i
    public void onHide() {
        getMMainHandler().removeCallbacksAndMessages(this);
        com.bytedance.ai.utils.g.f37637a.i(TAG, "onHide");
        this.pendingOnShow = false;
        this.pageStatus = PageStatus.INVISIABLE;
        d3.b0 r100 = getAIBridge();
        if (r100 == null) goto L6;
        JsonObject r101 = new JsonObject();
        r101.addProperty("eventName", getPageInfo().toViewContext());
        Unit r102 = Unit.INSTANCE;
        r100.a("onHide", r101);
        return;
    }

    @Override // k2.i
    public void onShow() {
        getMMainHandler().removeCallbacksAndMessages(this);
        com.bytedance.ai.utils.g r100 = com.bytedance.ai.utils.g.f37637a;
        r100.i(TAG, SendEventContainerMethodParamModel.EventKinds.onShow);
        this.pageStatus = PageStatus.VISIABLE;
        if (this.isPageLoadFinish == true) goto L6;
        this.pendingOnShow = true;
        return;
    L6:
        r100.d(TAG, "widget " + getPageID() + " onShow send");
        d3.b0 r101 = getAIBridge();
        if (r101 == null) goto L10;
        JsonObject r102 = new JsonObject();
        r102.addProperty("eventName", getPageInfo().toViewContext());
        Unit r103 = Unit.INSTANCE;
        r101.a(SendEventContainerMethodParamModel.EventKinds.onShow, r102);
        return;
    }

    @Override // k2.j
    public String viewContext() {
        getPageInfo().setPageId(getPageID());
        return getPageInfo().toViewContext();
    }

    @Override // k2.j
    public final AppletRuntime getAppletRuntime() {
        return this.appletRuntime;
    }

    @Override // k2.i
    public HashMap<String, Object> getEventCommonParams() {
        return this.eventCommonParams;
    }

    @Override // k2.i
    public String getPageID() {
        return this.pageId;
    }

    @Override // k2.j
    public PageInfo getPageInfo() {
        return this.pageInfo;
    }

    public final PageStatus getPageStatus() {
        return this.pageStatus;
    }

    @Override // k2.k
    public KClass<?> getRenderClass() {
        return this.renderClass;
    }

    public String getRenderType() {
        return this._renderType;
    }

    public final String selectionContent() {
        return this.selectionContent;
    }

    public final String uiContext() {
        return this.uiContext;
    }

    private static final void onViewFinish$lambda$8(c r100) {
        d3.w r101 = r100.appletRuntime.u();
        if (r101 == null) goto L6;
        JsonObject r102 = new JsonObject();
        r102.addProperty("viewId", r100.getPageID());
        Unit r103 = Unit.INSTANCE;
        r101.a("onPageOpened", r102);
    L6:
        if (r100.pendingOnShow == false) goto L11;
        d3.b0 r104 = r100.getAIBridge();
        if (r104 == null) goto L12;
        JsonObject r105 = new JsonObject();
        r105.addProperty("viewId", r100.getPageID());
        r105.addProperty("eventName", r100.getPageInfo().toViewContext());
        Unit r106 = Unit.INSTANCE;
        r104.a(SendEventContainerMethodParamModel.EventKinds.onShow, r105);
        return;
    L12:
        return;
    }

    private final void reportAppletEvent(String r100) {
        com.bytedance.ai.monitor.b.d(r100, new C0708c(this));
    }

    public final String getTargetUrl(PageInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "pageInfo");
        String r101 = r100.getPageUrl();
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        return r101;
    L12:
        return getLoadUrl(r101, r100.getPageSettings());
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    @Override // k2.i
    public void onViewError(String r100) {
        com.bytedance.ai.utils.g.f37637a.i(TAG, "onViewError");
        this.pageStatus = PageStatus.LOADING_ERROR;
    }

    @Override // k2.i
    public void onViewFinish(String r100) {
        com.bytedance.ai.utils.g.f37637a.i(TAG, "onViewFinish");
        this.isPageLoadFinish = true;
        this.pageStatus = PageStatus.LOADING_FINISH;
        p2.c.e(new com.bytedance.ai.model.widgets.a(this), 100);
        reportAppletEvent("applet_view_load_finish");
    }

    @Override // k2.i
    public void onViewStart(String r100) {
        com.bytedance.ai.utils.g.f37637a.i(TAG, "onViewStart");
        this.isPageLoadFinish = false;
        this.pageStatus = PageStatus.LOADING_START;
        reportAppletEvent("applet_view_start");
    }

    @Override // k2.i
    public void setEventCommonParams(HashMap<String, Object> r100) {
        this.eventCommonParams = r100;
    }

    public void setPageInfo(PageInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.pageInfo = r100;
    }

    public final void setPageStatus(PageStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.pageStatus = r100;
    }

    public void setRenderClass(KClass<?> r100) {
        this.renderClass = r100;
    }

    public void setSelectionContent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "selection");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        this.selectionContent = r100;
        String r102 = this.appletRuntime.f36719h.N;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r103 = AppletRuntimeManager.f36749d;
        if (r103 == null) goto L15;
        if (r102 == null) goto L12;
        String r104 = x4.a.a(r102);
    L13:
        r103.k(r104, r102);
        return;
    L12:
        r104 = null;
        goto L13
    L15:
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // k2.j
    public void setUiContext(String r100) {
        this.uiContext = r100;
        String r101 = getPageInfo().getMessageId();
        if (r101 == null) goto L7;
        r4.h r102 = r4.a.f535985l;
        if (r102 == null) goto L7;
        r102.b(r101, r100);
    L7:
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r103 = AppletRuntimeManager.f36749d;
        if (r103 == null) goto L15;
        String r104 = this.appletRuntime.f36719h.N;
        if (r104 == null) goto L12;
        String r105 = x4.a.a(r104);
    L13:
        r103.k(r105, this.appletRuntime.f36719h.N);
        return;
    L12:
        r105 = null;
        goto L13
    }

    public c(AppletRuntime r100, PageInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "appletRuntime");
        Intrinsics.checkNotNullParameter(r101, "pageInfo");
        this.appletRuntime = r100;
        this.pageInfo = r101;
        Companion.getClass();
        String r102 = UUID.randomUUID().toString();
        getPageInfo().setPageId(r102);
        this.pageId = r102;
        this.mMainHandler$delegate = LazyKt.lazy(new com.bytedance.ai.model.widgets.b());
        this.pageStatus = PageStatus.NONE;
        List<Page> r103 = r100.f36719h.L;
        Page r104 = null;
        Object r105 = null;
        if (r103 == null) goto L11;
        Iterator<T> r106 = r103.iterator();
    L6:
        if (r106.hasNext() == false) goto L10;
        Object r107 = r106.next();
        if (Intrinsics.areEqual(((Page) r107).pageId(), getPageInfo().getPageName()) == false) goto L6;
        r105 = r107;
    L10:
        r104 = (Page) r105;
    L11:
        if (r104 == null) goto L14;
        String r108 = r104.getRenderType();
        if (r108 == null) goto L14;
    L15:
        this._renderType = r108;
        AppletRuntimeManager.INSTANCE.getClass();
        Intrinsics.checkNotNullParameter(this, "page");
        AppletRuntimeManager.f36747b.put(getPageID(), this);
        Iterator<T> r109 = AppletRuntimeManager.f36752g.iterator();
    L17:
        if (r109.hasNext() == false) goto L19;
        ((AppletRuntimeManager.b) r109.next()).b();
        goto L17
    L19:
        this.pageStatus = PageStatus.STARTED;
        reportAppletEvent("applet_create_container");
        return;
    L14:
        r108 = this.appletRuntime.f36719h.f36908o;
        goto L15
    }

    private final String getLoadUrl(String r100, ReadableMap r101) {
        AtomicBoolean r102 = f2.b.f475097a;
        h2.a r103 = f2.b.f475099c;
        boolean r104 = false;
        if (r103 != null) goto L5;
    L7:
        if (r104 == false) goto L9;
        return r100;
    L9:
        if (r101 == null) goto L17;
        Uri.Builder r105 = UriProtector.parse(r100).buildUpon();
        ReadableMapKeySetIterator r106 = r101.keySetIterator();
    L12:
        if (r106.hasNextKey() == false) goto L15;
        String r107 = r106.nextKey();
        r105.appendQueryParameter(r107, r101.getString(r107));
        goto L12
    L15:
        return r105.build().toString();
    L17:
        return r100;
    L5:
        if (r103.f483571j != true) goto L7;
        r104 = true;
        goto L7
    }

    public View createPage(PageInfo r100, Context r101, Function1<? super Integer, Unit> r102, Function1<? super String, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "pageInfo");
        AppletRuntime r104 = this.appletRuntime;
        r104.f36719h.e();
        r104.g();
        com.bytedance.ai.utils.g.f37637a.i(TAG, "onHostCreate");
        return null;
    }

    public static /* synthetic */ String getLoadUrl$default(c r100, String r101, ReadableMap r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L7;
        r102 = null;
    L7:
        return r100.getLoadUrl(r101, r102);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLoadUrl");
    }
}
