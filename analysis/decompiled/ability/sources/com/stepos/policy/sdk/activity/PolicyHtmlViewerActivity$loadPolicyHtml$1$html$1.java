package com.stepos.policy.sdk.activity;

import C7.r;
import J7.c;
import S7.n;
import com.stepos.policy.sdk.util.PolicyHtmlLoader;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1", f = "PolicyHtmlViewerActivity.kt", l = {}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "", "<anonymous>", "(Lm9/z;)Ljava/lang/String;"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1 extends SuspendLambda implements n {
    final /* synthetic */ String $uri;
    int label;
    final /* synthetic */ PolicyHtmlViewerActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1(PolicyHtmlViewerActivity policyHtmlViewerActivity, String str, H7.c<? super PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1> cVar) {
        super(2, cVar);
        this.this$0 = policyHtmlViewerActivity;
        this.$uri = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1(this.this$0, this.$uri, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        b.b(obj);
        return PolicyHtmlLoader.loadHtml(this.this$0, this.$uri);
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super String> cVar) {
        return ((PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
