package p7;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class f1 extends m7.n {
    @Override // m7.n
    public final Object read(u7.a aVar) {
        return new AtomicBoolean(aVar.O());
    }

    @Override // m7.n
    public final void write(u7.c cVar, Object obj) {
        cVar.T(((AtomicBoolean) obj).get());
    }
}
