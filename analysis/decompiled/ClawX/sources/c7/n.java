package c7;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class n implements v {

    /* renamed from: a, reason: collision with root package name */
    public final InputStream f1179a;

    /* renamed from: b, reason: collision with root package name */
    public final x f1180b;

    public n(InputStream inputStream, x xVar) {
        this.f1179a = inputStream;
        this.f1180b = xVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f1179a.close();
    }

    @Override // c7.v, c7.t
    public final x d() {
        return this.f1180b;
    }

    @Override // c7.v
    public final long h(long j4, f fVar) throws IOException {
        try {
            this.f1180b.f();
            q qVarT = fVar.t(1);
            int i8 = this.f1179a.read(qVarT.f1187a, qVarT.f1189c, (int) Math.min(8192L, 8192 - qVarT.f1189c));
            if (i8 != -1) {
                qVarT.f1189c += i8;
                long j8 = i8;
                fVar.f1164b += j8;
                return j8;
            }
            if (qVarT.f1188b != qVarT.f1189c) {
                return -1L;
            }
            fVar.f1163a = qVarT.a();
            r.a(qVarT);
            return -1L;
        } catch (AssertionError e9) {
            if (d7.f.a(e9)) {
                throw new IOException(e9);
            }
            throw e9;
        }
    }

    public final String toString() {
        return "source(" + this.f1179a + ')';
    }
}
