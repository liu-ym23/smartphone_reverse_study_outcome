package kotlin.coroutines;

import b6.f;
import java.io.Serializable;
import kotlin.coroutines.d;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.g;
import lb.n;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CombinedContext implements d, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final d f10054a;

    /* renamed from: b, reason: collision with root package name */
    public final d.a f10055b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Serialized implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final d[] f10056a;

        public Serialized(d[] dVarArr) {
            this.f10056a = dVarArr;
        }

        private final Object readResolve() {
            d dVarPlus = EmptyCoroutineContext.f10057a;
            for (d dVar : this.f10056a) {
                dVarPlus = dVarPlus.plus(dVar);
            }
            return dVarPlus;
        }
    }

    public CombinedContext(d left, d.a element) {
        g.f(left, "left");
        g.f(element, "element");
        this.f10054a = left;
        this.f10055b = element;
    }

    private final Object writeReplace() {
        int iA = a();
        final d[] dVarArr = new d[iA];
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        fold(n.f10413a, new p() { // from class: qb.a
            @Override // zb.p
            public final Object invoke(Object obj, Object obj2) {
                d.a element = (d.a) obj2;
                g.f((n) obj, "<unused var>");
                g.f(element, "element");
                Ref$IntRef ref$IntRef2 = ref$IntRef;
                int i10 = ref$IntRef2.f10074a;
                ref$IntRef2.f10074a = i10 + 1;
                dVarArr[i10] = element;
                return n.f10413a;
            }
        });
        if (ref$IntRef.f10074a == iA) {
            return new Serialized(dVarArr);
        }
        throw new IllegalStateException("Check failed.");
    }

    public final int a() {
        int i10 = 2;
        while (true) {
            d dVar = this.f10054a;
            this = dVar instanceof CombinedContext ? (CombinedContext) dVar : null;
            if (this == null) {
                return i10;
            }
            i10++;
        }
    }

    public final boolean equals(Object obj) {
        boolean zB;
        if (this == obj) {
            return true;
        }
        if (obj instanceof CombinedContext) {
            CombinedContext combinedContext = (CombinedContext) obj;
            if (combinedContext.a() == a()) {
                while (true) {
                    d.a aVar = this.f10055b;
                    if (!g.b(combinedContext.get(aVar.getKey()), aVar)) {
                        zB = false;
                        break;
                    }
                    d dVar = this.f10054a;
                    if (!(dVar instanceof CombinedContext)) {
                        g.d(dVar, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                        d.a aVar2 = (d.a) dVar;
                        zB = g.b(combinedContext.get(aVar2.getKey()), aVar2);
                        break;
                    }
                    this = (CombinedContext) dVar;
                }
                if (zB) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // kotlin.coroutines.d
    public final <R> R fold(R r, p<? super R, ? super d.a, ? extends R> operation) {
        g.f(operation, "operation");
        return operation.invoke((Object) this.f10054a.fold(r, operation), this.f10055b);
    }

    @Override // kotlin.coroutines.d
    public final <E extends d.a> E get(d.b<E> key) {
        g.f(key, "key");
        while (true) {
            E e10 = (E) this.f10055b.get(key);
            if (e10 != null) {
                return e10;
            }
            d dVar = this.f10054a;
            if (!(dVar instanceof CombinedContext)) {
                return (E) dVar.get(key);
            }
            this = (CombinedContext) dVar;
        }
    }

    public final int hashCode() {
        return this.f10055b.hashCode() + this.f10054a.hashCode();
    }

    @Override // kotlin.coroutines.d
    public final d minusKey(d.b<?> key) {
        g.f(key, "key");
        d.a aVar = this.f10055b;
        d.a aVar2 = aVar.get(key);
        d dVar = this.f10054a;
        if (aVar2 != null) {
            return dVar;
        }
        d dVarMinusKey = dVar.minusKey(key);
        return dVarMinusKey == dVar ? this : dVarMinusKey == EmptyCoroutineContext.f10057a ? aVar : new CombinedContext(dVarMinusKey, aVar);
    }

    @Override // kotlin.coroutines.d
    public final d plus(d context) {
        g.f(context, "context");
        return context == EmptyCoroutineContext.f10057a ? this : (d) context.fold(this, new com.stepos.core.common.log.c(4));
    }

    public final String toString() {
        return ai.onnxruntime.a.n(new StringBuilder("["), (String) fold("", new f(5)), ']');
    }
}
