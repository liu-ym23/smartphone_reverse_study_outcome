package ob;

import java.io.Closeable;
import java.io.RandomAccessFile;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public final class u implements Closeable {

    /* renamed from: f, reason: collision with root package name */
    public final boolean f8034f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f8035g;

    /* renamed from: h, reason: collision with root package name */
    public int f8036h;

    /* renamed from: i, reason: collision with root package name */
    public final ReentrantLock f8037i = new ReentrantLock();

    /* renamed from: j, reason: collision with root package name */
    public final RandomAccessFile f8038j;

    public u(boolean z4, RandomAccessFile randomAccessFile) {
        this.f8034f = z4;
        this.f8038j = randomAccessFile;
    }

    public static l a(u uVar) {
        if (!uVar.f8034f) {
            throw new IllegalStateException("file handle is read-only");
        }
        ReentrantLock reentrantLock = uVar.f8037i;
        reentrantLock.lock();
        try {
            if (uVar.f8035g) {
                throw new IllegalStateException("closed");
            }
            uVar.f8036h++;
            reentrantLock.unlock();
            return new l(uVar);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final m b(long j2) {
        ReentrantLock reentrantLock = this.f8037i;
        reentrantLock.lock();
        try {
            if (this.f8035g) {
                throw new IllegalStateException("closed");
            }
            this.f8036h++;
            reentrantLock.unlock();
            return new m(this, j2);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ReentrantLock reentrantLock = this.f8037i;
        reentrantLock.lock();
        try {
            if (this.f8035g) {
                return;
            }
            this.f8035g = true;
            if (this.f8036h != 0) {
                return;
            }
            synchronized (this) {
                this.f8038j.close();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void flush() {
        if (!this.f8034f) {
            throw new IllegalStateException("file handle is read-only");
        }
        ReentrantLock reentrantLock = this.f8037i;
        reentrantLock.lock();
        try {
            if (this.f8035g) {
                throw new IllegalStateException("closed");
            }
            synchronized (this) {
                this.f8038j.getFD().sync();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final long size() {
        long length;
        ReentrantLock reentrantLock = this.f8037i;
        reentrantLock.lock();
        try {
            if (this.f8035g) {
                throw new IllegalStateException("closed");
            }
            synchronized (this) {
                length = this.f8038j.length();
            }
            return length;
        } finally {
            reentrantLock.unlock();
        }
    }
}
