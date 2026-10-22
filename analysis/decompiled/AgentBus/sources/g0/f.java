package g0;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class f extends d7.j {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f3682f;

    /* renamed from: g, reason: collision with root package name */
    public final j0.g f3683g;

    public /* synthetic */ f(int i2, j0.g gVar) {
        this.f3682f = i2;
        this.f3683g = gVar;
    }

    @Override // d7.j
    public final int a() {
        switch (this.f3682f) {
        }
        return this.f3683g.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        switch (this.f3682f) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f3682f) {
            case 0:
                this.f3683g.clear();
                break;
            default:
                this.f3683g.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.f3682f) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                j0.g gVar = this.f3683g;
                Object obj2 = gVar.get(key);
                return obj2 != null ? obj2.equals(entry.getValue()) : entry.getValue() == null && gVar.containsKey(entry.getKey());
            default:
                return this.f3683g.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f3682f) {
            case 0:
                return new ea.g(this.f3683g);
            default:
                l[] lVarArr = new l[8];
                for (int i2 = 0; i2 < 8; i2++) {
                    lVarArr[i2] = new m(1);
                }
                return new g(this.f3683g, lVarArr);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        switch (this.f3682f) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return this.f3683g.remove(entry.getKey(), entry.getValue());
            default:
                j0.g gVar = this.f3683g;
                if (!gVar.containsKey(obj)) {
                    return false;
                }
                gVar.remove(obj);
                return true;
        }
    }
}
