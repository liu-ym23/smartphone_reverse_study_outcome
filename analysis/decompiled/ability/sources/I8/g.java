package I8;

import D7.v;
import H4.o;
import L8.p;
import L8.q;
import L8.s;
import X8.A;
import X8.AbstractC0272c;
import X8.AbstractC0285p;
import X8.C0270a;
import X8.C0281l;
import X8.K;
import X8.N;
import X8.S;
import X8.U;
import X8.w;
import X8.y;
import Z7.t;
import a.AbstractC0291a;
import ca.AbstractC0897f;
import e8.n;
import h8.AbstractC1532o;
import h8.AbstractC1538u;
import h8.C1493A;
import h8.C1531n;
import h8.InterfaceC1494B;
import h8.InterfaceC1498F;
import h8.InterfaceC1501I;
import h8.InterfaceC1506N;
import h8.InterfaceC1507O;
import h8.InterfaceC1510S;
import h8.InterfaceC1520c;
import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import h8.InterfaceC1525h;
import h8.InterfaceC1527j;
import h8.InterfaceC1528k;
import h8.InterfaceC1539v;
import h8.InterfaceC1540w;
import i8.InterfaceC1555a;
import i8.InterfaceC1556b;
import j9.m;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k8.C1640i;
import k8.I;
import k8.J;
import k8.Q;
import k8.r;
import k8.u;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.EmptyList;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.renderer.AnnotationArgumentsRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier;
import kotlin.reflect.jvm.internal.impl.renderer.OverrideRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.ParameterNameRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.PropertyAccessorRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;

/* loaded from: classes4.dex */
public final class g implements h {
    public static final g c;
    public static final g d;
    public static final g e;

    /* renamed from: a, reason: collision with root package name */
    public final j f813a;
    public final C7.f b = kotlin.a.a(new e(this, 0));

    static {
        Z6.k.R(c.b);
        Z6.k.R(c.d);
        Z6.k.R(c.e);
        Z6.k.R(c.f);
        Z6.k.R(c.g);
        Z6.k.R(c.h);
        c = Z6.k.R(c.i);
        Z6.k.R(c.f808j);
        d = Z6.k.R(c.k);
        e = Z6.k.R(c.l);
        Z6.k.R(c.c);
    }

    public g(j jVar) {
        this.f813a = jVar;
    }

    public static void V(StringBuilder sb) {
        int length = sb.length();
        if (length == 0 || sb.charAt(length - 1) != ' ') {
            sb.append(' ');
        }
    }

    public static boolean h0(w wVar) {
        if (!M.a.h0(wVar)) {
            return false;
        }
        List listL = wVar.L();
        if ((listL instanceof Collection) && listL.isEmpty()) {
            return true;
        }
        Iterator it = listL.iterator();
        while (it.hasNext()) {
            if (((N) it.next()).c()) {
                return false;
            }
        }
        return true;
    }

    public static final void l(g gVar, InterfaceC1501I interfaceC1501I, StringBuilder sb) throws IOException {
        boolean zP = gVar.p();
        j jVar = gVar.f813a;
        if (!zP) {
            i iVar = jVar.g;
            t[] tVarArr = j.f815Y;
            if (!((Boolean) iVar.getValue(jVar, tVarArr[5])).booleanValue()) {
                List listP0 = interfaceC1501I.p0();
                kotlin.jvm.internal.k.e(listP0, "getContextReceiverParameters(...)");
                gVar.A(sb, listP0);
                if (gVar.o().contains(DescriptorRendererModifier.g)) {
                    gVar.w(sb, interfaceC1501I, null);
                    r rVarO0 = interfaceC1501I.o0();
                    if (rVarO0 != null) {
                        gVar.w(sb, rVarO0, AnnotationUseSiteTarget.b);
                    }
                    r rVarJ = interfaceC1501I.J();
                    if (rVarJ != null) {
                        gVar.w(sb, rVarJ, AnnotationUseSiteTarget.f4954j);
                    }
                    if (((PropertyAccessorRenderingPolicy) jVar.f822H.getValue(jVar, tVarArr[32])) == PropertyAccessorRenderingPolicy.b) {
                        I getter = interfaceC1501I.getGetter();
                        if (getter != null) {
                            gVar.w(sb, getter, AnnotationUseSiteTarget.e);
                        }
                        J setter = interfaceC1501I.getSetter();
                        if (setter != null) {
                            gVar.w(sb, setter, AnnotationUseSiteTarget.f);
                            List listX = setter.x();
                            kotlin.jvm.internal.k.e(listX, "getValueParameters(...)");
                            Q q5 = (Q) v.U0(listX);
                            kotlin.jvm.internal.k.c(q5);
                            gVar.w(sb, q5, AnnotationUseSiteTarget.i);
                        }
                    }
                }
                C1531n visibility = interfaceC1501I.getVisibility();
                kotlin.jvm.internal.k.e(visibility, "getVisibility(...)");
                gVar.f0(visibility, sb);
                gVar.L(sb, gVar.o().contains(DescriptorRendererModifier.n) && interfaceC1501I.isConst(), "const");
                gVar.I(interfaceC1501I, sb);
                gVar.K(interfaceC1501I, sb);
                gVar.Q(interfaceC1501I, sb);
                gVar.L(sb, gVar.o().contains(DescriptorRendererModifier.o) && interfaceC1501I.q0(), "lateinit");
                gVar.H(interfaceC1501I, sb);
            }
            gVar.c0(interfaceC1501I, sb, false);
            List typeParameters = interfaceC1501I.getTypeParameters();
            kotlin.jvm.internal.k.e(typeParameters, "getTypeParameters(...)");
            gVar.b0(typeParameters, sb, true);
            gVar.T(interfaceC1501I, sb);
        }
        gVar.N(interfaceC1501I, sb, true);
        sb.append(": ");
        w type = interfaceC1501I.getType();
        kotlin.jvm.internal.k.e(type, "getType(...)");
        sb.append(gVar.W(type));
        gVar.U(interfaceC1501I, sb);
        gVar.F(interfaceC1501I, sb);
        List typeParameters2 = interfaceC1501I.getTypeParameters();
        kotlin.jvm.internal.k.e(typeParameters2, "getTypeParameters(...)");
        gVar.g0(sb, typeParameters2);
    }

