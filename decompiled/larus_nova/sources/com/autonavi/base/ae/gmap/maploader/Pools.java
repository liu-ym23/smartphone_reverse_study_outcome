package com.autonavi.base.ae.gmap.maploader;

/* JADX INFO: loaded from: classes39.dex */
public final class Pools {

    public interface Pool<T> {
        T acquire();

        void destory();

        boolean release(T r100);
    }

    public static class SimplePool<T> implements Pool<T> {
        private final Object[] mPool;
        private int mPoolSize;

        @Override // com.autonavi.base.ae.gmap.maploader.Pools.Pool
        public void destory() {
            int r100 = 0;
        L3:
            Object[] r101 = this.mPool;
            if (r100 >= r101.length) goto L6;
            r101[r100] = null;
            r100 = r100 + 1;
            goto L3
        }

        @Override // com.autonavi.base.ae.gmap.maploader.Pools.Pool
        public T acquire() {
            int r100 = this.mPoolSize;
            if (r100 <= 0) goto L6;
            int r101 = r100 - 1;
            Object[] r102 = this.mPool;
            T r103 = (T) r102[r101];
            r102[r101] = null;
            this.mPoolSize = r101;
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

        @Override // com.autonavi.base.ae.gmap.maploader.Pools.Pool
        public boolean release(T r100) {
            if (isInPool(r100) == true) goto L11;
            int r101 = this.mPoolSize;
            Object[] r102 = this.mPool;
            if (r101 >= r102.length) goto L8;
            r102[r101] = r100;
            this.mPoolSize = r101 + 1;
            return true;
        L8:
            return false;
        L11:
            throw new IllegalStateException("Already in the pool!");
        }
    }

    public static class SynchronizedPool<T> extends SimplePool<T> {
        private final Object mLock;

        @Override // com.autonavi.base.ae.gmap.maploader.Pools.SimplePool, com.autonavi.base.ae.gmap.maploader.Pools.Pool
        public T acquire() {
            Object r100 = this.mLock;
            monitor-enter(r100);
            T r101 = (T) super.acquire();
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        public SynchronizedPool(int r100) {
            super(r100);
            this.mLock = new Object();
        }

        @Override // com.autonavi.base.ae.gmap.maploader.Pools.SimplePool, com.autonavi.base.ae.gmap.maploader.Pools.Pool
        public boolean release(T r100) {
            Object r101 = this.mLock;
            monitor-enter(r101);
            boolean r102 = super.release(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return r102;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private Pools() {
    }
}
