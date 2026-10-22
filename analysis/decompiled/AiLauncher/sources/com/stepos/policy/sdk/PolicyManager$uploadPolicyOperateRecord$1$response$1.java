package com.stepos.policy.sdk;

import Ua.M;
import Y8.t;
import com.stepos.policy.sdk.api.PolicyApiService;
import com.stepos.policy.sdk.bean.PolicyOperateRecordResponse;
import com.stepos.policy.sdk.bean.PolicyRecordRequest;
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

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lyc/v;", "Lcom/stepos/policy/sdk/bean/PolicyOperateRecordResponse;", "<anonymous>", "(LUa/M;)Lyc/v;"}, k = 3, mv = {1, 8, 0})
@InterfaceC4112d(c = "com.stepos.policy.sdk.PolicyManager$uploadPolicyOperateRecord$1$response$1", f = "PolicyManager.kt", l = {514}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class PolicyManager$uploadPolicyOperateRecord$1$response$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super v<PolicyOperateRecordResponse>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f30538a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f30539b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<String> f30540c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref$LongRef f30541d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ PolicyRecordRequest f30542e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f30543f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicyManager$uploadPolicyOperateRecord$1$response$1(String str, Ref$ObjectRef<String> ref$ObjectRef, Ref$LongRef ref$LongRef, PolicyRecordRequest policyRecordRequest, String str2, InterfaceC4014c<? super PolicyManager$uploadPolicyOperateRecord$1$response$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f30539b = str;
        this.f30540c = ref$ObjectRef;
        this.f30541d = ref$LongRef;
        this.f30542e = policyRecordRequest;
        this.f30543f = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new PolicyManager$uploadPolicyOperateRecord$1$response$1(this.f30539b, this.f30540c, this.f30541d, this.f30542e, this.f30543f, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super v<PolicyOperateRecordResponse>> interfaceC4014c) {
        return ((PolicyManager$uploadPolicyOperateRecord$1$response$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f30538a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        PolicyApiService policyApiService = new PolicyApiService(PolicySdkRetrofitHelper.INSTANCE.getApiService());
        String str = this.f30539b;
        String str2 = this.f30540c.f34820a;
        long j10 = this.f30541d.f34819a;
        PolicyRecordRequest policyRecordRequest = this.f30542e;
        PolicyManager policyManager = PolicyManager.INSTANCE;
        String brand = policyManager.getBrand();
        String model = policyManager.getModel();
        String osVersion = policyManager.getOsVersion();
        String str3 = this.f30543f;
        this.f30538a = 1;
        Object objUploadOperateRecordUsingPOST = policyApiService.uploadOperateRecordUsingPOST(str, str2, j10, policyRecordRequest, brand, model, osVersion, str3, this);
        return objUploadOperateRecordUsingPOST == objG ? objG : objUploadOperateRecordUsingPOST;
    }
}
