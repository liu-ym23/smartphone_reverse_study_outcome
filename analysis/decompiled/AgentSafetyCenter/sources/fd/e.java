package fd;

import ad.e0;
import od.l;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class e {
    static {
        l lVar = l.f9459h;
        f8.b.l("\"\\");
        f8.b.l("\t ,=");
    }

    public static final boolean a(e0 e0Var) {
        if (k.a((String) e0Var.f468c.f638c, "HEAD")) {
            return false;
        }
        int i = e0Var.f471h;
        return (((i >= 100 && i < 200) || i == 204 || i == 304) && bd.b.j(e0Var) == -1 && !"chunked".equalsIgnoreCase(e0.d(e0Var, "Transfer-Encoding"))) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(ad.b r33, ad.q r34, ad.n r35) {
        /*
            Method dump skipped, instructions count: 635
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fd.e.b(ad.b, ad.q, ad.n):void");
    }
}
