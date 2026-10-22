package com.stepos.policy.sdk;

import com.stepos.policy.sdk.api.PolicyApiService;
import com.stepos.policy.sdk.bean.PolicyServiceConfigResponse;
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
@rb.c(c = "com.stepos.policy.sdk.PolicyManager$getPolicyServiceConfig$1$response$1", f = "PolicyManager.kt", l = {2635}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class PolicyManager$getPolicyServiceConfig$1$response$1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super r<PolicyServiceConfigResponse>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f7819a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7820b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<String> f7821c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref$LongRef f7822d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f7823e;
    public final /* synthetic */ String h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicyManager$getPolicyServiceConfig$1$response$1(String str, Ref$ObjectRef<String> ref$ObjectRef, Ref$LongRef ref$LongRef, String str2, String str3, qb.b<? super PolicyManager$getPolicyServiceConfig$1$response$1> bVar) {
        super(2, bVar);
        this.f7820b = str;
        this.f7821c = ref$ObjectRef;
        this.f7822d = ref$LongRef;
        this.f7823e = str2;
        this.h = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        return new PolicyManager$getPolicyServiceConfig$1$response$1(this.f7820b, this.f7821c, this.f7822d, this.f7823e, this.h, bVar);
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super r<PolicyServiceConfigResponse>> bVar) {
        return ((PolicyManager$getPolicyServiceConfig$1$response$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f7819a;
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
        String str = this.f7821c.f10076a;
        long j10 = this.f7822d.f10075a;
        PolicyManager policyManager = PolicyManager.INSTANCE;
        String brand = policyManager.getBrand();
        String model = policyManager.getModel();
        String osVersion = policyManager.getOsVersion();
        this.f7819a = 1;
        Object serviceConfig = policyApiService.getServiceConfig(this.f7820b, str, j10, this.f7823e, brand, model, osVersion, this.h, this);
        return serviceConfig == coroutineSingletons ? coroutineSingletons : serviceConfig;
    }
}
