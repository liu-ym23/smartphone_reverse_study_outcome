package rc;

import java.io.InputStream;
import java.util.BitSet;
import java.util.Map;
import org.scilab.forge.jlatexmath.SymbolMappingNotFoundException;
import org.scilab.forge.jlatexmath.SymbolNotFoundException;

/* loaded from: classes5.dex */
public class W0 extends AbstractC5300p {

    /* renamed from: h, reason: collision with root package name */
    public static Map<String, W0> f39172h = new e1().b();

    /* renamed from: i, reason: collision with root package name */
    public static BitSet f39173i;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f39174e;

    /* renamed from: f, reason: collision with root package name */
    public final String f39175f;

    /* renamed from: g, reason: collision with root package name */
    public char f39176g;

    static {
        BitSet bitSet = new BitSet(16);
        f39173i = bitSet;
        bitSet.set(0);
        f39173i.set(1);
        f39173i.set(2);
        f39173i.set(3);
        f39173i.set(4);
        f39173i.set(5);
        f39173i.set(6);
        f39173i.set(10);
    }

    public W0(String str, int i10, boolean z10) {
        this.f39175f = str;
        this.f39248a = i10;
        if (i10 == 1) {
            this.f39249b = 0;
        }
        this.f39174e = z10;
    }

    public static void o(InputStream inputStream, String str) {
        f39172h.putAll(new e1(inputStream, str).b());
    }

    public static W0 p(String str) throws SymbolNotFoundException {
        W0 w02 = f39172h.get(str);
        if (w02 != null) {
            return w02;
        }
        throw new SymbolNotFoundException(str);
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) throws SymbolMappingNotFoundException {
        char c10;
        Z0 z0N = y02.n();
        int iM = y02.m();
        C5292l c5292lJ = z0N.j(this.f39175f, iM);
        AbstractC5284h c5296n = new C5296n(c5292lJ);
        if (y02.k() && (c10 = this.f39176g) != 0 && Character.isLowerCase(c10)) {
            try {
                c5296n = new L0(new C5296n(z0N.j(a1.f39206l[Character.toUpperCase(this.f39176g)], iM)), 0.8d, 0.8d);
            } catch (SymbolMappingNotFoundException unused) {
            }
        }
        if (this.f39248a != 1) {
            return c5296n;
        }
        if (iM < 2 && z0N.C(c5292lJ)) {
            c5292lJ = z0N.K(c5292lJ, iM);
        }
        C5296n c5296n2 = new C5296n(c5292lJ);
        c5296n2.o(((-(c5296n2.h() + c5296n2.g())) / 2.0f) - y02.n().k(y02.m()));
        float fG = c5292lJ.g();
        Q q10 = new Q(c5296n2);
        if (fG > 1.0E-7f) {
            q10.b(new U0(fG, 0.0f, 0.0f, 0.0f));
        }
        return q10;
    }

    @Override // rc.AbstractC5300p
    public C5298o i(Z0 z02) {
        return z02.j(this.f39175f, 0).b();
    }

    public String q() {
        return this.f39175f;
    }

    public W0 r(char c10) {
        this.f39176g = c10;
        return this;
    }
}
