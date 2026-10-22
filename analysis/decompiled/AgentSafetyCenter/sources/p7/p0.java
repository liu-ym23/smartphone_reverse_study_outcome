package p7;

import java.net.URL;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class p0 extends m7.n {
    @Override // m7.n
    public final Object read(u7.a aVar) {
        if (aVar.Y() == u7.b.f14169m) {
            aVar.U();
            return null;
        }
        String strW = aVar.W();
        if (strW.equals("null")) {
            return null;
        }
        return new URL(strW);
    }

    @Override // m7.n
    public final void write(u7.c cVar, Object obj) {
        URL url = (URL) obj;
        cVar.S(url == null ? null : url.toExternalForm());
    }
}
