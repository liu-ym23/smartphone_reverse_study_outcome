package R4;

import V3.n;
import a4.C0428b;
import i4.InterfaceC0772l;
import java.lang.reflect.Method;
import s4.C1082l;
import s4.InterfaceC1080k;

/* loaded from: classes.dex */
public final class m {

    static final class a extends j4.l implements InterfaceC0772l<Throwable, V3.v> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ R4.b f5034a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(R4.b bVar) {
            super(1);
            this.f5034a = bVar;
        }

        public final void b(Throwable th) {
            this.f5034a.cancel();
        }

        @Override // i4.InterfaceC0772l
        public /* bridge */ /* synthetic */ V3.v invoke(Throwable th) {
            b(th);
            return V3.v.f5542a;
        }
    }

    static final class b extends j4.l implements InterfaceC0772l<Throwable, V3.v> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ R4.b f5035a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(R4.b bVar) {
            super(1);
            this.f5035a = bVar;
        }

        public final void b(Throwable th) {
            this.f5035a.cancel();
        }

        @Override // i4.InterfaceC0772l
        public /* bridge */ /* synthetic */ V3.v invoke(Throwable th) {
            b(th);
            return V3.v.f5542a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class c<T> implements R4.d<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC1080k f5036a;

        c(InterfaceC1080k interfaceC1080k) {
            this.f5036a = interfaceC1080k;
        }

        @Override // R4.d
        public void a(R4.b<T> bVar, t<T> tVar) {
            j4.k.h(bVar, "call");
            j4.k.h(tVar, "response");
            if (!tVar.e()) {
                InterfaceC1080k interfaceC1080k = this.f5036a;
                j jVar = new j(tVar);
                n.a aVar = V3.n.f5531a;
                interfaceC1080k.resumeWith(V3.n.a(V3.o.a(jVar)));
                return;
            }
            T tA = tVar.a();
            if (tA != null) {
                this.f5036a.resumeWith(V3.n.a(tA));
                return;
            }
            Object objH = bVar.a().h(l.class);
            if (objH == null) {
                j4.k.p();
            }
            j4.k.c(objH, "call.request().tag(Invocation::class.java)!!");
            Method methodA = ((l) objH).a();
            StringBuilder sb = new StringBuilder();
            sb.append("Response from ");
            j4.k.c(methodA, "method");
            Class<?> declaringClass = methodA.getDeclaringClass();
            j4.k.c(declaringClass, "method.declaringClass");
            sb.append(declaringClass.getName());
            sb.append('.');
            sb.append(methodA.getName());
            sb.append(" was null but response body type was declared as non-null");
            V3.e eVar = new V3.e(sb.toString());
            InterfaceC1080k interfaceC1080k2 = this.f5036a;
            n.a aVar2 = V3.n.f5531a;
            interfaceC1080k2.resumeWith(V3.n.a(V3.o.a(eVar)));
        }

        @Override // R4.d
        public void b(R4.b<T> bVar, Throwable th) {
            j4.k.h(bVar, "call");
            j4.k.h(th, "t");
            InterfaceC1080k interfaceC1080k = this.f5036a;
            n.a aVar = V3.n.f5531a;
            interfaceC1080k.resumeWith(V3.n.a(V3.o.a(th)));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class d<T> implements R4.d<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC1080k f5037a;

        d(InterfaceC1080k interfaceC1080k) {
            this.f5037a = interfaceC1080k;
        }

        @Override // R4.d
        public void a(R4.b<T> bVar, t<T> tVar) {
            j4.k.h(bVar, "call");
            j4.k.h(tVar, "response");
            if (tVar.e()) {
                this.f5037a.resumeWith(V3.n.a(tVar.a()));
                return;
            }
            InterfaceC1080k interfaceC1080k = this.f5037a;
            j jVar = new j(tVar);
            n.a aVar = V3.n.f5531a;
            interfaceC1080k.resumeWith(V3.n.a(V3.o.a(jVar)));
        }

        @Override // R4.d
        public void b(R4.b<T> bVar, Throwable th) {
            j4.k.h(bVar, "call");
            j4.k.h(th, "t");
            InterfaceC1080k interfaceC1080k = this.f5037a;
            n.a aVar = V3.n.f5531a;
            interfaceC1080k.resumeWith(V3.n.a(V3.o.a(th)));
        }
    }

    static final class e extends j4.l implements InterfaceC0772l<Throwable, V3.v> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ R4.b f5038a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(R4.b bVar) {
            super(1);
            this.f5038a = bVar;
        }

        public final void b(Throwable th) {
            this.f5038a.cancel();
        }

        @Override // i4.InterfaceC0772l
        public /* bridge */ /* synthetic */ V3.v invoke(Throwable th) {
            b(th);
            return V3.v.f5542a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class f<T> implements R4.d<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC1080k f5039a;

        f(InterfaceC1080k interfaceC1080k) {
            this.f5039a = interfaceC1080k;
        }

        @Override // R4.d
        public void a(R4.b<T> bVar, t<T> tVar) {
            j4.k.h(bVar, "call");
            j4.k.h(tVar, "response");
            this.f5039a.resumeWith(V3.n.a(tVar));
        }

        @Override // R4.d
        public void b(R4.b<T> bVar, Throwable th) {
            j4.k.h(bVar, "call");
            j4.k.h(th, "t");
            InterfaceC1080k interfaceC1080k = this.f5039a;
            n.a aVar = V3.n.f5531a;
            interfaceC1080k.resumeWith(V3.n.a(V3.o.a(th)));
        }
    }

    static final class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Z3.e f5040a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Exception f5041b;

        g(Z3.e eVar, Exception exc) {
            this.f5040a = eVar;
            this.f5041b = exc;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Z3.e eVarC = C0428b.c(this.f5040a);
            Exception exc = this.f5041b;
            n.a aVar = V3.n.f5531a;
            eVarC.resumeWith(V3.n.a(V3.o.a(exc)));
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "retrofit2.KotlinExtensions", f = "KotlinExtensions.kt", l = {113}, m = "suspendAndThrow")
    static final class h extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f5042a;

        /* renamed from: b, reason: collision with root package name */
        int f5043b;

        /* renamed from: c, reason: collision with root package name */
        Object f5044c;

        h(Z3.e eVar) {
            super(eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.f5042a = obj;
            this.f5043b |= Integer.MIN_VALUE;
            return m.d(null, this);
        }
    }

    public static final <T> Object a(R4.b<T> bVar, Z3.e<? super T> eVar) {
        C1082l c1082l = new C1082l(C0428b.c(eVar), 1);
        c1082l.f(new a(bVar));
        bVar.o(new c(c1082l));
        Object objX = c1082l.x();
        if (objX == C0428b.e()) {
            kotlin.coroutines.jvm.internal.h.c(eVar);
        }
        return objX;
    }

    public static final <T> Object b(R4.b<T> bVar, Z3.e<? super T> eVar) {
        C1082l c1082l = new C1082l(C0428b.c(eVar), 1);
        c1082l.f(new b(bVar));
        bVar.o(new d(c1082l));
        Object objX = c1082l.x();
        if (objX == C0428b.e()) {
            kotlin.coroutines.jvm.internal.h.c(eVar);
        }
        return objX;
    }

    public static final <T> Object c(R4.b<T> bVar, Z3.e<? super t<T>> eVar) {
        C1082l c1082l = new C1082l(C0428b.c(eVar), 1);
        c1082l.f(new e(bVar));
        bVar.o(new f(c1082l));
        Object objX = c1082l.x();
        if (objX == C0428b.e()) {
            kotlin.coroutines.jvm.internal.h.c(eVar);
        }
        return objX;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object d(java.lang.Exception r4, Z3.e<?> r5) {
        /*
            boolean r0 = r5 instanceof R4.m.h
            if (r0 == 0) goto L13
            r0 = r5
            R4.m$h r0 = (R4.m.h) r0
            int r1 = r0.f5043b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5043b = r1
            goto L18
        L13:
            R4.m$h r0 = new R4.m$h
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f5042a
            java.lang.Object r1 = a4.C0428b.e()
            int r2 = r0.f5043b
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.f5044c
            java.lang.Exception r4 = (java.lang.Exception) r4
            V3.o.b(r5)
            goto L5c
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            V3.o.b(r5)
            r0.f5044c = r4
            r0.f5043b = r3
            s4.E r5 = s4.W.a()
            Z3.i r2 = r0.getContext()
            R4.m$g r3 = new R4.m$g
            r3.<init>(r0, r4)
            r5.Y(r2, r3)
            java.lang.Object r4 = a4.C0428b.e()
            java.lang.Object r5 = a4.C0428b.e()
            if (r4 != r5) goto L59
            kotlin.coroutines.jvm.internal.h.c(r0)
        L59:
            if (r4 != r1) goto L5c
            return r1
        L5c:
            V3.v r4 = V3.v.f5542a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: R4.m.d(java.lang.Exception, Z3.e):java.lang.Object");
    }
}
