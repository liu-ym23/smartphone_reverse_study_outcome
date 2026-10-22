package com.stepos.policy.sdk;

import android.content.Context;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import com.stepos.policy.sdk.bean.PolicyServiceConfigBean;
import com.stepos.policy.sdk.bean.PolicyServiceConfigResponse;
import com.stepos.policy.sdk.config.PolicySdkErrorCode;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import com.stepos.policy.sdk.util.PolicySdkStringUtils;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import retrofit2.Response;

/* renamed from: com.stepos.policy.sdk.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0509h extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public PolicySdkResultBean f12183a;

    /* renamed from: b, reason: collision with root package name */
    public int f12184b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f12185c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f12186d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f12187e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Function1 f12188f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f12189g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Context f12190h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0509h(String str, String str2, String str3, Function1 function1, String str4, Context context, Continuation continuation) {
        super(2, continuation);
        this.f12185c = str;
        this.f12186d = str2;
        this.f12187e = str3;
        this.f12188f = function1;
        this.f12189g = str4;
        this.f12190h = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C0509h(this.f12185c, this.f12186d, this.f12187e, this.f12188f, this.f12189g, this.f12190h, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C0509h) create((Z2.F) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13, types: [T, com.stepos.policy.sdk.bean.PolicyServiceConfigResponse] */
    /* JADX WARN: Type inference failed for: r7v2, types: [T, java.lang.String] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        Object objO;
        PolicySdkResultBean policySdkResultBean;
        List<PolicyServiceConfigBean> data;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f12184b;
        Function1 function1 = this.f12188f;
        String str2 = com.stepos.alphame.persona.privacy.PolicyManager.TAG;
        try {
        } catch (Throwable th) {
            th = th;
        }
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            PolicySdkResultBean policySdkResultBean2 = new PolicySdkResultBean();
            if (this.f12185c == null) {
                policySdkResultBean2.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
                PolicySdkLogUtils.INSTANCE.e(com.stepos.alphame.persona.privacy.PolicyManager.TAG, "return policySdkResultBean = : " + policySdkResultBean2.getCode());
                function1.invoke(policySdkResultBean2);
                return Unit.INSTANCE;
            }
            Ref.LongRef longRef = new Ref.LongRef();
            longRef.element = System.currentTimeMillis();
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            PolicySdkToolsUtils.Companion companion = PolicySdkToolsUtils.INSTANCE;
            String str3 = this.f12186d;
            String str4 = this.f12187e;
            str = com.stepos.alphame.persona.privacy.PolicyManager.TAG;
            try {
                objectRef.element = companion.getAppSign(str3, str4, longRef.element);
                f3.c cVar = Z2.Q.f2190b;
                C0508g c0508g = new C0508g(this.f12186d, objectRef, longRef, this.f12189g, this.f12185c, null);
                this.f12183a = policySdkResultBean2;
                this.f12184b = 1;
                objO = t0.J.O(this, cVar, c0508g);
                if (objO == coroutine_suspended) {
                    return coroutine_suspended;
                }
                policySdkResultBean = policySdkResultBean2;
            } catch (Throwable th2) {
                th = th2;
                str2 = str;
                PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.INSTANCE;
                StringBuilder sb = new StringBuilder("exception : ");
                th.getMessage();
                Unit unit = Unit.INSTANCE;
                sb.append(th);
                companion2.e(str2, sb.toString());
                return Unit.INSTANCE;
            }
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            policySdkResultBean = this.f12183a;
            ResultKt.throwOnFailure(obj);
            objO = obj;
            str = com.stepos.alphame.persona.privacy.PolicyManager.TAG;
        }
        Response response = (Response) objO;
        PolicySdkLogUtils.Companion companion3 = PolicySdkLogUtils.INSTANCE;
        String str5 = str;
        companion3.d(str5, "response" + response);
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        if (response.isSuccessful()) {
            companion3.d(str5, "response isSuccessful");
            companion3.d(str5, "response.code()=" + response.code());
            companion3.d(str5, "response.body() =" + response.body());
            ?? r12 = (PolicyServiceConfigResponse) response.body();
            if (r12 != 0) {
                objectRef2.element = r12;
            }
        } else {
            companion3.d(str5, "response failed");
        }
        policySdkResultBean.setCode(0);
        PolicyServiceConfigResponse policyServiceConfigResponse = (PolicyServiceConfigResponse) objectRef2.element;
        if (policyServiceConfigResponse != null && (data = policyServiceConfigResponse.getData()) != null) {
            Context context = this.f12190h;
            policySdkResultBean.setPolicyServiceConfigList(data);
            policySdkResultBean.setDeleteInfoBeanList(PolicySdkStringUtils.INSTANCE.getDeleteInfoListFromServiceConfig(context, data));
        }
        companion3.d(str5, "return policySdkResultBean = : " + policySdkResultBean.getCode());
        function1.invoke(policySdkResultBean);
        return Unit.INSTANCE;
    }
}
