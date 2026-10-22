package com.stepos.policy.sdk.activity;

import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity$fetchOnlinePolicy$1$getResult$1", f = "PolicyHtmlViewerActivity.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class PolicyHtmlViewerActivity$fetchOnlinePolicy$1$getResult$1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
    final /* synthetic */ String $category;
    final /* synthetic */ PolicySdkResultBean $policySdkResultBean;
    int label;
    final /* synthetic */ PolicyHtmlViewerActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicyHtmlViewerActivity$fetchOnlinePolicy$1$getResult$1(PolicyHtmlViewerActivity policyHtmlViewerActivity, PolicySdkResultBean policySdkResultBean, String str, qb.b<? super PolicyHtmlViewerActivity$fetchOnlinePolicy$1$getResult$1> bVar) {
        super(2, bVar);
        this.this$0 = policyHtmlViewerActivity;
        this.$policySdkResultBean = policySdkResultBean;
        this.$category = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        return new PolicyHtmlViewerActivity$fetchOnlinePolicy$1$getResult$1(this.this$0, this.$policySdkResultBean, this.$category, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String policyUrl;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.c.b(obj);
        this.this$0.hideProgress();
        PolicySdkResultBean policySdkResultBean = this.$policySdkResultBean;
        if (policySdkResultBean == null || policySdkResultBean.getCode() != 0 || (policyUrl = this.$policySdkResultBean.getPolicyUrl()) == null || policyUrl.length() == 0) {
            this.this$0.tryLoadLocalPolicy(this.$category);
        } else {
            this.this$0.loadPolicyHtml(policyUrl);
        }
        return n.f10413a;
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
        return ((PolicyHtmlViewerActivity$fetchOnlinePolicy$1$getResult$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
