package org.chromium.support_lib_boundary;

import android.net.Uri;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import java.lang.reflect.InvocationHandler;

/* JADX INFO: loaded from: classes5.dex */
public interface WebViewProviderBoundaryInterface {
    InvocationHandler addDocumentStartJavaScript(String r1, String[] r2);

    void addWebMessageListener(String r1, String[] r2, InvocationHandler r3);

    InvocationHandler[] createWebMessageChannel();

    InvocationHandler getProfile();

    WebChromeClient getWebChromeClient();

    WebViewClient getWebViewClient();

    InvocationHandler getWebViewRenderer();

    InvocationHandler getWebViewRendererClient();

    void insertVisualStateCallback(long r1, InvocationHandler r3);

    boolean isAudioMuted();

    void postMessageToMainFrame(InvocationHandler r1, Uri r2);

    void removeWebMessageListener(String r1);

    void setAudioMuted(boolean r1);

    void setProfile(String r1);

    void setWebViewRendererClient(InvocationHandler r1);
}
