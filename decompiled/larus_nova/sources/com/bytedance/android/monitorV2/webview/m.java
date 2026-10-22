package com.bytedance.android.monitorV2.webview;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.android.anniex.monitor.salamander.SLMonitorCompat;
import com.bytedance.android.monitorV2.DataReporter;
import com.bytedance.android.monitorV2.dataprocessor.TypedDataDispatcher;
import com.bytedance.android.monitorV2.entity.NativeCommon;
import com.bytedance.android.monitorV2.event.HybridEvent;
import com.bytedance.android.monitorV2.hybridSetting.Switches;
import com.bytedance.android.monitorV2.webview.cache.impl.WebNativeCommon;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class m implements sz2.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final m f163358f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f163359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f163360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f163361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n f163362d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f163363e;

    @Override // sz2.c
    public final void a(String r100, Object r101) {
    }

    static {
        f163358f = new m();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class g() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.lynx.webview.TTWebSdk");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.lynx.webview.TTWebSdk");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.lynx.webview.TTWebSdk");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.lynx.webview.TTWebSdk");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.lynx.webview.TTWebSdk");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.lynx.webview.TTWebSdk");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.lynx.webview.TTWebSdk");
    }

    public final boolean B() {
        if (this.f163360b == true) goto L5;
    L9:
        boolean r100 = false;
    L11:
        if (this.f163363e == r100) goto L13;
        nz2.b.f("WebViewMonitorHelper", "monitor enabled: " + r100);
        this.f163363e = r100;
    L13:
        return r100;
    L5:
        if (Switches.monitor.isEnabled() == false) goto L9;
        if (Switches.webMonitor.isEnabled() == false) goto L9;
        r100 = true;
        goto L11
    }

    public final boolean D() {
        if (this.f163359a == true) goto L5;
    L9:
        return false;
    L5:
        if (this.f163361c == false) goto L9;
        if (Switches.webTTWebDelegate.isEnabled() == false) goto L9;
        return true;
    }

    public m() {
        this.f163359a = false;
        this.f163360b = true;
        this.f163361c = true;
        this.f163362d = new n();
        this.f163363e = false;
        sz2.e.f543917a.getClass();
        Intrinsics.checkNotNullParameter("web", "name");
        Intrinsics.checkNotNullParameter(this, "action");
        sz2.e.f543919c.put("web", this);
        Class r100 = g();     // Catch: Throwable -> L5
        r100.getDeclaredMethod("registerGlobalWebViewHandler", new Class[]{InvocationHandler.class}).invoke(null, new Object[]{new f()});     // Catch: Throwable -> L5
        r100.getDeclaredMethod("registerGlobalWebViewHandler", new Class[]{InvocationHandler.class}).invoke(null, new Object[]{new e()});     // Catch: Throwable -> L5
        r100.getDeclaredMethod("registerGlobalWebViewHandler", new Class[]{InvocationHandler.class}).invoke(null, new Object[]{new d()});     // Catch: Throwable -> L5
        this.f163359a = true;     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        this.f163359a = false;
        com.bytedance.android.monitorV2.util.f.b(th);
    }

    public static boolean C(WebResourceRequest r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (r100.isForMainFrame() == true) goto L13;
        Uri r101 = r100.getUrl();
        if (r101 == null) goto L14;
        String r102 = r101.getPath();
        if (r102 != null) goto L10;
        return false;
    L10:
        return r102.endsWith("favicon.ico");
    L14:
        return false;
    L13:
        return false;
    }

    public final void A(WebView r100) {
        nz2.b.f("WebViewMonitorHelper", "handleViewCreate: " + nz2.b.e(r100));
        if (D() == true) goto L5;
    L17:
    L14:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);
        return;
    L8:
        if (B() == false) goto L19;
        if (r100 == null) goto L20;
        this.f163362d.o(r100);     // Catch: Throwable -> L14
        return;
    L20:
        return;
    L19:
        return;
    L5:
        if (this.f163362d.i(r100) == false) goto L17;
    }

    public final void E(WebView r100) {
        nz2.b.f("WebViewMonitorHelper", r100.getClass().getSimpleName() + " attachToWindow, container: " + r100.getContext().getClass().getName() + ", isTTWebEnable: " + D());
        if (D() == true) goto L5;
    L18:
    L15:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);
        return;
    L8:
        if (B() == true) goto L11;
        return;
    L11:
        if (this.f163362d.h(r100) == false) goto L21;
        this.f163362d.j(r100);     // Catch: Throwable -> L15
        return;
    L21:
        return;
    L5:
        if (this.f163362d.i(r100) == false) goto L18;
    }

    public final void M(WebView r100) {
        nz2.b.f("WebViewMonitorHelper", "reload: " + nz2.b.e(r100));
        if (D() == false) goto L6;
        this.f163362d.i(r100);
        return;
    }

    public final void N(String... r100) {
        n r101 = this.f163362d;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "webViewClassesNames");
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        String r104 = r100[r103];
        HashMap<String, c> r105 = r101.f163364a;
        if (r105 == null) goto L8;
        TypeIntrinsics.asMutableMap(r105).remove(r104);
        r103 = r103 + 1;
        goto L3
    L8:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    }

    @Override // sz2.c
    public final jz2.e b(View r100) {
        if (r100 == null) goto L14;
        if ((r100 instanceof WebView) == false) goto L12;
        n r101 = this.f163362d;
        WebView r102 = (WebView) r100;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "webView");
        NavigationDataManager r103 = r101.f(r102).f163290f;
        if (r103 == null) goto L10;
        jz2.e r104 = r103.f163268j;
        if (r104 == null) goto L10;
        return r104;
    L10:
        return new jz2.e(new NativeCommon());
    L12:
        return new jz2.e(new NativeCommon());
    L14:
        return new jz2.e(new NativeCommon());
    }

    public final void h(c r100) {
        n r101 = this.f163362d;
        r101.getClass();
        if (r100 == null) goto L28;
        c r102 = n.b(r100);     // Catch: Exception -> L21
        String[] r103 = r102.f163337b;     // Catch: Exception -> L21
        int r104 = 0;
        if (r103 != null) goto L8;
    L12:
        String[] r105 = r102.f163336a;     // Catch: Exception -> L21
        if (r105 != null) goto L15;
    L19:
        r101.f163366c.clear();     // Catch: Exception -> L21
        return;
    L15:
        if (r105.length == 0) goto L19;
        int r106 = r105.length;     // Catch: Exception -> L21
    L17:
        if (r104 >= r106) goto L19;
        String r107 = r105[r104];     // Catch: Exception -> L21
        r101.f163364a.put(r107, r102);     // Catch: Exception -> L21
        r104 = r104 + 1;     // Catch: Exception -> L21
        goto L17
    L8:
        if (r103.length == 0) goto L12;
        int r108 = r103.length;     // Catch: Exception -> L21
        int r109 = 0;
    L10:
        if (r109 >= r108) goto L12;
        String r110 = r103[r109];     // Catch: Exception -> L21
        r101.f163365b.put(r110, r102);     // Catch: Exception -> L21
        r109 = r109 + 1;     // Catch: Exception -> L21
    L21:
        e = move-exception;
        com.bytedance.android.monitorV2.util.f.b(e);
        return;
    }

    public final void k(WebView r100) {
        nz2.b.f("WebViewMonitorHelper", "destroy: " + nz2.b.e(r100));
        if (D() == true) goto L5;
    L15:
    L12:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);
        return;
    L8:
        if (B() == false) goto L17;
        this.f163362d.p(r100);     // Catch: Throwable -> L12
        return;
    L17:
        return;
    L5:
        if (this.f163362d.i(r100) == false) goto L15;
    }

    public final void l(WebView r100) {
        nz2.b.f("WebViewMonitorHelper", "goBack: " + nz2.b.e(r100));
        if (D() == true) goto L5;
    L7:
        m(r100);
        return;
    L5:
        if (this.f163362d.i(r100) == false) goto L7;
    }

    public final void m(WebView r100) {
    L10:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);
        return;
    L3:
        if (B() == true) goto L6;
        return;
    L6:
        if (this.f163362d.h(r100) == true) goto L8;
        return;
    L8:
        n r101 = this.f163362d;     // Catch: Throwable -> L10
        r101.getClass();     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r100, "webView");     // Catch: Throwable -> L10
        WebViewDataManager r102 = r101.f(r100);     // Catch: Throwable -> L10
        r102.e();     // Catch: Throwable -> L10
        r102.h(false);     // Catch: Throwable -> L10
    }

    public final void F(WebView r100, String r101) {
        nz2.b.f("WebViewMonitorHelper", "onLoadUrl: " + r101);
        if (D() == true) goto L5;
    L7:
        G(r100, r101);
        return;
    L5:
        if (this.f163362d.i(r100) == false) goto L7;
    }

    public final void G(WebView r100, String r101) {
    L13:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);
        return;
    L3:
        if (B() == true) goto L6;
        return;
    L6:
        if (this.f163362d.h(r100) == true) goto L9;
        return;
    L9:
        if (r101.contains("javascript:") == false) goto L11;
        return;
    L11:
        this.f163362d.k(r100, r101);     // Catch: Throwable -> L13
    }

    public final void H(WebView r100, String r101) {
        nz2.b.f("WebViewMonitorHelper", "onPageFinished: " + r101);
        if (D() == true) goto L5;
    L15:
    L12:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);
        return;
    L8:
        if (this.f163362d.h(r100) == false) goto L17;
        this.f163362d.l(r100, r101);     // Catch: Throwable -> L12
        return;
    L17:
        return;
    L5:
        if (this.f163362d.i(r100) == false) goto L15;
    }

    public final void I(WebView r100, String r101) {
        nz2.b.f("WebViewMonitorHelper", "onPageStarted:" + r101);
        if (D() == true) goto L5;
    L7:
        J(r100, r101);
        return;
    L5:
        if (this.f163362d.i(r100) == false) goto L7;
    }

    public final void J(WebView r100, String r101) {
        com.bytedance.android.monitorV2.event.a r102 = new com.bytedance.android.monitorV2.event.a("navigationStart");
        r102.c();     // Catch: Throwable -> L12
        if (r100 != null) goto L7;
        return;
    L7:
        if (this.f163362d.h(r100) == true) goto L10;
        r102.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);     // Catch: Throwable -> L12
        return;
    L10:
        r102.f163006f.url = r101;     // Catch: Throwable -> L12
        this.f163362d.m(r100, r102);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        r102.onEventTerminated(HybridEvent.TerminateType.CATCH_EXCEPTION);
        com.bytedance.android.monitorV2.util.f.b(th);
    }

    public final void K(WebView r100, int r101) {
        nz2.b.f("WebViewMonitorHelper", "onProgressChanged: " + nz2.b.e(r100) + ", newProgress: " + r101);
        if (D() == true) goto L5;
    L7:
        L(r100, r101);
        return;
    L5:
        if (this.f163362d.i(r100) == false) goto L7;
    }

    public final void L(WebView r100, int r101) {
    L15:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);
        return;
    L3:
        if (B() == true) goto L5;
        return;
    L5:
        if (r100 == null) goto L23;
    L12:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);     // Catch: Throwable -> L15
        return;
    L8:
        if (this.f163362d.h(r100) == false) goto L22;
        this.f163362d.n(r100, r101);     // Catch: Throwable -> L12
    L24:
        return;
    L22:
        return;
    }

    @Override // sz2.c
    public final void c(View r100, jz2.d r101) {
        if ((r100 instanceof WebView) == false) goto L5;
        j((WebView) r100, r101);
        return;
    L5:
        nz2.b.b("WebViewMonitorHelper", "customReport: view not match WebView");
    }

    public final void j(WebView r100, jz2.d r101) {
        SLMonitorCompat.f41001a.getClass();
        SLMonitorCompat.j(r100, r101);
        com.bytedance.android.monitorV2.event.b r102 = new com.bytedance.android.monitorV2.event.b(r101);
        if (B() == true) goto L6;
        r102.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);
        return;
    L6:
        if (r100 != null) goto L10;
        TypedDataDispatcher r103 = DataReporter.f162979a;
        DataReporter.h(r102, Boolean.TRUE);
        return;
    L10:
        if (this.f163362d.h(r100) == true) goto L13;
        r102.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);
        return;
    L13:
        this.f163362d.d(r100, r102);
    }

    public final void n(WebView r100, jz2.g r101) {
        com.bytedance.android.monitorV2.event.a r102 = new com.bytedance.android.monitorV2.event.a("fetchError");
        r102.c();
    L20:
        th = move-exception;
        r102.onEventTerminated(HybridEvent.TerminateType.CATCH_EXCEPTION);
        com.bytedance.android.monitorV2.util.f.b(th);
        return;
    L4:
        if (B() == true) goto L7;
        r102.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);     // Catch: Throwable -> L20
        return;
    L7:
        if (r100 != null) goto L11;
        r102.onEventTerminated(HybridEvent.TerminateType.PARAM_EXCEPTION);     // Catch: Throwable -> L20
        return;
    L11:
        if (this.f163362d.h(r100) == true) goto L15;
        r102.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);     // Catch: Throwable -> L20
        return;
    L15:
        if (Switches.webFetch.isEnabled() == true) goto L18;
        r102.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);     // Catch: Throwable -> L20
        return;
    L18:
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L20
        r101.a(r103);     // Catch: Throwable -> L20
        q(r100, r102, r103);     // Catch: Throwable -> L20
        O(r100, r102, r101.f501142d, r101.f501143e);     // Catch: Throwable -> L20
    }

    public final void o(WebView r100, jz2.h r101) {
        nz2.b.f("WebViewMonitorHelper", "handleJSBError: " + nz2.b.e(r100));
        com.bytedance.android.monitorV2.event.a r102 = new com.bytedance.android.monitorV2.event.a("jsbError");
        r102.c();
    L20:
        th = move-exception;
        r102.onEventTerminated(HybridEvent.TerminateType.CATCH_EXCEPTION);
        com.bytedance.android.monitorV2.util.f.b(th);
        return;
    L4:
        if (B() == true) goto L7;
        r102.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);     // Catch: Throwable -> L20
        return;
    L7:
        if (r100 != null) goto L11;
        r102.onEventTerminated(HybridEvent.TerminateType.PARAM_EXCEPTION);     // Catch: Throwable -> L20
        return;
    L11:
        if (this.f163362d.h(r100) == true) goto L15;
        r102.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);     // Catch: Throwable -> L20
        return;
    L15:
        if (Switches.webJSB.isEnabled() == true) goto L18;
        r102.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);     // Catch: Throwable -> L20
        return;
    L18:
        q(r100, r102, zz2.a.b(r101));     // Catch: Throwable -> L20
        O(r100, r102, r101.f501147a, r101.f501148b);     // Catch: Throwable -> L20
    }

    public final void p(WebView r100, jz2.i r101) {
        nz2.b.f("WebViewMonitorHelper", "handleJSBInfo: " + nz2.b.e(r100));
        com.bytedance.android.monitorV2.event.a r102 = new com.bytedance.android.monitorV2.event.a("jsbPerf");
        r102.c();
    L20:
        th = move-exception;
        r102.onEventTerminated(HybridEvent.TerminateType.CATCH_EXCEPTION);
        com.bytedance.android.monitorV2.util.f.b(th);
        return;
    L4:
        if (B() == true) goto L7;
        r102.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);     // Catch: Throwable -> L20
        return;
    L7:
        if (r100 != null) goto L11;
        r102.onEventTerminated(HybridEvent.TerminateType.PARAM_EXCEPTION);     // Catch: Throwable -> L20
        return;
    L11:
        if (this.f163362d.h(r100) == true) goto L15;
        r102.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);     // Catch: Throwable -> L20
        return;
    L15:
        if (Switches.webJSB.isEnabled() == true) goto L18;
        r102.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);     // Catch: Throwable -> L20
        return;
    L18:
        q(r100, r102, zz2.a.a(r101));     // Catch: Throwable -> L20
    }

    public final void s(WebView r100, RenderProcessGoneDetail r101) {
        com.bytedance.android.monitorV2.event.a r102 = new com.bytedance.android.monitorV2.event.a("nativeError");
        r102.c();
    L25:
        th = move-exception;
        r102.onEventTerminated(HybridEvent.TerminateType.CATCH_EXCEPTION);
        com.bytedance.android.monitorV2.util.f.b(th);
        return;
    L4:
        if (B() == true) goto L7;
        r102.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);     // Catch: Throwable -> L25
        return;
    L7:
        if (r100 == null) goto L23;
        if (r101 == null) goto L23;
        if (TextUtils.isEmpty(r100.getUrl()) == true) goto L23;
        if (this.f163362d.h(r100) == true) goto L16;
        r102.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);     // Catch: Throwable -> L25
        return;
    L16:
        this.f163362d.g(r100, r101);     // Catch: Throwable -> L25
        String r103 = "";
        if (Build.VERSION.SDK_INT >= 26) goto L19;
    L22:
        q(r100, r102, zz2.a.c(r100.getUrl(), null, -10000, r103, null));     // Catch: Throwable -> L25
        O(r100, r102, -10000, r103);     // Catch: Throwable -> L25
        return;
    L19:
        if (r101.didCrash() == false) goto L21;
        r103 = "cause by crash";
        goto L22
    L21:
        r103 = "cause by system";
    L23:
        r102.onEventTerminated(HybridEvent.TerminateType.PARAM_EXCEPTION);     // Catch: Throwable -> L25
    }

    @Override // sz2.c
    public final void d(View r100, int r101, Function1<? super JSONObject, Unit> r102) {
        if (r100 != null) goto L4;
        r102.invoke(new JSONObject());
        return;
    L4:
        if ((r100 instanceof WebView) == false) goto L26;
        n r103 = this.f163362d;
        WebView r104 = (WebView) r100;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "webView");
        Intrinsics.checkNotNullParameter(r102, "performanceCallback");
        WebViewDataManager r105 = r103.f(r104);
        Intrinsics.checkNotNullParameter(r102, "performanceCallback");
        NavigationDataManager r106 = r105.f163290f;
        if (r106 == null) goto L23;
        Intrinsics.checkNotNullParameter(r102, "performanceCallback");
        if (r101 != 0) goto L10;
    L21:
        r102.invoke(r106.b());
    L22:
        Unit r107 = Unit.INSTANCE;
    L24:
        if (r107 != null) goto L29;
        r102.invoke(new JSONObject());
        return;
    L29:
        return;
    L10:
        if (r101 != 1) goto L14;
        if (r106.f163283y <= 0) goto L14;
    L18:
        if (r106.f163281w.f483380c.get() == false) goto L21;
    L20:
        r106.f163284z = r101;
        r106.A = r102;
    L14:
        if (r101 != 2) goto L20;
        if (r106.f163282x <= 0) goto L20;
    L23:
        r107 = null;
        goto L24
    L26:
        r102.invoke(new JSONObject());
    }

    @Override // sz2.c
    public final void f(View r100, String r101, JSONObject r102) {
        if ((r100 instanceof WebView) == false) goto L17;
        WebView r103 = (WebView) r100;
        nz2.b.f("WebViewMonitorHelper", "handleNativeInfo: eventTYpe: ".concat(r101));
        com.bytedance.android.monitorV2.event.a r104 = new com.bytedance.android.monitorV2.event.a(r101);
        r104.c();
    L15:
        th = move-exception;
        r104.onEventTerminated(HybridEvent.TerminateType.CATCH_EXCEPTION);
        com.bytedance.android.monitorV2.util.f.b(th);
        return;
    L6:
        if (B() == true) goto L8;
        r104.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);     // Catch: Throwable -> L15
    L19:
        return;
    L8:
        if (r103 != null) goto L11;
        r104.onEventTerminated(HybridEvent.TerminateType.PARAM_EXCEPTION);     // Catch: Throwable -> L15
        goto L19
    L11:
        if (this.f163362d.h(r103) == true) goto L13;
        r104.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);     // Catch: Throwable -> L15
        goto L19
    L13:
        q(r103, r104, r102);     // Catch: Throwable -> L15
        goto L19
    L17:
        nz2.b.b("WebViewMonitorHelper", "handleNativeInfo: view not match WebView");
    }

    public final void i(WebView r100, String r101, String r102) {
        SLMonitorCompat.f41001a.getClass();
        SLMonitorCompat.a(r100, r101, r102);
        if (B() == true) goto L6;
        return;
    L6:
        if (this.f163362d.h(r100) == true) goto L8;
        return;
    L8:
        n r103 = this.f163362d;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        WebViewDataManager r104 = r103.f(r100);
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        NavigationDataManager r105 = r104.f163290f;
        if (r105 == null) goto L12;
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        r105.f163265g.addContext(r101, r102);
        return;
    }

    public final void q(WebView r100, com.bytedance.android.monitorV2.event.a r101, JSONObject r102) {
        n r103 = this.f163362d;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(r101, "event");
        WebViewDataManager r104 = r103.f(r100);
        Intrinsics.checkNotNullParameter(r101, "event");
        NavigationDataManager r105 = r104.f163290f;
        if (r105 == null) goto L5;
        r105.h(r101, r102);
        Unit r106 = Unit.INSTANCE;
    L6:
        if (r106 != null) goto L9;
        r101.onEventTerminated(HybridEvent.TerminateType.INVALID_CASE);
        return;
    L9:
        return;
    L5:
        r106 = null;
        goto L6
    }

    public final void u(WebView r100, WebResourceRequest r101, WebResourceError r102) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        nz2.b.f("WebViewMonitorHelper", "handleRequestError: " + nz2.b.e(r100) + ", errorCode: " + r102.getErrorCode());
    L6:
        if (D() == true) goto L8;
    L10:
        w(r100, r101, r102);
        return;
    L8:
        if (this.f163362d.i(r100) == false) goto L10;
    }

    public final void w(WebView r100, WebResourceRequest r101, WebResourceError r102) {
        com.bytedance.android.monitorV2.event.a r103 = new com.bytedance.android.monitorV2.event.a("nativeError");
        r103.c();
    L24:
        th = move-exception;
        r103.onEventTerminated(HybridEvent.TerminateType.CATCH_EXCEPTION);
        com.bytedance.android.monitorV2.util.f.b(th);
        return;
    L4:
        if (B() == true) goto L7;
        r103.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);     // Catch: Throwable -> L24
        return;
    L7:
        if (r100 == null) goto L22;
        if (r101 == null) goto L22;
        if (r102 == null) goto L22;
        if (Build.VERSION.SDK_INT < 23) goto L22;
        if (C(r101) == false) goto L18;
        r103.onEventTerminated(HybridEvent.TerminateType.INVALID_CASE);     // Catch: Throwable -> L24
        return;
    L18:
        if (this.f163362d.h(r100) == true) goto L21;
        r103.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);     // Catch: Throwable -> L24
        return;
    L21:
        q(r100, r103, zz2.a.c(r101.getUrl().toString(), Boolean.valueOf(r101.isForMainFrame()), Integer.valueOf(r102.getErrorCode()), r102.getDescription().toString(), 0));     // Catch: Throwable -> L24
        O(r100, r103, r102.getErrorCode(), r102.getDescription().toString());     // Catch: Throwable -> L24
        return;
    L22:
        r103.onEventTerminated(HybridEvent.TerminateType.PARAM_EXCEPTION);     // Catch: Throwable -> L24
    }

    public final void x(WebView r100, WebResourceRequest r101, WebResourceResponse r102) {
        nz2.b.f("WebViewMonitorHelper", "handleRequestHttpError: " + nz2.b.e(r100) + ", request: " + r101 + ", statusCode: " + r102.getStatusCode());
        if (D() == true) goto L5;
    L7:
        y(r100, r101, r102);
        return;
    L5:
        if (this.f163362d.i(r100) == false) goto L7;
    }

    public final void y(WebView r100, WebResourceRequest r101, WebResourceResponse r102) {
        com.bytedance.android.monitorV2.event.a r103 = new com.bytedance.android.monitorV2.event.a("nativeError");
        r103.c();
    L21:
        th = move-exception;
        r103.onEventTerminated(HybridEvent.TerminateType.CATCH_EXCEPTION);
        com.bytedance.android.monitorV2.util.f.b(th);
        return;
    L4:
        if (B() == true) goto L7;
        r103.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);     // Catch: Throwable -> L21
        return;
    L7:
        if (r100 == null) goto L19;
        if (r101 == null) goto L19;
        if (r102 == null) goto L19;
        if (C(r101) == false) goto L15;
        r103.onEventTerminated(HybridEvent.TerminateType.INVALID_CASE);     // Catch: Throwable -> L21
        return;
    L15:
        if (this.f163362d.h(r100) == true) goto L18;
        r103.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);     // Catch: Throwable -> L21
        return;
    L18:
        q(r100, r103, zz2.a.c(r101.getUrl().toString(), Boolean.valueOf(r101.isForMainFrame()), 0, r102.getReasonPhrase(), Integer.valueOf(r102.getStatusCode())));     // Catch: Throwable -> L21
        O(r100, r103, r102.getStatusCode(), r102.getReasonPhrase());     // Catch: Throwable -> L21
        return;
    L19:
        r103.onEventTerminated(HybridEvent.TerminateType.PARAM_EXCEPTION);     // Catch: Throwable -> L21
    }

    public final void O(WebView r100, com.bytedance.android.monitorV2.event.a r101, int r102, String r103) {
        n r104 = this.f163362d;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(r101, "event");
        WebViewDataManager r105 = r104.f(r100);
        Intrinsics.checkNotNullParameter(r101, "event");
        NavigationDataManager r106 = r105.f163290f;
        if (r106 == null) goto L9;
        Intrinsics.checkNotNullParameter(r101, "event");
        jz2.e r107 = r106.f163268j;
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        r107.b(r101, r102, r103);
        return;
    }

    @Override // sz2.c
    public final void e(View r100, String r101, jz2.a r102, sz2.b r103) {
        com.bytedance.android.monitorV2.event.a r104 = new com.bytedance.android.monitorV2.event.a("containerError");
        r104.c();
    L14:
        th = move-exception;
        r104.onEventTerminated(HybridEvent.TerminateType.CATCH_EXCEPTION);
        com.bytedance.android.monitorV2.util.f.b(th);
        return;
    L4:
        if (B() == true) goto L8;
        r104.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);     // Catch: Throwable -> L14
        return;
    L8:
        if (r100 != null) goto L10;
        r104.f163008h = r102;     // Catch: Throwable -> L14
        r104.f163020n = r103.a();     // Catch: Throwable -> L14
        WebNativeCommon r105 = new WebNativeCommon();     // Catch: Throwable -> L14
        r105.virtualAid = r103.f543914c;     // Catch: Throwable -> L14
        r105.containerType = "web";     // Catch: Throwable -> L14
        g.a(r101, null, r105);     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r105, "<set-?>");     // Catch: Throwable -> L14
        r104.f163006f = r105;     // Catch: Throwable -> L14
        r104.f163019m = new jz2.c();     // Catch: Throwable -> L14
        TypedDataDispatcher r106 = DataReporter.f162979a;     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r104, "commonEvent");     // Catch: Throwable -> L14
        DataReporter.g(r104, null, Boolean.TRUE);     // Catch: Throwable -> L14
        return;
    L10:
        if ((r100 instanceof WebView) == false) goto L18;
        r104.f163020n = r103.a();     // Catch: Throwable -> L14
        q((WebView) r100, r104, null);     // Catch: Throwable -> L14
        return;
    }

    public final void r(WebView r100, String r101, JSONObject r102, JSONObject r103) {
        jz2.d.a r104 = new jz2.d.a("pia_" + r101);     // Catch: Throwable -> L17
        r104.f501116d = r102;     // Catch: Throwable -> L17
        r104.f501117e = r103;     // Catch: Throwable -> L17
        r104.f501118f = null;     // Catch: Throwable -> L17
        r104.f501120h = null;     // Catch: Throwable -> L17
        r104.b(3);     // Catch: Throwable -> L17
        jz2.d r105 = r104.a();     // Catch: Throwable -> L17
        com.bytedance.android.monitorV2.event.d r106 = new com.bytedance.android.monitorV2.event.d(r105);     // Catch: Throwable -> L17
        SLMonitorCompat.f41001a.getClass();     // Catch: Throwable -> L17
        SLMonitorCompat.j(r100, r105);     // Catch: Throwable -> L17
        if (B() == true) goto L6;
    L9:
        boolean r107 = true;
    L10:
        r106.i(r107, HybridEvent.TerminateType.SWITCH_OFF);     // Catch: Throwable -> L17
        if (r107 == false) goto L13;
        return;
    L13:
        if (r100 != null) goto L15;
        TypedDataDispatcher r108 = DataReporter.f162979a;     // Catch: Throwable -> L17
        DataReporter.h(r106, Boolean.TRUE);     // Catch: Throwable -> L17
        return;
    L15:
        this.f163362d.d(r100, r106);     // Catch: Throwable -> L17
        return;
    L6:
        if (this.f163362d.h(r100) == false) goto L9;
        r107 = false;
    L17:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);
    }

    public final void t(WebView r100, int r101, String r102, String r103) {
        nz2.b.f("WebViewMonitorHelper", "handleRequestError: " + nz2.b.e(r100) + ", errorCode: " + r101);
        if (D() == true) goto L5;
    L7:
        v(r100, r101, r102, r103);
        return;
    L5:
        if (this.f163362d.i(r100) == false) goto L7;
    }

    public final void v(WebView r100, int r101, String r102, String r103) {
        com.bytedance.android.monitorV2.event.a r104 = new com.bytedance.android.monitorV2.event.a("nativeError");
        r104.c();
    L20:
        th = move-exception;
        r104.onEventTerminated(HybridEvent.TerminateType.CATCH_EXCEPTION);
        com.bytedance.android.monitorV2.util.f.b(th);
        return;
    L4:
        if (B() == true) goto L7;
        r104.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);     // Catch: Throwable -> L20
        return;
    L7:
        if (r100 == null) goto L18;
        if (r102 == null) goto L18;
        if (r103 == null) goto L18;
        if (Build.VERSION.SDK_INT >= 23) goto L18;
        if (this.f163362d.h(r100) == true) goto L17;
        r104.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);     // Catch: Throwable -> L20
        return;
    L17:
        q(r100, r104, zz2.a.c(r103, Boolean.TRUE, Integer.valueOf(r101), r102, 0));     // Catch: Throwable -> L20
        O(r100, r104, r101, r102);     // Catch: Throwable -> L20
        return;
    L18:
        r104.onEventTerminated(HybridEvent.TerminateType.PARAM_EXCEPTION);     // Catch: Throwable -> L20
    }

    public final void z(String r100, String r101, String r102, Map<String, Object> r110) {
        n r103 = this.f163362d;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "eventType");
        Intrinsics.checkNotNullParameter(r101, "engineHash");
        Intrinsics.checkNotNullParameter(r102, "url");
        WebViewDataManager r104 = r103.f163367d.get(r101);
        if (r104 == null) goto L86;
        Intrinsics.checkNotNullParameter(r100, "eventType");
        Intrinsics.checkNotNullParameter(r102, "url");
        p r105 = (p) r104.f163304t.getValue();
        NavigationDataManager r106 = r104.f163290f;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r100, "event");
        Boolean r107 = null;
        if (Intrinsics.areEqual(r100, "anniex_ssp_pv") == false) goto L26;
        if (r102 == null) goto L87;
        r105.b().add(r102);
        wz2.a r108 = new wz2.a();     // Catch: Exception -> L23
        r105.a(r108, r102, r106);     // Catch: Exception -> L23
        if (r110 == null) goto L21;
        Object r109 = r110.get("biz");     // Catch: Exception -> L23
        if ((r109 instanceof String) == false) goto L13;
        String r111 = (String) r109;     // Catch: Exception -> L23
    L14:
        if (r111 == null) goto L16;
        r108.f561913g = r111;     // Catch: Exception -> L23
    L16:
        Object r112 = r110.get("is_redirect");     // Catch: Exception -> L23
        if ((r112 instanceof Boolean) == false) goto L19;
        r107 = (Boolean) r112;     // Catch: Exception -> L23
    L19:
        if (r107 == null) goto L21;
        r107.booleanValue();     // Catch: Exception -> L23
        goto L21
    L13:
        r111 = null;
    L21:
        r108.f561907a = r105.f163376b;     // Catch: Exception -> L23
        Method r113 = gz2.c.f483375a;     // Catch: Exception -> L23
        gz2.c.f("anniex_ssp_pv", r108.toJsonObject());     // Catch: Exception -> L23
        return;
    L23:
        e = move-exception;
        e.printStackTrace();
        return;
    L87:
        return;
    L26:
        if (Intrinsics.areEqual(r100, "anniex_ssp_res_loader_info") == false) goto L89;
        if (r102 == null) goto L90;
        wz2.a r114 = new wz2.a();     // Catch: Exception -> L79
        r105.a(r114, r102, r106);     // Catch: Exception -> L79
        if (r110 == null) goto L77;
        Object r115 = r110.get("res_format_src");     // Catch: Exception -> L79
        if ((r115 instanceof String) == false) goto L33;
        String r116 = (String) r115;     // Catch: Exception -> L79
    L34:
        if (r116 == null) goto L36;
        r114.f561914h = r116;     // Catch: Exception -> L79
    L36:
        Object r117 = r110.get("res_full_src");     // Catch: Exception -> L79
        if ((r117 instanceof String) == false) goto L39;
        String r118 = (String) r117;     // Catch: Exception -> L79
    L40:
        if (r118 == null) goto L42;
        r114.f561915i = r118;     // Catch: Exception -> L79
    L42:
        Object r119 = r110.get("res_from");     // Catch: Exception -> L79
        if ((r119 instanceof String) == false) goto L45;
        String r120 = (String) r119;     // Catch: Exception -> L79
    L46:
        if (r120 == null) goto L48;
        r114.f561916j = r120;     // Catch: Exception -> L79
    L48:
        Object r121 = r110.get("res_size");     // Catch: Exception -> L79
        if ((r121 instanceof Number) == false) goto L51;
        Number r122 = (Number) r121;     // Catch: Exception -> L79
    L52:
        if (r122 == null) goto L54;
        r114.f561917k = Integer.valueOf(r122.intValue());     // Catch: Exception -> L79
    L54:
        Object r123 = r110.get("res_type");     // Catch: Exception -> L79
        if ((r123 instanceof String) == false) goto L57;
        String r124 = (String) r123;     // Catch: Exception -> L79
    L58:
        if (r124 == null) goto L60;
        r114.f561918l = r124;     // Catch: Exception -> L79
    L60:
        Object r125 = r110.get("request_method");     // Catch: Exception -> L79
        if ((r125 instanceof String) == false) goto L63;
        String r126 = (String) r125;     // Catch: Exception -> L79
    L64:
        if (r126 == null) goto L66;
        r114.f561919m = r126;     // Catch: Exception -> L79
    L66:
        Object r127 = r110.get("biz");     // Catch: Exception -> L79
        if ((r127 instanceof String) == false) goto L69;
        String r128 = (String) r127;     // Catch: Exception -> L79
    L70:
        if (r128 == null) goto L72;
        r114.f561913g = r128;     // Catch: Exception -> L79
    L72:
        Object r129 = r110.get("is_redirect");     // Catch: Exception -> L79
        if ((r129 instanceof Boolean) == false) goto L75;
        r107 = (Boolean) r129;     // Catch: Exception -> L79
    L75:
        if (r107 == null) goto L77;
        r107.booleanValue();     // Catch: Exception -> L79
        goto L77
    L69:
        r128 = null;
        goto L70
    L63:
        r126 = null;
        goto L64
    L57:
        r124 = null;
        goto L58
    L51:
        r122 = null;
        goto L52
    L45:
        r120 = null;
        goto L46
    L39:
        r118 = null;
        goto L40
    L33:
        r116 = null;
    L77:
        r114.f561907a = r105.f163377c;     // Catch: Exception -> L79
        Method r130 = gz2.c.f483375a;     // Catch: Exception -> L79
        gz2.c.f("anniex_ssp_res_loader_info", r114.toJsonObject());     // Catch: Exception -> L79
        return;
    L79:
        e = move-exception;
        e.printStackTrace();
        return;
    L90:
        return;
    L89:
        return;
    }
}
