package com.stepos.policy.sdk;

import android.content.Context;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* renamed from: com.stepos.policy.sdk.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0518q extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public int f12241a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PolicyManager f12242b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f12243c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f12244d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0518q(PolicyManager policyManager, Context context, Ref.ObjectRef objectRef, Continuation continuation) {
        super(2, continuation);
        this.f12242b = policyManager;
        this.f12243c = context;
        this.f12244d = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C0518q(this.f12242b, this.f12243c, this.f12244d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C0518q) create((Z2.F) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f12241a;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            String str = (String) this.f12244d.element;
            this.f12241a = 1;
            if (this.f12242b.savePolicyOperate(this.f12243c, true, str, this) == coroutine_suspended) {
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
