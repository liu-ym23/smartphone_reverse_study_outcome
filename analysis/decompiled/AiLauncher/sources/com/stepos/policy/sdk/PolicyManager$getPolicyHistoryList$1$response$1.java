package com.stepos.policy.sdk;

import Ua.M;
import Y8.t;
import com.stepos.policy.sdk.api.PolicyApiService;
import com.stepos.policy.sdk.bean.PolicyHistoryListResponse;
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

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lyc/v;", "Lcom/stepos/policy/sdk/bean/PolicyHistoryListResponse;", "<anonymous>", "(LUa/M;)Lyc/v;"}, k = 3, mv = {1, 8, 0})
@InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager$getPolicyHistoryList$1$response$1", f = "PolicyManager.kt", l = {2251}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class PolicyManager$getPolicyHistoryList$1$response$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super v<PolicyHistoryListResponse>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f30408a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f30409b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<String> f30410c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f30411d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Ref$LongRef f30412e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f30413f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long f30414g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ String f30415h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicyManager$getPolicyHistoryList$1$response$1(String str, Ref$ObjectRef<String> ref$ObjectRef, String str2, Ref$LongRef ref$LongRef, String str3, long j10, String str4, InterfaceC4014c<? super PolicyManager$getPolicyHistoryList$1$response$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f30409b = str;
        this.f30410c = ref$ObjectRef;
        this.f30411d = str2;
        this.f30412e = ref$LongRef;
        this.f30413f = str3;
        this.f30414g = j10;
        this.f30415h = str4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new PolicyManager$getPolicyHistoryList$1$response$1(this.f30409b, this.f30410c, this.f30411d, this.f30412e, this.f30413f, this.f30414g, this.f30415h, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super v<PolicyHistoryListResponse>> interfaceC4014c) {
        return ((PolicyManager$getPolicyHistoryList$1$response$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f30408a;
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
        String str = this.f30409b;
        String str2 = this.f30410c.f34820a;
        String str3 = this.f30411d;
        long j10 = this.f30412e.f34819a;
        String str4 = this.f30413f;
        long j11 = this.f30414g;
        PolicyManager policyManager = PolicyManager.INSTANCE;
        String brand = policyManager.getBrand();
        String model = policyManager.getModel();
        String osVersion = policyManager.getOsVersion();
        String str5 = this.f30415h;
        this.f30408a = 1;
        Object objPolicyHistoryListUsingGET = policyApiService.policyHistoryListUsingGET(str, str2, str3, j10, str4, j11, brand, model, osVersion, str5, this);
        return objPolicyHistoryListUsingGET == objG ? objG : objPolicyHistoryListUsingGET;
    }
}
