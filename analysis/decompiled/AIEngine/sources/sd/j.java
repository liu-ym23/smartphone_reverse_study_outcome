package sd;

import java.io.Closeable;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class j implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public boolean f11946a;

    /* renamed from: b, reason: collision with root package name */
    public int f11947b;

    /* renamed from: c, reason: collision with root package name */
    public final ReentrantLock f11948c = new ReentrantLock();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements e0 {

        /* renamed from: a, reason: collision with root package name */
        public final j f11949a;

        /* renamed from: b, reason: collision with root package name */
        public long f11950b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f11951c;

        public a(j jVar, long j10) {
            this.f11949a = jVar;
            this.f11950b = j10;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.f11951c) {
                return;
            }
            this.f11951c = true;
            j jVar = this.f11949a;
            ReentrantLock reentrantLock = jVar.f11948c;
            reentrantLock.lock();
            try {
                int i10 = jVar.f11947b - 1;
                jVar.f11947b = i10;
                if (i10 == 0 && jVar.f11946a) {
                    lb.n nVar = lb.n.f10413a;
                    reentrantLock.unlock();
                    jVar.a();
                }
            } finally {
                reentrantLock.unlock();
            }
        }

        @Override // sd.e0
        public final long read(e sink, long j10) {
            long j11;
            long j12;
            kotlin.jvm.internal.g.f(sink, "sink");
            if (this.f11951c) {
                throw new IllegalStateException("closed");
            }
            long j13 = this.f11950b;
            if (j10 < 0) {
                throw new IllegalArgumentException(com.stepos.core.ota.d.f(j10, "byteCount < 0: ").toString());
            }
            long j14 = j10 + j13;
            long j15 = j13;
            while (true) {
                if (j15 >= j14) {
                    j11 = -1;
                    break;
                }
                a0 a0VarM0 = sink.M0(1);
                j11 = -1;
                long j16 = j14;
                int iO = this.f11949a.o(j15, a0VarM0.f11901a, a0VarM0.f11903c, (int) Math.min(j14 - j15, 8192 - r10));
                if (iO == -1) {
                    if (a0VarM0.f11902b == a0VarM0.f11903c) {
                        sink.f11925a = a0VarM0.a();
                        b0.a(a0VarM0);
                    }
                    if (j13 == j15) {
                        j12 = -1;
                    }
                } else {
                    a0VarM0.f11903c += iO;
                    long j17 = iO;
                    j15 += j17;
                    sink.f11926b += j17;
                    j14 = j16;
                }
            }
            j12 = j15 - j13;
            if (j12 != j11) {
                this.f11950b += j12;
            }
            return j12;
        }

        @Override // sd.e0
        public final f0 timeout() {
            return f0.f11935d;
        }
    }

    public final a C(long j10) {
        ReentrantLock reentrantLock = this.f11948c;
        reentrantLock.lock();
        try {
            if (this.f11946a) {
                throw new IllegalStateException("closed");
            }
            this.f11947b++;
            reentrantLock.unlock();
            return new a(this, j10);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public abstract void a();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ReentrantLock reentrantLock = this.f11948c;
        reentrantLock.lock();
        try {
            if (this.f11946a) {
                return;
            }
            this.f11946a = true;
            if (this.f11947b != 0) {
                return;
            }
            lb.n nVar = lb.n.f10413a;
            reentrantLock.unlock();
            a();
        } finally {
            reentrantLock.unlock();
        }
    }

    public abstract int o(long j10, byte[] bArr, int i10, int i11);

    public final long size() {
        ReentrantLock reentrantLock = this.f11948c;
        reentrantLock.lock();
        try {
            if (this.f11946a) {
                throw new IllegalStateException("closed");
            }
            lb.n nVar = lb.n.f10413a;
            reentrantLock.unlock();
            return w();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public abstract long w();
}
