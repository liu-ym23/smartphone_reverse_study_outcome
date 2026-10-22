package od;

import java.io.Closeable;
import java.io.RandomAccessFile;
import java.lang.invoke.VarHandle;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u implements Closeable {

    /* renamed from: c, reason: collision with root package name */
    public boolean f9490c;

    /* renamed from: f, reason: collision with root package name */
    public int f9491f;

    /* renamed from: g, reason: collision with root package name */
    public ReentrantLock f9492g;

    /* renamed from: h, reason: collision with root package name */
    public RandomAccessFile f9493h;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ReentrantLock reentrantLock = this.f9492g;
        reentrantLock.lock();
        try {
            if (this.f9490c) {
                return;
            }
            this.f9490c = true;
            if (this.f9491f != 0) {
                return;
            }
            synchronized (this) {
                this.f9493h.close();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final m d(long j10) {
        ReentrantLock reentrantLock = this.f9492g;
        reentrantLock.lock();
        try {
            if (this.f9490c) {
                throw new IllegalStateException("closed");
            }
            this.f9491f++;
            reentrantLock.unlock();
            m mVar = new m();
            mVar.f9467c = this;
            mVar.f9468f = j10;
            VarHandle.storeStoreFence();
            return mVar;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final long size() {
        long length;
        ReentrantLock reentrantLock = this.f9492g;
        reentrantLock.lock();
        try {
            if (this.f9490c) {
                throw new IllegalStateException("closed");
            }
            synchronized (this) {
                length = this.f9493h.length();
            }
            return length;
        } finally {
            reentrantLock.unlock();
        }
    }
}
