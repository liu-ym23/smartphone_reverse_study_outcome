package H8;

import com.google.protobuf.C0990s2;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
public class D extends AbstractSet {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f763a;
    public final /* synthetic */ AbstractMap b;

    public /* synthetic */ D(AbstractMap abstractMap, int i) {
        this.f763a = i;
        this.b = abstractMap;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        switch (this.f763a) {
            case 0:
                Map.Entry entry = (Map.Entry) obj;
                if (!contains(entry)) {
                    ((x) this.b).put((Comparable) entry.getKey(), entry.getValue());
                    break;
                }
                break;
            default:
                Map.Entry entry2 = (Map.Entry) obj;
                if (!contains(entry2)) {
                    ((C0990s2) this.b).put((Comparable) entry2.getKey(), entry2.getValue());
                    break;
                }
                break;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f763a) {
            case 0:
                ((x) this.b).clear();
                break;
            default:
                ((C0990s2) this.b).clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.f763a) {
            case 0:
                Map.Entry entry = (Map.Entry) obj;
                Object obj2 = ((x) this.b).get(entry.getKey());
                Object value = entry.getValue();
                if (obj2 == value || (obj2 != null && obj2.equals(value))) {
                }
                break;
            default:
                Map.Entry entry2 = (Map.Entry) obj;
                Object obj3 = ((C0990s2) this.b).get(entry2.getKey());
                Object value2 = entry2.getValue();
                if (obj3 == value2 || (obj3 != null && obj3.equals(value2))) {
                }
                break;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        switch (this.f763a) {
            case 0:
                return new C((x) this.b, 0);
            default:
                return new C((C0990s2) this.b, 1);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        switch (this.f763a) {
            case 0:
                Map.Entry entry = (Map.Entry) obj;
                if (contains(entry)) {
                    ((x) this.b).remove(entry.getKey());
                    break;
                }
                break;
            default:
                Map.Entry entry2 = (Map.Entry) obj;
                if (contains(entry2)) {
                    ((C0990s2) this.b).remove(entry2.getKey());
                    break;
                }
                break;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f763a) {
            case 0:
                return ((x) this.b).size();
            default:
                return ((C0990s2) this.b).size();
        }
    }
}
