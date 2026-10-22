package V9;

import E9.InterfaceC0797b;
import pa.C5079c;

/* loaded from: classes5.dex */
public final class o implements n {

    /* renamed from: a, reason: collision with root package name */
    public C5079c f6550a;

    @Override // V9.n
    public InterfaceC0797b a(Z9.g javaClass) {
        kotlin.jvm.internal.p.i(javaClass, "javaClass");
        return b().b(javaClass);
    }

    public final C5079c b() {
        C5079c c5079c = this.f6550a;
        if (c5079c != null) {
            return c5079c;
        }
        kotlin.jvm.internal.p.A("resolver");
        return null;
    }

    public final void c(C5079c c5079c) {
        kotlin.jvm.internal.p.i(c5079c, "<set-?>");
        this.f6550a = c5079c;
    }
}
