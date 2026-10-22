package W9;

import V9.g;
import j9.AbstractC1607a;
import java.io.EOFException;
import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f1496a;

    static {
        byte[] bytes = "0123456789abcdef".getBytes(AbstractC1607a.f4778a);
        k.e(bytes, "this as java.lang.String).getBytes(charset)");
        f1496a = bytes;
    }

    public static final String a(g gVar, long j5) throws EOFException {
        if (j5 > 0) {
            long j6 = j5 - 1;
            if (gVar.r(j6) == 13) {
                String strF = gVar.F(j6, AbstractC1607a.f4778a);
                gVar.skip(2L);
                return strF;
            }
        }
        String strF2 = gVar.F(j5, AbstractC1607a.f4778a);
        gVar.skip(1L);
        return strF2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x005c, code lost:
    
        if (r18 == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005e, code lost:
    
        return -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007e, code lost:
    
        return r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int b(V9.g r16, V9.p r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 173
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: W9.a.b(V9.g, V9.p, boolean):int");
    }
}
