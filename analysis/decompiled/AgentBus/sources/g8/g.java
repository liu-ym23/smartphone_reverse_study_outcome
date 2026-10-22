package g8;

import d7.y;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class g implements j {
    @Override // g8.j
    public final c b(e9.c cVar) {
        q7.k.e(cVar, "fqName");
        return null;
    }

    @Override // g8.j
    public final boolean g(e9.c cVar) {
        return i.hasAnnotation(this, cVar);
    }

    @Override // g8.j
    public final boolean isEmpty() {
        return true;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return y.f2977f;
    }

    public final String toString() {
        return "EMPTY";
    }
}