    public static Modality t(InterfaceC1539v interfaceC1539v) {
        if (interfaceC1539v instanceof InterfaceC1522e) {
            return ((InterfaceC1522e) interfaceC1539v).getKind() == ClassKind.b ? Modality.e : Modality.b;
        }
        InterfaceC1527j interfaceC1527jD = interfaceC1539v.d();
        InterfaceC1522e interfaceC1522e = interfaceC1527jD instanceof InterfaceC1522e ? (InterfaceC1522e) interfaceC1527jD : null;
        if (interfaceC1522e != null && (interfaceC1539v instanceof InterfaceC1520c)) {
            InterfaceC1520c interfaceC1520c = (InterfaceC1520c) interfaceC1539v;
            Collection collectionE = interfaceC1520c.e();
            kotlin.jvm.internal.k.e(collectionE, "getOverriddenDescriptors(...)");
            if (!collectionE.isEmpty() && interfaceC1522e.i() != Modality.b) {
                return Modality.d;
            }
            if (interfaceC1522e.getKind() != ClassKind.b || kotlin.jvm.internal.k.b(interfaceC1520c.getVisibility(), AbstractC1532o.f4583a)) {
                return Modality.b;
            }
            Modality modalityI = interfaceC1520c.i();
            Modality modality = Modality.e;
            return modalityI == modality ? modality : Modality.d;
        }
        return Modality.b;
    }

