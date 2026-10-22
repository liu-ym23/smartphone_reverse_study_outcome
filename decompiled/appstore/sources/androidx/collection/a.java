package androidx.collection;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Collection, Set {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f1195e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object[] f1196f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Object[] f1197g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f1198h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Object[] f1199i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f1200j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f1201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f1202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MapCollections f1204d;

    /* JADX INFO: renamed from: androidx.collection.a$a, reason: collision with other inner class name */
    public class C0008a extends MapCollections {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f1205d;

        public C0008a(a r10) {
            this.f1205d = r10;
        }

        @Override // androidx.collection.MapCollections
        public void a() {
            this.f1205d.clear();
        }

        @Override // androidx.collection.MapCollections
        public Object b(int r10, int r11) {
            return this.f1205d.f1202b[r10];
        }

        @Override // androidx.collection.MapCollections
        public Map c() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // androidx.collection.MapCollections
        public int d() {
            return this.f1205d.f1203c;
        }

        @Override // androidx.collection.MapCollections
        public int e(Object r10) {
            return this.f1205d.indexOf(r10);
        }

        @Override // androidx.collection.MapCollections
        public int f(Object r10) {
            return this.f1205d.indexOf(r10);
        }

        @Override // androidx.collection.MapCollections
        public void g(Object r10, Object r11) {
            this.f1205d.add(r10);
        }

        @Override // androidx.collection.MapCollections
        public void h(int r10) {
            this.f1205d.g(r10);
        }

        @Override // androidx.collection.MapCollections
        public Object i(int r10, Object r11) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    static {
        f1195e = new int[0];
        f1196f = new Object[0];
    }

    public a() {
        this(0);
    }

    public static void c(int[] r10, Object[] r11, int r12) {
        if (r10.length != 8) goto L19;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f1200j >= 10) goto L14;
        r11[0] = f1199i;     // Catch: Throwable -> L11
        r11[1] = r10;     // Catch: Throwable -> L11
        int r13 = r12 - 1;     // Catch: Throwable -> L11
    L9:
        if (r13 < 2) goto L13;
        r11[r13] = null;     // Catch: Throwable -> L11
        r13 = r13 - 1;     // Catch: Throwable -> L11
        goto L9
    L13:
        f1199i = r11;     // Catch: Throwable -> L11
        f1200j++;     // Catch: Throwable -> L11
    L14:
        monitor-exit(a.class);     // Catch: Throwable -> L11
        return;
    L19:
        if (r10.length == 4) goto L21;
        return;
    L21:
        monitor-enter(a.class);
    L27:
        th = move-exception;
        throw th;
    L23:
        if (f1198h >= 10) goto L30;
        r11[0] = f1197g;     // Catch: Throwable -> L27
        r11[1] = r10;     // Catch: Throwable -> L27
        int r14 = r12 - 1;     // Catch: Throwable -> L27
    L25:
        if (r14 < 2) goto L29;
        r11[r14] = null;     // Catch: Throwable -> L27
        r14 = r14 - 1;     // Catch: Throwable -> L27
        goto L25
    L29:
        f1197g = r11;     // Catch: Throwable -> L27
        f1198h++;     // Catch: Throwable -> L27
    L30:
        monitor-exit(a.class);     // Catch: Throwable -> L27
    }

    public final void a(int r10) {
        if (r10 != 8) goto L18;
        monitor-enter(a.class);
        Object[] r11 = f1199i;     // Catch: Throwable -> L11
        if (r11 == null) goto L13;
        this.f1202b = r11;     // Catch: Throwable -> L11
        f1199i = (Object[]) r11[0];     // Catch: Throwable -> L11
        this.f1201a = (int[]) r11[1];     // Catch: Throwable -> L11
        r11[1] = null;     // Catch: Throwable -> L11
        r11[0] = null;     // Catch: Throwable -> L11
        f1200j--;     // Catch: Throwable -> L11
        monitor-exit(a.class);     // Catch: Throwable -> L11
        return;
    L13:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L32:
        this.f1201a = new int[r10];
        this.f1202b = new Object[r10];
        return;
    L11:
        th = move-exception;
        throw th;
    L18:
        if (r10 != 4) goto L32;
        monitor-enter(a.class);
        Object[] r12 = f1197g;     // Catch: Throwable -> L26
        if (r12 == null) goto L28;
        this.f1202b = r12;     // Catch: Throwable -> L26
        f1197g = (Object[]) r12[0];     // Catch: Throwable -> L26
        this.f1201a = (int[]) r12[1];     // Catch: Throwable -> L26
        r12[1] = null;     // Catch: Throwable -> L26
        r12[0] = null;     // Catch: Throwable -> L26
        f1198h--;     // Catch: Throwable -> L26
        monitor-exit(a.class);     // Catch: Throwable -> L26
        return;
    L28:
        monitor-exit(a.class);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(Object r10) {
        if (r10 != null) goto L5;
        int r11 = f();
        int r12 = 0;
    L6:
        if (r11 < 0) goto L8;
        return false;
    L8:
        int r13 = ~r11;
        int r14 = this.f1203c;
        int[] r15 = this.f1201a;
        if (r14 < r15.length) goto L21;
        int r16 = 8;
        if (r14 < 8) goto L14;
        r16 = (r14 >> 1) + r14;
    L17:
        Object[] r17 = this.f1202b;
        a(r16);
        int[] r18 = this.f1201a;
        if (r18.length <= 0) goto L20;
        System.arraycopy(r15, 0, r18, 0, r15.length);
        System.arraycopy(r17, 0, this.f1202b, 0, r17.length);
    L20:
        c(r15, r17, this.f1203c);
        goto L21
    L14:
        if (r14 >= 4) goto L17;
        r16 = 4;
    L21:
        int r19 = this.f1203c;
        if (r13 >= r19) goto L24;
        int[] r20 = this.f1201a;
        int r21 = r13 + 1;
        System.arraycopy(r20, r13, r20, r21, r19 - r13);
        Object[] r22 = this.f1202b;
        System.arraycopy(r22, r13, r22, r21, this.f1203c - r13);
    L24:
        this.f1201a[r13] = r12;
        this.f1202b[r13] = r10;
        this.f1203c++;
        return true;
    L5:
        int r23 = r10.hashCode();
        r12 = r23;
        r11 = e(r10, r23);
        goto L6
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection r10) {
        b(this.f1203c + r10.size());
        Iterator r11 = r10.iterator();
        boolean r12 = false;
    L4:
        if (r11.hasNext() == false) goto L6;
        r12 = r12 | add(r11.next());
        goto L4
    L6:
        return r12;
    }

    public void b(int r10) {
        int[] r11 = this.f1201a;
        if (r11.length >= r10) goto L9;
        Object[] r12 = this.f1202b;
        a(r10);
        int r13 = this.f1203c;
        if (r13 <= 0) goto L7;
        System.arraycopy(r11, 0, this.f1201a, 0, r13);
        System.arraycopy(r12, 0, this.f1202b, 0, this.f1203c);
    L7:
        c(r11, r12, this.f1203c);
        return;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int r10 = this.f1203c;
        if (r10 == 0) goto L6;
        c(this.f1201a, this.f1202b, r10);
        this.f1201a = f1195e;
        this.f1202b = f1196f;
        this.f1203c = 0;
        return;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object r10) {
        if (indexOf(r10) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection r10) {
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        if (contains(r11.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    public final MapCollections d() {
        if (this.f1204d != null) goto L6;
        this.f1204d = new C0008a(this);
    L6:
        return this.f1204d;
    }

    public final int e(Object r10, int r11) {
        int r12 = this.f1203c;
        if (r12 != 0) goto L6;
        return -1;
    L6:
        int r13 = b.a(this.f1201a, r12, r11);
        if (r13 >= 0) goto L10;
        return r13;
    L10:
        if (r10.equals(this.f1202b[r13]) == false) goto L12;
        return r13;
    L12:
        int r14 = r13 + 1;
    L13:
        if (r14 >= r12) goto L20;
        if (this.f1201a[r14] != r11) goto L20;
        if (r10.equals(this.f1202b[r14]) == true) goto L18;
        r14 = r14 + 1;
        goto L13
    L18:
        return r14;
    L20:
        int r15 = r13 - 1;
    L21:
        if (r15 < 0) goto L29;
        if (this.f1201a[r15] != r11) goto L29;
        if (r10.equals(this.f1202b[r15]) == true) goto L26;
        r15 = r15 - 1;
        goto L21
    L26:
        return r15;
    L29:
        return ~r14;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof Set) == false) goto L18;
        Set r11 = (Set) r10;
        if (size() == r11.size()) goto L10;
        return false;
    L10:
        int r12 = 0;
    L20:
        if (r12 >= this.f1203c) goto L17;
        if (r11.contains(h(r12)) == false) goto L15;
        r12 = r12 + 1;
        goto L20
    L15:
        return false;
    L17:
        return true;
    L18:
        return false;
    }

    public final int f() {
        int r10 = this.f1203c;
        if (r10 != 0) goto L6;
        return -1;
    L6:
        int r11 = b.a(this.f1201a, r10, 0);
        if (r11 >= 0) goto L10;
        return r11;
    L10:
        if (this.f1202b[r11] != null) goto L12;
        return r11;
    L12:
        int r12 = r11 + 1;
    L13:
        if (r12 >= r10) goto L20;
        if (this.f1201a[r12] != 0) goto L20;
        if (this.f1202b[r12] == null) goto L18;
        r12 = r12 + 1;
        goto L13
    L18:
        return r12;
    L20:
        int r13 = r11 - 1;
    L21:
        if (r13 < 0) goto L29;
        if (this.f1201a[r13] != 0) goto L29;
        if (this.f1202b[r13] == null) goto L26;
        r13 = r13 - 1;
        goto L21
    L26:
        return r13;
    L29:
        return ~r12;
    }

    public Object g(int r10) {
        Object[] r11 = this.f1202b;
        Object r12 = r11[r10];
        int r13 = this.f1203c;
        if (r13 > 1) goto L5;
        c(this.f1201a, r11, r13);
        this.f1201a = f1195e;
        this.f1202b = f1196f;
        this.f1203c = 0;
    L21:
        return r12;
    L5:
        int[] r14 = this.f1201a;
        int r15 = 8;
        if (r14.length > 8) goto L8;
    L17:
        int r16 = r13 - 1;
        this.f1203c = r16;
        if (r10 >= r16) goto L20;
        int r17 = r10 + 1;
        System.arraycopy(r14, r17, r14, r10, r16 - r10);
        Object[] r18 = this.f1202b;
        System.arraycopy(r18, r17, r18, r10, this.f1203c - r10);
    L20:
        this.f1202b[this.f1203c] = null;
        goto L21
    L8:
        if (r13 >= (r14.length / 3)) goto L17;
        if (r13 <= 8) goto L11;
        r15 = r13 + (r13 >> 1);
    L11:
        a(r15);
        this.f1203c--;
        if (r10 <= 0) goto L14;
        System.arraycopy(r14, 0, this.f1201a, 0, r10);
        System.arraycopy(r11, 0, this.f1202b, 0, r10);
    L14:
        int r19 = this.f1203c;
        if (r10 >= r19) goto L21;
        int r20 = r10 + 1;
        System.arraycopy(r14, r20, this.f1201a, r10, r19 - r10);
        System.arraycopy(r11, r20, this.f1202b, r10, this.f1203c - r10);
        goto L21
    }

    public Object h(int r10) {
        return this.f1202b[r10];
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] r10 = this.f1201a;
        int r11 = this.f1203c;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r13 = r13 + r10[r12];
        r12 = r12 + 1;
        goto L3
    L5:
        return r13;
    }

    public int indexOf(Object r10) {
        if (r10 != null) goto L5;
        return f();
    L5:
        return e(r10, r10.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        if (this.f1203c > 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return d().m().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object r10) {
        int r11 = indexOf(r10);
        if (r11 < 0) goto L6;
        g(r11);
        return true;
    L6:
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection r10) {
        Iterator r11 = r10.iterator();
        boolean r12 = false;
    L4:
        if (r11.hasNext() == false) goto L6;
        r12 = r12 | remove(r11.next());
        goto L4
    L6:
        return r12;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection r10) {
        int r11 = this.f1203c - 1;
        boolean r12 = false;
    L3:
        if (r11 < 0) goto L8;
        if (r10.contains(this.f1202b[r11]) == true) goto L7;
        g(r11);
        r12 = true;
    L7:
        r11 = r11 - 1;
        goto L3
    L8:
        return r12;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f1203c;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int r10 = this.f1203c;
        Object[] r11 = new Object[r10];
        System.arraycopy(this.f1202b, 0, r11, 0, r10);
        return r11;
    }

    public String toString() {
        if (isEmpty() == false) goto L6;
        return "{}";
    L6:
        StringBuilder r10 = new StringBuilder(this.f1203c * 14);
        r10.append('{');
        int r11 = 0;
    L8:
        if (r11 >= this.f1203c) goto L16;
        if (r11 <= 0) goto L11;
        r10.append(", ");
    L11:
        Object r12 = h(r11);
        if (r12 == this) goto L14;
        r10.append(r12);
    L15:
        r11 = r11 + 1;
        goto L8
    L14:
        r10.append("(this Set)");
        goto L15
    L16:
        r10.append('}');
        return r10.toString();
    }

    public a(int r10) {
        if (r10 != 0) goto L5;
        this.f1201a = f1195e;
        this.f1202b = f1196f;
    L6:
        this.f1203c = 0;
        return;
    L5:
        a(r10);
        goto L6
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray(Object[] r10) {
        if (r10.length >= this.f1203c) goto L5;
        r10 = (Object[]) Array.newInstance(r10.getClass().getComponentType(), this.f1203c);
    L5:
        System.arraycopy(this.f1202b, 0, r10, 0, this.f1203c);
        int r11 = r10.length;
        int r12 = this.f1203c;
        if (r11 <= r12) goto L8;
        r10[r12] = null;
    L8:
        return r10;
    }
}
