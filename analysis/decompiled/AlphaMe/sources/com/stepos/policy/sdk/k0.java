package com.stepos.policy.sdk;

import com.stepos.policy.sdk.bean.PolicyHistoryListResponse;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
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
public final class k0 extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public PolicySdkResultBean f12208a;

    /* renamed from: b, reason: collision with root package name */
    public int f12209b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f12210c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f12211d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f12212e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f12213f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Function1 f12214g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ String f12215h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ long f12216i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(String str, String str2, String str3, String str4, Function1 function1, String str5, long j4, Continuation continuation) {
        super(2, continuation);
        this.f12210c = str;
        this.f12211d = str2;
        this.f12212e = str3;
        this.f12213f = str4;
        this.f12214g = function1;
        this.f12215h = str5;
        this.f12216i = j4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new k0(this.f12210c, this.f12211d, this.f12212e, this.f12213f, this.f12214g, this.f12215h, this.f12216i, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((k0) create((Z2.F) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19, types: [T, com.stepos.policy.sdk.bean.PolicyHistoryListResponse] */
    /* JADX WARN: Type inference failed for: r7v2, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v2, types: [com.stepos.policy.sdk.i0, kotlin.jvm.functions.Function2] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        PolicySdkResultBean policySdkResultBean;
        String str;
        String str2;
        String str3;
        Object objO;
        String str4 = "response";
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f12209b;
        Function1 function1 = this.f12214g;
        String str5 = com.stepos.alphame.persona.privacy.PolicyManager.TAG;
        try {
            try {
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            str4 = str5;
        }
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            policySdkResultBean = new PolicySdkResultBean();
            if (this.f12210c == null || this.f12211d == null) {
                str4 = com.stepos.alphame.persona.privacy.PolicyManager.TAG;
                policySdkResultBean.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
                PolicySdkLogUtils.INSTANCE.e(str4, "return policySdkResultBean = : " + policySdkResultBean.getCode());
                function1.invoke(policySdkResultBean);
                return Unit.INSTANCE;
            }
            Ref.LongRef longRef = new Ref.LongRef();
            longRef.element = System.currentTimeMillis();
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            PolicySdkToolsUtils.Companion companion = PolicySdkToolsUtils.INSTANCE;
            String str6 = this.f12212e;
            String str7 = this.f12213f;
            str = com.stepos.alphame.persona.privacy.PolicyManager.TAG;
            try {
                objectRef.element = companion.getAppSign(str6, str7, longRef.element);
                f3.c cVar = Z2.Q.f2190b;
                str2 = "response.body() =";
                str3 = "response.code()=";
                ?? i0Var = new i0(this.f12212e, objectRef, this.f12210c, longRef, this.f12215h, this.f12216i, this.f12211d, null);
                this.f12208a = policySdkResultBean;
                this.f12209b = 1;
                objO = t0.J.O(this, cVar, i0Var);
                str5 = i0Var;
                if (objO == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (Throwable th3) {
                th = th3;
                str4 = str;
                PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.INSTANCE;
                StringBuilder sb = new StringBuilder("exception : ");
                th.getMessage();
                Unit unit = Unit.INSTANCE;
                sb.append(th);
                companion2.e(str4, sb.toString());
                return Unit.INSTANCE;
            }
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            PolicySdkResultBean policySdkResultBean2 = this.f12208a;
            ResultKt.throwOnFailure(obj);
            policySdkResultBean = policySdkResultBean2;
            str2 = "response.body() =";
            str3 = "response.code()=";
            str = com.stepos.alphame.persona.privacy.PolicyManager.TAG;
            objO = obj;
            str5 = str5;
        }
        Response response = (Response) objO;
        PolicySdkLogUtils.Companion companion3 = PolicySdkLogUtils.INSTANCE;
        str4 = str;
        companion3.d(str4, "response" + response);
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        if (response.isSuccessful()) {
            companion3.d(str4, "response isSuccessful");
            companion3.d(str4, str3 + response.code());
            companion3.d(str4, str2 + response.body());
            ?? r02 = (PolicyHistoryListResponse) response.body();
            if (r02 != 0) {
                objectRef2.element = r02;
            }
        } else {
            companion3.d(str4, "response failed");
        }
        policySdkResultBean.setCode(0);
        PolicyHistoryListResponse policyHistoryListResponse = (PolicyHistoryListResponse) objectRef2.element;
        if (policyHistoryListResponse != null) {
            policySdkResultBean.setPolicyHistoryListResponse(policyHistoryListResponse);
        }
        companion3.e(str4, "return policySdkResultBean = : " + policySdkResultBean.getCode());
        function1.invoke(policySdkResultBean);
        return Unit.INSTANCE;
    }
}
