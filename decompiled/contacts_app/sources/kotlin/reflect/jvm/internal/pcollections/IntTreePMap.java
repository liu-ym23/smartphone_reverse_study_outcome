package kotlin.reflect.jvm.internal.pcollections;

/* JADX INFO: loaded from: classes4.dex */
final class IntTreePMap<V> {
    private static final IntTreePMap<Object> EMPTY = null;
    private final IntTree<V> root;

    static {
        EMPTY = new IntTreePMap(IntTree.EMPTYNODE);
    }

    public static <V> IntTreePMap<V> empty() {
        return (IntTreePMap<V>) EMPTY;
    }

    private IntTreePMap(IntTree<V> r1) {
        this.root = r1;
    }

    private IntTreePMap<V> withRoot(IntTree<V> r2) {
        if (r2 != this.root) goto L6;
        return this;
    L6:
        return new IntTreePMap(r2);
    }

    public V get(int r3) {
        return this.root.get(r3);
    }

    public IntTreePMap<V> plus(int r4, V r5) {
        return withRoot(this.root.plus(r4, r5));
    }

    public IntTreePMap<V> minus(int r4) {
        return withRoot(this.root.minus(r4));
    }
}
