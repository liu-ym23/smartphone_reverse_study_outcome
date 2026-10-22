package s4;

import i4.InterfaceC0772l;

/* renamed from: s4.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC1078j extends A0 {

    /* renamed from: s4.j$a */
    public static final class a implements InterfaceC1078j {

        /* renamed from: a, reason: collision with root package name */
        private final InterfaceC0772l<Throwable, V3.v> f20351a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(InterfaceC0772l<? super Throwable, V3.v> interfaceC0772l) {
            this.f20351a = interfaceC0772l;
        }

        @Override // s4.InterfaceC1078j
        public void a(Throwable th) {
            this.f20351a.invoke(th);
        }

        public String toString() {
            return "CancelHandler.UserSupplied[" + M.a(this.f20351a) + '@' + M.b(this) + ']';
        }
    }

    void a(Throwable th);
}
