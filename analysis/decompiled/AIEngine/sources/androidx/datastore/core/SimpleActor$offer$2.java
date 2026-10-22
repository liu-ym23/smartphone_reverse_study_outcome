package androidx.datastore.core;

import com.stepos.core.ota.crypto.FekEnvelope;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "androidx.datastore.core.SimpleActor$offer$2", f = "SimpleActor.kt", l = {FekEnvelope.EXPECTED_EPK_CHARS, FekEnvelope.EXPECTED_EPK_CHARS}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class SimpleActor$offer$2 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f1601a;

    /* renamed from: b, reason: collision with root package name */
    public int f1602b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SimpleActor<Object> f1603c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleActor$offer$2(SimpleActor<Object> simpleActor, qb.b<? super SimpleActor$offer$2> bVar) {
        super(2, bVar);
        this.f1603c = simpleActor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        return new SimpleActor$offer$2(this.f1603c, bVar);
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
        return ((SimpleActor$offer$2) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004a, code lost:
    
        if (r3.invoke(r8, r7) != r2) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0041 A[PHI: r3 r8
      0x0041: PHI (r3v1 zb.p<java.lang.Object, qb.b<? super lb.n>, java.lang.Object>) = 
      (r3v2 zb.p<java.lang.Object, qb.b<? super lb.n>, java.lang.Object>)
      (r3v4 zb.p<java.lang.Object, qb.b<? super lb.n>, java.lang.Object>)
     binds: [B:13:0x003e, B:9:0x001c] A[DONT_GENERATE, DONT_INLINE]
      0x0041: PHI (r8v3 java.lang.Object) = (r8v7 java.lang.Object), (r8v0 java.lang.Object) binds: [B:13:0x003e, B:9:0x001c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004a -> B:18:0x004d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            androidx.datastore.core.SimpleActor<java.lang.Object> r0 = r7.f1603c
            java.util.concurrent.atomic.AtomicInteger r1 = r0.f1597d
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r3 = r7.f1602b
            r4 = 2
            r5 = 1
            if (r3 == 0) goto L24
            if (r3 == r5) goto L1c
            if (r3 != r4) goto L14
            kotlin.c.b(r8)
            goto L4d
        L14:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L1c:
            java.lang.Object r3 = r7.f1601a
            zb.p r3 = (zb.p) r3
            kotlin.c.b(r8)
            goto L41
        L24:
            kotlin.c.b(r8)
            int r8 = r1.get()
            if (r8 <= 0) goto L56
        L2d:
            kotlinx.coroutines.CoroutineScope r8 = r0.f1594a
            kotlinx.coroutines.CoroutineScopeKt.ensureActive(r8)
            zb.p<T, qb.b<? super lb.n>, java.lang.Object> r3 = r0.f1595b
            kotlinx.coroutines.channels.Channel<T> r8 = r0.f1596c
            r7.f1601a = r3
            r7.f1602b = r5
            java.lang.Object r8 = r8.receive(r7)
            if (r8 != r2) goto L41
            goto L4c
        L41:
            r6 = 0
            r7.f1601a = r6
            r7.f1602b = r4
            java.lang.Object r8 = r3.invoke(r8, r7)
            if (r8 != r2) goto L4d
        L4c:
            return r2
        L4d:
            int r8 = r1.decrementAndGet()
            if (r8 != 0) goto L2d
            lb.n r7 = lb.n.f10413a
            return r7
        L56:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Check failed."
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SimpleActor$offer$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
