package com.bytedance.android.livesdkapi.jsb;

import android.webkit.WebView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/jsb/IExternalLiveWebCallback;", "", "onPageFinished", "", "webView", "Landroid/webkit/WebView;", "url", "", "onPageStarted", "onReceivedError", "msg", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IExternalLiveWebCallback {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void onPageStarted(IExternalLiveWebCallback r100, WebView r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "webView");
        }

        public static /* synthetic */ void onReceivedError$default(IExternalLiveWebCallback r100, WebView r101, String r102, String r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L6;
            r103 = "";
        L6:
            r100.onReceivedError(r101, r102, r103);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onReceivedError");
        }
    }

    void onPageFinished(WebView r100, String r101);

    void onPageStarted(WebView r100, String r101);

    void onReceivedError(WebView r100, String r101, String r102);
}
