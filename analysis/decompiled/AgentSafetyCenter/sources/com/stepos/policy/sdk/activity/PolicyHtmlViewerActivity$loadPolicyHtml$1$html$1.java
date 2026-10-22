package com.stepos.policy.sdk.activity;

import com.stepos.policy.sdk.util.PolicyHtmlLoader;
import jb.v;
import kc.t;
import nb.c;
import od.f;
import pb.e;
import pb.i;
import xb.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@e(c = "com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1", f = "PolicyHtmlViewerActivity.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1 extends i implements p {
    final /* synthetic */ String $uri;
    int label;
    final /* synthetic */ PolicyHtmlViewerActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1(PolicyHtmlViewerActivity policyHtmlViewerActivity, String str, c cVar) {
        super(2, cVar);
        this.this$0 = policyHtmlViewerActivity;
        this.$uri = str;
    }

    @Override // pb.a
    public final c create(Object obj, c cVar) {
        return new PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1(this.this$0, this.$uri, cVar);
    }

    @Override // xb.p
    public final Object invoke(t tVar, c cVar) {
        return ((PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1) create(tVar, cVar)).invokeSuspend(v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        ob.a aVar = ob.a.f9351c;
        if (this.label == 0) {
            id.c.I(obj);
            return PolicyHtmlLoader.loadHtml(this.this$0, this.$uri);
        }
        f.e("call to 'resume' before 'invoke' with coroutine");
        return null;
    }
}
