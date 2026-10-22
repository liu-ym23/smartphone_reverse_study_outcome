package L3;

import x3.AbstractC1286b;
import x3.InterfaceC1287c;
import x3.n;
import x3.o;

/* loaded from: classes.dex */
public final class b<T> extends AbstractC1286b {

    /* renamed from: a, reason: collision with root package name */
    final n<T> f3903a;

    static final class a<T> implements o<T>, A3.c {

        /* renamed from: a, reason: collision with root package name */
        final InterfaceC1287c f3904a;

        /* renamed from: b, reason: collision with root package name */
        A3.c f3905b;

        a(InterfaceC1287c interfaceC1287c) {
            this.f3904a = interfaceC1287c;
        }

        @Override // x3.o
        public void a() {
            this.f3904a.a();
        }

        @Override // x3.o
        public void b(A3.c cVar) {
            this.f3905b = cVar;
            this.f3904a.b(this);
        }

        @Override // x3.o
        public void d(T t5) {
        }

        @Override // A3.c
        public void dispose() {
            this.f3905b.dispose();
        }

        @Override // A3.c
        public boolean g() {
            return this.f3905b.g();
        }

        @Override // x3.o
        public void onError(Throwable th) {
            this.f3904a.onError(th);
        }
    }

    public b(n<T> nVar) {
        this.f3903a = nVar;
    }

    @Override // x3.AbstractC1286b
    public void i(InterfaceC1287c interfaceC1287c) {
        this.f3903a.a(new a(interfaceC1287c));
    }
}
