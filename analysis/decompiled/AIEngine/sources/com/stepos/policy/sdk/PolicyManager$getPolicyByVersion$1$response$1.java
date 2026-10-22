package com.stepos.policy.sdk;

import com.stepos.policy.sdk.api.PolicyApiService;
import com.stepos.policy.sdk.bean.PolicyVersionResponse;
import com.stepos.policy.sdk.net.PolicySdkRetrofitHelper;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import xd.r;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.policy.sdk.PolicyManager$getPolicyByVersion$1$response$1", f = "PolicyManager.kt", l = {2337}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class PolicyManager$getPolicyByVersion$1$response$1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super r<PolicyVersionResponse>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f7773a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7774b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<String> f7775c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref$LongRef f7776d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f7777e;
    public final /* synthetic */ Long h;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f7778j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicyManager$getPolicyByVersion$1$response$1(String str, Ref$ObjectRef<String> ref$ObjectRef, Ref$LongRef ref$LongRef, String str2, Long l10, String str3, qb.b<? super PolicyManager$getPolicyByVersion$1$response$1> bVar) {
        super(2, bVar);
        this.f7774b = str;
        this.f7775c = ref$ObjectRef;
        this.f7776d = ref$LongRef;
        this.f7777e = str2;
        this.h = l10;
        this.f7778j = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        return new PolicyManager$getPolicyByVersion$1$response$1(this.f7774b, this.f7775c, this.f7776d, this.f7777e, this.h, this.f7778j, bVar);
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super r<PolicyVersionResponse>> bVar) {
        return ((PolicyManager$getPolicyByVersion$1$response$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f7773a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            return obj;
        }
        kotlin.c.b(obj);
        PolicySdkLogUtils.Companion.d("PolicyManager", "getPolicyUsingGET");
        PolicyApiService policyApiService = new PolicyApiService(PolicySdkRetrofitHelper.INSTANCE.getApiService());
        String str = this.f7775c.f10076a;
        long j10 = this.f7776d.f10075a;
        long jLongValue = this.h.longValue();
        PolicyManager policyManager = PolicyManager.INSTANCE;
        String brand = policyManager.getBrand();
        String model = policyManager.getModel();
        String osVersion = policyManager.getOsVersion();
        this.f7773a = 1;
        Object objPolicyVersionInfoUsingGET = policyApiService.policyVersionInfoUsingGET(this.f7774b, str, j10, this.f7777e, jLongValue, brand, model, osVersion, this.f7778j, this);
        return objPolicyVersionInfoUsingGET == coroutineSingletons ? coroutineSingletons : objPolicyVersionInfoUsingGET;
    }
}
