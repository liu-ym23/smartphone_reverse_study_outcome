package com.android.ttcjpaysdk.base.h5;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/CJPayJavascriptInterface;", "", "url", "", "(Ljava/lang/String;)V", "onCJEvent", "", "schema", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayJavascriptInterface {
    private final String url;

    public CJPayJavascriptInterface(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.url = r100;
    }

    @JavascriptInterface
    public final void onCJEvent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        if (StringsKt.startsWith$default(r100, "cjevent://cj_DOMContentLoaded", false, 2, null) == false) goto L15;
        Uri r101 = UriProtector.parse(r100);     // Catch: Exception -> L10
        String r102 = r101.getHost();     // Catch: Exception -> L10
        String r103 = UriProtector.getQueryParameter(r101, "time");     // Catch: Exception -> L10
        if (TextUtils.equals("cj_DOMContentLoaded", r102) == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r103) == true) goto L17;
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L10
        r104.put("url", this.url);     // Catch: Exception -> L10
        r104.put(ReportCardMonitorPlugin.EVENT_NAME, "cj_DOMContentLoaded");     // Catch: Exception -> L10
        r104.put("event_time", r103);     // Catch: Exception -> L10
        CJPayLynxEventApi.INSTANCE.getLynxEventService().enqueueEvent("cjpay_webview_dom_event", System.currentTimeMillis(), r104);     // Catch: Exception -> L10
        return;
    L17:
        return;
    L10:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayJavascriptInterface#onCJEvent", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayJavascriptInterface#onCJEvent", e);
        return;
    }
}
