package n;

import java.util.HashMap;
import java.util.Map;
import n.C0870b;

/* renamed from: n.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0869a<K, V> extends C0870b<K, V> {

    /* renamed from: e, reason: collision with root package name */
    private final HashMap<K, C0870b.c<K, V>> f18823e = new HashMap<>();

    @Override // n.C0870b
    protected C0870b.c<K, V> c(K k5) {
        return this.f18823e.get(k5);
    }

    public boolean contains(K k5) {
        return this.f18823e.containsKey(k5);
    }

    @Override // n.C0870b
    public V m(K k5, V v5) {
        C0870b.c<K, V> cVarC = c(k5);
        if (cVarC != null) {
            return cVarC.f18829b;
        }
        this.f18823e.put(k5, i(k5, v5));
        return null;
    }

    @Override // n.C0870b
    public V n(K k5) {
        V v5 = (V) super.n(k5);
        this.f18823e.remove(k5);
        return v5;
    }

    public Map.Entry<K, V> o(K k5) {
        if (contains(k5)) {
            return this.f18823e.get(k5).f18831d;
        }
        return null;
    }
}
