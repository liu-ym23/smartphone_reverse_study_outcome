package com.stepos.policy.sdk;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.stepos.policy.sdk.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0525y extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f12290a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f12291b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0525y(boolean z4, Continuation continuation) {
        super(2, continuation);
        this.f12291b = z4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C0525y c0525y = new C0525y(this.f12291b, continuation);
        c0525y.f12290a = obj;
        return c0525y;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        C0525y c0525y = new C0525y(this.f12291b, (Continuation) obj2);
        c0525y.f12290a = (V.b) obj;
        return c0525y.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        V.b bVar = (V.b) this.f12290a;
        V.f key = b0.f12125c;
        Boolean boolBoxBoolean = Boxing.boxBoolean(this.f12291b);
        bVar.getClass();
        Intrinsics.checkNotNullParameter(key, "key");
        bVar.d(key, boolBoxBoolean);
        return Unit.INSTANCE;
    }
}
