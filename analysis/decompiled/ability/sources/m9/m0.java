package m9;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes4.dex */
public final class m0 extends H7.a implements c0 {

    /* renamed from: a, reason: collision with root package name */
    public static final m0 f5330a = new m0(b0.f5325a);

    @Override // m9.c0
    public final void cancel(CancellationException cancellationException) {
    }

    @Override // m9.c0
    public final Object g(ContinuationImpl continuationImpl) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // m9.c0
    public final CancellationException i() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // m9.c0
    public final boolean isActive() {
        return true;
    }

    @Override // m9.c0
    public final InterfaceC1721n k(kotlinx.coroutines.c cVar) {
        return n0.f5331a;
    }

    @Override // m9.c0
    public final InterfaceC1693K n(boolean z10, boolean z11, S7.k kVar) {
        return n0.f5331a;
    }

    @Override // m9.c0
    public final boolean r() {
        return false;
    }

    @Override // m9.c0
    public final boolean start() {
        return false;
    }

    public final String toString() {
        return "NonCancellable";
    }

    @Override // m9.c0
    public final InterfaceC1693K w(S7.k kVar) {
        return n0.f5331a;
    }
}
