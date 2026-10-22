package com.stepos.policy.sdk;

import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
public final class X extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f12072a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public X(Function1 function1) {
        super(1);
        this.f12072a = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        PolicySdkResultBean policySdkResultBean = (PolicySdkResultBean) obj;
        Intrinsics.checkNotNullParameter(policySdkResultBean, "policySdkResultBean");
        PolicySdkLogUtils.INSTANCE.d("uploadRecordToCleanServiceData", "policySdkResultBean.code " + policySdkResultBean.getCode());
        this.f12072a.invoke(policySdkResultBean);
        return Unit.INSTANCE;
    }
}
