package androidx.work;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "androidx.work.ListenableFutureKt$launchFuture$1$2", f = "ListenableFuture.kt", l = {42}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class ListenableFutureKt$launchFuture$1$2 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f2779a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2780b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SuspendLambda f2781c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a<Object> f2782d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ListenableFutureKt$launchFuture$1$2(p<? super CoroutineScope, ? super qb.b<Object>, ? extends Object> pVar, CallbackToFutureAdapter.a<Object> aVar, qb.b<? super ListenableFutureKt$launchFuture$1$2> bVar) {
        super(2, bVar);
        this.f2781c = (SuspendLambda) pVar;
        this.f2782d = aVar;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.coroutines.jvm.internal.SuspendLambda, zb.p] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        ListenableFutureKt$launchFuture$1$2 listenableFutureKt$launchFuture$1$2 = new ListenableFutureKt$launchFuture$1$2(this.f2781c, this.f2782d, bVar);
        listenableFutureKt$launchFuture$1$2.f2780b = obj;
        return listenableFutureKt$launchFuture$1$2;
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
        return ((ListenableFutureKt$launchFuture$1$2) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.coroutines.jvm.internal.SuspendLambda, zb.p] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f2779a;
        CallbackToFutureAdapter.a<Object> aVar = this.f2782d;
        try {
            if (i10 == 0) {
                kotlin.c.b(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.f2780b;
                ?? r12 = this.f2781c;
                this.f2779a = 1;
                obj = r12.invoke(coroutineScope, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            aVar.a(obj);
        } catch (CancellationException unused) {
            aVar.f1025d = true;
            CallbackToFutureAdapter.c<Object> cVar = aVar.f1023b;
            if (cVar != null && cVar.f1027b.cancel(true)) {
                aVar.f1022a = null;
                aVar.f1023b = null;
                aVar.f1024c = null;
            }
        } catch (Throwable th) {
            aVar.b(th);
        }
        return n.f10413a;
    }
}
