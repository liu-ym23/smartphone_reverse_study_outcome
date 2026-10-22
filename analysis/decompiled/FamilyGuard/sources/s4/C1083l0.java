package s4;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: s4.l0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C1083l0 extends p0 {

    /* renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f20359f = AtomicIntegerFieldUpdater.newUpdater(C1083l0.class, "_invoked$volatile");
    private volatile /* synthetic */ int _invoked$volatile;

    /* renamed from: e, reason: collision with root package name */
    private final InterfaceC1081k0 f20360e;

    public C1083l0(InterfaceC1081k0 interfaceC1081k0) {
        this.f20360e = interfaceC1081k0;
    }

    @Override // s4.InterfaceC1081k0
    public void a(Throwable th) {
        if (f20359f.compareAndSet(this, 0, 1)) {
            this.f20360e.a(th);
        }
    }
}
