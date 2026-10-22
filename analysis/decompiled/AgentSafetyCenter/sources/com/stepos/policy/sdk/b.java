package com.stepos.policy.sdk;

import com.stepos.policy.sdk.PolicySdk;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import xb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2785c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ PolicySdk.PolicySdkCallback f2786f;

    public /* synthetic */ b(int i) {
        this.f2785c = i;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        int i = this.f2785c;
        PolicySdk.PolicySdkCallback policySdkCallback = this.f2786f;
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
