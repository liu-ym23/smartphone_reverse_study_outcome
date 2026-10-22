package com.google.protobuf;

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

/* renamed from: com.google.protobuf.s2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0990s2 extends AbstractMap {
    public static final /* synthetic */ int g = 0;

    /* renamed from: a, reason: collision with root package name */
    public final int f2941a;
    public List b = Collections.EMPTY_LIST;
    public Map c;
    public boolean d;
    public volatile H8.D e;
    public Map f;

    public C0990s2(int i) {
        this.f2941a = i;
        Map map = Collections.EMPTY_MAP;
        this.c = map;
        this.f = map;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(java.lang.Comparable r5) {
        /*
            r4 = this;
            java.util.List r0 = r4.b
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L21
            java.util.List r2 = r4.b
            java.lang.Object r2 = r2.get(r1)
            com.google.protobuf.w2 r2 = (com.google.protobuf.C1006w2) r2
            java.lang.Comparable r2 = r2.f2984a
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
            java.util.List r3 = r4.b
            java.lang.Object r3 = r3.get(r2)
            com.google.protobuf.w2 r3 = (com.google.protobuf.C1006w2) r3
            java.lang.Comparable r3 = r3.f2984a
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C0990s2.a(java.lang.Comparable):int");
    }

    public final void b() {
        if (this.d) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        b();
        if (!this.b.isEmpty()) {
            this.b.clear();
        }
        if (this.c.isEmpty()) {
            return;
        }
        this.c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.c.containsKey(comparable);
    }

    public final Map.Entry d(int i) {
        return (Map.Entry) this.b.get(i);
    }

    public final Iterable e() {
        return this.c.isEmpty() ? AbstractC1002v2.b : this.c.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.e == null) {
            this.e = new H8.D(this, 1);
        }
        return this.e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0990s2)) {
            return super.equals(obj);
        }
        C0990s2 c0990s2 = (C0990s2) obj;
        int size = size();
        if (size == c0990s2.size()) {
            int size2 = this.b.size();
            if (size2 != c0990s2.b.size()) {
                return ((AbstractSet) entrySet()).equals(c0990s2.entrySet());
            }
            for (int i = 0; i < size2; i++) {
                if (d(i).equals(c0990s2.d(i))) {
                }
            }
            if (size2 != size) {
                return this.c.equals(c0990s2.c);
            }
            return true;
        }
        return false;
    }

    public final SortedMap f() {
        b();
        if (this.c.isEmpty() && !(this.c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.c = treeMap;
            this.f = treeMap.descendingMap();
        }
        return (SortedMap) this.c;
    }

    public final void g() {
        if (!this.d) {
            for (int i = 0; i < this.b.size(); i++) {
                Map.Entry entryD = d(i);
                if (((D0) ((X0) entryD.getKey())).isRepeated()) {
                    entryD.setValue(Collections.unmodifiableList((List) entryD.getValue()));
                }
            }
            for (Map.Entry entry : e()) {
                if (((D0) ((X0) entry.getKey())).isRepeated()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        if (this.d) {
            return;
        }
        this.c = this.c.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.c);
        this.f = this.f.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f);
        this.d = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        return iA >= 0 ? ((C1006w2) this.b.get(iA)).b : this.c.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        b();
        int iA = a(comparable);
        if (iA >= 0) {
            return ((C1006w2) this.b.get(iA)).setValue(obj);
        }
        b();
        boolean zIsEmpty = this.b.isEmpty();
        int i = this.f2941a;
        if (zIsEmpty && !(this.b instanceof ArrayList)) {
            this.b = new ArrayList(i);
        }
        int i6 = -(iA + 1);
        if (i6 >= i) {
            return f().put(comparable, obj);
        }
        if (this.b.size() == i) {
            C1006w2 c1006w2 = (C1006w2) this.b.remove(i - 1);
            f().put(c1006w2.f2984a, c1006w2.b);
        }
        this.b.add(i6, new C1006w2(this, comparable, obj));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int size = this.b.size();
        int iHashCode = 0;
        for (int i = 0; i < size; i++) {
            iHashCode += ((C1006w2) this.b.get(i)).hashCode();
        }
        return this.c.size() > 0 ? this.c.hashCode() + iHashCode : iHashCode;
    }

    public final Object i(int i) {
        b();
        Object obj = ((C1006w2) this.b.remove(i)).b;
        if (!this.c.isEmpty()) {
            Iterator it = f().entrySet().iterator();
            List list = this.b;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new C1006w2(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return obj;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        b();
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        if (iA >= 0) {
            return i(iA);
        }
        if (this.c.isEmpty()) {
            return null;
        }
        return this.c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.c.size() + this.b.size();
    }
}
