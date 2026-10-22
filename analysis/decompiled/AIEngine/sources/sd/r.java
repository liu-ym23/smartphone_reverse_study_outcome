package sd;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class r implements e0 {

    /* renamed from: a, reason: collision with root package name */
    public final z f11973a;

    /* renamed from: b, reason: collision with root package name */
    public final Inflater f11974b;

    /* renamed from: c, reason: collision with root package name */
    public int f11975c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f11976d;

    public r(z zVar, Inflater inflater) {
        this.f11973a = zVar;
        this.f11974b = inflater;
    }

    public final long a(e sink, long j10) throws DataFormatException, IOException {
        Inflater inflater = this.f11974b;
        kotlin.jvm.internal.g.f(sink, "sink");
        if (j10 < 0) {
            throw new IllegalArgumentException(com.stepos.core.ota.d.f(j10, "byteCount < 0: ").toString());
        }
        if (this.f11976d) {
            throw new IllegalStateException("closed");
        }
        if (j10 != 0) {
            try {
                a0 a0VarM0 = sink.M0(1);
                int iMin = (int) Math.min(j10, 8192 - a0VarM0.f11903c);
                boolean zNeedsInput = inflater.needsInput();
                z zVar = this.f11973a;
                if (zNeedsInput && !zVar.f0()) {
                    a0 a0Var = zVar.f11987b.f11925a;
                    kotlin.jvm.internal.g.c(a0Var);
                    int i10 = a0Var.f11903c;
                    int i11 = a0Var.f11902b;
                    int i12 = i10 - i11;
                    this.f11975c = i12;
                    inflater.setInput(a0Var.f11901a, i11, i12);
                }
                int iInflate = inflater.inflate(a0VarM0.f11901a, a0VarM0.f11903c, iMin);
                int i13 = this.f11975c;
                if (i13 != 0) {
                    int remaining = i13 - inflater.getRemaining();
                    this.f11975c -= remaining;
                    zVar.skip(remaining);
                }
                if (iInflate > 0) {
                    a0VarM0.f11903c += iInflate;
                    long j11 = iInflate;
                    sink.f11926b += j11;
                    return j11;
                }
                if (a0VarM0.f11902b == a0VarM0.f11903c) {
                    sink.f11925a = a0VarM0.a();
                    b0.a(a0VarM0);
                }
            } catch (DataFormatException e10) {
                throw new IOException(e10);
            }
        }
        return 0L;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f11976d) {
            return;
        }
        this.f11974b.end();
        this.f11976d = true;
        this.f11973a.close();
    }

    @Override // sd.e0
    public final long read(e sink, long j10) throws DataFormatException, IOException {
        kotlin.jvm.internal.g.f(sink, "sink");
        do {
            long jA = a(sink, j10);
            if (jA > 0) {
                return jA;
            }
            Inflater inflater = this.f11974b;
            if (inflater.finished() || inflater.needsDictionary()) {
                return -1L;
            }
        } while (!this.f11973a.f0());
        throw new EOFException("source exhausted prematurely");
    }

    @Override // sd.e0
    public final f0 timeout() {
        return this.f11973a.f11986a.timeout();
    }
}
