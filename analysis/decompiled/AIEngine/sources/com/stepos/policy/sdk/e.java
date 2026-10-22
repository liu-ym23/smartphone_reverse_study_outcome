package com.stepos.policy.sdk;

import com.stepos.policy.sdk.PolicySdk;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7975a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PolicySdk.PolicySdkCallback f7976b;

    public /* synthetic */ e(PolicySdk.PolicySdkCallback policySdkCallback, int i10) {
        this.f7975a = i10;
        this.f7976b = policySdkCallback;
    }

    @Override // zb.l
    public final Object invoke(Object obj) {
        int i10 = this.f7975a;
        PolicySdk.PolicySdkCallback policySdkCallback = this.f7976b;
        PolicySdkResultBean policySdkResultBean = (PolicySdkResultBean) obj;
        switch (i10) {
            case 0:
                return PolicySdk.lambda$getDeleteInfoWithoutSecureService$7(policySdkCallback, policySdkResultBean);
            case 1:
                return PolicySdk.lambda$getPolicyHistoryList$3(policySdkCallback, policySdkResultBean);
            case 2:
                return PolicySdk.lambda$uploadPolicyOperateRecord$1(policySdkCallback, policySdkResultBean);
            default:
                return PolicySdk.lambda$checkNewestPolicy$0(policySdkCallback, policySdkResultBean);
        }
    }
}
