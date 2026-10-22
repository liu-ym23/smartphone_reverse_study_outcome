package com.stepos.policy.sdk;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes.dex */
public final class I extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f12013a;

    /* renamed from: b, reason: collision with root package name */
    public int f12014b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ S.x f12015c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I(S.x xVar, Continuation continuation) {
        super(continuation);
        this.f12015c = xVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f12013a = obj;
        this.f12014b |= Integer.MIN_VALUE;
        return this.f12015c.emit(null, this);
    }
}
