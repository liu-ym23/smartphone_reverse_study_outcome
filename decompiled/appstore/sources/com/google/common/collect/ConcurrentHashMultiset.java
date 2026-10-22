package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public final class ConcurrentHashMultiset<E> extends AbstractMultiset<E> implements Serializable {
    private static final long serialVersionUID = 1;
    private final transient ConcurrentMap<E, AtomicInteger> countMap;

    public class EntrySet extends AbstractMultiset<E>.EntrySet {
        final /* synthetic */ ConcurrentHashMultiset this$0;

        private EntrySet(ConcurrentHashMultiset r10) {
            this.this$0 = r10;
            super(r10);
        }

        private List<Multiset.Entry<E>> snapshot() {
            ArrayList r10 = Lists.newArrayListWithExpectedSize(size());
            Iterators.addAll(r10, iterator());
            return r10;
        }

        @Override // com.google.common.collect.AbstractMultiset.EntrySet, com.google.common.collect.Multisets.EntrySet
        public /* bridge */ /* synthetic */ Multiset multiset() {
            return multiset();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return snapshot().toArray();
        }

        public /* synthetic */ EntrySet(ConcurrentHashMultiset r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.google.common.collect.AbstractMultiset.EntrySet, com.google.common.collect.Multisets.EntrySet
        public ConcurrentHashMultiset<E> multiset() {
            return this.this$0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] r10) {
            return (T[]) snapshot().toArray(r10);
        }
    }

    public static class FieldSettersHolder {
        static final Serialization.FieldSetter<ConcurrentHashMultiset> COUNT_MAP_FIELD_SETTER = null;

        static {
            COUNT_MAP_FIELD_SETTER = Serialization.getFieldSetter(ConcurrentHashMultiset.class, "countMap");
        }

        private FieldSettersHolder() {
        }
    }

    @VisibleForTesting
    public ConcurrentHashMultiset(ConcurrentMap<E, AtomicInteger> r10) {
        Preconditions.checkArgument(r10.isEmpty(), "the backing map (%s) must be empty", r10);
        this.countMap = r10;
    }

    public static /* synthetic */ ConcurrentMap access$100(ConcurrentHashMultiset r10) {
        return r10.countMap;
    }

    public static <E> ConcurrentHashMultiset<E> create() {
        return new ConcurrentHashMultiset(new ConcurrentHashMap());
    }

    private void readObject(ObjectInputStream r10) throws IOException, ClassNotFoundException {
        r10.defaultReadObject();
        ConcurrentMap r11 = (ConcurrentMap) r10.readObject();
        FieldSettersHolder.COUNT_MAP_FIELD_SETTER.set(this, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private List<E> snapshot() {
        ArrayList r10 = Lists.newArrayListWithExpectedSize(size());
        Iterator<E> r11 = entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Multiset.Entry r12 = (Multiset.Entry) r11.next();
        Object r13 = r12.getElement();
        int r14 = r12.getCount();
    L6:
        if (r14 <= 0) goto L4;
        r10.add(r13);
        r14 = r14 - 1;
        goto L6
    L8:
        return r10;
    }

    private void writeObject(ObjectOutputStream r10) throws IOException {
        r10.defaultWriteObject();
        r10.writeObject(this.countMap);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int add(E r10, int r11) {
        Preconditions.checkNotNull(r10);
        if (r11 == 0) goto L5;
        CollectPreconditions.checkPositive(r11, "occurences");
    L7:
        AtomicInteger r12 = (AtomicInteger) Maps.safeGet(this.countMap, r10);
        if (r12 != null) goto L12;
        r12 = this.countMap.putIfAbsent(r10, new AtomicInteger(r11));
        if (r12 != null) goto L12;
        return 0;
    L12:
        int r13 = r12.get();
        if (r13 == 0) goto L19;
        if (r12.compareAndSet(r13, IntMath.checkedAdd(r13, r11)) == false) goto L12;
        return r13;
    L18:
        throw new IllegalArgumentException("Overflow adding " + r11 + " occurrences to a count of " + r13);
    L19:
        AtomicInteger r14 = new AtomicInteger(r11);
        if (this.countMap.putIfAbsent(r10, r14) == null) goto L23;
        if (this.countMap.replace(r10, r12, r14) == false) goto L7;
    L23:
        return 0;
    L5:
        return count(r10);
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.countMap.clear();
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(@NullableDecl Object r10) {
        return super.contains(r10);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@NullableDecl Object r10) {
        AtomicInteger r11 = (AtomicInteger) Maps.safeGet(this.countMap, r10);
        if (r11 != null) goto L6;
        return 0;
    L6:
        return r11.get();
    }

    @Override // com.google.common.collect.AbstractMultiset
    public Set<E> createElementSet() {
        final Set<E> r10 = this.countMap.keySet();
        return new AnonymousClass1(this, r10);
    }

    @Override // com.google.common.collect.AbstractMultiset
    @Deprecated
    public Set<Multiset.Entry<E>> createEntrySet() {
        return new EntrySet(this, null);
    }

    @Override // com.google.common.collect.AbstractMultiset
    public int distinctElements() {
        return this.countMap.size();
    }

    @Override // com.google.common.collect.AbstractMultiset
    public Iterator<E> elementIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.AbstractMultiset
    public Iterator<Multiset.Entry<E>> entryIterator() {
        final AbstractIterator<Multiset.Entry<E>> r10 = new AnonymousClass2(this);
        return new AnonymousClass3(this, r10);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.countMap.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public Iterator<E> iterator() {
        return Multisets.iteratorImpl(this);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int remove(@NullableDecl Object r10, int r11) {
        if (r11 == 0) goto L4;
        CollectPreconditions.checkPositive(r11, "occurences");
        AtomicInteger r12 = (AtomicInteger) Maps.safeGet(this.countMap, r10);
        if (r12 != null) goto L8;
        return 0;
    L8:
        int r13 = r12.get();
        if (r13 == 0) goto L15;
        int r14 = Math.max(0, r13 - r11);
        if (r12.compareAndSet(r13, r14) == false) goto L8;
        if (r14 != 0) goto L14;
        this.countMap.remove(r10, r12);
    L14:
        return r13;
    L15:
        return 0;
    L4:
        return count(r10);
    }

    @CanIgnoreReturnValue
    public boolean removeExactly(@NullableDecl Object r10, int r11) {
        if (r11 != 0) goto L5;
        return true;
    L5:
        CollectPreconditions.checkPositive(r11, "occurences");
        AtomicInteger r12 = (AtomicInteger) Maps.safeGet(this.countMap, r10);
        if (r12 != null) goto L8;
        return false;
    L8:
        int r13 = r12.get();
        if (r13 < r11) goto L10;
        int r14 = r13 - r11;
        if (r12.compareAndSet(r13, r14) == false) goto L8;
        if (r14 != 0) goto L15;
        this.countMap.remove(r10, r12);
    L15:
        return true;
    L10:
        return false;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int setCount(E r10, int r11) {
        Preconditions.checkNotNull(r10);
        CollectPreconditions.checkNonnegative(r11, "count");
    L3:
        AtomicInteger r12 = (AtomicInteger) Maps.safeGet(this.countMap, r10);
        if (r12 != null) goto L10;
        if (r11 == 0) goto L6;
        r12 = this.countMap.putIfAbsent(r10, new AtomicInteger(r11));
        if (r12 != null) goto L10;
        return 0;
    L6:
        return 0;
    L10:
        int r13 = r12.get();
        if (r13 == 0) goto L12;
        if (r12.compareAndSet(r13, r11) == false) goto L10;
        if (r11 != 0) goto L23;
        this.countMap.remove(r10, r12);
    L23:
        return r13;
    L12:
        if (r11 == 0) goto L13;
        AtomicInteger r14 = new AtomicInteger(r11);
        if (this.countMap.putIfAbsent(r10, r14) == null) goto L18;
        if (this.countMap.replace(r10, r12, r14) == false) goto L3;
    L18:
        return 0;
    L13:
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        Iterator<AtomicInteger> r10 = this.countMap.values().iterator();
        long r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L7;
        r11 = r11 + ((long) r10.next().get());
        goto L4
    L7:
        return Ints.saturatedCast(r11);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return snapshot().toArray();
    }

    public static <E> ConcurrentHashMultiset<E> create(Iterable<? extends E> r10) {
        ConcurrentHashMultiset<E> r11 = create();
        Iterables.addAll(r11, r10);
        return r11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] r10) {
        return (T[]) snapshot().toArray(r10);
    }

    @Beta
    public static <E> ConcurrentHashMultiset<E> create(ConcurrentMap<E, AtomicInteger> r10) {
        return new ConcurrentHashMultiset(r10);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public boolean setCount(E r10, int r11, int r12) {
        Preconditions.checkNotNull(r10);
        CollectPreconditions.checkNonnegative(r11, "oldCount");
        CollectPreconditions.checkNonnegative(r12, "newCount");
        AtomicInteger r13 = (AtomicInteger) Maps.safeGet(this.countMap, r10);
        if (r13 != null) goto L12;
        if (r11 == 0) goto L6;
        return false;
    L6:
        if (r12 != 0) goto L9;
        return true;
    L9:
        if (this.countMap.putIfAbsent(r10, new AtomicInteger(r12)) == null) goto L11;
        return false;
    L11:
        return true;
    L12:
        int r14 = r13.get();
        if (r14 != r11) goto L29;
        if (r14 != 0) goto L25;
        if (r12 != 0) goto L18;
        this.countMap.remove(r10, r13);
        return true;
    L18:
        AtomicInteger r15 = new AtomicInteger(r12);
        if (this.countMap.putIfAbsent(r10, r15) == null) goto L23;
        if (this.countMap.replace(r10, r13, r15) == true) goto L23;
        return false;
    L23:
        return true;
    L25:
        if (r13.compareAndSet(r14, r12) == false) goto L29;
        if (r12 != 0) goto L28;
        this.countMap.remove(r10, r13);
    L28:
        return true;
    L29:
        return false;
    }
}
