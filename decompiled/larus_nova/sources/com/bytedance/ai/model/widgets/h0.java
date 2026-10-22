package com.bytedance.ai.model.widgets;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.viewmodel.RenderStateVM;
import com.bytedance.ai.monitor.AppletErrorCode;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.awemeopen.servicesapi.network.ByteNetEnvHeaderName;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.nova.R;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import m5.i1;

/* JADX INFO: loaded from: classes43.dex */
public final class h0 implements ix7.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebEngineAssem f37047a;

    @Override // ix7.e
    public final boolean g(WebView r100, ValueCallback r101) {
        return false;
    }

    @Override // ix7.e
    public final void f() {
        WebEngineAssem r100 = this.f37047a;
        int r101 = WebEngineAssem.C;
        RenderStateVM r102 = r100.u();
        if (r102 == null) goto L6;
        r102.updateState(new i5.b());
        return;
    }

    public h0(WebEngineAssem r100) {
        this.f37047a = r100;
    }

    @Override // ix7.e
    public final void b(SslError r100) {
        com.bytedance.ai.utils.g r101 = com.bytedance.ai.utils.g.f37637a;
        StringBuilder r102 = new StringBuilder("onReceivedSslError ");
        r102.append(r100);
        r102.append(" url:");
        WebEngineAssem r103 = this.f37047a;
        int r104 = WebEngineAssem.C;
        k2.b r105 = r103.t();
        if (r105 == null) goto L5;
        String r106 = r105.f501423b;
    L6:
        r102.append(r106);
        r101.w("WebViewAssem", r102.toString());
        return;
    L5:
        r106 = null;
        goto L6
    }

    @Override // ix7.e
    public final lx7.b c(lx7.b r110) {
        Intrinsics.checkNotNullParameter(r110, "before");
        WebEngineAssem r100 = this.f37047a;
        String r101 = r110.f511231a;
        Map<String, String> r102 = r110.f511232b;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.String>");
        Map r103 = TypeIntrinsics.asMutableMap(r102);
        int r104 = WebEngineAssem.C;
        r100.getClass();
        String r105 = (String) r103.get(AppConstants.HTTP_H_REFERER);
        boolean r106 = false;
        if (r100.v(r101) == false) goto L5;
    L8:
        boolean r107 = true;
    L9:
        String r108 = null;
        String r109 = "";
        if (r107 == false) goto L26;
        Uri.Builder r111 = UriProtector.parse(r101).buildUpon().appendQueryParameter("is_inapp", "1");
        k2.b r112 = r100.t();
        if (r112 != null) goto L14;
    L16:
        boolean r113 = false;
    L17:
        if (r113 == false) goto L21;
        k2.b r114 = r100.t();
        if (r114 == null) goto L24;
        String r115 = r114.f501428g;
    L25:
        Uri r116 = r111.appendQueryParameter("api_host", r115).build();
        com.bytedance.ai.utils.g.f37637a.i("WebViewAssem", "addCommonQuery: called, result uri = " + r116);
        r101 = r116.toString();
        Intrinsics.checkNotNull(r101);
    L28:
        WebEngineAssem r117 = this.f37047a;
        String r118 = r110.f511231a;
        Map<String, String> r119 = r110.f511232b;
        Intrinsics.checkNotNull(r119, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.String>");
        Map r120 = TypeIntrinsics.asMutableMap(r119);
        r117.getClass();
        String r121 = (String) r120.get(AppConstants.HTTP_H_REFERER);
        if (r117.v(r118) == false) goto L31;
    L34:
        boolean r122 = true;
    L35:
        if (r122 == false) goto L91;
        com.bytedance.ai.utils.g.f37637a.i("WebViewAssem", "addCommonHeaders: called, in whitelist");
        k2.b r123 = r117.t();
        if (r123 == null) goto L44;
        Callable<String> r124 = r123.f501430i;
        if (r124 == null) goto L44;
        String r125 = r124.call();
        if (r125 == null) goto L44;
        r109 = r125;
    L44:
        r120.put("x-tt-token", r109);
        k2.b r126 = r117.t();
        if (r126 != null) goto L47;
    L49:
        boolean r127 = false;
    L51:
        if (r127 == false) goto L68;
        r120.put(ByteNetEnvHeaderName.BOE, "1");
        k2.b r128 = r117.t();
        if (r128 == null) goto L62;
        String r129 = r128.f501426e;
        if (r129 == null) goto L62;
        if (r129.length() <= 0) goto L59;
        boolean r130 = true;
    L60:
        if (r130 != true) goto L62;
        boolean r131 = true;
    L63:
        if (r131 == false) goto L91;
        k2.b r132 = r117.t();
        if (r132 == null) goto L67;
        r108 = r132.f501426e;
    L67:
        Intrinsics.checkNotNull(r108);
        r120.put("x-tt-env", r108);
        goto L91
    L59:
        r130 = false;
    L62:
        r131 = false;
        goto L63
    L68:
        k2.b r133 = r117.t();
        if (r133 != null) goto L71;
    L73:
        boolean r134 = false;
    L74:
        if (r134 == false) goto L91;
        r120.put(ByteNetEnvHeaderName.PPE, "1");
        k2.b r135 = r117.t();
        if (r135 == null) goto L85;
        String r136 = r135.f501427f;
        if (r136 == null) goto L85;
        if (r136.length() <= 0) goto L82;
        boolean r137 = true;
    L83:
        if (r137 != true) goto L85;
        boolean r138 = true;
    L86:
        if (r138 == false) goto L91;
        k2.b r139 = r117.t();
        if (r139 == null) goto L90;
        r108 = r139.f501427f;
    L90:
        Intrinsics.checkNotNull(r108);
        r120.put("x-tt-env", r108);
        goto L91
    L82:
        r137 = false;
    L85:
        r138 = false;
        goto L86
    L71:
        if (r133.f501425d != true) goto L73;
        r134 = true;
        goto L74
    L47:
        if (r126.f501424c != true) goto L49;
        r127 = true;
    L91:
        h2.a r140 = f2.b.f475099c;
        if (r140 != null) goto L94;
    L96:
        if (r106 == false) goto L103;
        Iterator r141 = r120.entrySet().iterator();
        String r142 = "addCommonHeaders: called, headers: ";
    L99:
        if (r141.hasNext() == false) goto L101;
        Map.Entry r143 = (Map.Entry) r141.next();
        r142 = r142 + ((String) r143.getKey()) + " = " + ((String) r143.getValue()) + '\n';
        goto L99
    L101:
        com.bytedance.ai.utils.g.f37637a.d("WebViewAssem", r142);
    L103:
        return new lx7.b(r101, r120);
    L94:
        if (r140.f483572k != true) goto L96;
        r106 = true;
        goto L96
    L31:
        if (r117.v(r121) == true) goto L34;
        r122 = false;
    L24:
        r115 = null;
        goto L25
    L21:
        k2.b r144 = r100.t();
        if (r144 == null) goto L24;
        r115 = r144.f501429h;
        goto L25
    L14:
        if (r112.f501424c != true) goto L16;
        r113 = true;
        goto L17
    L26:
        if (r101 != null) goto L28;
        r101 = "";
        goto L28
    L5:
        if (r100.v(r105) == true) goto L8;
        r107 = false;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.bytedance.ai.model.widgets.g0] */
    @Override // ix7.e
    public final boolean d(final com.ivy.ivykit.plugin.impl.web.b r100) {
        WebEngineAssem r101 = this.f37047a;
        int r102 = WebEngineAssem.C;
        k2.b r103 = r101.t();
        if (r103 != null) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == false) goto L14;
        if (r100 == null) goto L14;
        RenderStateVM r105 = this.f37047a.u();
        if (r105 == null) goto L13;
        r105.updateState(new i5.i(r100.getResources(), r100.getOrigin(), new g0(r100)));
    L13:
        return true;
    L14:
        return false;
    L5:
        if (r103.f501438q != true) goto L7;
        r104 = true;
        goto L8
    }

    @Override // ix7.e
    public final void e(View r100) {
        WebEngineAssem r101 = this.f37047a;
        int r102 = WebEngineAssem.C;
        RenderStateVM r103 = r101.u();
        if (r103 == null) goto L6;
        r103.updateState(new i5.j(r100));
        return;
    }

    @Override // ix7.e
    public final void onPageStarted(String r100) {
        com.bytedance.ai.utils.g.f37637a.i("WebViewAssem", "onPageStarted url:" + r100);
        WebEngineAssem r101 = this.f37047a;
        int r102 = WebEngineAssem.C;
        k2.b r103 = r101.t();
        if (r103 == null) goto L7;
        k2.j r104 = r103.f501435n;
        if (r104 == null) goto L7;
        r104.onViewStart(r100);
    L7:
        RenderStateVM r105 = this.f37047a.u();
        if (r105 == null) goto L10;
        r105.updateState(new i5.d(r100));
    L10:
        WebEngineAssem r106 = this.f37047a;
        String r107 = r106.f36994y;
        if (r107 == null) goto L16;
        String r108 = r106.f36995z;
        if (r108 == null) goto L17;
        i1 r109 = m5.y0.f512051a;
        m5.y0.g(r107, r108);
        return;
    L17:
        return;
    }

    @Override // ix7.e
    public final void i(WebView r100, int r101) {
        com.bytedance.ai.utils.g.f37637a.i("WebViewAssem", "onProgressChanged newProgress:" + r101);
        WebEngineAssem r102 = this.f37047a;
        int r103 = WebEngineAssem.C;
        RenderStateVM r104 = r102.u();
        if (r104 == null) goto L5;
        r104.updateState(new i5.e(r101));
    L5:
        WebEngineAssem r105 = this.f37047a;
        if (r105.f36983n != null) goto L15;
        r105.f36983n = r100;
        k2.b r106 = r105.t();
        if (r106 == null) goto L16;
        k2.j r107 = r106.f501435n;
        if (r107 == null) goto L17;
        WebView r108 = this.f37047a.f36983n;
        if (r108 == null) goto L18;
        r108.setTag(R.id.applet_ai_container_tag, new WeakReference(r107));
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    @Override // ix7.e
    public final boolean j(WebView r100, com.ivy.ivykit.plugin.impl.web.c r101) {
        com.bytedance.ai.utils.g.f37637a.e("WebViewAssem", "onRenderProcessGone: " + r101);
        return true;
    }

    @Override // ix7.e
    public final void k(WebResourceRequest r100, WebResourceError r101) {
        com.bytedance.ai.utils.g r102 = com.bytedance.ai.utils.g.f37637a;
        StringBuilder r103 = new StringBuilder("onReceivedError ");
        r103.append(r101);
        r103.append(" url:");
        WebEngineAssem r104 = this.f37047a;
        int r105 = WebEngineAssem.C;
        k2.b r106 = r104.t();
        String r107 = null;
        if (r106 == null) goto L5;
        String r108 = r106.f501423b;
    L6:
        r103.append(r108);
        r103.append(' ');
        r102.w("WebViewAssem", r103.toString());
        if (Build.VERSION.SDK_INT < 23) goto L17;
        StringBuilder r109 = new StringBuilder("Request: ");
        if (r100 == null) goto L11;
        Uri r110 = r100.getUrl();
    L12:
        r109.append(r110);
        r109.append(", error: ");
        if (r101 == null) goto L15;
        CharSequence r111 = r101.getDescription();
    L16:
        r109.append(r111);
        String r112 = r109.toString();
    L22:
        k2.b r113 = this.f37047a.t();
        if (r113 == null) goto L27;
        k2.j r114 = r113.f501435n;
        if (r114 == null) goto L27;
        r114.onViewError(r112);
    L27:
        if (r101 != null) goto L29;
    L31:
        boolean r115 = false;
    L32:
        if (r115 == true) goto L49;
        if (r100 == null) goto L38;
        Uri r116 = r100.getUrl();
        if (r116 == null) goto L38;
        r107 = r116.getLastPathSegment();
    L38:
        if (Intrinsics.areEqual(r107, "favicon.ico") == true) goto L50;
        WebEngineAssem r117 = this.f37047a;
        String r118 = r117.f36994y;
        if (r118 == null) goto L51;
        String r119 = r117.f36995z;
        if (r119 == null) goto L52;
        i1 r120 = m5.y0.f512051a;
        if (r101 == null) goto L46;
        int r121 = r101.getErrorCode();
    L47:
        m5.y0.b(r118, r112, r121, r119);
        return;
    L46:
        r121 = AppletErrorCode.WEB_VIEW_LOAD_ERROR.getType();
        goto L47
    L52:
        return;
    L51:
        return;
    L50:
        return;
    L49:
        return;
    L29:
        if (r101.getErrorCode() != (-1)) goto L31;
        r115 = true;
        goto L32
    L15:
        r111 = null;
        goto L16
    L11:
        r110 = null;
        goto L12
    L17:
        StringBuilder r122 = new StringBuilder("Request: ");
        if (r100 == null) goto L20;
        Uri r123 = r100.getUrl();
    L21:
        r122.append(r123);
        r112 = r122.toString();
        goto L22
    L20:
        r123 = null;
        goto L21
    L5:
        r108 = null;
        goto L6
    }

    @Override // ix7.e
    public final void onPageFinished(WebView r100, String r101) {
        com.bytedance.ai.utils.g r102 = com.bytedance.ai.utils.g.f37637a;
        r102.i("WebViewAssem", "onPageFinished url:" + r101);
        WebEngineAssem r103 = this.f37047a;
        int r104 = WebEngineAssem.C;
        RenderStateVM r105 = r103.u();
        if (r105 == null) goto L5;
        r105.updateState(new i5.c(r101));
    L5:
        WebEngineAssem r106 = this.f37047a;
        WebView r107 = r106.f36983n;
        r102.i("WebViewAssem", "injectWebViewData " + r107);
        if (r107 == null) goto L27;
        StringBuilder r108 = new StringBuilder("window.getAppData = function() { return JSON.stringify(");
        k2.b r109 = r106.t();
        if (r109 == null) goto L14;
        k2.j r110 = r109.f501435n;
        if (r110 == null) goto L14;
        PageInfo r111 = r110.getPageInfo();
        if (r111 == null) goto L14;
        String r112 = r111.getPageData();
    L15:
        r108.append(r112);
        r108.append("); }; \n");
        String r113 = r108.toString();
        StringBuilder r114 = new StringBuilder("window.getViewContext = function() { return JSON.stringify(");
        k2.b r115 = r106.t();
        if (r115 == null) goto L21;
        k2.j r116 = r115.f501435n;
        if (r116 == null) goto L21;
        String r117 = r116.viewContext();
        if (r117 == null) goto L21;
    L22:
        r114.append(r117);
        r114.append("); };\n");
        r107.evaluateJavascript(r113 + r114.toString(), null);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        com.bytedance.ai.utils.g.f37637a.e("WebViewPage", "JavaScript execution error: " + th.getMessage());
    L21:
        r117 = "";
    L14:
        r112 = null;
    L27:
        k2.b r118 = this.f37047a.t();
        if (r118 == null) goto L32;
        k2.j r119 = r118.f501435n;
        if (r119 == null) goto L32;
        r119.onViewFinish(r101);
    L32:
        WebEngineAssem r120 = this.f37047a;
        String r121 = r120.f36994y;
        if (r121 == null) goto L40;
        String r122 = r120.f36995z;
        if (r122 == null) goto L41;
        i1 r123 = m5.y0.f512051a;
        m5.y0.f(r121, r122);
        return;
    L41:
        return;
    }

    @Override // ix7.e
    public final void onReceivedTitle(WebView r100, String r101) {
        com.bytedance.ai.utils.g.f37637a.i("WebViewAssem", "onReceivedTitle title:" + r101);
        WebEngineAssem r102 = this.f37047a;
        int r103 = WebEngineAssem.C;
        RenderStateVM r104 = r102.u();
        if (r104 != null) goto L5;
        return;
    L5:
        if (r100 == null) goto L7;
        String r105 = r100.getTitle();
    L8:
        r104.updateState(new i5.f(r105));
        return;
    L7:
        r105 = null;
        goto L8
    }

    @Override // ix7.e
    public final boolean shouldOverrideUrlLoading(WebView r100, String r101) {
        if (r101 == null) goto L22;
        WebEngineAssem r102 = this.f37047a;
        int r103 = WebEngineAssem.C;
        k2.b r104 = r102.t();
        if (r104 == null) goto L7;
        Boolean r105 = Boolean.valueOf(r104.f501439r);
    L8:
        Intrinsics.checkNotNullParameter(r101, "url");
        if (StringsKt.startsWith$default(r101, "http", false, 2, null) == true) goto L11;
    L20:
        com.bytedance.ai.utils.g.f37637a.i("WebViewAssem", "shouldOverrideUrlLoading http url:".concat(r101));     // Catch: Exception -> L16
        Intent r106 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(r101));     // Catch: Exception -> L16
        r106.setFlags(805306368);     // Catch: Exception -> L16
        Context r107 = r102.getContext();     // Catch: Exception -> L16
        if (r107 == null) goto L18;
        r107.startActivity(r106);     // Catch: Exception -> L16
    L18:
        return true;
    L16:
        e = move-exception;
        com.bytedance.ai.utils.g.f37637a.w("WebViewAssem", "shouldOverrideUrlLoading http url:".concat(r101), e);
        goto L18
    L11:
        if (Intrinsics.areEqual(r105, Boolean.TRUE) == true) goto L20;
        return false;
    L7:
        r105 = null;
        goto L8
    L22:
        return false;
    }

    @Override // ix7.e
    public final void a(int r100, String r101, String r102) {
        com.bytedance.ai.utils.g.f37637a.w("WebViewAssem", "onReceivedError code:" + r100 + " desc:" + r101 + " url:" + r102);
        StringBuilder r103 = new StringBuilder("errorCode: ");
        r103.append(r100);
        r103.append(", description: ");
        r103.append(r101);
        r103.append(", failingUrl: ");
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r103.append(r102);
        String r104 = r103.toString();
        WebEngineAssem r105 = this.f37047a;
        int r106 = WebEngineAssem.C;
        k2.b r107 = r105.t();
        if (r107 == null) goto L11;
        k2.j r108 = r107.f501435n;
        if (r108 == null) goto L11;
        r108.onViewError(r104);
    L11:
        if (r100 == (-1)) goto L18;
        WebEngineAssem r109 = this.f37047a;
        String r110 = r109.f36994y;
        if (r110 == null) goto L19;
        String r111 = r109.f36995z;
        if (r111 == null) goto L20;
        i1 r112 = m5.y0.f512051a;
        m5.y0.b(r110, r104, r100, r111);
        return;
    L20:
        return;
    L19:
        return;
    }

    @Override // ix7.e
    public final void h(String r100, int r101, String r102) {
        com.bytedance.ai.utils.g r103 = com.bytedance.ai.utils.g.f37637a;
        h2.a r104 = f2.b.f475099c;
        if (r104 == null) goto L7;
        boolean r105 = true;
        if (r104.f483572k != true) goto L7;
    L8:
        if (r105 == false) goto L22;
        if (r100 == null) goto L23;
        WebEngineAssem r106 = this.f37047a;
        if (TextUtils.isEmpty(r102) == false) goto L14;
        r102 = "unknown-source";
    L14:
        StringBuilder r107 = new StringBuilder("[console]\"");
        r107.append(r100);
        r107.append("\", source: ");
        r107.append(r102);
        r107.append('(');
        r107.append(r101);
        r107.append("), pageId: ");
        int r108 = WebEngineAssem.C;
        k2.b r109 = r106.t();
        if (r109 == null) goto L19;
        k2.j r110 = r109.f501435n;
        if (r110 == null) goto L19;
        String r111 = r110.getPageID();
    L20:
        r107.append(r111);
        r103.d("AppletPage", r107.toString());
        return;
    L19:
        r111 = null;
        goto L20
    L23:
        return;
    L22:
        return;
    L7:
        r105 = false;
        goto L8
    }
}
