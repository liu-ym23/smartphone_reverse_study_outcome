package p7;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class e1 extends m7.n {
    @Override // m7.n
    public final Object read(u7.a aVar) {
        try {
            return new AtomicInteger(aVar.Q());
        } catch (NumberFormatException e10) {
            throw new m7.h(e10);
        }
    }

    @Override // m7.n
    public final void write(u7.c cVar, Object obj) throws IOException {
        cVar.P(((AtomicInteger) obj).get());
    }
}
