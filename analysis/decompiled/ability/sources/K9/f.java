package K9;

import F9.M;
import kotlin.jvm.internal.k;
import okio.ByteString;
import s2.C1912a;

/* loaded from: classes4.dex */
public abstract class f {
    static {
        ByteString byteString = ByteString.d;
        C1912a.i("\"\\");
        C1912a.i("\t ,=");
    }

    public static final boolean a(M m) {
        if (k.b(m.f631a.b, "HEAD")) {
            return false;
        }
        int i = m.d;
        return (((i >= 100 && i < 200) || i == 204 || i == 304) && G9.b.i(m) == -1 && !"chunked".equalsIgnoreCase(M.b(m, "Transfer-Encoding"))) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(F9.C0237o r34, F9.y r35, F9.w r36) {
        /*
            Method dump skipped, instructions count: 584
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: K9.f.b(F9.o, F9.y, F9.w):void");
    }
}
