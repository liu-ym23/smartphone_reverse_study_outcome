package com.airbnb.lottie.parser.moshi;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class LinkedHashTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator<Comparable> NATURAL_ORDER = null;
    Comparator<? super K> comparator;
    private LinkedHashTreeMap<K, V>.EntrySet entrySet;
    final Node<K, V> header;
    private LinkedHashTreeMap<K, V>.KeySet keySet;
    int modCount;
    int size;
    Node<K, V>[] table;
    int threshold;

    static final class AvlBuilder<K, V> {
        private int leavesSkipped;
        private int leavesToSkip;
        private int size;
        private Node<K, V> stack;

        AvlBuilder() {
        }

        void reset(int r2) {
            this.leavesToSkip = ((Integer.highestOneBit(r2) * 2) - 1) - r2;
            this.size = 0;
            this.leavesSkipped = 0;
            this.stack = null;
        }

        void add(Node<K, V> r6) {
            r6.right = null;
            r6.parent = null;
            r6.left = null;
            r6.height = 1;
            int r1 = this.leavesToSkip;
            if (r1 <= 0) goto L7;
            int r2 = this.size;
            if ((r2 & 1) != 0) goto L7;
            this.size = r2 + 1;
            this.leavesToSkip = r1 - 1;
            this.leavesSkipped++;
        L7:
            r6.parent = this.stack;
            this.stack = r6;
            int r7 = this.size + 1;
            this.size = r7;
            int r3 = this.leavesToSkip;
            if (r3 > 0) goto L10;
        L12:
            int r8 = 4;
        L13:
            int r4 = r8 - 1;
            if ((this.size & r4) != r4) goto L25;
            int r5 = this.leavesSkipped;
            if (r5 != 0) goto L19;
            Node<K, V> r9 = this.stack;
            Node<K, V> r10 = r9.parent;
            Node<K, V> r11 = r10.parent;
            r10.parent = r11.parent;
            this.stack = r10;
            r10.left = r11;
            r10.right = r9;
            r10.height = r9.height + 1;
            r11.parent = r10;
            r9.parent = r10;
        L24:
            r8 = r8 * 2;
            goto L13
        L19:
            if (r5 != 1) goto L22;
            Node<K, V> r12 = this.stack;
            Node<K, V> r13 = r12.parent;
            this.stack = r13;
            r13.right = r12;
            r13.height = r12.height + 1;
            r12.parent = r13;
            this.leavesSkipped = 0;
            goto L24
        L22:
            if (r5 != 2) goto L24;
            this.leavesSkipped = 0;
            goto L24
        L25:
            return;
        L10:
            if ((r7 & 1) != 0) goto L12;
            this.size = r7 + 1;
            this.leavesToSkip = r3 - 1;
            this.leavesSkipped++;
            goto L12
        }

        Node<K, V> root() {
            Node<K, V> r1 = this.stack;
            if (r1.parent != null) goto L6;
            return r1;
        L6:
            throw new IllegalStateException();
        }
    }

    static class AvlIterator<K, V> {
        private Node<K, V> stackTop;

        AvlIterator() {
        }

        void reset(Node<K, V> r3) {
            Node<K, V> r0 = null;
        L3:
            if (r3 == null) goto L5;
            r3.parent = r0;
            r0 = r3;
            r3 = r3.left;
            goto L3
        L5:
            this.stackTop = r0;
        }

        public Node<K, V> next() {
            Node<K, V> r0 = this.stackTop;
            if (r0 != null) goto L5;
            return null;
        L5:
            Node<K, V> r2 = r0.parent;
            r0.parent = null;
            Node<K, V> r1 = r0.right;
        L6:
            Node<K, V> r3 = r2;
            r2 = r1;
            if (r2 == null) goto L9;
            r2.parent = r3;
            r1 = r2.left;
            goto L6
        L9:
            this.stackTop = r3;
            return r0;
        }
    }

    final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        final /* synthetic */ LinkedHashTreeMap this$0;

        EntrySet(LinkedHashTreeMap r1) {
            this.this$0 = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new AnonymousClass1(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r2) {
            if ((r2 instanceof Map.Entry) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.this$0.findByEntry((Map.Entry) r2) == null) goto L7;
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r3) {
            if ((r3 instanceof Map.Entry) == true) goto L5;
            return false;
        L5:
            Node<K, V> r4 = this.this$0.findByEntry((Map.Entry) r3);
            if (r4 != null) goto L8;
            return false;
        L8:
            this.this$0.removeInternal(r4, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.this$0.clear();
        }
    }

    final class KeySet extends AbstractSet<K> {
        final /* synthetic */ LinkedHashTreeMap this$0;

        KeySet(LinkedHashTreeMap r1) {
            this.this$0 = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new AnonymousClass1(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r1) {
            return this.this$0.containsKey(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r1) {
            if (this.this$0.removeInternalByKey(r1) == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.this$0.clear();
        }
    }

    abstract class LinkedTreeMapIterator<T> implements Iterator<T> {
        int expectedModCount;
        Node<K, V> lastReturned;
        Node<K, V> next;
        final /* synthetic */ LinkedHashTreeMap this$0;

        LinkedTreeMapIterator(LinkedHashTreeMap r2) {
            this.this$0 = r2;
            this.next = r2.header.next;
            this.lastReturned = null;
            this.expectedModCount = r2.modCount;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.next == this.this$0.header) goto L5;
            return true;
        L5:
            return false;
        }

        final Node<K, V> nextNode() {
            Node<K, V> r0 = this.next;
            if (r0 == this.this$0.header) goto L11;
            if (this.this$0.modCount != this.expectedModCount) goto L9;
            this.next = r0.next;
            this.lastReturned = r0;
            return r0;
        L9:
            throw new ConcurrentModificationException();
        L11:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            Node<K, V> r0 = this.lastReturned;
            if (r0 == null) goto L7;
            this.this$0.removeInternal(r0, true);
            this.lastReturned = null;
            this.expectedModCount = this.this$0.modCount;
            return;
        L7:
            throw new IllegalStateException();
        }
    }

    static final class Node<K, V> implements Map.Entry<K, V> {
        final int hash;
        int height;
        final K key;
        Node<K, V> left;
        Node<K, V> next;
        Node<K, V> parent;
        Node<K, V> prev;
        Node<K, V> right;
        V value;

        Node() {
            this.key = null;
            this.hash = -1;
            this.prev = this;
            this.next = this;
        }

        Node(Node<K, V> r1, K r2, int r3, Node<K, V> r4, Node<K, V> r5) {
            this.parent = r1;
            this.key = r2;
            this.hash = r3;
            this.height = 1;
            this.next = r4;
            this.prev = r5;
            r5.next = this;
            r4.prev = this;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public V setValue(V r2) {
            V r0 = this.value;
            this.value = r2;
            return r0;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r4) {
            if ((r4 instanceof Map.Entry) == false) goto L20;
            Map.Entry r5 = (Map.Entry) r4;
            K r0 = this.key;
            if (r0 != null) goto L10;
            if (r5.getKey() != null) goto L21;
        L11:
            V r3 = this.value;
            if (r3 != null) goto L17;
            if (r5.getValue() != null) goto L23;
        L18:
            return true;
        L23:
            return false;
        L17:
            if (r3.equals(r5.getValue()) == true) goto L18;
            return false;
        L21:
            return false;
        L10:
            if (r0.equals(r5.getKey()) == true) goto L11;
            return false;
        L20:
            return false;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K r0 = this.key;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            V r3 = this.value;
            if (r3 == null) goto L11;
            r1 = r3.hashCode();
        L11:
            return r2 ^ r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return this.key + "=" + this.value;
        }

        public Node<K, V> first() {
            Node<K, V> r0 = this.left;
        L3:
            Node<K, V> r1 = r0;
            Node<K, V> r2 = this;
            Node<K, V> this = r1;
            if (this == null) goto L6;
            r0 = this.left;
            goto L3
        L6:
            return r2;
        }

        public Node<K, V> last() {
            Node<K, V> r0 = this.right;
        L3:
            Node<K, V> r1 = r0;
            Node<K, V> r2 = this;
            Node<K, V> this = r1;
            if (this == null) goto L6;
            r0 = this.right;
            goto L3
        L6:
            return r2;
        }
    }

    private static int secondaryHash(int r2) {
        int r3 = r2 ^ ((r2 >>> 20) ^ (r2 >>> 12));
        int r0 = (r3 >>> 7) ^ r3;
        return (r3 >>> 4) ^ r0;
    }

    static {
        NATURAL_ORDER = new AnonymousClass1();
    }

    LinkedHashTreeMap() {
        this(null);
    }

    LinkedHashTreeMap(Comparator<? super K> r2) {
        this.size = 0;
        this.modCount = 0;
        if (r2 != null) goto L6;
        r2 = NATURAL_ORDER;
    L6:
        this.comparator = r2;
        this.header = new Node();
        Node<K, V>[] r3 = new Node[16];
        this.table = r3;
        this.threshold = (r3.length / 2) + (r3.length / 4);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object r1) {
        Node<K, V> r0 = findByObject(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object r1) {
        if (findByObject(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K r2, V r3) {
        if (r2 == null) goto L6;
        Node<K, V> r1 = find(r2, true);
        V r4 = r1.value;
        r1.value = r3;
        return r4;
    L6:
        throw new NullPointerException("key == null");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.table, null);
        this.size = 0;
        this.modCount++;
        Node<K, V> r3 = this.header;
        Node<K, V> r0 = r3.next;
    L3:
        if (r0 == r3) goto L5;
        Node<K, V> r2 = r0.next;
        r0.prev = null;
        r0.next = null;
        r0 = r2;
        goto L3
    L5:
        r3.prev = r3;
        r3.next = r3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object r1) {
        Node<K, V> r0 = removeInternalByKey(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.value;
    }

    Node<K, V> find(K r13, boolean r14) {
        Comparator<? super K> r0 = this.comparator;
        Node<K, V>[] r1 = this.table;
        int r6 = secondaryHash(r13.hashCode());
        int r2 = (r1.length - 1) & r6;
        Node<K, V> r3 = r1[r2];
        if (r3 != null) goto L5;
        int r7 = 0;
    L20:
        Node<K, V> r10 = r3;
        int r11 = r7;
        if (r14 == true) goto L23;
        return null;
    L23:
        Node<K, V> r8 = this.header;
        if (r10 == null) goto L26;
        Node<K, V> r15 = new Node(r10, r13, r6, r8, r8.prev);
        if (r11 >= 0) goto L36;
        r10.left = r15;
    L37:
        rebalance(r10, true);
    L38:
        int r16 = this.size;
        this.size = r16 + 1;
        if (r16 <= this.threshold) goto L41;
        doubleCapacity();
    L41:
        this.modCount++;
        return r15;
    L36:
        r10.right = r15;
        goto L37
    L26:
        if (r0 == NATURAL_ORDER) goto L28;
    L32:
        r15 = new Node(r10, r13, r6, r8, r8.prev);
        r1[r2] = r15;
        goto L38
    L28:
        if ((r13 instanceof Comparable) == true) goto L32;
        throw new ClassCastException(r13.getClass().getName() + " is not Comparable");
    L5:
        if (r0 != NATURAL_ORDER) goto L7;
        Comparable r5 = (Comparable) r13;
    L8:
        if (r5 == null) goto L10;
        r7 = r5.compareTo(r3.key);
    L11:
        if (r7 == 0) goto L12;
        if (r7 >= 0) goto L15;
        Node<K, V> r9 = r3.left;
    L16:
        if (r9 == null) goto L20;
        r3 = r9;
        goto L8
    L15:
        r9 = r3.right;
        goto L16
    L12:
        return r3;
    L10:
        r7 = r0.compare(r13, r3.key);
        goto L11
    L7:
        r5 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    Node<K, V> findByObject(Object r3) {
        if (r3 != 0) goto L8;
        return null;
    L8:
        return find(r3, false);
    L11:
        return null;
    }

    Node<K, V> findByEntry(Map.Entry<?, ?> r3) {
        Node<K, V> r0 = findByObject(r3.getKey());
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L12;
        return null;
    L12:
        return r0;
    L5:
        if (equal(r0.value, r3.getValue()) == false) goto L7;
        r2 = true;
        goto L8
    }

    private boolean equal(Object r1, Object r2) {
        if (r1 == r2) goto L8;
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.equals(r2) == false) goto L7;
    L8:
        return true;
    }

    void removeInternal(Node<K, V> r6, boolean r7) {
        if (r7 == false) goto L5;
        r6.prev.next = r6.next;
        r6.next.prev = r6.prev;
        r6.prev = null;
        r6.next = null;
    L5:
        Node<K, V> r8 = r6.left;
        Node<K, V> r1 = r6.right;
        Node<K, V> r2 = r6.parent;
        int r3 = 0;
        if (r8 == null) goto L21;
        if (r1 == null) goto L21;
        if (r8.height <= r1.height) goto L11;
        Node<K, V> r9 = r8.last();
    L12:
        removeInternal(r9, false);
        Node<K, V> r4 = r6.left;
        if (r4 == null) goto L15;
        int r5 = r4.height;
        r9.left = r4;
        r4.parent = r9;
        r6.left = null;
    L16:
        Node<K, V> r10 = r6.right;
        if (r10 == null) goto L19;
        r3 = r10.height;
        r9.right = r10;
        r10.parent = r9;
        r6.right = null;
    L19:
        r9.height = Math.max(r5, r3) + 1;
        replaceInParent(r6, r9);
        return;
    L15:
        r5 = 0;
        goto L16
    L11:
        r9 = r1.first();
    L21:
        if (r8 == null) goto L23;
        replaceInParent(r6, r8);
        r6.left = null;
    L26:
        rebalance(r2, false);
        this.size--;
        this.modCount++;
        return;
    L23:
        if (r1 == null) goto L25;
        replaceInParent(r6, r1);
        r6.right = null;
        goto L26
    L25:
        replaceInParent(r6, null);
        goto L26
    }

    Node<K, V> removeInternalByKey(Object r2) {
        Node<K, V> r3 = findByObject(r2);
        if (r3 == null) goto L5;
        removeInternal(r3, true);
    L5:
        return r3;
    }

    private void replaceInParent(Node<K, V> r3, Node<K, V> r4) {
        Node<K, V> r0 = r3.parent;
        r3.parent = null;
        if (r4 == null) goto L5;
        r4.parent = r0;
    L5:
        if (r0 != null) goto L7;
        int r5 = r3.hash;
        Node<K, V>[] r2 = this.table;
        r2[r5 & (r2.length - 1)] = r4;
        return;
    L7:
        if (r0.left != r3) goto L9;
        r0.left = r4;
        return;
    L9:
        r0.right = r4;
    }

    private void rebalance(Node<K, V> r8, boolean r9) {
    L2:
        if (r8 == null) goto L52;
        Node<K, V> r0 = r8.left;
        Node<K, V> r1 = r8.right;
        int r2 = 0;
        if (r0 == null) goto L6;
        int r3 = r0.height;
    L7:
        if (r1 == null) goto L9;
        int r4 = r1.height;
    L10:
        int r5 = r3 - r4;
        if (r5 != (-2)) goto L28;
        Node<K, V> r6 = r1.left;
        Node<K, V> r7 = r1.right;
        if (r7 == null) goto L15;
        int r10 = r7.height;
    L16:
        if (r6 == null) goto L18;
        r2 = r6.height;
    L18:
        int r11 = r2 - r10;
        if (r11 == (-1)) goto L24;
        if (r11 != 0) goto L23;
        if (r9 == false) goto L24;
    L23:
        rotateRight(r1);
        rotateLeft(r8);
    L25:
        if (r9 == false) goto L51;
        return;
    L51:
        r8 = r8.parent;
    L24:
        rotateLeft(r8);
        goto L25
    L15:
        r10 = 0;
        goto L16
    L28:
        if (r5 != 2) goto L44;
        Node<K, V> r12 = r0.left;
        Node<K, V> r13 = r0.right;
        if (r13 == null) goto L32;
        int r14 = r13.height;
    L33:
        if (r12 == null) goto L35;
        r2 = r12.height;
    L35:
        int r15 = r2 - r14;
        if (r15 == 1) goto L41;
        if (r15 != 0) goto L40;
        if (r9 == false) goto L41;
    L40:
        rotateLeft(r0);
        rotateRight(r8);
    L42:
        if (r9 == false) goto L51;
        return;
    L41:
        rotateRight(r8);
        goto L42
    L32:
        r14 = 0;
        goto L33
    L44:
        if (r5 != 0) goto L48;
        r8.height = r3 + 1;
        if (r9 == false) goto L51;
        return;
    L48:
        r8.height = Math.max(r3, r4) + 1;
        if (r9 == true) goto L51;
        return;
    L9:
        r4 = 0;
        goto L10
    L6:
        r3 = 0;
        goto L7
    }

    private void rotateLeft(Node<K, V> r5) {
        Node<K, V> r0 = r5.left;
        Node<K, V> r1 = r5.right;
        Node<K, V> r2 = r1.left;
        Node<K, V> r3 = r1.right;
        r5.right = r2;
        if (r2 == null) goto L5;
        r2.parent = r5;
    L5:
        replaceInParent(r5, r1);
        r1.left = r5;
        r5.parent = r1;
        int r4 = 0;
        if (r0 == null) goto L8;
        int r6 = r0.height;
    L9:
        if (r2 == null) goto L11;
        int r7 = r2.height;
    L12:
        r5.height = Math.max(r6, r7) + 1;
        int r8 = r5.height;
        if (r3 == null) goto L15;
        r4 = r3.height;
    L15:
        r1.height = Math.max(r8, r4) + 1;
        return;
    L11:
        r7 = 0;
        goto L12
    L8:
        r6 = 0;
        goto L9
    }

    private void rotateRight(Node<K, V> r5) {
        Node<K, V> r0 = r5.left;
        Node<K, V> r1 = r5.right;
        Node<K, V> r2 = r0.left;
        Node<K, V> r3 = r0.right;
        r5.left = r3;
        if (r3 == null) goto L5;
        r3.parent = r5;
    L5:
        replaceInParent(r5, r0);
        r0.right = r5;
        r5.parent = r0;
        int r4 = 0;
        if (r1 == null) goto L8;
        int r6 = r1.height;
    L9:
        if (r3 == null) goto L11;
        int r7 = r3.height;
    L12:
        r5.height = Math.max(r6, r7) + 1;
        int r8 = r5.height;
        if (r2 == null) goto L15;
        r4 = r2.height;
    L15:
        r0.height = Math.max(r8, r4) + 1;
        return;
    L11:
        r7 = 0;
        goto L12
    L8:
        r6 = 0;
        goto L9
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedHashTreeMap<K, V>.EntrySet r0 = this.entrySet;
        if (r0 != null) goto L7;
        LinkedHashTreeMap<K, V>.EntrySet r1 = new EntrySet(this);
        this.entrySet = r1;
        return r1;
    L7:
        return r0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedHashTreeMap<K, V>.KeySet r0 = this.keySet;
        if (r0 != null) goto L7;
        LinkedHashTreeMap<K, V>.KeySet r1 = new KeySet(this);
        this.keySet = r1;
        return r1;
    L7:
        return r0;
    }

    private void doubleCapacity() {
        Node<K, V>[] r0 = doubleCapacity(this.table);
        this.table = r0;
        this.threshold = (r0.length / 2) + (r0.length / 4);
    }

    static <K, V> Node<K, V>[] doubleCapacity(Node<K, V>[] r11) {
        int r0 = r11.length;
        Node<K, V>[] r1 = new Node[r0 * 2];
        AvlIterator r2 = new AvlIterator();
        AvlBuilder r3 = new AvlBuilder();
        AvlBuilder r4 = new AvlBuilder();
        int r6 = 0;
    L3:
        if (r6 >= r0) goto L30;
        Node<K, V> r7 = r11[r6];
        if (r7 == null) goto L29;
        r2.reset(r7);
        int r8 = 0;
        int r9 = 0;
    L8:
        Node<K, V> r10 = r2.next();
        if (r10 == null) goto L14;
        if ((r10.hash & r0) == 0) goto L12;
        r9 = r9 + 1;
        goto L8
    L12:
        r8 = r8 + 1;
        goto L8
    L14:
        r3.reset(r8);
        r4.reset(r9);
        r2.reset(r7);
    L15:
        Node<K, V> r12 = r2.next();
        if (r12 == null) goto L21;
        if ((r12.hash & r0) == 0) goto L19;
        r4.add(r12);
        goto L15
    L19:
        r3.add(r12);
        goto L15
    L21:
        Node<K, V> r13 = null;
        if (r8 <= 0) goto L24;
        Node<K, V> r14 = r3.root();
    L25:
        r1[r6] = r14;
        int r15 = r6 + r0;
        if (r9 <= 0) goto L28;
        r13 = r4.root();
    L28:
        r1[r15] = r13;
        goto L29
    L24:
        r14 = null;
    L29:
        r6 = r6 + 1;
        goto L3
    L30:
        return r1;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }
}
