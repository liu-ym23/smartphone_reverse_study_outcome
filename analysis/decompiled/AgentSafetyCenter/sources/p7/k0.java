package p7;

import java.math.BigInteger;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class k0 extends m7.n {
    @Override // m7.n
    public final Object read(u7.a aVar) {
        if (aVar.Y() == u7.b.f14169m) {
            aVar.U();
            return null;
        }
        String strW = aVar.W();
        try {
            o7.h.c(strW);
            return new BigInteger(strW);
        } catch (NumberFormatException e10) {
            StringBuilder sbO = androidx.activity.b.o("Failed parsing '", strW, "' as BigInteger; at path ");
            sbO.append(aVar.F());
            throw new m7.h(sbO.toString(), e10);
        }
    }

    @Override // m7.n
    public final void write(u7.c cVar, Object obj) {
        cVar.R((BigInteger) obj);
    }
}
