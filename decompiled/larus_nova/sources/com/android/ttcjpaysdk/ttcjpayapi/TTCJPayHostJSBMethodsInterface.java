package com.android.ttcjpaysdk.ttcjpayapi;

import android.content.Context;
import android.webkit.WebView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H&¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayHostJSBMethodsInterface;", "", "getJSBMethods", "Ljava/util/HashMap;", "", "Lcom/android/ttcjpaysdk/ttcjpayapi/ICJPayJSBMethod;", "Lkotlin/collections/HashMap;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "webView", "Landroid/webkit/WebView;", "url", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TTCJPayHostJSBMethodsInterface {
    HashMap<String, ICJPayJSBMethod> getJSBMethods(Context r100, WebView r101, String r102);
}
