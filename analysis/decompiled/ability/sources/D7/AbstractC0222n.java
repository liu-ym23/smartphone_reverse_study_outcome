package D7;

import java.util.Iterator;
import java.util.Set;

/* renamed from: D7.n, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0222n extends AbstractC0209a implements Set {
    public static final C0221m Companion = new C0221m();

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set other = (Set) obj;
        Companion.getClass();
        kotlin.jvm.internal.k.f(other, "other");
        if (size() != other.size()) {
            return false;
        }
        return containsAll(other);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        Companion.getClass();
        Iterator<E> it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }
}
