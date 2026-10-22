package com.stepos.policy.sdk;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.stepos.policy.sdk.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0521u extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f12255a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f12256b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f12257c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0521u(String str, String str2, Continuation continuation) {
        super(2, continuation);
        this.f12256b = str;
        this.f12257c = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C0521u c0521u = new C0521u(this.f12256b, this.f12257c, continuation);
        c0521u.f12255a = obj;
        return c0521u;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C0521u) create((V.b) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        V.b bVar = (V.b) this.f12255a;
        V.f key = com.airbnb.lottie.h.I("local_" + this.f12256b);
        bVar.getClass();
        Intrinsics.checkNotNullParameter(key, "key");
        bVar.d(key, this.f12257c);
        return Unit.INSTANCE;
    }
}
