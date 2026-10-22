package Z3;

import Z3.i;
import i4.p;
import j4.k;
import java.io.Serializable;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public final class d implements i, Serializable {

    /* renamed from: a, reason: collision with root package name */
    private final i f6652a;

    /* renamed from: b, reason: collision with root package name */
    private final i.b f6653b;

    public d(i iVar, i.b bVar) {
        k.g(iVar, "left");
        k.g(bVar, "element");
        this.f6652a = iVar;
        this.f6653b = bVar;
    }

    private final boolean d(i.b bVar) {
        return k.b(a(bVar.getKey()), bVar);
    }

    private final boolean e(d dVar) {
        while (d(dVar.f6653b)) {
            i iVar = dVar.f6652a;
            if (!(iVar instanceof d)) {
                k.e(iVar, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return d((i.b) iVar);
            }
            dVar = (d) iVar;
        }
        return false;
    }

    private final int f() {
        int i5 = 2;
        while (true) {
            i iVar = this.f6652a;
            this = iVar instanceof d ? (d) iVar : null;
            if (this == null) {
                return i5;
            }
            i5++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String g(String str, i.b bVar) {
        k.g(str, "acc");
        k.g(bVar, "element");
        if (str.length() == 0) {
            return bVar.toString();
        }
        return str + ", " + bVar;
    }

    @Override // Z3.i
    public /* bridge */ i C(i iVar) {
        return i.a.b(this, iVar);
    }

    @Override // Z3.i
    public i W(i.c<?> cVar) {
        k.g(cVar, "key");
        if (this.f6653b.a(cVar) != null) {
            return this.f6652a;
        }
        i iVarW = this.f6652a.W(cVar);
        return iVarW == this.f6652a ? this : iVarW == j.f6656a ? this.f6653b : new d(iVarW, this.f6653b);
    }

    @Override // Z3.i
    public <E extends i.b> E a(i.c<E> cVar) {
        k.g(cVar, "key");
        while (true) {
            E e6 = (E) this.f6653b.a(cVar);
            if (e6 != null) {
                return e6;
            }
            i iVar = this.f6652a;
            if (!(iVar instanceof d)) {
                return (E) iVar.a(cVar);
            }
            this = (d) iVar;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return dVar.f() == f() && dVar.e(this);
    }

    public int hashCode() {
        return this.f6652a.hashCode() + this.f6653b.hashCode();
    }

    @Override // Z3.i
    public <R> R o(R r5, p<? super R, ? super i.b, ? extends R> pVar) {
        k.g(pVar, "operation");
        return pVar.invoke((Object) this.f6652a.o(r5, pVar), this.f6653b);
    }

    public String toString() {
        return '[' + ((String) o(BuildConfig.FLAVOR, new p() { // from class: Z3.c
            @Override // i4.p
            public final Object invoke(Object obj, Object obj2) {
                return d.g((String) obj, (i.b) obj2);
            }
        })) + ']';
    }
}
