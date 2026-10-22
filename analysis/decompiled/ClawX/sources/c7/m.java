package c7;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class m implements v {

    /* renamed from: a, reason: collision with root package name */
    public final p f1176a;

    /* renamed from: b, reason: collision with root package name */
    public final Inflater f1177b;

    /* renamed from: c, reason: collision with root package name */
    public int f1178c;
    public boolean d;

    public m(p pVar, Inflater inflater) {
        this.f1176a = pVar;
        this.f1177b = inflater;
    }

    public final long a(long j4, f fVar) throws DataFormatException, IOException {
        Inflater inflater = this.f1177b;
        if (j4 < 0) {
            throw new IllegalArgumentException(a8.b.l(j4, "byteCount < 0: ").toString());
        }
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        if (j4 != 0) {
            try {
                q qVarT = fVar.t(1);
                int iMin = (int) Math.min(j4, 8192 - qVarT.f1189c);
                boolean zNeedsInput = inflater.needsInput();
                p pVar = this.f1176a;
                if (zNeedsInput && !pVar.q()) {
                    q qVar = pVar.f1185b.f1163a;
                    kotlin.jvm.internal.p.b(qVar);
                    int i8 = qVar.f1189c;
                    int i9 = qVar.f1188b;
                    int i10 = i8 - i9;
                    this.f1178c = i10;
                    inflater.setInput(qVar.f1187a, i9, i10);
                }
                int iInflate = inflater.inflate(qVarT.f1187a, qVarT.f1189c, iMin);
                int i11 = this.f1178c;
                if (i11 != 0) {
                    int remaining = i11 - inflater.getRemaining();
                    this.f1178c -= remaining;
                    pVar.skip(remaining);
                }
                if (iInflate > 0) {
                    qVarT.f1189c += iInflate;
                    long j8 = iInflate;
                    fVar.f1164b += j8;
                    return j8;
                }
                if (qVarT.f1188b == qVarT.f1189c) {
                    fVar.f1163a = qVarT.a();
                    r.a(qVarT);
                }
            } catch (DataFormatException e9) {
                throw new IOException(e9);
            }
        }
        return 0L;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.d) {
            return;
        }
        this.f1177b.end();
        this.d = true;
        this.f1176a.close();
    }

    @Override // c7.v, c7.t
    public final x d() {
        return this.f1176a.f1184a.d();
    }

    @Override // c7.v
    public final long h(long j4, f fVar) throws DataFormatException, IOException {
        do {
            long jA = a(8192L, fVar);
            if (jA > 0) {
                return jA;
            }
            Inflater inflater = this.f1177b;
            if (inflater.finished() || inflater.needsDictionary()) {
                return -1L;
            }
        } while (!this.f1176a.q());
        throw new EOFException("source exhausted prematurely");
    }
}
