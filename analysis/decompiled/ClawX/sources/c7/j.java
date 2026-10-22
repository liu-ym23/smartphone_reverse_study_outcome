package c7;

import java.io.IOException;
import java.util.zip.Deflater;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j implements t {

    /* renamed from: a, reason: collision with root package name */
    public final o f1168a;

    /* renamed from: b, reason: collision with root package name */
    public final Deflater f1169b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1170c;

    public j(f fVar, Deflater deflater) {
        this.f1168a = new o(fVar);
        this.f1169b = deflater;
    }

    public final void a(boolean z) throws IOException {
        q qVarT;
        int iDeflate;
        o oVar = this.f1168a;
        f fVar = oVar.f1182b;
        while (true) {
            qVarT = fVar.t(1);
            byte[] bArr = qVarT.f1187a;
            Deflater deflater = this.f1169b;
            if (z) {
                try {
                    int i8 = qVarT.f1189c;
                    iDeflate = deflater.deflate(bArr, i8, 8192 - i8, 2);
                } catch (NullPointerException e9) {
                    throw new IOException("Deflater already closed", e9);
                }
            } else {
                int i9 = qVarT.f1189c;
                iDeflate = deflater.deflate(bArr, i9, 8192 - i9);
            }
            if (iDeflate > 0) {
                qVarT.f1189c += iDeflate;
                fVar.f1164b += iDeflate;
                oVar.a();
            } else if (deflater.needsInput()) {
                break;
            }
        }
        if (qVarT.f1188b == qVarT.f1189c) {
            fVar.f1163a = qVarT.a();
            r.a(qVarT);
        }
    }

    @Override // c7.t, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() throws Throwable {
        Deflater deflater = this.f1169b;
        if (this.f1170c) {
            return;
        }
        try {
            deflater.finish();
            a(false);
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            deflater.end();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        try {
            this.f1168a.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f1170c = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // c7.t
    public final x d() {
        return this.f1168a.f1181a.d();
    }

    @Override // c7.t, java.io.Flushable
    public final void flush() throws IOException {
        a(true);
        this.f1168a.flush();
    }

    public final String toString() {
        return "DeflaterSink(" + this.f1168a + ')';
    }

    @Override // c7.t
    public final void x(long j4, f fVar) throws IOException {
        b.d(fVar.f1164b, 0L, j4);
        while (true) {
            Deflater deflater = this.f1169b;
            if (j4 <= 0) {
                deflater.setInput(d7.b.f1927b, 0, 0);
                return;
            }
            q qVar = fVar.f1163a;
            kotlin.jvm.internal.p.b(qVar);
            int iMin = (int) Math.min(j4, qVar.f1189c - qVar.f1188b);
            deflater.setInput(qVar.f1187a, qVar.f1188b, iMin);
            a(false);
            long j8 = iMin;
            fVar.f1164b -= j8;
            int i8 = qVar.f1188b + iMin;
            qVar.f1188b = i8;
            if (i8 == qVar.f1189c) {
                fVar.f1163a = qVar.a();
                r.a(qVar);
            }
            j4 -= j8;
        }
    }
}
