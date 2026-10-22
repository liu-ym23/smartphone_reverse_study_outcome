package com.stepos.policy.sdk;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.stepos.policy.sdk.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0526z extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f12292a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f12293b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0526z(String str, Continuation continuation) {
        super(2, continuation);
        this.f12293b = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C0526z c0526z = new C0526z(this.f12293b, continuation);
        c0526z.f12292a = obj;
        return c0526z;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        C0526z c0526z = new C0526z(this.f12293b, (Continuation) obj2);
        c0526z.f12292a = (V.b) obj;
        return c0526z.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        V.b bVar = (V.b) this.f12292a;
        V.f key = b0.f12126d;
        String str = this.f12293b;
        if (str == null) {
            str = "";
        }
        bVar.getClass();
        Intrinsics.checkNotNullParameter(key, "key");
        bVar.d(key, str);
        return Unit.INSTANCE;
    }
}
