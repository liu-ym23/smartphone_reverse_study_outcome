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

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class w0 extends AbstractMap {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f574f = 0;

    /* renamed from: a, reason: collision with root package name */
    public List f575a;

    /* renamed from: b, reason: collision with root package name */
    public Map f576b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f577c;
    public volatile z0 d;

    /* renamed from: e, reason: collision with root package name */
    public Map f578e;

    public static w0 f() {
        w0 w0Var = new w0();
        w0Var.f575a = Collections.EMPTY_LIST;
        Map map = Collections.EMPTY_MAP;
        w0Var.f576b = map;
        w0Var.f578e = map;
        return w0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(java.lang.Comparable r5) {
        /*
            r4 = this;
            java.util.List r0 = r4.f575a
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L21
            java.util.List r2 = r4.f575a
            java.lang.Object r2 = r2.get(r1)
            androidx.datastore.preferences.protobuf.x0 r2 = (androidx.datastore.preferences.protobuf.x0) r2
            java.lang.Comparable r2 = r2.f581a
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
            java.util.List r3 = r4.f575a
            java.lang.Object r3 = r3.get(r2)
            androidx.datastore.preferences.protobuf.x0 r3 = (androidx.datastore.preferences.protobuf.x0) r3
            java.lang.Comparable r3 = r3.f581a
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.w0.a(java.lang.Comparable):int");
    }

    public final void b() {
        if (this.f577c) {
            throw new UnsupportedOperationException();
        }
    }

    public final Map.Entry c(int i8) {
        return (Map.Entry) this.f575a.get(i8);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        b();
        if (!this.f575a.isEmpty()) {
            this.f575a.clear();
        }
        if (this.f576b.isEmpty()) {
            return;
        }
        this.f576b.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.f576b.containsKey(comparable);
    }

    public final Set d() {
        return this.f576b.isEmpty() ? Collections.EMPTY_SET : this.f576b.entrySet();
    }

    public final SortedMap e() {
        b();
        if (this.f576b.isEmpty() && !(this.f576b instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f576b = treeMap;
            this.f578e = treeMap.descendingMap();
        }
        return (SortedMap) this.f576b;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.d == null) {
            this.d = new z0(0, this);
        }
        return this.d;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w0)) {
            return super.equals(obj);
        }
        w0 w0Var = (w0) obj;
        int size = size();
        if (size == w0Var.size()) {
            int size2 = this.f575a.size();
            if (size2 != w0Var.f575a.size()) {
                return ((AbstractSet) entrySet()).equals(w0Var.entrySet());
            }
            for (int i8 = 0; i8 < size2; i8++) {
                if (c(i8).equals(w0Var.c(i8))) {
                }
            }
            if (size2 != size) {
                return this.f576b.equals(w0Var.f576b);
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
            return ((x0) this.f575a.get(iA)).setValue(obj);
        }
        b();
        if (this.f575a.isEmpty() && !(this.f575a instanceof ArrayList)) {
            this.f575a = new ArrayList(16);
        }
        int i8 = -(iA + 1);
        if (i8 >= 16) {
            return e().put(comparable, obj);
        }
        if (this.f575a.size() == 16) {
            x0 x0Var = (x0) this.f575a.remove(15);
            e().put(x0Var.f581a, x0Var.f582b);
        }
        this.f575a.add(i8, new x0(this, comparable, obj));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        return iA >= 0 ? ((x0) this.f575a.get(iA)).f582b : this.f576b.get(comparable);
    }

    public final Object h(int i8) {
        b();
        Object obj = ((x0) this.f575a.remove(i8)).f582b;
        if (!this.f576b.isEmpty()) {
            Iterator it = e().entrySet().iterator();
            List list = this.f575a;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new x0(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return obj;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int size = this.f575a.size();
        int iHashCode = 0;
        for (int i8 = 0; i8 < size; i8++) {
            iHashCode += ((x0) this.f575a.get(i8)).hashCode();
        }
        return this.f576b.size() > 0 ? this.f576b.hashCode() + iHashCode : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        b();
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        if (iA >= 0) {
            return h(iA);
        }
        if (this.f576b.isEmpty()) {
            return null;
        }
        return this.f576b.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f576b.size() + this.f575a.size();
    }
}
