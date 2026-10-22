package com.stepos.policy.sdk;

import com.stepos.policy.sdk.api.PolicyApiService;
import com.stepos.policy.sdk.bean.PolicyHistoryListResponse;
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
@rb.c(c = "com.stepos.policy.sdk.PolicyManager$getPolicyHistoryList$1$response$1", f = "PolicyManager.kt", l = {2251}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class PolicyManager$getPolicyHistoryList$1$response$1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super r<PolicyHistoryListResponse>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f7802a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7803b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<String> f7804c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f7805d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Ref$LongRef f7806e;
    public final /* synthetic */ String h;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ long f7807j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f7808k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicyManager$getPolicyHistoryList$1$response$1(String str, Ref$ObjectRef<String> ref$ObjectRef, String str2, Ref$LongRef ref$LongRef, String str3, long j10, String str4, qb.b<? super PolicyManager$getPolicyHistoryList$1$response$1> bVar) {
        super(2, bVar);
        this.f7803b = str;
        this.f7804c = ref$ObjectRef;
        this.f7805d = str2;
        this.f7806e = ref$LongRef;
        this.h = str3;
        this.f7807j = j10;
        this.f7808k = str4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        return new PolicyManager$getPolicyHistoryList$1$response$1(this.f7803b, this.f7804c, this.f7805d, this.f7806e, this.h, this.f7807j, this.f7808k, bVar);
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super r<PolicyHistoryListResponse>> bVar) {
        return ((PolicyManager$getPolicyHistoryList$1$response$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f7802a;
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
        String str = this.f7804c.f10076a;
        long j10 = this.f7806e.f10075a;
        PolicyManager policyManager = PolicyManager.INSTANCE;
        String brand = policyManager.getBrand();
        String model = policyManager.getModel();
        String osVersion = policyManager.getOsVersion();
        this.f7802a = 1;
        Object objPolicyHistoryListUsingGET = policyApiService.policyHistoryListUsingGET(this.f7803b, str, this.f7805d, j10, this.h, this.f7807j, brand, model, osVersion, this.f7808k, this);
        return objPolicyHistoryListUsingGET == coroutineSingletons ? coroutineSingletons : objPolicyHistoryListUsingGET;
    }
}
