package s6;

import kotlin.jvm.internal.p;
import n6.u;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class g {
    static {
        c7.i iVar = c7.i.d;
        t1.f.f("\"\\");
        t1.f.f("\t ,=");
    }

    public static final boolean a(u uVar) {
        if (p.a(uVar.f4146a.f4129b, "HEAD")) {
            return false;
        }
        int i8 = uVar.d;
        if (((i8 < 100 || i8 >= 200) && i8 != 204 && i8 != 304) || o6.f.e(uVar) != -1) {
            return true;
        }
        String strF = uVar.f4150f.f("Transfer-Encoding");
        if (strF == null) {
            strF = null;
        }
        return "chunked".equalsIgnoreCase(strF);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(n6.b r38, n6.m r39, n6.k r40) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 620
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s6.g.b(n6.b, n6.m, n6.k):void");
    }
}
