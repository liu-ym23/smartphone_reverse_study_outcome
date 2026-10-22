package J8;

import Yb.r;
import Yb.u;
import Yb.z;
import bc.InterfaceC1477a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class j implements Zb.a, k {

    /* renamed from: k, reason: collision with root package name */
    public static final Pattern f3758k = Pattern.compile("^[!\"#\\$%&'\\(\\)\\*\\+,\\-\\./:;<=>\\?@\\[\\\\\\]\\^_`\\{\\|\\}~\\p{Pc}\\p{Pd}\\p{Pe}\\p{Pf}\\p{Pi}\\p{Po}\\p{Ps}]");

    /* renamed from: l, reason: collision with root package name */
    public static final Pattern f3759l = Pattern.compile("^ *(?:\n *)?");

    /* renamed from: m, reason: collision with root package name */
    public static final Pattern f3760m = Pattern.compile("^[\\p{Zs}\t\r\n\f]");

    /* renamed from: n, reason: collision with root package name */
    public static final Pattern f3761n = Pattern.compile("^[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]");

    /* renamed from: o, reason: collision with root package name */
    public static final Pattern f3762o = Pattern.compile("\\s+");

    /* renamed from: a, reason: collision with root package name */
    public final Zb.b f3763a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f3764b;

    /* renamed from: c, reason: collision with root package name */
    public final BitSet f3765c;

    /* renamed from: d, reason: collision with root package name */
    public final Map<Character, List<i>> f3766d;

    /* renamed from: e, reason: collision with root package name */
    public final Map<Character, InterfaceC1477a> f3767e;

    /* renamed from: f, reason: collision with root package name */
    public u f3768f;

    /* renamed from: g, reason: collision with root package name */
    public String f3769g;

    /* renamed from: h, reason: collision with root package name */
    public int f3770h;

    /* renamed from: i, reason: collision with root package name */
    public Tb.f f3771i;

    /* renamed from: j, reason: collision with root package name */
    public Tb.e f3772j;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f3773a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f3774b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f3775c;

        public a(int i10, boolean z10, boolean z11) {
            this.f3773a = i10;
            this.f3775c = z10;
            this.f3774b = z11;
        }
    }

    public interface b {
        b a(i iVar);

        Zb.c build();
    }

    public static class c implements b {

        /* renamed from: a, reason: collision with root package name */
        public final List<i> f3776a = new ArrayList(3);

        /* renamed from: b, reason: collision with root package name */
        public final List<InterfaceC1477a> f3777b = new ArrayList(3);

        /* renamed from: c, reason: collision with root package name */
        public boolean f3778c;

        @Override // J8.j.b
        public b a(i iVar) {
            this.f3776a.add(iVar);
            return this;
        }

        public b b() {
            this.f3778c = true;
            this.f3776a.addAll(Arrays.asList(new J8.a(), new J8.b(), new J8.c(), new J8.d(), new e(), new f(), new g(), new m(), new n()));
            this.f3777b.addAll(Arrays.asList(new Ub.a(), new Ub.c()));
            return this;
        }

        @Override // J8.j.b
        public Zb.c build() {
            return new d(this.f3778c, this.f3776a, this.f3777b);
        }
    }

    public static class d implements Zb.c {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f3779a;

        /* renamed from: b, reason: collision with root package name */
        public final List<i> f3780b;

        /* renamed from: c, reason: collision with root package name */
        public final List<InterfaceC1477a> f3781c;

        public d(boolean z10, List<i> list, List<InterfaceC1477a> list2) {
            this.f3779a = z10;
            this.f3780b = list;
            this.f3781c = list2;
        }

        @Override // Zb.c
        public Zb.a a(Zb.b bVar) {
            List arrayList;
            List<InterfaceC1477a> listB = bVar.b();
            int size = listB != null ? listB.size() : 0;
            if (size > 0) {
                arrayList = new ArrayList(size + this.f3781c.size());
                arrayList.addAll(this.f3781c);
                arrayList.addAll(listB);
            } else {
                arrayList = this.f3781c;
            }
            return new j(bVar, this.f3779a, this.f3780b, arrayList);
        }
    }

    public j(Zb.b bVar, boolean z10, List<i> list, List<InterfaceC1477a> list2) {
        this.f3763a = bVar;
        this.f3764b = z10;
        Map<Character, List<i>> mapR = r(list);
        this.f3766d = mapR;
        Map<Character, InterfaceC1477a> mapQ = q(list2);
        this.f3767e = mapQ;
        this.f3765c = s(mapR.keySet(), mapQ.keySet());
    }

    private void B(String str) {
        this.f3769g = str;
        this.f3770h = 0;
        this.f3771i = null;
        this.f3772j = null;
    }

    public static void o(char c10, InterfaceC1477a interfaceC1477a, Map<Character, InterfaceC1477a> map) {
        if (map.put(Character.valueOf(c10), interfaceC1477a) == null) {
            return;
        }
        throw new IllegalArgumentException("Delimiter processor conflict with delimiter char '" + c10 + "'");
    }

    public static void p(Iterable<InterfaceC1477a> iterable, Map<Character, InterfaceC1477a> map) {
        o oVar;
        for (InterfaceC1477a interfaceC1477a : iterable) {
            char cD = interfaceC1477a.d();
            char cB = interfaceC1477a.b();
            if (cD == cB) {
                InterfaceC1477a interfaceC1477a2 = map.get(Character.valueOf(cD));
                if (interfaceC1477a2 == null || interfaceC1477a2.d() != interfaceC1477a2.b()) {
                    o(cD, interfaceC1477a, map);
                } else {
                    if (interfaceC1477a2 instanceof o) {
                        oVar = (o) interfaceC1477a2;
                    } else {
                        o oVar2 = new o(cD);
                        oVar2.f(interfaceC1477a2);
                        oVar = oVar2;
                    }
                    oVar.f(interfaceC1477a);
                    map.put(Character.valueOf(cD), oVar);
                }
            } else {
                o(cD, interfaceC1477a, map);
                o(cB, interfaceC1477a, map);
            }
        }
    }

    private static Map<Character, InterfaceC1477a> q(List<InterfaceC1477a> list) {
        HashMap map = new HashMap();
        p(list, map);
        return map;
    }

    public static Map<Character, List<i>> r(List<i> list) {
        HashMap map = new HashMap(list.size());
        for (i iVar : list) {
            char cM = iVar.m();
            List arrayList = (List) map.get(Character.valueOf(cM));
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                map.put(Character.valueOf(cM), arrayList);
            }
            arrayList.add(iVar);
        }
        return map;
    }

    public static BitSet s(Set<Character> set, Set<Character> set2) {
        BitSet bitSet = new BitSet();
        Iterator<Character> it = set.iterator();
        while (it.hasNext()) {
            bitSet.set(it.next().charValue());
        }
        Iterator<Character> it2 = set2.iterator();
        while (it2.hasNext()) {
            bitSet.set(it2.next().charValue());
        }
        return bitSet;
    }

    public static b t() {
        return new c().b();
    }

    public final void A(Tb.f fVar, Tb.f fVar2) {
        Tb.f fVar3 = fVar2.f5942e;
        while (fVar3 != null && fVar3 != fVar) {
            Tb.f fVar4 = fVar3.f5942e;
            z(fVar3);
            fVar3 = fVar4;
        }
    }

    public final a C(InterfaceC1477a interfaceC1477a, char c10) {
        boolean z10;
        int i10 = this.f3770h;
        boolean z11 = false;
        int i11 = 0;
        while (peek() == c10) {
            i11++;
            this.f3770h++;
        }
        if (i11 < interfaceC1477a.c()) {
            this.f3770h = i10;
            return null;
        }
        String strSubstring = i10 == 0 ? "\n" : this.f3769g.substring(i10 - 1, i10);
        char cPeek = peek();
        String strValueOf = cPeek != 0 ? String.valueOf(cPeek) : "\n";
        Pattern pattern = f3758k;
        boolean zMatches = pattern.matcher(strSubstring).matches();
        Pattern pattern2 = f3760m;
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
        this.f3770h = i10;
        return new a(i11, z10, z11);
    }

    @Override // J8.k
    public r a(String str) {
        if (this.f3764b) {
            return this.f3763a.a(str);
        }
        return null;
    }

    @Override // J8.k
    public String b() {
        int iD = Xb.c.d(this.f3769g, this.f3770h);
        if (iD == -1) {
            return null;
        }
        String strSubstring = this.f3769g.substring(this.f3770h + 1, iD - 1);
        this.f3770h = iD;
        return Xb.a.e(strSubstring);
    }

    @Override // J8.k
    public u block() {
        return this.f3768f;
    }

    @Override // J8.k
    public String c(Pattern pattern) {
        if (this.f3770h >= this.f3769g.length()) {
            return null;
        }
        Matcher matcher = pattern.matcher(this.f3769g);
        matcher.region(this.f3770h, this.f3769g.length());
        if (!matcher.find()) {
            return null;
        }
        this.f3770h = matcher.end();
        return matcher.group();
    }

    @Override // J8.k
    public void d() {
        c(f3759l);
    }

    @Override // J8.k
    public String e() {
        int iA = Xb.c.a(this.f3769g, this.f3770h);
        if (iA == -1) {
            return null;
        }
        String strSubstring = peek() == '<' ? this.f3769g.substring(this.f3770h + 1, iA - 1) : this.f3769g.substring(this.f3770h, iA);
        this.f3770h = iA;
        return Xb.a.e(strSubstring);
    }

    @Override // J8.k
    public void f(Tb.e eVar) {
        Tb.e eVar2 = this.f3772j;
        if (eVar2 != null) {
            eVar2.f5937g = true;
        }
        this.f3772j = eVar;
    }

    @Override // J8.k
    public String g() {
        return this.f3769g;
    }

    @Override // J8.k
    public int h() {
        if (this.f3770h < this.f3769g.length() && this.f3769g.charAt(this.f3770h) == '[') {
            int i10 = this.f3770h + 1;
            int iC = Xb.c.c(this.f3769g, i10);
            int i11 = iC - i10;
            if (iC != -1 && i11 <= 999 && iC < this.f3769g.length() && this.f3769g.charAt(iC) == ']') {
                this.f3770h = iC + 1;
                return i11 + 2;
            }
        }
        return 0;
    }

    @Override // J8.k
    public Tb.f i() {
        return this.f3771i;
    }

    @Override // J8.k
    public int index() {
        return this.f3770h;
    }

    @Override // J8.k
    public void j(Tb.f fVar) {
        boolean z10;
        HashMap map = new HashMap();
        Tb.f fVar2 = this.f3771i;
        while (fVar2 != null) {
            Tb.f fVar3 = fVar2.f5942e;
            if (fVar3 == fVar) {
                break;
            } else {
                fVar2 = fVar3;
            }
        }
        while (fVar2 != null) {
            char c10 = fVar2.f5939b;
            InterfaceC1477a interfaceC1477a = this.f3767e.get(Character.valueOf(c10));
            if (!fVar2.f5941d || interfaceC1477a == null) {
                fVar2 = fVar2.f5943f;
            } else {
                char cD = interfaceC1477a.d();
                Tb.f fVar4 = fVar2.f5942e;
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
                    A(fVar4, fVar2);
                    h.c(zVar, zVar2);
                    interfaceC1477a.e(zVar, zVar2, iA);
                    if (fVar4.f5944g == 0) {
                        y(fVar4);
                    }
                    if (fVar2.f5944g == 0) {
                        Tb.f fVar5 = fVar2.f5943f;
                        y(fVar2);
                        fVar2 = fVar5;
                    }
                } else {
                    if (!z10) {
                        map.put(Character.valueOf(c10), fVar2.f5942e);
                        if (!fVar2.f5940c) {
                            z(fVar2);
                        }
                    }
                    fVar2 = fVar2.f5943f;
                }
            }
        }
        while (true) {
            Tb.f fVar6 = this.f3771i;
            if (fVar6 == null || fVar6 == fVar) {
                return;
            } else {
                z(fVar6);
            }
        }
    }

    @Override // J8.k
    public void k() {
        this.f3772j = this.f3772j.f5934d;
    }

    @Override // J8.k
    public z l(String str, int i10, int i11) {
        return new z(str.substring(i10, i11));
    }

    @Override // J8.k
    public Tb.e m() {
        return this.f3772j;
    }

    @Override // Zb.a
    public void n(String str, u uVar) {
        B(str.trim());
        this.f3768f = uVar;
        while (true) {
            u uVarV = v();
            if (uVarV == null) {
                j(null);
                h.a(uVar);
                return;
            }
            uVar.b(uVarV);
        }
    }

    @Override // J8.k
    public char peek() {
        if (this.f3770h < this.f3769g.length()) {
            return this.f3769g.charAt(this.f3770h);
        }
        return (char) 0;
    }

    @Override // J8.k
    public void setIndex(int i10) {
        this.f3770h = i10;
    }

    @Override // J8.k
    public z text(String str) {
        return new z(str);
    }

    public final u u(InterfaceC1477a interfaceC1477a, char c10) {
        a aVarC = C(interfaceC1477a, c10);
        if (aVarC == null) {
            return null;
        }
        int i10 = aVarC.f3773a;
        int i11 = this.f3770h;
        int i12 = i11 + i10;
        this.f3770h = i12;
        z zVarL = l(this.f3769g, i11, i12);
        Tb.f fVar = new Tb.f(zVarL, c10, aVarC.f3775c, aVarC.f3774b, this.f3771i);
        this.f3771i = fVar;
        fVar.f5944g = i10;
        fVar.f5945h = i10;
        Tb.f fVar2 = fVar.f5942e;
        if (fVar2 != null) {
            fVar2.f5943f = fVar;
        }
        return zVarL;
    }

    public final u v() {
        char cPeek = peek();
        u uVarU = null;
        if (cPeek == 0) {
            return null;
        }
        List<i> list = this.f3766d.get(Character.valueOf(cPeek));
        if (list != null) {
            int i10 = this.f3770h;
            Iterator<i> it = list.iterator();
            while (it.hasNext() && (uVarU = it.next().f(this)) == null) {
                this.f3770h = i10;
            }
        } else {
            InterfaceC1477a interfaceC1477a = this.f3767e.get(Character.valueOf(cPeek));
            uVarU = interfaceC1477a != null ? u(interfaceC1477a, cPeek) : w();
        }
        if (uVarU != null) {
            return uVarU;
        }
        this.f3770h++;
        return text(String.valueOf(cPeek));
    }

    public final u w() {
        int i10 = this.f3770h;
        int length = this.f3769g.length();
        while (true) {
            int i11 = this.f3770h;
            if (i11 == length || this.f3765c.get(this.f3769g.charAt(i11))) {
                break;
            }
            this.f3770h++;
        }
        int i12 = this.f3770h;
        if (i10 != i12) {
            return l(this.f3769g, i10, i12);
        }
        return null;
    }

    public final void x(Tb.f fVar) {
        Tb.f fVar2 = fVar.f5942e;
        if (fVar2 != null) {
            fVar2.f5943f = fVar.f5943f;
        }
        Tb.f fVar3 = fVar.f5943f;
        if (fVar3 == null) {
            this.f3771i = fVar2;
        } else {
            fVar3.f5942e = fVar2;
        }
    }

    public final void y(Tb.f fVar) {
        fVar.f5938a.l();
        x(fVar);
    }

    public final void z(Tb.f fVar) {
        x(fVar);
    }
}
