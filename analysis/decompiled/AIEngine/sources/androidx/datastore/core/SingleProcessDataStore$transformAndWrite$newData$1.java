package androidx.datastore.core;

import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "androidx.datastore.core.SingleProcessDataStore$transformAndWrite$newData$1", f = "SingleProcessDataStore.kt", l = {402}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class SingleProcessDataStore$transformAndWrite$newData$1 extends SuspendLambda implements p<CoroutineScope, qb.b<Object>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f1663a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p<Object, qb.b<Object>, Object> f1664b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1665c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SingleProcessDataStore$transformAndWrite$newData$1(p<Object, ? super qb.b<Object>, ? extends Object> pVar, Object obj, qb.b<? super SingleProcessDataStore$transformAndWrite$newData$1> bVar) {
        super(2, bVar);
        this.f1664b = pVar;
        this.f1665c = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        return new SingleProcessDataStore$transformAndWrite$newData$1(this.f1664b, this.f1665c, bVar);
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<Object> bVar) {
        return ((SingleProcessDataStore$transformAndWrite$newData$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f1663a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            return obj;
        }
        kotlin.c.b(obj);
        this.f1663a = 1;
        Object objInvoke = this.f1664b.invoke(this.f1665c, this);
        return objInvoke == coroutineSingletons ? coroutineSingletons : objInvoke;
    }
}
