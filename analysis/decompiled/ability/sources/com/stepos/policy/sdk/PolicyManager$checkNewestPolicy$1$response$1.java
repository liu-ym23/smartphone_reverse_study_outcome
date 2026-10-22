package com.stepos.policy.sdk;

import C7.r;
import com.stepos.policy.sdk.api.PolicyApiService;
import com.stepos.policy.sdk.net.PolicySdkRetrofitHelper;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import m9.InterfaceC1733z;

@J7.c(c = "com.stepos.policy.sdk.PolicyManager$checkNewestPolicy$1$response$1", f = "PolicyManager.kt", l = {1608}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lqa/L;", "Lcom/stepos/policy/sdk/bean/PolicyNewestResponse;", "<anonymous>", "(Lm9/z;)Lqa/L;"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes3.dex */
final class PolicyManager$checkNewestPolicy$1$response$1 extends SuspendLambda implements S7.n {

    /* renamed from: a, reason: collision with root package name */
    public int f3896a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Ref$ObjectRef c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Ref$LongRef e;
    public final /* synthetic */ String f;
    public final /* synthetic */ Ref$ObjectRef g;
    public final /* synthetic */ String h;
    public final /* synthetic */ Ref$ObjectRef i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicyManager$checkNewestPolicy$1$response$1(String str, Ref$ObjectRef ref$ObjectRef, String str2, Ref$LongRef ref$LongRef, String str3, Ref$ObjectRef ref$ObjectRef2, String str4, Ref$ObjectRef ref$ObjectRef3, H7.c cVar) {
        super(2, cVar);
        this.b = str;
        this.c = ref$ObjectRef;
        this.d = str2;
        this.e = ref$LongRef;
        this.f = str3;
        this.g = ref$ObjectRef2;
        this.h = str4;
        this.i = ref$ObjectRef3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new PolicyManager$checkNewestPolicy$1$response$1(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((PolicyManager$checkNewestPolicy$1$response$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f3896a;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            return obj;
        }
        kotlin.b.b(obj);
        PolicyApiService policyApiService = new PolicyApiService(PolicySdkRetrofitHelper.INSTANCE.getApiService());
        String str = (String) this.c.f4920a;
        long j5 = this.e.f4919a;
        long jLongValue = ((Number) this.g.f4920a).longValue();
        PolicyManager policyManager = PolicyManager.INSTANCE;
        String brand = policyManager.getBrand();
        String model = policyManager.getModel();
        String osVersion = policyManager.getOsVersion();
        String str2 = (String) this.i.f4920a;
        this.f3896a = 1;
        Object policyUsingGET = policyApiService.getPolicyUsingGET(this.b, str, this.d, j5, this.f, jLongValue, brand, model, osVersion, this.h, str2, this);
        return policyUsingGET == coroutineSingletons ? coroutineSingletons : policyUsingGET;
    }
}
