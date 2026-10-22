package com.stepos.policy.sdk;

import com.stepos.policy.sdk.api.PolicyApiService;
import com.stepos.policy.sdk.bean.PolicyOperateRecordResponse;
import com.stepos.policy.sdk.bean.PolicyRecordRequest;
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
@rb.c(c = "com.stepos.policy.sdk.PolicyManager$uploadPolicyOperateRecord$1$response$1", f = "PolicyManager.kt", l = {514}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class PolicyManager$uploadPolicyOperateRecord$1$response$1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super r<PolicyOperateRecordResponse>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f7919a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7920b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<String> f7921c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref$LongRef f7922d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ PolicyRecordRequest f7923e;
    public final /* synthetic */ String h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicyManager$uploadPolicyOperateRecord$1$response$1(String str, Ref$ObjectRef<String> ref$ObjectRef, Ref$LongRef ref$LongRef, PolicyRecordRequest policyRecordRequest, String str2, qb.b<? super PolicyManager$uploadPolicyOperateRecord$1$response$1> bVar) {
        super(2, bVar);
        this.f7920b = str;
        this.f7921c = ref$ObjectRef;
        this.f7922d = ref$LongRef;
        this.f7923e = policyRecordRequest;
        this.h = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        return new PolicyManager$uploadPolicyOperateRecord$1$response$1(this.f7920b, this.f7921c, this.f7922d, this.f7923e, this.h, bVar);
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super r<PolicyOperateRecordResponse>> bVar) {
        return ((PolicyManager$uploadPolicyOperateRecord$1$response$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f7919a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            return obj;
        }
        kotlin.c.b(obj);
        PolicyApiService policyApiService = new PolicyApiService(PolicySdkRetrofitHelper.INSTANCE.getApiService());
        String str = this.f7921c.f10076a;
        long j10 = this.f7922d.f10075a;
        PolicyManager policyManager = PolicyManager.INSTANCE;
        String brand = policyManager.getBrand();
        String model = policyManager.getModel();
        String osVersion = policyManager.getOsVersion();
        this.f7919a = 1;
        Object objUploadOperateRecordUsingPOST = policyApiService.uploadOperateRecordUsingPOST(this.f7920b, str, j10, this.f7923e, brand, model, osVersion, this.h, this);
        return objUploadOperateRecordUsingPOST == coroutineSingletons ? coroutineSingletons : objUploadOperateRecordUsingPOST;
    }
}
