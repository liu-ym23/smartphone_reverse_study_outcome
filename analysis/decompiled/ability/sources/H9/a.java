package H9;

import F9.L;
import F9.M;

/* loaded from: classes4.dex */
public final class a {
    public static final M a(M m) {
        if ((m != null ? m.g : null) == null) {
            return m;
        }
        L lF = m.f();
        lF.g = null;
        return lF.a();
    }

    public static boolean b(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }
}
