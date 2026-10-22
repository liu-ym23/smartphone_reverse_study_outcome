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

/* loaded from: classes.dex */
public final class a0 extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public int f12100a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f12101b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f12102c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.LongRef f12103d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f12104e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Long f12105f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f12106g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(String str, Ref.ObjectRef objectRef, Ref.LongRef longRef, String str2, Long l4, String str3, Continuation continuation) {
        super(2, continuation);
        this.f12101b = str;
        this.f12102c = objectRef;
        this.f12103d = longRef;
        this.f12104e = str2;
        this.f12105f = l4;
        this.f12106g = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new a0(this.f12101b, this.f12102c, this.f12103d, this.f12104e, this.f12105f, this.f12106g, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((a0) create((Z2.F) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f12100a;
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
        String str = (String) this.f12102c.element;
        long j4 = this.f12103d.element;
        long jLongValue = this.f12105f.longValue();
        PolicyManager policyManager = PolicyManager.INSTANCE;
        String brand = policyManager.getBrand();
        String model = policyManager.getModel();
        String osVersion = policyManager.getOsVersion();
        this.f12100a = 1;
        Object objPolicyVersionInfoUsingGET = policyApiService.policyVersionInfoUsingGET(this.f12101b, str, j4, this.f12104e, jLongValue, brand, model, osVersion, this.f12106g, this);
        return objPolicyVersionInfoUsingGET == coroutine_suspended ? coroutine_suspended : objPolicyVersionInfoUsingGET;
    }
}
