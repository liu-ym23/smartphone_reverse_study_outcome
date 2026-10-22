package androidx.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: ArraySet.java */
/* JADX INFO: loaded from: classes.dex */
public final class b<E> implements Collection<E>, Set<E> {
    private static final String TAG = "ArraySet";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f521c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object[] f522d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Object[] f523e;
    private static int f;
    private static Object[] g;
    private static int h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object[] f524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f525b;
    private int[] i;
    private f<E, E> j;

    static {
        f521c = new int[0];
        f522d = new Object[0];
    }

    private int a(Object r5, int r6) {
        int r0 = this.f525b;
        if (r0 != 0) goto L6;
        return -1;
    L6:
        int r1 = c.a(this.i, r0, r6);
        if (r1 >= 0) goto L10;
        return r1;
    L10:
        if (r5.equals(this.f524a[r1]) == false) goto L12;
        return r1;
    L12:
        int r2 = r1 + 1;
    L13:
        if (r2 >= r0) goto L20;
        if (this.i[r2] != r6) goto L20;
        if (r5.equals(this.f524a[r2]) == true) goto L18;
        r2 = r2 + 1;
        goto L13
    L18:
        return r2;
    L20:
        int r3 = r1 - 1;
    L21:
        if (r3 < 0) goto L29;
        if (this.i[r3] != r6) goto L29;
        if (r5.equals(this.f524a[r3]) == true) goto L26;
        r3 = r3 - 1;
        goto L21
    L26:
        return r3;
    L29:
        return ~r2;
    }

    private int a() {
        int r0 = this.f525b;
        if (r0 != 0) goto L6;
        return -1;
    L6:
        int r1 = c.a(this.i, r0, 0);
        if (r1 >= 0) goto L10;
        return r1;
    L10:
        if (this.f524a[r1] != null) goto L12;
        return r1;
    L12:
        int r2 = r1 + 1;
    L13:
        if (r2 >= r0) goto L20;
        if (this.i[r2] != 0) goto L20;
        if (this.f524a[r2] == null) goto L18;
        r2 = r2 + 1;
        goto L13
    L18:
        return r2;
    L20:
        int r3 = r1 - 1;
    L21:
        if (r3 < 0) goto L29;
        if (this.i[r3] != 0) goto L29;
        if (this.f524a[r3] == null) goto L26;
        r3 = r3 - 1;
        goto L21
    L26:
        return r3;
    L29:
        return ~r2;
    }

