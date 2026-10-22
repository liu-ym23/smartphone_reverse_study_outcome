package com.stepos.policy.sdk.activity;

import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import jb.v;
import yb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PolicyHtmlViewerActivity$displayHtml$1$2 extends l implements xb.l {
    final /* synthetic */ PolicyHtmlViewerActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicyHtmlViewerActivity$displayHtml$1$2(PolicyHtmlViewerActivity policyHtmlViewerActivity) {
        super(1);
        this.this$0 = policyHtmlViewerActivity;
    }

    public final void invoke(String str) {
        str.getClass();
        PolicySdkToolsUtils.Companion.startBrowser(this.this$0, str);
    }

    @Override // xb.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return v.f6774a;
    }
}
