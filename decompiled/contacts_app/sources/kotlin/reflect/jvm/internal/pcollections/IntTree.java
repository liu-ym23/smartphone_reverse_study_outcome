package kotlin.reflect.jvm.internal.pcollections;

/* JADX INFO: loaded from: classes4.dex */
final class IntTree<V> {
    static final IntTree<Object> EMPTYNODE = null;
    private final long key;
    private final IntTree<V> left;
    private final IntTree<V> right;
    private final int size;
    private final V value;

    static {
        EMPTYNODE = new IntTree();
    }

    private IntTree() {
        this.size = 0;
        this.key = 0;
        this.value = null;
        this.left = null;
        this.right = null;
    }

    private IntTree(long r1, V r3, IntTree<V> r4, IntTree<V> r5) {
        this.key = r1;
        this.value = r3;
        this.left = r4;
        this.right = r5;
        this.size = (r4.size + 1) + r5.size;
    }

    private IntTree<V> withKey(long r8) {
        if (this.size != 0) goto L5;
    L9:
        return this;
    L5:
        if (r8 == this.key) goto L9;
        return new IntTree(r8, this.value, this.left, this.right);
    }

    V get(long r4) {
        if (this.size != 0) goto L6;
        return null;
    L6:
        long r0 = this.key;
        if (r4 >= r0) goto L11;
        return this.left.get(r4 - r0);
    L11:
        if (r4 <= r0) goto L15;
        return this.right.get(r4 - r0);
    L15:
        return this.value;
    }

    IntTree<V> plus(long r8, V r10) {
        if (this.size == 0) goto L5;
        long r0 = this.key;
        if (r8 >= r0) goto L11;
        return rebalanced(this.left.plus(r8 - r0, r10), this.right);
    L11:
        if (r8 <= r0) goto L15;
        return rebalanced(this.left, this.right.plus(r8 - r0, r10));
    L15:
        if (r10 != this.value) goto L18;
        return this;
    L18:
        return new IntTree(r8, r10, this.left, this.right);
    L5:
        return new IntTree(r8, r10, this, this);
    }

    IntTree<V> minus(long r8) {
        if (this.size != 0) goto L5;
        return this;
    L5:
        long r0 = this.key;
        if (r8 >= r0) goto L10;
        return rebalanced(this.left.minus(r8 - r0), this.right);
    L10:
        if (r8 > r0) goto L12;
        IntTree<V> r9 = this.left;
        if (r9.size != 0) goto L17;
        IntTree<V> r7 = this.right;
        return r7.withKey(r7.key + r0);
    L17:
        IntTree<V> r10 = this.right;
        if (r10.size == 0) goto L20;
        long r11 = r10.minKey();
        long r1 = this.key;
        long r12 = r11 + r1;
        V r2 = this.right.get(r12 - r1);
        IntTree<V> r3 = this.right.minus(r12 - this.key);
        IntTree<V> r4 = r3.withKey((r3.key + this.key) - r12);
        IntTree<V> r5 = this.left;
        return rebalanced(r12, r2, r5.withKey((r5.key + this.key) - r12), r4);
    L20:
        return r9.withKey(r9.key + r0);
    L12:
        return rebalanced(this.left, this.right.minus(r8 - r0));
    }

    private long minKey() {
        IntTree<V> r0 = this.left;
        if (r0.size != 0) goto L7;
        return this.key;
    L7:
        return r0.minKey() + this.key;
    }

    private IntTree<V> rebalanced(IntTree<V> r3, IntTree<V> r4) {
        if (r3 != this.left) goto L8;
        if (r4 != this.right) goto L8;
        return this;
    L8:
        return rebalanced(this.key, this.value, r3, r4);
    }

    private static <V> IntTree<V> rebalanced(long r17, V r19, IntTree<V> r20, IntTree<V> r21) {
        int r0 = ((IntTree) r20).size;
        int r1 = ((IntTree) r21).size;
        if ((r0 + r1) <= 1) goto L21;
        if (r0 < (r1 * 5)) goto L13;
        IntTree<V> r11 = ((IntTree) r20).left;
        IntTree<V> r2 = ((IntTree) r20).right;
        if (((IntTree) r2).size >= (((IntTree) r11).size * 2)) goto L10;
        long r3 = ((IntTree) r20).key;
        return new IntTree(r3 + r17, ((IntTree) r20).value, r11, new IntTree(-r3, r19, r2.withKey(((IntTree) r2).key + r3), r21));
    L10:
        IntTree<V> r4 = ((IntTree) r2).left;
        IntTree<V> r5 = ((IntTree) r2).right;
        long r7 = ((IntTree) r2).key;
        long r14 = (((IntTree) r20).key + r7) + r17;
        V r6 = ((IntTree) r2).value;
        IntTree r16 = new IntTree(-r7, ((IntTree) r20).value, r11, r4.withKey(((IntTree) r4).key + r7));
        long r8 = ((IntTree) r20).key;
        long r9 = ((IntTree) r2).key;
        return new IntTree(r14, r6, r16, new IntTree((-r8) - r9, r19, r5.withKey((((IntTree) r5).key + r9) + r8), r21));
    L13:
        if (r1 < (r0 * 5)) goto L21;
        IntTree<V> r10 = ((IntTree) r21).left;
        IntTree<V> r12 = ((IntTree) r21).right;
        if (((IntTree) r10).size >= (((IntTree) r12).size * 2)) goto L18;
        long r13 = ((IntTree) r21).key;
        return new IntTree(r13 + r17, ((IntTree) r21).value, new IntTree(-r13, r19, r20, r10.withKey(((IntTree) r10).key + r13)), r12);
    L18:
        IntTree<V> r15 = ((IntTree) r10).left;
        IntTree<V> r18 = ((IntTree) r10).right;
        long r22 = ((IntTree) r10).key;
        long r110 = ((IntTree) r21).key;
        long r111 = (r22 + r110) + r17;
        V r112 = ((IntTree) r10).value;
        IntTree r113 = new IntTree((-r110) - r22, r19, r20, r15.withKey((((IntTree) r15).key + r22) + r110));
        long r23 = ((IntTree) r10).key;
        return new IntTree(r111, r112, r113, new IntTree(-r23, ((IntTree) r21).value, r18.withKey(((IntTree) r18).key + r23), r12));
    L21:
        return new IntTree(r17, r19, r20, r21);
    }
}
