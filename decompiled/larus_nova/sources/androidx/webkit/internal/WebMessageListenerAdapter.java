package androidx.webkit.internal;

import android.net.Uri;
import android.webkit.WebView;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import java.lang.reflect.InvocationHandler;
import nvc.a;
import org.chromium.support_lib_boundary.WebMessageBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessageListenerBoundaryInterface;

/* JADX INFO: loaded from: classes17.dex */
public class WebMessageListenerAdapter implements WebMessageListenerBoundaryInterface {
    private WebViewCompat.WebMessageListener mWebMessageListener;

    @Override // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
    public String[] getSupportedFeatures() {
        return new String[]{WebViewFeature.WEB_MESSAGE_LISTENER};
    }

    public WebMessageListenerAdapter(WebViewCompat.WebMessageListener r100) {
        this.mWebMessageListener = r100;
    }

    @Override // org.chromium.support_lib_boundary.WebMessageListenerBoundaryInterface
    public void onPostMessage(WebView r100, InvocationHandler r101, Uri r102, boolean r110, InvocationHandler r111) {
        WebMessageCompat r103 = WebMessageAdapter.webMessageCompatFromBoundaryInterface((WebMessageBoundaryInterface) a.a(WebMessageBoundaryInterface.class, r101));
        JavaScriptReplyProxyImpl r104 = JavaScriptReplyProxyImpl.forInvocationHandler(r111);
        this.mWebMessageListener.onPostMessage(r100, r103, r102, r110, r104);
    }
}
