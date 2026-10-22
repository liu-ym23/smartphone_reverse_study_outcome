package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
final class TopKSelector<T> {
    private final T[] buffer;
    private int bufferSize;
    private final Comparator<? super T> comparator;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f10355k;

    @NullableDecl
    private T threshold;

    private TopKSelector(Comparator<? super T> r10, int r11) {
        this.comparator = (Comparator) Preconditions.checkNotNull(r10, "comparator");
        this.f10355k = r11;
        if (r11 < 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12, "k must be nonnegative, was %s", r11);
        this.buffer = (T[]) new Object[r11 * 2];
        this.bufferSize = 0;
        this.threshold = null;
        return;
    L5:
        r12 = false;
        goto L6
    }

    public static <T extends Comparable<? super T>> TopKSelector<T> greatest(int r10) {
        return greatest(r10, Ordering.natural());
    }

    public static <T extends Comparable<? super T>> TopKSelector<T> least(int r10) {
        return least(r10, Ordering.natural());
    }

    private int partition(int r10, int r11, int r12) {
        T[] r13 = this.buffer;
        T r14 = r13[r12];
        r13[r12] = r13[r11];
        int r15 = r10;
    L3:
        if (r10 >= r11) goto L8;
        if (this.comparator.compare(this.buffer[r10], r14) >= 0) goto L7;
        swap(r15, r10);
        r15 = r15 + 1;
    L7:
        r10 = r10 + 1;
        goto L3
    L8:
        T[] r16 = this.buffer;
        r16[r11] = r16[r15];
        r16[r15] = r14;
        return r15;
    }

    private void swap(int r10, int r11) {
        T[] r12 = this.buffer;
        T r13 = r12[r10];
        r12[r10] = r12[r11];
        r12[r11] = r13;
    }

    private void trim() {
        int r10 = (this.f10355k * 2) - 1;
        int r11 = IntMath.log2(r10, RoundingMode.CEILING) * 3;
        int r12 = 0;
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r12 >= r10) goto L12;
        int r15 = partition(r12, r10, ((r12 + r10) + 1) >>> 1);
        int r16 = this.f10355k;
        if (r15 <= r16) goto L7;
        r10 = r15 - 1;
    L9:
        r13 = r13 + 1;
        if (r13 < r11) goto L3;
        Arrays.sort(this.buffer, r12, r10, this.comparator);
        goto L12
    L7:
        if (r15 >= r16) goto L12;
        r12 = Math.max(r15, r12 + 1);
        r14 = r15;
    L12:
        this.bufferSize = this.f10355k;
        this.threshold = this.buffer[r14];
    L13:
        r14 = r14 + 1;
        if (r14 >= this.f10355k) goto L19;
        if (this.comparator.compare(this.buffer[r14], this.threshold) <= 0) goto L13;
        this.threshold = this.buffer[r14];
        goto L13
    }

    public void offer(@NullableDecl T r10) {
        int r11 = this.f10355k;
        if (r11 != 0) goto L5;
        return;
    L5:
        int r12 = this.bufferSize;
        if (r12 != 0) goto L8;
        this.buffer[0] = r10;
        this.threshold = r10;
        this.bufferSize = 1;
        return;
    L8:
        if (r12 >= r11) goto L13;
        T[] r13 = this.buffer;
        this.bufferSize = r12 + 1;
        r13[r12] = r10;
        if (this.comparator.compare(r10, this.threshold) <= 0) goto L19;
        this.threshold = r10;
        return;
    L19:
        return;
    L13:
        if (this.comparator.compare(r10, this.threshold) >= 0) goto L21;
        T[] r14 = this.buffer;
        int r15 = this.bufferSize;
        int r16 = r15 + 1;
        this.bufferSize = r16;
        r14[r15] = r10;
        if (r16 != (this.f10355k * 2)) goto L22;
        trim();
        return;
    L22:
        return;
    }

    public void offerAll(Iterable<? extends T> r10) {
        offerAll(r10.iterator());
    }

    public List<T> topK() {
        Arrays.sort(this.buffer, 0, this.bufferSize, this.comparator);
        int r10 = this.bufferSize;
        int r11 = this.f10355k;
        if (r10 <= r11) goto L6;
        T[] r12 = this.buffer;
        Arrays.fill(r12, r11, r12.length, null);
        int r13 = this.f10355k;
        this.bufferSize = r13;
        this.threshold = this.buffer[r13 - 1];
    L6:
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(this.buffer, this.bufferSize)));
    }

    public static <T> TopKSelector<T> greatest(int r10, Comparator<? super T> r11) {
        return new TopKSelector(Ordering.from(r11).reverse(), r10);
    }

    public static <T> TopKSelector<T> least(int r10, Comparator<? super T> r11) {
        return new TopKSelector(r11, r10);
    }

    public void offerAll(Iterator<? extends T> r10) {
    L3:
        if (r10.hasNext() == false) goto L5;
        offer(r10.next());
        goto L3
    }
}
