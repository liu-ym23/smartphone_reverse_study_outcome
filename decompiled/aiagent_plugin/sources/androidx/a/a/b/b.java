package androidx.a.a.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: SafeIterableMap.java */
/* JADX INFO: loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    c<K, V> f100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c<K, V> f101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WeakHashMap<f<K, V>, Boolean> f102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f103d;

    /* JADX INFO: compiled from: SafeIterableMap.java */
    static class a<K, V> extends e<K, V> {
        a(c<K, V> r1, c<K, V> r2) {
            super(r1, r2);
        }

        @Override // androidx.a.a.b.b.e
        c<K, V> a(c<K, V> r1) {
            return r1.f106c;
        }

        @Override // androidx.a.a.b.b.e
        c<K, V> b(c<K, V> r1) {
            return r1.f107d;
        }
    }

    /* JADX INFO: renamed from: androidx.a.a.b.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SafeIterableMap.java */
    private static class C0002b<K, V> extends e<K, V> {
        C0002b(c<K, V> r1, c<K, V> r2) {
            super(r1, r2);
        }

        @Override // androidx.a.a.b.b.e
        c<K, V> a(c<K, V> r1) {
            return r1.f107d;
        }

        @Override // androidx.a.a.b.b.e
        c<K, V> b(c<K, V> r1) {
            return r1.f106c;
        }
    }

    /* JADX INFO: compiled from: SafeIterableMap.java */
    static class c<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final K f104a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final V f105b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        c<K, V> f106c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        c<K, V> f107d;

        c(K r1, V r2) {
            this.f104a = r1;
            this.f105b = r2;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f104a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f105b;
        }

        @Override // java.util.Map.Entry
        public V setValue(V r1) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f104a + "=" + this.f105b;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (this.f104a.equals(r6.f104a) == false) goto L14;
            if (this.f105b.equals(r6.f105b) == false) goto L14;
            return true;
        L14:
            return false;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int r0 = this.f104a.hashCode();
            return this.f105b.hashCode() ^ r0;
        }
    }

    /* JADX INFO: compiled from: SafeIterableMap.java */
    public class d extends f<K, V> implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f108a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private c<K, V> f109b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f110c;

        @Override // java.util.Iterator
        public /* synthetic */ Object next() {
            return a();
        }

        d(b r1) {
            this.f108a = r1;
            this.f110c = true;
        }

        @Override // androidx.a.a.b.b.f
        void a_(c<K, V> r2) {
            c<K, V> r0 = this.f109b;
            if (r2 != r0) goto L10;
            c<K, V> r3 = r0.f107d;
            this.f109b = r3;
            if (r3 != null) goto L7;
            boolean r4 = true;
        L8:
            this.f110c = r4;
            return;
        L7:
            r4 = false;
            goto L8
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f110c == true) goto L5;
            c<K, V> r3 = this.f109b;
            if (r3 == null) goto L15;
            if (r3.f106c == null) goto L15;
            return true;
        L15:
            return false;
        L5:
            if (this.f108a.f100a == null) goto L8;
            return true;
        L8:
            return false;
        }

        public Map.Entry<K, V> a() {
            if (this.f110c == false) goto L5;
            this.f110c = false;
            this.f109b = this.f108a.f100a;
        L11:
            return this.f109b;
        L5:
            c<K, V> r0 = this.f109b;
            if (r0 == null) goto L8;
            c<K, V> r1 = r0.f106c;
        L9:
            this.f109b = r1;
            goto L11
        L8:
            r1 = null;
            goto L9
        }
    }

    /* JADX INFO: compiled from: SafeIterableMap.java */
    private static abstract class e<K, V> extends f<K, V> implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        c<K, V> f111a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        c<K, V> f112b;

        abstract c<K, V> a(c<K, V> r1);

        abstract c<K, V> b(c<K, V> r1);

        @Override // java.util.Iterator
        public /* synthetic */ Object next() {
            return a();
        }

        e(c<K, V> r1, c<K, V> r2) {
            this.f111a = r2;
            this.f112b = r1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f112b == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.a.a.b.b.f
        public void a_(c<K, V> r2) {
            if (this.f111a == r2) goto L5;
        L7:
            c<K, V> r0 = this.f111a;
            if (r0 != r2) goto L11;
            this.f111a = b(r0);
        L11:
            if (this.f112b != r2) goto L14;
            this.f112b = b();
            return;
        L14:
            return;
        L5:
            if (r2 != this.f112b) goto L7;
            this.f112b = null;
            this.f111a = null;
            goto L7
        }

        private c<K, V> b() {
            c<K, V> r0 = this.f112b;
            c<K, V> r1 = this.f111a;
            if (r0 == r1) goto L8;
            if (r1 != null) goto L7;
            return null;
        L7:
            return a(r0);
        L8:
            return null;
        }

        public Map.Entry<K, V> a() {
            c<K, V> r0 = this.f112b;
            this.f112b = b();
            return r0;
        }
    }

    /* JADX INFO: compiled from: SafeIterableMap.java */
    public static abstract class f<K, V> {
        abstract void a_(c<K, V> r1);

        public f() {
        }
    }

    public b() {
        this.f102c = new WeakHashMap();
        this.f103d = 0;
    }

    public c<K, V> a(K r2) {
        c<K, V> r1 = this.f100a;
    L3:
        if (r1 == null) goto L8;
        if (r1.f104a.equals(r2) == true) goto L8;
        r1 = r1.f106c;
    L8:
        return r1;
    }

    public V a(K r2, V r3) {
        c<K, V> r0 = a(r2);
        if (r0 != null) goto L5;
        b(r2, r3);
        return null;
    L5:
        return r0.f105b;
    }

    c<K, V> b(K r2, V r3) {
        c<K, V> r0 = new c(r2, r3);
        this.f103d++;
        c<K, V> r4 = this.f101b;
        if (r4 != null) goto L6;
        this.f100a = r0;
        this.f101b = r0;
        return r0;
    L6:
        r4.f106c = r0;
        r0.f107d = this.f101b;
        this.f101b = r0;
        return r0;
    }

    public V b(K r6) {
        c<K, V> r7 = a(r6);
        if (r7 != null) goto L5;
        return null;
    L5:
        this.f103d--;
        if (this.f102c.isEmpty() == true) goto L12;
        Iterator<f<K, V>> r1 = this.f102c.keySet().iterator();
    L9:
        if (r1.hasNext() == false) goto L12;
        ((f) ZeusTransformUtils.preCheckCast(r1.next(), f.class, "com.obric.aiagent.plugin")).a_(r7);
    L12:
        if (r7.f107d == null) goto L14;
        r7.f107d.f106c = r7.f106c;
    L16:
        if (r7.f106c == null) goto L18;
        r7.f106c.f107d = r7.f107d;
    L19:
        r7.f106c = null;
        r7.f107d = null;
        return r7.f105b;
    L18:
        this.f101b = r7.f107d;
        goto L19
    L14:
        this.f100a = r7.f106c;
        goto L16
    }

    public int a() {
        return this.f103d;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a r0 = new a(this.f100a, this.f101b);
        this.f102c.put(r0, false);
        return r0;
    }

    public Iterator<Map.Entry<K, V>> b() {
        C0002b r0 = new C0002b(this.f101b, this.f100a);
        this.f102c.put(r0, false);
        return r0;
    }

    public b<K, V>.d c() {
        b<K, V>.d r0 = new d(this);
        this.f102c.put(r0, false);
        return r0;
    }

    public Map.Entry<K, V> d() {
        return this.f100a;
    }

    public Map.Entry<K, V> e() {
        return this.f101b;
    }

    public boolean equals(Object r6) {
        if (r6 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, b.class) == true) goto L8;
        return false;
    L8:
        b r7 = (b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.aiagent.plugin");
        if (a() == r7.a()) goto L11;
        return false;
    L11:
        Iterator<Map.Entry<K, V>> r5 = iterator();
        Iterator<Map.Entry<K, V>> r8 = r7.iterator();
    L13:
        if (r5.hasNext() == false) goto L24;
        if (r8.hasNext() == false) goto L24;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        Map.Entry<K, V> r4 = r8.next();
        if (r0 != null) goto L19;
        if (r4 == null) goto L19;
    L22:
        return false;
    L19:
        if (r0 == null) goto L13;
        if (r0.equals(r4) == true) goto L13;
    L24:
        if (r5.hasNext() == true) goto L29;
        if (r8.hasNext() == true) goto L29;
        return true;
    L29:
        return false;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> r4 = iterator();
        int r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = r0 + ((Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.aiagent.plugin")).hashCode();
        goto L4
    L6:
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("[");
        Iterator<Map.Entry<K, V>> r4 = iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        r0.append(((Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.aiagent.plugin")).toString());
        if (r4.hasNext() == false) goto L4;
        r0.append(", ");
        goto L4
    L8:
        r0.append("]");
        return r0.toString();
    }
}
