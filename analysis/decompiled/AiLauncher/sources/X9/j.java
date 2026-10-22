package X9;

import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import La.H;
import Z8.C1174w;
import Z8.F;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import ra.InterfaceC5238k;
import ya.A0;
import ya.AbstractC5974I;
import ya.AbstractC5990d0;
import ya.B0;
import ya.InterfaceC5988c0;
import ya.S;
import ya.s0;

/* loaded from: classes5.dex */
public final class j extends AbstractC5974I implements InterfaceC5988c0 {
    public j(AbstractC5990d0 abstractC5990d0, AbstractC5990d0 abstractC5990d02, boolean z10) {
        super(abstractC5990d0, abstractC5990d02);
        if (z10) {
            return;
        }
        kotlin.reflect.jvm.internal.impl.types.checker.b.f36098a.b(abstractC5990d0, abstractC5990d02);
    }

    public static final CharSequence V0(String it) {
        p.i(it, "it");
        return "(raw) " + it;
    }

    public static final boolean W0(String str, String str2) {
        return p.d(str, H.R0(str2, "out ")) || p.d(str2, "*");
    }

    public static final List<String> X0(kotlin.reflect.jvm.internal.impl.renderer.b bVar, S s10) {
        List<B0> listF0 = s10.F0();
        ArrayList arrayList = new ArrayList(C1174w.x(listF0, 10));
        Iterator<T> it = listF0.iterator();
        while (it.hasNext()) {
            arrayList.add(bVar.T((B0) it.next()));
        }
        return arrayList;
    }

    public static final String Y0(String str, String str2) {
        if (!H.f0(str, '<', false, 2, null)) {
            return str;
        }
        return H.w1(str, '<', null, 2, null) + '<' + str2 + '>' + H.s1(str, '>', null, 2, null);
    }

    @Override // ya.AbstractC5974I
    public AbstractC5990d0 O0() {
        return P0();
    }

    @Override // ya.AbstractC5974I
    public String R0(kotlin.reflect.jvm.internal.impl.renderer.b renderer, kotlin.reflect.jvm.internal.impl.renderer.c options) {
        p.i(renderer, "renderer");
        p.i(options, "options");
        String strS = renderer.S(P0());
        String strS2 = renderer.S(Q0());
        if (options.i()) {
            return "raw (" + strS + ".." + strS2 + ')';
        }
        if (Q0().F0().isEmpty()) {
            return renderer.P(strS, strS2, Da.d.n(this));
        }
        List<String> listX0 = X0(renderer, P0());
        List<String> listX02 = X0(renderer, Q0());
        List<String> list = listX0;
        String strA0 = F.A0(list, ", ", null, null, 0, null, i.f6892a, 30, null);
        List<Pair> listW1 = F.w1(list, listX02);
        if ((listW1 instanceof Collection) && listW1.isEmpty()) {
            strS2 = Y0(strS2, strA0);
        } else {
            for (Pair pair : listW1) {
                if (!W0((String) pair.e(), (String) pair.f())) {
                    break;
                }
            }
            strS2 = Y0(strS2, strA0);
        }
        String strY0 = Y0(strS, strA0);
        return p.d(strY0, strS2) ? strY0 : renderer.P(strY0, strS2, Da.d.n(this));
    }

    @Override // ya.K0
    /* renamed from: T0, reason: merged with bridge method [inline-methods] */
    public j L0(boolean z10) {
        return new j(P0().L0(z10), Q0().L0(z10));
    }

    @Override // ya.K0
    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public AbstractC5974I R0(kotlin.reflect.jvm.internal.impl.types.checker.c kotlinTypeRefiner) {
        p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
        S sA = kotlinTypeRefiner.a(P0());
        p.g(sA, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        S sA2 = kotlinTypeRefiner.a(Q0());
        p.g(sA2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new j((AbstractC5990d0) sA, (AbstractC5990d0) sA2, true);
    }

    @Override // ya.K0
    /* renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public j N0(s0 newAttributes) {
        p.i(newAttributes, "newAttributes");
        return new j(P0().N0(newAttributes), Q0().N0(newAttributes));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ya.AbstractC5974I, ya.S
    public InterfaceC5238k m() {
        InterfaceC0799d interfaceC0799dD = H0().d();
        A0 a02 = null;
        Object[] objArr = 0;
        InterfaceC0797b interfaceC0797b = interfaceC0799dD instanceof InterfaceC0797b ? (InterfaceC0797b) interfaceC0799dD : null;
        if (interfaceC0797b != null) {
            InterfaceC5238k interfaceC5238kK0 = interfaceC0797b.k0(new h(a02, 1, objArr == true ? 1 : 0));
            p.h(interfaceC5238kK0, "getMemberScope(...)");
            return interfaceC5238kK0;
        }
        throw new IllegalStateException(("Incorrect classifier: " + H0().d()).toString());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(AbstractC5990d0 lowerBound, AbstractC5990d0 upperBound) {
        this(lowerBound, upperBound, false);
        p.i(lowerBound, "lowerBound");
        p.i(upperBound, "upperBound");
    }
}
