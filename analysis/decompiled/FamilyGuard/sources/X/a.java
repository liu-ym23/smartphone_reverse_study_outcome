package X;

import s4.I;
import s4.s0;

/* loaded from: classes.dex */
public final class a implements AutoCloseable, I {

    /* renamed from: a, reason: collision with root package name */
    private final Z3.i f5766a;

    public a(Z3.i iVar) {
        j4.k.g(iVar, "coroutineContext");
        this.f5766a = iVar;
    }

    @Override // s4.I
    public Z3.i G() {
        return this.f5766a;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        s0.d(G(), null, 1, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(I i5) {
        this(i5.G());
        j4.k.g(i5, "coroutineScope");
    }
}
