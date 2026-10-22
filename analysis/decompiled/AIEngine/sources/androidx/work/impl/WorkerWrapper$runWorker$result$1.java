package androidx.work.impl;

import android.content.Context;
import androidx.work.c;
import h2.j;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "androidx.work.impl.WorkerWrapper$runWorker$result$1", f = "WorkerWrapper.kt", l = {300, 311}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class WorkerWrapper$runWorker$result$1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super c.a>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f2857a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f2858b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ androidx.work.c f2859c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ r2.p f2860d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkerWrapper$runWorker$result$1(d dVar, androidx.work.c cVar, r2.p pVar, qb.b bVar) {
        super(2, bVar);
        this.f2858b = dVar;
        this.f2859c = cVar;
        this.f2860d = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        return new WorkerWrapper$runWorker$result$1(this.f2858b, this.f2859c, this.f2860d, bVar);
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super c.a> bVar) {
        return ((WorkerWrapper$runWorker$result$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        WorkerWrapper$runWorker$result$1 workerWrapper$runWorker$result$1;
        d dVar = this.f2858b;
        q2.p pVar = dVar.f2941a;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f2857a;
        androidx.work.c cVar = this.f2859c;
        if (i10 == 0) {
            kotlin.c.b(obj);
            Context context = dVar.f2942b;
            s2.c cVar2 = dVar.f2945e;
            this.f2857a = 1;
            workerWrapper$runWorker$result$1 = this;
            if (androidx.work.impl.utils.b.a(context, pVar, cVar, this.f2860d, cVar2, workerWrapper$runWorker$result$1) != coroutineSingletons) {
            }
        }
        if (i10 != 1) {
            if (i10 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            return obj;
        }
        kotlin.c.b(obj);
        workerWrapper$runWorker$result$1 = this;
        String str = e.f2965a;
        j.d().a(str, "Starting work for " + pVar.f11507c);
        c5.a<c.a> aVarStartWork = cVar.startWork();
        g.e(aVarStartWork, "worker.startWork()");
        workerWrapper$runWorker$result$1.f2857a = 2;
        Object objA = e.a(aVarStartWork, cVar, workerWrapper$runWorker$result$1);
        return objA == coroutineSingletons ? coroutineSingletons : objA;
    }
}
