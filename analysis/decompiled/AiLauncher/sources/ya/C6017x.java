package ya;

import E9.InterfaceC0799d;
import za.C6459e;
import za.C6466l;
import za.InterfaceC6465k;

/* renamed from: ya.x, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6017x extends AbstractC6019z implements InterfaceC6015v, Ca.c {

    /* renamed from: d, reason: collision with root package name */
    public static final a f44134d = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC5990d0 f44135b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f44136c;

    /* renamed from: ya.x$a */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static /* synthetic */ C6017x c(a aVar, K0 k02, boolean z10, boolean z11, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                z10 = false;
            }
            if ((i10 & 4) != 0) {
                z11 = false;
            }
            return aVar.b(k02, z10, z11);
        }

        public final boolean a(K0 k02) {
            return (k02.H0() instanceof InterfaceC6465k) || (k02.H0().d() instanceof E9.b0) || (k02 instanceof C6459e) || (k02 instanceof m0);
        }

        public final C6017x b(K0 type, boolean z10, boolean z11) {
            kotlin.jvm.internal.p.i(type, "type");
            if (type instanceof C6017x) {
                return (C6017x) type;
            }
            kotlin.jvm.internal.i iVar = null;
            if (!z11 && !d(type, z10)) {
                return null;
            }
            if (type instanceof AbstractC5974I) {
                AbstractC5974I abstractC5974I = (AbstractC5974I) type;
                kotlin.jvm.internal.p.d(abstractC5974I.P0().H0(), abstractC5974I.Q0().H0());
            }
            return new C6017x(C5977L.c(type).L0(false), z10, iVar);
        }

        public final boolean d(K0 k02, boolean z10) {
            if (!a(k02)) {
                return false;
            }
            if (k02 instanceof m0) {
                return H0.l(k02);
            }
            InterfaceC0799d interfaceC0799dD = k02.H0().d();
            H9.U u10 = interfaceC0799dD instanceof H9.U ? (H9.U) interfaceC0799dD : null;
            if (u10 == null || u10.N0()) {
                return (z10 && (k02.H0().d() instanceof E9.b0)) ? H0.l(k02) : !C6466l.f45420a.a(k02);
            }
            return true;
        }

        public a() {
        }
    }

    public /* synthetic */ C6017x(AbstractC5990d0 abstractC5990d0, boolean z10, kotlin.jvm.internal.i iVar) {
        this(abstractC5990d0, z10);
    }

    @Override // ya.AbstractC6019z, ya.S
    public boolean I0() {
        return false;
    }

    @Override // ya.K0
    /* renamed from: O0 */
    public AbstractC5990d0 L0(boolean z10) {
        return z10 ? Q0().L0(z10) : this;
    }

    @Override // ya.K0
    /* renamed from: P0 */
    public AbstractC5990d0 N0(s0 newAttributes) {
        kotlin.jvm.internal.p.i(newAttributes, "newAttributes");
        return new C6017x(Q0().N0(newAttributes), this.f44136c);
    }

    @Override // ya.AbstractC6019z
    public AbstractC5990d0 Q0() {
        return this.f44135b;
    }

    @Override // ya.InterfaceC6015v
    public S T(S replacement) {
        kotlin.jvm.internal.p.i(replacement, "replacement");
        return C5998h0.e(replacement.K0(), this.f44136c);
    }

    public final AbstractC5990d0 T0() {
        return this.f44135b;
    }

    @Override // ya.AbstractC6019z
    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public C6017x S0(AbstractC5990d0 delegate) {
        kotlin.jvm.internal.p.i(delegate, "delegate");
        return new C6017x(delegate, this.f44136c);
    }

    @Override // ya.AbstractC5990d0
    public String toString() {
        return Q0() + " & Any";
    }

    @Override // ya.InterfaceC6015v
    public boolean y0() {
        return (Q0().H0() instanceof InterfaceC6465k) || (Q0().H0().d() instanceof E9.b0);
    }

    public C6017x(AbstractC5990d0 abstractC5990d0, boolean z10) {
        this.f44135b = abstractC5990d0;
        this.f44136c = z10;
    }
}
