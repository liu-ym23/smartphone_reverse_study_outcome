package com.stepos.policy.sdk.activity;

import V3.o;
import V3.v;
import Z3.e;
import a4.C0428b;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import i4.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import s4.I;

@f(c = "com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity$fetchOnlinePolicy$1$getResult$1", f = "PolicyHtmlViewerActivity.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class PolicyHtmlViewerActivity$fetchOnlinePolicy$1$getResult$1 extends l implements p<I, e<? super v>, Object> {
    final /* synthetic */ String $category;
    final /* synthetic */ PolicySdkResultBean $policySdkResultBean;
    int label;
    final /* synthetic */ PolicyHtmlViewerActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PolicyHtmlViewerActivity$fetchOnlinePolicy$1$getResult$1(PolicyHtmlViewerActivity policyHtmlViewerActivity, PolicySdkResultBean policySdkResultBean, String str, e<? super PolicyHtmlViewerActivity$fetchOnlinePolicy$1$getResult$1> eVar) {
        super(2, eVar);
        this.this$0 = policyHtmlViewerActivity;
        this.$policySdkResultBean = policySdkResultBean;
        this.$category = str;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final e<v> create(Object obj, e<?> eVar) {
        return new PolicyHtmlViewerActivity$fetchOnlinePolicy$1$getResult$1(this.this$0, this.$policySdkResultBean, this.$category, eVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        String policyUrl;
        C0428b.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        o.b(obj);
        this.this$0.hideProgress();
        PolicySdkResultBean policySdkResultBean = this.$policySdkResultBean;
        if (policySdkResultBean == null || policySdkResultBean.getCode() != 0 || (policyUrl = this.$policySdkResultBean.getPolicyUrl()) == null || policyUrl.length() == 0) {
            this.this$0.tryLoadLocalPolicy(this.$category);
        } else {
            this.this$0.loadPolicyHtml(policyUrl);
        }
        return v.f5542a;
    }

    @Override // i4.p
    public final Object invoke(I i5, e<? super v> eVar) {
        return ((PolicyHtmlViewerActivity$fetchOnlinePolicy$1$getResult$1) create(i5, eVar)).invokeSuspend(v.f5542a);
    }
}
