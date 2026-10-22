package com.stepos.policy.sdk;

import com.stepos.policy.sdk.util.ReadClipboardUtils;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class A extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f11973a;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        A a4 = new A(2, continuation);
        a4.f11973a = obj;
        return a4;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        A a4 = new A(2, (Continuation) obj2);
        a4.f11973a = (V.b) obj;
        return a4.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        V.b bVar = (V.b) this.f11973a;
        V.f key = b0.f12127e;
        Integer numBoxInt = Boxing.boxInt(ReadClipboardUtils.READ_CLIPBOARD_PERMISSION_AGREE);
        bVar.getClass();
        Intrinsics.checkNotNullParameter(key, "key");
        bVar.d(key, numBoxInt);
        return Unit.INSTANCE;
    }
}
