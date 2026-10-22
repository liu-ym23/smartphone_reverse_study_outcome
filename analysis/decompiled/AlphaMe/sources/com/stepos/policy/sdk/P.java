package com.stepos.policy.sdk;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes.dex */
public final class P extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f12048a;

    /* renamed from: b, reason: collision with root package name */
    public int f12049b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ x0.i f12050c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public P(x0.i iVar, Continuation continuation) {
        super(continuation);
        this.f12050c = iVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f12048a = obj;
        this.f12049b |= Integer.MIN_VALUE;
        return this.f12050c.emit(null, this);
    }
}
