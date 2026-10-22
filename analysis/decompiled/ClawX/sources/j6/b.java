package j6;

import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.p;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b implements d {

    /* renamed from: a, reason: collision with root package name */
    public final InputStream f3513a;

    public b(InputStream input) {
        p.e(input, "input");
        this.f3513a = input;
    }

    @Override // java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f3513a.close();
    }

    @Override // j6.d
    public final long m(a aVar, long j4) throws IOException {
        if (j4 == 0) {
            return 0L;
        }
        if (j4 < 0) {
            throw new IllegalArgumentException(("byteCount (" + j4 + ") < 0").toString());
        }
        boolean z = false;
        try {
            g gVarN = aVar.n(1);
            long j8 = this.f3513a.read(gVarN.f3524a, gVarN.f3526c, (int) Math.min(j4, r4.length - r5));
            int i8 = j8 == -1 ? 0 : (int) j8;
            if (i8 == 1) {
                gVarN.f3526c += i8;
                aVar.f3512c += i8;
                return j8;
            }
            if (i8 < 0 || i8 > gVarN.a()) {
                throw new IllegalStateException(("Invalid number of bytes written: " + i8 + ". Should be in 0.." + gVarN.a()).toString());
            }
            if (i8 != 0) {
                gVarN.f3526c += i8;
                aVar.f3512c += i8;
                return j8;
            }
            if (gVarN.b() == 0) {
                g gVar = aVar.f3511b;
                p.b(gVar);
                g gVar2 = gVar.f3529g;
                aVar.f3511b = gVar2;
                if (gVar2 == null) {
                    aVar.f3510a = null;
                } else {
                    gVar2.f3528f = null;
                }
                gVar.f3529g = null;
                h.a(gVar);
            }
            return j8;
        } catch (AssertionError e9) {
            if (e9.getCause() != null) {
                String message = e9.getMessage();
                if (message != null ? n.g1(message, "getsockname failed", false) : false) {
                    z = true;
                }
            }
            if (z) {
                throw new IOException(e9);
            }
            throw e9;
        }
    }

    public final String toString() {
        return "RawSource(" + this.f3513a + ')';
    }
}
