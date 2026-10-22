package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
final class CartesianList<E> extends AbstractList<List<E>> implements RandomAccess {
    private final transient ImmutableList<List<E>> axes;
    private final transient int[] axesSizeProduct;

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r1) {
        return get(r1);
    }

    static /* synthetic */ ImmutableList access$000(CartesianList r0) {
        return r0.axes;
    }

    static /* synthetic */ int access$100(CartesianList r0, int r1, int r2) {
        return r0.getAxisIndexForProductIndex(r1, r2);
    }

    static <E> List<List<E>> create(List<? extends List<? extends E>> r3) {
        ImmutableList.Builder r0 = new ImmutableList.Builder(r3.size());
        Iterator<? extends List<? extends E>> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L11;
        ImmutableList r1 = ImmutableList.copyOf(r4.next());
        if (r1.isEmpty() == true) goto L8;
        r0.add(r1);
        goto L4
    L8:
        return ImmutableList.of();
    L11:
        return new CartesianList(r0.build());
    }

    CartesianList(ImmutableList<List<E>> r5) {
        this.axes = r5;
        int[] r0 = new int[r5.size() + 1];
        r0[r5.size()] = 1;
        int r2 = r5.size() - 1;     // Catch: ArithmeticException -> L9
    L4:
        if (r2 < 0) goto L7;
        r0[r2] = IntMath.checkedMultiply(r0[r2 + 1], r5.get(r2).size());     // Catch: ArithmeticException -> L9
        r2 = r2 - 1;
        goto L4
    L7:
        this.axesSizeProduct = r0;
        return;
    L10:
        throw new IllegalArgumentException("Cartesian product too large; must have size at most Integer.MAX_VALUE");
    }

    private int getAxisIndexForProductIndex(int r3, int r4) {
        return (r3 / this.axesSizeProduct[r4 + 1]) % this.axes.get(r4).size();
    }

    @Override // java.util.AbstractList, java.util.List
    public ImmutableList<E> get(final int r2) {
        Preconditions.checkElementIndex(r2, size());
        return new AnonymousClass1(this, r2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.axesSizeProduct[0];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(@Nullable Object r4) {
        if ((r4 instanceof List) == true) goto L5;
        return false;
    L5:
        List r5 = (List) r4;
        if (r5.size() == this.axes.size()) goto L8;
        return false;
    L8:
        ListIterator<E> r6 = r5.listIterator();
    L10:
        if (r6.hasNext() == false) goto L14;
        int r0 = r6.nextIndex();
        if (this.axes.get(r0).contains(r6.next()) == true) goto L10;
        return false;
    L14:
        return true;
    }
}
