package ob;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: classes.dex */
public final class t implements k0 {

    /* renamed from: f, reason: collision with root package name */
    public final e0 f8030f;

    /* renamed from: g, reason: collision with root package name */
    public final Inflater f8031g;

    /* renamed from: h, reason: collision with root package name */
    public int f8032h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f8033i;

    public t(e0 e0Var, Inflater inflater) {
        this.f8030f = e0Var;
        this.f8031g = inflater;
    }

    public final long a(h hVar, long j2) throws DataFormatException, IOException {
        Inflater inflater = this.f8031g;
        q7.k.e(hVar, "sink");
        if (j2 < 0) {
            throw new IllegalArgumentException(a1.a.h("byteCount < 0: ", j2).toString());
        }
        if (this.f8033i) {
            throw new IllegalStateException("closed");
        }
        if (j2 != 0) {
            try {
                f0 f0VarE = hVar.E(1);
                int iMin = (int) Math.min(j2, 8192 - f0VarE.f7977c);
                boolean zNeedsInput = inflater.needsInput();
                e0 e0Var = this.f8030f;
                if (zNeedsInput && !e0Var.a()) {
                    f0 f0Var = e0Var.f7965g.f7992f;
                    q7.k.b(f0Var);
                    int i2 = f0Var.f7977c;
                    int i10 = f0Var.f7976b;
                    int i11 = i2 - i10;
                    this.f8032h = i11;
                    inflater.setInput(f0Var.f7975a, i10, i11);
                }
                int iInflate = inflater.inflate(f0VarE.f7975a, f0VarE.f7977c, iMin);
                int i12 = this.f8032h;
                if (i12 != 0) {
                    int remaining = i12 - inflater.getRemaining();
                    this.f8032h -= remaining;
                    e0Var.skip(remaining);
                }
                if (iInflate > 0) {
                    f0VarE.f7977c += iInflate;
                    long j4 = iInflate;
                    hVar.f7993g += j4;
                    return j4;
                }
                if (f0VarE.f7976b == f0VarE.f7977c) {
                    hVar.f7992f = f0VarE.a();
                    g0.a(f0VarE);
                }
            } catch (DataFormatException e10) {
                throw new IOException(e10);
            }
        }
        return 0L;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f8033i) {
            return;
        }
        this.f8031g.end();
        this.f8033i = true;
        this.f8030f.close();
    }

    @Override // ob.k0
    public final long read(h hVar, long j2) throws DataFormatException, IOException {
        q7.k.e(hVar, "sink");
        do {
            long jA = a(hVar, j2);
            if (jA > 0) {
                return jA;
            }
            Inflater inflater = this.f8031g;
            if (inflater.finished() || inflater.needsDictionary()) {
                return -1L;
            }
        } while (!this.f8030f.a());
        throw new EOFException("source exhausted prematurely");
    }

    @Override // ob.k0
    public final m0 timeout() {
        return this.f8030f.f7964f.timeout();
    }
}
