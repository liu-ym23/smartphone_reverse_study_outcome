package Mb;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import io.ktor.http.ContentDisposition;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\u001eB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u001a\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\u0018H$¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0007H$¢\u0006\u0004\b\u001c\u0010\u000fJ\u000f\u0010\u001d\u001a\u00020\u0013H$¢\u0006\u0004\b\u001d\u0010\u0015R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001fR\u0016\u0010&\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u001b\u0010-\u001a\u00060'j\u0002`(8\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,¨\u0006."}, d2 = {"LMb/g;", "Ljava/io/Closeable;", "Lokio/Closeable;", "", "readWrite", "<init>", "(Z)V", "", "fileOffset", "LMb/d;", "sink", "byteCount", "G", "(JLMb/d;J)J", ContentDisposition.Parameters.Size, "()J", "LMb/I;", "J", "(J)LMb/I;", "LY8/t;", "close", "()V", "", "array", "", "arrayOffset", "n", "(J[BII)I", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "m", Const.INTENT_KEY_APIKEY, "Z", "getReadWrite", "()Z", Const.INTENT_KEY_PKGNAME, AlipayXuiIsland.REASON_CLOSED, "c", "I", "openStreamCount", "Ljava/util/concurrent/locks/ReentrantLock;", "Lokio/Lock;", Const.INTENT_KEY_UMID, "Ljava/util/concurrent/locks/ReentrantLock;", "l", "()Ljava/util/concurrent/locks/ReentrantLock;", "lock", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: Mb.g, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0969g implements Closeable {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final boolean readWrite;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public boolean closed;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public int openStreamCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final ReentrantLock lock = M.b();

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010#\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006$"}, d2 = {"LMb/g$a;", "LMb/I;", "LMb/g;", "fileHandle", "", "position", "<init>", "(LMb/g;J)V", "LMb/d;", "sink", "byteCount", "u0", "(LMb/d;J)J", "LMb/J;", "c", "()LMb/J;", "LY8/t;", "close", "()V", Const.INTENT_KEY_APIKEY, "LMb/g;", "getFileHandle", "()LMb/g;", Const.INTENT_KEY_PKGNAME, "J", "getPosition", "()J", "setPosition", "(J)V", "", "Z", "getClosed", "()Z", "setClosed", "(Z)V", AlipayXuiIsland.REASON_CLOSED, "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: Mb.g$a */
    public static final class a implements I {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final AbstractC0969g fileHandle;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public long position;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public boolean closed;

        public a(AbstractC0969g fileHandle, long j10) {
            kotlin.jvm.internal.p.i(fileHandle, "fileHandle");
            this.fileHandle = fileHandle;
            this.position = j10;
        }

        @Override // Mb.I
        public J c() {
            return J.f4694f;
        }

        @Override // Mb.I, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            ReentrantLock lock = this.fileHandle.getLock();
            lock.lock();
            try {
                AbstractC0969g abstractC0969g = this.fileHandle;
                abstractC0969g.openStreamCount--;
                if (this.fileHandle.openStreamCount == 0 && this.fileHandle.closed) {
                    Y8.t tVar = Y8.t.f7040a;
                    lock.unlock();
                    this.fileHandle.m();
                }
            } finally {
                lock.unlock();
            }
        }

        @Override // Mb.I
        public long u0(C0966d sink, long byteCount) throws IOException {
            kotlin.jvm.internal.p.i(sink, "sink");
            if (this.closed) {
                throw new IllegalStateException(AlipayXuiIsland.REASON_CLOSED);
            }
            long jG = this.fileHandle.G(this.position, sink, byteCount);
            if (jG != -1) {
                this.position += jG;
            }
            return jG;
        }
    }

    public AbstractC0969g(boolean z10) {
        this.readWrite = z10;
    }

    public abstract long A() throws IOException;

    public final long G(long fileOffset, C0966d sink, long byteCount) throws IOException {
        if (byteCount < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        long j10 = byteCount + fileOffset;
        long j11 = fileOffset;
        while (true) {
            if (j11 >= j10) {
                break;
            }
            E eH1 = sink.h1(1);
            int iN = n(j11, eH1.data, eH1.limit, (int) Math.min(j10 - j11, 8192 - r7));
            if (iN == -1) {
                if (eH1.pos == eH1.limit) {
                    sink.head = eH1.b();
                    F.b(eH1);
                }
                if (fileOffset == j11) {
                    return -1L;
                }
            } else {
                eH1.limit += iN;
                long j12 = iN;
                j11 += j12;
                sink.a1(sink.getSize() + j12);
            }
        }
        return j11 - fileOffset;
    }

    public final I J(long fileOffset) throws IOException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.closed) {
                throw new IllegalStateException(AlipayXuiIsland.REASON_CLOSED);
            }
            this.openStreamCount++;
            reentrantLock.unlock();
            return new a(this, fileOffset);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.closed) {
                return;
            }
            this.closed = true;
            if (this.openStreamCount != 0) {
                return;
            }
            Y8.t tVar = Y8.t.f7040a;
            reentrantLock.unlock();
            m();
        } finally {
            reentrantLock.unlock();
        }
    }

    /* renamed from: l, reason: from getter */
    public final ReentrantLock getLock() {
        return this.lock;
    }

    public abstract void m() throws IOException;

    public abstract int n(long fileOffset, byte[] array, int arrayOffset, int byteCount) throws IOException;

    public final long size() throws IOException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.closed) {
                throw new IllegalStateException(AlipayXuiIsland.REASON_CLOSED);
            }
            Y8.t tVar = Y8.t.f7040a;
            reentrantLock.unlock();
            return A();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
