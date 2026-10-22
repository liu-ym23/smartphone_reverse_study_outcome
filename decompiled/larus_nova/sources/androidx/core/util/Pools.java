package androidx.core.util;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Landroidx/core/util/Pools;", "", "()V", "Pool", "SimplePool", "SynchronizedPool", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Pools {

    /* JADX INFO: loaded from: classes3.dex */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002J\u000f\u0010\u0003\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0002\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Landroidx/core/util/Pools$Pool;", ExifInterface.GPS_DIRECTION_TRUE, "", "acquire", "()Ljava/lang/Object;", "release", "", "instance", "(Ljava/lang/Object;)Z", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Pool<T> {
        T acquire();

        boolean release(T r100);
    }

    /* JADX INFO: loaded from: classes3.dex */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u000f\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000f\u0010\u000b\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\fJ\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010R\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/core/util/Pools$SimplePool;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/core/util/Pools$Pool;", "maxPoolSize", "", "(I)V", "pool", "", "[Ljava/lang/Object;", "poolSize", "acquire", "()Ljava/lang/Object;", "isInPool", "", "instance", "(Ljava/lang/Object;)Z", "release", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class SimplePool<T> implements Pool<T> {
        private final Object[] pool;
        private int poolSize;

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            int r100 = this.poolSize;
            if (r100 <= 0) goto L6;
            int r101 = r100 - 1;
            T r102 = (T) this.pool[r101];
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
            this.pool[r101] = null;
            this.poolSize--;
            return r102;
        L6:
            return null;
        }

        public SimplePool(int r100) {
            if (r100 <= 0) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L10;
            this.pool = new Object[r100];
            return;
        L10:
            throw new IllegalArgumentException("The max pool size must be > 0".toString());
        L5:
            r101 = false;
            goto L6
        }

        private final boolean isInPool(T r100) {
            int r101 = this.poolSize;
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L9;
            if (this.pool[r102] == r100) goto L6;
            r102 = r102 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(T r100) {
            Intrinsics.checkNotNullParameter(r100, "instance");
            if ((!isInPool(r100)) == false) goto L11;
            int r101 = this.poolSize;
            Object[] r102 = this.pool;
            if (r101 >= r102.length) goto L8;
            r102[r101] = r100;
            this.poolSize = r101 + 1;
            return true;
        L8:
            return false;
        L11:
            throw new IllegalStateException("Already in the pool!".toString());
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000f\u0010\b\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\tJ\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\u0007\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/core/util/Pools$SynchronizedPool;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/core/util/Pools$SimplePool;", "maxPoolSize", "", "(I)V", "lock", "acquire", "()Ljava/lang/Object;", "release", "", "instance", "(Ljava/lang/Object;)Z", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class SynchronizedPool<T> extends SimplePool<T> {
        private final Object lock;

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public T acquire() {
            Object r100 = this.lock;
            monitor-enter(r100);
            T r101 = (T) super.acquire();
            monitor-exit(r100);
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        public SynchronizedPool(int r100) {
            super(r100);
            this.lock = new Object();
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public boolean release(T r100) {
            Intrinsics.checkNotNullParameter(r100, "instance");
            Object r101 = this.lock;
            monitor-enter(r101);
            boolean r102 = super.release(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);
            return r102;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private Pools() {
    }
}
