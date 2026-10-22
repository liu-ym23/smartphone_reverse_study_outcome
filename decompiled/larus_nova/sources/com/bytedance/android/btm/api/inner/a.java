package com.bytedance.android.btm.api.inner;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.View;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmPageLifecycle;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.btm.api.model.j;
import com.bytedance.android.btm.api.model.k;
import com.bytedance.android.btm.api.model.m;
import com.bytedance.android.btm.api.model.o;
import com.bytedance.android.btm.api.model.p;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;
import zc.i;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements com.bytedance.android.btm.api.inner.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0772a f42000a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f42001b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f42002c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f42003d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f42004e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f42005f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f42006g = null;

    /* JADX INFO: renamed from: com.bytedance.android.btm.api.inner.a$a, reason: collision with other inner class name */
    public static final class C0772a implements com.bytedance.android.btm.api.inner.d {
        public C0772a() {
        }

        @Override // com.bytedance.android.btm.api.inner.d
        public void onEventV1(j r100) {
        }

        @Override // com.bytedance.android.btm.api.inner.d
        public void onEventV3(k r100) {
        }
    }

    public static final class b implements i {
        public b() {
        }

        @Override // zc.i
        public final void callback() {
        }
    }

    public static final class c implements com.bytedance.android.btm.api.c {
        public c() {
        }
    }

    public static final class d implements BtmPageLifecycle {
        public d() {
        }

        @Override // com.bytedance.android.btm.api.BtmPageLifecycle
        public final void a(Object r100) {
        }

        @Override // com.bytedance.android.btm.api.BtmPageLifecycle
        public final void b(Object r100, boolean r101) {
        }

        @Override // com.bytedance.android.btm.api.BtmPageLifecycle
        public final void c(Object r100, BtmPageLifecycle.State r101) {
        }

        @Override // com.bytedance.android.btm.api.BtmPageLifecycle
        public final boolean d(Object r100, boolean r101) {
            return false;
        }

        @Override // com.bytedance.android.btm.api.BtmPageLifecycle
        public final void e(Object r100, Boolean r101, m r102) {
        }

        @Override // com.bytedance.android.btm.api.BtmPageLifecycle
        public final BtmPageLifecycle.State f(Object r100) {
            return null;
        }

        @Override // com.bytedance.android.btm.api.BtmPageLifecycle
        public final void g(Object r100, Boolean r101, o r102) {
        }
    }

    public static final class e implements com.bytedance.android.btm.api.inner.g {
        public e() {
        }

        @Override // com.bytedance.android.btm.api.inner.g
        public final void a(int r100, String r101, Object r102, Throwable r103, boolean r104) {
        }

        @Override // com.bytedance.android.btm.api.inner.g
        public final void b(boolean r100, Function0<? extends Object> r101) {
        }

        @Override // com.bytedance.android.btm.api.inner.g
        public final void c(int r100, String r101, Object r102, Throwable r103, boolean r104, Function1<? super JSONObject, Unit> r105) {
        }
    }

    public static final class f implements com.bytedance.android.btm.api.g {
        public f() {
        }

        @Override // com.bytedance.android.btm.api.g
        public final void a(Runnable r100, boolean r101) {
        }

        @Override // com.bytedance.android.btm.api.g
        public final void b(Runnable r100, boolean r101) {
        }
    }

    public static final class g implements com.bytedance.android.btm.api.k {
        public g() {
        }

        @Override // com.bytedance.android.btm.api.k
        public final void a(String r100, View r101, String r102, String r103) {
        }
    }

    public a() {
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final void checkEventParam(j r100) {
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final boolean checkPageBtmFormat(String r100, String r101, boolean r102, String r103, String r104) {
        return true;
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final String createBtmId(com.bytedance.android.btm.api.model.c r100) {
        return "";
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final String createExternalEvokeBtmToken(String r100, String r101, BcmParams r102) {
        return null;
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final String createJumpSourceBtmToken(com.bytedance.android.btm.api.model.d r100, boolean r101) {
        return null;
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final boolean delayEventHook() {
        return false;
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final boolean enableDeepLinkProcess(String r100) {
        return false;
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final boolean enableRouterMonitor() {
        return false;
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final boolean fixBcmValueNotConvert() {
        return false;
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final boolean fixSourceTokenError() {
        return false;
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final com.bytedance.android.btm.api.inner.b getALogWriter() {
        return null;
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final com.bytedance.android.btm.api.model.e getBtmPageInfo(PageFinder r100) {
        return null;
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final Object getCurrentResumedPage() {
        return null;
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final Object getLastCreatedPage() {
        return null;
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final String getLastPageBtm() {
        return null;
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final com.bytedance.android.btm.api.inner.f getLogWriter() {
        return null;
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final String getPageId(PageFinder r100) {
        return null;
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final Object getReportParamsByKey(String r100, String r101, PageFinder r102) {
        return null;
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final void init() {
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final boolean isHybridContainer(View r100) {
        return false;
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final void minimizeInit(Application r100) {
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final boolean onEventHook(Context r100, String r101, String r102, String r103, Long r104, Long r105, Boolean r106, JSONObject r107, boolean r108) {
        return false;
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final void onLowMemory() {
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final void onRegisterHybridContainer(com.bytedance.android.btm.api.i r100) {
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final void onRegisterPage(com.bytedance.android.btm.api.d r100) {
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final void onRegisterPage(com.bytedance.android.btm.api.e r100) {
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final void onUnregisterPage(com.bytedance.android.btm.api.e r100) {
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final boolean processEventModel(j r100) {
        return false;
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final boolean registerBtmPage(View r100, String r101, String r102, Map<String, ? extends Object> r103) {
        return false;
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final void registerBtmPageCallback(bd.b r100) {
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final void registerEventChecker(com.bytedance.android.btm.api.model.i r100) {
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final boolean registerFEBtmPage(View r100, String r101, String r102, Boolean r103, Map<String, ? extends Object> r104) {
        return false;
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final void registerPageBtmWithSchemaAsync(String r100, Object r101, String r102, String r103) {
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final boolean removeBcmChainPageId() {
        return false;
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final boolean removeSearchTokenC() {
        return false;
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final boolean removeSourceBtmTokenInQueue(String r100) {
        return false;
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final void setInitInActivity(Activity r100) {
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final void setInitTag(String r100) {
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final void setStartNode(p r100) {
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final void unregisterBtmPageCallback(bd.b r100) {
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final void updateBtmPage(Object r100, String r101) {
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final void updateLazyDataSettings() {
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final boolean useV2Api() {
        return false;
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final boolean useV2ApiMall() {
        return false;
    }

    static {
        f42006g = new a();
        f42000a = new C0772a();
        f42001b = new e();
        f42002c = new d();
        f42003d = new f();
        f42004e = new c();
        f42005f = new b();
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final com.bytedance.android.btm.api.k getHybridContainerLoadSchemaCallback() {
        return new g();
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final com.bytedance.android.btm.api.inner.d getAppLog() {
        return f42000a;
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final com.bytedance.android.btm.api.c getLaunchApi() {
        return f42004e;
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final com.bytedance.android.btm.api.inner.g getMonitor() {
        return f42001b;
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final BtmPageLifecycle getPageLifecycle() {
        return f42002c;
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final i getSchemaSettingCallback() {
        return f42005f;
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final com.bytedance.android.btm.api.g getThreadExecutor() {
        return f42003d;
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final j addBtmEventParam(j r100) {
        JSONObject r101 = r100.f42064h;
        if (r101 == null) goto L5;
        r101.remove("btm_id");
    L5:
        return r100;
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final JSONObject createBtmChain(com.bytedance.android.btm.api.model.c r100) {
        return new JSONObject();
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final k addBtmEventParam(k r100) {
        JSONObject r101 = r100.f42067b;
        if (r101 == null) goto L5;
        r101.remove("btm_id");
    L5:
        return r100;
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final Map<String, Object> createFullyReportParams(String r100, PageFinder r101) {
        return new LinkedHashMap();
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final void getPageBtmWithSchemaAsync(String r100, h r101) {
        r101.call("", null);
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final Map<String, Object> createReportParams(String r100, PageFinder r101, Set<String> r102) {
        return new LinkedHashMap();
    }

    @Override // com.bytedance.android.btm.api.inner.e
    public final Map<String, Object> generateBtmEventParams(String r100, int r101, String r102) {
        return new LinkedHashMap();
    }
}
