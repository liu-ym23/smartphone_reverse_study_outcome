package androidx.arch.core.internal;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class SafeIterableMap<K, V> implements Iterable<Map.Entry<K, V>> {
    private Entry<K, V> mEnd;
    private final WeakHashMap<SupportRemove<K, V>, Boolean> mIterators;
    private int mSize;
    Entry<K, V> mStart;

    /* JADX INFO: loaded from: classes3.dex */
    public static class AscendingIterator<K, V> extends ListIterator<K, V> {
        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        public Entry<K, V> backward(Entry<K, V> r100) {
            return r100.mPrevious;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        public Entry<K, V> forward(Entry<K, V> r100) {
            return r100.mNext;
        }

        public AscendingIterator(Entry<K, V> r100, Entry<K, V> r101) {
            super(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class DescendingIterator<K, V> extends ListIterator<K, V> {
        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        public Entry<K, V> backward(Entry<K, V> r100) {
            return r100.mNext;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        public Entry<K, V> forward(Entry<K, V> r100) {
            return r100.mPrevious;
        }

        public DescendingIterator(Entry<K, V> r100, Entry<K, V> r101) {
            super(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static class Entry<K, V> implements Map.Entry<K, V> {
        final K mKey;
        Entry<K, V> mNext;
        Entry<K, V> mPrevious;
        final V mValue;

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.mKey.hashCode() ^ this.mValue.hashCode();
        }

        public String toString() {
            return this.mKey + ContainerUtils.KEY_VALUE_DELIMITER + this.mValue;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.mKey;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.mValue;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r100) {
            if (r100 != this) goto L6;
            return true;
        L6:
            if ((r100 instanceof Entry) == true) goto L8;
            return false;
        L8:
            Entry r101 = (Entry) r100;
            if (this.mKey.equals(r101.mKey) == true) goto L11;
        L13:
            return false;
        L11:
            if (this.mValue.equals(r101.mValue) == false) goto L13;
            return true;
        }

        @Override // java.util.Map.Entry
        public V setValue(V r100) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public Entry(K r100, V r101) {
            this.mKey = r100;
            this.mValue = r101;
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public class IteratorWithAdditions extends SupportRemove<K, V> implements Iterator<Map.Entry<K, V>> {
        private boolean mBeforeStart;
        private Entry<K, V> mCurrent;
        final /* synthetic */ SafeIterableMap this$0;

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.mBeforeStart == true) goto L5;
            Entry<K, V> r100 = this.mCurrent;
            if (r100 != null) goto L12;
        L14:
            return false;
        L12:
            if (r100.mNext == null) goto L14;
            return true;
        L5:
            if (this.this$0.mStart != null) goto L16;
            return false;
        L16:
            return true;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (this.mBeforeStart == false) goto L5;
            this.mBeforeStart = false;
            this.mCurrent = this.this$0.mStart;
        L11:
            return this.mCurrent;
        L5:
            Entry<K, V> r100 = this.mCurrent;
            if (r100 == null) goto L8;
            Entry<K, V> r101 = r100.mNext;
        L9:
            this.mCurrent = r101;
            goto L11
        L8:
            r101 = null;
            goto L9
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        public IteratorWithAdditions(SafeIterableMap r100) {
            this.this$0 = r100;
            this.mBeforeStart = true;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.SupportRemove
        public void supportRemove(Entry<K, V> r100) {
            Entry<K, V> r101 = this.mCurrent;
            if (r100 != r101) goto L10;
            Entry<K, V> r102 = r101.mPrevious;
            this.mCurrent = r102;
            if (r102 != null) goto L7;
            boolean r103 = true;
        L8:
            this.mBeforeStart = r103;
            return;
        L7:
            r103 = false;
            goto L8
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static abstract class ListIterator<K, V> extends SupportRemove<K, V> implements Iterator<Map.Entry<K, V>> {
        Entry<K, V> mExpectedEnd;
        Entry<K, V> mNext;

        public abstract Entry<K, V> backward(Entry<K, V> r100);

        public abstract Entry<K, V> forward(Entry<K, V> r100);

        private Entry<K, V> nextNode() {
            Entry<K, V> r100 = this.mNext;
            Entry<K, V> r101 = this.mExpectedEnd;
            if (r100 == r101) goto L8;
            if (r101 != null) goto L7;
            return null;
        L7:
            return forward(r100);
        L8:
            return null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.mNext == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            Entry<K, V> r100 = this.mNext;
            this.mNext = nextNode();
            return r100;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.SupportRemove
        public void supportRemove(Entry<K, V> r100) {
            if (this.mExpectedEnd == r100) goto L5;
        L7:
            Entry<K, V> r101 = this.mExpectedEnd;
            if (r101 != r100) goto L11;
            this.mExpectedEnd = backward(r101);
        L11:
            if (this.mNext != r100) goto L14;
            this.mNext = nextNode();
            return;
        L14:
            return;
        L5:
            if (r100 != this.mNext) goto L7;
            this.mNext = null;
            this.mExpectedEnd = null;
            goto L7
        }

        public ListIterator(Entry<K, V> r100, Entry<K, V> r101) {
            this.mExpectedEnd = r101;
            this.mNext = r100;
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static abstract class SupportRemove<K, V> {
        public SupportRemove() {
        }

        public abstract void supportRemove(Entry<K, V> r100);
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        DescendingIterator r100 = new DescendingIterator(this.mEnd, this.mStart);
        this.mIterators.put(r100, Boolean.FALSE);
        return r100;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        AscendingIterator r100 = new AscendingIterator(this.mStart, this.mEnd);
        this.mIterators.put(r100, Boolean.FALSE);
        return r100;
    }

    public SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions() {
        SafeIterableMap<K, V>.IteratorWithAdditions r100 = new IteratorWithAdditions(this);
        this.mIterators.put(r100, Boolean.FALSE);
        return r100;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("[");
        Iterator<Map.Entry<K, V>> r101 = iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        r100.append(r101.next().toString());
        if (r101.hasNext() == false) goto L4;
        r100.append(", ");
        goto L4
    L8:
        r100.append("]");
        return r100.toString();
    }

    public SafeIterableMap() {
        this.mIterators = new WeakHashMap();
        this.mSize = 0;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> r100 = iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L6;
        r101 = r101 + r100.next().hashCode();
        goto L4
    L6:
        return r101;
    }

    public Map.Entry<K, V> eldest() {
        return this.mStart;
    }

    public Map.Entry<K, V> newest() {
        return this.mEnd;
    }

    public int size() {
        return this.mSize;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof SafeIterableMap) == true) goto L8;
        return false;
    L8:
        SafeIterableMap r101 = (SafeIterableMap) r100;
        if (size() == r101.size()) goto L11;
        return false;
    L11:
        Iterator<Map.Entry<K, V>> r102 = iterator();
        Iterator<Map.Entry<K, V>> r103 = r101.iterator();
    L13:
        if (r102.hasNext() == false) goto L24;
        if (r103.hasNext() == false) goto L24;
        Map.Entry<K, V> r104 = r102.next();
        Map.Entry<K, V> r105 = r103.next();
        if (r104 != null) goto L19;
        if (r105 == null) goto L19;
    L22:
        return false;
    L19:
        if (r104 == null) goto L13;
        if (r104.equals(r105) == true) goto L13;
    L24:
        if (r102.hasNext() == false) goto L26;
    L28:
        return false;
    L26:
        if (r103.hasNext() == true) goto L28;
        return true;
    }

    public Entry<K, V> get(K r100) {
        Entry<K, V> r101 = this.mStart;
    L3:
        if (r101 == null) goto L8;
        if (r101.mKey.equals(r100) == true) goto L8;
        r101 = r101.mNext;
    L8:
        return r101;
    }

    public V remove(K r100) {
        Entry<K, V> r101 = get(r100);
        if (r101 != null) goto L5;
        return null;
    L5:
        this.mSize--;
        if (this.mIterators.isEmpty() == true) goto L11;
        Iterator<SupportRemove<K, V>> r102 = this.mIterators.keySet().iterator();
    L9:
        if (r102.hasNext() == false) goto L11;
        r102.next().supportRemove(r101);
    L11:
        Entry<K, V> r103 = r101.mPrevious;
        if (r103 == null) goto L14;
        r103.mNext = r101.mNext;
    L15:
        Entry<K, V> r104 = r101.mNext;
        if (r104 == null) goto L18;
        r104.mPrevious = r103;
    L19:
        r101.mNext = null;
        r101.mPrevious = null;
        return r101.mValue;
    L18:
        this.mEnd = r103;
        goto L19
    L14:
        this.mStart = r101.mNext;
        goto L15
    }

    public Entry<K, V> put(K r100, V r101) {
        Entry<K, V> r102 = new Entry(r100, r101);
        this.mSize++;
        Entry<K, V> r103 = this.mEnd;
        if (r103 != null) goto L6;
        this.mStart = r102;
        this.mEnd = r102;
        return r102;
    L6:
        r103.mNext = r102;
        r102.mPrevious = r103;
        this.mEnd = r102;
        return r102;
    }

    public V putIfAbsent(K r100, V r101) {
        Entry<K, V> r102 = get(r100);
        if (r102 != null) goto L5;
        put(r100, r101);
        return null;
    L5:
        return r102.mValue;
    }
}
