package com.android.ttcjpaysdk.base.gecko;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.android.ttcjpaysdk.base.BuildConfig;
import com.android.ttcjpaysdk.base.service.ICJPayGeckoService;
import com.android.ttcjpaysdk.base.service.ICJPayOfflineHelper;
import com.android.ttcjpaysdk.base.service.IUpdateConfig;
import com.android.ttcjpaysdk.base.service.annotation.CJPayModuleEntryReport;
import com.bytedance.android.ec.core.event.a;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J$\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0017J&\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0017J(\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0017J(\u0010\u0015\u001a\u0004\u0018\u00010\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0017¨\u0006\u0019"}, d2 = {"Lcom/android/ttcjpaysdk/base/gecko/CJPayGeckoService;", "Lcom/android/ttcjpaysdk/base/service/ICJPayGeckoService;", "()V", "getGeckoPath", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getOfflineHelper", "Lcom/android/ttcjpaysdk/base/service/ICJPayOfflineHelper;", "getPackageName", "initGeckoClient", "", "appId", a.KEY_DID, "initWebOffline", "aid", "shouldInterceptRequest", "Landroid/webkit/WebResourceResponse;", "webView", "Landroid/webkit/WebView;", "url", "shouldInterceptRequestByUrl", "view", "loadUrl", "CJPayOfflineHelper", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayGeckoService implements ICJPayGeckoService {

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016¨\u0006\u0015"}, d2 = {"Lcom/android/ttcjpaysdk/base/gecko/CJPayGeckoService$CJPayOfflineHelper;", "Lcom/android/ttcjpaysdk/base/service/ICJPayOfflineHelper;", "()V", "checkCJGeckoUseful", "", "channel", "", "checkLiveChannelUseful", "forceUpdateChannel", "", "updateConfig", "Lcom/android/ttcjpaysdk/base/service/IUpdateConfig;", "getAK", "getChannel", "url", "getChannelVersion", "getOfflineDir", "shouldInterceptRequestByUrl", "Landroid/webkit/WebResourceResponse;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CJPayOfflineHelper implements ICJPayOfflineHelper {
        public static final CJPayOfflineHelper INSTANCE = null;

        static {
            INSTANCE = new CJPayOfflineHelper();
        }

        private CJPayOfflineHelper() {
        }

        @Override // com.android.ttcjpaysdk.base.service.ICJPayOfflineHelper
        public String getAK() {
            return CJPayGeckoXUtils.Companion.getAK();
        }

        @Override // com.android.ttcjpaysdk.base.service.ICJPayOfflineHelper
        public String getOfflineDir() {
            return CJPayGeckoXUtils.Companion.getPath$default(CJPayGeckoXUtils.Companion, null, 1, null);
        }

        @Override // com.android.ttcjpaysdk.base.service.ICJPayOfflineHelper
        public boolean checkCJGeckoUseful(String r100) {
            return CJPayGeckoXUtils.Companion.checkChannelUseful(r100);
        }

        @Override // com.android.ttcjpaysdk.base.service.ICJPayOfflineHelper
        public boolean checkLiveChannelUseful(String r100) {
            return CJPayGeckoXUtils.Companion.checkLiveChannelUseful(r100);
        }

        @Override // com.android.ttcjpaysdk.base.service.ICJPayOfflineHelper
        public void forceUpdateChannel(IUpdateConfig r100) {
            CJPayGeckoXManager.INSTANCE.forceUpdateChannel(r100);
        }

        @Override // com.android.ttcjpaysdk.base.service.ICJPayOfflineHelper
        public String getChannel(String r100) {
            if (r100 != null) goto L4;
            return "";
        L4:
            return CJPayGeckoXUtils.Companion.getChannel(r100);
        }

        @Override // com.android.ttcjpaysdk.base.service.ICJPayOfflineHelper
        public String getChannelVersion(String r100) {
            return CJPayGeckoXUtils.Companion.getChannelVersion(r100);
        }

        @Override // com.android.ttcjpaysdk.base.service.ICJPayOfflineHelper
        public WebResourceResponse shouldInterceptRequestByUrl(String r100, Context r101) {
            return CJPayGeckoXManager.INSTANCE.shouldInterceptRequest(r100, r101);
        }
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayService
    public String getPackageName() {
        return BuildConfig.LIBRARY_PACKAGE_NAME;
    }

    public CJPayGeckoService() {
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayGeckoService
    public ICJPayOfflineHelper getOfflineHelper() {
        return CJPayOfflineHelper.INSTANCE;
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayGeckoService
    public String getGeckoPath(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return CJPayGeckoXUtils.Companion.getPath(r100.getApplicationContext());
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayGeckoService
    @CJPayModuleEntryReport
    public void initGeckoClient(String r100, String r101, Context r102) {
        Intrinsics.checkNotNullParameter(r101, a.KEY_DID);
        CJPayGeckoXManager.INSTANCE.initGeckoClient(r100, r101, r102);
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayGeckoService
    @CJPayModuleEntryReport
    public void initWebOffline(String r100, String r101, Context r102) {
        CJPayGeckoOffline.Companion.initWebOffline(r100, r101, r102);
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayGeckoService
    @CJPayModuleEntryReport
    public WebResourceResponse shouldInterceptRequest(WebView r100, String r101, Context r102) {
        return CJPayGeckoXManager.INSTANCE.shouldInterceptRequest(r100, r101, r102);
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayGeckoService
    @CJPayModuleEntryReport
    public WebResourceResponse shouldInterceptRequestByUrl(WebView r100, String r101, Context r102) {
        return CJPayGeckoOffline.Companion.shouldInterceptRequestByUrl(r100, r101, r102);
    }
}
