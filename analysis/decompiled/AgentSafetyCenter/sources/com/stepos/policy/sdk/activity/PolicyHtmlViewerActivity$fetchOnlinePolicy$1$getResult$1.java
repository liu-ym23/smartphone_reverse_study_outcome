package com.stepos.policy.sdk.activity;

import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import jb.v;
import kc.t;
import nb.c;
import od.f;
import pb.e;
import pb.i;
import xb.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@e(c = "com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity$fetchOnlinePolicy$1$getResult$1", f = "PolicyHtmlViewerActivity.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class PolicyHtmlViewerActivity$fetchOnlinePolicy$1$getResult$1 extends i implements p {
    final /* synthetic */ String $category;
    final /* synthetic */ PolicySdkResultBean $policySdkResultBean;
    int label;
    final /* synthetic */ PolicyHtmlViewerActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicyHtmlViewerActivity$fetchOnlinePolicy$1$getResult$1(PolicyHtmlViewerActivity policyHtmlViewerActivity, PolicySdkResultBean policySdkResultBean, String str, c cVar) {
        super(2, cVar);
        this.this$0 = policyHtmlViewerActivity;
        this.$policySdkResultBean = policySdkResultBean;
        this.$category = str;
    }

    @Override // pb.a
    public final c create(Object obj, c cVar) {
        return new PolicyHtmlViewerActivity$fetchOnlinePolicy$1$getResult$1(this.this$0, this.$policySdkResultBean, this.$category, cVar);
    }

    @Override // xb.p
    public final Object invoke(t tVar, c cVar) {
        return ((PolicyHtmlViewerActivity$fetchOnlinePolicy$1$getResult$1) create(tVar, cVar)).invokeSuspend(v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        String policyUrl;
        ob.a aVar = ob.a.f9351c;
        if (this.label != 0) {
            f.e("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        id.c.I(obj);
        this.this$0.hideProgress();
        PolicySdkResultBean policySdkResultBean = this.$policySdkResultBean;
        if (policySdkResultBean == null || policySdkResultBean.getCode() != 0 || (policyUrl = this.$policySdkResultBean.getPolicyUrl()) == null || policyUrl.length() == 0) {
            this.this$0.tryLoadLocalPolicy(this.$category);
        } else {
            this.this$0.loadPolicyHtml(policyUrl);
        }
        return v.f6774a;
    }
}
