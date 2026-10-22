package p7;

import java.io.IOException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class e0 extends m7.n {
    @Override // m7.n
    public final Object read(u7.a aVar) {
        if (aVar.Y() == u7.b.f14169m) {
            aVar.U();
            return null;
        }
        try {
            return Long.valueOf(aVar.R());
        } catch (NumberFormatException e10) {
            throw new m7.h(e10);
        }
    }

    @Override // m7.n
    public final void write(u7.c cVar, Object obj) throws IOException {
        Number number = (Number) obj;
        if (number == null) {
            cVar.C();
        } else {
            cVar.P(number.longValue());
        }
    }
}
