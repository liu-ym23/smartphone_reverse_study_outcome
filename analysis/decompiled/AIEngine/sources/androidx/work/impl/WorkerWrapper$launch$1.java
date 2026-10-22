package androidx.work.impl;

import androidx.work.impl.d;
import h2.j;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "androidx.work.impl.WorkerWrapper$launch$1", f = "WorkerWrapper.kt", l = {98}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class WorkerWrapper$launch$1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super Boolean>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f2845a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f2846b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkerWrapper$launch$1(d dVar, qb.b<? super WorkerWrapper$launch$1> bVar) {
        super(2, bVar);
        this.f2846b = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        return new WorkerWrapper$launch$1(this.f2846b, bVar);
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super Boolean> bVar) {
        return ((WorkerWrapper$launch$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object aVar;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f2845a;
        d dVar = this.f2846b;
        try {
            if (i10 == 0) {
                kotlin.c.b(obj);
                CompletableJob completableJob = dVar.f2953n;
                WorkerWrapper$launch$1$resolution$1 workerWrapper$launch$1$resolution$1 = new WorkerWrapper$launch$1$resolution$1(dVar, null);
                this.f2845a = 1;
                obj = BuildersKt.withContext(completableJob, workerWrapper$launch$1$resolution$1, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            aVar = (d.b) obj;
        } catch (WorkerStoppedException e10) {
            aVar = new d.b.c(e10.f2844a);
        } catch (CancellationException unused) {
            aVar = new d.b.a(0);
        } catch (Throwable th) {
            j.d().c(e.f2965a, "Unexpected error in WorkerWrapper", th);
            aVar = new d.b.a(0);
        }
        Object objN = dVar.f2948i.n(new com.stepos.core.ota.a(1, aVar, dVar));
        g.e(objN, "workDatabase.runInTransa…          }\n            )");
        return objN;
    }
}
