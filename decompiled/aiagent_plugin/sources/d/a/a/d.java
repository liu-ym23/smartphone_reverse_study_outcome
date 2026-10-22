package d.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.l.n;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: MapBuilder.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d<K, V> implements d.h.b.a.g, Serializable, Map<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f38327a = null;
    private static final d o = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private K[] f38328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private V[] f38329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int[] f38330d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int[] f38331e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private d.a.a.f<K> k;
    private g<V> l;
    private d.a.a.e<K, V> m;
    private boolean n;

    /* JADX INFO: compiled from: MapBuilder.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public static final /* synthetic */ int a(a r0, int r1) {
            return r0.b(r1);
        }

        public static final /* synthetic */ int b(a r0, int r1) {
            return r0.a(r1);
        }

        public final d a() {
            return d.k();
        }

        private final int a(int r1) {
            return Integer.highestOneBit(n.c(r1, 1) * 3);
        }

        private final int b(int r1) {
            return Integer.numberOfLeadingZeros(r1) + 1;
        }
    }

    /* JADX INFO: compiled from: MapBuilder.kt */
    public static final class b<K, V> extends C1033d<K, V> implements d.h.b.a.d, Iterator<Map.Entry<K, V>> {
        public b(d<K, V> r2) {
            o.e(r2, "map");
            super(r2);
        }

        @Override // java.util.Iterator
        public /* synthetic */ Object next() {
            return a();
        }

        public c<K, V> a() {
            g();
            if (d() >= d.b(c())) goto L7;
            int r0 = d();
            a(r0 + 1);
            b(r0);
            c<K, V> r1 = new c(c(), e());
            f();
            return r1;
        L7:
            throw new NoSuchElementException();
        }

        public final int b() {
            if (d() >= d.b(c())) goto L14;
            int r0 = d();
            a(r0 + 1);
            b(r0);
            Object r1 = d.d(c())[e()];
            int r2 = 0;
            if (r1 == null) goto L7;
            int r3 = r1.hashCode();
        L8:
            Object[] r4 = d.e(c());
            o.a(r4);
            Object r5 = r4[e()];
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            int r6 = r3 ^ r2;
            f();
            return r6;
        L7:
            r3 = 0;
            goto L8
        L14:
            throw new NoSuchElementException();
        }

        public final void a(StringBuilder r4) {
            o.e(r4, "sb");
            if (d() >= d.b(c())) goto L15;
            int r0 = d();
            a(r0 + 1);
            b(r0);
            Object r1 = d.d(c())[e()];
            if (r1 != c()) goto L7;
            r4.append("(this Map)");
        L8:
            r4.append('=');
            Object[] r2 = d.e(c());
            o.a(r2);
            Object r3 = r2[e()];
            if (r3 != c()) goto L11;
            r4.append("(this Map)");
        L12:
            f();
            return;
        L11:
            r4.append(r3);
            goto L12
        L7:
            r4.append(r1);
            goto L8
        L15:
            throw new NoSuchElementException();
        }
    }

    /* JADX INFO: compiled from: MapBuilder.kt */
    public static final class c<K, V> implements d.h.b.a.g.a, Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d<K, V> f38332a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f38333b;

        public c(d<K, V> r2, int r3) {
            o.e(r2, "map");
            this.f38332a = r2;
            this.f38333b = r3;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) d.d(this.f38332a)[this.f38333b];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object[] r0 = d.e(this.f38332a);
            o.a(r0);
            return (V) r0[this.f38333b];
        }

        @Override // java.util.Map.Entry
        public V setValue(V r3) {
            this.f38332a.g();
            Object[] r0 = d.f(this.f38332a);
            int r2 = this.f38333b;
            V r1 = (V) r0[r2];
            r0[r2] = r3;
            return r1;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, Map.Entry.class) == true) goto L5;
        L9:
            return false;
        L5:
            if (o.a(((Map.Entry) ZeusTransformUtils.preCheckCast(r4, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), getKey()) == false) goto L9;
            if (o.a(((Map.Entry) ZeusTransformUtils.preCheckCast(r4, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), getValue()) == false) goto L9;
            return true;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K r0 = getKey();
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            V r3 = getValue();
            if (r3 == null) goto L10;
            r1 = r3.hashCode();
        L10:
            return r2 ^ r1;
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return new StringBuilder().append(getKey()).append('=').append(getValue()).toString();
        }
    }

    /* JADX INFO: renamed from: d.a.a.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MapBuilder.kt */
    public static class C1033d<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d<K, V> f38334a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f38335b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f38336c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f38337d;

        public C1033d(d<K, V> r2) {
            o.e(r2, "map");
            this.f38334a = r2;
            this.f38336c = -1;
            this.f38337d = d.a(r2);
            f();
        }

        public final d<K, V> c() {
            return this.f38334a;
        }

        public final void a(int r1) {
            this.f38335b = r1;
        }

        public final int d() {
            return this.f38335b;
        }

        public final void b(int r1) {
            this.f38336c = r1;
        }

        public final int e() {
            return this.f38336c;
        }

        public final void f() {
        L3:
            if (this.f38335b >= d.b(this.f38334a)) goto L7;
            int[] r0 = d.c(this.f38334a);
            int r1 = this.f38335b;
            if (r0[r1] >= 0) goto L10;
            this.f38335b = r1 + 1;
            goto L3
        L10:
            return;
        }

        public final boolean hasNext() {
            if (this.f38335b >= d.b(this.f38334a)) goto L5;
            return true;
        L5:
            return false;
        }

        public final void remove() {
            g();
            if (this.f38336c == (-1)) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L10;
            this.f38334a.g();
            d.a(this.f38334a, this.f38336c);
            this.f38336c = -1;
            this.f38337d = d.a(this.f38334a);
            return;
        L10:
            throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
        L5:
            r0 = false;
            goto L6
        }

        public final void g() {
            if (d.a(this.f38334a) != this.f38337d) goto L6;
            return;
        L6:
            throw new ConcurrentModificationException();
        }
    }

    /* JADX INFO: compiled from: MapBuilder.kt */
    public static final class e<K, V> extends C1033d<K, V> implements d.h.b.a.d, Iterator<K> {
        public e(d<K, V> r2) {
            o.e(r2, "map");
            super(r2);
        }

        @Override // java.util.Iterator
        public K next() {
            g();
            if (d() >= d.b(c())) goto L7;
            int r0 = d();
            a(r0 + 1);
            b(r0);
            K r1 = (K) d.d(c())[e()];
            f();
            return r1;
        L7:
            throw new NoSuchElementException();
        }
    }

    /* JADX INFO: compiled from: MapBuilder.kt */
    public static final class f<K, V> extends C1033d<K, V> implements d.h.b.a.d, Iterator<V> {
        public f(d<K, V> r2) {
            o.e(r2, "map");
            super(r2);
        }

        @Override // java.util.Iterator
        public V next() {
            g();
            if (d() >= d.b(c())) goto L7;
            int r0 = d();
            a(r0 + 1);
            b(r0);
            Object[] r1 = d.e(c());
            o.a(r1);
            V r2 = (V) r1[e()];
            f();
            return r2;
        L7:
            throw new NoSuchElementException();
        }
    }

    private d(K[] r1, V[] r2, int[] r3, int[] r4, int r5, int r6) {
        this.f38328b = r1;
        this.f38329c = r2;
        this.f38330d = r3;
        this.f38331e = r4;
        this.f = r5;
        this.g = r6;
        this.h = a.a(f38327a, l());
    }

    public static final /* synthetic */ int a(d r0) {
        return r0.i;
    }

    public static final /* synthetic */ void a(d r0, int r1) {
        r0.f(r1);
    }

    public static final /* synthetic */ int b(d r0) {
        return r0.g;
    }

    public static final /* synthetic */ int[] c(d r0) {
        return r0.f38330d;
    }

    public static final /* synthetic */ Object[] d(d r0) {
        return r0.f38328b;
    }

    public static final /* synthetic */ Object[] e(d r0) {
        return r0.f38329c;
    }

    public static final /* synthetic */ Object[] f(d r0) {
        return r0.n();
    }

    public static final /* synthetic */ d k() {
        return o;
    }

    @Override // java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return e();
    }

    @Override // java.util.Map
    public final Set<K> keySet() {
        return c();
    }

    @Override // java.util.Map
    public final int size() {
        return a();
    }

    @Override // java.util.Map
    public final Collection<V> values() {
        return d();
    }

    public int a() {
        return this.j;
    }

    public d() {
        this(8);
    }

    public d(int r8) {
        this(d.a.a.c.a(r8), null, new int[r8], new int[a.b(f38327a, r8)], 2, 0);
    }

    public final Map<K, V> b() {
        g();
        this.n = true;
        if (size() > 0) goto L7;
        d<K, V> this = o;
        o.a(this, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
    L7:
        return (Map) ZeusTransformUtils.preCheckCast(this, Map.class, "com.obric.aiagent.plugin");
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object r1) {
        if (e(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsValue(Object r1) {
        if (f(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V get(Object r1) {
        int r2 = e(r1);
        if (r2 >= 0) goto L6;
        return null;
    L6:
        V[] r0 = this.f38329c;
        o.a(r0);
        return r0[r2];
    }

    @Override // java.util.Map
    public V put(K r2, V r3) {
        g();
        int r4 = a(r2);
        V[] r1 = n();
        if (r4 >= 0) goto L6;
        int r5 = (-r4) - 1;
        V r0 = r1[r5];
        r1[r5] = r3;
        return r0;
    L6:
        r1[r4] = r3;
        return null;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        o.e(r4, "from");
        g();
        b((Collection) ZeusTransformUtils.preCheckCast(r4.entrySet(), Collection.class, "com.obric.aiagent.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V remove(Object r2) {
        g();
        int r3 = e(r2);
        if (r3 >= 0) goto L6;
        return null;
    L6:
        V[] r0 = this.f38329c;
        o.a(r0);
        V r1 = r0[r3];
        f(r3);
        return r1;
    }

    @Override // java.util.Map
    public void clear() {
        g();
        int r0 = this.g - 1;
        if (r0 < 0) goto L10;
        int r2 = 0;
    L5:
        int[] r3 = this.f38330d;
        int r4 = r3[r2];
        if (r4 < 0) goto L8;
        this.f38331e[r4] = 0;
        r3[r2] = -1;
    L8:
        if (r2 == r0) goto L10;
        r2 = r2 + 1;
    L10:
        d.a.a.c.a(this.f38328b, 0, this.g);
        V[] r1 = this.f38329c;
        if (r1 == null) goto L13;
        d.a.a.c.a(r1, 0, this.g);
    L13:
        this.j = 0;
        this.g = 0;
        m();
    }

    public Set<K> c() {
        d.a.a.f<K> r0 = this.k;
        if (r0 != null) goto L6;
        d.a.a.f<K> r1 = new d.a.a.f(this);
        this.k = r1;
        return (Set) ZeusTransformUtils.preCheckCast(r1, Set.class, "com.obric.aiagent.plugin");
    L6:
        return (Set) ZeusTransformUtils.preCheckCast(r0, Set.class, "com.obric.aiagent.plugin");
    }

    public Collection<V> d() {
        g<V> r0 = this.l;
        if (r0 != null) goto L6;
        g<V> r1 = new g(this);
        this.l = r1;
        return (Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin");
    L6:
        return (Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin");
    }

    public Set<Map.Entry<K, V>> e() {
        d.a.a.e<K, V> r0 = this.m;
        if (r0 != null) goto L7;
        d.a.a.e<K, V> r1 = new d.a.a.e(this);
        this.m = r1;
        return (Set) ZeusTransformUtils.preCheckCast(r1, Set.class, "com.obric.aiagent.plugin");
    L7:
        return (Set) ZeusTransformUtils.preCheckCast(r0, Set.class, "com.obric.aiagent.plugin");
    }

    @Override // java.util.Map
    public boolean equals(Object r3) {
        if (r3 != this) goto L4;
    L9:
        return true;
    L4:
        if (ZeusTransformUtils.instanceOf(r3, Map.class) == true) goto L6;
    L8:
        return false;
    L6:
        if (a((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.aiagent.plugin")) == false) goto L8;
        goto L8
    }

    @Override // java.util.Map
    public int hashCode() {
        b<K, V> r2 = j();
        int r0 = 0;
    L4:
        if (r2.hasNext() == false) goto L6;
        r0 = r0 + r2.b();
        goto L4
    L6:
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder((size() * 3) + 2);
        r0.append("{");
        b<K, V> r3 = j();
        int r1 = 0;
    L4:
        if (r3.hasNext() == false) goto L8;
        if (r1 <= 0) goto L7;
        r0.append(", ");
    L7:
        r3.a(r0);
        r1 = r1 + 1;
        goto L4
    L8:
        r0.append("}");
        String r4 = r0.toString();
        o.c(r4, "toString(...)");
        return r4;
    }

    public final int f() {
        return this.f38328b.length;
    }

    private final int l() {
        return this.f38331e.length;
    }

    private final void m() {
        this.i++;
    }

    public final void g() {
        if (this.n == true) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    private final void a(int r2) {
        if (b(r2) == false) goto L5;
        a(true);
        return;
    L5:
        c(this.g + r2);
    }

    private final boolean b(int r4) {
        int r0 = f();
        int r1 = this.g;
        int r2 = r0 - r1;
        int r3 = r1 - size();
        if (r2 < r4) goto L5;
    L9:
        return false;
    L5:
        if ((r2 + r3) < r4) goto L9;
        if (r3 < (f() / 4)) goto L9;
        return true;
    }

    private final void c(int r3) {
        if (r3 < 0) goto L14;
        if (r3 <= f()) goto L15;
        int r4 = d.a.c.f38373a.c(f(), r3);
        this.f38328b = (K[]) d.a.a.c.a(this.f38328b, r4);
        V[] r0 = this.f38329c;
        if (r0 == null) goto L8;
        V[] r1 = (V[]) d.a.a.c.a(r0, r4);
    L9:
        this.f38329c = r1;
        int[] r2 = Arrays.copyOf(this.f38330d, r4);
        o.c(r2, "copyOf(...)");
        this.f38330d = r2;
        int r5 = a.b(f38327a, r4);
        if (r5 <= l()) goto L16;
        d(r5);
        return;
    L16:
        return;
    L8:
        r1 = null;
        goto L9
    L15:
        return;
    L14:
        throw new OutOfMemoryError();
    }

    private final V[] n() {
        V[] r0 = this.f38329c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        V[] r1 = (V[]) d.a.a.c.a(f());
        this.f38329c = r1;
        return r1;
    }

    private final int d(K r2) {
        if (r2 == null) goto L4;
        int r3 = r2.hashCode();
    L6:
        return (r3 * (-1640531527)) >>> this.h;
    L4:
        r3 = 0;
        goto L6
    }

    private final void a(boolean r8) {
        V[] r0 = this.f38329c;
        int r1 = 0;
        int r2 = 0;
    L3:
        int r3 = this.g;
        if (r1 >= r3) goto L14;
        int[] r4 = this.f38330d;
        int r5 = r4[r1];
        if (r5 < 0) goto L13;
        K[] r6 = this.f38328b;
        r6[r2] = r6[r1];
        if (r0 == null) goto L10;
        r0[r2] = r0[r1];
    L10:
        if (r8 == false) goto L12;
        r4[r2] = r5;
        this.f38331e[r5] = r2 + 1;
    L12:
        r2 = r2 + 1;
    L13:
        r1 = r1 + 1;
        goto L3
    L14:
        d.a.a.c.a(this.f38328b, r2, r3);
        if (r0 == null) goto L17;
        d.a.a.c.a(r0, r2, this.g);
    L17:
        this.g = r2;
    }

    private final void d(int r4) {
        m();
        int r2 = 0;
        if (this.g <= size()) goto L5;
        a(false);
    L5:
        this.f38331e = new int[r4];
        this.h = a.a(f38327a, r4);
    L7:
        if (r2 >= this.g) goto L13;
        int r5 = r2 + 1;
        if (e(r2) == false) goto L12;
        r2 = r5;
        goto L7
    L12:
        throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
    }

    private final boolean e(int r6) {
        int r0 = d(this.f38328b[r6]);
        int r1 = this.f;
    L3:
        int[] r2 = this.f38331e;
        if (r2[r0] == 0) goto L5;
        r1 = r1 - 1;
        if (r1 < 0) goto L9;
        int r3 = r0 - 1;
        if (r0 == 0) goto L13;
        r0 = r3;
        goto L3
    L13:
        r0 = l() - 1;
        goto L3
    L9:
        return false;
    L5:
        r2[r0] = r6 + 1;
        this.f38330d[r6] = r0;
        return true;
    }

    private final int e(K r6) {
        int r0 = d(r6);
        int r1 = this.f;
    L3:
        int r2 = this.f38331e[r0];
        if (r2 == 0) goto L5;
        if (r2 <= 0) goto L10;
        int r3 = r2 - 1;
        if (o.a(this.f38328b[r3], r6) == false) goto L10;
        return r3;
    L10:
        r1 = r1 - 1;
        if (r1 < 0) goto L12;
        int r4 = r0 - 1;
        if (r0 == 0) goto L15;
        r0 = r4;
        goto L3
    L15:
        r0 = l() - 1;
        goto L3
    L12:
        return -1;
    L5:
        return -1;
    }

    private final int f(V r3) {
        int r0 = this.g;
    L3:
        r0 = r0 - 1;
        if (r0 < 0) goto L10;
        if (this.f38330d[r0] < 0) goto L3;
        V[] r1 = this.f38329c;
        o.a(r1);
        if (o.a(r1[r0], r3) == false) goto L3;
        return r0;
    L10:
        return -1;
    }

    public final int a(K r8) {
        g();
    L3:
        int r0 = d(r8);
        int r1 = n.d(this.f * 2, l() / 2);
        int r2 = 0;
    L4:
        int r3 = this.f38331e[r0];
        if (r3 <= 0) goto L7;
        if (o.a(this.f38328b[r3 - 1], r8) == true) goto L16;
        r2 = r2 + 1;
        if (r2 > r1) goto L19;
        int r4 = r0 - 1;
        if (r0 == 0) goto L22;
        r0 = r4;
        goto L4
    L22:
        r0 = l() - 1;
        goto L4
    L19:
        d(l() * 2);
        goto L3
    L16:
        return -r3;
    L7:
        if (this.g < f()) goto L9;
        a(1);
        goto L3
    L9:
        int r5 = this.g;
        int r6 = r5 + 1;
        this.g = r6;
        this.f38328b[r5] = r8;
        this.f38330d[r5] = r0;
        this.f38331e[r0] = r6;
        this.j = size() + 1;
        m();
        if (r2 <= this.f) goto L12;
        this.f = r2;
    L12:
        return r5;
    }

    public final boolean b(K r1) {
        g();
        int r2 = e(r1);
        if (r2 >= 0) goto L6;
        return false;
    L6:
        f(r2);
        return true;
    }

    private final void f(int r3) {
        d.a.a.c.b(this.f38328b, r3);
        V[] r0 = this.f38329c;
        if (r0 == null) goto L5;
        d.a.a.c.b(r0, r3);
    L5:
        g(this.f38330d[r3]);
        this.f38330d[r3] = -1;
        this.j = size() - 1;
        m();
    }

    private final void g(int r10) {
        int r2 = n.d(this.f * 2, l() / 2);
        int r3 = 0;
        int r0 = r10;
    L3:
        int r4 = r10 - 1;
        if (r10 != 0) goto L6;
        r10 = l() - 1;
    L7:
        r3 = r3 + 1;
        if (r3 > this.f) goto L9;
        int[] r5 = this.f38331e;
        int r6 = r5[r10];
        if (r6 == 0) goto L13;
        if (r6 >= 0) goto L19;
        r5[r0] = -1;
    L18:
        r0 = r10;
        r3 = 0;
    L22:
        r2 = r2 - 1;
        if (r2 >= 0) goto L3;
        this.f38331e[r0] = -1;
        return;
    L19:
        int r7 = r6 - 1;
        if (((d(this.f38328b[r7]) - r10) & (l() - 1)) < r3) goto L22;
        this.f38331e[r0] = r6;
        this.f38330d[r7] = r0;
        goto L18
    L13:
        r5[r0] = 0;
        return;
    L9:
        this.f38331e[r0] = 0;
        return;
    L6:
        r10 = r4;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean a(Map.Entry<? extends K, ? extends V> r3) {
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.aiagent.plugin");
        o.e(r4, "entry");
        int r0 = e(r4.getKey());
        if (r0 >= 0) goto L6;
        return false;
    L6:
        V[] r2 = this.f38329c;
        o.a(r2);
        return o.a(r2[r0], r4.getValue());
    }

    private final boolean a(Map<?, ?> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        if (size() == r5.size()) goto L5;
    L7:
        return false;
    L5:
        if (a((Collection) ZeusTransformUtils.preCheckCast(r5.entrySet(), Collection.class, "com.obric.aiagent.plugin")) == false) goto L7;
        return true;
    }

    public final boolean a(Collection<?> r5) {
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.aiagent.plugin");
        o.e(r6, "m");
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L10;
        Object r0 = r7.next();
        if (r0 == null) goto L9;
        if (a((Map.Entry) ZeusTransformUtils.preCheckCast(r0, Map.Entry.class, "com.obric.aiagent.plugin")) == true) goto L4;
    L9:
        return false;
    L10:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean c(Map.Entry<? extends K, ? extends V> r5) {
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r5, Map.Entry.class, "com.obric.aiagent.plugin");
        int r0 = a(r6.getKey());
        Object[] r4 = n();
        if (r0 < 0) goto L6;
        r4[r0] = r6.getValue();
        return true;
    L6:
        int r1 = (-r0) - 1;
        Object r2 = r4[r1];
        if (o.a(r6.getValue(), r2) == true) goto L10;
        r4[r1] = r6.getValue();
        return true;
    L10:
        return false;
    }

    private final boolean b(Collection<? extends Map.Entry<? extends K, ? extends V>> r5) {
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.aiagent.plugin");
        boolean r2 = false;
        if (r6.isEmpty() == false) goto L5;
        return false;
    L5:
        a(r6.size());
        Iterator r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L11;
        if (c((Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin")) == false) goto L7;
        r2 = true;
        goto L7
    L11:
        return r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean b(Map.Entry<? extends K, ? extends V> r4) {
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r4, Map.Entry.class, "com.obric.aiagent.plugin");
        o.e(r5, "entry");
        g();
        int r0 = e(r5.getKey());
        if (r0 >= 0) goto L5;
        return false;
    L5:
        V[] r2 = this.f38329c;
        o.a(r2);
        if (o.a(r2[r0], r5.getValue()) == true) goto L8;
        return false;
    L8:
        f(r0);
        return true;
    }

    public final boolean c(V r1) {
        g();
        int r2 = f(r1);
        if (r2 >= 0) goto L6;
        return false;
    L6:
        f(r2);
        return true;
    }

    public final e<K, V> h() {
        return new e(this);
    }

    public final f<K, V> i() {
        return new f(this);
    }

    public final b<K, V> j() {
        return new b(this);
    }

    static {
        f38327a = new a(null);
        d r0 = new d(0);
        r0.n = true;
        o = r0;
    }
}
