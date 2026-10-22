package com.alibaba.fastjson.util;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

/* JADX INFO: loaded from: classes28.dex */
public class AntiCollisionHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Cloneable, Serializable {
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    static final int KEY = 16777619;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int M_MASK = -2023358765;
    static final int SEED = -2128831035;
    private static final long serialVersionUID = 362498820763181265L;
    private transient Set<Map.Entry<K, V>> entrySet;
    volatile transient Set<K> keySet;
    final float loadFactor;
    volatile transient int modCount;
    final int random;
    transient int size;
    transient Entry<K, V>[] table;
    int threshold;
    volatile transient Collection<V> values;

    /* JADX INFO: renamed from: com.alibaba.fastjson.util.AntiCollisionHashMap$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Entry<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        Entry<K, V> next;
        V value;

        @Override // java.util.Map.Entry
        public final int hashCode() {
            K r100 = this.key;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            V r103 = this.value;
            if (r103 == null) goto L11;
            r101 = r103.hashCode();
        L11:
            return r102 ^ r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return getKey() + ContainerUtils.KEY_VALUE_DELIMITER + getValue();
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object r100) {
            if ((r100 instanceof Map.Entry) == true) goto L5;
            return false;
        L5:
            Map.Entry r101 = (Map.Entry) r100;
            K r102 = getKey();
            Object r103 = r101.getKey();
            if (r102 == r103) goto L12;
            if (r102 != null) goto L9;
        L11:
            return false;
        L9:
            if (r102.equals(r103) == false) goto L11;
        L12:
            V r104 = getValue();
            Object r105 = r101.getValue();
            if (r104 == r105) goto L17;
            if (r104 != null) goto L16;
            return false;
        L16:
            if (r104.equals(r105) == true) goto L17;
            return false;
        L17:
            return true;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V r100) {
            V r101 = this.value;
            this.value = r100;
            return r101;
        }

        public Entry(int r100, K r101, V r102, Entry<K, V> r103) {
            this.value = r102;
            this.next = r103;
            this.key = r101;
            this.hash = r100;
        }
    }

    public final class EntryIterator extends AntiCollisionHashMap<K, V>.HashIterator<Map.Entry<K, V>> {
        final /* synthetic */ AntiCollisionHashMap this$0;

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            return nextEntry();
        }

        private EntryIterator(AntiCollisionHashMap r100) {
            this.this$0 = r100;
            super(r100);
        }

        public /* synthetic */ EntryIterator(AntiCollisionHashMap r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        final /* synthetic */ AntiCollisionHashMap this$0;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return this.this$0.newEntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.size;
        }

        private EntrySet(AntiCollisionHashMap r100) {
            this.this$0 = r100;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r100) {
            if ((r100 instanceof Map.Entry) == true) goto L5;
            return false;
        L5:
            Map.Entry r101 = (Map.Entry) r100;
            Entry<K, V> r102 = this.this$0.getEntry(r101.getKey());
            if (r102 != null) goto L8;
            return false;
        L8:
            if (r102.equals(r101) == false) goto L12;
            return true;
        L12:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r100) {
            if (this.this$0.removeMapping(r100) == null) goto L5;
            return true;
        L5:
            return false;
        }

        public /* synthetic */ EntrySet(AntiCollisionHashMap r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public abstract class HashIterator<E> implements Iterator<E> {
        Entry<K, V> current;
        int expectedModCount;
        int index;
        Entry<K, V> next;
        final /* synthetic */ AntiCollisionHashMap this$0;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.next == null) goto L5;
            return true;
        L5:
            return false;
        }

        public final Entry<K, V> nextEntry() {
            if (this.this$0.modCount != this.expectedModCount) goto L19;
            Entry<K, V> r100 = this.next;
            if (r100 == null) goto L17;
            Entry<K, V> r101 = r100.next;
            this.next = r101;
            if (r101 != null) goto L14;
            Entry<K, V>[] r102 = this.this$0.table;
        L9:
            int r103 = this.index;
            if (r103 >= r102.length) goto L14;
            this.index = r103 + 1;
            Entry<K, V> r104 = r102[r103];
            this.next = r104;
            if (r104 == null) goto L9;
        L14:
            this.current = r100;
            return r100;
        L17:
            throw new NoSuchElementException();
        L19:
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.current == null) goto L11;
            if (this.this$0.modCount != this.expectedModCount) goto L9;
            K r100 = this.current.key;
            this.current = null;
            this.this$0.removeEntryForKey(r100);
            this.expectedModCount = this.this$0.modCount;
            return;
        L9:
            throw new ConcurrentModificationException();
        L11:
            throw new IllegalStateException();
        }

        public HashIterator(AntiCollisionHashMap r100) {
            this.this$0 = r100;
            this.expectedModCount = r100.modCount;
            if (r100.size <= 0) goto L10;
            Entry<K, V>[] r101 = r100.table;
        L5:
            int r102 = this.index;
            if (r102 >= r101.length) goto L14;
            this.index = r102 + 1;
            Entry<K, V> r103 = r101[r102];
            this.next = r103;
            if (r103 == null) goto L5;
            return;
        L14:
            return;
        }
    }

    public final class KeyIterator extends AntiCollisionHashMap<K, V>.HashIterator<K> {
        final /* synthetic */ AntiCollisionHashMap this$0;

        @Override // java.util.Iterator
        public K next() {
            return nextEntry().getKey();
        }

        private KeyIterator(AntiCollisionHashMap r100) {
            this.this$0 = r100;
            super(r100);
        }

        public /* synthetic */ KeyIterator(AntiCollisionHashMap r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public final class KeySet extends AbstractSet<K> {
        final /* synthetic */ AntiCollisionHashMap this$0;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return this.this$0.newKeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.size;
        }

        private KeySet(AntiCollisionHashMap r100) {
            this.this$0 = r100;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r100) {
            return this.this$0.containsKey(r100);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r100) {
            if (this.this$0.removeEntryForKey(r100) == null) goto L5;
            return true;
        L5:
            return false;
        }

        public /* synthetic */ KeySet(AntiCollisionHashMap r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public final class ValueIterator extends AntiCollisionHashMap<K, V>.HashIterator<V> {
        final /* synthetic */ AntiCollisionHashMap this$0;

        @Override // java.util.Iterator
        public V next() {
            return nextEntry().value;
        }

        private ValueIterator(AntiCollisionHashMap r100) {
            this.this$0 = r100;
            super(r100);
        }

        public /* synthetic */ ValueIterator(AntiCollisionHashMap r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public final class Values extends AbstractCollection<V> {
        final /* synthetic */ AntiCollisionHashMap this$0;

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return this.this$0.newValueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.this$0.size;
        }

        private Values(AntiCollisionHashMap r100) {
            this.this$0 = r100;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object r100) {
            return this.this$0.containsValue(r100);
        }

        public /* synthetic */ Values(AntiCollisionHashMap r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public static int hash(int r100) {
        int r101 = r100 * r100;
        int r102 = r101 ^ ((r101 >>> 20) ^ (r101 >>> 12));
        int r103 = (r102 >>> 7) ^ r102;
        return (r102 >>> 4) ^ r103;
    }

    public static int indexFor(int r100, int r101) {
        return r100 & (r101 - 1);
    }

    @Override // java.util.AbstractMap
    public Object clone() {
        AntiCollisionHashMap r100 = (AntiCollisionHashMap) super.clone();     // Catch: CloneNotSupportedException -> L5
    L6:
        r100.table = new Entry[this.table.length];
        r100.entrySet = null;
        r100.modCount = 0;
        r100.size = 0;
        r100.init();
        r100.putAllForCreate(this);
        return r100;
    L5:
        r100 = null;
        goto L6
    }

    public void init() {
    }

    private boolean containsNullValue() {
        Entry<K, V>[] r100 = this.table;
        int r101 = 0;
    L4:
        if (r101 >= r100.length) goto L13;
        Entry<K, V> r102 = r100[r101];
    L6:
        if (r102 == null) goto L12;
        if (r102.value == null) goto L9;
        r102 = r102.next;
        goto L6
    L9:
        return true;
    L12:
        r101 = r101 + 1;
        goto L4
    L13:
        return false;
    }

    private Set<Map.Entry<K, V>> entrySet0() {
        Set<Map.Entry<K, V>> r100 = this.entrySet;
        if (r100 != null) goto L7;
        EntrySet r101 = new EntrySet(this, null);
        this.entrySet = r101;
        return r101;
    L7:
        return r100;
    }

    private V getForNullKey() {
        Entry<K, V> r100 = this.table[0];
    L3:
        if (r100 == null) goto L9;
        if (r100.key == null) goto L7;
        r100 = r100.next;
        goto L3
    L7:
        return r100.value;
    L9:
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.modCount++;
        Entry<K, V>[] r100 = this.table;
        int r101 = 0;
    L4:
        if (r101 >= r100.length) goto L6;
        r100[r101] = null;
        r101 = r101 + 1;
        goto L4
    L6:
        this.size = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        if (this.size != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> r100 = this.keySet;
        if (r100 != null) goto L7;
        KeySet r101 = new KeySet(this, null);
        this.keySet = r101;
        return r101;
    L7:
        return r100;
    }

    public Iterator<Map.Entry<K, V>> newEntryIterator() {
        return new EntryIterator(this, null);
    }

    public Iterator<K> newKeyIterator() {
        return new KeyIterator(this, null);
    }

    public Iterator<V> newValueIterator() {
        return new ValueIterator(this, null);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> r100 = this.values;
        if (r100 != null) goto L7;
        Values r101 = new Values(this, null);
        this.values = r101;
        return r101;
    L7:
        return r100;
    }

    public AntiCollisionHashMap() {
        this.keySet = null;
        this.values = null;
        this.random = new Random().nextInt(99999);
        this.entrySet = null;
        this.loadFactor = 0.75f;
        this.threshold = 12;
        this.table = new Entry[16];
        init();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return entrySet0();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public AntiCollisionHashMap(Map<? extends K, ? extends V> r100) {
        this(Math.max(((int) (r100.size() / 0.75f)) + 1, 16), 0.75f);
        putAllForCreate(r100);
    }

    private int hashString(String r100) {
        int r101 = this.random * SEED;
        int r102 = 0;
    L4:
        if (r102 >= r100.length()) goto L7;
        r101 = (r101 * KEY) ^ r100.charAt(r102);
        r102 = r102 + 1;
        goto L4
    L7:
        return ((r101 >> 1) ^ r101) & M_MASK;
    }

    private void putAllForCreate(Map<? extends K, ? extends V> r100) {
        Iterator<Map.Entry<? extends K, ? extends V>> r101 = r100.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<? extends K, ? extends V> r102 = r101.next();
        putForCreate(r102.getKey(), r102.getValue());
        goto L4
    }

    private V putForNullKey(V r100) {
        Entry<K, V> r101 = this.table[0];
    L3:
        if (r101 == null) goto L9;
        if (r101.key == null) goto L6;
        r101 = r101.next;
        goto L3
    L6:
        V r102 = r101.value;
        r101.value = r100;
        return r102;
    L9:
        this.modCount++;
        addEntry(0, null, r100, 0);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        r100.defaultReadObject();
        this.table = new Entry[r100.readInt()];
        init();
        int r101 = r100.readInt();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        putForCreate(r100.readObject(), r100.readObject());
        r102 = r102 + 1;
        goto L3
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        if (this.size <= 0) goto L5;
        Iterator<Map.Entry<K, V>> r101 = entrySet0().iterator();
    L6:
        r100.defaultWriteObject();
        r100.writeInt(this.table.length);
        r100.writeInt(this.size);
        if (r101 != null) goto L9;
        return;
    L9:
        if (r101.hasNext() == false) goto L13;
        Map.Entry<K, V> r102 = r101.next();
        r100.writeObject(r102.getKey());
        r100.writeObject(r102.getValue());
        goto L9
    L13:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object r100) {
        if (getEntry(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object r100) {
        if (r100 == null) goto L4;
        Entry<K, V>[] r101 = this.table;
        int r102 = 0;
    L7:
        if (r102 >= r101.length) goto L16;
        Entry<K, V> r103 = r101[r102];
    L9:
        if (r103 == null) goto L15;
        if (r100.equals(r103.value) == true) goto L12;
        r103 = r103.next;
        goto L9
    L12:
        return true;
    L15:
        r102 = r102 + 1;
        goto L7
    L16:
        return false;
    L4:
        return containsNullValue();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object r100) {
        if (r100 != null) goto L6;
        return getForNullKey();
    L6:
        if ((r100 instanceof String) == false) goto L8;
        int r101 = hash(hashString((String) r100));
    L9:
        Entry<K, V>[] r102 = this.table;
        Entry<K, V> r103 = r102[indexFor(r101, r102.length)];
    L10:
        if (r103 == null) goto L20;
        if (r103.hash != r101) goto L19;
        K r104 = r103.key;
        if (r104 == r100) goto L18;
        if (r100.equals(r104) == false) goto L19;
    L18:
        return r103.value;
    L19:
        r103 = r103.next;
        goto L10
    L20:
        return null;
    L8:
        r101 = hash(r100.hashCode());
        goto L9
    }

    public final Entry<K, V> getEntry(Object r100) {
        if (r100 != null) goto L5;
        int r101 = 0;
    L8:
        Entry<K, V>[] r102 = this.table;
        Entry<K, V> r103 = r102[indexFor(r101, r102.length)];
    L9:
        if (r103 == null) goto L19;
        if (r103.hash != r101) goto L18;
        K r104 = r103.key;
        if (r104 == r100) goto L17;
        if (r100 == null) goto L18;
        if (r100.equals(r104) == false) goto L18;
    L17:
        return r103;
    L18:
        r103 = r103.next;
        goto L9
    L19:
        return null;
    L5:
        if ((r100 instanceof String) == false) goto L7;
        r101 = hash(hashString((String) r100));
        goto L8
    L7:
        r101 = hash(r100.hashCode());
        goto L8
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> r100) {
        int r101 = r100.size();
        if (r101 != 0) goto L6;
        return;
    L6:
        if (r101 <= this.threshold) goto L16;
        int r102 = (int) ((r101 / this.loadFactor) + 1.0f);
        if (r102 <= 1073741824) goto L10;
        r102 = 1073741824;
    L10:
        int r103 = this.table.length;
    L11:
        if (r103 >= r102) goto L14;
        r103 = r103 << 1;
        goto L11
    L14:
        if (r103 <= this.table.length) goto L16;
        resize(r103);
    L16:
        Iterator<Map.Entry<? extends K, ? extends V>> r104 = r100.entrySet().iterator();
    L18:
        if (r104.hasNext() == false) goto L20;
        Map.Entry<? extends K, ? extends V> r105 = r104.next();
        put(r105.getKey(), r105.getValue());
        goto L18
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object r100) {
        Entry<K, V> r101 = removeEntryForKey(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        return r101.value;
    }

    public final Entry<K, V> removeEntryForKey(Object r100) {
        if (r100 != null) goto L5;
        int r101 = 0;
    L8:
        int r102 = indexFor(r101, this.table.length);
        Entry<K, V> r103 = this.table[r102];
        Entry<K, V> r104 = r103;
    L9:
        if (r103 == null) goto L23;
        Entry<K, V> r105 = r103.next;
        if (r103.hash != r101) goto L22;
        K r106 = r103.key;
        if (r106 == r100) goto L17;
        if (r100 == null) goto L22;
        if (r100.equals(r106) == false) goto L22;
    L17:
        this.modCount++;
        this.size--;
        if (r104 != r103) goto L20;
        this.table[r102] = r105;
    L21:
        return r103;
    L20:
        r104.next = r105;
    L22:
        r104 = r103;
        r103 = r105;
        goto L9
    L23:
        return r103;
    L5:
        if ((r100 instanceof String) == false) goto L7;
        r101 = hash(hashString((String) r100));
        goto L8
    L7:
        r101 = hash(r100.hashCode());
        goto L8
    }

    public final Entry<K, V> removeMapping(Object r100) {
        if ((r100 instanceof Map.Entry) == true) goto L6;
        return null;
    L6:
        Map.Entry r101 = (Map.Entry) r100;
        Object r102 = r101.getKey();
        if (r102 != null) goto L10;
        int r103 = 0;
    L13:
        int r104 = indexFor(r103, this.table.length);
        Entry<K, V> r105 = this.table[r104];
        Entry<K, V> r106 = r105;
    L14:
        if (r105 == null) goto L25;
        Entry<K, V> r107 = r105.next;
        if (r105.hash != r103) goto L24;
        if (r105.equals(r101) == false) goto L24;
        this.modCount++;
        this.size--;
        if (r106 != r105) goto L22;
        this.table[r104] = r107;
    L23:
        return r105;
    L22:
        r106.next = r107;
    L24:
        r106 = r105;
        r105 = r107;
        goto L14
    L25:
        return r105;
    L10:
        if ((r102 instanceof String) == false) goto L12;
        r103 = hash(hashString((String) r102));
        goto L13
    L12:
        r103 = hash(r102.hashCode());
        goto L13
    }

    public void resize(int r100) {
        if (this.table.length != 1073741824) goto L6;
        this.threshold = Integer.MAX_VALUE;
        return;
    L6:
        Entry<K, V>[] r101 = new Entry[r100];
        transfer(r101);
        this.table = r101;
        this.threshold = (int) (r100 * this.loadFactor);
    }

    public void transfer(Entry[] r100) {
        Entry<K, V>[] r101 = this.table;
        int r102 = r100.length;
        int r103 = 0;
    L4:
        if (r103 >= r101.length) goto L13;
        Entry<K, V> r104 = r101[r103];
        if (r104 == null) goto L12;
        r101[r103] = null;
    L8:
        Entry<K, V> r105 = r104.next;
        int r106 = indexFor(r104.hash, r102);
        r104.next = r100[r106];
        r100[r106] = r104;
        if (r105 == null) goto L12;
        r104 = r105;
    L12:
        r103 = r103 + 1;
        goto L4
    }

    public AntiCollisionHashMap(int r100) {
        this(r100, 0.75f);
    }

    public AntiCollisionHashMap(int r100, float r101) {
        this.keySet = null;
        this.values = null;
        this.random = new Random().nextInt(99999);
        this.entrySet = null;
        if (r100 < 0) goto L19;
        if (r100 <= 1073741824) goto L8;
        r100 = 1073741824;
    L8:
        if (r101 <= 0.0f) goto L17;
        if (Float.isNaN(r101) == true) goto L17;
        int r102 = 1;
    L12:
        if (r102 >= r100) goto L14;
        r102 = r102 << 1;
        goto L12
    L14:
        this.loadFactor = r101;
        this.threshold = (int) (r102 * r101);
        this.table = new Entry[r102];
        init();
        return;
    L17:
        throw new IllegalArgumentException("Illegal load factor: " + r101);
    L19:
        throw new IllegalArgumentException("Illegal initial capacity: " + r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void putForCreate(K r100, V r101) {
        if (r100 != 0) goto L5;
        int r102 = 0;
    L8:
        int r103 = indexFor(r102, this.table.length);
        Entry<K, V> r104 = this.table[r103];
    L9:
        if (r104 == null) goto L20;
        if (r104.hash != r102) goto L19;
        K r105 = r104.key;
        if (r105 == r100) goto L17;
        if (r100 == 0) goto L19;
        if (r100.equals(r105) == false) goto L19;
    L17:
        r104.value = r101;
        return;
    L19:
        r104 = r104.next;
        goto L9
    L20:
        createEntry(r102, r100, r101, r103);
        return;
    L5:
        if ((r100 instanceof String) == false) goto L7;
        r102 = hash(hashString((String) r100));
        goto L8
    L7:
        r102 = hash(r100.hashCode());
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V put(K r100, V r101) {
        if (r100 != 0) goto L6;
        return putForNullKey(r101);
    L6:
        if ((r100 instanceof String) == false) goto L8;
        int r102 = hash(hashString((String) r100));
    L9:
        int r103 = indexFor(r102, this.table.length);
        Entry<K, V> r104 = this.table[r103];
    L10:
        if (r104 == null) goto L20;
        if (r104.hash != r102) goto L19;
        K r105 = r104.key;
        if (r105 == r100) goto L17;
        if (r100.equals(r105) == false) goto L19;
    L17:
        V r106 = r104.value;
        r104.value = r101;
        return r106;
    L19:
        r104 = r104.next;
        goto L10
    L20:
        this.modCount++;
        addEntry(r102, r100, r101, r103);
        return null;
    L8:
        r102 = hash(r100.hashCode());
        goto L9
    }

    public void addEntry(int r100, K r101, V r102, int r103) {
        Entry<K, V>[] r104 = this.table;
        r104[r103] = new Entry(r100, r101, r102, r104[r103]);
        int r105 = this.size;
        this.size = r105 + 1;
        if (r105 < this.threshold) goto L6;
        resize(this.table.length * 2);
        return;
    }

    public void createEntry(int r100, K r101, V r102, int r103) {
        Entry<K, V>[] r104 = this.table;
        r104[r103] = new Entry(r100, r101, r102, r104[r103]);
        this.size++;
    }
}
