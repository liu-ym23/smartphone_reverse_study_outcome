package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class i extends e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f21095d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object[] f21096e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f21097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f21098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21099c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f21095d = new a(null);
        f21096e = new Object[0];
    }

    public i(int r10) {
        if (r10 != 0) goto L5;
        Object[] r11 = f21096e;
    L7:
        this.f21098b = r11;
        return;
    L5:
        if (r10 <= 0) goto L10;
        r11 = new Object[r10];
        goto L7
    L10:
        throw new IllegalArgumentException("Illegal Capacity: " + r10);
    }

    public final void a(int r10, Collection r11) {
        Iterator r12 = r11.iterator();
        int r13 = this.f21098b.length;
    L3:
        if (r10 >= r13) goto L7;
        if (r12.hasNext() == false) goto L7;
        this.f21098b[r10] = r12.next();
        r10 = r10 + 1;
    L7:
        int r14 = this.f21097a;
        int r15 = 0;
    L8:
        if (r15 >= r14) goto L12;
        if (r12.hasNext() == false) goto L12;
        this.f21098b[r15] = r12.next();
        r15 = r15 + 1;
    L12:
        this.f21099c = size() + r11.size();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object r10) {
        addLast(r10);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection r10) {
        kotlin.jvm.internal.q.g(r10, "elements");
        if (r10.isEmpty() == false) goto L6;
        return false;
    L6:
        d(size() + r10.size());
        a(i(this.f21097a + size()), r10);
        return true;
    }

    public final void addFirst(Object r10) {
        d(size() + 1);
        int r11 = c(this.f21097a);
        this.f21097a = r11;
        this.f21098b[r11] = r10;
        this.f21099c = size() + 1;
    }

    public final void addLast(Object r10) {
        d(size() + 1);
        this.f21098b[i(this.f21097a + size())] = r10;
        this.f21099c = size() + 1;
    }

    public final void b(int r10) {
        Object[] r11 = new Object[r10];
        Object[] r12 = this.f21098b;
        m.e(r12, r11, 0, this.f21097a, r12.length);
        Object[] r13 = this.f21098b;
        int r14 = r13.length;
        int r15 = this.f21097a;
        m.e(r13, r11, r14 - r15, 0, r15);
        this.f21097a = 0;
        this.f21098b = r11;
    }

    public final int c(int r10) {
        if (r10 != 0) goto L5;
        return n.t(this.f21098b);
    L5:
        return r10 - 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int r10 = i(this.f21097a + size());
        int r11 = this.f21097a;
        if (r11 >= r10) goto L6;
        m.i(this.f21098b, null, r11, r10);
    L8:
        this.f21097a = 0;
        this.f21099c = 0;
        return;
    L6:
        if (isEmpty() == true) goto L8;
        Object[] r12 = this.f21098b;
        m.i(r12, null, this.f21097a, r12.length);
        m.i(this.f21098b, null, 0, r10);
        goto L8
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object r10) {
        if (indexOf(r10) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public final void d(int r10) {
        if (r10 < 0) goto L13;
        Object[] r11 = this.f21098b;
        if (r10 > r11.length) goto L7;
        return;
    L7:
        if (r11 != f21096e) goto L10;
        this.f21098b = new Object[bg.h.d(r10, 10)];
        return;
    L10:
        b(b.Companion.d(r11.length, r10));
        return;
    L13:
        throw new IllegalStateException("Deque is too big.");
    }

    public final Object e() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return this.f21098b[this.f21097a];
    }

    public final int f(int r10) {
        if (r10 != n.t(this.f21098b)) goto L6;
        return 0;
    L6:
        return r10 + 1;
    }

    public final Object first() {
        if (isEmpty() == true) goto L7;
        return this.f21098b[this.f21097a];
    L7:
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final Object g() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return this.f21098b[i(this.f21097a + t.k(this))];
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int r10) {
        b.Companion.a(r10, size());
        return this.f21098b[i(this.f21097a + r10)];
    }

    @Override // kotlin.collections.e
    public int getSize() {
        return this.f21099c;
    }

    public final int h(int r10) {
        if (r10 < 0) goto L4;
        return r10;
    L4:
        return r10 + this.f21098b.length;
    }

    public final int i(int r10) {
        Object[] r11 = this.f21098b;
        if (r10 >= r11.length) goto L5;
        return r10;
    L5:
        return r10 - r11.length;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object r10) {
        int r11 = i(this.f21097a + size());
        int r12 = this.f21097a;
        if (r12 >= r11) goto L11;
    L4:
        if (r12 >= r11) goto L32;
        if (kotlin.jvm.internal.q.b(r10, this.f21098b[r12]) == true) goto L7;
        r12 = r12 + 1;
        goto L4
    L7:
        int r13 = this.f21097a;
    L9:
        return r12 - r13;
    L32:
        return -1;
    L11:
        if (r12 < r11) goto L24;
        int r14 = this.f21098b.length;
    L13:
        if (r12 >= r14) goto L18;
        if (kotlin.jvm.internal.q.b(r10, this.f21098b[r12]) == true) goto L16;
        r12 = r12 + 1;
        goto L13
    L16:
        r13 = this.f21097a;
        goto L9
    L18:
        int r15 = 0;
    L19:
        if (r15 >= r11) goto L33;
        if (kotlin.jvm.internal.q.b(r10, this.f21098b[r15]) == true) goto L22;
        r15 = r15 + 1;
        goto L19
    L22:
        r12 = r15 + this.f21098b.length;
        r13 = this.f21097a;
        goto L9
    L33:
        return -1;
    L24:
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final Object j() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return removeFirst();
    }

    public final Object last() {
        if (isEmpty() == true) goto L7;
        return this.f21098b[i(this.f21097a + t.k(this))];
    L7:
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object r10) {
        int r11 = i(this.f21097a + size());
        int r12 = this.f21097a;
        if (r12 >= r11) goto L13;
        int r13 = r11 - 1;
        if (r12 <= r13) goto L7;
    L27:
        return -1;
    L7:
        if (kotlin.jvm.internal.q.b(r10, this.f21098b[r13]) == true) goto L8;
        if (r13 == r12) goto L27;
        r13 = r13 - 1;
        goto L7
    L8:
        int r14 = this.f21097a;
    L10:
        return r13 - r14;
    L13:
        if (r12 <= r11) goto L27;
        int r15 = r11 - 1;
    L15:
        if ((-1) >= r15) goto L20;
        if (kotlin.jvm.internal.q.b(r10, this.f21098b[r15]) == true) goto L18;
        r15 = r15 - 1;
        goto L15
    L18:
        r13 = r15 + this.f21098b.length;
        r14 = this.f21097a;
        goto L10
    L20:
        r13 = n.t(this.f21098b);
        int r16 = this.f21097a;
        if (r16 > r13) goto L27;
    L23:
        if (kotlin.jvm.internal.q.b(r10, this.f21098b[r13]) == true) goto L24;
        if (r13 == r16) goto L27;
        r13 = r13 - 1;
        goto L23
    L24:
        r14 = this.f21097a;
        goto L10
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object r10) {
        int r11 = indexOf(r10);
        if (r11 != (-1)) goto L6;
        return false;
    L6:
        remove(r11);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection r12) {
        kotlin.jvm.internal.q.g(r12, "elements");
        boolean r10 = false;
        r10 = false;
        int r11 = 0;
        r10 = false;
        if (isEmpty() == false) goto L5;
    L34:
        return r10;
    L5:
        if (this.f21098b.length == 0) goto L34;
        int r13 = i(this.f21097a + size());
        int r14 = this.f21097a;
        if (r14 >= r13) goto L17;
        int r15 = r14;
    L10:
        if (r14 >= r13) goto L16;
        Object r16 = this.f21098b[r14];
        if (r12.contains(r16) == true) goto L14;
        this.f21098b[r15] = r16;
        r15 = r15 + 1;
    L15:
        r14 = r14 + 1;
        goto L10
    L14:
        r10 = true;
        goto L15
    L16:
        m.i(this.f21098b, null, r15, r13);
    L32:
        if (r10 == false) goto L34;
        this.f21099c = h(r15 - this.f21097a);
        goto L34
    L17:
        int r17 = this.f21098b.length;
        boolean r18 = false;
        int r19 = r14;
    L18:
        if (r14 >= r17) goto L24;
        Object[] r20 = this.f21098b;
        Object r21 = r20[r14];
        r20[r14] = null;
        if (r12.contains(r21) == true) goto L22;
        this.f21098b[r19] = r21;
        r19 = r19 + 1;
    L23:
        r14 = r14 + 1;
        goto L18
    L22:
        r18 = true;
        goto L23
    L24:
        r15 = i(r19);
    L25:
        if (r11 >= r13) goto L31;
        Object[] r22 = this.f21098b;
        Object r23 = r22[r11];
        r22[r11] = null;
        if (r12.contains(r23) == true) goto L29;
        this.f21098b[r15] = r23;
        r15 = f(r15);
    L30:
        r11 = r11 + 1;
        goto L25
    L29:
        r18 = true;
        goto L30
    L31:
        r10 = r18;
        goto L32
    }

    @Override // kotlin.collections.e
    public Object removeAt(int r10) {
        b.Companion.a(r10, size());
        if (r10 == t.k(this)) goto L5;
        if (r10 == 0) goto L8;
        int r11 = i(this.f21097a + r10);
        Object r12 = this.f21098b[r11];
        if (r10 >= (size() >> 1)) goto L16;
        int r13 = this.f21097a;
        if (r11 < r13) goto L14;
        Object[] r14 = this.f21098b;
        m.e(r14, r14, r13 + 1, r13, r11);
    L15:
        Object[] r15 = this.f21098b;
        int r16 = this.f21097a;
        r15[r16] = null;
        this.f21097a = f(r16);
    L21:
        this.f21099c = size() - 1;
        return r12;
    L14:
        Object[] r17 = this.f21098b;
        m.e(r17, r17, 1, 0, r11);
        Object[] r18 = this.f21098b;
        r18[0] = r18[r18.length - 1];
        int r19 = this.f21097a;
        m.e(r18, r18, r19 + 1, r19, r18.length - 1);
        goto L15
    L16:
        int r20 = i(this.f21097a + t.k(this));
        if (r11 > r20) goto L19;
        Object[] r21 = this.f21098b;
        m.e(r21, r21, r11, r11 + 1, r20 + 1);
    L20:
        this.f21098b[r20] = null;
        goto L21
    L19:
        Object[] r22 = this.f21098b;
        m.e(r22, r22, r11, r11 + 1, r22.length);
        Object[] r23 = this.f21098b;
        r23[r23.length - 1] = r23[0];
        m.e(r23, r23, 0, 1, r20 + 1);
        goto L20
    L8:
        return removeFirst();
    L5:
        return removeLast();
    }

    public final Object removeFirst() {
        if (isEmpty() == true) goto L7;
        Object[] r10 = this.f21098b;
        int r11 = this.f21097a;
        Object r12 = r10[r11];
        r10[r11] = null;
        this.f21097a = f(r11);
        this.f21099c = size() - 1;
        return r12;
    L7:
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final Object removeLast() {
        if (isEmpty() == true) goto L7;
        int r10 = i(this.f21097a + t.k(this));
        Object[] r11 = this.f21098b;
        Object r12 = r11[r10];
        r11[r10] = null;
        this.f21099c = size() - 1;
        return r12;
    L7:
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection r12) {
        kotlin.jvm.internal.q.g(r12, "elements");
        boolean r10 = false;
        r10 = false;
        int r11 = 0;
        r10 = false;
        if (isEmpty() == false) goto L5;
    L34:
        return r10;
    L5:
        if (this.f21098b.length == 0) goto L34;
        int r13 = i(this.f21097a + size());
        int r14 = this.f21097a;
        if (r14 >= r13) goto L17;
        int r15 = r14;
    L10:
        if (r14 >= r13) goto L16;
        Object r16 = this.f21098b[r14];
        if (r12.contains(r16) == false) goto L14;
        this.f21098b[r15] = r16;
        r15 = r15 + 1;
    L15:
        r14 = r14 + 1;
        goto L10
    L14:
        r10 = true;
        goto L15
    L16:
        m.i(this.f21098b, null, r15, r13);
    L32:
        if (r10 == false) goto L34;
        this.f21099c = h(r15 - this.f21097a);
        goto L34
    L17:
        int r17 = this.f21098b.length;
        boolean r18 = false;
        int r19 = r14;
    L18:
        if (r14 >= r17) goto L24;
        Object[] r20 = this.f21098b;
        Object r21 = r20[r14];
        r20[r14] = null;
        if (r12.contains(r21) == false) goto L22;
        this.f21098b[r19] = r21;
        r19 = r19 + 1;
    L23:
        r14 = r14 + 1;
        goto L18
    L22:
        r18 = true;
        goto L23
    L24:
        r15 = i(r19);
    L25:
        if (r11 >= r13) goto L31;
        Object[] r22 = this.f21098b;
        Object r23 = r22[r11];
        r22[r11] = null;
        if (r12.contains(r23) == false) goto L29;
        this.f21098b[r15] = r23;
        r15 = f(r15);
    L30:
        r11 = r11 + 1;
        goto L25
    L29:
        r18 = true;
        goto L30
    L31:
        r10 = r18;
        goto L32
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int r10, Object r11) {
        b.Companion.a(r10, size());
        int r12 = i(this.f21097a + r10);
        Object[] r13 = this.f21098b;
        Object r14 = r13[r12];
        r13[r12] = r11;
        return r14;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray(Object[] r10) {
        kotlin.jvm.internal.q.g(r10, "array");
        if (r10.length >= size()) goto L6;
        r10 = k.a(r10, size());
    L6:
        int r11 = i(this.f21097a + size());
        int r12 = this.f21097a;
        if (r12 >= r11) goto L10;
        m.f(this.f21098b, r10, 0, r12, r11, 2, null);
    L13:
        return s.f(size(), r10);
    L10:
        if (isEmpty() == true) goto L13;
        Object[] r13 = this.f21098b;
        m.e(r13, r10, 0, this.f21097a, r13.length);
        Object[] r14 = this.f21098b;
        m.e(r14, r10, r14.length - this.f21097a, 0, r11);
        goto L13
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int r10, Object r11) {
        b.Companion.b(r10, size());
        if (r10 != size()) goto L6;
        addLast(r11);
        return;
    L6:
        if (r10 != 0) goto L9;
        addFirst(r11);
        return;
    L9:
        d(size() + 1);
        int r12 = i(this.f21097a + r10);
        if (r10 >= ((size() + 1) >> 1)) goto L16;
        int r13 = c(r12);
        int r14 = c(this.f21097a);
        int r15 = this.f21097a;
        if (r13 < r15) goto L14;
        Object[] r16 = this.f21098b;
        r16[r14] = r16[r15];
        m.e(r16, r16, r15, r15 + 1, r13 + 1);
    L15:
        this.f21098b[r13] = r11;
        this.f21097a = r14;
    L21:
        this.f21099c = size() + 1;
        return;
    L14:
        Object[] r17 = this.f21098b;
        m.e(r17, r17, r15 - 1, r15, r17.length);
        Object[] r18 = this.f21098b;
        r18[r18.length - 1] = r18[0];
        m.e(r18, r18, 0, 1, r13 + 1);
        goto L15
    L16:
        int r19 = i(this.f21097a + size());
        if (r12 >= r19) goto L19;
        Object[] r20 = this.f21098b;
        m.e(r20, r20, r12 + 1, r12, r19);
    L20:
        this.f21098b[r12] = r11;
        goto L21
    L19:
        Object[] r21 = this.f21098b;
        m.e(r21, r21, 1, 0, r19);
        Object[] r22 = this.f21098b;
        r22[0] = r22[r22.length - 1];
        m.e(r22, r22, r12 + 1, r12, r22.length - 1);
        goto L20
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int r10, Collection r11) {
        kotlin.jvm.internal.q.g(r11, "elements");
        b.Companion.b(r10, size());
        if (r11.isEmpty() == false) goto L6;
        return false;
    L6:
        if (r10 == size()) goto L8;
        d(size() + r11.size());
        int r12 = i(this.f21097a + size());
        int r13 = i(this.f21097a + r10);
        int r14 = r11.size();
        if (r10 >= ((size() + 1) >> 1)) goto L24;
        int r15 = this.f21097a;
        int r16 = r15 - r14;
        if (r13 < r15) goto L19;
        if (r16 < 0) goto L15;
        Object[] r17 = this.f21098b;
        m.e(r17, r17, r16, r15, r13);
    L23:
        this.f21097a = r16;
        a(h(r13 - r14), r11);
    L38:
        return true;
    L15:
        Object[] r18 = this.f21098b;
        r16 = r16 + r18.length;
        int r19 = r13 - r15;
        int r20 = r18.length - r16;
        if (r20 < r19) goto L18;
        m.e(r18, r18, r16, r15, r13);
        goto L23
    L18:
        m.e(r18, r18, r16, r15, r15 + r20);
        Object[] r21 = this.f21098b;
        m.e(r21, r21, 0, this.f21097a + r20, r13);
        goto L23
    L19:
        Object[] r22 = this.f21098b;
        m.e(r22, r22, r16, r15, r22.length);
        if (r14 < r13) goto L22;
        Object[] r23 = this.f21098b;
        m.e(r23, r23, r23.length - r14, 0, r13);
        goto L23
    L22:
        Object[] r24 = this.f21098b;
        m.e(r24, r24, r24.length - r14, 0, r14);
        Object[] r25 = this.f21098b;
        m.e(r25, r25, 0, r14, r13);
        goto L23
    L24:
        int r26 = r13 + r14;
        if (r13 >= r12) goto L33;
        int r27 = r14 + r12;
        Object[] r28 = this.f21098b;
        if (r27 > r28.length) goto L30;
        m.e(r28, r28, r26, r13, r12);
    L37:
        a(r13, r11);
        goto L38
    L30:
        if (r26 < r28.length) goto L32;
        m.e(r28, r28, r26 - r28.length, r13, r12);
        goto L37
    L32:
        int r29 = r12 - (r27 - r28.length);
        m.e(r28, r28, 0, r29, r12);
        Object[] r30 = this.f21098b;
        m.e(r30, r30, r26, r13, r29);
        goto L37
    L33:
        Object[] r31 = this.f21098b;
        m.e(r31, r31, r14, 0, r12);
        Object[] r32 = this.f21098b;
        if (r26 < r32.length) goto L36;
        m.e(r32, r32, r26 - r32.length, r13, r32.length);
        goto L37
    L36:
        m.e(r32, r32, 0, r32.length - r14, r32.length);
        Object[] r33 = this.f21098b;
        m.e(r33, r33, r26, r13, r33.length - r14);
        goto L37
    L8:
        return addAll(r11);
    }

    public i() {
        this.f21098b = f21096e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
