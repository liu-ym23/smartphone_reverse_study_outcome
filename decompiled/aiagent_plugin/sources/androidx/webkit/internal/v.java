package androidx.webkit.internal;

import android.webkit.SafeBrowsingResponse;
import android.webkit.WebMessagePort;
import android.webkit.WebResourceError;
import android.webkit.WebSettings;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

/* JADX INFO: compiled from: WebkitToCompatConverter.java */
/* JADX INFO: loaded from: classes.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WebkitToCompatConverterBoundaryInterface f3013a;

    public v(WebkitToCompatConverterBoundaryInterface r3) {
        this.f3013a = (WebkitToCompatConverterBoundaryInterface) ZeusTransformUtils.wrapperContextForParams(r3, WebkitToCompatConverterBoundaryInterface.class, "com.obric.aiagent.plugin");
    }

    public o a(WebSettings r3) {
        return new o((WebSettingsBoundaryInterface) ZeusTransformUtils.preCheckCast(org.chromium.support_lib_boundary.a.a.a(WebSettingsBoundaryInterface.class, this.f3013a.convertSettings(r3)), WebSettingsBoundaryInterface.class, "com.obric.aiagent.plugin"));
    }

    public InvocationHandler a(WebResourceError r1) {
        return this.f3013a.convertWebResourceError(r1);
    }

    public WebResourceError a(InvocationHandler r3) {
        InvocationHandler r4 = (InvocationHandler) ZeusTransformUtils.wrapperContextForParams(r3, InvocationHandler.class, "com.obric.aiagent.plugin");
        return (WebResourceError) ZeusTransformUtils.preCheckCast(this.f3013a.convertWebResourceError(r4), WebResourceError.class, "com.obric.aiagent.plugin");
    }

    public InvocationHandler a(SafeBrowsingResponse r1) {
        return this.f3013a.convertSafeBrowsingResponse(r1);
    }

    public SafeBrowsingResponse b(InvocationHandler r3) {
        InvocationHandler r4 = (InvocationHandler) ZeusTransformUtils.wrapperContextForParams(r3, InvocationHandler.class, "com.obric.aiagent.plugin");
        return (SafeBrowsingResponse) ZeusTransformUtils.preCheckCast(this.f3013a.convertSafeBrowsingResponse(r4), SafeBrowsingResponse.class, "com.obric.aiagent.plugin");
    }

    public WebMessagePort c(InvocationHandler r3) {
        InvocationHandler r4 = (InvocationHandler) ZeusTransformUtils.wrapperContextForParams(r3, InvocationHandler.class, "com.obric.aiagent.plugin");
        return (WebMessagePort) ZeusTransformUtils.preCheckCast(this.f3013a.convertWebMessagePort(r4), WebMessagePort.class, "com.obric.aiagent.plugin");
    }
}
