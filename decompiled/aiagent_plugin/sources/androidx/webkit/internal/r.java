package androidx.webkit.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;

/* JADX INFO: compiled from: WebViewProviderAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    WebViewProviderBoundaryInterface f3009a;

    public r(WebViewProviderBoundaryInterface r3) {
        this.f3009a = (WebViewProviderBoundaryInterface) ZeusTransformUtils.wrapperContextForParams(r3, WebViewProviderBoundaryInterface.class, "com.obric.aiagent.plugin");
    }

    public void a(String r1) {
        this.f3009a.setProfile(r1);
    }
}
