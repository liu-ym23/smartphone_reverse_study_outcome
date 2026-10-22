package Tb;

import Yb.u;
import Yb.x;
import Yb.z;
import bc.InterfaceC1477a;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class n implements Zb.a {

    /* renamed from: i, reason: collision with root package name */
    public static final Pattern f5979i = Pattern.compile("^[!\"#\\$%&'\\(\\)\\*\\+,\\-\\./:;<=>\\?@\\[\\\\\\]\\^_`\\{\\|\\}~\\p{Pc}\\p{Pd}\\p{Pe}\\p{Pf}\\p{Pi}\\p{Po}\\p{Ps}]");

    /* renamed from: j, reason: collision with root package name */
    public static final Pattern f5980j = Pattern.compile("^(?:<[A-Za-z][A-Za-z0-9-]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-]*\\s*[>]|<!---->|<!--(?:-?[^>-])(?:-?[^-])*-->|[<][?].*?[?][>]|<![A-Z]+\\s+[^>]*>|<!\\[CDATA\\[[\\s\\S]*?\\]\\]>)", 2);

    /* renamed from: k, reason: collision with root package name */
    public static final Pattern f5981k = Pattern.compile("^[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]");

    /* renamed from: l, reason: collision with root package name */
    public static final Pattern f5982l = Pattern.compile("^&(?:#x[a-f0-9]{1,6}|#[0-9]{1,7}|[a-z][a-z0-9]{1,31});", 2);

    /* renamed from: m, reason: collision with root package name */
    public static final Pattern f5983m = Pattern.compile("`+");

    /* renamed from: n, reason: collision with root package name */
    public static final Pattern f5984n = Pattern.compile("^`+");

    /* renamed from: o, reason: collision with root package name */
    public static final Pattern f5985o = Pattern.compile("^<([a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*)>");

    /* renamed from: p, reason: collision with root package name */
    public static final Pattern f5986p = Pattern.compile("^<[a-zA-Z][a-zA-Z0-9.+-]{1,31}:[^<>\u0000- ]*>");

    /* renamed from: q, reason: collision with root package name */
    public static final Pattern f5987q = Pattern.compile("^ *(?:\n *)?");

    /* renamed from: r, reason: collision with root package name */
    public static final Pattern f5988r = Pattern.compile("^[\\p{Zs}\t\r\n\f]");

    /* renamed from: s, reason: collision with root package name */
    public static final Pattern f5989s = Pattern.compile("\\s+");

    /* renamed from: t, reason: collision with root package name */
    public static final Pattern f5990t = Pattern.compile(" *$");

    /* renamed from: a, reason: collision with root package name */
    public final BitSet f5991a;

    /* renamed from: b, reason: collision with root package name */
    public final BitSet f5992b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<Character, InterfaceC1477a> f5993c;

    /* renamed from: d, reason: collision with root package name */
    public final Zb.b f5994d;

    /* renamed from: e, reason: collision with root package name */
    public String f5995e;

    /* renamed from: f, reason: collision with root package name */
    public int f5996f;

    /* renamed from: g, reason: collision with root package name */
    public f f5997g;

    /* renamed from: h, reason: collision with root package name */
    public e f5998h;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f5999a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f6000b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f6001c;

        public a(int i10, boolean z10, boolean z11) {
            this.f5999a = i10;
            this.f6001c = z10;
            this.f6000b = z11;
        }
    }

    public n(Zb.b bVar) {
        Map<Character, InterfaceC1477a> mapE = e(bVar.b());
        this.f5993c = mapE;
        BitSet bitSetD = d(mapE.keySet());
        this.f5992b = bitSetD;
        this.f5991a = f(bitSetD);
        this.f5994d = bVar;
    }

    private u A() {
        int i10 = this.f5996f;
        int length = this.f5995e.length();
        while (true) {
            int i11 = this.f5996f;
            if (i11 == length || this.f5991a.get(this.f5995e.charAt(i11))) {
                break;
            }
            this.f5996f++;
        }
        int i12 = this.f5996f;
        if (i10 != i12) {
            return M(this.f5995e, i10, i12);
        }
        return null;
    }

    private char B() {
        if (this.f5996f < this.f5995e.length()) {
            return this.f5995e.charAt(this.f5996f);
        }
        return (char) 0;
    }

    private void C(f fVar) {
        boolean z10;
        HashMap map = new HashMap();
        f fVar2 = this.f5997g;
        while (fVar2 != null) {
            f fVar3 = fVar2.f5942e;
            if (fVar3 == fVar) {
                break;
            } else {
                fVar2 = fVar3;
            }
        }
        while (fVar2 != null) {
            char c10 = fVar2.f5939b;
            InterfaceC1477a interfaceC1477a = this.f5993c.get(Character.valueOf(c10));
            if (!fVar2.f5941d || interfaceC1477a == null) {
                fVar2 = fVar2.f5943f;
            } else {
                char cD = interfaceC1477a.d();
                f fVar4 = fVar2.f5942e;
                int iA = 0;
                boolean z11 = false;
                while (fVar4 != null && fVar4 != fVar && fVar4 != map.get(Character.valueOf(c10))) {
                    if (fVar4.f5940c && fVar4.f5939b == cD) {
                        iA = interfaceC1477a.a(fVar4, fVar2);
                        z11 = true;
                        if (iA > 0) {
                            z10 = true;
                            break;
                        }
                    }
                    fVar4 = fVar4.f5942e;
                }
                z10 = z11;
                z11 = false;
                if (z11) {
                    z zVar = fVar4.f5938a;
                    z zVar2 = fVar2.f5938a;
                    fVar4.f5944g -= iA;
                    fVar2.f5944g -= iA;
                    zVar.n(zVar.m().substring(0, zVar.m().length() - iA));
                    zVar2.n(zVar2.m().substring(0, zVar2.m().length() - iA));
                    G(fVar4, fVar2);
                    j(zVar, zVar2);
                    interfaceC1477a.e(zVar, zVar2, iA);
                    if (fVar4.f5944g == 0) {
                        E(fVar4);
                    }
                    if (fVar2.f5944g == 0) {
                        f fVar5 = fVar2.f5943f;
                        E(fVar2);
                        fVar2 = fVar5;
                    }
                } else {
                    if (!z10) {
                        map.put(Character.valueOf(c10), fVar2.f5942e);
                        if (!fVar2.f5940c) {
                            F(fVar2);
                        }
                    }
                    fVar2 = fVar2.f5943f;
                }
            }
        }
        while (true) {
            f fVar6 = this.f5997g;
            if (fVar6 == null || fVar6 == fVar) {
                return;
            } else {
                F(fVar6);
            }
        }
    }

    private void D(f fVar) {
        f fVar2 = fVar.f5942e;
        if (fVar2 != null) {
            fVar2.f5943f = fVar.f5943f;
        }
        f fVar3 = fVar.f5943f;
        if (fVar3 == null) {
            this.f5997g = fVar2;
        } else {
            fVar3.f5942e = fVar2;
        }
    }

    private void E(f fVar) {
        fVar.f5938a.l();
        D(fVar);
    }

    private void F(f fVar) {
        D(fVar);
    }

    private void G(f fVar, f fVar2) {
        f fVar3 = fVar2.f5942e;
        while (fVar3 != null && fVar3 != fVar) {
            f fVar4 = fVar3.f5942e;
            F(fVar3);
            fVar3 = fVar4;
        }
    }

    private void H() {
        this.f5998h = this.f5998h.f5934d;
    }

    private void K() {
        g(f5987q);
    }

    private z L(String str) {
        return new z(str);
    }

    private z M(String str, int i10, int i11) {
        return new z(str.substring(i10, i11));
    }

    private void a(e eVar) {
        e eVar2 = this.f5998h;
        if (eVar2 != null) {
            eVar2.f5937g = true;
        }
        this.f5998h = eVar;
    }

    private static void b(char c10, InterfaceC1477a interfaceC1477a, Map<Character, InterfaceC1477a> map) {
        if (map.put(Character.valueOf(c10), interfaceC1477a) == null) {
            return;
        }
        throw new IllegalArgumentException("Delimiter processor conflict with delimiter char '" + c10 + "'");
    }

    private static void c(Iterable<InterfaceC1477a> iterable, Map<Character, InterfaceC1477a> map) {
        r rVar;
        for (InterfaceC1477a interfaceC1477a : iterable) {
            char cD = interfaceC1477a.d();
            char cB = interfaceC1477a.b();
            if (cD == cB) {
                InterfaceC1477a interfaceC1477a2 = map.get(Character.valueOf(cD));
                if (interfaceC1477a2 == null || interfaceC1477a2.d() != interfaceC1477a2.b()) {
                    b(cD, interfaceC1477a, map);
                } else {
                    if (interfaceC1477a2 instanceof r) {
                        rVar = (r) interfaceC1477a2;
                    } else {
                        r rVar2 = new r(cD);
                        rVar2.f(interfaceC1477a2);
                        rVar = rVar2;
                    }
                    rVar.f(interfaceC1477a);
                    map.put(Character.valueOf(cD), rVar);
                }
            } else {
                b(cD, interfaceC1477a, map);
                b(cB, interfaceC1477a, map);
            }
        }
    }

    public static BitSet d(Set<Character> set) {
        BitSet bitSet = new BitSet();
        Iterator<Character> it = set.iterator();
        while (it.hasNext()) {
            bitSet.set(it.next().charValue());
        }
        return bitSet;
    }

    public static Map<Character, InterfaceC1477a> e(List<InterfaceC1477a> list) {
        HashMap map = new HashMap();
        c(Arrays.asList(new Ub.a(), new Ub.c()), map);
        c(list, map);
        return map;
    }

    public static BitSet f(BitSet bitSet) {
        BitSet bitSet2 = new BitSet();
        bitSet2.or(bitSet);
        bitSet2.set(10);
        bitSet2.set(96);
        bitSet2.set(91);
        bitSet2.set(93);
        bitSet2.set(92);
        bitSet2.set(33);
        bitSet2.set(60);
        bitSet2.set(38);
        return bitSet2;
    }

    private String g(Pattern pattern) {
        if (this.f5996f >= this.f5995e.length()) {
            return null;
        }
        Matcher matcher = pattern.matcher(this.f5995e);
        matcher.region(this.f5996f, this.f5995e.length());
        if (!matcher.find()) {
            return null;
        }
        this.f5996f = matcher.end();
        return matcher.group();
    }

    private u r(InterfaceC1477a interfaceC1477a, char c10) {
        a aVarJ = J(interfaceC1477a, c10);
        if (aVarJ == null) {
            return null;
        }
        int i10 = aVarJ.f5999a;
        int i11 = this.f5996f;
        int i12 = i11 + i10;
        this.f5996f = i12;
        z zVarM = M(this.f5995e, i11, i12);
        f fVar = new f(zVarM, c10, aVarJ.f6001c, aVarJ.f6000b, this.f5997g);
        this.f5997g = fVar;
        fVar.f5944g = i10;
        fVar.f5945h = i10;
        f fVar2 = fVar.f5942e;
        if (fVar2 != null) {
            fVar2.f5943f = fVar;
        }
        return zVarM;
    }

    private String v() {
        int iA = Xb.c.a(this.f5995e, this.f5996f);
        if (iA == -1) {
            return null;
        }
        String strSubstring = B() == '<' ? this.f5995e.substring(this.f5996f + 1, iA - 1) : this.f5995e.substring(this.f5996f, iA);
        this.f5996f = iA;
        return Xb.a.e(strSubstring);
    }

    private String x() {
        int iD = Xb.c.d(this.f5995e, this.f5996f);
        if (iD == -1) {
            return null;
        }
        String strSubstring = this.f5995e.substring(this.f5996f + 1, iD - 1);
        this.f5996f = iD;
        return Xb.a.e(strSubstring);
    }

    public void I(String str) {
        this.f5995e = str;
        this.f5996f = 0;
        this.f5997g = null;
        this.f5998h = null;
    }

    public final a J(InterfaceC1477a interfaceC1477a, char c10) {
        boolean z10;
        int i10 = this.f5996f;
        boolean z11 = false;
        int i11 = 0;
        while (B() == c10) {
            i11++;
            this.f5996f++;
        }
        if (i11 < interfaceC1477a.c()) {
            this.f5996f = i10;
            return null;
        }
        String strSubstring = i10 == 0 ? "\n" : this.f5995e.substring(i10 - 1, i10);
        char cB = B();
        String strValueOf = cB != 0 ? String.valueOf(cB) : "\n";
        Pattern pattern = f5979i;
        boolean zMatches = pattern.matcher(strSubstring).matches();
        Pattern pattern2 = f5988r;
        boolean zMatches2 = pattern2.matcher(strSubstring).matches();
        boolean zMatches3 = pattern.matcher(strValueOf).matches();
        boolean zMatches4 = pattern2.matcher(strValueOf).matches();
        boolean z12 = !zMatches4 && (!zMatches3 || zMatches2 || zMatches);
        boolean z13 = !zMatches2 && (!zMatches || zMatches4 || zMatches3);
        if (c10 == '_') {
            z10 = z12 && (!z13 || zMatches);
            if (z13 && (!z12 || zMatches3)) {
                z11 = true;
            }
        } else {
            boolean z14 = z12 && c10 == interfaceC1477a.d();
            if (z13 && c10 == interfaceC1477a.b()) {
                z11 = true;
            }
            z10 = z14;
        }
        this.f5996f = i10;
        return new a(i11, z10, z11);
    }

    public final void h(u uVar) {
        if (uVar.c() == uVar.d()) {
            return;
        }
        k(uVar.c(), uVar.d());
    }

    public final void i(z zVar, z zVar2, int i10) {
        if (zVar == null || zVar2 == null || zVar == zVar2) {
            return;
        }
        StringBuilder sb2 = new StringBuilder(i10);
        sb2.append(zVar.m());
        u uVarE = zVar.e();
        u uVarE2 = zVar2.e();
        while (uVarE != uVarE2) {
            sb2.append(((z) uVarE).m());
            u uVarE3 = uVarE.e();
            uVarE.l();
            uVarE = uVarE3;
        }
        zVar.n(sb2.toString());
    }

    public final void j(u uVar, u uVar2) {
        if (uVar == uVar2 || uVar.e() == uVar2) {
            return;
        }
        k(uVar.e(), uVar2.g());
    }

    public final void k(u uVar, u uVar2) {
        z zVar = null;
        z zVar2 = null;
        int length = 0;
        while (uVar != null) {
            if (uVar instanceof z) {
                zVar2 = (z) uVar;
                if (zVar == null) {
                    zVar = zVar2;
                }
                length += zVar2.m().length();
            } else {
                i(zVar, zVar2, length);
                zVar = null;
                zVar2 = null;
                length = 0;
            }
            if (uVar == uVar2) {
                break;
            } else {
                uVar = uVar.e();
            }
        }
        i(zVar, zVar2, length);
    }

    public final u l() {
        String strG = g(f5985o);
        if (strG != null) {
            String strSubstring = strG.substring(1, strG.length() - 1);
            Yb.q qVar = new Yb.q("mailto:" + strSubstring, null);
            qVar.b(new z(strSubstring));
            return qVar;
        }
        String strG2 = g(f5986p);
        if (strG2 == null) {
            return null;
        }
        String strSubstring2 = strG2.substring(1, strG2.length() - 1);
        Yb.q qVar2 = new Yb.q(strSubstring2, null);
        qVar2.b(new z(strSubstring2));
        return qVar2;
    }

    public final u m() {
        this.f5996f++;
        if (B() == '\n') {
            Yb.k kVar = new Yb.k();
            this.f5996f++;
            return kVar;
        }
        if (this.f5996f < this.f5995e.length()) {
            Pattern pattern = f5981k;
            String str = this.f5995e;
            int i10 = this.f5996f;
            if (pattern.matcher(str.substring(i10, i10 + 1)).matches()) {
                String str2 = this.f5995e;
                int i11 = this.f5996f;
                z zVarM = M(str2, i11, i11 + 1);
                this.f5996f++;
                return zVarM;
            }
        }
        return L("\\");
    }

    @Override // Zb.a
    public void n(String str, u uVar) {
        I(str.trim());
        u uVarU = null;
        while (true) {
            uVarU = u(uVarU);
            if (uVarU == null) {
                C(null);
                h(uVar);
                return;
            }
            uVar.b(uVarU);
        }
    }

    public final u o() {
        String strG;
        String strG2 = g(f5984n);
        if (strG2 == null) {
            return null;
        }
        int i10 = this.f5996f;
        do {
            strG = g(f5983m);
            if (strG == null) {
                this.f5996f = i10;
                return L(strG2);
            }
        } while (!strG.equals(strG2));
        Yb.e eVar = new Yb.e();
        String strReplace = this.f5995e.substring(i10, this.f5996f - strG2.length()).replace('\n', ' ');
        if (strReplace.length() >= 3 && strReplace.charAt(0) == ' ' && strReplace.charAt(strReplace.length() - 1) == ' ' && Xb.d.e(strReplace)) {
            strReplace = strReplace.substring(1, strReplace.length() - 1);
        }
        eVar.n(strReplace);
        return eVar;
    }

    public final u p() {
        int i10 = this.f5996f;
        this.f5996f = i10 + 1;
        if (B() != '[') {
            return L("!");
        }
        this.f5996f++;
        z zVarL = L("![");
        a(e.a(zVarL, i10 + 1, this.f5998h, this.f5997g));
        return zVarL;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final Yb.u q() {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Tb.n.q():Yb.u");
    }

    public final u s() {
        String strG = g(f5982l);
        if (strG != null) {
            return L(Xb.b.a(strG));
        }
        return null;
    }

    public final u t() {
        String strG = g(f5980j);
        if (strG == null) {
            return null;
        }
        Yb.n nVar = new Yb.n();
        nVar.n(strG);
        return nVar;
    }

    public final u u(u uVar) {
        u uVarY;
        char cB = B();
        if (cB == 0) {
            return null;
        }
        if (cB == '\n') {
            uVarY = y(uVar);
        } else if (cB == '!') {
            uVarY = p();
        } else if (cB == '&') {
            uVarY = s();
        } else if (cB == '<') {
            uVarY = l();
            if (uVarY == null) {
                uVarY = t();
            }
        } else if (cB != '`') {
            switch (cB) {
                case '[':
                    uVarY = z();
                    break;
                case '\\':
                    uVarY = m();
                    break;
                case ']':
                    uVarY = q();
                    break;
                default:
                    if (!this.f5992b.get(cB)) {
                        uVarY = A();
                        break;
                    } else {
                        uVarY = r(this.f5993c.get(Character.valueOf(cB)), cB);
                        break;
                    }
            }
        } else {
            uVarY = o();
        }
        if (uVarY != null) {
            return uVarY;
        }
        this.f5996f++;
        return L(String.valueOf(cB));
    }

    public int w() {
        if (this.f5996f < this.f5995e.length() && this.f5995e.charAt(this.f5996f) == '[') {
            int i10 = this.f5996f + 1;
            int iC = Xb.c.c(this.f5995e, i10);
            int i11 = iC - i10;
            if (iC != -1 && i11 <= 999 && iC < this.f5995e.length() && this.f5995e.charAt(iC) == ']') {
                this.f5996f = iC + 1;
                return i11 + 2;
            }
        }
        return 0;
    }

    public final u y(u uVar) {
        this.f5996f++;
        if (uVar instanceof z) {
            z zVar = (z) uVar;
            if (zVar.m().endsWith(" ")) {
                String strM = zVar.m();
                Matcher matcher = f5990t.matcher(strM);
                int iEnd = matcher.find() ? matcher.end() - matcher.start() : 0;
                if (iEnd > 0) {
                    zVar.n(strM.substring(0, strM.length() - iEnd));
                }
                return iEnd >= 2 ? new Yb.k() : new x();
            }
        }
        return new x();
    }

    public final u z() {
        int i10 = this.f5996f;
        this.f5996f = i10 + 1;
        z zVarL = L("[");
        a(e.b(zVarL, i10, this.f5998h, this.f5997g));
        return zVarL;
    }
}
