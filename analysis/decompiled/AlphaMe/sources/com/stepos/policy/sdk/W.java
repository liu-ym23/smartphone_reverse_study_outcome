package com.stepos.policy.sdk;

import com.stepos.policy.sdk.bean.PolicyOperateRecordResponse;
import com.stepos.policy.sdk.bean.PolicyRecordRequest;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import retrofit2.Response;

/* loaded from: classes.dex */
public final class W extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public PolicySdkResultBean f12065a;

    /* renamed from: b, reason: collision with root package name */
    public int f12066b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f12067c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f12068d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ PolicyRecordRequest f12069e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Function1 f12070f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f12071g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public W(String str, String str2, PolicyRecordRequest policyRecordRequest, Function1 function1, String str3, Continuation continuation) {
        super(2, continuation);
        this.f12067c = str;
        this.f12068d = str2;
        this.f12069e = policyRecordRequest;
        this.f12070f = function1;
        this.f12071g = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new W(this.f12067c, this.f12068d, this.f12069e, this.f12070f, this.f12071g, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((W) create((Z2.F) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r7v2, types: [T, java.lang.String] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        PolicySdkResultBean policySdkResultBean;
        Function1 function1;
        Ref.LongRef longRef;
        Ref.ObjectRef objectRef;
        Function1 function12;
        Object objO;
        PolicySdkResultBean policySdkResultBean2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f12066b;
        Function1 function13 = this.f12070f;
        PolicyRecordRequest policyRecordRequest = this.f12069e;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            policySdkResultBean = new PolicySdkResultBean();
            try {
                longRef = new Ref.LongRef();
                longRef.element = System.currentTimeMillis();
                objectRef = new Ref.ObjectRef();
                function12 = function13;
            } catch (Exception e4) {
                e = e4;
                function1 = function13;
            }
            try {
                objectRef.element = PolicySdkToolsUtils.INSTANCE.getAppSign(this.f12067c, this.f12068d, longRef.element);
                f3.c cVar = Z2.Q.f2190b;
                U u4 = new U(this.f12067c, objectRef, longRef, this.f12069e, this.f12071g, null);
                this.f12065a = policySdkResultBean;
                this.f12066b = 1;
                objO = t0.J.O(this, cVar, u4);
                if (objO == coroutine_suspended) {
                    return coroutine_suspended;
                }
                policySdkResultBean2 = policySdkResultBean;
            } catch (Exception e5) {
                e = e5;
                function1 = function12;
                PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
                companion.d(com.stepos.alphame.persona.privacy.PolicyManager.TAG, "uploadPolicyOperateRecord response failed");
                StringBuilder sb = new StringBuilder("exception : ");
                e.getMessage();
                Unit unit = Unit.INSTANCE;
                sb.append(e);
                companion.e(com.stepos.alphame.persona.privacy.PolicyManager.TAG, sb.toString());
                policySdkResultBean.setCode(-1);
                policySdkResultBean.setPolicyRecordRequest(policyRecordRequest);
                function1.invoke(policySdkResultBean);
                return Unit.INSTANCE;
            }
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            policySdkResultBean2 = this.f12065a;
            try {
                ResultKt.throwOnFailure(obj);
                objO = obj;
                function12 = function13;
            } catch (Exception e6) {
                e = e6;
                function1 = function13;
                policySdkResultBean = policySdkResultBean2;
                PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.INSTANCE;
                companion2.d(com.stepos.alphame.persona.privacy.PolicyManager.TAG, "uploadPolicyOperateRecord response failed");
                StringBuilder sb2 = new StringBuilder("exception : ");
                e.getMessage();
                Unit unit2 = Unit.INSTANCE;
                sb2.append(e);
                companion2.e(com.stepos.alphame.persona.privacy.PolicyManager.TAG, sb2.toString());
                policySdkResultBean.setCode(-1);
                policySdkResultBean.setPolicyRecordRequest(policyRecordRequest);
                function1.invoke(policySdkResultBean);
                return Unit.INSTANCE;
            }
        }
        try {
            Response response = (Response) objO;
            PolicySdkLogUtils.Companion companion3 = PolicySdkLogUtils.INSTANCE;
            companion3.d(com.stepos.alphame.persona.privacy.PolicyManager.TAG, "response =" + response);
            if (response.isSuccessful()) {
                companion3.d(com.stepos.alphame.persona.privacy.PolicyManager.TAG, "uploadPolicyOperateRecord response isSuccessful");
                companion3.d(com.stepos.alphame.persona.privacy.PolicyManager.TAG, "uploadPolicyOperateRecord response.code()=" + Boxing.boxInt(response.code()));
                companion3.d(com.stepos.alphame.persona.privacy.PolicyManager.TAG, "uploadPolicyOperateRecord response.body() =" + ((PolicyOperateRecordResponse) response.body()));
                PolicyOperateRecordResponse policyOperateRecordResponse = (PolicyOperateRecordResponse) response.body();
                if (policyOperateRecordResponse == null || policyOperateRecordResponse.getCode() != 200) {
                    policySdkResultBean2.setCode(-1);
                    policySdkResultBean2.setPolicyRecordRequest(policyRecordRequest);
                } else {
                    policySdkResultBean2.setCode(0);
                }
            } else {
                policySdkResultBean2.setCode(-1);
                policySdkResultBean2.setPolicyRecordRequest(policyRecordRequest);
                companion3.d(com.stepos.alphame.persona.privacy.PolicyManager.TAG, "uploadPolicyOperateRecord response failed");
            }
            function1 = function12;
        } catch (Exception e7) {
            e = e7;
            function1 = function12;
        }
        try {
            function1.invoke(policySdkResultBean2);
        } catch (Exception e8) {
            e = e8;
            policySdkResultBean = policySdkResultBean2;
            PolicySdkLogUtils.Companion companion22 = PolicySdkLogUtils.INSTANCE;
            companion22.d(com.stepos.alphame.persona.privacy.PolicyManager.TAG, "uploadPolicyOperateRecord response failed");
            StringBuilder sb22 = new StringBuilder("exception : ");
            e.getMessage();
            Unit unit22 = Unit.INSTANCE;
            sb22.append(e);
            companion22.e(com.stepos.alphame.persona.privacy.PolicyManager.TAG, sb22.toString());
            policySdkResultBean.setCode(-1);
            policySdkResultBean.setPolicyRecordRequest(policyRecordRequest);
            function1.invoke(policySdkResultBean);
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
