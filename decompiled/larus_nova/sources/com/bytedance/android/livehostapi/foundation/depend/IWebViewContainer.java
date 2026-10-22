package com.bytedance.android.livehostapi.foundation.depend;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH&J\u0012\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\u0012\u0010\u0010\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0011H&J\u0012\u0010\u0012\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0013H&¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/foundation/depend/IWebViewContainer;", "", "getContainerView", "Landroid/view/View;", "getWebView", "Landroid/webkit/WebView;", "init", "", "args", "Landroid/os/Bundle;", "loadUrl", "url", "", "setOnPageLoadListener", "listener", "Lcom/bytedance/android/livehostapi/foundation/depend/ILivePageLoadListener;", "setOnScrollStateChangeListener", "Lcom/bytedance/android/livehostapi/foundation/depend/IWebScrollStateChangeListener;", "setOnTouchListener", "Landroid/view/View$OnTouchListener;", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IWebViewContainer {
    View getContainerView();

    WebView getWebView();

    void init(Bundle r100);

    void loadUrl(String r100);

    void setOnPageLoadListener(ILivePageLoadListener r100);

    void setOnScrollStateChangeListener(IWebScrollStateChangeListener r100);

    void setOnTouchListener(View.OnTouchListener r100);
}
