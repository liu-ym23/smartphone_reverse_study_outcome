package com.stepos.policy.sdk;

import com.stepos.policy.sdk.PolicySdk;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import kotlin.jvm.functions.Function1;

/* renamed from: com.stepos.policy.sdk.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0516o implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12235a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PolicySdk.PolicySdkCallback f12236b;

    public /* synthetic */ C0516o(PolicySdk.PolicySdkCallback policySdkCallback, int i4) {
        this.f12235a = i4;
        this.f12236b = policySdkCallback;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i4 = this.f12235a;
        PolicySdk.PolicySdkCallback policySdkCallback = this.f12236b;
        PolicySdkResultBean policySdkResultBean = (PolicySdkResultBean) obj;
        switch (i4) {
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
