package rc;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.stepos.core.ability.AbilityType;
import io.ktor.util.date.GMTDateParser;
import java.lang.Character;
import java.util.Map;
import java.util.StringTokenizer;
import org.scilab.forge.jlatexmath.ParseException;
import org.scilab.forge.jlatexmath.SymbolNotFoundException;
import rc.a1;

/* renamed from: rc.x0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5316x0 {
    static {
        C5293l0.e("array", "\\array@@env{#1}{", "}", 1);
        C5293l0.e("tabular", "\\array@@env{#1}{", "}", 1);
        C5293l0.e("matrix", "\\matrix@@env{", "}", 0);
        C5293l0.e("smallmatrix", "\\smallmatrix@@env{", "}", 0);
        C5293l0.e("pmatrix", "\\left(\\begin{matrix}", "\\end{matrix}\\right)", 0);
        C5293l0.e("bmatrix", "\\left[\\begin{matrix}", "\\end{matrix}\\right]", 0);
        C5293l0.e("Bmatrix", "\\left\\{\\begin{matrix}", "\\end{matrix}\\right\\}", 0);
        C5293l0.e("vmatrix", "\\left|\\begin{matrix}", "\\end{matrix}\\right|", 0);
        C5293l0.e("Vmatrix", "\\left\\|\\begin{matrix}", "\\end{matrix}\\right\\|", 0);
        C5293l0.e("eqnarray", "\\begin{array}{rcl}", "\\end{array}", 0);
        C5293l0.e("align", "\\align@@env{", "}", 0);
        C5293l0.e("flalign", "\\flalign@@env{", "}", 0);
        C5293l0.e("alignat", "\\alignat@@env{#1}{", "}", 1);
        C5293l0.e("aligned", "\\aligned@@env{", "}", 0);
        C5293l0.e("alignedat", "\\alignedat@@env{#1}{", "}", 1);
        C5293l0.e("multline", "\\multline@@env{", "}", 0);
        C5293l0.e("cases", "\\left\\{\\begin{array}{l@{\\!}l}", "\\end{array}\\right.", 0);
        C5293l0.e("split", "\\begin{array}{rl}", "\\end{array}", 0);
        C5293l0.e("gather", "\\gather@@env{", "}", 0);
        C5293l0.e("gathered", "\\gathered@@env{", "}", 0);
        C5293l0.e(AbilityType.MATH, "\\(", "\\)", 0);
        C5293l0.e("displaymath", "\\[", "\\]", 0);
        C5291k0.a("operatorname", "\\mathop{\\mathrm{#1}}\\nolimits ", 1);
        C5291k0.a("DeclareMathOperator", "\\newcommand{#1}{\\mathop{\\mathrm{#2}}\\nolimits}", 2);
        C5291k0.a("substack", "{\\scriptstyle\\begin{array}{c}#1\\end{array}}", 1);
        C5291k0.a("dfrac", "\\genfrac{}{}{}{}{#1}{#2}", 2);
        C5291k0.a("tfrac", "\\genfrac{}{}{}{1}{#1}{#2}", 2);
        C5291k0.a("dbinom", "\\genfrac{(}{)}{0pt}{}{#1}{#2}", 2);
        C5291k0.a("tbinom", "\\genfrac{(}{)}{0pt}{1}{#1}{#2}", 2);
        C5291k0.a("pmod", "\\qquad\\mathbin{(\\mathrm{mod}\\ #1)}", 1);
        C5291k0.a("mod", "\\qquad\\mathbin{\\mathrm{mod}\\ #1}", 1);
        C5291k0.a("pod", "\\qquad\\mathbin{(#1)}", 1);
        C5291k0.a("dddot", "\\mathop{#1}\\limits^{...}", 1);
        C5291k0.a("ddddot", "\\mathop{#1}\\limits^{....}", 1);
        C5291k0.a("spdddot", "^{\\mathrm{...}}", 0);
        C5291k0.a("spbreve", "^{\\makeatletter\\sp@breve\\makeatother}", 0);
        C5291k0.a("sphat", "^{\\makeatletter\\sp@hat\\makeatother}", 0);
        C5291k0.a("spddot", "^{\\displaystyle..}", 0);
        C5291k0.a("spcheck", "^{\\vee}", 0);
        C5291k0.a("sptilde", "^{\\sim}", 0);
        C5291k0.a("spdot", "^{\\displaystyle.}", 0);
        C5291k0.a(Const.INTENT_KEY_UMID, "\\underaccent{\\dot}{#1}", 1);
        C5291k0.a(Const.INTENT_KEY_PKGNAME, "\\underaccent{\\bar}{#1}", 1);
        C5291k0.a("Bra", "\\left\\langle{#1}\\right\\vert", 1);
        C5291k0.a("Ket", "\\left\\vert{#1}\\right\\rangle", 1);
        C5291k0.a("textsuperscript", "{}^{\\text{#1}}", 1);
        C5291k0.a("textsubscript", "{}_{\\text{#1}}", 1);
        C5291k0.a("textit", "\\mathit{\\text{#1}}", 1);
        C5291k0.a("textbf", "\\mathbf{\\text{#1}}", 1);
        C5291k0.a("textsf", "\\mathsf{\\text{#1}}", 1);
        C5291k0.a("texttt", "\\mathtt{\\text{#1}}", 1);
        C5291k0.a("textrm", "\\text{#1}", 1);
        C5291k0.a("degree", "^\\circ", 0);
        C5291k0.a(JsonPOJOBuilder.DEFAULT_WITH_PREFIX, "\\mathbin{\\&}", 0);
        C5291k0.a("parr", "\\mathbin{\\rotatebox[origin=c]{180}{\\&}}", 0);
        C5291k0.a("copyright", "\\textcircled{\\raisebox{0.2ex}{c}}", 0);
        C5291k0.a("L", "\\mathrm{\\polishlcross L}", 0);
        C5291k0.a("l", "\\mathrm{\\polishlcross l}", 0);
        C5291k0.a("Join", "\\mathop{\\rlap{\\ltimes}\\rtimes}", 0);
    }

    public static final AbstractC5276d A(d1 d1Var, String[] strArr) throws ParseException, NumberFormatException {
        C5274c c5274c = new C5274c();
        new d1(d1Var.o(), strArr[2], c5274c, false).F();
        c5274c.q();
        if (c5274c.f39231p == Integer.parseInt(strArr[1]) * 2) {
            return new C5279e0(d1Var.o(), c5274c, 7);
        }
        throw new ParseException("Bad number of equations in alignedat environment !");
    }

    public static final AbstractC5276d A0(d1 d1Var, String[] strArr) throws ParseException {
        AbstractC5276d abstractC5276d;
        a1 a1Var = new a1(d1Var, strArr[1], false);
        a1 a1Var2 = new a1(d1Var, strArr[2], false);
        AbstractC5276d abstractC5276d2 = a1Var.f39212d;
        if (abstractC5276d2 == null || (abstractC5276d = a1Var2.f39212d) == null) {
            throw new ParseException("Both numerator and denominator of a fraction can't be empty!");
        }
        return new G(abstractC5276d2, abstractC5276d, true);
    }

    public static final AbstractC5276d A1(d1 d1Var, String[] strArr) throws ParseException {
        return new E0(new a1(d1Var, strArr[1], false).f39212d);
    }

    public static final AbstractC5276d A2(d1 d1Var, String[] strArr) throws ParseException {
        AbstractC5276d abstractC5276d = new a1(d1Var, strArr[1]).f39212d;
        abstractC5276d.f39250c = 0;
        return abstractC5276d;
    }

    public static final AbstractC5276d B(d1 d1Var, String[] strArr) throws ParseException {
        I0 i02 = new I0(W0.p("approx"));
        i02.i(new R0(0, -0.095f, 0.0f, 0.0f));
        i02.i(new k1(W0.p("normaldot"), W0.p("normaldot"), 5, 5.2f, false, true));
        return new i1(3, 3, i02);
    }

    public static final AbstractC5276d B0(d1 d1Var, String[] strArr) throws ParseException {
        C5274c c5274c = new C5274c();
        new d1(d1Var.o(), strArr[1], c5274c, false).F();
        c5274c.q();
        int i10 = c5274c.f39231p;
        if (i10 > 1) {
            throw new ParseException("Character '&' is only available in array mode !");
        }
        if (i10 == 0) {
            return null;
        }
        return new C5289j0(d1Var.o(), c5274c, 1);
    }

    public static final AbstractC5276d B1(d1 d1Var, String[] strArr) throws ParseException {
        return new S0(new a1(d1Var, strArr[1], false).f39212d);
    }

    public static final AbstractC5276d B2(d1 d1Var, String[] strArr) throws ParseException {
        AbstractC5276d abstractC5276d = new a1(d1Var, strArr[1]).f39212d;
        abstractC5276d.f39250c = 1;
        return abstractC5276d;
    }

    public static final AbstractC5276d C(d1 d1Var, String[] strArr) throws ParseException {
        I0 i02 = new I0(W0.p("approx"));
        i02.i(new R0(0, -0.095f, 0.0f, 0.0f));
        k1 k1Var = new k1(W0.p("normaldot"), W0.p("normaldot"), 5, 5.2f, false, true);
        i02.i(k1Var);
        i02.i(k1Var);
        return new i1(3, 3, i02);
    }

    public static final AbstractC5276d C0(d1 d1Var, String[] strArr) throws ParseException {
        C5274c c5274c = new C5274c();
        new d1(d1Var.o(), strArr[1], c5274c, false).F();
        c5274c.q();
        int i10 = c5274c.f39231p;
        if (i10 > 1) {
            throw new ParseException("Character '&' is only available in array mode !");
        }
        if (i10 == 0) {
            return null;
        }
        return new C5289j0(d1Var.o(), c5274c, 2);
    }

    public static final AbstractC5276d C1(d1 d1Var, String[] strArr) throws ParseException {
        return new h1(new a1(d1Var, strArr[1], false).f39212d);
    }

    public static final AbstractC5276d C2(d1 d1Var, String[] strArr) throws ParseException {
        a1 a1Var = new a1();
        a1Var.d(new C5312v0(new a1(d1Var, strArr[3]).f39212d, false, true, true));
        a1Var.h(d1Var.o(), strArr[1]);
        a1Var.d(new R0(5, -0.3f, 0.0f, 0.0f));
        a1Var.h(d1Var.o(), strArr[3] + "\\nolimits" + strArr[2]);
        return new i1(0, 0, a1Var.f39212d);
    }

    public static final AbstractC5276d D(d1 d1Var, String[] strArr) throws ParseException {
        C5274c c5274c = new C5274c();
        new d1(d1Var.o(), strArr[2], c5274c, false).F();
        c5274c.q();
        return new C5279e0(d1Var.o(), c5274c, strArr[1], true);
    }

    public static final AbstractC5276d D0(d1 d1Var, String[] strArr) throws ParseException {
        boolean z10;
        AbstractC5276d abstractC5276d;
        AbstractC5276d abstractC5276d2 = new a1(d1Var, strArr[1], false).f39212d;
        W0 w02 = abstractC5276d2 instanceof W0 ? (W0) abstractC5276d2 : null;
        AbstractC5276d abstractC5276d3 = new a1(d1Var, strArr[2], false).f39212d;
        W0 w03 = abstractC5276d3 instanceof W0 ? (W0) abstractC5276d3 : null;
        float[] fArrK = R0.k(strArr[3]);
        String str = strArr[3];
        if (str == null || str.length() == 0 || fArrK.length == 1) {
            fArrK = new float[]{0.0f, 0.0f};
            z10 = false;
        } else {
            z10 = true;
        }
        int i10 = strArr[4].length() != 0 ? Integer.parseInt(strArr[4]) : 0;
        a1 a1Var = new a1(d1Var, strArr[5], false);
        a1 a1Var2 = new a1(d1Var, strArr[6], false);
        AbstractC5276d abstractC5276d4 = a1Var.f39212d;
        if (abstractC5276d4 == null || (abstractC5276d = a1Var2.f39212d) == null) {
            throw new ParseException("Both numerator and denominator of a fraction can't be empty!");
        }
        G g10 = new G(abstractC5276d4, abstractC5276d, z10, (int) fArrK[0], fArrK[1]);
        I0 i02 = new I0();
        i02.i(new V0(i10 * 2, new D(g10, w02, w03)));
        return i02;
    }

    public static final AbstractC5276d D1(d1 d1Var, String[] strArr) throws ParseException {
        C5274c c5274c = new C5274c();
        new d1(d1Var.o(), strArr[1], c5274c, false).F();
        c5274c.q();
        return new C5279e0(d1Var.o(), c5274c, 1);
    }

    public static final AbstractC5276d D2(d1 d1Var, String[] strArr) throws ParseException {
        I0 i02 = new I0(W0.p("sim"));
        i02.i(new R0(0, -0.095f, 0.0f, 0.0f));
        i02.i(new k1(W0.p("normaldot"), W0.p("normaldot"), 5, 5.2f, false, true));
        return new i1(3, 3, i02);
    }

    public static final AbstractC5276d E(d1 d1Var, String[] strArr) throws ParseException {
        AbstractC5276d abstractC5276dL = d1Var.l();
        AbstractC5276d abstractC5276d = new a1(d1Var, d1Var.t(), false).f39212d;
        if (abstractC5276dL == null || abstractC5276d == null) {
            throw new ParseException("Both numerator and denominator of a fraction can't be empty!");
        }
        return new G(abstractC5276dL, abstractC5276d, false);
    }

    public static final AbstractC5276d E0(d1 d1Var, String[] strArr) throws ParseException {
        I0 i02 = new I0(W0.p("normaldot"));
        i02.i(new R0(5, 4.0f, 0.0f, 0.0f));
        i02.i(W0.p("normaldot"));
        return new i1(3, 3, new k1(W0.p("minus"), i02, 5, -3.4f, false, i02, 5, -3.4f, false));
    }

    public static final AbstractC5276d E1(d1 d1Var, String[] strArr) throws ParseException {
        return new V0(2, new E0(new a1(d1Var, strArr[1], "mathnormal", false, false).f39212d));
    }

    public static final AbstractC5276d E2(d1 d1Var, String[] strArr) throws ParseException {
        I0 i02 = new I0(W0.p("sim"));
        i02.i(new R0(0, -0.095f, 0.0f, 0.0f));
        k1 k1Var = new k1(W0.p("normaldot"), W0.p("normaldot"), 5, 5.2f, false, true);
        i02.i(k1Var);
        i02.i(k1Var);
        return new i1(3, 3, i02);
    }

    public static final AbstractC5276d F(d1 d1Var, String[] strArr) throws ParseException {
        AbstractC5276d abstractC5276dL = d1Var.l();
        AbstractC5276d abstractC5276d = new a1(d1Var, d1Var.t(), false).f39212d;
        if (abstractC5276dL == null || abstractC5276d == null) {
            throw new ParseException("Both numerator and denominator of a fraction can't be empty!");
        }
        AbstractC5276d abstractC5276d2 = new a1(d1Var, strArr[1], false).f39212d;
        if (abstractC5276d2 instanceof C5278e) {
            abstractC5276d2 = ((C5278e) abstractC5276d2).f39268d;
        }
        AbstractC5276d abstractC5276d3 = new a1(d1Var, strArr[2], false).f39212d;
        if (abstractC5276d3 instanceof C5278e) {
            abstractC5276d3 = ((C5278e) abstractC5276d3).f39268d;
        }
        if ((abstractC5276d2 instanceof W0) && (abstractC5276d3 instanceof W0)) {
            return new D(new G(abstractC5276dL, abstractC5276d, false), (W0) abstractC5276d2, (W0) abstractC5276d3);
        }
        I0 i02 = new I0();
        i02.i(abstractC5276d2);
        i02.i(new G(abstractC5276dL, abstractC5276d, false));
        i02.i(abstractC5276d3);
        return i02;
    }

    public static final AbstractC5276d F0(d1 d1Var, String[] strArr) throws ParseException {
        return new C5270a(new a1(d1Var, strArr[2], false).f39212d, new a1(d1Var, strArr[1], false).f39212d, false);
    }

    public static final AbstractC5276d F1(d1 d1Var, String[] strArr) throws ParseException {
        return new C5283g0(new a1(d1Var, strArr[1]).f39212d);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final rc.AbstractC5276d F2(rc.d1 r7, java.lang.String[] r8) throws org.scilab.forge.jlatexmath.ParseException {
        /*
            r0 = 0
            r1 = r8[r0]
            java.lang.String r2 = "tiny"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto Lf
            r8 = 1056964608(0x3f000000, float:0.5)
            goto L8b
        Lf:
            java.lang.String r1 = "scriptsize"
            r2 = r8[r0]
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L1e
            r8 = 1060320051(0x3f333333, float:0.7)
            goto L8b
        L1e:
            java.lang.String r1 = "footnotesize"
            r2 = r8[r0]
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L2c
            r8 = 1061997773(0x3f4ccccd, float:0.8)
            goto L8b
        L2c:
            java.lang.String r1 = "small"
            r2 = r8[r0]
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L3a
            r8 = 1063675494(0x3f666666, float:0.9)
            goto L8b
        L3a:
            java.lang.String r1 = "normalsize"
            r2 = r8[r0]
            boolean r1 = r1.equals(r2)
            r2 = 1065353216(0x3f800000, float:1.0)
            if (r1 == 0) goto L48
        L46:
            r8 = r2
            goto L8b
        L48:
            java.lang.String r1 = "large"
            r3 = r8[r0]
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L56
            r8 = 1067030938(0x3f99999a, float:1.2)
            goto L8b
        L56:
            java.lang.String r1 = "Large"
            r3 = r8[r0]
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L64
            r8 = 1068708659(0x3fb33333, float:1.4)
            goto L8b
        L64:
            java.lang.String r1 = "LARGE"
            r3 = r8[r0]
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L72
            r8 = 1072064102(0x3fe66666, float:1.8)
            goto L8b
        L72:
            java.lang.String r1 = "huge"
            r3 = r8[r0]
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L7f
            r8 = 1073741824(0x40000000, float:2.0)
            goto L8b
        L7f:
            java.lang.String r1 = "Huge"
            r8 = r8[r0]
            boolean r8 = r1.equals(r8)
            if (r8 == 0) goto L46
            r8 = 1075838976(0x40200000, float:2.5)
        L8b:
            rc.h0 r0 = new rc.h0
            rc.a1 r1 = new rc.a1
            java.lang.String r3 = r7.t()
            r5 = 0
            boolean r6 = r7.z()
            r4 = 0
            r2 = r7
            r1.<init>(r2, r3, r4, r5, r6)
            rc.d r7 = r1.f39212d
            r0.<init>(r7, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rc.C5316x0.F2(rc.d1, java.lang.String[]):rc.d");
    }

    public static final AbstractC5276d G(d1 d1Var, String[] strArr) throws ParseException {
        return l0(d1Var, strArr);
    }

    public static final AbstractC5276d G0(d1 d1Var, String[] strArr) throws ParseException, NumberFormatException {
        int i10 = Integer.parseInt(strArr[1]);
        String str = strArr[2];
        d1Var.a(new O(i10, str != null ? Float.parseFloat(str) : 1.0f));
        ((C5274c) d1Var.f39255a).o(i10);
        return null;
    }

    public static final AbstractC5276d G1(d1 d1Var, String[] strArr) throws ParseException {
        I0 i02 = new I0(W0.p("minus"));
        i02.i(new R0(0, -0.095f, 0.0f, 0.0f));
        i02.i(new k1(W0.p("normaldot"), W0.p("normaldot"), 5, 5.2f, false, true));
        return new i1(3, 3, i02);
    }

    public static final AbstractC5276d G2(d1 d1Var, String[] strArr) throws ParseException {
        return new i1(3, 3, new k1(W0.p("equals"), W0.p("smallfrown"), 5, -2.0f, true, true));
    }

    public static final AbstractC5276d H(d1 d1Var, String[] strArr) throws ParseException {
        return X("langle", "rangle", d1Var, strArr);
    }

    public static final AbstractC5276d H0(d1 d1Var, String[] strArr) throws ParseException {
        if (d1Var.y()) {
            return new P();
        }
        throw new ParseException("The macro \\hline is only available in array mode !");
    }

    public static final AbstractC5276d H1(d1 d1Var, String[] strArr) throws ParseException {
        I0 i02 = new I0(W0.p("minus"));
        i02.i(new R0(0, -0.095f, 0.0f, 0.0f));
        k1 k1Var = new k1(W0.p("normaldot"), W0.p("normaldot"), 5, 5.2f, false, true);
        i02.i(k1Var);
        i02.i(k1Var);
        return new i1(3, 3, i02);
    }

    public static final AbstractC5276d H2(d1 d1Var, String[] strArr) throws ParseException {
        C5274c c5274c = new C5274c();
        new d1(d1Var.o(), strArr[1], c5274c, false).F();
        c5274c.q();
        return new C5279e0(d1Var.o(), c5274c, 5);
    }

    public static final AbstractC5276d I(d1 d1Var, String[] strArr) throws ParseException {
        return new C5282g(new E0(new a1(d1Var, d1Var.t(), null, false, d1Var.z()).f39212d));
    }

    public static final AbstractC5276d I0(d1 d1Var, String[] strArr) throws ParseException {
        return new C5312v0(new a1(d1Var, strArr[1], false).f39212d, true, false, false);
    }

    public static final AbstractC5276d I1(d1 d1Var, String[] strArr) throws ParseException, NumberFormatException {
        int i10 = Integer.parseInt(strArr[1]);
        d1Var.a(new C5287i0(i10, strArr[2], new a1(d1Var, strArr[3]).f39212d));
        ((C5274c) d1Var.f39255a).o(i10);
        return null;
    }

    public static final AbstractC5276d I2(d1 d1Var, String[] strArr) throws ParseException {
        return new Q0(new a1(d1Var, strArr[1], false).f39212d, strArr[2]);
    }

    public static final AbstractC5276d J(d1 d1Var, String[] strArr) throws ParseException {
        try {
            return new C5302q(new a1(d1Var, strArr[2]).f39212d, C5302q.j(strArr[1]), null);
        } catch (NumberFormatException e10) {
            throw new ParseException(e10.toString());
        }
    }

    public static final AbstractC5276d J0(d1 d1Var, String[] strArr) throws ParseException {
        I0 i02 = new I0(new R0(1, -0.1f, 0.0f, 0.0f));
        i02.i(W0.p("bar"));
        o1 o1Var = new o1(new C5271a0(i02, 'r'));
        o1Var.o(1, -0.1f);
        I0 i03 = new I0(o1Var);
        i03.i(new E0(new C5294m(GMTDateParser.HOURS, d1Var.f39255a.f39213e)));
        return i03;
    }

    public static final AbstractC5276d J1(d1 d1Var, String[] strArr) throws ParseException {
        C5274c c5274c = new C5274c();
        new d1(d1Var.o(), strArr[1], c5274c, false).F();
        c5274c.q();
        int i10 = c5274c.f39231p;
        if (i10 > 1) {
            throw new ParseException("Character '&' is only available in array mode !");
        }
        if (i10 == 0) {
            return null;
        }
        return new C5289j0(d1Var.o(), c5274c, 0);
    }

    public static final AbstractC5276d J2(d1 d1Var, String[] strArr) throws ParseException {
        o1 o1Var = new o1(new a1("\\displaystyle\\!\\breve{}").f39212d);
        o1Var.o(1, 0.6f);
        return new Q0(o1Var, null);
    }

    public static final AbstractC5276d K(d1 d1Var, String[] strArr) throws ParseException {
        AbstractC5276d abstractC5276d = new a1(d1Var, strArr[1], false).f39212d;
        return !(abstractC5276d instanceof W0) ? abstractC5276d : new C5278e((W0) abstractC5276d, 1);
    }

    public static final AbstractC5276d K0(d1 d1Var, String[] strArr) throws ParseException, NumberFormatException {
        int i10 = 0;
        while (i10 < strArr[1].length() && !Character.isLetter(strArr[1].charAt(i10))) {
            i10++;
        }
        try {
            float f10 = Float.parseFloat(strArr[1].substring(0, i10));
            int iN = i10 != strArr[1].length() ? R0.n(strArr[1].substring(i10).toLowerCase()) : 3;
            if (iN != -1) {
                return strArr[0].charAt(0) == 'h' ? new R0(iN, f10, 0.0f, 0.0f) : new R0(iN, 0.0f, f10, 0.0f);
            }
            throw new ParseException("Unknown unit \"" + strArr[1].substring(i10) + "\" !");
        } catch (NumberFormatException e10) {
            throw new ParseException(e10.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000c A[PHI: r1
      0x000c: PHI (r1v7 int) = (r1v1 int), (r1v1 int), (r1v5 int), (r1v5 int) binds: [B:3:0x000a, B:12:0x0031, B:21:0x0053, B:24:0x005e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final rc.AbstractC5276d K1(rc.d1 r5, java.lang.String[] r6) throws org.scilab.forge.jlatexmath.ParseException {
        /*
            r5 = 0
            r0 = r6[r5]
            java.lang.String r1 = ","
            boolean r0 = r0.equals(r1)
            r1 = 1
            if (r0 == 0) goto Lf
        Lc:
            r5 = r1
            goto L78
        Lf:
            r0 = r6[r5]
            java.lang.String r2 = ":"
            boolean r0 = r0.equals(r2)
            r2 = 2
            if (r0 == 0) goto L1c
        L1a:
            r5 = r2
            goto L78
        L1c:
            r0 = r6[r5]
            java.lang.String r3 = ";"
            boolean r0 = r0.equals(r3)
            r3 = 3
            if (r0 == 0) goto L29
        L27:
            r5 = r3
            goto L78
        L29:
            r0 = r6[r5]
            java.lang.String r4 = "thinspace"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L34
            goto Lc
        L34:
            r0 = r6[r5]
            java.lang.String r1 = "medspace"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L3f
            goto L1a
        L3f:
            r0 = r6[r5]
            java.lang.String r1 = "thickspace"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L4a
            goto L27
        L4a:
            r0 = r6[r5]
            java.lang.String r1 = "!"
            boolean r0 = r0.equals(r1)
            r1 = -1
            if (r0 == 0) goto L56
            goto Lc
        L56:
            r0 = r6[r5]
            java.lang.String r2 = "negthinspace"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L61
            goto Lc
        L61:
            r0 = r6[r5]
            java.lang.String r1 = "negmedspace"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L6d
            r5 = -2
            goto L78
        L6d:
            r6 = r6[r5]
            java.lang.String r0 = "negthickspace"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L78
            r5 = -3
        L78:
            rc.R0 r6 = new rc.R0
            r6.<init>(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: rc.C5316x0.K1(rc.d1, java.lang.String[]):rc.d");
    }

    public static final AbstractC5276d K2(d1 d1Var, String[] strArr) throws ParseException {
        o1 o1Var = new o1(new a1("\\displaystyle\\widehat{}").f39212d);
        o1Var.o(1, 0.6f);
        return new Q0(o1Var, null);
    }

    public static final AbstractC5276d L(d1 d1Var, String[] strArr) throws ParseException {
        AbstractC5276d abstractC5276d = new a1(d1Var, strArr[1], false).f39212d;
        return !(abstractC5276d instanceof W0) ? abstractC5276d : new C5278e((W0) abstractC5276d, 3);
    }

    public static final AbstractC5276d L0(d1 d1Var, String[] strArr) throws ParseException {
        return new i1(7, 7, new U());
    }

    public static final AbstractC5276d L1(d1 d1Var, String[] strArr) throws ParseException {
        return new R0();
    }

    public static final AbstractC5276d L2(d1 d1Var, String[] strArr) throws ParseException {
        return strArr[2] == null ? new C5295m0(new a1(d1Var, strArr[1], false).f39212d, null) : new C5295m0(new a1(d1Var, strArr[1], false).f39212d, new a1(d1Var, strArr[2], false).f39212d);
    }

    public static final AbstractC5276d M(d1 d1Var, String[] strArr) throws ParseException {
        AbstractC5276d abstractC5276d = new a1(d1Var, strArr[1], false).f39212d;
        if (!(abstractC5276d instanceof W0)) {
            return abstractC5276d;
        }
        C5278e c5278e = new C5278e((W0) abstractC5276d, 3);
        c5278e.f39248a = 4;
        return c5278e;
    }

    public static final AbstractC5276d M0(d1 d1Var, String[] strArr) throws ParseException, SymbolNotFoundException {
        AbstractC5276d abstractC5276dClone = W0.p("int").clone();
        abstractC5276dClone.f39249b = 1;
        I0 i02 = new I0(abstractC5276dClone);
        i02.i(new R0(5, -1.0f, 0.0f, 0.0f));
        W0 w0P = W0.p("cdotp");
        I0 i03 = new I0(w0P);
        i03.i(w0P);
        i03.i(w0P);
        i02.i(new i1(7, 7, i03));
        i02.i(new R0(5, -1.0f, 0.0f, 0.0f));
        i02.i(abstractC5276dClone);
        i02.f39102e = true;
        return new i1(1, 1, i02);
    }

    public static final AbstractC5276d M1(d1 d1Var, String[] strArr) throws ParseException {
        String str = strArr[1];
        if (!d1Var.C(str)) {
            throw new ParseException("Invalid name for the command :" + str);
        }
        String str2 = strArr[3];
        Integer num = str2 == null ? new Integer(0) : Integer.valueOf(Integer.parseInt(str2));
        if (strArr[4] == null) {
            C5291k0.a(str.substring(1), strArr[2], num.intValue());
            return null;
        }
        C5291k0.b(str.substring(1), strArr[2], num.intValue(), strArr[4]);
        return null;
    }

    public static final AbstractC5276d M2(d1 d1Var, String[] strArr) throws ParseException {
        return new T0(new a1(d1Var, strArr[1], false).f39212d);
    }

    public static final AbstractC5276d N(d1 d1Var, String[] strArr) throws ParseException {
        AbstractC5276d abstractC5276d = new a1(d1Var, strArr[1], false).f39212d;
        if (!(abstractC5276d instanceof W0)) {
            return abstractC5276d;
        }
        C5278e c5278e = new C5278e((W0) abstractC5276d, 3);
        c5278e.f39248a = 5;
        return c5278e;
    }

    public static final AbstractC5276d N0(d1 d1Var, String[] strArr) throws ParseException {
        AbstractC5276d abstractC5276dClone = W0.p("int").clone();
        abstractC5276dClone.f39249b = 1;
        I0 i02 = new I0(abstractC5276dClone);
        i02.i(new R0(5, -6.0f, 0.0f, 0.0f));
        i02.i(abstractC5276dClone);
        i02.i(new R0(5, -6.0f, 0.0f, 0.0f));
        i02.i(abstractC5276dClone);
        i02.i(new R0(5, -6.0f, 0.0f, 0.0f));
        i02.i(abstractC5276dClone);
        i02.f39102e = true;
        return new i1(1, 1, i02);
    }

    public static final AbstractC5276d N1(d1 d1Var, String[] strArr) throws ParseException {
        String str = strArr[4];
        C5293l0.e(strArr[1], strArr[2], strArr[3], str == null ? 0 : Integer.parseInt(str));
        return null;
    }

    public static final AbstractC5276d N2(d1 d1Var, String[] strArr) throws ParseException {
        return new i1(2, 2, new k1(new a1(d1Var, strArr[2], false).f39212d, new a1(d1Var, strArr[3], false).f39212d, 5, 0.5f, true, new a1(d1Var, strArr[1], false).f39212d, 5, 2.5f, true));
    }

    public static final AbstractC5276d O(d1 d1Var, String[] strArr) throws ParseException {
        AbstractC5276d abstractC5276d = new a1(d1Var, strArr[1], false).f39212d;
        if (!(abstractC5276d instanceof W0)) {
            return abstractC5276d;
        }
        C5278e c5278e = new C5278e((W0) abstractC5276d, 1);
        c5278e.f39248a = 4;
        return c5278e;
    }

    public static final AbstractC5276d O0(d1 d1Var, String[] strArr) throws ParseException {
        AbstractC5276d abstractC5276dClone = W0.p("int").clone();
        abstractC5276dClone.f39249b = 1;
        I0 i02 = new I0(abstractC5276dClone);
        i02.i(new R0(5, -6.0f, 0.0f, 0.0f));
        i02.i(abstractC5276dClone);
        i02.i(new R0(5, -6.0f, 0.0f, 0.0f));
        i02.i(abstractC5276dClone);
        i02.f39102e = true;
        return new i1(1, 1, i02);
    }

    public static final AbstractC5276d O1(d1 d1Var, String[] strArr) throws ParseException {
        AbstractC5276d abstractC5276dP = d1Var.p();
        abstractC5276dP.f39249b = 1;
        return abstractC5276dP.clone();
    }

    public static final AbstractC5276d O2(d1 d1Var, String[] strArr) throws ParseException {
        return new i1(3, 3, new k1(new a1(d1Var, strArr[2], false).f39212d, new a1(d1Var, strArr[3], false).f39212d, 5, 0.5f, true, new a1(d1Var, strArr[1], false).f39212d, 5, 2.5f, true));
    }

    public static final AbstractC5276d P(d1 d1Var, String[] strArr) throws ParseException {
        AbstractC5276d abstractC5276d = new a1(d1Var, strArr[1], false).f39212d;
        if (!(abstractC5276d instanceof W0)) {
            return abstractC5276d;
        }
        C5278e c5278e = new C5278e((W0) abstractC5276d, 1);
        c5278e.f39248a = 5;
        return c5278e;
    }

    public static final AbstractC5276d P0(d1 d1Var, String[] strArr) throws ParseException {
        AbstractC5276d abstractC5276dClone = W0.p("int").clone();
        abstractC5276dClone.f39249b = 1;
        I0 i02 = new I0(abstractC5276dClone);
        i02.i(new R0(5, -6.0f, 0.0f, 0.0f));
        i02.i(abstractC5276dClone);
        i02.f39102e = true;
        return new i1(1, 1, i02);
    }

    public static final AbstractC5276d P1(d1 d1Var, String[] strArr) throws ParseException {
        AbstractC5276d abstractC5276dP = d1Var.p();
        abstractC5276dP.f39249b = 0;
        return abstractC5276dP.clone();
    }

    public static final AbstractC5276d P2(d1 d1Var, String[] strArr) throws ParseException {
        return new n1(W0.p("surdsign"));
    }

    public static final AbstractC5276d Q(d1 d1Var, String[] strArr) throws ParseException {
        AbstractC5276d abstractC5276d;
        a1 a1Var = new a1(d1Var, strArr[1], false);
        a1 a1Var2 = new a1(d1Var, strArr[2], false);
        AbstractC5276d abstractC5276d2 = a1Var.f39212d;
        if (abstractC5276d2 == null || (abstractC5276d = a1Var2.f39212d) == null) {
            throw new ParseException("Both binomial coefficients must be not empty !!");
        }
        return new D(new G(abstractC5276d2, abstractC5276d, false), new W0("lbrack", 4, true), new W0("rbrack", 5, true));
    }

    public static final AbstractC5276d Q0(d1 d1Var, String[] strArr) throws ParseException {
        return new N(strArr[1], strArr[2]);
    }

    public static final AbstractC5276d Q1(d1 d1Var, String[] strArr) throws ParseException {
        return new C5297n0(new a1(d1Var, strArr[1]).f39212d);
    }

    public static final AbstractC5276d Q2(d1 d1Var, String[] strArr) throws ParseException {
        return new u1();
    }

    public static final AbstractC5276d R(d1 d1Var, String[] strArr) throws ParseException {
        return new C5282g(new a1(d1Var, strArr[1], false).f39212d);
    }

    public static final AbstractC5276d R0(d1 d1Var, String[] strArr) throws ParseException {
        return new C5288j();
    }

    public static final AbstractC5276d R1(d1 d1Var, String[] strArr) throws ParseException {
        AbstractC5276d abstractC5276dClone = W0.p("oint").clone();
        abstractC5276dClone.f39249b = 1;
        return abstractC5276dClone;
    }

    public static final AbstractC5276d R2(d1 d1Var, String[] strArr) throws ParseException {
        return new E0(new a1(d1Var, strArr[1], "mathnormal", false, false).f39212d);
    }

    public static final AbstractC5276d S(d1 d1Var, String[] strArr) throws ParseException {
        return X("lbrace", "rbrace", d1Var, strArr);
    }

    public static final AbstractC5276d S0(d1 d1Var, String[] strArr) throws ParseException {
        AbstractC5276d abstractC5276dClone = W0.p("int").clone();
        abstractC5276dClone.f39249b = 1;
        return abstractC5276dClone;
    }

    public static final AbstractC5276d S1(d1 d1Var, String[] strArr) throws ParseException {
        return new C5299o0(new a1(d1Var, strArr[1]).f39212d);
    }

    public static final AbstractC5276d S2(d1 d1Var, String[] strArr) throws ParseException {
        return new f1(new E0(new a1(d1Var, strArr[1]).f39212d));
    }

    public static final AbstractC5276d T(d1 d1Var, String[] strArr) throws ParseException {
        return X("lsqbrack", "rsqbrack", d1Var, strArr);
    }

    public static final AbstractC5276d T0(d1 d1Var, String[] strArr) throws ParseException {
        if (!d1Var.y()) {
            throw new ParseException("Bad environment for \\intertext command !");
        }
        E0 e02 = new E0(new a1(d1Var, strArr[1].replaceAll("\\^\\{\\\\prime\\}", "'").replaceAll("\\^\\{\\\\prime\\\\prime\\}", "''"), "mathnormal", false, false).f39212d);
        e02.f39248a = 11;
        d1Var.a(e02);
        d1Var.b();
        return null;
    }

    public static final AbstractC5276d T1(d1 d1Var, String[] strArr) throws ParseException {
        AbstractC5276d abstractC5276dL = d1Var.l();
        AbstractC5276d abstractC5276d = new a1(d1Var, d1Var.t(), false).f39212d;
        if (abstractC5276dL == null || abstractC5276d == null) {
            throw new ParseException("Both numerator and denominator of a fraction can't be empty!");
        }
        return new G(abstractC5276dL, abstractC5276d, true);
    }

    public static final AbstractC5276d T2(d1 d1Var, String[] strArr) throws ParseException {
        return new C5302q(new a1(d1Var, strArr[2]).f39212d, null, C5302q.j(strArr[1]));
    }

    public static final AbstractC5276d U(d1 d1Var, String[] strArr) throws ParseException {
        return new C5290k(new a1(d1Var, strArr[1]).f39212d);
    }

    public static final AbstractC5276d U0(d1 d1Var, String[] strArr) throws ParseException {
        return new V(new a1(d1Var, d1Var.t(), null, false, d1Var.z()).f39212d);
    }

    public static final AbstractC5276d U1(d1 d1Var, String[] strArr) throws ParseException {
        return new C5306s0(new a1(d1Var, strArr[1], false).f39212d, null, W0.p("lbrace"), 1, 0.0f, true);
    }

    public static final AbstractC5276d U2(d1 d1Var, String[] strArr) throws ParseException {
        return new P0(new a1(d1Var, strArr[1], false).f39212d);
    }

    public static final AbstractC5276d V(d1 d1Var, String[] strArr) throws ParseException {
        AbstractC5276d abstractC5276d;
        int i10 = "r".equals(strArr[3]) ? 1 : "l".equals(strArr[3]) ? 0 : 2;
        a1 a1Var = new a1(d1Var, strArr[1], false);
        a1 a1Var2 = new a1(d1Var, strArr[2], false);
        AbstractC5276d abstractC5276d2 = a1Var.f39212d;
        if (abstractC5276d2 == null || (abstractC5276d = a1Var2.f39212d) == null) {
            throw new ParseException("Both numerator and denominator of a fraction can't be empty!");
        }
        G g10 = new G(abstractC5276d2, abstractC5276d, true, i10, 2);
        I0 i02 = new I0();
        i02.i(new V0(0, g10));
        return i02;
    }

    public static final AbstractC5276d V0(d1 d1Var, String[] strArr) throws ParseException {
        return new r(d1Var.p(), new a1(d1Var, strArr[1]).f39212d, null);
    }

    public static final AbstractC5276d V1(d1 d1Var, String[] strArr) throws ParseException {
        return new C5306s0(new a1(d1Var, strArr[1], false).f39212d, null, W0.p("lsqbrack"), 1, 0.0f, true);
    }

    public static final AbstractC5276d V2(d1 d1Var, String[] strArr) throws ParseException {
        return new V0(2, new a1(d1Var, d1Var.t(), false).f39212d);
    }

    public static final AbstractC5276d W(d1 d1Var, String[] strArr) throws ParseException {
        String strSubstring = strArr[1];
        int i10 = 16;
        if (strSubstring.startsWith("0x") || strSubstring.startsWith("0X")) {
            strSubstring = strSubstring.substring(2);
        } else if (strSubstring.startsWith("x") || strSubstring.startsWith("X")) {
            strSubstring = strSubstring.substring(1);
        } else if (strSubstring.startsWith("0")) {
            strSubstring = strSubstring.substring(1);
            i10 = 8;
        } else {
            i10 = 10;
        }
        return d1Var.c((char) Integer.parseInt(strSubstring, i10), true);
    }

    public static final AbstractC5276d W0(d1 d1Var, String[] strArr) throws ParseException {
        return new r(d1Var.p(), null, new a1(d1Var, strArr[1]).f39212d);
    }

    public static final AbstractC5276d W1(d1 d1Var, String[] strArr) throws ParseException {
        return new j1(new a1(d1Var, strArr[1], false).f39212d, true, true);
    }

    public static final AbstractC5276d W2(d1 d1Var, String[] strArr) throws ParseException {
        String str = strArr[0];
        if ("frak".equals(str)) {
            str = "mathfrak";
        } else if ("Bbb".equals(strArr[0])) {
            str = "mathbb";
        } else {
            if ("bold".equals(strArr[0])) {
                return new C5282g(new a1(d1Var, strArr[1], false).f39212d);
            }
            if ("cal".equals(strArr[0])) {
                str = "mathcal";
            }
        }
        Map<Character.UnicodeBlock, a1.a> map = a1.f39208n;
        Character.UnicodeBlock unicodeBlock = Character.UnicodeBlock.BASIC_LATIN;
        a1.a aVar = map.get(unicodeBlock);
        if (aVar != null) {
            a1.f39208n.put(unicodeBlock, null);
        }
        AbstractC5276d abstractC5276d = new a1(d1Var, strArr[1], false).f39212d;
        if (aVar != null) {
            a1.f39208n.put(unicodeBlock, aVar);
        }
        return new g1(abstractC5276d, str);
    }

    public static final AbstractC5276d X(String str, String str2, d1 d1Var, String[] strArr) throws ParseException {
        AbstractC5276d abstractC5276dL = d1Var.l();
        AbstractC5276d abstractC5276d = new a1(d1Var, d1Var.t(), false).f39212d;
        if (abstractC5276dL == null || abstractC5276d == null) {
            throw new ParseException("Both numerator and denominator of choose can't be empty!");
        }
        return new D(new G(abstractC5276dL, abstractC5276d, false), new W0(str, 4, true), new W0(str2, 5, true));
    }

    public static final AbstractC5276d X0(d1 d1Var, String[] strArr) throws ParseException {
        if (tc.a.k()) {
            return new tc.a(strArr[1], strArr[2]);
        }
        throw new ParseException("No ExternalConverterFactory set !");
    }

    public static final AbstractC5276d X1(d1 d1Var, String[] strArr) throws ParseException {
        return new j1(new a1(d1Var, strArr[1], false).f39212d, true);
    }

    public static final AbstractC5276d X2(d1 d1Var, String[] strArr) throws ParseException {
        return new h1(new a1(d1Var, d1Var.t(), null, false, d1Var.z()).f39212d);
    }

    public static final AbstractC5276d Y(d1 d1Var, String[] strArr) throws ParseException {
        return X("lbrack", "rbrack", d1Var, strArr);
    }

    public static final AbstractC5276d Y0(d1 d1Var, String[] strArr) throws ParseException {
        X.r(strArr[1]);
        return null;
    }

    public static final AbstractC5276d Y1(d1 d1Var, String[] strArr) throws ParseException {
        return new C5308t0(new a1(d1Var, strArr[1], false).f39212d);
    }

    public static final AbstractC5276d Y2(d1 d1Var, String[] strArr) throws ParseException {
        return new k1(new a1(d1Var, strArr[2], false).f39212d, new a1(d1Var, strArr[1], false).f39212d, 5, 0.3f, true, false);
    }

    public static final AbstractC5276d Z(d1 d1Var, String[] strArr) throws ParseException {
        return new C5271a0(new a1(d1Var, strArr[1]).f39212d, strArr[0].charAt(0));
    }

    public static final AbstractC5276d Z0(d1 d1Var, String[] strArr) throws ParseException {
        return new W(strArr[1], 0);
    }

    public static final AbstractC5276d Z1(d1 d1Var, String[] strArr) throws ParseException {
        return new C5306s0(new a1(d1Var, strArr[1], false).f39212d, null, W0.p("lbrack"), 1, 0.0f, true);
    }

    public static final AbstractC5276d Z2(d1 d1Var, String[] strArr) throws ParseException {
        return new C5306s0(new a1(d1Var, strArr[1], false).f39212d, null, W0.p("rbrace"), 1, 0.0f, false);
    }

    public static final AbstractC5276d a(d1 d1Var, String[] strArr) throws ParseException {
        AbstractC5276d abstractC5276d = new a1(d1Var, strArr[1], false).f39212d;
        return !(abstractC5276d instanceof W0) ? abstractC5276d : new C5278e((W0) abstractC5276d, 2);
    }

    public static final AbstractC5276d a0(d1 d1Var, String[] strArr) throws ParseException {
        I0 i02 = new I0(new k1(W0.p("normaldot"), W0.p("normaldot"), 5, 5.2f, false, true));
        i02.i(new R0(0, -0.32f, 0.0f, 0.0f));
        i02.i(W0.p("approx"));
        return new i1(3, 3, i02);
    }

    public static final AbstractC5276d a1(d1 d1Var, String[] strArr) throws ParseException {
        return new W(strArr[1], 1);
    }

    public static final AbstractC5276d a2(d1 d1Var, String[] strArr) throws ParseException {
        return new j1(new a1(d1Var, strArr[1], false).f39212d, false, true);
    }

    public static final AbstractC5276d a3(d1 d1Var, String[] strArr) throws ParseException {
        return new C5306s0(new a1(d1Var, strArr[1], false).f39212d, null, W0.p("rsqbrack"), 1, 0.0f, false);
    }

    public static final AbstractC5276d b(d1 d1Var, String[] strArr) throws ParseException {
        AbstractC5276d abstractC5276d = new a1(d1Var, strArr[1], false).f39212d;
        return !(abstractC5276d instanceof W0) ? abstractC5276d : new C5278e((W0) abstractC5276d, 4);
    }

    public static final AbstractC5276d b0(d1 d1Var, String[] strArr) throws ParseException {
        k1 k1Var = new k1(W0.p("normaldot"), W0.p("normaldot"), 5, 5.2f, false, true);
        I0 i02 = new I0(k1Var);
        i02.i(k1Var);
        return new i1(3, 3, i02);
    }

    public static final AbstractC5276d b1(d1 d1Var, String[] strArr) throws ParseException {
        return new W(strArr[1], 2);
    }

    public static final AbstractC5276d b2(d1 d1Var, String[] strArr) throws ParseException {
        return new i1(3, 3, new k1(new a1(d1Var, strArr[2], false).f39212d, new a1(d1Var, strArr[1], false).f39212d, 5, 2.5f, true, true));
    }

    public static final AbstractC5276d b3(d1 d1Var, String[] strArr) throws ParseException {
        return new j1(new a1(d1Var, strArr[1], false).f39212d, true, false);
    }

    public static final AbstractC5276d c(d1 d1Var, String[] strArr) throws ParseException {
        AbstractC5276d abstractC5276d = new a1(d1Var, strArr[1], false).f39212d;
        if (!(abstractC5276d instanceof W0)) {
            return abstractC5276d;
        }
        C5278e c5278e = new C5278e((W0) abstractC5276d, 4);
        c5278e.f39248a = 4;
        return c5278e;
    }

    public static final AbstractC5276d c0(d1 d1Var, String[] strArr) throws ParseException {
        k1 k1Var = new k1(W0.p("normaldot"), W0.p("normaldot"), 5, 5.2f, false, true);
        I0 i02 = new I0(k1Var);
        i02.i(k1Var);
        i02.i(new R0(0, -0.32f, 0.0f, 0.0f));
        i02.i(W0.p("approx"));
        return new i1(3, 3, i02);
    }

    public static final AbstractC5276d c1(d1 d1Var, String[] strArr) throws ParseException {
        return new W(strArr[1], 3);
    }

    public static final AbstractC5276d c2(d1 d1Var, String[] strArr) throws ParseException {
        AbstractC5276d abstractC5276dL = d1Var.l();
        AbstractC5276d abstractC5276d = new a1(d1Var, d1Var.t(), false).f39212d;
        if (abstractC5276dL == null || abstractC5276d == null) {
            throw new ParseException("Both numerator and denominator of a fraction can't be empty!");
        }
        AbstractC5276d abstractC5276d2 = new a1(d1Var, strArr[1], false).f39212d;
        if (abstractC5276d2 instanceof C5278e) {
            abstractC5276d2 = ((C5278e) abstractC5276d2).f39268d;
        }
        AbstractC5276d abstractC5276d3 = new a1(d1Var, strArr[2], false).f39212d;
        if (abstractC5276d3 instanceof C5278e) {
            abstractC5276d3 = ((C5278e) abstractC5276d3).f39268d;
        }
        if ((abstractC5276d2 instanceof W0) && (abstractC5276d3 instanceof W0)) {
            return new D(new G(abstractC5276dL, abstractC5276d, true), (W0) abstractC5276d2, (W0) abstractC5276d3);
        }
        I0 i02 = new I0();
        i02.i(abstractC5276d2);
        i02.i(new G(abstractC5276dL, abstractC5276d, true));
        i02.i(abstractC5276d3);
        return i02;
    }

    public static final AbstractC5276d c3(d1 d1Var, String[] strArr) throws ParseException {
        return new j1(new a1(d1Var, strArr[1], false).f39212d, false);
    }

    public static final AbstractC5276d d(d1 d1Var, String[] strArr) throws ParseException {
        AbstractC5276d abstractC5276d = new a1(d1Var, strArr[1], false).f39212d;
        if (!(abstractC5276d instanceof W0)) {
            return abstractC5276d;
        }
        C5278e c5278e = new C5278e((W0) abstractC5276d, 4);
        c5278e.f39248a = 5;
        return c5278e;
    }

    public static final AbstractC5276d d0(d1 d1Var, String[] strArr) throws ParseException {
        k1 k1Var = new k1(W0.p("normaldot"), W0.p("normaldot"), 5, 5.2f, false, true);
        I0 i02 = new I0(k1Var);
        i02.i(k1Var);
        i02.i(new R0(0, -0.32f, 0.0f, 0.0f));
        i02.i(W0.p("equals"));
        return new i1(3, 3, i02);
    }

    public static final AbstractC5276d d1(d1 d1Var, String[] strArr) throws ParseException {
        Map<String, String> map = d1Var.f39255a.f39210b;
        String strSubstring = strArr[1];
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            int iIndexOf = strSubstring.indexOf("$");
            if (iIndexOf == -1) {
                stringBuffer.append(strSubstring);
                return new a1(d1Var, stringBuffer.toString()).f39212d;
            }
            if (iIndexOf < strSubstring.length() - 1) {
                int i10 = iIndexOf;
                do {
                    i10++;
                    if (i10 >= strSubstring.length()) {
                        break;
                    }
                } while (Character.isLetter(strSubstring.charAt(i10)));
                String str = map.get(strSubstring.substring(iIndexOf + 1, i10));
                if (str != null) {
                    stringBuffer.append(strSubstring.substring(0, iIndexOf));
                    stringBuffer.append(str);
                } else {
                    stringBuffer.append(strSubstring.substring(0, i10));
                }
                strSubstring = strSubstring.substring(i10);
            } else {
                stringBuffer.append(strSubstring);
                strSubstring = "";
            }
        }
    }

    public static final AbstractC5276d d2(d1 d1Var, String[] strArr) throws ParseException {
        return new C5312v0(new a1(d1Var, strArr[1], false).f39212d, true, true, true);
    }

    public static final AbstractC5276d d3(d1 d1Var, String[] strArr) throws ParseException {
        return new l1(new a1(d1Var, strArr[1], false).f39212d);
    }

    public static final AbstractC5276d e(d1 d1Var, String[] strArr) throws ParseException {
        AbstractC5276d abstractC5276d = new a1(d1Var, strArr[1], false).f39212d;
        if (!(abstractC5276d instanceof W0)) {
            return abstractC5276d;
        }
        C5278e c5278e = new C5278e((W0) abstractC5276d, 2);
        c5278e.f39248a = 4;
        return c5278e;
    }

    public static final AbstractC5276d e0(d1 d1Var, String[] strArr) throws ParseException {
        k1 k1Var = new k1(W0.p("normaldot"), W0.p("normaldot"), 5, 5.2f, false, true);
        I0 i02 = new I0(k1Var);
        i02.i(k1Var);
        i02.i(new R0(0, -0.32f, 0.0f, 0.0f));
        i02.i(W0.p("minus"));
        return new i1(3, 3, i02);
    }

    public static final AbstractC5276d e1(d1 d1Var, String[] strArr) throws ParseException {
        return new i1(3, 3, new R0(5, -2.6f, 0.0f, 0.0f));
    }

    public static final AbstractC5276d e2(d1 d1Var, String[] strArr) throws ParseException {
        AbstractC5276d abstractC5276d = new a1(d1Var, strArr[3]).f39212d;
        d1Var.a(new M0(new C5312v0(abstractC5276d, false, true, true), new a1(d1Var, strArr[2]).f39212d, new a1(d1Var, strArr[1]).f39212d, false));
        d1Var.a(new R0(5, -0.3f, 0.0f, 0.0f));
        return new i1(0, 0, abstractC5276d);
    }

    public static final AbstractC5276d e3(d1 d1Var, String[] strArr) throws ParseException {
        return new C5306s0(new a1(d1Var, strArr[1], false).f39212d, null, W0.p("rbrack"), 1, 0.0f, false);
    }

    public static final AbstractC5276d f(d1 d1Var, String[] strArr) throws ParseException {
        AbstractC5276d abstractC5276d = new a1(d1Var, strArr[1], false).f39212d;
        if (!(abstractC5276d instanceof W0)) {
            return abstractC5276d;
        }
        C5278e c5278e = new C5278e((W0) abstractC5276d, 2);
        c5278e.f39248a = 5;
        return c5278e;
    }

    public static final AbstractC5276d f0(d1 d1Var, String[] strArr) throws ParseException {
        k1 k1Var = new k1(W0.p("normaldot"), W0.p("normaldot"), 5, 5.2f, false, true);
        I0 i02 = new I0(k1Var);
        i02.i(k1Var);
        i02.i(new R0(0, -0.32f, 0.0f, 0.0f));
        i02.i(W0.p("sim"));
        return new i1(3, 3, i02);
    }

    public static final AbstractC5276d f1(d1 d1Var, String[] strArr) throws ParseException {
        float[] fArrK = R0.k(strArr[1]);
        if (fArrK.length != 1) {
            return new R0((int) fArrK[0], fArrK[1], 0.0f, 0.0f);
        }
        throw new ParseException("Error in getting kern in \\kern command !");
    }

    public static final AbstractC5276d f2(d1 d1Var, String[] strArr) throws ParseException {
        return new R0(0, 2.0f, 0.0f, 0.0f);
    }

    public static final AbstractC5276d f3(d1 d1Var, String[] strArr) throws ParseException {
        return new j1(new a1(d1Var, strArr[1], false).f39212d, false, false);
    }

    public static final AbstractC5276d g(d1 d1Var, String[] strArr) throws ParseException {
        return new a1(d1Var, "\\left\\langle " + strArr[1].replaceAll("\\|", "\\\\middle\\\\vert ") + "\\right\\rangle").f39212d;
    }

    public static final AbstractC5276d g0(d1 d1Var, String[] strArr) throws ParseException {
        I0 i02 = new I0(new k1(W0.p("normaldot"), W0.p("normaldot"), 5, 5.2f, false, true));
        i02.i(new R0(0, -0.32f, 0.0f, 0.0f));
        i02.i(W0.p("equals"));
        return new i1(3, 3, i02);
    }

    public static final AbstractC5276d g1(d1 d1Var, String[] strArr) throws ParseException {
        String strN = d1Var.n("\\left", "\\right");
        AbstractC5276d abstractC5276d = new a1(d1Var, strArr[1], false).f39212d;
        if (abstractC5276d instanceof C5278e) {
            abstractC5276d = ((C5278e) abstractC5276d).f39268d;
        }
        AbstractC5276d abstractC5276dG = d1Var.g();
        if (abstractC5276dG instanceof C5278e) {
            abstractC5276dG = ((C5278e) abstractC5276dG).f39268d;
        }
        if ((abstractC5276d instanceof W0) && (abstractC5276dG instanceof W0)) {
            a1 a1Var = new a1(d1Var, strN, false);
            return new D(a1Var.f39212d, (W0) abstractC5276d, a1Var.f39209a, (W0) abstractC5276dG);
        }
        I0 i02 = new I0();
        i02.i(abstractC5276d);
        i02.i(new a1(d1Var, strN, false).f39212d);
        i02.i(abstractC5276dG);
        return i02;
    }

    public static final AbstractC5276d g2(d1 d1Var, String[] strArr) throws ParseException {
        return new R0(0, 1.0f, 0.0f, 0.0f);
    }

    public static final AbstractC5276d g3(d1 d1Var, String[] strArr) throws ParseException {
        return new m1();
    }

    public static final AbstractC5276d h(d1 d1Var, String[] strArr) throws ParseException {
        C5307t.Z(Float.parseFloat(strArr[1]), Float.parseFloat(strArr[2]), Float.parseFloat(strArr[3]), Float.parseFloat(strArr[4]));
        return null;
    }

    public static final AbstractC5276d h0(d1 d1Var, String[] strArr) throws ParseException {
        I0 i02 = new I0(new k1(W0.p("normaldot"), W0.p("normaldot"), 5, 5.2f, false, true));
        i02.i(new R0(0, -0.32f, 0.0f, 0.0f));
        i02.i(W0.p("minus"));
        return new i1(3, 3, i02);
    }

    public static final AbstractC5276d h1(d1 d1Var, String[] strArr) throws ParseException {
        return new C5277d0(new a1(d1Var, d1Var.n("\\[", "\\]"), false).f39212d, 0);
    }

    public static final AbstractC5276d h2(d1 d1Var, String[] strArr) throws ParseException {
        return new i1(3, 3, new k1(W0.p(a1.f39205k[61]), new K0(W0.p(a1.f39205k[63]), 0.75d), 5, 2.5f, true, true));
    }

    public static final AbstractC5276d h3(d1 d1Var, String[] strArr) throws ParseException {
        return new i1(3, 3, new k1(new a1(d1Var, strArr[2], false).f39212d, new a1(d1Var, strArr[1], false).f39212d, 5, 0.5f, true, false));
    }

    public static final AbstractC5276d i(d1 d1Var, String[] strArr) throws ParseException {
        I0 i02 = new I0(new R0(1, -0.1f, 0.0f, 0.0f));
        i02.i(W0.p("bar"));
        o1 o1Var = new o1(new C5271a0(i02, 'r'));
        o1Var.o(1, -0.55f);
        I0 i03 = new I0(o1Var);
        i03.i(new E0(new C5294m('D', d1Var.f39255a.f39213e)));
        return i03;
    }

    public static final AbstractC5276d i0(d1 d1Var, String[] strArr) throws ParseException {
        I0 i02 = new I0(new k1(W0.p("normaldot"), W0.p("normaldot"), 5, 5.2f, false, true));
        i02.i(new R0(0, -0.32f, 0.0f, 0.0f));
        i02.i(W0.p("sim"));
        return new i1(3, 3, i02);
    }

    public static final AbstractC5276d i1(d1 d1Var, String[] strArr) throws ParseException {
        return new C5277d0(new a1(d1Var, d1Var.n("\\(", "\\)"), false).f39212d, 2);
    }

    public static final AbstractC5276d i2(d1 d1Var, String[] strArr) throws ParseException {
        float[] fArrK = R0.k(strArr[1]);
        if (fArrK.length == 1) {
            throw new ParseException("Error in getting raise in \\raisebox command !");
        }
        float[] fArrK2 = R0.k(strArr[3]);
        float[] fArrK3 = R0.k(strArr[4]);
        if (fArrK2.length == 1 || fArrK2[1] == 0.0f) {
            fArrK2 = new float[]{-1.0f, 0.0f};
        }
        if (fArrK3.length == 1 || fArrK3[1] == 0.0f) {
            fArrK3 = new float[]{-1.0f, 0.0f};
        }
        return new A0(new a1(d1Var, strArr[2]).f39212d, (int) fArrK[0], fArrK[1], (int) fArrK2[0], fArrK2[1], (int) fArrK3[0], fArrK3[1]);
    }

    public static final AbstractC5276d i3(d1 d1Var, String[] strArr) throws ParseException {
        AbstractC5276d abstractC5276d = new a1(d1Var, strArr[1], false).f39212d;
        return new k1(abstractC5276d, new C5270a(new C5312v0(abstractC5276d, true, false, false), "widetilde"), 5, 0.3f, true, false);
    }

    public static final AbstractC5276d j(d1 d1Var, String[] strArr) throws ParseException {
        a1 a1Var = new a1("\\mathbb{G}\\mathsf{e}");
        a1Var.d(new I());
        a1Var.c("\\mathsf{Gebra}");
        return new C5302q(a1Var.f39212d, null, new Cc.c(102, 102, 102));
    }

    public static final AbstractC5276d j0(d1 d1Var, String[] strArr) throws ParseException {
        Cc.c cVarJ = C5302q.j(strArr[1]);
        return new A(new a1(d1Var, strArr[2]).f39212d, cVarJ, cVarJ);
    }

    public static final AbstractC5276d j1(d1 d1Var, String[] strArr) throws ParseException {
        AbstractC5276d abstractC5276dP = d1Var.p();
        abstractC5276dP.f39249b = 2;
        return abstractC5276dP.clone();
    }

    public static final AbstractC5276d j2(d1 d1Var, String[] strArr) throws ParseException {
        return new i1(3, 3, new k1(W0.p("normaldot"), W0.p("normaldot"), 5, 5.2f, false, true));
    }

    public static final AbstractC5276d j3(d1 d1Var, String[] strArr) throws ParseException {
        return new p1();
    }

    public static final AbstractC5276d k(d1 d1Var, String[] strArr) throws ParseException {
        I0 i02 = new I0(new R0(1, 0.28f, 0.0f, 0.0f));
        i02.i(W0.p("textendash"));
        o1 o1Var = new o1(new C5271a0(i02, 'r'));
        o1Var.o(1, 0.55f);
        I0 i03 = new I0(o1Var);
        i03.i(new E0(new C5294m('H', d1Var.f39255a.f39213e)));
        return i03;
    }

    public static final AbstractC5276d k0(d1 d1Var, String[] strArr) throws ParseException {
        o1 o1Var = new o1(W0.p("equals"));
        o1Var.i(new R0(5, 0.0f, 1.5f, 0.0f));
        o1Var.i(W0.p("sim"));
        o1Var.o(5, -1.0f);
        return new i1(3, 3, o1Var);
    }

    public static final AbstractC5276d k1(d1 d1Var, String[] strArr) throws ParseException {
        C5278e c5278e = new C5278e((W0) W0.p("lmoustache").clone(), 1);
        c5278e.f39248a = 4;
        return c5278e;
    }

    public static final AbstractC5276d k2(d1 d1Var, String[] strArr) throws ParseException {
        return new B0(new a1(d1Var, strArr[1]).f39212d);
    }

    public static final AbstractC5276d k3(d1 d1Var, String[] strArr) throws ParseException {
        return new C5312v0(new a1(d1Var, strArr[1], false).f39212d, false, true, true);
    }

    public static final AbstractC5276d l(d1 d1Var, String[] strArr) throws ParseException {
        return new T(strArr[0].charAt(0) == 'I');
    }

    public static final AbstractC5276d l0(d1 d1Var, String[] strArr) throws ParseException {
        if (d1Var.y()) {
            d1Var.b();
            return null;
        }
        C5274c c5274c = new C5274c();
        c5274c.d(d1Var.f39255a.f39212d);
        c5274c.p();
        new d1(d1Var.o(), d1Var.w(), c5274c, false, d1Var.z()).F();
        c5274c.q();
        d1Var.e();
        d1Var.f39255a.f39212d = c5274c.r();
        return null;
    }

    public static final AbstractC5276d l1(d1 d1Var, String[] strArr) throws ParseException {
        try {
            return new C5273b0(Long.valueOf(strArr[2]).longValue(), Long.valueOf(strArr[1]).longValue());
        } catch (NumberFormatException unused) {
            throw new ParseException("Divisor and dividend must be integer numbers");
        }
    }

    public static final AbstractC5276d l2(d1 d1Var, String[] strArr) throws ParseException {
        String str = strArr[1];
        if (d1Var.C(str)) {
            String str2 = strArr[3];
            C5291k0.c(str.substring(1), strArr[2], (str2 == null ? new Integer(0) : Integer.valueOf(Integer.parseInt(str2))).intValue());
            return null;
        }
        throw new ParseException("Invalid name for the command :" + str);
    }

    public static final AbstractC5276d l3(d1 d1Var, String[] strArr) throws ParseException {
        return new s1(new a1(d1Var, strArr[1], false).f39212d, new a1(d1Var, strArr[2]).f39212d, true);
    }

    public static final AbstractC5276d m(d1 d1Var, String[] strArr) throws ParseException {
        return new Y(strArr[0].charAt(0) == 'L');
    }

    public static final AbstractC5276d m0(d1 d1Var, String[] strArr) throws ParseException {
        return new i1(7, 7, new C5305s());
    }

    public static final AbstractC5276d m1(d1 d1Var, String[] strArr) throws ParseException {
        C5307t.Y(Float.parseFloat(strArr[1]));
        return null;
    }

    public static final AbstractC5276d m2(d1 d1Var, String[] strArr) throws ParseException {
        String str = strArr[4];
        C5293l0.f(strArr[1], strArr[2], strArr[3], str == null ? 0 : Integer.parseInt(str));
        return null;
    }

    public static final AbstractC5276d m3(d1 d1Var, String[] strArr) throws ParseException {
        return new s1(new a1(d1Var, strArr[1], false).f39212d, new a1(d1Var, strArr[2]).f39212d, false);
    }

    public static final AbstractC5276d n(d1 d1Var, String[] strArr) throws ParseException {
        return new Z();
    }

    public static final AbstractC5276d n0(d1 d1Var, String[] strArr) throws ParseException, NumberFormatException {
        Cc.c cVar;
        if ("gray".equals(strArr[2])) {
            float f10 = Float.parseFloat(strArr[3]);
            cVar = new Cc.c(f10, f10, f10);
        } else if ("rgb".equals(strArr[2])) {
            StringTokenizer stringTokenizer = new StringTokenizer(strArr[3], ";,");
            if (stringTokenizer.countTokens() != 3) {
                throw new ParseException("The color definition must have three components !");
            }
            cVar = new Cc.c(Float.parseFloat(stringTokenizer.nextToken().trim()), Float.parseFloat(stringTokenizer.nextToken().trim()), Float.parseFloat(stringTokenizer.nextToken().trim()));
        } else {
            if (!"cmyk".equals(strArr[2])) {
                throw new ParseException("The color model is incorrect !");
            }
            StringTokenizer stringTokenizer2 = new StringTokenizer(strArr[3], ",;");
            if (stringTokenizer2.countTokens() != 4) {
                throw new ParseException("The color definition must have four components !");
            }
            float[] fArr = new float[4];
            for (int i10 = 0; i10 < 4; i10++) {
                fArr[i10] = Float.parseFloat(stringTokenizer2.nextToken().trim());
            }
            float f11 = 1.0f - fArr[3];
            cVar = new Cc.c((1.0f - fArr[0]) * f11, (1.0f - fArr[1]) * f11, f11 * (1.0f - fArr[2]));
        }
        C5302q.f39376g.put(strArr[1], cVar);
        return null;
    }

    public static final AbstractC5276d n1(d1 d1Var, String[] strArr) throws ParseException {
        d1Var.D();
        return null;
    }

    public static final AbstractC5276d n2(d1 d1Var, String[] strArr) throws ParseException {
        AbstractC5276d abstractC5276d = new a1(d1Var, strArr[3]).f39212d;
        boolean z10 = true;
        String str = strArr[1];
        String str2 = strArr[2];
        if (!str.equals("!") && !strArr[2].equals("!")) {
            z10 = false;
        }
        return new D0(abstractC5276d, str, str2, z10);
    }

    public static final AbstractC5276d o(d1 d1Var, String[] strArr) throws ParseException {
        return new a1(d1Var, "\\left\\{" + strArr[1].replaceFirst("\\|", "\\\\middle\\\\vert ") + "\\right\\}").f39212d;
    }

    public static final AbstractC5276d o0(d1 d1Var, String[] strArr) throws ParseException {
        return new V0(0, new a1(d1Var, d1Var.t(), false).f39212d);
    }

    public static final AbstractC5276d o1(d1 d1Var, String[] strArr) throws ParseException {
        d1Var.E();
        return null;
    }

    public static final AbstractC5276d o2(d1 d1Var, String[] strArr) throws ParseException {
        return new E0(new a1(d1Var, d1Var.t(), null, false, d1Var.z()).f39212d);
    }

    public static final AbstractC5276d p(d1 d1Var, String[] strArr) throws ParseException {
        return new X0(strArr[0].charAt(0) == 'T');
    }

    public static final AbstractC5276d p0(d1 d1Var, String[] strArr) throws ParseException {
        return new i1(3, 3, new k1(W0.p("equals"), W0.p("ldotp"), 5, 3.7f, false, true));
    }

    public static final AbstractC5276d p1(d1 d1Var, String[] strArr) throws ParseException {
        return new C5282g(new E0(new a1(d1Var, strArr[1], false).f39212d));
    }

    public static final AbstractC5276d p2(d1 d1Var, String[] strArr) throws ParseException {
        C5278e c5278e = new C5278e((W0) W0.p("rmoustache").clone(), 1);
        c5278e.f39248a = 5;
        return c5278e;
    }

    public static final AbstractC5276d q(d1 d1Var, String[] strArr) throws ParseException {
        return new F0(new a1(d1Var, strArr[1]).f39212d, 180.0d, "origin=cc");
    }

    public static final AbstractC5276d q0(d1 d1Var, String[] strArr) throws ParseException {
        return new i1(2, 2, new k1(W0.p("minus"), W0.p("normaldot"), 5, -3.3f, false, true));
    }

    public static final AbstractC5276d q1(d1 d1Var, String[] strArr) throws ParseException {
        return new i1(2, 2, new a1(d1Var, strArr[1], false).f39212d);
    }

    public static final AbstractC5276d q2(d1 d1Var, String[] strArr) throws ParseException, NumberFormatException {
        int[] iArr = {1000, 900, 500, Const.I_TILE_TINY, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strArr2 = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "IV", "I"};
        int i10 = Integer.parseInt(strArr[1].trim());
        String lowerCase = "";
        for (int i11 = 0; i11 < 13; i11++) {
            while (i10 >= iArr[i11]) {
                lowerCase = lowerCase + strArr2[i11];
                i10 -= iArr[i11];
            }
        }
        if (strArr[0].charAt(0) == 'r') {
            lowerCase = lowerCase.toLowerCase();
        }
        return new a1(lowerCase, false).f39212d;
    }

    public static final AbstractC5276d r(d1 d1Var, String[] strArr) throws ParseException {
        AbstractC5276d abstractC5276dL = d1Var.l();
        float[] fArrQ = d1Var.q();
        AbstractC5276d abstractC5276d = new a1(d1Var, d1Var.t(), false).f39212d;
        if (fArrQ == null || fArrQ.length != 2) {
            throw new ParseException("Invalid length in above macro");
        }
        if (abstractC5276dL == null || abstractC5276d == null) {
            throw new ParseException("Both numerator and denominator of a fraction can't be empty!");
        }
        return new G(abstractC5276dL, abstractC5276d, (int) fArrQ[0], fArrQ[1]);
    }

    public static final AbstractC5276d r0(d1 d1Var, String[] strArr) throws ParseException {
        return new C5313w(new a1(d1Var, strArr[1]).f39212d);
    }

    public static final AbstractC5276d r1(d1 d1Var, String[] strArr) throws ParseException {
        return new i1(5, 5, new a1(d1Var, strArr[1], false).f39212d);
    }

    public static final AbstractC5276d r2(d1 d1Var, String[] strArr) throws ParseException {
        AbstractC5276d abstractC5276d = new a1(d1Var, strArr[2]).f39212d;
        String str = strArr[1];
        return new F0(abstractC5276d, str == null ? 0.0d : Double.parseDouble(str), strArr[3]);
    }

    public static final AbstractC5276d s(d1 d1Var, String[] strArr) throws ParseException {
        AbstractC5276d abstractC5276dL = d1Var.l();
        float[] fArrQ = d1Var.q();
        AbstractC5276d abstractC5276d = new a1(d1Var, d1Var.t(), false).f39212d;
        if (fArrQ == null || fArrQ.length != 2) {
            throw new ParseException("Invalid length in above macro");
        }
        if (abstractC5276dL == null || abstractC5276d == null) {
            throw new ParseException("Both numerator and denominator of a fraction can't be empty!");
        }
        AbstractC5276d abstractC5276d2 = new a1(d1Var, strArr[1], false).f39212d;
        if (abstractC5276d2 instanceof C5278e) {
            abstractC5276d2 = ((C5278e) abstractC5276d2).f39268d;
        }
        AbstractC5276d abstractC5276d3 = new a1(d1Var, strArr[2], false).f39212d;
        if (abstractC5276d3 instanceof C5278e) {
            abstractC5276d3 = ((C5278e) abstractC5276d3).f39268d;
        }
        if ((abstractC5276d2 instanceof W0) && (abstractC5276d3 instanceof W0)) {
            return new D(new G(abstractC5276dL, abstractC5276d, (int) fArrQ[0], fArrQ[1]), (W0) abstractC5276d2, (W0) abstractC5276d3);
        }
        I0 i02 = new I0();
        i02.i(abstractC5276d2);
        i02.i(new G(abstractC5276dL, abstractC5276d, true));
        i02.i(abstractC5276d3);
        return i02;
    }

    public static final AbstractC5276d s0(d1 d1Var, String[] strArr) throws ParseException {
        I0 i02 = new I0(new R0(1, 0.25f, 0.0f, 0.0f));
        i02.i(W0.p("bar"));
        o1 o1Var = new o1(new C5271a0(i02, 'r'));
        o1Var.o(1, -0.1f);
        I0 i03 = new I0(o1Var);
        i03.i(new E0(new C5294m(GMTDateParser.DAY_OF_MONTH, d1Var.f39255a.f39213e)));
        return i03;
    }

    public static final AbstractC5276d s1(d1 d1Var, String[] strArr) throws ParseException {
        return new C5271a0(new a1(d1Var, strArr[1]).f39212d, strArr[0].charAt(4));
    }

    public static final AbstractC5276d s2(d1 d1Var, String[] strArr) throws ParseException {
        float[] fArrK = R0.k(strArr[1]);
        if (fArrK.length == 1) {
            throw new ParseException("Error in getting width in \\rule command !");
        }
        float[] fArrK2 = R0.k(strArr[2]);
        if (fArrK2.length == 1) {
            throw new ParseException("Error in getting height in \\rule command !");
        }
        float[] fArrK3 = R0.k(strArr[3]);
        if (fArrK3.length != 1) {
            return new J0((int) fArrK[0], fArrK[1], (int) fArrK2[0], fArrK2[1], (int) fArrK3[0], -fArrK3[1]);
        }
        throw new ParseException("Error in getting raise in \\rule command !");
    }

    public static final AbstractC5276d t(d1 d1Var, String[] strArr) throws ParseException {
        return new C5270a(new a1(d1Var, strArr[2], false).f39212d, new a1(d1Var, strArr[1], false).f39212d);
    }

    public static final AbstractC5276d t0(d1 d1Var, String[] strArr) throws ParseException {
        I0 i02 = new I0(W0.p("equals"));
        i02.i(new R0(0, -0.095f, 0.0f, 0.0f));
        i02.i(new k1(W0.p("normaldot"), W0.p("normaldot"), 5, 5.2f, false, true));
        return new i1(3, 3, i02);
    }

    public static final AbstractC5276d t1(d1 d1Var, String[] strArr) throws ParseException {
        return new i1(7, 7, new a1(d1Var, strArr[1], false).f39212d);
    }

    public static final AbstractC5276d t2(d1 d1Var, String[] strArr) throws ParseException {
        return new P0(new a1(d1Var, d1Var.t(), null, false, d1Var.z()).f39212d);
    }

    public static final AbstractC5276d u(d1 d1Var, String[] strArr) throws ParseException {
        return new C5270a(new a1(d1Var, strArr[1], false).f39212d, strArr[0]);
    }

    public static final AbstractC5276d u0(d1 d1Var, String[] strArr) throws ParseException {
        I0 i02 = new I0(W0.p("equals"));
        i02.i(new R0(0, -0.095f, 0.0f, 0.0f));
        k1 k1Var = new k1(W0.p("normaldot"), W0.p("normaldot"), 5, 5.2f, false, true);
        i02.i(k1Var);
        i02.i(k1Var);
        return new i1(3, 3, i02);
    }

    public static final AbstractC5276d u1(d1 d1Var, String[] strArr) throws ParseException {
        return new V(new a1(d1Var, strArr[1], false).f39212d);
    }

    public static final AbstractC5276d u2(d1 d1Var, String[] strArr) throws ParseException, NumberFormatException {
        AbstractC5276d abstractC5276d = new a1(d1Var, strArr[2]).f39212d;
        double d10 = Double.parseDouble(strArr[1]);
        String str = strArr[3];
        return new K0(abstractC5276d, d10, str == null ? Double.parseDouble(strArr[1]) : Double.parseDouble(str));
    }

    public static final AbstractC5276d v(d1 d1Var, String[] strArr) throws ParseException {
        String str;
        char cCharAt = strArr[0].charAt(0);
        if (cCharAt == '\"') {
            str = "ddot";
        } else if (cCharAt == '\'') {
            str = "acute";
        } else if (cCharAt == '.') {
            str = "dot";
        } else if (cCharAt == '=') {
            str = "bar";
        } else if (cCharAt == 'H') {
            str = "doubleacute";
        } else if (cCharAt == 'U') {
            str = "cyrbreve";
        } else if (cCharAt == '^') {
            str = "hat";
        } else if (cCharAt == '`') {
            str = "grave";
        } else if (cCharAt == 'r') {
            str = "mathring";
        } else if (cCharAt != '~') {
            switch (cCharAt) {
                case 't':
                    str = "tie";
                    break;
                case 'u':
                    str = "breve";
                    break;
                case 'v':
                    str = "check";
                    break;
                default:
                    str = "";
                    break;
            }
        } else {
            str = "tilde";
        }
        return new C5270a(new a1(d1Var, strArr[1], false).f39212d, str);
    }

    public static final AbstractC5276d v0(d1 d1Var, String[] strArr) throws ParseException {
        return new A(new a1(d1Var, strArr[1], false).f39212d);
    }

    public static final AbstractC5276d v1(d1 d1Var, String[] strArr) throws ParseException {
        i1 i1Var = new i1(1, 1, new a1(d1Var, strArr[1], false).f39212d);
        i1Var.f39249b = 0;
        return i1Var;
    }

    public static final AbstractC5276d v2(d1 d1Var, String[] strArr) throws ParseException {
        return new V0(6, new a1(d1Var, d1Var.t(), false).f39212d);
    }

    public static final AbstractC5276d w(d1 d1Var, String[] strArr) throws ParseException {
        return new C5270a(new a1(d1Var, strArr[2], false).f39212d, new a1(d1Var, strArr[1], false).f39212d);
    }

    public static final AbstractC5276d w0(d1 d1Var, String[] strArr) throws ParseException {
        return new A(new a1(d1Var, strArr[3]).f39212d, C5302q.j(strArr[2]), C5302q.j(strArr[1]));
    }

    public static final AbstractC5276d w1(d1 d1Var, String[] strArr) throws ParseException {
        return new i1(4, 4, new a1(d1Var, strArr[1], false).f39212d);
    }

    public static final AbstractC5276d w2(d1 d1Var, String[] strArr) throws ParseException {
        return new V0(4, new a1(d1Var, d1Var.t(), false).f39212d);
    }

    public static final AbstractC5276d x(d1 d1Var, String[] strArr) throws ParseException {
        C5274c c5274c = new C5274c();
        new d1(d1Var.o(), strArr[1], c5274c, false).F();
        c5274c.q();
        return new C5279e0(d1Var.o(), c5274c, 2);
    }

    public static final AbstractC5276d x0(d1 d1Var, String[] strArr) throws ParseException, NumberFormatException {
        int i10 = Integer.parseInt(strArr[1]);
        if (i10 <= 5) {
            return new B(i10);
        }
        int i11 = i10 / 5;
        int i12 = i10 % 5;
        I0 i02 = new I0();
        for (int i13 = 0; i13 < i11; i13++) {
            i02.i(new B(5));
        }
        i02.i(new B(i12));
        return i02;
    }

    public static final AbstractC5276d x1(d1 d1Var, String[] strArr) throws ParseException {
        return new i1(0, 0, new a1(d1Var, strArr[1], false).f39212d);
    }

    public static final AbstractC5276d x2(d1 d1Var, String[] strArr) throws ParseException {
        return new S0(new a1(d1Var, d1Var.t(), null, false, d1Var.z()).f39212d);
    }

    public static final AbstractC5276d y(d1 d1Var, String[] strArr) throws ParseException, NumberFormatException {
        C5274c c5274c = new C5274c();
        new d1(d1Var.o(), strArr[2], c5274c, false).F();
        c5274c.q();
        if (c5274c.f39231p == Integer.parseInt(strArr[1]) * 2) {
            return new C5279e0(d1Var.o(), c5274c, 3);
        }
        throw new ParseException("Bad number of equations in alignat environment !");
    }

    public static final AbstractC5276d y0(d1 d1Var, String[] strArr) throws ParseException {
        try {
            return new C5302q(new a1(d1Var, strArr[2]).f39212d, null, C5302q.j(strArr[1]));
        } catch (NumberFormatException e10) {
            throw new ParseException(e10.toString());
        }
    }

    public static final AbstractC5276d y1(d1 d1Var, String[] strArr) throws ParseException {
        return new i1(6, 6, new a1(d1Var, strArr[1], false).f39212d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final AbstractC5276d y2(d1 d1Var, String[] strArr) throws ParseException, SymbolNotFoundException {
        float f10;
        float f11;
        float f12;
        double d10;
        double d11;
        W0 w02;
        a1 a1Var = new a1(d1Var, strArr[1], false);
        a1 a1Var2 = new a1(d1Var, strArr[2], false);
        if (a1Var.f39212d == null || a1Var2.f39212d == null) {
            throw new ParseException("Both numerator and denominator of a fraction can't be empty!");
        }
        W0 w0P = W0.p("slash");
        if (d1Var.A()) {
            f10 = 0.45f;
            f11 = -0.13f;
            f12 = -0.065f;
            d10 = 0.75d;
            d11 = 0.75d;
            w02 = w0P;
        } else {
            o1 o1Var = new o1(new K0(W0.p("textfractionsolidus"), 1.25d, 0.65d));
            o1Var.o(1, 0.4f);
            f11 = -0.24f;
            f10 = 0.75f;
            d10 = 0.6d;
            d11 = 0.5d;
            f12 = -0.24f;
            w02 = o1Var;
        }
        float f13 = f10;
        o1 o1Var2 = new o1(new K0(a1Var.f39212d, d10, d11));
        o1Var2.o(1, f13);
        I0 i02 = new I0(o1Var2);
        i02.i(new R0(0, f11, 0.0f, 0.0f));
        i02.i(w02);
        i02.i(new R0(0, f12, 0.0f, 0.0f));
        i02.i(new K0(a1Var2.f39212d, d10, d11));
        return i02;
    }

    public static final AbstractC5276d z(d1 d1Var, String[] strArr) throws ParseException {
        C5274c c5274c = new C5274c();
        new d1(d1Var.o(), strArr[1], c5274c, false).F();
        c5274c.q();
        return new C5279e0(d1Var.o(), c5274c, 6);
    }

    public static final AbstractC5276d z0(d1 d1Var, String[] strArr) throws ParseException {
        C5274c c5274c = new C5274c();
        new d1(d1Var.o(), strArr[1], c5274c, false).F();
        c5274c.q();
        return new C5279e0(d1Var.o(), c5274c, 4);
    }

    public static final AbstractC5276d z1(d1 d1Var, String[] strArr) throws ParseException {
        return new i1(3, 3, new a1(d1Var, strArr[1], false).f39212d);
    }

    public static final AbstractC5276d z2(d1 d1Var, String[] strArr) throws ParseException {
        return new N0(new a1(d1Var, strArr[1]).f39212d);
    }
}
