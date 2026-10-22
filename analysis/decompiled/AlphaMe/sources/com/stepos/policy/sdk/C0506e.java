package com.stepos.policy.sdk;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: com.stepos.policy.sdk.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0506e extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f12152a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PolicyManager f12153b;

    /* renamed from: c, reason: collision with root package name */
    public int f12154c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0506e(PolicyManager policyManager, Continuation continuation) {
        super(continuation);
        this.f12153b = policyManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f12152a = obj;
        this.f12154c |= Integer.MIN_VALUE;
        return this.f12153b.getPolicyOperate(null, this);
    }
}
