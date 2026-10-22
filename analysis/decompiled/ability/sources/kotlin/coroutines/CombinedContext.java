package kotlin.coroutines;

import B7.a;
import C7.r;
import H4.l;
import H7.b;
import H7.f;
import H7.g;
import H7.h;
import S7.n;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\rJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u000b\u001a\u00020\n2\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lkotlin/coroutines/CombinedContext;", "LH7/h;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "writeReplace", "()Ljava/lang/Object;", "Ljava/io/ObjectInputStream;", "Lkotlin/internal/ReadObjectParameterType;", "input", "LC7/r;", "readObject", "(Ljava/io/ObjectInputStream;)V", "Serialized", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CombinedContext implements h, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final h f4906a;
    public final f b;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/coroutines/CombinedContext$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "readResolve", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Serialized implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final h[] f4907a;

        public Serialized(h[] hVarArr) {
            this.f4907a = hVarArr;
        }

        private final Object readResolve() {
            h hVarPlus = EmptyCoroutineContext.f4908a;
            for (h hVar : this.f4907a) {
                hVarPlus = hVarPlus.plus(hVar);
            }
            return hVarPlus;
        }
    }

    public CombinedContext(f element, h left) {
        k.f(left, "left");
        k.f(element, "element");
        this.f4906a = left;
        this.b = element;
    }

    private final void readObject(ObjectInputStream input) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace() {
        int iA = a();
        h[] hVarArr = new h[iA];
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        fold(r.f317a, new l(1, hVarArr, ref$IntRef));
        if (ref$IntRef.f4918a == iA) {
            return new Serialized(hVarArr);
        }
        throw new IllegalStateException("Check failed.");
    }

    public final int a() {
        int i = 2;
        while (true) {
            h hVar = this.f4906a;
            this = hVar instanceof CombinedContext ? (CombinedContext) hVar : null;
            if (this == null) {
                return i;
            }
            i++;
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
                    f fVar = this.b;
                    if (!k.b(combinedContext.get(fVar.getKey()), fVar)) {
                        zB = false;
                        break;
                    }
                    h hVar = this.f4906a;
                    if (!(hVar instanceof CombinedContext)) {
                        k.d(hVar, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                        f fVar2 = (f) hVar;
                        zB = k.b(combinedContext.get(fVar2.getKey()), fVar2);
                        break;
                    }
                    this = (CombinedContext) hVar;
                }
                if (zB) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // H7.h
    public final Object fold(Object obj, n nVar) {
        return nVar.invoke(this.f4906a.fold(obj, nVar), this.b);
    }

    @Override // H7.h
    public final f get(g key) {
        k.f(key, "key");
        while (true) {
            f fVar = this.b.get(key);
            if (fVar != null) {
                return fVar;
            }
            h hVar = this.f4906a;
            if (!(hVar instanceof CombinedContext)) {
                return hVar.get(key);
            }
            this = (CombinedContext) hVar;
        }
    }

    public final int hashCode() {
        return this.b.hashCode() + this.f4906a.hashCode();
    }

    @Override // H7.h
    public final h minusKey(g key) {
        k.f(key, "key");
        f fVar = this.b;
        f fVar2 = fVar.get(key);
        h hVar = this.f4906a;
        if (fVar2 != null) {
            return hVar;
        }
        h hVarMinusKey = hVar.minusKey(key);
        return hVarMinusKey == hVar ? this : hVarMinusKey == EmptyCoroutineContext.f4908a ? fVar : new CombinedContext(fVar, hVarMinusKey);
    }

    @Override // H7.h
    public final h plus(h context) {
        k.f(context, "context");
        return context == EmptyCoroutineContext.f4908a ? this : (h) context.fold(this, new b(1));
    }

    public final String toString() {
        return a.g(']', (String) fold("", new b(0)), new StringBuilder("["));
    }
}
