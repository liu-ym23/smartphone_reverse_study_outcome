package com.stepos.policy.sdk.activity;

import V3.v;
import i4.p;
import j4.k;
import j4.l;

/* loaded from: classes.dex */
final class PolicyHtmlViewerActivity$displayHtml$1$1 extends l implements p<String, String, v> {
    final /* synthetic */ PolicyHtmlViewerActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PolicyHtmlViewerActivity$displayHtml$1$1(PolicyHtmlViewerActivity policyHtmlViewerActivity) {
        super(2);
        this.this$0 = policyHtmlViewerActivity;
    }

    @Override // i4.p
    public /* bridge */ /* synthetic */ v invoke(String str, String str2) {
        invoke2(str, str2);
        return v.f5542a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str, String str2) {
        k.g(str, "url");
        this.this$0.openPolicyLink(str, str2);
    }
}
