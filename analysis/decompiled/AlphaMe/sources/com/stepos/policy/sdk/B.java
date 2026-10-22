package com.stepos.policy.sdk;

import com.stepos.policy.sdk.api.PolicyApiService;
import com.stepos.policy.sdk.net.PolicySdkRetrofitHelper;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* loaded from: classes.dex */
public final class B extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public int f11974a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f11975b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f11976c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f11977d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Ref.LongRef f11978e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f11979f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f11980g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ String f11981h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f11982i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(String str, Ref.ObjectRef objectRef, String str2, Ref.LongRef longRef, String str3, Ref.ObjectRef objectRef2, String str4, Ref.ObjectRef objectRef3, Continuation continuation) {
        super(2, continuation);
        this.f11975b = str;
        this.f11976c = objectRef;
        this.f11977d = str2;
        this.f11978e = longRef;
        this.f11979f = str3;
        this.f11980g = objectRef2;
        this.f11981h = str4;
        this.f11982i = objectRef3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new B(this.f11975b, this.f11976c, this.f11977d, this.f11978e, this.f11979f, this.f11980g, this.f11981h, this.f11982i, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((B) create((Z2.F) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f11974a;
        if (i4 != 0) {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        PolicyApiService policyApiService = new PolicyApiService(PolicySdkRetrofitHelper.INSTANCE.getApiService());
        String str = (String) this.f11976c.element;
        long j4 = this.f11978e.element;
        long jLongValue = ((Number) this.f11980g.element).longValue();
        PolicyManager policyManager = PolicyManager.INSTANCE;
        String brand = policyManager.getBrand();
        String model = policyManager.getModel();
        String osVersion = policyManager.getOsVersion();
        String str2 = (String) this.f11982i.element;
        this.f11974a = 1;
        Object policyUsingGET = policyApiService.getPolicyUsingGET(this.f11975b, str, this.f11977d, j4, this.f11979f, jLongValue, brand, model, osVersion, this.f11981h, str2, this);
        return policyUsingGET == coroutine_suspended ? coroutine_suspended : policyUsingGET;
    }
}
