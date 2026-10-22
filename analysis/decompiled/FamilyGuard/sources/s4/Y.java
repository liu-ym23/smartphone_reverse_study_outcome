package s4;

/* loaded from: classes.dex */
final class Y implements InterfaceC1078j {

    /* renamed from: a, reason: collision with root package name */
    private final X f20327a;

    public Y(X x5) {
        this.f20327a = x5;
    }

    @Override // s4.InterfaceC1078j
    public void a(Throwable th) {
        this.f20327a.dispose();
    }

    public String toString() {
        return "DisposeOnCancel[" + this.f20327a + ']';
    }
}
