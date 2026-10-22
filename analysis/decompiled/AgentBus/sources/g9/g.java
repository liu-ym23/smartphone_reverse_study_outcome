package g9;

import a4.u;
import d7.b0;
import f8.c0;
import f8.i0;
import f8.l0;
import f8.q0;
import f8.t0;
import f8.w;
import i8.j0;
import i8.k0;
import i8.r0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import m.x;
import v9.m0;
import v9.p0;
import v9.v;
import v9.x0;
import v9.z;
import v9.z0;
import w7.e0;

/* loaded from: classes.dex */
public final class g implements j {

    /* renamed from: c, reason: collision with root package name */
    public static final g f3939c;

    /* renamed from: d, reason: collision with root package name */
    public static final g f3940d;

    /* renamed from: e, reason: collision with root package name */
    public static final g f3941e;

    /* renamed from: a, reason: collision with root package name */
    public final l f3942a;

    /* renamed from: b, reason: collision with root package name */
    public final c7.o f3943b = s7.a.H(new a8.c(8, this));

    static {
        l lVar = new l();
        lVar.h();
        lVar.f3964a = true;
        new g(lVar);
        l lVar2 = new l();
        lVar2.h();
        b0 b0Var = b0.f2947f;
        lVar2.f(b0Var);
        lVar2.f3964a = true;
        new g(lVar2);
        l lVar3 = new l();
        lVar3.h();
        lVar3.f(b0Var);
        lVar3.n();
        lVar3.f3964a = true;
        new g(lVar3);
        l lVar4 = new l();
        lVar4.f(b0Var);
        b bVar = b.f3928c;
        lVar4.e(bVar);
        p pVar = p.f3996g;
        lVar4.d(pVar);
        lVar4.f3964a = true;
        new g(lVar4);
        l lVar5 = new l();
        lVar5.h();
        lVar5.f(b0Var);
        lVar5.e(bVar);
        lVar5.l();
        lVar5.d(p.f3997h);
        lVar5.a();
        lVar5.c();
        lVar5.n();
        lVar5.g();
        lVar5.f3964a = true;
        new g(lVar5);
        l lVar6 = new l();
        lVar6.f(h.f3944g);
        lVar6.f3964a = true;
        f3939c = new g(lVar6);
        l lVar7 = new l();
        lVar7.f(h.f3945h);
        lVar7.f3964a = true;
        new g(lVar7);
        l lVar8 = new l();
        lVar8.e(bVar);
        lVar8.d(pVar);
        lVar8.f3964a = true;
        f3940d = new g(lVar8);
        l lVar9 = new l();
        lVar9.b();
        lVar9.e(b.f3927b);
        lVar9.f(h.f3945h);
        lVar9.f3964a = true;
        f3941e = new g(lVar9);
        l lVar10 = new l();
        lVar10.m();
        lVar10.f(h.f3945h);
        lVar10.f3964a = true;
        new g(lVar10);
    }

    public g(l lVar) {
        this.f3942a = lVar;
    }

    public static void Y(StringBuilder sb2) {
        int length = sb2.length();
        if (length == 0 || sb2.charAt(length - 1) != ' ') {
            sb2.append(' ');
        }
    }

    public static boolean k0(v vVar) {
        if (!s7.a.B(vVar)) {
            return false;
        }
        List listC0 = vVar.C0();
        if (listC0 != null && listC0.isEmpty()) {
            return true;
        }
        Iterator it = listC0.iterator();
        while (it.hasNext()) {
            if (((p0) it.next()).c()) {
                return false;
            }
        }
        return true;
    }

