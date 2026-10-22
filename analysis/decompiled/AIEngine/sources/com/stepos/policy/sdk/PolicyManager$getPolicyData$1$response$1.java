package com.stepos.policy.sdk;

import com.stepos.policy.sdk.api.PolicyApiService;
import com.stepos.policy.sdk.bean.PolicyNewestResponse;
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
@rb.c(c = "com.stepos.policy.sdk.PolicyManager$getPolicyData$1$response$1", f = "PolicyManager.kt", l = {2150}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class PolicyManager$getPolicyData$1$response$1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super r<PolicyNewestResponse>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f7787a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7788b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<String> f7789c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f7790d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Ref$LongRef f7791e;
    public final /* synthetic */ String h;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Long f7792j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f7793k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicyManager$getPolicyData$1$response$1(String str, Ref$ObjectRef<String> ref$ObjectRef, String str2, Ref$LongRef ref$LongRef, String str3, Long l10, String str4, qb.b<? super PolicyManager$getPolicyData$1$response$1> bVar) {
        super(2, bVar);
        this.f7788b = str;
        this.f7789c = ref$ObjectRef;
        this.f7790d = str2;
        this.f7791e = ref$LongRef;
        this.h = str3;
        this.f7792j = l10;
        this.f7793k = str4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        return new PolicyManager$getPolicyData$1$response$1(this.f7788b, this.f7789c, this.f7790d, this.f7791e, this.h, this.f7792j, this.f7793k, bVar);
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super r<PolicyNewestResponse>> bVar) {
        return ((PolicyManager$getPolicyData$1$response$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f7787a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            return obj;
        }
        kotlin.c.b(obj);
        PolicySdkLogUtils.Companion.d("getPolicyData", "getPolicyUsingGET");
        PolicyApiService policyApiService = new PolicyApiService(PolicySdkRetrofitHelper.INSTANCE.getApiService());
        String str = this.f7789c.f10076a;
        long j10 = this.f7791e.f10075a;
        long jLongValue = this.f7792j.longValue();
        PolicyManager policyManager = PolicyManager.INSTANCE;
        String brand = policyManager.getBrand();
        String model = policyManager.getModel();
        String osVersion = policyManager.getOsVersion();
        this.f7787a = 1;
        Object policyUsingGET = policyApiService.getPolicyUsingGET(this.f7788b, str, this.f7790d, j10, this.h, jLongValue, brand, model, osVersion, this.f7793k, "", this);
        return policyUsingGET == coroutineSingletons ? coroutineSingletons : policyUsingGET;
    }
}
