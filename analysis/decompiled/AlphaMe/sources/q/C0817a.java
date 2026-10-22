package q;

import androidx.datastore.preferences.protobuf.k0;
import androidx.datastore.preferences.protobuf.o0;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* renamed from: q.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0817a extends AbstractSet {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13938a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f13939b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0817a(k0 k0Var) {
        this(k0Var, 1);
        this.f13938a = 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        switch (this.f13938a) {
            case 1:
                Map.Entry entry = (Map.Entry) obj;
                if (contains(entry)) {
                    return false;
                }
                ((k0) this.f13939b).l((Comparable) entry.getKey(), entry.getValue());
                return true;
            default:
                return super.add(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f13938a) {
            case 1:
                ((k0) this.f13939b).clear();
                break;
            default:
                super.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.f13938a) {
            case 1:
                Map.Entry entry = (Map.Entry) obj;
                Object obj2 = ((k0) this.f13939b).get(entry.getKey());
                Object value = entry.getValue();
                return obj2 == value || (obj2 != null && obj2.equals(value));
            default:
                return super.contains(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        int i4 = this.f13938a;
        Map map = this.f13939b;
        switch (i4) {
            case 0:
                return new C0820d((f) map);
            default:
                return new o0((k0) map);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        switch (this.f13938a) {
            case 1:
                Map.Entry entry = (Map.Entry) obj;
                if (!contains(entry)) {
                    return false;
                }
                ((k0) this.f13939b).remove(entry.getKey());
                return true;
            default:
                return super.remove(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        int i4 = this.f13938a;
        Map map = this.f13939b;
        switch (i4) {
            case 0:
                return ((f) map).f13970c;
            default:
                return ((k0) map).size();
        }
    }

    public /* synthetic */ C0817a(Map map, int i4) {
        this.f13938a = i4;
        this.f13939b = map;
    }
}
