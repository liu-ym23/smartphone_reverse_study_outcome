package com.google.protobuf;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class v3 extends AbstractMap {

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f2589l = 0;

    /* renamed from: f, reason: collision with root package name */
    public Object[] f2590f;

    /* renamed from: g, reason: collision with root package name */
    public int f2591g;

    /* renamed from: h, reason: collision with root package name */
    public Map f2592h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2593i;

    /* renamed from: j, reason: collision with root package name */
    public volatile androidx.datastore.preferences.protobuf.h1 f2594j;

    /* renamed from: k, reason: collision with root package name */
    public Map f2595k;

    public static v3 f() {
        v3 v3Var = new v3();
        Map map = Collections.EMPTY_MAP;
        v3Var.f2592h = map;
        v3Var.f2595k = map;
        return v3Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(java.lang.Comparable r5) {
        /*
            r4 = this;
            int r0 = r4.f2591g
            int r1 = r0 + (-1)
            if (r1 < 0) goto L1b
            java.lang.Object[] r2 = r4.f2590f
            r2 = r2[r1]
            com.google.protobuf.w3 r2 = (com.google.protobuf.w3) r2
            java.lang.Comparable r2 = r2.f2622f
            int r2 = r5.compareTo(r2)
            if (r2 <= 0) goto L18
            int r0 = r0 + 1
        L16:
            int r4 = -r0
            return r4
        L18:
            if (r2 != 0) goto L1b
            return r1
        L1b:
            r0 = 0
        L1c:
            if (r0 > r1) goto L3b
            int r2 = r0 + r1
            int r2 = r2 / 2
            java.lang.Object[] r3 = r4.f2590f
            r3 = r3[r2]
            com.google.protobuf.w3 r3 = (com.google.protobuf.w3) r3
            java.lang.Comparable r3 = r3.f2622f
            int r3 = r5.compareTo(r3)
            if (r3 >= 0) goto L34
            int r2 = r2 + (-1)
            r1 = r2
            goto L1c
        L34:
            if (r3 <= 0) goto L3a
            int r2 = r2 + 1
            r0 = r2
            goto L1c
        L3a:
            return r2
        L3b:
            int r0 = r0 + 1
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.v3.a(java.lang.Comparable):int");
    }

    public final void b() {
        if (this.f2593i) {
            throw new UnsupportedOperationException();
        }
    }

    public final w3 c(int i2) {
        if (i2 < this.f2591g) {
            return (w3) this.f2590f[i2];
        }
        throw new ArrayIndexOutOfBoundsException(i2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        b();
        if (this.f2591g != 0) {
            this.f2590f = null;
            this.f2591g = 0;
        }
        if (this.f2592h.isEmpty()) {
            return;
        }
        this.f2592h.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.f2592h.containsKey(comparable);
    }

    public final Set d() {
        return this.f2592h.isEmpty() ? Collections.EMPTY_SET : this.f2592h.entrySet();
    }

    public final SortedMap e() {
        b();
        if (this.f2592h.isEmpty() && !(this.f2592h instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f2592h = treeMap;
            this.f2595k = treeMap.descendingMap();
        }
        return (SortedMap) this.f2592h;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.f2594j == null) {
            this.f2594j = new androidx.datastore.preferences.protobuf.h1(this, 1);
        }
        return this.f2594j;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v3)) {
            return super.equals(obj);
        }
        v3 v3Var = (v3) obj;
        int size = size();
        if (size == v3Var.size()) {
            int i2 = this.f2591g;
            if (i2 != v3Var.f2591g) {
                return ((AbstractSet) entrySet()).equals(v3Var.entrySet());
            }
            for (int i10 = 0; i10 < i2; i10++) {
                if (c(i10).equals(v3Var.c(i10))) {
                }
            }
            if (i2 != size) {
                return this.f2592h.equals(v3Var.f2592h);
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
            return ((w3) this.f2590f[iA]).setValue(obj);
        }
        b();
        if (this.f2590f == null) {
            this.f2590f = new Object[16];
        }
        int i2 = -(iA + 1);
        if (i2 >= 16) {
            return e().put(comparable, obj);
        }
        int i10 = this.f2591g;
        if (i10 == 16) {
            w3 w3Var = (w3) this.f2590f[15];
            this.f2591g = i10 - 1;
            e().put(w3Var.f2622f, w3Var.f2623g);
        }
        Object[] objArr = this.f2590f;
        System.arraycopy(objArr, i2, objArr, i2 + 1, (objArr.length - i2) - 1);
        this.f2590f[i2] = new w3(this, comparable, obj);
        this.f2591g++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        return iA >= 0 ? ((w3) this.f2590f[iA]).f2623g : this.f2592h.get(comparable);
    }

    public final Object h(int i2) {
        b();
        Object[] objArr = this.f2590f;
        Object obj = ((w3) objArr[i2]).f2623g;
        System.arraycopy(objArr, i2 + 1, objArr, i2, (this.f2591g - i2) - 1);
        this.f2591g--;
        if (!this.f2592h.isEmpty()) {
            Iterator it = e().entrySet().iterator();
            Object[] objArr2 = this.f2590f;
            int i10 = this.f2591g;
            Map.Entry entry = (Map.Entry) it.next();
            objArr2[i10] = new w3(this, (Comparable) entry.getKey(), entry.getValue());
            this.f2591g++;
            it.remove();
        }
        return obj;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int i2 = this.f2591g;
        int iHashCode = 0;
        for (int i10 = 0; i10 < i2; i10++) {
            iHashCode += this.f2590f[i10].hashCode();
        }
        return this.f2592h.size() > 0 ? this.f2592h.hashCode() + iHashCode : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        b();
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        if (iA >= 0) {
            return h(iA);
        }
        if (this.f2592h.isEmpty()) {
            return null;
        }
        return this.f2592h.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f2592h.size() + this.f2591g;
    }
}
