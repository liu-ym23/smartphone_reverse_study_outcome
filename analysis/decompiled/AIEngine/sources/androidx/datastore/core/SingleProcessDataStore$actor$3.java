package androidx.datastore.core;

import androidx.datastore.core.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lb.n;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "androidx.datastore.core.SingleProcessDataStore$actor$3", f = "SingleProcessDataStore.kt", l = {239, 242}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class SingleProcessDataStore$actor$3 extends SuspendLambda implements p<c.a<Object>, qb.b<? super n>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f1611a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1612b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c<Object> f1613c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$actor$3(c<Object> cVar, qb.b<? super SingleProcessDataStore$actor$3> bVar) {
        super(2, bVar);
        this.f1613c = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        SingleProcessDataStore$actor$3 singleProcessDataStore$actor$3 = new SingleProcessDataStore$actor$3(this.f1613c, bVar);
        singleProcessDataStore$actor$3.f1612b = obj;
        return singleProcessDataStore$actor$3;
    }

    @Override // zb.p
    public final Object invoke(c.a<Object> aVar, qb.b<? super n> bVar) {
        return ((SingleProcessDataStore$actor$3) create(aVar, bVar)).invokeSuspend(n.f10413a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0061, code lost:
    
        if (r5 == r0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0078, code lost:
    
        if (androidx.datastore.core.c.b(r4, (androidx.datastore.core.c.a.b) r6, r5) == r0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x007a, code lost:
    
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r5.f1611a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L19
            if (r1 == r3) goto L15
            if (r1 != r2) goto Ld
            goto L15
        Ld:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L15:
            kotlin.c.b(r6)
            goto L7b
        L19:
            kotlin.c.b(r6)
            java.lang.Object r6 = r5.f1612b
            androidx.datastore.core.c$a r6 = (androidx.datastore.core.c.a) r6
            boolean r1 = r6 instanceof androidx.datastore.core.c.a.C0011a
            androidx.datastore.core.c<java.lang.Object> r4 = r5.f1613c
            if (r1 == 0) goto L6c
            androidx.datastore.core.c$a$a r6 = (androidx.datastore.core.c.a.C0011a) r6
            r5.f1611a = r3
            kotlinx.coroutines.flow.MutableStateFlow<d1.g<T>> r1 = r4.f1680g
            java.lang.Object r1 = r1.getValue()
            d1.g r1 = (d1.g) r1
            boolean r2 = r1 instanceof d1.a
            if (r2 == 0) goto L37
            goto L5f
        L37:
            boolean r2 = r1 instanceof d1.f
            if (r2 == 0) goto L49
            d1.g<T> r6 = r6.f1682a
            if (r1 != r6) goto L5f
            java.lang.Object r5 = r4.f(r5)
            if (r5 != r0) goto L46
            goto L61
        L46:
            lb.n r5 = lb.n.f10413a
            goto L61
        L49:
            d1.h r6 = d1.h.f8262a
            boolean r6 = kotlin.jvm.internal.g.b(r1, r6)
            if (r6 == 0) goto L5b
            java.lang.Object r5 = r4.f(r5)
            if (r5 != r0) goto L58
            goto L61
        L58:
            lb.n r5 = lb.n.f10413a
            goto L61
        L5b:
            boolean r5 = r1 instanceof d1.d
            if (r5 != 0) goto L64
        L5f:
            lb.n r5 = lb.n.f10413a
        L61:
            if (r5 != r0) goto L7b
            goto L7a
        L64:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "Can't read in final state."
            r5.<init>(r6)
            throw r5
        L6c:
            boolean r1 = r6 instanceof androidx.datastore.core.c.a.b
            if (r1 == 0) goto L7b
            androidx.datastore.core.c$a$b r6 = (androidx.datastore.core.c.a.b) r6
            r5.f1611a = r2
            java.lang.Object r5 = androidx.datastore.core.c.b(r4, r6, r5)
            if (r5 != r0) goto L7b
        L7a:
            return r0
        L7b:
            lb.n r5 = lb.n.f10413a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore$actor$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
