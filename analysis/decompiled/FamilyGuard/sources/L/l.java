package L;

import V3.v;
import i4.InterfaceC0772l;
import i4.p;
import java.util.concurrent.atomic.AtomicInteger;
import s4.C1076i;
import s4.I;
import s4.n0;
import u4.C1167e;
import u4.C1168f;
import u4.C1171i;
import u4.InterfaceC1166d;

/* loaded from: classes.dex */
public final class l<T> {

    /* renamed from: a, reason: collision with root package name */
    private final I f3694a;

    /* renamed from: b, reason: collision with root package name */
    private final p<T, Z3.e<? super v>, Object> f3695b;

    /* renamed from: c, reason: collision with root package name */
    private final InterfaceC1166d<T> f3696c;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicInteger f3697d;

    static final class a extends j4.l implements InterfaceC0772l<Throwable, v> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC0772l<Throwable, v> f3698a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ l<T> f3699b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ p<T, Throwable, v> f3700c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(InterfaceC0772l<? super Throwable, v> interfaceC0772l, l<T> lVar, p<? super T, ? super Throwable, v> pVar) {
            super(1);
            this.f3698a = interfaceC0772l;
            this.f3699b = lVar;
            this.f3700c = pVar;
        }

        public final void b(Throwable th) {
            v vVar;
            this.f3698a.invoke(th);
            ((l) this.f3699b).f3696c.c(th);
            do {
                Object objF = C1168f.f(((l) this.f3699b).f3696c.b());
                if (objF == null) {
                    vVar = null;
                } else {
                    this.f3700c.invoke(objF, th);
                    vVar = v.f5542a;
                }
            } while (vVar != null);
        }

        @Override // i4.InterfaceC0772l
        public /* bridge */ /* synthetic */ v invoke(Throwable th) {
            b(th);
            return v.f5542a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "androidx.datastore.core.SimpleActor$offer$2", f = "SimpleActor.kt", l = {122, 122}, m = "invokeSuspend")
    static final class b extends kotlin.coroutines.jvm.internal.l implements p<I, Z3.e<? super v>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f3701a;

        /* renamed from: b, reason: collision with root package name */
        int f3702b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ l<T> f3703c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(l<T> lVar, Z3.e<? super b> eVar) {
            super(2, eVar);
            this.f3703c = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
            return new b(this.f3703c, eVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x005f, code lost:
        
            if (r1.invoke(r6, r5) != r0) goto L21;
         */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0056 A[PHI: r1 r6
          0x0056: PHI (r1v1 i4.p) = (r1v2 i4.p), (r1v4 i4.p) binds: [B:16:0x0053, B:9:0x001a] A[DONT_GENERATE, DONT_INLINE]
          0x0056: PHI (r6v8 java.lang.Object) = (r6v15 java.lang.Object), (r6v0 java.lang.Object) binds: [B:16:0x0053, B:9:0x001a] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005f -> B:21:0x0062). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = a4.C0428b.e()
                int r1 = r5.f3702b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                V3.o.b(r6)
                goto L62
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1a:
                java.lang.Object r1 = r5.f3701a
                i4.p r1 = (i4.p) r1
                V3.o.b(r6)
                goto L56
            L22:
                V3.o.b(r6)
                L.l<T> r6 = r5.f3703c
                java.util.concurrent.atomic.AtomicInteger r6 = L.l.c(r6)
                int r6 = r6.get()
                if (r6 <= 0) goto L33
                r6 = r3
                goto L34
            L33:
                r6 = 0
            L34:
                if (r6 == 0) goto L71
            L36:
                L.l<T> r6 = r5.f3703c
                s4.I r6 = L.l.d(r6)
                s4.J.c(r6)
                L.l<T> r6 = r5.f3703c
                i4.p r1 = L.l.a(r6)
                L.l<T> r6 = r5.f3703c
                u4.d r6 = L.l.b(r6)
                r5.f3701a = r1
                r5.f3702b = r3
                java.lang.Object r6 = r6.a(r5)
                if (r6 != r0) goto L56
                goto L61
            L56:
                r4 = 0
                r5.f3701a = r4
                r5.f3702b = r2
                java.lang.Object r6 = r1.invoke(r6, r5)
                if (r6 != r0) goto L62
            L61:
                return r0
            L62:
                L.l<T> r6 = r5.f3703c
                java.util.concurrent.atomic.AtomicInteger r6 = L.l.c(r6)
                int r6 = r6.decrementAndGet()
                if (r6 != 0) goto L36
                V3.v r5 = V3.v.f5542a
                return r5
            L71:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "Check failed."
                r5.<init>(r6)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: L.l.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // i4.p
        public final Object invoke(I i5, Z3.e<? super v> eVar) {
            return ((b) create(i5, eVar)).invokeSuspend(v.f5542a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(I i5, InterfaceC0772l<? super Throwable, v> interfaceC0772l, p<? super T, ? super Throwable, v> pVar, p<? super T, ? super Z3.e<? super v>, ? extends Object> pVar2) {
        j4.k.g(i5, "scope");
        j4.k.g(interfaceC0772l, "onComplete");
        j4.k.g(pVar, "onUndeliveredElement");
        j4.k.g(pVar2, "consumeMessage");
        this.f3694a = i5;
        this.f3695b = pVar2;
        this.f3696c = C1167e.b(Integer.MAX_VALUE, null, null, 6, null);
        this.f3697d = new AtomicInteger(0);
        n0 n0Var = (n0) i5.G().a(n0.f20363P);
        if (n0Var == null) {
            return;
        }
        n0Var.u(new a(interfaceC0772l, this, pVar));
    }

    public final void e(T t5) throws Throwable {
        Object objD = this.f3696c.d(t5);
        if (objD instanceof C1168f.a) {
            Throwable thE = C1168f.e(objD);
            if (thE != null) {
                throw thE;
            }
            throw new C1171i("Channel was closed normally");
        }
        if (!C1168f.i(objD)) {
            throw new IllegalStateException("Check failed.");
        }
        if (this.f3697d.getAndIncrement() == 0) {
            C1076i.b(this.f3694a, null, null, new b(this, null), 3, null);
        }
    }
}
