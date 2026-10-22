package v4;

import V3.v;

/* loaded from: classes.dex */
public final class o<T> implements InterfaceC1194c<T> {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC1194c<T> f23381a;

    /* renamed from: b, reason: collision with root package name */
    private final i4.p<InterfaceC1194c<? super T>, Z3.e<? super v>, Object> f23382b;

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.SubscribedFlowCollector", f = "Share.kt", l = {415, 419}, m = "onSubscription")
    static final class a extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a, reason: collision with root package name */
        Object f23383a;

        /* renamed from: b, reason: collision with root package name */
        Object f23384b;

        /* renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f23385c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ o<T> f23386d;

        /* renamed from: e, reason: collision with root package name */
        int f23387e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(o<T> oVar, Z3.e<? super a> eVar) {
            super(eVar);
            this.f23386d = oVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.f23385c = obj;
            this.f23387e |= Integer.MIN_VALUE;
            return this.f23386d.a(this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0077, code lost:
    
        if (((v4.o) r7).a(r0) == r1) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(Z3.e<? super V3.v> r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof v4.o.a
            if (r0 == 0) goto L13
            r0 = r8
            v4.o$a r0 = (v4.o.a) r0
            int r1 = r0.f23387e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f23387e = r1
            goto L18
        L13:
            v4.o$a r0 = new v4.o$a
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f23385c
            java.lang.Object r1 = a4.C0428b.e()
            int r2 = r0.f23387e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            V3.o.b(r8)
            goto L7a
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            java.lang.Object r7 = r0.f23384b
            w4.i r7 = (w4.i) r7
            java.lang.Object r2 = r0.f23383a
            v4.o r2 = (v4.o) r2
            V3.o.b(r8)     // Catch: java.lang.Throwable -> L40
            goto L61
        L40:
            r8 = move-exception
            goto L84
        L42:
            V3.o.b(r8)
            w4.i r8 = new w4.i
            v4.c<T> r2 = r7.f23381a
            Z3.i r5 = r0.getContext()
            r8.<init>(r2, r5)
            i4.p<v4.c<? super T>, Z3.e<? super V3.v>, java.lang.Object> r2 = r7.f23382b     // Catch: java.lang.Throwable -> L80
            r0.f23383a = r7     // Catch: java.lang.Throwable -> L80
            r0.f23384b = r8     // Catch: java.lang.Throwable -> L80
            r0.f23387e = r4     // Catch: java.lang.Throwable -> L80
            java.lang.Object r2 = r2.invoke(r8, r0)     // Catch: java.lang.Throwable -> L80
            if (r2 != r1) goto L5f
            goto L79
        L5f:
            r2 = r7
            r7 = r8
        L61:
            r7.releaseIntercepted()
            v4.c<T> r7 = r2.f23381a
            boolean r8 = r7 instanceof v4.o
            if (r8 == 0) goto L7d
            v4.o r7 = (v4.o) r7
            r8 = 0
            r0.f23383a = r8
            r0.f23384b = r8
            r0.f23387e = r3
            java.lang.Object r7 = r7.a(r0)
            if (r7 != r1) goto L7a
        L79:
            return r1
        L7a:
            V3.v r7 = V3.v.f5542a
            return r7
        L7d:
            V3.v r7 = V3.v.f5542a
            return r7
        L80:
            r7 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        L84:
            r7.releaseIntercepted()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: v4.o.a(Z3.e):java.lang.Object");
    }

    @Override // v4.InterfaceC1194c
    public Object g(T t5, Z3.e<? super v> eVar) {
        return this.f23381a.g(t5, eVar);
    }
}
