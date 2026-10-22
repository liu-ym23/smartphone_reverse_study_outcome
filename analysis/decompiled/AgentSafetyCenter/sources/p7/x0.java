package p7;

import java.io.IOException;
import java.util.BitSet;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class x0 extends m7.n {
    @Override // m7.n
    public final Object read(u7.a aVar) throws IOException, NumberFormatException {
        boolean zO;
        BitSet bitSet = new BitSet();
        aVar.d();
        u7.b bVarY = aVar.Y();
        int i = 0;
        while (bVarY != u7.b.f14163f) {
            int iOrdinal = bVarY.ordinal();
            if (iOrdinal == 5 || iOrdinal == 6) {
                int iQ = aVar.Q();
                if (iQ == 0) {
                    zO = false;
                } else {
                    if (iQ != 1) {
                        StringBuilder sbT = k0.a.t(iQ, "Invalid bitset value ", ", expected 0 or 1; at path ");
                        sbT.append(aVar.F());
                        throw new m7.h(sbT.toString());
                    }
                    zO = true;
                }
            } else {
                if (iOrdinal != 7) {
                    StringBuilder sb2 = new StringBuilder("Invalid bitset value type: ");
                    sb2.append(bVarY);
                    String strA = aVar.A();
                    sb2.append("; at path ");
                    sb2.append(strA);
                    throw new m7.h(sb2.toString());
                }
                zO = aVar.O();
            }
            if (zO) {
                bitSet.set(i);
            }
            i++;
            bVarY = aVar.Y();
        }
        aVar.n();
        return bitSet;
    }

    @Override // m7.n
    public final void write(u7.c cVar, Object obj) throws IOException {
        BitSet bitSet = (BitSet) obj;
        cVar.e();
        int length = bitSet.length();
        for (int i = 0; i < length; i++) {
            cVar.P(bitSet.get(i) ? 1L : 0L);
        }
        cVar.n();
    }
}
