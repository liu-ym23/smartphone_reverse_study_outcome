package com.stepos.policy.sdk;

import com.stepos.policy.sdk.api.PolicyApiService;
import com.stepos.policy.sdk.net.PolicySdkRetrofitHelper;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import jb.v;
import nb.c;
import od.f;
import pb.e;
import pb.i;
import xb.p;
import yb.t;
import yb.u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@e(c = "com.stepos.policy.sdk.PolicyManager$getPolicyServiceConfig$1$response$1", f = "PolicyManager.kt", l = {2536}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class PolicyManager$getPolicyServiceConfig$1$response$1 extends i implements p {
    final /* synthetic */ String $appId;
    final /* synthetic */ u $appSign;
    final /* synthetic */ t $eqTime;
    final /* synthetic */ String $language;
    final /* synthetic */ String $versionName;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicyManager$getPolicyServiceConfig$1$response$1(String str, u uVar, t tVar, String str2, String str3, c cVar) {
        super(2, cVar);
        this.$appId = str;
        this.$appSign = uVar;
        this.$eqTime = tVar;
        this.$language = str2;
        this.$versionName = str3;
    }

    @Override // pb.a
    public final c create(Object obj, c cVar) {
        return new PolicyManager$getPolicyServiceConfig$1$response$1(this.$appId, this.$appSign, this.$eqTime, this.$language, this.$versionName, cVar);
    }

    @Override // xb.p
    public final Object invoke(kc.t tVar, c cVar) {
        return ((PolicyManager$getPolicyServiceConfig$1$response$1) create(tVar, cVar)).invokeSuspend(v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        ob.a aVar = ob.a.f9351c;
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                id.c.I(obj);
                return obj;
            }
            f.e("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        id.c.I(obj);
        PolicySdkLogUtils.Companion.d("PolicyManager", "getPolicyUsingGET");
        PolicyApiService policyApiService = new PolicyApiService(PolicySdkRetrofitHelper.INSTANCE.getApiService());
        String str = this.$appId;
        String str2 = (String) this.$appSign.f16098c;
        long j10 = this.$eqTime.f16097c;
        String str3 = this.$language;
        PolicyManager policyManager = PolicyManager.INSTANCE;
        String brand = policyManager.getBrand();
        String model = policyManager.getModel();
        String osVersion = policyManager.getOsVersion();
        String str4 = this.$versionName;
        this.label = 1;
        Object serviceConfig = policyApiService.getServiceConfig(str, str2, j10, str3, brand, model, osVersion, str4, this);
        return serviceConfig == aVar ? aVar : serviceConfig;
    }
}
