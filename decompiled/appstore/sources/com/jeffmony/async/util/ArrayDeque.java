package com.jeffmony.async.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public class ArrayDeque<E> extends AbstractCollection<E> implements Deque<E>, Cloneable, Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MIN_INITIAL_CAPACITY = 8;
    private static final long serialVersionUID = 2340985798034038923L;
    private transient Object[] elements;
    private transient int head;
    private transient int tail;

    public static /* synthetic */ class a {
    }

    public class b implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f10425a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f10426b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f10427c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ArrayDeque f10428d;

        public b(ArrayDeque r10) {
            this.f10428d = r10;
            this.f10425a = ArrayDeque.access$200(r10);
            this.f10426b = ArrayDeque.access$300(r10);
            this.f10427c = -1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f10425a == this.f10426b) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.f10425a == this.f10426b) goto L12;
            Object r10 = ArrayDeque.access$400(this.f10428d)[this.f10425a];
            if (ArrayDeque.access$300(this.f10428d) != this.f10426b) goto L10;
            if (r10 == null) goto L10;
            int r11 = this.f10425a;
            this.f10427c = r11;
            this.f10425a = (r11 + 1) & (ArrayDeque.access$400(this.f10428d).length - 1);
            return r10;
        L10:
            throw new ConcurrentModificationException();
        L12:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            int r10 = this.f10427c;
            if (r10 < 0) goto L10;
            if (ArrayDeque.access$500(this.f10428d, r10) == false) goto L7;
            this.f10425a = (this.f10425a - 1) & (ArrayDeque.access$400(this.f10428d).length - 1);
            this.f10426b = ArrayDeque.access$300(this.f10428d);
        L7:
            this.f10427c = -1;
            return;
        L10:
            throw new IllegalStateException();
        }

        public /* synthetic */ b(ArrayDeque r10, a r11) {
            this(r10);
        }
    }

    public class c implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f10429a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f10430b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f10431c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ArrayDeque f10432d;

        public c(ArrayDeque r10) {
            this.f10432d = r10;
            this.f10429a = ArrayDeque.access$300(r10);
            this.f10430b = ArrayDeque.access$200(r10);
            this.f10431c = -1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f10429a == this.f10430b) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            int r10 = this.f10429a;
            if (r10 == this.f10430b) goto L12;
            this.f10429a = (r10 - 1) & (ArrayDeque.access$400(this.f10432d).length - 1);
            Object r11 = ArrayDeque.access$400(this.f10432d)[this.f10429a];
            if (ArrayDeque.access$200(this.f10432d) != this.f10430b) goto L10;
            if (r11 == null) goto L10;
            this.f10431c = this.f10429a;
            return r11;
        L10:
            throw new ConcurrentModificationException();
        L12:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            int r10 = this.f10431c;
            if (r10 < 0) goto L10;
            if (ArrayDeque.access$500(this.f10432d, r10) == true) goto L7;
            this.f10429a = (this.f10429a + 1) & (ArrayDeque.access$400(this.f10432d).length - 1);
            this.f10430b = ArrayDeque.access$200(this.f10432d);
        L7:
            this.f10431c = -1;
            return;
        L10:
            throw new IllegalStateException();
        }

        public /* synthetic */ c(ArrayDeque r10, a r11) {
            this(r10);
        }
    }

    static {
    }

    public ArrayDeque() {
        this.elements = new Object[16];
    }

    public static /* synthetic */ int access$200(ArrayDeque r10) {
        return r10.head;
    }

    public static /* synthetic */ int access$300(ArrayDeque r10) {
        return r10.tail;
    }

    public static /* synthetic */ Object[] access$400(ArrayDeque r10) {
        return r10.elements;
    }

    public static /* synthetic */ boolean access$500(ArrayDeque r10, int r11) {
        return r10.delete(r11);
    }

    private void allocateElements(int r10) {
        int r11 = 8;
        if (r10 < 8) goto L7;
        int r12 = r10 | (r10 >>> 1);
        int r13 = r12 | (r12 >>> 2);
        int r14 = r13 | (r13 >>> 4);
        int r15 = r14 | (r14 >>> 8);
        r11 = (r15 | (r15 >>> 16)) + 1;
        if (r11 >= 0) goto L7;
        r11 = r11 >>> 1;
    L7:
        this.elements = new Object[r11];
    }

    private void checkInvariants() {
    }

    private <T> T[] copyElements(T[] r10) {
        int r11 = this.head;
        int r12 = this.tail;
        if (r11 >= r12) goto L5;
        System.arraycopy(this.elements, r11, r10, 0, size());
    L7:
        return r10;
    L5:
        if (r11 <= r12) goto L7;
        Object[] r13 = this.elements;
        int r14 = r13.length - r11;
        System.arraycopy(r13, r11, r10, 0, r14);
        System.arraycopy(this.elements, 0, r10, r14, this.tail);
        goto L7
    }

    private boolean delete(int r10) {
        checkInvariants();
        Object[] r11 = this.elements;
        int r12 = r11.length - 1;
        int r13 = this.head;
        int r14 = this.tail;
        int r15 = (r10 - r13) & r12;
        int r16 = (r14 - r10) & r12;
        if (r15 >= ((r14 - r13) & r12)) goto L16;
        if (r15 >= r16) goto L11;
        if (r13 > r10) goto L8;
        System.arraycopy(r11, r13, r11, r13 + 1, r15);
    L9:
        r11[r13] = null;
        this.head = (r13 + 1) & r12;
        return false;
    L8:
        System.arraycopy(r11, 0, r11, 1, r10);
        r11[0] = r11[r12];
        System.arraycopy(r11, r13, r11, r13 + 1, r12 - r13);
        goto L9
    L11:
        if (r10 >= r14) goto L13;
        System.arraycopy(r11, r10 + 1, r11, r10, r16);
        this.tail = r14 - 1;
    L14:
        return true;
    L13:
        System.arraycopy(r11, r10 + 1, r11, r10, r12 - r10);
        r11[r12] = r11[0];
        System.arraycopy(r11, 1, r11, 0, r14);
        this.tail = (r14 - 1) & r12;
        goto L14
    L16:
        throw new ConcurrentModificationException();
    }

    private void doubleCapacity() {
        int r10 = this.head;
        Object[] r11 = this.elements;
        int r12 = r11.length;
        int r13 = r12 - r10;
        int r14 = r12 << 1;
        if (r14 < 0) goto L7;
        Object[] r15 = new Object[r14];
        System.arraycopy(r11, r10, r15, 0, r13);
        System.arraycopy(this.elements, 0, r15, r13, r10);
        this.elements = r15;
        this.head = 0;
        this.tail = r12;
        return;
    L7:
        throw new IllegalStateException("Sorry, deque too big");
    }

    private void readObject(ObjectInputStream r10) throws IOException, ClassNotFoundException {
        r10.defaultReadObject();
        int r11 = r10.readInt();
        allocateElements(r11);
        int r12 = 0;
        this.head = 0;
        this.tail = r11;
    L3:
        if (r12 >= r11) goto L5;
        this.elements[r12] = r10.readObject();
        r12 = r12 + 1;
        goto L3
    }

    private void writeObject(ObjectOutputStream r10) throws IOException {
        r10.defaultWriteObject();
        r10.writeInt(size());
        int r11 = this.elements.length - 1;
        int r12 = this.head;
    L4:
        if (r12 == this.tail) goto L6;
        r10.writeObject(this.elements[r12]);
        r12 = (r12 + 1) & r11;
        goto L4
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.jeffmony.async.util.Deque, java.util.Queue
    public boolean add(E r10) {
        addLast(r10);
        return true;
    }

    @Override // com.jeffmony.async.util.Deque
    public void addFirst(E r10) {
        if (r10 == null) goto L8;
        Object[] r11 = this.elements;
        int r12 = (this.head - 1) & (r11.length - 1);
        this.head = r12;
        r11[r12] = r10;
        if (r12 != this.tail) goto L9;
        doubleCapacity();
        return;
    L9:
        return;
    L8:
        throw new NullPointerException("e == null");
    }

    @Override // com.jeffmony.async.util.Deque
    public void addLast(E r10) {
        if (r10 == null) goto L8;
        Object[] r11 = this.elements;
        int r12 = this.tail;
        r11[r12] = r10;
        int r13 = (r11.length - 1) & (r12 + 1);
        this.tail = r13;
        if (r13 != this.head) goto L9;
        doubleCapacity();
        return;
    L9:
        return;
    L8:
        throw new NullPointerException("e == null");
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        int r10 = this.head;
        int r11 = this.tail;
        if (r10 == r11) goto L7;
        this.tail = 0;
        this.head = 0;
        int r12 = this.elements.length - 1;
    L5:
        this.elements[r10] = null;
        r10 = (r10 + 1) & r12;
        if (r10 != r11) goto L5;
        return;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m14clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.jeffmony.async.util.Deque
    public boolean contains(Object r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        int r11 = this.elements.length - 1;
        int r12 = this.head;
    L6:
        Object r13 = this.elements[r12];
        if (r13 == null) goto L12;
        if (r10.equals(r13) == true) goto L10;
        r12 = (r12 + 1) & r11;
        goto L6
    L10:
        return true;
    L12:
        return false;
    }

    @Override // com.jeffmony.async.util.Deque
    public Iterator<E> descendingIterator() {
        return new c(this, null);
    }

    @Override // com.jeffmony.async.util.Deque, java.util.Queue
    public E element() {
        return getFirst();
    }

    @Override // com.jeffmony.async.util.Deque
    public E getFirst() {
        E r10 = (E) this.elements[this.head];
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new NoSuchElementException();
    }

    @Override // com.jeffmony.async.util.Deque
    public E getLast() {
        Object[] r10 = this.elements;
        E r11 = (E) r10[(this.tail - 1) & (r10.length - 1)];
        if (r11 == null) goto L6;
        return r11;
    L6:
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        if (this.head != this.tail) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.jeffmony.async.util.Deque
    public Iterator<E> iterator() {
        return new b(this, null);
    }

    @Override // com.jeffmony.async.util.Deque, java.util.Queue
    public boolean offer(E r10) {
        return offerLast(r10);
    }

    @Override // com.jeffmony.async.util.Deque
    public boolean offerFirst(E r10) {
        addFirst(r10);
        return true;
    }

    @Override // com.jeffmony.async.util.Deque
    public boolean offerLast(E r10) {
        addLast(r10);
        return true;
    }

    @Override // com.jeffmony.async.util.Deque, java.util.Queue
    public E peek() {
        return peekFirst();
    }

    @Override // com.jeffmony.async.util.Deque
    public E peekFirst() {
        return (E) this.elements[this.head];
    }

    @Override // com.jeffmony.async.util.Deque
    public E peekLast() {
        Object[] r10 = this.elements;
        return (E) r10[(this.tail - 1) & (r10.length - 1)];
    }

    @Override // com.jeffmony.async.util.Deque, java.util.Queue
    public E poll() {
        return pollFirst();
    }

    @Override // com.jeffmony.async.util.Deque
    public E pollFirst() {
        int r10 = this.head;
        Object[] r11 = this.elements;
        E r12 = (E) r11[r10];
        if (r12 != null) goto L5;
        return null;
    L5:
        r11[r10] = null;
        this.head = (r10 + 1) & (r11.length - 1);
        return r12;
    }

    @Override // com.jeffmony.async.util.Deque
    public E pollLast() {
        int r10 = this.tail - 1;
        Object[] r11 = this.elements;
        int r12 = r10 & (r11.length - 1);
        E r13 = (E) r11[r12];
        if (r13 != null) goto L5;
        return null;
    L5:
        r11[r12] = null;
        this.tail = r12;
        return r13;
    }

    @Override // com.jeffmony.async.util.Deque
    public E pop() {
        return removeFirst();
    }

    @Override // com.jeffmony.async.util.Deque
    public void push(E r10) {
        addFirst(r10);
    }

    @Override // com.jeffmony.async.util.Deque, java.util.Queue
    public E remove() {
        return removeFirst();
    }

    @Override // com.jeffmony.async.util.Deque
    public E removeFirst() {
        E r10 = pollFirst();
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new NoSuchElementException();
    }

    @Override // com.jeffmony.async.util.Deque
    public boolean removeFirstOccurrence(Object r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        int r11 = this.elements.length - 1;
        int r12 = this.head;
    L6:
        Object r13 = this.elements[r12];
        if (r13 == null) goto L13;
        if (r10.equals(r13) == true) goto L10;
        r12 = (r12 + 1) & r11;
        goto L6
    L10:
        delete(r12);
        return true;
    L13:
        return false;
    }

    @Override // com.jeffmony.async.util.Deque
    public E removeLast() {
        E r10 = pollLast();
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new NoSuchElementException();
    }

    @Override // com.jeffmony.async.util.Deque
    public boolean removeLastOccurrence(Object r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        int r11 = this.elements.length - 1;
        int r12 = this.tail - 1;
    L6:
        int r13 = r12 & r11;
        Object r14 = this.elements[r13];
        if (r14 == null) goto L13;
        if (r10.equals(r14) == true) goto L10;
        r12 = r13 - 1;
        goto L6
    L10:
        delete(r13);
        return true;
    L13:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.jeffmony.async.util.Deque
    public int size() {
        return (this.elements.length - 1) & (this.tail - this.head);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return copyElements(new Object[size()]);
    }

    public ArrayDeque<E> clone() {
        ArrayDeque<E> r10 = (ArrayDeque) super.clone();     // Catch: CloneNotSupportedException -> L4
        Object[] r11 = this.elements;     // Catch: CloneNotSupportedException -> L4
        System.arraycopy(r11, 0, r10.elements, 0, r11.length);     // Catch: CloneNotSupportedException -> L4
        return r10;
    L5:
        throw new AssertionError();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.jeffmony.async.util.Deque
    public boolean remove(Object r10) {
        return removeFirstOccurrence(r10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] r10) {
        int r11 = size();
        if (r10.length >= r11) goto L5;
        r10 = (T[]) ((Object[]) Array.newInstance(r10.getClass().getComponentType(), r11));
    L5:
        copyElements(r10);
        if (r10.length <= r11) goto L8;
        r10[r11] = null;
    L8:
        return r10;
    }

    public ArrayDeque(int r10) {
        allocateElements(r10);
    }

    public ArrayDeque(Collection<? extends E> r10) {
        allocateElements(r10.size());
        addAll(r10);
    }
}
