package com.stepos.policy.sdk;

import com.stepos.policy.sdk.api.PolicyApiService;
import com.stepos.policy.sdk.bean.PolicyRecordRequest;
import com.stepos.policy.sdk.net.PolicySdkRetrofitHelper;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* loaded from: classes.dex */
public final class U extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public int f12056a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f12057b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f12058c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.LongRef f12059d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ PolicyRecordRequest f12060e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f12061f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public U(String str, Ref.ObjectRef objectRef, Ref.LongRef longRef, PolicyRecordRequest policyRecordRequest, String str2, Continuation continuation) {
        super(2, continuation);
        this.f12057b = str;
        this.f12058c = objectRef;
        this.f12059d = longRef;
        this.f12060e = policyRecordRequest;
        this.f12061f = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new U(this.f12057b, this.f12058c, this.f12059d, this.f12060e, this.f12061f, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((U) create((Z2.F) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f12056a;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            PolicyApiService policyApiService = new PolicyApiService(PolicySdkRetrofitHelper.INSTANCE.getApiService());
            String str = (String) this.f12058c.element;
            long j4 = this.f12059d.element;
            PolicyManager policyManager = PolicyManager.INSTANCE;
            String brand = policyManager.getBrand();
            String model = policyManager.getModel();
            String osVersion = policyManager.getOsVersion();
            this.f12056a = 1;
            obj = policyApiService.uploadOperateRecordUsingPOST(this.f12057b, str, j4, this.f12060e, brand, model, osVersion, this.f12061f, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
