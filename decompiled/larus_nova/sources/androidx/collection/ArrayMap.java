package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import com.huawei.hms.framework.common.ContainerUtils;
import java.lang.reflect.Array;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V> {
    ArrayMap<K, V>.EntrySet mEntrySet;
    ArrayMap<K, V>.KeySet mKeySet;
    ArrayMap<K, V>.ValueCollection mValues;

    public final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        final /* synthetic */ ArrayMap this$0;

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new MapIterator(this.this$0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.size();
        }

        public EntrySet(ArrayMap r100) {
            this.this$0 = r100;
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public final class KeyIterator extends IndexBasedArrayIterator<K> {
        final /* synthetic */ ArrayMap this$0;

        public KeyIterator(ArrayMap r100) {
            this.this$0 = r100;
            super(r100.size());
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        public K elementAt(int r100) {
            return this.this$0.keyAt(r100);
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        public void removeAt(int r100) {
            this.this$0.removeAt(r100);
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public final class KeySet implements Set<K> {
        final /* synthetic */ ArrayMap this$0;

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int r100 = this.this$0.size() - 1;
            int r101 = 0;
        L3:
            if (r100 < 0) goto L9;
            K r102 = this.this$0.keyAt(r100);
            if (r102 != null) goto L7;
            int r103 = 0;
        L8:
            r101 = r101 + r103;
            r100 = r100 - 1;
            goto L3
        L7:
            r103 = r102.hashCode();
            goto L8
        L9:
            return r101;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return this.this$0.isEmpty();
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new KeyIterator(this.this$0);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return this.this$0.size();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            int r100 = this.this$0.size();
            Object[] r101 = new Object[r100];
            int r102 = 0;
        L3:
            if (r102 >= r100) goto L5;
            r101[r102] = this.this$0.keyAt(r102);
            r102 = r102 + 1;
            goto L3
        L5:
            return r101;
        }

        public KeySet(ArrayMap r100) {
            this.this$0 = r100;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K r100) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> r100) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object r100) {
            return this.this$0.containsKey(r100);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> r100) {
            return this.this$0.containsAll(r100);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object r100) {
            return ArrayMap.equalsSetHelper(this, r100);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object r100) {
            int r101 = this.this$0.indexOfKey(r100);
            if (r101 < 0) goto L6;
            this.this$0.removeAt(r101);
            return true;
        L6:
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> r100) {
            return this.this$0.removeAll(r100);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> r100) {
            return this.this$0.retainAll(r100);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] r100) {
            int r101 = size();
            if (r100.length >= r101) goto L5;
            r100 = (T[]) ((Object[]) Array.newInstance(r100.getClass().getComponentType(), r101));
        L5:
            int r102 = 0;
        L6:
            if (r102 >= r101) goto L9;
            T[] r103 = r100;
            r103[r102] = this.this$0.keyAt(r102);
            r102 = r102 + 1;
            goto L6
        L9:
            if (r100.length <= r101) goto L11;
            r100[r101] = null;
        L11:
            return r100;
        }
    }

    public final class MapIterator implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {
        int mEnd;
        boolean mEntryValid;
        int mIndex;
        final /* synthetic */ ArrayMap this$0;

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.mEntryValid == false) goto L7;
            return this.this$0.keyAt(this.mIndex);
        L7:
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.mEntryValid == false) goto L7;
            return this.this$0.valueAt(this.mIndex);
        L7:
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.mIndex >= this.mEnd) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (this.mEntryValid == false) goto L14;
            K r100 = this.this$0.keyAt(this.mIndex);
            V r101 = this.this$0.valueAt(this.mIndex);
            int r102 = 0;
            if (r100 != null) goto L7;
            int r103 = 0;
        L8:
            if (r101 == null) goto L12;
            r102 = r101.hashCode();
        L12:
            return r103 ^ r102;
        L7:
            r103 = r100.hashCode();
            goto L8
        L14:
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.mEntryValid == false) goto L7;
            this.this$0.removeAt(this.mIndex);
            this.mIndex--;
            this.mEnd--;
            this.mEntryValid = false;
            return;
        L7:
            throw new IllegalStateException();
        }

        public String toString() {
            return getKey() + ContainerUtils.KEY_VALUE_DELIMITER + getValue();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (hasNext() == false) goto L7;
            this.mIndex++;
            this.mEntryValid = true;
            return this;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        public MapIterator(ArrayMap r100) {
            this.this$0 = r100;
            this.mEnd = r100.size() - 1;
            this.mIndex = -1;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r100) {
            if (this.mEntryValid == false) goto L14;
            if ((r100 instanceof Map.Entry) == true) goto L7;
            return false;
        L7:
            Map.Entry r101 = (Map.Entry) r100;
            if (ContainerHelpersKt.equal(r101.getKey(), this.this$0.keyAt(this.mIndex)) == true) goto L10;
            return false;
        L10:
            if (ContainerHelpersKt.equal(r101.getValue(), this.this$0.valueAt(this.mIndex)) == false) goto L16;
            return true;
        L16:
            return false;
        L14:
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V setValue(V r100) {
            if (this.mEntryValid == false) goto L7;
            return this.this$0.setValueAt(this.mIndex, r100);
        L7:
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public final class ValueCollection implements Collection<V> {
        final /* synthetic */ ArrayMap this$0;

        @Override // java.util.Collection
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.this$0.isEmpty();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new ValueIterator(this.this$0);
        }

        @Override // java.util.Collection
        public int size() {
            return this.this$0.size();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            int r100 = this.this$0.size();
            Object[] r101 = new Object[r100];
            int r102 = 0;
        L3:
            if (r102 >= r100) goto L5;
            r101[r102] = this.this$0.valueAt(r102);
            r102 = r102 + 1;
            goto L3
        L5:
            return r101;
        }

        public ValueCollection(ArrayMap r100) {
            this.this$0 = r100;
        }

        @Override // java.util.Collection
        public boolean add(V r100) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> r100) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean contains(Object r100) {
            if (this.this$0.__restricted$indexOfValue(r100) < 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> r100) {
            Iterator<?> r101 = r100.iterator();
        L4:
            if (r101.hasNext() == false) goto L9;
            if (contains(r101.next()) == true) goto L4;
            return false;
        L9:
            return true;
        }

        @Override // java.util.Collection
        public boolean remove(Object r100) {
            int r101 = this.this$0.__restricted$indexOfValue(r100);
            if (r101 < 0) goto L6;
            this.this$0.removeAt(r101);
            return true;
        L6:
            return false;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> r100) {
            int r101 = this.this$0.size();
            int r102 = 0;
            boolean r103 = false;
        L3:
            if (r102 >= r101) goto L8;
            if (r100.contains(this.this$0.valueAt(r102)) == false) goto L7;
            this.this$0.removeAt(r102);
            r102 = r102 - 1;
            r101 = r101 - 1;
            r103 = true;
        L7:
            r102 = r102 + 1;
            goto L3
        L8:
            return r103;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> r100) {
            int r101 = this.this$0.size();
            int r102 = 0;
            boolean r103 = false;
        L3:
            if (r102 >= r101) goto L8;
            if (r100.contains(this.this$0.valueAt(r102)) == true) goto L7;
            this.this$0.removeAt(r102);
            r102 = r102 - 1;
            r101 = r101 - 1;
            r103 = true;
        L7:
            r102 = r102 + 1;
            goto L3
        L8:
            return r103;
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] r100) {
            int r101 = size();
            if (r100.length >= r101) goto L5;
            r100 = (T[]) ((Object[]) Array.newInstance(r100.getClass().getComponentType(), r101));
        L5:
            int r102 = 0;
        L6:
            if (r102 >= r101) goto L9;
            T[] r103 = r100;
            r103[r102] = this.this$0.valueAt(r102);
            r102 = r102 + 1;
            goto L6
        L9:
            if (r100.length <= r101) goto L11;
            r100[r101] = null;
        L11:
            return r100;
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public final class ValueIterator extends IndexBasedArrayIterator<V> {
        final /* synthetic */ ArrayMap this$0;

        public ValueIterator(ArrayMap r100) {
            this.this$0 = r100;
            super(r100.size());
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        public V elementAt(int r100) {
            return this.this$0.valueAt(r100);
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        public void removeAt(int r100) {
            this.this$0.removeAt(r100);
        }
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        ArrayMap<K, V>.EntrySet r100 = this.mEntrySet;
        if (r100 != null) goto L6;
        ArrayMap<K, V>.EntrySet r101 = new EntrySet(this);
        this.mEntrySet = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        ArrayMap<K, V>.KeySet r100 = this.mKeySet;
        if (r100 != null) goto L6;
        ArrayMap<K, V>.KeySet r101 = new KeySet(this);
        this.mKeySet = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // java.util.Map
    public Collection<V> values() {
        ArrayMap<K, V>.ValueCollection r100 = this.mValues;
        if (r100 != null) goto L6;
        ArrayMap<K, V>.ValueCollection r101 = new ValueCollection(this);
        this.mValues = r101;
        return r101;
    L6:
        return r100;
    }

    public ArrayMap() {
    }

    public ArrayMap(int r100) {
        super(r100);
    }

    public boolean containsAll(Collection<?> r100) {
        Iterator<?> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (containsKey(r101.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public boolean containsKey(Object r100) {
        return super.containsKey(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public boolean containsValue(Object r100) {
        return super.containsValue(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public V get(Object r100) {
        return (V) super.get(r100);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> r100) {
        ensureCapacity(size() + r100.size());
        Iterator<Map.Entry<? extends K, ? extends V>> r101 = r100.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<? extends K, ? extends V> r102 = r101.next();
        put(r102.getKey(), r102.getValue());
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public V remove(Object r100) {
        return (V) super.remove(r100);
    }

    public boolean removeAll(Collection<?> r100) {
        int r101 = size();
        Iterator<?> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        remove(r102.next());
        goto L4
    L7:
        if (r101 == size()) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean retainAll(Collection<?> r100) {
        int r101 = size();
        int r102 = size() - 1;
    L3:
        if (r102 < 0) goto L9;
        if (r100.contains(keyAt(r102)) == true) goto L7;
        removeAt(r102);
    L7:
        r102 = r102 - 1;
        goto L3
    L9:
        if (r101 != size()) goto L16;
        return false;
    L16:
        return true;
    }

    public ArrayMap(SimpleArrayMap r100) {
        super(r100);
    }

    public static <T> boolean equalsSetHelper(Set<T> r100, Object r101) {
        if (r100 != r101) goto L6;
        return true;
    L6:
        if ((r101 instanceof Set) == false) goto L15;
        Set r102 = (Set) r101;
        if (r100.size() != r102.size()) goto L13;
        if (r100.containsAll(r102) == false) goto L13;
        return true;
    L13:
        return false;
    L15:
        return false;
    }
}
