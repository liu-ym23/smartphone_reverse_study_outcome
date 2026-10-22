package com.stepos.ability.manager.sync;

import J7.c;
import android.content.Context;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "com.stepos.ability.manager.sync.AbilitySyncCoordinator", f = "AbilitySyncCoordinator.kt", l = {418, 431, 433, 434}, m = "runCloudSyncPipeline", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class AbilitySyncCoordinator$runCloudSyncPipeline$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Context f3156a;
    public String b;
    public List c;
    public int d;
    public /* synthetic */ Object e;
    public final /* synthetic */ a f;
    public int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbilitySyncCoordinator$runCloudSyncPipeline$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.g |= Integer.MIN_VALUE;
        return a.a(this.f, null, this);
    }
}
