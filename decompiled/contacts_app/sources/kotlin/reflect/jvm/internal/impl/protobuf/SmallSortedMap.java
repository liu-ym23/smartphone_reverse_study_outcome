package kotlin.reflect.jvm.internal.impl.protobuf;

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

/* JADX INFO: loaded from: classes4.dex */
class SmallSortedMap<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private List<SmallSortedMap<K, V>.Entry> entryList;
    private boolean isImmutable;
    private volatile SmallSortedMap<K, V>.EntrySet lazyEntrySet;
    private final int maxArraySize;
    private Map<K, V> overflowEntries;

    private static class EmptySet {
        private static final Iterable<Object> ITERABLE = null;
        private static final Iterator<Object> ITERATOR = null;

        static /* synthetic */ Iterator access$700() {
            return ITERATOR;
        }

        static {
            ITERATOR = new AnonymousClass1();
            ITERABLE = new AnonymousClass2();
        }

        static <T> Iterable<T> iterable() {
            return (Iterable<T>) ITERABLE;
        }
    }

    private class Entry implements Comparable<SmallSortedMap<K, V>.Entry>, Map.Entry<K, V> {
        private final K key;
        final /* synthetic */ SmallSortedMap this$0;
        private V value;

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object r1) {
            return compareTo((Entry) r1);
        }

        @Override // java.util.Map.Entry
        public /* bridge */ /* synthetic */ Object getKey() {
            return getKey();
        }

        Entry(SmallSortedMap r2, Map.Entry<K, V> r3) {
            this(r2, r3.getKey(), r3.getValue());
        }

        Entry(SmallSortedMap r1, K r2, V r3) {
            this.this$0 = r1;
            this.key = r2;
            this.value = r3;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        public int compareTo(SmallSortedMap<K, V>.Entry r1) {
            return getKey().compareTo(r1.getKey());
        }

        @Override // java.util.Map.Entry
        public V setValue(V r2) {
            SmallSortedMap.access$200(this.this$0);
            V r0 = this.value;
            this.value = r2;
            return r0;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if ((r5 instanceof Map.Entry) == true) goto L8;
            return false;
        L8:
            Map.Entry r6 = (Map.Entry) r5;
            if (equals(this.key, r6.getKey()) == false) goto L14;
            if (equals(this.value, r6.getValue()) == false) goto L14;
            return true;
        L14:
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
            String r0 = String.valueOf(String.valueOf(this.key));
            String r4 = String.valueOf(String.valueOf(this.value));
            return new StringBuilder((r0.length() + 1) + r4.length()).append(r0).append("=").append(r4).toString();
        }

        private boolean equals(Object r1, Object r2) {
            if (r1 != null) goto L7;
            if (r2 != null) goto L5;
            return true;
        L5:
            return false;
        L7:
            return r1.equals(r2);
        }
    }

    private class EntryIterator implements Iterator<Map.Entry<K, V>> {
        private Iterator<Map.Entry<K, V>> lazyOverflowIterator;
        private boolean nextCalledBeforeRemove;
        private int pos;
        final /* synthetic */ SmallSortedMap this$0;

        private EntryIterator(SmallSortedMap r1) {
            this.this$0 = r1;
            this.pos = -1;
        }

        /* synthetic */ EntryIterator(SmallSortedMap r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
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
        public Map.Entry<K, V> next() {
            this.nextCalledBeforeRemove = true;
            int r1 = this.pos + 1;
            this.pos = r1;
            if (r1 >= SmallSortedMap.access$400(this.this$0).size()) goto L7;
            return (Map.Entry) SmallSortedMap.access$400(this.this$0).get(this.pos);
        L7:
            return getOverflowIterator().next();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.nextCalledBeforeRemove == false) goto L10;
            this.nextCalledBeforeRemove = false;
            SmallSortedMap.access$200(this.this$0);
            if (this.pos >= SmallSortedMap.access$400(this.this$0).size()) goto L7;
            SmallSortedMap r0 = this.this$0;
            int r1 = this.pos;
            this.pos = r1 - 1;
            SmallSortedMap.access$500(r0, r1);
            return;
        L7:
            getOverflowIterator().remove();
            return;
        L10:
            throw new IllegalStateException("remove() was called before next()");
        }

        private Iterator<Map.Entry<K, V>> getOverflowIterator() {
            if (this.lazyOverflowIterator != null) goto L6;
            this.lazyOverflowIterator = SmallSortedMap.access$600(this.this$0).entrySet().iterator();
        L6:
            return this.lazyOverflowIterator;
        }
    }

    private class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        final /* synthetic */ SmallSortedMap this$0;

        private EntrySet(SmallSortedMap r1) {
            this.this$0 = r1;
        }

        /* synthetic */ EntrySet(SmallSortedMap r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public /* bridge */ /* synthetic */ boolean add(Object r1) {
            return add((Map.Entry) r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator(this.this$0, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r2) {
            Map.Entry r3 = (Map.Entry) r2;
            Object r1 = this.this$0.get(r3.getKey());
            Object r4 = r3.getValue();
            if (r1 == r4) goto L9;
            if (r1 != null) goto L6;
        L8:
            return false;
        L6:
            if (r1.equals(r4) == false) goto L8;
        L9:
            return true;
        }

        public boolean add(Map.Entry<K, V> r2) {
            if (contains(r2) == true) goto L6;
            this.this$0.put(r2.getKey(), r2.getValue());
            return true;
        L6:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r2) {
            Map.Entry r3 = (Map.Entry) r2;
            if (contains(r3) == false) goto L6;
            this.this$0.remove(r3.getKey());
            return true;
        L6:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.this$0.clear();
        }
    }

    /* synthetic */ SmallSortedMap(int r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ void access$200(SmallSortedMap r0) {
        r0.checkMutable();
    }

    static /* synthetic */ List access$400(SmallSortedMap r0) {
        return r0.entryList;
    }

    static /* synthetic */ Object access$500(SmallSortedMap r0, int r1) {
        return r0.removeArrayEntryAt(r1);
    }

    static /* synthetic */ Map access$600(SmallSortedMap r0) {
        return r0.overflowEntries;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object r1, Object r2) {
        return put((Comparable) r1, r2);
    }

    static <FieldDescriptorType extends FieldSet.FieldDescriptorLite<FieldDescriptorType>> SmallSortedMap<FieldDescriptorType, Object> newFieldMap(final int r1) {
        return (SmallSortedMap<FieldDescriptorType, Object>) new AnonymousClass1(r1);
    }

    private SmallSortedMap(int r1) {
        this.maxArraySize = r1;
        this.entryList = Collections.emptyList();
        this.overflowEntries = Collections.emptyMap();
    }

    public void makeImmutable() {
        if (this.isImmutable == false) goto L5;
        return;
    L5:
        if (this.overflowEntries.isEmpty() == false) goto L7;
        Map<K, V> r0 = Collections.emptyMap();
    L8:
        this.overflowEntries = r0;
        this.isImmutable = true;
        return;
    L7:
        r0 = Collections.unmodifiableMap(this.overflowEntries);
        goto L8
    }

    public boolean isImmutable() {
        return this.isImmutable;
    }

    public int getNumArrayEntries() {
        return this.entryList.size();
    }

    public Map.Entry<K, V> getArrayEntryAt(int r1) {
        return this.entryList.get(r1);
    }

    public Iterable<Map.Entry<K, V>> getOverflowEntries() {
        if (this.overflowEntries.isEmpty() == false) goto L6;
        return EmptySet.iterable();
    L6:
        return this.overflowEntries.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.entryList.size() + this.overflowEntries.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object r2) {
        Comparable r3 = (Comparable) r2;
        if (binarySearchInArray(r3) < 0) goto L5;
    L8:
        return true;
    L5:
        if (this.overflowEntries.containsKey(r3) == true) goto L8;
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object r2) {
        Comparable r3 = (Comparable) r2;
        int r0 = binarySearchInArray(r3);
        if (r0 < 0) goto L7;
        return this.entryList.get(r0).getValue();
    L7:
        return this.overflowEntries.get(r3);
    }

    public V put(K r5, V r6) {
        checkMutable();
        int r0 = binarySearchInArray(r5);
        if (r0 >= 0) goto L5;
        ensureEntryArrayMutable();
        int r1 = -(r0 + 1);
        if (r1 >= this.maxArraySize) goto L9;
        int r2 = this.entryList.size();
        int r3 = this.maxArraySize;
        if (r2 != r3) goto L13;
        SmallSortedMap<K, V>.Entry r4 = this.entryList.remove(r3 - 1);
        getOverflowEntriesMutable().put(r4.getKey(), r4.getValue());
    L13:
        this.entryList.add(r1, new Entry(this, r5, r6));
        return null;
    L9:
        return getOverflowEntriesMutable().put(r5, r6);
    L5:
        return this.entryList.get(r0).setValue(r6);
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
    public V remove(Object r2) {
        checkMutable();
        Comparable r3 = (Comparable) r2;
        int r0 = binarySearchInArray(r3);
        if (r0 < 0) goto L7;
        return removeArrayEntryAt(r0);
    L7:
        if (this.overflowEntries.isEmpty() == false) goto L11;
        return null;
    L11:
        return this.overflowEntries.remove(r3);
    }

    private V removeArrayEntryAt(int r5) {
        checkMutable();
        V r6 = this.entryList.remove(r5).getValue();
        if (this.overflowEntries.isEmpty() == true) goto L5;
        Iterator<Map.Entry<K, V>> r0 = getOverflowEntriesMutable().entrySet().iterator();
        this.entryList.add(new Entry(this, r0.next()));
        r0.remove();
    L5:
        return r6;
    }

    private int binarySearchInArray(K r5) {
        int r0 = this.entryList.size() - 1;
        if (r0 < 0) goto L10;
        int r1 = r5.compareTo(this.entryList.get(r0).getKey());
        if (r1 > 0) goto L7;
        if (r1 != 0) goto L10;
        return r0;
    L7:
        return -(r0 + 2);
    L10:
        int r2 = 0;
    L11:
        if (r2 > r0) goto L19;
        int r3 = (r2 + r0) / 2;
        int r4 = r5.compareTo(this.entryList.get(r3).getKey());
        if (r4 < 0) goto L14;
        if (r4 <= 0) goto L17;
        r2 = r3 + 1;
        goto L11
    L17:
        return r3;
    L14:
        r0 = r3 - 1;
        goto L11
    L19:
        return -(r2 + 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.lazyEntrySet != null) goto L6;
        this.lazyEntrySet = new EntrySet(this, null);
    L6:
        return this.lazyEntrySet;
    }

    private void checkMutable() {
        if (this.isImmutable == true) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    private SortedMap<K, V> getOverflowEntriesMutable() {
        checkMutable();
        if (this.overflowEntries.isEmpty() == false) goto L8;
        if ((this.overflowEntries instanceof TreeMap) == true) goto L8;
        this.overflowEntries = new TreeMap();
    L8:
        return (SortedMap) this.overflowEntries;
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
}
