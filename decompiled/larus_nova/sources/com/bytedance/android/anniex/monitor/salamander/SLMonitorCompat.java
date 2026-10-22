package com.bytedance.android.anniex.monitor.salamander;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.monitorV2.webview.ttweb.TTUtils;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.salamander.anniex.AccessLayerStringField;
import com.bytedance.salamander.anniex.SLAnnieXMonitor;
import com.bytedance.salamander.anniex.SLContainerErrorCode;
import com.bytedance.salamander.anniex.SLContainerTiming;
import com.bytedance.salamander.anniex.SLEndToEndErrorCode;
import com.bytedance.salamander.anniex.SLEndToEndStage;
import com.bytedance.salamander.anniex.SLEndToEndStatus;
import com.bytedance.salamander.anniex.i1;
import com.bytedance.salamander.anniex.i5;
import com.bytedance.salamander.anniex.i7;
import com.bytedance.salamander.anniex.k7;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.devtoolwrapper.ScreenshotMode;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxView;
import com.ss.android.lark.camera_export.CameraParam;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class SLMonitorCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SLMonitorCompat f41001a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f41002b;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/anniex/monitor/salamander/SLMonitorCompat$ContainerType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Lynx", "Web", "Unknown", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final enum ContainerType extends Enum<ContainerType> {
        public static final ContainerType Lynx = null;
        public static final ContainerType Unknown = null;
        public static final ContainerType Web = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ContainerType[] f41003a = null;
        private final String value;

        public static ContainerType valueOf(String r100) {
            return (ContainerType) r27.a.a(ContainerType.class, r100);
        }

        public static ContainerType[] values() {
            return (ContainerType[]) f41003a.clone();
        }

        static {
            ContainerType r100 = new ContainerType("Lynx", 0, "lynx");
            Lynx = r100;
            ContainerType r101 = new ContainerType("Web", 1, "webview");
            Web = r101;
            ContainerType r102 = new ContainerType("Unknown", 2, "unknown");
            Unknown = r102;
            f41003a = new ContainerType[]{r100, r101, r102};
        }

        public final String getValue() {
            return this.value;
        }

        public ContainerType(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/anniex/monitor/salamander/SLMonitorCompat$NativeErrorScene;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "WebError", "WebProcessTerminate", "LynxError", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final enum NativeErrorScene extends Enum<NativeErrorScene> {
        public static final NativeErrorScene LynxError = null;
        public static final NativeErrorScene WebError = null;
        public static final NativeErrorScene WebProcessTerminate = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ NativeErrorScene[] f41004a = null;
        private final String value;

        public static NativeErrorScene valueOf(String r100) {
            return (NativeErrorScene) r27.a.a(NativeErrorScene.class, r100);
        }

        public static NativeErrorScene[] values() {
            return (NativeErrorScene[]) f41004a.clone();
        }

        static {
            NativeErrorScene r100 = new NativeErrorScene("WebError", 0, "web_error");
            WebError = r100;
            NativeErrorScene r101 = new NativeErrorScene("WebProcessTerminate", 1, "web_process_terminate");
            WebProcessTerminate = r101;
            NativeErrorScene r102 = new NativeErrorScene("LynxError", 2, "lynx_error");
            LynxError = r102;
            f41004a = new NativeErrorScene[]{r100, r101, r102};
        }

        public final String getValue() {
            return this.value;
        }

        public NativeErrorScene(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/anniex/monitor/salamander/SLMonitorCompat$ViewType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Card", "Popup", "Page", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final enum ViewType extends Enum<ViewType> {
        public static final ViewType Card = null;
        public static final ViewType Page = null;
        public static final ViewType Popup = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ViewType[] f41005a = null;
        private final String value;

        public static ViewType valueOf(String r100) {
            return (ViewType) r27.a.a(ViewType.class, r100);
        }

        public static ViewType[] values() {
            return (ViewType[]) f41005a.clone();
        }

        static {
            ViewType r100 = new ViewType("Card", 0, BrowserDependency.UrlClickType.CARD);
            Card = r100;
            ViewType r101 = new ViewType("Popup", 1, "popup");
            Popup = r101;
            ViewType r102 = new ViewType("Page", 2, "page");
            Page = r102;
            f41005a = new ViewType[]{r100, r101, r102};
        }

        public final String getValue() {
            return this.value;
        }

        public ViewType(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebView f41006a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SLAnnieXMonitor f41007b;

        public a(WebView r100, SLAnnieXMonitor r101) {
            this.f41006a = r100;
            this.f41007b = r101;
        }

        public final void a() {
            SLMonitorCompat r100 = SLMonitorCompat.f41001a;
            WebView r101 = this.f41006a;
            r100.getClass();
            String r102 = "";
            String r103 = r101.getSettings().getUserAgentString();     // Catch: Throwable -> L15
            if (r103 != null) goto L6;
            r103 = "";
        L6:
            int r104 = StringsKt.indexOf$default(r103, "Chrome/", 0, false, 6, null);     // Catch: Throwable -> L15
            if (r104 == (-1)) goto L9;
            r104 = r104 + 7;     // Catch: Throwable -> L15
        L9:
            List r105 = StringsKt.split$default(r103.substring(r104), new String[]{" "}, false, 0, 6, null);     // Catch: Throwable -> L15
            if ((!r105.isEmpty()) == false) goto L13;
            r102 = (String) ListProtector.get(r105, 0);     // Catch: Throwable -> L15
        L13:
            String r106 = com.bytedance.android.anniex.monitor.salamander.a.f41010a;
            Intrinsics.checkNotNullParameter(r102, "<set-?>");
            com.bytedance.android.anniex.monitor.salamander.a.f41012c = r102;
            this.f41007b.h(AccessLayerStringField.WebEngineVersion, r102);
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

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebView f41008a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SLAnnieXMonitor f41009b;

        public b(WebView r100, SLAnnieXMonitor r101) {
            this.f41008a = r100;
            this.f41009b = r101;
        }

        public final void a() {
            Lazy r100 = TTUtils.f163378a;
            WebView r101 = this.f41008a;
            boolean r102 = false;
            Method r103 = (Method) TTUtils.f163380c.getValue();     // Catch: Exception -> L7
            if (r103 == null) goto L9;
            Object r104 = r103.invoke(null, new Object[]{r101});     // Catch: Exception -> L7
            Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.Boolean");     // Catch: Exception -> L7
            r102 = ((Boolean) r104).booleanValue();     // Catch: Exception -> L7
        L9:
            if (r102 == false) goto L11;
            String r105 = "ttwebview";
        L12:
            String r106 = com.bytedance.android.anniex.monitor.salamander.a.f41010a;
            Intrinsics.checkNotNullParameter(r105, "<set-?>");
            com.bytedance.android.anniex.monitor.salamander.a.f41011b = r105;
            this.f41009b.h(AccessLayerStringField.WebViewType, r105);
            return;
        L11:
            r105 = CameraParam.TYPE_SYSTEM_CAMERA;
        L7:
            e = move-exception;
            com.bytedance.android.monitorV2.util.f.b(e);
            goto L9
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

    static {
        f41001a = new SLMonitorCompat();
    }

    public SLMonitorCompat() {
    }

    private final Activity getActivity(Context r100) {
    L3:
        if (r100 == null) goto L11;
        if ((r100 instanceof Activity) == true) goto L7;
        if ((r100 instanceof ContextWrapper) == false) goto L11;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L3
    L7:
        return (Activity) r100;
    L11:
        return null;
    }

    public static void k(jz2.d r100) {
        Intrinsics.checkNotNullParameter(r100, "customInfo");
        if (f41002b == true) goto L5;
        return;
    L5:
        String r101 = r100.f501102b;
        if (r101 != null) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r101, "") == true) goto L13;
        int r102 = i5.f268119a;
        String r103 = r100.f501103c;
        int r104 = r100.f501111k;
        String r105 = r100.f501102b;
        JSONObject r106 = r100.f501104d;
        JSONObject r107 = r100.f501105e;
        JSONObject r108 = r100.f501106f;
        String r109 = r100.f501101a;
        Intrinsics.checkNotNullParameter(r103, "eventName");
        Intrinsics.checkNotNullParameter(r105, "bid");
        i1.a(r103, r105, Integer.valueOf(r104), r106, r107, r108, r109);
        return;
    }

    public static String m(Uri r100) {
        String r101 = r100.getScheme();
        boolean r102 = true;
        if (r101 == null) goto L30;
        int r103 = r101.hashCode();
        if (r103 == (-1772600516)) goto L27;
        if (r103 == 3213448) goto L15;
        if (r103 != 99617003) goto L30;
        if (r101.equals("https") == false) goto L30;
    L17:
        String r104 = r100.getPath();
        if (r104 != null) goto L20;
    L22:
        r102 = false;
    L23:
        if (r102 == false) goto L49;
        return ContainerType.Lynx.getValue();
    L49:
        return ContainerType.Web.getValue();
    L20:
        if (StringsKt.endsWith$default(r104, ".js", false, 2, null) != true) goto L22;
    L15:
        if (r101.equals("http") == true) goto L17;
    L27:
        if (r101.equals(ScreenshotMode.SCREEN_SHOT_MODE_LYNX_VIEW) == false) goto L30;
        return ContainerType.Lynx.getValue();
    L30:
        String r105 = r100.getHost();
        if (r105 != null) goto L33;
    L35:
        boolean r106 = false;
    L36:
        if (r106 == true) goto L51;
        String r107 = r100.getHost();
        if (r107 != null) goto L41;
    L43:
        r102 = false;
    L44:
        if (r102 == false) goto L47;
        return ContainerType.Web.getValue();
    L47:
        return ContainerType.Lynx.getValue();
    L41:
        if (StringsKt.contains$default(r107, "web", false, 2, null) != true) goto L43;
    L51:
        return ContainerType.Lynx.getValue();
    L33:
        if (StringsKt.contains$default(r105, "lynx", false, 2, null) != true) goto L35;
        r106 = true;
        goto L36
    }

    public final String n(View r100) {
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        Activity r103 = getActivity(r100.getContext());     // Catch: Throwable -> L9
        if (r103 == null) goto L6;
        String r104 = r103.getClass().getName();     // Catch: Throwable -> L9
    L7:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r105) == true) goto L15;
        r101 = r105;
    L15:
        String r106 = (String) r101;
        if (r106 != null) goto L21;
        return "";
    L21:
        return r106;
    L6:
        r104 = null;
    L9:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public static void c(String r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "block");
        if (f41002b == true) goto L5;
        return;
    L5:
        r101.invoke(c.f41013a.a(r100));
    }

    public static void d(String r100, SLEndToEndStage r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "stage");
        if (f41002b == true) goto L5;
        return;
    L5:
        c.f41013a.a(r100).l(r101);
    }

    public static void f(String r100, LynxView r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "lynxView");
        if (f41002b == true) goto L5;
        return;
    L5:
        SLAnnieXMonitor r102 = c.f41013a.a(r100);
        r102.h(AccessLayerStringField.ContainerType, ContainerType.Lynx.getValue());
        if (Intrinsics.areEqual(com.bytedance.android.anniex.monitor.salamander.a.f41010a, "unknown") == false) goto L8;
        String r103 = LynxEnv.inst().getLynxVersion();
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        com.bytedance.android.anniex.monitor.salamander.a.f41010a = r103;
    L8:
        r102.h(AccessLayerStringField.LynxVersion, com.bytedance.android.anniex.monitor.salamander.a.f41010a);
        r102.h(AccessLayerStringField.NativePage, f41001a.n(r101));
    }

    public static void i(String r100, WebView r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "webView");
        if (f41002b == true) goto L5;
        return;
    L5:
        SLAnnieXMonitor r102 = c.f41013a.a(r100);
        r102.h(AccessLayerStringField.ContainerType, ContainerType.Web.getValue());
        if (Intrinsics.areEqual(com.bytedance.android.anniex.monitor.salamander.a.f41012c, "unknown") == false) goto L8;
    L11:
        com.bytedance.android.monitorV2.executor.a.c(new a(r101, r102));
    L13:
        if (Intrinsics.areEqual(com.bytedance.android.anniex.monitor.salamander.a.f41011b, "unknown") == false) goto L15;
        com.bytedance.android.monitorV2.executor.a.c(new b(r101, r102));
    L16:
        r102.h(AccessLayerStringField.NativePage, f41001a.n(r101));
        return;
    L15:
        r102.h(AccessLayerStringField.WebViewType, com.bytedance.android.anniex.monitor.salamander.a.f41011b);
        goto L16
    L8:
        if (StringsKt.isBlank(com.bytedance.android.anniex.monitor.salamander.a.f41012c) == true) goto L11;
        r102.h(AccessLayerStringField.WebEngineVersion, com.bytedance.android.anniex.monitor.salamander.a.f41012c);
        goto L13
    }

    public static void j(View r100, jz2.d r101) {
        Intrinsics.checkNotNullParameter(r101, "customInfo");
        if (f41002b == true) goto L6;
        return;
    L6:
        if (r101.f501103c != null) goto L8;
        return;
    L8:
        String r102 = r101.f501109i;
        if (r102 == null) goto L12;
    L18:
        if (r102 == null) goto L21;
        l(r102, r101);
        return;
    L21:
        if (r101.f501102b == null) goto L25;
        k(r101);
        return;
    L25:
        return;
    L12:
        if ((r100 instanceof WebView) == false) goto L15;
        sz2.a r103 = sz2.a.f543906a;
        r102 = (String) CollectionsKt.first(sz2.a.d(r100));
        goto L18
    L15:
        if ((r100 instanceof LynxView) == false) goto L17;
        sz2.a r104 = sz2.a.f543906a;
        r102 = (String) CollectionsKt.first(sz2.a.d(r100));
        goto L18
    L17:
        r102 = null;
        goto L18
    }

    public static void l(String r100, jz2.d r110) {
        Intrinsics.checkNotNullParameter(r110, "customInfo");
        if (f41002b == true) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        int r101 = i5.f268119a;
        String r102 = r110.f501103c;
        int r103 = r110.f501111k;
        JSONObject r104 = r110.f501104d;
        JSONObject r105 = r110.f501105e;
        JSONObject r106 = r110.f501106f;
        String r107 = r110.f501101a;
        String r108 = r110.f501102b;
        Intrinsics.checkNotNullParameter(r102, "eventName");
        Intrinsics.checkNotNullParameter(r100, "containerId");
        i1.b(r102, r100, Integer.valueOf(r103), r104, r105, r106, r107, r108);
    }

    public static void o(String r100, i7 r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "eventInfo");
        if (f41002b == true) goto L5;
        return;
    L5:
        c.f41013a.a(r100).D(r101);
    }

    public static void r(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "schema");
        if (f41002b == true) goto L5;
        return;
    L5:
        Uri r102 = UriProtector.parse(r101);
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r102, "schema");
        if (f41002b == false) goto L17;
        String r103 = com.bytedance.android.anniex.utils.c.getType(r102);
        if (Intrinsics.areEqual(r103, "_popup") == false) goto L12;
        String r104 = ViewType.Popup.getValue();
    L15:
        q(r100, r102, m(r102), r104);
        return;
    L12:
        if (Intrinsics.areEqual(r103, "_page") == false) goto L14;
        r104 = ViewType.Page.getValue();
        goto L15
    L14:
        r104 = ViewType.Card.getValue();
        goto L15
    }

    public static void a(View r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        if (f41002b == true) goto L6;
        return;
    L6:
        if ((r100 instanceof WebView) == false) goto L9;
        sz2.a r103 = sz2.a.f543906a;
        String r104 = (String) CollectionsKt.firstOrNull(sz2.a.d(r100));
    L12:
        if (r104 == null) goto L15;
        SLMonitorCompat r105 = f41001a;
        String r106 = r102.toString();
        r105.getClass();
        b(r104, r101, r106);
        return;
    L15:
        return;
    L9:
        if ((r100 instanceof LynxView) == false) goto L11;
        sz2.a r107 = sz2.a.f543906a;
        r104 = (String) CollectionsKt.firstOrNull(sz2.a.d(r100));
        goto L12
    L11:
        r104 = null;
        goto L12
    }

    public static void b(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        if (f41002b == true) goto L5;
        return;
    L5:
        c.f41013a.a(r100).f(r101, r102);
    }

    public static void g(String r100, SLContainerTiming r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "key");
        if (f41002b == true) goto L5;
        return;
    L5:
        c.f41013a.a(r100).p(r101, r102);
    }

    public static void h(String r100, long r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r102, "resFrom");
        if (f41002b == true) goto L5;
        return;
    L5:
        SLAnnieXMonitor r103 = c.f41013a.a(r100);
        r103.h(AccessLayerStringField.GeckoId, String.valueOf(r101));
        String r104 = "unknown";
        switch(r102.hashCode()) {
            case -1994413639: goto L35;
            case -1848962670: goto L31;
            case -1785310379: goto L27;
            case -1548612125: goto L22;
            case -318613945: goto L20;
            case -284840886: goto L18;
            case 98349: goto L15;
            case 98230121: goto L12;
            case 230943795: goto L9;
            default: goto L38;
        };
    L12:
        String r105 = "gecko";
        if (r102.equals("gecko") == false) goto L38;
    L25:
        r104 = r105;
        goto L38
    L15:
        r105 = "cdn";
        if (r102.equals("cdn") == true) goto L25;
    L18:
        r102.equals("unknown");
        goto L38
    L22:
        r105 = OperationName.OPERATION_OFFLINE_AVAILABLE;
        if (r102.equals(OperationName.OPERATION_OFFLINE_AVAILABLE) == true) goto L25;
    L38:
        r103.h(AccessLayerStringField.TemplateResType, r104);
        return;
    L9:
        if (r102.equals("buildIn") == false) goto L38;
        r104 = "builtin";
        goto L38
    L20:
        if (r102.equals("externalTemplateBundle") == false) goto L38;
    L37:
        r104 = "template_bundle";
        goto L38
    L27:
        if (r102.equals("cdnCache") == false) goto L38;
        r104 = "cdn_cache";
        goto L38
    L31:
        if (r102.equals("geckoUpdate") == false) goto L38;
        r104 = "gecko_update";
        goto L38
    L35:
        if (r102.equals("internalTemplateBundle") == true) goto L37;
        goto L37
    }

    public static void p(String r100, Uri r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "schema");
        Intrinsics.checkNotNullParameter(r102, "viewType");
        if (f41002b == true) goto L5;
        return;
    L5:
        q(r100, r101, m(r101), r102);
    }

    public static void q(String r100, final Uri r101, final String r102, final String r103) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "schema");
        Intrinsics.checkNotNullParameter(r102, "containerType");
        if (f41002b == true) goto L5;
        return;
    L5:
        Function0<Map<AccessLayerStringField, String>> r104 = new SLMonitorCompat$reportPV$fieldsMaker$1(r101, r102, r103);
        c.f41013a.a(r100).E(new k7(), r104);
    }

    public static void e(String r100, SLEndToEndStage r101, SLEndToEndStatus r102, SLEndToEndErrorCode r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "stage");
        Intrinsics.checkNotNullParameter(r102, "status");
        if (f41002b == true) goto L5;
        return;
    L5:
        if (r103 == null) goto L15;
        if (r104 == null) goto L15;
        if (r101 != SLEndToEndStage.LoadContainerFail) goto L14;
        SLAnnieXMonitor r105 = c.f41013a.a(r100);
        if (StringsKt.contains$default(r104, "uri parse failed", false, 2, null) == false) goto L12;
        SLContainerErrorCode r106 = SLContainerErrorCode.Schema;
    L13:
        r105.j(r104, r106);
        return;
    L12:
        r106 = SLContainerErrorCode.Common;
        goto L13
    L14:
        c.f41013a.a(r100).k(r101, r102, r103, r104);
        return;
    L15:
        c.f41013a.a(r100).i(r101, r102);
    }

    public static void s(SLMonitorCompat r100, String r101, String r102, String r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = null;
    L8:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "sessionId");
        if (f41002b == false) goto L13;
        c.f41013a.a(r101).G(new k7(), r103, r102);
        return;
    }
}