    public final void A(StringBuilder sb, List list) {
        if (list.isEmpty()) {
            return;
        }
        sb.append("context(");
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i6 = i + 1;
            u uVar = (u) it.next();
            w(sb, uVar, AnnotationUseSiteTarget.g);
            w type = uVar.getType();
            kotlin.jvm.internal.k.e(type, "getType(...)");
            sb.append(E(type));
            if (i == o.H(list)) {
                sb.append(") ");
            } else {
                sb.append(", ");
            }
            i = i6;
        }
    }

    public final void B(StringBuilder sb, A a3) {
        w(sb, a3, null);
        if (AbstractC0272c.k(a3)) {
            boolean z10 = a3 instanceof Z8.g;
            j jVar = this.f813a;
            if (z10 && ((Z8.g) a3).d.b && ((Boolean) jVar.f836V.getValue(jVar, j.f815Y[47])).booleanValue()) {
                Z8.i iVar = Z8.i.f1619a;
                if (z10) {
                    boolean z11 = ((Z8.g) a3).d.b;
                }
                K kQ = a3.Q();
                kotlin.jvm.internal.k.d(kQ, "null cannot be cast to non-null type org.jetbrains.kotlin.types.error.ErrorTypeConstructor");
                sb.append(C(((Z8.h) kQ).b[0]));
            } else {
                if (!z10 || ((Boolean) jVar.f838X.getValue(jVar, j.f815Y[49])).booleanValue()) {
                    sb.append(a3.Q().toString());
                } else {
                    sb.append(((Z8.g) a3).h);
                }
                sb.append(X(a3.L()));
            }
        } else {
            K kQ2 = a3.Q();
            InterfaceC1524g interfaceC1524gD = a3.Q().d();
            A5.c cVarA = AbstractC1538u.a(a3, interfaceC1524gD instanceof InterfaceC1525h ? (InterfaceC1525h) interfaceC1524gD : null, 0);
            if (cVarA == null) {
                sb.append(Y(kQ2));
                sb.append(X(a3.L()));
            } else {
                S(sb, cVarA);
            }
        }
        if (a3.W()) {
            sb.append("?");
        }
        if (a3 instanceof C0281l) {
            sb.append(" & Any");
        }
    }

    public final String C(String str) {
        int iOrdinal = q().ordinal();
        if (iOrdinal == 0) {
            return str;
        }
        if (iOrdinal == 1) {
            return B7.a.m("<font color=red><b>", str, "</b></font>");
        }
        throw new NoWhenBranchMatchedException();
    }

    public final String D(String lowerRendered, String upperRendered, e8.i iVar) {
        kotlin.jvm.internal.k.f(lowerRendered, "lowerRendered");
        kotlin.jvm.internal.k.f(upperRendered, "upperRendered");
        if (AbstractC0291a.J(lowerRendered, upperRendered)) {
            return j9.t.e0(upperRendered, "(", false) ? B7.a.m("(", lowerRendered, ")!") : lowerRendered.concat("!");
        }
        String strL0 = m.L0(n().a(iVar.i(n.f4390C), this), "Collection");
        String strF = AbstractC0291a.F(lowerRendered, strL0.concat("Mutable"), upperRendered, strL0, strL0.concat("(Mutable)"));
        if (strF != null) {
            return strF;
        }
        String strF2 = AbstractC0291a.F(lowerRendered, strL0.concat("MutableMap.MutableEntry"), upperRendered, strL0.concat("Map.Entry"), strL0.concat("(Mutable)Map.(Mutable)Entry"));
        if (strF2 != null) {
            return strF2;
        }
        String strL02 = m.L0(n().a(iVar.j("Array"), this), "Array");
        String strF3 = AbstractC0291a.F(lowerRendered, strL02.concat(m("Array<")), upperRendered, strL02.concat(m("Array<out ")), strL02.concat(m("Array<(out) ")));
        if (strF3 != null) {
            return strF3;
        }
        return "(" + lowerRendered + ".." + upperRendered + ')';
    }

    public final String E(w wVar) throws IOException {
        String strW = W(wVar);
        return ((!h0(wVar) || S.e(wVar)) && !(wVar instanceof C0281l)) ? strW : androidx.compose.foundation.b.m(')', "(", strW);
    }

    public final void F(InterfaceC1510S interfaceC1510S, StringBuilder sb) {
        L8.g gVarI0;
        String strZ;
        j jVar = this.f813a;
        if (!((Boolean) jVar.u.getValue(jVar, j.f815Y[19])).booleanValue() || (gVarI0 = interfaceC1510S.i0()) == null || (strZ = z(gVarI0)) == null) {
            return;
        }
        sb.append(" = ");
        sb.append(m(strZ));
    }

    public final String G(String str) {
        int iOrdinal = q().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            j jVar = this.f813a;
            if (!((Boolean) jVar.f837W.getValue(jVar, j.f815Y[48])).booleanValue()) {
                return B7.a.m("<b>", str, "</b>");
            }
        }
        return str;
    }

    public final void H(InterfaceC1520c interfaceC1520c, StringBuilder sb) {
        if (o().contains(DescriptorRendererModifier.i) && s() && interfaceC1520c.getKind() != CallableMemberDescriptor$Kind.f4950a) {
            sb.append("/*");
            sb.append(M0.i.J(interfaceC1520c.getKind().name()));
            sb.append("*/ ");
        }
    }

    public final void I(InterfaceC1539v interfaceC1539v, StringBuilder sb) {
        L(sb, interfaceC1539v.isExternal(), "external");
        boolean z10 = false;
        L(sb, o().contains(DescriptorRendererModifier.l) && interfaceC1539v.g0(), "expect");
        if (o().contains(DescriptorRendererModifier.m) && interfaceC1539v.S()) {
            z10 = true;
        }
        L(sb, z10, "actual");
    }

    public final void J(Modality modality, StringBuilder sb, Modality modality2) {
        j jVar = this.f813a;
        if (((Boolean) jVar.p.getValue(jVar, j.f815Y[14])).booleanValue() || modality != modality2) {
            L(sb, o().contains(DescriptorRendererModifier.e), M0.i.J(modality.name()));
        }
    }

    public final void K(InterfaceC1520c interfaceC1520c, StringBuilder sb) {
        if (J8.e.s(interfaceC1520c) && interfaceC1520c.i() == Modality.b) {
            return;
        }
        j jVar = this.f813a;
        if (((OverrideRenderingPolicy) jVar.f817B.getValue(jVar, j.f815Y[26])) == OverrideRenderingPolicy.f5110a && interfaceC1520c.i() == Modality.d && !interfaceC1520c.e().isEmpty()) {
            return;
        }
        Modality modalityI = interfaceC1520c.i();
        kotlin.jvm.internal.k.e(modalityI, "getModality(...)");
        J(modalityI, sb, t(interfaceC1520c));
    }

    public final void L(StringBuilder sb, boolean z10, String str) {
        if (z10) {
            sb.append(G(str));
            sb.append(" ");
        }
    }

    public final String M(G8.f fVar, boolean z10) {
        String strM = m(AbstractC0291a.D(fVar));
        j jVar = this.f813a;
        return (((Boolean) jVar.f837W.getValue(jVar, j.f815Y[48])).booleanValue() && q() == RenderingFormat.b && z10) ? B7.a.m("<b>", strM, "</b>") : strM;
    }

    public final void N(InterfaceC1527j interfaceC1527j, StringBuilder sb, boolean z10) {
        G8.f name = interfaceC1527j.getName();
        kotlin.jvm.internal.k.e(name, "getName(...)");
        sb.append(M(name, z10));
    }

    public final void O(StringBuilder sb, w wVar) throws IOException {
        U uZ = wVar.Z();
        C0270a c0270a = uZ instanceof C0270a ? (C0270a) uZ : null;
        if (c0270a == null) {
            P(sb, wVar);
            return;
        }
        A a3 = c0270a.c;
        A a4 = c0270a.b;
        j jVar = this.f813a;
        i iVar = jVar.f832R;
        t[] tVarArr = j.f815Y;
        if (((Boolean) iVar.getValue(jVar, tVarArr[42])).booleanValue()) {
            P(sb, a4);
            if (((Boolean) jVar.f833S.getValue(jVar, tVarArr[43])).booleanValue()) {
                RenderingFormat renderingFormatQ = q();
                RenderingFormat renderingFormat = RenderingFormat.b;
                if (renderingFormatQ == renderingFormat) {
                    sb.append("<font color=\"808080\"><i>");
                }
                sb.append(" /* ");
                sb.append("from: ");
                P(sb, a3);
                sb.append(" */");
                if (q() == renderingFormat) {
                    sb.append("</i></font>");
                    return;
                }
                return;
            }
            return;
        }
        P(sb, a3);
        if (((Boolean) jVar.f831Q.getValue(jVar, tVarArr[41])).booleanValue()) {
            RenderingFormat renderingFormatQ2 = q();
            RenderingFormat renderingFormat2 = RenderingFormat.b;
            if (renderingFormatQ2 == renderingFormat2) {
                sb.append("<font color=\"808080\"><i>");
            }
            sb.append(" /* ");
            sb.append("= ");
            P(sb, a4);
            sb.append(" */");
            if (q() == renderingFormat2) {
                sb.append("</i></font>");
            }
        }
    }

    public final void P(StringBuilder sb, w wVar) throws IOException {
        G8.f fVarS;
        String strM;
        boolean z10 = wVar instanceof y;
        j jVar = this.f813a;
        if (z10 && jVar.l() && !((y) wVar).d.b()) {
            sb.append("<Not computed yet>");
            return;
        }
        U uZ = wVar.Z();
        if (uZ instanceof AbstractC0285p) {
            sb.append(((AbstractC0285p) uZ).s0(this, this));
            return;
        }
        if (!(uZ instanceof A)) {
            throw new NoWhenBranchMatchedException();
        }
        A a3 = (A) uZ;
        if (a3.equals(S.b) || a3.Q() == S.f1527a.b) {
            sb.append("???");
            return;
        }
        K kQ = a3.Q();
        if ((kQ instanceof Z8.h) && ((Z8.h) kQ).f1618a == ErrorTypeKind.f5154j) {
            if (!((Boolean) jVar.f844t.getValue(jVar, j.f815Y[18])).booleanValue()) {
                sb.append("???");
                return;
            }
            K kQ2 = a3.Q();
            kotlin.jvm.internal.k.d(kQ2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.error.ErrorTypeConstructor");
            sb.append(C(((Z8.h) kQ2).b[0]));
            return;
        }
        if (AbstractC0272c.k(a3)) {
            B(sb, a3);
            return;
        }
        if (!h0(a3)) {
            B(sb, a3);
            return;
        }
        int length = sb.length();
        ((g) this.b.getF4884a()).w(sb, a3, null);
        boolean z11 = sb.length() != length;
        w wVarD0 = M.a.d0(a3);
        List listW = M.a.W(a3);
        boolean zI0 = M.a.i0(a3);
        boolean zW = a3.W();
        boolean z12 = zW || (z11 && wVarD0 != null);
        if (z12) {
            if (zI0) {
                sb.insert(length, '(');
            } else {
                if (z11) {
                    AbstractC0897f.F(m.t0(sb));
                    if (sb.charAt(m.m0(sb) - 1) != ')') {
                        sb.insert(m.m0(sb), "()");
                    }
                }
                sb.append("(");
            }
        }
        if (!listW.isEmpty()) {
            sb.append("context(");
            Iterator it = listW.subList(0, o.H(listW)).iterator();
            while (it.hasNext()) {
                O(sb, (w) it.next());
                sb.append(", ");
            }
            O(sb, (w) v.K0(listW));
            sb.append(") ");
        }
        L(sb, zI0, "suspend");
        if (wVarD0 != null) {
            boolean z13 = (h0(wVarD0) && !wVarD0.W()) || M.a.i0(wVarD0) || !wVarD0.getAnnotations().isEmpty() || (wVarD0 instanceof C0281l);
            if (z13) {
                sb.append("(");
            }
            O(sb, wVarD0);
            if (z13) {
                sb.append(")");
            }
            sb.append(".");
        }
        sb.append("(");
        if (!M.a.h0(a3) || a3.getAnnotations().m(n.p) == null || a3.L().size() > 1) {
            int i = 0;
            for (N typeProjection : M.a.f0(a3)) {
                int i6 = i + 1;
                if (i > 0) {
                    sb.append(", ");
                }
                if (((Boolean) jVar.f835U.getValue(jVar, j.f815Y[45])).booleanValue()) {
                    w wVarB = typeProjection.b();
                    kotlin.jvm.internal.k.e(wVarB, "getType(...)");
                    fVarS = M.a.S(wVarB);
                } else {
                    fVarS = null;
                }
                if (fVarS != null) {
                    sb.append(M(fVarS, false));
                    sb.append(": ");
                }
                kotlin.jvm.internal.k.f(typeProjection, "typeProjection");
                StringBuilder sb2 = new StringBuilder();
                v.H0(o.M(typeProjection), sb2, ", ", null, null, new f(this, 0), 60);
                String string = sb2.toString();
                kotlin.jvm.internal.k.e(string, "toString(...)");
                sb.append(string);
                i = i6;
            }
        } else {
            sb.append("???");
        }
        sb.append(") ");
        int iOrdinal = q().ordinal();
        if (iOrdinal == 0) {
            strM = m("->");
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            strM = "&rarr;";
        }
        sb.append(strM);
        sb.append(" ");
        M.a.h0(a3);
        w wVarB2 = ((N) v.K0(a3.L())).b();
        kotlin.jvm.internal.k.e(wVarB2, "getType(...)");
        O(sb, wVarB2);
        if (z12) {
            sb.append(")");
        }
        if (zW) {
            sb.append("?");
        }
    }

    public final void Q(InterfaceC1520c interfaceC1520c, StringBuilder sb) {
        if (o().contains(DescriptorRendererModifier.f) && !interfaceC1520c.e().isEmpty()) {
            j jVar = this.f813a;
            if (((OverrideRenderingPolicy) jVar.f817B.getValue(jVar, j.f815Y[26])) != OverrideRenderingPolicy.b) {
                L(sb, true, "override");
                if (s()) {
                    sb.append("/*");
                    sb.append(interfaceC1520c.e().size());
                    sb.append("*/ ");
                }
            }
        }
    }

    public final void R(G8.c cVar, String str, StringBuilder sb) {
        sb.append(G(str));
        G8.e eVarI = cVar.i();
        kotlin.jvm.internal.k.e(eVarI, "toUnsafe(...)");
        String strM = m(AbstractC0291a.E(eVarI.e()));
        if (strM.length() > 0) {
            sb.append(" ");
            sb.append(strM);
        }
    }

    public final void S(StringBuilder sb, A5.c cVar) {
        A5.c cVar2 = (A5.c) cVar.d;
        InterfaceC1525h interfaceC1525h = (InterfaceC1525h) cVar.b;
        if (cVar2 != null) {
            S(sb, cVar2);
            sb.append('.');
            G8.f name = interfaceC1525h.getName();
            kotlin.jvm.internal.k.e(name, "getName(...)");
            sb.append(M(name, false));
        } else {
            K kM = interfaceC1525h.m();
            kotlin.jvm.internal.k.e(kM, "getTypeConstructor(...)");
            sb.append(Y(kM));
        }
        sb.append(X((List) cVar.c));
    }

    public final void T(InterfaceC1520c interfaceC1520c, StringBuilder sb) {
        u uVarI = interfaceC1520c.I();
        if (uVarI != null) {
            w(sb, uVarI, AnnotationUseSiteTarget.g);
            w type = uVarI.getType();
            kotlin.jvm.internal.k.e(type, "getType(...)");
            sb.append(E(type));
            sb.append(".");
        }
    }

    public final void U(InterfaceC1520c interfaceC1520c, StringBuilder sb) {
        u uVarI;
        j jVar = this.f813a;
        if (((Boolean) jVar.f820F.getValue(jVar, j.f815Y[30])).booleanValue() && (uVarI = interfaceC1520c.I()) != null) {
            sb.append(" on ");
            w type = uVarI.getType();
            kotlin.jvm.internal.k.e(type, "getType(...)");
            sb.append(W(type));
        }
    }

    public final String W(w type) throws IOException {
        kotlin.jvm.internal.k.f(type, "type");
        StringBuilder sb = new StringBuilder();
        j jVar = this.f813a;
        O(sb, (w) ((S7.k) jVar.y.getValue(jVar, j.f815Y[23])).invoke(type));
        String string = sb.toString();
        kotlin.jvm.internal.k.e(string, "toString(...)");
        return string;
    }

    public final String X(List typeArguments) throws IOException {
        kotlin.jvm.internal.k.f(typeArguments, "typeArguments");
        if (typeArguments.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(m("<"));
        v.H0(typeArguments, sb, ", ", null, null, new f(this, 0), 60);
        sb.append(m(">"));
        String string = sb.toString();
        kotlin.jvm.internal.k.e(string, "toString(...)");
        return string;
    }

    public final String Y(K typeConstructor) {
        kotlin.jvm.internal.k.f(typeConstructor, "typeConstructor");
        InterfaceC1524g klass = typeConstructor.d();
        if ((klass instanceof InterfaceC1507O) || (klass instanceof InterfaceC1522e) || (klass instanceof InterfaceC1506N)) {
            kotlin.jvm.internal.k.f(klass, "klass");
            return Z8.i.f(klass) ? klass.m().toString() : n().a(klass, this);
        }
        if (klass == null) {
            return typeConstructor instanceof X8.v ? ((X8.v) typeConstructor).g(c.m) : typeConstructor.toString();
        }
        throw new IllegalStateException(("Unexpected classifier: " + klass.getClass()).toString());
    }

    public final void Z(InterfaceC1507O interfaceC1507O, StringBuilder sb, boolean z10) {
        if (z10) {
            sb.append(m("<"));
        }
        if (s()) {
            sb.append("/*");
            sb.append(interfaceC1507O.getIndex());
            sb.append("*/ ");
        }
        L(sb, interfaceC1507O.o(), "reified");
        String str = interfaceC1507O.r().f5143a;
        boolean z11 = true;
        L(sb, str.length() > 0, str);
        w(sb, interfaceC1507O, null);
        N(interfaceC1507O, sb, z10);
        int size = interfaceC1507O.getUpperBounds().size();
        if ((size > 1 && !z10) || size == 1) {
            w wVar = (w) interfaceC1507O.getUpperBounds().iterator().next();
            if (wVar == null) {
                e8.i.a(142);
                throw null;
            }
            if (!e8.i.x(wVar) || !wVar.W()) {
                sb.append(" : ");
                sb.append(W(wVar));
            }
        } else if (z10) {
            for (w wVar2 : interfaceC1507O.getUpperBounds()) {
                if (wVar2 == null) {
                    e8.i.a(142);
                    throw null;
                }
                if (!e8.i.x(wVar2) || !wVar2.W()) {
                    if (z11) {
                        sb.append(" : ");
                    } else {
                        sb.append(" & ");
                    }
                    sb.append(W(wVar2));
                    z11 = false;
                }
            }
        }
        if (z10) {
            sb.append(m(">"));
        }
    }

    @Override // I8.h
    public final void a() {
        this.f813a.a();
    }

    public final void a0(StringBuilder sb, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Z((InterfaceC1507O) it.next(), sb, false);
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
    }

    @Override // I8.h
    public final void b() {
        this.f813a.b();
    }

    public final void b0(List list, StringBuilder sb, boolean z10) {
        j jVar = this.f813a;
        if (((Boolean) jVar.f846w.getValue(jVar, j.f815Y[21])).booleanValue() || list.isEmpty()) {
            return;
        }
        sb.append(m("<"));
        a0(sb, list);
        sb.append(m(">"));
        if (z10) {
            sb.append(" ");
        }
    }

    @Override // I8.h
    public final void c(ParameterNameRenderingPolicy parameterNameRenderingPolicy) {
        this.f813a.c(parameterNameRenderingPolicy);
    }

    public final void c0(InterfaceC1510S interfaceC1510S, StringBuilder sb, boolean z10) {
        if (z10 || !(interfaceC1510S instanceof Q)) {
            sb.append(G(interfaceC1510S.H() ? "var" : "val"));
            sb.append(" ");
        }
    }

    @Override // I8.h
    public final void d() {
        this.f813a.d();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d0(k8.Q r11, boolean r12, java.lang.StringBuilder r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: I8.g.d0(k8.Q, boolean, java.lang.StringBuilder, boolean):void");
    }

    @Override // I8.h
    public final void e() {
        this.f813a.e();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e0(java.util.Collection r8, boolean r9, java.lang.StringBuilder r10) {
        /*
            r7 = this;
            I8.j r0 = r7.f813a
            I8.i r1 = r0.E
            Z7.t[] r2 = I8.j.f815Y
            r3 = 29
            r2 = r2[r3]
            java.lang.Object r0 = r1.getValue(r0, r2)
            kotlin.reflect.jvm.internal.impl.renderer.ParameterNameRenderingPolicy r0 = (kotlin.reflect.jvm.internal.impl.renderer.ParameterNameRenderingPolicy) r0
            int r0 = r0.ordinal()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L27
            if (r0 == r2) goto L25
            r9 = 2
            if (r0 != r9) goto L1f
        L1d:
            r9 = r1
            goto L28
        L1f:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        L25:
            if (r9 != 0) goto L1d
        L27:
            r9 = r2
        L28:
            int r0 = r8.size()
            I8.d r3 = r7.r()
            r3.getClass()
            java.lang.String r3 = "builder"
            kotlin.jvm.internal.k.f(r10, r3)
            java.lang.String r3 = "("
            r10.append(r3)
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r8 = r8.iterator()
            r3 = r1
        L44:
            boolean r4 = r8.hasNext()
            if (r4 == 0) goto L73
            int r4 = r3 + 1
            java.lang.Object r5 = r8.next()
            k8.Q r5 = (k8.Q) r5
            I8.d r6 = r7.r()
            r6.getClass()
            java.lang.String r6 = "parameter"
            kotlin.jvm.internal.k.f(r5, r6)
            r7.d0(r5, r9, r10, r1)
            I8.d r5 = r7.r()
            r5.getClass()
            int r5 = r0 + (-1)
            if (r3 == r5) goto L71
            java.lang.String r3 = ", "
            r10.append(r3)
        L71:
            r3 = r4
            goto L44
        L73:
            I8.d r7 = r7.r()
            r7.getClass()
            java.lang.String r7 = ")"
            r10.append(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: I8.g.e0(java.util.Collection, boolean, java.lang.StringBuilder):void");
    }

    @Override // I8.h
    public final void f() {
        this.f813a.f();
    }

    public final boolean f0(C1531n c1531n, StringBuilder sb) {
        if (!o().contains(DescriptorRendererModifier.d)) {
            return false;
        }
        j jVar = this.f813a;
        i iVar = jVar.n;
        t[] tVarArr = j.f815Y;
        if (((Boolean) iVar.getValue(jVar, tVarArr[12])).booleanValue()) {
            c1531n = AbstractC1532o.f(c1531n.f4582a.c());
        }
        if (!((Boolean) jVar.o.getValue(jVar, tVarArr[13])).booleanValue() && kotlin.jvm.internal.k.b(c1531n, AbstractC1532o.l)) {
            return false;
        }
        sb.append(G(c1531n.f4582a.b()));
        sb.append(" ");
        return true;
    }

    @Override // I8.h
    public final void g() {
        this.f813a.g();
    }

    public final void g0(StringBuilder sb, List list) throws IOException {
        j jVar = this.f813a;
        if (((Boolean) jVar.f846w.getValue(jVar, j.f815Y[21])).booleanValue()) {
            return;
        }
        ArrayList arrayList = new ArrayList(0);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            InterfaceC1507O interfaceC1507O = (InterfaceC1507O) it.next();
            List upperBounds = interfaceC1507O.getUpperBounds();
            kotlin.jvm.internal.k.e(upperBounds, "getUpperBounds(...)");
            for (w wVar : v.w0(upperBounds, 1)) {
                StringBuilder sb2 = new StringBuilder();
                G8.f name = interfaceC1507O.getName();
                kotlin.jvm.internal.k.e(name, "getName(...)");
                sb2.append(M(name, false));
                sb2.append(" : ");
                kotlin.jvm.internal.k.c(wVar);
                sb2.append(W(wVar));
                arrayList.add(sb2.toString());
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        sb.append(" ");
        sb.append(G("where"));
        sb.append(" ");
        v.H0(arrayList, sb, ", ", null, null, null, 124);
    }

    @Override // I8.h
    public final void h(b bVar) {
        this.f813a.h(bVar);
    }

    @Override // I8.h
    public final void i(Set set) {
        kotlin.jvm.internal.k.f(set, "<set-?>");
        this.f813a.i(set);
    }

    @Override // I8.h
    public final void j() {
        this.f813a.j();
    }

    @Override // I8.h
    public final void k() {
        RenderingFormat renderingFormat = RenderingFormat.f5113a;
        this.f813a.k();
    }

    public final String m(String str) {
        return q().a(str);
    }

    public final b n() {
        j jVar = this.f813a;
        return (b) jVar.b.getValue(jVar, j.f815Y[0]);
    }

    public final Set o() {
        j jVar = this.f813a;
        return (Set) jVar.e.getValue(jVar, j.f815Y[3]);
    }

    public final boolean p() {
        j jVar = this.f813a;
        return ((Boolean) jVar.f.getValue(jVar, j.f815Y[4])).booleanValue();
    }

    public final RenderingFormat q() {
        j jVar = this.f813a;
        return (RenderingFormat) jVar.f819D.getValue(jVar, j.f815Y[28]);
    }

    public final d r() {
        j jVar = this.f813a;
        return (d) jVar.f818C.getValue(jVar, j.f815Y[27]);
    }

    public final boolean s() {
        j jVar = this.f813a;
        return ((Boolean) jVar.f840j.getValue(jVar, j.f815Y[8])).booleanValue();
    }

    public final String u(InterfaceC1527j declarationDescriptor) {
        InterfaceC1527j interfaceC1527jD;
        String str;
        kotlin.jvm.internal.k.f(declarationDescriptor, "declarationDescriptor");
        StringBuilder sb = new StringBuilder();
        declarationDescriptor.N(new A8.d(this, 2), sb);
        j jVar = this.f813a;
        i iVar = jVar.c;
        t[] tVarArr = j.f815Y;
        if (((Boolean) iVar.getValue(jVar, tVarArr[1])).booleanValue() && !(declarationDescriptor instanceof InterfaceC1494B) && !(declarationDescriptor instanceof InterfaceC1498F) && (interfaceC1527jD = declarationDescriptor.d()) != null && !(interfaceC1527jD instanceof InterfaceC1540w)) {
            sb.append(" ");
            int iOrdinal = q().ordinal();
            if (iOrdinal == 0) {
                str = "defined in";
            } else {
                if (iOrdinal != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                str = "<i>defined in</i>";
            }
            sb.append(str);
            sb.append(" ");
            G8.e eVarG = J8.e.g(interfaceC1527jD);
            kotlin.jvm.internal.k.e(eVarG, "getFqName(...)");
            sb.append(eVarG.f689a.isEmpty() ? "root package" : m(AbstractC0291a.E(eVarG.e())));
            if (((Boolean) jVar.d.getValue(jVar, tVarArr[2])).booleanValue() && (interfaceC1527jD instanceof InterfaceC1494B) && (declarationDescriptor instanceof InterfaceC1528k)) {
                ((InterfaceC1528k) declarationDescriptor).getSource().getClass();
            }
        }
        String string = sb.toString();
        kotlin.jvm.internal.k.e(string, "toString(...)");
        return string;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String v(InterfaceC1556b annotation, AnnotationUseSiteTarget annotationUseSiteTarget) throws IOException {
        C1640i c1640iU;
        List listX;
        j jVar = this.f813a;
        i iVar = jVar.f828N;
        kotlin.jvm.internal.k.f(annotation, "annotation");
        StringBuilder sb = new StringBuilder();
        sb.append('@');
        if (annotationUseSiteTarget != null) {
            sb.append(annotationUseSiteTarget.f4955a + ':');
        }
        w type = annotation.getType();
        sb.append(W(type));
        t[] tVarArr = j.f815Y;
        if (((AnnotationArgumentsRenderingPolicy) iVar.getValue(jVar, tVarArr[38])).f5105a) {
            Map mapA = annotation.a();
            EmptyList emptyList = null;
            InterfaceC1522e interfaceC1522eD = ((Boolean) jVar.f823I.getValue(jVar, tVarArr[33])).booleanValue() ? kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.d(annotation) : null;
            if (interfaceC1522eD != null && (c1640iU = interfaceC1522eD.u()) != null && (listX = c1640iU.x()) != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : listX) {
                    if (((Q) obj).S0()) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(D7.w.c0(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((Q) it.next()).getName());
                }
                emptyList = arrayList2;
            }
            if (emptyList == null) {
                emptyList = EmptyList.f4893a;
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : emptyList) {
                if (!mapA.containsKey((G8.f) obj2)) {
                    arrayList3.add(obj2);
                }
            }
            ArrayList arrayList4 = new ArrayList(D7.w.c0(arrayList3, 10));
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                arrayList4.add(((G8.f) it2.next()).b() + " = ...");
            }
            Set<Map.Entry> setEntrySet = mapA.entrySet();
            ArrayList arrayList5 = new ArrayList(D7.w.c0(setEntrySet, 10));
            for (Map.Entry entry : setEntrySet) {
                G8.f fVar = (G8.f) entry.getKey();
                L8.g gVar = (L8.g) entry.getValue();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(fVar.b());
                sb2.append(" = ");
                sb2.append(!emptyList.contains(fVar) ? z(gVar) : "...");
                arrayList5.add(sb2.toString());
            }
            List listY0 = v.Y0(v.Q0(arrayList5, arrayList4));
            if (((AnnotationArgumentsRenderingPolicy) iVar.getValue(jVar, j.f815Y[38])).b || !listY0.isEmpty()) {
                v.H0(listY0, sb, ", ", "(", ")", null, 112);
            }
        }
        if (s() && (AbstractC0272c.k(type) || (type.Q().d() instanceof C1493A))) {
            sb.append(" /* annotation class not found */");
        }
        String string = sb.toString();
        kotlin.jvm.internal.k.e(string, "toString(...)");
        return string;
    }

    public final void w(StringBuilder sb, InterfaceC1555a interfaceC1555a, AnnotationUseSiteTarget annotationUseSiteTarget) {
        if (o().contains(DescriptorRendererModifier.g)) {
            boolean z10 = interfaceC1555a instanceof w;
            j jVar = this.f813a;
            Set setM = z10 ? jVar.m() : (Set) jVar.f825K.getValue(jVar, j.f815Y[35]);
            S7.k kVar = (S7.k) jVar.f827M.getValue(jVar, j.f815Y[37]);
            for (InterfaceC1556b interfaceC1556b : interfaceC1555a.getAnnotations()) {
                if (!v.u0(setM, interfaceC1556b.b()) && !kotlin.jvm.internal.k.b(interfaceC1556b.b(), n.f4419r) && (kVar == null || ((Boolean) kVar.invoke(interfaceC1556b)).booleanValue())) {
                    sb.append(v(interfaceC1556b, annotationUseSiteTarget));
                    if (((Boolean) jVar.f824J.getValue(jVar, j.f815Y[34])).booleanValue()) {
                        sb.append('\n');
                    } else {
                        sb.append(" ");
                    }
                }
            }
        }
    }

    public final void y(InterfaceC1525h interfaceC1525h, StringBuilder sb) {
        List listH = interfaceC1525h.h();
        kotlin.jvm.internal.k.e(listH, "getDeclaredTypeParameters(...)");
        List parameters = interfaceC1525h.m().getParameters();
        kotlin.jvm.internal.k.e(parameters, "getParameters(...)");
        if (s() && interfaceC1525h.q() && parameters.size() > listH.size()) {
            sb.append(" /*captured type parameters: ");
            a0(sb, parameters.subList(listH.size(), parameters.size()));
            sb.append("*/");
        }
    }

    public final String z(L8.g gVar) {
        j jVar = this.f813a;
        S7.k kVar = (S7.k) jVar.f845v.getValue(jVar, j.f815Y[20]);
        if (kVar != null) {
            return (String) kVar.invoke(gVar);
        }
        if (gVar instanceof L8.b) {
            Iterable iterable = (Iterable) ((L8.b) gVar).f939a;
            ArrayList arrayList = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                String strZ = z((L8.g) it.next());
                if (strZ != null) {
                    arrayList.add(strZ);
                }
            }
            return v.I0(arrayList, ", ", "{", "}", null, 56);
        }
        if (gVar instanceof L8.a) {
            return m.y0("@", v((InterfaceC1556b) ((L8.a) gVar).f939a, null));
        }
        if (!(gVar instanceof s)) {
            return gVar.toString();
        }
        L8.r rVar = (L8.r) ((s) gVar).f939a;
        if (rVar instanceof p) {
            return ((p) rVar).f942a + "::class";
        }
        if (!(rVar instanceof q)) {
            throw new NoWhenBranchMatchedException();
        }
        q qVar = (q) rVar;
        String strB = qVar.f943a.f938a.a().b();
        int i = qVar.f943a.b;
        for (int i6 = 0; i6 < i; i6++) {
            strB = androidx.compose.foundation.b.m('>', "kotlin.Array<", strB);
        }
        return androidx.appfunctions.metadata.a.l(strB, "::class");
    }
}
