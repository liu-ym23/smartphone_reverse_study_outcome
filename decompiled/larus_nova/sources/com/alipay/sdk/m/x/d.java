package com.alipay.sdk.m.x;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.ImageView;
import com.alipay.sdk.m.u.n;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class d extends com.alipay.sdk.m.x.c implements com.alipay.sdk.m.x.e.f, com.alipay.sdk.m.x.e.g, com.alipay.sdk.m.x.e.h {
    public static final String A = "action";
    public static final String B = "pushWindow";
    public static final String C = "h5JsFuncCallback";
    public static final String D = "sdkInfo";
    public static final String E = "canUseTaoLogin";
    public static final String F = "taoLogin";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f25922l = "sdk_result_code:";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f25923m = "alipayjsbridge://";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f25924n = "onBack";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f25925o = "setTitle";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f25926p = "onRefresh";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f25927q = "showBackButton";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f25928r = "onExit";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f25929s = "onLoadJs";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f25930t = "callNativeFunc";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f25931u = "back";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f25932v = "title";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f25933w = "refresh";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f25934x = "backButton";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f25935y = "refreshButton";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f25936z = "exit";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f25937e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f25938f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f25939g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.alipay.sdk.m.s.a f25940h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f25941i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.alipay.sdk.m.x.e f25942j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.alipay.sdk.m.x.f f25943k;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f25944a;

        @Override // java.lang.Runnable
        public void run() {
            com_alipay_sdk_m_x_d$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_alipay_sdk_m_x_d$a__run$___twin___() {
            this.f25944a.f25920a.finish();
        }

        public a(d r100) {
            this.f25944a = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_alipay_sdk_m_x_d$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_alipay_sdk_m_x_d$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public class b extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.alipay.sdk.m.x.e f25945a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f25946b;

        @Override // com.alipay.sdk.m.x.d.e, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation r100) {
            this.f25945a.a();
            d.a(this.f25946b, false);
        }

        public b(d r100, com.alipay.sdk.m.x.e r101) {
            this.f25946b = r100;
            this.f25945a = r101;
            super(null);
        }
    }

    public class c extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.alipay.sdk.m.x.e f25947a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f25948b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f25949c;

        @Override // com.alipay.sdk.m.x.d.e, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation r100) {
            this.f25949c.removeView(this.f25947a);
            d.a(this.f25949c).a(this.f25948b);
            d.a(this.f25949c, false);
        }

        public c(d r100, com.alipay.sdk.m.x.e r101, String r102) {
            this.f25949c = r100;
            this.f25947a = r101;
            this.f25948b = r102;
            super(null);
        }
    }

    /* JADX INFO: renamed from: com.alipay.sdk.m.x.d$d, reason: collision with other inner class name */
    public class RunnableC0498d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f25950a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SslErrorHandler f25951b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f25952c;

        /* JADX INFO: renamed from: com.alipay.sdk.m.x.d$d$a */
        public class a implements DialogInterface.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ RunnableC0498d f25953a;

            public a(RunnableC0498d r100) {
                this.f25953a = r100;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface r100, int r101) {
                this.f25953a.f25951b.cancel();
                com.alipay.sdk.m.k.a.b(d.b(this.f25953a.f25952c), com.alipay.sdk.m.k.b.f25406k, com.alipay.sdk.m.k.b.A, "2");
                com.alipay.sdk.m.j.b.a(com.alipay.sdk.m.j.b.a());
                this.f25953a.f25950a.finish();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            com_alipay_sdk_m_x_d$d_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_alipay_sdk_m_x_d$d__run$___twin___() {
            com.alipay.sdk.m.x.b.a(this.f25950a, "安全警告", "安全连接证书校验无效，将无法保证访问数据的安全性，请安装支付宝后重试。", "确定", new a(this), null, null);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_alipay_sdk_m_x_d$d_com_larus_apm_impl_protector_RunnableLancet_run(RunnableC0498d r100) {
            r100.com_alipay_sdk_m_x_d$d__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC0498d(d r100, Activity r101, SslErrorHandler r102) {
            this.f25952c = r100;
            this.f25950a = r101;
            this.f25951b = r102;
        }
    }

    public static abstract class e implements Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation r100) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation r100) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation r100) {
        }

        public e() {
        }

        public /* synthetic */ e(a r100) {
            this();
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<com.alipay.sdk.m.x.e> f25954a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f25955b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f25956c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final JSONObject f25957d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f25958e;

        public void a(JSONObject r100) {
            if (this.f25958e == false) goto L5;
            return;
        L5:
            com.alipay.sdk.m.x.e r101 = (com.alipay.sdk.m.x.e) n.a(this.f25954a);
            if (r101 != null) goto L8;
            return;
        L8:
            this.f25958e = true;
            r101.a(String.format("javascript:window.AlipayJSBridge.callBackFromNativeFunc('%s','%s');", new Object[]{a(this.f25956c), a(r100.toString())}));
        }

        public static String a(String r100) {
            if (TextUtils.isEmpty(r100) == false) goto L6;
            return "";
        L6:
            return r100.replace("'", "");
        }

        public f(com.alipay.sdk.m.x.e r100, String r101, String r102, JSONObject r103) {
            this.f25958e = false;
            this.f25954a = new WeakReference(r100);
            this.f25955b = r101;
            this.f25956c = r102;
            this.f25957d = r103;
        }
    }

    public static class g implements com.alipay.sdk.m.j.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f25959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f25960b;

        public g(f r100, String r101) {
            this.f25959a = r100;
            this.f25960b = r101;
        }

        @Override // com.alipay.sdk.m.j.d.a
        public void a(boolean r100, JSONObject r101, String r102) {
            f r103 = this.f25959a;     // Catch: JSONException -> L6
            JSONObject r104 = new JSONObject().put("success", r100);     // Catch: JSONException -> L6
            r103.a(r104.put("random", this.f25960b).put("code", r101).put("status", r102));     // Catch: JSONException -> L6
            return;
        }
    }

    private synchronized boolean e() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f25943k.b() == false) goto L6;
        this.f25920a.finish();     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return true;
    L6:
        this.f25939g = true;     // Catch: Throwable -> L9
        com.alipay.sdk.m.x.e r100 = this.f25942j;     // Catch: Throwable -> L9
        this.f25942j = this.f25943k.c();     // Catch: Throwable -> L9
        TranslateAnimation r101 = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);     // Catch: Throwable -> L9
        r101.setDuration(400);     // Catch: Throwable -> L9
        r101.setFillAfter(false);     // Catch: Throwable -> L9
        r101.setAnimationListener(new b(this, r100));     // Catch: Throwable -> L9
        r100.setAnimation(r101);     // Catch: Throwable -> L9
        removeView(r100);     // Catch: Throwable -> L9
        addView(this.f25942j);     // Catch: Throwable -> L9
        goto L7
    }

    private synchronized void f() {
        monitor-enter(this);
        Activity r100 = this.f25920a;     // Catch: Throwable -> L15
        com.alipay.sdk.m.x.e r101 = this.f25942j;     // Catch: Throwable -> L15
        if (r100 == null) goto L13;
        if (r101 == null) goto L13;
        if (this.f25937e == false) goto L10;
        r100.finish();     // Catch: Throwable -> L15
    L11:
        monitor-exit(this);
        return;
    L10:
        r101.a("javascript:window.AlipayJSBridge.callListener('h5BackAction');");     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private synchronized boolean g() {
        monitor-enter(this);
        com.alipay.sdk.m.x.e r100 = new com.alipay.sdk.m.x.e(this.f25920a, this.f25940h, new com.alipay.sdk.m.x.e.C0500e(!a(), !a()));     // Catch: Throwable -> L6 Exception -> L9
        this.f25942j = r100;     // Catch: Throwable -> L6 Exception -> L9
        r100.setChromeProxy(this);     // Catch: Throwable -> L6 Exception -> L9
        this.f25942j.setWebClientProxy(this);     // Catch: Throwable -> L6 Exception -> L9
        this.f25942j.setWebEventProxy(this);     // Catch: Throwable -> L6 Exception -> L9
        addView(this.f25942j);     // Catch: Throwable -> L6 Exception -> L9
        monitor-exit(this);
        return true;
    L6:
        th = move-exception;
        throw th;
    L10:
        return false;
    }

    private synchronized void i() {
        monitor-enter(this);
        WebView r100 = this.f25942j.getWebView();     // Catch: Throwable -> L14
        if (r100.canGoBack() == false) goto L6;
        r100.goBack();     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return;
    L6:
        com.alipay.sdk.m.x.f r101 = this.f25943k;     // Catch: Throwable -> L14
        if (r101 != null) goto L9;
    L11:
        a(false);     // Catch: Throwable -> L14
        goto L12
    L9:
        if (r101.b() == true) goto L11;
        e();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.alipay.sdk.m.x.c
    public synchronized boolean b() {
        monitor-enter(this);
        Activity r100 = this.f25920a;     // Catch: Throwable -> L31
        if (r100 != null) goto L9;
        monitor-exit(this);
        return true;
    L9:
        if (a() == false) goto L27;
        com.alipay.sdk.m.x.e r101 = this.f25942j;     // Catch: Throwable -> L31
        if (r101 != null) goto L13;
    L23:
        r100.finish();     // Catch: Throwable -> L31
        monitor-exit(this);
        return true;
    L13:
        if (r101.getWebView() == null) goto L23;
        if (r101.getWebView().canGoBack() == true) goto L18;
        com.alipay.sdk.m.j.b.a(com.alipay.sdk.m.j.b.a());     // Catch: Throwable -> L31
        r100.finish();     // Catch: Throwable -> L31
    L21:
        monitor-exit(this);
        return true;
    L18:
        if (d() == false) goto L21;
        com.alipay.sdk.m.j.c r102 = com.alipay.sdk.m.j.c.b(com.alipay.sdk.m.j.c.f25365f.b());     // Catch: Throwable -> L31
        com.alipay.sdk.m.j.b.a(com.alipay.sdk.m.j.b.a(r102.b(), r102.a(), ""));     // Catch: Throwable -> L31
        r100.finish();     // Catch: Throwable -> L31
        goto L21
    L27:
        if (this.f25939g == true) goto L29;
        f();     // Catch: Throwable -> L31
    L29:
        monitor-exit(this);
        return true;
    L31:
        th = move-exception;
        throw th;
    }

    @Override // com.alipay.sdk.m.x.c
    public synchronized void c() {
        monitor-enter(this);
        this.f25942j.a();     // Catch: Throwable -> L6
        this.f25943k.a();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void h() {
        com.alipay.sdk.m.x.e r100 = this.f25942j;
        if (r100 == null) goto L6;
        r100.getWebView().loadUrl("javascript:(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n;window.AlipayJSBridge.callListener('h5PageFinished');");
        return;
    }

    public boolean d() {
        return this.f25941i;
    }

    private synchronized void b(String r100) {
        monitor-enter(this);
        Map<String, String> r101 = n.b(this.f25940h, r100);     // Catch: Throwable -> L34
        if (r100.startsWith(f25930t) == false) goto L7;
        a(r101.get("func"), r101.get("cbId"), r101.get("data"));     // Catch: Throwable -> L34
    L32:
        monitor-exit(this);
        return;
    L7:
        if (r100.startsWith(f25924n) == false) goto L10;
        i();     // Catch: Throwable -> L34
        goto L32
    L10:
        if (r100.startsWith(f25925o) == false) goto L15;
        if (r101.containsKey("title") == false) goto L15;
        this.f25942j.getTitle().setText(r101.get("title"));     // Catch: Throwable -> L34
    L15:
        if (r100.startsWith(f25926p) == false) goto L18;
        this.f25942j.getWebView().reload();     // Catch: Throwable -> L34
        goto L32
    L18:
        if (r100.startsWith(f25927q) == false) goto L27;
        if (r101.containsKey("bshow") == false) goto L27;
        boolean r102 = TextUtils.equals("true", r101.get("bshow"));     // Catch: Throwable -> L34
        ImageView r103 = this.f25942j.getBackButton();     // Catch: Throwable -> L34
        if (r102 == false) goto L24;
        int r104 = 0;
    L25:
        r103.setVisibility(r104);     // Catch: Throwable -> L34
        goto L32
    L24:
        r104 = 4;
    L27:
        if (r100.startsWith(f25928r) == false) goto L30;
        com.alipay.sdk.m.j.b.a(r101.get("result"));     // Catch: Throwable -> L34
        a(TextUtils.equals("true", r101.get("bsucc")));     // Catch: Throwable -> L34
        goto L32
    L30:
        if (r100.startsWith(f25929s) == false) goto L32;
        this.f25942j.a("javascript:(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n");     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;
    }

    @Override // com.alipay.sdk.m.x.c
    public synchronized void a(String r100) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if ("POST".equals(this.f25938f) == false) goto L6;
        this.f25942j.a(r100, null);     // Catch: Throwable -> L10
    L7:
        com.alipay.sdk.m.x.c.a(this.f25942j.getWebView());     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        this.f25942j.a(r100);     // Catch: Throwable -> L10
        goto L7
    }

    @Override // android.view.ViewGroup
    public synchronized boolean onInterceptTouchEvent(MotionEvent r100) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f25939g == false) goto L6;
        boolean r101 = true;
    L7:
        monitor-exit(this);
        return r101;
    L6:
        r101 = super.onInterceptTouchEvent(r100);     // Catch: Throwable -> L9
        goto L7
    }

    @Override // com.alipay.sdk.m.x.e.h
    public synchronized void a(com.alipay.sdk.m.x.e r100) {
        monitor-enter(this);
        r100.getWebView().reload();     // Catch: Throwable -> L6
        r100.getRefreshButton().setVisibility(4);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.alipay.sdk.m.x.e.h
    public synchronized void b(com.alipay.sdk.m.x.e r100) {
        monitor-enter(this);
        f();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized void a(boolean r100) {
        monitor-enter(this);
        com.alipay.sdk.m.j.b.a(r100);     // Catch: Throwable -> L6
        this.f25920a.finish();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ com.alipay.sdk.m.s.a b(d r100) {
        return r100.f25940h;
    }

    public static /* synthetic */ com.alipay.sdk.m.x.e a(d r100) {
        return r100.f25942j;
    }

    private synchronized boolean b(String r110, String r111) {
        monitor-enter(this);
        com.alipay.sdk.m.x.e r100 = this.f25942j;     // Catch: Throwable -> L14
        com.alipay.sdk.m.x.e r101 = new com.alipay.sdk.m.x.e(this.f25920a, this.f25940h, new com.alipay.sdk.m.x.e.C0500e(!a(), !a()));     // Catch: Throwable -> L12
        this.f25942j = r101;     // Catch: Throwable -> L12
        r101.setChromeProxy(this);     // Catch: Throwable -> L12
        this.f25942j.setWebClientProxy(this);     // Catch: Throwable -> L12
        this.f25942j.setWebEventProxy(this);     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r111) == true) goto L9;
        this.f25942j.getTitle().setText(r111);     // Catch: Throwable -> L12
    L9:
        this.f25939g = true;     // Catch: Throwable -> L14
        this.f25943k.a(r100);     // Catch: Throwable -> L14
        TranslateAnimation r102 = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);     // Catch: Throwable -> L14
        r102.setDuration(400);     // Catch: Throwable -> L14
        r102.setFillAfter(false);     // Catch: Throwable -> L14
        r102.setAnimationListener(new c(this, r100, r110));     // Catch: Throwable -> L14
        this.f25942j.setAnimation(r102);     // Catch: Throwable -> L14
        addView(this.f25942j);     // Catch: Throwable -> L14
        monitor-exit(this);
        return true;
    L13:
        return false;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.alipay.sdk.m.x.e.g
    public synchronized boolean a(com.alipay.sdk.m.x.e r100, String r101) {
        monitor-enter(this);
    L35:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L8;
        monitor-exit(this);
        return false;
    L8:
        Activity r102 = this.f25920a;     // Catch: Throwable -> L35
        if (r102 != null) goto L14;
        monitor-exit(this);
        return true;
    L14:
        if (n.a(this.f25940h, r101, r102) == false) goto L18;
        monitor-exit(this);
        return true;
    L18:
        if (r101.startsWith(f25923m) == false) goto L21;
        b(r101.substring(17));     // Catch: Throwable -> L35
    L33:
        monitor-exit(this);
        return true;
    L21:
        if (TextUtils.equals(r101, com.alipay.sdk.m.l.a.f25469q) == false) goto L24;
        a(false);     // Catch: Throwable -> L35
        goto L33
    L24:
        if (r101.startsWith("http://") == false) goto L26;
    L32:
        this.f25942j.a(r101);     // Catch: Throwable -> L35
        goto L33
    L26:
        if (r101.startsWith("https://") == true) goto L32;
        Intent r103 = new Intent();     // Catch: Throwable -> L30
        r103.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);     // Catch: Throwable -> L30
        r103.setData(Uri.parse(r101));     // Catch: Throwable -> L30
        r102.startActivity(r103);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        com.alipay.sdk.m.k.a.a(this.f25940h, "biz", th);     // Catch: Throwable -> L35
        goto L33
    }

    @Override // com.alipay.sdk.m.x.e.f
    public synchronized void c(com.alipay.sdk.m.x.e r100, String r101) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (r101.startsWith("http") == false) goto L6;
    L8:
        monitor-exit(this);
        return;
    L6:
        if (r100.getUrl().endsWith(r101) == true) goto L8;
        this.f25942j.getTitle().setText(r101);     // Catch: Throwable -> L10
        goto L8
    }

    @Override // com.alipay.sdk.m.x.e.g
    public synchronized boolean d(com.alipay.sdk.m.x.e r100, String r101) {
        monitor-enter(this);
        com.alipay.sdk.m.k.a.a(this.f25940h, "biz", "h5ld", SystemClock.elapsedRealtime() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + n.i(r101));     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r101) == false) goto L6;
    L8:
        monitor-exit(this);
        return false;
    L6:
        if (r101.endsWith(".apk") == true) goto L8;
        h();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ boolean a(d r100, boolean r101) {
        r100.f25939g = r101;
        return r101;
    }

    @Override // com.alipay.sdk.m.x.e.g
    public synchronized boolean b(com.alipay.sdk.m.x.e r100, String r101) {
        monitor-enter(this);
        com.alipay.sdk.m.k.a.a(this.f25940h, "biz", "h5ldd", SystemClock.elapsedRealtime() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + n.i(r101));     // Catch: Throwable -> L7
        h();     // Catch: Throwable -> L7
        r100.getRefreshButton().setVisibility(0);     // Catch: Throwable -> L7
        monitor-exit(this);
        return true;
    L7:
        th = move-exception;
        throw th;
    }

    public d(Activity r100, com.alipay.sdk.m.s.a r101, String r102) {
        super(r100, r102);
        this.f25937e = true;
        this.f25938f = "GET";
        this.f25939g = false;
        this.f25942j = null;
        this.f25943k = new com.alipay.sdk.m.x.f();
        this.f25940h = r101;
        g();
    }

    private synchronized void a(String r110, String r111, String r112) {
        monitor-enter(this);
        com.alipay.sdk.m.x.e r100 = this.f25942j;     // Catch: Throwable -> L90
        if (r100 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        JSONObject r113 = n.h(r112);     // Catch: Throwable -> L90
        f r101 = new f(r100, r110, r111, r113);     // Catch: Throwable -> L90
        Context r114 = r100.getContext();     // Catch: Throwable -> L90
        String r102 = r101.f25955b;     // Catch: Throwable -> L86
        int r103 = 4;
        switch(r102.hashCode()) {
            case -1785164386: goto L39;
            case -552487705: goto L36;
            case 3015911: goto L33;
            case 3127582: goto L30;
            case 110371416: goto L27;
            case 1085444827: goto L24;
            case 1703426986: goto L21;
            case 1906413305: goto L18;
            case 1947723784: goto L15;
            case 2033767917: goto L12;
            default: goto L41;
        };     // Catch: Throwable -> L86
    L41:
        byte r104 = -1;
    L42:
        switch(r104) {
            case 0: goto L83;
            case 1: goto L81;
            case 2: goto L80;
            case 3: goto L79;
            case 4: goto L75;
            case 5: goto L71;
            case 6: goto L70;
            case 7: goto L65;
            case 8: goto L59;
            case 9: goto L44;
            default: goto L88;
        };     // Catch: Throwable -> L86
    L44:
        String r105 = r100.getUrl();     // Catch: Throwable -> L86
        if (n.a(this.f25940h, r105) == true) goto L47;
        com.alipay.sdk.m.k.a.b(this.f25940h, "biz", "jsUrlErr", r105);     // Catch: Throwable -> L86
        goto L88
    L47:
        String r106 = r113.optString("random");     // Catch: Throwable -> L86
        JSONObject r115 = r113.optJSONObject("options");     // Catch: Throwable -> L86
        if (TextUtils.isEmpty("random") == true) goto L88;
        if (r115 == null) goto L88;
        String r107 = r115.optString("url");     // Catch: Throwable -> L86
        String r108 = r115.optString("action");     // Catch: Throwable -> L86
        if (TextUtils.isEmpty(r107) == true) goto L88;
        if (TextUtils.isEmpty(r108) == true) goto L88;
        if ((r114 instanceof Activity) == false) goto L88;
        com.alipay.sdk.m.j.d.a(this.f25940h, (Activity) r114, 1010, r107, r108, new g(r101, r106));     // Catch: Throwable -> L86
        goto L88
    L59:
        String r116 = r100.getUrl();     // Catch: Throwable -> L86
        if (n.a(this.f25940h, r116) == true) goto L62;
        com.alipay.sdk.m.k.a.b(this.f25940h, "biz", "jsUrlErr", r116);     // Catch: Throwable -> L86
        goto L88
    L62:
        JSONObject r117 = new JSONObject();     // Catch: Throwable -> L86
        boolean r118 = com.alipay.sdk.m.j.d.a(this.f25940h, r114);     // Catch: Throwable -> L86
        r117.put("enabled", r118);     // Catch: Throwable -> L86
        com.alipay.sdk.m.s.a r109 = this.f25940h;     // Catch: Throwable -> L86
        com.alipay.sdk.m.k.a.a(r109, "biz", com.alipay.sdk.m.k.b.f25425t0, String.valueOf(r118));     // Catch: Throwable -> L86
        r101.a(r117);     // Catch: Throwable -> L86
        goto L88
    L65:
        JSONObject r119 = new JSONObject();     // Catch: Throwable -> L86
        r119.put("sdk_version", "15.8.15");     // Catch: Throwable -> L86
        r119.put("app_name", this.f25940h.b());     // Catch: Throwable -> L86
        r119.put("app_version", this.f25940h.c());     // Catch: Throwable -> L86
        r101.a(r119);     // Catch: Throwable -> L86
        goto L88
    L70:
        b(r113.optString("url"), r113.optString("title", ""));     // Catch: Throwable -> L86
        goto L88
    L71:
        boolean r120 = r113.optBoolean("show", true);     // Catch: Throwable -> L86
        ImageView r121 = r100.getRefreshButton();     // Catch: Throwable -> L86
        if (r120 == false) goto L74;
        r103 = 0;
    L74:
        r121.setVisibility(r103);     // Catch: Throwable -> L86
        goto L88
    L75:
        boolean r122 = r113.optBoolean("show", true);     // Catch: Throwable -> L86
        ImageView r123 = r100.getBackButton();     // Catch: Throwable -> L86
        if (r122 == false) goto L78;
        r103 = 0;
    L78:
        r123.setVisibility(r103);     // Catch: Throwable -> L86
        goto L88
    L79:
        com.alipay.sdk.m.j.b.a(r113.optString("result", null));     // Catch: Throwable -> L86
        a(r113.optBoolean("success", false));     // Catch: Throwable -> L86
        goto L88
    L80:
        i();     // Catch: Throwable -> L86
        goto L88
    L81:
        r100.getWebView().reload();     // Catch: Throwable -> L86
    L88:
        monitor-exit(this);
        return;
    L83:
        if (r113.has("title") == false) goto L88;
        r100.getTitle().setText(r113.optString("title", ""));     // Catch: Throwable -> L86
        goto L88
    L12:
        if (r102.equals(f25935y) == false) goto L41;
        r104 = 5;
        goto L42
    L15:
        if (r102.equals(D) == false) goto L41;
        r104 = 7;
        goto L42
    L18:
        if (r102.equals(f25934x) == false) goto L41;
        r104 = 4;
        goto L42
    L21:
        if (r102.equals(B) == false) goto L41;
        r104 = 6;
        goto L42
    L24:
        if (r102.equals("refresh") == false) goto L41;
        r104 = 1;
        goto L42
    L27:
        if (r102.equals("title") == false) goto L41;
        r104 = 0;
        goto L42
    L30:
        if (r102.equals("exit") == false) goto L41;
        r104 = 3;
        goto L42
    L33:
        if (r102.equals("back") == false) goto L41;
        r104 = 2;
        goto L42
    L36:
        if (r102.equals(F) == false) goto L41;
        r104 = 9;
        goto L42
    L39:
        if (r102.equals(E) == false) goto L41;
        r104 = 8;
    L86:
        th = move-exception;
        com.alipay.sdk.m.k.a.a(this.f25940h, "biz", "jInfoErr", th, r110);     // Catch: Throwable -> L90
    L90:
        th = move-exception;
        throw th;
    }

    @Override // com.alipay.sdk.m.x.e.g
    public synchronized boolean a(com.alipay.sdk.m.x.e r100, SslErrorHandler r101, SslError r102) {
        monitor-enter(this);
        Activity r103 = this.f25920a;     // Catch: Throwable -> L12
        if (r103 != null) goto L9;
        monitor-exit(this);
        return true;
    L9:
        com.alipay.sdk.m.k.a.b(this.f25940h, com.alipay.sdk.m.k.b.f25406k, com.alipay.sdk.m.k.b.f25436z, "2-" + r102);     // Catch: Throwable -> L12
        r103.runOnUiThread(new RunnableC0498d(this, r103, r101));     // Catch: Throwable -> L12
        monitor-exit(this);
        return true;
    L12:
        th = move-exception;
        throw th;
    }

    public synchronized void a(String r100, String r101, boolean r102) {
        monitor-enter(this);
        this.f25938f = r101;     // Catch: Throwable -> L6
        this.f25942j.getTitle().setText(r100);     // Catch: Throwable -> L6
        this.f25937e = r102;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.alipay.sdk.m.x.e.g
    public synchronized boolean a(com.alipay.sdk.m.x.e r100, int r101, String r102, String r103) {
        monitor-enter(this);
        this.f25941i = true;     // Catch: Throwable -> L8
        com.alipay.sdk.m.k.a.b(this.f25940h, com.alipay.sdk.m.k.b.f25406k, com.alipay.sdk.m.k.b.f25434y, "onReceivedError:" + r101 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r103);     // Catch: Throwable -> L8
        r100.getRefreshButton().setVisibility(0);     // Catch: Throwable -> L8
        monitor-exit(this);
        return false;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.alipay.sdk.m.x.e.f
    public synchronized boolean a(com.alipay.sdk.m.x.e r100, String r101, String r102, String r103, JsPromptResult r104) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (r102.startsWith("<head>") == true) goto L6;
    L8:
        r104.cancel();     // Catch: Throwable -> L12
        monitor-exit(this);
        return true;
    L6:
        if (r102.contains(f25922l) == false) goto L8;
        a r105 = new a(this);     // Catch: Throwable -> L12
        this.f25920a.runOnUiThread(r105);     // Catch: Throwable -> L12
        goto L8
    }
}
