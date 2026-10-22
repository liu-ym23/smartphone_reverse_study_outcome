package androidx.datastore.preferences.protobuf;

import com.google.protobuf.v3;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class h1 extends AbstractSet {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f869f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Map f870g;

    public /* synthetic */ h1(Map map, int i2) {
        this.f869f = i2;
        this.f870g = map;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        switch (this.f869f) {
            case 0:
                Map.Entry entry = (Map.Entry) obj;
                if (contains(entry)) {
                    return false;
                }
                ((b1) this.f870g).put((Comparable) entry.getKey(), entry.getValue());
                return true;
            case 1:
                Map.Entry entry2 = (Map.Entry) obj;
                if (contains(entry2)) {
                    return false;
                }
                ((v3) this.f870g).put((Comparable) entry2.getKey(), entry2.getValue());
                return true;
            case 2:
                Map.Entry entry3 = (Map.Entry) obj;
                if (contains(entry3)) {
                    return false;
                }
                ((f9.a0) this.f870g).put((Comparable) entry3.getKey(), entry3.getValue());
                return true;
            default:
                return super.add(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        switch (this.f869f) {
            case 0:
                ((b1) this.f870g).clear();
                break;
            case 1:
                ((v3) this.f870g).clear();
                break;
            case 2:
                ((f9.a0) this.f870g).clear();
                break;
            default:
                super.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        switch (this.f869f) {
            case 0:
                Map.Entry entry = (Map.Entry) obj;
                Object obj2 = ((b1) this.f870g).get(entry.getKey());
                Object value = entry.getValue();
                return obj2 == value || (obj2 != null && obj2.equals(value));
            case 1:
                Map.Entry entry2 = (Map.Entry) obj;
                Object obj3 = ((v3) this.f870g).get(entry2.getKey());
                Object value2 = entry2.getValue();
                return obj3 == value2 || (obj3 != null && obj3.equals(value2));
            case 2:
                Map.Entry entry3 = (Map.Entry) obj;
                Object obj4 = ((f9.a0) this.f870g).get(entry3.getKey());
                Object value3 = entry3.getValue();
                return obj4 == value3 || (obj4 != null && obj4.equals(value3));
            default:
                return super.contains(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        switch (this.f869f) {
            case 0:
                return new g1((b1) this.f870g, 0);
            case 1:
                return new g1((v3) this.f870g, 1);
            case 2:
                return new g1((f9.a0) this.f870g, 2);
            default:
                return new k.c((k.e) this.f870g);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        switch (this.f869f) {
            case 0:
                Map.Entry entry = (Map.Entry) obj;
                if (!contains(entry)) {
                    return false;
                }
                ((b1) this.f870g).remove(entry.getKey());
                return true;
            case 1:
                Map.Entry entry2 = (Map.Entry) obj;
                if (!contains(entry2)) {
                    return false;
                }
                ((v3) this.f870g).remove(entry2.getKey());
                return true;
            case 2:
                Map.Entry entry3 = (Map.Entry) obj;
                if (!contains(entry3)) {
                    return false;
                }
                ((f9.a0) this.f870g).remove(entry3.getKey());
                return true;
            default:
                return super.remove(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f869f) {
            case 0:
                return ((b1) this.f870g).size();
            case 1:
                return ((v3) this.f870g).size();
            case 2:
                return ((f9.a0) this.f870g).size();
            default:
                return ((k.e) this.f870g).f5479h;
        }
    }
}
