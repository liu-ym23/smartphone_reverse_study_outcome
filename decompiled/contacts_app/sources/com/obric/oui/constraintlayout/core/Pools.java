package com.obric.oui.constraintlayout.core;

/* JADX INFO: loaded from: classes3.dex */
final class Pools {
    private static final boolean DEBUG = false;

    interface Pool<T> {
        T acquire();

        boolean release(T r1);

        void releaseAll(T[] r1, int r2);
    }

    static class SimplePool<T> implements Pool<T> {
        private final Object[] mPool;
        private int mPoolSize;

        SimplePool(int r1) {
            if (r1 <= 0) goto L7;
            this.mPool = new Object[r1];
            return;
        L7:
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        @Override // com.obric.oui.constraintlayout.core.Pools.Pool
        public T acquire() {
            int r0 = this.mPoolSize;
            if (r0 <= 0) goto L6;
            int r2 = r0 - 1;
            Object[] r3 = this.mPool;
            T r4 = (T) r3[r2];
            r3[r2] = null;
            this.mPoolSize = r0 - 1;
            return r4;
        L6:
            return null;
        }

        @Override // com.obric.oui.constraintlayout.core.Pools.Pool
        public boolean release(T r4) {
            int r0 = this.mPoolSize;
            Object[] r1 = this.mPool;
            if (r0 >= r1.length) goto L6;
            r1[r0] = r4;
            this.mPoolSize = r0 + 1;
            return true;
        L6:
            return false;
        }

        @Override // com.obric.oui.constraintlayout.core.Pools.Pool
        public void releaseAll(T[] r6, int r7) {
            if (r7 <= r6.length) goto L5;
            r7 = r6.length;
        L5:
            int r0 = 0;
        L6:
            if (r0 >= r7) goto L11;
            T r1 = r6[r0];
            int r2 = this.mPoolSize;
            Object[] r3 = this.mPool;
            if (r2 >= r3.length) goto L10;
            r3[r2] = r1;
            this.mPoolSize = r2 + 1;
        L10:
            r0 = r0 + 1;
            goto L6
        }

        private boolean isInPool(T r4) {
            int r1 = 0;
        L4:
            if (r1 >= this.mPoolSize) goto L10;
            if (this.mPool[r1] == r4) goto L7;
            r1 = r1 + 1;
            goto L4
        L7:
            return true;
        L10:
            return false;
        }
    }

    private Pools() {
    }
}
