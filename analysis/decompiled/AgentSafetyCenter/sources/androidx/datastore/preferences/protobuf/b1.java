package androidx.datastore.preferences.protobuf;

import java.lang.invoke.VarHandle;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class b1 extends AbstractSet {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1089c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Map f1090f;

    public /* synthetic */ b1(Map map, int i) {
        this.f1089c = i;
        this.f1090f = map;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        switch (this.f1089c) {
            case 0:
                Map.Entry entry = (Map.Entry) obj;
                if (contains(entry)) {
                    return false;
                }
                ((y0) this.f1090f).put((Comparable) entry.getKey(), entry.getValue());
                return true;
            default:
                return super.add(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        switch (this.f1089c) {
            case 0:
                ((y0) this.f1090f).clear();
                break;
            default:
                super.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        switch (this.f1089c) {
            case 0:
                Map.Entry entry = (Map.Entry) obj;
                Object obj2 = ((y0) this.f1090f).get(entry.getKey());
                Object value = entry.getValue();
                return obj2 == value || (obj2 != null && obj2.equals(value));
            default:
                return super.contains(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        int i = this.f1089c;
        Map map = this.f1090f;
        switch (i) {
            case 0:
                a1 a1Var = new a1();
                a1Var.f1086h = (y0) map;
                a1Var.f1083c = -1;
                VarHandle.storeStoreFence();
                return a1Var;
            default:
                p.c cVar = new p.c();
                cVar.f9528h = (p.e) map;
                cVar.f9525c = r2.f9610g - 1;
                cVar.f9526f = -1;
                VarHandle.storeStoreFence();
                return cVar;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        switch (this.f1089c) {
            case 0:
                Map.Entry entry = (Map.Entry) obj;
                if (!contains(entry)) {
                    return false;
                }
                ((y0) this.f1090f).remove(entry.getKey());
                return true;
            default:
                return super.remove(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f1089c) {
            case 0:
                return ((y0) this.f1090f).size();
            default:
                return ((p.e) this.f1090f).f9610g;
        }
    }
}
