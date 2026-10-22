package com.stepos.policy.sdk;

import com.stepos.policy.sdk.bean.PolicyData;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import com.stepos.policy.sdk.bean.PolicyVersionResponse;
import com.stepos.policy.sdk.config.PolicySdkErrorCode;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import retrofit2.Response;

/* loaded from: classes.dex */
public final class c0 extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public PolicySdkResultBean f12131a;

    /* renamed from: b, reason: collision with root package name */
    public int f12132b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Long f12133c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f12134d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f12135e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f12136f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Function1 f12137g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ String f12138h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(Long l4, String str, String str2, String str3, Function1 function1, String str4, Continuation continuation) {
        super(2, continuation);
        this.f12133c = l4;
        this.f12134d = str;
        this.f12135e = str2;
        this.f12136f = str3;
        this.f12137g = function1;
        this.f12138h = str4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new c0(this.f12133c, this.f12134d, this.f12135e, this.f12136f, this.f12137g, this.f12138h, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((c0) create((Z2.F) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [T, com.stepos.policy.sdk.bean.PolicyVersionResponse] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v6, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r8v2, types: [com.stepos.policy.sdk.a0, kotlin.jvm.functions.Function2] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        PolicySdkResultBean policySdkResultBean;
        String str2;
        Object objO;
        PolicyData data;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f12132b;
        Function1 function1 = this.f12137g;
        ?? r7 = 1;
        String str3 = com.stepos.alphame.persona.privacy.PolicyManager.TAG;
        try {
            try {
            } catch (Throwable th) {
                th = th;
                str = str3;
            }
        } catch (Throwable th2) {
            th = th2;
            str = r7;
        }
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            policySdkResultBean = new PolicySdkResultBean();
            if (this.f12133c == null || this.f12134d == null) {
                String str4 = com.stepos.alphame.persona.privacy.PolicyManager.TAG;
                policySdkResultBean.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
                PolicySdkLogUtils.INSTANCE.e(str4, "return policySdkResultBean = : " + policySdkResultBean.getCode());
                r7 = str4;
                function1.invoke(policySdkResultBean);
                return Unit.INSTANCE;
            }
            Ref.LongRef longRef = new Ref.LongRef();
            longRef.element = System.currentTimeMillis();
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            PolicySdkToolsUtils.Companion companion = PolicySdkToolsUtils.INSTANCE;
            String str5 = this.f12135e;
            String str6 = this.f12136f;
            str2 = com.stepos.alphame.persona.privacy.PolicyManager.TAG;
            try {
                objectRef.element = companion.getAppSign(str5, str6, longRef.element);
                f3.c cVar = Z2.Q.f2190b;
                ?? a0Var = new a0(this.f12135e, objectRef, longRef, this.f12138h, this.f12133c, this.f12134d, null);
                this.f12131a = policySdkResultBean;
                this.f12132b = 1;
                objO = t0.J.O(this, cVar, a0Var);
                str3 = a0Var;
                if (objO == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (Throwable th3) {
                th = th3;
                str = str2;
                PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.INSTANCE;
                StringBuilder sb = new StringBuilder("exception : ");
                th.getMessage();
                Unit unit = Unit.INSTANCE;
                sb.append(th);
                companion2.e(str, sb.toString());
                return Unit.INSTANCE;
            }
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            PolicySdkResultBean policySdkResultBean2 = this.f12131a;
            ResultKt.throwOnFailure(obj);
            policySdkResultBean = policySdkResultBean2;
            str2 = com.stepos.alphame.persona.privacy.PolicyManager.TAG;
            objO = obj;
            str3 = str3;
        }
        Response response = (Response) objO;
        PolicySdkLogUtils.Companion companion3 = PolicySdkLogUtils.INSTANCE;
        String str7 = str2;
        companion3.d(str7, "response" + response);
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        if (response.isSuccessful()) {
            companion3.d(str7, "response isSuccessful");
            companion3.d(str7, "response.code()=" + response.code());
            companion3.d(str7, "response.body() =" + response.body());
            ?? r02 = (PolicyVersionResponse) response.body();
            if (r02 != 0) {
                objectRef2.element = r02;
            }
        } else {
            companion3.d(str7, "response failed");
        }
        policySdkResultBean.setCode(0);
        PolicyVersionResponse policyVersionResponse = (PolicyVersionResponse) objectRef2.element;
        if (policyVersionResponse != null && (data = policyVersionResponse.getData()) != null) {
            policySdkResultBean.setPolicyData(data);
        }
        companion3.e(str7, "return policySdkResultBean = : " + policySdkResultBean.getCode());
        r7 = str7;
        function1.invoke(policySdkResultBean);
        return Unit.INSTANCE;
    }
}
