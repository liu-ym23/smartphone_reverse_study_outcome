package A1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class g extends j implements Iterable<j> {

    /* renamed from: a, reason: collision with root package name */
    private final List<j> f63a = new ArrayList();

    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof g) && ((g) obj).f63a.equals(this.f63a);
        }
        return true;
    }

    public int hashCode() {
        return this.f63a.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<j> iterator() {
        return this.f63a.iterator();
    }

    public void o(j jVar) {
        if (jVar == null) {
            jVar = l.f64a;
        }
        this.f63a.add(jVar);
    }
}
