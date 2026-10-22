package kc;

import java.util.concurrent.CancellationException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface x0 extends nb.e {
    j A(e1 e1Var);

    g0 H(boolean z10, boolean z11, androidx.room.d dVar);

    boolean d();

    void e(CancellationException cancellationException);

    g0 g(xb.l lVar);

    Object i(pb.c cVar);

    boolean isCancelled();

    CancellationException o();

    boolean start();
}
