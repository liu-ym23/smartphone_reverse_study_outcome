package com.stepos.policy.sdk;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.stepos.policy.sdk.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0520t extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f12252a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ V.f f12253b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f12254c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0520t(V.f fVar, String str, Continuation continuation) {
        super(2, continuation);
        this.f12253b = fVar;
        this.f12254c = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C0520t c0520t = new C0520t(this.f12253b, this.f12254c, continuation);
        c0520t.f12252a = obj;
        return c0520t;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C0520t) create((V.b) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        V.b bVar = (V.b) this.f12252a;
        String str = this.f12254c;
        if (str == null) {
            str = "";
        }
        bVar.getClass();
        V.f key = this.f12253b;
        Intrinsics.checkNotNullParameter(key, "key");
        bVar.d(key, str);
        return Unit.INSTANCE;
    }
}
