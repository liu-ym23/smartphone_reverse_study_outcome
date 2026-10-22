package p7;

import java.io.IOException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class c1 extends m7.n {
    @Override // m7.n
    public final Object read(u7.a aVar) throws IOException {
        if (aVar.Y() == u7.b.f14169m) {
            aVar.U();
            return null;
        }
        try {
            int iQ = aVar.Q();
            if (iQ <= 65535 && iQ >= -32768) {
                return Short.valueOf((short) iQ);
            }
            StringBuilder sbT = k0.a.t(iQ, "Lossy conversion from ", " to short; at path ");
            sbT.append(aVar.F());
            throw new m7.h(sbT.toString());
        } catch (NumberFormatException e10) {
            throw new m7.h(e10);
        }
    }

    @Override // m7.n
    public final void write(u7.c cVar, Object obj) throws IOException {
        if (((Number) obj) == null) {
            cVar.C();
        } else {
            cVar.P(r4.shortValue());
        }
    }
}
