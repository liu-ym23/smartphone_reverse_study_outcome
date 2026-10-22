package androidx.arch.core.internal;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class SafeIterableMap<K, V> implements Iterable<Map.Entry<K, V>> {
    private Entry<K, V> mEnd;
    private final WeakHashMap<SupportRemove<K, V>, Boolean> mIterators;
    private int mSize;
    Entry<K, V> mStart;

    static class AscendingIterator<K, V> extends ListIterator<K, V> {
        AscendingIterator(Entry<K, V> r1, Entry<K, V> r2) {
            super(r1, r2);
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        Entry<K, V> forward(Entry<K, V> r1) {
            return r1.mNext;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        Entry<K, V> backward(Entry<K, V> r1) {
            return r1.mPrevious;
        }
    }

    private static class DescendingIterator<K, V> extends ListIterator<K, V> {
        DescendingIterator(Entry<K, V> r1, Entry<K, V> r2) {
            super(r1, r2);
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        Entry<K, V> forward(Entry<K, V> r1) {
            return r1.mPrevious;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        Entry<K, V> backward(Entry<K, V> r1) {
            return r1.mNext;
        }
    }

    static class Entry<K, V> implements Map.Entry<K, V> {
        final K mKey;
        Entry<K, V> mNext;
        Entry<K, V> mPrevious;
        final V mValue;

        Entry(K r1, V r2) {
            this.mKey = r1;
            this.mValue = r2;
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
        public V setValue(V r1) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.mKey + "=" + this.mValue;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if ((r5 instanceof Entry) == true) goto L8;
            return false;
        L8:
            Entry r6 = (Entry) r5;
            if (this.mKey.equals(r6.mKey) == false) goto L14;
            if (this.mValue.equals(r6.mValue) == false) goto L14;
            return true;
        L14:
            return false;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int r0 = this.mKey.hashCode();
            return this.mValue.hashCode() ^ r0;
        }
    }

    public class IteratorWithAdditions extends SupportRemove<K, V> implements Iterator<Map.Entry<K, V>> {
        private boolean mBeforeStart;
        private Entry<K, V> mCurrent;
        final /* synthetic */ SafeIterableMap this$0;

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        IteratorWithAdditions(SafeIterableMap r1) {
            this.this$0 = r1;
            this.mBeforeStart = true;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.SupportRemove
        void supportRemove(Entry<K, V> r2) {
            Entry<K, V> r0 = this.mCurrent;
            if (r2 != r0) goto L10;
            Entry<K, V> r3 = r0.mPrevious;
            this.mCurrent = r3;
            if (r3 != null) goto L7;
            boolean r4 = true;
        L8:
            this.mBeforeStart = r4;
            return;
        L7:
            r4 = false;
            goto L8
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.mBeforeStart == true) goto L5;
            Entry<K, V> r3 = this.mCurrent;
            if (r3 == null) goto L15;
            if (r3.mNext == null) goto L15;
            return true;
        L15:
            return false;
        L5:
            if (this.this$0.mStart == null) goto L8;
            return true;
        L8:
            return false;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (this.mBeforeStart == false) goto L5;
            this.mBeforeStart = false;
            this.mCurrent = this.this$0.mStart;
        L11:
            return this.mCurrent;
        L5:
            Entry<K, V> r0 = this.mCurrent;
            if (r0 == null) goto L8;
            Entry<K, V> r1 = r0.mNext;
        L9:
            this.mCurrent = r1;
            goto L11
        L8:
            r1 = null;
            goto L9
        }
    }

    private static abstract class ListIterator<K, V> extends SupportRemove<K, V> implements Iterator<Map.Entry<K, V>> {
        Entry<K, V> mExpectedEnd;
        Entry<K, V> mNext;

        abstract Entry<K, V> backward(Entry<K, V> r1);

        abstract Entry<K, V> forward(Entry<K, V> r1);

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        ListIterator(Entry<K, V> r1, Entry<K, V> r2) {
            this.mExpectedEnd = r2;
            this.mNext = r1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.mNext == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.SupportRemove
        public void supportRemove(Entry<K, V> r2) {
            if (this.mExpectedEnd == r2) goto L5;
        L7:
            Entry<K, V> r0 = this.mExpectedEnd;
            if (r0 != r2) goto L11;
            this.mExpectedEnd = backward(r0);
        L11:
            if (this.mNext != r2) goto L14;
            this.mNext = nextNode();
            return;
        L14:
            return;
        L5:
            if (r2 != this.mNext) goto L7;
            this.mNext = null;
            this.mExpectedEnd = null;
            goto L7
        }

        private Entry<K, V> nextNode() {
            Entry<K, V> r0 = this.mNext;
            Entry<K, V> r1 = this.mExpectedEnd;
            if (r0 == r1) goto L8;
            if (r1 != null) goto L7;
            return null;
        L7:
            return forward(r0);
        L8:
            return null;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            Entry<K, V> r0 = this.mNext;
            this.mNext = nextNode();
            return r0;
        }
    }

    public static abstract class SupportRemove<K, V> {
        abstract void supportRemove(Entry<K, V> r1);

        public SupportRemove() {
        }
    }

    public SafeIterableMap() {
        this.mIterators = new WeakHashMap();
        this.mSize = 0;
    }

    protected Entry<K, V> get(K r2) {
        Entry<K, V> r1 = this.mStart;
    L3:
        if (r1 == null) goto L8;
        if (r1.mKey.equals(r2) == true) goto L8;
        r1 = r1.mNext;
    L8:
        return r1;
    }

    public V putIfAbsent(K r2, V r3) {
        Entry<K, V> r0 = get(r2);
        if (r0 != null) goto L5;
        put(r2, r3);
        return null;
    L5:
        return r0.mValue;
    }

    Entry<K, V> put(K r2, V r3) {
        Entry<K, V> r0 = new Entry(r2, r3);
        this.mSize++;
        Entry<K, V> r4 = this.mEnd;
        if (r4 != null) goto L6;
        this.mStart = r0;
        this.mEnd = r0;
        return r0;
    L6:
        r4.mNext = r0;
        r0.mPrevious = this.mEnd;
        this.mEnd = r0;
        return r0;
    }

    public V remove(K r4) {
        Entry<K, V> r5 = get(r4);
        if (r5 != null) goto L5;
        return null;
    L5:
        this.mSize--;
        if (this.mIterators.isEmpty() == true) goto L12;
        Iterator<SupportRemove<K, V>> r1 = this.mIterators.keySet().iterator();
    L9:
        if (r1.hasNext() == false) goto L12;
        r1.next().supportRemove(r5);
    L12:
        if (r5.mPrevious == null) goto L14;
        r5.mPrevious.mNext = r5.mNext;
    L16:
        if (r5.mNext == null) goto L18;
        r5.mNext.mPrevious = r5.mPrevious;
    L19:
        r5.mNext = null;
        r5.mPrevious = null;
        return r5.mValue;
    L18:
        this.mEnd = r5.mPrevious;
        goto L19
    L14:
        this.mStart = r5.mNext;
        goto L16
    }

    public int size() {
        return this.mSize;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        AscendingIterator r0 = new AscendingIterator(this.mStart, this.mEnd);
        this.mIterators.put(r0, false);
        return r0;
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        DescendingIterator r0 = new DescendingIterator(this.mEnd, this.mStart);
        this.mIterators.put(r0, false);
        return r0;
    }

    public SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions() {
        SafeIterableMap<K, V>.IteratorWithAdditions r0 = new IteratorWithAdditions(this);
        this.mIterators.put(r0, false);
        return r0;
    }

    public Map.Entry<K, V> eldest() {
        return this.mStart;
    }

    public Map.Entry<K, V> newest() {
        return this.mEnd;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SafeIterableMap) == true) goto L8;
        return false;
    L8:
        SafeIterableMap r6 = (SafeIterableMap) r5;
        if (size() == r6.size()) goto L11;
        return false;
    L11:
        Iterator<Map.Entry<K, V>> r4 = iterator();
        Iterator<Map.Entry<K, V>> r7 = r6.iterator();
    L13:
        if (r4.hasNext() == false) goto L24;
        if (r7.hasNext() == false) goto L24;
        Map.Entry<K, V> r1 = r4.next();
        Map.Entry<K, V> r3 = r7.next();
        if (r1 != null) goto L19;
        if (r3 == null) goto L19;
    L22:
        return false;
    L19:
        if (r1 == null) goto L13;
        if (r1.equals(r3) == true) goto L13;
    L24:
        if (r4.hasNext() == true) goto L29;
        if (r7.hasNext() == true) goto L29;
        return true;
    L29:
        return false;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> r2 = iterator();
        int r0 = 0;
    L4:
        if (r2.hasNext() == false) goto L6;
        r0 = r0 + r2.next().hashCode();
        goto L4
    L6:
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("[");
        Iterator<Map.Entry<K, V>> r2 = iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        r0.append(r2.next().toString());
        if (r2.hasNext() == false) goto L4;
        r0.append(", ");
        goto L4
    L8:
        r0.append("]");
        return r0.toString();
    }
}
