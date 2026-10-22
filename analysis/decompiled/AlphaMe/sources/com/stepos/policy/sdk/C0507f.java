package com.stepos.policy.sdk;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: com.stepos.policy.sdk.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0507f extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f12163a;

    /* renamed from: b, reason: collision with root package name */
    public int f12164b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ S.x f12165c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0507f(S.x xVar, Continuation continuation) {
        super(continuation);
        this.f12165c = xVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f12163a = obj;
        this.f12164b |= Integer.MIN_VALUE;
        return this.f12165c.emit(null, this);
    }
}
