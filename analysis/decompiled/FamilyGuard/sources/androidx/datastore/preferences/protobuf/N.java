package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.K;
import java.util.Map;

/* loaded from: classes.dex */
class N implements M {
    N() {
    }

    private static <K, V> int i(int i5, Object obj, Object obj2) {
        L l5 = (L) obj;
        K k5 = (K) obj2;
        int iA = 0;
        if (l5.isEmpty()) {
            return 0;
        }
        for (Map.Entry<K, V> entry : l5.entrySet()) {
            iA += k5.a(i5, entry.getKey(), entry.getValue());
        }
        return iA;
    }

    private static <K, V> L<K, V> j(Object obj, Object obj2) {
        L<K, V> lP = (L) obj;
        L<K, V> l5 = (L) obj2;
        if (!l5.isEmpty()) {
            if (!lP.k()) {
                lP = lP.p();
            }
            lP.n(l5);
        }
        return lP;
    }

    @Override // androidx.datastore.preferences.protobuf.M
    public Object a(Object obj, Object obj2) {
        return j(obj, obj2);
    }

    @Override // androidx.datastore.preferences.protobuf.M
    public Object b(Object obj) {
        ((L) obj).l();
        return obj;
    }

    @Override // androidx.datastore.preferences.protobuf.M
    public K.a<?, ?> c(Object obj) {
        return ((K) obj).c();
    }

    @Override // androidx.datastore.preferences.protobuf.M
    public Map<?, ?> d(Object obj) {
        return (L) obj;
    }

    @Override // androidx.datastore.preferences.protobuf.M
    public Object e(Object obj) {
        return L.g().p();
    }

    @Override // androidx.datastore.preferences.protobuf.M
    public int f(int i5, Object obj, Object obj2) {
        return i(i5, obj, obj2);
    }

    @Override // androidx.datastore.preferences.protobuf.M
    public boolean g(Object obj) {
        return !((L) obj).k();
    }

    @Override // androidx.datastore.preferences.protobuf.M
    public Map<?, ?> h(Object obj) {
        return (L) obj;
    }
}
