package org.apache.commons.math.util;

import org.apache.commons.math.exception.DimensionMismatchException;
import org.apache.commons.math.exception.NotStrictlyPositiveException;
import org.apache.commons.math.exception.OutOfRangeException;

/* JADX INFO: loaded from: classes3.dex */
public class MultidimensionalCounter implements Iterable<Integer> {
    private final int dimension;
    private final int last;
    private final int[] size;
    private final int totalSize;
    private final int[] uniCounterOffset;

    public class Iterator implements java.util.Iterator<Integer> {
        private int count;
        private final int[] counter;
        final /* synthetic */ MultidimensionalCounter this$0;

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Integer next() {
            return next();
        }

        Iterator(MultidimensionalCounter this$0) {
            this.this$0 = this$0;
            this.counter = new int[MultidimensionalCounter.access$000(this.this$0)];
            this.count = -1;
            this.counter[MultidimensionalCounter.access$100(this$0)] = -1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i = 0;
        L4:
            if (i >= MultidimensionalCounter.access$000(this.this$0)) goto L9;
            if (this.counter[i] != (MultidimensionalCounter.access$200(this.this$0)[i] - 1)) goto L7;
            i = i + 1;
            goto L4
        L7:
            return true;
        L9:
            return false;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Integer next() {
            int i = MultidimensionalCounter.access$100(this.this$0);
        L3:
            if (i < 0) goto L8;
            if (this.counter[i] != (MultidimensionalCounter.access$200(this.this$0)[i] - 1)) goto L7;
            this.counter[i] = 0;
            i = i - 1;
            goto L3
        L7:
            int[] r1 = this.counter;
            r1[i] = r1[i] + 1;
        L8:
            int i2 = this.count;
            int r0 = i2 + 1;
            this.count = r0;
            return Integer.valueOf(r0);
        }

        public int getCount() {
            return this.count;
        }

        public int[] getCounts() {
            return MultidimensionalCounter.access$300(this.this$0, this.counter, MultidimensionalCounter.access$000(this.this$0));
        }

        public int getCount(int dim) {
            return this.counter[dim];
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    static /* synthetic */ int access$000(MultidimensionalCounter x0) {
        return x0.dimension;
    }

    static /* synthetic */ int access$100(MultidimensionalCounter x0) {
        return x0.last;
    }

    static /* synthetic */ int[] access$200(MultidimensionalCounter x0) {
        return x0.size;
    }

    static /* synthetic */ int[] access$300(MultidimensionalCounter x0, int[] x1, int x2) {
        return x0.copyOf(x1, x2);
    }

    @Override // java.lang.Iterable
    public /* bridge */ /* synthetic */ java.util.Iterator<Integer> iterator() {
        return iterator2();
    }

    public MultidimensionalCounter(int... size) {
        this.dimension = size.length;
        this.size = copyOf(size, this.dimension);
        this.uniCounterOffset = new int[this.dimension];
        this.last = this.dimension - 1;
        int tS = size[this.last];
        int i = 0;
    L4:
        if (i >= this.last) goto L10;
        int count = 1;
        int j = i + 1;
    L7:
        if (j >= this.dimension) goto L9;
        count = count * size[j];
        j = j + 1;
        goto L7
    L9:
        this.uniCounterOffset[i] = count;
        tS = tS * size[i];
        i = i + 1;
        goto L4
    L10:
        this.uniCounterOffset[this.last] = 0;
        if (tS <= 0) goto L15;
        this.totalSize = tS;
        return;
    L15:
        throw new NotStrictlyPositiveException(Integer.valueOf(tS));
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
    public java.util.Iterator<Integer> iterator2() {
        return new Iterator(this);
    }

    public int getDimension() {
        return this.dimension;
    }

    public int[] getCounts(int index) {
        if (index < 0) goto L18;
        if (index >= this.totalSize) goto L18;
        int[] indices = new int[this.dimension];
        int count = 0;
        int i = 0;
    L7:
        if (i >= this.last) goto L12;
        int idx = 0;
        int offset = this.uniCounterOffset[i];
    L9:
        if (count > index) goto L11;
        count = count + offset;
        idx = idx + 1;
        goto L9
    L11:
        count = count - offset;
        indices[i] = idx - 1;
        i = i + 1;
        goto L7
    L12:
        int idx2 = 1;
    L13:
        if (count >= index) goto L15;
        count = count + idx2;
        idx2 = idx2 + 1;
        goto L13
    L15:
        indices[this.last] = idx2 - 1;
        return indices;
    L18:
        throw new OutOfRangeException(Integer.valueOf(index), 0, Integer.valueOf(this.totalSize));
    }

    public int getCount(int... c) throws OutOfRangeException {
        if (c.length != this.dimension) goto L17;
        int count = 0;
        int i = 0;
    L6:
        if (i >= this.dimension) goto L14;
        int index = c[i];
        if (index < 0) goto L13;
        if (index >= this.size[i]) goto L13;
        count = count + (this.uniCounterOffset[i] * c[i]);
        i = i + 1;
    L13:
        throw new OutOfRangeException(Integer.valueOf(index), 0, Integer.valueOf(this.size[i] - 1));
    L14:
        int i2 = this.last;
        return c[i2] + count;
    L17:
        throw new DimensionMismatchException(c.length, this.dimension);
    }

    public int getSize() {
        return this.totalSize;
    }

    public int[] getSizes() {
        return copyOf(this.size, this.dimension);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
    L4:
        if (i >= this.dimension) goto L7;
        sb.append("[");
        sb.append(getCount(new int[]{i}));
        sb.append("]");
        i = i + 1;
        goto L4
    L7:
        return sb.toString();
    }

    private int[] copyOf(int[] source, int newLen) {
        int[] output = new int[newLen];
        System.arraycopy(source, 0, output, 0, Math.min(source.length, newLen));
        return output;
    }
}
