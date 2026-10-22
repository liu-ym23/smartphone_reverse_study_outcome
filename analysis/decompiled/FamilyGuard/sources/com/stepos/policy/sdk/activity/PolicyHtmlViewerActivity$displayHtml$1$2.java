package com.stepos.policy.sdk.activity;

import V3.v;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import i4.InterfaceC0772l;
import j4.k;
import j4.l;

/* loaded from: classes.dex */
final class PolicyHtmlViewerActivity$displayHtml$1$2 extends l implements InterfaceC0772l<String, v> {
    final /* synthetic */ PolicyHtmlViewerActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PolicyHtmlViewerActivity$displayHtml$1$2(PolicyHtmlViewerActivity policyHtmlViewerActivity) {
        super(1);
        this.this$0 = policyHtmlViewerActivity;
    }

    @Override // i4.InterfaceC0772l
    public /* bridge */ /* synthetic */ v invoke(String str) {
        invoke2(str);
        return v.f5542a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        k.g(str, "url");
        PolicySdkToolsUtils.Companion.startBrowser(this.this$0, str);
    }
}
