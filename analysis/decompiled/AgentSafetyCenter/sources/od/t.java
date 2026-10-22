package od;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t implements i0 {

    /* renamed from: c, reason: collision with root package name */
    public final c0 f9486c;

    /* renamed from: f, reason: collision with root package name */
    public final Inflater f9487f;

    /* renamed from: g, reason: collision with root package name */
    public int f9488g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f9489h;

    public t(c0 c0Var, Inflater inflater) {
        this.f9486c = c0Var;
        this.f9487f = inflater;
    }

    @Override // od.i0
    public final k0 b() {
        return this.f9486c.f9427c.b();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f9489h) {
            return;
        }
        this.f9487f.end();
        this.f9489h = true;
        this.f9486c.close();
    }

    @Override // od.i0
    public final long l(i iVar, long j10) throws DataFormatException, IOException {
        long j11;
        iVar.getClass();
        while (j10 >= 0) {
            if (this.f9489h) {
                f.e("closed");
                return 0L;
            }
            c0 c0Var = this.f9486c;
            Inflater inflater = this.f9487f;
            if (j10 == 0) {
                j11 = 0;
            } else {
                try {
                    d0 d0VarY = iVar.Y(1);
                    int iMin = (int) Math.min(j10, 8192 - d0VarY.f9439c);
                    if (inflater.needsInput() && !c0Var.d()) {
                        d0 d0Var = c0Var.f9428f.f9453c;
                        d0Var.getClass();
                        int i = d0Var.f9439c;
                        int i3 = d0Var.f9438b;
                        int i10 = i - i3;
                        this.f9488g = i10;
                        inflater.setInput(d0Var.f9437a, i3, i10);
                    }
                    int iInflate = inflater.inflate(d0VarY.f9437a, d0VarY.f9439c, iMin);
                    int i11 = this.f9488g;
                    if (i11 != 0) {
                        int remaining = i11 - inflater.getRemaining();
                        this.f9488g -= remaining;
                        c0Var.M(remaining);
                    }
                    if (iInflate > 0) {
                        d0VarY.f9439c += iInflate;
                        j11 = iInflate;
                        iVar.f9454f += j11;
                    } else {
                        if (d0VarY.f9438b == d0VarY.f9439c) {
                            iVar.f9453c = d0VarY.a();
                            e0.a(d0VarY);
                        }
                        j11 = 0;
                    }
                } catch (DataFormatException e10) {
                    throw new IOException(e10);
                }
            }
            if (j11 > 0) {
                return j11;
            }
            if (inflater.finished() || inflater.needsDictionary()) {
                return -1L;
            }
            if (c0Var.d()) {
                throw new EOFException("source exhausted prematurely");
            }
        }
        f.c(k0.a.m("byteCount < 0: ", j10));
        return 0L;
    }
}
