package com.stepos.policy.sdk.activity;

import com.stepos.policy.sdk.util.PolicyHtmlLoader;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1", f = "PolicyHtmlViewerActivity.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super String>, Object> {
    final /* synthetic */ String $uri;
    int label;
    final /* synthetic */ PolicyHtmlViewerActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1(PolicyHtmlViewerActivity policyHtmlViewerActivity, String str, qb.b<? super PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1> bVar) {
        super(2, bVar);
        this.this$0 = policyHtmlViewerActivity;
        this.$uri = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        return new PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1(this.this$0, this.$uri, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.c.b(obj);
        return PolicyHtmlLoader.loadHtml(this.this$0, this.$uri);
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super String> bVar) {
        return ((PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
