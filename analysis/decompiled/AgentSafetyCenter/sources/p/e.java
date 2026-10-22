package p;

import androidx.datastore.preferences.protobuf.b1;
import java.lang.invoke.VarHandle;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends p0 implements Map {

    /* renamed from: h, reason: collision with root package name */
    public b1 f9545h;
    public b i;

    /* renamed from: j, reason: collision with root package name */
    public d f9546j;

    @Override // java.util.Map
    public final Set entrySet() {
        b1 b1Var = this.f9545h;
        if (b1Var != null) {
            return b1Var;
        }
        b1 b1Var2 = new b1(this, 1);
        this.f9545h = b1Var2;
        return b1Var2;
    }

    public final boolean i(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!super.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final boolean j(Collection collection) {
        int i = this.f9610g;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            super.remove(it.next());
        }
        return i != this.f9610g;
    }

    @Override // java.util.Map
    public final Set keySet() {
        b bVar = this.i;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b();
        bVar2.f9518c = this;
        VarHandle.storeStoreFence();
        this.i = bVar2;
        return bVar2;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        int size = map.size() + this.f9610g;
        int i = this.f9610g;
        int[] iArr = this.f9608c;
        if (iArr.length < size) {
            this.f9608c = Arrays.copyOf(iArr, size);
            this.f9609f = Arrays.copyOf(this.f9609f, size * 2);
        }
        if (this.f9610g != i) {
            throw new ConcurrentModificationException();
        }
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final Collection values() {
        d dVar = this.f9546j;
        if (dVar != null) {
            return dVar;
        }
        d dVar2 = new d();
        dVar2.f9537c = this;
        VarHandle.storeStoreFence();
        this.f9546j = dVar2;
        return dVar2;
    }
}
