package androidx.work.impl;

import android.content.Context;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lb.n;
import r2.h;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "androidx.work.impl.UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$2", f = "UnfinishedWorkListener.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$2 extends SuspendLambda implements p<Boolean, qb.b<? super n>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ boolean f2834a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f2835b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$2(Context context, qb.b<? super UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$2> bVar) {
        super(2, bVar);
        this.f2835b = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$2 unfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$2 = new UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$2(this.f2835b, bVar);
        unfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$2.f2834a = ((Boolean) obj).booleanValue();
        return unfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$2;
    }

    @Override // zb.p
    public final Object invoke(Boolean bool, qb.b<? super n> bVar) {
        Boolean bool2 = bool;
        bool2.booleanValue();
        return ((UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$2) create(bool2, bVar)).invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        kotlin.c.b(obj);
        h.a(this.f2835b, k2.e.class, this.f2834a);
        return n.f10413a;
    }
}
