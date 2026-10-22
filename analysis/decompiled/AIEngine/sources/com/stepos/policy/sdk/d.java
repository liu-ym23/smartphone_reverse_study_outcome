package com.stepos.policy.sdk;

import com.stepos.policy.sdk.PolicySdk;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7971a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PolicySdk.PolicySdkCallback f7972b;

    public /* synthetic */ d(PolicySdk.PolicySdkCallback policySdkCallback, int i10) {
        this.f7971a = i10;
        this.f7972b = policySdkCallback;
    }

    @Override // zb.l
    public final Object invoke(Object obj) {
        int i10 = this.f7971a;
        PolicySdk.PolicySdkCallback policySdkCallback = this.f7972b;
        PolicySdkResultBean policySdkResultBean = (PolicySdkResultBean) obj;
        switch (i10) {
            case 0:
                return PolicySdk.lambda$withdrawalCleanCustomUploadRecord$5(policySdkCallback, policySdkResultBean);
            case 1:
                return PolicySdk.lambda$uploadRecordWithoutSecureService$8(policySdkCallback, policySdkResultBean);
            case 2:
                return PolicySdk.lambda$withdrawalCleanUploadRecordByAccountValidateCode$6(policySdkCallback, policySdkResultBean);
            case 3:
                return PolicySdk.lambda$getPolicy$4(policySdkCallback, policySdkResultBean);
            default:
                return PolicySdk.lambda$getPolicyByVersion$2(policySdkCallback, policySdkResultBean);
        }
    }
}
