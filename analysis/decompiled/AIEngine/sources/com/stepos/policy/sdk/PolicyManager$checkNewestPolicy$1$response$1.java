package com.stepos.policy.sdk;

import com.stepos.policy.sdk.api.PolicyApiService;
import com.stepos.policy.sdk.bean.PolicyNewestResponse;
import com.stepos.policy.sdk.net.PolicySdkRetrofitHelper;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import xd.r;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.policy.sdk.PolicyManager$checkNewestPolicy$1$response$1", f = "PolicyManager.kt", l = {1611}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class PolicyManager$checkNewestPolicy$1$response$1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super r<PolicyNewestResponse>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f7718a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7719b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<String> f7720c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f7721d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Ref$LongRef f7722e;
    public final /* synthetic */ String h;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<Long> f7723j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f7724k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<String> f7725l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicyManager$checkNewestPolicy$1$response$1(String str, Ref$ObjectRef<String> ref$ObjectRef, String str2, Ref$LongRef ref$LongRef, String str3, Ref$ObjectRef<Long> ref$ObjectRef2, String str4, Ref$ObjectRef<String> ref$ObjectRef3, qb.b<? super PolicyManager$checkNewestPolicy$1$response$1> bVar) {
        super(2, bVar);
        this.f7719b = str;
        this.f7720c = ref$ObjectRef;
        this.f7721d = str2;
        this.f7722e = ref$LongRef;
        this.h = str3;
        this.f7723j = ref$ObjectRef2;
        this.f7724k = str4;
        this.f7725l = ref$ObjectRef3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        return new PolicyManager$checkNewestPolicy$1$response$1(this.f7719b, this.f7720c, this.f7721d, this.f7722e, this.h, this.f7723j, this.f7724k, this.f7725l, bVar);
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super r<PolicyNewestResponse>> bVar) {
        return ((PolicyManager$checkNewestPolicy$1$response$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f7718a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            return obj;
        }
        kotlin.c.b(obj);
        PolicyApiService policyApiService = new PolicyApiService(PolicySdkRetrofitHelper.INSTANCE.getApiService());
        String str = this.f7720c.f10076a;
        long j10 = this.f7722e.f10075a;
        long jLongValue = this.f7723j.f10076a.longValue();
        PolicyManager policyManager = PolicyManager.INSTANCE;
        String brand = policyManager.getBrand();
        String model = policyManager.getModel();
        String osVersion = policyManager.getOsVersion();
        String str2 = this.f7725l.f10076a;
        this.f7718a = 1;
        Object policyUsingGET = policyApiService.getPolicyUsingGET(this.f7719b, str, this.f7721d, j10, this.h, jLongValue, brand, model, osVersion, this.f7724k, str2, this);
        return policyUsingGET == coroutineSingletons ? coroutineSingletons : policyUsingGET;
    }
}
