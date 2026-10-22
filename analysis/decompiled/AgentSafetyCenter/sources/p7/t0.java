package p7;

import java.util.Currency;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class t0 extends m7.n {
    @Override // m7.n
    public final Object read(u7.a aVar) {
        String strW = aVar.W();
        try {
            return Currency.getInstance(strW);
        } catch (IllegalArgumentException e10) {
            StringBuilder sbO = androidx.activity.b.o("Failed parsing '", strW, "' as Currency; at path ");
            sbO.append(aVar.F());
            throw new m7.h(sbO.toString(), e10);
        }
    }

    @Override // m7.n
    public final void write(u7.c cVar, Object obj) {
        cVar.S(((Currency) obj).getCurrencyCode());
    }
}
