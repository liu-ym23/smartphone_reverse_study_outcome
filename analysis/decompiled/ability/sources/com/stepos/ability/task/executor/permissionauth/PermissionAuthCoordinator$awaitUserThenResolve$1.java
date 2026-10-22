package com.stepos.ability.task.executor.permissionauth;

import J7.c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import z4.p;

@c(c = "com.stepos.ability.task.executor.permissionauth.PermissionAuthCoordinator", f = "PermissionAuthCoordinator.kt", l = {29, 34}, m = "awaitUserThenResolve", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class PermissionAuthCoordinator$awaitUserThenResolve$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public String f3315a;
    public p b;
    public Object c;
    public /* synthetic */ Object d;
    public final /* synthetic */ a e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PermissionAuthCoordinator$awaitUserThenResolve$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.e = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f |= Integer.MIN_VALUE;
        return this.e.a(null, null, null, null, this);
    }
}
