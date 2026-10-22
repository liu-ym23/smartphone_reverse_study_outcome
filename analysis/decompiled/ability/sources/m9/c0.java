package m9;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes4.dex */
public interface c0 extends H7.f {
    void cancel(CancellationException cancellationException);

    Object g(ContinuationImpl continuationImpl);

    CancellationException i();

    boolean isActive();

    InterfaceC1721n k(kotlinx.coroutines.c cVar);

    InterfaceC1693K n(boolean z10, boolean z11, S7.k kVar);

    boolean r();

    boolean start();

    InterfaceC1693K w(S7.k kVar);
}
