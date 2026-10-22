package com.stepos.policy.sdk;

import android.content.Context;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* renamed from: com.stepos.policy.sdk.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0524x extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public int f12286a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PolicySdkResultBean f12287b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f12288c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f12289d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0524x(PolicySdkResultBean policySdkResultBean, Ref.ObjectRef objectRef, Context context, Continuation continuation) {
        super(2, continuation);
        this.f12287b = policySdkResultBean;
        this.f12288c = objectRef;
        this.f12289d = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C0524x(this.f12287b, this.f12288c, this.f12289d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C0524x) create((Z2.F) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String strG;
        boolean z4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f12286a;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
            StringBuilder sb = new StringBuilder("policySdkResultBean.code ");
            PolicySdkResultBean policySdkResultBean = this.f12287b;
            sb.append(policySdkResultBean.getCode());
            companion.d("autoUploadRecord", sb.toString());
            if (policySdkResultBean.getCode() == 0) {
                strG = "";
                z4 = true;
            } else {
                strG = new F1.n().g(this.f12288c.element);
                Intrinsics.checkNotNullExpressionValue(strG, "gson.toJson(policyRecordRequest)");
                z4 = false;
            }
            companion.d("autoUploadRecord", "isOperateSuccess " + z4);
            PolicyManager policyManager = PolicyManager.INSTANCE;
            this.f12286a = 1;
            if (policyManager.savePolicyOperate(this.f12289d, z4, strG, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
