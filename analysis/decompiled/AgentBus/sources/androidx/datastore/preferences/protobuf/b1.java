package androidx.datastore.preferences.protobuf;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class b1 extends AbstractMap {

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f817l = 0;

    /* renamed from: f, reason: collision with root package name */
    public final int f818f;

    /* renamed from: g, reason: collision with root package name */
    public List f819g = Collections.EMPTY_LIST;

    /* renamed from: h, reason: collision with root package name */
    public Map f820h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f821i;

    /* renamed from: j, reason: collision with root package name */
    public volatile h1 f822j;

    /* renamed from: k, reason: collision with root package name */
    public Map f823k;

    public b1(int i2) {
        this.f818f = i2;
        Map map = Collections.EMPTY_MAP;
        this.f820h = map;
        this.f823k = map;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(java.lang.Comparable r5) {
        /*
            r4 = this;
            java.util.List r0 = r4.f819g
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L21
            java.util.List r2 = r4.f819g
            java.lang.Object r2 = r2.get(r1)
            androidx.datastore.preferences.protobuf.f1 r2 = (androidx.datastore.preferences.protobuf.f1) r2
            java.lang.Comparable r2 = r2.f847f
            int r2 = r5.compareTo(r2)
            if (r2 <= 0) goto L1e
            int r0 = r0 + 1
        L1c:
            int r4 = -r0
            return r4
        L1e:
            if (r2 != 0) goto L21
            return r1
        L21:
            r0 = 0
        L22:
            if (r0 > r1) goto L43
            int r2 = r0 + r1
            int r2 = r2 / 2
            java.util.List r3 = r4.f819g
            java.lang.Object r3 = r3.get(r2)
            androidx.datastore.preferences.protobuf.f1 r3 = (androidx.datastore.preferences.protobuf.f1) r3
            java.lang.Comparable r3 = r3.f847f
            int r3 = r5.compareTo(r3)
            if (r3 >= 0) goto L3c
            int r2 = r2 + (-1)
            r1 = r2
            goto L22
        L3c:
            if (r3 <= 0) goto L42
            int r2 = r2 + 1
            r0 = r2
            goto L22
        L42:
            return r2
        L43:
            int r0 = r0 + 1
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.b1.a(java.lang.Comparable):int");
    }

    public final void b() {
        if (this.f821i) {
            throw new UnsupportedOperationException();
        }
    }

    public final Map.Entry c(int i2) {
        return (Map.Entry) this.f819g.get(i2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        b();
        if (!this.f819g.isEmpty()) {
            this.f819g.clear();
        }
        if (this.f820h.isEmpty()) {
            return;
        }
        this.f820h.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.f820h.containsKey(comparable);
    }

    public final Iterable d() {
        return this.f820h.isEmpty() ? e1.f844b : this.f820h.entrySet();
    }

    public final SortedMap e() {
        b();
        if (this.f820h.isEmpty() && !(this.f820h instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f820h = treeMap;
            this.f823k = treeMap.descendingMap();
        }
        return (SortedMap) this.f820h;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.f822j == null) {
            this.f822j = new h1(this, 0);
        }
        return this.f822j;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b1)) {
            return super.equals(obj);
        }
        b1 b1Var = (b1) obj;
        int size = size();
        if (size == b1Var.size()) {
            int size2 = this.f819g.size();
            if (size2 != b1Var.f819g.size()) {
                return ((AbstractSet) entrySet()).equals(b1Var.entrySet());
            }
            for (int i2 = 0; i2 < size2; i2++) {
                if (c(i2).equals(b1Var.c(i2))) {
                }
            }
            if (size2 != size) {
                return this.f820h.equals(b1Var.f820h);
            }
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        b();
        int iA = a(comparable);
        if (iA >= 0) {
            return ((f1) this.f819g.get(iA)).setValue(obj);
        }
        b();
        boolean zIsEmpty = this.f819g.isEmpty();
        int i2 = this.f818f;
        if (zIsEmpty && !(this.f819g instanceof ArrayList)) {
            this.f819g = new ArrayList(i2);
        }
        int i10 = -(iA + 1);
        if (i10 >= i2) {
            return e().put(comparable, obj);
        }
        if (this.f819g.size() == i2) {
            f1 f1Var = (f1) this.f819g.remove(i2 - 1);
            e().put(f1Var.f847f, f1Var.f848g);
        }
        this.f819g.add(i10, new f1(this, comparable, obj));
        return null;
    }

    public final Object g(int i2) {
        b();
        Object obj = ((f1) this.f819g.remove(i2)).f848g;
        if (!this.f820h.isEmpty()) {
            Iterator it = e().entrySet().iterator();
            List list = this.f819g;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new f1(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return obj;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        return iA >= 0 ? ((f1) this.f819g.get(iA)).f848g : this.f820h.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int size = this.f819g.size();
        int iHashCode = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iHashCode += ((f1) this.f819g.get(i2)).hashCode();
        }
        return this.f820h.size() > 0 ? this.f820h.hashCode() + iHashCode : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        b();
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        if (iA >= 0) {
            return g(iA);
        }
        if (this.f820h.isEmpty()) {
            return null;
        }
        return this.f820h.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f820h.size() + this.f819g.size();
    }
}
