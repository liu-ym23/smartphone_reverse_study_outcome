package androidx.webkit.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: compiled from: WebSettingsAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WebSettingsBoundaryInterface f2999a;

    public o(WebSettingsBoundaryInterface r3) {
        this.f2999a = (WebSettingsBoundaryInterface) ZeusTransformUtils.wrapperContextForParams(r3, WebSettingsBoundaryInterface.class, "com.obric.aiagent.plugin");
    }

    public void a(boolean r1) {
        this.f2999a.setEnterpriseAuthenticationAppLinkPolicyEnabled(r1);
    }

    public boolean a() {
        return this.f2999a.getEnterpriseAuthenticationAppLinkPolicyEnabled();
    }
}
