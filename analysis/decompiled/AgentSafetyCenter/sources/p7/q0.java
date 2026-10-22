package p7;

import java.net.URI;
import java.net.URISyntaxException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class q0 extends m7.n {
    @Override // m7.n
    public final Object read(u7.a aVar) {
        if (aVar.Y() == u7.b.f14169m) {
            aVar.U();
            return null;
        }
        try {
            String strW = aVar.W();
            if (strW.equals("null")) {
                return null;
            }
            return new URI(strW);
        } catch (URISyntaxException e10) {
            throw new m7.h(e10);
        }
    }

    @Override // m7.n
    public final void write(u7.c cVar, Object obj) {
        URI uri = (URI) obj;
        cVar.S(uri == null ? null : uri.toASCIIString());
    }
}
