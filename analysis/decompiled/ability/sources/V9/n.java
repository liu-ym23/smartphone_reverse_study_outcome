package V9;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: classes4.dex */
public final class n implements w {

    /* renamed from: a, reason: collision with root package name */
    public final r f1421a;
    public final Inflater b;
    public int c;
    public boolean d;

    public n(r rVar, Inflater inflater) {
        this.f1421a = rVar;
        this.b = inflater;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.d) {
            return;
        }
        this.b.end();
        this.d = true;
        this.f1421a.close();
    }

    @Override // V9.w
    public final long e(g sink, long j5) throws DataFormatException, IOException {
        long j6;
        Inflater inflater = this.b;
        kotlin.jvm.internal.k.f(sink, "sink");
        while (!this.d) {
            try {
                s sVarJ = sink.J(1);
                int iMin = (int) Math.min(8192L, 8192 - sVarJ.c);
                boolean zNeedsInput = inflater.needsInput();
                r rVar = this.f1421a;
                if (zNeedsInput && !rVar.b()) {
                    s sVar = rVar.b.f1418a;
                    kotlin.jvm.internal.k.c(sVar);
                    int i = sVar.c;
                    int i6 = sVar.b;
                    int i10 = i - i6;
                    this.c = i10;
                    inflater.setInput(sVar.f1426a, i6, i10);
                }
                int iInflate = inflater.inflate(sVarJ.f1426a, sVarJ.c, iMin);
                int i11 = this.c;
                if (i11 != 0) {
                    int remaining = i11 - inflater.getRemaining();
                    this.c -= remaining;
                    rVar.skip(remaining);
                }
                if (iInflate > 0) {
                    sVarJ.c += iInflate;
                    j6 = iInflate;
                    sink.b += j6;
                } else {
                    if (sVarJ.b == sVarJ.c) {
                        sink.f1418a = sVarJ.a();
                        t.a(sVarJ);
                    }
                    j6 = 0;
                }
                if (j6 > 0) {
                    return j6;
                }
                if (inflater.finished() || inflater.needsDictionary()) {
                    return -1L;
                }
                if (rVar.b()) {
                    throw new EOFException("source exhausted prematurely");
                }
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        }
        throw new IllegalStateException("closed");
    }

    @Override // V9.w
    public final y timeout() {
        return this.f1421a.f1425a.timeout();
    }
}
