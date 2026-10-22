package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public final class EnumMultiset<E extends Enum<E>> extends AbstractMultiset<E> implements Serializable {

    @GwtIncompatible
    private static final long serialVersionUID = 0;
    private transient int[] counts;
    private transient int distinctElements;
    private transient E[] enumConstants;
    private transient long size;
    private transient Class<E> type;

    public abstract class Itr<T> implements Iterator<T> {
        int index;
        final /* synthetic */ EnumMultiset this$0;
        int toRemove;

        public Itr(EnumMultiset r10) {
            this.this$0 = r10;
            this.index = 0;
            this.toRemove = -1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
        L3:
            if (this.index >= EnumMultiset.access$000(this.this$0).length) goto L9;
            int[] r10 = EnumMultiset.access$100(this.this$0);
            int r11 = this.index;
            if (r10[r11] > 0) goto L6;
            this.index = r11 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext() == false) goto L7;
            T r10 = output(this.index);
            int r11 = this.index;
            this.toRemove = r11;
            this.index = r11 + 1;
            return r10;
        L7:
            throw new NoSuchElementException();
        }

        public abstract T output(int r10);

        @Override // java.util.Iterator
        public void remove() {
            if (this.toRemove < 0) goto L5;
            boolean r10 = true;
        L6:
            CollectPreconditions.checkRemove(r10);
            if (EnumMultiset.access$100(this.this$0)[this.toRemove] <= 0) goto L9;
            EnumMultiset.access$210(this.this$0);
            EnumMultiset r11 = this.this$0;
            EnumMultiset.access$302(r11, EnumMultiset.access$300(r11) - ((long) EnumMultiset.access$100(this.this$0)[this.toRemove]));
            EnumMultiset.access$100(this.this$0)[this.toRemove] = 0;
        L9:
            this.toRemove = -1;
            return;
        L5:
            r10 = false;
            goto L6
        }
    }

    private EnumMultiset(Class<E> r10) {
        this.type = r10;
        Preconditions.checkArgument(r10.isEnum());
        E[] r11 = r10.getEnumConstants();
        this.enumConstants = r11;
        this.counts = new int[r11.length];
    }

    public static /* synthetic */ Enum[] access$000(EnumMultiset r10) {
        return r10.enumConstants;
    }

    public static /* synthetic */ int[] access$100(EnumMultiset r10) {
        return r10.counts;
    }

    public static /* synthetic */ int access$210(EnumMultiset r10) {
        int r11 = r10.distinctElements;
        r10.distinctElements = r11 - 1;
        return r11;
    }

    public static /* synthetic */ long access$300(EnumMultiset r10) {
        return r10.size;
    }

    public static /* synthetic */ long access$302(EnumMultiset r10, long r11) {
        r10.size = r11;
        return r11;
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Class<E> r10) {
        return new EnumMultiset(r10);
    }

    private boolean isActuallyE(@NullableDecl Object r10) {
        if ((r10 instanceof Enum) == false) goto L10;
        Enum r11 = (Enum) r10;
        int r12 = r11.ordinal();
        E[] r13 = this.enumConstants;
        if (r12 < r13.length) goto L7;
        return false;
    L7:
        if (r13[r12] != r11) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream r10) throws IOException, ClassNotFoundException {
        r10.defaultReadObject();
        Class<E> r11 = (Class) r10.readObject();
        this.type = r11;
        E[] r12 = r11.getEnumConstants();
        this.enumConstants = r12;
        this.counts = new int[r12.length];
        Serialization.populateMultiset(this, r10);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream r10) throws IOException {
        r10.defaultWriteObject();
        r10.writeObject(this.type);
        Serialization.writeMultiset(this, r10);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ int add(Object r10, int r11) {
        return add((Enum) r10, r11);
    }

    public void checkIsE(@NullableDecl Object r10) {
        Preconditions.checkNotNull(r10);
        if (isActuallyE(r10) == false) goto L6;
        return;
    L6:
        throw new ClassCastException("Expected an " + this.type + " but got " + r10);
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Arrays.fill(this.counts, 0);
        this.size = 0;
        this.distinctElements = 0;
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(@NullableDecl Object r10) {
        return super.contains(r10);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@NullableDecl Object r10) {
        if (r10 != null) goto L4;
        return 0;
    L4:
        if (isActuallyE(r10) == true) goto L7;
        return 0;
    L7:
        return this.counts[((Enum) r10).ordinal()];
    }

    @Override // com.google.common.collect.AbstractMultiset
    public int distinctElements() {
        return this.distinctElements;
    }

    @Override // com.google.common.collect.AbstractMultiset
    public Iterator<E> elementIterator() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.AbstractMultiset
    public Iterator<Multiset.Entry<E>> entryIterator() {
        return new AnonymousClass2(this);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public Iterator<E> iterator() {
        return Multisets.iteratorImpl(this);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int remove(@NullableDecl Object r10, int r11) {
        if (r10 != null) goto L5;
    L18:
        return 0;
    L5:
        if (isActuallyE(r10) == false) goto L18;
        Enum r12 = (Enum) r10;
        CollectPreconditions.checkNonnegative(r11, "occurrences");
        if (r11 == 0) goto L10;
        int r13 = r12.ordinal();
        int[] r14 = this.counts;
        int r15 = r14[r13];
        if (r15 != 0) goto L14;
        return 0;
    L14:
        if (r15 > r11) goto L16;
        r14[r13] = 0;
        this.distinctElements--;
        this.size -= (long) r15;
    L17:
        return r15;
    L16:
        r14[r13] = r15 - r11;
        this.size -= (long) r11;
        goto L17
    L10:
        return count(r10);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ int setCount(Object r10, int r11) {
        return setCount((Enum) r10, r11);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return Ints.saturatedCast(this.size);
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> r10) {
        Iterator<E> r11 = r10.iterator();
        Preconditions.checkArgument(r11.hasNext(), "EnumMultiset constructor passed empty Iterable");
        EnumMultiset<E> r12 = new EnumMultiset(r11.next().getDeclaringClass());
        Iterables.addAll(r12, r10);
        return r12;
    }

    @CanIgnoreReturnValue
    public int add(E r10, int r11) {
        checkIsE(r10);
        CollectPreconditions.checkNonnegative(r11, "occurrences");
        if (r11 == 0) goto L5;
        int r12 = r10.ordinal();
        int r13 = this.counts[r12];
        long r14 = r11;
        long r15 = ((long) r13) + r14;
        if (r15 > 2147483647L) goto L9;
        boolean r16 = true;
    L10:
        Preconditions.checkArgument(r16, "too many occurrences: %s", r15);
        this.counts[r12] = (int) r15;
        if (r13 != 0) goto L13;
        this.distinctElements++;
    L13:
        this.size += r14;
        return r13;
    L9:
        r16 = false;
        goto L10
    L5:
        return count(r10);
    }

    @CanIgnoreReturnValue
    public int setCount(E r10, int r11) {
        checkIsE(r10);
        CollectPreconditions.checkNonnegative(r11, "count");
        int r12 = r10.ordinal();
        int[] r13 = this.counts;
        int r14 = r13[r12];
        r13[r12] = r11;
        this.size += (long) (r11 - r14);
        if (r14 != 0) goto L6;
        if (r11 <= 0) goto L6;
        this.distinctElements++;
    L9:
        return r14;
    L6:
        if (r14 <= 0) goto L9;
        if (r11 != 0) goto L9;
        this.distinctElements--;
        goto L9
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> r10, Class<E> r11) {
        EnumMultiset<E> r12 = create(r11);
        Iterables.addAll(r12, r10);
        return r12;
    }
}
