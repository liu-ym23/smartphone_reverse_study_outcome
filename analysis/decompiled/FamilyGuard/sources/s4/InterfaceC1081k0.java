package s4;

import i4.InterfaceC0772l;

/* renamed from: s4.k0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC1081k0 {

    /* renamed from: s4.k0$a */
    public static final class a implements InterfaceC1081k0 {

        /* renamed from: a, reason: collision with root package name */
        private final InterfaceC0772l<Throwable, V3.v> f20353a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(InterfaceC0772l<? super Throwable, V3.v> interfaceC0772l) {
            this.f20353a = interfaceC0772l;
        }

        @Override // s4.InterfaceC1081k0
        public void a(Throwable th) {
            this.f20353a.invoke(th);
        }

        public String toString() {
            return "InternalCompletionHandler.UserSupplied[" + M.a(this.f20353a) + '@' + M.b(this) + ']';
        }
    }

    void a(Throwable th);
}
