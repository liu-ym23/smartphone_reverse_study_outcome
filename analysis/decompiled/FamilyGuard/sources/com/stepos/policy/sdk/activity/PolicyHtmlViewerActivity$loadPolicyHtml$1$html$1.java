package com.stepos.policy.sdk.activity;

import V3.o;
import V3.v;
import Z3.e;
import a4.C0428b;
import com.stepos.policy.sdk.util.PolicyHtmlLoader;
import i4.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import s4.I;

@f(c = "com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1", f = "PolicyHtmlViewerActivity.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1 extends l implements p<I, e<? super String>, Object> {
    final /* synthetic */ String $uri;
    int label;
    final /* synthetic */ PolicyHtmlViewerActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1(PolicyHtmlViewerActivity policyHtmlViewerActivity, String str, e<? super PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1> eVar) {
        super(2, eVar);
        this.this$0 = policyHtmlViewerActivity;
        this.$uri = str;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final e<v> create(Object obj, e<?> eVar) {
        return new PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1(this.this$0, this.$uri, eVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        C0428b.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        o.b(obj);
        return PolicyHtmlLoader.loadHtml(this.this$0, this.$uri);
    }

    @Override // i4.p
    public final Object invoke(I i5, e<? super String> eVar) {
        return ((PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1) create(i5, eVar)).invokeSuspend(v.f5542a);
    }
}
