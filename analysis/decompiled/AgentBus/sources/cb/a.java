package cb;

import ab.y;
import ab.z;

/* loaded from: classes.dex */
public final class a {
    public static final z a(z zVar) {
        if ((zVar != null ? zVar.f690l : null) == null) {
            return zVar;
        }
        y yVarD = zVar.d();
        yVarD.f677g = null;
        return yVarD.a();
    }

    public static boolean b(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }
}
