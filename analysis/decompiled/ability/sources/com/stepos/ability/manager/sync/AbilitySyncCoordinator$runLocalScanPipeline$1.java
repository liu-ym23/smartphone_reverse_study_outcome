package com.stepos.ability.manager.sync;

import J7.c;
import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import m9.InterfaceC1723p;

@c(c = "com.stepos.ability.manager.sync.AbilitySyncCoordinator", f = "AbilitySyncCoordinator.kt", l = {336, 339, 363, 368}, m = "runLocalScanPipeline", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class AbilitySyncCoordinator$runLocalScanPipeline$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Context f3157a;
    public InterfaceC1723p b;
    public com.stepos.ability.manager.discovery.a c;
    public Z3.a d;
    public long e;
    public long f;
    public /* synthetic */ Object g;
    public final /* synthetic */ a h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbilitySyncCoordinator$runLocalScanPipeline$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.h = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.g = obj;
        this.i |= Integer.MIN_VALUE;
        return a.b(this.h, null, null, this);
    }
}
