package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true, serializable = true)
public class LinkedListMultimap<K, V> extends AbstractMultimap<K, V> implements ListMultimap<K, V>, Serializable {

    @GwtIncompatible
    private static final long serialVersionUID = 0;

    @NullableDecl
    private transient Node<K, V> head;
    private transient Map<K, KeyList<K, V>> keyToKeyList;
    private transient int modCount;
    private transient int size;

    @NullableDecl
    private transient Node<K, V> tail;

    public class DistinctKeyIterator implements Iterator<K> {

        @NullableDecl
        Node<K, V> current;
        int expectedModCount;
        Node<K, V> next;
        final Set<K> seenKeys;
        final /* synthetic */ LinkedListMultimap this$0;

        private DistinctKeyIterator(LinkedListMultimap r10) {
            this.this$0 = r10;
            this.seenKeys = Sets.newHashSetWithExpectedSize(r10.keySet().size());
            this.next = LinkedListMultimap.access$200(r10);
            this.expectedModCount = LinkedListMultimap.access$000(r10);
        }

        private void checkForConcurrentModification() {
            if (LinkedListMultimap.access$000(this.this$0) != this.expectedModCount) goto L6;
            return;
        L6:
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            checkForConcurrentModification();
            if (this.next == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public K next() {
            checkForConcurrentModification();
            LinkedListMultimap.access$300(this.next);
            Node<K, V> r10 = this.next;
            this.current = r10;
            this.seenKeys.add(r10.key);
        L3:
            Node<K, V> r11 = this.next.next;
            this.next = r11;
            if (r11 == null) goto L8;
            if (this.seenKeys.add(r11.key) == false) goto L3;
        L8:
            return this.current.key;
        }

        @Override // java.util.Iterator
        public void remove() {
            checkForConcurrentModification();
            if (this.current == null) goto L5;
            boolean r10 = true;
        L6:
            CollectPreconditions.checkRemove(r10);
            LinkedListMultimap.access$500(this.this$0, this.current.key);
            this.current = null;
            this.expectedModCount = LinkedListMultimap.access$000(this.this$0);
            return;
        L5:
            r10 = false;
            goto L6
        }

        public /* synthetic */ DistinctKeyIterator(LinkedListMultimap r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    public static class KeyList<K, V> {
        int count;
        Node<K, V> head;
        Node<K, V> tail;

        public KeyList(Node<K, V> r10) {
            this.head = r10;
            this.tail = r10;
            r10.previousSibling = null;
            r10.nextSibling = null;
            this.count = 1;
        }
    }

    public static final class Node<K, V> extends AbstractMapEntry<K, V> {

        @NullableDecl
        final K key;

        @NullableDecl
        Node<K, V> next;

        @NullableDecl
        Node<K, V> nextSibling;

        @NullableDecl
        Node<K, V> previous;

        @NullableDecl
        Node<K, V> previousSibling;

        @NullableDecl
        V value;

        public Node(@NullableDecl K r10, @NullableDecl V r11) {
            this.key = r10;
            this.value = r11;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V setValue(@NullableDecl V r10) {
            V r11 = this.value;
            this.value = r10;
            return r11;
        }
    }

    public class NodeIterator implements ListIterator<Map.Entry<K, V>> {

        @NullableDecl
        Node<K, V> current;
        int expectedModCount;

        @NullableDecl
        Node<K, V> next;
        int nextIndex;

        @NullableDecl
        Node<K, V> previous;
        final /* synthetic */ LinkedListMultimap this$0;

        public NodeIterator(LinkedListMultimap r10, int r11) {
            this.this$0 = r10;
            this.expectedModCount = LinkedListMultimap.access$000(r10);
            int r12 = r10.size();
            Preconditions.checkPositionIndex(r11, r12);
            if (r11 < (r12 / 2)) goto L8;
            this.previous = LinkedListMultimap.access$100(r10);
            this.nextIndex = r12;
        L5:
            int r13 = r11 + 1;
            if (r11 >= r12) goto L12;
            previous();
            r11 = r13;
        L12:
            this.current = null;
            return;
        L8:
            this.next = LinkedListMultimap.access$200(r10);
        L9:
            int r14 = r11 - 1;
            if (r11 <= 0) goto L12;
            next();
            r11 = r14;
            goto L9
        }

        private void checkForConcurrentModification() {
            if (LinkedListMultimap.access$000(this.this$0) != this.expectedModCount) goto L6;
            return;
        L6:
            throw new ConcurrentModificationException();
        }

        @Override // java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object r10) {
            add((Map.Entry) r10);
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            checkForConcurrentModification();
            if (this.next == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            checkForConcurrentModification();
            if (this.previous == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.nextIndex;
        }

        @Override // java.util.ListIterator
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ Object previous() {
            return previous();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.nextIndex - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            checkForConcurrentModification();
            if (this.current == null) goto L5;
            boolean r10 = true;
        L6:
            CollectPreconditions.checkRemove(r10);
            Node<K, V> r11 = this.current;
            if (r11 == this.next) goto L9;
            this.previous = r11.previous;
            this.nextIndex--;
        L10:
            LinkedListMultimap.access$400(this.this$0, r11);
            this.current = null;
            this.expectedModCount = LinkedListMultimap.access$000(this.this$0);
            return;
        L9:
            this.next = r11.next;
            goto L10
        L5:
            r10 = false;
            goto L6
        }

        @Override // java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object r10) {
            set((Map.Entry) r10);
        }

        public void setValue(V r10) {
            if (this.current == null) goto L5;
            boolean r11 = true;
        L6:
            Preconditions.checkState(r11);
            this.current.value = r10;
            return;
        L5:
            r11 = false;
            goto L6
        }

        public void add(Map.Entry<K, V> r10) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        @CanIgnoreReturnValue
        public Node<K, V> next() {
            checkForConcurrentModification();
            LinkedListMultimap.access$300(this.next);
            Node<K, V> r10 = this.next;
            this.current = r10;
            this.previous = r10;
            this.next = r10.next;
            this.nextIndex++;
            return r10;
        }

        @Override // java.util.ListIterator
        @CanIgnoreReturnValue
        public Node<K, V> previous() {
            checkForConcurrentModification();
            LinkedListMultimap.access$300(this.previous);
            Node<K, V> r10 = this.previous;
            this.current = r10;
            this.next = r10;
            this.previous = r10.previous;
            this.nextIndex--;
            return r10;
        }

        public void set(Map.Entry<K, V> r10) {
            throw new UnsupportedOperationException();
        }
    }

    public class ValueForKeyIterator implements ListIterator<V> {

        @NullableDecl
        Node<K, V> current;

        @NullableDecl
        final Object key;

        @NullableDecl
        Node<K, V> next;
        int nextIndex;

        @NullableDecl
        Node<K, V> previous;
        final /* synthetic */ LinkedListMultimap this$0;

        public ValueForKeyIterator(@NullableDecl LinkedListMultimap r10, Object r11) {
            this.this$0 = r10;
            this.key = r11;
            KeyList r12 = (KeyList) LinkedListMultimap.access$600(r10).get(r11);
            if (r12 != null) goto L5;
            Node<K, V> r13 = null;
        L6:
            this.next = r13;
            return;
        L5:
            r13 = r12.head;
            goto L6
        }

        @Override // java.util.ListIterator
        public void add(V r10) {
            this.previous = LinkedListMultimap.access$700(this.this$0, this.key, r10, this.next);
            this.nextIndex++;
            this.current = null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            if (this.next == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (this.previous == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        @CanIgnoreReturnValue
        public V next() {
            LinkedListMultimap.access$300(this.next);
            Node<K, V> r10 = this.next;
            this.current = r10;
            this.previous = r10;
            this.next = r10.nextSibling;
            this.nextIndex++;
            return r10.value;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.nextIndex;
        }

        @Override // java.util.ListIterator
        @CanIgnoreReturnValue
        public V previous() {
            LinkedListMultimap.access$300(this.previous);
            Node<K, V> r10 = this.previous;
            this.current = r10;
            this.next = r10;
            this.previous = r10.previousSibling;
            this.nextIndex--;
            return r10.value;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.nextIndex - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            if (this.current == null) goto L5;
            boolean r10 = true;
        L6:
            CollectPreconditions.checkRemove(r10);
            Node<K, V> r11 = this.current;
            if (r11 == this.next) goto L9;
            this.previous = r11.previousSibling;
            this.nextIndex--;
        L10:
            LinkedListMultimap.access$400(this.this$0, r11);
            this.current = null;
            return;
        L9:
            this.next = r11.nextSibling;
            goto L10
        L5:
            r10 = false;
            goto L6
        }

        @Override // java.util.ListIterator
        public void set(V r10) {
            if (this.current == null) goto L5;
            boolean r11 = true;
        L6:
            Preconditions.checkState(r11);
            this.current.value = r10;
            return;
        L5:
            r11 = false;
            goto L6
        }

        public ValueForKeyIterator(@NullableDecl LinkedListMultimap r10, Object r11, int r12) {
            this.this$0 = r10;
            KeyList r13 = (KeyList) LinkedListMultimap.access$600(r10).get(r11);
            if (r13 != null) goto L5;
            int r14 = 0;
        L6:
            Preconditions.checkPositionIndex(r12, r14);
            if (r12 < (r14 / 2)) goto L15;
            if (r13 != null) goto L10;
            Node<K, V> r15 = null;
        L11:
            this.previous = r15;
            this.nextIndex = r14;
        L12:
            int r16 = r12 + 1;
            if (r12 >= r14) goto L22;
            previous();
            r12 = r16;
        L22:
            this.key = r11;
            this.current = null;
            return;
        L10:
            r15 = r13.tail;
            goto L11
        L15:
            if (r13 != null) goto L17;
            Node<K, V> r17 = null;
        L18:
            this.next = r17;
        L19:
            int r18 = r12 - 1;
            if (r12 <= 0) goto L22;
            next();
            r12 = r18;
            goto L19
        L17:
            r17 = r13.head;
            goto L18
        L5:
            r14 = r13.count;
            goto L6
        }
    }

    public LinkedListMultimap() {
        this(12);
    }

    public static /* synthetic */ int access$000(LinkedListMultimap r10) {
        return r10.modCount;
    }

    public static /* synthetic */ Node access$100(LinkedListMultimap r10) {
        return r10.tail;
    }

    public static /* synthetic */ Node access$200(LinkedListMultimap r10) {
        return r10.head;
    }

    public static /* synthetic */ void access$300(Object r10) {
        checkElement(r10);
    }

    public static /* synthetic */ void access$400(LinkedListMultimap r10, Node r11) {
        r10.removeNode(r11);
    }

    public static /* synthetic */ void access$500(LinkedListMultimap r10, Object r11) {
        r10.removeAllNodes(r11);
    }

    public static /* synthetic */ Map access$600(LinkedListMultimap r10) {
        return r10.keyToKeyList;
    }

    public static /* synthetic */ Node access$700(LinkedListMultimap r10, Object r11, Object r12, Node r13) {
        return r10.addNode(r11, r12, r13);
    }

    public static /* synthetic */ int access$900(LinkedListMultimap r10) {
        return r10.size;
    }

    @CanIgnoreReturnValue
    private Node<K, V> addNode(@NullableDecl K r10, @NullableDecl V r11, @NullableDecl Node<K, V> r12) {
        Node<K, V> r13 = new Node(r10, r11);
        if (this.head != null) goto L5;
        this.tail = r13;
        this.head = r13;
        this.keyToKeyList.put(r10, new KeyList(r13));
        this.modCount++;
    L19:
        this.size++;
        return r13;
    L5:
        if (r12 != null) goto L10;
        Node<K, V> r14 = this.tail;
        r14.next = r13;
        r13.previous = r14;
        this.tail = r13;
        KeyList<K, V> r15 = this.keyToKeyList.get(r10);
        if (r15 != null) goto L9;
        this.keyToKeyList.put(r10, new KeyList(r13));
        this.modCount++;
        goto L19
    L9:
        r15.count++;
        Node<K, V> r16 = r15.tail;
        r16.nextSibling = r13;
        r13.previousSibling = r16;
        r15.tail = r13;
        goto L19
    L10:
        this.keyToKeyList.get(r10).count++;
        r13.previous = r12.previous;
        r13.previousSibling = r12.previousSibling;
        r13.next = r12;
        r13.nextSibling = r12;
        Node<K, V> r17 = r12.previousSibling;
        if (r17 != null) goto L13;
        this.keyToKeyList.get(r10).head = r13;
    L14:
        Node<K, V> r18 = r12.previous;
        if (r18 != null) goto L17;
        this.head = r13;
    L18:
        r12.previous = r13;
        r12.previousSibling = r13;
        goto L19
    L17:
        r18.next = r13;
        goto L18
    L13:
        r17.nextSibling = r13;
        goto L14
    }

    private static void checkElement(@NullableDecl Object r10) {
        if (r10 == null) goto L5;
        return;
    L5:
        throw new NoSuchElementException();
    }

    public static <K, V> LinkedListMultimap<K, V> create() {
        return new LinkedListMultimap();
    }

    private List<V> getCopy(@NullableDecl Object r10) {
        return Collections.unmodifiableList(Lists.newArrayList(new ValueForKeyIterator(this, r10)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    private void readObject(ObjectInputStream r10) throws IOException, ClassNotFoundException {
        r10.defaultReadObject();
        this.keyToKeyList = CompactLinkedHashMap.create();
        int r11 = r10.readInt();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        put(r10.readObject(), r10.readObject());
        r12 = r12 + 1;
        goto L3
    }

    private void removeAllNodes(@NullableDecl Object r10) {
        Iterators.clear(new ValueForKeyIterator(this, r10));
    }

    private void removeNode(Node<K, V> r10) {
        Node<K, V> r11 = r10.previous;
        if (r11 == null) goto L5;
        r11.next = r10.next;
    L6:
        Node<K, V> r12 = r10.next;
        if (r12 == null) goto L9;
        r12.previous = r11;
    L11:
        if (r10.previousSibling == null) goto L13;
    L15:
        KeyList<K, V> r13 = this.keyToKeyList.get(r10.key);
        r13.count--;
        Node<K, V> r14 = r10.previousSibling;
        if (r14 != null) goto L18;
        r13.head = r10.nextSibling;
    L19:
        Node<K, V> r15 = r10.nextSibling;
        if (r15 != null) goto L22;
        r13.tail = r14;
    L23:
        this.size--;
        return;
    L22:
        r15.previousSibling = r14;
        goto L23
    L18:
        r14.nextSibling = r10.nextSibling;
        goto L19
    L13:
        if (r10.nextSibling != null) goto L15;
        this.keyToKeyList.remove(r10.key).count = 0;
        this.modCount++;
        goto L23
    L9:
        this.tail = r11;
        goto L11
    L5:
        this.head = r10.next;
        goto L6
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream r10) throws IOException {
        r10.defaultWriteObject();
        r10.writeInt(size());
        Iterator<Map.Entry<K, V>> r11 = entries().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry<K, V> r12 = r11.next();
        r10.writeObject(r12.getKey());
        r10.writeObject(r12.getValue());
        goto L4
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        this.head = null;
        this.tail = null;
        this.keyToKeyList.clear();
        this.size = 0;
        this.modCount++;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsEntry(@NullableDecl Object r10, @NullableDecl Object r11) {
        return super.containsEntry(r10, r11);
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@NullableDecl Object r10) {
        return this.keyToKeyList.containsKey(r10);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public boolean containsValue(@NullableDecl Object r10) {
        return values().contains(r10);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Map<K, Collection<V>> createAsMap() {
        return new Multimaps.AsMap(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public /* bridge */ /* synthetic */ Collection createEntries() {
        return createEntries();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Set<K> createKeySet() {
        return new C1KeySetImpl(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Multiset<K> createKeys() {
        return new Multimaps.Keys(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public /* bridge */ /* synthetic */ Collection createValues() {
        return createValues();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection entries() {
        return entries();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object r10) {
        return super.equals(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection get(@NullableDecl Object r10) {
        return get(r10);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public boolean isEmpty() {
        if (this.head != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Multiset keys() {
        return super.keys();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public boolean put(@NullableDecl K r10, @NullableDecl V r11) {
        addNode(r10, r11, null);
        return true;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(Multimap r10) {
        return super.putAll(r10);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean remove(@NullableDecl Object r10, @NullableDecl Object r11) {
        return super.remove(r10, r11);
    }

    @Override // com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Collection removeAll(@NullableDecl Object r10) {
        return removeAll(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Collection replaceValues(@NullableDecl Object r10, Iterable r11) {
        return replaceValues(r10, r11);
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.AbstractMultimap
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    private LinkedListMultimap(int r10) {
        this.keyToKeyList = Platform.newHashMapWithExpectedSize(r10);
    }

    public static <K, V> LinkedListMultimap<K, V> create(int r10) {
        return new LinkedListMultimap(r10);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public List<Map.Entry<K, V>> createEntries() {
        return new C1EntriesImpl(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public List<V> createValues() {
        return new C1ValuesImpl(this);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public List<Map.Entry<K, V>> entries() {
        return (List) super.entries();
    }

    @Override // com.google.common.collect.Multimap
    public List<V> get(@NullableDecl final K r10) {
        return new AnonymousClass1(this, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(@NullableDecl Object r10, Iterable r11) {
        return super.putAll(r10, r11);
    }

    @Override // com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public List<V> removeAll(@NullableDecl Object r10) {
        List<V> r11 = getCopy(r10);
        removeAllNodes(r10);
        return r11;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public List<V> replaceValues(@NullableDecl K r10, Iterable<? extends V> r11) {
        List<V> r12 = getCopy(r10);
        ValueForKeyIterator r13 = new ValueForKeyIterator(this, r10);
        Iterator<? extends V> r14 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L9;
        if (r14.hasNext() == false) goto L9;
        r13.next();
        r13.set(r14.next());
    L9:
        if (r13.hasNext() == false) goto L12;
        r13.next();
        r13.remove();
    L12:
        if (r14.hasNext() == false) goto L14;
        r13.add(r14.next());
        goto L12
    L14:
        return r12;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public List<V> values() {
        return (List) super.values();
    }

    public static <K, V> LinkedListMultimap<K, V> create(Multimap<? extends K, ? extends V> r10) {
        return new LinkedListMultimap(r10);
    }

    private LinkedListMultimap(Multimap<? extends K, ? extends V> r10) {
        this(r10.keySet().size());
        putAll(r10);
    }
}
