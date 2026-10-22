package d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ArrayDeque.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class h<E> extends e<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f38382a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object[] f38383e = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f38384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object[] f38385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f38386d;

    /* JADX INFO: compiled from: ArrayDeque.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    @Override // d.a.e
    public int a() {
        return this.f38386d;
    }

    public h(int r3) {
        if (r3 != 0) goto L5;
        Object[] r4 = f38383e;
    L7:
        this.f38385c = r4;
        return;
    L5:
        if (r3 <= 0) goto L10;
        r4 = new Object[r3];
        goto L7
    L10:
        throw new IllegalArgumentException("Illegal Capacity: " + r3);
    }

    public h() {
        this.f38385c = f38383e;
    }

    public h(Collection<? extends E> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "elements");
        boolean r0 = false;
        Object[] r5 = r4.toArray(new Object[0]);
        this.f38385c = r5;
        this.f38386d = r5.length;
        if (r5.length != 0) goto L5;
        r0 = true;
    L5:
        if (r0 == false) goto L8;
        this.f38385c = f38383e;
        return;
    }

    private final void b(int r3) {
        if (r3 < 0) goto L13;
        Object[] r0 = this.f38385c;
        if (r3 > r0.length) goto L7;
        return;
    L7:
        if (r0 != f38383e) goto L10;
        this.f38385c = new Object[d.l.n.c(r3, 10)];
        return;
    L10:
        c(c.f38373a.c(this.f38385c.length, r3));
        return;
    L13:
        throw new IllegalStateException("Deque is too big.");
    }

    private final void c(int r5) {
        Object[] r6 = new Object[r5];
        Object[] r0 = this.f38385c;
        i.a(r0, r6, 0, this.f38384b, r0.length);
        Object[] r1 = this.f38385c;
        int r2 = r1.length;
        int r3 = this.f38384b;
        i.a(r1, r6, r2 - r3, 0, r3);
        this.f38384b = 0;
        this.f38385c = r6;
    }

    private final int d(int r2) {
        Object[] r1 = this.f38385c;
        if (r2 >= r1.length) goto L5;
        return r2;
    L5:
        return r2 - r1.length;
    }

    private final int e(int r1) {
        if (r1 < 0) goto L4;
        return r1;
    L4:
        return r1 + this.f38385c.length;
    }

    private final int f(int r1) {
        if (r1 != i.f(this.f38385c)) goto L6;
        return 0;
    L6:
        return r1 + 1;
    }

    private final int g(int r1) {
        if (r1 != 0) goto L5;
        return i.f(this.f38385c);
    L5:
        return r1 - 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void a(E r3) {
        e();
        b(size() + 1);
        int r0 = g(this.f38384b);
        this.f38384b = r0;
        this.f38385c[r0] = r3;
        this.f38386d = size() + 1;
    }

    public final void b(E r4) {
        e();
        b(size() + 1);
        this.f38385c[d(this.f38384b + size())] = r4;
        this.f38386d = size() + 1;
    }

    public final E b() {
        if (isEmpty() == true) goto L7;
        e();
        Object[] r0 = this.f38385c;
        int r1 = this.f38384b;
        E r2 = (E) r0[r1];
        r0[r1] = null;
        this.f38384b = f(r1);
        this.f38386d = size() - 1;
        return r2;
    L7:
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E c() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return b();
    }

    public final E d() {
        if (isEmpty() == true) goto L7;
        e();
        int r0 = d(this.f38384b + p.b((List) ZeusTransformUtils.preCheckCast(this, List.class, "com.obric.aiagent.plugin")));
        Object[] r1 = this.f38385c;
        E r2 = (E) r1[r0];
        r1[r0] = null;
        this.f38386d = size() - 1;
        return r2;
    L7:
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E r1) {
        b(r1);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int r8, E r9) {
        c.f38373a.b(r8, size());
        if (r8 != size()) goto L6;
        b(r9);
        return;
    L6:
        if (r8 != 0) goto L9;
        a(r9);
        return;
    L9:
        e();
        b(size() + 1);
        int r0 = d(this.f38384b + r8);
        if (r8 >= ((size() + 1) >> 1)) goto L16;
        int r10 = g(r0);
        int r1 = g(this.f38384b);
        int r2 = this.f38384b;
        if (r10 < r2) goto L14;
        Object[] r3 = this.f38385c;
        r3[r1] = r3[r2];
        i.a(r3, r3, r2, r2 + 1, r10 + 1);
    L15:
        this.f38385c[r10] = r9;
        this.f38384b = r1;
    L21:
        this.f38386d = size() + 1;
        return;
    L14:
        Object[] r4 = this.f38385c;
        i.a(r4, r4, r2 - 1, r2, r4.length);
        Object[] r5 = this.f38385c;
        r5[r5.length - 1] = r5[0];
        i.a(r5, r5, 0, 1, r10 + 1);
        goto L15
    L16:
        int r11 = d(this.f38384b + size());
        if (r0 >= r11) goto L19;
        Object[] r6 = this.f38385c;
        i.a(r6, r6, r0 + 1, r0, r11);
    L20:
        this.f38385c[r0] = r9;
        goto L21
    L19:
        Object[] r7 = this.f38385c;
        i.a(r7, r7, 1, 0, r11);
        Object[] r12 = this.f38385c;
        r12[0] = r12[r12.length - 1];
        i.a(r12, r12, r0 + 1, r0, r12.length - 1);
        goto L20
    }

    private final void a(int r5, Collection<? extends E> r6) {
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.aiagent.plugin");
        Iterator<E> r0 = r7.iterator();
        int r1 = this.f38385c.length;
    L3:
        if (r5 >= r1) goto L7;
        if (r0.hasNext() == false) goto L7;
        this.f38385c[r5] = r0.next();
        r5 = r5 + 1;
    L7:
        int r8 = 0;
        int r2 = this.f38384b;
    L8:
        if (r8 >= r2) goto L12;
        if (r0.hasNext() == false) goto L12;
        this.f38385c[r8] = r0.next();
        r8 = r8 + 1;
    L12:
        this.f38386d = size() + r7.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> r3) {
        Collection<? extends E> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "elements");
        if (r4.isEmpty() == false) goto L6;
        return false;
    L6:
        e();
        b(size() + r4.size());
        a(d(this.f38384b + size()), r4);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int r9, Collection<? extends E> r10) {
        Collection<? extends E> r11 = (Collection) ZeusTransformUtils.wrapperContextForParams(r10, Collection.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "elements");
        c.f38373a.b(r9, size());
        if (r11.isEmpty() == false) goto L6;
        return false;
    L6:
        if (r9 == size()) goto L8;
        e();
        b(size() + r11.size());
        int r0 = d(this.f38384b + size());
        int r2 = d(this.f38384b + r9);
        int r3 = r11.size();
        if (r9 >= ((size() + 1) >> 1)) goto L24;
        int r12 = this.f38384b;
        int r1 = r12 - r3;
        if (r2 < r12) goto L19;
        if (r1 < 0) goto L15;
        Object[] r4 = this.f38385c;
        i.a(r4, r4, r1, r12, r2);
    L23:
        this.f38384b = r1;
        a(e(r2 - r3), r11);
    L38:
        return true;
    L15:
        Object[] r5 = this.f38385c;
        r1 = r1 + r5.length;
        int r6 = r2 - r12;
        int r7 = r5.length - r1;
        if (r7 < r6) goto L18;
        i.a(r5, r5, r1, r12, r2);
        goto L23
    L18:
        i.a(r5, r5, r1, r12, r12 + r7);
        Object[] r13 = this.f38385c;
        i.a(r13, r13, 0, this.f38384b + r7, r2);
        goto L23
    L19:
        Object[] r8 = this.f38385c;
        i.a(r8, r8, r1, r12, r8.length);
        if (r3 < r2) goto L22;
        Object[] r14 = this.f38385c;
        i.a(r14, r14, r14.length - r3, 0, r2);
        goto L23
    L22:
        Object[] r15 = this.f38385c;
        i.a(r15, r15, r15.length - r3, 0, r3);
        Object[] r16 = this.f38385c;
        i.a(r16, r16, 0, r3, r2);
        goto L23
    L24:
        int r17 = r2 + r3;
        if (r2 >= r0) goto L33;
        int r18 = r3 + r0;
        Object[] r19 = this.f38385c;
        if (r18 > r19.length) goto L30;
        i.a(r19, r19, r17, r2, r0);
    L37:
        a(r2, r11);
        goto L38
    L30:
        if (r17 < r19.length) goto L32;
        i.a(r19, r19, r17 - r19.length, r2, r0);
        goto L37
    L32:
        int r20 = r0 - (r18 - r19.length);
        i.a(r19, r19, 0, r20, r0);
        Object[] r21 = this.f38385c;
        i.a(r21, r21, r17, r2, r20);
        goto L37
    L33:
        Object[] r22 = this.f38385c;
        i.a(r22, r22, r3, 0, r0);
        Object[] r23 = this.f38385c;
        if (r17 < r23.length) goto L36;
        i.a(r23, r23, r17 - r23.length, r2, r23.length);
        goto L37
    L36:
        i.a(r23, r23, 0, r23.length - r3, r23.length);
        Object[] r24 = this.f38385c;
        i.a(r24, r24, r17, r2, r24.length - r3);
        goto L37
    L8:
        return addAll(r11);
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int r3) {
        c.f38373a.a(r3, size());
        return (E) this.f38385c[d(this.f38384b + r3)];
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int r3, E r4) {
        c.f38373a.a(r3, size());
        int r5 = d(this.f38384b + r3);
        Object[] r2 = this.f38385c;
        E r0 = (E) r2[r5];
        r2[r5] = r4;
        return r0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object r1) {
        if (indexOf(r1) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object r5) {
        int r0 = d(this.f38384b + size());
        int r1 = this.f38384b;
        if (r1 >= r0) goto L11;
    L4:
        if (r1 >= r0) goto L32;
        if (d.h.b.o.a(r5, this.f38385c[r1]) == true) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        int r4 = this.f38384b;
    L9:
        return r1 - r4;
    L32:
        return -1;
    L11:
        if (r1 < r0) goto L24;
        int r2 = this.f38385c.length;
    L13:
        if (r1 >= r2) goto L18;
        if (d.h.b.o.a(r5, this.f38385c[r1]) == true) goto L16;
        r1 = r1 + 1;
        goto L13
    L16:
        r4 = this.f38384b;
        goto L9
    L18:
        int r3 = 0;
    L19:
        if (r3 >= r0) goto L33;
        if (d.h.b.o.a(r5, this.f38385c[r3]) == true) goto L22;
        r3 = r3 + 1;
        goto L19
    L22:
        r1 = r3 + this.f38385c.length;
        r4 = this.f38384b;
        goto L9
    L33:
        return -1;
    L24:
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object r5) {
        int r0 = d(this.f38384b + size());
        int r1 = this.f38384b;
        if (r1 >= r0) goto L13;
        int r2 = r0 - 1;
        if (r1 <= r2) goto L7;
    L27:
        return -1;
    L7:
        if (d.h.b.o.a(r5, this.f38385c[r2]) == true) goto L8;
        if (r2 == r1) goto L27;
        r2 = r2 - 1;
        goto L7
    L8:
        int r4 = this.f38384b;
    L10:
        return r2 - r4;
    L13:
        if (r1 <= r0) goto L27;
        int r3 = r0 - 1;
    L15:
        if ((-1) >= r3) goto L20;
        if (d.h.b.o.a(r5, this.f38385c[r3]) == true) goto L18;
        r3 = r3 - 1;
        goto L15
    L18:
        r2 = r3 + this.f38385c.length;
        r4 = this.f38384b;
        goto L10
    L20:
        r2 = i.f(this.f38385c);
        int r6 = this.f38384b;
        if (r6 > r2) goto L27;
    L23:
        if (d.h.b.o.a(r5, this.f38385c[r2]) == true) goto L24;
        if (r2 == r6) goto L27;
        r2 = r2 - 1;
        goto L23
    L24:
        r4 = this.f38384b;
        goto L10
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object r2) {
        int r3 = indexOf(r2);
        if (r3 != (-1)) goto L6;
        return false;
    L6:
        remove(r3);
        return true;
    }

    @Override // d.a.e
    public E a(int r9) {
        c.f38373a.a(r9, size());
        if (r9 == p.b((List) ZeusTransformUtils.preCheckCast(this, List.class, "com.obric.aiagent.plugin"))) goto L5;
        if (r9 == 0) goto L8;
        e();
        int r0 = d(this.f38384b + r9);
        E r2 = (E) this.f38385c[r0];
        if (r9 >= (size() >> 1)) goto L16;
        int r10 = this.f38384b;
        if (r0 < r10) goto L14;
        Object[] r1 = this.f38385c;
        i.a(r1, r1, r10 + 1, r10, r0);
    L15:
        Object[] r11 = this.f38385c;
        int r3 = this.f38384b;
        r11[r3] = null;
        this.f38384b = f(r3);
    L21:
        this.f38386d = size() - 1;
        return r2;
    L14:
        Object[] r12 = this.f38385c;
        i.a(r12, r12, 1, 0, r0);
        Object[] r13 = this.f38385c;
        r13[0] = r13[r13.length - 1];
        int r4 = this.f38384b;
        i.a(r13, r13, r4 + 1, r4, r13.length - 1);
        goto L15
    L16:
        int r14 = d(this.f38384b + p.b((List) ZeusTransformUtils.preCheckCast(this, List.class, "com.obric.aiagent.plugin")));
        if (r0 > r14) goto L19;
        Object[] r5 = this.f38385c;
        i.a(r5, r5, r0, r0 + 1, r14 + 1);
    L20:
        this.f38385c[r14] = null;
        goto L21
    L19:
        Object[] r6 = this.f38385c;
        i.a(r6, r6, r0, r0 + 1, r6.length);
        Object[] r7 = this.f38385c;
        r7[r7.length - 1] = r7[0];
        i.a(r7, r7, 0, 1, r14 + 1);
        goto L20
    L8:
        return b();
    L5:
        return d();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L5;
        e();
        c(this.f38384b, d(this.f38384b + size()));
    L5:
        this.f38384b = 0;
        this.f38386d = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] r8) {
        d.h.b.o.e(r8, "array");
        if (r8.length >= size()) goto L6;
        r8 = (T[]) i.a(r8, size());
    L6:
        int r4 = d(this.f38384b + size());
        int r3 = this.f38384b;
        if (r3 >= r4) goto L10;
        i.a(this.f38385c, r8, 0, r3, r4, 2, null);
    L13:
        return (T[]) p.a(size(), r8);
    L10:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L13;
        Object[] r0 = this.f38385c;
        i.a(r0, r8, 0, this.f38384b, r0.length);
        Object[] r1 = this.f38385c;
        i.a(r1, r8, r1.length - this.f38384b, 0, r4);
        goto L13
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    @Override // java.util.AbstractList
    public void removeRange(int r3, int r4) {
        c.f38373a.a(r3, r4, size());
        int r0 = r4 - r3;
        if (r0 != 0) goto L6;
        return;
    L6:
        if (r0 != size()) goto L10;
        clear();
        return;
    L10:
        if (r0 != 1) goto L13;
        remove(r3);
        return;
    L13:
        e();
        if (r3 >= (size() - r4)) goto L16;
        a(r3, r4);
        int r5 = d(this.f38384b + r0);
        c(this.f38384b, r5);
        this.f38384b = r5;
    L17:
        this.f38386d = size() - r0;
        return;
    L16:
        b(r3, r4);
        int r6 = d(this.f38384b + size());
        c(e(r6 - r0), r6);
        goto L17
    }

    private final void a(int r7, int r8) {
        int r0 = d(this.f38384b + (r7 - 1));
        int r9 = d(this.f38384b + (r8 - 1));
    L3:
        if (r7 <= 0) goto L5;
        int r1 = r0 + 1;
        int r2 = Math.min(r7, Math.min(r1, r9 + 1));
        Object[] r3 = this.f38385c;
        int r10 = r9 - r2;
        int r4 = r0 - r2;
        i.a(r3, r3, r10 + 1, r4 + 1, r1);
        r0 = e(r4);
        r9 = e(r10);
        r7 = r7 - r2;
        goto L3
    }

    private final void b(int r5, int r6) {
        int r0 = d(this.f38384b + r6);
        int r7 = d(this.f38384b + r5);
        int r1 = size();
    L3:
        r1 = r1 - r6;
        if (r1 <= 0) goto L6;
        Object[] r8 = this.f38385c;
        r6 = Math.min(r1, Math.min(r8.length - r0, r8.length - r7));
        Object[] r2 = this.f38385c;
        int r3 = r0 + r6;
        i.a(r2, r2, r7, r0, r3);
        r0 = d(r3);
        r7 = d(r7 + r6);
        goto L3
    }

    private final void c(int r4, int r5) {
        if (r4 >= r5) goto L5;
        i.a(this.f38385c, null, r4, r5);
        return;
    L5:
        Object[] r1 = this.f38385c;
        i.a(r1, null, r4, r1.length);
        i.a(this.f38385c, null, 0, r5);
    }

    private final void e() {
        this.modCount++;
    }

    static {
        f38382a = new a(null);
        f38383e = new Object[0];
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> r12) {
        Collection r13 = (Collection) ZeusTransformUtils.wrapperContextForParams(r12, Collection.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r13, "elements");
        boolean r1 = false;
        r1 = false;
        int r2 = 0;
        r1 = false;
        if (isEmpty() == false) goto L5;
    L37:
        return r1;
    L5:
        if (this.f38385c.length != 0) goto L7;
        Object[] r0 = true;
    L8:
        if (r0 == true) goto L37;
        int r3 = d(this.f38384b + size());
        int r4 = this.f38384b;
        if (r4 >= r3) goto L20;
        int r5 = r4;
    L13:
        if (r4 >= r3) goto L19;
        Object r6 = this.f38385c[r4];
        if ((!r13.contains(r6)) == false) goto L17;
        this.f38385c[r5] = r6;
        r5 = r5 + 1;
    L18:
        r4 = r4 + 1;
        goto L13
    L17:
        r1 = true;
        goto L18
    L19:
        i.a(this.f38385c, null, r5, r3);
    L35:
        if (r1 == false) goto L37;
        e();
        this.f38386d = e(r5 - this.f38384b);
        goto L37
    L20:
        int r7 = this.f38385c.length;
        boolean r8 = false;
        int r9 = r4;
    L21:
        if (r4 >= r7) goto L27;
        Object[] r10 = this.f38385c;
        Object r11 = r10[r4];
        r10[r4] = null;
        if ((!r13.contains(r11)) == false) goto L25;
        this.f38385c[r9] = r11;
        r9 = r9 + 1;
    L26:
        r4 = r4 + 1;
        goto L21
    L25:
        r8 = true;
        goto L26
    L27:
        r5 = d(r9);
    L28:
        if (r2 >= r3) goto L34;
        Object[] r14 = this.f38385c;
        Object r15 = r14[r2];
        r14[r2] = null;
        if ((!r13.contains(r15)) == false) goto L32;
        this.f38385c[r5] = r15;
        r5 = f(r5);
    L33:
        r2 = r2 + 1;
        goto L28
    L32:
        r8 = true;
        goto L33
    L34:
        r1 = r8;
        goto L35
    L7:
        r0 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> r12) {
        Collection r13 = (Collection) ZeusTransformUtils.wrapperContextForParams(r12, Collection.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r13, "elements");
        boolean r1 = false;
        r1 = false;
        int r2 = 0;
        r1 = false;
        if (isEmpty() == false) goto L5;
    L37:
        return r1;
    L5:
        if (this.f38385c.length != 0) goto L7;
        Object[] r0 = true;
    L8:
        if (r0 == true) goto L37;
        int r3 = d(this.f38384b + size());
        int r4 = this.f38384b;
        if (r4 >= r3) goto L20;
        int r5 = r4;
    L13:
        if (r4 >= r3) goto L19;
        Object r6 = this.f38385c[r4];
        if (r13.contains(r6) == false) goto L17;
        this.f38385c[r5] = r6;
        r5 = r5 + 1;
    L18:
        r4 = r4 + 1;
        goto L13
    L17:
        r1 = true;
        goto L18
    L19:
        i.a(this.f38385c, null, r5, r3);
    L35:
        if (r1 == false) goto L37;
        e();
        this.f38386d = e(r5 - this.f38384b);
        goto L37
    L20:
        int r7 = this.f38385c.length;
        boolean r8 = false;
        int r9 = r4;
    L21:
        if (r4 >= r7) goto L27;
        Object[] r10 = this.f38385c;
        Object r11 = r10[r4];
        r10[r4] = null;
        if (r13.contains(r11) == false) goto L25;
        this.f38385c[r9] = r11;
        r9 = r9 + 1;
    L26:
        r4 = r4 + 1;
        goto L21
    L25:
        r8 = true;
        goto L26
    L27:
        r5 = d(r9);
    L28:
        if (r2 >= r3) goto L34;
        Object[] r14 = this.f38385c;
        Object r15 = r14[r2];
        r14[r2] = null;
        if (r13.contains(r15) == false) goto L32;
        this.f38385c[r5] = r15;
        r5 = f(r5);
    L33:
        r2 = r2 + 1;
        goto L28
    L32:
        r8 = true;
        goto L33
    L34:
        r1 = r8;
        goto L35
    L7:
        r0 = false;
        goto L8
    }
}
