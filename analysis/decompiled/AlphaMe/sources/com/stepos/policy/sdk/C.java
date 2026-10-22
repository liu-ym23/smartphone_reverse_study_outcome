package com.stepos.policy.sdk;

import S.InterfaceC0103i;
import android.content.Context;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import f1.AbstractC0557a;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
public final class C extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public int f11983a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f11984b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C(Context context, Continuation continuation) {
        super(2, continuation);
        this.f11984b = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C(this.f11984b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new C(this.f11984b, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f11983a;
        try {
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                InterfaceC0103i interfaceC0103iA = b0.a(this.f11984b);
                A a4 = new A(2, null);
                this.f11983a = 1;
                if (AbstractC0557a.r(interfaceC0103iA, a4, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (Exception e4) {
            PolicySdkLogUtils.INSTANCE.e("savePolicyCategoryVersion", "error =" + e4 + ' ');
        }
        return Unit.INSTANCE;
    }
}
