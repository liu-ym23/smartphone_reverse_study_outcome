package v4;

import V3.v;

/* renamed from: v4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1192a<T> implements InterfaceC1193b<T> {

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.AbstractFlow", f = "Flow.kt", l = {226}, m = "collect")
    /* renamed from: v4.a$a, reason: collision with other inner class name */
    static final class C0253a extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a, reason: collision with root package name */
        Object f23348a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f23349b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AbstractC1192a<T> f23350c;

        /* renamed from: d, reason: collision with root package name */
        int f23351d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0253a(AbstractC1192a<T> abstractC1192a, Z3.e<? super C0253a> eVar) {
            super(eVar);
            this.f23350c = abstractC1192a;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.f23349b = obj;
            this.f23351d |= Integer.MIN_VALUE;
            return this.f23350c.a(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // v4.InterfaceC1193b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(v4.InterfaceC1194c<? super T> r5, Z3.e<? super V3.v> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof v4.AbstractC1192a.C0253a
            if (r0 == 0) goto L13
            r0 = r6
            v4.a$a r0 = (v4.AbstractC1192a.C0253a) r0
            int r1 = r0.f23351d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f23351d = r1
            goto L18
        L13:
            v4.a$a r0 = new v4.a$a
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f23349b
            java.lang.Object r1 = a4.C0428b.e()
            int r2 = r0.f23351d
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r4 = r0.f23348a
            w4.i r4 = (w4.i) r4
            V3.o.b(r6)     // Catch: java.lang.Throwable -> L2d
            goto L4f
        L2d:
            r5 = move-exception
            goto L57
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            V3.o.b(r6)
            w4.i r6 = new w4.i
            Z3.i r2 = r0.getContext()
            r6.<init>(r5, r2)
            r0.f23348a = r6     // Catch: java.lang.Throwable -> L55
            r0.f23351d = r3     // Catch: java.lang.Throwable -> L55
            java.lang.Object r4 = r4.b(r6, r0)     // Catch: java.lang.Throwable -> L55
            if (r4 != r1) goto L4e
            return r1
        L4e:
            r4 = r6
        L4f:
            r4.releaseIntercepted()
            V3.v r4 = V3.v.f5542a
            return r4
        L55:
            r5 = move-exception
            r4 = r6
        L57:
            r4.releaseIntercepted()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: v4.AbstractC1192a.a(v4.c, Z3.e):java.lang.Object");
    }

    public abstract Object b(InterfaceC1194c<? super T> interfaceC1194c, Z3.e<? super v> eVar);
}
