package com.stepos.policy.sdk.activity;

import Ua.M;
import Y8.t;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {1, 8, 0})
@InterfaceC4112d(c = "com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity$fetchOnlinePolicy$1$getResult$1", f = "PolicyHtmlViewerActivity.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class PolicyHtmlViewerActivity$fetchOnlinePolicy$1$getResult$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ String $category;
    final /* synthetic */ PolicySdkResultBean $policySdkResultBean;
    int label;
    final /* synthetic */ PolicyHtmlViewerActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicyHtmlViewerActivity$fetchOnlinePolicy$1$getResult$1(PolicyHtmlViewerActivity policyHtmlViewerActivity, PolicySdkResultBean policySdkResultBean, String str, InterfaceC4014c<? super PolicyHtmlViewerActivity$fetchOnlinePolicy$1$getResult$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = policyHtmlViewerActivity;
        this.$policySdkResultBean = policySdkResultBean;
        this.$category = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new PolicyHtmlViewerActivity$fetchOnlinePolicy$1$getResult$1(this.this$0, this.$policySdkResultBean, this.$category, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((PolicyHtmlViewerActivity$fetchOnlinePolicy$1$getResult$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String policyUrl;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        this.this$0.hideProgress();
        PolicySdkResultBean policySdkResultBean = this.$policySdkResultBean;
        if (policySdkResultBean == null || policySdkResultBean.getCode() != 0 || (policyUrl = this.$policySdkResultBean.getPolicyUrl()) == null || policyUrl.length() == 0) {
            this.this$0.tryLoadLocalPolicy(this.$category);
        } else {
            this.this$0.loadPolicyHtml(policyUrl);
        }
        return t.f7040a;
    }
}
