package com.stepos.policy.sdk.activity;

import i4.InterfaceC0772l;
import j4.k;
import j4.l;

/* loaded from: classes.dex */
final class PolicyHtmlViewerActivity$openPolicyLink$category$1 extends l implements InterfaceC0772l<String, Boolean> {
    final /* synthetic */ PolicyHtmlViewerActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PolicyHtmlViewerActivity$openPolicyLink$category$1(PolicyHtmlViewerActivity policyHtmlViewerActivity) {
        super(1);
        this.this$0 = policyHtmlViewerActivity;
    }

    @Override // i4.InterfaceC0772l
    public final Boolean invoke(String str) {
        k.g(str, "cat");
        return Boolean.valueOf(this.this$0.resolveLocalPolicyContentUri(str) != null);
    }
}
