package com.google.gson.internal;

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

/* JADX INFO: loaded from: classes3.dex */
public final class LinkedHashTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
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

    public static final class AvlBuilder<K, V> {
        private int leavesSkipped;
        private int leavesToSkip;
        private int size;
        private Node<K, V> stack;

        public AvlBuilder() {
        }

        public void add(Node<K, V> r10) {
            r10.right = null;
            r10.parent = null;
            r10.left = null;
            r10.height = 1;
            int r11 = this.leavesToSkip;
            if (r11 <= 0) goto L7;
            int r12 = this.size;
            if ((r12 & 1) != 0) goto L7;
            this.size = r12 + 1;
            this.leavesToSkip = r11 - 1;
            this.leavesSkipped++;
        L7:
            r10.parent = this.stack;
            this.stack = r10;
            int r13 = this.size;
            int r14 = r13 + 1;
            this.size = r14;
            int r15 = this.leavesToSkip;
            if (r15 > 0) goto L10;
        L12:
            int r16 = 4;
        L13:
            int r17 = r16 - 1;
            if ((this.size & r17) != r17) goto L24;
            int r18 = this.leavesSkipped;
            if (r18 != 0) goto L19;
            Node<K, V> r19 = this.stack;
            Node<K, V> r20 = r19.parent;
            Node<K, V> r21 = r20.parent;
            r20.parent = r21.parent;
            this.stack = r20;
            r20.left = r21;
            r20.right = r19;
            r20.height = r19.height + 1;
            r21.parent = r20;
            r19.parent = r20;
        L23:
            r16 = r16 * 2;
            goto L13
        L19:
            if (r18 != 1) goto L21;
            Node<K, V> r22 = this.stack;
            Node<K, V> r23 = r22.parent;
            this.stack = r23;
            r23.right = r22;
            r23.height = r22.height + 1;
            r22.parent = r23;
            this.leavesSkipped = 0;
            goto L23
        L21:
            if (r18 != 2) goto L23;
            this.leavesSkipped = 0;
            goto L23
        L24:
            return;
        L10:
            if ((r14 & 1) != 0) goto L12;
            this.size = r13 + 2;
            this.leavesToSkip = r15 - 1;
            this.leavesSkipped++;
            goto L12
        }

        public void reset(int r10) {
            this.leavesToSkip = ((Integer.highestOneBit(r10) * 2) - 1) - r10;
            this.size = 0;
            this.leavesSkipped = 0;
            this.stack = null;
        }

        public Node<K, V> root() {
            Node<K, V> r10 = this.stack;
            if (r10.parent != null) goto L6;
            return r10;
        L6:
            throw new IllegalStateException();
        }
    }

    public static class AvlIterator<K, V> {
        private Node<K, V> stackTop;

        public AvlIterator() {
        }

        public Node<K, V> next() {
            Node<K, V> r10 = this.stackTop;
            if (r10 != null) goto L5;
            return null;
        L5:
            Node<K, V> r11 = r10.parent;
            r10.parent = null;
            Node<K, V> r12 = r10.right;
        L6:
            Node<K, V> r13 = r11;
            r11 = r12;
            if (r11 == null) goto L9;
            r11.parent = r13;
            r12 = r11.left;
            goto L6
        L9:
            this.stackTop = r13;
            return r10;
        }

        public void reset(Node<K, V> r10) {
            Node<K, V> r11 = null;
        L3:
            if (r10 == null) goto L5;
            r10.parent = r11;
            r11 = r10;
            r10 = r10.left;
            goto L3
        L5:
            this.stackTop = r11;
        }
    }

    public final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        final /* synthetic */ LinkedHashTreeMap this$0;

        public EntrySet(LinkedHashTreeMap r10) {
            this.this$0 = r10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r10) {
            if ((r10 instanceof Map.Entry) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.this$0.findByEntry((Map.Entry) r10) == null) goto L7;
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new AnonymousClass1(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r10) {
            if ((r10 instanceof Map.Entry) == true) goto L5;
            return false;
        L5:
            Node<K, V> r11 = this.this$0.findByEntry((Map.Entry) r10);
            if (r11 != null) goto L8;
            return false;
        L8:
            this.this$0.removeInternal(r11, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.size;
        }
    }

    public final class KeySet extends AbstractSet<K> {
        final /* synthetic */ LinkedHashTreeMap this$0;

        public KeySet(LinkedHashTreeMap r10) {
            this.this$0 = r10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r10) {
            return this.this$0.containsKey(r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new AnonymousClass1(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r10) {
            if (this.this$0.removeInternalByKey(r10) == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.size;
        }
    }

    public abstract class LinkedTreeMapIterator<T> implements Iterator<T> {
        int expectedModCount;
        Node<K, V> lastReturned;
        Node<K, V> next;
        final /* synthetic */ LinkedHashTreeMap this$0;

        public LinkedTreeMapIterator(LinkedHashTreeMap r10) {
            this.this$0 = r10;
            this.next = r10.header.next;
            this.lastReturned = null;
            this.expectedModCount = r10.modCount;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.next == this.this$0.header) goto L5;
            return true;
        L5:
            return false;
        }

        public final Node<K, V> nextNode() {
            Node<K, V> r10 = this.next;
            LinkedHashTreeMap r11 = this.this$0;
            if (r10 == r11.header) goto L11;
            if (r11.modCount != this.expectedModCount) goto L9;
            this.next = r10.next;
            this.lastReturned = r10;
            return r10;
        L9:
            throw new ConcurrentModificationException();
        L11:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            Node<K, V> r10 = this.lastReturned;
            if (r10 == null) goto L7;
            this.this$0.removeInternal(r10, true);
            this.lastReturned = null;
            this.expectedModCount = this.this$0.modCount;
            return;
        L7:
            throw new IllegalStateException();
        }
    }

    public static final class Node<K, V> implements Map.Entry<K, V> {
        final int hash;
        int height;
        final K key;
        Node<K, V> left;
        Node<K, V> next;
        Node<K, V> parent;
        Node<K, V> prev;
        Node<K, V> right;
        V value;

        public Node() {
            this.key = null;
            this.hash = -1;
            this.prev = this;
            this.next = this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r10) {
            if ((r10 instanceof Map.Entry) == false) goto L20;
            Map.Entry r11 = (Map.Entry) r10;
            K r12 = this.key;
            if (r12 != null) goto L10;
            if (r11.getKey() != null) goto L21;
        L11:
            V r13 = this.value;
            if (r13 != null) goto L17;
            if (r11.getValue() != null) goto L23;
        L18:
            return true;
        L23:
            return false;
        L17:
            if (r13.equals(r11.getValue()) == true) goto L18;
            return false;
        L21:
            return false;
        L10:
            if (r12.equals(r11.getKey()) == true) goto L11;
            return false;
        L20:
            return false;
        }

        public Node<K, V> first() {
            Node<K, V> r10 = this.left;
        L3:
            Node<K, V> r11 = r10;
            Node<K, V> r12 = this;
            Node<K, V> this = r11;
            if (this == null) goto L6;
            r10 = this.left;
            goto L3
        L6:
            return r12;
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
        public int hashCode() {
            K r10 = this.key;
            int r11 = 0;
            if (r10 != null) goto L5;
            int r12 = 0;
        L6:
            V r13 = this.value;
            if (r13 == null) goto L11;
            r11 = r13.hashCode();
        L11:
            return r12 ^ r11;
        L5:
            r12 = r10.hashCode();
            goto L6
        }

        public Node<K, V> last() {
            Node<K, V> r10 = this.right;
        L3:
            Node<K, V> r11 = r10;
            Node<K, V> r12 = this;
            Node<K, V> this = r11;
            if (this == null) goto L6;
            r10 = this.right;
            goto L3
        L6:
            return r12;
        }

        @Override // java.util.Map.Entry
        public V setValue(V r10) {
            V r11 = this.value;
            this.value = r10;
            return r11;
        }

        public String toString() {
            return this.key + "=" + this.value;
        }

        public Node(Node<K, V> r10, K r11, int r12, Node<K, V> r13, Node<K, V> r14) {
            this.parent = r10;
            this.key = r11;
            this.hash = r12;
            this.height = 1;
            this.next = r13;
            this.prev = r14;
            r14.next = this;
            r13.prev = this;
        }
    }

    static {
        NATURAL_ORDER = new AnonymousClass1();
    }

    public LinkedHashTreeMap() {
        this(NATURAL_ORDER);
    }

    private void doubleCapacity() {
        Node<K, V>[] r10 = doubleCapacity(this.table);
        this.table = r10;
        this.threshold = (r10.length / 2) + (r10.length / 4);
    }

    private boolean equal(Object r10, Object r11) {
        if (r10 == r11) goto L8;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.equals(r11) == false) goto L7;
    L8:
        return true;
    }

    private void rebalance(Node<K, V> r10, boolean r11) {
    L2:
        if (r10 == null) goto L52;
        Node<K, V> r12 = r10.left;
        Node<K, V> r13 = r10.right;
        int r14 = 0;
        if (r12 == null) goto L6;
        int r15 = r12.height;
    L7:
        if (r13 == null) goto L9;
        int r16 = r13.height;
    L10:
        int r17 = r15 - r16;
        if (r17 != (-2)) goto L28;
        Node<K, V> r18 = r13.left;
        Node<K, V> r19 = r13.right;
        if (r19 == null) goto L15;
        int r20 = r19.height;
    L16:
        if (r18 == null) goto L18;
        r14 = r18.height;
    L18:
        int r21 = r14 - r20;
        if (r21 == (-1)) goto L24;
        if (r21 != 0) goto L23;
        if (r11 == false) goto L24;
    L23:
        rotateRight(r13);
        rotateLeft(r10);
    L25:
        if (r11 == false) goto L51;
        return;
    L51:
        r10 = r10.parent;
    L24:
        rotateLeft(r10);
        goto L25
    L15:
        r20 = 0;
        goto L16
    L28:
        if (r17 != 2) goto L44;
        Node<K, V> r22 = r12.left;
        Node<K, V> r23 = r12.right;
        if (r23 == null) goto L32;
        int r24 = r23.height;
    L33:
        if (r22 == null) goto L35;
        r14 = r22.height;
    L35:
        int r25 = r14 - r24;
        if (r25 == 1) goto L41;
        if (r25 != 0) goto L40;
        if (r11 == false) goto L41;
    L40:
        rotateLeft(r12);
        rotateRight(r10);
    L42:
        if (r11 == false) goto L51;
        return;
    L41:
        rotateRight(r10);
        goto L42
    L32:
        r24 = 0;
        goto L33
    L44:
        if (r17 != 0) goto L48;
        r10.height = r15 + 1;
        if (r11 == false) goto L51;
        return;
    L48:
        r10.height = Math.max(r15, r16) + 1;
        if (r11 == true) goto L51;
        return;
    L9:
        r16 = 0;
        goto L10
    L6:
        r15 = 0;
        goto L7
    }

    private void replaceInParent(Node<K, V> r10, Node<K, V> r11) {
        Node<K, V> r12 = r10.parent;
        r10.parent = null;
        if (r11 == null) goto L5;
        r11.parent = r12;
    L5:
        if (r12 != null) goto L7;
        int r13 = r10.hash;
        Node<K, V>[] r14 = this.table;
        r14[r13 & (r14.length - 1)] = r11;
        return;
    L7:
        if (r12.left != r10) goto L9;
        r12.left = r11;
        return;
    L9:
        r12.right = r11;
    }

    private void rotateLeft(Node<K, V> r10) {
        Node<K, V> r11 = r10.left;
        Node<K, V> r12 = r10.right;
        Node<K, V> r13 = r12.left;
        Node<K, V> r14 = r12.right;
        r10.right = r13;
        if (r13 == null) goto L5;
        r13.parent = r10;
    L5:
        replaceInParent(r10, r12);
        r12.left = r10;
        r10.parent = r12;
        int r15 = 0;
        if (r11 == null) goto L8;
        int r16 = r11.height;
    L9:
        if (r13 == null) goto L11;
        int r17 = r13.height;
    L12:
        int r18 = Math.max(r16, r17) + 1;
        r10.height = r18;
        if (r14 == null) goto L15;
        r15 = r14.height;
    L15:
        r12.height = Math.max(r18, r15) + 1;
        return;
    L11:
        r17 = 0;
        goto L12
    L8:
        r16 = 0;
        goto L9
    }

    private void rotateRight(Node<K, V> r10) {
        Node<K, V> r11 = r10.left;
        Node<K, V> r12 = r10.right;
        Node<K, V> r13 = r11.left;
        Node<K, V> r14 = r11.right;
        r10.left = r14;
        if (r14 == null) goto L5;
        r14.parent = r10;
    L5:
        replaceInParent(r10, r11);
        r11.right = r10;
        r10.parent = r11;
        int r15 = 0;
        if (r12 == null) goto L8;
        int r16 = r12.height;
    L9:
        if (r14 == null) goto L11;
        int r17 = r14.height;
    L12:
        int r18 = Math.max(r16, r17) + 1;
        r10.height = r18;
        if (r13 == null) goto L15;
        r15 = r13.height;
    L15:
        r11.height = Math.max(r18, r15) + 1;
        return;
    L11:
        r17 = 0;
        goto L12
    L8:
        r16 = 0;
        goto L9
    }

    private static int secondaryHash(int r10) {
        int r11 = r10 ^ ((r10 >>> 20) ^ (r10 >>> 12));
        int r12 = (r11 >>> 7) ^ r11;
        return (r11 >>> 4) ^ r12;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.table, null);
        this.size = 0;
        this.modCount++;
        Node<K, V> r10 = this.header;
        Node<K, V> r11 = r10.next;
    L3:
        if (r11 == r10) goto L5;
        Node<K, V> r12 = r11.next;
        r11.prev = null;
        r11.next = null;
        r11 = r12;
        goto L3
    L5:
        r10.prev = r10;
        r10.next = r10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object r10) {
        if (findByObject(r10) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedHashTreeMap<K, V>.EntrySet r10 = this.entrySet;
        if (r10 != null) goto L7;
        LinkedHashTreeMap<K, V>.EntrySet r11 = new EntrySet(this);
        this.entrySet = r11;
        return r11;
    L7:
        return r10;
    }

    public Node<K, V> find(K r13, boolean r14) {
        Comparator<? super K> r10 = this.comparator;
        Node<K, V>[] r11 = this.table;
        int r12 = secondaryHash(r13.hashCode());
        int r15 = (r11.length - 1) & r12;
        Node<K, V> r16 = r11[r15];
        if (r16 != null) goto L5;
        int r17 = 0;
    L17:
        Node<K, V> r18 = r16;
        int r19 = r17;
        if (r14 == true) goto L22;
        return null;
    L22:
        Node<K, V> r20 = this.header;
        if (r18 == null) goto L25;
        Node<K, V> r110 = new Node(r18, r13, r12, r20, r20.prev);
        if (r19 >= 0) goto L35;
        r18.left = r110;
    L36:
        rebalance(r18, true);
    L37:
        int r111 = this.size;
        this.size = r111 + 1;
        if (r111 <= this.threshold) goto L40;
        doubleCapacity();
    L40:
        this.modCount++;
        return r110;
    L35:
        r18.right = r110;
        goto L36
    L25:
        if (r10 == NATURAL_ORDER) goto L27;
    L31:
        r110 = new Node(r18, r13, r12, r20, r20.prev);
        r11[r15] = r110;
        goto L37
    L27:
        if ((r13 instanceof Comparable) == true) goto L31;
        throw new ClassCastException(r13.getClass().getName() + " is not Comparable");
    L5:
        if (r10 != NATURAL_ORDER) goto L7;
        Comparable r21 = (Comparable) r13;
    L8:
        if (r21 == null) goto L10;
        r17 = r21.compareTo(r16.key);
    L11:
        if (r17 == 0) goto L12;
        if (r17 >= 0) goto L15;
        Node<K, V> r22 = r16.left;
    L16:
        if (r22 == null) goto L17;
        r16 = r22;
        goto L8
    L15:
        r22 = r16.right;
        goto L16
    L12:
        return r16;
    L10:
        r17 = r10.compare(r13, r16.key);
        goto L11
    L7:
        r21 = null;
        goto L8
    }

    public Node<K, V> findByEntry(Map.Entry<?, ?> r10) {
        Node<K, V> r11 = findByObject(r10.getKey());
        if (r11 != null) goto L5;
    L7:
        return null;
    L5:
        if (equal(r11.value, r10.getValue()) == false) goto L7;
        return r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Node<K, V> findByObject(Object r10) {
        if (r10 != 0) goto L8;
        return null;
    L8:
        return find(r10, false);
    L11:
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object r10) {
        Node<K, V> r11 = findByObject(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedHashTreeMap<K, V>.KeySet r10 = this.keySet;
        if (r10 != null) goto L7;
        LinkedHashTreeMap<K, V>.KeySet r11 = new KeySet(this);
        this.keySet = r11;
        return r11;
    L7:
        return r10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K r10, V r11) {
        if (r10 == null) goto L6;
        Node<K, V> r12 = find(r10, true);
        V r13 = r12.value;
        r12.value = r11;
        return r13;
    L6:
        throw new NullPointerException("key == null");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object r10) {
        Node<K, V> r11 = removeInternalByKey(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.value;
    }

    public void removeInternal(Node<K, V> r10, boolean r11) {
        if (r11 == false) goto L5;
        Node<K, V> r12 = r10.prev;
        r12.next = r10.next;
        r10.next.prev = r12;
        r10.prev = null;
        r10.next = null;
    L5:
        Node<K, V> r13 = r10.left;
        Node<K, V> r14 = r10.right;
        Node<K, V> r15 = r10.parent;
        int r16 = 0;
        if (r13 == null) goto L21;
        if (r14 == null) goto L21;
        if (r13.height <= r14.height) goto L11;
        Node<K, V> r17 = r13.last();
    L12:
        removeInternal(r17, false);
        Node<K, V> r18 = r10.left;
        if (r18 == null) goto L15;
        int r19 = r18.height;
        r17.left = r18;
        r18.parent = r17;
        r10.left = null;
    L16:
        Node<K, V> r20 = r10.right;
        if (r20 == null) goto L19;
        r16 = r20.height;
        r17.right = r20;
        r20.parent = r17;
        r10.right = null;
    L19:
        r17.height = Math.max(r19, r16) + 1;
        replaceInParent(r10, r17);
        return;
    L15:
        r19 = 0;
        goto L16
    L11:
        r17 = r14.first();
    L21:
        if (r13 == null) goto L23;
        replaceInParent(r10, r13);
        r10.left = null;
    L26:
        rebalance(r15, false);
        this.size--;
        this.modCount++;
        return;
    L23:
        if (r14 == null) goto L25;
        replaceInParent(r10, r14);
        r10.right = null;
        goto L26
    L25:
        replaceInParent(r10, null);
        goto L26
    }

    public Node<K, V> removeInternalByKey(Object r10) {
        Node<K, V> r11 = findByObject(r10);
        if (r11 == null) goto L5;
        removeInternal(r11, true);
    L5:
        return r11;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public LinkedHashTreeMap(Comparator<? super K> r10) {
        this.size = 0;
        this.modCount = 0;
        if (r10 != null) goto L6;
        r10 = NATURAL_ORDER;
    L6:
        this.comparator = r10;
        this.header = new Node();
        Node<K, V>[] r11 = new Node[16];
        this.table = r11;
        this.threshold = (r11.length / 2) + (r11.length / 4);
    }

    public static <K, V> Node<K, V>[] doubleCapacity(Node<K, V>[] r11) {
        int r10 = r11.length;
        Node<K, V>[] r12 = new Node[r10 * 2];
        AvlIterator r13 = new AvlIterator();
        AvlBuilder r14 = new AvlBuilder();
        AvlBuilder r15 = new AvlBuilder();
        int r16 = 0;
    L3:
        if (r16 >= r10) goto L30;
        Node<K, V> r17 = r11[r16];
        if (r17 == null) goto L29;
        r13.reset(r17);
        int r18 = 0;
        int r19 = 0;
    L8:
        Node<K, V> r110 = r13.next();
        if (r110 == null) goto L14;
        if ((r110.hash & r10) == 0) goto L12;
        r19 = r19 + 1;
        goto L8
    L12:
        r18 = r18 + 1;
        goto L8
    L14:
        r14.reset(r18);
        r15.reset(r19);
        r13.reset(r17);
    L15:
        Node<K, V> r20 = r13.next();
        if (r20 == null) goto L21;
        if ((r20.hash & r10) == 0) goto L19;
        r15.add(r20);
        goto L15
    L19:
        r14.add(r20);
        goto L15
    L21:
        Node<K, V> r21 = null;
        if (r18 <= 0) goto L24;
        Node<K, V> r22 = r14.root();
    L25:
        r12[r16] = r22;
        int r23 = r16 + r10;
        if (r19 <= 0) goto L28;
        r21 = r15.root();
    L28:
        r12[r23] = r21;
        goto L29
    L24:
        r22 = null;
    L29:
        r16 = r16 + 1;
        goto L3
    L30:
        return r12;
    }
}
