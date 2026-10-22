package A1;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class t<T> {

    class a extends t<T> {
        a() {
        }

        @Override // A1.t
        public T b(G1.a aVar) throws IOException {
            if (aVar.V() != G1.b.NULL) {
                return (T) t.this.b(aVar);
            }
            aVar.O();
            return null;
        }

        @Override // A1.t
        public void d(G1.c cVar, T t5) throws IOException {
            if (t5 == null) {
                cVar.D();
            } else {
                t.this.d(cVar, t5);
            }
        }
    }

    public final t<T> a() {
        return new a();
    }

    public abstract T b(G1.a aVar);

    public final j c(T t5) {
        try {
            D1.f fVar = new D1.f();
            d(fVar, t5);
            return fVar.h0();
        } catch (IOException e6) {
            throw new k(e6);
        }
    }

    public abstract void d(G1.c cVar, T t5);
}
