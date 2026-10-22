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
@e(c = "com.stepos.policy.sdk.PolicyManager$getPolicyHistoryList$1$response$1", f = "PolicyManager.kt", l = {2164}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class PolicyManager$getPolicyHistoryList$1$response$1 extends i implements p {
    final /* synthetic */ String $appId;
    final /* synthetic */ u $appSign;
    final /* synthetic */ String $category;
    final /* synthetic */ t $eqTime;
    final /* synthetic */ String $language;
    final /* synthetic */ long $version;
    final /* synthetic */ String $versionName;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicyManager$getPolicyHistoryList$1$response$1(String str, u uVar, String str2, t tVar, String str3, long j10, String str4, c cVar) {
        super(2, cVar);
        this.$appId = str;
        this.$appSign = uVar;
        this.$category = str2;
        this.$eqTime = tVar;
        this.$language = str3;
        this.$version = j10;
        this.$versionName = str4;
    }

    @Override // pb.a
    public final c create(Object obj, c cVar) {
        return new PolicyManager$getPolicyHistoryList$1$response$1(this.$appId, this.$appSign, this.$category, this.$eqTime, this.$language, this.$version, this.$versionName, cVar);
    }

    @Override // xb.p
    public final Object invoke(kc.t tVar, c cVar) {
        return ((PolicyManager$getPolicyHistoryList$1$response$1) create(tVar, cVar)).invokeSuspend(v.f6774a);
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
        String str3 = this.$category;
        long j10 = this.$eqTime.f16097c;
        String str4 = this.$language;
        long j11 = this.$version;
        PolicyManager policyManager = PolicyManager.INSTANCE;
        String brand = policyManager.getBrand();
        String model = policyManager.getModel();
        String osVersion = policyManager.getOsVersion();
        String str5 = this.$versionName;
        this.label = 1;
        Object objPolicyHistoryListUsingGET = policyApiService.policyHistoryListUsingGET(str, str2, str3, j10, str4, j11, brand, model, osVersion, str5, this);
        return objPolicyHistoryListUsingGET == aVar ? aVar : objPolicyHistoryListUsingGET;
    }
}
