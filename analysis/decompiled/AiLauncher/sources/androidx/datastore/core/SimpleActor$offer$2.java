package androidx.datastore.core;

import Ua.M;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {1, 5, 1})
@InterfaceC4112d(c = "androidx.datastore.core.SimpleActor$offer$2", f = "SimpleActor.kt", l = {122, 122}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SimpleActor$offer$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f13282a;

    /* renamed from: b, reason: collision with root package name */
    public int f13283b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SimpleActor<T> f13284c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleActor$offer$2(SimpleActor<T> simpleActor, InterfaceC4014c<? super SimpleActor$offer$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f13284c = simpleActor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SimpleActor$offer$2(this.f13284c, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((SimpleActor$offer$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x005f, code lost:
    
        if (r1.invoke(r6, r5) != r0) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0056 A[PHI: r1 r6
      0x0056: PHI (r1v1 p9.p) = (r1v2 p9.p), (r1v4 p9.p) binds: [B:16:0x0053, B:9:0x001a] A[DONT_GENERATE, DONT_INLINE]
      0x0056: PHI (r6v8 java.lang.Object) = (r6v15 java.lang.Object), (r6v0 java.lang.Object) binds: [B:16:0x0053, B:9:0x001a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005f -> B:21:0x0062). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r5.f13283b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.C4849c.b(r6)
            goto L62
        L12:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L1a:
            java.lang.Object r1 = r5.f13282a
            p9.p r1 = (p9.p) r1
            kotlin.C4849c.b(r6)
            goto L56
        L22:
            kotlin.C4849c.b(r6)
            androidx.datastore.core.SimpleActor<T> r6 = r5.f13284c
            java.util.concurrent.atomic.AtomicInteger r6 = androidx.datastore.core.SimpleActor.c(r6)
            int r6 = r6.get()
            if (r6 <= 0) goto L33
            r6 = r3
            goto L34
        L33:
            r6 = 0
        L34:
            if (r6 == 0) goto L71
        L36:
            androidx.datastore.core.SimpleActor<T> r6 = r5.f13284c
            Ua.M r6 = androidx.datastore.core.SimpleActor.d(r6)
            kotlinx.coroutines.d.g(r6)
            androidx.datastore.core.SimpleActor<T> r6 = r5.f13284c
            p9.p r1 = androidx.datastore.core.SimpleActor.a(r6)
            androidx.datastore.core.SimpleActor<T> r6 = r5.f13284c
            Wa.g r6 = androidx.datastore.core.SimpleActor.b(r6)
            r5.f13282a = r1
            r5.f13283b = r3
            java.lang.Object r6 = r6.receive(r5)
            if (r6 != r0) goto L56
            goto L61
        L56:
            r4 = 0
            r5.f13282a = r4
            r5.f13283b = r2
            java.lang.Object r6 = r1.invoke(r6, r5)
            if (r6 != r0) goto L62
        L61:
            return r0
        L62:
            androidx.datastore.core.SimpleActor<T> r6 = r5.f13284c
            java.util.concurrent.atomic.AtomicInteger r6 = androidx.datastore.core.SimpleActor.c(r6)
            int r6 = r6.decrementAndGet()
            if (r6 != 0) goto L36
            Y8.t r5 = Y8.t.f7040a
            return r5
        L71:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "Check failed."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SimpleActor$offer$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
