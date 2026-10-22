package l;

import java.util.HashMap;
import java.util.Map;
import l.C4854b;

/* renamed from: l.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C4853a<K, V> extends C4854b<K, V> {

    /* renamed from: e, reason: collision with root package name */
    public final HashMap<K, C4854b.c<K, V>> f36854e = new HashMap<>();

    @Override // l.C4854b
    public C4854b.c<K, V> c(K k10) {
        return this.f36854e.get(k10);
    }

    public boolean contains(K k10) {
        return this.f36854e.containsKey(k10);
    }

    @Override // l.C4854b
    public V j(K k10, V v10) {
        C4854b.c<K, V> cVarC = c(k10);
        if (cVarC != null) {
            return cVarC.f36860b;
        }
        this.f36854e.put(k10, i(k10, v10));
        return null;
    }

    @Override // l.C4854b
    public V k(K k10) {
        V v10 = (V) super.k(k10);
        this.f36854e.remove(k10);
        return v10;
    }

    public Map.Entry<K, V> l(K k10) {
        if (contains(k10)) {
            return this.f36854e.get(k10).f36862d;
        }
        return null;
    }
}
