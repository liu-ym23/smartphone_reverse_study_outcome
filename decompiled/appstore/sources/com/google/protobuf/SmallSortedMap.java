package com.google.protobuf;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
class SmallSortedMap<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private List<SmallSortedMap<K, V>.Entry> entryList;
    private boolean isImmutable;
    private volatile SmallSortedMap<K, V>.EntrySet lazyEntrySet;
    private final int maxArraySize;
    private Map<K, V> overflowEntries;

    public static class EmptySet {
        private static final Iterable<Object> ITERABLE = null;
        private static final Iterator<Object> ITERATOR = null;

        static {
            ITERATOR = new AnonymousClass1();
            ITERABLE = new AnonymousClass2();
        }

        private EmptySet() {
        }

        public static /* synthetic */ Iterator access$700() {
            return ITERATOR;
        }

        public static <T> Iterable<T> iterable() {
            return (Iterable<T>) ITERABLE;
        }
    }

    public class Entry implements Map.Entry<K, V>, Comparable<SmallSortedMap<K, V>.Entry> {
        private final K key;
        final /* synthetic */ SmallSortedMap this$0;
        private V value;

        public Entry(SmallSortedMap r10, Map.Entry<K, V> r11) {
            this(r10, r11.getKey(), r11.getValue());
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object r10) {
            return compareTo((Entry) r10);
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r10) {
            if (r10 != this) goto L6;
            return true;
        L6:
            if ((r10 instanceof Map.Entry) == true) goto L8;
            return false;
        L8:
            Map.Entry r11 = (Map.Entry) r10;
            if (equals(this.key, r11.getKey()) == false) goto L14;
            if (equals(this.value, r11.getValue()) == false) goto L14;
            return true;
        L14:
            return false;
        }

        @Override // java.util.Map.Entry
        public /* bridge */ /* synthetic */ Object getKey() {
            return getKey();
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

        @Override // java.util.Map.Entry
        public V setValue(V r10) {
            SmallSortedMap.access$200(this.this$0);
            V r11 = this.value;
            this.value = r10;
            return r11;
        }

        public String toString() {
            return this.key + "=" + this.value;
        }

        public Entry(SmallSortedMap r10, K r11, V r12) {
            this.this$0 = r10;
            this.key = r11;
            this.value = r12;
        }

        public int compareTo(SmallSortedMap<K, V>.Entry r10) {
            return getKey().compareTo(r10.getKey());
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        private boolean equals(Object r10, Object r11) {
            if (r10 != null) goto L7;
            if (r11 != null) goto L5;
            return true;
        L5:
            return false;
        L7:
            return r10.equals(r11);
        }
    }

    public class EntryIterator implements Iterator<Map.Entry<K, V>> {
        private Iterator<Map.Entry<K, V>> lazyOverflowIterator;
        private boolean nextCalledBeforeRemove;
        private int pos;
        final /* synthetic */ SmallSortedMap this$0;

        private EntryIterator(SmallSortedMap r10) {
            this.this$0 = r10;
            this.pos = -1;
        }

        private Iterator<Map.Entry<K, V>> getOverflowIterator() {
            if (this.lazyOverflowIterator != null) goto L6;
            this.lazyOverflowIterator = SmallSortedMap.access$600(this.this$0).entrySet().iterator();
        L6:
            return this.lazyOverflowIterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if ((this.pos + 1) >= SmallSortedMap.access$400(this.this$0).size()) goto L5;
            return true;
        L5:
            if (getOverflowIterator().hasNext() == true) goto L10;
            return false;
        L10:
            return true;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.nextCalledBeforeRemove == false) goto L10;
            this.nextCalledBeforeRemove = false;
            SmallSortedMap.access$200(this.this$0);
            if (this.pos >= SmallSortedMap.access$400(this.this$0).size()) goto L7;
            SmallSortedMap r10 = this.this$0;
            int r11 = this.pos;
            this.pos = r11 - 1;
            SmallSortedMap.access$500(r10, r11);
            return;
        L7:
            getOverflowIterator().remove();
            return;
        L10:
            throw new IllegalStateException("remove() was called before next()");
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            this.nextCalledBeforeRemove = true;
            int r10 = this.pos + 1;
            this.pos = r10;
            if (r10 >= SmallSortedMap.access$400(this.this$0).size()) goto L7;
            return (Map.Entry) SmallSortedMap.access$400(this.this$0).get(this.pos);
        L7:
            return getOverflowIterator().next();
        }

        public /* synthetic */ EntryIterator(SmallSortedMap r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    public class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        final /* synthetic */ SmallSortedMap this$0;

        private EntrySet(SmallSortedMap r10) {
            this.this$0 = r10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public /* bridge */ /* synthetic */ boolean add(Object r10) {
            return add((Map.Entry) r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r10) {
            Map.Entry r11 = (Map.Entry) r10;
            Object r12 = this.this$0.get(r11.getKey());
            Object r13 = r11.getValue();
            if (r12 == r13) goto L9;
            if (r12 != null) goto L6;
        L8:
            return false;
        L6:
            if (r12.equals(r13) == false) goto L8;
        L9:
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator(this.this$0, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r10) {
            Map.Entry r11 = (Map.Entry) r10;
            if (contains(r11) == false) goto L6;
            this.this$0.remove(r11.getKey());
            return true;
        L6:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.size();
        }

        public /* synthetic */ EntrySet(SmallSortedMap r10, AnonymousClass1 r11) {
            this(r10);
        }

        public boolean add(Map.Entry<K, V> r10) {
            if (contains(r10) == true) goto L6;
            this.this$0.put(r10.getKey(), r10.getValue());
            return true;
        L6:
            return false;
        }
    }

    public /* synthetic */ SmallSortedMap(int r10, AnonymousClass1 r11) {
        this(r10);
    }

    public static /* synthetic */ void access$200(SmallSortedMap r10) {
        r10.checkMutable();
    }

    public static /* synthetic */ List access$400(SmallSortedMap r10) {
        return r10.entryList;
    }

    public static /* synthetic */ Object access$500(SmallSortedMap r10, int r11) {
        return r10.removeArrayEntryAt(r11);
    }

    public static /* synthetic */ Map access$600(SmallSortedMap r10) {
        return r10.overflowEntries;
    }

    private int binarySearchInArray(K r10) {
        int r11 = this.entryList.size();
        int r12 = r11 - 1;
        if (r12 < 0) goto L11;
        int r13 = r10.compareTo(this.entryList.get(r12).getKey());
        if (r13 <= 0) goto L9;
        int r14 = r11 + 1;
    L8:
        return -r14;
    L9:
        if (r13 != 0) goto L11;
        return r12;
    L11:
        int r15 = 0;
    L12:
        if (r15 > r12) goto L19;
        int r16 = (r15 + r12) / 2;
        int r17 = r10.compareTo(this.entryList.get(r16).getKey());
        if (r17 < 0) goto L15;
        if (r17 <= 0) goto L18;
        r15 = r16 + 1;
        goto L12
    L18:
        return r16;
    L15:
        r12 = r16 - 1;
        goto L12
    L19:
        r14 = r15 + 1;
        goto L8
    }

    private void checkMutable() {
        if (this.isImmutable == true) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    private void ensureEntryArrayMutable() {
        checkMutable();
        if (this.entryList.isEmpty() == true) goto L5;
        return;
    L5:
        if ((this.entryList instanceof ArrayList) == true) goto L9;
        this.entryList = new ArrayList(this.maxArraySize);
        return;
    }

    private SortedMap<K, V> getOverflowEntriesMutable() {
        checkMutable();
        if (this.overflowEntries.isEmpty() == false) goto L8;
        if ((this.overflowEntries instanceof TreeMap) == true) goto L8;
        this.overflowEntries = new TreeMap();
    L8:
        return (SortedMap) this.overflowEntries;
    }

    public static <FieldDescriptorType extends FieldSet.FieldDescriptorLite<FieldDescriptorType>> SmallSortedMap<FieldDescriptorType, Object> newFieldMap(final int r10) {
        return (SmallSortedMap<FieldDescriptorType, Object>) new AnonymousClass1(r10);
    }

    public static <K extends Comparable<K>, V> SmallSortedMap<K, V> newInstanceForTest(int r10) {
        return new SmallSortedMap(r10);
    }

    private V removeArrayEntryAt(int r10) {
        checkMutable();
        V r11 = this.entryList.remove(r10).getValue();
        if (this.overflowEntries.isEmpty() == true) goto L5;
        Iterator<Map.Entry<K, V>> r12 = getOverflowEntriesMutable().entrySet().iterator();
        this.entryList.add(new Entry(this, r12.next()));
        r12.remove();
    L5:
        return r11;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        checkMutable();
        if (this.entryList.isEmpty() == true) goto L6;
        this.entryList.clear();
    L6:
        if (this.overflowEntries.isEmpty() == true) goto L9;
        this.overflowEntries.clear();
        return;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object r10) {
        Comparable r11 = (Comparable) r10;
        if (binarySearchInArray(r11) < 0) goto L5;
    L8:
        return true;
    L5:
        if (this.overflowEntries.containsKey(r11) == true) goto L8;
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.lazyEntrySet != null) goto L6;
        this.lazyEntrySet = new EntrySet(this, null);
    L6:
        return this.lazyEntrySet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof SmallSortedMap) == false) goto L8;
        SmallSortedMap r11 = (SmallSortedMap) r10;
        int r12 = size();
        if (r12 == r11.size()) goto L12;
        return false;
    L12:
        int r13 = getNumArrayEntries();
        if (r13 != r11.getNumArrayEntries()) goto L15;
        int r14 = 0;
    L17:
        if (r14 >= r13) goto L22;
        if (getArrayEntryAt(r14).equals(r11.getArrayEntryAt(r14)) == false) goto L20;
        r14 = r14 + 1;
        goto L17
    L20:
        return false;
    L22:
        if (r13 != r12) goto L24;
        return true;
    L24:
        return this.overflowEntries.equals(r11.overflowEntries);
    L15:
        return entrySet().equals(r11.entrySet());
    L8:
        return super.equals(r10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object r10) {
        Comparable r11 = (Comparable) r10;
        int r12 = binarySearchInArray(r11);
        if (r12 < 0) goto L7;
        return this.entryList.get(r12).getValue();
    L7:
        return this.overflowEntries.get(r11);
    }

    public Map.Entry<K, V> getArrayEntryAt(int r10) {
        return this.entryList.get(r10);
    }

    public int getNumArrayEntries() {
        return this.entryList.size();
    }

    public int getNumOverflowEntries() {
        return this.overflowEntries.size();
    }

    public Iterable<Map.Entry<K, V>> getOverflowEntries() {
        if (this.overflowEntries.isEmpty() == false) goto L6;
        return EmptySet.iterable();
    L6:
        return this.overflowEntries.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int r10 = getNumArrayEntries();
        int r11 = 0;
        int r12 = 0;
    L3:
        if (r11 >= r10) goto L6;
        r12 = r12 + this.entryList.get(r11).hashCode();
        r11 = r11 + 1;
        goto L3
    L6:
        if (getNumOverflowEntries() > 0) goto L8;
        return r12;
    L8:
        return r12 + this.overflowEntries.hashCode();
    }

    public boolean isImmutable() {
        return this.isImmutable;
    }

    public void makeImmutable() {
        if (this.isImmutable == false) goto L5;
        return;
    L5:
        if (this.overflowEntries.isEmpty() == false) goto L7;
        Map<K, V> r10 = Collections.emptyMap();
    L8:
        this.overflowEntries = r10;
        this.isImmutable = true;
        return;
    L7:
        r10 = Collections.unmodifiableMap(this.overflowEntries);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object r10, Object r11) {
        return put((Comparable) r10, r11);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object r10) {
        checkMutable();
        Comparable r11 = (Comparable) r10;
        int r12 = binarySearchInArray(r11);
        if (r12 < 0) goto L7;
        return removeArrayEntryAt(r12);
    L7:
        if (this.overflowEntries.isEmpty() == false) goto L11;
        return null;
    L11:
        return this.overflowEntries.remove(r11);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.entryList.size() + this.overflowEntries.size();
    }

    private SmallSortedMap(int r10) {
        this.maxArraySize = r10;
        this.entryList = Collections.emptyList();
        this.overflowEntries = Collections.emptyMap();
    }

    public V put(K r10, V r11) {
        checkMutable();
        int r12 = binarySearchInArray(r10);
        if (r12 >= 0) goto L5;
        ensureEntryArrayMutable();
        int r13 = -(r12 + 1);
        if (r13 >= this.maxArraySize) goto L9;
        int r14 = this.entryList.size();
        int r15 = this.maxArraySize;
        if (r14 != r15) goto L13;
        SmallSortedMap<K, V>.Entry r16 = this.entryList.remove(r15 - 1);
        getOverflowEntriesMutable().put(r16.getKey(), r16.getValue());
    L13:
        this.entryList.add(r13, new Entry(this, r10, r11));
        return null;
    L9:
        return getOverflowEntriesMutable().put(r10, r11);
    L5:
        return this.entryList.get(r12).setValue(r11);
    }
}
