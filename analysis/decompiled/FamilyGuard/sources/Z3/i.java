package Z3;

import Z3.f;
import Z3.i;
import i4.p;
import j4.k;

/* loaded from: classes.dex */
public interface i {

    public static final class a {
        public static i b(i iVar, i iVar2) {
            k.g(iVar2, "context");
            return iVar2 == j.f6656a ? iVar : (i) iVar2.o(iVar, new p() { // from class: Z3.h
                @Override // i4.p
                public final Object invoke(Object obj, Object obj2) {
                    return i.a.c((i) obj, (i.b) obj2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static i c(i iVar, b bVar) {
            k.g(iVar, "acc");
            k.g(bVar, "element");
            i iVarW = iVar.W(bVar.getKey());
            j jVar = j.f6656a;
            if (iVarW == jVar) {
                return bVar;
            }
            f.b bVar2 = f.f6654N;
            f fVar = (f) iVarW.a(bVar2);
            if (fVar == null) {
                return new d(iVarW, bVar);
            }
            i iVarW2 = iVarW.W(bVar2);
            return iVarW2 == jVar ? new d(bVar, fVar) : new d(new d(iVarW2, bVar), fVar);
        }
    }

    public interface b extends i {

        public static final class a {
            public static <R> R a(b bVar, R r5, p<? super R, ? super b, ? extends R> pVar) {
                k.g(pVar, "operation");
                return pVar.invoke(r5, bVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends b> E b(b bVar, c<E> cVar) {
                k.g(cVar, "key");
                if (!k.b(bVar.getKey(), cVar)) {
                    return null;
                }
                k.e(bVar, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return bVar;
            }

            public static i c(b bVar, c<?> cVar) {
                k.g(cVar, "key");
                return k.b(bVar.getKey(), cVar) ? j.f6656a : bVar;
            }

            public static i d(b bVar, i iVar) {
                k.g(iVar, "context");
                return a.b(bVar, iVar);
            }
        }

        @Override // Z3.i
        <E extends b> E a(c<E> cVar);

        c<?> getKey();
    }

    public interface c<E extends b> {
    }

    i C(i iVar);

    i W(c<?> cVar);

    <E extends b> E a(c<E> cVar);

    <R> R o(R r5, p<? super R, ? super b, ? extends R> pVar);
}
