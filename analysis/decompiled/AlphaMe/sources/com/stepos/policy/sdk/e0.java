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
public final class e0 extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public int f12155a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f12156b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f12157c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f12158d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Ref.LongRef f12159e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f12160f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Long f12161g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ String f12162h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(String str, Ref.ObjectRef objectRef, String str2, Ref.LongRef longRef, String str3, Long l4, String str4, Continuation continuation) {
        super(2, continuation);
        this.f12156b = str;
        this.f12157c = objectRef;
        this.f12158d = str2;
        this.f12159e = longRef;
        this.f12160f = str3;
        this.f12161g = l4;
        this.f12162h = str4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new e0(this.f12156b, this.f12157c, this.f12158d, this.f12159e, this.f12160f, this.f12161g, this.f12162h, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((e0) create((Z2.F) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f12155a;
        if (i4 != 0) {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        PolicySdkLogUtils.INSTANCE.d("getPolicyData", "getPolicyUsingGET");
        PolicyApiService policyApiService = new PolicyApiService(PolicySdkRetrofitHelper.INSTANCE.getApiService());
        String str = (String) this.f12157c.element;
        long j4 = this.f12159e.element;
        long jLongValue = this.f12161g.longValue();
        PolicyManager policyManager = PolicyManager.INSTANCE;
        String brand = policyManager.getBrand();
        String model = policyManager.getModel();
        String osVersion = policyManager.getOsVersion();
        this.f12155a = 1;
        Object policyUsingGET = policyApiService.getPolicyUsingGET(this.f12156b, str, this.f12158d, j4, this.f12160f, jLongValue, brand, model, osVersion, this.f12162h, "", this);
        return policyUsingGET == coroutine_suspended ? coroutine_suspended : policyUsingGET;
    }
}
