package com.stepos.policy.sdk;

import Ua.M;
import Y8.t;
import com.stepos.policy.sdk.api.PolicyApiService;
import com.stepos.policy.sdk.bean.PolicyServiceConfigResponse;
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

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lyc/v;", "Lcom/stepos/policy/sdk/bean/PolicyServiceConfigResponse;", "<anonymous>", "(LUa/M;)Lyc/v;"}, k = 3, mv = {1, 8, 0})
@InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager$getPolicyServiceConfig$1$response$1", f = "PolicyManager.kt", l = {2635}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class PolicyManager$getPolicyServiceConfig$1$response$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super v<PolicyServiceConfigResponse>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f30427a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f30428b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<String> f30429c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref$LongRef f30430d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f30431e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f30432f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicyManager$getPolicyServiceConfig$1$response$1(String str, Ref$ObjectRef<String> ref$ObjectRef, Ref$LongRef ref$LongRef, String str2, String str3, InterfaceC4014c<? super PolicyManager$getPolicyServiceConfig$1$response$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f30428b = str;
        this.f30429c = ref$ObjectRef;
        this.f30430d = ref$LongRef;
        this.f30431e = str2;
        this.f30432f = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new PolicyManager$getPolicyServiceConfig$1$response$1(this.f30428b, this.f30429c, this.f30430d, this.f30431e, this.f30432f, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super v<PolicyServiceConfigResponse>> interfaceC4014c) {
        return ((PolicyManager$getPolicyServiceConfig$1$response$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f30427a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        PolicySdkLogUtils.INSTANCE.d("PolicyManager", "getPolicyUsingGET");
        PolicyApiService policyApiService = new PolicyApiService(PolicySdkRetrofitHelper.INSTANCE.getApiService());
        String str = this.f30428b;
        String str2 = this.f30429c.f34820a;
        long j10 = this.f30430d.f34819a;
        String str3 = this.f30431e;
        PolicyManager policyManager = PolicyManager.INSTANCE;
        String brand = policyManager.getBrand();
        String model = policyManager.getModel();
        String osVersion = policyManager.getOsVersion();
        String str4 = this.f30432f;
        this.f30427a = 1;
        Object serviceConfig = policyApiService.getServiceConfig(str, str2, j10, str3, brand, model, osVersion, str4, this);
        return serviceConfig == objG ? objG : serviceConfig;
    }
}
