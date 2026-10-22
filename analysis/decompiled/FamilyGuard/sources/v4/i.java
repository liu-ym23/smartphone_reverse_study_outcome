package v4;

import j4.v;
import w4.C1272a;

/* loaded from: classes.dex */
final /* synthetic */ class i {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements InterfaceC1194c<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ v f23362a;

        public a(v vVar) {
            this.f23362a = vVar;
        }

        @Override // v4.InterfaceC1194c
        public Object g(T t5, Z3.e<? super V3.v> eVar) {
            this.f23362a.f17836a = t5;
            throw new C1272a(this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {179}, m = "first")
    static final class b<T> extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a, reason: collision with root package name */
        Object f23363a;

        /* renamed from: b, reason: collision with root package name */
        Object f23364b;

        /* renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f23365c;

        /* renamed from: d, reason: collision with root package name */
        int f23366d;

        b(Z3.e<? super b> eVar) {
            super(eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.f23365c = obj;
            this.f23366d |= Integer.MIN_VALUE;
            return d.d(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0068 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object a(v4.InterfaceC1193b<? extends T> r4, Z3.e<? super T> r5) {
        /*
            boolean r0 = r5 instanceof v4.i.b
            if (r0 == 0) goto L13
            r0 = r5
            v4.i$b r0 = (v4.i.b) r0
            int r1 = r0.f23366d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f23366d = r1
            goto L18
        L13:
            v4.i$b r0 = new v4.i$b
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f23365c
            java.lang.Object r1 = a4.C0428b.e()
            int r2 = r0.f23366d
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r4 = r0.f23364b
            v4.i$a r4 = (v4.i.a) r4
            java.lang.Object r0 = r0.f23363a
            j4.v r0 = (j4.v) r0
            V3.o.b(r5)     // Catch: w4.C1272a -> L31
            goto L62
        L31:
            r5 = move-exception
            goto L5f
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            V3.o.b(r5)
            j4.v r5 = new j4.v
            r5.<init>()
            x4.F r2 = w4.h.f23721a
            r5.f17836a = r2
            v4.i$a r2 = new v4.i$a
            r2.<init>(r5)
            r0.f23363a = r5     // Catch: w4.C1272a -> L5b
            r0.f23364b = r2     // Catch: w4.C1272a -> L5b
            r0.f23366d = r3     // Catch: w4.C1272a -> L5b
            java.lang.Object r4 = r4.a(r2, r0)     // Catch: w4.C1272a -> L5b
            if (r4 != r1) goto L59
            return r1
        L59:
            r0 = r5
            goto L62
        L5b:
            r4 = move-exception
            r0 = r5
            r5 = r4
            r4 = r2
        L5f:
            w4.f.a(r5, r4)
        L62:
            T r4 = r0.f17836a
            x4.F r5 = w4.h.f23721a
            if (r4 == r5) goto L69
            return r4
        L69:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.String r5 = "Expected at least one element"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: v4.i.a(v4.b, Z3.e):java.lang.Object");
    }
}
