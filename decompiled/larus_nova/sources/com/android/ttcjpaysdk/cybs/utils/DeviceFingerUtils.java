package com.android.ttcjpaysdk.cybs.utils;

import android.content.Context;
import android.webkit.WebView;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.service.ICJPayCybsService;
import com.android.ttcjpaysdk.base.utils.CJPayCountDownTimeUtil;
import com.android.ttcjpaysdk.cybs.jsb.CybsBridge;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0004J\u0016\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/android/ttcjpaysdk/cybs/utils/DeviceFingerUtils;", "", "()V", "BASE_URL", "", "DDC_SCRIPT", "DM_DEVICE_FINGER_SCRIPT_BOE", "DM_DEVICE_FINGER_SCRIPT_ONLINE", "MERCHANT_ID", "TIMER_KEY", "collectDDCFor3DS", "", "webView", "Landroid/webkit/WebView;", "url", "accessToken", "callback", "Lcom/android/ttcjpaysdk/base/service/ICJPayCybsService$DDCResultCallback;", "collectDMDeviceFinger", "sessionId", "collentBrowserDeviceFinger", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "Lcom/android/ttcjpaysdk/base/service/ICJPayCybsService$DeviceFingerResultCallback;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeviceFingerUtils {
    private static final String BASE_URL = "https://douyinpay/cybs";
    private static final String DDC_SCRIPT = "  <!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\n            \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n    <html xmlns=\"http://www.w3.org/1999/xhtml\">\n    <head>\n        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\n        <title>DDC test</title>\n    </head>\n    <body>\n    <iframe name=\"ddc-iframe\" height=\"1\" width=\"1\" style=\"display: none;\">\n    </iframe>\n    <form id=\"ddc-form\" target=\"ddc-iframe\" method=\"POST\" action=\"<actionPlaceHolder>\">\n        <input type=\"hidden\" name=\"JWT\" value=\"<JWTPlaceHolder>\"/>\n    </form>\n\n    <script type=\"application/javascript\">\n\n                console.log(window.CybsObject);\n        window.onload = function () {\n console.log(\"onload\");\n            var ddcForm = document.querySelector('#ddc-form');\n            // ddc form exists\n            if (ddcForm) {\n                ddcForm.submit();\n            }\n        };\n\n        window.addEventListener(\"message\", (event) => {\n            //{MessageType: \"profile.completed\", SessionId: \"bab9a46f-2482-4e9c-b0b1-1a7c72f0c0c6\", Status: true}\n            var data = JSON.parse(event.data);\n console.log(event.data);\n            if (typeof (data) !== 'undefined' && data.Status) {\n                //todo:请求第二步认证\n                // $('.js_step1_session_id').val(data.SessionId);\n                // $('#step2-form').submit();\n                console.log(data);\nwindow.CybsObject.ddcCallback(\"1\");\n            } else {\n                window.CybsObject.ddcCallback(\"0\");            \t\n            }\n\n        }, false);\n\n    </script>\n    </body>\n    </html>";
    private static final String DM_DEVICE_FINGER_SCRIPT_BOE = "<head>\n    <script type=\"text/javascript\" src=\"https://h.online-metrix.net/fp/\ntags.js?org_id=1snn5n9w&session_id=<sessionIdPlaceHolder>\"></script>\n</head>\n<body>\n<noscript>\n       <iframe style=\"width: 100px; height: 100px; border: 0; position:\nabsolute; top: -5000px;\" src=\"https://h.online-metrix.net/fp/tags?org_\nid=1snn5n9w&session_id=<sessionIdPlaceHolder>\"></iframe>\n    </noscript>\n</body>";
    private static final String DM_DEVICE_FINGER_SCRIPT_ONLINE = "<head>\n    <script type=\"text/javascript\" src=\"https://h.online-metrix.net/fp/\ntags.js?org_id=k8vif92e&session_id=<sessionIdPlaceHolder>\"></script>\n</head>\n<body>\n<noscript>\n       <iframe style=\"width: 100px; height: 100px; border: 0; position:\nabsolute; top: -5000px;\" src=\"https://h.online-metrix.net/fp/tags?org_\nid=k8vif92e&session_id=<sessionIdPlaceHolder>\"></iframe>\n    </noscript>\n</body>";
    public static final DeviceFingerUtils INSTANCE = null;
    private static final String MERCHANT_ID = "bytedance_hzyb";
    private static final String TIMER_KEY = "ddc_timer";

    static {
        INSTANCE = new DeviceFingerUtils();
    }

    private DeviceFingerUtils() {
    }

    public final void collectDMDeviceFinger(WebView r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "webView");
        Intrinsics.checkNotNullParameter(r111, "sessionId");
        String r112 = StringEscapeUtils.INSTANCE.escapeHtml4(r111);
        if (2 != CJPayHostInfo.serverType) goto L5;
        String r113 = StringsKt.replace$default(DM_DEVICE_FINGER_SCRIPT_BOE, "<sessionIdPlaceHolder>", MERCHANT_ID + r112, false, 4, null);
    L6:
        r110.getSettings().setJavaScriptEnabled(true);
        r110.getSettings().setDefaultTextEncodingName("UTF-8");
        r110.loadDataWithBaseURL(BASE_URL, r113, "text/html", XML.CHARSET_UTF8, null);
        CJLogger.d("collectDMDeviceFinger", "start collet dm");
        return;
    L5:
        r113 = StringsKt.replace$default(DM_DEVICE_FINGER_SCRIPT_ONLINE, "<sessionIdPlaceHolder>", MERCHANT_ID + r112, false, 4, null);
        goto L6
    }

    public final void collentBrowserDeviceFinger(final Context r100, final ICJPayCybsService.DeviceFingerResultCallback r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "callback");
        WebView r102 = new WebView(r100);
        r102.getSettings().setJavaScriptEnabled(true);
        r102.getSettings().setDefaultTextEncodingName("UTF-8");
        r102.addJavascriptInterface(new CybsBridge(new DeviceFingerUtils$collentBrowserDeviceFinger$1$cybsBridge$1(r101, r100)), "CybsObject");
        r102.evaluateJavascript("javascript:var ret = {}; ret.language=navigator.language;ret.javaEnabled=navigator.javaEnabled();ret.colorDepth=screen.colorDepth;ret.screenHeight=screen.height;ret.screenWidth=screen.width;ret.userAgent=navigator.userAgent;CybsObject.collectDDCInfo(JSON.stringify(ret))", null);
    }

    public final void collectDDCFor3DS(WebView r110, String r111, String r112, final ICJPayCybsService.DDCResultCallback r113) {
        Intrinsics.checkNotNullParameter(r110, "webView");
        Intrinsics.checkNotNullParameter(r111, "url");
        Intrinsics.checkNotNullParameter(r112, "accessToken");
        Intrinsics.checkNotNullParameter(r113, "callback");
        StringEscapeUtils r100 = StringEscapeUtils.INSTANCE;
        String r101 = r100.escapeHtml4(r111);
        String r102 = r100.escapeHtml4(r112);
        String r103 = StringsKt.replace$default(StringsKt.replace$default(DDC_SCRIPT, "<actionPlaceHolder>", r101, false, 4, null), "<JWTPlaceHolder>", r102, false, 4, null);
        final Ref.BooleanRef r104 = new Ref.BooleanRef();
        CJPayCountDownTimeUtil.getInstance().cancel(TIMER_KEY);
        CJPayCountDownTimeUtil.getInstance().putCountDownTimer(TIMER_KEY, 10000, 1000, new AnonymousClass1(r104, r113));
        r110.getSettings().setJavaScriptEnabled(true);
        r110.getSettings().setDefaultTextEncodingName("UTF-8");
        r110.addJavascriptInterface(new CybsBridge(new DeviceFingerUtils$collectDDCFor3DS$2$cybsBridge$1(r104, r113)), "CybsObject");
        r110.loadDataWithBaseURL(BASE_URL, r103, "text/html", XML.CHARSET_UTF8, null);
    }
}
