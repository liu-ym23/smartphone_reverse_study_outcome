package com.stepos.policy.sdk;

import Ua.M;
import Y8.t;
import com.stepos.policy.sdk.api.PolicyApiService;
import com.stepos.policy.sdk.bean.PolicyNewestResponse;
import com.stepos.policy.sdk.net.PolicySdkRetrofitHelper;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.p;
import yc.v;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lyc/v;", "Lcom/stepos/policy/sdk/bean/PolicyNewestResponse;", "<anonymous>", "(LUa/M;)Lyc/v;"}, k = 3, mv = {1, 8, 0})
@InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager$getPolicyData$1$response$1", f = "PolicyManager.kt", l = {2150}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class PolicyManager$getPolicyData$1$response$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super v<PolicyNewestResponse>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f30391a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f30392b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<String> f30393c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f30394d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Ref$LongRef f30395e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f30396f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Long f30397g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ String f30398h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicyManager$getPolicyData$1$response$1(String str, Ref$ObjectRef<String> ref$ObjectRef, String str2, Ref$LongRef ref$LongRef, String str3, Long l10, String str4, InterfaceC4014c<? super PolicyManager$getPolicyData$1$response$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f30392b = str;
        this.f30393c = ref$ObjectRef;
        this.f30394d = str2;
        this.f30395e = ref$LongRef;
        this.f30396f = str3;
        this.f30397g = l10;
        this.f30398h = str4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new PolicyManager$getPolicyData$1$response$1(this.f30392b, this.f30393c, this.f30394d, this.f30395e, this.f30396f, this.f30397g, this.f30398h, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super v<PolicyNewestResponse>> interfaceC4014c) {
        return ((PolicyManager$getPolicyData$1$response$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f30391a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        PolicySdkLogUtils.INSTANCE.d("getPolicyData", "getPolicyUsingGET");
        PolicyApiService policyApiService = new PolicyApiService(PolicySdkRetrofitHelper.INSTANCE.getApiService());
        String str = this.f30392b;
        String str2 = this.f30393c.f34820a;
        String str3 = this.f30394d;
        long j10 = this.f30395e.f34819a;
        String str4 = this.f30396f;
        long jLongValue = this.f30397g.longValue();
        PolicyManager policyManager = PolicyManager.INSTANCE;
        String brand = policyManager.getBrand();
        String model = policyManager.getModel();
        String osVersion = policyManager.getOsVersion();
        String str5 = this.f30398h;
        this.f30391a = 1;
        Object policyUsingGET = policyApiService.getPolicyUsingGET(str, str2, str3, j10, str4, jLongValue, brand, model, osVersion, str5, "", this);
        return policyUsingGET == objG ? objG : policyUsingGET;
    }
}
