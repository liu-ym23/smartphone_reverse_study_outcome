package com.stepos.policy.sdk;

import C7.r;
import com.stepos.policy.sdk.api.PolicyApiService;
import com.stepos.policy.sdk.net.PolicySdkRetrofitHelper;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import m9.InterfaceC1733z;

@J7.c(c = "com.stepos.policy.sdk.PolicyManager$getPolicyByVersion$1$response$1", f = "PolicyManager.kt", l = {2316}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lqa/L;", "Lcom/stepos/policy/sdk/bean/PolicyVersionResponse;", "<anonymous>", "(Lm9/z;)Lqa/L;"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes3.dex */
final class PolicyManager$getPolicyByVersion$1$response$1 extends SuspendLambda implements S7.n {

    /* renamed from: a, reason: collision with root package name */
    public int f3904a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Ref$ObjectRef c;
    public final /* synthetic */ Ref$LongRef d;
    public final /* synthetic */ String e;
    public final /* synthetic */ Long f;
    public final /* synthetic */ String g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicyManager$getPolicyByVersion$1$response$1(String str, Ref$ObjectRef ref$ObjectRef, Ref$LongRef ref$LongRef, String str2, Long l, String str3, H7.c cVar) {
        super(2, cVar);
        this.b = str;
        this.c = ref$ObjectRef;
        this.d = ref$LongRef;
        this.e = str2;
        this.f = l;
        this.g = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new PolicyManager$getPolicyByVersion$1$response$1(this.b, this.c, this.d, this.e, this.f, this.g, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((PolicyManager$getPolicyByVersion$1$response$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f3904a;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            return obj;
        }
        kotlin.b.b(obj);
        PolicySdkLogUtils.INSTANCE.d("PolicyManager", "getPolicyUsingGET");
        PolicyApiService policyApiService = new PolicyApiService(PolicySdkRetrofitHelper.INSTANCE.getApiService());
        String str = (String) this.c.f4920a;
        long j5 = this.d.f4919a;
        long jLongValue = this.f.longValue();
        PolicyManager policyManager = PolicyManager.INSTANCE;
        String brand = policyManager.getBrand();
        String model = policyManager.getModel();
        String osVersion = policyManager.getOsVersion();
        this.f3904a = 1;
        Object objPolicyVersionInfoUsingGET = policyApiService.policyVersionInfoUsingGET(this.b, str, j5, this.e, jLongValue, brand, model, osVersion, this.g, this);
        return objPolicyVersionInfoUsingGET == coroutineSingletons ? coroutineSingletons : objPolicyVersionInfoUsingGET;
    }
}
