package Z;

import Z.e;
import java.util.Set;
import java.util.concurrent.Callable;
import x3.EnumC1285a;

/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f6607a = new Object();

    static class a implements x3.h<Object> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String[] f6608a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f6609b;

        /* renamed from: Z.k$a$a, reason: collision with other inner class name */
        class C0095a extends e.c {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ x3.g f6610b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0095a(String[] strArr, x3.g gVar) {
                super(strArr);
                this.f6610b = gVar;
            }

            @Override // Z.e.c
            public void a(Set<String> set) {
                if (this.f6610b.isCancelled()) {
                    return;
                }
                this.f6610b.d(k.f6607a);
            }
        }

        class b implements D3.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ e.c f6612a;

            b(e.c cVar) {
                this.f6612a = cVar;
            }

            @Override // D3.a
            public void run() {
                a.this.f6609b.h().g(this.f6612a);
            }
        }

        a(String[] strArr, g gVar) {
            this.f6608a = strArr;
            this.f6609b = gVar;
        }

        @Override // x3.h
        public void a(x3.g<Object> gVar) {
            C0095a c0095a = new C0095a(this.f6608a, gVar);
            if (!gVar.isCancelled()) {
                this.f6609b.h().a(c0095a);
                gVar.a(A3.d.c(new b(c0095a)));
            }
            if (gVar.isCancelled()) {
                return;
            }
            gVar.d(k.f6607a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static class b<T> implements D3.h<Object, x3.l<T>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ x3.j f6614a;

        b(x3.j jVar) {
            this.f6614a = jVar;
        }

        @Override // D3.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public x3.l<T> apply(Object obj) {
            return this.f6614a;
        }
    }

    public static x3.f<Object> a(g gVar, String... strArr) {
        return x3.f.h(new a(strArr, gVar), EnumC1285a.LATEST);
    }

    public static <T> x3.f<T> b(g gVar, String[] strArr, Callable<T> callable) {
        return (x3.f<T>) a(gVar, strArr).G(T3.a.b(gVar.j())).u(new b(x3.j.b(callable)));
    }
}
