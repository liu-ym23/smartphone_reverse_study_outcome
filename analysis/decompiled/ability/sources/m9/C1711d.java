package m9;

/* renamed from: m9.d, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1711d implements InterfaceC1716i {

    /* renamed from: a, reason: collision with root package name */
    public final C1710c[] f5326a;

    public C1711d(C1710c[] c1710cArr) {
        this.f5326a = c1710cArr;
    }

    public final void a() {
        for (C1710c c1710c : this.f5326a) {
            InterfaceC1693K interfaceC1693K = c1710c.f;
            if (interfaceC1693K == null) {
                kotlin.jvm.internal.k.n("handle");
                throw null;
            }
            interfaceC1693K.dispose();
        }
    }

    @Override // m9.InterfaceC1716i
    public final void b(Throwable th) {
        a();
    }

    public final String toString() {
        return "DisposeHandlersOnCancel[" + this.f5326a + ']';
    }
}
