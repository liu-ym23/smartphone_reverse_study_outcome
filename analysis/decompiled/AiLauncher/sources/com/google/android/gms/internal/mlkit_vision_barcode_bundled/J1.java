package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public class J1 extends AbstractMap {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f20029a;

    /* renamed from: b, reason: collision with root package name */
    public int f20030b;

    /* renamed from: c, reason: collision with root package name */
    public Map f20031c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f20032d;

    /* renamed from: e, reason: collision with root package name */
    public volatile H1 f20033e;

    /* renamed from: f, reason: collision with root package name */
    public Map f20034f;

    public J1() {
        Map map = Collections.EMPTY_MAP;
        this.f20031c = map;
        this.f20034f = map;
    }

    public void b() {
        if (this.f20032d) {
            return;
        }
        this.f20031c = this.f20031c.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f20031c);
        this.f20034f = this.f20034f.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f20034f);
        this.f20032d = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        r();
        if (this.f20030b != 0) {
            this.f20029a = null;
            this.f20030b = 0;
        }
        if (this.f20031c.isEmpty()) {
            return;
        }
        this.f20031c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return o(comparable) >= 0 || this.f20031c.containsKey(comparable);
    }

    public final int d() {
        return this.f20030b;
    }

    public final Iterable e() {
        return this.f20031c.isEmpty() ? Collections.EMPTY_SET : this.f20031c.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.f20033e == null) {
            this.f20033e = new H1(this, null);
        }
        return this.f20033e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof J1)) {
            return super.equals(obj);
        }
        J1 j12 = (J1) obj;
        int size = size();
        if (size != j12.size()) {
            return false;
        }
        int i10 = this.f20030b;
        if (i10 != j12.f20030b) {
            return entrySet().equals(j12.entrySet());
        }
        for (int i11 = 0; i11 < i10; i11++) {
            if (!i(i11).equals(j12.i(i11))) {
                return false;
            }
        }
        if (i10 != size) {
            return this.f20031c.equals(j12.f20031c);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iO = o(comparable);
        return iO >= 0 ? ((D1) this.f20029a[iO]).getValue() : this.f20031c.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        r();
        int iO = o(comparable);
        if (iO >= 0) {
            return ((D1) this.f20029a[iO]).setValue(obj);
        }
        r();
        if (this.f20029a == null) {
            this.f20029a = new Object[16];
        }
        int i10 = -(iO + 1);
        if (i10 >= 16) {
            return q().put(comparable, obj);
        }
        if (this.f20030b == 16) {
            D1 d12 = (D1) this.f20029a[15];
            this.f20030b = 15;
            q().put(d12.a(), d12.getValue());
        }
        Object[] objArr = this.f20029a;
        int length = objArr.length;
        System.arraycopy(objArr, i10, objArr, i10 + 1, 15 - i10);
        this.f20029a[i10] = new D1(this, comparable, obj);
        this.f20030b++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int i10 = this.f20030b;
        int iHashCode = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            iHashCode += this.f20029a[i11].hashCode();
        }
        return this.f20031c.size() > 0 ? iHashCode + this.f20031c.hashCode() : iHashCode;
    }

    public final Map.Entry i(int i10) {
        if (i10 < this.f20030b) {
            return (D1) this.f20029a[i10];
        }
        throw new ArrayIndexOutOfBoundsException(i10);
    }

    public final boolean m() {
        return this.f20032d;
    }

    public final int o(Comparable comparable) {
        int i10 = this.f20030b;
        int i11 = i10 - 1;
        int i12 = 0;
        if (i11 >= 0) {
            int iCompareTo = comparable.compareTo(((D1) this.f20029a[i11]).a());
            if (iCompareTo > 0) {
                return -(i10 + 1);
            }
            if (iCompareTo == 0) {
                return i11;
            }
        }
        while (i12 <= i11) {
            int i13 = (i12 + i11) / 2;
            int iCompareTo2 = comparable.compareTo(((D1) this.f20029a[i13]).a());
            if (iCompareTo2 < 0) {
                i11 = i13 - 1;
            } else {
                if (iCompareTo2 <= 0) {
                    return i13;
                }
                i12 = i13 + 1;
            }
        }
        return -(i12 + 1);
    }

    public final Object p(int i10) {
        r();
        Object value = ((D1) this.f20029a[i10]).getValue();
        Object[] objArr = this.f20029a;
        System.arraycopy(objArr, i10 + 1, objArr, i10, (this.f20030b - i10) - 1);
        this.f20030b--;
        if (!this.f20031c.isEmpty()) {
            Iterator it = q().entrySet().iterator();
            Object[] objArr2 = this.f20029a;
            int i11 = this.f20030b;
            Map.Entry entry = (Map.Entry) it.next();
            objArr2[i11] = new D1(this, (Comparable) entry.getKey(), entry.getValue());
            this.f20030b++;
            it.remove();
        }
        return value;
    }

    public final SortedMap q() {
        r();
        if (this.f20031c.isEmpty() && !(this.f20031c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f20031c = treeMap;
            this.f20034f = treeMap.descendingMap();
        }
        return (SortedMap) this.f20031c;
    }

    public final void r() {
        if (this.f20032d) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        r();
        Comparable comparable = (Comparable) obj;
        int iO = o(comparable);
        if (iO >= 0) {
            return p(iO);
        }
        if (this.f20031c.isEmpty()) {
            return null;
        }
        return this.f20031c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f20030b + this.f20031c.size();
    }

    public /* synthetic */ J1(I1 i12) {
        Map map = Collections.EMPTY_MAP;
        this.f20031c = map;
        this.f20034f = map;
    }
}
