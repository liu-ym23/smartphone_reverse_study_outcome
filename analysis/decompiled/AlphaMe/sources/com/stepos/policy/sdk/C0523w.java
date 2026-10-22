package com.stepos.policy.sdk;

import android.content.Context;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: com.stepos.policy.sdk.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0523w extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Context f12275a;

    /* renamed from: b, reason: collision with root package name */
    public String f12276b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f12277c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f12278d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ PolicyManager f12279e;

    /* renamed from: f, reason: collision with root package name */
    public int f12280f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0523w(PolicyManager policyManager, Continuation continuation) {
        super(continuation);
        this.f12279e = policyManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f12278d = obj;
        this.f12280f |= Integer.MIN_VALUE;
        return this.f12279e.savePolicyOperate(null, false, null, this);
    }
}
