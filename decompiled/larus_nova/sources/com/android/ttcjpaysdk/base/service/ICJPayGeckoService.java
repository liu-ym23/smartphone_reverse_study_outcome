package com.android.ttcjpaysdk.base.service;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.android.ec.core.event.a;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J$\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J&\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J(\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J(\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0016"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayGeckoService;", "Lcom/android/ttcjpaysdk/base/service/ICJPayService;", "getGeckoPath", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getOfflineHelper", "Lcom/android/ttcjpaysdk/base/service/ICJPayOfflineHelper;", "initGeckoClient", "", "appId", a.KEY_DID, "initWebOffline", "aid", "shouldInterceptRequest", "Landroid/webkit/WebResourceResponse;", "webView", "Landroid/webkit/WebView;", "url", "shouldInterceptRequestByUrl", "view", "loadUrl", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJPayGeckoService extends ICJPayService {
    String getGeckoPath(Context r100);

    ICJPayOfflineHelper getOfflineHelper();

    void initGeckoClient(String r100, String r101, Context r102);

    void initWebOffline(String r100, String r101, Context r102);

    WebResourceResponse shouldInterceptRequest(WebView r100, String r101, Context r102);

    WebResourceResponse shouldInterceptRequestByUrl(WebView r100, String r101, Context r102);
}
