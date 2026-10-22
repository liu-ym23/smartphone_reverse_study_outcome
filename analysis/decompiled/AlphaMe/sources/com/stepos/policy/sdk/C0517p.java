package com.stepos.policy.sdk;

import android.content.Context;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* renamed from: com.stepos.policy.sdk.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0517p extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12237a;

    /* renamed from: b, reason: collision with root package name */
    public int f12238b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f12239c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Serializable f12240d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0517p(Context context, String str, Continuation continuation) {
        super(2, continuation);
        this.f12237a = 2;
        this.f12239c = context;
        this.f12240d = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        int i4 = this.f12237a;
        Context context = this.f12239c;
        Serializable serializable = this.f12240d;
        switch (i4) {
            case 0:
                return new C0517p((HashMap) serializable, context, continuation, 0);
            case 1:
                return new C0517p((Ref.ObjectRef) serializable, context, continuation, 1);
            default:
                return new C0517p(context, (String) serializable, continuation);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int i4 = this.f12237a;
        Context context = this.f12239c;
        Serializable serializable = this.f12240d;
        switch (i4) {
            case 0:
                return new C0517p((HashMap) serializable, context, (Continuation) obj2, 0).invokeSuspend(Unit.INSTANCE);
            case 1:
                return new C0517p((Ref.ObjectRef) serializable, context, (Continuation) obj2, 1).invokeSuspend(Unit.INSTANCE);
            default:
                return new C0517p(context, (String) serializable, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i4 = this.f12237a;
        Serializable serializable = this.f12240d;
        Context context = this.f12239c;
        switch (i4) {
            case 0:
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i5 = this.f12238b;
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    f3.c cVar = Z2.Q.f2190b;
                    C0514m c0514m = new C0514m((HashMap) serializable, context, null);
                    this.f12238b = 1;
                    if (t0.J.O(this, cVar, c0514m) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            case 1:
                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i6 = this.f12238b;
                if (i6 == 0) {
                    ResultKt.throwOnFailure(obj);
                    String strG = new F1.n().g(((Ref.ObjectRef) serializable).element);
                    PolicyManager policyManager = PolicyManager.INSTANCE;
                    this.f12238b = 1;
                    if (policyManager.savePolicyOperate(context, false, strG, this) == coroutine_suspended2) {
                        return coroutine_suspended2;
                    }
                } else {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            default:
                Object coroutine_suspended3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i7 = this.f12238b;
                if (i7 == 0) {
                    ResultKt.throwOnFailure(obj);
                    T t4 = new T(b0.a(context).b(), (String) serializable, 1);
                    this.f12238b = 1;
                    obj = Z2.I.k(t4, this);
                    if (obj == coroutine_suspended3) {
                        return coroutine_suspended3;
                    }
                } else {
                    if (i7 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                String strValueOf = String.valueOf(obj);
                if (Intrinsics.areEqual(strValueOf, "null")) {
                    strValueOf = "";
                }
                return strValueOf;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0517p(Serializable serializable, Context context, Continuation continuation, int i4) {
        super(2, continuation);
        this.f12237a = i4;
        this.f12240d = serializable;
        this.f12239c = context;
    }
}
