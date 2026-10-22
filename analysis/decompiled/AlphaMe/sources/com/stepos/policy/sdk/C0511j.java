package com.stepos.policy.sdk;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: com.stepos.policy.sdk.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0511j extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f12201a;

    /* renamed from: b, reason: collision with root package name */
    public int f12202b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ S.x f12203c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0511j(S.x xVar, Continuation continuation) {
        super(continuation);
        this.f12203c = xVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f12201a = obj;
        this.f12202b |= Integer.MIN_VALUE;
        return this.f12203c.emit(null, this);
    }
}
