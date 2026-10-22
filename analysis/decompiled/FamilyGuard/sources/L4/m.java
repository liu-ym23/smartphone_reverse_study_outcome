package L4;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: classes.dex */
public final class m implements y {

    /* renamed from: a, reason: collision with root package name */
    private int f3955a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f3956b;

    /* renamed from: c, reason: collision with root package name */
    private final g f3957c;

    /* renamed from: d, reason: collision with root package name */
    private final Inflater f3958d;

    public m(g gVar, Inflater inflater) {
        j4.k.h(gVar, "source");
        j4.k.h(inflater, "inflater");
        this.f3957c = gVar;
        this.f3958d = inflater;
    }

    private final void c() {
        int i5 = this.f3955a;
        if (i5 == 0) {
            return;
        }
        int remaining = i5 - this.f3958d.getRemaining();
        this.f3955a -= remaining;
        this.f3957c.skip(remaining);
    }

    public final boolean a() {
        if (!this.f3958d.needsInput()) {
            return false;
        }
        c();
        if (this.f3958d.getRemaining() != 0) {
            throw new IllegalStateException("?");
        }
        if (this.f3957c.t()) {
            return true;
        }
        t tVar = this.f3957c.s().f3938a;
        if (tVar == null) {
            j4.k.p();
        }
        int i5 = tVar.f3976c;
        int i6 = tVar.f3975b;
        int i7 = i5 - i6;
        this.f3955a = i7;
        this.f3958d.setInput(tVar.f3974a, i6, i7);
        return false;
    }

    @Override // L4.y
    public z b() {
        return this.f3957c.b();
    }

    @Override // L4.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f3956b) {
            return;
        }
        this.f3958d.end();
        this.f3956b = true;
        this.f3957c.close();
    }

    @Override // L4.y
    public long e(e eVar, long j5) throws DataFormatException, IOException {
        boolean zA;
        j4.k.h(eVar, "sink");
        if (j5 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j5).toString());
        }
        if (this.f3956b) {
            throw new IllegalStateException("closed");
        }
        if (j5 == 0) {
            return 0L;
        }
        do {
            zA = a();
            try {
                t tVarC0 = eVar.c0(1);
                int iInflate = this.f3958d.inflate(tVarC0.f3974a, tVarC0.f3976c, (int) Math.min(j5, 8192 - tVarC0.f3976c));
                if (iInflate > 0) {
                    tVarC0.f3976c += iInflate;
                    long j6 = iInflate;
                    eVar.W(eVar.size() + j6);
                    return j6;
                }
                if (!this.f3958d.finished() && !this.f3958d.needsDictionary()) {
                }
                c();
                if (tVarC0.f3975b != tVarC0.f3976c) {
                    return -1L;
                }
                eVar.f3938a = tVarC0.b();
                u.a(tVarC0);
                return -1L;
            } catch (DataFormatException e6) {
                throw new IOException(e6);
            }
        } while (!zA);
        throw new EOFException("source exhausted prematurely");
    }
}
