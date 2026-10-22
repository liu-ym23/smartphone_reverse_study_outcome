package com.stepos.policy.sdk.activity;

import jb.v;
import xb.p;
import yb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PolicyHtmlViewerActivity$displayHtml$1$1 extends l implements p {
    final /* synthetic */ PolicyHtmlViewerActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicyHtmlViewerActivity$displayHtml$1$1(PolicyHtmlViewerActivity policyHtmlViewerActivity) {
        super(2);
        this.this$0 = policyHtmlViewerActivity;
    }

    public final void invoke(String str, String str2) {
        str.getClass();
        PolicyHtmlViewerActivity.Companion.start(this.this$0, str, str2);
    }

    @Override // xb.p
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (String) obj2);
        return v.f6774a;
    }
}
