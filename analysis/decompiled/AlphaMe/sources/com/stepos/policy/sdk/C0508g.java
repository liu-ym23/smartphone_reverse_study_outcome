package com.stepos.policy.sdk;

import com.stepos.policy.sdk.api.PolicyApiService;
import com.stepos.policy.sdk.net.PolicySdkRetrofitHelper;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* renamed from: com.stepos.policy.sdk.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0508g extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public int f12168a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f12169b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f12170c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.LongRef f12171d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f12172e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f12173f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0508g(String str, Ref.ObjectRef objectRef, Ref.LongRef longRef, String str2, String str3, Continuation continuation) {
        super(2, continuation);
        this.f12169b = str;
        this.f12170c = objectRef;
        this.f12171d = longRef;
        this.f12172e = str2;
        this.f12173f = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C0508g(this.f12169b, this.f12170c, this.f12171d, this.f12172e, this.f12173f, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C0508g) create((Z2.F) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f12168a;
        if (i4 != 0) {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        PolicySdkLogUtils.INSTANCE.d(com.stepos.alphame.persona.privacy.PolicyManager.TAG, "getPolicyUsingGET");
        PolicyApiService policyApiService = new PolicyApiService(PolicySdkRetrofitHelper.INSTANCE.getApiService());
        String str = (String) this.f12170c.element;
        long j4 = this.f12171d.element;
        PolicyManager policyManager = PolicyManager.INSTANCE;
        String brand = policyManager.getBrand();
        String model = policyManager.getModel();
        String osVersion = policyManager.getOsVersion();
        this.f12168a = 1;
        Object serviceConfig = policyApiService.getServiceConfig(this.f12169b, str, j4, this.f12172e, brand, model, osVersion, this.f12173f, this);
        return serviceConfig == coroutine_suspended ? coroutine_suspended : serviceConfig;
    }
}
