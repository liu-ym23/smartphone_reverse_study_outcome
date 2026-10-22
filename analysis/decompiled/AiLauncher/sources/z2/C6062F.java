package z2;

import java.util.Iterator;
import java.util.Map;

/* renamed from: z2.F, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C6062F extends AbstractC6069M {

    /* renamed from: a, reason: collision with root package name */
    public final Map f44654a;

    public C6062F(Map map) {
        this.f44654a = map;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f44654a.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f44654a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f44654a.size();
    }
}
