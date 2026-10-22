package j6;

import java.io.EOFException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e implements j {

    /* renamed from: a, reason: collision with root package name */
    public final c f3519a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3520b;

    /* renamed from: c, reason: collision with root package name */
    public final a f3521c = new a();

    public e(c cVar) {
        this.f3519a = cVar;
    }

    @Override // j6.j
    public final a c() {
        return this.f3521c;
    }

    @Override // java.lang.AutoCloseable
    public final void close() throws EOFException {
        if (this.f3520b) {
            return;
        }
        this.f3520b = true;
        this.f3519a.f3517e = true;
        a aVar = this.f3521c;
        aVar.skip(aVar.f3512c);
    }

    @Override // j6.j
    public final void f(long j4) throws EOFException {
        if (k(j4)) {
            return;
        }
        throw new EOFException("Source doesn't contain required number of bytes (" + j4 + ").");
    }

    @Override // j6.j
    public final boolean k(long j4) {
        a aVar;
        if (this.f3520b) {
            throw new IllegalStateException("Source is closed.");
        }
        if (j4 < 0) {
            throw new IllegalArgumentException(a8.b.l(j4, "byteCount: ").toString());
        }
        do {
            aVar = this.f3521c;
            if (aVar.f3512c >= j4) {
                return true;
            }
        } while (this.f3519a.m(aVar, 8192L) != -1);
        return false;
    }

    @Override // j6.d
    public final long m(a aVar, long j4) {
        if (this.f3520b) {
            throw new IllegalStateException("Source is closed.");
        }
        if (j4 < 0) {
            throw new IllegalArgumentException(a8.b.l(j4, "byteCount: ").toString());
        }
        a aVar2 = this.f3521c;
        if (aVar2.f3512c == 0 && this.f3519a.m(aVar2, 8192L) == -1) {
            return -1L;
        }
        return aVar2.m(aVar, Math.min(j4, aVar2.f3512c));
    }

    @Override // j6.j
    public final e peek() {
        if (this.f3520b) {
            throw new IllegalStateException("Source is closed.");
        }
        return new e(new c(this));
    }

    @Override // j6.j
    public final boolean q() {
        if (this.f3520b) {
            throw new IllegalStateException("Source is closed.");
        }
        a aVar = this.f3521c;
        return aVar.q() && this.f3519a.m(aVar, 8192L) == -1;
    }

    public final String toString() {
        return "buffered(" + this.f3519a + ')';
    }
}
