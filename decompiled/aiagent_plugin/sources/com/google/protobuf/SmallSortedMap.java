package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
class SmallSortedMap<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    static final int DEFAULT_FIELD_MAP_ARRAY_SIZE = 16;
    private Object[] entries;
    private int entriesSize;
    private boolean isImmutable;
    private volatile SmallSortedMap<K, V>.EntrySet lazyEntrySet;
    private Map<K, V> overflowEntries;
    private Map<K, V> overflowEntriesDescending;

    private class DescendingEntryIterator implements Iterator<Map.Entry<K, V>> {
        private Iterator<Map.Entry<K, V>> lazyOverflowIterator;
        private int pos;
        final /* synthetic */ SmallSortedMap this$0;

        private DescendingEntryIterator(SmallSortedMap r1) {
            this.this$0 = r1;
            this.pos = SmallSortedMap.access$600(r1);
        }

        /* synthetic */ DescendingEntryIterator(SmallSortedMap r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int r0 = this.pos;
            if (r0 <= 0) goto L7;
            if (r0 > SmallSortedMap.access$600(this.this$0)) goto L7;
        L8:
            return true;
        L7:
            if (getOverflowIterator().hasNext() == true) goto L8;
            return false;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (getOverflowIterator().hasNext() == true) goto L5;
            Object[] r0 = SmallSortedMap.access$800(this.this$0);
            int r2 = this.pos - 1;
            this.pos = r2;
            return (Entry) ZeusTransformUtils.preCheckCast(r0[r2], Entry.class, "com.obric.aiagent.plugin");
        L5:
            return (Map.Entry) ZeusTransformUtils.preCheckCast(getOverflowIterator().next(), Map.Entry.class, "com.obric.aiagent.plugin");
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private Iterator<Map.Entry<K, V>> getOverflowIterator() {
            if (this.lazyOverflowIterator != null) goto L6;
            this.lazyOverflowIterator = SmallSortedMap.access$1000(this.this$0).entrySet().iterator();
        L6:
            return this.lazyOverflowIterator;
        }
    }

    private class DescendingEntrySet extends SmallSortedMap<K, V>.EntrySet {
        final /* synthetic */ SmallSortedMap this$0;

        private DescendingEntrySet(SmallSortedMap r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        /* synthetic */ DescendingEntrySet(SmallSortedMap r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.protobuf.SmallSortedMap.EntrySet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new DescendingEntryIterator(this.this$0, null);
        }
    }

    private class Entry implements Comparable<SmallSortedMap<K, V>.Entry>, Map.Entry<K, V> {
        private final K key;
        final /* synthetic */ SmallSortedMap this$0;
        private V value;

        @Override // java.lang.Comparable
        public /* synthetic */ int compareTo(Object r3) {
            return compareTo((Entry) ZeusTransformUtils.preCheckCast(r3, Entry.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.Map.Entry
        public /* bridge */ /* synthetic */ Object getKey() {
            return getKey();
        }

        Entry(SmallSortedMap r4, Map.Entry<K, V> r5) {
            Map.Entry r6 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r5, Map.Entry.class, "com.obric.aiagent.plugin");
            this(r4, (Comparable) ZeusTransformUtils.preCheckCast(r6.getKey(), Comparable.class, "com.obric.aiagent.plugin"), r6.getValue());
        }

        Entry(SmallSortedMap r3, K r4, V r5) {
            K r6 = (K) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            this.key = r6;
            this.value = r5;
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
            SmallSortedMap.access$300(this.this$0);
            V r0 = this.value;
            this.value = r2;
            return r0;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, Map.Entry.class) == true) goto L8;
            return false;
        L8:
            Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5, Map.Entry.class, "com.obric.aiagent.plugin");
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
            return this.key + "=" + this.value;
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
            if ((this.pos + 1) >= SmallSortedMap.access$600(this.this$0)) goto L5;
            return true;
        L5:
            if (SmallSortedMap.access$700(this.this$0).isEmpty() == false) goto L7;
        L9:
            return false;
        L7:
            if (getOverflowIterator().hasNext() == false) goto L9;
            return true;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            this.nextCalledBeforeRemove = true;
            int r1 = this.pos + 1;
            this.pos = r1;
            if (r1 >= SmallSortedMap.access$600(this.this$0)) goto L7;
            return (Entry) ZeusTransformUtils.preCheckCast(SmallSortedMap.access$800(this.this$0)[this.pos], Entry.class, "com.obric.aiagent.plugin");
        L7:
            return (Map.Entry) ZeusTransformUtils.preCheckCast(getOverflowIterator().next(), Map.Entry.class, "com.obric.aiagent.plugin");
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.nextCalledBeforeRemove == false) goto L10;
            this.nextCalledBeforeRemove = false;
            SmallSortedMap.access$300(this.this$0);
            if (this.pos >= SmallSortedMap.access$600(this.this$0)) goto L7;
            SmallSortedMap r0 = this.this$0;
            int r1 = this.pos;
            this.pos = r1 - 1;
            SmallSortedMap.access$900(r0, r1);
            return;
        L7:
            getOverflowIterator().remove();
            return;
        L10:
            throw new IllegalStateException("remove() was called before next()");
        }

        private Iterator<Map.Entry<K, V>> getOverflowIterator() {
            if (this.lazyOverflowIterator != null) goto L6;
            this.lazyOverflowIterator = SmallSortedMap.access$700(this.this$0).entrySet().iterator();
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
        public /* synthetic */ boolean add(Object r3) {
            return add((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.aiagent.plugin"));
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
        public boolean contains(Object r3) {
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.aiagent.plugin");
            Object r2 = this.this$0.get(r4.getKey());
            Object r5 = r4.getValue();
            if (r2 == r5) goto L9;
            if (r2 != null) goto L6;
        L8:
            return false;
        L6:
            if (r2.equals(r5) == false) goto L8;
        L9:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean add(Map.Entry<K, V> r4) {
            Map.Entry r5 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r4, Map.Entry.class, "com.obric.aiagent.plugin");
            if (contains(r5) == true) goto L6;
            this.this$0.put((Comparable) ZeusTransformUtils.preCheckCast(r5.getKey(), Comparable.class, "com.obric.aiagent.plugin"), r5.getValue());
            return true;
        L6:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r3) {
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.aiagent.plugin");
            if (contains(r4) == false) goto L6;
            this.this$0.remove(r4.getKey());
            return true;
        L6:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.this$0.clear();
        }
    }

    /* synthetic */ SmallSortedMap(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ Map access$1000(SmallSortedMap r0) {
        return r0.overflowEntriesDescending;
    }

    static /* synthetic */ void access$300(SmallSortedMap r0) {
        r0.checkMutable();
    }

    static /* synthetic */ int access$600(SmallSortedMap r0) {
        return r0.entriesSize;
    }

    static /* synthetic */ Map access$700(SmallSortedMap r0) {
        return r0.overflowEntries;
    }

    static /* synthetic */ Object[] access$800(SmallSortedMap r0) {
        return r0.entries;
    }

    static /* synthetic */ Object access$900(SmallSortedMap r0, int r1) {
        return r0.removeArrayEntryAt(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* synthetic */ Object put(Object r3, Object r4) {
        return put((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.aiagent.plugin"), r4);
    }

    static <FieldDescriptorT extends FieldSet.FieldDescriptorLite<FieldDescriptorT>> SmallSortedMap<FieldDescriptorT, Object> newFieldMap() {
        return (SmallSortedMap<FieldDescriptorT, Object>) new AnonymousClass1();
    }

    static <K extends Comparable<K>, V> SmallSortedMap<K, V> newInstanceForTest() {
        return new SmallSortedMap();
    }

    private SmallSortedMap() {
        this.overflowEntries = Collections.emptyMap();
        this.overflowEntriesDescending = Collections.emptyMap();
    }

    public void makeImmutable() {
        if (this.isImmutable == false) goto L5;
        return;
    L5:
        if (this.overflowEntries.isEmpty() == false) goto L7;
        Map<K, V> r0 = Collections.emptyMap();
    L8:
        this.overflowEntries = r0;
        if (this.overflowEntriesDescending.isEmpty() == false) goto L11;
        Map<K, V> r1 = Collections.emptyMap();
    L12:
        this.overflowEntriesDescending = r1;
        this.isImmutable = true;
        return;
    L11:
        r1 = Collections.unmodifiableMap(this.overflowEntriesDescending);
        goto L12
    L7:
        r0 = Collections.unmodifiableMap(this.overflowEntries);
        goto L8
    }

    public boolean isImmutable() {
        return this.isImmutable;
    }

    public int getNumArrayEntries() {
        return this.entriesSize;
    }

    public Map.Entry<K, V> getArrayEntryAt(int r2) {
        if (r2 >= this.entriesSize) goto L7;
        return (Entry) ZeusTransformUtils.preCheckCast(this.entries[r2], Entry.class, "com.obric.aiagent.plugin");
    L7:
        throw new ArrayIndexOutOfBoundsException(r2);
    }

    public int getNumOverflowEntries() {
        return this.overflowEntries.size();
    }

    public Iterable<Map.Entry<K, V>> getOverflowEntries() {
        if (this.overflowEntries.isEmpty() == false) goto L6;
        return Collections.emptySet();
    L6:
        return this.overflowEntries.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.entriesSize + this.overflowEntries.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object r3) {
        Comparable r4 = (Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.aiagent.plugin");
        if (binarySearchInArray(r4) < 0) goto L5;
    L8:
        return true;
    L5:
        if (this.overflowEntries.containsKey(r4) == true) goto L8;
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object r3) {
        Comparable r4 = (Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.aiagent.plugin");
        int r0 = binarySearchInArray(r4);
        if (r0 < 0) goto L7;
        return (V) ((Entry) ZeusTransformUtils.preCheckCast(this.entries[r0], Entry.class, "com.obric.aiagent.plugin")).getValue();
    L7:
        return this.overflowEntries.get(r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V put(K r5, V r6) {
        Comparable r7 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r5, Comparable.class, "com.obric.aiagent.plugin");
        checkMutable();
        int r0 = binarySearchInArray(r7);
        if (r0 >= 0) goto L5;
        ensureEntryArrayMutable();
        int r1 = -(r0 + 1);
        if (r1 < 16) goto L11;
        return (V) getOverflowEntriesMutable().put(r7, r6);
    L11:
        if (this.entriesSize != 16) goto L13;
        Entry r2 = (Entry) ZeusTransformUtils.preCheckCast(this.entries[15], Entry.class, "com.obric.aiagent.plugin");
        this.entriesSize--;
        getOverflowEntriesMutable().put(r2.getKey(), r2.getValue());
    L13:
        Object[] r3 = this.entries;
        System.arraycopy(r3, r1, r3, r1 + 1, (r3.length - r1) - 1);
        this.entries[r1] = new Entry(this, r7, r6);
        this.entriesSize++;
        return null;
    L5:
        return (V) ((Entry) ZeusTransformUtils.preCheckCast(this.entries[r0], Entry.class, "com.obric.aiagent.plugin")).setValue(r6);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        checkMutable();
        if (this.entriesSize == 0) goto L6;
        this.entries = null;
        this.entriesSize = 0;
    L6:
        if (this.overflowEntries.isEmpty() == true) goto L9;
        this.overflowEntries.clear();
        return;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object r3) {
        checkMutable();
        Comparable r4 = (Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.aiagent.plugin");
        int r0 = binarySearchInArray(r4);
        if (r0 < 0) goto L7;
        return removeArrayEntryAt(r0);
    L7:
        if (this.overflowEntries.isEmpty() == false) goto L11;
        return null;
    L11:
        return this.overflowEntries.remove(r4);
    }

    private V removeArrayEntryAt(int r8) {
        checkMutable();
        V r0 = (V) ((Entry) ZeusTransformUtils.preCheckCast(this.entries[r8], Entry.class, "com.obric.aiagent.plugin")).getValue();
        Object[] r1 = this.entries;
        System.arraycopy(r1, r8 + 1, r1, r8, (this.entriesSize - r8) - 1);
        this.entriesSize--;
        if (this.overflowEntries.isEmpty() == true) goto L5;
        Iterator<Map.Entry<K, V>> r9 = getOverflowEntriesMutable().entrySet().iterator();
        this.entries[this.entriesSize] = new Entry(this, (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.aiagent.plugin"));
        this.entriesSize++;
        r9.remove();
    L5:
        return r0;
    }

    private int binarySearchInArray(K r7) {
        Comparable r8 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r7, Comparable.class, "com.obric.aiagent.plugin");
        int r0 = this.entriesSize - 1;
        if (r0 < 0) goto L10;
        int r2 = r8.compareTo(((Entry) ZeusTransformUtils.preCheckCast(this.entries[r0], Entry.class, "com.obric.aiagent.plugin")).getKey());
        if (r2 > 0) goto L7;
        if (r2 != 0) goto L10;
        return r0;
    L7:
        return -(r0 + 2);
    L10:
        int r3 = 0;
    L11:
        if (r3 > r0) goto L19;
        int r4 = (r3 + r0) / 2;
        int r5 = r8.compareTo(((Entry) ZeusTransformUtils.preCheckCast(this.entries[r4], Entry.class, "com.obric.aiagent.plugin")).getKey());
        if (r5 < 0) goto L14;
        if (r5 <= 0) goto L17;
        r3 = r4 + 1;
        goto L11
    L17:
        return r4;
    L14:
        r0 = r4 - 1;
        goto L11
    L19:
        return -(r3 + 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.lazyEntrySet != null) goto L6;
        this.lazyEntrySet = new EntrySet(this, null);
    L6:
        return this.lazyEntrySet;
    }

    Set<Map.Entry<K, V>> descendingEntrySet() {
        return new DescendingEntrySet(this, null);
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
        if (ZeusTransformUtils.instanceOf(this.overflowEntries, TreeMap.class) == true) goto L8;
        TreeMap r0 = new TreeMap();
        this.overflowEntries = r0;
        this.overflowEntriesDescending = ((TreeMap) ZeusTransformUtils.preCheckCast(r0, TreeMap.class, "com.obric.aiagent.plugin")).descendingMap();
    L8:
        return (SortedMap) ZeusTransformUtils.preCheckCast(this.overflowEntries, SortedMap.class, "com.obric.aiagent.plugin");
    }

    private void ensureEntryArrayMutable() {
        checkMutable();
        if (this.entries != null) goto L6;
        this.entries = new Object[16];
        return;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r8, SmallSortedMap.class) == false) goto L8;
        SmallSortedMap r9 = (SmallSortedMap) ZeusTransformUtils.preCheckCast(r8, SmallSortedMap.class, "com.obric.aiagent.plugin");
        int r0 = size();
        if (r0 == r9.size()) goto L12;
        return false;
    L12:
        int r2 = getNumArrayEntries();
        if (r2 != r9.getNumArrayEntries()) goto L15;
        int r4 = 0;
    L17:
        if (r4 >= r2) goto L22;
        if (getArrayEntryAt(r4).equals(r9.getArrayEntryAt(r4)) == false) goto L20;
        r4 = r4 + 1;
        goto L17
    L20:
        return false;
    L22:
        if (r2 != r0) goto L24;
        return true;
    L24:
        return this.overflowEntries.equals(r9.overflowEntries);
    L15:
        return entrySet().equals(r9.entrySet());
    L8:
        return super.equals(r8);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int r0 = getNumArrayEntries();
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L6;
        r2 = r2 + this.entries[r1].hashCode();
        r1 = r1 + 1;
        goto L3
    L6:
        if (getNumOverflowEntries() > 0) goto L8;
        return r2;
    L8:
        return r2 + this.overflowEntries.hashCode();
    }
}
