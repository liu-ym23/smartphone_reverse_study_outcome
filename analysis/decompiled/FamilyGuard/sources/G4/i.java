package G4;

import C4.D;
import C4.w;
import java.net.Proxy;

/* loaded from: classes.dex */
public final class i {
    public static String a(D d6, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(d6.f());
        sb.append(' ');
        if (b(d6, type)) {
            sb.append(d6.i());
        } else {
            sb.append(c(d6.i()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean b(D d6, Proxy.Type type) {
        return !d6.e() && type == Proxy.Type.HTTP;
    }

    public static String c(w wVar) {
        String strH = wVar.h();
        String strJ = wVar.j();
        if (strJ == null) {
            return strH;
        }
        return strH + '?' + strJ;
    }
}
