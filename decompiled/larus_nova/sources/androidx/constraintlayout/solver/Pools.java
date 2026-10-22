package androidx.constraintlayout.solver;

/* JADX INFO: loaded from: classes17.dex */
final class Pools {
    private static final boolean DEBUG = false;

    /* JADX INFO: loaded from: classes3.dex */
    public interface Pool<T> {
        T acquire();

        boolean release(T r100);

        void releaseAll(T[] r100, int r101);
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static class SimplePool<T> implements Pool<T> {
        private final Object[] mPool;
        private int mPoolSize;

        @Override // androidx.constraintlayout.solver.Pools.Pool
        public T acquire() {
            int r100 = this.mPoolSize;
            if (r100 <= 0) goto L6;
            int r101 = r100 - 1;
            Object[] r102 = this.mPool;
            T r103 = (T) r102[r101];
            r102[r101] = null;
            this.mPoolSize = r100 - 1;
            return r103;
        L6:
            return null;
        }

        public SimplePool(int r100) {
            if (r100 <= 0) goto L7;
            this.mPool = new Object[r100];
            return;
        L7:
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        private boolean isInPool(T r100) {
            int r101 = 0;
        L4:
            if (r101 >= this.mPoolSize) goto L10;
            if (this.mPool[r101] == r100) goto L7;
            r101 = r101 + 1;
            goto L4
        L7:
            return true;
        L10:
            return false;
        }

        @Override // androidx.constraintlayout.solver.Pools.Pool
        public boolean release(T r100) {
            int r101 = this.mPoolSize;
            Object[] r102 = this.mPool;
            if (r101 >= r102.length) goto L6;
            r102[r101] = r100;
            this.mPoolSize = r101 + 1;
            return true;
        L6:
            return false;
        }

        @Override // androidx.constraintlayout.solver.Pools.Pool
        public void releaseAll(T[] r100, int r101) {
            if (r101 <= r100.length) goto L5;
            r101 = r100.length;
        L5:
            int r102 = 0;
        L6:
            if (r102 >= r101) goto L11;
            T r103 = r100[r102];
            int r104 = this.mPoolSize;
            Object[] r105 = this.mPool;
            if (r104 >= r105.length) goto L10;
            r105[r104] = r103;
            this.mPoolSize = r104 + 1;
        L10:
            r102 = r102 + 1;
            goto L6
        }
    }

    private Pools() {
    }
}
