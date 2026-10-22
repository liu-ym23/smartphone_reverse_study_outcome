package androidx.webkit.internal;

import android.webkit.WebView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.chromium.support_lib_boundary.DropDataContentProviderBoundaryInterface;
import org.chromium.support_lib_boundary.ProfileStoreBoundaryInterface;
import org.chromium.support_lib_boundary.StaticsBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

/* JADX INFO: compiled from: WebViewProviderFactoryAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class t implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final WebViewProviderFactoryBoundaryInterface f3010a;

    public t(WebViewProviderFactoryBoundaryInterface r3) {
        this.f3010a = (WebViewProviderFactoryBoundaryInterface) ZeusTransformUtils.wrapperContextForParams(r3, WebViewProviderFactoryBoundaryInterface.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.webkit.internal.s
    public WebViewProviderBoundaryInterface a(WebView r2) {
        return (WebViewProviderBoundaryInterface) ZeusTransformUtils.preCheckCast(org.chromium.support_lib_boundary.a.a.a(WebViewProviderBoundaryInterface.class, this.f3010a.createWebView(r2)), WebViewProviderBoundaryInterface.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.webkit.internal.s
    public WebkitToCompatConverterBoundaryInterface a() {
        return (WebkitToCompatConverterBoundaryInterface) ZeusTransformUtils.preCheckCast(org.chromium.support_lib_boundary.a.a.a(WebkitToCompatConverterBoundaryInterface.class, this.f3010a.getWebkitToCompatConverter()), WebkitToCompatConverterBoundaryInterface.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.webkit.internal.s
    public StaticsBoundaryInterface b() {
        return (StaticsBoundaryInterface) ZeusTransformUtils.preCheckCast(org.chromium.support_lib_boundary.a.a.a(StaticsBoundaryInterface.class, this.f3010a.getStatics()), StaticsBoundaryInterface.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.webkit.internal.s
    public String[] c() {
        return this.f3010a.getSupportedFeatures();
    }

    @Override // androidx.webkit.internal.s
    public DropDataContentProviderBoundaryInterface d() {
        return (DropDataContentProviderBoundaryInterface) ZeusTransformUtils.preCheckCast(org.chromium.support_lib_boundary.a.a.a(DropDataContentProviderBoundaryInterface.class, this.f3010a.getDropDataProvider()), DropDataContentProviderBoundaryInterface.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.webkit.internal.s
    public ProfileStoreBoundaryInterface e() {
        return (ProfileStoreBoundaryInterface) ZeusTransformUtils.preCheckCast(org.chromium.support_lib_boundary.a.a.a(ProfileStoreBoundaryInterface.class, this.f3010a.getProfileStore()), ProfileStoreBoundaryInterface.class, "com.obric.aiagent.plugin");
    }
}
