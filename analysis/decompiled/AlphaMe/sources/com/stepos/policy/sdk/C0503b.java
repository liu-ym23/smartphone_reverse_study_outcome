package com.stepos.policy.sdk;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: com.stepos.policy.sdk.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0503b extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f12120a;

    /* renamed from: b, reason: collision with root package name */
    public int f12121b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ S.x f12122c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0503b(S.x xVar, Continuation continuation) {
        super(continuation);
        this.f12122c = xVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f12120a = obj;
        this.f12121b |= Integer.MIN_VALUE;
        return this.f12122c.emit(null, this);
    }
}
