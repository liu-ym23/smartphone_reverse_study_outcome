package com.stepos.policy.sdk;

import com.stepos.policy.sdk.PolicySdk;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;

/* loaded from: classes3.dex */
public final /* synthetic */ class n implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3955a;
    public final /* synthetic */ PolicySdk.PolicySdkCallback b;

    public /* synthetic */ n(PolicySdk.PolicySdkCallback policySdkCallback, int i) {
        this.f3955a = i;
        this.b = policySdkCallback;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        int i = this.f3955a;
        PolicySdk.PolicySdkCallback policySdkCallback = this.b;
        PolicySdkResultBean policySdkResultBean = (PolicySdkResultBean) obj;
        switch (i) {
            case 0:
                return PolicySdk.lambda$withdrawalCleanCustomUploadRecord$5(policySdkCallback, policySdkResultBean);
            case 1:
                return PolicySdk.lambda$getDeleteInfoWithoutSecureService$7(policySdkCallback, policySdkResultBean);
            case 2:
                return PolicySdk.lambda$uploadRecordWithoutSecureService$8(policySdkCallback, policySdkResultBean);
            case 3:
                return PolicySdk.lambda$getPolicyHistoryList$3(policySdkCallback, policySdkResultBean);
            case 4:
                return PolicySdk.lambda$withdrawalCleanUploadRecordByAccountValidateCode$6(policySdkCallback, policySdkResultBean);
            case 5:
                return PolicySdk.lambda$uploadPolicyOperateRecord$1(policySdkCallback, policySdkResultBean);
            case 6:
                return PolicySdk.lambda$getPolicy$4(policySdkCallback, policySdkResultBean);
            case 7:
                return PolicySdk.lambda$checkNewestPolicy$0(policySdkCallback, policySdkResultBean);
            default:
                return PolicySdk.lambda$getPolicyByVersion$2(policySdkCallback, policySdkResultBean);
        }
    }
}