    public static final void o(g gVar, l0 l0Var, StringBuilder sb2) {
        boolean zS = gVar.s();
        l lVar = gVar.f3942a;
        if (!zS) {
            k kVar = lVar.f3970g;
            w7.t[] tVarArr = l.W;
            if (!((Boolean) kVar.a(lVar, tVarArr[5])).booleanValue()) {
                if (gVar.r().contains(h.ANNOTATIONS)) {
                    gVar.z(sb2, l0Var, null);
                    i8.s sVarQ = l0Var.Q();
                    if (sVarQ != null) {
                        gVar.z(sb2, sVarQ, g8.e.FIELD);
                    }
                    i8.s sVarK = l0Var.K();
                    if (sVarK != null) {
                        gVar.z(sb2, sVarK, g8.e.PROPERTY_DELEGATE_FIELD);
                    }
                    if (((q) lVar.G.a(lVar, tVarArr[31])) == q.f4000g) {
                        j0 j0VarB = l0Var.b();
                        if (j0VarB != null) {
                            gVar.z(sb2, j0VarB, g8.e.PROPERTY_GETTER);
                        }
                        k0 k0VarG = l0Var.g();
                        if (k0VarG != null) {
                            gVar.z(sb2, k0VarG, g8.e.PROPERTY_SETTER);
                            List listX0 = k0VarG.x0();
                            q7.k.d(listX0, "setter.valueParameters");
                            r0 r0Var = (r0) d7.r.f1(listX0);
                            q7.k.d(r0Var, "it");
                            gVar.z(sb2, r0Var, g8.e.SETTER_PARAMETER);
                        }
                    }
                }
                List listS = l0Var.S();
                q7.k.d(listS, "property.contextReceiverParameters");
                gVar.D(sb2, listS);
                f8.n nVarC = l0Var.c();
                q7.k.d(nVarC, "property.visibility");
                gVar.i0(nVarC, sb2);
                gVar.O(sb2, gVar.r().contains(h.CONST) && l0Var.D(), "const");
                gVar.L(l0Var, sb2);
                gVar.N(l0Var, sb2);
                gVar.T(l0Var, sb2);
                gVar.O(sb2, gVar.r().contains(h.LATEINIT) && l0Var.V(), "lateinit");
                gVar.K(l0Var, sb2);
            }
            gVar.f0(l0Var, sb2, false);
            List typeParameters = l0Var.getTypeParameters();
            q7.k.d(typeParameters, "property.typeParameters");
            gVar.e0(sb2, typeParameters, true);
            gVar.W(l0Var, sb2);
        }
        gVar.Q(l0Var, sb2, true);
        sb2.append(": ");
        v type = l0Var.getType();
        q7.k.d(type, "property.type");
        sb2.append(gVar.Z(type));
        gVar.X(l0Var, sb2);
        gVar.I(l0Var, sb2);
        List typeParameters2 = l0Var.getTypeParameters();
        q7.k.d(typeParameters2, "property.typeParameters");
        gVar.j0(sb2, typeParameters2);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0054 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int w(f8.w r6) {
        /*
            boolean r0 = r6 instanceof f8.e
            r1 = 4
            r2 = 2
            r3 = 1
            if (r0 == 0) goto L10
            f8.e r6 = (f8.e) r6
            int r6 = r6.B()
            if (r6 != r2) goto L57
            goto L54
        L10:
            f8.j r0 = r6.p()
            boolean r4 = r0 instanceof f8.e
            if (r4 == 0) goto L1b
            f8.e r0 = (f8.e) r0
            goto L1c
        L1b:
            r0 = 0
        L1c:
            if (r0 != 0) goto L1f
            goto L57
        L1f:
            boolean r4 = r6 instanceof f8.c
            if (r4 != 0) goto L24
            goto L57
        L24:
            f8.c r6 = (f8.c) r6
            java.util.Collection r4 = r6.r()
            java.lang.String r5 = "this.overriddenDescriptors"
            q7.k.d(r4, r5)
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L3c
            int r4 = r0.i()
            if (r4 == r3) goto L3c
            goto L55
        L3c:
            int r0 = r0.B()
            if (r0 != r2) goto L57
            f8.n r0 = r6.c()
            f8.n r2 = f8.o.f3488a
            boolean r0 = q7.k.a(r0, r2)
            if (r0 != 0) goto L57
            int r6 = r6.i()
            if (r6 != r1) goto L55
        L54:
            return r1
        L55:
            r6 = 3
            return r6
        L57:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: g9.g.w(f8.w):int");
    }

    public final void B(f8.h hVar, StringBuilder sb2) {
        List listS = hVar.s();
        q7.k.d(listS, "classifier.declaredTypeParameters");
        List parameters = hVar.h().getParameters();
        q7.k.d(parameters, "classifier.typeConstructor.parameters");
        if (v() && hVar.m() && parameters.size() > listS.size()) {
            sb2.append(" /*captured type parameters: ");
            d0(sb2, parameters.subList(listS.size(), parameters.size()));
            sb2.append("*/");
        }
    }

    public final String C(j9.g gVar) {
        if (gVar instanceof j9.b) {
            return d7.r.U0((Iterable) ((j9.b) gVar).f5408a, ", ", "{", "}", new e(this, 1), 24);
        }
        if (gVar instanceof j9.a) {
            return ga.k.z0(y((g8.c) ((j9.a) gVar).f5408a, null), "@");
        }
        if (!(gVar instanceof j9.s)) {
            return gVar.toString();
        }
        j9.r rVar = (j9.r) ((j9.s) gVar).f5408a;
        if (rVar instanceof j9.p) {
            return ((j9.p) rVar).f5415a + "::class";
        }
        if (!(rVar instanceof j9.q)) {
            throw new u();
        }
        j9.f fVar = ((j9.q) rVar).f5416a;
        String strB = fVar.f5406a.b().b();
        int i2 = fVar.f5407b;
        for (int i10 = 0; i10 < i2; i10++) {
            strB = a1.a.e('>', "kotlin.Array<", strB);
        }
        return a1.a.i(strB, "::class");
    }

