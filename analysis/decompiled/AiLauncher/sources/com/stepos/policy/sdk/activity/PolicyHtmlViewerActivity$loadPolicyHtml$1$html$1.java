package com.stepos.policy.sdk.activity;

import Ua.M;
import Y8.t;
import com.stepos.policy.sdk.util.PolicyHtmlLoader;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Ljava/lang/String;"}, k = 3, mv = {1, 8, 0})
@InterfaceC4112d(c = "com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1", f = "PolicyHtmlViewerActivity.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super String>, Object> {
    final /* synthetic */ String $uri;
    int label;
    final /* synthetic */ PolicyHtmlViewerActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1(PolicyHtmlViewerActivity policyHtmlViewerActivity, String str, InterfaceC4014c<? super PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = policyHtmlViewerActivity;
        this.$uri = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1(this.this$0, this.$uri, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super String> interfaceC4014c) {
        return ((PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        return PolicyHtmlLoader.loadHtml(this.this$0, this.$uri);
    }
}
