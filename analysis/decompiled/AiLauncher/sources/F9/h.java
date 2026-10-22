package F9;

import F9.g;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.p;

/* loaded from: classes5.dex */
public final class h implements g {

    /* renamed from: a, reason: collision with root package name */
    public final List<c> f2612a;

    /* JADX WARN: Multi-variable type inference failed */
    public h(List<? extends c> annotations) {
        p.i(annotations, "annotations");
        this.f2612a = annotations;
    }

    @Override // F9.g
    public /* bridge */ boolean E(ga.c cVar) {
        return g.b.b(this, cVar);
    }

    @Override // F9.g
    public /* bridge */ c d(ga.c cVar) {
        return g.b.a(this, cVar);
    }

    @Override // F9.g
    public boolean isEmpty() {
        return this.f2612a.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<c> iterator() {
        return this.f2612a.iterator();
    }

    public String toString() {
        return this.f2612a.toString();
    }
}
