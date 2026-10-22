package com.stepos.policy.sdk;

import Ua.M;
import Y8.t;
import com.stepos.policy.sdk.api.PolicyApiService;
import com.stepos.policy.sdk.bean.PolicyNewestResponse;
import com.stepos.policy.sdk.net.PolicySdkRetrofitHelper;
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
@InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager$checkNewestPolicy$1$response$1", f = "PolicyManager.kt", l = {1611}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class PolicyManager$checkNewestPolicy$1$response$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super v<PolicyNewestResponse>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f30316a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f30317b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<String> f30318c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f30319d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Ref$LongRef f30320e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f30321f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<Long> f30322g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ String f30323h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<String> f30324i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicyManager$checkNewestPolicy$1$response$1(String str, Ref$ObjectRef<String> ref$ObjectRef, String str2, Ref$LongRef ref$LongRef, String str3, Ref$ObjectRef<Long> ref$ObjectRef2, String str4, Ref$ObjectRef<String> ref$ObjectRef3, InterfaceC4014c<? super PolicyManager$checkNewestPolicy$1$response$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f30317b = str;
        this.f30318c = ref$ObjectRef;
        this.f30319d = str2;
        this.f30320e = ref$LongRef;
        this.f30321f = str3;
        this.f30322g = ref$ObjectRef2;
        this.f30323h = str4;
        this.f30324i = ref$ObjectRef3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new PolicyManager$checkNewestPolicy$1$response$1(this.f30317b, this.f30318c, this.f30319d, this.f30320e, this.f30321f, this.f30322g, this.f30323h, this.f30324i, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super v<PolicyNewestResponse>> interfaceC4014c) {
        return ((PolicyManager$checkNewestPolicy$1$response$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f30316a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        PolicyApiService policyApiService = new PolicyApiService(PolicySdkRetrofitHelper.INSTANCE.getApiService());
        String str = this.f30317b;
        String str2 = this.f30318c.f34820a;
        String str3 = this.f30319d;
        long j10 = this.f30320e.f34819a;
        String str4 = this.f30321f;
        long jLongValue = this.f30322g.f34820a.longValue();
        PolicyManager policyManager = PolicyManager.INSTANCE;
        String brand = policyManager.getBrand();
        String model = policyManager.getModel();
        String osVersion = policyManager.getOsVersion();
        String str5 = this.f30323h;
        String str6 = this.f30324i.f34820a;
        this.f30316a = 1;
        Object policyUsingGET = policyApiService.getPolicyUsingGET(str, str2, str3, j10, str4, jLongValue, brand, model, osVersion, str5, str6, this);
        return policyUsingGET == objG ? objG : policyUsingGET;
    }
}
