package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
final class CartesianList<E> extends AbstractList<List<E>> implements RandomAccess {
    private final transient ImmutableList<List<E>> axes;
    private final transient int[] axesSizeProduct;

    public CartesianList(ImmutableList<List<E>> r10) {
        this.axes = r10;
        int[] r11 = new int[r10.size() + 1];
        r11[r10.size()] = 1;
        int r12 = r10.size() - 1;     // Catch: ArithmeticException -> L9
    L4:
        if (r12 < 0) goto L7;
        r11[r12] = IntMath.checkedMultiply(r11[r12 + 1], r10.get(r12).size());     // Catch: ArithmeticException -> L9
        r12 = r12 - 1;
        goto L4
    L7:
        this.axesSizeProduct = r11;
        return;
    L10:
        throw new IllegalArgumentException("Cartesian product too large; must have size at most Integer.MAX_VALUE");
    }

    public static /* synthetic */ ImmutableList access$000(CartesianList r10) {
        return r10.axes;
    }

    public static /* synthetic */ int access$100(CartesianList r10, int r11, int r12) {
        return r10.getAxisIndexForProductIndex(r11, r12);
    }

    public static <E> List<List<E>> create(List<? extends List<? extends E>> r10) {
        ImmutableList.Builder r11 = new ImmutableList.Builder(r10.size());
        Iterator<? extends List<? extends E>> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        ImmutableList r13 = ImmutableList.copyOf(r12.next());
        if (r13.isEmpty() == true) goto L8;
        r11.add(r13);
        goto L4
    L8:
        return ImmutableList.of();
    L11:
        return new CartesianList(r11.build());
    }

    private int getAxisIndexForProductIndex(int r10, int r11) {
        return (r10 / this.axesSizeProduct[r11 + 1]) % this.axes.get(r11).size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(@NullableDecl Object r10) {
        if (indexOf(r10) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r10) {
        return get(r10);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object r10) {
        if ((r10 instanceof List) == true) goto L5;
        return -1;
    L5:
        List r11 = (List) r10;
        if (r11.size() == this.axes.size()) goto L8;
        return -1;
    L8:
        ListIterator<E> r12 = r11.listIterator();
        int r13 = 0;
    L10:
        if (r12.hasNext() == false) goto L15;
        int r14 = r12.nextIndex();
        int r15 = this.axes.get(r14).indexOf(r12.next());
        if (r15 == (-1)) goto L13;
        r13 = r13 + (r15 * this.axesSizeProduct[r14 + 1]);
        goto L10
    L13:
        return -1;
    L15:
        return r13;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.axesSizeProduct[0];
    }

    @Override // java.util.AbstractList, java.util.List
    public ImmutableList<E> get(final int r10) {
        Preconditions.checkElementIndex(r10, size());
        return new AnonymousClass1(this, r10);
    }
}
