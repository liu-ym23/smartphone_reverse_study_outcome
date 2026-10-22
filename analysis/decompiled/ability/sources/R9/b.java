package R9;

import D7.N;
import V9.g;
import V9.i;
import V9.p;
import java.io.EOFException;
import kotlin.jvm.internal.k;
import okio.ByteString;
import org.json.HTTP;
import s2.C1912a;

/* loaded from: classes4.dex */
public final class b {
    public static final p d;
    public static final ByteString e;

    /* renamed from: a, reason: collision with root package name */
    public String f1161a;
    public final i b;
    public final a c;

    static {
        ByteString byteString = ByteString.d;
        d = N.I(C1912a.i(HTTP.CRLF), C1912a.i("\r"), C1912a.i("\n"), C1912a.i("data: "), C1912a.i("data:"), C1912a.i("data\r\n"), C1912a.i("data\r"), C1912a.i("data\n"), C1912a.i("id: "), C1912a.i("id:"), C1912a.i("id\r\n"), C1912a.i("id\r"), C1912a.i("id\n"), C1912a.i("event: "), C1912a.i("event:"), C1912a.i("event\r\n"), C1912a.i("event\r"), C1912a.i("event\n"), C1912a.i("retry: "), C1912a.i("retry:"));
        e = C1912a.i(HTTP.CRLF);
    }

    public b(i source, a aVar) {
        k.f(source, "source");
        this.b = source;
        this.c = aVar;
    }

    public final boolean a() throws NumberFormatException, EOFException {
        String strQ = this.f1161a;
        g gVar = new g();
        while (true) {
            String strQ2 = null;
            while (true) {
                i iVar = this.b;
                p pVar = d;
                int iZ = iVar.z(pVar);
                if (iZ >= 0 && 2 >= iZ) {
                    if (gVar.b == 0) {
                        return true;
                    }
                    this.f1161a = strQ;
                    gVar.skip(1L);
                    String strG = gVar.G();
                    a aVar = this.c;
                    aVar.c.onEvent(aVar, strQ, strQ2, strG);
                    return true;
                }
                ByteString byteString = e;
                if (3 <= iZ && 4 >= iZ) {
                    gVar.L(10);
                    iVar.p(gVar, iVar.h(byteString));
                    iVar.z(pVar);
                } else if (5 <= iZ && 7 >= iZ) {
                    gVar.L(10);
                } else if (8 <= iZ && 9 >= iZ) {
                    strQ = iVar.q();
                    if (strQ.length() <= 0) {
                        strQ = null;
                    }
                } else if (10 <= iZ && 12 >= iZ) {
                    strQ = null;
                } else if (13 <= iZ && 14 >= iZ) {
                    strQ2 = iVar.q();
                    if (strQ2.length() > 0) {
                    }
                } else {
                    if (15 <= iZ && 17 >= iZ) {
                        break;
                    }
                    if (18 <= iZ && 19 >= iZ) {
                        String strQ3 = iVar.q();
                        byte[] bArr = G9.b.f704a;
                        try {
                            Long.parseLong(strQ3);
                        } catch (NumberFormatException unused) {
                        }
                    } else {
                        if (iZ != -1) {
                            throw new AssertionError();
                        }
                        long jH = iVar.h(byteString);
                        if (jH == -1) {
                            return false;
                        }
                        iVar.skip(jH);
                        iVar.z(pVar);
                    }
                }
            }
        }
    }
}