    private void d(int r9) {
        if (r9 != 8) goto L16;
        monitor-enter(b.class);
        Object[] r5 = g;     // Catch: Throwable -> L12
        if (r5 == null) goto L10;
        this.f524a = r5;     // Catch: Throwable -> L12
        g = (Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(r5[0], Object[].class, "com.obric.aiagent.plugin"), Object[].class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        this.i = (int[]) ZeusTransformUtils.preCheckCast((int[]) ZeusTransformUtils.preCheckCast(r5[1], int[].class, "com.obric.aiagent.plugin"), int[].class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        r5[1] = null;     // Catch: Throwable -> L12
        r5[0] = null;     // Catch: Throwable -> L12
        h--;     // Catch: Throwable -> L12
        monitor-exit(b.class);     // Catch: Throwable -> L12
        return;
    L10:
        monitor-exit(b.class);     // Catch: Throwable -> L12
    L28:
        this.i = new int[r9];
        this.f524a = new Object[r9];
        return;
    L12:
        th = move-exception;
        throw th;
    L16:
        if (r9 != 4) goto L28;
        monitor-enter(b.class);
        Object[] r6 = f523e;     // Catch: Throwable -> L25
        if (r6 == null) goto L23;
        this.f524a = r6;     // Catch: Throwable -> L25
        f523e = (Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(r6[0], Object[].class, "com.obric.aiagent.plugin"), Object[].class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        this.i = (int[]) ZeusTransformUtils.preCheckCast((int[]) ZeusTransformUtils.preCheckCast(r6[1], int[].class, "com.obric.aiagent.plugin"), int[].class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        r6[1] = null;     // Catch: Throwable -> L25
        r6[0] = null;     // Catch: Throwable -> L25
        f--;     // Catch: Throwable -> L25
        monitor-exit(b.class);     // Catch: Throwable -> L25
        return;
    L23:
        monitor-exit(b.class);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    private static void a(int[] r8, Object[] r9, int r10) {
        if (r8.length != 8) goto L17;
        monitor-enter(b.class);
    L13:
        th = move-exception;
        throw th;
    L6:
        if (h >= 10) goto L11;
        r9[0] = g;     // Catch: Throwable -> L13
        r9[1] = r8;     // Catch: Throwable -> L13
        int r11 = r10 - 1;     // Catch: Throwable -> L13
    L8:
        if (r11 < 2) goto L10;
        r9[r11] = null;     // Catch: Throwable -> L13
        r11 = r11 - 1;     // Catch: Throwable -> L13
        goto L8
    L10:
        g = r9;     // Catch: Throwable -> L13
        h++;     // Catch: Throwable -> L13
    L11:
        monitor-exit(b.class);     // Catch: Throwable -> L13
        return;
    L17:
        if (r8.length != 4) goto L37;
        monitor-enter(b.class);
    L27:
        th = move-exception;
        throw th;
    L20:
        if (f >= 10) goto L25;
        r9[0] = f523e;     // Catch: Throwable -> L27
        r9[1] = r8;     // Catch: Throwable -> L27
        int r12 = r10 - 1;     // Catch: Throwable -> L27
    L22:
        if (r12 < 2) goto L24;
        r9[r12] = null;     // Catch: Throwable -> L27
        r12 = r12 - 1;     // Catch: Throwable -> L27
        goto L22
    L24:
        f523e = r9;     // Catch: Throwable -> L27
        f++;     // Catch: Throwable -> L27
    L25:
        monitor-exit(b.class);     // Catch: Throwable -> L27
        return;
    }

    public b() {
        this(0);
    }

    public b(int r1) {
        if (r1 != 0) goto L5;
        this.i = f521c;
        this.f524a = f522d;
    L6:
        this.f525b = 0;
        return;
    L5:
        d(r1);
        goto L6
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int r0 = this.f525b;
        if (r0 == 0) goto L6;
        a(this.i, this.f524a, r0);
        this.i = f521c;
        this.f524a = f522d;
        this.f525b = 0;
        return;
    }

    public void a(int r5) {
        int[] r0 = this.i;
        if (r0.length >= r5) goto L9;
        Object[] r1 = this.f524a;
        d(r5);
        int r6 = this.f525b;
        if (r6 <= 0) goto L7;
        System.arraycopy(r0, 0, this.i, 0, r6);
        System.arraycopy(r1, 0, this.f524a, 0, this.f525b);
    L7:
        a(r0, r1, this.f525b);
        return;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object r1) {
        if (a(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int a(Object r2) {
        if (r2 != null) goto L5;
        return a();
    L5:
        return a(r2, r2.hashCode());
    }

    public E b(int r1) {
        return (E) this.f524a[r1];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        if (this.f525b > 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E r9) {
        if (r9 != null) goto L5;
        int r1 = a();
        int r2 = 0;
    L6:
        if (r1 < 0) goto L8;
        return false;
    L8:
        int r3 = ~r1;
        int r4 = this.f525b;
        int[] r5 = this.i;
        if (r4 < r5.length) goto L19;
        int r6 = 4;
        if (r4 < 8) goto L13;
        r6 = (r4 >> 1) + r4;
    L15:
        Object[] r7 = this.f524a;
        d(r6);
        int[] r8 = this.i;
        if (r8.length <= 0) goto L18;
        System.arraycopy(r5, 0, r8, 0, r5.length);
        System.arraycopy(r7, 0, this.f524a, 0, r7.length);
    L18:
        a(r5, r7, this.f525b);
        goto L19
    L13:
        if (r4 < 4) goto L15;
        r6 = 8;
    L19:
        int r0 = this.f525b;
        if (r3 >= r0) goto L22;
        int[] r10 = this.i;
        int r11 = r3 + 1;
        System.arraycopy(r10, r3, r10, r11, r0 - r3);
        Object[] r12 = this.f524a;
        System.arraycopy(r12, r3, r12, r11, this.f525b - r3);
    L22:
        this.i[r3] = r2;
        this.f524a[r3] = r9;
        this.f525b++;
        return true;
    L5:
        int r13 = r9.hashCode();
        r2 = r13;
        r1 = a(r9, r13);
        goto L6
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object r1) {
        int r2 = a(r1);
        if (r2 < 0) goto L6;
        c(r2);
        return true;
    L6:
        return false;
    }

    public E c(int r9) {
        Object[] r0 = this.f524a;
        E r1 = (E) r0[r9];
        int r2 = this.f525b;
        if (r2 > 1) goto L5;
        a(this.i, r0, r2);
        this.i = f521c;
        this.f524a = f522d;
        this.f525b = 0;
    L21:
        return r1;
    L5:
        int[] r5 = this.i;
        int r7 = 8;
        if (r5.length > 8) goto L8;
    L17:
        int r3 = r2 - 1;
        this.f525b = r3;
        if (r9 >= r3) goto L20;
        int r4 = r9 + 1;
        System.arraycopy(r5, r4, r5, r9, r3 - r9);
        Object[] r6 = this.f524a;
        System.arraycopy(r6, r4, r6, r9, this.f525b - r9);
    L20:
        this.f524a[this.f525b] = null;
        goto L21
    L8:
        if (r2 >= (r5.length / 3)) goto L17;
        if (r2 <= 8) goto L11;
        r7 = r2 + (r2 >> 1);
    L11:
        d(r7);
        this.f525b--;
        if (r9 <= 0) goto L14;
        System.arraycopy(r5, 0, this.i, 0, r9);
        System.arraycopy(r0, 0, this.f524a, 0, r9);
    L14:
        int r8 = this.f525b;
        if (r9 >= r8) goto L21;
        int r10 = r9 + 1;
        System.arraycopy(r5, r10, this.i, r9, r8 - r9);
        System.arraycopy(r0, r10, this.f524a, r9, this.f525b - r9);
        goto L21
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f525b;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int r0 = this.f525b;
        Object[] r1 = new Object[r0];
        System.arraycopy(this.f524a, 0, r1, 0, r0);
        return r1;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] r4) {
        if (r4.length >= this.f525b) goto L5;
        r4 = (T[]) ((Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(Array.newInstance(r4.getClass().getComponentType(), this.f525b), Object[].class, "com.obric.aiagent.plugin"), Object[].class, "com.obric.aiagent.plugin"));
    L5:
        T[] r5 = r4;
        System.arraycopy(this.f524a, 0, r5, 0, this.f525b);
        int r0 = r4.length;
        int r3 = this.f525b;
        if (r0 <= r3) goto L8;
        r4[r3] = null;
    L8:
        return r4;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Set.class) == false) goto L18;
        Set r6 = (Set) ZeusTransformUtils.preCheckCast(r5, Set.class, "com.obric.aiagent.plugin");
        if (size() == r6.size()) goto L10;
        return false;
    L10:
        int r1 = 0;
    L20:
        if (r1 >= this.f525b) goto L17;
        if (r6.contains(b(r1)) == false) goto L15;
        r1 = r1 + 1;
        goto L20
    L15:
        return false;
    L17:
        return true;
    L18:
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] r0 = this.i;
        int r4 = this.f525b;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r4) goto L5;
        r2 = r2 + r0[r1];
        r1 = r1 + 1;
        goto L3
    L5:
        return r2;
    }

    public String toString() {
        if (isEmpty() == false) goto L6;
        return "{}";
    L6:
        StringBuilder r0 = new StringBuilder(this.f525b * 14);
        r0.append('{');
        int r1 = 0;
    L8:
        if (r1 >= this.f525b) goto L16;
        if (r1 <= 0) goto L11;
        r0.append(", ");
    L11:
        E r2 = b(r1);
        if (r2 == this) goto L14;
        r0.append(r2);
    L15:
        r1 = r1 + 1;
        goto L8
    L14:
        r0.append("(this Set)");
        goto L15
    L16:
        r0.append('}');
        return r0.toString();
    }

    private f<E, E> b() {
        if (this.j != null) goto L6;
        this.j = new AnonymousClass1(this);
    L6:
        return this.j;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return b().e().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> r3) {
        Iterator<E> r4 = ((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        if (contains(r4.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        a(this.f525b + r4.size());
        Iterator<E> r5 = r4.iterator();
        boolean r0 = false;
    L4:
        if (r5.hasNext() == false) goto L6;
        r0 = r0 | add(r5.next());
        goto L4
    L6:
        return r0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> r3) {
        Iterator<E> r4 = ((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin")).iterator();
        boolean r0 = false;
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = r0 | remove(r4.next());
        goto L4
    L6:
        return r0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> r5) {
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.aiagent.plugin");
        int r0 = this.f525b - 1;
        boolean r2 = false;
    L3:
        if (r0 < 0) goto L8;
        if (r6.contains(this.f524a[r0]) == true) goto L7;
        c(r0);
        r2 = true;
    L7:
        r0 = r0 - 1;
        goto L3
    L8:
        return r2;
    }
}
