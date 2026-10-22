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

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y0 extends AbstractMap {

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f1223j = 0;

    /* renamed from: c, reason: collision with root package name */
    public List f1224c;

    /* renamed from: f, reason: collision with root package name */
    public Map f1225f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1226g;

    /* renamed from: h, reason: collision with root package name */
    public volatile b1 f1227h;
    public Map i;

    public static y0 f() {
        y0 y0Var = new y0();
        y0Var.f1224c = Collections.EMPTY_LIST;
        Map map = Collections.EMPTY_MAP;
        y0Var.f1225f = map;
        y0Var.i = map;
        return y0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(java.lang.Comparable r5) {
        /*
            r4 = this;
            java.util.List r0 = r4.f1224c
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L21
            java.util.List r2 = r4.f1224c
            java.lang.Object r2 = r2.get(r1)
            androidx.datastore.preferences.protobuf.z0 r2 = (androidx.datastore.preferences.protobuf.z0) r2
            java.lang.Comparable r2 = r2.f1229c
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
            java.util.List r3 = r4.f1224c
            java.lang.Object r3 = r3.get(r2)
            androidx.datastore.preferences.protobuf.z0 r3 = (androidx.datastore.preferences.protobuf.z0) r3
            java.lang.Comparable r3 = r3.f1229c
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.y0.a(java.lang.Comparable):int");
    }

    public final void b() {
        if (this.f1226g) {
            b8.z.c();
        }
    }

    public final Map.Entry c(int i) {
        return (Map.Entry) this.f1224c.get(i);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        b();
        if (!this.f1224c.isEmpty()) {
            this.f1224c.clear();
        }
        if (this.f1225f.isEmpty()) {
            return;
        }
        this.f1225f.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.f1225f.containsKey(comparable);
    }

    public final Set d() {
        return this.f1225f.isEmpty() ? Collections.EMPTY_SET : this.f1225f.entrySet();
    }

    public final SortedMap e() {
        b();
        if (this.f1225f.isEmpty() && !(this.f1225f instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f1225f = treeMap;
            this.i = treeMap.descendingMap();
        }
        return (SortedMap) this.f1225f;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.f1227h == null) {
            this.f1227h = new b1(this, 0);
        }
        return this.f1227h;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y0)) {
            return super.equals(obj);
        }
        y0 y0Var = (y0) obj;
        int size = size();
        if (size == y0Var.size()) {
            int size2 = this.f1224c.size();
            if (size2 != y0Var.f1224c.size()) {
                return ((AbstractSet) entrySet()).equals(y0Var.entrySet());
            }
            for (int i = 0; i < size2; i++) {
                if (c(i).equals(y0Var.c(i))) {
                }
            }
            if (size2 != size) {
                return this.f1225f.equals(y0Var.f1225f);
            }
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        b();
        int iA = a(comparable);
        if (iA >= 0) {
            return ((z0) this.f1224c.get(iA)).setValue(obj);
        }
        b();
        if (this.f1224c.isEmpty() && !(this.f1224c instanceof ArrayList)) {
            this.f1224c = new ArrayList(16);
        }
        int i = -(iA + 1);
        if (i >= 16) {
            return e().put(comparable, obj);
        }
        if (this.f1224c.size() == 16) {
            z0 z0Var = (z0) this.f1224c.remove(15);
            e().put(z0Var.f1229c, z0Var.f1230f);
        }
        this.f1224c.add(i, new z0(this, comparable, obj));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        return iA >= 0 ? ((z0) this.f1224c.get(iA)).f1230f : this.f1225f.get(comparable);
    }

    public final Object h(int i) {
        b();
        Object obj = ((z0) this.f1224c.remove(i)).f1230f;
        if (!this.f1225f.isEmpty()) {
            Iterator it = e().entrySet().iterator();
            List list = this.f1224c;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new z0(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return obj;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int size = this.f1224c.size();
        int iHashCode = 0;
        for (int i = 0; i < size; i++) {
            iHashCode += ((z0) this.f1224c.get(i)).hashCode();
        }
        return this.f1225f.size() > 0 ? this.f1225f.hashCode() + iHashCode : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        b();
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        if (iA >= 0) {
            return h(iA);
        }
        if (this.f1225f.isEmpty()) {
            return null;
        }
        return this.f1225f.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f1225f.size() + this.f1224c.size();
    }
}
