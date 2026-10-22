package F1;

import androidx.room.AbstractC0351g;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class o extends p implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f448a = new ArrayList();

    @Override // F1.p
    public final String a() {
        ArrayList arrayList = this.f448a;
        int size = arrayList.size();
        if (size == 1) {
            return ((p) arrayList.get(0)).a();
        }
        throw new IllegalStateException(AbstractC0351g.m("Array must have size 1, but has size ", size));
    }

    public final boolean equals(Object obj) {
        return obj == this || ((obj instanceof o) && ((o) obj).f448a.equals(this.f448a));
    }

    public final int hashCode() {
        return this.f448a.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f448a.iterator();
    }
}
