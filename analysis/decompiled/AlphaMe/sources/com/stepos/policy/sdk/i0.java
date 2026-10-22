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
public final class i0 extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public int f12193a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f12194b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f12195c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f12196d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Ref.LongRef f12197e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f12198f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long f12199g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ String f12200h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(String str, Ref.ObjectRef objectRef, String str2, Ref.LongRef longRef, String str3, long j4, String str4, Continuation continuation) {
        super(2, continuation);
        this.f12194b = str;
        this.f12195c = objectRef;
        this.f12196d = str2;
        this.f12197e = longRef;
        this.f12198f = str3;
        this.f12199g = j4;
        this.f12200h = str4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new i0(this.f12194b, this.f12195c, this.f12196d, this.f12197e, this.f12198f, this.f12199g, this.f12200h, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((i0) create((Z2.F) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f12193a;
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
        String str = (String) this.f12195c.element;
        long j4 = this.f12197e.element;
        PolicyManager policyManager = PolicyManager.INSTANCE;
        String brand = policyManager.getBrand();
        String model = policyManager.getModel();
        String osVersion = policyManager.getOsVersion();
        this.f12193a = 1;
        Object objPolicyHistoryListUsingGET = policyApiService.policyHistoryListUsingGET(this.f12194b, str, this.f12196d, j4, this.f12198f, this.f12199g, brand, model, osVersion, this.f12200h, this);
        return objPolicyHistoryListUsingGET == coroutine_suspended ? coroutine_suspended : objPolicyHistoryListUsingGET;
    }
}
