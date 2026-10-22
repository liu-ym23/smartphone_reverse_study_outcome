package com.stepos.policy.sdk;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes.dex */
public final class M extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f12040a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PolicyManager f12041b;

    /* renamed from: c, reason: collision with root package name */
    public int f12042c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M(PolicyManager policyManager, Continuation continuation) {
        super(continuation);
        this.f12041b = policyManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f12040a = obj;
        this.f12042c |= Integer.MIN_VALUE;
        return this.f12041b.getAgreeStatus(null, this);
    }
}
