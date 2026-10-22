package X0;

import q.C0933a;

/* loaded from: classes.dex */
public final class b<K, V> extends C0933a<K, V> {

    /* renamed from: g, reason: collision with root package name */
    private int f5781g;

    @Override // q.i, java.util.Map
    public void clear() {
        this.f5781g = 0;
        super.clear();
    }

    @Override // q.i
    public void g(q.i<? extends K, ? extends V> iVar) {
        this.f5781g = 0;
        super.g(iVar);
    }

    @Override // q.i
    public V h(int i5) {
        this.f5781g = 0;
        return (V) super.h(i5);
    }

    @Override // q.i, java.util.Map
    public int hashCode() {
        if (this.f5781g == 0) {
            this.f5781g = super.hashCode();
        }
        return this.f5781g;
    }

    @Override // q.i
    public V i(int i5, V v5) {
        this.f5781g = 0;
        return (V) super.i(i5, v5);
    }

    @Override // q.i, java.util.Map
    public V put(K k5, V v5) {
        this.f5781g = 0;
        return (V) super.put(k5, v5);
    }
}
