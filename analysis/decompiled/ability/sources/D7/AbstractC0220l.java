package D7;

import java.util.AbstractSet;
import java.util.Set;

/* renamed from: D7.l, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0220l extends AbstractSet implements Set, T7.f {
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean add(Object obj);

    public abstract int getSize();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }
}
