package androidx.datastore.preferences.protobuf;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import q.C0817a;

/* loaded from: classes.dex */
public final class k0 extends AbstractMap {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f3500g = 0;

    /* renamed from: a, reason: collision with root package name */
    public final int f3501a;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3504d;

    /* renamed from: e, reason: collision with root package name */
    public volatile C0817a f3505e;

    /* renamed from: b, reason: collision with root package name */
    public List f3502b = Collections.emptyList();

    /* renamed from: c, reason: collision with root package name */
    public Map f3503c = Collections.emptyMap();

    /* renamed from: f, reason: collision with root package name */
    public Map f3506f = Collections.emptyMap();

    public k0(int i4) {
        this.f3501a = i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(java.lang.Comparable r5) {
        /*
            r4 = this;
            java.util.List r0 = r4.f3502b
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L21
            java.util.List r2 = r4.f3502b
            java.lang.Object r2 = r2.get(r1)
            androidx.datastore.preferences.protobuf.n0 r2 = (androidx.datastore.preferences.protobuf.n0) r2
            java.lang.Comparable r2 = r2.f3515a
            int r2 = r5.compareTo(r2)
            if (r2 <= 0) goto L1e
            int r0 = r0 + 1
        L1c:
            int r1 = -r0
            goto L47
        L1e:
            if (r2 != 0) goto L21
            goto L47
        L21:
            r0 = 0
        L22:
            if (r0 > r1) goto L44
            int r2 = r0 + r1
            int r2 = r2 / 2
            java.util.List r3 = r4.f3502b
            java.lang.Object r3 = r3.get(r2)
            androidx.datastore.preferences.protobuf.n0 r3 = (androidx.datastore.preferences.protobuf.n0) r3
            java.lang.Comparable r3 = r3.f3515a
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
            r1 = r2
            goto L47
        L44:
            int r0 = r0 + 1
            goto L1c
        L47:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.k0.a(java.lang.Comparable):int");
    }

    public final void b() {
        if (this.f3504d) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final void clear() {
        b();
        if (!this.f3502b.isEmpty()) {
            this.f3502b.clear();
        }
        if (this.f3503c.isEmpty()) {
            return;
        }
        this.f3503c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.f3503c.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final Set entrySet() {
        if (this.f3505e == null) {
            this.f3505e = new C0817a(this);
        }
        return this.f3505e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k0)) {
            return super.equals(obj);
        }
        k0 k0Var = (k0) obj;
        int size = size();
        if (size != k0Var.size()) {
            return false;
        }
        int size2 = this.f3502b.size();
        if (size2 != k0Var.f3502b.size()) {
            return entrySet().equals(k0Var.entrySet());
        }
        for (int i4 = 0; i4 < size2; i4++) {
            if (!h(i4).equals(k0Var.h(i4))) {
                return false;
            }
        }
        if (size2 != size) {
            return this.f3503c.equals(k0Var.f3503c);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        return iA >= 0 ? ((n0) this.f3502b.get(iA)).f3516b : this.f3503c.get(comparable);
    }

    public final Map.Entry h(int i4) {
        return (Map.Entry) this.f3502b.get(i4);
    }

    public final Iterable i() {
        return this.f3503c.isEmpty() ? X.f3442b : this.f3503c.entrySet();
    }

    public final SortedMap j() {
        b();
        if (this.f3503c.isEmpty() && !(this.f3503c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f3503c = treeMap;
            this.f3506f = treeMap.descendingMap();
        }
        return (SortedMap) this.f3503c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public final int hashCode() {
        int size = this.f3502b.size();
        int iHashCode = 0;
        for (int i4 = 0; i4 < size; i4++) {
            iHashCode += ((n0) this.f3502b.get(i4)).hashCode();
        }
        return this.f3503c.size() > 0 ? iHashCode + this.f3503c.hashCode() : iHashCode;
    }

    public final Object l(Comparable comparable, Object obj) {
        b();
        int iA = a(comparable);
        if (iA >= 0) {
            return ((n0) this.f3502b.get(iA)).setValue(obj);
        }
        b();
        boolean zIsEmpty = this.f3502b.isEmpty();
        int i4 = this.f3501a;
        if (zIsEmpty && !(this.f3502b instanceof ArrayList)) {
            this.f3502b = new ArrayList(i4);
        }
        int i5 = -(iA + 1);
        if (i5 >= i4) {
            return j().put(comparable, obj);
        }
        if (this.f3502b.size() == i4) {
            n0 n0Var = (n0) this.f3502b.remove(i4 - 1);
            j().put(n0Var.f3515a, n0Var.f3516b);
        }
        this.f3502b.add(i5, new n0(this, comparable, obj));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public final Object remove(Object obj) {
        b();
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        if (iA >= 0) {
            return n(iA);
        }
        if (this.f3503c.isEmpty()) {
            return null;
        }
        return this.f3503c.remove(comparable);
    }

    public final Object n(int i4) {
        b();
        Object obj = ((n0) this.f3502b.remove(i4)).f3516b;
        if (!this.f3503c.isEmpty()) {
            Iterator it = j().entrySet().iterator();
            List list = this.f3502b;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new n0(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return obj;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public final int size() {
        return this.f3503c.size() + this.f3502b.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        B0.g.y(obj);
        return l(null, obj2);
    }
}
