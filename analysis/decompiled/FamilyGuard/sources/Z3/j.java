package Z3;

import Z3.i;
import i4.p;
import j4.k;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class j implements i, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final j f6656a = new j();

    private j() {
    }

    @Override // Z3.i
    public i C(i iVar) {
        k.g(iVar, "context");
        return iVar;
    }

    @Override // Z3.i
    public i W(i.c<?> cVar) {
        k.g(cVar, "key");
        return this;
    }

    @Override // Z3.i
    public <E extends i.b> E a(i.c<E> cVar) {
        k.g(cVar, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // Z3.i
    public <R> R o(R r5, p<? super R, ? super i.b, ? extends R> pVar) {
        k.g(pVar, "operation");
        return r5;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