    public final void D(StringBuilder sb2, List list) {
        if (list.isEmpty()) {
            return;
        }
        sb2.append("context(");
        Iterator it = list.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            int i10 = i2 + 1;
            i8.v vVar = (i8.v) it.next();
            z(sb2, vVar, g8.e.RECEIVER);
            sb2.append(H(vVar.getType()));
            if (i2 == d7.s.t0(list)) {
                sb2.append(") ");
            } else {
                sb2.append(", ");
            }
            i2 = i10;
        }
    }

    public final void E(StringBuilder sb2, z zVar) {
        z(sb2, zVar, null);
        if (v9.c.i(zVar)) {
            boolean z4 = zVar instanceof x9.f;
            l lVar = this.f3942a;
            if (z4 && ((x9.f) zVar).f11294i.f11322g && ((Boolean) lVar.T.a(lVar, l.W[45])).booleanValue()) {
                x9.i iVar = x9.i.f11323a;
                if (z4) {
                    boolean z10 = ((x9.f) zVar).f11294i.f11322g;
                }
                m0 m0VarE0 = zVar.E0();
                q7.k.c(m0VarE0, "null cannot be cast to non-null type org.jetbrains.kotlin.types.error.ErrorTypeConstructor");
                sb2.append(F(((x9.g) m0VarE0).f11300b[0]));
            } else {
                if (!z4 || ((Boolean) lVar.V.a(lVar, l.W[47])).booleanValue()) {
                    sb2.append(zVar.E0().toString());
                } else {
                    sb2.append(((x9.f) zVar).f11298m);
                }
                sb2.append(a0(zVar.C0()));
            }
        } else {
            m0 m0VarE02 = zVar.E0();
            f8.g gVarC = zVar.E0().c();
            i5.l lVarA = f8.v.a(zVar, gVarC instanceof f8.h ? (f8.h) gVarC : null, 0);
            if (lVarA == null) {
                sb2.append(b0(m0VarE02));
                sb2.append(a0(zVar.C0()));
            } else {
                V(sb2, lVarA);
            }
        }
        if (zVar.F0()) {
            sb2.append("?");
        }
        if (zVar instanceof v9.l) {
            sb2.append(" & Any");
        }
    }

    public final String F(String str) {
        int iOrdinal = t().ordinal();
        if (iOrdinal == 0) {
            return str;
        }
        if (iOrdinal == 1) {
            return a1.a.j("<font color=red><b>", str, "</b></font>");
        }
        throw new u();
    }

    public final String G(String str, String str2, c8.h hVar) {
        q7.k.e(str, "lowerRendered");
        q7.k.e(str2, "upperRendered");
        if (a.a.o0(str, str2)) {
            return ga.r.g0(str2, "(", false) ? a1.a.j("(", str, ")!") : str.concat("!");
        }
        String strJ0 = ga.k.J0(q().a(hVar.i(c8.m.B), this), "Collection");
        String strF0 = a.a.f0(str, strJ0.concat("Mutable"), str2, strJ0, strJ0.concat("(Mutable)"));
        if (strF0 != null) {
            return strF0;
        }
        String strF02 = a.a.f0(str, strJ0.concat("MutableMap.MutableEntry"), str2, strJ0.concat("Map.Entry"), strJ0.concat("(Mutable)Map.(Mutable)Entry"));
        if (strF02 != null) {
            return strF02;
        }
        String strJ02 = ga.k.J0(q().a(hVar.j("Array"), this), "Array");
        String strF03 = a.a.f0(str, strJ02.concat(p("Array<")), str2, strJ02.concat(p("Array<out ")), strJ02.concat(p("Array<(out) ")));
        if (strF03 != null) {
            return strF03;
        }
        return "(" + str + ".." + str2 + ')';
    }

    public final String H(v vVar) throws IOException {
        String strZ = Z(vVar);
        return ((!k0(vVar) || x0.e(vVar)) && !(vVar instanceof v9.l)) ? strZ : a1.a.e(')', "(", strZ);
    }

    public final void I(t0 t0Var, StringBuilder sb2) {
        j9.g gVarQ0;
        l lVar = this.f3942a;
        if (!((Boolean) lVar.f3984u.a(lVar, l.W[19])).booleanValue() || (gVarQ0 = t0Var.q0()) == null) {
            return;
        }
        sb2.append(" = ");
        sb2.append(p(C(gVarQ0)));
    }

    public final String J(String str) {
        int iOrdinal = t().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                throw new u();
            }
            l lVar = this.f3942a;
            if (!((Boolean) lVar.U.a(lVar, l.W[46])).booleanValue()) {
                return a1.a.j("<b>", str, "</b>");
            }
        }
        return str;
    }

    public final void K(f8.c cVar, StringBuilder sb2) {
        String str;
        if (r().contains(h.MEMBER_KIND) && v() && cVar.getKind() != 1) {
            sb2.append("/*");
            int kind = cVar.getKind();
            if (kind == 1) {
                str = "DECLARATION";
            } else if (kind == 2) {
                str = "FAKE_OVERRIDE";
            } else if (kind == 3) {
                str = "DELEGATION";
            } else {
                if (kind != 4) {
                    throw null;
                }
                str = "SYNTHESIZED";
            }
            sb2.append(e0.O(str));
            sb2.append("*/ ");
        }
    }

    public final void L(w wVar, StringBuilder sb2) {
        O(sb2, wVar.w(), "external");
        boolean z4 = false;
        O(sb2, r().contains(h.EXPECT) && wVar.Z(), "expect");
        if (r().contains(h.ACTUAL) && wVar.r0()) {
            z4 = true;
        }
        O(sb2, z4, "actual");
    }

    public final void M(int i2, StringBuilder sb2, int i10) {
        String str;
        l lVar = this.f3942a;
        if (((Boolean) lVar.f3979p.a(lVar, l.W[14])).booleanValue() || i2 != i10) {
            boolean zContains = r().contains(h.MODALITY);
            if (i2 == 1) {
                str = "FINAL";
            } else if (i2 == 2) {
                str = "SEALED";
            } else if (i2 == 3) {
                str = "OPEN";
            } else {
                if (i2 != 4) {
                    throw null;
                }
                str = "ABSTRACT";
            }
            O(sb2, zContains, e0.O(str));
        }
    }

    public final void N(f8.c cVar, StringBuilder sb2) {
        if (h9.f.s(cVar) && cVar.i() == 1) {
            return;
        }
        l lVar = this.f3942a;
        if (((o) lVar.A.a(lVar, l.W[25])) == o.f3992f && cVar.i() == 3 && !cVar.r().isEmpty()) {
            return;
        }
        int i2 = cVar.i();
        x.y(i2, "callable.modality");
        M(i2, sb2, w(cVar));
    }

    public final void O(StringBuilder sb2, boolean z4, String str) {
        if (z4) {
            sb2.append(J(str));
            sb2.append(" ");
        }
    }

    public final String P(e9.f fVar, boolean z4) {
        String strP = p(a.a.d0(fVar));
        l lVar = this.f3942a;
        return (((Boolean) lVar.U.a(lVar, l.W[46])).booleanValue() && t() == t.f4003g && z4) ? a1.a.j("<b>", strP, "</b>") : strP;
    }

    public final void Q(f8.j jVar, StringBuilder sb2, boolean z4) {
        e9.f name = jVar.getName();
        q7.k.d(name, "descriptor.name");
        sb2.append(P(name, z4));
    }

    public final void R(StringBuilder sb2, v vVar) throws IOException {
        z0 z0VarH0 = vVar.H0();
        v9.a aVar = z0VarH0 instanceof v9.a ? (v9.a) z0VarH0 : null;
        if (aVar == null) {
            S(sb2, vVar);
            return;
        }
        z zVar = aVar.f10531g;
        l lVar = this.f3942a;
        k kVar = lVar.Q;
        w7.t[] tVarArr = l.W;
        if (((Boolean) kVar.a(lVar, tVarArr[41])).booleanValue()) {
            S(sb2, zVar);
            return;
        }
        S(sb2, aVar.f10532h);
        if (((Boolean) lVar.P.a(lVar, tVarArr[40])).booleanValue()) {
            t tVarT = t();
            r rVar = t.f4003g;
            if (tVarT == rVar) {
                sb2.append("<font color=\"808080\"><i>");
            }
            sb2.append(" /* = ");
            S(sb2, zVar);
            sb2.append(" */");
            if (t() == rVar) {
                sb2.append("</i></font>");
            }
        }
    }

    public final void S(StringBuilder sb2, v vVar) throws IOException {
        e9.f fVarQ;
        String strP;
        l lVar = this.f3942a;
        if ((vVar instanceof v9.x) && lVar.o()) {
            u9.i iVar = ((v9.x) vVar).f10603i;
            if (iVar.f10201h == u9.j.f10202f || iVar.f10201h == u9.j.f10203g) {
                sb2.append("<Not computed yet>");
                return;
            }
        }
        z0 z0VarH0 = vVar.H0();
        if (z0VarH0 instanceof v9.p) {
            sb2.append(((v9.p) z0VarH0).M0(this, this));
            return;
        }
        if (z0VarH0 instanceof z) {
            z zVar = (z) z0VarH0;
            if (zVar.equals(x0.f10605b) || zVar.E0() == x0.f10604a.f11292g) {
                sb2.append("???");
                return;
            }
            m0 m0VarE0 = zVar.E0();
            if ((m0VarE0 instanceof x9.g) && ((x9.g) m0VarE0).f11299a == x9.h.f11309o) {
                if (!((Boolean) lVar.f3983t.a(lVar, l.W[18])).booleanValue()) {
                    sb2.append("???");
                    return;
                }
                m0 m0VarE02 = zVar.E0();
                q7.k.c(m0VarE02, "null cannot be cast to non-null type org.jetbrains.kotlin.types.error.ErrorTypeConstructor");
                sb2.append(F(((x9.g) m0VarE02).f11300b[0]));
                return;
            }
            if (v9.c.i(zVar)) {
                E(sb2, zVar);
                return;
            }
            if (!k0(zVar)) {
                E(sb2, zVar);
                return;
            }
            int length = sb2.length();
            ((g) this.f3943b.getValue()).z(sb2, zVar, null);
            boolean z4 = sb2.length() != length;
            v vVarV = s7.a.v(zVar);
            List listT = s7.a.t(zVar);
            if (!listT.isEmpty()) {
                sb2.append("context(");
                Iterator it = listT.subList(0, d7.s.t0(listT)).iterator();
                while (it.hasNext()) {
                    R(sb2, (v) it.next());
                    sb2.append(", ");
                }
                R(sb2, (v) d7.r.W0(listT));
                sb2.append(") ");
            }
            boolean zE = s7.a.E(zVar);
            boolean zF0 = zVar.F0();
            boolean z10 = zF0 || (z4 && vVarV != null);
            if (z10) {
                if (zE) {
                    sb2.insert(length, '(');
                } else {
                    if (z4) {
                        ib.c.E(ga.k.u0(sb2));
                        if (sb2.charAt(ga.k.o0(sb2) - 1) != ')') {
                            sb2.insert(ga.k.o0(sb2), "()");
                        }
                    }
                    sb2.append("(");
                }
            }
            O(sb2, zE, "suspend");
            if (vVarV != null) {
                boolean z11 = (k0(vVarV) && !vVarV.F0()) || s7.a.E(vVarV) || !vVarV.getAnnotations().isEmpty() || (vVarV instanceof v9.l);
                if (z11) {
                    sb2.append("(");
                }
                R(sb2, vVarV);
                if (z11) {
                    sb2.append(")");
                }
                sb2.append(".");
            }
            sb2.append("(");
            if (!s7.a.B(zVar) || zVar.getAnnotations().b(c8.m.f2045p) == null || zVar.C0().size() > 1) {
                int i2 = 0;
                for (p0 p0Var : s7.a.A(zVar)) {
                    int i10 = i2 + 1;
                    if (i2 > 0) {
                        sb2.append(", ");
                    }
                    if (((Boolean) lVar.S.a(lVar, l.W[43])).booleanValue()) {
                        v vVarB = p0Var.b();
                        q7.k.d(vVarB, "typeProjection.type");
                        fVarQ = s7.a.q(vVarB);
                    } else {
                        fVarQ = null;
                    }
                    if (fVarQ != null) {
                        sb2.append(P(fVarQ, false));
                        sb2.append(": ");
                    }
                    q7.k.e(p0Var, "typeProjection");
                    StringBuilder sb3 = new StringBuilder();
                    d7.r.T0(a.a.S(p0Var), sb3, ", ", null, null, new e(this, 0), 60);
                    String string = sb3.toString();
                    q7.k.d(string, "StringBuilder().apply(builderAction).toString()");
                    sb2.append(string);
                    i2 = i10;
                }
            } else {
                sb2.append("???");
            }
            sb2.append(") ");
            int iOrdinal = t().ordinal();
            if (iOrdinal == 0) {
                strP = p("->");
            } else {
                if (iOrdinal != 1) {
                    throw new u();
                }
                strP = "&rarr;";
            }
            sb2.append(strP);
            sb2.append(" ");
            s7.a.B(zVar);
            v vVarB2 = ((p0) d7.r.W0(zVar.C0())).b();
            q7.k.d(vVarB2, "arguments.last().type");
            R(sb2, vVarB2);
            if (z10) {
                sb2.append(")");
            }
            if (zF0) {
                sb2.append("?");
            }
        }
    }

    public final void T(f8.c cVar, StringBuilder sb2) {
        if (r().contains(h.OVERRIDE) && !cVar.r().isEmpty()) {
            l lVar = this.f3942a;
            if (((o) lVar.A.a(lVar, l.W[25])) != o.f3993g) {
                O(sb2, true, "override");
                if (v()) {
                    sb2.append("/*");
                    sb2.append(cVar.r().size());
                    sb2.append("*/ ");
                }
            }
        }
    }

    public final void U(e9.c cVar, String str, StringBuilder sb2) {
        sb2.append(J(str));
        e9.e eVarI = cVar.i();
        q7.k.d(eVarI, "fqName.toUnsafe()");
        String strP = p(a.a.e0(eVarI.e()));
        if (strP.length() > 0) {
            sb2.append(" ");
            sb2.append(strP);
        }
    }

    public final void V(StringBuilder sb2, i5.l lVar) {
        i5.l lVar2 = (i5.l) lVar.f4689i;
        f8.h hVar = (f8.h) lVar.f4687g;
        if (lVar2 != null) {
            V(sb2, lVar2);
            sb2.append('.');
            e9.f name = hVar.getName();
            q7.k.d(name, "possiblyInnerType.classifierDescriptor.name");
            sb2.append(P(name, false));
        } else {
            m0 m0VarH = hVar.h();
            q7.k.d(m0VarH, "possiblyInnerType.classi…escriptor.typeConstructor");
            sb2.append(b0(m0VarH));
        }
        sb2.append(a0((List) lVar.f4688h));
    }

    public final void W(f8.c cVar, StringBuilder sb2) {
        i8.v vVarI = cVar.I();
        if (vVarI != null) {
            z(sb2, vVarI, g8.e.RECEIVER);
            sb2.append(H(vVarI.getType()));
            sb2.append(".");
        }
    }

    public final void X(f8.c cVar, StringBuilder sb2) {
        i8.v vVarI;
        l lVar = this.f3942a;
        if (((Boolean) lVar.E.a(lVar, l.W[29])).booleanValue() && (vVarI = cVar.I()) != null) {
            sb2.append(" on ");
            sb2.append(Z(vVarI.getType()));
        }
    }

    public final String Z(v vVar) throws IOException {
        q7.k.e(vVar, "type");
        StringBuilder sb2 = new StringBuilder();
        l lVar = this.f3942a;
        R(sb2, (v) ((p7.k) lVar.f3987x.a(lVar, l.W[22])).invoke(vVar));
        String string = sb2.toString();
        q7.k.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @Override // g9.j
    public final void a() {
        this.f3942a.a();
    }

    public final String a0(List list) throws IOException {
        q7.k.e(list, "typeArguments");
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(p("<"));
        d7.r.T0(list, sb2, ", ", null, null, new e(this, 0), 60);
        sb2.append(p(">"));
        String string = sb2.toString();
        q7.k.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @Override // g9.j
    public final void b() {
        this.f3942a.b();
    }

    public final String b0(m0 m0Var) {
        q7.k.e(m0Var, "typeConstructor");
        f8.g gVarC = m0Var.c();
        if (gVarC instanceof q0 ? true : gVarC instanceof f8.e ? true : gVarC instanceof t9.s) {
            q7.k.e(gVarC, "klass");
            return x9.i.f(gVarC) ? gVarC.h().toString() : q().a(gVarC, this);
        }
        if (gVarC == null) {
            return m0Var instanceof v9.u ? ((v9.u) m0Var).f(f.f3935i) : m0Var.toString();
        }
        throw new IllegalStateException(("Unexpected classifier: " + gVarC.getClass()).toString());
    }

    @Override // g9.j
    public final void c() {
        this.f3942a.c();
    }

    public final void c0(q0 q0Var, StringBuilder sb2, boolean z4) {
        String str;
        if (z4) {
            sb2.append(p("<"));
        }
        if (v()) {
            sb2.append("/*");
            sb2.append(q0Var.getIndex());
            sb2.append("*/ ");
        }
        O(sb2, q0Var.N(), "reified");
        int iA0 = q0Var.a0();
        if (iA0 == 1) {
            str = "";
        } else if (iA0 == 2) {
            str = "in";
        } else {
            if (iA0 != 3) {
                throw null;
            }
            str = "out";
        }
        boolean z10 = true;
        O(sb2, str.length() > 0, str);
        z(sb2, q0Var, null);
        Q(q0Var, sb2, z4);
        int size = q0Var.getUpperBounds().size();
        if ((size > 1 && !z4) || size == 1) {
            v vVar = (v) q0Var.getUpperBounds().iterator().next();
            if (vVar == null) {
                c8.h.a(141);
                throw null;
            }
            if (!c8.h.x(vVar) || !vVar.F0()) {
                sb2.append(" : ");
                sb2.append(Z(vVar));
            }
        } else if (z4) {
            for (v vVar2 : q0Var.getUpperBounds()) {
                if (vVar2 == null) {
                    c8.h.a(141);
                    throw null;
                }
                if (!c8.h.x(vVar2) || !vVar2.F0()) {
                    if (z10) {
                        sb2.append(" : ");
                    } else {
                        sb2.append(" & ");
                    }
                    sb2.append(Z(vVar2));
                    z10 = false;
                }
            }
        }
        if (z4) {
            sb2.append(p(">"));
        }
    }

    @Override // g9.j
    public final void d(p pVar) {
        this.f3942a.d(pVar);
    }

    public final void d0(StringBuilder sb2, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            c0((q0) it.next(), sb2, false);
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
    }

    @Override // g9.j
    public final void e(c cVar) {
        this.f3942a.e(cVar);
    }

    public final void e0(StringBuilder sb2, List list, boolean z4) {
        l lVar = this.f3942a;
        if (((Boolean) lVar.f3985v.a(lVar, l.W[20])).booleanValue() || list.isEmpty()) {
            return;
        }
        sb2.append(p("<"));
        d0(sb2, list);
        sb2.append(p(">"));
        if (z4) {
            sb2.append(" ");
        }
    }

    @Override // g9.j
    public final void f(Set set) {
        q7.k.e(set, "<set-?>");
        this.f3942a.f(set);
    }

    public final void f0(t0 t0Var, StringBuilder sb2, boolean z4) {
        if (z4 || !(t0Var instanceof r0)) {
            sb2.append(J(t0Var.F() ? "var" : "val"));
            sb2.append(" ");
        }
    }

    @Override // g9.j
    public final void g() {
        this.f3942a.g();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g0(i8.r0 r11, boolean r12, java.lang.StringBuilder r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g9.g.g0(i8.r0, boolean, java.lang.StringBuilder, boolean):void");
    }

    @Override // g9.j
    public final void h() {
        this.f3942a.h();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h0(java.lang.StringBuilder r8, java.util.List r9, boolean r10) {
        /*
            r7 = this;
            g9.l r0 = r7.f3942a
            g9.k r1 = r0.D
            w7.t[] r2 = g9.l.W
            r3 = 28
            r2 = r2[r3]
            java.lang.Object r0 = r1.a(r0, r2)
            g9.p r0 = (g9.p) r0
            int r0 = r0.ordinal()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L27
            if (r0 == r2) goto L25
            r10 = 2
            if (r0 != r10) goto L1f
        L1d:
            r10 = r1
            goto L28
        L1f:
            a4.u r7 = new a4.u
            r7.<init>()
            throw r7
        L25:
            if (r10 != 0) goto L1d
        L27:
            r10 = r2
        L28:
            int r0 = r9.size()
            g9.d r3 = r7.u()
            r3.getClass()
            java.lang.String r3 = "builder"
            q7.k.e(r8, r3)
            java.lang.String r3 = "("
            r8.append(r3)
            java.util.Iterator r9 = r9.iterator()
            r3 = r1
        L42:
            boolean r4 = r9.hasNext()
            if (r4 == 0) goto L71
            int r4 = r3 + 1
            java.lang.Object r5 = r9.next()
            i8.r0 r5 = (i8.r0) r5
            g9.d r6 = r7.u()
            r6.getClass()
            java.lang.String r6 = "parameter"
            q7.k.e(r5, r6)
            r7.g0(r5, r10, r8, r1)
            g9.d r5 = r7.u()
            r5.getClass()
            int r5 = r0 + (-1)
            if (r3 == r5) goto L6f
            java.lang.String r3 = ", "
            r8.append(r3)
        L6f:
            r3 = r4
            goto L42
        L71:
            g9.d r7 = r7.u()
            r7.getClass()
            java.lang.String r7 = ")"
            r8.append(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g9.g.h0(java.lang.StringBuilder, java.util.List, boolean):void");
    }

    @Override // g9.j
    public final Set i() {
        return this.f3942a.i();
    }

    public final boolean i0(f8.n nVar, StringBuilder sb2) {
        if (!r().contains(h.VISIBILITY)) {
            return false;
        }
        l lVar = this.f3942a;
        k kVar = lVar.f3977n;
        w7.t[] tVarArr = l.W;
        if (((Boolean) kVar.a(lVar, tVarArr[12])).booleanValue()) {
            nVar = f8.o.f(nVar.f3485a.c());
        }
        if (!((Boolean) lVar.f3978o.a(lVar, tVarArr[13])).booleanValue() && q7.k.a(nVar, f8.o.f3497j)) {
            return false;
        }
        sb2.append(J(nVar.f3485a.b()));
        sb2.append(" ");
        return true;
    }

    @Override // g9.j
    public final a j() {
        return this.f3942a.j();
    }

    public final void j0(StringBuilder sb2, List list) {
        l lVar = this.f3942a;
        if (((Boolean) lVar.f3985v.a(lVar, l.W[20])).booleanValue()) {
            return;
        }
        ArrayList arrayList = new ArrayList(0);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            q0 q0Var = (q0) it.next();
            List upperBounds = q0Var.getUpperBounds();
            q7.k.d(upperBounds, "typeParameter.upperBounds");
            for (v vVar : d7.r.K0(upperBounds, 1)) {
                StringBuilder sb3 = new StringBuilder();
                e9.f name = q0Var.getName();
                q7.k.d(name, "typeParameter.name");
                sb3.append(P(name, false));
                sb3.append(" : ");
                q7.k.d(vVar, "it");
                sb3.append(Z(vVar));
                arrayList.add(sb3.toString());
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        sb2.append(" ");
        sb2.append(J("where"));
        sb2.append(" ");
        d7.r.T0(arrayList, sb2, ", ", null, null, null, 124);
    }

    @Override // g9.j
    public final void k(LinkedHashSet linkedHashSet) {
        this.f3942a.k(linkedHashSet);
    }

    @Override // g9.j
    public final void l() {
        this.f3942a.l();
    }

    @Override // g9.j
    public final void m() {
        this.f3942a.m();
    }

    @Override // g9.j
    public final void n() {
        this.f3942a.n();
    }

    public final String p(String str) {
        return t().a(str);
    }

    public final c q() {
        l lVar = this.f3942a;
        return (c) lVar.f3965b.a(lVar, l.W[0]);
    }

    public final Set r() {
        l lVar = this.f3942a;
        return (Set) lVar.f3968e.a(lVar, l.W[3]);
    }

    public final boolean s() {
        l lVar = this.f3942a;
        return ((Boolean) lVar.f3969f.a(lVar, l.W[4])).booleanValue();
    }

    public final t t() {
        l lVar = this.f3942a;
        return (t) lVar.C.a(lVar, l.W[27]);
    }

    public final d u() {
        l lVar = this.f3942a;
        return (d) lVar.B.a(lVar, l.W[26]);
    }

    public final boolean v() {
        l lVar = this.f3942a;
        return ((Boolean) lVar.f3973j.a(lVar, l.W[8])).booleanValue();
    }

    public final String x(f8.j jVar) {
        f8.j jVarP;
        String str;
        q7.k.e(jVar, "declarationDescriptor");
        StringBuilder sb2 = new StringBuilder();
        jVar.P(new a7.d(10, this), sb2);
        l lVar = this.f3942a;
        k kVar = lVar.f3966c;
        w7.t[] tVarArr = l.W;
        if (((Boolean) kVar.a(lVar, tVarArr[1])).booleanValue() && !(jVar instanceof f8.e0) && !(jVar instanceof i0) && (jVarP = jVar.p()) != null && !(jVarP instanceof f8.z)) {
            sb2.append(" ");
            int iOrdinal = t().ordinal();
            if (iOrdinal == 0) {
                str = "defined in";
            } else {
                if (iOrdinal != 1) {
                    throw new u();
                }
                str = "<i>defined in</i>";
            }
            sb2.append(str);
            sb2.append(" ");
            e9.e eVarG = h9.f.g(jVarP);
            q7.k.d(eVarG, "getFqName(containingDeclaration)");
            sb2.append(eVarG.f3193a.isEmpty() ? "root package" : p(a.a.e0(eVarG.e())));
            if (((Boolean) lVar.f3967d.a(lVar, tVarArr[2])).booleanValue() && (jVarP instanceof f8.e0) && (jVar instanceof f8.k)) {
                ((f8.k) jVar).q().getClass();
            }
        }
        String string = sb2.toString();
        q7.k.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String y(g8.c cVar, g8.e eVar) throws IOException {
        i8.i iVarK0;
        List listX0;
        q7.k.e(cVar, "annotation");
        StringBuilder sb2 = new StringBuilder();
        sb2.append('@');
        if (eVar != null) {
            sb2.append(eVar.f3882f + ':');
        }
        v type = cVar.getType();
        sb2.append(Z(type));
        l lVar = this.f3942a;
        if (i.getIncludeAnnotationArguments(lVar)) {
            Map mapB = cVar.b();
            d7.z zVar = null;
            f8.e eVarD = ((Boolean) lVar.H.a(lVar, l.W[32])).booleanValue() ? l9.d.d(cVar) : null;
            if (eVarD != null && (iVarK0 = eVarD.k0()) != null && (listX0 = iVarK0.x0()) != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : listX0) {
                    if (((r0) obj).H0()) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(d7.t.A0(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((r0) it.next()).getName());
                }
                zVar = arrayList2;
            }
            if (zVar == null) {
                zVar = d7.z.f2978f;
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : zVar) {
                e9.f fVar = (e9.f) obj2;
                q7.k.d(fVar, "it");
                if (!mapB.containsKey(fVar)) {
                    arrayList3.add(obj2);
                }
            }
            ArrayList arrayList4 = new ArrayList(d7.t.A0(arrayList3, 10));
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                arrayList4.add(((e9.f) it2.next()).b() + " = ...");
            }
            Set<Map.Entry> setEntrySet = mapB.entrySet();
            ArrayList arrayList5 = new ArrayList(d7.t.A0(setEntrySet, 10));
            for (Map.Entry entry : setEntrySet) {
                e9.f fVar2 = (e9.f) entry.getKey();
                j9.g gVar = (j9.g) entry.getValue();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(fVar2.b());
                sb3.append(" = ");
                sb3.append(!zVar.contains(fVar2) ? C(gVar) : "...");
                arrayList5.add(sb3.toString());
            }
            List listI1 = d7.r.i1(d7.r.c1(arrayList4, arrayList5));
            if (i.getIncludeEmptyAnnotationArguments(lVar) || !listI1.isEmpty()) {
                d7.r.T0(listI1, sb2, ", ", "(", ")", null, 112);
            }
        }
        if (v() && (v9.c.i(type) || (type.E0().c() instanceof c0))) {
            sb2.append(" /* annotation class not found */");
        }
        String string = sb2.toString();
        q7.k.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final void z(StringBuilder sb2, g8.a aVar, g8.e eVar) {
        if (r().contains(h.ANNOTATIONS)) {
            boolean z4 = aVar instanceof v;
            l lVar = this.f3942a;
            Set setI = z4 ? lVar.i() : (Set) lVar.J.a(lVar, l.W[34]);
            p7.k kVar = (p7.k) lVar.L.a(lVar, l.W[36]);
            for (g8.c cVar : aVar.getAnnotations()) {
                if (!d7.r.I0(setI, cVar.a()) && !q7.k.a(cVar.a(), c8.m.f2047r) && (kVar == null || ((Boolean) kVar.invoke(cVar)).booleanValue())) {
                    sb2.append(y(cVar, eVar));
                    if (((Boolean) lVar.I.a(lVar, l.W[33])).booleanValue()) {
                        sb2.append('\n');
                    } else {
                        sb2.append(" ");
                    }
                }
            }
        }
    }
}
