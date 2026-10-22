package com.android.ttcjpaysdk.base.gecko;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.utils.CJPayThreadUtils;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/android/ttcjpaysdk/base/gecko/CJPayGeckoOffline;", "", "()V", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayGeckoOffline {
    public static final Companion Companion = null;
    private static boolean isDegrade;
    private static boolean isMergeRequest;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ&\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/base/gecko/CJPayGeckoOffline$Companion;", "", "()V", "isDegrade", "", "isMergeRequest", "initWebOffline", "", "aid", "", a.KEY_DID, PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "shouldInterceptRequestByUrl", "Landroid/webkit/WebResourceResponse;", "view", "Landroid/webkit/WebView;", "loadUrl", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final void initWebOffline(String r100, String r101, final Context r102) {
            CJPayThreadUtils.getInstance().runOnWorkThreadDelay(new CJPayGeckoOffline$Companion$initWebOffline$1(r102), 5000);
        }

        public final WebResourceResponse shouldInterceptRequestByUrl(WebView r100, String r101, Context r102) {
            CJLogger.d("CJPayGeckoOffline", "isUsingGecko: " + CJPayHostInfo.isUsingGecko + ", isDegrade: " + CJPayGeckoOffline.access$isDegrade$cp() + ", loadUrl: " + r101);
            int r103 = 1;
            if (CJPayHostInfo.isUsingGecko == true) goto L5;
        L7:
            WebResourceResponse r104 = null;
            int r105 = 0;
        L8:
            StringBuilder r106 = new StringBuilder("response: ");
            if (r104 == null) goto L11;
            boolean r107 = true;
        L12:
            r106.append(r107);
            r106.append(" loadUrl: ");
            r106.append(r101);
            CJLogger.d("CJPayGeckoOffline", r106.toString());
            if (r104 != null) goto L16;
            r103 = 0;
        L16:
            CJPayGeckoXUtils.Companion.uploadInterceptResult(r105, r101, r103);
            return r104;
        L11:
            r107 = false;
            goto L12
        L5:
            if (CJPayGeckoOffline.access$isDegrade$cp() == true) goto L7;
            r104 = CJPayGeckoXManager.INSTANCE.shouldInterceptRequest(r100, r101, r102);
            r105 = 1;
            goto L8
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CJPayGeckoOffline() {
    }

    public static final /* synthetic */ boolean access$isDegrade$cp() {
        return isDegrade;
    }

    public static final /* synthetic */ void access$setDegrade$cp(boolean r100) {
        isDegrade = r100;
    }

    public static final /* synthetic */ void access$setMergeRequest$cp(boolean r100) {
        isMergeRequest = r100;
    }
}
