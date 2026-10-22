package kotlinx.coroutines;

import kotlin.Unit;

/* JADX INFO: loaded from: classes4.dex */
public final class u1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineDispatcher f21760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CancellableContinuation f21761b;

    public u1(CoroutineDispatcher r10, CancellableContinuation r11) {
        this.f21760a = r10;
        this.f21761b = r11;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f21761b.resumeUndispatched(this.f21760a, Unit.f21064a);
    }
}
