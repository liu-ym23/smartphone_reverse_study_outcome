package androidx.work.impl;

import androidx.work.impl.d;
import java.lang.reflect.InvocationTargetException;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "androidx.work.impl.WorkerWrapper$launch$1$resolution$1", f = "WorkerWrapper.kt", l = {98}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class WorkerWrapper$launch$1$resolution$1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super d.b>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f2847a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f2848b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkerWrapper$launch$1$resolution$1(d dVar, qb.b<? super WorkerWrapper$launch$1$resolution$1> bVar) {
        super(2, bVar);
        this.f2848b = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        return new WorkerWrapper$launch$1$resolution$1(this.f2848b, bVar);
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super d.b> bVar) {
        return ((WorkerWrapper$launch$1$resolution$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f2847a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            return obj;
        }
        kotlin.c.b(obj);
        this.f2847a = 1;
        Object objA = d.a(this.f2848b, this);
        return objA == coroutineSingletons ? coroutineSingletons : objA;
    }
}
